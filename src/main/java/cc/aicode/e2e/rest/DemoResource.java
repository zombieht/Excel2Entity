package cc.aicode.e2e.rest;

import cc.aicode.e2e.service.DemoService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by zombi on 2018/3/3.
 */
@RestController
@RequestMapping("/api")
public class DemoResource {

    @Autowired
    private DemoService demoService;

    @GetMapping("/go")
    public ResponseEntity<Void> go() throws IOException, InvalidFormatException {
        demoService.save("HUAXI TML.xlsx");
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping("/create")
    public ResponseEntity<Void> create() {
        demoService.createExcel();
        return new ResponseEntity(HttpStatus.OK);
    }


}
