package com.gestorfinancas.dto;

import com.gestorfinancas.models.Conta;
import com.gestorfinancas.models.Pessoa;
import org.springframework.beans.BeanUtils;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public record ContaRecordDto(@NotNull Double saldo, @NotNull Double limiteSaqueDiario, @NotNull boolean flagAtivo , @NotNull Integer tipoConta, LocalDate dataCriacao, PessoaDto pessoa) {

    public Conta convertToConta () {
        var conta = new Conta();
        Pessoa pessoa = new Pessoa();
        conta.setPessoa(pessoa);
        BeanUtils.copyProperties(this, conta);
        return conta;
    }

    public static class PessoaDto {
        private Long codigo;

        public Long getCodigo() {
            return codigo;
        }

        public void setCodigo(Long codigo) {
            this.codigo = codigo;
        }
    }
}
