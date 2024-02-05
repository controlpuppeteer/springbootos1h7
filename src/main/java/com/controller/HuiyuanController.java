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
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.plugins.Page;
import com.common.PoetryResult;
import com.req.BaseRequestVO;
import com.service.ICommentService;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.HuiyuanEntity;
import com.entity.view.HuiyuanView;

import com.service.HuiyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 会员
 * 后端接口
 * @author
 * @email
 * @date 2023-02-23 11:38:11
 */
@RestController
@RequestMapping("/huiyuan")
public class HuiyuanController {
    @Autowired
    private HuiyuanService huiyuanService;



	@Autowired
	private TokenService tokenService;

    @Resource
    private ICommentService commentService;
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("zhanghao", username));
		if(u==null || !u.getMima().equals(password)) {
			return R.error("账号或密码不正确");
		}

		String token = tokenService.generateToken(u.getId(), username,"huiyuan",  "会员" );
		return R.ok().put("token", token);
	}


	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody HuiyuanEntity huiyuan){
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("zhanghao", huiyuan.getZhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		huiyuan.setId(uId);
        huiyuanService.insert(huiyuan);
        return R.ok();
    }


	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}

	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        HuiyuanEntity u = huiyuanService.selectById(id);
        return R.ok().put("data", u);
    }

    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("zhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima("123456");
        huiyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,HuiyuanEntity huiyuan,
		HttpServletRequest request){
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();

		PageUtils page = huiyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuan), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,HuiyuanEntity huiyuan,
		HttpServletRequest request){
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();

		PageUtils page = huiyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( HuiyuanEntity huiyuan){
       	EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( huiyuan, "huiyuan"));
        return R.ok().put("data", huiyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(HuiyuanEntity huiyuan){
        EntityWrapper< HuiyuanEntity> ew = new EntityWrapper< HuiyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( huiyuan, "huiyuan"));
		HuiyuanView huiyuanView =  huiyuanService.selectView(ew);
		return R.ok("查询会员成功").put("data", huiyuanView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        HuiyuanEntity huiyuan = huiyuanService.selectById(id);
        return R.ok().put("data", huiyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        HuiyuanEntity huiyuan = huiyuanService.selectById(id);
        return R.ok().put("data", huiyuan);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
    	huiyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("zhanghao", huiyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huiyuan.setId(new Date().getTime());
        huiyuanService.insert(huiyuan);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
    	huiyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(huiyuan);
    	HuiyuanEntity u = huiyuanService.selectOne(new EntityWrapper<HuiyuanEntity>().eq("zhanghao", huiyuan.getZhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		huiyuan.setId(new Date().getTime());
        huiyuanService.insert(huiyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody HuiyuanEntity huiyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(huiyuan);
        huiyuanService.updateById(huiyuan);//全部更新
        return R.ok();
    }




    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        huiyuanService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<HuiyuanEntity> wrapper = new EntityWrapper<HuiyuanEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = huiyuanService.selectCount(wrapper);
		return R.ok().put("count", count);
	}







    /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
        List<Map<String, Object>> result = huiyuanService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("timeStatType", timeStatType);
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
        List<Map<String, Object>> result = huiyuanService.selectTimeStatValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }

    /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
        List<Map<String, Object>> result = huiyuanService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
    }




    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,HuiyuanEntity huiyuan, HttpServletRequest request){
        EntityWrapper<HuiyuanEntity> ew = new EntityWrapper<HuiyuanEntity>();
        int count = huiyuanService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, huiyuan), params), params));
        return R.ok().put("data", count);
    }



}
