package org.example;

import liquibase.Liquibase;

import liquibase.database.DatabaseConnection;

import liquibase.exception.DatabaseException;

import liquibase.exception.LiquibaseException;

import liquibase.resource.ResourceAccessor;

import liquibase.snapshot.SnapshotControl;

import liquibase.structure.DatabaseObject;

import liquibase.structure.core.*;

import java.util.UUID;


public class ADLiq extends Liquibase {

    public ADLiq(String changeLogFile, ResourceAccessor resourceAccessor, DatabaseConnection conn) throws LiquibaseException {

        super(changeLogFile, resourceAccessor, conn);

        try {

            Data data = new Data();

            data.setName("foo");

            Relation relation = new ADrealtion();

            Column column =  new Column("fight")

            .setDefaultValue("big");//.setRelation(relation);

            relation.setName("NAN").addColumn(column);

            relation.setSnapshotId(UUID.randomUUID().toString());

            Catalog catalog = new Catalog();

            catalog.setSnapshotId(UUID.randomUUID().toString());

            DatabaseObject[] obj = new DatabaseObject[]{catalog,relation};

            new ADsnapshot(obj,getDatabase());


        }
        catch (DatabaseException e){

            System.out.println("Try:"+e.getMessage());
        }

    }

}
