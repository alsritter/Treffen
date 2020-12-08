package com.alsritter.treffen.controller.vo;

import com.alsritter.treffen.entity.TbMenuItem;
import com.alsritter.treffen.entity.TbMenuItemGroup;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 一个 Menu 对象表示一个组
 * 内部的 MenuItemList 表示其子 Item
 *
 * @author alsritter
 * @version 1.0
 **/
@Data
public class Menu {
    @ApiModelProperty("分组信息")
    private TbMenuItemGroup menuItemGroup;
    @ApiModelProperty("该分组下的 item")
    private List<TbMenuItem> itemList;
}
