package ru.tasha2k7.mail.motordepot.daodb.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import ru.tasha2k7.mail.motordepot.annotation.analyzer.DBTableNameAnalyzer;
import ru.tasha2k7.mail.motordepot.annotation.analyzer.DaoMetadataAnalyzer;
import ru.tasha2k7.mail.motordepot.daodb.GenericDao;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.DiMapper;
import ru.tasha2k7.mail.motordepot.daodb.dimapper.impl.ApplicationDiMapperImpl;
import ru.tasha2k7.mail.motordepot.daodb.mapper.ApplicationMapper;
import ru.tasha2k7.mail.motordepot.datamodel.Application;

@Repository
public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@Inject
	private JdbcTemplate jdbcTemplate;
	private String dbTableName;// = new
								// DBTableNameAnalyzer().getDBTableName(this.getGenericEntityClass());

	/*
	 * @SuppressWarnings("unchecked") private Class<T> entityClass1 = new
	 * DaoMetadataAnalyzer().getEntityClass();
	 */
	@Inject
	private DiMapper<T> diMapper;

	private Class<T> diMapper1;
	private Class<T> entityClass;
	private Class<T> mapper;

	public GenericDaoImpl(Class<T> entityClass, String dbTabName, Class mapper, Class diMapper1) {
		this.entityClass = entityClass;
		this.dbTableName = dbTabName;
		this.diMapper1 = diMapper1;
		this.mapper = mapper;
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
		StringBuilder sql = new StringBuilder("UPDATE " + dbTableName + " SET ");

		Map<String, Object> map = diMapper.mapColumns(obj);
		Object[] value = new Object[map.size()];

		int index = 0;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (index < map.size() - 1) {
				sql.append(entry.getKey().concat(" = ?"));
				if (index < map.size() - 2) {
					sql.append(",");
				}
				sql.append(" ");
			}
			value[index] = entry.getValue();
			index++;
		}
		sql.append("WHERE id = ?");

		jdbcTemplate.update(sql.toString(), value);
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
