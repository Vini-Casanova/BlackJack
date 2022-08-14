import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class App implements ActionListener {

    ImageIcon icon = new ImageIcon("./imgs/balckJack.png");
    JFrame frame = new JFrame("Black Jack");
    JButton hit = new JButton("Hit");
    JButton stay = new JButton("Stay");
    JTextField rodadas = new JTextField("Rodadas");
    JTextField maoDealer = new JTextField();
    JTextField maoJogador = new JTextField();
    int numRodadas =0;
    int dealer =0;
    int jogador =0;
    boolean firstPlay= true;

    App() {
        firstPlay = true;
        maoDealer.setBounds(50,175,60,75);
        maoDealer.setFont(new Font("Arial",Font.BOLD,30));
        maoDealer.setForeground(Color.white);
        maoDealer.setBackground(Color.BLACK);
        maoDealer.setEditable(false);

        maoJogador.setBounds(50, 375, 60, 75);
        maoJogador.setFont(new Font("Arial", Font.BOLD,30));
        maoJogador.setForeground(Color.white);
        maoJogador.setBackground(Color.BLACK);
        maoJogador.setEditable(false);

        stay.addActionListener(this);
        stay.setBounds(135, 500, 100, 50);
        stay.setForeground(Color.white);
        stay.setBackground(Color.DARK_GRAY);
        stay.setFont(new Font("Arial", Font.BOLD,30));
        stay.setFocusable(false);

        hit.addActionListener(this);
        hit.setBounds(50, 500, 75, 50);
        hit.setForeground(Color.white);
        hit.setBackground(Color.DARK_GRAY);
        hit.setFont(new Font("Arial", Font.BOLD,30));
        hit.setFocusable(false);

        frame.add(maoDealer);
        frame.add(maoJogador);
        frame.add(stay);
        frame.add(hit);

        frame.setIconImage(icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }
    public static void main(String[] args) throws Exception ,InterruptedException {
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == hit){
            if(firstPlay == true){
                jogador= (int)(Math.random() *13)+2;
                maoJogador.setText(String.valueOf(jogador));

                dealer= (int)(Math.random()* 13)+2;
                maoDealer.setText(String.valueOf(dealer));
                firstPlay = false;
            }else{
                jogador+= (int)(Math.floor(Math.random() *11)+2);
                maoJogador.setText(String.valueOf(jogador));
                if(jogador >= 21){
                     numRodadas +=1;

                     try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                     jogador =0;
                     dealer =0;
                     maoJogador.setText(String.valueOf(jogador));
                     maoDealer.setText(String.valueOf(dealer));
                     firstPlay = true;

                }
            }

        }
        if(e.getSource() == stay){
           /*
           dealer= (int)(Math.random()* 13)+2;
           maoDealer.setText(String.valueOf(dealer));
           */
        }

    }
}
