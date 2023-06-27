package com.gestorfinancas.dto;

import com.gestorfinancas.models.Pessoa;
import org.springframework.beans.BeanUtils;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public record PessoaRecordDto(@NotBlank String nome, @NotNull Long cpf, @NotNull Date dataNascimento) {

    public Pessoa convertToPessoa () {
        var pessoa = new Pessoa();
//        pessoa.setCpf(this.cpf);
//        pessoa.setNome(this.nome);
        BeanUtils.copyProperties(this, pessoa);
        return pessoa;
    }

}
