package com.etoak.mapper;


import com.etoak.bean.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    /**
     * 根据父id查询
     * @param pid
     * @return
     */
    List<Area> queryByPid(@Param("pid") int pid);

    /**
     * 根据Id查询地区
     * @param area
     * @return
     */
    Area queryById(@Param("id") Integer area);
}
