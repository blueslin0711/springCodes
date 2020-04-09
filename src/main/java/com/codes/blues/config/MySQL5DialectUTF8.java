package com.codes.blues.config;

import org.hibernate.dialect.MySQL55Dialect;

public class MySQL5DialectUTF8 extends MySQL55Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}