package org.example;

import liquibase.parser.core.ParsedNode;
import liquibase.parser.core.ParsedNodeException;
import liquibase.resource.ResourceAccessor;
import liquibase.structure.DatabaseObject;
import liquibase.structure.core.Schema;

import java.util.Set;

public class DabObj implements DatabaseObject {
    @Override
    public String getSnapshotId() {
        return null;
    }

    @Override
    public void setSnapshotId(String id) {

    }

    @Override
    public DatabaseObject[] getContainingObjects() {
        return new DatabaseObject[0];
    }

    @Override
    public String getObjectTypeName() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public DatabaseObject setName(String name) {
        return null;
    }

    @Override
    public Schema getSchema() {
        return null;
    }

    @Override
    public boolean snapshotByDefault() {
        return false;
    }

    @Override
    public Set<String> getAttributes() {
        return null;
    }

    @Override
    public <T> T getAttribute(String attribute, Class<T> type) {
        return null;
    }

    @Override
    public <T> T getAttribute(String attribute, T defaultValue) {
        return null;
    }

    @Override
    public DatabaseObject setAttribute(String attribute, Object value) {
        return null;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String getSerializedObjectName() {
        return null;
    }

    @Override
    public Set<String> getSerializableFields() {
        return null;
    }

    @Override
    public Object getSerializableFieldValue(String field) {
        return null;
    }

    @Override
    public SerializationType getSerializableFieldType(String field) {
        return null;
    }

    @Override
    public String getSerializableFieldNamespace(String field) {
        return null;
    }

    @Override
    public String getSerializedObjectNamespace() {
        return null;
    }

    @Override
    public void load(ParsedNode parsedNode, ResourceAccessor resourceAccessor) throws ParsedNodeException {

    }

    @Override
    public ParsedNode serialize() throws ParsedNodeException {
        return null;
    }
}
