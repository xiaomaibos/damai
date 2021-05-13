package cn.ecnu.damai.mapper;

import cn.ecnu.damai.entity.Level;

import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/13 15:48
 */
public interface LevelMapper {
    int addLevel(Level level);
    List<Level> getLevelList(Integer showId);
}
