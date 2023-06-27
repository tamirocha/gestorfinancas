package com.gestorfinancas.services;

import com.gestorfinancas.dto.ContaRecordDto;
import com.gestorfinancas.models.Conta;
import com.gestorfinancas.repositories.ContaRepository;
import com.gestorfinancas.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.gestorfinancas.models.Conta_.saldo;

@Service
public class ContaService {
    ContaRepository contaRepository;
    PessoaRepository pessoaRepository;

    public ContaService(ContaRepository contaRepository, PessoaRepository pessoaRepository) {
        this.contaRepository = contaRepository;
        this.pessoaRepository = pessoaRepository;
    }

    public Conta saveConta(ContaRecordDto contaRecordDto) throws Exception {
        var pessoa = pessoaRepository.findById(contaRecordDto.pessoa().getCodigo());
        if(pessoa.isEmpty()) {
            throw new Exception("Pessoa não encontrada " + contaRecordDto.pessoa().getCodigo());
        }
        var conta = contaRecordDto.convertToConta();
        conta.setPessoa(pessoa.get());
        return contaRepository.save(conta);
    }

    public Optional<Conta> findById(Long id) {
        return contaRepository.findById(id);
    }

    public List<Conta> findAll() {
        return contaRepository.findAll();
    }

    public void delete(Conta conta) {
        contaRepository.delete(conta);
    }

    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }


    public void bloquear(Long id) throws Exception {
        Optional<Conta> conta = contaRepository.findById(id);
        if (conta.isEmpty()) {
            throw new Exception("Conta não encontrada: " + id);
        }
        Conta contaParaBloquear = conta.get();
        contaParaBloquear.setFlagAtivo(false);
        contaRepository.save(contaParaBloquear);
    }
}
