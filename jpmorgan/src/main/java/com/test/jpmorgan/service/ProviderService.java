package com.test.jpmorgan.service;

import com.test.jpmorgan.model.ProviderRequest;

public interface ProviderService {

    boolean isProvider1Valid(ProviderRequest request);

    boolean isProvider2Valid(ProviderRequest request);
}
