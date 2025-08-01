package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.Objects;

public class Mentoria extends Conteudo {

    private LocalDate data;

    public Mentoria() {
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = Objects.requireNonNull(data, "A data da mentoria não pode ser nula");
    }

    @Override
    public String toString() {
        return String.format(
            "Mentoria {\n  Título: '%s',\n  Descrição: '%s',\n  Data: %s\n}",
            getTitulo(), getDescricao(), data
        );
    }
}
