package com.vincent.strategy.first;

import com.google.common.base.Preconditions;
import com.vincent.strategy.AbstractStrategyRouter;
import com.vincent.strategy.StrategyHandler;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:51
 * @desc
 **/
public class ThreeXRouter extends AbstractStrategyRouter<String,String> implements StrategyHandler<String,String> {

    @Override
    protected StrategyMapper<String, String> registerStrategyMapper() {

        return null;
    }

    @Override
    public String apply(String param) {
        Preconditions.checkArgument(param == null || param.startsWith("3"), "Floor1Router's param must start with 3");
        return applyStrategy(param);
    }

}
