package org.example;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import org.apache.ibatis.mapping.Environment;

import org.apache.ibatis.session.Configuration;

import org.apache.ibatis.transaction.TransactionFactory;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.sql.SQLException;

import java.util.Properties;

import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {


        //  dataSource.getConnection().beginRequest();
        String url = "jdbc:mysql://localhost:3306/test?user=root&password=?";

        PooledDataSource pooledDataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver",url,new Properties());

        try {
            pooledDataSource.getConnection().beginRequest();

            pooledDataSource.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `Andy` (\n" +
                    "  `master_db` varchar(64) NOT NULL default '',\n" +
                    "  `master_table` varchar(64) NOT NULL default '',\n" +
                    "  `master_field` varchar(64) NOT NULL default '',\n" +
                    "  `foreign_db` varchar(64) NOT NULL default '',\n" +
                    "  `foreign_table` varchar(64) NOT NULL default '',\n" +
                    "  `foreign_field` varchar(64) NOT NULL default '',\n" +
                    "  PRIMARY KEY  (`master_db`,`master_table`,`master_field`),\n" +
                    "  KEY `foreign_field` (`foreign_db`,`foreign_table`)\n" +
                    ")").execute();

            TransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();

            new ADSQL(new Configuration(new Environment(UUID.randomUUID().toString(),jdbcTransactionFactory , pooledDataSource)));

        }
        catch (SQLException exception){

        System.out.println("Try again: "+exception.getMessage());

        }
    }
}