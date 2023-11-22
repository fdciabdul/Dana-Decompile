package id.dana.di.modules;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.twilio.security.logger.Logger;
import com.twilio.security.storage.EncryptedStorage;
import com.twilio.security.storage.EncryptedStorageKt;
import com.twilio.verify.TwilioVerify;
import com.twilio.verify.TwilioVerifyException;
import com.twilio.verify.api.ChallengeAPIClient;
import com.twilio.verify.api.FactorAPIClient;
import com.twilio.verify.api.ServiceAPIClient;
import com.twilio.verify.data.Entry;
import com.twilio.verify.data.KeyStorage;
import com.twilio.verify.data.Migration;
import com.twilio.verify.data.Storage;
import com.twilio.verify.data.jwt.JwtGenerator;
import com.twilio.verify.domain.TwilioVerifyManager;
import com.twilio.verify.domain.challenge.ChallengeFacade;
import com.twilio.verify.domain.challenge.ChallengeRepository;
import com.twilio.verify.domain.challenge.PushChallengeProcessor;
import com.twilio.verify.domain.factor.FactorFacade;
import com.twilio.verify.domain.factor.FactorMigrations;
import com.twilio.verify.domain.factor.FactorRepository;
import com.twilio.verify.domain.factor.PushFactory;
import com.twilio.verify.domain.service.ServiceFacade;
import com.twilio.verify.domain.service.ServiceRepository;
import com.twilio.verify.logger.LoggerImplementation;
import com.twilio.verify.logger.LoggerService;
import com.twilio.verify.networking.Authentication;
import com.twilio.verify.networking.AuthenticationProvider;
import com.twilio.verify.networking.NetworkProvider;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import id.dana.AppLifeCycleObserver;
import id.dana.UIThread;
import id.dana.appcontainer.plugin.ocrreceipt.repository.OcrConfigRepository;
import id.dana.cardbinding.data.repository.CardBindingEntityRepository;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cashier.data.repository.CashierEntityRepository;
import id.dana.cashier.domain.CashierRepository;
import id.dana.danah5.ocrreceipt.repository.DefaultOcrConfigRepository;
import id.dana.data.account.repository.AccountEntityRepository;
import id.dana.data.account.repository.source.LocalConfigLiteAccountEntityRepository;
import id.dana.data.account.repository.source.preference.PreferenceAccountEntityData;
import id.dana.data.announcement.repository.AnnouncementEntityRepository;
import id.dana.data.auth.face.repository.FaceAuthenticationEntityRepository;
import id.dana.data.auth.face.repository.source.entity.FaceAuthPopUpConsultationEntityRepository;
import id.dana.data.autoroute.repository.source.AutoRouteEntityRepository;
import id.dana.data.bank.repository.UserBankEntityRepository;
import id.dana.data.cancelsurvey.repository.CancelSurveyEntityRepository;
import id.dana.data.card.repository.CardEntityRepository;
import id.dana.data.carrieridentification.CarrierIdentificationEntityRepository;
import id.dana.data.citcall.CitCallEntityRepository;
import id.dana.data.config.repository.AppGeneralEntityRepository;
import id.dana.data.config.repository.FeatureConfigEntityRepository;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.HomeWidgetEntityData;
import id.dana.data.config.source.SecuredPrefHomeWidgetData;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefScannerConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefSplitAttributes;
import id.dana.data.config.source.sharedpreference.SharedPrefStartupConfig;
import id.dana.data.connectionbar.repository.ConnectionBarEntityRepository;
import id.dana.data.contactinjection.ContactInjectionEntityRepository;
import id.dana.data.csatsurvey.repository.CsatSurveyEntityRepository;
import id.dana.data.danah5.H5EntityRepository;
import id.dana.data.danainfo.DanaTutorialsEntityRepository;
import id.dana.data.danaprotection.repository.DanaProtectionInfoEntityRepository;
import id.dana.data.deeplink.repository.DeepLinkEntityRepository;
import id.dana.data.deeplink.repository.GenerateLinkEntityRepository;
import id.dana.data.dialogtnc.TncEntitySummaryRepository;
import id.dana.data.donation.repository.source.DonationCampaignEntityRepository;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.electronicmoney.ElectronicmoneyEntityRepository;
import id.dana.data.exploredana.repository.ExploreDanaEntityRepository;
import id.dana.data.expresspurchase.ExpressPurchaseEntityRepository;
import id.dana.data.familyaccount.repository.FamilyAccountEntityRepository;
import id.dana.data.featureswitch.repository.source.FeatureNonAMCSEntityRepository;
import id.dana.data.feeds.repository.FeedsEntityRepository;
import id.dana.data.foundation.h5app.repository.H5ResponseH5ResponseCacheEntityRepository;
import id.dana.data.foundation.logger.rds.RDSTracker;
import id.dana.data.fullstory.FullstoryEntityDataRepository;
import id.dana.data.geocode.repository.GeocodeEntityRepository;
import id.dana.data.geofence.repository.source.GeoFenceEntityRepository;
import id.dana.data.globalnetwork.GlobalNetworkEntityRepository;
import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.h5event.repository.H5EventEntityRepository;
import id.dana.data.h5onlineconfig.repository.H5OnlineConfigEntityRepository;
import id.dana.data.home.HomePassiveBioEntityRepository;
import id.dana.data.home.repository.HomeWidgetEntityRepository;
import id.dana.data.homeinfo.repository.HomeConfigEntityRepository;
import id.dana.data.homeinfo.repository.HomeInfoEntityRepository;
import id.dana.data.investment.repository.InvestmentEntityRepository;
import id.dana.data.ipg.IpgEntityRepository;
import id.dana.data.kycamledd.repository.KycAmlEddEntityRepository;
import id.dana.data.kycrenewal.repository.KycRenewalEntityRepository;
import id.dana.data.lazada.LazadaEntityRepository;
import id.dana.data.login.LoginEntityRepository;
import id.dana.data.login.LoginLogoutSubject;
import id.dana.data.loyalty.repository.LoyaltyEntityRepository;
import id.dana.data.merchant.repository.source.MerchantCategoriesEntityRepository;
import id.dana.data.merchantmanagement.repository.MerchantManagementEntityRepository;
import id.dana.data.miniprogram.source.MiniProgramEntityRepository;
import id.dana.data.miniprogram.source.network.NetworkMiniPrograms;
import id.dana.data.moreforyou.MoreForYouEntityRepository;
import id.dana.data.mybills.repository.MyBillsEntityRepository;
import id.dana.data.nearbyme.repository.MerchantConfigEntityRepository;
import id.dana.data.nearbyme.repository.MerchantInfoEntityRepository;
import id.dana.data.nearbyme.repository.MerchantReviewFormEntityRepository;
import id.dana.data.nearbyme.repository.NearbyMeEntityRepository;
import id.dana.data.nearbyplaces.repository.NearbyPlaceEntityRepository;
import id.dana.data.notificationcenter.repository.NotificationCenterEntityRepository;
import id.dana.data.notificationcenter.repository.source.PushNotificationEntityRepository;
import id.dana.data.oauth.repository.OauthEntityRepository;
import id.dana.data.ocr.repository.OCREntityRepository;
import id.dana.data.otp.OtpEntityRepository;
import id.dana.data.ott.repository.OttEntityRepository;
import id.dana.data.payasset.PayAssetEntityRepository;
import id.dana.data.paylater.repository.PaylaterEntityRepository;
import id.dana.data.paymentsetting.PaymentSettingEntityRepository;
import id.dana.data.permission.PermissionEntityRepository;
import id.dana.data.playstorereview.repository.PlayStoreReviewEntityRepository;
import id.dana.data.pocket.repository.PocketEntityRepository;
import id.dana.data.profilemenu.repository.SettingsEntityRepository;
import id.dana.data.promocenter.PromoCenterEntityRepository;
import id.dana.data.promocode.repository.PromoCodeEntityRepository;
import id.dana.data.promodiscovery.repository.PromoDiscoveryEntityRepository;
import id.dana.data.promoquest.repository.PromoQuestEntityRepository;
import id.dana.data.promotion.repository.PromotionEntityRepository;
import id.dana.data.pushverify.PushVerifyEntityRepository;
import id.dana.data.qrbarcode.repository.QrBarcodeEntityRepository;
import id.dana.data.qriscrossborder.QrisCrossBorderEntityRepository;
import id.dana.data.qrpay.QrPayEntityRepository;
import id.dana.data.recentcontact.repository.RecentContactEntityRepository;
import id.dana.data.recentrecipient.repository.RecentRecipientEntityRepository;
import id.dana.data.referral.ReferralEngagementEntityRepository;
import id.dana.data.referral.ReferralEntityRepository;
import id.dana.data.referral.repository.MyReferralConsultEntityRepository;
import id.dana.data.referralconfig.ReferralConfigEntityRepository;
import id.dana.data.referraltracker.ReferralTrackerEntityRepository;
import id.dana.data.referralwidget.ReferralWidgetEntityRepository;
import id.dana.data.requestmoney.RequestMoneyEntityRepository;
import id.dana.data.resetpin.ResetPinRepositoryImpl;
import id.dana.data.saving.repository.SavingCategoryEntityRepository;
import id.dana.data.saving.repository.SavingEntityRepository;
import id.dana.data.senddigitalmoney.repository.SendDigitalMoneyEntityRepository;
import id.dana.data.sendmoney.repository.SendMoneyEntityRepository;
import id.dana.data.services.repository.ServicesEntityRepository;
import id.dana.data.shortener.repository.ShortenerEntityRepository;
import id.dana.data.splitbill.repository.SplitBillEntityRepository;
import id.dana.data.sslpinning.LocalConfigSSLPinningEntityRepository;
import id.dana.data.sslpinning.SSLQuakeInterceptor;
import id.dana.data.sslpinning.interceptor.SSLQuakeInterceptorImpl;
import id.dana.data.statement.repository.UserStatementEntityRepository;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import id.dana.data.storage.SimpleSecureKeyPreference;
import id.dana.data.synccontact.repository.SyncContactEntityRepository;
import id.dana.data.tracker.MixpanelEntityRepository;
import id.dana.data.transferaccount.TransferAccountEntityRepository;
import id.dana.data.twilio.TwilioSdkEntityRepository;
import id.dana.data.twilio.repository.TwilioEnrollmentEligibilityEntityRepository;
import id.dana.data.twilio.repository.TwilioEntityRepository;
import id.dana.data.uploadfiles.UploadFilesEntityRepository;
import id.dana.data.user.UserEntityRepository;
import id.dana.data.userconfig.repository.UserConfigEntityRepository;
import id.dana.data.userconfig.repository.UserConfigRepository;
import id.dana.data.userconsent.repository.UserConsentEntityRepository;
import id.dana.data.usereducation.repository.UserEducationEntityRepository;
import id.dana.data.useremailaddress.repository.UserEmailAddressEntityRepository;
import id.dana.data.userprofileinfo.UserProfileInfoEntityRepository;
import id.dana.data.usersecurityquestions.repository.UserSecurityQuestionStateEntityRepository;
import id.dana.data.verifytoken.VerifyTokenEntityRepository;
import id.dana.data.version.VersionEntityRepository;
import id.dana.data.wallet_v3.repository.PersonalTabEntityRepository;
import id.dana.data.wallet_v3.repository.WalletConfigEntityRepository;
import id.dana.data.wallet_v3.repository.WalletV3EntityRepository;
import id.dana.data.webviewinterceptor.WebviewInterceptorEntityRepository;
import id.dana.data.zendesk.repository.ZendeskEntityRepository;
import id.dana.domain.PostExecutionThread;
import id.dana.domain.account.AccountRepository;
import id.dana.domain.account.LiteAccountRepository;
import id.dana.domain.announcement.AnnouncementRepository;
import id.dana.domain.auth.face.repository.FaceAuthPopUpConsultationRepository;
import id.dana.domain.auth.face.repository.FaceAuthenticationRepository;
import id.dana.domain.autoroute.repository.AutoRouteRepository;
import id.dana.domain.bank.repository.UserBankRepository;
import id.dana.domain.cancelsurvey.repository.CancelSurveyRepository;
import id.dana.domain.card.repository.CardRepository;
import id.dana.domain.carrieridentification.CarrierIdentificationRepository;
import id.dana.domain.citcall.CitcallRepository;
import id.dana.domain.connectionbar.ConnectionBarRepository;
import id.dana.domain.contactinjection.ContactInjectionRepository;
import id.dana.domain.csatsurvey.CsatSurveyRepository;
import id.dana.domain.danah5.H5Repository;
import id.dana.domain.danainfo.repository.DanaTutorialsRepository;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.deeplink.repository.DeepLinkRepository;
import id.dana.domain.deeplink.repository.GenerateLinkRepository;
import id.dana.domain.donation.DonationRepository;
import id.dana.domain.electronicmoney.ElectronicmoneyRepository;
import id.dana.domain.exploredana.repository.ExploreDanaRepository;
import id.dana.domain.expresspurchase.repository.ExpressPurchaseRepository;
import id.dana.domain.familyaccount.FamilyAccountRepository;
import id.dana.domain.featureconfig.AppGeneralRepository;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.LocalSplitAttributesEntityData;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.featureswitch.FeatureNonAmcsRepository;
import id.dana.domain.feeds.FeedsRepository;
import id.dana.domain.foundation.h5app.repository.H5ResponseCacheRepository;
import id.dana.domain.fullstory.FullstoryRepository;
import id.dana.domain.geocode.GeocodeRepository;
import id.dana.domain.geofence.GeoFenceRepository;
import id.dana.domain.globalnetwork.GlobalNetworkRepository;
import id.dana.domain.h5event.H5EventRepository;
import id.dana.domain.h5onlineconfig.H5OnlineConfigRepository;
import id.dana.domain.home.HomePassiveBioRepository;
import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.homeinfo.HomeWidgetClearable;
import id.dana.domain.homeinfo.repository.HomeConfigRepository;
import id.dana.domain.homeinfo.repository.HomeInfoRepository;
import id.dana.domain.investment.InvestmentRepository;
import id.dana.domain.ipg.IpgRepository;
import id.dana.domain.kycamledd.KycAmlEddRepository;
import id.dana.domain.kycrenewal.KycRenewalRepository;
import id.dana.domain.lazada.LazadaRepository;
import id.dana.domain.login.LoginRepository;
import id.dana.domain.loyalty.LoyaltyRepository;
import id.dana.domain.merchant.MerchantCategoriesRepository;
import id.dana.domain.merchantmanagement.MerchantManagementRepository;
import id.dana.domain.miniprogram.MiniProgramRepository;
import id.dana.domain.moreforyou.MoreForYouRepository;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.nearbyme.MerchantConfigRepository;
import id.dana.domain.nearbyme.MerchantInfoRepository;
import id.dana.domain.nearbyme.MerchantReviewFormRepository;
import id.dana.domain.nearbyme.NearbyMeRepository;
import id.dana.domain.nearbyplaces.NearbyPlaceRepository;
import id.dana.domain.notificationcenter.repository.NotificationCenterRepository;
import id.dana.domain.notificationcenter.repository.PushNotificationRepository;
import id.dana.domain.oauth.repository.OauthRepository;
import id.dana.domain.ocr.OCRRepository;
import id.dana.domain.otp.OtpRepository;
import id.dana.domain.ott.repository.OttRepository;
import id.dana.domain.payasset.repository.PayAssetRepository;
import id.dana.domain.paylater.PaylaterRepository;
import id.dana.domain.paymentsetting.PaymentSettingRepository;
import id.dana.domain.permission.PermissionRepository;
import id.dana.domain.playstorereview.repository.PlayStoreReviewRepository;
import id.dana.domain.pocket.PocketRepository;
import id.dana.domain.profilemenu.SettingRepository;
import id.dana.domain.promocenter.repository.PromoCenterRepository;
import id.dana.domain.promocode.repository.PromoCodeRepository;
import id.dana.domain.promodiscovery.repository.PromoDiscoveryRepository;
import id.dana.domain.promoquest.respository.PromoQuestRepository;
import id.dana.domain.promotion.repository.PromotionRepository;
import id.dana.domain.pushverify.repository.PushVerifyRepository;
import id.dana.domain.qrbarcode.QrBarcodeRepository;
import id.dana.domain.qriscrossborder.QrisCrossBorderRepository;
import id.dana.domain.qrpay.QrPayRepository;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import id.dana.domain.recentrecipient.repository.RecentRecipientRepository;
import id.dana.domain.referral.MyReferralConsultRepository;
import id.dana.domain.referral.ReferralEngagementDialogRepository;
import id.dana.domain.referral.ReferralRepository;
import id.dana.domain.referralconfig.ReferralConfigRepository;
import id.dana.domain.referraltracker.ReferralTrackerRepository;
import id.dana.domain.referralwidget.ReferralWidgetRepository;
import id.dana.domain.requestmoney.RequestMoneyRepository;
import id.dana.domain.resetpin.ResetPinRepository;
import id.dana.domain.saving.SavingCategoryRepository;
import id.dana.domain.saving.SavingRepository;
import id.dana.domain.senddigitalmoney.SendDigitalMoneyRepository;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import id.dana.domain.services.ServicesRepository;
import id.dana.domain.shortener.repository.ShortenerRepository;
import id.dana.domain.splitbill.repository.SplitBillRepository;
import id.dana.domain.sslpinning.SSLPinningRepository;
import id.dana.domain.statement.UserStatementRepository;
import id.dana.domain.synccontact.SyncContactRepository;
import id.dana.domain.tncsummary.TncSummaryRepository;
import id.dana.domain.tracker.MixpanelRepository;
import id.dana.domain.transferaccount.TransferAccountRepository;
import id.dana.domain.transferaccount.interactor.GetCacheTransferAccountStatus;
import id.dana.domain.twilio.TwilioEnrollmentEligibilityRepository;
import id.dana.domain.twilio.TwilioRepository;
import id.dana.domain.twilio.TwilioSdkRepository;
import id.dana.domain.uploadfiles.UploadFilesRepository;
import id.dana.domain.user.repository.UserRepository;
import id.dana.domain.useragreement.UserConsentRepository;
import id.dana.domain.usereducation.repository.UserEducationRepository;
import id.dana.domain.useremailaddress.repository.UserEmailAddressRepository;
import id.dana.domain.userprofileinfo.UserProfileInfoRepository;
import id.dana.domain.usersecurityquestions.repository.UserSecurityQuestionStateRepository;
import id.dana.domain.verifytoken.VerifyTokenRepository;
import id.dana.domain.version.VersionRepository;
import id.dana.domain.wallet_v3.repository.PersonalTabRepository;
import id.dana.domain.wallet_v3.repository.WalletConfigRepository;
import id.dana.domain.wallet_v3.repository.WalletV3Repository;
import id.dana.domain.webviewinterceptor.WebviewInterceptorRepository;
import id.dana.domain.zendesk.ZendeskRepository;
import id.dana.explore.data.globalsearch.GlobalSearchEntityRepository;
import id.dana.explore.data.sku.repository.ProductInfoEntityRepository;
import id.dana.explore.data.userpersonalization.UserPersonalizationEntityRepository;
import id.dana.explore.domain.globalsearch.GlobalSearchRepository;
import id.dana.explore.domain.sku.ProductInfoRepository;
import id.dana.explore.domain.userpersonalization.UserPersonalizationRepository;
import id.dana.feeds.data.activation.FeedInitEntityRepository;
import id.dana.feeds.data.config.FeedsConfigEntityRepository;
import id.dana.feeds.data.friend.FriendEntityRepository;
import id.dana.feeds.data.reaction.FeedsReactionEntityRepository;
import id.dana.feeds.data.relationship.FeedsRelationshipEntityRepository;
import id.dana.feeds.data.share.FeedsShareEntityRepository;
import id.dana.feeds.data.synccontact.FeedsSyncContactEntityRepository;
import id.dana.feeds.data.synccontact.RecurringFeedsSyncContactRepository;
import id.dana.feeds.data.username.source.UserProfileEntityData;
import id.dana.feeds.data.username.source.network.NetworkUserProfileEntityData;
import id.dana.feeds.domain.activation.FeedInitRepository;
import id.dana.feeds.domain.config.FeedsConfigRepository;
import id.dana.feeds.domain.friend.FriendRepository;
import id.dana.feeds.domain.reactions.FeedsReactionRepository;
import id.dana.feeds.domain.relationship.FeedsRelationshipRepository;
import id.dana.feeds.domain.runner.FullSyncContactRunner;
import id.dana.feeds.domain.runner.PartialSyncContactRunner;
import id.dana.feeds.domain.share.FeedsShareRepository;
import id.dana.feeds.domain.synccontact.FeedsSyncContactRepository;
import id.dana.feeds.domain.synccontact.SyncRunner;
import id.dana.kyb.data.repository.KybEntityRepository;
import id.dana.kyb.domain.KybRepository;
import id.dana.lib.gcontainer.util.UserAgentFactory;
import id.dana.sendmoney.data.repository.core.SendMoneyCoreEntityRepository;
import id.dana.sendmoney.data.repository.globalsend.GlobalSendEntityRepository;
import id.dana.sendmoney.domain.core.SendMoneyCoreRepository;
import id.dana.sendmoney.domain.globalsend.GlobalSendRepository;
import id.dana.toggle.locationpermission.LocationPermissionObserver;
import id.dana.toggle.locationpermission.LocationPermissionSubject;
import id.dana.toggle.userloginlogout.LoginLogoutObserver;
import id.dana.transferaccount.TransferAccountStatusChecker;
import id.dana.transferaccount.success.TransferAccountSuccessActivity;
import id.dana.transferaccount.transferaccountstatus.TransferAccountStatusActivity;
import id.dana.utils.OSUtil;
import id.dana.utils.concurrent.JobExecutor;
import id.dana.utils.concurrent.ThreadExecutor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Module
/* loaded from: classes.dex */
public class ApplicationModule {
    private final Application MyBillsEntityDataFactory;

