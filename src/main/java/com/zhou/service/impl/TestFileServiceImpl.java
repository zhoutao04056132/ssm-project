package com.zhou.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhou.dao.ITestFileDao;
import com.zhou.model.TestFile;
import com.zhou.service.ITestFileService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("testFileService")
public class TestFileServiceImpl implements ITestFileService {
    @Resource
    private ITestFileDao testFileDao;

    @Override
    public TestFile selectTestFileById(Integer id) throws DataAccessException {
        return testFileDao.selectTestFileById(id);
    }

    @Override
    public Page<TestFile> selectTestFilesByPage(Integer page, Integer size) throws DataAccessException {
        PageHelper.startPage(page, size);
        Page<TestFile> testFilePage = testFileDao.selectTestFilesByPage();

        return testFilePage;
    }

    @Override
    public TestFile insertTestFile(TestFile testFile) throws DataAccessException {
        int result = testFileDao.insertTestFile(testFile);
        if (result != 1) {
            return null;
        }

        return testFile;
    }

    @Override
    public int insertTestFilesBatch(List<TestFile> testFileList) throws DataAccessException {
        int result = 0;
        try {
            result = testFileDao.insertTestFilesBatch(testFileList);
        } catch (DataAccessException e) {
            result = -1;
        }

        return result;
    }

    @Override
    public int updateTestFile(TestFile testFile) throws DataAccessException {
        return testFileDao.updateTestFile(testFile);
    }

    @Override
    public int deleteTestFileById(Integer id) throws DataAccessException {
        return testFileDao.deleteTestFileById(id);
    }
}
