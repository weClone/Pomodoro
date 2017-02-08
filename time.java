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
	int work=1;
	int sbreak=2;
	int lbreak=2;
	int session=2;
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
	boolean mode=true;
	boolean play=false;
	//int 
	
	//
	JButton btnNewButton ;
	public time() {
		super();
		setVisible(true);
		setSize(640,320);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(262, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(33))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(130)
					.addComponent(btnNewButton)
					.addContainerGap(209, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		t=new Timer(100,this);//  1s
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
		int p=lbreak ;
		if(mode){ g.setColor(Color.red);
			p=work;
		}
		else {g.setColor(Color.cyan);
		p=sbreak;
		}
		if(cw<1)g.setColor(Color.yellow);
		int k=6*st/p;
		ve(mode,k);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnNewButton)
		{			play=!play;
			clock(st);
		}
		else if(play)
		{
			//System.out.println(mode);
			st++;
			clock(st);
		}
	}
	public void clock(int a)
	{ int k=a;
	if(cw>0){
		if(mode){  if(k%work==0)
		{
		k=6*k/work;
		ve(mode,k);
		if(k>=359){
			st=0;
			mode=false;
			cw--;
			System.out.println(cw);
		}
		}
	   }
	
		
		else if(k%sbreak==0)
		{
			//System.out.println("a");
			k=6*k/sbreak;
			ve(false,k);
			if(k>=360)
			
	{
				st=0;
				mode=true;
		}
			
		}
	}
	///*
	else if(k%lbreak==0)
	{		
		k=6*k/lbreak;
	    ve(false,k);
		if(k>=359){
			st=0;
			cw=session ;// chu trinh moi
			mode=true;
	}
		
	}
	//*/
	}
	
	public void ve(boolean bl,int k)
	{int m,l;
	if(bl) g.setColor(Color.red);
	else g.setColor(Color.cyan);
	if(cw<1)g.setColor(Color.yellow);
	
	for(int i=r2+1;i<r;i=i+1)
		{
			m=y-i/2;
			l=x-i/2;
			g.drawArc(l, m, i, i,90+k , 6);
		if(i%2==1)	g.drawArc(l, m, i+1, i+1,90+k , 6);
		}
		//*/
	
	}
	
	public static void main(String[]a)
	{
		time ttt=new time();
	}
}
