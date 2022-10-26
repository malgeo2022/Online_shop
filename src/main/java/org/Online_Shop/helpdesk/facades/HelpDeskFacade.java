package org.Online_Shop.helpdesk.facades;

import org.Online_Shop.helpdesk.enteties.SupportTicket;

public interface HelpDeskFacade {

    void addNewSupportTicket(SupportTicket supportTicket);

    SupportTicket getNextSupportTicket();

    /**
     * @return amount of tickets that are not processed
     */
    int getNumberOfTickets();
}
