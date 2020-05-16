package com.zhou.dao;

import com.github.pagehelper.Page;
import com.zhou.model.TestFile;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ITestFileDao {
    TestFile selectTestFileById(Integer id) throws DataAccessException;
    Page<TestFile> selectTestFilesByPage() throws DataAccessException;
    int insertTestFile(TestFile testFile) throws DataAccessException;
    int insertTestFilesBatch(List<TestFile> testFileList) throws DataAccessException;
    int updateTestFile(TestFile testFile) throws DataAccessException;
    int deleteTestFileById(Integer id) throws DataAccessException;
}
