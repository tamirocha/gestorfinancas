package com.gestorfinancas.controllers;

import com.gestorfinancas.dto.PessoaRecordDto;
import com.gestorfinancas.models.Pessoa;
import com.gestorfinancas.services.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class PessoaController {

    PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping("/pessoa")
    public ResponseEntity<List<Pessoa>> getAllPessoa() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping("/pessoa/(id)")
    public ResponseEntity<Object> getOnePessoa(@PathVariable(value = "id") Long id) {
        Optional<Pessoa> pessoa = pessoaService.findById(id);
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoa.get());
    }

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> savePessoa (@RequestBody @Valid PessoaRecordDto pessoaRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaRecordDto.convertToPessoa()));
    }

    @DeleteMapping("/pessoa/(id)")
    public ResponseEntity<Object> deletePessoa (@PathVariable (value = "id") Long id) {
        Optional<Pessoa> pessoa0 = pessoaService.findById(id);
        if (pessoa0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        pessoaService.delete(pessoa0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa deletada com sucesso");
    }

    @PutMapping("/pessoa/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable (value = "id") Long id, @RequestBody @Valid PessoaRecordDto pessoaRecordDto) {
        Optional<Pessoa> pessoa0 = pessoaService.findById(id);
        if (pessoa0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        var pessoa = pessoaRecordDto.convertToPessoa();
        pessoa.setCodigo(pessoa0.get().getCodigo());
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoa));
    }






























}
