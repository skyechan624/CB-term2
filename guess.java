import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guess 
{
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel panel;
    private JLabel emptyLabel[] = new JLabel[4];
    private JLabel emptyLabel_2[] = new JLabel[4];
    private ColourCode myColourCode = new ColourCode();
    private int black;
    private int white;
    Picture p = new Picture("icons/Empty.png");
    Picture Score_0 = new Picture("icons/Score_0.png");
    Picture Score_1 = new Picture("icons/Score_1.png");

    public guess()
    {
        //empty labels on the left
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(1,4));
        
        for (int a=0; a<4; a++)
        {
            emptyLabel[a] = new JLabel(p);
            leftPanel.add(emptyLabel[a]);
        }

        //empty labels on the right
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(2,2));

        for (int a=0; a<4; a++)
        {
            emptyLabel_2[a] = new JLabel(p);
            rightPanel.add(emptyLabel_2[a]);
        }

        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add("West", leftPanel);
        panel.add("East", rightPanel);
    } 

    public void Scoring(int black, int white)
    {
        this.black = black; 
        this.white = white;
        int i;
        int j; //j equals to the frequency of white
        
        for (i=0; i<4; i++)
            {
                
                if(black>0) //if there are correct inputs
                {
                    emptyLabel_2[i].setIcon(Score_0); //show black labels
                    black--;
                }

                else if(white>0)
                {
                    emptyLabel_2[i].setIcon(Score_1);
                    white--;
                }
            }
        
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public JLabel[] getEmptyLabel()
    {
        return emptyLabel;
    }
}
