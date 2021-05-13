package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Program;

public interface DamaiCrawlService {

    String crawlProblemByCode(String code, Program program);
}
