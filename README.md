# COVID-19 Design Patterns
> Implementação de 5 design patterns da GoF - Tarefa de Desenvolvimento de Software II (2020/1)

Nosso trabalho consiste em uma simples aplicação para consultar casos de COVID-19 por localização ou dados consolidados (referentes ao mundo inteiro).

## Padrões implementados

### Singleton

**Onde foi criado?** br.unisinos.edu.dev2.covid.designpatterns.api.config.ObjectMapperSingleton  
**Onde foi usado?** br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.CovidTrackerProxyRepository  
**Por quê?** Precisamos que o ObjectMapper seja uma instância única para toda a aplicação porque nele temos todas as configurações de serialização.

### Factory 

**Onde (definição)?** br.unisinos.edu.dev2.covid.designpatterns.api.config.ObjectMapperFactory
**Onde (uso)?** br.unisinos.edu.dev2.covid.designpatterns.api.config.ObjectMapperSingleton
**Por quê?** Precisamos construir uma instância de ObjectMapper usando diversas configurações

### Builder

**Onde foi criado?** br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.CovidTrackerApiUrlBuilder  
**Onde foi usado?** br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.CovidTrackerProxyRepository  
**Por quê?** Precisamos de uma maneira eficiente de construir uma mesma URL em diferentes momentos. Ou seja, temos a necessidade de trafegar a configuração da URL em dieferentes métodos sem termos montado a URL efetivamente.  
  
### Bridge 

**Onde foi criado?** br.unisinos.edu.dev2.covid.designpatterns.api.service.interfaces.CovidDataService   
Implementação em: br.unisinos.edu.dev2.covid.designpatterns.api.service.br.unisinos.edu.dev2.covid.designpatterns.api.service.CasoCovidDataServiceImpl  
**Onde foi usado?** br.unisinos.edu.dev2.covid.designpatterns.api.controller.DadosCovidController  
**Por quê?** Fazer a segregação da definicação de um subsistema (serviço de consulta de casos de COVID-19) e sua implementação. Desta forma, podemos reimplementar o serviço sem necessidade de alterar os seus clientes.  

### Proxy

**Onde foi criado?** br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.CovidTrackerProxyRepository  
**Onde foi usado?** br.unisinos.edu.dev2.covid.designpatterns.api.service.br.unisinos.edu.dev2.covid.designpatterns.api.service.CasoCovidDataServiceImpl  
**Por quê?** Precisamos de uma maneira fácil para tratar chamadas à serviços externos como se fossem chamadas à métodos locais.





