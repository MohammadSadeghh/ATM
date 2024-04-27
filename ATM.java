import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// I have taken help from Javatpoint site to write this code
public class ATM implements ActionListener {
    public JFrame f = new JFrame();
    public JPanel p = new JPanel();
    public static int language = 0;
    public static int lock = 0;
    ATM() {

        // set the main panel
        p.setBounds(0,0,1000,700);
        p.setBackground(Color.PINK);
        f.add(p);

        // set buttons for choose language
        JButton persian = new JButton("فارسی");
        persian.setFont(new Font("Zar", Font.BOLD, 18));
        JButton English = new JButton("English");
        English.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        p.add(persian);
        p.add(English);
        persian.setBounds(75,250,200,70);
        English.setBounds(700,250,200,70);

        // set labels for choose language
        JLabel perlab = new JLabel("زبان خود را انتخاب کنید");
        perlab.setBounds(110,350,300,100);
        perlab.setFont(new Font("Zar", Font.BOLD, 18));
        p.add(perlab);
        JLabel englab = new JLabel("Choose language");
        englab.setBounds(725,350,200,70);
        englab.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        p.add(englab);
        p.setLayout(null);

        // set action of choose language buttons
        persian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                language = 0;
                if(lock == 0){
                    pass_panel();
                }
                else{
                    selection_panel();
                }
            }
        });
        English.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                language=1;
                if(lock == 0){
                    pass_panel();
                }
                else{
                    selection_panel();
                }
            }
        });

        // set frame
        f.setSize(1000,700);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    // set enter password panel
    public void pass_panel(){

        p.removeAll();

        // set field for type password
        JPasswordField pf = new JPasswordField();
        pf.setBounds(330,300,300,50);
        p.add(pf);

        // set label for type password
        JLabel enterpass = new JLabel();
        enterpass.setBounds(410,100,300,300);
        p.add(enterpass);

        // set button for submit password
        JButton submit = new JButton();
        submit.setBounds(375,550,200,50);
        p.add(submit);

        // set words of this panel based of selected language
        if(language == 0){
            enterpass.setText("رمز خود را وارد کنید");
            enterpass.setFont(new Font("Zar", Font.BOLD, 22));
            submit.setText("ثبت");
            submit.setFont(new Font("Zar", Font.BOLD, 22));
        }
        else{
            enterpass.setText("Enter password");
            enterpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            submit.setText("Submit");
            submit.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        }

        // set action of submit button
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selection_panel();
            }
        });

        lock=1;
        p.revalidate();
        p.repaint();

    }

    // set select operation panel
    public void selection_panel(){

        p.removeAll();

        // set operation buttons
        JButton balance = new JButton();
        JButton money = new JButton();
        JButton pass = new JButton();
        JButton trasfer = new JButton();
        balance.setBounds(70,150,200,100);
        money.setBounds(70,400,200,100);
        pass.setBounds(700,150,200,100);
        trasfer.setBounds(700,400,200,100);
        p.add(balance);
        p.add(money);
        p.add(pass);
        p.add(trasfer);

        // set change language button
        JButton change_language = new JButton();
        change_language.setBounds(375,550,200,50);
        p.add(change_language);

        // set words based on selected language
        if(language == 0){
            money.setText("برداشت وجه");
            money.setFont(new Font("Zar", Font.BOLD, 22));
            balance.setText("اعلام موجودی");
            balance.setFont(new Font("Zar", Font.BOLD, 22));
            trasfer.setText("کارت به کارت");
            trasfer.setFont(new Font("Zar", Font.BOLD, 22));
            pass.setText("تغییر رمز");
            pass.setFont(new Font("Zar", Font.BOLD, 22));
            change_language.setText("تغییر زبان");
            change_language.setFont(new Font("Zar", Font.BOLD, 22));
        }
        else{
            money.setText("Get money");
            money.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            balance.setText("Balance");
            balance.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            trasfer.setText("Transfer money");
            trasfer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            pass.setText("Change password");
            pass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
            change_language.setText("change language");
            change_language.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
        }

        // set action for get money button
        money.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Getmoney_panel();
            }
        });
        // set action for get balance button
        balance.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                balance_panel();
            }
        });
        // set action for transfer money button
        trasfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transfer_panel();
            }
        });
        // set action for change password button
        pass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changepass_panel();
            }
        });
        // set action for change language button
        change_language.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new ATM();
            }
        });


        p.revalidate();
        p.repaint();

    }

    // set panel for get money
    public void Getmoney_panel(){

        p.removeAll();

        // set button for amounts of money that you can get
        JButton amount[] = new JButton[5];
        for(int i=1; i<=4; i++){
            amount[i] = new JButton(String.valueOf(i*(500000)));
            amount[i].setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            // set action of get money buttons
            amount[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    success_panel();
                }
            });
            p.add(amount[i]);
        }
        amount[1].setBounds(70,150,200,100);
        amount[2].setBounds(70,400,200,100);
        amount[3].setBounds(700,150,200,100);
        amount[4].setBounds(700,400,200,100);

        p.revalidate();
        p.repaint();

    }

    // set action of final panel after an operation
    public void success_panel(){
        p.removeAll();

        // set label for print your operation was successful
        JLabel success = new JLabel();
        success.setBounds(370,150,500,300);
        p.add(success);

        // set buttons for end operations and operate again
        JButton end = new JButton();
        JButton again = new JButton();
        end.setBounds(150,500,200,100);
        again.setBounds(625,500,200,100);
        p.add(again);
        p.add(end);

        // set words of panel based on your chose language
        if(language == 0){
            success.setText("عملیات موفقیت آمیز بود!");
            success.setFont(new Font("Zar", Font.BOLD, 30));
            again.setText("عملیات جدید");
            end.setText("اتمام عملیات");
            again.setFont(new Font("Zar", Font.BOLD, 22));
            end.setFont(new Font("Zar", Font.BOLD, 22));
        }
        else{
            success.setText("The operation was successful!");
            success.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 28));
            success.setBounds(250,150,500,300);
            again.setText("New operatoin");
            end.setText("End operation");
            again.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            end.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        }

        // set action for end and again button
        again.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selection_panel();
            }
        });
        end.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });

        p.revalidate();
        p.repaint();
    }

    // set the action of balance panel
    public void balance_panel(){
        p.removeAll();

        // set text that show you your account balance
        JLabel balance = new JLabel();
        balance.setBounds(350,150,500,300);
        p.add(balance);

        // set button for confirm your balance
        JButton conf = new JButton();
        conf.setBounds(375,550,200,50);
        p.add(conf);

        // set words of panel based on your chose language
        if(language == 0){
            balance.setText("موجودی حساب شما: 56350000");
            balance.setFont(new Font("Zar", Font.BOLD, 22));
            conf.setText("تایید");
            conf.setFont(new Font("Zar", Font.BOLD, 22));
        }
        else {
            balance.setText("Your account balance: 56350000");
            balance.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            conf.setText("confirm");
            conf.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        }

        // set action for confirm button
        conf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                success_panel();
            }
        });

        p.revalidate();
        p.repaint();
    }

    // set the action of transfer panel
    public void transfer_panel(){
        p.removeAll();

        // set text field for type your card number
        JTextField cardnum = new JTextField();
        JLabel cardnumlab = new JLabel();
        cardnum.setBounds(350,150,300,50);
        cardnumlab.setBounds(370,20,400,200);
        p.add(cardnum); p.add(cardnumlab);

        // set text field for type your desired amount
        JTextField amount = new JTextField();
        JLabel amountlab = new JLabel();
        amount.setBounds(350,330,300,50);
        amountlab.setBounds(380,200,400,200);
        p.add(amount); p.add(amountlab);

        // set button for confirm transfer operation
        JButton conf = new JButton();
        conf.setBounds(375,550,200,50);
        p.add(conf);

        // set words of panel based on your chose language
        if(language == 0){
            cardnumlab.setText("شماره کارت مورد نظر خود را وارد کنید:");
            amountlab.setText("مبلغ مورد نظر خود را وارد کنید:");
            conf.setText("تایید");
            conf.setFont(new Font("Zar", Font.BOLD, 22));
            cardnumlab.setFont(new Font("Zar", Font.BOLD, 22));
            amountlab.setFont(new Font("Zar", Font.BOLD, 22));
        }
        else {
            cardnumlab.setText("Enter your desired card number:");
            amountlab.setText("Enter the desired amount:");
            conf.setText("confirm");
            conf.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            cardnumlab.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            amountlab.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        }

        // set the action of confirm button
        conf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                success_panel();
            }
        });

        p.repaint();
        p.revalidate();
    }

    public void changepass_panel(){
        p.removeAll();

        // set field for type password
        JPasswordField pf = new JPasswordField();
        pf.setBounds(330,300,300,50);
        p.add(pf);

        // set label for type password
        JLabel enterpass = new JLabel();
        enterpass.setBounds(390,100,300,300);
        p.add(enterpass);

        // set button for submit password
        JButton submit = new JButton();
        submit.setBounds(375,550,200,50);
        p.add(submit);

        // set words of this panel based of selected language
        if(language == 0){
            enterpass.setText("رمز جدید خود را وارد کنید");
            enterpass.setFont(new Font("Zar", Font.BOLD, 22));
            submit.setText("ثبت");
            submit.setFont(new Font("Zar", Font.BOLD, 22));
        }
        else{
            enterpass.setText("Enter your new password:");
            enterpass.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            submit.setText("Submit");
            submit.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 22));
        }

        // set action of submit button
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                success_panel();
            }
        });

        p.revalidate();
        p.repaint();
    }

    // creating an ATM
    public static void main(String[] args) {
        new ATM();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}