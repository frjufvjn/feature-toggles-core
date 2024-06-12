package com.github.featuretoggles;

import lombok.Getter;

@Getter
public class FeatureException extends RuntimeException {
    private static final long serialVersionUID = -6954318562205652891L;
    private final String message;

    public FeatureException(String message) {
        this.message = message;
    }
}
