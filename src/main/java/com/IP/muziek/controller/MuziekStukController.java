package com.IP.muziek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.IP.muziek.domain.MuziekStuk;
import com.IP.muziek.service.MuziekLibraryService;


/**
 * Created by Sylvaren on 14/04/2017.
 */

@Controller
@RequestMapping(value="/stuk")
public class MuziekStukController {
    private final MuziekLibraryService service;

    public MuziekStukController(@Autowired MuziekLibraryService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getStukken(){
        ModelAndView mnv = new ModelAndView("muziekStukOverview", "stukken", service.getAllStukken());
        mnv.addObject("gem", service.gemiddelde());
        return mnv;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView getNewForm(){
        return new ModelAndView("stukForm", "stuk", new MuziekStuk());
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute ("stuk") MuziekStuk stuk, BindingResult result){
        if(result.hasErrors()){
            return "stukForm";
        }
        service.setMuziekStuk(stuk);
        return "redirect:/stuk.htm";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@ModelAttribute ("stuk") MuziekStuk stuk){


        return "redirect:/stuk.htm";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable String id){
        return new ModelAndView("stukForm", "stuk", service.getMuziekStuk(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String id){
        service.verwijderMuziekStuk(id);
        return "redirect:/stuk.htm";
    }


}
