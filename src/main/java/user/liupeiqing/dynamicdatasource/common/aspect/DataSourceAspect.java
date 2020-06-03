package user.liupeiqing.dynamicdatasource.common.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import user.liupeiqing.dynamicdatasource.common.annotion.UsingDataSource;
import user.liupeiqing.dynamicdatasource.config.DataSourceContextHolder;

@Slf4j
@Aspect
@Configuration
public class DataSourceAspect {

    public DataSourceAspect(){
        System.out.println("this is init");
    }

    @Pointcut("@within(user.liupeiqing.dynamicdatasource.common.annotion.UsingDataSource) || " +
            "@annotation(user.liupeiqing.dynamicdatasource.common.annotion.UsingDataSource)")
    public void pointCut(){

    }

    @Before("pointCut() && @annotation(usingDataSource)")
    public void doBefore(UsingDataSource usingDataSource){
        log.debug("select dataSource---"+usingDataSource.type());
        DataSourceContextHolder.setDatabaseHolder(usingDataSource.type());
    }

    @After("pointCut()")
    public void doAfter(){
        DataSourceContextHolder.clear();
    }


}
