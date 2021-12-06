package com.test.jpmorgan.service;


import com.test.jpmorgan.model.AccountDetails;
import com.test.jpmorgan.model.AccountInfo;
import com.test.jpmorgan.model.ProviderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidateServiceImpl implements ValidateService{
    private final Logger logger = LoggerFactory.getLogger(ValidateServiceImpl.class);

    @Autowired
    private ProviderService providerService;

    @Override
    public List<AccountDetails> getAccountDetails(AccountInfo accountInfo) {
        try {
            logger.trace("start validation account info [{}]",accountInfo);
            ProviderRequest request = new ProviderRequest();
            List<AccountDetails> result = new ArrayList<>();

            request.setAccountNumber(accountInfo.getAccountNUmber());

            boolean provider1Valid = providerService.isProvider1Valid(request);
            boolean provider2Valid =  providerService.isProvider2Valid(request);



            result.add(new AccountDetails().isValid(provider1Valid).provider("provider1"));
            result.add(new AccountDetails().isValid(provider2Valid).provider("provider2"));

            return result;
        }catch (Exception e){
            logger.error("Error while trying to validate account {}",accountInfo,e);
            throw e;
        }
    }
}
