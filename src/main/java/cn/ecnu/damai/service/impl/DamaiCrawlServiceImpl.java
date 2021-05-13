package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.service.DamaiCrawlService;
import cn.ecnu.damai.util.DamaiCrawler;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

@Service("damaiCrawl")
public class DamaiCrawlServiceImpl implements DamaiCrawlService {

    private DamaiCrawler damaiCrawler = new DamaiCrawler();

    @Override
    public String crawlProblemByCode(String code, Program program) {
        return damaiCrawler.synCrawl(code, program);
    }
}
