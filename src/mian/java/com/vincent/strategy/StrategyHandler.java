package com.vincent.strategy;

/**
 *
 * @author admin
 * @param <T>
 * @param <R>
 */
public interface StrategyHandler<T, R> {
 
    @SuppressWarnings("rawtypes")
    StrategyHandler DEFAULT = t -> null;
 
    /**
     * apply strategy
     *
     * @param param
     * @return
     */
    R apply(T param);
}