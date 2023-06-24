package com.example.demo.RequestModel;

public class IpinGenerationRequestModel {

    private String ipin;
    private String consumerPublicKey;
    private String uuid;
    private int counter;

    public String getIpin() {
        return ipin;
    }

    public void setIpin(String ipin) {
        this.ipin = ipin;
    }

    public String getConsumerPublicKey() {
        return consumerPublicKey;
    }

    public void setConsumerPublicKey(String consumerPublicKey) {
        this.consumerPublicKey = consumerPublicKey;
    }

    public int getCounter() {
        return counter;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
