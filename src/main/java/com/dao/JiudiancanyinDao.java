package com.dao;

import com.entity.JiudiancanyinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiudiancanyinVO;
import com.entity.view.JiudiancanyinView;


/**
 * 酒店餐饮
 * 
 * @author 
 * @email 
 * @date 2023-02-23 11:38:12
 */
public interface JiudiancanyinDao extends BaseMapper<JiudiancanyinEntity> {
	
	List<JiudiancanyinVO> selectListVO(@Param("ew") Wrapper<JiudiancanyinEntity> wrapper);
	
	JiudiancanyinVO selectVO(@Param("ew") Wrapper<JiudiancanyinEntity> wrapper);
	
	List<JiudiancanyinView> selectListView(@Param("ew") Wrapper<JiudiancanyinEntity> wrapper);

	List<JiudiancanyinView> selectListView(Pagination page,@Param("ew") Wrapper<JiudiancanyinEntity> wrapper);
	
	JiudiancanyinView selectView(@Param("ew") Wrapper<JiudiancanyinEntity> wrapper);
	

}
