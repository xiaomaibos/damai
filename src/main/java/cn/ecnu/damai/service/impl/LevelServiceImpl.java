package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.dao.repository.LevelRepository;
import cn.ecnu.damai.dao.repository.ProgramRepository;
import cn.ecnu.damai.dao.repository.ShowRepository;
import cn.ecnu.damai.entity.Level;
import cn.ecnu.damai.dao.mapper.LevelMapper;
import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.entity.Show;
import cn.ecnu.damai.service.LevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author Kyrie Lee
 * @date 2021/5/13 15:47
 */
@Service("levelService")
public class LevelServiceImpl implements LevelService {
    @Resource
    private LevelMapper levelMapper;
    @Resource
    private LevelRepository levelRepository;

    @Override
    public int addLevel(Level level) {
        return levelMapper.addLevel(level);
    }

    @Override
    public List<Level> getLevelList(Integer showId) {
        return levelMapper.getLevelList(showId);
    }

    @Override
    public Level getLevel(Integer levelId) {
        Optional<Level> optLevel = levelRepository.findById(levelId);
        return optLevel.orElse(null);
    }

    @Override
    public Level updateLevel(Level level) {
        return levelRepository.save(level);
    }

}
