package com.github.featuretoggles.orchestration;

import com.github.featuretoggles.FeatureOption;
import org.springframework.aop.framework.AopProxyUtils;

public class ProxyBeanExtractor {
    public static FeatureOption getFeatureOptionIfProxyBean(Object proxy) {
        return AopProxyUtils.ultimateTargetClass(proxy).getAnnotation(FeatureOption.class);
    }
}