    @Provides
    @Singleton
    public HomeWidgetEntityData BuiltInFictitiousFunctionClassFactory(SecuredPrefHomeWidgetData securedPrefHomeWidgetData) {
        return securedPrefHomeWidgetData;
    }

    @Provides
    @Singleton
    public CardRepository BuiltInFictitiousFunctionClassFactory(CardEntityRepository cardEntityRepository) {
        return cardEntityRepository;
    }

    @Provides
    @Singleton
    public CitcallRepository BuiltInFictitiousFunctionClassFactory(CitCallEntityRepository citCallEntityRepository) {
        return citCallEntityRepository;
    }

    @Provides
    @Singleton
    public H5Repository BuiltInFictitiousFunctionClassFactory(H5EntityRepository h5EntityRepository) {
        return h5EntityRepository;
    }

    @Provides
    @Singleton
    public GenerateLinkRepository BuiltInFictitiousFunctionClassFactory(GenerateLinkEntityRepository generateLinkEntityRepository) {
        return generateLinkEntityRepository;
    }

    @Provides
    @Singleton
    public ExploreDanaRepository BuiltInFictitiousFunctionClassFactory(ExploreDanaEntityRepository exploreDanaEntityRepository) {
        return exploreDanaEntityRepository;
    }

    @Provides
    @Singleton
    public FeatureNonAmcsRepository BuiltInFictitiousFunctionClassFactory(FeatureNonAMCSEntityRepository featureNonAMCSEntityRepository) {
        return featureNonAMCSEntityRepository;
    }

