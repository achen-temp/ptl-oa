package com.ptl.exercise.capco;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hackrank {

    public static void main(String[] args) {
        PositionSvc positionSvc = new PositionSvc();
        QuoteSvc quoteSvc = new QuoteSvc();
        //START YOUR CODING HERE
        /*
          YOU NEED to based on given code, output a list of account and total value.
          total value is the number of shares * type of stock. and add all types up for that account
          result is like
          "account1" : 23432.33
          "account2" : 345.54
          //Follow up: sort result by value in decreasing order
         */
        List<Position> positions = positionSvc.getCustomerPositions(); //contain duplicate accountId entries
        List<Quote> quotes = quoteSvc.getAllPreviousQuotes(); //quote symbols are unique

        Map<String, BigDecimal> map = new HashMap<>();
        for(Position position : positions){
            String accountId = position.getAccountId();
            String symbol = position.getSymbol();
            long numOfShares = position.getNumOfShares();
            Quote foundQuote = quotes.stream().filter(q -> q.getSymbal().equalsIgnoreCase(symbol)).findFirst().orElse(null);
            BigDecimal sharePrice = new BigDecimal(0);
            if(foundQuote != null){
                //numshare * oneSharePrice = total price for that stock
                sharePrice = foundQuote.getPrice().multiply(BigDecimal.valueOf(numOfShares));
            }
            if(!map.containsKey(accountId)){
                map.put(accountId, sharePrice); //new account, just add to map
            }else{
                //exist in map, need to add value, the account has multiple type of stocks
                map.put(accountId, map.get(accountId).add(sharePrice));
            }
        }
        //output
        map.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //followup: sort by value decreasing
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) //sort by value decreasing
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue())); //print
    }
}

//all below code is given
class Position{
    String accountId;
    String symbol;
    long numOfShares;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public long getNumOfShares() {
        return numOfShares;
    }

    public void setNumOfShares(long numOfShares) {
        this.numOfShares = numOfShares;
    }
}

class Quote{
    String symbal;
    BigDecimal price;

    public String getSymbal() {
        return symbal;
    }

    public void setSymbal(String symbal) {
        this.symbal = symbal;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

class PositionSvc{
    List<Position> positions;
    public PositionSvc(){
        //there are a list of new posiiton objected added -- ignored. it is given
    }
    public List<Position> getCustomerPositions(){
        return this.positions;
    }
}

class QuoteSvc{
    List<Quote> quotes;
    public QuoteSvc(){
        //given a list of quote objects. parsed from input string,-- ignored. it is given
    }
    public List<Quote> getAllPreviousQuotes(){
        return this.quotes;
    }
}