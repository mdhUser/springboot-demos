package org.maxwell.webdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.maxwell.webdemo.model.po.TRole;
import org.maxwell.webdemo.model.vo.RoleVO;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/18 21:24
 */
@Mapper
public interface RoleMapper extends BaseMapper<TRole> {

    /**
     * 查找角色列表
     *
     * @return
     */
    @Select("select id,name from t_role")
    List<RoleVO> findRoleList();

}