    @Provides
    @Singleton
    public MerchantCategoriesRepository BuiltInFictitiousFunctionClassFactory(MerchantCategoriesEntityRepository merchantCategoriesEntityRepository) {
        return merchantCategoriesEntityRepository;
    }

    @Provides
    @Singleton
    public MoreForYouRepository BuiltInFictitiousFunctionClassFactory(MoreForYouEntityRepository moreForYouEntityRepository) {
        return moreForYouEntityRepository;
    }

    @Provides
    @Singleton
    public OauthRepository BuiltInFictitiousFunctionClassFactory(OauthEntityRepository oauthEntityRepository) {
        return oauthEntityRepository;
    }

    @Provides
    @Singleton
    public OtpRepository BuiltInFictitiousFunctionClassFactory(OtpEntityRepository otpEntityRepository) {
        return otpEntityRepository;
    }

    @Provides
    @Singleton
    public PaylaterRepository BuiltInFictitiousFunctionClassFactory(PaylaterEntityRepository paylaterEntityRepository) {
        return paylaterEntityRepository;
    }

    @Provides
    @Singleton
    public QrisCrossBorderRepository BuiltInFictitiousFunctionClassFactory(QrisCrossBorderEntityRepository qrisCrossBorderEntityRepository) {
        return qrisCrossBorderEntityRepository;
    }

    @Provides
    @Singleton
    public ReferralRepository BuiltInFictitiousFunctionClassFactory(ReferralEntityRepository referralEntityRepository) {
        return referralEntityRepository;
    }

    @Provides
    @Singleton
    public ReferralTrackerRepository BuiltInFictitiousFunctionClassFactory(ReferralTrackerEntityRepository referralTrackerEntityRepository) {
        return referralTrackerEntityRepository;
    }

    @Provides
    @Singleton
    public SendMoneyRepository BuiltInFictitiousFunctionClassFactory(SendMoneyEntityRepository sendMoneyEntityRepository) {
        return sendMoneyEntityRepository;
    }

    @Provides
    @Singleton
    public ServicesRepository BuiltInFictitiousFunctionClassFactory(ServicesEntityRepository servicesEntityRepository) {
        return servicesEntityRepository;
    }

    @Provides
    @Singleton
    public UserRepository BuiltInFictitiousFunctionClassFactory(UserEntityRepository userEntityRepository) {
        return userEntityRepository;
    }

    @Provides
    @Singleton
    public UserEducationRepository BuiltInFictitiousFunctionClassFactory(UserEducationEntityRepository userEducationEntityRepository) {
        return userEducationEntityRepository;
    }

    @Provides
    @Singleton
    public WalletV3Repository BuiltInFictitiousFunctionClassFactory(WalletV3EntityRepository walletV3EntityRepository) {
        return walletV3EntityRepository;
    }

    @Provides
    @Singleton
    public ZendeskRepository BuiltInFictitiousFunctionClassFactory(ZendeskEntityRepository zendeskEntityRepository) {
        return zendeskEntityRepository;
    }

    @Provides
    @Singleton
    public KybRepository BuiltInFictitiousFunctionClassFactory(KybEntityRepository kybEntityRepository) {
        return kybEntityRepository;
    }

