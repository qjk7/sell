package com.imooc.VO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商品详情
 */

@Data
public class ProductInfoVO implements Serializable {


    private static final long serialVersionUID = 2282190241274267647L;

    @JsonProperty("id")
    private String ProductId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;

    @JsonProperty("stock")
    private Integer productStock;
}
