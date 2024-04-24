package io.frjufvjn.featuretoggles;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class FeatureException extends RuntimeException {
    private static final long serialVersionUID = -6954318562205652891L;
    private final String message;

    public FeatureException(String message) {
        this.message = message;
        log.error(message);
    }
}
