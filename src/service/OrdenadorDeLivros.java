package service;

import exception.SortingServiceException;
import model.Livro;
import model.Ordem;
import model.enums.Sentido;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrdenadorDeLivros {

    public static final String TITULO = "Titulo";
    public static final String AUTOR = "Autor";
    public static final String EDICAO = "Edicao";


    public List<Livro> ordernar(List<Livro> livros, Sentido sentido, String atributo) throws SortingServiceException {
        List<Livro> livrosOrdenados = new ArrayList<>();


        try {

            if (livros.isEmpty()) {
                return livrosOrdenados;
            }

            if (sentido == Sentido.DESC && atributo.equals(TITULO)) {
                livros.sort(Comparator.comparing(Livro::getTitulo).reversed());
                livrosOrdenados = livros;
            }
            if (sentido == Sentido.ASC && atributo.equals(TITULO)) {
                livros.sort(Comparator.comparing(Livro::getTitulo));
                livrosOrdenados = livros;
            }

            if (sentido == Sentido.DESC && atributo.equals(AUTOR)) {
                livros.sort(Comparator.comparing(Livro::getAutor).reversed());
                livrosOrdenados = livros;
            }
            if (sentido == Sentido.ASC && atributo.equals(AUTOR)) {
                livros.sort(Comparator.comparing(Livro::getAutor));
                livrosOrdenados = livros;
            }

            if (sentido == Sentido.DESC && atributo.equals(EDICAO)) {
                livros.sort(Comparator.comparing(Livro::getEdicao).reversed());
                livrosOrdenados = livros;
            }
            if (sentido == Sentido.ASC && atributo.equals(EDICAO)) {
                livros.sort(Comparator.comparing(Livro::getEdicao));
                livrosOrdenados = livros;
            }
            return livrosOrdenados;

        } catch (NullPointerException ex) {
            throw new SortingServiceException("Não foi possível ler a ordenação!");
        }
    }

    public List<Livro> ordernar(List<Livro> livros, Ordem ordem) throws SortingServiceException {

        List<Livro> livrosOrdenados = new ArrayList<>();

        try {

            if (livros.isEmpty()) {
                return livrosOrdenados;
            }


            if (ordem.getAtributo().equals("") || ordem.getSentido().equals("")) {
                return livrosOrdenados;
            }

            if (ordem.getSentido() == Sentido.DESC && ordem.getAtributo().equals(AUTOR)) {
                livros.sort(Comparator.comparing(Livro::getAutor)
                        .thenComparing(Livro::getTitulo));
                livrosOrdenados = livros;
            }
            if (ordem.getSentido() == Sentido.ASC && ordem.getAtributo().equals(AUTOR)) {
                livros.sort(Comparator.comparing(Livro::getAutor)
                        .thenComparing(Livro::getTitulo).reversed());
                livrosOrdenados = livros;
            }

            if (ordem.getSentido() == Sentido.DESC && ordem.getAtributo().equals(EDICAO)) {
                livros.sort(Comparator.comparing(Livro::getEdicao).reversed()
                        .thenComparing(Comparator.comparing(Livro::getAutor).reversed()
                                .thenComparing(Livro::getTitulo)));
                livrosOrdenados = livros;
            }
            return livrosOrdenados;

        } catch (NullPointerException ex) {
            throw new SortingServiceException("Não foi possível ler a ordenação!");
        }


    }
}
