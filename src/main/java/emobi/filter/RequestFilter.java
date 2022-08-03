package emobi.filter;

import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public abstract class RequestFilter implements Filter {
    protected Response response;
    protected FilterableRequestSpecification requestSpec;
    protected FilterableResponseSpecification responseSpec;
    protected FilterContext ctx;

    public abstract boolean condition();

    public abstract void action();

    @Override
    public boolean isLoggable(LogRecord record) {
        return false;
    }
}