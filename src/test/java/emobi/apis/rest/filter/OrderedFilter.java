package emobi.apis.rest.filter;

public interface OrderedFilter extends Filter{
    /**
     * The default precedence
     */
    int DEFAULT_PRECEDENCE = 1000;

    /**
     * Useful constant for the highest precedence value.
     *
     * @see Integer#MIN_VALUE
     */
    int HIGHEST_PRECEDENCE = Integer.MIN_VALUE;

    /**
     * Useful constant for the lowest precedence value.
     *
     * @see Integer#MAX_VALUE
     */
    int LOWEST_PRECEDENCE = Integer.MAX_VALUE;

    /**
     * @return The order of the filter
     */
    int getOrder();
}
