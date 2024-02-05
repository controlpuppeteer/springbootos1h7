package com.dao;

import com.entity.HuiyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuiyuanVO;
import com.entity.view.HuiyuanView;


/**
 * 会员
 * 
 * @author 
 * @email 
 * @date 2023-02-23 11:38:11
 */
public interface HuiyuanDao extends BaseMapper<HuiyuanEntity> {
	
	List<HuiyuanVO> selectListVO(@Param("ew") Wrapper<HuiyuanEntity> wrapper);
	
	HuiyuanVO selectVO(@Param("ew") Wrapper<HuiyuanEntity> wrapper);
	
	List<HuiyuanView> selectListView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);

	List<HuiyuanView> selectListView(Pagination page,@Param("ew") Wrapper<HuiyuanEntity> wrapper);
	
	HuiyuanView selectView(@Param("ew") Wrapper<HuiyuanEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuiyuanEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuiyuanEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuiyuanEntity> wrapper);



}
