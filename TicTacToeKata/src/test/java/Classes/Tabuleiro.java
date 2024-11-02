package Classes;

//criando o tabuleiro
public class Tabuleiro {
    static String[][] tabuleiro = new String[3][3];
    static boolean isXPlaying = true;


    //criando jogadas alternadas entre jogadores
    public static void insert(int linha, int coluna) {
        tabuleiro[linha][coluna] = isXPlaying ? "X" : "O";
        isXPlaying = !isXPlaying;
        System.out.print(tabuleiro[linha][coluna]);
    }

    //insere apenas se posicao vazia
    public boolean insert(int linha, int coluna, String jogador) {
        if (linha < 0 || coluna < 0 || linha >= 3 || coluna >= 3) {
            throw new IllegalArgumentException("Posição invalida");
        }
        if (tabuleiro[linha][coluna] == null) {
            tabuleiro[linha][coluna] = jogador;
            return true;
        }
        return false;
    }

    //retorna posicao indicada
    public String getPosition(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    //Verifica se há um vencedor
    public String checkWinner() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] != null && tabuleiro[i][0].equals(tabuleiro[i][1]) && tabuleiro[i][0].equals(tabuleiro[i][2])) {
                return tabuleiro[i][0]; //Vencedor na linha
            }
            if (tabuleiro[0][i] != null && tabuleiro[0][i].equals(tabuleiro[1][i]) && tabuleiro[0][i].equals(tabuleiro[2][i])) {
                return tabuleiro[0][i]; //vencedor na coluna
            }
            if (tabuleiro[0][0] != null && tabuleiro[0][0].equals(tabuleiro[1][1]) && tabuleiro[0][0].equals(tabuleiro[2][2])) {
                return tabuleiro[0][0]; //Vencedor na diagonal
            }
            if (tabuleiro[0][2] != null && tabuleiro[0][2].equals(tabuleiro[1][1]) && tabuleiro[0][2].equals(tabuleiro[2][0])) {
                return tabuleiro[0][2]; //Vencedor na diagonal inversa
            }
        }
        return null;
    }

    //Verifica se o tabuleiro está cheio
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }
}
