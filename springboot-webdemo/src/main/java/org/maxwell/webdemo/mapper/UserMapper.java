package org.maxwell.webdemo.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.maxwell.webdemo.model.bo.AddUser;
import org.maxwell.webdemo.model.bo.UpdateUser;
import org.maxwell.webdemo.model.vo.UserVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 12:08
 */
public interface UserMapper {


    /**
     * 查找用户总数
     *
     * @return
     */
    @Select("select count(id) from t_user")
    int findTotalRecords();


    /**
     * 分页查找用户列表
     *
     * @param offset
     * @param pageSize
     * @return
     */
    List<UserVO> findUserList(@Param("offset") int offset, @Param("pageSize") int pageSize);


    /**
     * 模糊分页查找用户列表
     *
     * @param offset
     * @param pageSize
     * @param name
     * @return
     */
    List<UserVO> findUserListLike(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("name") String name);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(AddUser user);

    /**
     *  修改用户
     * @param user
     * @return
     */
    int updateUser(UpdateUser user);

    /**
     *  删除用户
     * @param uid
     * @return
     */
    int deleteUser(int uid);
}
