package org.example;

import oracle.jdbc.pool.OracleDataSource;

import oracle.net.url.common.DriverType;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import org.apache.ibatis.jdbc.SQL;

import org.apache.ibatis.mapping.Environment;

import org.apache.ibatis.session.Configuration;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.SQLException;

import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {

        SQL sql = new SQL();

        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();

        // jdbcTransactionFactory.newTransaction(new ADConect());
        OracleDataSource dataSource = new OracleDataSource();


        dataSource.setDriverType(DriverType.DEFAULT.urlPrefix());


        dataSource.setURL("https://localhost/phpmyadmin/index.php?route=/");

       // dataSource.getConnection().beginRequest();

      //  boolean close = dataSource.getConnection().isClosed();

      //  System.out.println(close);
/*
        dataSource.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `pma__relation` (\n" +
                "  `master_db` varchar(64) NOT NULL default '',\n" +
                "  `master_table` varchar(64) NOT NULL default '',\n" +
                "  `master_field` varchar(64) NOT NULL default '',\n" +
                "  `foreign_db` varchar(64) NOT NULL default '',\n" +
                "  `foreign_table` varchar(64) NOT NULL default '',\n" +
                "  `foreign_field` varchar(64) NOT NULL default '',\n" +
                "  PRIMARY KEY  (`master_db`,`master_table`,`master_field`),\n" +
                "  KEY `foreign_field` (`foreign_db`,`foreign_table`)\n" +
                ")").execute();
*/


        dataSource.setDatabaseName("jones");

        PooledDataSource pooledDataSource = new PooledDataSource("com.mysql.jdbc.Driver","jdbc:mysql://localhost/phpmyadmin/index.php?route=/database/structure&db=test",new Properties());

        pooledDataSource.getConnection().beginRequest();

        new ADSQL(new Configuration(new Environment("1016",jdbcTransactionFactory , pooledDataSource)));
        //  sql.INSERT_INTO("Andy");

    }
}