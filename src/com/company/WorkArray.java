package com.company;

public class WorkArray {
    public static char[][] copyArray(char[][] mass){
        char[][] response = new char[mass.length][mass[0].length];

        for(int x = 0; x < mass.length; x++)
            for(int y = 0; y < mass[x].length; y++)
                response[x][y] = mass[x][y];

        return response;
    }

    public static boolean checkEmpty(char element) {
        return element != '#' && element != '*' && element != 's';
    }

    public static void checkFinish(char element, char[][] mass) {
        if (element == 'f')
            Display.printData(mass);
    }

    public static int[] findStart(char[][] mass) throws Exception {

        for (int y = 0; y < mass.length; y++) {
            for (int x = 0; x < mass[y].length; x++) {
                if (mass[y][x] == 's')
                    return new int[]{x, y};
            }
        }
        throw new Exception("Нет начальной координаты!");
    }

    public static int[] findEnd(char[][] mass) throws Exception {

        for (int y = 0; y < mass.length; y++) {
            for (int x = 0; x < mass[y].length; x++) {
                if (mass[y][x] == 'f')
                    return new int[]{x, y};
            }
        }
        throw new Exception("Нет конечной координаты!");
    }
}
