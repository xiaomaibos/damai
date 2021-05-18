package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.dao.repository.AttenderRepository;
import cn.ecnu.damai.entity.Attender;
import cn.ecnu.damai.service.AttenderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service("attenderService")
public class AttenderServiceImpl implements AttenderService {

    @Resource
    private AttenderRepository attenderRepository;

    @Override
    public Attender addAttender(Attender attender) {
        return attenderRepository.save(attender);
    }

    @Override
    public boolean deleteAttender(Integer attenderId) {
        Optional<Attender> optAttender = attenderRepository.findById(attenderId);
        if (optAttender.isPresent()) {
            Attender attender = optAttender.get();
            attender.setIsDelete(1);
            attenderRepository.save(attender);
            return true;
        }
        return false;
    }

    @Override
    public Attender getAttender(Integer attenderId) {
        Optional<Attender> optAttender = attenderRepository.findById(attenderId);
        if (optAttender.isPresent()) {
            Attender attender = optAttender.get();
            if (attender.getIsDelete() == 0) {
                return attender;
            }
        }
        return null;
    }
}
