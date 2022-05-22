package org.maxwell.springboot;

import org.junit.jupiter.api.Test;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/4 10:12
 */
public class Demo {

    @Test
    public void test() {

        int i = 10;
        int j = 10;

        int sum1 = (i++) + (i++) + (i++),
                sum2 = (++j) + (++j) + (++j);

        System.out.println(sum1+","+sum2);
    }
}
