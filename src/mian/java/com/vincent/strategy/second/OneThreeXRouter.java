package com.vincent.strategy.second;

import com.google.common.base.Preconditions;
import com.vincent.strategy.AbstractStrategyRouter;
import com.vincent.strategy.StrategyHandler;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:51
 * @desc
 **/
public class OneThreeXRouter extends AbstractStrategyRouter<String, String> implements StrategyHandler<String, String> {

    public static class OneThreeXStrategyRouter implements StrategyMapper<String, String> {

        @Override
        public StrategyHandler<String, String> get(String param) {

            if (param.startsWith("131")) {
                return param1 -> new OneOneXRouter().apply(param1);
            } else if (param.startsWith("132")) {
                return param1 -> new OneTwoXRouter().apply(param1);
            } else if (param.startsWith("133")) {
                return param1 -> new OneThreeXRouter().apply(param1);
            }
            return param1 -> "不知道你丫想干嘛13";
        }
    }



    @Override
    protected StrategyMapper<String, String> registerStrategyMapper() {
        //
        return new OneThreeXStrategyRouter();
    }

    @Override
    public String apply(String param) {
        Preconditions.checkArgument(param == null || param.startsWith("13"), "Floor1Router's param must start with 13");
        return applyStrategy(param);
    }


}
