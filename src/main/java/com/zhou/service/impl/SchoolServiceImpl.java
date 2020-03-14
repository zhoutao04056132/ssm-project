package com.zhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhou.dao.ISchoolDao;
import com.zhou.model.School;
import com.zhou.service.ISchoolService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("schoolService")
public class SchoolServiceImpl implements ISchoolService {
    @Resource
    private ISchoolDao schoolDao;

    @Override
    public School selectSchoolById(Integer id) throws DataAccessException {
        return schoolDao.selectSchoolById(id);
    }

    @Override
    public Page<School> selectSchoolsByPage(Integer page, Integer size) throws DataAccessException {
        PageHelper.startPage(page, size);
        Page<School> schoolPage = schoolDao.selectSchoolsByPage();

        return schoolPage;
    }

    @Override
    public Page<School> selectSchoolsByConditionByPage(Integer provinceId, Integer sourceId, String subjectionName, Integer page, Integer size) throws DataAccessException {
        PageHelper.startPage(page, size);
        Page<School> schoolPage = schoolDao.selectSchoolsByConditionByPage(provinceId, sourceId, subjectionName);

        return schoolPage;
    }

    @Override
    public School insertSchool(School school) throws DataAccessException {
        int result = schoolDao.insertSchool(school);
        if (result != 1) {
            return null;
        }

        return school;
    }

    @Override
    public int updateSchool(School school) throws DataAccessException {
        return schoolDao.updateSchool(school);
    }

    @Override
    public int deleteSchoolById(Integer id) throws DataAccessException {
        return schoolDao.deleteSchoolById(id);
    }
}

