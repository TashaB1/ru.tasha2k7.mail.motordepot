package ru.tasha2k7.mail.motordepot.daodb.util;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.jdbc.support.MetaDataAccessException;

public class GetAllTableNames implements DatabaseMetaDataCallback {

	@Override
	public Object processMetaData(DatabaseMetaData dbmd) throws SQLException, MetaDataAccessException {
		ResultSet rs = dbmd.getTables(dbmd.getUserName(), null, null, new String[]{"TABLE"});
        ArrayList<String> setTableName = new ArrayList<String>();
        while (rs.next()) {
        	setTableName.add(rs.getString(3));
        }
        return setTableName;
	}
}
