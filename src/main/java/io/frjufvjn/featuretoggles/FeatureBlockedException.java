package io.frjufvjn.featuretoggles;

/**
 * 기능을 차단 설정한 토글일 경우 예외
 *
 * @see <a href="https://scglab.atlassian.net/wiki/spaces/SCGLAB/pages/475332623/Feature+Toggles+Flag#%EA%B8%B0%EB%8A%A5">토글 기능 문서</a>
 */
public class FeatureBlockedException extends RuntimeException {
    private static final long serialVersionUID = -6701885083031701720L;
}
