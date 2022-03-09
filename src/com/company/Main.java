package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        char[][] mass = new char[][]{
                {'#', 's', '#', '#', '#'},
                {'#', '.', '.', '.', '#'},
                {'.', '.', '#', '.', '#'},
                {'.', '#', '.', '.', '#'},
                {'#', '#', '#', '.', 'f'}
        };

        int[] startСoordinate = findStart(mass);
        int[] endСoordinate = findEnd(mass);

        findWay(mass, startСoordinate);


    }

    private static int[] findStart(char[][] mass) throws Exception {

        for (int y = 0; y < mass.length; y++) {
            for (int x = 0; x < mass[y].length; x++) {
                if (mass[y][x] == 's')
                    return new int[]{x, y};
            }
        }
        throw new Exception("Нет начальной координаты!");
    }

    private static int[] findEnd(char[][] mass) throws Exception {

        for (int y = 0; y < mass.length; y++) {
            for (int x = 0; x < mass[y].length; x++) {
                if (mass[y][x] == 'f')
                    return new int[]{x, y};
            }
        }
        throw new Exception("Нет конечной координаты!");
    }

    public static void findWay(char[][] mass, int[] startPos) {

        if ((startPos[1] != 0) && (mass[startPos[1] - 1][startPos[0]] != '#' && mass[startPos[1] - 1][startPos[0]] != '*' && mass[startPos[1] - 1][startPos[0]] != 's')) { // можно ли пойти вверх
            char[][] tempMass = WorkArray.copyArray(mass);

            if (tempMass[startPos[1] - 1][startPos[0]] == 'f')
                Display.printData(mass);

            tempMass[startPos[1] - 1][startPos[0]] = '*';
            findWay(tempMass, new int[]{startPos[0], startPos[1] - 1});
        }
        if ((startPos[0] != 0) && (mass[startPos[1]][startPos[0] - 1] != '#' && mass[startPos[1]][startPos[0] - 1] != '*' && mass[startPos[1]][startPos[0] - 1] != 's')) { // можно ли пойти влево
            char[][] tempMass = WorkArray.copyArray(mass);

            if (tempMass[startPos[1]][startPos[0] - 1] == 'f')
                Display.printData(mass);

            tempMass[startPos[1]][startPos[0] - 1] = '*';
            findWay(tempMass, new int[]{startPos[0] - 1, startPos[1]});
        }
        if ((startPos[1] != mass.length - 1) && (mass[startPos[1] + 1][startPos[0]] != '#' && mass[startPos[1] + 1][startPos[0]] != '*' && mass[startPos[1] + 1][startPos[0]] != 's')) { // можно ли пойти вниз
            char[][] tempMass = WorkArray.copyArray(mass);

            if (tempMass[startPos[1] + 1][startPos[0]] == 'f')
                Display.printData(mass);

            tempMass[startPos[1] + 1][startPos[0]] = '*';
            findWay(tempMass, new int[]{startPos[0], startPos[1] + 1});
        }
        if ((startPos[0] != mass[0].length - 1) && (mass[startPos[1]][startPos[0] + 1] != '#' && mass[startPos[1]][startPos[0] + 1] != '*' && mass[startPos[1]][startPos[0] + 1] != 's')) { // можно ли пойти вправо
            char[][] tempMass = WorkArray.copyArray(mass);

            if (tempMass[startPos[1]][startPos[0] + 1] == 'f')
                Display.printData(mass);

            tempMass[startPos[1]][startPos[0] + 1] = '*';
            findWay(tempMass, new int[]{startPos[0] + 1, startPos[1]});
        }
    }

}
