package br.edu.ifrs.restinga.trabprog3.demo.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class naoencontrado extends RuntimeException {

    public naoencontrado(String erro) {
        super(erro);
    }
}
