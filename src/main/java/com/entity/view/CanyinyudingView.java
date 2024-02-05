package com.entity.view;

import com.entity.CanyinyudingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 餐饮预定
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-02-23 11:38:12
 */
@TableName("canyinyuding")
public class CanyinyudingView  extends CanyinyudingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CanyinyudingView(){
	}
 
 	public CanyinyudingView(CanyinyudingEntity canyinyudingEntity){
 	try {
			BeanUtils.copyProperties(this, canyinyudingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
