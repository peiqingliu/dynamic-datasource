package user.liupeiqing.dynamicdatasource.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支持的数据源
 */
@AllArgsConstructor
@Getter
public enum SupportDatasourceEnum {

    PROD_DB("jdbc:mysql://localhost:3306/master?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true","root","123qwe123","master"),

    DEV_DB("jdbc:mysql://localhost:3306/slave1?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true","root","123qwe123","slave1"),

    PRE_DB("jdbc:mysql://localhost:3306/slave2?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowPublicKeyRetrieval=true","root","123qwe123","slave2");

    String url;
    String username;
    String password;
    String databaseName;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }

}
