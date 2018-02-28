package com.tt.common.config;

/**
 * Created by Riber on 2017/8/7 0007.
 */
public class MySQL5DialectWithoutFK extends org.hibernate.dialect.MySQL5Dialect {
    @Override
    public String getAddForeignKeyConstraintString(String constraintName, String[] foreignKey, String referencedTable, String[] primaryKey, boolean referencesPrimaryKey) {
        return " alter "+ foreignKey[0] +" set default ''" ;
    }
}
