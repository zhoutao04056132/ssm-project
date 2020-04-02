package com.zhou.dao;

import com.zhou.model.GroupNameVo;
import com.zhou.model.UserNew;

import java.util.List;

public interface IUserNewDao {
    UserNew selectUserNewById(long id);
    List<String> selectGroupNames();
    List<GroupNameVo> selectGroupNameVos();
}
