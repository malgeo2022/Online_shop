package org.Online_Shop.helpdesk.facades.impl;

import org.Online_Shop.helpdesk.enteties.SupportTicket;
import org.Online_Shop.helpdesk.facades.HelpDeskFacade;
import org.Online_Shop.helpdesk.utils.CustomSupportTicketsComparator;

import java.util.PriorityQueue;
import java.util.Queue;

public class DefaultHelpDeskFacade implements HelpDeskFacade {
    private Queue<SupportTicket> tickets;

    {
        tickets = new PriorityQueue<>(new CustomSupportTicketsComparator());
    }

    @Override
    public void addNewSupportTicket(SupportTicket supportTicket) {
        tickets.offer(supportTicket);
    }

    @Override
    public SupportTicket getNextSupportTicket() {
        return tickets.poll();
    }

    @Override
    public int getNumberOfTickets() {
        return tickets.size();
    }

}
