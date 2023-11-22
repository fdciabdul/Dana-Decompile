package id.dana.data.account.clear.repository.source.preference;

import android.app.Application;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Lazy;
import id.dana.data.account.clear.repository.ClearAccountEntityData;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefScannerConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefSplitAttributes;
import id.dana.data.danaprotection.repository.source.local.DanaProtectionInfoPreference;
import id.dana.data.deeplink.repository.source.local.DeepLinkPreferences;
import id.dana.data.foundation.facade.SecurityGuardFacade;
import id.dana.data.foundation.h5app.repository.source.local.H5ResponseCachePreferences;
import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.home.repository.source.presistence.PersistenceHomeWidgetEntityData;
import id.dana.data.homeinfo.repository.source.local.MaintenanceBroadcastPreference;
import id.dana.data.kycrenewal.repository.source.session.KycRenewalPreference;
import id.dana.data.miniprogram.source.local.MiniProgramPreference;
import id.dana.data.nearbyme.repository.source.local.PreferenceMerchantReviewFormEntityData;
import id.dana.data.promotion.repository.source.persistence.PromoPreference;
import id.dana.data.pushverify.source.local.LocalPushVerifyPreferenceEntityData;
import id.dana.data.recentrecipient.source.persistence.PersistenceRecentRecipientEntityData;
import id.dana.data.referral.repository.source.local.ReferralPreferences;
import id.dana.data.registration.source.local.LocalRegistrationEntityData;
import id.dana.data.splitbill.repository.source.persistence.PersistenceRecentPayerEntityData;
import id.dana.data.splitbill.repository.source.persistence.PersistenceSplitBillEntityData;
import id.dana.data.storage.GeneralPreferences;
import id.dana.data.user.source.persistence.LocalUserInfoData;
import id.dana.data.user.source.persistence.UserInfoPreference;
import id.dana.data.userconfig.repository.source.local.UserConfigPreference;
import id.dana.data.userconsent.repository.source.local.UserConsentPreference;
import id.dana.data.usercredential.repository.source.local.CredentialPreference;
import id.dana.data.userpersonalization.source.local.UserPersonalizationPreferences;
import id.dana.data.wallet_v3.repository.source.local.WalletV3Preference;
import id.dana.data.wallet_v3.repository.source.persistence.PersistenceWalletV3EntityData;
import id.dana.utils.foundation.logger.log.DanaLog;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u009f\u0003\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0006\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0006\u0012\f\u00107\u001a\b\u0012\u0004\u0012\u0002060\u0006\u0012\f\u00109\u001a\b\u0012\u0004\u0012\u0002080\u0006\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0006\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0006\u0012\f\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u0006\u0012\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u0006\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u0006\u0012\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0006\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0006\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0006\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u0006\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u0002000\u0006\u0012\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0006\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u0006\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0006¢\u0006\u0004\bB\u0010CJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\tR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\tR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\tR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\tR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\tR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\tR\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\tR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\tR\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\tR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\tR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\tR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\tR\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\tR\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\tR\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\tR\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\tR\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\tR\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\tR\u001a\u00101\u001a\b\u0012\u0004\u0012\u0002000\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010\tR\u001a\u00103\u001a\b\u0012\u0004\u0012\u0002020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010\tR\u001a\u00105\u001a\b\u0012\u0004\u0012\u0002040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010\tR\u001a\u00107\u001a\b\u0012\u0004\u0012\u0002060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010\tR\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u0010\tR\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010\tR\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020<0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010\tR\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010\tR\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010\t"}, d2 = {"Lid/dana/data/account/clear/repository/source/preference/PreferenceClearAccountEntityData;", "Lid/dana/data/account/clear/repository/ClearAccountEntityData;", "Lio/reactivex/Observable;", "", "clearAll", "()Lio/reactivex/Observable;", "Ldagger/Lazy;", "Landroid/app/Application;", HummerConstants.CONTEXT, "Ldagger/Lazy;", "Lid/dana/data/usercredential/repository/source/local/CredentialPreference;", "credentialPreference", "Lid/dana/data/danaprotection/repository/source/local/DanaProtectionInfoPreference;", "danaProtectionInfoPreference", "Lid/dana/data/deeplink/repository/source/local/DeepLinkPreferences;", "deepLinkPreferences", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Lid/dana/data/foundation/h5app/repository/source/local/H5ResponseCachePreferences;", "h5ResponseCachePreferences", "Lid/dana/data/kycrenewal/repository/source/session/KycRenewalPreference;", "kycRenewalPreference", "Lid/dana/data/pushverify/source/local/LocalPushVerifyPreferenceEntityData;", "localPushVerifyPreferenceEntityData", "Lid/dana/data/registration/source/local/LocalRegistrationEntityData;", "localRegistrationEntityData", "Lid/dana/data/user/source/persistence/LocalUserInfoData;", "localUserInfoData", "Lid/dana/data/homeinfo/repository/source/local/MaintenanceBroadcastPreference;", "maintenanceBroadcastPreference", "Lid/dana/data/nearbyme/repository/source/local/PreferenceMerchantReviewFormEntityData;", "merchantReviewPreference", "Lid/dana/data/miniprogram/source/local/MiniProgramPreference;", "miniProgramPreference", "Lid/dana/data/home/repository/source/presistence/PersistenceHomeWidgetEntityData;", "persistenceHomeWidgetEntityData", "Lid/dana/data/wallet_v3/repository/source/persistence/PersistenceWalletV3EntityData;", "persistenceWalletV3EntityData", "Lid/dana/data/promotion/repository/source/persistence/PromoPreference;", "promoPreference", "Lid/dana/data/splitbill/repository/source/persistence/PersistenceRecentPayerEntityData;", "recentPayerEntityData", "Lid/dana/data/recentrecipient/source/persistence/PersistenceRecentRecipientEntityData;", "recentRecipientEntityData", "Lid/dana/data/referral/repository/source/local/ReferralPreferences;", "referralPreferences", "Lid/dana/data/foundation/facade/SecurityGuardFacade;", "securityGuardFacade", "Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "sharedPrefCashierConfig", "Lid/dana/data/config/source/sharedpreference/SharedPrefScannerConfig;", "sharedPrefScannerConfig", "Lid/dana/data/config/source/sharedpreference/SharedPrefSplitAttributes;", "sharedPrefSplitAttributes", "Lid/dana/data/splitbill/repository/source/persistence/PersistenceSplitBillEntityData;", "splitBillEntityData", "Lid/dana/data/userconfig/repository/source/local/UserConfigPreference;", "userConfigPreference", "Lid/dana/data/userconsent/repository/source/local/UserConsentPreference;", "userConsentPreference", "Lid/dana/data/user/source/persistence/UserInfoPreference;", "userInfoPreference", "Lid/dana/data/userpersonalization/source/local/UserPersonalizationPreferences;", "userPersonalizationPreferences", "Lid/dana/data/wallet_v3/repository/source/local/WalletV3Preference;", "walletV3Preference", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreferenceClearAccountEntityData implements ClearAccountEntityData {
    private final Lazy<Application> context;
    private final Lazy<CredentialPreference> credentialPreference;
    private final Lazy<DanaProtectionInfoPreference> danaProtectionInfoPreference;
    private final Lazy<DeepLinkPreferences> deepLinkPreferences;
    private final Lazy<GeneralPreferences> generalPreferences;
    private final Lazy<H5ResponseCachePreferences> h5ResponseCachePreferences;
    private final Lazy<KycRenewalPreference> kycRenewalPreference;
    private final Lazy<LocalPushVerifyPreferenceEntityData> localPushVerifyPreferenceEntityData;
    private final Lazy<LocalRegistrationEntityData> localRegistrationEntityData;
    private final Lazy<LocalUserInfoData> localUserInfoData;
    private final Lazy<MaintenanceBroadcastPreference> maintenanceBroadcastPreference;
    private final Lazy<PreferenceMerchantReviewFormEntityData> merchantReviewPreference;
    private final Lazy<MiniProgramPreference> miniProgramPreference;
    private final Lazy<PersistenceHomeWidgetEntityData> persistenceHomeWidgetEntityData;
    private final Lazy<PersistenceWalletV3EntityData> persistenceWalletV3EntityData;
    private final Lazy<PromoPreference> promoPreference;
    private final Lazy<PersistenceRecentPayerEntityData> recentPayerEntityData;
    private final Lazy<PersistenceRecentRecipientEntityData> recentRecipientEntityData;
    private final Lazy<ReferralPreferences> referralPreferences;
    private final Lazy<SecurityGuardFacade> securityGuardFacade;
    private final Lazy<SharedPrefCashierConfig> sharedPrefCashierConfig;
    private final Lazy<SharedPrefScannerConfig> sharedPrefScannerConfig;
    private final Lazy<SharedPrefSplitAttributes> sharedPrefSplitAttributes;
    private final Lazy<PersistenceSplitBillEntityData> splitBillEntityData;
    private final Lazy<UserConfigPreference> userConfigPreference;
    private final Lazy<UserConsentPreference> userConsentPreference;
    private final Lazy<UserInfoPreference> userInfoPreference;
    private final Lazy<UserPersonalizationPreferences> userPersonalizationPreferences;
    private final Lazy<WalletV3Preference> walletV3Preference;

    @Inject
    public PreferenceClearAccountEntityData(Lazy<DeepLinkPreferences> lazy, Lazy<H5ResponseCachePreferences> lazy2, Lazy<PersistenceRecentPayerEntityData> lazy3, Lazy<ReferralPreferences> lazy4, Lazy<PersistenceSplitBillEntityData> lazy5, Lazy<UserConfigPreference> lazy6, Lazy<PromoPreference> lazy7, Lazy<Application> lazy8, Lazy<PreferenceMerchantReviewFormEntityData> lazy9, Lazy<KycRenewalPreference> lazy10, Lazy<MaintenanceBroadcastPreference> lazy11, Lazy<UserConsentPreference> lazy12, Lazy<UserPersonalizationPreferences> lazy13, Lazy<UserInfoPreference> lazy14, Lazy<SharedPrefSplitAttributes> lazy15, Lazy<LocalUserInfoData> lazy16, Lazy<PersistenceWalletV3EntityData> lazy17, Lazy<WalletV3Preference> lazy18, Lazy<LocalRegistrationEntityData> lazy19, Lazy<PersistenceRecentRecipientEntityData> lazy20, Lazy<CredentialPreference> lazy21, Lazy<LocalPushVerifyPreferenceEntityData> lazy22, Lazy<DanaProtectionInfoPreference> lazy23, Lazy<SharedPrefCashierConfig> lazy24, Lazy<SharedPrefScannerConfig> lazy25, Lazy<PersistenceHomeWidgetEntityData> lazy26, Lazy<MiniProgramPreference> lazy27, Lazy<GeneralPreferences> lazy28, Lazy<SecurityGuardFacade> lazy29) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        Intrinsics.checkNotNullParameter(lazy11, "");
        Intrinsics.checkNotNullParameter(lazy12, "");
        Intrinsics.checkNotNullParameter(lazy13, "");
        Intrinsics.checkNotNullParameter(lazy14, "");
        Intrinsics.checkNotNullParameter(lazy15, "");
        Intrinsics.checkNotNullParameter(lazy16, "");
        Intrinsics.checkNotNullParameter(lazy17, "");
        Intrinsics.checkNotNullParameter(lazy18, "");
        Intrinsics.checkNotNullParameter(lazy19, "");
        Intrinsics.checkNotNullParameter(lazy20, "");
        Intrinsics.checkNotNullParameter(lazy21, "");
        Intrinsics.checkNotNullParameter(lazy22, "");
        Intrinsics.checkNotNullParameter(lazy23, "");
        Intrinsics.checkNotNullParameter(lazy24, "");
        Intrinsics.checkNotNullParameter(lazy25, "");
        Intrinsics.checkNotNullParameter(lazy26, "");
        Intrinsics.checkNotNullParameter(lazy27, "");
        Intrinsics.checkNotNullParameter(lazy28, "");
        Intrinsics.checkNotNullParameter(lazy29, "");
        this.deepLinkPreferences = lazy;
        this.h5ResponseCachePreferences = lazy2;
        this.recentPayerEntityData = lazy3;
        this.referralPreferences = lazy4;
        this.splitBillEntityData = lazy5;
        this.userConfigPreference = lazy6;
        this.promoPreference = lazy7;
        this.context = lazy8;
        this.merchantReviewPreference = lazy9;
        this.kycRenewalPreference = lazy10;
        this.maintenanceBroadcastPreference = lazy11;
        this.userConsentPreference = lazy12;
        this.userPersonalizationPreferences = lazy13;
        this.userInfoPreference = lazy14;
        this.sharedPrefSplitAttributes = lazy15;
        this.localUserInfoData = lazy16;
        this.persistenceWalletV3EntityData = lazy17;
        this.walletV3Preference = lazy18;
        this.localRegistrationEntityData = lazy19;
        this.recentRecipientEntityData = lazy20;
        this.credentialPreference = lazy21;
        this.localPushVerifyPreferenceEntityData = lazy22;
        this.danaProtectionInfoPreference = lazy23;
        this.sharedPrefCashierConfig = lazy24;
        this.sharedPrefScannerConfig = lazy25;
        this.persistenceHomeWidgetEntityData = lazy26;
        this.miniProgramPreference = lazy27;
        this.generalPreferences = lazy28;
        this.securityGuardFacade = lazy29;
    }

    @Override // id.dana.data.account.clear.repository.ClearAccountEntityData
    public final Observable<Unit> clearAll() {
        Observable<Unit> defer = Observable.defer(new Callable() { // from class: id.dana.data.account.clear.repository.source.preference.PreferenceClearAccountEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ObservableSource m735clearAll$lambda1;
                m735clearAll$lambda1 = PreferenceClearAccountEntityData.m735clearAll$lambda1(PreferenceClearAccountEntityData.this);
                return m735clearAll$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(defer, "");
        return defer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearAll$lambda-1  reason: not valid java name */
    public static final ObservableSource m735clearAll$lambda1(final PreferenceClearAccountEntityData preferenceClearAccountEntityData) {
        Intrinsics.checkNotNullParameter(preferenceClearAccountEntityData, "");
        return Observable.fromCallable(new Callable() { // from class: id.dana.data.account.clear.repository.source.preference.PreferenceClearAccountEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m736clearAll$lambda1$lambda0;
                m736clearAll$lambda1$lambda0 = PreferenceClearAccountEntityData.m736clearAll$lambda1$lambda0(PreferenceClearAccountEntityData.this);
                return m736clearAll$lambda1$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearAll$lambda-1$lambda-0  reason: not valid java name */
    public static final Unit m736clearAll$lambda1$lambda0(PreferenceClearAccountEntityData preferenceClearAccountEntityData) {
        Intrinsics.checkNotNullParameter(preferenceClearAccountEntityData, "");
        preferenceClearAccountEntityData.deepLinkPreferences.get().clearAll();
        try {
            preferenceClearAccountEntityData.h5ResponseCachePreferences.get().KClassImpl$Data$declaredNonStaticMembers$2.clearAllData();
        } catch (Exception e) {
            DanaLog.scheduleImpl("H5ResponseCachePreferences", e.getMessage());
        }
        preferenceClearAccountEntityData.recentPayerEntityData.get().clearAll();
        preferenceClearAccountEntityData.referralPreferences.get().clearAll();
        preferenceClearAccountEntityData.splitBillEntityData.get().clearAll();
        preferenceClearAccountEntityData.userConfigPreference.get().clearAll();
        preferenceClearAccountEntityData.promoPreference.get().clearAll();
        preferenceClearAccountEntityData.merchantReviewPreference.get().clearAll();
        preferenceClearAccountEntityData.kycRenewalPreference.get().getAuthRequestContext.clearAllData();
        preferenceClearAccountEntityData.maintenanceBroadcastPreference.get().clearAll();
        preferenceClearAccountEntityData.userConsentPreference.get().getAuthRequestContext.clearAllData();
        preferenceClearAccountEntityData.userPersonalizationPreferences.get().getAuthRequestContext.clearData("explore_personalization_shown");
        preferenceClearAccountEntityData.userInfoPreference.get().clearAll();
        preferenceClearAccountEntityData.sharedPrefSplitAttributes.get().clearAll();
        preferenceClearAccountEntityData.localUserInfoData.get().clearAll();
        preferenceClearAccountEntityData.persistenceWalletV3EntityData.get().clearAll();
        preferenceClearAccountEntityData.walletV3Preference.get().clearAll();
        preferenceClearAccountEntityData.localRegistrationEntityData.get().clearAll();
        preferenceClearAccountEntityData.recentRecipientEntityData.get().clearAll();
        preferenceClearAccountEntityData.credentialPreference.get().KClassImpl$Data$declaredNonStaticMembers$2.clearAllData();
        preferenceClearAccountEntityData.localPushVerifyPreferenceEntityData.get().clearAll();
        preferenceClearAccountEntityData.danaProtectionInfoPreference.get().MyBillsEntityDataFactory.clearAllData();
        preferenceClearAccountEntityData.sharedPrefCashierConfig.get().clearAll();
        preferenceClearAccountEntityData.sharedPrefScannerConfig.get().clearAll();
        PersistenceHomeWidgetEntityData persistenceHomeWidgetEntityData = preferenceClearAccountEntityData.persistenceHomeWidgetEntityData.get();
        persistenceHomeWidgetEntityData.getDb().singleBalanceDao().PlaceComponentResult();
        persistenceHomeWidgetEntityData.getDb().newsWidgetActivityDao().PlaceComponentResult();
        persistenceHomeWidgetEntityData.getDb().promoBannerContentDao().BuiltInFictitiousFunctionClassFactory();
        persistenceHomeWidgetEntityData.getDb().promoBannerAnnouncementDao().getAuthRequestContext();
        preferenceClearAccountEntityData.miniProgramPreference.get().KClassImpl$Data$declaredNonStaticMembers$2.clearAllData();
        preferenceClearAccountEntityData.generalPreferences.get().clearAll();
        CookieUtil.PlaceComponentResult(preferenceClearAccountEntityData.context.get());
        CommonUtil.BuiltInFictitiousFunctionClassFactory(preferenceClearAccountEntityData.securityGuardFacade.get(), null);
        return Unit.INSTANCE;
    }
}
