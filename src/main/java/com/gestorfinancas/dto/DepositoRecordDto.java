package com.gestorfinancas.dto;

import com.gestorfinancas.models.Pessoa;

import java.math.BigDecimal;

public record DepositoRecordDto(Pessoa pessoa, BigDecimal valor) {
}
