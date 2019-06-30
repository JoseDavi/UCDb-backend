package com.backend.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class usuarioNotFoundException extends RuntimeException {
   public usuarioNotFoundException(String msg) {
       super(msg);
   }
}

