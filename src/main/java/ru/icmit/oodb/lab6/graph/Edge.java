package ru.icmit.oodb.lab6.graph;

public class Edge {
    private EntityNode nodeSource;
    private EntityNode nodeTarget;
    private RelationType relationType;

    public EntityNode getNodeSource() {
        return nodeSource;
    }

    public void setNodeSource(EntityNode nodeSource) {
        this.nodeSource = nodeSource;
    }

    public EntityNode getNodeTarget() {
        return nodeTarget;
    }

    public void setNodeTarget(EntityNode nodeTarget) {
        this.nodeTarget = nodeTarget;
    }

    public RelationType getRelationType() {
        return relationType;
    }

    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }
}
