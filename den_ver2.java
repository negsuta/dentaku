
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class den2 extends JFrame implements ActionListener,KeyListener {
	
	JLabel lb = new JLabel("");
	JTextField tf = new JTextField(15);
	JPanel bf = new JPanel();
	
	JButton bt[] = new JButton[12];
	JButton enzan[] = new JButton[4];
	
	JPanel ue = new JPanel();
	JPanel st = new JPanel();
	
	double sum ;
	double kari;
	int hugo=0;
	int tbfl=0;
	int last;
	int first=0;
	
	den2() {
		tf.addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("電卓");
		setSize(600, 800);
		//main
		setLayout(new GridLayout(2, 1));
		add(ue);
		add(st);
		//ue
		
		ue.setLayout(new GridLayout(3,1));
		ue.add(lb);
		ue.add(tf);
		ue.add(bf);
		//bfの中身
			bf.setLayout(new GridLayout(1,4));
			for (int i=7;i<=9 ;i++) {
				bt[i] = new JButton(""+i);
				bt[i].addActionListener(this);
				bf.add(bt[i]);
			}
			enzan[3] = new JButton("÷");
			enzan[3].addActionListener(this);
			bf.add(enzan[3]);
		//sita
		st.setLayout(new GridLayout(3,4));
			int co=2;
			for (int i = 4; i >= 1; i -= 3) {
				for (int j = 0; j < 3; j++) {
					bt[i + j] = new JButton("" + (i + j));
					bt[i + j].addActionListener(this);
					st.add(bt[i + j]);
				}
				if (co==2) {
					enzan[2] = new JButton("×");
					enzan[2].addActionListener(this);
					st.add(enzan[2]);
				}else {
					enzan[1] = new JButton("-");
					enzan[1].addActionListener(this);
					st.add(enzan[1]);
				}
				co--;
			}
			
		bt[0] = new JButton("0");
		bt[0].addActionListener(this);
		bt[10] = new JButton("C");
		bt[10].addActionListener(this);
		bt[11] = new JButton("=");
		bt[11].addActionListener(this);
		enzan[0] = new JButton("+");
		enzan[0].addActionListener(this);
		
		st.add(bt[10]);
		st.add(bt[0]);
		st.add(bt[11]);
		st.add(enzan[0]);
		
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (e.getSource() == bt[0]) {
			tf.setText(tf.getText()+0);
			tbfl=1;
			
		} else if (e.getSource() == bt[1]) {
			tf.setText(tf.getText()+1);	
			tbfl=1;
			
		} else if (e.getSource() == bt[2]) {
			tf.setText(tf.getText()+2);	
			tbfl=1;
			
		} else if (e.getSource() == bt[3]) {
			tf.setText(tf.getText()+3);	
			tbfl=1;
			
		} else if (e.getSource() == bt[4]) {
			tf.setText(tf.getText()+4);	
			tbfl=1;
			
		} else if (e.getSource() == bt[5]) {
			tf.setText(tf.getText()+5);	
			tbfl=1;
			
		} else if (e.getSource() == bt[6]) {
			tf.setText(tf.getText()+6);	
			tbfl=1;
			
		} else if (e.getSource() == bt[7]) {
			tf.setText(tf.getText()+7);	
			tbfl=1;
			
		} else if (e.getSource() == bt[8]) {
			tf.setText(tf.getText()+8);	
			tbfl=1;
			
		} else if (e.getSource() == bt[9]) {
			tf.setText(tf.getText()+9);	
			tbfl=1;
			
			
//clear
		} else if (e.getSource() == bt[10]) {
			reset();

//eqoru
		} else if (e.getSource() == bt[11]) {
			if(tbfl!=0) {
				kari = Double.parseDouble(tf.getText());
				keisan();
				if(sum%1 == 0) {
					lb.setText(lb.getText()+(int)kari+"="+(int)sum);
					tf.setText("");
				}else {
					lb.setText(lb.getText()+kari+"="+sum);
					tf.setText("");
				}
				tbfl=0;
			}
			
//+
		} else if (e.getSource() == enzan[0]) {
			tasu();
//-
		} else if (e.getSource() == enzan[1]) {
			hiku();
//*			
		} else if (e.getSource() == enzan[2]) {
			kake();
//÷
		} else if (e.getSource() == enzan[3]) {
			waru();
		}
		
	}
	void tasu() {
		//テキストボックスがnullのときは何も動かさない
		if(tbfl!=0) {
			kari = Double.parseDouble(tf.getText());
			keisan();
			kari=0;
			tf.setText(null);
			tbfl=0;
			
			hugo=1;
		//小数点がない場合はint型に
			if(sum%1 == 0) {
				lb.setText((int)sum+"+");
			}else {
				lb.setText(sum+"+");
			}
		}else if(tbfl == 0 && first ==1) {
			hugo=1;
			if(sum%1 == 0) {
				lb.setText((int)sum+"+");
			}else {
				lb.setText(sum+"+");
			}
		}
	}
	void hiku() {
		if(tbfl!=0) {
			kari = Double.parseDouble(tf.getText());
			keisan();
			tf.setText(null);
			tbfl=0;
			
			hugo=2;
		//小数点がない場合はint型に
			if(sum%1 == 0) {
				lb.setText((int)sum+"-");
			}else {
				lb.setText(sum+"-");
			}
		}else if(tbfl == 0 && first ==1) {
			hugo=2;
			if(sum%1 == 0) {
				lb.setText((int)sum+"-");
			}else {
				lb.setText(sum+"-");
			}
		}
	}
	void waru() {
		if(tbfl!=0) {
			kari = Double.parseDouble(tf.getText());
			keisan();
			tf.setText(null);
			tbfl=0;
			
			hugo=4;
		//小数点がない場合はint型に
			if(sum%1 == 0) {
				lb.setText((int)sum+"÷");
			}else {
				lb.setText(sum+"÷");
			}
		}else if(tbfl == 0 && first ==1) {
			hugo=4;
			if(sum%1 == 0) {
				lb.setText((int)sum+"÷");
			}else {
				lb.setText(sum+"÷");
			}
		}
	}
	
	void kake() {
		if(tbfl!=0) {
			kari = Double.parseDouble(tf.getText());
			keisan();
			kari=0;
			tf.setText(null);
			tbfl=0;
			
			hugo=3;
		//小数点がない場合はint型に
			if(sum%1 == 0) {
				lb.setText((int)sum+"×");
			}else {
				lb.setText(sum+"×");
			}
		}else if(tbfl == 0 && first ==1) {
			hugo=3;
			if(sum%1 == 0) {
				lb.setText((int)sum+"×");
			}else {
				lb.setText(sum+"×");
			}
		}
	}

	void reset() {
		lb.setText("");
		tf.setText("");
		sum=0;
		kari=0;
		hugo=0;
		tbfl=0;
		first=0;

	}
	void keisan() {
		if(first==0) {
			first=1;
		}
		
		switch (hugo){
		case 1:
			sum += kari;
		break;
		case 2:
			sum -= kari;
		break;
		case 3:
			sum *= kari;
		break;
		case 4:
			sum /= kari;
		break;
		default:
			sum += kari;
		break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if(e.getKeyCode() >= 96 && e.getKeyCode() <=105) {
			tbfl=1;
		}else if(e.getKeyCode() >= 48 && e.getKeyCode()<=57){
			tbfl=1;
		}
	}

	
}
public class den_ver2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new den2();
	}

}
