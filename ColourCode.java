import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ColourCode
{
    private Random r = new Random();
    //private guess myGuess = new guess();
    private int[] ans = new int[4];
    private int[] myplayerans = new int[4];
    private int colour;
    private int index;
    private int black = 0;
    private int white = 0;
    

    public void randomNum()
    {
        for (int i=0; i<4; i++)
        {
            int r_int = r.nextInt(7);
            ans[i] = r_int;
            System.out.println(r_int);
        }
    }

    public void playerans(int a,int i)
    {
        colour = a;
        index = i;
        myplayerans[index] = colour;
        System.out.printf("%d ",myplayerans[index]);
    }
    
    public int blackLabel()
    {
        black = 0;
        //int [] ans = a;
        for (int index =0; index<4; index++)
        {
            if (myplayerans[index] == ans[index])
            {
                black++;
            }
        }
        System.out.printf("black : %d", black);
        return black;
    }

    public int whiteLabel()
    {
        white = 0;
        int [] a = new int[4]; //model answer
        int [] g = new int [4]; //player's answer
        for (int i=0; i<4; i++)
        {
            a[i] = ans[i];
            g[i] = myplayerans[i];
        }

        for (int i=0; i<4; i++) //position of a
        {
            for (int j=0; j<4; j++)//position of g
            {
                if (a[i]==g[j] && i == j)
                {
                    a[i] = -1;
                    g[j] = -1;
                    break;
                }

                else if (a[i]==g[j] /*&& i != j*/ && a[i] != -1 && a[j]!= -1)
                {
                    a[i] = -1;
                    g[i] = -1;
                    white++;
                    break;
                }
            }
           
        }
        System.out.printf("white : %d", white);
        return white;
    }

}



