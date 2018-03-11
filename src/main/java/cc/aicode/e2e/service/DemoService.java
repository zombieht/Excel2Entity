package cc.aicode.e2e.service;

import cc.aicode.e2e.ExcelHelper;
import cc.aicode.e2e.domain.Demo;
import cc.aicode.e2e.exception.ExcelContentInvalidException;
import cc.aicode.e2e.exception.ExcelParseException;
import cc.aicode.e2e.exception.ExcelRegexpValidFailedException;
import cc.aicode.e2e.repository.DemoRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by zombi on 2018/3/3.
 */
@Service
@Transactional
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public void save(String a) throws IOException, InvalidFormatException {

        if (StringUtils.isEmpty(a)){
            throw new RuntimeException ("路径不能为空");
        }
        ExcelHelper eh = ExcelHelper.readExcel(a);

        String[] headers = eh.getHeaders();
        String[][] datas = eh.getDatas();

        List<Demo> entitys = null;
        try {
            entitys = eh.toEntitys(Demo.class);
            for (Demo d : entitys) {
                demoRepository.save(d);
                System.out.println(d.toString());
            }
        } catch (ExcelParseException e) {
            System.out.println(e.getMessage());
        } catch (ExcelContentInvalidException e) {
            System.out.println(e.getMessage());
        } catch (ExcelRegexpValidFailedException e) {
            System.out.println(e.getMessage());
        }
    }


    public void createExcel() {


        List<Demo> list = demoRepository.findAllByCargoOrCargoOrCargo("PX", "SM", "BEN");
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet();
        // 添加表头行
        HSSFRow hssfRow = sheet.createRow(0);
        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 添加表头内容
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("NAME");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("CJK");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("ETB");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("ETD");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("CARGO");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(5);
        headCell.setCellValue("QUANTITY");
        headCell.setCellStyle(cellStyle);


        headCell = hssfRow.createCell(6);
        headCell.setCellValue("LAST PORT");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(7);
        headCell.setCellValue("LOA");
        headCell.setCellStyle(cellStyle);
        // 添加数据内容
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                hssfRow = sheet.createRow((int) i + 1);
                Demo demo = list.get(i);

                // 创建单元格，并设置值
                HSSFCell cell = hssfRow.createCell(0);
                cell.setCellValue(demo.getName());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(1);
                cell.setCellValue(demo.getCjk());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(2);
                cell.setCellValue(demo.getEtb());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(3);
                cell.setCellValue(demo.getEtd());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(4);
                cell.setCellValue(demo.getCargo());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(5);
                cell.setCellValue(demo.getQuantity());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(6);
                cell.setCellValue(demo.getLastPort());
                cell.setCellStyle(cellStyle);

                cell = hssfRow.createCell(7);
                cell.setCellValue(demo.getLoa());
                cell.setCellStyle(cellStyle);

            }
        }
        // 保存Excel文件
        try {

            OutputStream outputStream = new FileOutputStream("D:/demo" + LocalDateTime.now().getMonthValue() + LocalDateTime.now().getDayOfMonth() + LocalDateTime.now().getHour() + LocalDateTime.now().getMinute() + ".xls");
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
