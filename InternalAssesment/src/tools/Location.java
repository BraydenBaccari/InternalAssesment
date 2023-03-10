/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import tools.Constants;

/**
 *
 * @author b.baccari
 */
public class Location {

    Constants con = new Constants();

    /**
     *
     * @param rowNum what row the label is in
     * @param columnNum what column the label is in
     * @return what the number of the label is
     */
    public int getLabelNum(int x, int y) {
        int labelNum = 0;

        if (y == 0) {
            return x;
        } else {
            labelNum = 30 * y;
            labelNum += x;
            return labelNum;
        }

    }

    /**
     *
     * @param labelNum the label number
     * @return returns the position of the label(int terms of x and y)
     */
    public int[] getCoords(int labelNum) {
        int[] coords = new int[2];
        int x = 0;
        int y = 0;
        if (labelNum <= 30) {
            x = labelNum;
            y = 0;
            coords[0] = x;
            coords[1] = y;
            return coords;
        } else {
            while (labelNum >= 30) {
                labelNum -= 30;
                y++;
            }
            x = labelNum;
            coords[0] = x;
            coords[1] = y;
            return coords;
        }

    }
}
