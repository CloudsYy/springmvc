package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsVo;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

/**
 * @Title:ItemService
 * @date:24 Oct 2018 15:27:50
 * @author cloud-PC
 * @Discription:商品信息接口
 */

public interface ItemService {
	//查询商品信息
	public List<ItemsCustom> finditemlist(ItemsVo itemsVo) throws Exception;

	//根据id查询商品信息
	public ItemsCustom finditembyId(Integer id) throws Exception;

	//根据id修改商品信息
	public void updateitembyId(Integer id,ItemsCustom itemsCustom) throws Exception;

	public void deleteItemsbyId(Integer[] items_id) throws Exception;

	public void updateitemList(ItemsVo itemsVo)throws  Exception;

	public void addItems(Items items)throws Exception;
}
