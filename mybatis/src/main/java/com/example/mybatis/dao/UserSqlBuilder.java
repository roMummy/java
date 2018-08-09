package com.example.mybatis.dao;

import org.apache.ibatis.jdbc.SQL;

public class UserSqlBuilder {
    public static String buildGetUsersById(final Integer id){
        return new SQL(){{
            SELECT("*");
            FROM("user");
            if (id > 5 ) {
                WHERE("id like #{value} || '%'");
            }
            ORDER_BY("id");
        }}.toString();
    }
}
