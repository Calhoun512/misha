/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import CRM.objects.clients;
import CRM.objects.Message;
import CRM.repository.ClientsDAO;
import java.util.HashMap;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author calho
 */
@Controller
public class ClientController {
    @Autowired
    ClientsDAO dao;
    
    private static final Logger logger = Logger.getLogger(ClientController.class.getName());
    
    @RequestMapping("/clients/clientform")
    public ModelAndView showform(){
        return new ModelAndView("clientform","clients", new clients());
    }
    
    @RequestMapping(value = "/clients/save", method =  RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("clients") clients clients, HttpServletRequest request){
        int r = dao.save(clients);
        
        Message msg = null;
        if(r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Client has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New client creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }
    
    @RequestMapping("/clients/viewclients")
    public ModelAndView viewclients(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;
        }
        
        List<clients> list = dao.getClientsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");
        
        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
            
        }
        
        return new ModelAndView("viewclients", context);
    }
    
    @RequestMapping(value = "/clients/editclients/{id}")
    public ModelAndView edit(@PathVariable int client_id){
        clients clients = dao.getClientById(client_id);
        return new ModelAndView("clienteditform","clients",clients);
    }
    
    @RequestMapping(value = "/clients/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("clients") clients clients, HttpServletRequest request){
        int r = dao.update(clients);
        
        Message msg = null;
        if(r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Client has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Client edit failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }
    
    @RequestMapping(value = "/clients/deleteclients/{client_id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int client_id, HttpServletRequest request){
        int r = dao.delete(client_id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Client has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Client deletion failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/clients/viewclients");
    }
    
}
