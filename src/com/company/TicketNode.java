package com.company;

public class TicketNode {
   public int _ticketNumber;
   public String _name;

    /* Initalizes the TicketNode
     * @param int ticket number, String name attached to number
     * @return nothing is implemented
     * @throws Nothing is implemented
     * O(n)=c
     */
   public TicketNode(int ticket, String name){
        _ticketNumber = ticket;
        _name = name;
   }

}
