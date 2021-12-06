package com.test.jpmorgan.api;


import com.test.jpmorgan.model.AccountDetails;
import com.test.jpmorgan.model.AccountInfo;
import com.test.jpmorgan.service.ValidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ValidationApi {

    private Logger logger = LoggerFactory.getLogger(ValidationApi.class);

    @Autowired
    private ValidateService validateService;

    @PostMapping("/validate")
    public List<AccountDetails> getAccountValidations(AccountInfo accountInfo){
        try {
            this.logger.trace("checking validation [{}]",accountInfo);
            return validateService.getAccountDetails(accountInfo);
        }catch (Exception e){
            this.logger.error("Exception while validating account {}", accountInfo,e);
            throw e;
        }
    }
}
