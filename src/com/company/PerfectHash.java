package com.company;

public class PerfectHash {
    private TicketNode[] data;
    int _offSet=0;

    //initalizer
    /* Initalizes the database
     * @param int the size of database, int how much to offset database
     * @return nothing is implemented
     * @throws Nothing is implemented
     * O(n)=c
     */
    public PerfectHash(int size, int offSet){
        data = new TicketNode[size];
        _offSet = offSet;
    }
    //preprocessing
    /* performs preprocessing to convert ticket number into database index
     * @param int ticket number should be between 2000-60000
     * @return the database index for the given ticket number
     * @throws Nothing is implemented
     * O(n)=c
     */
    private int preprocessing(int ticket){
        return ticket-_offSet;
    }
    //hashmethod
    /* calls preprocessing because we didnt really need it but wanted it here for future use
     * @param int ticket number should be between 2000-60000
     * @return the database index for the given ticket number
     * @throws Nothing is implemented
     * O(n)=c
     */
    private int hash(int ticket){
        return preprocessing(ticket);
    }
    // inserts
    /* calls preprocessing with the ticket number it was given then uses that to access the database and store the name there
     * @param int ticket number should be between 2000-60000, String the persons name
     * @return true
     * @throws Nothing is implemented
     * O(n)=c
     */
    public boolean insert(int ticket,String name){
        int index = hash(ticket);
        data[index] = new TicketNode(ticket, name);
        return true;
    }

    // fetches
    /*calls preprocessing then uses the index to return the database entry
     * @param int ticket number should be between 2000-60000
     * @return The data of the ticket number given
     * @throws Nothing is implemented
     * O(n)=c
     */
    public String fetch(int ticket){
        int index = preprocessing(ticket);
        return data[index]._name;
    }
    // update
    /* calls preprocessing to convert ticket number into database index then uses to update the databe at index to the new name
     * @param int ticket number should be between 2000-60000, String new name given
     * @return true
     * @throws Nothing is implemented
     * O(n)=c
     */
    public boolean update(int ticket, String name){
        int index = preprocessing(ticket);
        data[index] = new TicketNode(ticket, name);
        return true;
    }
    // delete operation
    /* calls preprocessing to convert ticket number into database index, then uses the index to delete what is held there
     * @param int ticket number should be between 2000-60000
     * @return true
     * @throws Nothing is implemented
     * O(n)=c
     */
    public boolean delete(int ticket){
        int index = preprocessing(ticket);
        if (data[index]==null) {
            return false;
        }

        data[index] = null;
        return true;
    }
    /* calls preprocessing to convert ticket number into database index/ seat number then returns it to who called it
     * @param int ticket number should be between 2000-60000
     * @return the seat number for the given ticket number
     * @throws Nothing is implemented
     * O(n)=c
     */
    public int seatNumber(int ticket){
        return preprocessing(ticket);
    }
}
