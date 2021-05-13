package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.Show;
import cn.ecnu.damai.entity.ShowFilter;
import cn.ecnu.damai.mapper.ShowMapper;
import cn.ecnu.damai.service.ShowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 15:17
 */
@Service("showService")
public class ShowServiceImpl implements ShowService {
    @Resource
    private ShowMapper showMapper;

    @Override
    public List<Show> getShowList(Integer programId) {
        return showMapper.getShowList(programId);
    }

    @Override
    public PageInfo<Show> findShowWithFilters(String keyWord, Integer pageSize, Integer currentPage) {
        ShowFilter showFilter = new ShowFilter();
        showFilter.setKeyWord(keyWord);
        PageHelper.startPage(currentPage, pageSize);
        return new PageInfo<>(showMapper.findShowWithFilters(showFilter));
    }

    @Override
    public int addShow(Show show) {
        return showMapper.addShow(show);
    }
}
