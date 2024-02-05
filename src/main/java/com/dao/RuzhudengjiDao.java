package com.dao;

import com.entity.RuzhudengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RuzhudengjiVO;
import com.entity.view.RuzhudengjiView;


/**
 * 入住登记
 * 
 * @author 
 * @email 
 * @date 2023-02-23 11:38:12
 */
public interface RuzhudengjiDao extends BaseMapper<RuzhudengjiEntity> {
	
	List<RuzhudengjiVO> selectListVO(@Param("ew") Wrapper<RuzhudengjiEntity> wrapper);
	
	RuzhudengjiVO selectVO(@Param("ew") Wrapper<RuzhudengjiEntity> wrapper);
	
	List<RuzhudengjiView> selectListView(@Param("ew") Wrapper<RuzhudengjiEntity> wrapper);

	List<RuzhudengjiView> selectListView(Pagination page,@Param("ew") Wrapper<RuzhudengjiEntity> wrapper);
	
	RuzhudengjiView selectView(@Param("ew") Wrapper<RuzhudengjiEntity> wrapper);
	

}
