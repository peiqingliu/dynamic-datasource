package user.liupeiqing.dynamicdatasource.common.annotion;


import user.liupeiqing.dynamicdatasource.common.enums.SupportDatasourceEnum;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UsingDataSource {

    SupportDatasourceEnum type()  ;
}
