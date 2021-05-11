package cn.ecnu.damai.mapper;

import cn.ecnu.damai.entity.Show;
import cn.ecnu.damai.entity.ShowFilter;

import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 15:17
 */
public interface ShowMapper {
    List<Show> findShowWithFilters(ShowFilter showFilter);
}