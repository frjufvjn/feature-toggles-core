package io.frjufvjn.featuretoggles;

/**
 * 출시나 유지기간이 아닌 토글의 경우 예외
 */
public class FeatureNotYetOrExpiredException extends RuntimeException {
    private static final long serialVersionUID = 5463461491849847646L;
}
