import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ColourCode
{
    private Random r = new Random();
    private int[] ans = new int[4];
    private int[] myplayerans = new int[4];
    private JLabel emptyLabel_2[] = new JLabel[4];
    private int colour;
    private int order;
    private int black = 0;
    private int white = 0;
    
    //prints out random number representing the coloured buttons
    public void randomNum()
    {
        for (int i=0; i<4; i++)
        {
            int r_int = r.nextInt(7);
            ans[i] = r_int;
            System.out.println(r_int);
        }
    }

    //scans and prints out player's input
    public void playerans(int a,int i)
    {
        colour = a;
        order = i;
        myplayerans[order] = colour;
        System.out.printf("\n%d ",myplayerans[order]);
    }
    
    public int blackLabel()//prints out black label when the order and colour of player's input are correct
    {
        black = 0; //makes surethe black label returns back to zero for every trial

        for (int i =0; i<4; i++)
        {
            if (myplayerans[i] == ans[i])
            {
                black++;
            }
        }
        System.out.printf("\nBlack : %d", black);
        return black;
    }

    public int whiteLabel()//prints out white labels when the colour of player's input is correct but accurate order
    {
        white = 0; //makes surethe black label returns back to zero for every trial

            if(myplayerans[0]==ans[1] || myplayerans[0]==ans[2] || myplayerans[0]==ans[3])
            {
                white = white+1;
            }

            if(myplayerans[1]==ans[0] || myplayerans[1]==ans[2] || myplayerans[1]==ans[3])
            {
                white = white+1;
            }

            if(myplayerans[2]==ans[0] || myplayerans[2]==ans[1] || myplayerans[2]==ans[3])
            {
                white = white+1;
            }

            if(myplayerans[3]==ans[0] || myplayerans[3]==ans[1] || myplayerans[3]==ans[2])
            {
                white = white+1;
            }
        System.out.printf("\nWhite : %d", white);
        return white;  
    }

    //exit once the player wins
    public void exit()
    {
        boolean isEqual = true;
        {
            for (int i=0; i<myplayerans.length; i++)
            {
                if(myplayerans[i] != ans[i])
                {
                    isEqual = false;
                    break;
                }
            }
        }
        if (isEqual)
            {
                System.out.println("\nCongratulations, you've won!!");
                System.exit(0);
            }
    }
}



