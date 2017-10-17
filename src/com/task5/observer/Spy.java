package com.task5.observer;

public class Spy implements Observer{
    private String name;
    private Congress congress;
    private Agency agency;
    private Message message = new Message();

    public Spy(String name) {
        this.name = name;
    }


    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    @Override
    public void update() {
        message.addData("Bribe",congress.getBribes());
        message.addData("Expansion",congress.getExpansion());
        message.addData("Laundering",congress.getLaundering());

        if(message.hasFullData)
            agency.getMessage(this,this.message);

    }
}
