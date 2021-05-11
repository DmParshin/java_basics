package main;

import response.Deal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Deal> deals = new HashMap<>();

    public static int addDeal(Deal deal){
        int id = currentId++;
        deal.setId(id);
        deal.setDone(false);
        deals.put(id, deal);
        return id;
    }

    public static Deal getDeal (int dealId){
        if(deals.containsKey(dealId)){
            return deals.get(dealId);
        }
        return null;
    }

    public static List<Deal> getAllDeals(){
        ArrayList<Deal> dealList = new ArrayList<Deal>();
        dealList.addAll(deals.values());
        return dealList;
    }

    public static void delDeal (int dealId){
        if(deals.containsKey(dealId)){
            deals.remove(dealId);
        }
    }

    public static void delAllDeal (){
        if(deals.size() != 0){
            deals.clear();
        }
    }

    public static void updateDeal (int dealId, int number, String name, boolean done){
        if(deals.containsKey(dealId)){
            Deal deal = getDeal(dealId);
            deal.setNumber(number);
            deal.setName(name);
            deal.setDone(done);
        }
    }

    public static void updateAllDeal (boolean done){
        if(deals.size() != 0){
            deals.values().forEach(d -> d.setDone(done));
        }
    }

}
