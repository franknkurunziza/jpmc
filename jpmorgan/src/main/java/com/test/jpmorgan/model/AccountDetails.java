package com.test.jpmorgan.model;

public class AccountDetails {

    private String provider;

    private boolean isValid;


    public AccountDetails provider(String provider){
        this.provider = provider;
        return this;
    }

    public AccountDetails isValid(boolean isValid){
        this.isValid = isValid;
        return this;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
