package io.frjufvjn.featuretoggles;

import org.springframework.stereotype.Service;

@FeatureOption(name = "release")
@Service
public class AdvertServiceReleaseImpl implements AdeverService {
    @Override
    public String findAdvert() {
        return "release";
    }
}
