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
 * 已有保险
 *
 * @author 
 * @email
 * @date 2021-03-24
 */
@TableName("gaoumai")
public class GaoumaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GaoumaiEntity() {

	}

	public GaoumaiEntity(T t) {
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
     * 购买人
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 购买保险
     */
    @TableField(value = "baoxian_id")

    private Integer baoxianId;


    /**
     * 购买时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "goumai_time",fill = FieldFill.UPDATE)

    private Date goumaiTime;


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
	 * 设置：购买人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：购买人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：购买保险
	 */
    public Integer getBaoxianId() {
        return baoxianId;
    }


    /**
	 * 获取：购买保险
	 */

    public void setBaoxianId(Integer baoxianId) {
        this.baoxianId = baoxianId;
    }
    /**
	 * 设置：购买时间
	 */
    public Date getGoumaiTime() {
        return goumaiTime;
    }


    /**
	 * 获取：购买时间
	 */

    public void setGoumaiTime(Date goumaiTime) {
        this.goumaiTime = goumaiTime;
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
        return "Gaoumai{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", baoxianId=" + baoxianId +
            ", goumaiTime=" + goumaiTime +
            ", createTime=" + createTime +
        "}";
    }
}
