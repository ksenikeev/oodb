package ru.icmit.oodb.lab6.graph;

import java.util.List;

public class EntityNode {
    private String entityName;
    private List<EntityAttribute> atributes;

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<EntityAttribute> getAtributes() {
        return atributes;
    }

    public void setAtributes(List<EntityAttribute> atributes) {
        this.atributes = atributes;
    }
}
