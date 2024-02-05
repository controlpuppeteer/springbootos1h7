package com.dao;

import com.entity.CanyinyudingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CanyinyudingVO;
import com.entity.view.CanyinyudingView;


/**
 * 餐饮预定
 * 
 * @author 
 * @email 
 * @date 2023-02-23 11:38:12
 */
public interface CanyinyudingDao extends BaseMapper<CanyinyudingEntity> {
	
	List<CanyinyudingVO> selectListVO(@Param("ew") Wrapper<CanyinyudingEntity> wrapper);
	
	CanyinyudingVO selectVO(@Param("ew") Wrapper<CanyinyudingEntity> wrapper);
	
	List<CanyinyudingView> selectListView(@Param("ew") Wrapper<CanyinyudingEntity> wrapper);

	List<CanyinyudingView> selectListView(Pagination page,@Param("ew") Wrapper<CanyinyudingEntity> wrapper);
	
	CanyinyudingView selectView(@Param("ew") Wrapper<CanyinyudingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CanyinyudingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CanyinyudingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<CanyinyudingEntity> wrapper);



}
