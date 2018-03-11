package cc.aicode.e2e;

import cc.aicode.e2e.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.out.println("拖入文件");
        DemoService demoService = new DemoService();

        try {
            if (args.length == 1) {
                demoService.save(args[0]);
            } else {
                System.out.println("参数格式不正确");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
