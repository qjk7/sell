package com.imooc.cotroller;

import com.imooc.VO.ProductInfoVO;
import com.imooc.VO.ProductVO;
import com.imooc.VO.ResultVO;
import com.imooc.dataobject.ProductCategory;
import com.imooc.dataobject.ProductInfo;
import com.imooc.service.CategoryService;
import com.imooc.service.ProductService;
import com.imooc.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 */

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 想要使用redis缓存，返回的对象必须是可序列化对象(对象继承Serializable接口)，并使用SerialVersionUID生成序列号
     * cacheNames是redis的保存字段的名字，key必须指定，否则默认为返回对象的id，那每条redis记录都是不同的，即都会缓存
     * @Cacheable(cacheNames = "product" , key = "#id" condition="#id.length >3" unless="#id.length != 0")
     * key可以使用动态的方式，condition是判断条件,unless除非条件
     */

    @GetMapping("/list")
//    @Cacheable(cacheNames = "product" , key = "1001" , unless = "#result.getCode() != 0")
    public ResultVO list(){

        //1.查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目(一次性查询)
//        List<Integer> categoryTypeList = new ArrayList<>();
//        //传统方法
//        for(ProductInfo productInfo:productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(Java8,lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryId(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryId());
            productVO.setCategoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryId())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //数据拷贝
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);

        }

        return ResultVOUtil.success(productVOList);
    }
}
