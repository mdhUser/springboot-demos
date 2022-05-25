package org.maxwell.shardingjdbc.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @TableName t_order_1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TOrder implements Serializable {
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 订单价格
     */
    private BigDecimal price;

    /**
     * 下单用户id
     */
    private Long userId;

    /**
     * 订单状态
     */
    private String status;

    private static final long serialVersionUID = 1L;


}