package com.nike.backstopper.handler.spring.webflux;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.handler.ApiExceptionHandlerBase;
import com.nike.backstopper.handler.ApiExceptionHandlerUtils;
import com.nike.backstopper.handler.ErrorResponseInfo;
import com.nike.backstopper.handler.RequestInfoForLogging;
import com.nike.backstopper.handler.UnexpectedMajorExceptionHandlingError;
import com.nike.backstopper.handler.adapter.RequestInfoForLoggingWebFluxAdapter;
import com.nike.backstopper.handler.spring.webflux.listener.SpringWebFluxApiExceptionHandlerListenerList;
import com.nike.backstopper.model.DefaultErrorContractDTO;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.Ordered;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.codec.HttpMessageWriter;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.result.view.ViewResolver;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;
import static com.nike.backstopper.handler.spring.webflux.DisconnectedClientHelper.isClientDisconnectedException;

/**
 * An {@link ApiExceptionHandlerBase} extension that hooks into Spring WebFlux via its
 * {@link WebExceptionHandler} interface, and specifically the
 * {@link WebExceptionHandler#handle(ServerWebExchange, Throwable)} method.
 *
 * <p>Any errors not handled here are things we don't know how to deal with and will fall through to
 * {@link SpringWebfluxUnhandledExceptionHandler}.
 *
 * @author Nic Munroe
 */
@Named
@Singleton
@SuppressWarnings("WeakerAccess")
public class SpringWebfluxApiExceptionHandler extends ApiExceptionHandlerBase<Mono<ServerResponse>> implements WebExceptionHandler, Ordered {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * The sort order for where this handler goes in the spring exception handler chain. We default to {@link
     * Ordered#HIGHEST_PRECEDENCE}, so that this is tried first before any other handlers.
     */
    private int order = Ordered.HIGHEST_PRECEDENCE;

    protected final SpringWebfluxApiExceptionHandlerUtils springUtils;

    protected final List<HttpMessageReader<?>> messageReaders;

    protected final List<HttpMessageWriter<?>> messageWriters;

    protected final List<ViewResolver> viewResolvers;

    @Inject
    public SpringWebfluxApiExceptionHandler(@NotNull ProjectApiErrors projectApiErrors, @NotNull SpringWebFluxApiExceptionHandlerListenerList apiExceptionHandlerListeners, @NotNull ApiExceptionHandlerUtils generalUtils, @NotNull SpringWebfluxApiExceptionHandlerUtils springUtils, @NotNull ObjectProvider<ViewResolver> viewResolversProvider, @NotNull ServerCodecConfigurer serverCodecConfigurer) {
        super(projectApiErrors, apiExceptionHandlerListeners.listeners, generalUtils);
        //noinspection ConstantConditions
        if (springUtils == null) {
            throw new NullPointerException("springUtils cannot be null.");
        }
        //noinspection ConstantConditions
        if (viewResolversProvider == null) {
            throw new NullPointerException("viewResolversProvider cannot be null.");
        }
        //noinspection ConstantConditions
        if (serverCodecConfigurer == null) {
            throw new NullPointerException("serverCodecConfigurer cannot be null.");
        }
        this.springUtils = springUtils;
        this.viewResolvers = viewResolversProvider.orderedStream().collect(Collectors.toList());
        this.messageReaders = serverCodecConfigurer.getReaders();
        this.messageWriters = serverCodecConfigurer.getWriters();
    }

    @Override
    protected Mono<ServerResponse> prepareFrameworkRepresentation(DefaultErrorContractDTO errorContractDTO, int httpStatusCode, Collection<ApiError> rawFilteredApiErrors, Throwable originalException, RequestInfoForLogging request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @NotNull
    public Mono<Void> handle(@NotNull ServerWebExchange exchange, @NotNull Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void processWebFluxResponse(ErrorResponseInfo<Mono<ServerResponse>> errorResponseInfo, ServerHttpResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Copied and slightly modified from Spring Boot 3.3.3's AbstractErrorWebExceptionHandler class.
    protected Mono<? extends Void> write(ServerWebExchange exchange, ServerResponse response) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * See the javadocs for {@link #order} for info on what this is for.
     */
    @Override
    public int getOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * See the javadocs for {@link #order} for info on what this is for.
     */
    @SuppressWarnings({ "unused" })
    public void setOrder(int order) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Copied and slightly modified from Springboot 3.3.3's AbstractErrorWebExceptionHandler.
    public static class ResponseContext implements ServerResponse.Context {

        private final List<HttpMessageWriter<?>> messageWriters;

        private final List<ViewResolver> viewResolvers;

        protected ResponseContext(List<HttpMessageWriter<?>> messageWriters, List<ViewResolver> viewResolvers) {
            this.messageWriters = messageWriters;
            this.viewResolvers = viewResolvers;
        }

        @Override
        @NotNull
        public List<HttpMessageWriter<?>> messageWriters() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @NotNull
        public List<ViewResolver> viewResolvers() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
