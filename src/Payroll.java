import tools.Tools;
import window.Select;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Payroll {

    public static void main(String[] args) {
        //实例化窗口
        Select selct = new Select();
        new Tools(selct);
        registerListener(selct);
//        new Excel();
    }
    //select窗口中的按钮事件
    public static void registerListener(Select s){
        //获取文件绝对路径写入jb_selectFile
        s.jb_selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(".");             //设置选择器
                FileNameExtensionFilter filter = new FileNameExtensionFilter("excel","xls","xlsx");
                chooser.setFileFilter(filter);
                chooser.setMultiSelectionEnabled(false);             //设为多选
                int returnVal = chooser.showOpenDialog(s.jb_selectFile);        //是否打开文件选择框
//                System.out.println("returnVal="+returnVal);

                if (returnVal == JFileChooser.APPROVE_OPTION) {          //如果符合文件类型

                    String filepath = chooser.getSelectedFile().getAbsolutePath();      //获取绝对路径
//                    System.out.println(filepath);
                    s.jt_selectFile.setText(filepath);

//                    System.out.println("You chose to open this file: "+ chooser.getSelectedFile().getName());  //输出相对路径

                }
            }
        });
        //开始按钮的事件
        s.jb_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description = new String("<html><body>" +
                        "" +
                        "" +
                        "" +
                        "</body></html>");
                s.jl_description.setText(description);
            }
        });
    }
}
class MyFileFilter extends FileFilter {

    String ends; // 文件后缀
    String description; // 文件描述文字

    public MyFileFilter(String ends, String description) { // 构造函数
        this.ends = ends; // 设置文件后缀
        this.description = description; // 设置文件描述文字
    }

    @Override
    // 只显示符合扩展名的文件，目录全部显示
    public boolean accept(File file) {
        if (file.isDirectory()) return true;
        String fileName = file.getName();
        if (fileName.toUpperCase().endsWith(this.ends.toUpperCase())) return true;
        return false;
    }

    @Override
    // 返回这个扩展名过滤器的描述
    public String getDescription() {
        return this.description;
    }

    // 返回这个扩展名过滤器的扩展名
    public String getEnds() {
        return this.ends;
    }
}