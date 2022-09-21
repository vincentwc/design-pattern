package com.vincent.strategy.root;

import com.vincent.strategy.AbstractStrategyRouter;
import com.vincent.strategy.first.OneXRouter;
import com.vincent.strategy.StrategyHandler;
import com.vincent.strategy.first.ThreeXRouter;
import com.vincent.strategy.first.TwoXRouter;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:45
 * @desc
 **/
public class RootRouter extends AbstractStrategyRouter<String, String> {

    @Override
    protected StrategyMapper<String, String> registerStrategyMapper() {
        return new RootStrategyMapper();
    }

    public static class RootStrategyMapper implements StrategyMapper<String, String> {

        @Override
        public StrategyHandler<String, String> get(String param) {

            if (param.startsWith("1")) {
                return param1 -> new OneXRouter().apply(param1);
            } else if (param.startsWith("2")) {
                return param1 -> new TwoXRouter().apply(param1);
            } else if (param.startsWith("3")) {
                return param1 -> new ThreeXRouter().apply(param1);
            }
            return param1 -> "不知道你丫想干嘛";
        }
    }



    public static void main(String[] args) {
        RootRouter rootRouter = new RootRouter();
        String result = rootRouter.applyStrategy("1234");
        System.out.println(result);
    }


}
