package it.vincenzogovernali.devilparser.model;

import it.vincenzogovernali.devilparser.m3u8.model.GenericModel;
import org.junit.jupiter.api.Test;

import static it.vincenzogovernali.devilparser.constant.Constant.TEST_STRING;
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
