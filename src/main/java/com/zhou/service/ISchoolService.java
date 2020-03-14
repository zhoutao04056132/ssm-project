package com.zhou.service;

import com.github.pagehelper.Page;
import com.zhou.model.School;
import org.springframework.dao.DataAccessException;

public interface ISchoolService {
    School selectSchoolById(Integer id) throws DataAccessException;
    // 默认按拼音排序
    Page<School> selectSchoolsByPage(Integer page, Integer size) throws DataAccessException;
    Page<School> selectSchoolsByConditionByPage(Integer provinceId, Integer sourceId, String subjectionName, Integer page, Integer size) throws DataAccessException;
    School insertSchool(School school) throws DataAccessException;
    int updateSchool(School school) throws DataAccessException;
    int deleteSchoolById(Integer id) throws DataAccessException;
}
