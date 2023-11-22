package id.dana.data.wallet_v3.repository;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.account.AccountEntity;
import id.dana.data.account.repository.source.AccountEntityData;
import id.dana.data.account.repository.source.AccountEntityDataFactory;
import id.dana.data.pocket.mapper.PocketQueryListResultMapperKt;
import id.dana.data.pocket.model.KtpAssetResult;
import id.dana.data.pocket.model.PocketQueryListResult;
import id.dana.data.security.source.SecurityEntityData;
import id.dana.data.security.source.SecurityEntityDataFactory;
import id.dana.data.userconfig.UserConfigBizTypeConstant;
import id.dana.data.userconfig.model.KtpPopUpStoreConfig;
import id.dana.data.userconfig.model.KtpPopUpUserConfig;
import id.dana.data.userconfig.repository.UserConfigRepository;
import id.dana.data.wallet.mapper.VerifyPinKtpMapperKt;
import id.dana.data.wallet_v3.mapper.KycInfoMapperKt;
import id.dana.data.wallet_v3.repository.source.WalletV3EntityDataFactory;
import id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityData;
import id.dana.data.wallet_v3.repository.source.network.PersonalTabEntityDataFactory;
import id.dana.data.wallet_v3.repository.source.network.result.KtpResult;
import id.dana.data.wallet_v3.repository.source.network.result.KycStatusResult;
import id.dana.data.wallet_v3.repository.source.network.result.VerifyPinKtpResult;
import id.dana.domain.pocket.model.AssetStatus;
import id.dana.domain.pocket.model.PocketQueryList;
import id.dana.domain.userconfig.model.QueryConfig;
import id.dana.domain.wallet_v3.model.InsuranceAsset;
import id.dana.domain.wallet_v3.model.KtpInfo;
import id.dana.domain.wallet_v3.model.KycInfo;
import id.dana.domain.wallet_v3.model.VerifyPinKtpModel;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010@\u001a\u00020?\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010F\u001a\u00020E\u0012\u0006\u0010L\u001a\u00020K¢\u0006\u0004\bN\u0010OJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u0006*\u00020\n0\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u000fJ\u0013\u0010\u0015\u001a\u0006*\u00020\u00140\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\tJ9\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016¢\u0006\u0004\b#\u0010$J+\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0!0\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016¢\u0006\u0004\b&\u0010'J\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0002¢\u0006\u0004\b(\u0010\u0005J'\u0010*\u001a\u001a\u0012\b\u0012\u0006*\u00020)0)*\f\u0012\b\u0012\u0006*\u00020)0)0\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u0005J%\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0016¢\u0006\u0004\b,\u0010'J\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\tJ\u0015\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b.\u0010\u0005J%\u00100\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u00102\u001a\u00020\u0003H\u0016¢\u0006\u0004\b3\u00104J\u001d\u00107\u001a\u00020\u00172\f\u00106\u001a\b\u0012\u0004\u0012\u0002050\u001eH\u0002¢\u0006\u0004\b7\u00108J\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u00102\u001a\u00020\u0003H\u0016¢\u0006\u0004\b9\u00104J/\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\u00020\u00022\u0006\u00102\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010;J\u001d\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u00022\u0006\u0010<\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u0010\tR\u0014\u0010@\u001a\u00020?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010I\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020K8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bL\u0010M"}, d2 = {"Lid/dana/data/wallet_v3/repository/PersonalTabEntityRepository;", "Lid/dana/domain/wallet_v3/repository/PersonalTabRepository;", "Lio/reactivex/Observable;", "", "checkKtpConsultPopUp", "()Lio/reactivex/Observable;", "", "phoneNumber", "checkKtpPopUp", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/account/repository/source/AccountEntityData;", "createAccountData", "()Lid/dana/data/account/repository/source/AccountEntityData;", "Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityData;", "createLocalPersonalTabEntityData", "()Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityData;", "Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "createLocalWalletV3EntityData", "()Lid/dana/data/wallet_v3/repository/WalletV3EntityData;", "createNetworkPersonalTabEntityData", "Lid/dana/data/security/source/SecurityEntityData;", "createSecurityData", "()Lid/dana/data/security/source/SecurityEntityData;", "", "deleteKtpDetailInfo", "()V", "firstTimeCheck", "", "pageNum", SecurityConstants.KEY_PAGE_SIZE, "", "Lid/dana/domain/pocket/model/AssetStatus;", "statuses", "Lid/dana/domain/pocket/model/PocketQueryList;", "Lid/dana/domain/wallet_v3/model/InsuranceAsset;", "getInsuranceAssets", "(IILjava/util/List;)Lio/reactivex/Observable;", "Lid/dana/domain/wallet_v3/model/KtpInfo;", "getKtpInfo", "(II)Lio/reactivex/Observable;", "getPhoneNumber", "Lid/dana/data/userconfig/model/KtpPopUpUserConfig;", "getPopupUserConfig", "Lid/dana/domain/wallet_v3/model/KycInfo;", "getUserKYCStatus", "getUserSpecificConfigAndSaveToLocal", "isKtpSaved", SummaryActivity.FIRST_STATE_SHARE_FEED, "saveFirstTimeCheck", "(Ljava/lang/String;Z)Lio/reactivex/Observable;", "userSaveKtp", "saveKtpConsultPopUp", "(Z)Lio/reactivex/Observable;", "Lid/dana/data/wallet_v3/repository/source/network/result/KtpResult;", "ktpResult", "saveKtpDetailInfo", "(Ljava/util/List;)V", "storeKtpSaved", "updatePreferenceAndDatabase", "(ZLjava/lang/String;)Lio/reactivex/Observable;", "inputPin", "Lid/dana/domain/wallet_v3/model/VerifyPinKtpModel;", "verifyPinPersonalKtp", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "accountEntityDataFactory", "Lid/dana/data/account/repository/source/AccountEntityDataFactory;", "Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityDataFactory;", "personalTabEntityDataFactory", "Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityDataFactory;", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "securityEntityDataFactory", "Lid/dana/data/security/source/SecurityEntityDataFactory;", "Lid/dana/data/userconfig/repository/UserConfigRepository;", "userConfigRepository", "Lid/dana/data/userconfig/repository/UserConfigRepository;", "Lid/dana/data/wallet_v3/repository/source/WalletV3EntityDataFactory;", "walletV3EntityDataFactory", "Lid/dana/data/wallet_v3/repository/source/WalletV3EntityDataFactory;", "<init>", "(Lid/dana/data/wallet_v3/repository/source/network/PersonalTabEntityDataFactory;Lid/dana/data/account/repository/source/AccountEntityDataFactory;Lid/dana/data/userconfig/repository/UserConfigRepository;Lid/dana/data/security/source/SecurityEntityDataFactory;Lid/dana/data/wallet_v3/repository/source/WalletV3EntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PersonalTabEntityRepository implements PersonalTabRepository {
    private final AccountEntityDataFactory accountEntityDataFactory;
    private final PersonalTabEntityDataFactory personalTabEntityDataFactory;
    private final SecurityEntityDataFactory securityEntityDataFactory;
    private final UserConfigRepository userConfigRepository;
    private final WalletV3EntityDataFactory walletV3EntityDataFactory;

    @Inject
    public PersonalTabEntityRepository(PersonalTabEntityDataFactory personalTabEntityDataFactory, AccountEntityDataFactory accountEntityDataFactory, UserConfigRepository userConfigRepository, SecurityEntityDataFactory securityEntityDataFactory, WalletV3EntityDataFactory walletV3EntityDataFactory) {
        Intrinsics.checkNotNullParameter(personalTabEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(accountEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(userConfigRepository, "");
        Intrinsics.checkNotNullParameter(securityEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(walletV3EntityDataFactory, "");
        this.personalTabEntityDataFactory = personalTabEntityDataFactory;
        this.accountEntityDataFactory = accountEntityDataFactory;
        this.userConfigRepository = userConfigRepository;
        this.securityEntityDataFactory = securityEntityDataFactory;
        this.walletV3EntityDataFactory = walletV3EntityDataFactory;
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<Boolean> checkKtpConsultPopUp() {
        Observable flatMap = getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2151checkKtpConsultPopUp$lambda0;
                m2151checkKtpConsultPopUp$lambda0 = PersonalTabEntityRepository.m2151checkKtpConsultPopUp$lambda0(PersonalTabEntityRepository.this, (String) obj);
                return m2151checkKtpConsultPopUp$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: checkKtpConsultPopUp$lambda-0  reason: not valid java name */
    public static final ObservableSource m2151checkKtpConsultPopUp$lambda0(PersonalTabEntityRepository personalTabEntityRepository, String str) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return personalTabEntityRepository.firstTimeCheck(str);
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<Boolean> saveKtpConsultPopUp(final boolean userSaveKtp) {
        Observable<Boolean> flatMap = getPopupUserConfig().map(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable m2163saveKtpConsultPopUp$lambda2;
                m2163saveKtpConsultPopUp$lambda2 = PersonalTabEntityRepository.m2163saveKtpConsultPopUp$lambda2(PersonalTabEntityRepository.this, userSaveKtp, (KtpPopUpUserConfig) obj);
                return m2163saveKtpConsultPopUp$lambda2;
            }
        }).flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2164saveKtpConsultPopUp$lambda4;
                m2164saveKtpConsultPopUp$lambda4 = PersonalTabEntityRepository.m2164saveKtpConsultPopUp$lambda4(PersonalTabEntityRepository.this, userSaveKtp, (Observable) obj);
                return m2164saveKtpConsultPopUp$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveKtpConsultPopUp$lambda-2  reason: not valid java name */
    public static final Observable m2163saveKtpConsultPopUp$lambda2(PersonalTabEntityRepository personalTabEntityRepository, boolean z, KtpPopUpUserConfig ktpPopUpUserConfig) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(ktpPopUpUserConfig, "");
        UserConfigRepository userConfigRepository = personalTabEntityRepository.userConfigRepository;
        ktpPopUpUserConfig.setKtpIsSaved(z);
        return userConfigRepository.saveUserSpecificConfig(new KtpPopUpStoreConfig(ktpPopUpUserConfig));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveKtpConsultPopUp$lambda-4  reason: not valid java name */
    public static final ObservableSource m2164saveKtpConsultPopUp$lambda4(final PersonalTabEntityRepository personalTabEntityRepository, final boolean z, Observable observable) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(observable, "");
        return personalTabEntityRepository.getPhoneNumber().flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2165saveKtpConsultPopUp$lambda4$lambda3;
                m2165saveKtpConsultPopUp$lambda4$lambda3 = PersonalTabEntityRepository.m2165saveKtpConsultPopUp$lambda4$lambda3(PersonalTabEntityRepository.this, z, (String) obj);
                return m2165saveKtpConsultPopUp$lambda4$lambda3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveKtpConsultPopUp$lambda-4$lambda-3  reason: not valid java name */
    public static final ObservableSource m2165saveKtpConsultPopUp$lambda4$lambda3(PersonalTabEntityRepository personalTabEntityRepository, boolean z, String str) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        return personalTabEntityRepository.updatePreferenceAndDatabase(z, str);
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<KycInfo> getUserKYCStatus(int pageNum, int pageSize) {
        Observable map = createNetworkPersonalTabEntityData().getUserKYCStatus(pageNum, pageSize).map(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                KycInfo m2158getUserKYCStatus$lambda5;
                m2158getUserKYCStatus$lambda5 = PersonalTabEntityRepository.m2158getUserKYCStatus$lambda5((KycStatusResult) obj);
                return m2158getUserKYCStatus$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserKYCStatus$lambda-5  reason: not valid java name */
    public static final KycInfo m2158getUserKYCStatus$lambda5(KycStatusResult kycStatusResult) {
        Intrinsics.checkNotNullParameter(kycStatusResult, "");
        return KycInfoMapperKt.toKycInfo(kycStatusResult);
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<PocketQueryList<KtpInfo>> getKtpInfo(int pageNum, int pageSize) {
        Observable map = createNetworkPersonalTabEntityData().getKtpInfo(pageNum, pageSize).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PersonalTabEntityRepository.m2154getKtpInfo$lambda6(PersonalTabEntityRepository.this, (KtpAssetResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PocketQueryList m2155getKtpInfo$lambda7;
                m2155getKtpInfo$lambda7 = PersonalTabEntityRepository.m2155getKtpInfo$lambda7((KtpAssetResult) obj);
                return m2155getKtpInfo$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getKtpInfo$lambda-6  reason: not valid java name */
    public static final void m2154getKtpInfo$lambda6(PersonalTabEntityRepository personalTabEntityRepository, KtpAssetResult ktpAssetResult) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        personalTabEntityRepository.saveKtpDetailInfo(ktpAssetResult.getPockets());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getKtpInfo$lambda-7  reason: not valid java name */
    public static final PocketQueryList m2155getKtpInfo$lambda7(KtpAssetResult ktpAssetResult) {
        Intrinsics.checkNotNullParameter(ktpAssetResult, "");
        return PocketQueryListResultMapperKt.toPocketQueryList(ktpAssetResult, PersonalTabEntityRepository$getKtpInfo$2$1.INSTANCE);
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<PocketQueryList<InsuranceAsset>> getInsuranceAssets(int pageNum, int pageSize, List<? extends AssetStatus> statuses) {
        Intrinsics.checkNotNullParameter(statuses, "");
        Observable map = createNetworkPersonalTabEntityData().getInsuranceAssets(pageNum, pageSize, statuses).map(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PocketQueryList m2153getInsuranceAssets$lambda8;
                m2153getInsuranceAssets$lambda8 = PersonalTabEntityRepository.m2153getInsuranceAssets$lambda8((PocketQueryListResult) obj);
                return m2153getInsuranceAssets$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getInsuranceAssets$lambda-8  reason: not valid java name */
    public static final PocketQueryList m2153getInsuranceAssets$lambda8(PocketQueryListResult pocketQueryListResult) {
        Intrinsics.checkNotNullParameter(pocketQueryListResult, "");
        return PocketQueryListResultMapperKt.toPocketQueryList(pocketQueryListResult, PersonalTabEntityRepository$getInsuranceAssets$1$1.INSTANCE);
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<VerifyPinKtpModel> verifyPinPersonalKtp(final String inputPin) {
        Intrinsics.checkNotNullParameter(inputPin, "");
        Observable flatMap = createSecurityData().loginKey().flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2168verifyPinPersonalKtp$lambda10;
                m2168verifyPinPersonalKtp$lambda10 = PersonalTabEntityRepository.m2168verifyPinPersonalKtp$lambda10(PersonalTabEntityRepository.this, inputPin, (String) obj);
                return m2168verifyPinPersonalKtp$lambda10;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyPinPersonalKtp$lambda-10  reason: not valid java name */
    public static final ObservableSource m2168verifyPinPersonalKtp$lambda10(PersonalTabEntityRepository personalTabEntityRepository, String str, String str2) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return personalTabEntityRepository.createNetworkPersonalTabEntityData().verifyPinKtp(str, str2).map(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                VerifyPinKtpModel m2169verifyPinPersonalKtp$lambda10$lambda9;
                m2169verifyPinPersonalKtp$lambda10$lambda9 = PersonalTabEntityRepository.m2169verifyPinPersonalKtp$lambda10$lambda9((VerifyPinKtpResult) obj);
                return m2169verifyPinPersonalKtp$lambda10$lambda9;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: verifyPinPersonalKtp$lambda-10$lambda-9  reason: not valid java name */
    public static final VerifyPinKtpModel m2169verifyPinPersonalKtp$lambda10$lambda9(VerifyPinKtpResult verifyPinKtpResult) {
        Intrinsics.checkNotNullParameter(verifyPinKtpResult, "");
        return VerifyPinKtpMapperKt.BuiltInFictitiousFunctionClassFactory(verifyPinKtpResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: isKtpSaved$lambda-11  reason: not valid java name */
    public static final Boolean m2161isKtpSaved$lambda11(KtpPopUpUserConfig ktpPopUpUserConfig) {
        Intrinsics.checkNotNullParameter(ktpPopUpUserConfig, "");
        return Boolean.valueOf(ktpPopUpUserConfig.getKtpIsSaved());
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<Boolean> isKtpSaved() {
        Observable map = getPopupUserConfig().map(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m2161isKtpSaved$lambda11;
                m2161isKtpSaved$lambda11 = PersonalTabEntityRepository.m2161isKtpSaved$lambda11((KtpPopUpUserConfig) obj);
                return m2161isKtpSaved$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.wallet_v3.repository.PersonalTabRepository
    public final Observable<Boolean> storeKtpSaved(final boolean userSaveKtp) {
        Observable flatMap = getPopupUserConfig().flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2166storeKtpSaved$lambda13;
                m2166storeKtpSaved$lambda13 = PersonalTabEntityRepository.m2166storeKtpSaved$lambda13(PersonalTabEntityRepository.this, userSaveKtp, (KtpPopUpUserConfig) obj);
                return m2166storeKtpSaved$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: storeKtpSaved$lambda-13  reason: not valid java name */
    public static final ObservableSource m2166storeKtpSaved$lambda13(PersonalTabEntityRepository personalTabEntityRepository, boolean z, KtpPopUpUserConfig ktpPopUpUserConfig) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(ktpPopUpUserConfig, "");
        UserConfigRepository userConfigRepository = personalTabEntityRepository.userConfigRepository;
        ktpPopUpUserConfig.setKtpIsSaved(z);
        return userConfigRepository.saveUserSpecificConfig(new KtpPopUpStoreConfig(ktpPopUpUserConfig));
    }

    private final Observable<Boolean> firstTimeCheck(final String phoneNumber) {
        Observable flatMap = createLocalPersonalTabEntityData().isFirstTimeCheck(phoneNumber).flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2152firstTimeCheck$lambda14;
                m2152firstTimeCheck$lambda14 = PersonalTabEntityRepository.m2152firstTimeCheck$lambda14(PersonalTabEntityRepository.this, phoneNumber, (Boolean) obj);
                return m2152firstTimeCheck$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: firstTimeCheck$lambda-14  reason: not valid java name */
    public static final ObservableSource m2152firstTimeCheck$lambda14(PersonalTabEntityRepository personalTabEntityRepository, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bool, "");
        return personalTabEntityRepository.saveFirstTimeCheck(str, bool.booleanValue());
    }

    private final Observable<Boolean> saveFirstTimeCheck(final String phoneNumber, boolean firstTime) {
        if (firstTime) {
            Observable<Boolean> doOnNext = createLocalPersonalTabEntityData().saveFirstTimeCheck(phoneNumber).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda14
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    PersonalTabEntityRepository.m2162saveFirstTimeCheck$lambda15(PersonalTabEntityRepository.this, phoneNumber, (Boolean) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            return doOnNext;
        }
        return checkKtpPopUp(phoneNumber);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveFirstTimeCheck$lambda-15  reason: not valid java name */
    public static final void m2162saveFirstTimeCheck$lambda15(PersonalTabEntityRepository personalTabEntityRepository, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        personalTabEntityRepository.getUserSpecificConfigAndSaveToLocal(str);
    }

    private final Observable<Boolean> checkKtpPopUp(String phoneNumber) {
        return createLocalPersonalTabEntityData().checkKtpPopUp(phoneNumber);
    }

    private final Observable<Boolean> getUserSpecificConfigAndSaveToLocal(final String phoneNumber) {
        Observable flatMap = getPopupUserConfig().doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PersonalTabEntityRepository.m2159getUserSpecificConfigAndSaveToLocal$lambda16(PersonalTabEntityRepository.this, phoneNumber, (KtpPopUpUserConfig) obj);
            }
        }).flatMap(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m2160getUserSpecificConfigAndSaveToLocal$lambda17;
                m2160getUserSpecificConfigAndSaveToLocal$lambda17 = PersonalTabEntityRepository.m2160getUserSpecificConfigAndSaveToLocal$lambda17((KtpPopUpUserConfig) obj);
                return m2160getUserSpecificConfigAndSaveToLocal$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserSpecificConfigAndSaveToLocal$lambda-16  reason: not valid java name */
    public static final void m2159getUserSpecificConfigAndSaveToLocal$lambda16(PersonalTabEntityRepository personalTabEntityRepository, String str, KtpPopUpUserConfig ktpPopUpUserConfig) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        Intrinsics.checkNotNullParameter(str, "");
        personalTabEntityRepository.createLocalPersonalTabEntityData().saveKtpPopUpCheck(str, ktpPopUpUserConfig.getKtpIsSaved());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getUserSpecificConfigAndSaveToLocal$lambda-17  reason: not valid java name */
    public static final ObservableSource m2160getUserSpecificConfigAndSaveToLocal$lambda17(KtpPopUpUserConfig ktpPopUpUserConfig) {
        Intrinsics.checkNotNullParameter(ktpPopUpUserConfig, "");
        return Observable.just(Boolean.valueOf(ktpPopUpUserConfig.getKtpIsSaved()));
    }

    private final Observable<String> getPhoneNumber() {
        Observable map = createAccountData().getAccount().map(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                String m2156getPhoneNumber$lambda18;
                m2156getPhoneNumber$lambda18 = PersonalTabEntityRepository.m2156getPhoneNumber$lambda18((AccountEntity) obj);
                return m2156getPhoneNumber$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPhoneNumber$lambda-18  reason: not valid java name */
    public static final String m2156getPhoneNumber$lambda18(AccountEntity accountEntity) {
        Intrinsics.checkNotNullParameter(accountEntity, "");
        String phoneNumber = accountEntity.getPhoneNumber();
        return phoneNumber == null ? "" : phoneNumber;
    }

    private final Observable<KtpPopUpUserConfig> getPopupUserConfig() {
        return this.userConfigRepository.getUserSpecificConfig(new QueryConfig(UserConfigBizTypeConstant.SHOW_USER_CONSULT_POP_UP, KtpPopUpUserConfig.class)).onErrorResumeNext(new Function() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Observable m2157getPopupUserConfig$lambda19;
                m2157getPopupUserConfig$lambda19 = PersonalTabEntityRepository.m2157getPopupUserConfig$lambda19((Throwable) obj);
                return m2157getPopupUserConfig$lambda19;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getPopupUserConfig$lambda-19  reason: not valid java name */
    public static final Observable m2157getPopupUserConfig$lambda19(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(new KtpPopUpUserConfig(false, 1, null));
    }

    private final Observable<Boolean> updatePreferenceAndDatabase(boolean userSaveKtp, String phoneNumber) {
        if (userSaveKtp) {
            return createLocalPersonalTabEntityData().saveKtpPopUpCheck(phoneNumber, userSaveKtp);
        }
        return createLocalPersonalTabEntityData().saveKtpPopUpCheck(phoneNumber, userSaveKtp).doOnNext(new Consumer() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PersonalTabEntityRepository.m2167updatePreferenceAndDatabase$lambda20(PersonalTabEntityRepository.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updatePreferenceAndDatabase$lambda-20  reason: not valid java name */
    public static final void m2167updatePreferenceAndDatabase$lambda20(PersonalTabEntityRepository personalTabEntityRepository, Boolean bool) {
        Intrinsics.checkNotNullParameter(personalTabEntityRepository, "");
        personalTabEntityRepository.deleteKtpDetailInfo();
    }

    private final void saveKtpDetailInfo(List<KtpResult> ktpResult) {
        SubscribersKt.MyBillsEntityDataFactory(createLocalWalletV3EntityData().saveKtpDetailInfo(ktpResult), new Function1<Throwable, Unit>() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$saveKtpDetailInfo$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory("WalletV3", th.getMessage(), th);
            }
        }, null, 2);
    }

    private final void deleteKtpDetailInfo() {
        SubscribersKt.MyBillsEntityDataFactory(createLocalWalletV3EntityData().deleteKtpDetailInfo(), new Function1<Throwable, Unit>() { // from class: id.dana.data.wallet_v3.repository.PersonalTabEntityRepository$deleteKtpDetailInfo$1
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory("WalletV3", th.getMessage(), th);
            }
        }, null, 2);
    }

    private final AccountEntityData createAccountData() {
        return this.accountEntityDataFactory.createData2("local");
    }

    private final PersonalTabEntityData createNetworkPersonalTabEntityData() {
        return this.personalTabEntityDataFactory.createData2("network");
    }

    private final PersonalTabEntityData createLocalPersonalTabEntityData() {
        return this.personalTabEntityDataFactory.createData2("local");
    }

    private final SecurityEntityData createSecurityData() {
        return this.securityEntityDataFactory.createData2("network");
    }

    private final WalletV3EntityData createLocalWalletV3EntityData() {
        return this.walletV3EntityDataFactory.createData2("local");
    }
}
