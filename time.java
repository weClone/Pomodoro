package promodo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
public class time extends JFrame implements ActionListener

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Timer t;
	int st=0; // thoi gian dem
	int work=25;
	int sbreak=5;
	int lbreak=10;
	int session=4;
	int x=200;
	int y=150;
	int x1;int y1;
	int x2,y2,x3,y3;
	Color c;
	int r=180;
	int r2=160;
	Graphics2D g;
	Font big,small;
	
	int cw;
	boolean mode;
	//int 
	
	//
	JButton btnNewButton ;
	public time() {
		super();
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		btnNewButton = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(145)
					.addComponent(btnNewButton)
					.addContainerGap(150, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(339, Short.MAX_VALUE)
					.addComponent(btnNewButton))
		);
		getContentPane().setLayout(groupLayout);
		t=new Timer(1000,this);//  1s
		t.start();
	//	peper();
		y1=y-r/2;
		x1=x-r/2;
		y2=y-r2/2;
		x2=x-r2/2;
		cw=session ;
		
		repaint();
		
	}
	public void paint(Graphics g2)
	{
		super.paint(g2);
		 g = (Graphics2D) g2.create();
		 RenderingHints rh =
		            new RenderingHints(RenderingHints.KEY_ANTIALIASING,
		            RenderingHints.VALUE_ANTIALIAS_ON);
		 
		        rh.put(RenderingHints.KEY_RENDERING,
		               RenderingHints.VALUE_RENDER_QUALITY);
		 
		        g.setRenderingHints(rh);
		g.setColor(Color.CYAN);
		g.fillOval(x1, y1, r, r);
		c=getBackground();
		g.setColor(c);
		g.fillOval(x2, y2, r2, r2);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnNewButton)
		{
			st=0;
			mode=true;
			clock(st,mode);
		}
		else
		{
			st++;
			clock(st,mode);
		}
		System.out.println("aaa");
	}
	public void clock(int a,boolean mode)
	{ int k=a;
	if(cw>0){	if(mode&&(k%work==0))
		{
		k=6*k/work;
		x3=(int)(x-r*Math.cos(k));
		y3=(int)(y+r*Math.sin(k));
		ve(x3,y3,mode,k);
		if(k>=360){
			st=0;
			mode=!mode;
			cw--;
		}
		}
		else
		{
			k=6*k/sbreak;
			x3=(int)(x-r*Math.cos(k));
			y3=(int)(y+r*Math.sin(k));
			ve(x3,y3,mode,k);
			if(k>=360){
				st=0;
				mode=!mode;
		}
		}
	}
	else
	{
		k=6*k/lbreak;
		x3=(int)(x-r*Math.cos(k));
		y3=(int)(y+r*Math.sin(k));
		ve(x3,y3,mode,k);
		if(k>=360){
			st=0;
			cw=session ;// chu trinh moi
	}
	}
	}
	public void ve(int a,int b,boolean bl,int k)
	{
		g.setColor(Color.red);
		g.fillArc(x1, y1, r, r,0 , k);
		g.setColor(c);
		g.fillArc(x2, y2, r2, r2,0 , k);
		
	}
	
	public static void main(String[]a)
	{
		time ta=new time();
	}
}
