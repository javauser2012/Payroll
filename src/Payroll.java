import excel.Excel;
import tools.Tools;
import window.Select;

import javax.swing.*;
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

    }
    //select窗口中的按钮事件
    public static void registerListener(Select s){
        //获取文件绝对路径写入jb_selectFile
        s.jb_selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser(".");             //设置选择器
                FileNameExtensionFilter filter = new FileNameExtensionFilter("excel文件","xls");
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
                File xlsFile = new File(s.jt_selectFile.getText());
                new Excel(xlsFile);
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