    @Provides
    @Singleton
    public CashierRepository KClassImpl$Data$declaredNonStaticMembers$2(CashierEntityRepository cashierEntityRepository) {
        return cashierEntityRepository;
    }

    @Provides
    @Singleton
    public UserConfigRepository KClassImpl$Data$declaredNonStaticMembers$2(UserConfigEntityRepository userConfigEntityRepository) {
        return userConfigEntityRepository;
    }

    @Provides
    @Singleton
    public FaceAuthPopUpConsultationRepository KClassImpl$Data$declaredNonStaticMembers$2(FaceAuthPopUpConsultationEntityRepository faceAuthPopUpConsultationEntityRepository) {
        return faceAuthPopUpConsultationEntityRepository;
    }

    @Provides
    @Singleton
    public FaceAuthenticationRepository KClassImpl$Data$declaredNonStaticMembers$2(FaceAuthenticationEntityRepository faceAuthenticationEntityRepository) {
        return faceAuthenticationEntityRepository;
    }

    @Provides
    @Singleton
    public UserBankRepository KClassImpl$Data$declaredNonStaticMembers$2(UserBankEntityRepository userBankEntityRepository) {
        return userBankEntityRepository;
    }

    @Provides
    @Singleton
    public CancelSurveyRepository KClassImpl$Data$declaredNonStaticMembers$2(CancelSurveyEntityRepository cancelSurveyEntityRepository) {
        return cancelSurveyEntityRepository;
    }

    @Provides
    @Singleton
    public ConnectionBarRepository KClassImpl$Data$declaredNonStaticMembers$2(ConnectionBarEntityRepository connectionBarEntityRepository) {
        return connectionBarEntityRepository;
    }

    @Provides
    @Singleton
    public DanaTutorialsRepository KClassImpl$Data$declaredNonStaticMembers$2(DanaTutorialsEntityRepository danaTutorialsEntityRepository) {
        return danaTutorialsEntityRepository;
    }

