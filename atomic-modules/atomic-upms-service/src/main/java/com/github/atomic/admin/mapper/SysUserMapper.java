/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.github.atomic.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.atomic.admin.model.entity.SysUser;
import com.github.atomic.common.bean.interceptor.DataScope;
import com.github.atomic.common.util.Query;
import com.github.atomic.common.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author lengleng
 * @since 2017-10-29
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 通过用户名查询用户信息（含有角色信息）
     *
     * @param username 用户名
     * @return userVo
     */
    UserVO selectUserVoByUsername(String username);

    /**
     * 分页查询用户信息（含角色）
     *
     * @param query     查询条件
     * @param username  用户名
     * @param dataScope 数据权限
     * @return list
     */
    List selectUserVoPageDataScope(Query query, @Param("username") Object username, DataScope dataScope);

    /**
     * 通过手机号查询用户信息（含有角色信息）
     *
     * @param mobile 用户名
     * @return userVo
     */
    UserVO selectUserVoByMobile(String mobile);

    /**
     * 通过openId查询用户信息
     *
     * @param openId openid
     * @return userVo
     */
    UserVO selectUserVoByOpenId(String openId);

    /**
     * 通过ID查询用户信息
     *
     * @param id 用户ID
     * @return userVo
     */
    UserVO selectUserVoById(Integer id);
}