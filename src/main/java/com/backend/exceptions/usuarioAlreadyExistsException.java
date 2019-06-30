package com.backend.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class usuarioAlreadyExistsException extends RuntimeException {
   public usuarioAlreadyExistsException(String msg) {
       super(msg);
   }
}

