/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

/**
 *
 * @author b.baccari
 */
public class Mover {
    Constants con = new Constants();
    Location location = new Location();

    public int left(int x, int y) {
        if(x == 0) return location.getLabelNum(x, y);
        else{
            x--;
            return location.getLabelNum(x, y);
        }
    }

    public int right(int x, int y) {
        if(x == 0) return location.getLabelNum(x, y);
        else{
            x++;
            return location.getLabelNum(x, y);
        }
    }

    public int down(int x, int y) {
        if (y == 0) return location.getLabelNum(x, y);
        else if(y == con.ROWS -2){
            return location.getLabelNum(x, y);
        }
        else {
            y++;
            return location.getLabelNum(x, y);

        }
    }
}
