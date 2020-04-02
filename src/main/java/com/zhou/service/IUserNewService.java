package com.zhou.service;

import com.zhou.model.GroupNameVo;
import com.zhou.model.UserNew;

import java.util.List;

public interface IUserNewService {
    UserNew selectUserNewById(long id);
    List<String> selectGroupNames();
    List<GroupNameVo> selectGroupNameVos();
}
