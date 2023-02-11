package com.oxygen.education.mybatis.type;


import com.oxygen.education.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 小欧说编程
 * @param <T>
 */
@MappedJdbcTypes({JdbcType.INTEGER, JdbcType.VARCHAR})
@MappedTypes(value = BaseEnum.class)
public class CustomEnumTypeHandler<T> extends BaseTypeHandler<BaseEnum<T>> {
    private final Class<BaseEnum> type;

    public CustomEnumTypeHandler(Class<BaseEnum> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, BaseEnum<T> parameter, JdbcType jdbcType) throws SQLException {
        // 如果没有jdbc type 那么则使用 int 作为默认的类型
        if (jdbcType == null) {
            ps.setInt((Integer) parameter.getValue(), i);
        } else {
            ps.setObject(i, parameter.getValue(), jdbcType.TYPE_CODE);
        }
    }

    @Override
    public BaseEnum<T> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return getBaseEnum(rs.getObject(columnName), rs.getInt(columnName), rs.getString(columnName));
    }

    public BaseEnum<T> getBaseEnum(Object object, int anInt, String string) {
        Object valObj = object;
        if (valObj instanceof Integer) {
            Integer val = anInt;
            return val == null ? null : BaseEnum.valueOfEnum(type, val);
        } else {
            String val = string;
            return val == null ? null : BaseEnum.valueOfEnum(type, val);
        }
    }

    @Override
    public BaseEnum<T> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return getBaseEnum(rs.getObject(columnIndex), rs.getInt(columnIndex), rs.getString(columnIndex));
    }

    @Override
    public BaseEnum<T> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return getBaseEnum(cs.getObject(columnIndex), cs.getInt(columnIndex), cs.getString(columnIndex));
    }
}
