package com.oxygen.education.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 企业数据表配置
 * </p>
 *
 * @author oxy
 * @since 2022-12-07
 */
@Data
@TableName("company_table_config")
public class CompanyTableConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业主键
     */
    private Integer companyId;

    /**
     * 表类型
     */
    private String tableType;

    /**
     * 真实表名
     */
    private String realTable;

    /**
     * 是否开启，1为是，0为否
     */
    private Integer valid;


}
