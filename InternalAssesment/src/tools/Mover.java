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
    Location location = new Location();
    public int left(int x, int y) {
        
        x--;
        return location.getLabelNum(x, y);
    }

    public int right(int x, int y) {
         x++;
        return location.getLabelNum(x, y);
        
    }
    public int down(int x, int y){
     y++;
     return location.getLabelNum(x, y);
    }
}
