package cn.itcast.ssm.po;

import cn.itcast.ssm.mapper.ItemsMapperCustom;

import java.util.List;

/**
 * 
 * @Title:ItemsMapperVo
 * @date:24 Oct 2018 15:39:15
 * @author cloud-PC
 * @Discription:商品包装类
 */
public class ItemsVo {

	private Items items;

    private ItemsCustom itemsCustom;

	private List<ItemsCustom> itemsList;

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}

    public List<ItemsCustom> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ItemsCustom> itemsList) {
        this.itemsList = itemsList;
    }

}