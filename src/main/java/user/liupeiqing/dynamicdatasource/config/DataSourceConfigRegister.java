package user.liupeiqing.dynamicdatasource.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import user.liupeiqing.dynamicdatasource.common.annotion.AppDataSource;
import user.liupeiqing.dynamicdatasource.common.enums.SupportDatasourceEnum;

import java.util.Map;

public class DataSourceConfigRegister implements ImportSelector {

    /**
     * 返回值：导入到spring容器中的组件全类名
     *
     * 1、返回值： 就是我们实际上要导入到容器中的组件全类名【重点 】
     * 2、参数： AnnotationMetadata表示当前被@Import注解给标注的所有注解信息【不是重点】
     *
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(AppDataSource.class.getName()));
        System.out.println("#######  datasource import #######");
        if (null != attributes) {
            Object object = attributes.get("datasourceType");
            SupportDatasourceEnum[] supportDatasourceEnums = (SupportDatasourceEnum[]) object;
            for (SupportDatasourceEnum supportDatasourceEnum : supportDatasourceEnums) {
                DataSourceContextHolder.addDatasource(supportDatasourceEnum);
            }
        }
        return new String[0];
    }
}
