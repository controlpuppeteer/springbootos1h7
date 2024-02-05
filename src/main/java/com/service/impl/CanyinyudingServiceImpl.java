package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CanyinyudingDao;
import com.entity.CanyinyudingEntity;
import com.service.CanyinyudingService;
import com.entity.vo.CanyinyudingVO;
import com.entity.view.CanyinyudingView;

@Service("canyinyudingService")
public class CanyinyudingServiceImpl extends ServiceImpl<CanyinyudingDao, CanyinyudingEntity> implements CanyinyudingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CanyinyudingEntity> page = this.selectPage(
                new Query<CanyinyudingEntity>(params).getPage(),
                new EntityWrapper<CanyinyudingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CanyinyudingEntity> wrapper) {
		  Page<CanyinyudingView> page =new Query<CanyinyudingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CanyinyudingVO> selectListVO(Wrapper<CanyinyudingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CanyinyudingVO selectVO(Wrapper<CanyinyudingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CanyinyudingView> selectListView(Wrapper<CanyinyudingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CanyinyudingView selectView(Wrapper<CanyinyudingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<CanyinyudingEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<CanyinyudingEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<CanyinyudingEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
