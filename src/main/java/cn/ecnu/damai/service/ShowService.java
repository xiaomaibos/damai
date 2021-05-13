package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Show;
import com.github.pagehelper.PageInfo;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 15:16
 */
public interface ShowService {
    PageInfo<Show> findShowWithFilters(String keyWord, Integer pageSize, Integer currentPage);

    int addShow(Show show);
}
