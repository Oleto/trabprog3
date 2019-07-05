package br.edu.ifrs.restinga.trabprog3.demo.erro;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RNinvalida extends RuntimeException {

    public RNinvalida(String erro){
        super(erro);
    }
}
