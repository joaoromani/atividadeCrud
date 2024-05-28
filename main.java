import java.io.*;
import java.util.*;

class Entidade {
    private int id;
    private String nome;

    public Entidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

public class SistemaCRUD {
    private static final String ARQUIVO_DADOS = "dados.txt";
    private static List<Entidade> listaEntidades = new ArrayList<>();

    public static void main(String[] args) {
        carregarDados();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Criar");
            System.out.println("2. Ler");
            System.out.println("3. Atualizar");
            System.out.println("4. Deletar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    criarEntidade(scanner);
                    break;
                case 2:
                    listarEntidades();
                    break;
                case 3:
                    atualizarEntidade(scanner);
                    break;
                case 4:
                    deletarEntidade(scanner);
                    break;
                case 0:
                    salvarDados();
                    System.out.println("Encerrando o programa. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void criarEntidade(Scanner scanner) {
        System.out.print("Digite o nome da entidade: ");
        String nome = scanner.next();
        int novoId = listaEntidades.size() + 1;
        Entidade novaEntidade = new Entidade(novoId, nome);
        listaEntidades.add(novaEntidade);
        System.out.println("Entidade criada com sucesso!");
    }

    private static void listarEntidades() {
        System.out.println("\nLista de Entidades:");
        for (Entidade entidade : listaEntidades) {
            System.out.println(entidade.getId() + ". " + entidade.getNome());
        }
    }

    private static void atualizarEntidade(Scanner scanner) {
        System.out.print("Digite o ID da entidade que deseja atualizar: ");
        int id = scanner.nextInt();
        for (Entidade entidade : listaEntidades) {
            if (entidade.getId() == id) {
                System.out.print("Digite o novo nome da entidade: ");
                String novoNome = scanner.next();
                entidade.setNome(novoNome);
                System.out.println("Entidade atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Entidade não encontrada com o ID informado.");
    }

    private static void deletarEntidade(Scanner scanner) {
        System.out.print("Digite o ID da entidade que deseja deletar: ");
        int id = scanner.nextInt();
        for (Entidade entidade : listaEntidades) {
            if (entidade.getId() == id) {
                listaEntidades.remove(entidade);
                System.out.println("Entidade deletada com sucesso!");
                return;
            }
        }
        System.out.println("Entidade não encontrada com o ID informado.");
    }

    private static void carregarDados() {
        // Implemente a lógica para carregar os dados do arquivo (se existir)
    }

    private static void salvarDados() {
        // Implemente a lógica para salvar os dados no arquivo
    }
}
