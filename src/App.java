import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) throws IOException {
        LRUCache<Integer> cache = new LRUCache<>(3);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int aux = 1;

        while (aux != 0) {
            System.out.println("1: Adicionar Chave e Valor\n2: Buscar Valor pela Chave\n0: Parar execução");
            aux = Integer.parseInt(br.readLine());
            String key;

            int value;

            switch (aux) {
                case 1:
                    System.out.println("Digite a chave [APENAS NÚMEROS]");
                    key = br.readLine();

                    System.out.println("Digite o valor");
                    value = Integer.parseInt(br.readLine());

                    cache.put(key, value);
                    break;

                case 2:
                    System.out.println("Digite a chave [APENAS NÚMEROS]");

                    key = br.readLine();

                    System.out.println("O valor é: " + cache.get(key).toString() + "\n");

            }
        }
    }

}
