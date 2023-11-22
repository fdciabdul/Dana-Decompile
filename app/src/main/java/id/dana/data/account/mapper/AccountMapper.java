package id.dana.data.account.mapper;

import id.dana.data.account.AccountEntity;
import id.dana.domain.account.Account;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class AccountMapper {
    @Inject
    public AccountMapper() {
    }

    public Account transform(AccountEntity accountEntity) {
        if (accountEntity == null) {
            return null;
        }
        Account account = new Account();
        account.setUserId(accountEntity.getUserId());
        account.setNickname(accountEntity.getNickname());
        account.setAvatarUrl(accountEntity.getAvatarUrl());
        account.setAmount(accountEntity.getAmount());
        account.setCurrency(accountEntity.getCurrency());
        account.setPhoneMask(accountEntity.getPhoneMask());
        account.setPhoneNumber(accountEntity.getPhoneNumber());
        account.setSessionId(accountEntity.getSessionId());
        account.setUUID(accountEntity.getUUID());
        account.setUsername(accountEntity.getUsername());
        account.setKycLevel(accountEntity.getKycLevel());
        return account;
    }

    public AccountEntity transform(Account account) {
        if (account == null) {
            return null;
        }
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(account.getUserId());
        accountEntity.setNickname(account.getNickname());
        accountEntity.setAvatarUrl(account.getAvatarUrl());
        accountEntity.setAmount(account.getAmount());
        accountEntity.setCurrency(account.getCurrency());
        accountEntity.setPhoneMask(account.getPhoneMask());
        accountEntity.setPhoneNumber(account.getPhoneNumber());
        accountEntity.setSessionId(account.getSessionId());
        accountEntity.setUUID(account.getUUID());
        accountEntity.setUsername(account.getUsername());
        accountEntity.setKycLevel(account.getKycLevel());
        return accountEntity;
    }
}