    @Provides
    @Singleton
    public DeepLinkRepository KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkEntityRepository deepLinkEntityRepository) {
        return deepLinkEntityRepository;
    }

    @Provides
    @Singleton
    public ElectronicmoneyRepository KClassImpl$Data$declaredNonStaticMembers$2(ElectronicmoneyEntityRepository electronicmoneyEntityRepository) {
        return electronicmoneyEntityRepository;
    }

    @Provides
    @Singleton
    public AppGeneralRepository KClassImpl$Data$declaredNonStaticMembers$2(AppGeneralEntityRepository appGeneralEntityRepository) {
        return appGeneralEntityRepository;
    }

    @Provides
    @Singleton
    public LocalSplitAttributesEntityData KClassImpl$Data$declaredNonStaticMembers$2(SharedPrefSplitAttributes sharedPrefSplitAttributes) {
        return sharedPrefSplitAttributes;
    }

    @Provides
    @Singleton
    public StartupConfigEntityData KClassImpl$Data$declaredNonStaticMembers$2(SharedPrefStartupConfig sharedPrefStartupConfig) {
        return sharedPrefStartupConfig;
    }

    @Provides
    @Singleton
    public FeedsRepository KClassImpl$Data$declaredNonStaticMembers$2(FeedsEntityRepository feedsEntityRepository) {
        return feedsEntityRepository;
    }

    @Provides
    public FullstoryRepository KClassImpl$Data$declaredNonStaticMembers$2(FullstoryEntityDataRepository fullstoryEntityDataRepository) {
        return fullstoryEntityDataRepository;
    }

    @Provides
    @Singleton
    public GlobalNetworkRepository KClassImpl$Data$declaredNonStaticMembers$2(GlobalNetworkEntityRepository globalNetworkEntityRepository) {
        return globalNetworkEntityRepository;
    }

    @Provides
    @Singleton
    public LoyaltyRepository KClassImpl$Data$declaredNonStaticMembers$2(LoyaltyEntityRepository loyaltyEntityRepository) {
        return loyaltyEntityRepository;
    }

    @Provides
    @Singleton
    public MerchantManagementRepository KClassImpl$Data$declaredNonStaticMembers$2(MerchantManagementEntityRepository merchantManagementEntityRepository) {
        return merchantManagementEntityRepository;
    }

    @Provides
    @Singleton
    public MerchantInfoRepository KClassImpl$Data$declaredNonStaticMembers$2(MerchantInfoEntityRepository merchantInfoEntityRepository) {
        return merchantInfoEntityRepository;
    }

    @Provides
    @Singleton
    public MerchantReviewFormRepository KClassImpl$Data$declaredNonStaticMembers$2(MerchantReviewFormEntityRepository merchantReviewFormEntityRepository) {
        return merchantReviewFormEntityRepository;
    }

    @Provides
    @Singleton
    public NearbyMeRepository KClassImpl$Data$declaredNonStaticMembers$2(NearbyMeEntityRepository nearbyMeEntityRepository) {
        return nearbyMeEntityRepository;
    }

    @Provides
    @Singleton
    public PushNotificationRepository KClassImpl$Data$declaredNonStaticMembers$2(PushNotificationEntityRepository pushNotificationEntityRepository) {
        return pushNotificationEntityRepository;
    }

    @Provides
    @Singleton
    public PocketRepository KClassImpl$Data$declaredNonStaticMembers$2(PocketEntityRepository pocketEntityRepository) {
        return pocketEntityRepository;
    }

    @Provides
    @Singleton
    public PushVerifyRepository KClassImpl$Data$declaredNonStaticMembers$2(PushVerifyEntityRepository pushVerifyEntityRepository) {
        return pushVerifyEntityRepository;
    }

    @Provides
    @Singleton
    public QrBarcodeRepository KClassImpl$Data$declaredNonStaticMembers$2(QrBarcodeEntityRepository qrBarcodeEntityRepository) {
        return qrBarcodeEntityRepository;
    }

    @Provides
    @Singleton
    public MyReferralConsultRepository KClassImpl$Data$declaredNonStaticMembers$2(MyReferralConsultEntityRepository myReferralConsultEntityRepository) {
        return myReferralConsultEntityRepository;
    }

    @Provides
    @Singleton
    public ReferralConfigRepository KClassImpl$Data$declaredNonStaticMembers$2(ReferralConfigEntityRepository referralConfigEntityRepository) {
        return referralConfigEntityRepository;
    }

    @Provides
    @Singleton
    public ResetPinRepository KClassImpl$Data$declaredNonStaticMembers$2(ResetPinRepositoryImpl resetPinRepositoryImpl) {
        return resetPinRepositoryImpl;
    }

    @Provides
    @Singleton
    public SplitBillRepository KClassImpl$Data$declaredNonStaticMembers$2(SplitBillEntityRepository splitBillEntityRepository) {
        return splitBillEntityRepository;
    }

    @Provides
    @Singleton
    public TwilioEnrollmentEligibilityRepository KClassImpl$Data$declaredNonStaticMembers$2(TwilioEnrollmentEligibilityEntityRepository twilioEnrollmentEligibilityEntityRepository) {
        return twilioEnrollmentEligibilityEntityRepository;
    }

    @Provides
    @Singleton
    public UserEmailAddressRepository KClassImpl$Data$declaredNonStaticMembers$2(UserEmailAddressEntityRepository userEmailAddressEntityRepository) {
        return userEmailAddressEntityRepository;
    }

    @Provides
    @Singleton
    public UserPersonalizationRepository KClassImpl$Data$declaredNonStaticMembers$2(UserPersonalizationEntityRepository userPersonalizationEntityRepository) {
        return userPersonalizationEntityRepository;
    }

    @Provides
    @Singleton
    public FriendRepository KClassImpl$Data$declaredNonStaticMembers$2(FriendEntityRepository friendEntityRepository) {
        return friendEntityRepository;
    }

    @Provides
    @Singleton
    public FeedsShareRepository KClassImpl$Data$declaredNonStaticMembers$2(FeedsShareEntityRepository feedsShareEntityRepository) {
        return feedsShareEntityRepository;
    }

    @Provides
    @Singleton
    public FeedsSyncContactRepository KClassImpl$Data$declaredNonStaticMembers$2(FeedsSyncContactEntityRepository feedsSyncContactEntityRepository) {
        return feedsSyncContactEntityRepository;
    }

    @Provides
    @Singleton
    @Named("nearbyExecutor")
    public ThreadExecutor KClassImpl$Data$declaredNonStaticMembers$2(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    public AccountRepository MyBillsEntityDataFactory(AccountEntityRepository accountEntityRepository) {
        return accountEntityRepository;
    }

    @Provides
    @Singleton
    public ContactInjectionRepository MyBillsEntityDataFactory(ContactInjectionEntityRepository contactInjectionEntityRepository) {
        return contactInjectionEntityRepository;
    }

    @Provides
    @Singleton
    public ExpressPurchaseRepository MyBillsEntityDataFactory(ExpressPurchaseEntityRepository expressPurchaseEntityRepository) {
        return expressPurchaseEntityRepository;
    }

    @Provides
    @Singleton
    public FamilyAccountRepository MyBillsEntityDataFactory(FamilyAccountEntityRepository familyAccountEntityRepository) {
        return familyAccountEntityRepository;
    }

    @Provides
    @Singleton
    public GeocodeRepository MyBillsEntityDataFactory(GeocodeEntityRepository geocodeEntityRepository) {
        return geocodeEntityRepository;
    }

    @Provides
    @Singleton
    public GeoFenceRepository MyBillsEntityDataFactory(GeoFenceEntityRepository geoFenceEntityRepository) {
        return geoFenceEntityRepository;
    }

    @Provides
    @Singleton
    public HomePassiveBioRepository MyBillsEntityDataFactory(HomePassiveBioEntityRepository homePassiveBioEntityRepository) {
        return homePassiveBioEntityRepository;
    }

    @Provides
    @Singleton
    public HomeConfigRepository MyBillsEntityDataFactory(HomeConfigEntityRepository homeConfigEntityRepository) {
        return homeConfigEntityRepository;
    }

    @Provides
    @Singleton
    public IpgRepository MyBillsEntityDataFactory(IpgEntityRepository ipgEntityRepository) {
        return ipgEntityRepository;
    }

    @Provides
    @Singleton
    public KycRenewalRepository MyBillsEntityDataFactory(KycRenewalEntityRepository kycRenewalEntityRepository) {
        return kycRenewalEntityRepository;
    }

    @Provides
    @Singleton
    public LazadaRepository MyBillsEntityDataFactory(LazadaEntityRepository lazadaEntityRepository) {
        return lazadaEntityRepository;
    }

    @Provides
    @Singleton
    public NotificationCenterRepository MyBillsEntityDataFactory(NotificationCenterEntityRepository notificationCenterEntityRepository) {
        return notificationCenterEntityRepository;
    }

    @Provides
    @Singleton
    public OCRRepository MyBillsEntityDataFactory(OCREntityRepository oCREntityRepository) {
        return oCREntityRepository;
    }

    @Provides
    @Singleton
    public OttRepository MyBillsEntityDataFactory(OttEntityRepository ottEntityRepository) {
        return ottEntityRepository;
    }

    @Provides
    @Singleton
    public PayAssetRepository MyBillsEntityDataFactory(PayAssetEntityRepository payAssetEntityRepository) {
        return payAssetEntityRepository;
    }

    @Provides
    @Singleton
    public PermissionRepository MyBillsEntityDataFactory(PermissionEntityRepository permissionEntityRepository) {
        return permissionEntityRepository;
    }

    @Provides
    @Singleton
    public PlayStoreReviewRepository MyBillsEntityDataFactory(PlayStoreReviewEntityRepository playStoreReviewEntityRepository) {
        return playStoreReviewEntityRepository;
    }

    @Provides
    @Singleton
    public PromoCodeRepository MyBillsEntityDataFactory(PromoCodeEntityRepository promoCodeEntityRepository) {
        return promoCodeEntityRepository;
    }

    @Provides
    @Singleton
    public SavingRepository MyBillsEntityDataFactory(SavingEntityRepository savingEntityRepository) {
        return savingEntityRepository;
    }

    @Provides
    @Singleton
    public UserStatementRepository MyBillsEntityDataFactory(UserStatementEntityRepository userStatementEntityRepository) {
        return userStatementEntityRepository;
    }

    @Provides
    @Singleton
    public TwilioRepository MyBillsEntityDataFactory(TwilioEntityRepository twilioEntityRepository) {
        return twilioEntityRepository;
    }

    @Provides
    @Singleton
    public UserConsentRepository MyBillsEntityDataFactory(UserConsentEntityRepository userConsentEntityRepository) {
        return userConsentEntityRepository;
    }

    @Provides
    @Singleton
    public UserSecurityQuestionStateRepository MyBillsEntityDataFactory(UserSecurityQuestionStateEntityRepository userSecurityQuestionStateEntityRepository) {
        return userSecurityQuestionStateEntityRepository;
    }

    @Provides
    @Singleton
    public VerifyTokenRepository MyBillsEntityDataFactory(VerifyTokenEntityRepository verifyTokenEntityRepository) {
        return verifyTokenEntityRepository;
    }

    @Provides
    @Singleton
    public VersionRepository MyBillsEntityDataFactory(VersionEntityRepository versionEntityRepository) {
        return versionEntityRepository;
    }

    @Provides
    @Singleton
    public GlobalSearchRepository MyBillsEntityDataFactory(GlobalSearchEntityRepository globalSearchEntityRepository) {
        return globalSearchEntityRepository;
    }

    @Provides
    @Singleton
    public UserProfileEntityData MyBillsEntityDataFactory(NetworkUserProfileEntityData networkUserProfileEntityData) {
        return networkUserProfileEntityData;
    }

    @Provides
    @Singleton
    public ThreadExecutor MyBillsEntityDataFactory(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    public CardBindingRepository PlaceComponentResult(CardBindingEntityRepository cardBindingEntityRepository) {
        return cardBindingEntityRepository;
    }

    @Provides
    @Singleton
    public AutoRouteRepository PlaceComponentResult(AutoRouteEntityRepository autoRouteEntityRepository) {
        return autoRouteEntityRepository;
    }

    @Provides
    @Singleton
    public DonationRepository PlaceComponentResult(DonationCampaignEntityRepository donationCampaignEntityRepository) {
        return donationCampaignEntityRepository;
    }

    @Provides
    @Singleton
    public FeatureConfigRepository PlaceComponentResult(FeatureConfigEntityRepository featureConfigEntityRepository) {
        return featureConfigEntityRepository;
    }

    @Provides
    @Singleton
    public HomeInfoRepository PlaceComponentResult(HomeInfoEntityRepository homeInfoEntityRepository) {
        return homeInfoEntityRepository;
    }

    @Provides
    @Singleton
    public InvestmentRepository PlaceComponentResult(InvestmentEntityRepository investmentEntityRepository) {
        return investmentEntityRepository;
    }

    @Provides
    @Singleton
    public LoginRepository PlaceComponentResult(LoginEntityRepository loginEntityRepository) {
        return loginEntityRepository;
    }

    @Provides
    @Singleton
    public MiniProgramRepository PlaceComponentResult(MiniProgramEntityRepository miniProgramEntityRepository) {
        return miniProgramEntityRepository;
    }

    @Provides
    @Singleton
    public MyBillsRepository PlaceComponentResult(MyBillsEntityRepository myBillsEntityRepository) {
        return myBillsEntityRepository;
    }

    @Provides
    @Singleton
    public MerchantConfigRepository PlaceComponentResult(MerchantConfigEntityRepository merchantConfigEntityRepository) {
        return merchantConfigEntityRepository;
    }

    @Provides
    @Singleton
    public PaymentSettingRepository PlaceComponentResult(PaymentSettingEntityRepository paymentSettingEntityRepository) {
        return paymentSettingEntityRepository;
    }

    @Provides
    @Singleton
    public SettingRepository PlaceComponentResult(SettingsEntityRepository settingsEntityRepository) {
        return settingsEntityRepository;
    }

    @Provides
    @Singleton
    public PromoQuestRepository PlaceComponentResult(PromoQuestEntityRepository promoQuestEntityRepository) {
        return promoQuestEntityRepository;
    }

    @Provides
    @Singleton
    public QrPayRepository PlaceComponentResult(QrPayEntityRepository qrPayEntityRepository) {
        return qrPayEntityRepository;
    }

    @Provides
    @Singleton
    public SendDigitalMoneyRepository PlaceComponentResult(SendDigitalMoneyEntityRepository sendDigitalMoneyEntityRepository) {
        return sendDigitalMoneyEntityRepository;
    }

    @Provides
    @Singleton
    public SyncContactRepository PlaceComponentResult(SyncContactEntityRepository syncContactEntityRepository) {
        return syncContactEntityRepository;
    }

    @Provides
    @Singleton
    public TncSummaryRepository PlaceComponentResult(TncEntitySummaryRepository tncEntitySummaryRepository) {
        return tncEntitySummaryRepository;
    }

    @Provides
    @Singleton
    public TransferAccountRepository PlaceComponentResult(TransferAccountEntityRepository transferAccountEntityRepository) {
        return transferAccountEntityRepository;
    }

    @Provides
    @Singleton
    public UploadFilesRepository PlaceComponentResult(UploadFilesEntityRepository uploadFilesEntityRepository) {
        return uploadFilesEntityRepository;
    }

    @Provides
    @Singleton
    public WalletConfigRepository PlaceComponentResult(WalletConfigEntityRepository walletConfigEntityRepository) {
        return walletConfigEntityRepository;
    }

    @Provides
    @Singleton
    public FeedsConfigRepository PlaceComponentResult(FeedsConfigEntityRepository feedsConfigEntityRepository) {
        return feedsConfigEntityRepository;
    }

    @Provides
    @Singleton
    public FeedsRelationshipRepository PlaceComponentResult(FeedsRelationshipEntityRepository feedsRelationshipEntityRepository) {
        return feedsRelationshipEntityRepository;
    }

    @Provides
    @Singleton
    public SendMoneyCoreRepository PlaceComponentResult(SendMoneyCoreEntityRepository sendMoneyCoreEntityRepository) {
        return sendMoneyCoreEntityRepository;
    }

    @Provides
    @Singleton
    @Named("friendshipthreadexecutor")
    public ThreadExecutor PlaceComponentResult(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    public OcrConfigRepository getAuthRequestContext(DefaultOcrConfigRepository defaultOcrConfigRepository) {
        return defaultOcrConfigRepository;
    }

    @Provides
    @Singleton
    public PostExecutionThread getAuthRequestContext(UIThread uIThread) {
        return uIThread;
    }

    @Provides
    @Singleton
    public AnnouncementRepository getAuthRequestContext(AnnouncementEntityRepository announcementEntityRepository) {
        return announcementEntityRepository;
    }

    @Provides
    @Singleton
    public CarrierIdentificationRepository getAuthRequestContext(CarrierIdentificationEntityRepository carrierIdentificationEntityRepository) {
        return carrierIdentificationEntityRepository;
    }

    @Provides
    @Singleton
    public CsatSurveyRepository getAuthRequestContext(CsatSurveyEntityRepository csatSurveyEntityRepository) {
        return csatSurveyEntityRepository;
    }

    @Provides
    @Singleton
    public DanaProtectionInfoRepository getAuthRequestContext(DanaProtectionInfoEntityRepository danaProtectionInfoEntityRepository) {
        return danaProtectionInfoEntityRepository;
    }

    @Provides
    @Singleton
    public H5ResponseCacheRepository getAuthRequestContext(H5ResponseH5ResponseCacheEntityRepository h5ResponseH5ResponseCacheEntityRepository) {
        return h5ResponseH5ResponseCacheEntityRepository;
    }

    @Provides
    @Singleton
    public H5OnlineConfigRepository getAuthRequestContext(H5OnlineConfigEntityRepository h5OnlineConfigEntityRepository) {
        return h5OnlineConfigEntityRepository;
    }

    @Provides
    @Singleton
    public HomeWidgetRepository getAuthRequestContext(HomeWidgetEntityRepository homeWidgetEntityRepository) {
        return homeWidgetEntityRepository;
    }

    @Provides
    @Singleton
    public HomeWidgetClearable getAuthRequestContext(SecuredPrefHomeWidgetData securedPrefHomeWidgetData) {
        return securedPrefHomeWidgetData;
    }

    @Provides
    @Singleton
    public KycAmlEddRepository getAuthRequestContext(KycAmlEddEntityRepository kycAmlEddEntityRepository) {
        return kycAmlEddEntityRepository;
    }

    @Provides
    @Singleton
    public NearbyPlaceRepository getAuthRequestContext(NearbyPlaceEntityRepository nearbyPlaceEntityRepository) {
        return nearbyPlaceEntityRepository;
    }

    @Provides
    @Singleton
    public PromoCenterRepository getAuthRequestContext(PromoCenterEntityRepository promoCenterEntityRepository) {
        return promoCenterEntityRepository;
    }

    @Provides
    @Singleton
    public PromoDiscoveryRepository getAuthRequestContext(PromoDiscoveryEntityRepository promoDiscoveryEntityRepository) {
        return promoDiscoveryEntityRepository;
    }

    @Provides
    @Singleton
    public PromotionRepository getAuthRequestContext(PromotionEntityRepository promotionEntityRepository) {
        return promotionEntityRepository;
    }

    @Provides
    @Singleton
    public RecentContactRepository getAuthRequestContext(RecentContactEntityRepository recentContactEntityRepository) {
        return recentContactEntityRepository;
    }

    @Provides
    @Singleton
    public RecentRecipientRepository getAuthRequestContext(RecentRecipientEntityRepository recentRecipientEntityRepository) {
        return recentRecipientEntityRepository;
    }

    @Provides
    @Singleton
    public ReferralEngagementDialogRepository getAuthRequestContext(ReferralEngagementEntityRepository referralEngagementEntityRepository) {
        return referralEngagementEntityRepository;
    }

    @Provides
    @Singleton
    public ReferralWidgetRepository getAuthRequestContext(ReferralWidgetEntityRepository referralWidgetEntityRepository) {
        return referralWidgetEntityRepository;
    }

    @Provides
    @Singleton
    public RequestMoneyRepository getAuthRequestContext(RequestMoneyEntityRepository requestMoneyEntityRepository) {
        return requestMoneyEntityRepository;
    }

    @Provides
    @Singleton
    public SavingCategoryRepository getAuthRequestContext(SavingCategoryEntityRepository savingCategoryEntityRepository) {
        return savingCategoryEntityRepository;
    }

    @Provides
    @Singleton
    public ShortenerRepository getAuthRequestContext(ShortenerEntityRepository shortenerEntityRepository) {
        return shortenerEntityRepository;
    }

    @Provides
    @Singleton
    public TwilioSdkRepository getAuthRequestContext(TwilioSdkEntityRepository twilioSdkEntityRepository) {
        return twilioSdkEntityRepository;
    }

    @Provides
    @Singleton
    public UserProfileInfoRepository getAuthRequestContext(UserProfileInfoEntityRepository userProfileInfoEntityRepository) {
        return userProfileInfoEntityRepository;
    }

    @Provides
    @Singleton
    public PersonalTabRepository getAuthRequestContext(PersonalTabEntityRepository personalTabEntityRepository) {
        return personalTabEntityRepository;
    }

    @Provides
    @Singleton
    public WebviewInterceptorRepository getAuthRequestContext(WebviewInterceptorEntityRepository webviewInterceptorEntityRepository) {
        return webviewInterceptorEntityRepository;
    }

    @Provides
    @Singleton
    public ProductInfoRepository getAuthRequestContext(ProductInfoEntityRepository productInfoEntityRepository) {
        return productInfoEntityRepository;
    }

    @Provides
    @Singleton
    public FeedInitRepository getAuthRequestContext(FeedInitEntityRepository feedInitEntityRepository) {
        return feedInitEntityRepository;
    }

    @Provides
    @Singleton
    public FeedsReactionRepository getAuthRequestContext(FeedsReactionEntityRepository feedsReactionEntityRepository) {
        return feedsReactionEntityRepository;
    }

    @Provides
    @Singleton
    public GlobalSendRepository getAuthRequestContext(GlobalSendEntityRepository globalSendEntityRepository) {
        return globalSendEntityRepository;
    }

    @Provides
    @Singleton
    @Named("passkeyExecutor")
    public ThreadExecutor getAuthRequestContext(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    public ApplicationModule(Application application) {
        this.MyBillsEntityDataFactory = application;
    }

    @Provides
    @Singleton
    public Context KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @Singleton
    public Application PlaceComponentResult() {
        return this.MyBillsEntityDataFactory;
    }

    @Provides
    @Singleton
    public ContentResolver PlaceComponentResult(Application application) {
        return application.getContentResolver();
    }

    @Provides
    @Singleton
    public PackageManager getErrorConfigVersion(Context context) {
        return context.getPackageManager();
    }

    @Provides
    @Singleton
    public LiteAccountRepository getAuthRequestContext(Lazy<LocalConfigLiteAccountEntityRepository> lazy) {
        return lazy.get();
    }

    @Provides
    @Singleton
    public SSLPinningRepository BuiltInFictitiousFunctionClassFactory(Lazy<LocalConfigSSLPinningEntityRepository> lazy) {
        return lazy.get();
    }

    @Provides
    @Singleton
    public SSLQuakeInterceptor PlaceComponentResult(SSLPinningRepository sSLPinningRepository) {
        return new SSLQuakeInterceptorImpl(sSLPinningRepository);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, com.twilio.verify.domain.factor.FactorMapper, com.twilio.verify.domain.service.ServiceMapper] */
    @Provides
    @Singleton
    @Nullable
    public TwilioVerify GetContactSyncConfig(Context context) {
        ?? r2 = 0;
        if (OSUtil.GetContactSyncConfig()) {
            try {
                TwilioVerify.Builder builder = new TwilioVerify.Builder(context);
                for (LoggerService loggerService : builder.NetworkUserEntityData$$ExternalSyntheticLambda0) {
                    LoggerImplementation loggerImplementation = LoggerImplementation.INSTANCE;
                    LoggerImplementation.MyBillsEntityDataFactory(loggerService);
                }
                Logger logger = Logger.PlaceComponentResult;
                Logger.BuiltInFictitiousFunctionClassFactory = LoggerImplementation.INSTANCE;
                FactorFacade.Builder builder2 = new FactorFacade.Builder();
                Context context2 = builder.getAuthRequestContext;
                Intrinsics.checkParameterIsNotNull(context2, "");
                FactorFacade.Builder builder3 = builder2;
                builder2.KClassImpl$Data$declaredNonStaticMembers$2 = context2;
                NetworkProvider networkProvider = builder.scheduleImpl;
                Intrinsics.checkParameterIsNotNull(networkProvider, "");
                FactorFacade.Builder builder4 = builder2;
                builder2.MyBillsEntityDataFactory = networkProvider;
                KeyStorage keyStorage = builder.PlaceComponentResult;
                Intrinsics.checkParameterIsNotNull(keyStorage, "");
                FactorFacade.Builder builder5 = builder2;
                builder2.PlaceComponentResult = keyStorage;
                String str = builder.MyBillsEntityDataFactory;
                Intrinsics.checkParameterIsNotNull(str, "");
                FactorFacade.Builder builder6 = builder2;
                builder2.BuiltInFictitiousFunctionClassFactory = str;
                AuthenticationProvider authenticationProvider = builder.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkParameterIsNotNull(authenticationProvider, "");
                FactorFacade.Builder builder7 = builder2;
                builder2.getAuthRequestContext = authenticationProvider;
                FactorFacade.Builder builder8 = builder2;
                if (builder2.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for context"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder2.MyBillsEntityDataFactory == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for network provider"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder2.PlaceComponentResult == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for key storage"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder2.BuiltInFictitiousFunctionClassFactory == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for base url"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder2.getAuthRequestContext == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for authentication"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                StringBuilder sb = new StringBuilder();
                Context context3 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                sb.append(context3.getPackageName());
                sb.append(".verify");
                String obj = sb.toString();
                NetworkProvider networkProvider2 = builder2.MyBillsEntityDataFactory;
                if (networkProvider2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                Context context4 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                Authentication authentication = builder2.getAuthRequestContext;
                if (authentication == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                String str2 = builder2.BuiltInFictitiousFunctionClassFactory;
                if (str2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                FactorAPIClient factorAPIClient = new FactorAPIClient(networkProvider2, context4, authentication, str2, null, 16, null);
                Context context5 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                SharedPreferences sharedPreferences = context5.getSharedPreferences(obj, 0);
                Context context6 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(".enc");
                SharedPreferences sharedPreferences2 = context6.getSharedPreferences(sb2.toString(), 0);
                Intrinsics.checkExpressionValueIsNotNull(sharedPreferences2, "");
                EncryptedStorage KClassImpl$Data$declaredNonStaticMembers$2 = EncryptedStorageKt.KClassImpl$Data$declaredNonStaticMembers$2(obj, sharedPreferences2);
                Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "");
                int i = 2;
                final FactorMigrations factorMigrations = new FactorMigrations(sharedPreferences, r2, i, r2);
                FactorRepository factorRepository = new FactorRepository(factorAPIClient, new Storage(sharedPreferences, KClassImpl$Data$declaredNonStaticMembers$2, CollectionsKt.listOf(new Migration() { // from class: com.twilio.verify.domain.factor.FactorMigrations$migrations$migrationV1ToV2$1

                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
                    private final int BuiltInFictitiousFunctionClassFactory = 1;

                    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
                    private final int PlaceComponentResult = 2;

                    @Override // com.twilio.verify.data.Migration
                    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
                    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
                    public final int getBuiltInFictitiousFunctionClassFactory() {
                        return this.BuiltInFictitiousFunctionClassFactory;
                    }

                    @Override // com.twilio.verify.data.Migration
                    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
                    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
                    public final int getPlaceComponentResult() {
                        return this.PlaceComponentResult;
                    }

                    @Override // com.twilio.verify.data.Migration
                    public final List<Entry> KClassImpl$Data$declaredNonStaticMembers$2(List<String> p0) {
                        SharedPreferences sharedPreferences3;
                        SharedPreferences sharedPreferences4;
                        FactorMapper unused;
                        FactorMapper unused2;
                        Intrinsics.checkParameterIsNotNull(p0, "");
                        sharedPreferences3 = FactorMigrations.this.BuiltInFictitiousFunctionClassFactory;
                        Collection<?> values = sharedPreferences3.getAll().values();
                        ArrayList arrayList = new ArrayList();
                        for (Object obj2 : values) {
                            if (obj2 instanceof String) {
                                arrayList.add(obj2);
                            }
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj3 : arrayList) {
                            unused = FactorMigrations.this.MyBillsEntityDataFactory;
                            if (FactorMapper.MyBillsEntityDataFactory((String) obj3)) {
                                arrayList2.add(obj3);
                            }
                        }
                        ArrayList arrayList3 = arrayList2;
                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(new JSONObject((String) it.next()));
                        }
                        ArrayList<JSONObject> arrayList5 = arrayList4;
                        ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList5, 10));
                        for (JSONObject jSONObject : arrayList5) {
                            unused2 = FactorMigrations.this.MyBillsEntityDataFactory;
                            String KClassImpl$Data$declaredNonStaticMembers$22 = FactorMapper.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject);
                            String jSONObject2 = jSONObject.toString();
                            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "");
                            arrayList6.add(new Entry(KClassImpl$Data$declaredNonStaticMembers$22, jSONObject2));
                        }
                        ArrayList<Entry> arrayList7 = arrayList6;
                        for (Entry entry : arrayList7) {
                            sharedPreferences4 = FactorMigrations.this.BuiltInFictitiousFunctionClassFactory;
                            sharedPreferences4.edit().remove(entry.BuiltInFictitiousFunctionClassFactory).apply();
                        }
                        return arrayList7;
                    }
                })), null, 4, null);
                KeyStorage keyStorage2 = builder2.PlaceComponentResult;
                if (keyStorage2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                Context context7 = builder2.KClassImpl$Data$declaredNonStaticMembers$2;
                if (context7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                FactorFacade factorFacade = new FactorFacade(new PushFactory(factorRepository, keyStorage2, context7), factorRepository);
                ChallengeFacade.Builder builder9 = new ChallengeFacade.Builder();
                Context context8 = builder.getAuthRequestContext;
                Intrinsics.checkParameterIsNotNull(context8, "");
                ChallengeFacade.Builder builder10 = builder9;
                builder9.MyBillsEntityDataFactory = context8;
                NetworkProvider networkProvider3 = builder.scheduleImpl;
                Intrinsics.checkParameterIsNotNull(networkProvider3, "");
                ChallengeFacade.Builder builder11 = builder9;
                builder9.KClassImpl$Data$declaredNonStaticMembers$2 = networkProvider3;
                JwtGenerator jwtGenerator = builder.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkParameterIsNotNull(jwtGenerator, "");
                ChallengeFacade.Builder builder12 = builder9;
                builder9.getAuthRequestContext = jwtGenerator;
                Intrinsics.checkParameterIsNotNull(factorFacade, "");
                ChallengeFacade.Builder builder13 = builder9;
                builder9.BuiltInFictitiousFunctionClassFactory = factorFacade;
                String str3 = builder.MyBillsEntityDataFactory;
                Intrinsics.checkParameterIsNotNull(str3, "");
                ChallengeFacade.Builder builder14 = builder9;
                builder9.scheduleImpl = str3;
                AuthenticationProvider authenticationProvider2 = builder.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkParameterIsNotNull(authenticationProvider2, "");
                ChallengeFacade.Builder builder15 = builder9;
                builder9.PlaceComponentResult = authenticationProvider2;
                ChallengeFacade.Builder builder16 = builder9;
                if (builder9.MyBillsEntityDataFactory == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for context"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder9.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for network provider"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder9.getAuthRequestContext == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for JWT generator"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder9.BuiltInFictitiousFunctionClassFactory == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for factor provider"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder9.scheduleImpl == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for base url"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder9.PlaceComponentResult == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for authentication"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                NetworkProvider networkProvider4 = builder9.KClassImpl$Data$declaredNonStaticMembers$2;
                if (networkProvider4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                Context context9 = builder9.MyBillsEntityDataFactory;
                if (context9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                Authentication authentication2 = builder9.PlaceComponentResult;
                if (authentication2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                String str4 = builder9.scheduleImpl;
                if (str4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                ChallengeRepository challengeRepository = new ChallengeRepository(new ChallengeAPIClient(networkProvider4, context9, authentication2, str4, null, 16, null), null, null, 6, null);
                JwtGenerator jwtGenerator2 = builder9.getAuthRequestContext;
                if (jwtGenerator2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                PushChallengeProcessor pushChallengeProcessor = new PushChallengeProcessor(challengeRepository, jwtGenerator2);
                FactorFacade factorFacade2 = builder9.BuiltInFictitiousFunctionClassFactory;
                if (factorFacade2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                ChallengeFacade challengeFacade = new ChallengeFacade(pushChallengeProcessor, factorFacade2, challengeRepository);
                ServiceFacade.Builder builder17 = new ServiceFacade.Builder();
                Context context10 = builder.getAuthRequestContext;
                Intrinsics.checkParameterIsNotNull(context10, "");
                ServiceFacade.Builder builder18 = builder17;
                builder17.getAuthRequestContext = context10;
                NetworkProvider networkProvider5 = builder.scheduleImpl;
                Intrinsics.checkParameterIsNotNull(networkProvider5, "");
                ServiceFacade.Builder builder19 = builder17;
                builder17.PlaceComponentResult = networkProvider5;
                Intrinsics.checkParameterIsNotNull(factorFacade, "");
                ServiceFacade.Builder builder20 = builder17;
                builder17.BuiltInFictitiousFunctionClassFactory = factorFacade;
                AuthenticationProvider authenticationProvider3 = builder.BuiltInFictitiousFunctionClassFactory;
                Intrinsics.checkParameterIsNotNull(authenticationProvider3, "");
                ServiceFacade.Builder builder21 = builder17;
                builder17.KClassImpl$Data$declaredNonStaticMembers$2 = authenticationProvider3;
                String str5 = builder.MyBillsEntityDataFactory;
                Intrinsics.checkParameterIsNotNull(str5, "");
                ServiceFacade.Builder builder22 = builder17;
                builder17.MyBillsEntityDataFactory = str5;
                ServiceFacade.Builder builder23 = builder17;
                if (builder17.getAuthRequestContext == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for context"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder17.PlaceComponentResult == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for network provider"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder17.MyBillsEntityDataFactory == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for base url"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder17.BuiltInFictitiousFunctionClassFactory == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for factor facade"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                if (builder17.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    throw new TwilioVerifyException(new IllegalArgumentException("Illegal value for authentication"), TwilioVerifyException.ErrorCode.InitializationError);
                }
                NetworkProvider networkProvider6 = builder17.PlaceComponentResult;
                if (networkProvider6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                Context context11 = builder17.getAuthRequestContext;
                if (context11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                Authentication authentication3 = builder17.KClassImpl$Data$declaredNonStaticMembers$2;
                if (authentication3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                String str6 = builder17.MyBillsEntityDataFactory;
                if (str6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                ServiceRepository serviceRepository = new ServiceRepository(new ServiceAPIClient(networkProvider6, context11, authentication3, str6, null, 16, null), r2, i, r2);
                FactorFacade factorFacade3 = builder17.BuiltInFictitiousFunctionClassFactory;
                if (factorFacade3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                return new TwilioVerifyManager(factorFacade, challengeFacade, new ServiceFacade(serviceRepository, factorFacade3));
            } catch (TwilioVerifyException unused) {
            }
        }
        return null;
    }

    @Provides
    @Singleton
    public RDSTracker NetworkUserEntityData$$ExternalSyntheticLambda0(Context context) {
        return new RDSTracker(context);
    }

    @Provides
    @Singleton
    public AppLifeCycleObserver PlaceComponentResult(Lazy<PreferenceAccountEntityData> lazy, LocationPermissionSubject locationPermissionSubject) {
        return new AppLifeCycleObserver(lazy, locationPermissionSubject);
    }

    @Provides
    @Singleton
    public H5EventRepository BuiltInFictitiousFunctionClassFactory() {
        return new H5EventEntityRepository();
    }

    @Provides
    @Singleton
    public DynamicUrlWrapper getAuthRequestContext(ConfigEntityDataFactory configEntityDataFactory) {
        return new DynamicUrlWrapper(configEntityDataFactory);
    }

    @Provides
    @Singleton
    public MixpanelRepository KClassImpl$Data$declaredNonStaticMembers$2(MixpanelEntityRepository mixpanelEntityRepository) {
        mixpanelEntityRepository.initMixpanelEntityData();
        return mixpanelEntityRepository;
    }

    @Provides
    @Singleton
    @Named("partialsync")
    public SyncRunner PlaceComponentResult(FeedsSyncContactEntityRepository feedsSyncContactEntityRepository, FeedInitEntityRepository feedInitEntityRepository) {
        return new PartialSyncContactRunner(feedsSyncContactEntityRepository, feedInitEntityRepository);
    }

    @Provides
    @Singleton
    @Named("fullsync")
    public SyncRunner MyBillsEntityDataFactory(FeedsSyncContactEntityRepository feedsSyncContactEntityRepository, FeedInitEntityRepository feedInitEntityRepository) {
        return new FullSyncContactRunner(feedsSyncContactEntityRepository, feedInitEntityRepository);
    }

    @Provides
    @Singleton
    @Named("recurringpartialsync")
    public SyncRunner PlaceComponentResult(RecurringFeedsSyncContactRepository recurringFeedsSyncContactRepository, FeedInitEntityRepository feedInitEntityRepository) {
        return new PartialSyncContactRunner(recurringFeedsSyncContactRepository, feedInitEntityRepository);
    }

    @Provides
    @Singleton
    @Named("recurringfullsync")
    public SyncRunner KClassImpl$Data$declaredNonStaticMembers$2(RecurringFeedsSyncContactRepository recurringFeedsSyncContactRepository, FeedInitEntityRepository feedInitEntityRepository) {
        return new FullSyncContactRunner(recurringFeedsSyncContactRepository, feedInitEntityRepository);
    }

    @Provides
    @Singleton
    public RemoteGnPaymentEntityData KClassImpl$Data$declaredNonStaticMembers$2(Application application, UserEntityRepository userEntityRepository, NetworkMiniPrograms networkMiniPrograms) {
        UserAgentFactory.create("Skywalker", "2.47.1");
        return new RemoteGnPaymentEntityData(application, userEntityRepository, networkMiniPrograms);
    }

    @Provides
    @Singleton
    public LoginLogoutObserver MyBillsEntityDataFactory(LoginLogoutSubject loginLogoutSubject) {
        return new LoginLogoutObserver(loginLogoutSubject);
    }

    @Provides
    @Singleton
    public LocationPermissionObserver KClassImpl$Data$declaredNonStaticMembers$2(LocationPermissionSubject locationPermissionSubject) {
        return new LocationPermissionObserver(locationPermissionSubject);
    }

    @Provides
    @Singleton
    @Named("homewidget")
    public PreferenceFacade KClassImpl$Data$declaredNonStaticMembers$2(Context context) {
        return new SimpleSecureKeyPreference(new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SharedPrefSplitAttributes.SPLIT_ATTRIBUTES_PREF_KEY).setUseDrutherPreference(true)).createData2("local"));
    }

    @Provides
    @Singleton
    @Named("startuppref")
    public PreferenceFacade lookAheadTest(Context context) {
        return new SimpleSecureKeyPreference(new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SharedPrefStartupConfig.FEATURE_TOGGLE_PREF).setUseDrutherPreference(true)).createData2("local"));
    }

    @Provides
    @Singleton
    @Named("fullstory_session")
    public PreferenceFacade PlaceComponentResult(Context context) {
        return new SimpleSecureKeyPreference(new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SharedPrefStartupConfig.FULLSTORY_SESSION_PREF).setUseDrutherPreference(true)).createData2("local"));
    }

    @Provides
    @Singleton
    @Named("splitattributespref")
    public PreferenceFacade scheduleImpl(Context context) {
        return new SimpleSecureKeyPreference(new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SharedPrefStartupConfig.FEATURE_TOGGLE_PREF).setUseDrutherPreference(true)).createData2("local"));
    }

    @Provides
    @Singleton
    @Named("scannerpref")
    public PreferenceFacade moveToNextValue(Context context) {
        return new SimpleSecureKeyPreference(new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SharedPrefScannerConfig.SCANNER_PREFERENCE_KEY).setUseDrutherPreference(true)).createData2("local"));
    }

    @Provides
    @Singleton
    public TransferAccountStatusChecker BuiltInFictitiousFunctionClassFactory(final Context context, GetCacheTransferAccountStatus getCacheTransferAccountStatus) {
        return new TransferAccountStatusChecker(getCacheTransferAccountStatus, new Runnable() { // from class: id.dana.di.modules.ApplicationModule$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ApplicationModule.MyBillsEntityDataFactory(context);
            }
        }, new Runnable() { // from class: id.dana.di.modules.ApplicationModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ApplicationModule.getAuthRequestContext(context);
            }
        });
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(Context context) {
        Intent intent = new Intent(context, TransferAccountSuccessActivity.class);
        intent.addFlags(268468224);
        context.startActivity(intent);
    }

    public static /* synthetic */ void getAuthRequestContext(Context context) {
        Intent intent = new Intent(context, TransferAccountStatusActivity.class);
        intent.addFlags(268468224);
        context.startActivity(intent);
    }

    @Provides
    @Singleton
    @Named("cashierconfigpref")
    public PreferenceFacade BuiltInFictitiousFunctionClassFactory(Context context) {
        return new SimpleSecureKeyPreference(new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(SharedPrefCashierConfig.CASHIER_CONFIG_PREF).setUseDrutherPreference(true)).createData2("local"));
    }
}
