package com.gestorfinancas.services;

import com.gestorfinancas.dto.PessoaRecordDto;
import com.gestorfinancas.models.Pessoa;
import com.gestorfinancas.repositories.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa savePessoa(PessoaRecordDto pessoaRecordDto) {
       return pessoaRepository.save(pessoaRecordDto.convertToPessoa());
    }

    public Optional<Pessoa> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public void delete(Pessoa pessoa) {
        pessoaRepository.delete(pessoa);
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
