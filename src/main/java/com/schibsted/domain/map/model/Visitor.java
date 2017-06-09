package com.schibsted.domain.map.model;

public interface Visitor {
    VisitorReference getReference(Position position);
}
