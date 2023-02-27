package branch.manager.api.exception;

import branch.manager.api.dto.DetalheDeErrosDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.time.OffsetDateTime;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> handlerNotFoundException(EntityNotFoundException ex, WebRequest webRequest){

        HttpStatus status = HttpStatus.NOT_FOUND;

        DetalheDeErrosDto detalheDeErrosDto = criarDtoDeErro(status.value(),"Objeto não encontrado",ex.getMessage());

        return handleExceptionInternal(ex,detalheDeErrosDto, new HttpHeaders(),HttpStatus.NOT_FOUND,webRequest);
    }

    @ExceptionHandler(UnprocessableEntity.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handlerUnprocessableEntity(UnprocessableEntity ex, WebRequest webRequest){

        HttpStatus status = HttpStatus.BAD_REQUEST;

        DetalheDeErrosDto detalheDeErrosDto = criarDtoDeErro(status.value(),"Entidade mal processada",ex.getMessage());

        return handleExceptionInternal(ex,detalheDeErrosDto, new HttpHeaders(),HttpStatus.BAD_REQUEST,webRequest);
    }
    private DetalheDeErrosDto criarDtoDeErro(Integer status, String titulo, String detail){
        return DetalheDeErrosDto.builder()
                .timestamp(OffsetDateTime.now())
                .status(status)
                .detail(detail)
                .titulo(titulo)
                .build();
    }


}
