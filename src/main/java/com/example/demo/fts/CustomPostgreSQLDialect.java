package com.example.demo.fts;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.BooleanType;
import org.hibernate.type.DoubleType;
import org.hibernate.type.ObjectType;

public class CustomPostgreSQLDialect extends PostgreSQL9Dialect {
    public CustomPostgreSQLDialect() {
        registerFunction("fts", new PgFullTextDialect());
        registerFunction("ts_rank", new StandardSQLFunction("ts_rank", DoubleType.INSTANCE));
        registerFunction("to_tsquery", new StandardSQLFunction("to_tsquery", ObjectType.INSTANCE));
    }
}
