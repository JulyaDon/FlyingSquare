package sample;

import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public Canvas canvasC;

    GraphicsContext gs;// = canvasC.getGraphicsContext2D();

    Rectangle r = new Rectangle(0,0,30,30);
    int n = 1;
    int k = 1;

    Timer timer = new Timer(5, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // move rectangle here

            //try {
                gs.clearRect(0, 0, canvasC.getWidth(), canvasC.getWidth());
            //}
            //catch (Exception ex){

            //}
            gs.setFill(Color.BLACK);
            r.setLocation((int)r.getX()+1 * n, (int)r.getY()+1 * k);
            gs.fillRect(r.getX(),r.getY(),r.getWidth(),r.getHeight());
            if (r.getX()+30 >= canvasC.getWidth() || r.getX() < 0){
                //r.setLocation((int)r.getX()-1, (int)r.getY());
                //gs.fillRect(r.getX(),r.getY(),r.getWidth(),r.getHeight());
                n = n * -1;
            }

            if( r.getY()+30 >= canvasC.getHeight() || r.getY() < 0){
                k = k * -1;
            }

        }
    });

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //System.out.println("ha-ha");
        gs = canvasC.getGraphicsContext2D();

        timer.start();
    }
}

