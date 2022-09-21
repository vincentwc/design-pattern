package com.vincent.strategy.second;

import com.google.common.base.Preconditions;
import com.vincent.strategy.AbstractStrategyRouter;
import com.vincent.strategy.third.OneTwoOneXRouter;
import com.vincent.strategy.third.OneTwoThreeXRouter;
import com.vincent.strategy.third.OneTwoTwoXRouter;
import com.vincent.strategy.StrategyHandler;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:51
 * @desc
 **/
public class OneTwoXRouter extends AbstractStrategyRouter<String, String> implements StrategyHandler<String, String> {




    @Override
    protected StrategyMapper<String, String> registerStrategyMapper() {
        //
        return new OneTwoXStrategyRouter();
    }

    public static class OneTwoXStrategyRouter implements StrategyMapper<String, String> {

        @Override
        public StrategyHandler<String, String> get(String param) {

            if (param.startsWith("121")) {
                return param1 -> new OneTwoOneXRouter().apply(param1);
            } else if (param.startsWith("122")) {
                return param1 -> new OneTwoTwoXRouter().apply(param1);
            } else if (param.startsWith("123")) {
                return param1 -> new OneTwoThreeXRouter().apply(param1);
            }
            return param1 -> "不知道你丫想干嘛12";
        }
    }

    @Override
    public String apply(String param) {
        Preconditions.checkArgument(param == null || param.startsWith("1"), "Floor1Router's param must start with 1");
        return applyStrategy(param);
    }


}
