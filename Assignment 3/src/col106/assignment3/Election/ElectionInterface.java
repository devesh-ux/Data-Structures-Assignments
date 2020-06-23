package col106.assignment3.Election;

/**
 * DO NOT EDIT THIS FILE.
 */
public interface ElectionInterface {
    /**
     * @param name,candID,state,district,constituency,party,votes to be input in the Election
     * @return Success or failure
     */
    void insert(String name, String candID, String state, String district, String constituency, String party, String votes);

    /**
     * @param inputs the votes for a given candidate
     */
    void updateVote(String name, String candID, String votes);
    /**
     * @param inputs the name of the constituency
     * prints the {name candID party} of top 3 candidates in a constituency seperated by newlines.
     * example of output:
     * A 100 party1
     * B 200 party2
     * C 300 party3
     */
    void topkInConstituency(String constituency, String k);
    /**
     * @param inputs the name of the state
     * @return the name of the leading party of that state
     */
    void leadingPartyInState(String state);
    /**
     * @param inputs the name of the constituency for which suppose the EVM is suspected to be corrupted
     * delete all the candidates information for that constituency
     */
    void cancelVoteConstituency(String constituency);
    /**
     * @param inputs void
     * @return the name of the overall leading party across all the constituencies of all states 
     */
    void leadingPartyOverall();
     /**
     * @param inputs the name of a party and a state
     * @return the %vote a particular party obtains in a given state 
     */
    void voteShareInState(String party,String state);
    
    /**
     * @param inputs a state
     * Prints the <name, candID, state, district, constituency, party, votes> of all the candidates from your data structure (BST) according to level-order.
     * All the <name, candID, state, district, constituency, party, votes> should be separated by newlines.
     */
    void printElectionLevelOrder();
}



