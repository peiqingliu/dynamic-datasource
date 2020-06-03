package user.liupeiqing.dynamicdatasource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 这个方法适用于提供给开发者自定义对应数据源的查询key
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceContextHolder.getDatabaseHolder();
        return dataSource;
    }
}
