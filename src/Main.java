import java.io.IOException;
import java.util.*;
import static java.lang.System.exit;
/**
 *Programa para decifrar textos por substituição "ZENIT POLAR"
 *
 * @author Bruno Oliveira
 */
public class Main {
    /**
     * A entrada começa com dois inteiros c e n.
     * C é o tamanho da cifra.
     * Nas próximas duas linhas a cifra de tamanho c
     * indica quais caracteres da primeira linha serão substituídos
     * por caracteres da segunda linha, um caractere aparece apenas uma vez,
     * na primeira ou na segunda linha.
     * N defini quantidade de linhas
     *
     * EXEMPLO:
     * 5 1
     * ZENIT
     * POLAR
     * Osro roxre osri caftide
     *
     * SAÍDA:
     * Este texto esta cifrado
     */
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        try {
            while (true) {
                String[] inteiro = scan.nextLine().split(" ");
                int c = Integer.parseInt(inteiro[0]);
                int n = Integer.parseInt(inteiro[1]);

                // Declarações de variaveis
                ArrayList<String[]> fraseCripto = new ArrayList<String[]>();
                String[] fraseDescifrada = new String[n];
                String[] cifraA = new String[c];
                String[] cifraB = new String[c];
                int cont = 0;
                int aux = 0;

                cifraA = scan.nextLine().split("");
                cifraB = scan.nextLine().split("");

                // entrada das frases criptografadas divida por caracteres
                while (n > cont) {
                    String[] linha = scan.nextLine().split("");
                    fraseCripto.add(linha);
                    cont++;
                }

                // descifrando
                Iterator<String[]> it = fraseCripto.iterator();
                while (it.hasNext()) {
                    String[] i = it.next();

                    for (int j = 0; j < i.length; j++) {
                        for (int k = 0; k < cifraA.length; k++) {

                            //bloco de comparação do cifraA
                            if (i[j].equalsIgnoreCase(cifraA[k])) {
                                if (fraseDescifrada[aux] == null) {
                                    if(Character.isUpperCase(i[j].charAt(0))){
                                        fraseDescifrada[aux] = cifraB[k].toUpperCase();
                                    } else{
                                        if(Character.isUpperCase(i[j].charAt(0))) {
                                            fraseDescifrada[aux] = cifraB[k].toLowerCase();
                                        }
                                    }
                                } else {
                                    if(Character.isUpperCase(i[j].charAt(0))) {
                                        fraseDescifrada[aux] += cifraB[k].toUpperCase();
                                    }else{
                                        fraseDescifrada[aux] += cifraB[k].toLowerCase();
                                    }

                                }
                                break;

                                //bloco de comparação do cifraB
                            } else if (i[j].equalsIgnoreCase(cifraB[k])) {
                                if (fraseDescifrada[aux] == null) {
                                    if(Character.isUpperCase(i[j].charAt(0))) {
                                        fraseDescifrada[aux] = cifraA[k].toUpperCase();
                                    } else{
                                        fraseDescifrada[aux] = cifraA[k].toLowerCase();
                                    }

                                } else {
                                    if(Character.isUpperCase(i[j].charAt(0))) {
                                        fraseDescifrada[aux] += cifraA[k].toUpperCase();
                                    }else{
                                        fraseDescifrada[aux] += cifraA[k].toLowerCase();
                                    }
                                }
                                break;


                            } else if (k == cifraA.length - 1) {
                                if (fraseDescifrada[aux] == null) {
                                    if(Character.isUpperCase(i[j].charAt(0))) {
                                        fraseDescifrada[aux] = i[j].toUpperCase();
                                    }else{
                                        fraseDescifrada[aux] = i[j].toLowerCase();
                                    }

                                } else {
                                    if(Character.isUpperCase(i[j].charAt(0))) {
                                        fraseDescifrada[aux] += i[j].toUpperCase();
                                    }
                                    else{
                                        fraseDescifrada[aux] += i[j].toLowerCase();
                                    }
                                }
                                break;
                            }
                        }

                    }
                    aux++;
                }
                // Saida
                for (int i = 0; i < fraseDescifrada.length; i++) {
                    System.out.printf("%s\n",fraseDescifrada[i]);
                }
            }
        } finally {
            scan.close();
            exit(0);
        }
    }
}
