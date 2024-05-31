package io.frjufvjn.featuretoggles;

import io.frjufvjn.featuretoggles.router.FeatureAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = TestMain.class)
public class MockingDefaultFeatureTogglesTest {
    @Autowired
    private AdvertServiceGate advertServiceGate;
    @MockBean
    private FeatureAdapter featureAdapter;

    @DisplayName("feature 데이터에 설정된 토글을 찾을 수 없다면")
    @Test
    void defaultToggleTest() {
        given(featureAdapter.findActiveToggle(any())).willReturn(null);
        assertThat(advertServiceGate.findAdvert()).isEqualTo("default");
    }
}
