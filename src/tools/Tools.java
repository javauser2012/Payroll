package tools;


import javax.swing.*;
import java.awt.*;

public class Tools {
    public Tools(JFrame frame){
        this.centered(frame);
    }
    //让窗口显示再屏幕中间
    public void centered(Container container) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int w = container.getWidth();
        int h = container.getHeight();
        container.setBounds((screenSize.width - w) / 2,(screenSize.height - h) / 2, w, h);
    }
}
