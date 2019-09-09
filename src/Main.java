import exception.SortingServiceException;
import model.Livro;
import model.Ordem;
import model.enums.Sentido;
import service.OrdenadorDeLivros;

import java.util.ArrayList;
import java.util.List;

public class Main {

  private static  List<Livro> livros = new ArrayList<>();


    /**
     * O serviço de Ordenação recebe um List de livros para ordenar
     * O serviço de ordenação recebe uma Ordem(Objeto)  ou 2 parametros (Sentido e um Atributo para ordenação)
     *
     * @param args
     */


    public static void main(String[] args) {
        popularLivros();

        List<Livro> livroOrdenados = new ArrayList<>();
        OrdenadorDeLivros ordenadorDeLivros = new OrdenadorDeLivros();
        Ordem ordem = new Ordem();

        try {
            livroOrdenados = ordenadorDeLivros.ordernar(null , Sentido.ASC , OrdenadorDeLivros.TITULO);
        } catch (SortingServiceException e) {
            e.printStackTrace();
        }


//        try {
//            livroOrdenados = ordenadorDeLivros.ordernar(livros , ordem);
//        } catch (SortingServiceException e) {
//            e.printStackTrace();
//        }

        System.out.println(livroOrdenados);


    }

    private static void popularLivros() {

        livros.clear();
        livros.add(new Livro("Java How to Program", "Deitel & Deitel", 2007));
        livros.add(new Livro("Patterns of Enterprise Application Architeture", "Martin Fowler", 2002));
        livros.add(new Livro("Head First Design Patterns", "Elisabeth Freeman", 2004));
        livros.add(new Livro("Internet & World Wide Web: How to Program", "Deitel & Deitel", 2007));


    }
}
