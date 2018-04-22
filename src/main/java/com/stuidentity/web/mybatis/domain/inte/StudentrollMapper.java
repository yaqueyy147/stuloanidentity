package com.stuidentity.web.mybatis.domain.inte;

import com.stuidentity.web.mybatis.domain.Studentroll;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudentrollMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studentinfo
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studentinfo
     *
     * @mbggenerated
     */
    int insert(Studentroll record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studentinfo
     *
     * @mbggenerated
     */
    int insertSelective(Studentroll record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studentinfo
     *
     * @mbggenerated
     */
    Studentroll selectByPrimaryKey(String id);

    List<Studentroll> selectByParams(Map<String,Object> params);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studentinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Studentroll record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table studentinfo
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Studentroll record);
}