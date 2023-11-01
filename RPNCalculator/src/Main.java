import javax.swing.JFrame;
import rpn.RpnCalcForm;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("RPN Calculator");
        frame.setContentPane(new RpnCalcForm().Rpnform);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}