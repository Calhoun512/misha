/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRM.web;

import CRM.objects.Message;
import CRM.objects.prospects;
import CRM.repository.ProspectsDAO;
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
public class ProspectController {
    @Autowired
    ProspectsDAO dao;
    
    private static final Logger logger = Logger.getLogger(ProspectController.class.getName());
    
    @RequestMapping("/prospects/prospectform")
    public ModelAndView showform(){
        return new ModelAndView("prospectform","prospects", new prospects());
    }
    
    @RequestMapping(value = "/prospects/save", method =  RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("prospects") prospects prospects, HttpServletRequest request){
        int r = dao.save(prospects);
        
        Message msg = null;
        if(r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Prospect has been successfully created");
        }
        else {
            msg = new Message(Message.Level.ERROR, "New prospect creation failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/prospects/viewprospects");
    }
    
    @RequestMapping("/prospects/viewprospects")
    public ModelAndView viewprospects(@PathVariable int pageid, HttpServletRequest request){
        int start = 1;
        int total = 25;
        int count = dao.getProspectCount();
        
        if(pageid != 1) {
           start = (pageid-1) * total + 1;
        }
        
        List<prospects> list = dao.getProspectsByPage(start, total);
        
        HashMap<String, Object> context = new HashMap<String, Object>();
        context.put("pages", Math.ceil((float)count/(float)total));
        
        context.put("page", pageid);
        
        Message msg = (Message)request.getSession().getAttribute("message");
        
        if (msg != null) {
            context.put("message", msg);
            request.getSession().removeAttribute("message");
            
        }
        
        return new ModelAndView("viewprospects", context);
    }
    
    @RequestMapping(value = "/prospects/editprospects/{prospect_id}")
    public ModelAndView edit(@PathVariable int prospect_id){
        prospects prospects = dao.getProspectsById(prospect_id);
        return new ModelAndView("prospecteditform","prospects",prospects);
    }
    
    @RequestMapping(value = "/prospects/editsave", method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("prospects") prospects prospects, HttpServletRequest request){
        int r = dao.update(prospects);
        
        Message msg = null;
        if(r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Prospect has been successfully saved");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Prospect edit failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/prospects/viewprospects");
    }
    
    @RequestMapping(value = "/prospects/deleteprospects/{prospect_id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int prospect_id, HttpServletRequest request){
        int r = dao.delete(prospect_id);
        
        Message msg = null;
        if (r == 1) {
            msg = new Message(Message.Level.SUCCESS, "Prospect has been successfully deleted");
        }
        else {
            msg = new Message(Message.Level.ERROR, "Prospect deletion failed");
        }
        
        request.getSession().setAttribute("message", msg);
        
        return new ModelAndView("redirect:/prospects/viewprospects");
    }
    
}
