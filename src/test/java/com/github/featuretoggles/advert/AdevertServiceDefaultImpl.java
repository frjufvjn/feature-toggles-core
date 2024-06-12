package com.github.featuretoggles.advert;

import com.github.featuretoggles.FeatureOption;
import org.springframework.stereotype.Service;

@FeatureOption(defaultFeature = true)
@Service
public class AdevertServiceDefaultImpl implements AdeverService {
    @Override
    public String findAdvert() {
        return "default";
    }
}
