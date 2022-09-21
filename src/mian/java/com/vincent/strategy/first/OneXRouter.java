package com.vincent.strategy.first;

import com.google.common.base.Preconditions;
import com.vincent.strategy.AbstractStrategyRouter;
import com.vincent.strategy.second.OneOneXRouter;
import com.vincent.strategy.second.OneThreeXRouter;
import com.vincent.strategy.second.OneTwoXRouter;
import com.vincent.strategy.StrategyHandler;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:51
 * @desc
 **/
public class OneXRouter extends AbstractStrategyRouter<String, String> implements StrategyHandler<String, String> {


    public static class OneXStrategyRouter implements StrategyMapper<String, String> {

        @Override
        public StrategyHandler<String, String> get(String param) {

            if (param.startsWith("11")) {
                return param1 -> new OneOneXRouter().apply(param1);
            } else if (param.startsWith("12")) {
                return param1 -> new OneTwoXRouter().apply(param1);
            } else if (param.startsWith("13")) {
                return param1 -> new OneThreeXRouter().apply(param1);
            }
            return param1 -> "不知道你丫想干嘛";
        }
    }


    @Override
    protected StrategyMapper<String, String> registerStrategyMapper() {
        return new OneXStrategyRouter();
    }

    @Override
    public String apply(String param) {
        Preconditions.checkArgument(param == null || param.startsWith("1"), "Floor1Router's param must start with 1");

        return applyStrategy(param);
    }


}
