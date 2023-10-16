package com.example.dateanu.api.controller.client;

import com.example.dateanu.domain.client.Client;
import com.example.dateanu.domain.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/client")
@RequiredArgsConstructor
@RestController
@Slf4j
public class ClientController {
    private final ClientRepository clientRepository;

    @GetMapping("/{id}")
    public Optional<Client> clientInfo(@PathVariable Long id){
        return clientRepository.findById(id);
    }
}
