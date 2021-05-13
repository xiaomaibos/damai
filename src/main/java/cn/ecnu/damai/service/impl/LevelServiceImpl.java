package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.Level;
import cn.ecnu.damai.mapper.LevelMapper;
import cn.ecnu.damai.service.LevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Kyrie Lee
 * @date 2021/5/13 15:47
 */
@Service("levelService")
public class LevelServiceImpl implements LevelService {
    @Resource
    private LevelMapper levelMapper;

    @Override
    public int addLevel(Level level) {
        return levelMapper.addLevel(level);
    }
}