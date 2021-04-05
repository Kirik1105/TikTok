import java.util.Random;
import java.util.Scanner;

public class TikTok {
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static int MAX = 3;
    public static char[][] map = new char[MAX][MAX];

    public static void DrawMap(char[][] map) {
        for (int y = 0; y < MAX; y++) {
            for (int x = 0; x < MAX; x++) {
                System.out.print("[" + map[x][y] + "] ");
            }
            System.out.println();
        }
    }

    public static boolean isCellFree(int x, int y) {
        if (x < 0 || x >= MAX || y < 0 || y >= MAX) return false;
        if (map[x][y] == 'X'||map[x][y] == 'O') return true;
        if (map[x][y] == ' ') return true;
        return false;
    }


    public static void HumanChoice(char[][] map) {
        int x;
        int y;
        do {
            System.out.println("Введите кординаты:");
            x = sc.nextInt()-1;
            y = sc.nextInt()-1;
        } while (isCellFree(x, y));
        map[x][y] = 'X';

    }

    public static void AIChoise(char[][] map) {
        int x;
        int y;
        do {

            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (isCellFree(x, y));
        map[x][y] = 'O';

    }

    private static boolean checkWin(char[][] map) {
        return checkWinnerHorizontal(map) ||
                checkWinnerVertical(map) ||
                checkWinnerDiagonals(map);
    }

    private static boolean checkWinnerHorizontal(char[][] map) {
        return map[0][0]==map[1][0] && map[0][0]==map[2][0] ||
                map[0][1]==map[1][1] && map[0][1]==map[2][1] ||
                map[0][2]==map[1][2] && map[0][2]==map[2][2];
    }

    private static boolean checkWinnerVertical(char[][] map) {
        return map[0][0]==map[0][1] && map[0][0]==map[0][2] ||
        map[1][0]==map[1][1] && map[1][0]==map[1][2] ||
                map[2][0]==map[2][1] && map[2][0]==map[2][2];
    }

    private static boolean checkWinnerDiagonals(char[][] map) {
        return map[0][0]==map[1][1] && map[0][0]==map[2][2] ||
                map[2][0]==map[1][1] && map[2][0]==map[0][2];
    }


    public static void main(String[] args) {
        DrawMap(map);
        do {

            HumanChoice(map);
            AIChoise(map);
            DrawMap(map);

        } while (checkWin(map));


    }
}