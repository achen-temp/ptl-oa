//package com.example.demo;
package com.ptl.exercise.ig.magnitGlobal.trader;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.List;

@Service
public class TraderService {

    /* 
    @Autowired
    private TraderRespository traderRespository;

    public void registerTrader(Trader trader){
        traderRespository.save(trader);
    }

    public Trader getTraderById(Long id){
        return traderRespository.findById(id).get();
    }

    public Trader getTraderByEmail(String email){
        return traderRespository.findByEmail(email).orElse(new Trader());
    }

    public List<Trader> getAllTraders(){
        return  traderRespository.findAll();
    }

    public void updateTrader(UpdateTradeDTO trader){
        Trader existingTrader=traderRespository.findByEmail(trader.getEmail().get());
        existingTrader.setName(trader.getName());   //change here
        traderRespository.save(existingTrader);
    }
    public void addMoney(AddMoneyTraderDTO trader){
        Trader existingTrader=traderRespository.findByEmail(trader.getEmail().get());
        existingTrader.setBalance(existingTrader.getBalance()+trader.getAmount());  //change here
        traderRespository.save(existingTrader);
    }

    */

}
