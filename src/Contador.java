import java.util.Scanner;

public class Contador {

    public static void main(String[] args) throws ParametrosInvalidosException {

        Scanner terminal = new Scanner(System.in);

        int[] parametros = lerParametros(terminal);

        try {
            contar(parametros[0], parametros[1]);
        }
        catch (ParametrosInvalidosException e) {
            e.getMessage();
            parametros = lerParametros(terminal);
            contar(parametros[0], parametros[1]);
        }
        finally {
            terminal.close();
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O primeiro parâmetro não pode ser MAIOR que o segundo.");
        }

        int contagem = parametroDois - parametroUm;
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }

    static int[] lerParametros(Scanner terminal) {
        System.out.print("Digite o primeiro parâmetro: ");
        int parametroUm = terminal.nextInt();
        System.out.print("Digite o segundo parâmetro: ");
        int parametroDois = terminal.nextInt();
        int[] parametros = {parametroUm, parametroDois};
        return parametros;
    }
}
