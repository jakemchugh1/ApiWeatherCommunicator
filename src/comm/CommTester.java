package comm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CommTester {

    public static String[] weatherData;
    public static Comm comm;
    public static JLabel question, d1, d2, d3, d4, d5, d6, d7, d8, d9, saved;

    public static void main(String Args[])
            throws IOException{
        weatherWindow();
        System.out.println("Test Complete!");
    }
    private static void weatherWindow()
                throws IOException{
            Comm comm;

            JButton button = new JButton("Enter");
            JTextField text = new JTextField();

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(6,2));

            question = new JLabel("What City do you want the weather for?");
            d1 = new JLabel("");
            d2 = new JLabel("");
            d3 = new JLabel("");
            d4 = new JLabel("");
            d5 = new JLabel("");
            d6 = new JLabel("");
            d7 = new JLabel("");
            d8 = new JLabel("");
            d9 = new JLabel("");
            saved = new JLabel("");

            panel.add(question);
            panel.add(d1);
            panel.add(text);
            panel.add(d2);
            panel.add(button);
            panel.add(d3);
            panel.add(d4);
            panel.add(d5);
            panel.add(d6);
            panel.add(d7);
            panel.add(d8);
            panel.add(d9);


            JFrame frame = new JFrame("Jacob's Weather App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setSize(500,500);
            frame.add(panel);

            //comm = new Comm("Seattle");
           // weatherData = comm.accessData();

            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    String city = text.getText();
                    try{
                        collect(city);
                    }catch(IOException comm){

                    }
                }
            });



    }
    public static void collect(String city) throws IOException{
        comm = new Comm(city);
        weatherData = comm.accessData();
        d1.setText(weatherData[27]);
        d2.setText(weatherData[24]);
        d3.setText(weatherData[3]);
        d4.setText(weatherData[7]);
        System.out.println(weatherData[7]);
    }
}
