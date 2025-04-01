package com.entity.view;

import com.entity.GaoumaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

/**
 * 已有保险
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("gaoumai")
public class GaoumaiView extends GaoumaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;



		//级联表 baoxian
			/**
			* 保险名称
			*/
			private String bxname;
			/**
			* 保险费用
			*/
			private Double bxmoney;
			/**
			* 赔偿金额
			*/
			private Double bxamountpaid;
			/**
			* 保险类型
			*/
			private Integer leixingTypes;
				/**
				* 保险类型的值
				*/
				private String leixingValue;
			/**
			* 保险详情
			*/
			private String neirongContent;

		//级联表 yonghu
			/**
			* 名称
			*/
			private String name;
			/**
			* 账号
			*/
			private String username;
			/**
			* 密码
			*/
			private String password;
			/**
			* 头像
			*/
			private String imgPhoto;
			/**
			* 性别
			*/
			private Integer sexTypes;
				/**
				* 性别的值
				*/
				private String sexValue;
			/**
			* 手机号
			*/
			private String phone;
			/**
			* 身份证
			*/
			private String idNumber;
			/**
			* 身份
			*/
			private String role;

	public GaoumaiView() {

	}

	public GaoumaiView(GaoumaiEntity gaoumaiEntity) {
		try {
			BeanUtils.copyProperties(this, gaoumaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}








				//级联表的get和set baoxian
					/**
					* 获取： 保险名称
					*/
					public String getBxname() {
						return bxname;
					}
					/**
					* 设置： 保险名称
					*/
					public void setBxname(String bxname) {
						this.bxname = bxname;
					}
					/**
					* 获取： 保险费用
					*/
					public Double getBxmoney() {
						return bxmoney;
					}
					/**
					* 设置： 保险费用
					*/
					public void setBxmoney(Double bxmoney) {
						this.bxmoney = bxmoney;
					}
					/**
					* 获取： 赔偿金额
					*/
					public Double getBxamountpaid() {
						return bxamountpaid;
					}
					/**
					* 设置： 赔偿金额
					*/
					public void setBxamountpaid(Double bxamountpaid) {
						this.bxamountpaid = bxamountpaid;
					}
					/**
					* 获取： 保险类型
					*/
					public Integer getLeixingTypes() {
						return leixingTypes;
					}
					/**
					* 设置： 保险类型
					*/
					public void setLeixingTypes(Integer leixingTypes) {
						this.leixingTypes = leixingTypes;
					}


						/**
						* 获取： 保险类型的值
						*/
						public String getLeixingValue() {
							return leixingValue;
						}
						/**
						* 设置： 保险类型的值
						*/
						public void setLeixingValue(String leixingValue) {
							this.leixingValue = leixingValue;
						}
					/**
					* 获取： 保险详情
					*/
					public String getNeirongContent() {
						return neirongContent;
					}
					/**
					* 设置： 保险详情
					*/
					public void setNeirongContent(String neirongContent) {
						this.neirongContent = neirongContent;
					}











				//级联表的get和set yonghu
					/**
					* 获取： 名称
					*/
					public String getName() {
						return name;
					}
					/**
					* 设置： 名称
					*/
					public void setName(String name) {
						this.name = name;
					}
					/**
					* 获取： 账号
					*/
					public String getUsername() {
						return username;
					}
					/**
					* 设置： 账号
					*/
					public void setUsername(String username) {
						this.username = username;
					}
					/**
					* 获取： 密码
					*/
					public String getPassword() {
						return password;
					}
					/**
					* 设置： 密码
					*/
					public void setPassword(String password) {
						this.password = password;
					}
					/**
					* 获取： 头像
					*/
					public String getImgPhoto() {
						return imgPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setImgPhoto(String imgPhoto) {
						this.imgPhoto = imgPhoto;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 手机号
					*/
					public String getPhone() {
						return phone;
					}
					/**
					* 设置： 手机号
					*/
					public void setPhone(String phone) {
						this.phone = phone;
					}
					/**
					* 获取： 身份证
					*/
					public String getIdNumber() {
						return idNumber;
					}
					/**
					* 设置： 身份证
					*/
					public void setIdNumber(String idNumber) {
						this.idNumber = idNumber;
					}
					/**
					* 获取： 身份
					*/
					public String getRole() {
						return role;
					}
					/**
					* 设置： 身份
					*/
					public void setRole(String role) {
						this.role = role;
					}




}
