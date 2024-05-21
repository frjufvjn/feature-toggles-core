package io.frjufvjn.featuretoggles;

import org.springframework.stereotype.Service;

@FeatureOption(defaultFeature = true)
@Service
public class AdevertServiceDefaultImpl implements AdeverService {
    @Override
    public String findAdvert() {
        return "default";
    }
}
