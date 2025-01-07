package main;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
public class Main {
    public static void main(String[] args){
        
        String currentWorkingDirectory = System.getProperty("user.dir");
        System.out.println("Current Working Directory (PWD): " + currentWorkingDirectory);
        
        //Graphics area
        JFrame frame = new JFrame("Swing Example");
        frame.setSize(415, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel
        JPanel ChessBoard = new Board();
        frame.add(ChessBoard);
        // Show the frame
        frame.setVisible(true);
    }
}
