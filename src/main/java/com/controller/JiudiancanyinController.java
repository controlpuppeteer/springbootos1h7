package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiudiancanyinEntity;
import com.entity.view.JiudiancanyinView;

import com.service.JiudiancanyinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 酒店餐饮
 * 后端接口
 * @author 
 * @email 
 * @date 2023-02-23 11:38:12
 */
@RestController
@RequestMapping("/jiudiancanyin")
public class JiudiancanyinController {
    @Autowired
    private JiudiancanyinService jiudiancanyinService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiudiancanyinEntity jiudiancanyin,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			jiudiancanyin.setYuangonggonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiudiancanyinEntity> ew = new EntityWrapper<JiudiancanyinEntity>();

		PageUtils page = jiudiancanyinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudiancanyin), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiudiancanyinEntity jiudiancanyin, 
		HttpServletRequest request){
        EntityWrapper<JiudiancanyinEntity> ew = new EntityWrapper<JiudiancanyinEntity>();

		PageUtils page = jiudiancanyinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudiancanyin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiudiancanyinEntity jiudiancanyin){
       	EntityWrapper<JiudiancanyinEntity> ew = new EntityWrapper<JiudiancanyinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiudiancanyin, "jiudiancanyin")); 
        return R.ok().put("data", jiudiancanyinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiudiancanyinEntity jiudiancanyin){
        EntityWrapper< JiudiancanyinEntity> ew = new EntityWrapper< JiudiancanyinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiudiancanyin, "jiudiancanyin")); 
		JiudiancanyinView jiudiancanyinView =  jiudiancanyinService.selectView(ew);
		return R.ok("查询酒店餐饮成功").put("data", jiudiancanyinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiudiancanyinEntity jiudiancanyin = jiudiancanyinService.selectById(id);
		jiudiancanyin.setClicknum(jiudiancanyin.getClicknum()+1);
		jiudiancanyin.setClicktime(new Date());
		jiudiancanyinService.updateById(jiudiancanyin);
        return R.ok().put("data", jiudiancanyin);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiudiancanyinEntity jiudiancanyin = jiudiancanyinService.selectById(id);
		jiudiancanyin.setClicknum(jiudiancanyin.getClicknum()+1);
		jiudiancanyin.setClicktime(new Date());
		jiudiancanyinService.updateById(jiudiancanyin);
        return R.ok().put("data", jiudiancanyin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiudiancanyinEntity jiudiancanyin, HttpServletRequest request){
    	jiudiancanyin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiudiancanyin);
        jiudiancanyinService.insert(jiudiancanyin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
	@IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody JiudiancanyinEntity jiudiancanyin, HttpServletRequest request){
    	jiudiancanyin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiudiancanyin);
        jiudiancanyinService.insert(jiudiancanyin);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiudiancanyinEntity jiudiancanyin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiudiancanyin);
        jiudiancanyinService.updateById(jiudiancanyin);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiudiancanyinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiudiancanyinEntity> wrapper = new EntityWrapper<JiudiancanyinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yuangong")) {
			wrapper.eq("yuangonggonghao", (String)request.getSession().getAttribute("username"));
		}

		int count = jiudiancanyinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JiudiancanyinEntity jiudiancanyin, HttpServletRequest request,String pre){
        EntityWrapper<JiudiancanyinEntity> ew = new EntityWrapper<JiudiancanyinEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = jiudiancanyinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiudiancanyin), params), params));
        return R.ok().put("data", page);
    }









}
