package com.gestorfinancas.controllers;

import com.gestorfinancas.dto.DepositoRecordDto;
import com.gestorfinancas.dto.SaqueRecordDto;
import com.gestorfinancas.dto.TransacaoRecordDto;
import com.gestorfinancas.models.Transacao;
import com.gestorfinancas.services.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }


    @GetMapping
    public ResponseEntity<List<Transacao>> getAllTransacao() {
        return ResponseEntity.status(HttpStatus.OK).body(transacaoService.findAll());
    }

    @GetMapping("/(id)")
    public ResponseEntity<Object> getOneTransacao(@PathVariable(value = "id") Long id) {
        Optional<Transacao> transacao0 = transacaoService.findById(id);
        if (transacao0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Transação não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transacao0.get());
    }

    @PostMapping("/depositar")
    public ResponseEntity<Transacao> depositar (@RequestBody @Valid DepositoRecordDto depositoRecordDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.depositar(depositoRecordDto));
    }

    @PostMapping("/sacar")
    public ResponseEntity<Transacao> sacar (@RequestBody @Valid SaqueRecordDto saqueRecordDto) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoService.sacar(saqueRecordDto));
    }

}
