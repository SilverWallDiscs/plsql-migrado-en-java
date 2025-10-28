package com.example.demo.controller;

import com.example.demo.service.ScriptPrincipalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InitController {

    @Autowired
    private ScriptPrincipalService scriptPrincipalService;

    @GetMapping("/")
    public String home() {
        return "redirect:/init";
    }

    @GetMapping("/init")
    public String init(Model model) {
        model.addAttribute("message", "Haz clic para iniciar el proceso.");
        model.addAttribute("logs", new java.util.ArrayList<>());  // Lista vacía inicialmente
        return "init";
    }

    @PostMapping("/init")
    public String runProcess(Model model) {
        ScriptPrincipalService.ResultadoProceso resultado = scriptPrincipalService.ejecutarProceso();
        model.addAttribute("message", resultado.getMensaje());
        model.addAttribute("logs", resultado.getLogs());  // Pasa los logs
        return "init";
    }
}