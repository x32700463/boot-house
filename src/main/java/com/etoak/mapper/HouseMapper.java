package com.etoak.mapper;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;

import java.util.List;

public interface HouseMapper {
    /**
     * 添加房源
     * @param house
     * @return
     */
    int addHouse(House house);
    List<HouseVo> queryList(HouseVo houseVo);
}
