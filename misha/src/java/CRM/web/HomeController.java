/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.web;

/**
 *
 * @author calho
 */
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import CRM.objects.prospects;
import CRM.objects.interactions;
import CRM.objects.clients;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public ModelAndView viewartist(){
        return new ModelAndView("index");
    }
    
}
