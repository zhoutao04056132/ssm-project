package com.zhou.dao;

import com.github.pagehelper.Page;
import com.zhou.model.School;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

public interface ISchoolDao {
    School selectSchoolById(Integer id) throws DataAccessException;
    Page<School> selectSchoolsByPage() throws DataAccessException;
    Page<School> selectSchoolsByConditionByPage(@Param("provinceId") Integer provinceId,
                                                @Param("sourceId") Integer sourceId,
                                                @Param("subjectionName") String subjectionName) throws DataAccessException;
    int insertSchool(School school) throws DataAccessException;
    int updateSchool(School school) throws DataAccessException;
    int deleteSchoolById(Integer id) throws DataAccessException;
}
