/**
 *@Title:itemsImp
 *@date:24 Oct 2018 16:10:47
 *@author cloud-PC
 *@Discription:
 */
package cn.itcast.ssm.service.Imp;

import java.util.List;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.po.Items;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsVo;
import cn.itcast.ssm.service.ItemService;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

/**
 * @Title:itemsImp
 * @date:24 Oct 2018 16:10:47
 * @author cloud-PC
 * @Discription:
 */
@Service("ItemService")
public class itemsImp implements ItemService {

	@Autowired
	private ItemsMapperCustom itemsMapperCustom;

	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> finditemlist(ItemsVo itemsVo) throws Exception {
		return itemsMapperCustom.finditemlist(itemsVo);
	}

	//根据id查询商品信息
	@Override
	public ItemsCustom finditembyId(Integer id) throws Exception {
		Items items = itemsMapper.selectByPrimaryKey(id);
		//中间商品信息业务处理
		//...
		//返回ItemsCustom
		ItemsCustom itemsCustom = null;
		if (items != null) {
			//将items的属性值拷贝到itemsCustom中
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}

		return itemsCustom;
	}

	//更新商品信息
	@Override
	public void updateitembyId(Integer id, ItemsCustom itemsCustom){
		//需要添加一些业务校验，在service接口中对一些关键的参数进行校验
		//如校验id是否为空，为空则抛出异常....
		//此处的setid无论是否是重复的操作都要设置一下，因为上面我们已经传入
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);

	}

	@Override
	public void deleteItemsbyId(Integer[] items_id) throws Exception {
		itemsMapperCustom.deleteItemsbyId(items_id);
	}

	@Override
	public void updateitemList(ItemsVo itemsVo) throws Exception{
		itemsMapperCustom.updateitemList(itemsVo);

	}

	@Override
	public void addItems(Items items) throws Exception {
		itemsMapper.insert(items);
	}

}
