package com.example.studentservice.mapper;

import com.example.studentservice.domain.schoolclasses.ClassInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassInfoMapper {
    List<ClassInfo> findAll();

    /**
     * Dynamically selects information to search with. Can accept search by id, name and serial. Search is AND based,
     * thus returning information that must match ALL non null parts.
     * 使用动态sql做查询，根据非空值和AND方式查处对应的一条数据
     *
     * @param classInfo classInfo to search with. MetaData is ignored.
     * @return filled ClassInfo object if found by non null fields, null otherwise.
     */
    ClassInfo findBy(ClassInfo classInfo);

    /**
     * finds the last Serial by largest database Id.
     * @return String of full class serial number
     */
    String findLast();

}
