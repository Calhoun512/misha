/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.web;

import CRM.objects.Message;
import CRM.objects.interactions;
import CRM.repository.InteractionsDAO;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author calho
 */
public class InteractionsController {
    @Autowired
    InteractionsDAO dao;
    
    private static final Logger logger = Logger.getLogger(InteractionsController.class.getName());
    
    @RequestMapping("/interactions/interactionsform")
    public ModelAndView showform(){
        return new ModelAndView("interactionsform","interactions", new interactions());
    }
    
    @RequestMapping(value = "/interactions/save", method =  RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("interactions") interactions interactions, HttpServletRequest request){
        int r = dao.save(interactions);
        
        Message msg = null;
        if(r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Interaction has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New interaction creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }
    
    @RequestMapping("/interactions/viewinteractions")
    public ModelAndView viewinteractions(@PathVariable int pageid, HttpServletRequest request){
        int total = 25;
        int start = 1;
        int count = dao.getInteractionsCount();
        
        if(pageid != 1) {
            start = (pageid-1) * total + 1;
        }
        
        List<interactions> list = dao.getInteractionsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");
        
        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
            
        }
        
        return new ModelAndView("viewinteractions", context);
    }
    
    @RequestMapping(value = "/interactions/editinteractions/{interaction_id}")
    public ModelAndView edit(@PathVariable int interaction_id){
        interactions interactions = dao.getInteractionsById(interaction_id);
        return new ModelAndView("interactionseditform","interactions",interactions);
    }
    
    @RequestMapping(value = "/prospects/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("interactions") interactions interactions, HttpServletRequest request){
        int r = dao.update(interactions);
        
        Message msg = null;
        if(r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Interaction has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Interaction edit failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }
    
    @RequestMapping(value = "/interactions/deleteinteractions/{interaction_id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int interaction_id, HttpServletRequest request){
        int r = dao.delete(interaction_id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Interaction has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Interaction deletion failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/interactions/viewinteractions");
    }
    
    
}
