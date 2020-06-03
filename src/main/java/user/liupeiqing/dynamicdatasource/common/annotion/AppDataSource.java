package user.liupeiqing.dynamicdatasource.common.annotion;


import org.springframework.context.annotation.Import;
import user.liupeiqing.dynamicdatasource.common.enums.SupportDatasourceEnum;
import user.liupeiqing.dynamicdatasource.config.DataSourceConfigRegister;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DataSourceConfigRegister.class)
public @interface AppDataSource {
    SupportDatasourceEnum[] datasourceType();
}
