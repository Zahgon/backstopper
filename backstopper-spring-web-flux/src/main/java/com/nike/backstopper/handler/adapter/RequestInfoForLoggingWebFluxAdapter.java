package com.nike.backstopper.handler.adapter;

import com.nike.backstopper.handler.RequestInfoForLogging;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.ServerRequest;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * An implementation of {@link RequestInfoForLogging} that knows how to handle Spring WebFlux {@link ServerRequest}.
 *
 * @author Nic Munroe
 */
public class RequestInfoForLoggingWebFluxAdapter implements RequestInfoForLogging {

    @NotNull
    protected final ServerRequest request;

    @NotNull
    protected final URI requestUri;

    public RequestInfoForLoggingWebFluxAdapter(@NotNull ServerRequest request) {
        //noinspection ConstantConditions
        if (request == null) {
            throw new NullPointerException("request cannot be null");
        }
        this.request = request;
        this.requestUri = request.uri();
        //noinspection ConstantValue
        if (requestUri == null) {
            throw new NullPointerException("request.uri() cannot be null");
        }
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
}
