import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Curso cursoJava = criarCurso("Curso Java", "Descrição curso Java", 8);
        Curso cursoJs = criarCurso("Curso JS", "Descrição curso JS", 4);
        Mentoria mentoriaJava = criarMentoria("Mentoria de Java", "Descrição mentoria Java");

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(cursoJava);
        bootcamp.getConteudos().add(cursoJs);
        bootcamp.getConteudos().add(mentoriaJava);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        simularProgresso(devCamila, 2);

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);
        simularProgresso(devJoao, 3);
    }

    private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
        Curso curso = new Curso();
        curso.setTitulo(titulo);
        curso.setDescricao(descricao);
        curso.setCargaHoraria(cargaHoraria);
        return curso;
    }

    private static Mentoria criarMentoria(String titulo, String descricao) {
        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo(titulo);
        mentoria.setDescricao(descricao);
        mentoria.setData(LocalDate.now());
        return mentoria;
    }

    private static void simularProgresso(Dev dev, int passos) {
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        for (int i = 0; i < passos; i++) {
            dev.progredir();
        }
        System.out.println("Conteúdos Inscritos " + dev.getNome() + ": " + dev.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos " + dev.getNome() + ": " + dev.getConteudosConcluidos());
        System.out.println("XP: " + dev.calcularTotalXp());
    }
}
