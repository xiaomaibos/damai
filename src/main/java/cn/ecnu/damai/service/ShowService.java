package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Show;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 15:16
 */
public interface ShowService {

    List<Show> getShowList(Integer programId);

    PageInfo<Show> findShowWithFilters(String keyWord, Integer pageSize, Integer currentPage);

    int addShow(Show show);

    Show findShowById(Integer showId);
}
