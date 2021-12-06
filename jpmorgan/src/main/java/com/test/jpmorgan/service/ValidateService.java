package com.test.jpmorgan.service;

import com.test.jpmorgan.model.AccountDetails;
import com.test.jpmorgan.model.AccountInfo;
import com.test.jpmorgan.model.ProviderResponse;

import java.util.List;

public interface ValidateService {


    List<AccountDetails> getAccountDetails(AccountInfo accountInfo);
}
