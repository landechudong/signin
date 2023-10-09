package com.lxq.sign.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lxq.sign.domain.LoginBrowser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@SuppressWarnings({"all"})
@Mapper
public interface LoginBrowserDao extends BaseMapper<LoginBrowser> {

    @Select("select id,stu_code,browser from login_browser where stu_code = #{stuCode}")
    LoginBrowser selectStuCode(String stuCode);

    @Select("select browser from login_browser where stu_code = #{stuCode}")
    String selectBrowser(String stuCode);
}
