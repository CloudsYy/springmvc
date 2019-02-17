
package cn.itcast.ssm.controller;

import cn.itcast.ssm.controller.Exception.CustomeException;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsVo;
import cn.itcast.ssm.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author cloud-PC
 * @Title:ItemsController
 * @date:8 Oct 2018 15:02:05
 * @Discription:
 */

//商品controller(测试专用)
@Controller
public class ItemsController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemsMapper itemsMapper;

    @RequestMapping("/queryItems")
    public String  finditemslist(ItemsVo itemsVo,@RequestParam(required = true,defaultValue = "1")Integer page,Model model) throws Exception {
        //从第一条开始，每页查询五条数据记录
        PageHelper.startPage(page,3);

        // 调用service 查找数据库，查询商品列表
        List<ItemsCustom> itemsList = itemService.finditemlist(itemsVo);

        //将itemsList放进model中传到页面。
        model.addAttribute("itemsList",itemsList);

        //将商品信息放入pageinfo对象里
        PageInfo<ItemsCustom> pageInfo=new PageInfo<ItemsCustom>(itemsList);

        //将pageInfo数据放进page中，传到页面中去
        model.addAttribute("page",pageInfo);

        // 创建modelAndView准备填充数据、设置视图
        /*ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("page", pageInfo);

        // 填充数据
        modelAndView.addObject("itemsList",itemsList);*/

        // 视图
        /*modelAndView.setViewName("items/items");*/

        //返回视图
        return "items/items";

    }

    @RequestMapping("/deleteItems")
    public String deleteItems(Integer[] items_id) throws Exception {
        //如果与系统业务功能相关的异常，最好在service抛出异常
        //如果非业务功能的异常，就在controller中抛出
        if (items_id == null) {
            throw new CustomeException("删除失败，没有需要删除的商品信息！");
        } else {
            //调用service批量删除商品信息.
            itemService.deleteItemsbyId(items_id);

            return "success";
        }
    }


    //根据id查询商品信息
    //注解开发中，需要指定映射路径,@RequestParam(value = "id")的作用就相当于对输入进行参数绑定，required则表示是否必须传入参数，
    @RequestMapping(value = "/edititems", method = {RequestMethod.POST, RequestMethod.GET})
    public String edititems(Model model, @RequestParam(value = "id", required = true) Integer item_id) throws Exception {
        //调用service查找数据库，根据id查询商品列表
        ItemsCustom itemsCustom = itemService.finditembyId(item_id);
        //创建modelAndView准备填充数据，查询商品列表
        //ModelAndView modelAndView=new ModelAndView();

        //填充数据,这里相当于modelAndView.addObject("itemsList", itemsList);
        if (itemsCustom == null) {
            throw new CustomeException("修改的商品不存在！");
        }
        model.addAttribute("itemsCustom", itemsCustom);

        //视图
        //返回视图
        return "items/editItems";

    }

    //商品修改提交成功页面
    @RequestMapping(value = "/editItemsSubmit", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    public String editItemsSubmit(Model model, Integer id, @Validated ItemsCustom itemsCustom, BindingResult bindingResult, MultipartFile items_pic) throws Exception {
        //调用service根据页面返回修改的商品的信息
        //......
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }

            model.addAttribute("allerrors", allErrors);

            return "items/editItems";
        }

        //原始名称
        String originalFilename = items_pic.getOriginalFilename();

        //如果已经加入图片，进入修改，但是不重新加图片，此时的originalFilename是为空的，需要加入提交判断
        if (items_pic != null && originalFilename != null && originalFilename.length() > 0) {
            //存图片的物理路径
            String pic_path = "D:\\apache-tomcat-6.0.43\\upload\\";

            //得到新的突破名称
            String newfileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新图片
            File newfile = new File(pic_path + newfileName);

            //将内存中的数据写到磁盘中
            items_pic.transferTo(newfile);

            //将新的图片名称写到数据库中
            itemsCustom.setPic(newfileName);
        }

        //调用service接口，
        itemService.updateitembyId(id, itemsCustom);

        return "success";
    }

    @RequestMapping("/editItemsQuery")
    public String editItemsQuery(Model model, HttpServletRequest request, ItemsVo itemsVo) throws Exception {
        // 调用service 查找数据库，查询商品列表
        List<ItemsCustom> itemsList = itemService.finditemlist(itemsVo);

        // 填充数据
        model.addAttribute("itemsList", itemsList);

        //返回视图
        return "items/editItemsQuery";
    }

    @RequestMapping("/editItemsQuerySubmit")
    public String editItemsQuerySubmit(ItemsVo itemsVo) throws Exception {
        //调用service接口，修改商品信息
        itemService.updateitemList(itemsVo);
        return "success";
    }

    @RequestMapping("/addItems")
    public String addItems(HttpServletRequest request) throws Exception {

        return "items/addItems";
    }

    @RequestMapping("/addItemsSubmit")
    public String addItemsSubmit(Model model,@Validated ItemsCustom itemsCustom, BindingResult bindingResult, MultipartFile items_pic) throws Exception {
         //校验信息。如：长度...
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();

            for (ObjectError objectError : allErrors) {
                System.out.println(objectError.getDefaultMessage());
            }

            model.addAttribute("allerrors", allErrors);

            return "items/editItems";
        }

        //原始名称
        String originalFilename = items_pic.getOriginalFilename();

        //如果已经加入图片，进入修改，但是不重新加图片，此时的originalFilename是为空的，需要加入提交判断
        if (items_pic != null && originalFilename != null && originalFilename.length() > 0) {
            //存图片的物理路径
            String pic_path = "D:\\apache-tomcat-6.0.43\\upload\\";

            //得到新的突破名称
            String newfileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

            //新图片
            File newfile = new File(pic_path + newfileName);

            //将内存中的数据写到磁盘中
            items_pic.transferTo(newfile);

            //将新的图片名称写到数据库中
            itemsCustom.setPic(newfileName);
        }

        //调用service接口，添加商品信息
        itemService.addItems(itemsCustom);

        return "success";
    }

}
