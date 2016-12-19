package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import ru.tasha2k7.mail.motordepot.annotation.analyzer.DaoMetadataAnalyzer;
import ru.tasha2k7.mail.motordepot.daoapi.IGenericDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.DiMapper;

public abstract class GenericDaoImpl<T, PK extends Serializable> implements IGenericDao<T, PK> {

	@Inject
	private JdbcTemplate jdbcTemplate;
	private String dbTableName;// = new
								// DBTableNameAnalyzer().getDBTableName(entityClass);//this.getGenericEntityClass());
T t;
	
	/*
	 * @SuppressWarnings("unchecked") private Class<T> entityClass1 = new
	 * DaoMetadataAnalyzer().getEntityClass();
	 */
	@Inject
	private DiMapper<T> diMapper;

	private Class<T> entityClass;
	private Class<T> mapper;

	public GenericDaoImpl(Class entityClass, String dbTabName, Class mapper) {
		this.entityClass = entityClass;
		this.dbTableName = dbTabName;
		this.mapper = mapper;
	}
	
	public PK getSequence(){
		return (PK) jdbcTemplate.queryForObject("select last_value from motordepot." + dbTableName + "_id_seq " , Long.class);
		//select last_value from motordepot.client_id_seq

	}

	@SuppressWarnings("unchecked")
	protected Class<T> getGenericEntityClass() {
		ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<T>) parameterizedType.getActualTypeArguments()[0];
	}

	@Override
	public T getById(PK id) {
		return (T) jdbcTemplate.queryForObject("select * from " + dbTableName + " where id = ?", new Object[] { id },
				new BeanPropertyRowMapper<>(entityClass));
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK insert(T obj) {
		SimpleJdbcInsert simpleJdbcInsert;
		Map<String, Object> map = diMapper.mapColumns(obj);

		if (map.get("id") != null) {
			simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withSchemaName("motordepot")
					.withTableName(dbTableName);
			simpleJdbcInsert.execute(map);
			return (PK) map.get("id");
		} else {
			simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withSchemaName("motordepot")
					.withTableName(dbTableName).usingGeneratedKeyColumns("id");
			return (PK) simpleJdbcInsert.executeAndReturnKey(map);
		}
	}

	@Override
	public void update(T obj) {
		StringBuilder sqlUpdate = new StringBuilder("update " + dbTableName + " set ");

		Map<String, Object> map = diMapper.mapColumns(obj);

		int i = 0;
		for (Map.Entry<String, Object> pair : map.entrySet()) {

			if (!pair.getKey().equals("id")) {
				if (i < map.size() - 1) {
					sqlUpdate.append(pair.getKey().concat(" = ?, "));
				} else {
					sqlUpdate.append(pair.getKey().concat(" = ? "));
				}
			}
			i++;
		}
		sqlUpdate.append(" where id = ? ");

		int j = 0;
		int v = 0;
		Object id = null;
		Object[] value = new Object[map.size()];
		for (Map.Entry<String, Object> pair : map.entrySet()) {

			if (!pair.getKey().equals("id") && j < map.size()) {
				value[v] = pair.getValue();
				v++;
			}
			if (pair.getKey().equals("id")) {
				id = pair.getValue();
			}
			j++;
		}
		value[map.size() - 1] = id;

		jdbcTemplate.update(sqlUpdate.toString(), value);
	}

	@Override
	public void delete(PK id) {
		jdbcTemplate.update("delete from " + dbTableName + " where id = ?", id);
	}

	@Override
	public void deleteAll(T obj) {
		jdbcTemplate.update("delete from " + dbTableName);
	}

	@Override
	public List<T> getAll() {
		return jdbcTemplate.query("select * from " + dbTableName,
				new BeanPropertyRowMapper<>(this.getGenericEntityClass()));
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK findTotalRecords() {
		return (PK) jdbcTemplate.queryForObject("select count(*) from " + dbTableName, Integer.class);
	}

}
