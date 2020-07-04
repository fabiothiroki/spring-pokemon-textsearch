package com.example.demo.fts;

import org.hibernate.QueryException;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.BooleanType;
import org.hibernate.type.Type;

import java.util.List;

public class PgFullTextDialect implements SQLFunction {

    @Override
    public boolean hasArguments() {
        return true;
    }

    @Override

    public boolean hasParenthesesIfNoArguments() {
        return false;
    }

    @Override

    public Type getReturnType(final Type firstArgumentType, final Mapping mapping) throws QueryException {
        return new BooleanType();
    }


    @Override
    public String render(Type firstArgumentType, List arguments, SessionFactoryImplementor factory) throws QueryException {
//        if (arguments == null || arguments.size() < 2) {
//            throw new IllegalArgumentException("The function must be passed at least 2 arguments");
//        }

        String searchString = (String) arguments.get(0);

        return "to_tsvector(description) " +
                "@@ " + "plainto_tsquery('" + searchString + "')";
    }
}
