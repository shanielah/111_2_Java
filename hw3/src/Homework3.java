import java.util.*;

public class Homework3 {

    public static boolean checkType8(int[][] playerCards) {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j <= 9; j++)
            {
                int sum = 0;
                for (int k = 0; k < 5; k++)
                {
                    sum += playerCards[i][(j + k) % 13];
                }
                if (sum == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkType7(int[][] playerCards) {
        for (int i = 0; i < 13; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += playerCards[j][i];
            }
            if (sum == 4) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkType6(int[][] playerCards) {
        int threeCount = 0;
        int twoCount = 0;

        for (int i = 0; i < 13; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += playerCards[j][i];
            }

            if (sum >= 3) {
                threeCount++;
            }
            if (sum >= 2) {
                twoCount++;
            }
        }

        if (threeCount >= 1 && twoCount >= 2) {
            return true;
        }
        return false;

    }

    public static boolean checkType5(int[][] playerCards) {
        for (int i = 0; i < 4; i++) {
            int sum = 0;
            for (int j = 0; j < 13; j++) {
                sum += playerCards[i][j];
            }
            if (sum >= 5) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkType4(int[][] playerCards) {
        int[] cardCount = new int[13];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                if (playerCards[i][j] == 1) {
                    cardCount[j] = 1;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                sum += cardCount[(i + j) % 13];
            }
            if (sum == 5) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkType3(int[][] playerCards) {
        for (int i = 0; i < 13; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += playerCards[j][i];
            }
            if (sum >= 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkType2(int[][] playerCards) {
        int pairCount = 0;
        for (int i = 0; i < 13; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += playerCards[j][i];
            }
            if (sum >= 2) {
                pairCount++;
            }
        }

        if (pairCount >= 2) {
            return true;
        }
        return false;
    }

    public static boolean checkType1(int[][] playerCards) {
        for (int i = 0; i < 13; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += playerCards[j][i];
            }
            if (sum >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int[][] cards = new int[4][13];

        for (int i = 0; i < 5; i++) {
            String input = scanner.next();

            int suit = 0;
            int value = 0;

            if (input.length() == 3) {
                value = input.charAt(1) - '0' + 10;
                if (input.charAt(2) == 'C') {
                    suit = 0;
                } else if (input.charAt(2) == 'D') {
                    suit = 1;
                } else if (input.charAt(2) == 'H') {
                    suit = 2;
                } else if (input.charAt(2) == 'S') {
                    suit = 3;
                }
                cards[suit][value - 1] = 1;
            } else {
                value = input.charAt(0) - '0';
                if (input.charAt(1) == 'C') {
                    suit = 0;
                } else if (input.charAt(1) == 'D') {
                    suit = 1;
                } else if (input.charAt(1) == 'H') {
                    suit = 2;
                } else if (input.charAt(1) == 'S') {
                    suit = 3;
                }
                cards[suit][value - 1] = 1;
            }

        }

        for (int i = 0; i < 6; i++) {
            int[][] playerCards = new int[4][13];

            for (int j = 0; j < 4; j++) // copy
            {
                for (int k = 0; k < 13; k++) {
                    playerCards[j][k] = cards[j][k];
                }
            }

            for (int j = 0; j < 2; j++) {
                String input = scanner.next();

                int suit = 0;
                int value = 0;

                if (input.length() == 3) {
                    value = input.charAt(1) - '0' + 10;
                    if (input.charAt(2) == 'C') {
                        suit = 0;
                    } else if (input.charAt(2) == 'D') {
                        suit = 1;
                    } else if (input.charAt(2) == 'H') {
                        suit = 2;
                    } else if (input.charAt(2) == 'S') {
                        suit = 3;
                    }
                    playerCards[suit][value - 1] = 1;
                } else {
                    value = input.charAt(0) - '0';
                    if (input.charAt(1) == 'C') {
                        suit = 0;
                    } else if (input.charAt(1) == 'D') {
                        suit = 1;
                    } else if (input.charAt(1) == 'H') {
                        suit = 2;
                    } else if (input.charAt(1) == 'S') {
                        suit = 3;
                    }
                    playerCards[suit][value - 1] = 1;
                }
            }

            if (checkType8(playerCards) == true) {
                System.out.println(8);
            } else if (checkType7(playerCards) == true) {
                System.out.println(7);
            } else if (checkType6(playerCards) == true) {
                System.out.println(6);
            } else if (checkType5(playerCards) == true) {
                System.out.println(5);
            } else if (checkType4(playerCards) == true) {
                System.out.println(4);
            } else if (checkType3(playerCards) == true) {
                System.out.println(3);
            } else if (checkType2(playerCards) == true) {
                System.out.println(2);
            } else if (checkType1(playerCards) == true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }

    }
}