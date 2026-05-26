package com.nike.backstopper.model.util;

import com.nike.backstopper.model.DefaultErrorDTO;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.cfg.SerializerFactoryConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.SerializerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.UUID;

/**
 * Maps any Object to a JSON representation. The default {@link #writeValueAsString(Object)} method knows about
 * {@link DefaultErrorDTO} objects and will exclude empty {@link DefaultErrorDTO#metadata} maps from the serialized
 * output, and serialize {@link DefaultErrorDTO#code} as a JSON number rather than string when possible. It uses
 * {@link #DEFAULT_SMART_MAPPER} to do the serialization.
 *
 * <p>If you want to always output the metadata object and/or always output error codes as strings you can generate the
 * appropriate serializer by calling {@link #generateErrorContractObjectMapper(boolean, boolean)} and passing in
 * whatever arguments you need, then use that by calling {@link #writeValueAsString(Object, ObjectMapper)} and pass in
 * your custom serializer.
 *
 * <p>You can further define a default generic error response that will be returned if there's a problem during
 * serialization by calling {@link #writeValueAsString(Object, ObjectMapper, String)}. The other methods use
 * {@link #DEFAULT_ERROR_RESPONSE_STRING} as a default.
 * <p>
 * Created by dsand7 on 9/25/14.
 */
@SuppressWarnings("WeakerAccess")
public class JsonUtilWithDefaultErrorContractDTOSupport {

    private JsonUtilWithDefaultErrorContractDTOSupport() {
        // Do nothing
    }

    private static final Logger logger = LoggerFactory.getLogger(JsonUtilWithDefaultErrorContractDTOSupport.class);

    public static final ObjectMapper DEFAULT_SMART_MAPPER = generateErrorContractObjectMapper(true, true);

    public static final String DEFAULT_ERROR_RESPONSE_STRING = "{\"error_id\":\"%uuid%\",\"errors\":[{\"code\":10,\"message\":\"An error occurred while fulfilling the request\"}]}";

    public static String writeValueAsString(Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String writeValueAsString(Object value, ObjectMapper mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String writeValueAsString(Object value, ObjectMapper mapper, String defaultResponseIfErrorDuringSerialization) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ObjectMapper generateErrorContractObjectMapper(boolean excludeEmptyMetadataFromJson, boolean serializeErrorCodeFieldAsIntegerIfPossible) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected static class ErrorContractSerializationFactory extends BeanSerializerFactory {

        private static final String METADATA_FIELD_NAME = "metadata";

        private static final String ERROR_CODE_FIELD_NAME = "code";

        private final boolean excludeEmptyMetadataFromJson;

        private final boolean serializeErrorCodeFieldAsIntegerIfPossible;

        protected ErrorContractSerializationFactory(SerializerFactoryConfig config, boolean excludeEmptyMetadataFromJson, boolean serializeErrorCodeFieldAsIntegerIfPossible) {
            super(config);
            this.excludeEmptyMetadataFromJson = excludeEmptyMetadataFromJson;
            this.serializeErrorCodeFieldAsIntegerIfPossible = serializeErrorCodeFieldAsIntegerIfPossible;
        }

        @Override
        public SerializerFactory withConfig(SerializerFactoryConfig config) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> props) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        protected BeanPropertyWriter findPropWriter(List<BeanPropertyWriter> propWriters, String desiredFieldName) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    protected static class MetadataPropertyWriter extends BeanPropertyWriter {

        protected MetadataPropertyWriter(BeanPropertyWriter base) {
            super(base);
        }

        @Override
        public void serializeAsField(Object bean, JsonGenerator jgen, SerializerProvider prov) throws Exception {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    protected static class SmartErrorCodePropertyWriter extends BeanPropertyWriter {

        protected SmartErrorCodePropertyWriter(BeanPropertyWriter base) {
            super(base);
        }

        @Override
        public void serializeAsField(Object bean, JsonGenerator jgen, SerializerProvider prov) throws Exception {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
