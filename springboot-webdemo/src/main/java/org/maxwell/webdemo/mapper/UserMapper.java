package org.maxwell.webdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.maxwell.webdemo.model.bo.AddUser;
import org.maxwell.webdemo.model.bo.UpdateUser;
import org.maxwell.webdemo.model.po.TUser;
import org.maxwell.webdemo.model.vo.UserVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 12:08
 */
@Mapper
public interface UserMapper extends BaseMapper<TUser> {


    /**
     * 查找用户总数
     *
     * @return
     */
    @Select("select count(id) from t_user")
    int findTotalRecords();


    /**
     * 模糊分页查找用户列表
     *
     * @param offset
     * @param pageSize
     * @param name
     * @return
     */
    List<UserVO> findUserListLike(int offset, int pageSize,String name);

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
