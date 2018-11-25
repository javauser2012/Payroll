package window;

import javax.swing.*;
import java.awt.*;

public class Select extends JFrame {
    Font font = new Font("仿宋",Font.BOLD,20);
    public JLabel jl_title,jl_selectFile,jl_description = null;
    public JTextField jt_selectFile = null;
    public JButton jb_selectFile,jb_start = null;
    public Select(){
        //设置窗口标题
        this.setTitle("工资条生成器");
        //调用窗体
        this.init();
        //调用按钮事件
//        this.registerListener();
    }
    //窗体
    public void init(){
        //设置布局格式
        this.setLayout(null);
        this.setSize(550, 300);
        //禁止调整窗口大小
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jl_title = new JLabel("工资条生成器",JLabel.CENTER);
        jl_title.setBounds(0,0,550,50);
        jl_title.setFont(new Font("仿宋",Font.BOLD,50));
        this.add(jl_title);
        jl_selectFile = new JLabel("文件路径:",JLabel.RIGHT);
        jl_selectFile.setBounds(0,80,100,20);
        jl_selectFile.setFont(font);
        this.add(jl_selectFile);
        jt_selectFile = new JTextField();
        jt_selectFile.setBounds(100,80,300,20);
        this.add(jt_selectFile);
        jb_selectFile = new JButton("选择文件");
        jb_selectFile.setFont(font);
        jb_selectFile.setBounds(400,80,120,20);
        this.add(jb_selectFile);
        jb_start = new JButton("开始");
        jb_start.setFont(font);
        jb_start.setBounds(200,110,150,50);
        this.add(jb_start);
        jl_description = new JLabel("");
        jl_description.setBounds(100,170,350,90);
        jl_description.setOpaque(true);
        jl_description.setBackground(Color.WHITE);
        this.add(jl_description);

        //显示窗体
        this.setVisible(true);
    }
    //按钮事件
//    public void registerListener(){
//        jb_selectFile.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JFileChooser chooser = new JFileChooser();             //设置选择器
//                chooser.setMultiSelectionEnabled(false);             //设为多选
//                int returnVal = chooser.showOpenDialog(jb_selectFile);        //是否打开文件选择框
//                System.out.println("returnVal="+returnVal);
//
//                if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型
//
//                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
//                    System.out.println(filepath);
//                    jt_selectFile.setText(filepath);
//
//                    System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());  //输出相对路径
//
//                }
//            }
//        });
//        jb_start.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String description = new String("<html><body>" +
//                        "" +
//                        "" +
//                        "" +
//                        "</body></html>");
//                jl_description.setText(description);
//            }
//        });
//    }
}
