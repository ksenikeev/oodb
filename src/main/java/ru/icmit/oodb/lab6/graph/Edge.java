package ru.icmit.oodb.lab6.graph;

public class Edge {
    private EntityNode node1;
    private EntityNode node2;
    private String relationType;

    public EntityNode getNode1() {
        return node1;
    }

    public void setNode1(EntityNode node1) {
        this.node1 = node1;
    }

    public EntityNode getNode2() {
        return node2;
    }

    public void setNode2(EntityNode node2) {
        this.node2 = node2;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }
}
