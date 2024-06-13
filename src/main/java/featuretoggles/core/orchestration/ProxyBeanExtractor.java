package featuretoggles.core.orchestration;

import featuretoggles.core.FeatureOption;
import org.springframework.aop.framework.AopProxyUtils;

public class ProxyBeanExtractor {
    public static FeatureOption getFeatureOptionIfProxyBean(Object proxy) {
        return AopProxyUtils.ultimateTargetClass(proxy).getAnnotation(FeatureOption.class);
    }
}
