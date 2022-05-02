package org.maxwell.webdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.maxwell.webdemo.model.po.TUserRole;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 15:32
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<TUserRole> {


    /**
     * 添加用户角色
     *
     * @param uid
     * @param roleIds
     * @return
     */
    int addUserRoles(Integer uid, List<Integer> roleIds);

    /**
     * 查找用户角色
     *
     * @param uid
     * @return
     */
    List<Integer> findRoles(Integer uid);


    /**
     * 删除用户角色
     *
     * @param uid
     * @return
     */
    int deleteRecords(Integer uid);
}
