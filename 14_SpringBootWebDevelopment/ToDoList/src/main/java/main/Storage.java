package main;

import main.model.Deal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Deal> deals = new HashMap<>();

    public static synchronized int addDeal(Deal deal){
        int id = currentId++;
        deal.setId(id);
        deal.setDone(false);
        deals.put(id, deal);
        return id;
    }

    public static synchronized Deal getDeal (int dealId){
        if(deals.containsKey(dealId)){
            return deals.get(dealId);
        }
        return null;
    }

    public static synchronized List<Deal> getAllDeals(){
        ArrayList<Deal> dealList = new ArrayList<Deal>();
        dealList.addAll(deals.values());
        return dealList;
    }

    public static synchronized void delDeal (int dealId){
        if(deals.containsKey(dealId)){
            deals.remove(dealId);
        }
    }

    public static synchronized void delAllDeal (){
        if(deals.size() != 0){
            deals.clear();
        }
    }

    public static synchronized void updateDeal (int dealId, int number, String name, boolean done){
        if(deals.containsKey(dealId)){
            Deal deal = getDeal(dealId);
            deal.setNumber(number);
            deal.setName(name);
            deal.setDone(done);
        }
    }

    public static synchronized void updateAllDeal (boolean done){
        if(deals.size() != 0){
            deals.values().forEach(d -> d.setDone(done));
        }
    }

}
