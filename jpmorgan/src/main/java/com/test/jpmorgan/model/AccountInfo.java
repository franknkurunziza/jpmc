package com.test.jpmorgan.model;

import java.util.List;

public class AccountInfo {

    private String accountNUmber;

    private List<String> providers;

    public String getAccountNUmber() {
        return accountNUmber;
    }

    public void setAccountNUmber(String accountNUmber) {
        this.accountNUmber = accountNUmber;
    }

    public List<String> getProviders() {
        return providers;
    }

    public void setProviders(List<String> providers) {
        this.providers = providers;
    }
}
