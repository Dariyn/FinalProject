import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class calculator extends JFrame implements ActionListener {
    // create a frame
    static JFrame f;

    // create a textfield
    static JTextField l;

    // store oprerator and operands
    String s0, s1, s2;

    // default constrcutor
    calculator() {
        s0 = s1 = s2 = "";
    }

    // main function
    public void createGUI() {
        // create a frame
        f = new JFrame("calculator");

        // create a object of class
        calculator c = new calculator();

        // create a textfield
        l = new JTextField(19);

        // set the textfield to non editable
        l.setEditable(false);

        // create number buttons and some operators
        JButton zero, one, two, three, four, five, six, seven, eight, nine, plus, sub, mult, div, dec, clear, eq;

        // create number buttons
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        eq = new JButton("=");
        plus = new JButton("+");
        sub = new JButton("-");
        div = new JButton("/");
        mult = new JButton("*");
        clear = new JButton("C");
        dec = new JButton(".");
        JPanel p = new JPanel();

        // add action listeners
        mult.addActionListener(c);
        div.addActionListener(c);
        sub.addActionListener(c);
        plus.addActionListener(c);
        nine.addActionListener(c);
        eight.addActionListener(c);
        seven.addActionListener(c);
        six.addActionListener(c);
        five.addActionListener(c);
        four.addActionListener(c);
        three.addActionListener(c);
        two.addActionListener(c);
        one.addActionListener(c);
        zero.addActionListener(c);
        dec.addActionListener(c);
        clear.addActionListener(c);
        eq.addActionListener(c);

        // add elements to panel
        p.add(l);
        p.add(plus);
        p.add(one);
        p.add(two);
        p.add(three);
        p.add(sub);
        p.add(four);
        p.add(five);
        p.add(six);
        p.add(mult);
        p.add(seven);
        p.add(eight);
        p.add(nine);
        p.add(div);
        p.add(zero);
        p.add(dec);
        p.add(clear);
        p.add(eq);
        p.setBackground(Color.white);

        // add panel to frame
        f.add(p);

        f.setSize(350, 220);
        f.setVisible(true);
        f.setResizable(false);
    }

    /*public void incorrect() {
        l.setText("illegal expression");
    }*/


    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();


        //if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;

            // set the value of text
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";

            // set the value of text
            l.setText(s0 + s1 + s2);
        } else if (s.charAt(0) == '=') {

            double ans;

            // store the value in 1st
            if (!(s0.equals("") || s2.equals(""))) {
                if (s1.equals("+"))
                    ans = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    ans = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    ans = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    ans = (Double.parseDouble(s0) * Double.parseDouble(s2));

                // set the value of text
                l.setText("" + ans);

                // convert it to string
                s0 = Double.toString(ans);

                s1 = s2 = "";
            } else {
                l.setText("No values");
            }
        } else {
            // if there was no operand

                if (s1.equals(""))
                    s1 = s;
                    // else evaluate
                else {
                    /*double ans;

                    // store the value in 1st
                    if (s1.equals("+"))
                        ans = (Double.parseDouble(s0) + Double.parseDouble(s2));
                    else if (s1.equals("-"))
                        ans = (Double.parseDouble(s0) - Double.parseDouble(s2));
                    else if (s1.equals("/"))
                        ans = (Double.parseDouble(s0) / Double.parseDouble(s2));
                    else
                        ans = (Double.parseDouble(s0) * Double.parseDouble(s2));

                    // convert it to string
                    s0 = Double.toString(ans);

                    // place the operator
                    s1 = s;

                    // make the operand blank
                    s2 = "";*/
                    l.setText("multiple operator chosen");
                }

                // set the value of text
                //l.setText(s0 + s1 + s2);

            }
        }
    }

