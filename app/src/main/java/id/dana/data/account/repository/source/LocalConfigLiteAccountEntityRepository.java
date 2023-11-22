package id.dana.data.account.repository.source;

import dagger.Lazy;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.mapper.AccountMapper;
import id.dana.domain.account.Account;
import id.dana.domain.account.LiteAccountRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import j$.util.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0003\u001a\u0006*\u00020\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0005H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u0016¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\tJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\tR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013"}, d2 = {"Lid/dana/data/account/repository/source/LocalConfigLiteAccountEntityRepository;", "Lid/dana/domain/account/LiteAccountRepository;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lio/reactivex/Observable;", "Lj$/util/Optional;", "", "initSecurePreferenceAccount", "()Lio/reactivex/Observable;", "Lid/dana/domain/account/Account;", "getAccount", "", "hasAccount", "getUserId", "phoneNumber", "Ldagger/Lazy;", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/data/account/mapper/AccountMapper;", "accountMapper", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final class LocalConfigLiteAccountEntityRepository implements LiteAccountRepository {
    private final Lazy<AccountEntityDataFactory> accountEntityDataFactory;
    private final Lazy<AccountMapper> accountMapper;

    @Inject
    public LocalConfigLiteAccountEntityRepository(Lazy<AccountEntityDataFactory> lazy, Lazy<AccountMapper> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.accountEntityDataFactory = lazy;
        this.accountMapper = lazy2;
    }

    @Override // id.dana.domain.account.LiteAccountRepository
    public final Observable<Optional<String>> initSecurePreferenceAccount() {
        Observable<Optional<String>> init = createAccountData().init();
        Intrinsics.checkNotNullExpressionValue(init, "");
        return init;
    }

    @Override // id.dana.domain.account.LiteAccountRepository
    public final Observable<Account> getAccount() {
        Observable map = createAccountData().getAccount().map(new Function() { // from class: id.dana.data.account.repository.source.LocalConfigLiteAccountEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Account m757getAccount$lambda0;
                m757getAccount$lambda0 = LocalConfigLiteAccountEntityRepository.m757getAccount$lambda0(LocalConfigLiteAccountEntityRepository.this, (AccountEntity) obj);
                return m757getAccount$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAccount$lambda-0  reason: not valid java name */
    public static final Account m757getAccount$lambda0(LocalConfigLiteAccountEntityRepository localConfigLiteAccountEntityRepository, AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(localConfigLiteAccountEntityRepository, "");
        Intrinsics.checkNotNullParameter(accountEntity, "");
        return localConfigLiteAccountEntityRepository.accountMapper.get().transform(accountEntity);
    }

    @Override // id.dana.domain.account.LiteAccountRepository
    public final Observable<Boolean> hasAccount() {
        Observable<Boolean> hasAccount = createAccountData().hasAccount();
        Intrinsics.checkNotNullExpressionValue(hasAccount, "");
        return hasAccount;
    }

    private final AccountEntityData createAccountData() {
        return this.accountEntityDataFactory.get().createData2("local");
    }

    @Override // id.dana.domain.account.LiteAccountRepository
    public final Observable<String> getUserId() {
        Observable<String> userId = createAccountData().getUserId();
        Intrinsics.checkNotNullExpressionValue(userId, "");
        return userId;
    }

    @Override // id.dana.domain.account.LiteAccountRepository
    public final Observable<String> phoneNumber() {
        Observable<String> phoneNumber = createAccountData().getPhoneNumber();
        Intrinsics.checkNotNullExpressionValue(phoneNumber, "");
        return phoneNumber;
    }
}
