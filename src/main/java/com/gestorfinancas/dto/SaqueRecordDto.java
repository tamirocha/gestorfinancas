package com.gestorfinancas.dto;

import com.gestorfinancas.models.Pessoa;

import java.math.BigDecimal;

public record SaqueRecordDto(Pessoa pessoa, BigDecimal valor) {
}
