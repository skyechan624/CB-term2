import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mainGame implements ActionListener
{
    Picture red = new Picture("icons/Colour_0.png");
    Picture orange = new Picture("icons/Colour_1.png");
    Picture yellow = new Picture("icons/Colour_2.png");
    Picture green = new Picture("icons/Colour_3.png");
    Picture blue = new Picture("icons/Colour_4.png");
    Picture indigo = new Picture("icons/Colour_5.png");
    Picture violet = new Picture("icons/Colour_6.png");
    Picture Score_0 = new Picture("icons/Score_0.png");
    Picture Score_1 = new Picture("icons/Score_1.png");
    private JFrame colourBreaker = new JFrame("Colour Breaker!");
    private JPanel colourPanel;
    private JPanel bigPanel = new JPanel();
    private JButton redButton = new JButton(red);
    private JButton orangeButton = new JButton(orange);
    private JButton yellowButton = new JButton(yellow);
    private JButton greenButton = new JButton(green);
    private JButton blueButton = new JButton(blue);
    private JButton indigoButton = new JButton(indigo);
    private JButton violetButton = new JButton(violet);
    private ColourCode myColourCode = new ColourCode();
    private guess myGuess = new guess();
    private guess row[] = new guess[6]; 
    private int j=5;
    private int i=0;
    
    
    public mainGame()
    {   
        //setting a panel called "colourPanel" for the buttons
        colourPanel = new JPanel();
        colourPanel.setLayout(new GridLayout(1,7));

        //adding the buttons into the panel
        colourPanel.add(redButton);
        colourPanel.add(orangeButton);   
        colourPanel.add(yellowButton);    
        colourPanel.add(greenButton);    
        colourPanel.add(blueButton);    
        colourPanel.add(indigoButton);     
        colourPanel.add(violetButton);

        redButton.addActionListener(this);
        orangeButton.addActionListener(this);
        yellowButton.addActionListener(this);
        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        indigoButton.addActionListener(this);
        violetButton.addActionListener(this);
        
        //setting a panel called "bigPanel" containing the panels for the empty labels and the buttons
        bigPanel.setLayout(new GridLayout(7,1));
        
        //loop the row six times
        for (int i=0; i<6; i++)
        {
            guess a = new guess();
            row[i] = a;   
            bigPanel.add(row[i].getPanel());
        }
        
        //add colourPanel into the bigPanel
        bigPanel.add(colourPanel);
        colourBreaker.setSize(550,600);
        colourBreaker.setContentPane(bigPanel);
        colourBreaker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        colourBreaker.setVisible(true);

        //print out model answer
        myColourCode.randomNum();
    }

    //change to next empty when button is pressed
    public void actionPerformed(ActionEvent e)
    {  
        if(e.getSource()==redButton)
        {
            
            row[j].getEmptyLabel()[i].setIcon(red);
            myColourCode.playerans(0, i);
            i++;
        }
    
        else if(e.getSource()==orangeButton)
        {
            row[j].getEmptyLabel()[i].setIcon(orange);
            myColourCode.playerans(1, i);
            i++;
        }

        else if(e.getSource()==yellowButton)
        {
            row[j].getEmptyLabel()[i].setIcon(yellow);
            myColourCode.playerans(2, i);
            i++;
        }

        else if(e.getSource()==greenButton)
        {
            row[j].getEmptyLabel()[i].setIcon(green);
            myColourCode.playerans(3,i);
            i++;
        }

        else if(e.getSource()==blueButton)
        {
            row[j].getEmptyLabel()[i].setIcon(blue);
            myColourCode.playerans(4,i);
            i++;
        }

        else if(e.getSource()==indigoButton)
        {
            row[j].getEmptyLabel()[i].setIcon(indigo);
            myColourCode.playerans(5, i);
            i++;
        }

        else if(e.getSource()==violetButton)
        {
            row[j].getEmptyLabel()[i].setIcon(violet);
            myColourCode.playerans(6, i);
            i++;
        }

        if(i==4)
        {
            int black = myColourCode.blackLabel();
            int white = myColourCode.whiteLabel();
            row[j].Scoring(black, white);
            i=0;
            j--;

            myColourCode.exit();
        }
    }
}
    