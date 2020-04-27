package br.unisinos.edu.dev2.covid.designpatterns.api.controller.web;


import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.InfectedData;
import br.unisinos.edu.dev2.covid.designpatterns.api.proxyRepository.models.Location;
import br.unisinos.edu.dev2.covid.designpatterns.api.service.CasoCovidDataServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/web")
public class CovidWebController {

    @RequestMapping(value = { "", "/", "/index", "/index/" }, method = RequestMethod.GET)
    public String index() throws IOException {
        return "index";
    }


    @RequestMapping(value = { "/location/{local}"}, method = RequestMethod.GET)
    public String location(HttpServletRequest request, @PathVariable("local") Integer codigoLocal) throws IOException {
        try {
            Location location = new CasoCovidDataServiceImpl().getDataByLocation(codigoLocal);
            request.setAttribute("location",location);
        }catch (Exception e) {
            System.out.println("Falha ao consultar API");
        }
        return "localizacao";
    }

    @RequestMapping(value = { "/global/","/global"}, method = RequestMethod.GET)
    public String global(HttpServletRequest request) throws IOException {
        try {
            InfectedData infected = new CasoCovidDataServiceImpl().getGlobalData();
            request.setAttribute("infected", infected);
        }catch (Exception e) {
            System.out.println("Falha ao consultar API");
        }
        return "global";
    }
}
