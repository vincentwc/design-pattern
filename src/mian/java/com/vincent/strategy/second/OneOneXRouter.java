package com.vincent.strategy.second;

import com.google.common.base.Preconditions;
import com.vincent.strategy.AbstractStrategyRouter;
import com.vincent.strategy.StrategyHandler;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:51
 * @desc
 **/
public class OneOneXRouter extends AbstractStrategyRouter<String, String> implements StrategyHandler<String, String> {


    public static class OneOneXStrategyRouter implements StrategyMapper<String, String> {

        @Override
        public StrategyHandler<String, String> get(String param) {

            if (param.startsWith("111")) {
                return param1 -> new OneOneXRouter().apply(param1);
            } else if (param.startsWith("112")) {
                return param1 -> new OneTwoXRouter().apply(param1);
            } else if (param.startsWith("113")) {
                return param1 -> new OneThreeXRouter().apply(param1);
            }
            return param1 -> "不知道你丫想干嘛11";
        }
    }


    @Override
    protected StrategyMapper<String, String> registerStrategyMapper() {
        return new OneOneXStrategyRouter();
    }

    @Override
    public String apply(String param) {
        Preconditions.checkArgument(param == null || param.startsWith("11"), "Floor1Router's param must start with 11");
        // 业务逻辑的处理
        return applyStrategy(param);
    }


}
