package com.Phone;

public class IPhone extends Phone implements Ringable{
    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public void displayInfo() {
        System.out.println("IPhone "+getVersionNumber()+" From "+getCarrier());
    }

    @Override
    public String ring() {
        return "IPhone "+getVersionNumber()+" says "+getRingTone();
    }

    @Override
    public String unlock() {
        return "Unlocking via Facial recognition";
    }
}
