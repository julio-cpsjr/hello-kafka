package br.com.httprequest.httpkafka.config;


import br.com.httprequest.httpkafka.response.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(1)
public class SystemExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleSystemException(Exception runtime) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(
                        new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                runtime.getMessage(),
                                HttpStatus.INTERNAL_SERVER_ERROR.name()
                        )
                );
    }

}
