package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.dao.repository.TicketRepository;
import cn.ecnu.damai.entity.Ticket;
import cn.ecnu.damai.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("ticketService")
public class TicketServiceImpl implements TicketService {
    @Resource
    private TicketRepository ticketRepository;

    @Override
    public Ticket addTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
