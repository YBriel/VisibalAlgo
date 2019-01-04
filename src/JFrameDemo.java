import javax.swing.*;
import java.awt.*;

/**
 * @author: yuzq
 * @Date: 2019-01-04  15:35
 * @Description:
 **/
public class JFrameDemo {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame=new JFrame("welcome");
            frame.setSize(500,500);
            //不能改变大小
            frame.setResizable(false);
            //设置关闭按钮
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //设置窗口固定
            frame.setVisible(true);
        });

    }
}
