package emobi.filter.log;


import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLogFilter implements Filter {
    Logger log = LoggerFactory.getLogger(CustomLogFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec, FilterContext ctx) {
        Response response = ctx.next(requestSpec, responseSpec);
        StringBuilder requestBuilder = new StringBuilder();
        requestBuilder.append(requestSpec.getMethod());
        requestBuilder.append("\n");
        requestBuilder.append(requestSpec.getURI());
        requestBuilder.append("\n");
        requestBuilder.append("*************");
        log.info(requestBuilder.toString());  //Log your request where you need it
        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(response.getStatusLine());
        responseBuilder.append("\n");
        responseBuilder.append(response.getBody());
        log.info(responseBuilder.toString()); //Log your response where you need it
        return response;
    }
}
