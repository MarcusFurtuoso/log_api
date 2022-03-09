package com.log.logapi.controller;


import java.util.Arrays;
import java.util.List;

import com.log.logapi.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @GetMapping("/clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1l);
        cliente1.setNome("Pedro");
        cliente1.setEmail("pedro@gmail.com");
        cliente1.setTelefone("79 99924-3289");

        var cliente2 = new Cliente();
        cliente2.setId(2l);
        cliente2.setNome("Clara");
        cliente2.setEmail("clara@gmail.com");
        cliente2.setTelefone("79 98744-5541");

        return Arrays.asList(cliente1, cliente2);
    }
}
