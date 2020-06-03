package user.liupeiqing.dynamicdatasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import user.liupeiqing.dynamicdatasource.common.enums.SupportDatasourceEnum;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.HashSet;

@Slf4j
@Configuration
public class DynamicDataSourceConfiguration {

    /**
     * 注入基础的数据源
     * @return
     */
    @Bean
    @Primary
    @ConditionalOnMissingBean
    public DataSource dataSource() {
        System.out.println("init datasource");
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置原始数据源
        HashMap<Object, Object> dataSourcesMap = new HashMap<>();
        HashSet<SupportDatasourceEnum> dataSet = DataSourceContextHolder.getDataSourceSet();
        for (SupportDatasourceEnum supportDatasourceEnum : dataSet) {
            DataSource dataSource = this.createDataSourceProperties(supportDatasourceEnum);
            dataSourcesMap.put(supportDatasourceEnum.toString(), dataSource);
        }
        dynamicDataSource.setTargetDataSources(dataSourcesMap);
        dynamicDataSource.setDefaultTargetDataSource(createDataSourceProperties(SupportDatasourceEnum.PRE_DB));
        return dynamicDataSource;
    }

    private synchronized DataSource createDataSourceProperties(SupportDatasourceEnum supportDatasourceEnum) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(supportDatasourceEnum.getUrl());
        druidDataSource.setUsername(supportDatasourceEnum.getUsername());
        druidDataSource.setPassword(supportDatasourceEnum.getPassword());
        //具体配置
        druidDataSource.setMaxActive(100);
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxWait(30000);
        //间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenConnectErrorMillis(60000);
        return druidDataSource;
    }

}
