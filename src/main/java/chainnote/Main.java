package chainnote;

import chainnote.content.ImagemConteudo;
import chainnote.content.NotaTexto;
import chainnote.content.TransacaoConteudo;
import chainnote.hash.CalculadoraHash;
import chainnote.hash.SHA256Hash;
import chainnote.model.Blockchain;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CalculadoraHash calculadoraHash = new SHA256Hash();
        Blockchain blockchain = new Blockchain(calculadoraHash);
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println();
            System.out.println("===== CHAINNOTE =====");
            System.out.println("1 - Adicionar nota de texto");
            System.out.println("2 - Adicionar imagem");
            System.out.println("3 - Adicionar transação");
            System.out.println("4 - Listar blockchain");
            System.out.println("5 - Validar blockchain");
            System.out.println("6 - Adulterar bloco");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a nota: ");
                    String texto = scanner.nextLine();

                    blockchain.adicionarBloco(new NotaTexto(texto));
                    System.out.println("Nota adicionada com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o nome do arquivo da imagem: ");
                    String nomeArquivo = scanner.nextLine();

                    System.out.print("Digite a descrição da imagem: ");
                    String descricao = scanner.nextLine();

                    blockchain.adicionarBloco(new ImagemConteudo(nomeArquivo, descricao));
                    System.out.println("Imagem adicionada com sucesso.");
                    break;

                case 3:
                    System.out.print("Digite o remetente: ");
                    String remetente = scanner.nextLine();

                    System.out.print("Digite o destinatário: ");
                    String destinatario = scanner.nextLine();

                    System.out.print("Digite o valor: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    blockchain.adicionarBloco(new TransacaoConteudo(remetente, destinatario, valor));
                    System.out.println("Transação adicionada com sucesso.");
                    break;

                case 4:
                    System.out.println();
                    System.out.println("===== BLOCKCHAIN =====");
                    blockchain.listarBlocos();
                    break;

                case 5:
                    System.out.println("Blockchain válida: " + blockchain.validarCadeia());
                    break;

                case 6:
                    System.out.print("Digite o ID do bloco que deseja adulterar: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo conteúdo adulterado: ");
                    String conteudoAdulterado = scanner.nextLine();

                    blockchain.adulterarBloco(id, new NotaTexto(conteudoAdulterado));
                    System.out.println("Bloco adulterado.");
                    break;

                case 0:
                    System.out.println("Encerrando ChainNote...");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}