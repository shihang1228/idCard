package com.baldurtech.idCard;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("idCard")
public class IdController {
    IdService idService;
    
    @Autowired
    public IdController(IdService idService) {
        this.idService = idService;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("idCard", new IdCard());
        return "idCard/create";
    }
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("idCard") IdCard idCard, BindingResult bindingResult, Model model) {   
        idService.save(idCard);
        model.addAttribute("idCard", idCard);
        return "idCard/success";
    }
}