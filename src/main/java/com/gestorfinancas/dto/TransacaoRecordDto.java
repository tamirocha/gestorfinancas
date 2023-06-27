package com.gestorfinancas.dto;

import com.gestorfinancas.models.Conta;
import com.gestorfinancas.models.Transacao;
import org.springframework.beans.BeanUtils;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record TransacaoRecordDto(@NotNull BigDecimal valor, LocalDate dataTransacao, ContaDto conta) {

    public Transacao convertToTransacao () {
        var transacao = new Transacao();
        var conta = new Conta();
        transacao.setConta(conta);
        BeanUtils.copyProperties(this, transacao);
        return transacao;
    }

    public static class ContaDto {
        private Long codigo;

        public Long getCodigo() {
            return codigo;
        }

        public void setCodigo(Long codigo) {
            this.codigo = codigo;
        }
    }
}
