package com.zhou.service;

import com.github.pagehelper.Page;
import com.zhou.model.TestFile;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ITestFileService {
    TestFile selectTestFileById(Integer id) throws DataAccessException;
    Page<TestFile> selectTestFilesByPage(Integer page, Integer size) throws DataAccessException;
    TestFile insertTestFile(TestFile testFile) throws DataAccessException;
    int insertTestFilesBatch(List<TestFile> testFileList) throws DataAccessException;
    int updateTestFile(TestFile testFile) throws DataAccessException;
    int deleteTestFileById(Integer id) throws DataAccessException;
}
