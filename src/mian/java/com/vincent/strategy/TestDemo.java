package com.vincent.strategy;

import com.vincent.strategy.root.RootRouter;

/**
 * @author wang_cheng
 * @date 2022/09/13 10:59
 * @desc
 **/
public class TestDemo {

    public static void main(String[] args) {
        RootRouter rootRouter = new RootRouter();

        String s = rootRouter.applyStrategy("123");
        System.out.println(s);
    }
}
