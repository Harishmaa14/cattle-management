import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class Userdefined extends Exception {
    Userdefined(String s) {
        super(s);
    }
}

class Vaccination {
    String date;
    String vtype;
    int amnt;

    Vaccination() {
    }

    Vaccination(String date, String vtype, int amnt) {
        this.date = date;
        this.vtype = vtype;
        this.amnt = amnt;
    }
}

class Feedinfo extends Vaccination {
    String pdate;
    int quan;
    int price;
    String feedtype;

    Feedinfo() {
    }

    Feedinfo(String date, String vtype, int amnt, String pdate, int quan, int price, String feedtype) {
        super(date, vtype, amnt);
        this.pdate = pdate;
        this.quan = quan;
        this.price = price;
        this.feedtype = feedtype;
    }
}

class Insurance extends Feedinfo {
    String donedate;
    String duedate;

    Insurance() {
    }

    Insurance(String date, String vtype, int amnt, String pdate, int quan, int price, String feedtype, String donedate,
            String duedate) {
        super(date, vtype, amnt, pdate, quan, price, feedtype);
        this.donedate = donedate;
        this.duedate = duedate;
    }
}

class Info extends Insurance {
    String cname;
    int cid;
    String ctype;

    Info() {
    }

    Info(String date, String vtype, int amnt, String pdate, int quan, int price, String feedtype, String donedate,
            String duedate, String cname, int cid, String ctype) {
        super(date, vtype, amnt, pdate, quan, price, feedtype, donedate, duedate);
        this.cname = cname;
        this.cid = cid;
        this.ctype = ctype;
    }
public String toString() {
        return "Date to be vaccinated: " + date +
               "\nVaccination type: " + vtype +
               "\nVaccinated amount: " + amnt +
               "\nDate to be purchased: " + pdate +
               "\nQuantity: " + quan +
               "\nPrice: " + price +
               "\nType of feed: " + feedtype +
               "\nInsurance done date: " + donedate +
               "\nInsurance due date: " + duedate +
               "\nCattle name: " + cname +
               "\nCattle ID: " + cid +
               "\nCattle type: " + ctype + "\n";
}
}

class Cattlegui extends Info implements ActionListener {
    ArrayList<Info> list = new ArrayList<>();
    JFrame f;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JButton b1, b2, b3;
    JTextArea a;

    Cattlegui() {
        f = new JFrame("Cattle Management");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        t7 = new JTextField(10);
        t8 = new JTextField(10);
        t9 = new JTextField(10);
        t10 = new JTextField(10);
        t11 = new JTextField(10);
        t12 = new JTextField(10);

        l1 = new JLabel("Date to be vaccinated");
        l2 = new JLabel("Vaccination type");
        l3 = new JLabel("Vaccinated amount");
        l4 = new JLabel("Date to be purchased");
        l5 = new JLabel("Quantity");
        l6 = new JLabel("Price");
        l7 = new JLabel("Type of feed");
        l8 = new JLabel("Insurance done date");
        l9 = new JLabel("Insurance due date");
        l10 = new JLabel("Cattle name");
        l11 = new JLabel("Cattle ID");
        l12 = new JLabel("Cattle type");

        b1 = new JButton("Submit");
        b2 = new JButton("Alert");
        b3 = new JButton("Periodic summary");
        a = new JTextArea();

        f.setLayout(new GridLayout(14, 2));

        f.add(l1);
        f.add(t1);
        f.add(l2);
        f.add(t2);
        f.add(l3);
        f.add(t3);
        f.add(l4);
        f.add(t4);
        f.add(l5);
        f.add(t5);
        f.add(l6);
        f.add(t6);
        f.add(l7);
        f.add(t7);
        f.add(l8);
        f.add(t8);
        f.add(l9);
        f.add(t9);
        f.add(l10);
        f.add(t10);
        f.add(l11);
        f.add(t11);
        f.add(l12);
        f.add(t12);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        f.setSize(500, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            int a = Integer.parseInt(t3.getText());
            int b = Integer.parseInt(t5.getText());
            int c = Integer.parseInt(t6.getText());
            int d = Integer.parseInt(t11.getText());
            try {
                if (t1.getText().isEmpty() || t2.getText().isEmpty() || t3.getText().isEmpty() || t4.getText().isEmpty()
                        || t5.getText().isEmpty() || t6.getText().isEmpty() || t7.getText().isEmpty()
                        || t8.getText().isEmpty() || t9.getText().isEmpty() || t10.getText().isEmpty()
                        || t11.getText().isEmpty() || t12.getText().isEmpty()) {
                    throw new Userdefined("Enter all details");
                }
            } catch (Userdefined u) {
                JOptionPane.showMessageDialog(f, u.getMessage());
            }
            list.add(new Info(t1.getText(), t2.getText(), a, t4.getText(), b, c, t7.getText(), t8.getText(),
                    t9.getText(), t10.getText(), d, t12.getText()));
        }
        if (e.getSource() == b2) {
            int d1 = Integer.parseInt(t1.getText());
            int td = 231130;
            int fd = d1 - td;
            JOptionPane.showMessageDialog(null, fd + " days left to vaccination", "Warning",
                    JOptionPane.WARNING_MESSAGE);
        }
        if (e.getSource() == b3) {
            StringBuilder summary = new StringBuilder("Periodic Summary:\n");
            for (Info i : list) {
                summary.append(i.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(summary.toString())),
                    "Periodic Summary", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String args[]) {
        Cattlegui cg = new Cattlegui();
    }
}
