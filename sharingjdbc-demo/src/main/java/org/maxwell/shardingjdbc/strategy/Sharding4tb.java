package org.maxwell.shardingjdbc.strategy;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @description: 定义精准查询库的算法类
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/20 23:57
 */

@Slf4j
public class Sharding4tb implements PreciseShardingAlgorithm<Long> {


    @Override
    public String doSharding(Collection<String> tbNames, PreciseShardingValue<Long> shardingValue) {

        String columnName = shardingValue.getColumnName();
        log.info("分片键名：{}", columnName);
        Long value = shardingValue.getValue();
        log.info("分片键值：{}", value);
        String logicTableName = shardingValue.getLogicTableName();
        log.info("获取分片逻辑表名：{}", logicTableName);

        String idx = String.valueOf(value % 2 + 1);
        return tbNames.stream().filter(d -> d.endsWith(idx)).findFirst().get();
    }
}
