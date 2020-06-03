package user.liupeiqing.dynamicdatasource.config;

import user.liupeiqing.dynamicdatasource.common.enums.SupportDatasourceEnum;

import java.util.HashSet;

public class DataSourceContextHolder {

    private static final HashSet<SupportDatasourceEnum> dataSourceSet = new HashSet<>();
    private static final ThreadLocal<String> databaseHolder = new ThreadLocal<>();


    public static void setDatabaseHolder(SupportDatasourceEnum supportDatasourceEnum) {
        databaseHolder.set(supportDatasourceEnum.toString());
    }


    /**
     * 取得当前数据源
     *
     * @return
     */
    public static String getDatabaseHolder() {
        return databaseHolder.get();
    }

    /**
     * 添加数据源
     *
     * @param supportDatasourceEnum
     */
    public static void addDatasource(SupportDatasourceEnum supportDatasourceEnum) {
        dataSourceSet.add(supportDatasourceEnum);
    }

    /**
     * 获取当期应用所支持的所有数据源
     *
     * @return
     */
    public static HashSet<SupportDatasourceEnum> getDataSourceSet() {
        return dataSourceSet;
    }

    /**
     * 清除上下文数据
     */
    public static void clear() {
        databaseHolder.remove();
    }
}
