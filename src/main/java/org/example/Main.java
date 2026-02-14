package org.example;

import liquibase.database.jvm.JdbcConnection;

import liquibase.exception.LiquibaseException;

import liquibase.resource.DirectoryResourceAccessor;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

import org.apache.ibatis.mapping.Environment;

import org.apache.ibatis.session.Configuration;

import org.apache.ibatis.transaction.TransactionFactory;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.File;

import java.io.FileNotFoundException;

import java.io.PrintStream;

import java.io.PrintWriter;

import java.sql.SQLException;

import java.util.Properties;

import java.util.UUID;

public class Main {
    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/test?user=root&password=?";

        PooledDataSource pooledDataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver",url,new Properties());

        try {
            pooledDataSource.getConnection().beginRequest();

            ADLiq adLiq = new ADLiq("test.xml",new DirectoryResourceAccessor

            (new File("C:\\Users\\andyd\\OneDrive\\Documents")), new JdbcConnection(pooledDataSource.getConnection()));

            adLiq.update();

            adLiq.reportLocks(new PrintStream("C:\\Users\\andyd\\OneDrive\\Documents\\Ac.txt"));

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

            pooledDataSource.setLogWriter(new PrintWriter("C:\\Users\\andyd\\OneDrive\\Documents\\asd.txt"));

            pooledDataSource.getLogWriter().println("Andy");

            new ADSQL(new Configuration(new Environment(UUID.randomUUID().toString(),jdbcTransactionFactory , pooledDataSource)));

        }
        catch (SQLException exception){

            System.out.println("Try again: "+exception.getMessage());

        } catch (FileNotFoundException e) {

            System.out.println("Try: "+e.getMessage());

        } catch (LiquibaseException e) {

            System.out.println("Liqui"+e.getMessage());
        }
    }
}