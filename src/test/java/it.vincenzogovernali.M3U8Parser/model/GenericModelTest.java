package it.vincenzogovernali.M3U8Parser.model;

import org.junit.jupiter.api.Test;

import static it.vincenzogovernali.M3U8Parser.constant.Constant.TEST_STRING;
import static org.assertj.core.api.Assertions.assertThat;


class GenericModelTest {

    @Test
    void testGetterAndSetter() {
        GenericModel model = createGenericModel();
        assertThat(model).hasNoNullFieldsOrProperties();
        assertThat(model.hashCode()).isNotZero();
        assertThat(model.toString()).isNotNull();
    }

    private GenericModel createGenericModel() {
        GenericModel model = new GenericModel(TEST_STRING, null, TEST_STRING, TEST_STRING);
        model = new GenericModel(TEST_STRING, TEST_STRING, null, TEST_STRING);
        return model;
    }

}
