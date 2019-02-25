import java.awt.*;
import java.awt.event.*;

/**
 * @author: yuzq
 * @Date: 2019-02-25  09:40
 * @Description:
 **/
public class AlgoVisualizer {
    private Circle[] circles;
    private AlgoFrame frame;
    private boolean isAnimate=true;

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N) {
        circles = new Circle[N];
        int R = 50;
        for (int i = 0; i < N; i++) {
            int x = (int) (Math.random() * (sceneWidth - 2 * R)) + R;
            int y = (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11) - 5;
            int vy = (int) (Math.random() * 11) - 5;
            circles[i] = new Circle(x, y, R, vx, vy);
        }
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("welcome", sceneWidth, sceneHeight);
            frame.addKeyListener(new AlgoKeyListenser());
            frame.addMouseListener(new AloMouseListener());
            new Thread(() -> {
                run();
            }).start();
        });
    }

    private void run() {
        while (true) {
            frame.render(circles);
            AlogoVisHelper.pause(20);
            if (isAnimate){
                for (Circle circle : circles) {
                    circle.move(0, 0, frame.getCanvasWidth(), frame.getCanvasHeight());
                }
            }

        }
    }

    private class AlgoKeyListenser extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println(e.getKeyChar());
            if (e.getKeyChar() == ' ') {
                isAnimate = !isAnimate;
            }
        }
    }

    public class AloMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            e.translatePoint(0,-(frame.getBounds().height-frame.getCanvasHeight()));
            System.out.println(e.getPoint());
            for(Circle circle:circles){
                if(circle.contains(e.getPoint())){
                    circle.isFilled=!circle.isFilled;
                }
            }
        }
    }
}
