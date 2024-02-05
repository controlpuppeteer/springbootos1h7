package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CanyinyudingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CanyinyudingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CanyinyudingView;


/**
 * 餐饮预定
 *
 * @author 
 * @email 
 * @date 2023-02-23 11:38:12
 */
public interface CanyinyudingService extends IService<CanyinyudingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CanyinyudingVO> selectListVO(Wrapper<CanyinyudingEntity> wrapper);
   	
   	CanyinyudingVO selectVO(@Param("ew") Wrapper<CanyinyudingEntity> wrapper);
   	
   	List<CanyinyudingView> selectListView(Wrapper<CanyinyudingEntity> wrapper);
   	
   	CanyinyudingView selectView(@Param("ew") Wrapper<CanyinyudingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CanyinyudingEntity> wrapper);
   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<CanyinyudingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<CanyinyudingEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<CanyinyudingEntity> wrapper);



}

