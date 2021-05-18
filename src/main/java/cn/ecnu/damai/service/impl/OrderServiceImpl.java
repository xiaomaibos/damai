package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.dao.repository.OrderRepository;
import cn.ecnu.damai.dao.repository.ProgramRepository;
import cn.ecnu.damai.dao.repository.ShowRepository;
import cn.ecnu.damai.entity.Order;
import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.entity.Show;
import cn.ecnu.damai.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderRepository orderRepository;
    @Resource
    private ShowRepository showRepository;
    @Resource
    private ProgramRepository programRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrderList(Integer userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        List<Order> resList = new ArrayList<>();
        for (Order order : orders) {
            Optional<Show> optShow = showRepository.findById(order.getShowId());
            if (optShow.isPresent()) {
                Show show = optShow.get();
                Optional<Program> optProgram = programRepository.findById(show.getProgramId());
                if (optProgram.isPresent()) {
                    Program program = optProgram.get();
                    show.setProgram(program);
                    order.setShow(show);
                    resList.add(order);
                }
            }
        }
        return resList;
    }
}
