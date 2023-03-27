package com.oxygen.education.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 企业数据表配置
 * </p>
 *
 * @author oxy
 * @since 2022-12-07
 */
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType;
    }

    public String getRealTable() {
        return realTable;
    }

    public void setRealTable(String realTable) {
        this.realTable = realTable;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "CompanyTableConfig{" +
        "id=" + id +
        ", companyId=" + companyId +
        ", tableType=" + tableType +
        ", realTable=" + realTable +
        ", valid=" + valid +
        "}";
    }
}
