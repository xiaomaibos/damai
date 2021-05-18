package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Attender;

public interface AttenderService{

    Attender addAttender(Attender attender);

    boolean deleteAttender(Integer attenderId);

    Attender getAttender(Integer attenderId);
}
