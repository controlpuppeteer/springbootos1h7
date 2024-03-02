package com.service.impl;

import com.utils.R;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KefangxinxiDao;
import com.entity.KefangxinxiEntity;
import com.service.KefangxinxiService;
import com.entity.vo.KefangxinxiVO;
import com.entity.view.KefangxinxiView;

@Service("kefangxinxiService")
public class KefangxinxiServiceImpl extends ServiceImpl<KefangxinxiDao, KefangxinxiEntity> implements KefangxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KefangxinxiEntity> page = this.selectPage(
                new Query<KefangxinxiEntity>(params).getPage(),
                new EntityWrapper<KefangxinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KefangxinxiEntity> wrapper) {
		  Page<KefangxinxiView> page =new Query<KefangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<KefangxinxiVO> selectListVO(Wrapper<KefangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public KefangxinxiVO selectVO(Wrapper<KefangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<KefangxinxiView> selectListView(Wrapper<KefangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KefangxinxiView selectView(Wrapper<KefangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<KefangxinxiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<KefangxinxiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<KefangxinxiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }

	@Override
	public R updateCommentStatusById(Integer kefangId, Integer status) {
		return R.ok(baseMapper.updateCommentStatusById(kefangId,status));
	}


}
