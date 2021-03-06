package cmpe275.dos.controller;

import cmpe275.dos.response.JsonResponse;
import cmpe275.dos.response.JsonResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static cmpe275.dos.constant.JsonConstant.KEY_ERROR;


public abstract class AbstractController extends JsonResponseHandler {

    protected <T> ResponseEntity<JsonResponse> success(String key, T data) {
        return genericResponse(new JsonResponse(key, data), HttpStatus.OK);
    }

    protected ResponseEntity<JsonResponse> notFound() {
        return genericResponse(new JsonResponse(KEY_ERROR, HttpStatus.NOT_FOUND.name()), HttpStatus.NOT_FOUND);
    }

    protected <T> ResponseEntity<JsonResponse> created(String key, T data) {
        return genericResponse(new JsonResponse(key, data), HttpStatus.CREATED);
    }

    protected ResponseEntity<JsonResponse> conflict() {
        return genericResponse(new JsonResponse(KEY_ERROR, HttpStatus.CONFLICT.name()), HttpStatus.CONFLICT);
    }
}
