package id.dana.data.account.repository;

import android.content.Context;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.TransactionEntity;
import id.dana.data.account.avatar.repository.source.AvatarEntityData;
import id.dana.data.account.avatar.repository.source.AvatarEntityDataFactory;
import id.dana.data.account.avatar.repository.source.network.result.AvatarEntityResult;
import id.dana.data.account.general.repository.GeneralEntityData;
import id.dana.data.account.general.repository.GeneralEntityDataFactory;
import id.dana.data.account.mapper.AccountMapper;
import id.dana.data.account.mapper.TransactionMapperKt;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.holdlogin.v1.HoldLoginV1EntityRepository;
import id.dana.data.userprofileinfo.source.UserProfileInfoEntityData;
import id.dana.data.userprofileinfo.source.UserProfileInfoEntityDataFactory;
import id.dana.data.userprofileinfo.source.network.result.UserProfileInfoResult;
import id.dana.domain.account.Account;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.model.Transaction;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class AccountEntityRepository implements AccountRepository {
    private final AccountMapper accountMapper;
    private final AvatarEntityDataFactory avatarEntityDataFactory;
    private final ConfigEntityDataFactory configEntityDataFactory;
    private final GeneralEntityDataFactory generalEntityDataFactory;
    private final HoldLoginV1EntityRepository holdLoginV1EntityRepository;
    private final UserProfileInfoEntityDataFactory userProfileInfoEntityDataFactory;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BalanceType {
        public static final String DANA = "dana";
        public static final String EMAS = "emas";
        public static final String GOALS = "goals";
        public static final String INVESTMENT = "investment";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface UpdateType {
        public static final String AVATAR = "avatarUrl";
        public static final String NICKNAME = "nickname";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String lambda$saveAvatarUrl$2(String str, String str2) throws Exception {
        return str;
    }

    @Inject
    public AccountEntityRepository(ConfigEntityDataFactory configEntityDataFactory, AvatarEntityDataFactory avatarEntityDataFactory, UserProfileInfoEntityDataFactory userProfileInfoEntityDataFactory, AccountMapper accountMapper, HoldLoginV1EntityRepository holdLoginV1EntityRepository, GeneralEntityDataFactory generalEntityDataFactory) {
        this.configEntityDataFactory = configEntityDataFactory;
        this.avatarEntityDataFactory = avatarEntityDataFactory;
        this.userProfileInfoEntityDataFactory = userProfileInfoEntityDataFactory;
        this.accountMapper = accountMapper;
        this.holdLoginV1EntityRepository = holdLoginV1EntityRepository;
        this.generalEntityDataFactory = generalEntityDataFactory;
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> uploadAvatar(File file) {
        return this.holdLoginV1EntityRepository.authenticatedRequest(createAvatarData().uploadAvatar(file, this.holdLoginV1EntityRepository.createAccountData().getUUIDAsString())).flatMap(updateProfile()).flatMap(saveAvatarUrl());
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> getAvatarUrl() {
        return this.holdLoginV1EntityRepository.createAccountData().getAvatarUrl();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> hasAccount() {
        return this.holdLoginV1EntityRepository.createAccountData().hasAccount();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> getUserId() {
        return this.holdLoginV1EntityRepository.createAccountData().getUserId();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> saveNickname(String str) {
        return this.holdLoginV1EntityRepository.createAccountData().saveNickname(str);
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> getNickname() {
        return this.holdLoginV1EntityRepository.createAccountData().getNickname();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> getUUID() {
        return this.holdLoginV1EntityRepository.createAccountData().getUUID();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> getPhoneNumber() {
        return this.holdLoginV1EntityRepository.createAccountData().getPhoneNumber();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> isFirstTime() {
        return this.holdLoginV1EntityRepository.createAccountData().isFirstTime();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> finishFirstTime() {
        return this.holdLoginV1EntityRepository.createAccountData().finishFirstTime();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Account> getDrutherDataForUpdate(Context context) {
        Observable<AccountEntity> drutherDataForUpdate = this.holdLoginV1EntityRepository.createAccountData().getDrutherDataForUpdate(context);
        AccountMapper accountMapper = this.accountMapper;
        Objects.requireNonNull(accountMapper);
        return drutherDataForUpdate.map(new AccountEntityRepository$$ExternalSyntheticLambda1(accountMapper));
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> getBalanceVisibility() {
        return createGeneralData().getBalanceVisibility();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> setBalanceVisibility(Boolean bool, String str) {
        char c;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == 3116762) {
            if (str.equals(BalanceType.EMAS)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 98526144) {
            if (hashCode == 1928999635 && str.equals(BalanceType.INVESTMENT)) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("goals")) {
                c = 1;
            }
            c = 65535;
        }
        if (c != 0) {
            if (c != 1) {
                if (c == 2) {
                    return createGeneralData().setInvestmentBalanceVisibility(bool.booleanValue());
                }
                return createGeneralData().setBalanceVisibility(bool.booleanValue());
            }
            return createGeneralData().setGoalsBalanceVisibility(bool.booleanValue());
        }
        return createGeneralData().setEmasBalanceVisibility(bool.booleanValue());
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Account> getAccount() {
        Observable<AccountEntity> account = this.holdLoginV1EntityRepository.createAccountData().getAccount();
        AccountMapper accountMapper = this.accountMapper;
        Objects.requireNonNull(accountMapper);
        return account.map(new AccountEntityRepository$$ExternalSyntheticLambda1(accountMapper));
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> saveLastTransaction(Transaction transaction) {
        return this.holdLoginV1EntityRepository.createAccountData().saveLastTransaction(TransactionMapperKt.toTransactionEntity(transaction));
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Transaction> getLastTransaction() {
        return this.holdLoginV1EntityRepository.createAccountData().getLatestTransaction().map(new Function() { // from class: id.dana.data.account.repository.AccountEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return TransactionMapperKt.toTransaction((TransactionEntity) obj);
            }
        });
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<String> getKycLevel() {
        return this.holdLoginV1EntityRepository.createAccountData().getKycLevel();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> getGoalsBalanceVisibility() {
        return createGeneralData().getGoalsBalanceVisibility();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> getInvestmentBalanceVisibility() {
        return createGeneralData().getInvestmentBalanceVisibility();
    }

    @Override // id.dana.domain.account.AccountRepository
    public Observable<Boolean> getEmasBalanceVisibility() {
        return createGeneralData().getEmasBalanceVisibility();
    }

    private GeneralEntityData createGeneralData() {
        return this.generalEntityDataFactory.createData2("local");
    }

    private AvatarEntityData createAvatarData() {
        return this.avatarEntityDataFactory.createData2("network");
    }

    private Function<AvatarEntityResult, Observable<String>> updateProfile() {
        return new Function() { // from class: id.dana.data.account.repository.AccountEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountEntityRepository.this.m756xde22ae1b((AvatarEntityResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateProfile$1$id-dana-data-account-repository-AccountEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m756xde22ae1b(final AvatarEntityResult avatarEntityResult) throws Exception {
        return createUserProfileInfo().updateUserProfileInfo(UpdateType.AVATAR, avatarEntityResult.url).map(new Function() { // from class: id.dana.data.account.repository.AccountEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String str;
                UserProfileInfoResult userProfileInfoResult = (UserProfileInfoResult) obj;
                str = AvatarEntityResult.this.url;
                return str;
            }
        });
    }

    private Function<String, Observable<String>> saveAvatarUrl() {
        return new Function() { // from class: id.dana.data.account.repository.AccountEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountEntityRepository.this.m755x8c49ee96((String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$saveAvatarUrl$3$id-dana-data-account-repository-AccountEntityRepository  reason: not valid java name */
    public /* synthetic */ Observable m755x8c49ee96(final String str) throws Exception {
        return this.holdLoginV1EntityRepository.createAccountData().saveAvatarUrl(str).map(new Function() { // from class: id.dana.data.account.repository.AccountEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return AccountEntityRepository.lambda$saveAvatarUrl$2(str, (String) obj);
            }
        });
    }

    private UserProfileInfoEntityData createUserProfileInfo() {
        return this.userProfileInfoEntityDataFactory.createData2("network");
    }

    private ConfigEntityData createSplitConfigData() {
        return this.configEntityDataFactory.createData2("split");
    }
}
