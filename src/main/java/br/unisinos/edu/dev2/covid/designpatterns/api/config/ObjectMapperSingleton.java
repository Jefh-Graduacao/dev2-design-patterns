package br.unisinos.edu.dev2.covid.designpatterns.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Configurações de serialização/deserialização para a comunicação com API's externas
 * Esta classe implementa o padrão Singleton porque precisamos que a configuração de
 * serialização seja única para todo o ciclo de vida da aplicação.
 */
public class ObjectMapperSingleton {
    //Variavel que irá armazenar a instancia unica desta classe.
    private static ObjectMapper objectMapper;

    public static ObjectMapper getInstance() {
        if(objectMapper != null) {
            return objectMapper;
        }

        synchronized (ObjectMapperSingleton.class) {
            if(objectMapper != null) {
                return objectMapper;
            }

            return (objectMapper = ObjectMapperFactory.create(ObjectMapperFactory.CreationType.DEFAULT_CONFIGS));
        }
    }
}
