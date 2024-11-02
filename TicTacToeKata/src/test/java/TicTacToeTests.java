import Classes.Tabuleiro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTests {
    Scanner sc = new Scanner(System.in);

    @Test
    @DisplayName("Teste De Tabuleiro")
    public void tabuleiroTest() {
        String[][] tabuleiro = new String[3][3];
    }

    @Test
    @DisplayName("Teste de inserir posiçao 1")
    public void InserirPosicao1Test() {
        Tabuleiro.insert(0, 0); //jogada X
        Tabuleiro.insert(1, 0); //jogada O
    }


    @Test
    @DisplayName("Teste de inserir posiçao 1 e 2")
    public void InserirPosicao2Test() {
        Tabuleiro.insert(0, 1); //jogada X
        Tabuleiro.insert(1, 2); //jogada O
    }

    @Test
    @DisplayName("Teste de de fileira")
    public void fileiraTest() {
        for (int i = 0; i < 3; i++) {
            Tabuleiro.insert(0, i);
        }
    }

    @Test
    @DisplayName("Teste de inserir todas posiçoes")
    public void InserirPosicaoTodasTest() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tabuleiro.insert(i, j);
            }
        }
    }

    @Test
    @DisplayName("Verifica se existe jogador na posição dada")
    public void ExistePosicaoTest() {
        Tabuleiro tabuleiro = new Tabuleiro();
        Tabuleiro.insert(0, 0);
        Tabuleiro.insert(1, 0);
        //imprime valor na posiçao (1,0)
        String valorPosicao = tabuleiro.getPosition(1, 0);
        System.out.println("\nValor na posição (1,0): " + valorPosicao);
        //imprime valor na posicao (0,0)
        String valorPosicao2 = tabuleiro.getPosition(2, 0);
        System.out.println("\nValor na posição (2,0): " + valorPosicao2);
    }

    @Test
    @DisplayName("Teste de Inserção de Jogada")
    public void testInsert() {
        Tabuleiro tabuleiro = new Tabuleiro();
        assertTrue(tabuleiro.insert(0, 0, "X"), "Deve permitir inserção em posição vazia");
        assertEquals("X", tabuleiro.getPosition(0, 0), "O valor na posição (0,0) deve ser X");

        assertFalse(tabuleiro.insert(0, 0, "O"), "Não deve permitir sobreposição");
        assertEquals("X", tabuleiro.getPosition(0, 0), "A posição (0,0) ainda deve ser X");
    }

    @Test
    @DisplayName("Teste de Verificação de vencedor - linhas")
    public void testCheckWinnerRows() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.insert(0, 0, "X");
        tabuleiro.insert(0, 1, "X");
        tabuleiro.insert(0, 2, "X");
        assertEquals("X", tabuleiro.checkWinner(), "X deve ser vencedor na linha 0");
    }

    @Test
    @DisplayName("Teste de Verificação de vencedor - colunas")
    public void testCheckWinnerCols() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.insert(0, 0, "X");
        tabuleiro.insert(1, 0, "X");
        tabuleiro.insert(2, 0, "X");
        assertEquals("X", tabuleiro.checkWinner(), "X deve ser vencedor na coluna 0");
    }
    @Test
    @DisplayName("Teste de Verificação de vencedor - Diagonal")
    public void testCheckWinnerDiagonal() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.insert(0, 0, "X");
        tabuleiro.insert(1, 1, "X");
        tabuleiro.insert(2, 2, "X");
        assertEquals("X", tabuleiro.checkWinner(), "X deve ser vencedor na Diagonal");
    }
    @Test
    @DisplayName("Teste de Verificação de vencedor - Diagonal inversa")
    public void testCheckWinnerInversa() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.insert(0, 2, "X");
        tabuleiro.insert(1, 1, "X");
        tabuleiro.insert(2, 0, "X");
        assertEquals("X", tabuleiro.checkWinner(), "X deve ser vencedor na Diagonal inversa");
    }
    @Test
    @DisplayName("Teste de tabuleiro cheio")
    public void isFull(){
        Tabuleiro tabuleiro = new Tabuleiro();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro.insert(i, j, "X");
            }
        }
        assertTrue(tabuleiro.isFull(), "O tabuleiro deve estar cheio");
    }
    @Test
    @DisplayName("Teste de Empate (Tabuleiro Cheio sem Vencedor)")
    public void testDraw() {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.insert(0, 0, "X");
        tabuleiro.insert(0, 1, "O");
        tabuleiro.insert(0, 2, "X");
        tabuleiro.insert(1, 0, "O");
        tabuleiro.insert(1, 1, "X");
        tabuleiro.insert(1, 2, "O");
        tabuleiro.insert(2, 0, "O");
        tabuleiro.insert(2, 1, "X");
        tabuleiro.insert(2, 2, "O");

        assertTrue(tabuleiro.isFull(), "O tabuleiro deve estar cheio");
        assertNull(tabuleiro.checkWinner(), "Não deve haver vencedor em caso de empate");
    }
}
