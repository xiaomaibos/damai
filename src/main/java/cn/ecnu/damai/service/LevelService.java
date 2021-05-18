package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Level;
import cn.ecnu.damai.entity.Show;

import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/13 15:47
 */
public interface LevelService {

    List<Level> getLevelList(Integer showId);

    int addLevel(Level level);

    Level getLevel(Integer levelId);
}
