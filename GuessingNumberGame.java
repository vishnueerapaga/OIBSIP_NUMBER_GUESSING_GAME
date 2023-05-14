package hey;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class GuessingNumberGame {
    static int  count=1;
    static int points=0;
    static int score=0;
    static int array[]=new int[3];
	public static String check(int input,int rand_num,int min_num,int max_num)
		{
	     if(input>max_num || input<min_num)
	     {
	    	 return "Invalid Guess";
	     }
	     else {
			if(input<rand_num)
			{
				
				return "Guessed Number is low";
				
			}
			else if(input>rand_num)
			{
				return "Guessed Number is High";
			}
			else
			{
				
				if(input!=rand_num)
				{
					return "Incorrect Guess \n Try Again";
				}
				else
				{   points=(50-(10*(count-1)));
					return "CORRECT GUESS \n POINTS:"+ (50-(10*(count-1)))+"\n NO OF ATTEMPTS:"+count;
				}
			}}
			
		}
    public static void main(String args[])
	{int  rand_num;
	int r=1;
		String inputstring;
		Random rand=new Random();
		ImageIcon icon=new ImageIcon("icon.png");
		String max = JOptionPane.showInputDialog(null,"Enter UpperBound","GUESS NUMBER ",JOptionPane.QUESTION_MESSAGE);
		int max_num=Integer.parseInt(max);
		String min = JOptionPane.showInputDialog(null,"Enter LowerBound","GUESS NUMBER",JOptionPane.QUESTION_MESSAGE);
		int min_num=Integer.parseInt(min);
	while(r<4) {
		rand_num =rand. nextInt(max_num - min_num+1)+min_num;
		//System.out.println(rand_num);
		points=0;
		JOptionPane.showMessageDialog(null,"ROUND "+r,"GUESS NUMBER \t\t  Attempt:"+count,JOptionPane.INFORMATION_MESSAGE,icon);
		 int input=-1;
		count=1;
	while(input!=rand_num){
		//IF FIFTH ATTEMPT GIVE LAST WARNING 
		if(count==5)
		{
			JOptionPane.showMessageDialog(null,"LAST CHANCE","GUESS NUMBER \t\t Attempt:"+count,JOptionPane.WARNING_MESSAGE);
		}
		if(count!=6) {
			 inputstring = JOptionPane.showInputDialog(null,"Guess the number"+"\n(Max attempts:5)","GUESS NUMBER  \t\t Attempt:"+count,JOptionPane.QUESTION_MESSAGE);
			 input=Integer.parseInt(inputstring);
			 JOptionPane.showMessageDialog(null,check(input,rand_num,min_num,max_num),"GUESS NUMBER \t\tAttempt:"+count,JOptionPane.INFORMATION_MESSAGE,icon);
	count+=1;
		}
		else {
			JOptionPane.showMessageDialog(null,"out of chances \n The Number Was:"+rand_num,"GUESS NUMBER \t\t  Attempt:"+count,JOptionPane.INFORMATION_MESSAGE,icon);
			break;
		}
	}
	array[r-1]=points;
	score+=(int)points;
	r=r+1;
	}
JOptionPane.showMessageDialog(null,"SCORE \n ROUND 1:"+array[0]+"\n ROUND 2:"+array[1]+"\n ROUND 3:"+array[2]+"\nTOTAL "+score,"GUESS NUMBER",JOptionPane.INFORMATION_MESSAGE,icon);
	}
}