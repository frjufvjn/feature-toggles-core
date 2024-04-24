package io.frjufvjn.featuretoggles;

/**
 * 출시나 유지기간이 아닌 토글의 경우 예외
 *
 * @see <a href="https://scglab.atlassian.net/wiki/spaces/SCGLAB/pages/475332623/Feature+Toggles+Flag#%EA%B8%B0%EB%8A%A5">토글 기능 문서</a>
 */
public class FeatureNotYetOrExpiredException extends RuntimeException {
    private static final long serialVersionUID = 5463461491849847646L;
}
