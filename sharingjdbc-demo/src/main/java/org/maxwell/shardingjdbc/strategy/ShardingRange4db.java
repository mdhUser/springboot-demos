package org.maxwell.shardingjdbc.strategy;

import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/21 0:32
 */
@Slf4j
public class ShardingRange4db implements RangeShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(Collection<String> dbNames, RangeShardingValue<Long> rangeShardingValue) {
        String columnName = rangeShardingValue.getColumnName();
        log.info("分片键名：{}", columnName);
        Range<Long> valueRange = rangeShardingValue.getValueRange();
        log.info("分片键值范围：{}", valueRange);
        String logicTableName = rangeShardingValue.getLogicTableName();
        log.info("获取分片逻辑表名：{}", logicTableName);

        //判断是否有范围查询的起始值
        if (valueRange.hasLowerBound()) {
            //获取起始值
            Long start = valueRange.lowerEndpoint();
            log.info("获取起始值{}",start);
        }
        //判断是否有上限值
        if (valueRange.hasUpperBound()) {
            Long end = valueRange.upperEndpoint();
        }
        //一般会根据start和end值找符合条件的数据源集合
        return Arrays.asList("ds1", "ds2");
    }


}
