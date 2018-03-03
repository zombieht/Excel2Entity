package cc.aicode.e2e.service;

import cc.aicode.e2e.ExcelHelper;
import cc.aicode.e2e.domain.Demo;
import cc.aicode.e2e.exception.ExcelContentInvalidException;
import cc.aicode.e2e.exception.ExcelParseException;
import cc.aicode.e2e.exception.ExcelRegexpValidFailedException;
import cc.aicode.e2e.repository.DemoRepository;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * Created by zombi on 2018/3/3.
 */
@Service
@Transactional
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;

    public void save() throws IOException, InvalidFormatException {

        ExcelHelper eh = ExcelHelper.readExcel("HUAXI TML.xlsx");

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
}
