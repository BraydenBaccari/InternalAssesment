/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

/**
 *
 * @author b.baccari
 */
public class Constants {
    public final int WIDTH = 596;
    public final int LENGTH = 800;
    public final int BLOCK_SIZE = 20;
    public final int COLUMNS = (WIDTH / BLOCK_SIZE) -1;
    public final int ROWS = (LENGTH / BLOCK_SIZE) - 2;
    public final int TOTAL = (LENGTH / BLOCK_SIZE) * (WIDTH / BLOCK_SIZE);
}
