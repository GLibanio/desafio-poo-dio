package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.*;

public class Bootcamp {

    private String nome;
    private String descricao;

    private final LocalDate dataInicial = LocalDate.now();
    private final LocalDate dataFinal = dataInicial.plusDays(45);

    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();

    // Getters e Setters com validações básicas
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do bootcamp não pode ser nulo ou vazio.");
        }
        this.nome = nome.trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição do bootcamp não pode ser nula ou vazia.");
        }
        this.descricao = descricao.trim();
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public void inscreverDev(Dev dev) {
        if (dev != null) {
            devsInscritos.add(dev);
        }
    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    public void adicionarConteudo(Conteudo conteudo) {
        if (conteudo != null) {
            conteudos.add(conteudo);
        }
    }

    // equals e hashCode usando apenas atributos essenciais
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp)) return false;
        Bootcamp that = (Bootcamp) o;
        return Objects.equals(nome, that.nome) &&
               Objects.equals(dataInicial, that.dataInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicial);
    }

    @Override
    public String toString() {
        return String.format("Bootcamp{nome='%s', descricao='%s', dataInicial=%s, dataFinal=%s, inscritos=%d, conteudos=%d}",
                nome, descricao, dataInicial, dataFinal, devsInscritos.size(), conteudos.size());
    }
}
