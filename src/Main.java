import java.awt.event.KeyEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main (String[] args){

        List<Pessoa> pessoas = new ArrayList<>();
        int i = 0;

        while(i < 5){
            i++;
            Pessoa pessoa = new Pessoa();
            Scanner s = new Scanner(System.in);
            System.out.println("Nome: ");
            pessoa.setNome(s.nextLine());
            System.out.println("\nSexo (M/F): ");
            pessoa.setSexo(s.nextLine());
            pessoas.add(pessoa);

        }

        Stream<Pessoa> mulheres = pessoas.stream().filter(pessoa -> pessoa.getSexo().equals("F"));
        mulheres.forEach(mulher -> System.out.println(mulher.getNome()));


    }
}
