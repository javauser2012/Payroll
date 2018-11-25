package excel;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;

public class Excel {
    private Workbook wb = null;
    public Excel(File xlsFile) {
        try {
            readExcel(xlsFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        Traversing(this.wb);
    }

    public void readExcel(File xlsFile) throws BiffException, IOException {
        //获取Excel对象
        this.wb = Workbook.getWorkbook(xlsFile);

        // 获得所有工作表
//        Sheet[] sheets = wb.getSheets();
//        //遍历工作表
//        if (checkForm(wb)) {
//            for (Sheet sheet : sheets) {
//                // 获得行数
//                int rows = sheet.getRows();
//                // 获得列数
//                int cols = sheet.getColumns();
//                // 读取数据
//                for (int row = 0; row < rows; row++) {
//                    for (int col = 0; col < cols; col++) {
//                        System.out.printf("%10s",sheet.getCell(col, row).getContents());
//                    }
//                    System.out.println();
//                }
//            }
//        }
//        wb.close();
    }

    public Boolean checkForm(Workbook wb){
        // 获得所有工作表
        Sheet[] sheets = wb.getSheets();
        //遍历工作表
        if (sheets != null) {
            for (Sheet sheet : sheets) {
                //查看表格是否符合规范
                if (sheet.getCell(0, 0).getContents().equals("序号") &&
                        sheet.getCell(1, 0).getContents().equals("账号") &&
                        sheet.getCell(2, 0).getContents().equals("账户名称") &&
                        sheet.getCell(3, 0).getContents().equals("工资")) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    public void Traversing(Workbook wb){
        Sheet[] sheets = wb.getSheets();
        //遍历工作表
        if (checkForm(wb)) {
            for (Sheet sheet : sheets) {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.printf("%10s",sheet.getCell(col, row).getContents());
                    }
                    System.out.println();
                }
            }
        }
        wb.close();
    }
    public void writeExcel() throws BiffException, IOException{
        File xlsFile = new File("jxl.xls");
        // 创建一个工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
        // 创建一个工作表
        WritableSheet st = workbook.createSheet("工资条", 0);
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                // 向工作表中添加数据
                st.addCell(new Label(col, row, "data" + row + col));
            }
        }
        workbook.write();
        workbook.close();
    }

}