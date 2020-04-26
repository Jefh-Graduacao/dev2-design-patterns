package br.unisinos.edu.dev2.covid.designpatterns.api.exception.factory;

import br.unisinos.edu.dev2.covid.designpatterns.api.exception.HttpException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpExceptionFactory {
    public static HttpException buildRegistroNaoEncontrado() {
        return new HttpException("Registro não encontrado", NOT_FOUND);
    }
}
