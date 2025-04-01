package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 保险
 *
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("baoxian")
public class BaoxianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BaoxianEntity() {

	}

	public BaoxianEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 保险名称
     */
    @TableField(value = "bxname")

    private String bxname;


    /**
     * 保险费用
     */
    @TableField(value = "bxmoney")

    private Double bxmoney;


    /**
     * 赔偿金额
     */
    @TableField(value = "bxamountpaid")

    private Double bxamountpaid;


    /**
     * 保险类型
     */
    @TableField(value = "leixing_types")

    private Integer leixingTypes;


    /**
     * 保险详情
     */
    @TableField(value = "neirong_content")

    private String neirongContent;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：保险名称
	 */
    public String getBxname() {
        return bxname;
    }


    /**
	 * 获取：保险名称
	 */

    public void setBxname(String bxname) {
        this.bxname = bxname;
    }
    /**
	 * 设置：保险费用
	 */
    public Double getBxmoney() {
        return bxmoney;
    }


    /**
	 * 获取：保险费用
	 */

    public void setBxmoney(Double bxmoney) {
        this.bxmoney = bxmoney;
    }
    /**
	 * 设置：赔偿金额
	 */
    public Double getBxamountpaid() {
        return bxamountpaid;
    }


    /**
	 * 获取：赔偿金额
	 */

    public void setBxamountpaid(Double bxamountpaid) {
        this.bxamountpaid = bxamountpaid;
    }
    /**
	 * 设置：保险类型
	 */
    public Integer getLeixingTypes() {
        return leixingTypes;
    }


    /**
	 * 获取：保险类型
	 */

    public void setLeixingTypes(Integer leixingTypes) {
        this.leixingTypes = leixingTypes;
    }
    /**
	 * 设置：保险详情
	 */
    public String getNeirongContent() {
        return neirongContent;
    }


    /**
	 * 获取：保险详情
	 */

    public void setNeirongContent(String neirongContent) {
        this.neirongContent = neirongContent;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Baoxian{" +
            "id=" + id +
            ", bxname=" + bxname +
            ", bxmoney=" + bxmoney +
            ", bxamountpaid=" + bxamountpaid +
            ", leixingTypes=" + leixingTypes +
            ", neirongContent=" + neirongContent +
            ", createTime=" + createTime +
        "}";
    }
}
