package com.oxygen.education.convert;

import com.oxygen.education.dto.UserDto;
import com.oxygen.education.model.UserModel;
import com.oxygen.education.param.UserSaveParam;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
 * @author oxy
 */
@Mapper(componentModel = "spring")
public interface UserConvert {
    /**
     * 转换model
     * @param u
     * @return
     */
    @Mapping(target = "gender", expression = "java(u.getGender().getCode())")
    @Mapping(target = "realName", source = "name")
    UserModel toModel(UserSaveParam u);

    /**
     * 转换model列表
     * @param u
     * @return
     */
    List<UserModel> toModel(List<UserSaveParam> u);

    /**
     * 转换dto
     * @param t
     * @return
     */
    @Mapping(target = "gender", expression = "java(com.oxygen.education.enums.GenderEnum.getByGender(t.getGender()))")
    @Mapping(target = "createdAt", dateFormat = "yyy-MM-dd HH:mm:ss")
    @Mapping(target = "updatedAt", dateFormat = "yyy-MM-dd HH:mm:ss")
    @Mapping(target = "name", source = "realName")
    UserDto toDto(UserModel t);

    /**
     * 转换dto列表
     * @param t
     * @return
     */
    List<UserDto> toDto(List<UserModel> t);

}
