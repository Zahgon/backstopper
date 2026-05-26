package com.nike.backstopper.handler.adapter;

import com.nike.backstopper.handler.RequestInfoForLogging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Adapter that allows {@link HttpServletRequest} to be used as a {@link RequestInfoForLogging}.
 *
 * @author Nic Munroe
 */
public class RequestInfoForLoggingServletApiAdapter implements RequestInfoForLogging {

    private final static Logger logger = LoggerFactory.getLogger(RequestInfoForLoggingServletApiAdapter.class);

    private final HttpServletRequest request;

    private Map<String, List<String>> headersMapCache;

    public RequestInfoForLoggingServletApiAdapter(HttpServletRequest request) {
        if (request == null)
            throw new IllegalArgumentException("request cannot be null");
        this.request = request;
    }

    @Override
    public String getRequestUri() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getRequestHttpMethod() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getQueryString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Map<String, List<String>> getHeadersMap() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getHeader(String headerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<String> getHeaders(String headerName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object getAttribute(String key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getBody() throws GetBodyException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("WeakerAccess")
    protected void safeCloseCloseable(Closeable closeable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
