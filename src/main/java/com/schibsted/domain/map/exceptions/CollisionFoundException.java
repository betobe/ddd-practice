package com.schibsted.domain.map.exceptions;

import com.schibsted.domain.map.model.VisitorReference;

public class CollisionFoundException extends RuntimeException {
    public final VisitorReference reference;

    public CollisionFoundException(VisitorReference reference) {
        this.reference = reference;
    }
}
