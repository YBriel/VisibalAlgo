import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * @author: yuzq
 * @Date: 2019-01-04  15:55
 * @Description:
 **/
public class AlgoFrame extends JFrame {

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        super(title);
        AlgoCanvas canvas=new AlgoCanvas();
        //canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        this.canvasHeight=canvasHeight;
        this.canvasWidth=canvasWidth;
        this.setSize(canvasWidth,canvasHeight);
        setContentPane(canvas);
        pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public int getCanvasWidth(){
        return canvasWidth;
    }
    public int getCanvasHeight(){
        return canvasHeight;
    }

    public AlgoFrame(String title){
        this(title,1024,768);
    }

    private class AlgoCanvas extends JPanel{
        //g是绘制的上下文环境
        @Override
        public void paintComponent(Graphics g){
           // g.drawOval(50,50,300,300);
            super.paintComponent(g);
            Graphics2D g2d=(Graphics2D)g;
            //抗锯齿
            RenderingHints hints=new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            g2d.setColor(Color.red);
            Ellipse2D circle=new Ellipse2D.Float(50,50,300,300);
            g2d.draw(circle);
        }
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
    public static void main(String[] args) {
        AlgoFrame algoFrame=new AlgoFrame("welcome",500,500);

    }

}
