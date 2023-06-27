package com.gestorfinancas.controllers;

import com.gestorfinancas.dto.ContaRecordDto;
import com.gestorfinancas.models.Conta;
import com.gestorfinancas.services.ContaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conta")
public class ContaController {

    ContaService contaService;


    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @GetMapping
    public ResponseEntity<List<Conta>> getAllConta() {
        return ResponseEntity.status(HttpStatus.OK).body(contaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneConta(@PathVariable(value = "id") Long id) {
        Optional<Conta> conta0 = contaService.findById(id);
        if (conta0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(conta0.get());
    }

    @PostMapping
    public ResponseEntity<Conta> saveConta (@RequestBody @Valid ContaRecordDto contaRecordDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.saveConta(contaRecordDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteConta (@PathVariable (value = "id") Long id) {
        Optional<Conta> conta0 = contaService.findById(id);
        if (conta0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
        }
        contaService.delete(conta0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateConta(@PathVariable (value = "id") Long id, @RequestBody @Valid ContaRecordDto contaRecordDto) {
        Optional<Conta> conta0 = contaService.findById(id);
        if (conta0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
        }
        var conta = contaRecordDto.convertToConta();
        conta.setCodigo(conta0.get().getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(contaService.save(conta));
    }

    @PutMapping("/bloquear/{id}")
    public ResponseEntity<?> bloquear(@PathVariable Long id) throws Exception {
        contaService.bloquear(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
