package com.gestorfinancas.services;

import com.gestorfinancas.dto.DepositoRecordDto;
import com.gestorfinancas.dto.SaqueRecordDto;
import com.gestorfinancas.dto.TransacaoRecordDto;
import com.gestorfinancas.models.Conta;
import com.gestorfinancas.models.Transacao;
import com.gestorfinancas.repositories.ContaRepository;
import com.gestorfinancas.repositories.TransacaoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    TransacaoRepository transacaoRepository;
    ContaRepository contaRepository;

    public TransacaoService(TransacaoRepository transacaoRepository, ContaRepository contaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.contaRepository = contaRepository;
    }

    public Optional<Transacao> findById(Long id) {
        return transacaoRepository.findById(id);
    }

    public List<Transacao> findAll() {
        return transacaoRepository.findAll();
    }

    @Transactional
    public Transacao depositar(DepositoRecordDto depositoRecordDto) {
        Conta conta = contaRepository.findContaByPessoa(depositoRecordDto.pessoa());
        conta.setSaldo(conta.getSaldo().add(depositoRecordDto.valor()) );
        Transacao transacao = new Transacao();
        transacao.setValor(depositoRecordDto.valor());
        transacao.setDataTransacao(LocalDate.now());
        transacao.setConta(conta);
        return transacaoRepository.save(transacao);
    }

    @Transactional
    public Transacao sacar(SaqueRecordDto saqueRecordDto) {
        Conta conta = contaRepository.findContaByPessoa(saqueRecordDto.pessoa());
        conta.setSaldo(conta.getSaldo().subtract(saqueRecordDto.valor()) );
        Transacao transacao = new Transacao();
        transacao.setValor(saqueRecordDto.valor().negate());
        transacao.setDataTransacao(LocalDate.now());
        transacao.setConta(conta);
        return transacaoRepository.save(transacao);
    }
}
