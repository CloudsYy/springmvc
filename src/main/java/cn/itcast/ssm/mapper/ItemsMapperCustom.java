package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsVo;

import java.util.List;

public interface ItemsMapperCustom {
	public List<ItemsCustom> finditemlist(ItemsVo itemsVo) throws Exception;

	public void deleteItemsbyId(Integer[] items_id) throws Exception;

	public void updateitemList(ItemsVo itemsVo)throws  Exception;

	/*public ItemsCustom finditembyId(Integer id) throws Exception;

	public void updateitembyId(Integer id, ItemsCustom itemsCustom) throws Exception;*/

}