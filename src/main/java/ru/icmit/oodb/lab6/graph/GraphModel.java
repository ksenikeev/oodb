package ru.icmit.oodb.lab6.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphModel {

    private List<EntityNode> entityNodeList = new ArrayList<>();

    private List<Edge> edges = new ArrayList<>();

    public List<EntityNode> getEntityNodeList() {
        return entityNodeList;
    }

    public void setEntityNodeList(List<EntityNode> entityNodeList) {
        this.entityNodeList = entityNodeList;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
