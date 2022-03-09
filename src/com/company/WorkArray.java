package com.company;

public class WorkArray {
    public static char[][] copyArray(char[][] mass){
        char[][] response = new char[mass.length][mass[0].length];

        for(int x = 0; x < mass.length; x++)
            for(int y = 0; y < mass[x].length; y++)
                response[x][y] = mass[x][y];

        return response;
    }
}
