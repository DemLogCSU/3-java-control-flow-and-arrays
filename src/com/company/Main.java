package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        char[][] mass = new char[][]{
                {'#', 's', '#', '#', '#'},
                {'#', '#', '#', '.', '#'},
                {'.', '.', '.', '.', '#'},
                {'.', '#', '.', '.', '#'},
                {'#', '#', '#', '.', 'f'}
        };

        int[] startСoordinate = WorkArray.findStart(mass);
        // int[] endСoordinate = WorkArray.findEnd(mass);

        findWay(mass, startСoordinate);

    }

    public static void findWay(char[][] mass, int[] startPos) { // ТРЕБУЕТСЯ РЕФАКТОРИНГ

        if ((startPos[1] != 0) && WorkArray.checkEmpty(mass[startPos[1] - 1][startPos[0]])) { // можно ли пойти вверх
            char[][] tempMass = WorkArray.copyArray(mass);
            WorkArray.checkFinish(tempMass[startPos[1] - 1][startPos[0]], mass);
            tempMass[startPos[1] - 1][startPos[0]] = '*';
            findWay(tempMass, new int[]{startPos[0], startPos[1] - 1});
        }
        if ((startPos[0] != 0) && WorkArray.checkEmpty(mass[startPos[1]][startPos[0] - 1])) { // можно ли пойти влево
            char[][] tempMass = WorkArray.copyArray(mass);
            WorkArray.checkFinish(tempMass[startPos[1]][startPos[0] - 1], mass);
            tempMass[startPos[1]][startPos[0] - 1] = '*';
            findWay(tempMass, new int[]{startPos[0] - 1, startPos[1]});
        }
        if ((startPos[1] != mass.length - 1) &&  WorkArray.checkEmpty(mass[startPos[1] + 1][startPos[0]])) { // можно ли пойти вниз
            char[][] tempMass = WorkArray.copyArray(mass);
            WorkArray.checkFinish(tempMass[startPos[1] + 1][startPos[0]], mass);
            tempMass[startPos[1] + 1][startPos[0]] = '*';
            findWay(tempMass, new int[]{startPos[0], startPos[1] + 1});
        }
        if ((startPos[0] != mass[0].length - 1) && WorkArray.checkEmpty(mass[startPos[1]][startPos[0] + 1])) { // можно ли пойти вправо
            char[][] tempMass = WorkArray.copyArray(mass);
            WorkArray.checkFinish(tempMass[startPos[1]][startPos[0] + 1], mass);
            tempMass[startPos[1]][startPos[0] + 1] = '*';
            findWay(tempMass, new int[]{startPos[0] + 1, startPos[1]});
        }
    }

}
