package org.example;

import jakarta.persistence.Persistence;

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

        String url = "jdbc:mysql://localhost:3306/test?user=root&password=A@15xvrt";

        PooledDataSource pooledDataSource = new PooledDataSource("com.mysql.cj.jdbc.Driver",url,new Properties());

        try {
          //  pooledDataSource.getConnection().beginRequest();

            ADLiq adLiq = new ADLiq("test.xml",new DirectoryResourceAccessor

                    (new File("C:\\Users\\andyd\\OneDrive\\Documents")), new JdbcConnection(pooledDataSource.getConnection()));

            adLiq.update();

            adLiq.reportLocks(new PrintStream("C:\\Users\\andyd\\OneDrive\\Documents\\Ac.txt"));

            TransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();

            PrintWriter printWriter = new PrintWriter("C:\\Users\\andyd\\OneDrive\\Documents\\asd.txt");

            printWriter.write("AS");

            System.out.println(Persistence.getPersistenceUtil().isLoaded(pooledDataSource+"loaded"));

            pooledDataSource.setLogWriter(printWriter);

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