package com.vincent.strategy.third;

import com.google.common.base.Preconditions;
import com.vincent.strategy.StrategyHandler;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:51
 * @desc
 **/
public class OneTwoTwoXRouter implements StrategyHandler<String, String> {



    @Override
    public String apply(String param) {
        Preconditions.checkArgument(param == null || param.startsWith("1"), "Floor1Router's param must start with 1");
        System.out.println("到达最底层啦122");
        return param;
    }


}
