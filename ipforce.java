
import java.io.*;

import java.applet.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 class ipforce extends JFrame implements ActionListener{
		JFrame f;
		JPanel p,p1;
		JTextArea ta;
		JLabel l;
		JButton b;
		//trems
		String term[]={"momentum","mass","v","accelaration","time","force","distance","weight","g","hieght","u","ke","pe","w","power"};
		double value[];
		String word[];
		String find="";
	public void init()
	{
		//frame properties
	f=new JFrame("IPPhysics");
	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	SystemTray d= SystemTray.getSystemTray();
	SystemTray.isSupported();
	
	d.getSystemTray();
	//panel
	p=new JPanel();
	p1=new JPanel();
	p1.setLayout(new GridLayout(1,0));
	//textarea
	ta=new JTextArea(26,44);
	JScrollPane scroll=new JScrollPane(ta);
	
    ta.setText("Please type your text here");
    
    // label
	l=new JLabel("Please enter your question");
	// defining button and adding acion listener to it 
	b=new JButton("Analyse");
	b.addActionListener(this);
	//adding label ,Button and textarea to panel p and p1 
	p1.add(l);
	p1.add(b);
	p.add(scroll);
	//adding panelto frame
	f.add(p1,BorderLayout.NORTH);
	f.add(p,BorderLayout.AFTER_LAST_LINE);
    //displaying frame
	f.setSize(500,500);
	f.show();
	}
	
	
	//extracts each word and stores them in array
	public void extractor(String s)
	{   
		int space=0;
		String str =s+" ";
		String st="";
		int c=0;
		int l=str.length();
		for(int i=0;i<l;i++)
		{
			char ch=str.charAt(i);
			if(ch==' ')
				space++;
		}
		word=new String[space];
		for(int i=0;i<l;i++)
		{
			char ch=str.charAt(i);
			if(!(ch==' '))
				st=st+ch;
			if(ch==' ')
			{
				word[c]=st;
				c++;
				st="";
			}
		}
		for(int i=0;i<space;i++)
		{		System.out.println(word[i]+"\n");
		ta.append(word[i]+"\n");
		}funCheck();
		
	}
	

	//fuction checker
	public void funCheck()
	{System.out.println("funcheck");
	// value is assigned 
	value=new double[15];
	for (int i=0;i<word.length;i++)
	{      //1
		for(int j=0;j<term.length;j++)
			if(word[i].equalsIgnoreCase(term[j]))
			{          //2
				System.out.println("match"+ word[i]+ term[j]);
				int c=i;
				for (int ia=c;ia<word.length;ia++)
				{        //3
					System.out.println(word[ia].charAt(0));
					char ch=word[ia].charAt(0);
					System.out.println(ch);
					if(ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9')
					{
						System.out.print( "cccc"+i);
						System.out.println("match"+ word[i] );
						if (value[j]==0)							
					value[j]=Double.parseDouble(word[ia]);
		
					System.out.println(value[j]);
					
					}
				}        //3end
			}        //2end
	}     //1end
	
	//display value for testing
	for (int y=0;y<=14;y++)
		System.out.println(term[y]+value[y]);
	// finds the value to be calculated
	int c=0;
	for (int i=0;i<word.length;i++)
	{//1
		if(word[i].equalsIgnoreCase("find")||word[i].equalsIgnoreCase("what"))
		{c++;
			for (int g=i;g<word.length;g++)
			{      //2
				for(int j=0;j<term.length;j++)
					if(word[g].equalsIgnoreCase(term[j]))
					{
						find=word[g];
					break;
					}
			}//2 end
		}
		}//1end
	if (c==0)
		JOptionPane.showMessageDialog(null,"Incorrect question Please chech your question once again","Error",JOptionPane.ERROR_MESSAGE);
	
	
	 System.out.println(find);
	// to check and assign value to respected methods for calculations 
	if (find.equalsIgnoreCase("momentum"))
	{
		mometum();
	}
	
	if (find.equalsIgnoreCase("mass"))
	{
		
	}
	
	if (find.equalsIgnoreCase("v"))
	{
		fvelocity();
	}
	
	if (find.equalsIgnoreCase("accelaration"))
	{
		
	}
	
	if (find.equalsIgnoreCase("time"))
	{
		
	}
	
	if (find.equalsIgnoreCase("force"))
	{
				force();
	}
	
	if (find.equalsIgnoreCase("distance"))
	{
		
	}
	
	if (find.equalsIgnoreCase("weight"))
	{
		weight();
	}
	
	if (find.equalsIgnoreCase("hieght"))
	{
		
	}
	
	if (find.equalsIgnoreCase("u"))
	{
		ivelocity();
	}
	
	if ((find.equalsIgnoreCase("ke"))||find.equalsIgnoreCase("kinetic energy"))
	{
		ke();
	}
	
	if ((find.equalsIgnoreCase("pe"))||find.equalsIgnoreCase("potential energy"))
	{
		String val=JOptionPane.showInputDialog("Please enter gravitational force value");
		value[8]=Double.parseDouble (val);
		pe();
	}
	if (find.equalsIgnoreCase("w"))
	{
		work();
	}
	if (find.equalsIgnoreCase("power"))
	{
		power();
	}
//	display value for testing
	for (int y=0;y<13;y++)
		System.out.println(term[y]+value[y]);
	}
	
	// method for calculations of momentum
	public void mometum()
	{
		System.out.print("mom" );
		value[0]=value[1]*value[2];
		ta.setText("we know that p=mv"+"\n");
		ta.append("=> p ="+value[1]+"*"+value[2]+"\n");
		ta.append("=> p(momentum) ="+value[0]+"\n");
	}
//	 method for calculations of force
	public void force()
	{
		System.out.print("mom" );
		value[5]=value[1]*value[3];
		ta.setText("we know that F=ma"+"\n");
		ta.append("=> F ="+value[1]+"*"+value[3]+"\n");
		ta.append("=> F(Force) ="+value[5]+"\n");
	}
//	 method for calculations of weight
	public void weight()
	{
		if((value[8]==0.0))// chechs for sutaible formula which should be used for taking out result
		{
			if(value[5]==0.0)
				force();//if force is calculated 
			
		System.out.print("mom" );
		value[7]=value[5]*value[6];
		ta.setText("we know that W=FS"+"\n");
		ta.append("=> W ="+value[5]+"*"+value[6]+"\n");
		ta.append("=> W(weight) ="+value[7]+"\n");
		}
		if((value[5]==0.0)&&(value[6]==0.0)&&(value[3]==0.0))
		{
			String val=JOptionPane.showInputDialog("Please enter gravitational force value");
			value[8]=Double.parseDouble (val);
		System.out.print("mom" );
		value[7]=value[1]*value[8]*value[9];
		ta.setText("we know that W=mgh"+"\n");
		ta.append("=> W ="+value[1]+"*"+value[8]+"*"+value[9]+"\n");
		ta.append("=> W(weight) ="+value[7]+"\n");
		}
		
		
	}
	// method to calculate kinetic energy
	public void ke()
	{
		System.out.print("mom" );
		value[11]=0.5*value[1]*(value[2]*value[2]);
		ta.setText("we know that K.E=1/2 m*v*v"+"\n");
		ta.append("=> K.E ="+"1/2 * "+value[1]+" * "+value[2]+" * "+value[2]+"\n");
		ta.append("=> K.E(Kinetic energy) ="+value[11]+"\n");
	}
	//metod to calculate potential energy
	public void pe()
	{
		
		System.out.print("mom" );
		value[12]=value[1]*(value[8]*value[9]);
		ta.setText("we know that F=mgh"+"\n");
		ta.append("=> P.E ="+value[1]+" * "+value[8]+" * "+value[9]+"\n");
		ta.append("=> P.E(Potential energy) ="+value[12]+"\n");
	}
    //	 method to find final velocity 
	public void fvelocity()
	{
		if(value[6]==0.0)
		{
			System.out.print("mom");
		    value[2]=value[10]+(value[3]*value[4]);
		    ta.setText("we know that v=u+at"+"\n");
		    ta.append("=> v ="+value[10]+" + "+value[3]+" * "+value[4]+"\n");
		    ta.append("=> v(final velocity) ="+value[2]+"\n");
		}
		if(value[4]==0.0)
		{
			System.out.print("mom");
		    value[2]=Math.sqrt(value[10]+(value[3]*value[4]));
		    ta.setText("we know that v*v=u*u+2aS"+"\n");
		    ta.append("=> v ="+value[10]+" + "+value[3]+" * "+value[4]+"\n");
		    ta.append("=> v(final velocity) ="+value[2]+"\n");
		}
	}
	// method to calculate initial velocity
	public void ivelocity()
	{
		if(value[4]==0.0)
		{
		System.out.print("mom");
	    value[10]=Math.sqrt((value[2]*value[2])-2*(value[3]*value[6]));
	    ta.setText("we know that u*u=v*v-2aS"+"\n");
	    ta.append("=> u*u ="+value[2]+" - 2"+value[3]+" * "+value[6]+"\n");
	    ta.append("=> u (initial velocity) ="+value[2]+"\n");
		}
		if(value[6]==0.0)
		{
			System.out.print("mom");
		    value[10]=value[2]-(value[3]*value[4]);
		    ta.setText("we know that u=v-at"+"\n");
		    ta.append("=> u ="+value[2]+" - "+value[3]+" * "+value[4]+"\n");
		    ta.append("=> u (initial velocity) ="+value[10]+"\n");
		}
	}
	//method to calculate work done 
	public void work()
	{
		System.out.print("mom" );
		value[13]=value[5]*value[6];
		ta.setText("we know that W=FS"+"\n");
		ta.append("=> W ="+value[5]+"*"+value[6]+"\n");
		ta.append("=> W(work done) ="+value[7]+"\n");
	}
	//method to calculate power
	public void power()
	{
		if(value[13]==0.0)
		{
			System.out.print("mom" );
			value[14]=value[13]/value[4];
			ta.setText("we know that P=W/t"+"\n");
			ta.append("=> W ="+value[13]+"/"+value[4]+"\n");
			ta.append("=> W(weight) ="+value[13]+"\n");
		}
	}
	
	//action listener
	public void actionPerformed(ActionEvent ae)
	{
		String act=ae.getActionCommand();
		if(act.equals("Analyse"))
		{
			String st=ta.getText();
		    extractor(st);
		}
	}
	public static void main(String[] args) 
	{
		ipforce app=new ipforce();
		app.init();
		
	}

}
