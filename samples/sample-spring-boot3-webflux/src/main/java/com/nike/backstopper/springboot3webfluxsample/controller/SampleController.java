package com.nike.backstopper.springboot3webfluxsample.controller;

import com.nike.backstopper.exception.ApiException;
import com.nike.backstopper.service.ClientDataValidationService;
import com.nike.backstopper.springboot3webfluxsample.error.SampleProjectApiError;
import com.nike.backstopper.springboot3webfluxsample.model.RgbColor;
import com.nike.backstopper.springboot3webfluxsample.model.SampleModel;
import com.nike.internal.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import java.util.Arrays;
import java.util.UUID;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.nike.backstopper.springboot3webfluxsample.controller.SampleController.SAMPLE_PATH;
import static java.util.Collections.singletonList;

/**
 * Contains some sample endpoints. In particular {@link #postSampleModel(SampleModel)} is useful for showing the
 * JSR 303 Bean Validation integration in Backstopper - see that method's javadocs and source code for more info.
 *
 * <p>The {@code VerifyExpectedErrorsAreReturnedComponentTest} component test launches the server and exercises
 * all these endpoints in various ways to verify the expected errors are returned using the expected error contract.
 */
@Controller
@RequestMapping(SAMPLE_PATH)
@SuppressWarnings({ "unused", "WeakerAccess" })
public class SampleController {

    public static final String SAMPLE_PATH = "/sample";

    public static final String CORE_ERROR_WRAPPER_ENDPOINT_SUBPATH = "/coreErrorWrapper";

    public static final String WITH_REQUIRED_QUERY_PARAM_SUBPATH = "/withRequiredQueryParam";

    public static final String WITH_REQUIRED_HEADER_SUBPATH = "/withRequiredHeader";

    public static final String TRIGGER_UNHANDLED_ERROR_SUBPATH = "/triggerUnhandledError";

    public static final String SAMPLE_FROM_ROUTER_FUNCTION_PATH = "/sample/fromRouterFunction";

    public static final String SAMPLE_FLUX_SUBPATH = "/flux";

    public static final String MONO_ERROR_SUBPATH = "/monoError";

    public static final String FLUX_ERROR_SUBPATH = "/fluxError";

    public static int nextRangeInt(int lowerBound, int upperBound) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static RgbColor nextRandomColor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public Mono<SampleModel> getSampleModel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Note how the {@link Valid} annotation causes Spring Boot to run the given request payload object through
     * JSR 303 validation after deserialization and before calling this method. Alternatively you could omit the
     * {@code @Valid} annotation, inject a {@link ClientDataValidationService} into this class, and call
     * {@link ClientDataValidationService#validateObjectsFailFast(Object...)} passing in the request payload object -
     * if it fails validation an appropriate exception would be thrown immediately. Both solutions are
     * functionally equivalent.
     *
     * <p>In this simple case the {@code @Valid} annotation is easier and simpler, but there are some more complex
     * use cases where using {@link ClientDataValidationService} yourself ends up being a better (or the only)
     * solution.
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SampleModel> postSampleModel(@Valid @RequestBody SampleModel model) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(path = CORE_ERROR_WRAPPER_ENDPOINT_SUBPATH)
    public void failWithCoreErrorWrapper() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(path = WITH_REQUIRED_QUERY_PARAM_SUBPATH, produces = "text/plain")
    @ResponseBody
    public Mono<String> withRequiredQueryParam(@RequestParam(name = "requiredQueryParamValue") int someRequiredQueryParam) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(path = WITH_REQUIRED_HEADER_SUBPATH, produces = "text/plain")
    @ResponseBody
    public Mono<String> withRequiredHeader(@RequestHeader(name = "requiredHeaderValue") int someRequiredHeader) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(path = TRIGGER_UNHANDLED_ERROR_SUBPATH)
    public void triggerUnhandledError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Mono<ServerResponse> getSampleModelRouterFunction(ServerRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(path = SAMPLE_FLUX_SUBPATH, produces = "application/json")
    @ResponseBody
    public Flux<SampleModel> getSampleModelFlux() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(path = MONO_ERROR_SUBPATH, produces = "application/json")
    @ResponseBody
    public Mono<SampleModel> getMonoError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @GetMapping(path = FLUX_ERROR_SUBPATH, produces = "application/json")
    @ResponseBody
    public Flux<SampleModel> getFluxError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
