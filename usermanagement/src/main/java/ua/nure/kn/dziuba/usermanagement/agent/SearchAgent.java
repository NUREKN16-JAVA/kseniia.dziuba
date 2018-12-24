package ua.nure.kn.dziuba.usermanagement.agent;

import jade.core.AID;
import jade.core.Agent;
import java.util.Collection;

import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import ua.nure.kn.dziuba.usermanagement.db.DaoFactory;
import ua.nure.kn.dziuba.usermanagement.db.DatabaseException;

public class SearchAgent extends Agent {
    private AID[] aids;

    protected void setup() {
        super.setup();
        System.out.println(getAID().getName() + " started");

        DFAgentDescription description = new DFAgentDescription();
        description.setName(getAID());
        ServiceDescription serviceDescription = new ServiceDescription();
        serviceDescription.setName("JADE-searching");
        serviceDescription.setType("searching");
        description.addServices(serviceDescription);
        try{
            DFService.register(this, description);
        }catch (FIPAException e){
            e.printStackTrace();
        }
    }

    protected void takeDown() {
        System.out.println(getAID().getName() + " terminated");
        super.takeDown();
    }

    public void search(String firstName, String lastName) throws SearchException{
        try {
            Collection users = DaoFactory.getInstance().getUserDao().find(firstName, lastName);
            if(users.size() > 0){
                showUsers(users);
            }
            else{
                addBehaviour(new SearchRequestBehaviour(new AID[]{}, firstName, lastName));
            }
        } catch (DatabaseException e) {
            throw new SearchException(e.getMessage());
        }
    }

    public void showUsers(Collection users){

    }
}
