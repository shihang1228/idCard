package com.baldurtech.idCard;

import java.sql.Blob;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.multipart.MultipartFile;
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
    public String save(@ModelAttribute("idCard") IdCard idCard,  
                       @RequestParam("image") MultipartFile file) {
        try {
            idCard.setContent(file.getBytes());
            idCard.setContentType(file.getContentType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            idService.save(idCard);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return "idCard/success";
    }
    
    @RequestMapping("show")
    public @ResponseBody void show(@RequestParam("id") Long id, HttpServletResponse resp) throws IOException {
        IdCard idCard = idService.getById(id);
        resp.setContentType(idCard.getContentType());
        OutputStream out=resp.getOutputStream(); 
        out.write(idCard.getContent()); 
    }
    
}