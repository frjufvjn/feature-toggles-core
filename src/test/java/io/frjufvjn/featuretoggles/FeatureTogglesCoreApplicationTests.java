package io.frjufvjn.featuretoggles;

import io.frjufvjn.featuretoggles.router.FeatureAdapter;
import io.frjufvjn.featuretoggles.router.FeaturesResource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = TestMain.class)
public class FeatureTogglesCoreApplicationTests {
    @Autowired
    private AdvertServiceGate advertServiceGate;
    @MockBean
    private FeatureAdapter featureAdapter;

    @DisplayName("토글을 찾을 수 없는 경우는 default토글을 반환합니다.")
    @Test
    void defaultToggleTest() {
        String result = advertServiceGate.findAdvert();
        assertThat(result).isEqualTo("default");
    }

    @DisplayName("feature 데이터에 토글이 'release'로 설정이 되어 잇다면")
    @Test
    void releaseToggleTest() {
        given(featureAdapter.findActiveToggle(any()))
                .willReturn(FeaturesResource.builder()
                        .id(1L)
                        .name("advert")
                        .toggle("release")
                        .build()
                );
        String result = advertServiceGate.findAdvert();
        assertThat(result).isEqualTo("release");
    }
}
