package com.oxygen.education.convert;

import com.oxygen.education.model.UserModel;
import com.oxygen.education.param.UserSaveParam;

/**
 * @author oxy
 */
public class UserConvertUtil {
   public static UserModel toModel(UserSaveParam u){
       UserModel userModel = new UserModel();
       userModel.setCompanyId(u.getCompanyId());
       userModel.setPhone(u.getPhone());
       userModel.setGender(u.getGender().getCode());
       userModel.setRealName(u.getName());
       userModel.setNickname(u.getNickname());
       return userModel;
    }
}
