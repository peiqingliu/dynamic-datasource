package user.liupeiqing.dynamicdatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import user.liupeiqing.dynamicdatasource.common.annotion.AppDataSource;
import user.liupeiqing.dynamicdatasource.common.enums.SupportDatasourceEnum;


@AppDataSource(datasourceType = {SupportDatasourceEnum.DEV_DB, SupportDatasourceEnum.PRE_DB, SupportDatasourceEnum.PROD_DB})
@SpringBootApplication
public class DynamicDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceApplication.class, args);
    }

}
