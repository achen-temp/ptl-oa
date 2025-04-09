//package com.example.demo;
package com.ptl.exercise.ig.magnitGlobal.trader;

//import ch.qos.logback.core.joran.spi.HttpUtil;
//import org.springframework.beans.factory.annotation.Autowired;

//import java.sql.Timestamp;
//import java.time.Instant;
//import java.util.Comparator;
//import java.util.stream.Collectors;

public class TraderController {

 /*    
    @Autowired
    private TraderService traderService;

    @Requestmapping(value="/register",method= HttpUtil.RequestMethod.POST,consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)

    public void registerTrader(@RequestBody @Valid Trader trader){
        Trader existed=traderService.getTraderByEmail(trader.getEmail());
        if(existed.getEmail()!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trader already exists");
        }else{
            trader.setCreatedAt(Timestamp.from(Instant.now()));
            trader.setUpdatedAt(Timestamp.from(Instant.now()));
            traderService.registerTrader(trader);
        }
    }

    //get by email
    @RequestMapping(method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TraderDTO getTraderByEmail(@RequestParam("email") String email){
        Trader trader=traderService.getTraderByEmail(email);
        if(trader==null||!email.equalsIgnoreCase(trader.getEmail())){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trader not found");
        }
        return new TraderDTO(trader);
    }

    //get all
    @RequestMapping(value="/all",method= HttpUtil.RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TraderDTO> getAllTrader(){
        return traderService.getAllTraders()
                .stream()
                .sorted(Comparator.comparing(Trader::getId)
                .map(TraderDTO::new)
                .collect(Collectors.toList());
    }

    //update by email
    @RequestMapping(method= HttpUtil.RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTrader (@RequestBody @Valid UpdateTraderDTO trader){
        Trader existed=traderService.getTraderByEmail(trader.getEmail());
        if(existed==null||!trader.getEmail().equalsIgnoreCase(existed.getEmail())){
            throw new ResponseStatusException(HttpStatus,NOT_FOUND, "Trader not found");
        }
        traderService.updateTrader(trader);
    }

    //add money
    @RequestMapping(value="/add",method= HttpUtil.RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void addMoney(@RequestBody @Valid AddMoneyTraderDTO trader){
        Trader existed=traderService.getTraderByEmail(trader.getEmail());
        if(existed==null||!trader.getEmail().equalsIgnoreCase(existed.getEmail())){
            throw new ResponseStatusException(HttpStaus.NOT_FOUND, "Trader not found");
        }
        traderService.addMoney(trader);
    }

    */

}
