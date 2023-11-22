package id.dana.data.config.repository;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import dagger.Lazy;
import id.dana.data.config.mapper.DanaProtectionWidgetConfigMapperKt;
import id.dana.data.config.mapper.DonationCampaignConfigMapper;
import id.dana.data.config.mapper.ExpiryInfoResultMapper;
import id.dana.data.config.mapper.GeofenceConfigMapper;
import id.dana.data.config.mapper.GnBindingBenefitMapperKt;
import id.dana.data.config.mapper.MaintenanceBroadcastResultMapper;
import id.dana.data.config.mapper.PromoCenterConfigMapper;
import id.dana.data.config.mapper.QrBindingConfigResultMapperKt;
import id.dana.data.config.mapper.QrisCrossBorderContentResultMapperKt;
import id.dana.data.config.mapper.RequestMoneyInfoResultMapper;
import id.dana.data.config.mapper.SplitBillConfigMapper;
import id.dana.data.config.mapper.TwilioTimeoutConfigMapper;
import id.dana.data.config.model.DanaProtectionWidgetConfigResult;
import id.dana.data.config.model.DealsConfigResult;
import id.dana.data.config.model.DealsConfigResultKt;
import id.dana.data.config.model.MarmotConfigResponse;
import id.dana.data.config.model.PromoAdsConfigResponse;
import id.dana.data.config.model.PromoAdsLocationConfigResponse;
import id.dana.data.config.model.QrBindingConfigResult;
import id.dana.data.config.model.QrisTciCoConfigResult;
import id.dana.data.config.model.QrisTciCoConfigResultKt;
import id.dana.data.config.model.TransactionHistoryConfigEntity;
import id.dana.data.config.model.TransactionHistoryConfigEntityKt;
import id.dana.data.config.model.UgcConfigResult;
import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.config.source.amcs.result.CashierMerchantWhitelistConfigResult;
import id.dana.data.config.source.amcs.result.CashierMerchantWhitelistConfigResultKt;
import id.dana.data.config.source.amcs.result.CashierPaymentAutorouteConfigResult;
import id.dana.data.config.source.amcs.result.CashierPaymentAutorouteConfigResultKt;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.config.source.amcs.result.DonationCampaignConfigResult;
import id.dana.data.config.source.amcs.result.GeofenceConfigResult;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.data.config.source.amcs.result.NearbyConfigResult;
import id.dana.data.config.source.amcs.result.PromoCenterConfigResult;
import id.dana.data.config.source.amcs.result.QrisCrossBorderContentResult;
import id.dana.data.config.source.amcs.result.RequestMoneyInfoResult;
import id.dana.data.config.source.amcs.result.SplitBillConfigResult;
import id.dana.data.config.source.amcs.result.TwilioTimeoutConfigResult;
import id.dana.data.config.source.sharedpreference.SharedPrefCashierConfig;
import id.dana.data.config.source.sharedpreference.SharedPrefScannerConfig;
import id.dana.data.featureswitch.FeatureNonAMCSEntityDataFactory;
import id.dana.data.featureswitch.repository.source.FeatureNonAMCSEntityData;
import id.dana.data.here.HereOauthManager;
import id.dana.data.here.model.HereConfigResponse;
import id.dana.data.homeinfo.repository.source.MaintenanceBroadcastDataFactory;
import id.dana.data.homeinfo.repository.source.MaintenanceBroadcastRepository;
import id.dana.data.login.source.network.result.LoginRegisterConfigResult;
import id.dana.data.profilemenu.model.ChangeUsernameEntity;
import id.dana.data.promocenter.mapper.PromoResultMapperKt;
import id.dana.data.promodiscovery.repository.source.split.model.PromoCenterVersionResult;
import id.dana.data.sendmoney.x2l.model.BannerConfigEntity;
import id.dana.data.sendmoney.x2l.model.BannerConfigEntityKt;
import id.dana.data.sendmoney.x2l.model.SocialLinkEntityKt;
import id.dana.data.storage.GeneralPreferences;
import id.dana.domain.danaprotection.DanaProtectionInfoRepository;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import id.dana.domain.featureconfig.model.CashierPaymentAutorouteConfig;
import id.dana.domain.featureconfig.model.ContactInjectionConfig;
import id.dana.domain.featureconfig.model.DealsConfig;
import id.dana.domain.featureconfig.model.DeepLinkFeatureSwitchModel;
import id.dana.domain.featureconfig.model.DonationCampaignConfig;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.domain.featureconfig.model.ExpiryInfo;
import id.dana.domain.featureconfig.model.ExpiryTimeConfig;
import id.dana.domain.featureconfig.model.ExpressPayInfo;
import id.dana.domain.featureconfig.model.GeofenceConfig;
import id.dana.domain.featureconfig.model.HelpButtonChatBot;
import id.dana.domain.featureconfig.model.MarmotConfig;
import id.dana.domain.featureconfig.model.MccListConfig;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import id.dana.domain.featureconfig.model.PersonalizedReferralConfig;
import id.dana.domain.featureconfig.model.PromoCenterConfig;
import id.dana.domain.featureconfig.model.QrisTciCoConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.featureconfig.model.ReferralMessageTemplateConfig;
import id.dana.domain.featureconfig.model.RequestMoneyInfo;
import id.dana.domain.featureconfig.model.ResetAndChangePinNativeEntryConfig;
import id.dana.domain.featureconfig.model.ShowAlipayConnectBrandConfig;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import id.dana.domain.featureconfig.model.TwilioTimeoutConfig;
import id.dana.domain.featureconfig.model.UgcConfig;
import id.dana.domain.login.model.LoginRegisterConfig;
import id.dana.domain.maintenance.model.BroadcastSavingStateResult;
import id.dana.domain.maintenance.model.MaintenanceBroadcast;
import id.dana.domain.nearbyme.model.NearbyConfig;
import id.dana.domain.nearbyme.model.NearbyWidgetConfig;
import id.dana.domain.oauth.model.GnBindingBenefit;
import id.dana.domain.oauth.model.QrBindingConfig;
import id.dana.domain.passkey.model.DanaVizEntryPointConfig;
import id.dana.domain.promocenter.model.PromoAdsConfig;
import id.dana.domain.qriscrossborder.model.QrisCrossBorderContent;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.sendmoney.x2l.model.BannerConfig;
import id.dana.domain.sendmoney.x2l.model.SocialLink;
import id.dana.domain.synccontact.model.SyncContactSplitConfigModel;
import id.dana.domain.transactionhistory.model.TransactionHistoryConfig;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000ú\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u009b\u0002\b\u0007\u0012\u000f\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030Ò\u00010Ñ\u0001\u0012\u000f\u0010ä\u0001\u001a\n\u0012\u0005\u0012\u00030ã\u00010Ñ\u0001\u0012\u000f\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Û\u00010Ñ\u0001\u0012\u000f\u0010æ\u0001\u001a\n\u0012\u0005\u0012\u00030å\u00010Ñ\u0001\u0012\u000f\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Ñ\u0001\u0012\u000f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010Ñ\u0001\u0012\u000f\u0010ð\u0001\u001a\n\u0012\u0005\u0012\u00030ï\u00010Ñ\u0001\u0012\u000f\u0010è\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010Ñ\u0001\u0012\u000f\u0010à\u0001\u001a\n\u0012\u0005\u0012\u00030ß\u00010Ñ\u0001\u0012\u000f\u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030×\u00010Ñ\u0001\u0012\u000f\u0010ò\u0001\u001a\n\u0012\u0005\u0012\u00030ñ\u00010Ñ\u0001\u0012\u000f\u0010Þ\u0001\u001a\n\u0012\u0005\u0012\u00030Ý\u00010Ñ\u0001\u0012\u000f\u0010â\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Ñ\u0001\u0012\u000f\u0010Ö\u0001\u001a\n\u0012\u0005\u0012\u00030Õ\u00010Ñ\u0001\u0012\u000f\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030ë\u00010Ñ\u0001\u0012\u000f\u0010î\u0001\u001a\n\u0012\u0005\u0012\u00030í\u00010Ñ\u0001¢\u0006\u0006\bó\u0001\u0010ô\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\r\u0010\nJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u000f\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00180\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\nJ\u0015\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\nJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u0007J\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\nJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u0004H\u0016¢\u0006\u0004\b!\u0010\nJ\u001b\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\"0\u0004H\u0016¢\u0006\u0004\b#\u0010\nJ\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020$0\u0004H\u0016¢\u0006\u0004\b%\u0010\nJ\u001b\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0\u0004H\u0016¢\u0006\u0004\b'\u0010\nJ\u0015\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u0004H\u0016¢\u0006\u0004\b)\u0010\nJ\u0015\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0004H\u0016¢\u0006\u0004\b+\u0010\nJ\u0015\u0010-\u001a\b\u0012\u0004\u0012\u00020,0\u0004H\u0016¢\u0006\u0004\b-\u0010\nJ\u0015\u0010/\u001a\b\u0012\u0004\u0012\u00020.0\u0004H\u0016¢\u0006\u0004\b/\u0010\nJ\u0015\u00101\u001a\b\u0012\u0004\u0012\u0002000\u0004H\u0016¢\u0006\u0004\b1\u0010\nJ\u0015\u00103\u001a\b\u0012\u0004\u0012\u0002020\u0004H\u0016¢\u0006\u0004\b3\u0010\nJ\u0015\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0004H\u0016¢\u0006\u0004\b5\u0010\nJ\u001b\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060&0\u0004H\u0016¢\u0006\u0004\b7\u0010\nJ\u001b\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\"0\u0004H\u0016¢\u0006\u0004\b9\u0010\nJ\u0015\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\u0004H\u0016¢\u0006\u0004\b;\u0010\nJ\u0015\u0010<\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b<\u0010\nJ\u001b\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0\u0004H\u0016¢\u0006\u0004\b=\u0010\nJ\u001b\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020>0\u0004H\u0016¢\u0006\u0004\b?\u0010\nJ\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020@0\u0004H\u0016¢\u0006\u0004\bA\u0010\nJ\u001b\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020B0&0\u0004H\u0016¢\u0006\u0004\bC\u0010\nJ\u0015\u0010E\u001a\b\u0012\u0004\u0012\u00020D0\u0004H\u0016¢\u0006\u0004\bE\u0010\nJ\u0015\u0010G\u001a\b\u0012\u0004\u0012\u00020F0\u0004H\u0016¢\u0006\u0004\bG\u0010\nJ\u0015\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u0004H\u0016¢\u0006\u0004\bI\u0010\nJ\u0015\u0010K\u001a\b\u0012\u0004\u0012\u00020J0\u0004H\u0016¢\u0006\u0004\bK\u0010\nJ\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020J0\u0004H\u0016¢\u0006\u0004\bL\u0010\nJ9\u0010Q\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020O0Nj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020O`P0\u00042\u0006\u0010M\u001a\u00020\u0002H\u0016¢\u0006\u0004\bQ\u0010\u0007J\u0015\u0010S\u001a\b\u0012\u0004\u0012\u00020R0\u0004H\u0016¢\u0006\u0004\bS\u0010\nJ\u0015\u0010U\u001a\b\u0012\u0004\u0012\u00020T0\u0004H\u0016¢\u0006\u0004\bU\u0010\nJ\u0015\u0010W\u001a\b\u0012\u0004\u0012\u00020V0\u0004H\u0016¢\u0006\u0004\bW\u0010\nJ\u0015\u0010X\u001a\b\u0012\u0004\u0012\u00020J0\u0004H\u0016¢\u0006\u0004\bX\u0010\nJ\u001b\u0010Z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0&0\u0004H\u0016¢\u0006\u0004\bZ\u0010\nJ\u001b\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0\u0004H\u0016¢\u0006\u0004\b[\u0010\nJ\u0015\u0010]\u001a\b\u0012\u0004\u0012\u00020\\0\u0004H\u0016¢\u0006\u0004\b]\u0010\nJ\u0015\u0010^\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\b^\u0010\nJ\u0015\u0010`\u001a\b\u0012\u0004\u0012\u00020_0\u0004H\u0016¢\u0006\u0004\b`\u0010\nJ\u0015\u0010a\u001a\b\u0012\u0004\u0012\u00020J0\u0004H\u0016¢\u0006\u0004\ba\u0010\nJ\u0015\u0010c\u001a\b\u0012\u0004\u0012\u00020b0\u0004H\u0016¢\u0006\u0004\bc\u0010\nJ\u0015\u0010d\u001a\b\u0012\u0004\u0012\u00020J0\u0004H\u0016¢\u0006\u0004\bd\u0010\nJ\u001b\u0010e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0\u0004H\u0016¢\u0006\u0004\be\u0010\nJ\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020g0\u00042\u0006\u0010f\u001a\u00020\u0002H\u0016¢\u0006\u0004\bh\u0010\u0007J\u001b\u0010i\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\"0\u0004H\u0016¢\u0006\u0004\bi\u0010\nJ\u0015\u0010k\u001a\b\u0012\u0004\u0012\u00020j0\u0004H\u0016¢\u0006\u0004\bk\u0010\nJ\u0015\u0010m\u001a\b\u0012\u0004\u0012\u00020l0\u0004H\u0016¢\u0006\u0004\bm\u0010\nJ\u0015\u0010o\u001a\b\u0012\u0004\u0012\u00020n0\u0004H\u0016¢\u0006\u0004\bo\u0010\nJ\u0015\u0010q\u001a\b\u0012\u0004\u0012\u00020p0\u0004H\u0016¢\u0006\u0004\bq\u0010\nJ\u0015\u0010s\u001a\b\u0012\u0004\u0012\u00020r0\u0004H\u0016¢\u0006\u0004\bs\u0010\nJ\u0015\u0010t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0004\bt\u0010\nJ\u0015\u0010u\u001a\b\u0012\u0004\u0012\u00020J0\u0004H\u0016¢\u0006\u0004\bu\u0010\nJ\u0015\u0010v\u001a\b\u0012\u0004\u0012\u00020,0\u0004H\u0016¢\u0006\u0004\bv\u0010\nJ\u0015\u0010x\u001a\b\u0012\u0004\u0012\u00020w0\u0004H\u0016¢\u0006\u0004\bx\u0010\nJ\u0015\u0010z\u001a\b\u0012\u0004\u0012\u00020y0\u0004H\u0016¢\u0006\u0004\bz\u0010\nJ\u0015\u0010|\u001a\b\u0012\u0004\u0012\u00020{0\u0004H\u0016¢\u0006\u0004\b|\u0010\nJ\u001b\u0010~\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020}0&0\u0004H\u0016¢\u0006\u0004\b~\u0010\nJ\u001b\u0010\u007f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0\u0004H\u0016¢\u0006\u0004\b\u007f\u0010\nJ\u0018\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010\u0004H\u0016¢\u0006\u0005\b\u0081\u0001\u0010\nJ4\u0010\u0084\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u001a\u0010\u0083\u0001\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u0082\u0001H\u0002¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001d\u0010\u0086\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020&0\u0004H\u0016¢\u0006\u0005\b\u0086\u0001\u0010\nJ\u0018\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0087\u00010\u0004H\u0016¢\u0006\u0005\b\u0088\u0001\u0010\nJ\u0017\u0010\u0089\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0005\b\u0089\u0001\u0010\nJ\u0018\u0010\u008b\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u0004H\u0016¢\u0006\u0005\b\u008b\u0001\u0010\nJ\u0017\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u008c\u0001\u0010\nJ\u001a\u0010\u008e\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u008d\u0001\u0018\u00010\u0004H\u0016¢\u0006\u0005\b\u008e\u0001\u0010\nJ\u0017\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0005\b\u008f\u0001\u0010\nJ\u0018\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0090\u00010\u0004H\u0016¢\u0006\u0005\b\u0091\u0001\u0010\nJ\u001d\u0010\u0092\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\"0\u0004H\u0016¢\u0006\u0005\b\u0092\u0001\u0010\nJ\u001d\u0010\u0093\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\"0\u0004H\u0016¢\u0006\u0005\b\u0093\u0001\u0010\nJ\u0018\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0094\u00010\u0004H\u0016¢\u0006\u0005\b\u0095\u0001\u0010\nJ\u0017\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u0096\u0001\u0010\nJ\u0017\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u0097\u0001\u0010\nJ\u0017\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u0098\u0001\u0010\nJ\u0017\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u0099\u0001\u0010\nJ\u0017\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u009a\u0001\u0010\nJ\u0017\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u009b\u0001\u0010\nJ\u0017\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u009c\u0001\u0010\nJ\u0017\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u009d\u0001\u0010\nJ\u0017\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u009e\u0001\u0010\nJ\u0017\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u009f\u0001\u0010\nJ\u0017\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b \u0001\u0010\nJ\u0017\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¡\u0001\u0010\nJ\u0017\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¢\u0001\u0010\nJ\u0017\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b£\u0001\u0010\nJ\u0017\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¤\u0001\u0010\nJ\u0017\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¥\u0001\u0010\nJ\u0017\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¦\u0001\u0010\nJ\u0017\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b§\u0001\u0010\nJ\u0017\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¨\u0001\u0010\nJ\u0017\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b©\u0001\u0010\nJ\u0017\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bª\u0001\u0010\nJ\u0017\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b«\u0001\u0010\nJ\u0017\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¬\u0001\u0010\nJ\u0017\u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b\u00ad\u0001\u0010\nJ\u0017\u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b®\u0001\u0010\nJ\u0017\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¯\u0001\u0010\nJ\u0017\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b°\u0001\u0010\nJ\u0017\u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b±\u0001\u0010\nJ \u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0007\u0010²\u0001\u001a\u00020\u0002H\u0016¢\u0006\u0005\b³\u0001\u0010\u0007J\u0017\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b´\u0001\u0010\nJ\u0017\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bµ\u0001\u0010\nJ\u0017\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¶\u0001\u0010\nJ\u0017\u0010·\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b·\u0001\u0010\nJ\u0017\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¸\u0001\u0010\nJ\u0017\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¹\u0001\u0010\nJ\u0017\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bº\u0001\u0010\nJ\u0017\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b»\u0001\u0010\nJ\u0017\u0010¼\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¼\u0001\u0010\nJ\u0017\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b½\u0001\u0010\nJ\u0017\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¾\u0001\u0010\nJ\u0017\u0010¿\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\b¿\u0001\u0010\nJ\u0017\u0010À\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÀ\u0001\u0010\nJ\u0017\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÁ\u0001\u0010\nJ\u0017\u0010Â\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÂ\u0001\u0010\nJ\u0017\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÃ\u0001\u0010\nJ\u0017\u0010Ä\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÄ\u0001\u0010\nJ\u0017\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÅ\u0001\u0010\nJ\u0017\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÆ\u0001\u0010\nJ\u0017\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÇ\u0001\u0010\nJ\u0017\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÈ\u0001\u0010\nJ\u0017\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÉ\u0001\u0010\nJ\u0017\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÊ\u0001\u0010\nJ\u0017\u0010Ë\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bË\u0001\u0010\nJ\u0017\u0010Ì\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÌ\u0001\u0010\nJ\u0017\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0016¢\u0006\u0005\bÍ\u0001\u0010\nJ\u0018\u0010Ï\u0001\u001a\t\u0012\u0005\u0012\u00030Î\u00010\u0004H\u0016¢\u0006\u0005\bÏ\u0001\u0010\nJ\u001f\u0010Ð\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\u0006\u0010\u001b\u001a\u00020\u0002H\u0016¢\u0006\u0005\bÐ\u0001\u0010\u0007R\u001f\u0010Ó\u0001\u001a\n\u0012\u0005\u0012\u00030Ò\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u001f\u0010Ö\u0001\u001a\n\u0012\u0005\u0012\u00030Õ\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010Ô\u0001R\u001f\u0010Ø\u0001\u001a\n\u0012\u0005\u0012\u00030×\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bØ\u0001\u0010Ô\u0001R\u001f\u0010Ú\u0001\u001a\n\u0012\u0005\u0012\u00030Ù\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÚ\u0001\u0010Ô\u0001R\u001f\u0010Ü\u0001\u001a\n\u0012\u0005\u0012\u00030Û\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÜ\u0001\u0010Ô\u0001R\u001f\u0010Þ\u0001\u001a\n\u0012\u0005\u0012\u00030Ý\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÞ\u0001\u0010Ô\u0001R\u001f\u0010à\u0001\u001a\n\u0012\u0005\u0012\u00030ß\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bà\u0001\u0010Ô\u0001R\u001f\u0010â\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bâ\u0001\u0010Ô\u0001R\u001f\u0010ä\u0001\u001a\n\u0012\u0005\u0012\u00030ã\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bä\u0001\u0010Ô\u0001R\u001f\u0010æ\u0001\u001a\n\u0012\u0005\u0012\u00030å\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bæ\u0001\u0010Ô\u0001R\u001f\u0010è\u0001\u001a\n\u0012\u0005\u0012\u00030ç\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bè\u0001\u0010Ô\u0001R\u001f\u0010ê\u0001\u001a\n\u0012\u0005\u0012\u00030é\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bê\u0001\u0010Ô\u0001R\u001f\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030ë\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bì\u0001\u0010Ô\u0001R\u001f\u0010î\u0001\u001a\n\u0012\u0005\u0012\u00030í\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bî\u0001\u0010Ô\u0001R\u001f\u0010ð\u0001\u001a\n\u0012\u0005\u0012\u00030ï\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bð\u0001\u0010Ô\u0001R\u001f\u0010ò\u0001\u001a\n\u0012\u0005\u0012\u00030ñ\u00010Ñ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bò\u0001\u0010Ô\u0001"}, d2 = {"Lid/dana/data/config/repository/FeatureConfigEntityRepository;", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "", "name", "Lio/reactivex/Observable;", "Lid/dana/domain/featureconfig/model/DeepLinkFeatureSwitchModel;", "checkDeepLinkFeatureVisibility", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "checkDexguardHookCheckFeature", "()Lio/reactivex/Observable;", "checkDexguardRootCheckFeature", "checkDexguardTamperCheckFeature", "checkIsResendWhatsAppEnable", "checkVisibilityFeature", "Lid/dana/data/config/source/ConfigEntityData;", "createConfigSplitEntityData", "()Lid/dana/data/config/source/ConfigEntityData;", "Lid/dana/data/featureswitch/repository/source/FeatureNonAMCSEntityData;", "createFeatureNonAmcsEntityData", "()Lid/dana/data/featureswitch/repository/source/FeatureNonAMCSEntityData;", "Lid/dana/data/homeinfo/repository/source/MaintenanceBroadcastRepository;", "createMaintenanceBroadcastEntityData", "()Lid/dana/data/homeinfo/repository/source/MaintenanceBroadcastRepository;", "", "getAddingNameWhitelistedSubMerchantId", "getAppShortcutEnabled", "lastDismissedBroadcast", "Lid/dana/domain/maintenance/model/BroadcastSavingStateResult;", "getBroadcastSavingState", "Lid/dana/domain/featureconfig/model/CashierPaymentAutorouteConfig;", "getCashierAutorouteConfig", "Lid/dana/domain/featureconfig/model/CashierMerchantWhitelistConfig;", "getCashierMerchantWhitelistConfig", "", "getCashierNativeEntryPoints", "Lid/dana/domain/featureconfig/model/ContactInjectionConfig;", "getContactInjectionConfig", "", "getCustomLoading3dsUrls", "Lid/dana/domain/danaprotection/model/DanaProtectionWidgetConfig;", "getDanaProtectionWidgetConfig", "Lid/dana/domain/featureconfig/model/DealsConfig;", "getDealsConfig", "", "getDecodeQrTimeout", "Lid/dana/domain/featureconfig/model/MccListConfig;", "getDecodeTciCoListConfig", "Lid/dana/domain/featureconfig/model/DonationCampaignConfig;", "getDonationCampaignConfig", "Lid/dana/domain/featureconfig/model/EmergencyNotificationConfig;", "getEmergencyNotifConfig", "Lid/dana/domain/featureconfig/model/ExpressPayInfo;", "getEnableExpressPayInfo", "Lid/dana/domain/featureconfig/model/ExpiryInfo;", "getExpiryChoice", "Lid/dana/domain/featureconfig/model/ExpiryTimeConfig;", "getExpiryTimeConfig", "Lid/dana/domain/passkey/model/DanaVizEntryPointConfig;", "getFeatureDanaVizEntryPointConfig", "getFeatureForcedFirstCard", "getFeatureSendMoneyCashierNative", "", "getFeatureSkipButtonMerchantList", "Lid/dana/domain/featureconfig/model/GeofenceConfig;", "getGeofenceConfig", "Lid/dana/domain/oauth/model/GnBindingBenefit;", "getGnBindingBenefits", "Lid/dana/domain/featureconfig/model/HelpButtonChatBot;", "getHelpButtonChatbotConfig", "Lid/dana/domain/login/model/LoginRegisterConfig;", "getLoginRegisterConfig", "Lid/dana/domain/featureconfig/model/MarmotConfig;", "getMarmotConfig", "", "getMaxBankAccount", "getMinimumRadiusInMeter", "configName", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getMultipleValueConfig", "Lid/dana/domain/nearbyme/model/NearbyConfig;", "getNearbyConfig", "Lid/dana/domain/nearbyme/model/NearbyWidgetConfig;", "getNearbyWidgetConfig", "Lid/dana/domain/featureconfig/model/OnboardingWarningTextConfig;", "getOnboardingWarningTextConfig", "getPaymentCodeDigit", "Lid/dana/domain/featureconfig/model/PersonalizedReferralConfig;", "getPersonalizedReferralConfig", "getPreventScreenshotConfig", "Lid/dana/domain/promocenter/model/PromoAdsConfig;", "getPromoAdsFeatureConfig", "getPromoBannerSliderItemNewSizeEnabled", "Lid/dana/domain/featureconfig/model/PromoCenterConfig;", "getPromoCenterConfig", "getPromoCenterVersion", "Lid/dana/domain/oauth/model/QrBindingConfig;", "getQrBindingConfig", "getQrCount", "getQrisCpmPrefixes", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "Lid/dana/domain/qriscrossborder/model/QrisCrossBorderContent;", "getQrisCrossBorderContent", "getQrisCrossBorderSupportedCountries", "Lid/dana/domain/featureconfig/model/QrisTciCoConfig;", "getQrisTcicoConfig", "Lid/dana/domain/featureconfig/model/QueryUserDataConfig;", "getQueryUserDataConfig", "Lid/dana/domain/featureconfig/model/ReferralMessageTemplateConfig;", "getReferralMessageTemplate", "Lid/dana/domain/featureconfig/model/RequestMoneyInfo;", "getRequestMoneyInfo", "Lid/dana/domain/featureconfig/model/ResetAndChangePinNativeEntryConfig;", "getResetAndChangePinNativeConfig", "getSendMoneyFeedConfig", "getSendMoneyNoteCharLimit", "getSendMoneyRefundTimeout", "Lid/dana/domain/sendmoney/x2l/model/BannerConfig;", "getSendToLinkBannerConfig", "Lid/dana/domain/featureconfig/model/ShowAlipayConnectBrandConfig;", "getShowAlipayConnectBrandConfig", "Lid/dana/domain/sendmoney/model/SmartFrictionConfig;", "getSmartFrictionConfig", "Lid/dana/domain/sendmoney/x2l/model/SocialLink;", "getSocialLinks", "getSocialMediaCategoryShare", "Lid/dana/domain/featureconfig/model/SplitBillConfig;", "getSplitBillConfig", "Lkotlin/Function1;", "getConfig", "getSplitWithAmcsFallbackConfig", "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/Observable;", "getStatementDisableDetailConfig", "Lid/dana/domain/synccontact/model/SyncContactSplitConfigModel;", "getSyncContactWithNameConfig", "getTnCReferralMissionConfig", "Lid/dana/domain/transactionhistory/model/TransactionHistoryConfig;", "getTransactionHistoryConfig", "getTwilioManualCheckConfig", "Lid/dana/domain/featureconfig/model/TwilioTimeoutConfig;", "getTwilioTimeoutConfig", "getUGCBannerConfig", "Lid/dana/domain/featureconfig/model/UgcConfig;", "getUgcFeatureConfig", "getValidDomainWhitelisted", "getWhitelistedSubMerchantId", "", "initHereConfig", "isBranchDeepLinkEnable", "isCScanBEnabled", "isCameraCardEnable", "isChangeUsernameEnabled", "isContactSyncEnable", "isFaceLoginEnable", "isFavoriteServicesEnable", "isFeatureAnnouncementEnable", "isFeatureAutoRoutingEnable", "isFeatureCashierDeeplinkKybEnabled", "isFeatureCashierEnable", "isFeatureElectronicMoneyBannerEnable", "isFeatureFeedHighlightEnabled", "isFeatureGnProxyEnable", "isFeatureGoalsBalanceEnable", "isFeatureInvestmentEnabled", "isFeatureMixPayEnable", "isFeatureNativeDecodeEnable", "isFeaturePaylaterCicilScannerEnabled", "isFeaturePaymentKeyboardEnable", "isFeatureQrisCrossBorderEnable", "isFeatureTncCardPaymentEnabled", "isFeedInboxTabEnable", "isFirebaseLoginPerformanceTrackerOn", "isFirebaseRegisterPerformanceTrackerOn", "isFrozenAccountChatbotEnabled", "isInterstitialBannerEnabled", "isKnowYourBusinessEnable", "type", "isKnowledgeBasedAuthEnable", "isLeaderboardEntryEnable", "isLogoutEnable", "isMePageNewEnabled", "isMerchantCategoryFilterEnable", "isNearbyMeEnable", "isNearbyMeMapViewEnable", "isNearbyReviewPageEnabled", "isOfflineF2FPay", "isProfileCompletionWidgetEnable", "isPromoCenterEnable", "isPromoClaimEnable", "isPromoQuestEnable", "isPushNotifDiagnosticEnable", "isQrisEnable", "isQrisTopUpEnable", "isRejectFakeNumberEnabled", "isSendMoneyPeerToCashEnable", "isSendToBankEnable", "isSendToLinkEnable", "isShowReferralCode", "isStatementDownloadEnable", "isStatementEnable", "isTwilioEnrollmentEnable", "isX2BPreKitkatDialogEnable", "isX2PEnable", "isX2XVoucherEnable", "Lid/dana/domain/maintenance/model/MaintenanceBroadcast;", "observeMaintenanceBroadcast", "setBroadcastSavingState", "Ldagger/Lazy;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Ldagger/Lazy;", "Lid/dana/domain/danaprotection/DanaProtectionInfoRepository;", "danaProtectionInfoRepository", "Lid/dana/data/config/mapper/DonationCampaignConfigMapper;", "donationCampaignConfigMapper", "Lid/dana/data/config/mapper/ExpiryInfoResultMapper;", "expiryInfoResultMapper", "Lid/dana/data/featureswitch/FeatureNonAMCSEntityDataFactory;", "featureNonAMCSEntityDataFactory", "Lid/dana/data/storage/GeneralPreferences;", "generalPreferences", "Lid/dana/data/config/mapper/GeofenceConfigMapper;", "geofenceConfigMapper", "Lid/dana/data/here/HereOauthManager;", "hereOauthManager", "Lid/dana/data/homeinfo/repository/source/MaintenanceBroadcastDataFactory;", "maintenanceBroadcastDataFactory", "Lid/dana/data/config/mapper/MaintenanceBroadcastResultMapper;", "maintenanceBroadcastResultMapper", "Lid/dana/data/config/mapper/PromoCenterConfigMapper;", "promoCenterConfigMapper", "Lid/dana/data/config/mapper/RequestMoneyInfoResultMapper;", "requestMoneyInfoResultMapper", "Lid/dana/data/config/source/sharedpreference/SharedPrefScannerConfig;", "scannerConfigPreference", "Lid/dana/data/config/source/sharedpreference/SharedPrefCashierConfig;", "sharedPrefCashierConfig", "Lid/dana/data/config/mapper/SplitBillConfigMapper;", "splitBillConfigMapper", "Lid/dana/data/config/mapper/TwilioTimeoutConfigMapper;", "twilioTimeoutConfigMapper", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FeatureConfigEntityRepository implements FeatureConfigRepository {
    private final Lazy<ConfigEntityDataFactory> configEntityDataFactory;
    private final Lazy<DanaProtectionInfoRepository> danaProtectionInfoRepository;
    private final Lazy<DonationCampaignConfigMapper> donationCampaignConfigMapper;
    private final Lazy<ExpiryInfoResultMapper> expiryInfoResultMapper;
    private final Lazy<FeatureNonAMCSEntityDataFactory> featureNonAMCSEntityDataFactory;
    private final Lazy<GeneralPreferences> generalPreferences;
    private final Lazy<GeofenceConfigMapper> geofenceConfigMapper;
    private final Lazy<HereOauthManager> hereOauthManager;
    private final Lazy<MaintenanceBroadcastDataFactory> maintenanceBroadcastDataFactory;
    private final Lazy<MaintenanceBroadcastResultMapper> maintenanceBroadcastResultMapper;
    private final Lazy<PromoCenterConfigMapper> promoCenterConfigMapper;
    private final Lazy<RequestMoneyInfoResultMapper> requestMoneyInfoResultMapper;
    private final Lazy<SharedPrefScannerConfig> scannerConfigPreference;
    private final Lazy<SharedPrefCashierConfig> sharedPrefCashierConfig;
    private final Lazy<SplitBillConfigMapper> splitBillConfigMapper;
    private final Lazy<TwilioTimeoutConfigMapper> twilioTimeoutConfigMapper;

    @Inject
    public FeatureConfigEntityRepository(Lazy<ConfigEntityDataFactory> lazy, Lazy<MaintenanceBroadcastDataFactory> lazy2, Lazy<FeatureNonAMCSEntityDataFactory> lazy3, Lazy<MaintenanceBroadcastResultMapper> lazy4, Lazy<ExpiryInfoResultMapper> lazy5, Lazy<RequestMoneyInfoResultMapper> lazy6, Lazy<SplitBillConfigMapper> lazy7, Lazy<PromoCenterConfigMapper> lazy8, Lazy<GeofenceConfigMapper> lazy9, Lazy<DonationCampaignConfigMapper> lazy10, Lazy<TwilioTimeoutConfigMapper> lazy11, Lazy<GeneralPreferences> lazy12, Lazy<HereOauthManager> lazy13, Lazy<DanaProtectionInfoRepository> lazy14, Lazy<SharedPrefScannerConfig> lazy15, Lazy<SharedPrefCashierConfig> lazy16) {
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
        this.configEntityDataFactory = lazy;
        this.maintenanceBroadcastDataFactory = lazy2;
        this.featureNonAMCSEntityDataFactory = lazy3;
        this.maintenanceBroadcastResultMapper = lazy4;
        this.expiryInfoResultMapper = lazy5;
        this.requestMoneyInfoResultMapper = lazy6;
        this.splitBillConfigMapper = lazy7;
        this.promoCenterConfigMapper = lazy8;
        this.geofenceConfigMapper = lazy9;
        this.donationCampaignConfigMapper = lazy10;
        this.twilioTimeoutConfigMapper = lazy11;
        this.generalPreferences = lazy12;
        this.hereOauthManager = lazy13;
        this.danaProtectionInfoRepository = lazy14;
        this.scannerConfigPreference = lazy15;
        this.sharedPrefCashierConfig = lazy16;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isKnowledgeBasedAuthEnable(String type) {
        Intrinsics.checkNotNullParameter(type, "");
        Observable<Boolean> isKnowledgeBasedAuthEnable = createConfigSplitEntityData().isKnowledgeBasedAuthEnable(type);
        Intrinsics.checkNotNullExpressionValue(isKnowledgeBasedAuthEnable, "");
        return isKnowledgeBasedAuthEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isKnowYourBusinessEnable() {
        Observable<Boolean> isKnowYourBusinessEnable = createConfigSplitEntityData().isKnowYourBusinessEnable();
        Intrinsics.checkNotNullExpressionValue(isKnowYourBusinessEnable, "");
        return isKnowYourBusinessEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isNearbyMeEnable() {
        Observable<Boolean> nearbyMeFeature = createConfigSplitEntityData().getNearbyMeFeature();
        Intrinsics.checkNotNullExpressionValue(nearbyMeFeature, "");
        return nearbyMeFeature;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isNearbyMeMapViewEnable() {
        Observable<Boolean> nearbyMeMapViewFeature = createConfigSplitEntityData().getNearbyMeMapViewFeature();
        Intrinsics.checkNotNullExpressionValue(nearbyMeMapViewFeature, "");
        return nearbyMeMapViewFeature;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isLogoutEnable() {
        Observable<Boolean> isLogoutEnable = createConfigSplitEntityData().isLogoutEnable();
        Intrinsics.checkNotNullExpressionValue(isLogoutEnable, "");
        return isLogoutEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isTwilioEnrollmentEnable() {
        Observable<Boolean> isTwilioEnrollmentEnable = createConfigSplitEntityData().isTwilioEnrollmentEnable();
        Intrinsics.checkNotNullExpressionValue(isTwilioEnrollmentEnable, "");
        return isTwilioEnrollmentEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isPromoQuestEnable() {
        Observable<Boolean> isPromoQuestEnable = createConfigSplitEntityData().isPromoQuestEnable();
        Intrinsics.checkNotNullExpressionValue(isPromoQuestEnable, "");
        return isPromoQuestEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Long> getSendMoneyRefundTimeout() {
        Observable<Long> sendMoneyRefundTimeout = createConfigSplitEntityData().getSendMoneyRefundTimeout();
        Intrinsics.checkNotNullExpressionValue(sendMoneyRefundTimeout, "");
        return sendMoneyRefundTimeout;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Integer> getSendMoneyNoteCharLimit() {
        Observable<Integer> sendMoneyNoteCharLimit = createConfigSplitEntityData().getSendMoneyNoteCharLimit();
        Intrinsics.checkNotNullExpressionValue(sendMoneyNoteCharLimit, "");
        return sendMoneyNoteCharLimit;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isPushNotifDiagnosticEnable() {
        Observable<Boolean> isPushNotifDiagnosticEnable = createConfigSplitEntityData().isPushNotifDiagnosticEnable();
        Intrinsics.checkNotNullExpressionValue(isPushNotifDiagnosticEnable, "");
        return isPushNotifDiagnosticEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<MaintenanceBroadcast> observeMaintenanceBroadcast() {
        Observable map = createConfigSplitEntityData().observeMaintenanceBroadcast().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MaintenanceBroadcast m887observeMaintenanceBroadcast$lambda0;
                m887observeMaintenanceBroadcast$lambda0 = FeatureConfigEntityRepository.m887observeMaintenanceBroadcast$lambda0(FeatureConfigEntityRepository.this, (MaintenanceBroadcastResult) obj);
                return m887observeMaintenanceBroadcast$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: observeMaintenanceBroadcast$lambda-0 */
    public static final MaintenanceBroadcast m887observeMaintenanceBroadcast$lambda0(FeatureConfigEntityRepository featureConfigEntityRepository, MaintenanceBroadcastResult maintenanceBroadcastResult) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(maintenanceBroadcastResult, "");
        return featureConfigEntityRepository.maintenanceBroadcastResultMapper.get().apply(maintenanceBroadcastResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<QrisTciCoConfig> getQrisTcicoConfig() {
        Observable map = createConfigSplitEntityData().getQrisTcicoConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda31
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QrisTciCoConfig m875getQrisTcicoConfig$lambda1;
                m875getQrisTcicoConfig$lambda1 = FeatureConfigEntityRepository.m875getQrisTcicoConfig$lambda1((QrisTciCoConfigResult) obj);
                return m875getQrisTcicoConfig$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getQrisTcicoConfig$lambda-1 */
    public static final QrisTciCoConfig m875getQrisTcicoConfig$lambda1(QrisTciCoConfigResult qrisTciCoConfigResult) {
        Intrinsics.checkNotNullParameter(qrisTciCoConfigResult, "");
        return QrisTciCoConfigResultKt.toQrisTciCoConfig(qrisTciCoConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isQrisTopUpEnable() {
        Observable<Boolean> isQrisTopUpEnable = createConfigSplitEntityData().isQrisTopUpEnable();
        Intrinsics.checkNotNullExpressionValue(isQrisTopUpEnable, "");
        return isQrisTopUpEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> getAppShortcutEnabled() {
        Observable flatMap = createConfigSplitEntityData().getAppWidgetEnabled().startWith(Observable.just(Boolean.valueOf(this.generalPreferences.get().getAppShortcutEnabledFlag()))).flatMap(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m853getAppShortcutEnabled$lambda2;
                m853getAppShortcutEnabled$lambda2 = FeatureConfigEntityRepository.m853getAppShortcutEnabled$lambda2(FeatureConfigEntityRepository.this, (Boolean) obj);
                return m853getAppShortcutEnabled$lambda2;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getAppShortcutEnabled$lambda-2 */
    public static final ObservableSource m853getAppShortcutEnabled$lambda2(FeatureConfigEntityRepository featureConfigEntityRepository, Boolean bool) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        featureConfigEntityRepository.generalPreferences.get().setAppShortcutEnabledFlag(bool.booleanValue());
        return Observable.just(bool);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Integer> getQrCount() {
        Observable<Integer> qrCount = createConfigSplitEntityData().getQrCount();
        Intrinsics.checkNotNullExpressionValue(qrCount, "");
        return qrCount;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getValidDomainWhitelisted() {
        Observable<List<String>> whitelistedDomain = createConfigSplitEntityData().getWhitelistedDomain();
        Intrinsics.checkNotNullExpressionValue(whitelistedDomain, "");
        return whitelistedDomain;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureGoalsBalanceEnable() {
        Observable<Boolean> isFeatureGoalsBalanceEnable = createConfigSplitEntityData().isFeatureGoalsBalanceEnable();
        Intrinsics.checkNotNullExpressionValue(isFeatureGoalsBalanceEnable, "");
        return isFeatureGoalsBalanceEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<TwilioTimeoutConfig> getTwilioTimeoutConfig() {
        return createConfigSplitEntityData().getTwilioTimeoutConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda33
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TwilioTimeoutConfig m882getTwilioTimeoutConfig$lambda3;
                m882getTwilioTimeoutConfig$lambda3 = FeatureConfigEntityRepository.m882getTwilioTimeoutConfig$lambda3(FeatureConfigEntityRepository.this, (TwilioTimeoutConfigResult) obj);
                return m882getTwilioTimeoutConfig$lambda3;
            }
        });
    }

    /* renamed from: getTwilioTimeoutConfig$lambda-3 */
    public static final TwilioTimeoutConfig m882getTwilioTimeoutConfig$lambda3(FeatureConfigEntityRepository featureConfigEntityRepository, TwilioTimeoutConfigResult twilioTimeoutConfigResult) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(twilioTimeoutConfigResult, "");
        return featureConfigEntityRepository.twilioTimeoutConfigMapper.get().apply(twilioTimeoutConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isOfflineF2FPay() {
        Observable<Boolean> isOfflineF2FPay = createConfigSplitEntityData().isOfflineF2FPay();
        Intrinsics.checkNotNullExpressionValue(isOfflineF2FPay, "");
        return isOfflineF2FPay;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isBranchDeepLinkEnable() {
        Observable<Boolean> isBranchDeepLinkEnable = createConfigSplitEntityData().isBranchDeepLinkEnable();
        Intrinsics.checkNotNullExpressionValue(isBranchDeepLinkEnable, "");
        return isBranchDeepLinkEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isMerchantCategoryFilterEnable() {
        Observable<Boolean> isMerchantCategoryFilterEnable = createConfigSplitEntityData().isMerchantCategoryFilterEnable();
        Intrinsics.checkNotNullExpressionValue(isMerchantCategoryFilterEnable, "");
        return isMerchantCategoryFilterEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<ExpressPayInfo> getEnableExpressPayInfo() {
        Observable<ExpressPayInfo> enableExpressPayInfo = createConfigSplitEntityData().getEnableExpressPayInfo();
        Intrinsics.checkNotNullExpressionValue(enableExpressPayInfo, "");
        return enableExpressPayInfo;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureCashierEnable() {
        if (this.sharedPrefCashierConfig.get().isFeatureCashierTimeExpired()) {
            Observable<Boolean> isFeatureCashierEnable = createConfigSplitEntityData().isFeatureCashierEnable();
            Intrinsics.checkNotNullExpressionValue(isFeatureCashierEnable, "");
            return isFeatureCashierEnable;
        }
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.sharedPrefCashierConfig.get().getFeatureCashierEnable()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeaturePaymentKeyboardEnable() {
        if (this.scannerConfigPreference.get().isFeaturePaymentKeyboardTimeExpired()) {
            Observable<Boolean> isFeaturePaymentKeyboardEnable = createConfigSplitEntityData().isFeaturePaymentKeyboardEnable();
            Intrinsics.checkNotNullExpressionValue(isFeaturePaymentKeyboardEnable, "");
            return isFeaturePaymentKeyboardEnable;
        }
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.scannerConfigPreference.get().getFeaturePaymentKeyboardEnable()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureAutoRoutingEnable() {
        Observable<Boolean> isFeatureAutoRoutingEnable = createConfigSplitEntityData().isFeatureAutoRoutingEnable();
        Intrinsics.checkNotNullExpressionValue(isFeatureAutoRoutingEnable, "");
        return isFeatureAutoRoutingEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureMixPayEnable() {
        Observable<Boolean> isFeatureMixPayEnable = createConfigSplitEntityData().isFeatureMixPayEnable();
        Intrinsics.checkNotNullExpressionValue(isFeatureMixPayEnable, "");
        return isFeatureMixPayEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureNativeDecodeEnable() {
        if (this.scannerConfigPreference.get().isFeatureNativeDecodeTimeExpired()) {
            Observable<Boolean> isFeatureNativeDecodeEnable = createConfigSplitEntityData().isFeatureNativeDecodeEnable();
            Intrinsics.checkNotNullExpressionValue(isFeatureNativeDecodeEnable, "");
            return isFeatureNativeDecodeEnable;
        }
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.scannerConfigPreference.get().getFeatureNativeDecodeEnable()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<ExpiryInfo>> getExpiryChoice() {
        Observable map = createConfigSplitEntityData().getExpiryChoice().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m860getExpiryChoice$lambda4;
                m860getExpiryChoice$lambda4 = FeatureConfigEntityRepository.m860getExpiryChoice$lambda4(FeatureConfigEntityRepository.this, (List) obj);
                return m860getExpiryChoice$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getExpiryChoice$lambda-4 */
    public static final List m860getExpiryChoice$lambda4(FeatureConfigEntityRepository featureConfigEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        return featureConfigEntityRepository.expiryInfoResultMapper.get().apply(list);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isShowReferralCode() {
        Observable<Boolean> timeout = createConfigSplitEntityData().isShowReferralCode().timeout(3L, TimeUnit.SECONDS);
        Intrinsics.checkNotNullExpressionValue(timeout, "");
        return timeout;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isLeaderboardEntryEnable() {
        Observable<Boolean> isLeaderboardEntryEnabled = createConfigSplitEntityData().isLeaderboardEntryEnabled();
        Intrinsics.checkNotNullExpressionValue(isLeaderboardEntryEnabled, "");
        return isLeaderboardEntryEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isSendToLinkEnable() {
        Observable<Boolean> isSendToLinkEnable = createConfigSplitEntityData().isSendToLinkEnable();
        Intrinsics.checkNotNullExpressionValue(isSendToLinkEnable, "");
        return isSendToLinkEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> getPromoBannerSliderItemNewSizeEnabled() {
        Observable<Boolean> promoBannerSliderItemNewSizeEnabled = createConfigSplitEntityData().getPromoBannerSliderItemNewSizeEnabled();
        Intrinsics.checkNotNullExpressionValue(promoBannerSliderItemNewSizeEnabled, "");
        return promoBannerSliderItemNewSizeEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<RequestMoneyInfo> getRequestMoneyInfo() {
        Observable map = createConfigSplitEntityData().getRequestMoneyInfo().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                RequestMoneyInfo m876getRequestMoneyInfo$lambda5;
                m876getRequestMoneyInfo$lambda5 = FeatureConfigEntityRepository.m876getRequestMoneyInfo$lambda5(FeatureConfigEntityRepository.this, (RequestMoneyInfoResult) obj);
                return m876getRequestMoneyInfo$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getRequestMoneyInfo$lambda-5 */
    public static final RequestMoneyInfo m876getRequestMoneyInfo$lambda5(FeatureConfigEntityRepository featureConfigEntityRepository, RequestMoneyInfoResult requestMoneyInfoResult) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(requestMoneyInfoResult, "");
        return featureConfigEntityRepository.requestMoneyInfoResultMapper.get().apply(requestMoneyInfoResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> getSendMoneyFeedConfig() {
        Observable<Boolean> onErrorReturn = createConfigSplitEntityData().getSendMoneyFeedConfig().onErrorReturn(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda28
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m877getSendMoneyFeedConfig$lambda6;
                m877getSendMoneyFeedConfig$lambda6 = FeatureConfigEntityRepository.m877getSendMoneyFeedConfig$lambda6((Throwable) obj);
                return m877getSendMoneyFeedConfig$lambda6;
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "");
        return onErrorReturn;
    }

    /* renamed from: getSendMoneyFeedConfig$lambda-6 */
    public static final Boolean m877getSendMoneyFeedConfig$lambda6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Boolean.TRUE;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isX2PEnable() {
        Observable<Boolean> isX2PEnable = createConfigSplitEntityData().isX2PEnable();
        Intrinsics.checkNotNullExpressionValue(isX2PEnable, "");
        return isX2PEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isX2BPreKitkatDialogEnable() {
        Observable<Boolean> isX2BPreKitkatDialogEnable = createConfigSplitEntityData().isX2BPreKitkatDialogEnable();
        Intrinsics.checkNotNullExpressionValue(isX2BPreKitkatDialogEnable, "");
        return isX2BPreKitkatDialogEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isX2XVoucherEnable() {
        Observable<Boolean> isX2XVoucherEnable = createConfigSplitEntityData().isX2XVoucherEnable();
        Intrinsics.checkNotNullExpressionValue(isX2XVoucherEnable, "");
        return isX2XVoucherEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isSendToBankEnable() {
        Observable<Boolean> isSendToBankEnable = createConfigSplitEntityData().isSendToBankEnable();
        Intrinsics.checkNotNullExpressionValue(isSendToBankEnable, "");
        return isSendToBankEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isContactSyncEnable() {
        Observable map = createConfigSplitEntityData().getContactSyncConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda32
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m886isContactSyncEnable$lambda7;
                m886isContactSyncEnable$lambda7 = FeatureConfigEntityRepository.m886isContactSyncEnable$lambda7((ContactSyncConfigResult) obj);
                return m886isContactSyncEnable$lambda7;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: isContactSyncEnable$lambda-7 */
    public static final Boolean m886isContactSyncEnable$lambda7(ContactSyncConfigResult contactSyncConfigResult) {
        Intrinsics.checkNotNullParameter(contactSyncConfigResult, "");
        return Boolean.valueOf(contactSyncConfigResult.isSynchronizeContact());
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> checkIsResendWhatsAppEnable() {
        Observable<Boolean> isResendWhatsAppEnable = createConfigSplitEntityData().isResendWhatsAppEnable();
        Intrinsics.checkNotNullExpressionValue(isResendWhatsAppEnable, "");
        return isResendWhatsAppEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isPromoClaimEnable() {
        Observable<Boolean> isPromoClaimEnable = createConfigSplitEntityData().isPromoClaimEnable();
        Intrinsics.checkNotNullExpressionValue(isPromoClaimEnable, "");
        return isPromoClaimEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<SplitBillConfig> getSplitBillConfig() {
        Observable map = createConfigSplitEntityData().getSplitBillConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda29
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                SplitBillConfig m880getSplitBillConfig$lambda8;
                m880getSplitBillConfig$lambda8 = FeatureConfigEntityRepository.m880getSplitBillConfig$lambda8(FeatureConfigEntityRepository.this, (SplitBillConfigResult) obj);
                return m880getSplitBillConfig$lambda8;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getSplitBillConfig$lambda-8 */
    public static final SplitBillConfig m880getSplitBillConfig$lambda8(FeatureConfigEntityRepository featureConfigEntityRepository, SplitBillConfigResult splitBillConfigResult) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(splitBillConfigResult, "");
        return featureConfigEntityRepository.splitBillConfigMapper.get().map(splitBillConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isPromoCenterEnable() {
        Observable<Boolean> isPromoCenterEnable = createConfigSplitEntityData().isPromoCenterEnable();
        Intrinsics.checkNotNullExpressionValue(isPromoCenterEnable, "");
        return isPromoCenterEnable;
    }

    private final Observable<Boolean> getSplitWithAmcsFallbackConfig(Function1<? super ConfigEntityData, ? extends Observable<Boolean>> getConfig) {
        return getConfig.invoke(createConfigSplitEntityData());
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> checkVisibilityFeature(final String name) {
        Intrinsics.checkNotNullParameter(name, "");
        return getSplitWithAmcsFallbackConfig(new Function1<ConfigEntityData, Observable<Boolean>>() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$checkVisibilityFeature$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<Boolean> invoke(ConfigEntityData configEntityData) {
                Intrinsics.checkNotNullParameter(configEntityData, "");
                Observable<Boolean> checkVisibilityFeature = configEntityData.checkVisibilityFeature(name);
                Intrinsics.checkNotNullExpressionValue(checkVisibilityFeature, "");
                return checkVisibilityFeature;
            }
        });
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isQrisEnable() {
        Observable<Boolean> isQrisEnabled = createConfigSplitEntityData().isQrisEnabled();
        Intrinsics.checkNotNullExpressionValue(isQrisEnabled, "");
        return isQrisEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getWhitelistedSubMerchantId() {
        Observable<List<String>> whitelistedSubMerchantId = createConfigSplitEntityData().getWhitelistedSubMerchantId();
        Intrinsics.checkNotNullExpressionValue(whitelistedSubMerchantId, "");
        return whitelistedSubMerchantId;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Set<String>> getAddingNameWhitelistedSubMerchantId() {
        Observable flatMap = createConfigSplitEntityData().getAddingNameWhitelistedSubMerchantId().flatMap(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m852getAddingNameWhitelistedSubMerchantId$lambda9;
                m852getAddingNameWhitelistedSubMerchantId$lambda9 = FeatureConfigEntityRepository.m852getAddingNameWhitelistedSubMerchantId$lambda9((List) obj);
                return m852getAddingNameWhitelistedSubMerchantId$lambda9;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getAddingNameWhitelistedSubMerchantId$lambda-9 */
    public static final ObservableSource m852getAddingNameWhitelistedSubMerchantId$lambda9(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return Observable.just(CollectionsKt.toMutableSet(list));
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isSendMoneyPeerToCashEnable() {
        Observable<Boolean> isSendMoneyPeerToCashEnable = createConfigSplitEntityData().isSendMoneyPeerToCashEnable();
        Intrinsics.checkNotNullExpressionValue(isSendMoneyPeerToCashEnable, "");
        return isSendMoneyPeerToCashEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> checkDexguardRootCheckFeature() {
        Observable<Boolean> isDexguardRootCheckEnable = createConfigSplitEntityData().isDexguardRootCheckEnable();
        Intrinsics.checkNotNullExpressionValue(isDexguardRootCheckEnable, "");
        return isDexguardRootCheckEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> checkDexguardHookCheckFeature() {
        Observable<Boolean> isDexguardHookCheckEnable = createConfigSplitEntityData().isDexguardHookCheckEnable();
        Intrinsics.checkNotNullExpressionValue(isDexguardHookCheckEnable, "");
        return isDexguardHookCheckEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> checkDexguardTamperCheckFeature() {
        Observable<Boolean> isDexguardTamperCheckEnable = createConfigSplitEntityData().isDexguardTamperCheckEnable();
        Intrinsics.checkNotNullExpressionValue(isDexguardTamperCheckEnable, "");
        return isDexguardTamperCheckEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<PromoCenterConfig> getPromoCenterConfig() {
        Observable<PromoCenterConfig> map = isPromoCenterEnable().flatMap(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda36
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m869getPromoCenterConfig$lambda10;
                m869getPromoCenterConfig$lambda10 = FeatureConfigEntityRepository.m869getPromoCenterConfig$lambda10(FeatureConfigEntityRepository.this, (Boolean) obj);
                return m869getPromoCenterConfig$lambda10;
            }
        }).map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoCenterConfig m870getPromoCenterConfig$lambda11;
                m870getPromoCenterConfig$lambda11 = FeatureConfigEntityRepository.m870getPromoCenterConfig$lambda11(FeatureConfigEntityRepository.this, (PromoCenterConfigResult) obj);
                return m870getPromoCenterConfig$lambda11;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getPromoCenterConfig$lambda-10 */
    public static final ObservableSource m869getPromoCenterConfig$lambda10(FeatureConfigEntityRepository featureConfigEntityRepository, Boolean bool) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(bool, "");
        if (bool.booleanValue()) {
            return featureConfigEntityRepository.createConfigSplitEntityData().getPromoCenterConfig(bool.booleanValue());
        }
        return Observable.just(new PromoCenterConfigResult());
    }

    /* renamed from: getPromoCenterConfig$lambda-11 */
    public static final PromoCenterConfig m870getPromoCenterConfig$lambda11(FeatureConfigEntityRepository featureConfigEntityRepository, PromoCenterConfigResult promoCenterConfigResult) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(promoCenterConfigResult, "");
        return featureConfigEntityRepository.promoCenterConfigMapper.get().apply(promoCenterConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureAnnouncementEnable() {
        Observable<Boolean> isFeatureAnnouncementEnable = createConfigSplitEntityData().isFeatureAnnouncementEnable();
        Intrinsics.checkNotNullExpressionValue(isFeatureAnnouncementEnable, "");
        return isFeatureAnnouncementEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Set<String>> getFeatureSkipButtonMerchantList() {
        Observable flatMap = createConfigSplitEntityData().getFeatureSkipButtonMerchantList().flatMap(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource m861getFeatureSkipButtonMerchantList$lambda12;
                m861getFeatureSkipButtonMerchantList$lambda12 = FeatureConfigEntityRepository.m861getFeatureSkipButtonMerchantList$lambda12((List) obj);
                return m861getFeatureSkipButtonMerchantList$lambda12;
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        return flatMap;
    }

    /* renamed from: getFeatureSkipButtonMerchantList$lambda-12 */
    public static final ObservableSource m861getFeatureSkipButtonMerchantList$lambda12(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return Observable.just(CollectionsKt.toMutableSet(list));
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFavoriteServicesEnable() {
        Observable<Boolean> isFavoriteServicesEnabled = createConfigSplitEntityData().isFavoriteServicesEnabled();
        Intrinsics.checkNotNullExpressionValue(isFavoriteServicesEnabled, "");
        return isFavoriteServicesEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFaceLoginEnable() {
        Observable<Boolean> isFaceLoginEnabled = createConfigSplitEntityData().isFaceLoginEnabled();
        Intrinsics.checkNotNullExpressionValue(isFaceLoginEnabled, "");
        return isFaceLoginEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isCameraCardEnable() {
        Observable<Boolean> featureCameraCard = createConfigSplitEntityData().getFeatureCameraCard();
        Intrinsics.checkNotNullExpressionValue(featureCameraCard, "");
        return featureCameraCard;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> getFeatureForcedFirstCard() {
        Observable<Boolean> featureForcedFirstCard = createConfigSplitEntityData().getFeatureForcedFirstCard();
        Intrinsics.checkNotNullExpressionValue(featureForcedFirstCard, "");
        return featureForcedFirstCard;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<GeofenceConfig> getGeofenceConfig() {
        Observable map = createConfigSplitEntityData().getGeofenceConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda11
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GeofenceConfig m862getGeofenceConfig$lambda13;
                m862getGeofenceConfig$lambda13 = FeatureConfigEntityRepository.m862getGeofenceConfig$lambda13(FeatureConfigEntityRepository.this, (GeofenceConfigResult) obj);
                return m862getGeofenceConfig$lambda13;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getGeofenceConfig$lambda-13 */
    public static final GeofenceConfig m862getGeofenceConfig$lambda13(FeatureConfigEntityRepository featureConfigEntityRepository, GeofenceConfigResult geofenceConfigResult) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(geofenceConfigResult, "");
        return featureConfigEntityRepository.geofenceConfigMapper.get().apply(geofenceConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<DonationCampaignConfig> getDonationCampaignConfig() {
        Observable map = createConfigSplitEntityData().getDonationCampaignConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda30
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DonationCampaignConfig m859getDonationCampaignConfig$lambda14;
                m859getDonationCampaignConfig$lambda14 = FeatureConfigEntityRepository.m859getDonationCampaignConfig$lambda14(FeatureConfigEntityRepository.this, (DonationCampaignConfigResult) obj);
                return m859getDonationCampaignConfig$lambda14;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getDonationCampaignConfig$lambda-14 */
    public static final DonationCampaignConfig m859getDonationCampaignConfig$lambda14(FeatureConfigEntityRepository featureConfigEntityRepository, DonationCampaignConfigResult donationCampaignConfigResult) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(donationCampaignConfigResult, "");
        return featureConfigEntityRepository.donationCampaignConfigMapper.get().apply(donationCampaignConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Integer> getMaxBankAccount() {
        Observable<Integer> maxBankAccount = createConfigSplitEntityData().getMaxBankAccount();
        Intrinsics.checkNotNullExpressionValue(maxBankAccount, "");
        return maxBankAccount;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<String> getTnCReferralMissionConfig() {
        Observable<String> tnCReferralMission = createConfigSplitEntityData().getTnCReferralMission();
        Intrinsics.checkNotNullExpressionValue(tnCReferralMission, "");
        return tnCReferralMission;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isStatementEnable() {
        Observable<Boolean> isStatementEnabled = createConfigSplitEntityData().isStatementEnabled();
        Intrinsics.checkNotNullExpressionValue(isStatementEnabled, "");
        return isStatementEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isStatementDownloadEnable() {
        Observable<Boolean> isStatementDownloadEnabled = createConfigSplitEntityData().isStatementDownloadEnabled();
        Intrinsics.checkNotNullExpressionValue(isStatementDownloadEnabled, "");
        return isStatementDownloadEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getStatementDisableDetailConfig() {
        Observable<List<String>> statementDisableDetailConfig = createConfigSplitEntityData().getStatementDisableDetailConfig();
        Intrinsics.checkNotNullExpressionValue(statementDisableDetailConfig, "");
        return statementDisableDetailConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<BroadcastSavingStateResult> setBroadcastSavingState(String lastDismissedBroadcast) {
        Intrinsics.checkNotNullParameter(lastDismissedBroadcast, "");
        return createMaintenanceBroadcastEntityData().setBroadcastSavingState(lastDismissedBroadcast);
    }

    private final MaintenanceBroadcastRepository createMaintenanceBroadcastEntityData() {
        return this.maintenanceBroadcastDataFactory.get().createData2("local");
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<BroadcastSavingStateResult> getBroadcastSavingState(String lastDismissedBroadcast) {
        Intrinsics.checkNotNullParameter(lastDismissedBroadcast, "");
        return createMaintenanceBroadcastEntityData().getBroadcastSavingState(lastDismissedBroadcast);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureGnProxyEnable() {
        Observable<Boolean> isFeatureGnProxyEnable = createConfigSplitEntityData().isFeatureGnProxyEnable();
        Intrinsics.checkNotNullExpressionValue(isFeatureGnProxyEnable, "");
        return isFeatureGnProxyEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isProfileCompletionWidgetEnable() {
        Observable<Boolean> profileCompletionWidgetVisibility = createConfigSplitEntityData().getProfileCompletionWidgetVisibility();
        Intrinsics.checkNotNullExpressionValue(profileCompletionWidgetVisibility, "");
        return profileCompletionWidgetVisibility;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<DeepLinkFeatureSwitchModel> checkDeepLinkFeatureVisibility(final String name) {
        Intrinsics.checkNotNullParameter(name, "");
        Observable zipWith = createFeatureNonAmcsEntityData().isFeatureNonAMCS(name).zipWith(getSplitWithAmcsFallbackConfig(new Function1<ConfigEntityData, Observable<Boolean>>() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$checkDeepLinkFeatureVisibility$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<Boolean> invoke(ConfigEntityData configEntityData) {
                Intrinsics.checkNotNullParameter(configEntityData, "");
                Observable<Boolean> checkVisibilityFeature = configEntityData.checkVisibilityFeature(name);
                Intrinsics.checkNotNullExpressionValue(checkVisibilityFeature, "");
                return checkVisibilityFeature;
            }
        }), new BiFunction() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                DeepLinkFeatureSwitchModel m851checkDeepLinkFeatureVisibility$lambda16;
                m851checkDeepLinkFeatureVisibility$lambda16 = FeatureConfigEntityRepository.m851checkDeepLinkFeatureVisibility$lambda16((Boolean) obj, (Boolean) obj2);
                return m851checkDeepLinkFeatureVisibility$lambda16;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }

    /* renamed from: checkDeepLinkFeatureVisibility$lambda-16 */
    public static final DeepLinkFeatureSwitchModel m851checkDeepLinkFeatureVisibility$lambda16(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        DeepLinkFeatureSwitchModel deepLinkFeatureSwitchModel = new DeepLinkFeatureSwitchModel();
        deepLinkFeatureSwitchModel.setFeatureActive(bool2.booleanValue());
        deepLinkFeatureSwitchModel.setFeatureNonAmcs(bool.booleanValue());
        return deepLinkFeatureSwitchModel;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureQrisCrossBorderEnable() {
        Observable<Boolean> isFeatureQrisCrossBorderEnabled = createConfigSplitEntityData().isFeatureQrisCrossBorderEnabled();
        Intrinsics.checkNotNullExpressionValue(isFeatureQrisCrossBorderEnabled, "");
        return isFeatureQrisCrossBorderEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getQrisCrossBorderSupportedCountries() {
        Observable<List<String>> qrisCrossBorderSupportedCountries = createConfigSplitEntityData().getQrisCrossBorderSupportedCountries();
        Intrinsics.checkNotNullExpressionValue(qrisCrossBorderSupportedCountries, "");
        return qrisCrossBorderSupportedCountries;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<QrisCrossBorderContent> getQrisCrossBorderContent(String r3) {
        Intrinsics.checkNotNullParameter(r3, "");
        Observable map = createConfigSplitEntityData().getQrisCrossBorderContent(r3).map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QrisCrossBorderContent m874getQrisCrossBorderContent$lambda17;
                m874getQrisCrossBorderContent$lambda17 = FeatureConfigEntityRepository.m874getQrisCrossBorderContent$lambda17((QrisCrossBorderContentResult) obj);
                return m874getQrisCrossBorderContent$lambda17;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getQrisCrossBorderContent$lambda-17 */
    public static final QrisCrossBorderContent m874getQrisCrossBorderContent$lambda17(QrisCrossBorderContentResult qrisCrossBorderContentResult) {
        Intrinsics.checkNotNullParameter(qrisCrossBorderContentResult, "");
        return QrisCrossBorderContentResultMapperKt.toQrisCrossBorderContent(qrisCrossBorderContentResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<GnBindingBenefit>> getGnBindingBenefits() {
        Observable map = createConfigSplitEntityData().getGnBindingBenefits().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda23
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m863getGnBindingBenefits$lambda18;
                m863getGnBindingBenefits$lambda18 = FeatureConfigEntityRepository.m863getGnBindingBenefits$lambda18((List) obj);
                return m863getGnBindingBenefits$lambda18;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getGnBindingBenefits$lambda-18 */
    public static final List m863getGnBindingBenefits$lambda18(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return GnBindingBenefitMapperKt.toGnBindingBenefitList(list);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isCScanBEnabled() {
        return getSplitWithAmcsFallbackConfig(new Function1<ConfigEntityData, Observable<Boolean>>() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$isCScanBEnabled$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<Boolean> invoke(ConfigEntityData configEntityData) {
                Intrinsics.checkNotNullParameter(configEntityData, "");
                Observable<Boolean> isCScanBEnabled = configEntityData.isCScanBEnabled();
                Intrinsics.checkNotNullExpressionValue(isCScanBEnabled, "");
                return isCScanBEnabled;
            }
        });
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isInterstitialBannerEnabled() {
        Observable<Boolean> isInterstitialBannerEnabled = createConfigSplitEntityData().isInterstitialBannerEnabled();
        Intrinsics.checkNotNullExpressionValue(isInterstitialBannerEnabled, "");
        return isInterstitialBannerEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureFeedHighlightEnabled() {
        Observable<Boolean> isFeatureFeedHightlightEnabled = createConfigSplitEntityData().isFeatureFeedHightlightEnabled();
        Intrinsics.checkNotNullExpressionValue(isFeatureFeedHightlightEnabled, "");
        return isFeatureFeedHightlightEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeedInboxTabEnable() {
        Observable<Boolean> isFeedInboxTabEnable = createConfigSplitEntityData().isFeedInboxTabEnable();
        Intrinsics.checkNotNullExpressionValue(isFeedInboxTabEnable, "");
        return isFeedInboxTabEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isChangeUsernameEnabled() {
        Observable<Boolean> onErrorReturnItem = createConfigSplitEntityData().isChangeUsernameEnabled().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m885isChangeUsernameEnabled$lambda19;
                m885isChangeUsernameEnabled$lambda19 = FeatureConfigEntityRepository.m885isChangeUsernameEnabled$lambda19((ChangeUsernameEntity) obj);
                return m885isChangeUsernameEnabled$lambda19;
            }
        }).onErrorReturnItem(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    /* renamed from: isChangeUsernameEnabled$lambda-19 */
    public static final Boolean m885isChangeUsernameEnabled$lambda19(ChangeUsernameEntity changeUsernameEntity) {
        Intrinsics.checkNotNullParameter(changeUsernameEntity, "");
        return Boolean.valueOf(changeUsernameEntity.getEnable());
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<PromoAdsConfig> getPromoAdsFeatureConfig() {
        Observable map = createConfigSplitEntityData().getFeaturePromoAds().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                PromoAdsConfig m868getPromoAdsFeatureConfig$lambda20;
                m868getPromoAdsFeatureConfig$lambda20 = FeatureConfigEntityRepository.m868getPromoAdsFeatureConfig$lambda20((PromoAdsConfigResponse) obj);
                return m868getPromoAdsFeatureConfig$lambda20;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getPromoAdsFeatureConfig$lambda-20 */
    public static final PromoAdsConfig m868getPromoAdsFeatureConfig$lambda20(PromoAdsConfigResponse promoAdsConfigResponse) {
        Intrinsics.checkNotNullParameter(promoAdsConfigResponse, "");
        return PromoResultMapperKt.toPromoAdsConfig(promoAdsConfigResponse);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Long> getDecodeQrTimeout() {
        Observable<Long> decodeQrTimeout = createConfigSplitEntityData().getDecodeQrTimeout();
        Intrinsics.checkNotNullExpressionValue(decodeQrTimeout, "");
        return decodeQrTimeout;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<ReferralMessageTemplateConfig> getReferralMessageTemplate() {
        Observable<ReferralMessageTemplateConfig> shareReferralMessageTemplate = createConfigSplitEntityData().getShareReferralMessageTemplate();
        Intrinsics.checkNotNullExpressionValue(shareReferralMessageTemplate, "");
        return shareReferralMessageTemplate;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<ShowAlipayConnectBrandConfig> getShowAlipayConnectBrandConfig() {
        Observable<ShowAlipayConnectBrandConfig> showAlipayConnectBrandConfig = createConfigSplitEntityData().getShowAlipayConnectBrandConfig();
        Intrinsics.checkNotNullExpressionValue(showAlipayConnectBrandConfig, "");
        return showAlipayConnectBrandConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Integer> getMinimumRadiusInMeter() {
        Observable map = createConfigSplitEntityData().getPromoAdsLocationConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer m866getMinimumRadiusInMeter$lambda21;
                m866getMinimumRadiusInMeter$lambda21 = FeatureConfigEntityRepository.m866getMinimumRadiusInMeter$lambda21((PromoAdsLocationConfigResponse) obj);
                return m866getMinimumRadiusInMeter$lambda21;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getMinimumRadiusInMeter$lambda-21 */
    public static final Integer m866getMinimumRadiusInMeter$lambda21(PromoAdsLocationConfigResponse promoAdsLocationConfigResponse) {
        Intrinsics.checkNotNullParameter(promoAdsLocationConfigResponse, "");
        return Integer.valueOf(promoAdsLocationConfigResponse.getMinimumRadiusInMeter());
    }

    /* renamed from: getNearbyConfig$lambda-22 */
    public static final NearbyConfig m867getNearbyConfig$lambda22(NearbyConfigResult nearbyConfigResult) {
        Intrinsics.checkNotNullParameter(nearbyConfigResult, "");
        return nearbyConfigResult.toNearbyConfig();
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<NearbyConfig> getNearbyConfig() {
        Observable map = createConfigSplitEntityData().getNearbyConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda22
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                NearbyConfig m867getNearbyConfig$lambda22;
                m867getNearbyConfig$lambda22 = FeatureConfigEntityRepository.m867getNearbyConfig$lambda22((NearbyConfigResult) obj);
                return m867getNearbyConfig$lambda22;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureInvestmentEnabled() {
        return getSplitWithAmcsFallbackConfig(new Function1<ConfigEntityData, Observable<Boolean>>() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$isFeatureInvestmentEnabled$1
            @Override // kotlin.jvm.functions.Function1
            public final Observable<Boolean> invoke(ConfigEntityData configEntityData) {
                Intrinsics.checkNotNullParameter(configEntityData, "");
                Observable<Boolean> isFeatureInvestmentEnabled = configEntityData.isFeatureInvestmentEnabled();
                Intrinsics.checkNotNullExpressionValue(isFeatureInvestmentEnabled, "");
                return isFeatureInvestmentEnabled;
            }
        });
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Unit> initHereConfig() {
        Observable map = createConfigSplitEntityData().getHereConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Unit m884initHereConfig$lambda23;
                m884initHereConfig$lambda23 = FeatureConfigEntityRepository.m884initHereConfig$lambda23(FeatureConfigEntityRepository.this, (HereConfigResponse) obj);
                return m884initHereConfig$lambda23;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: initHereConfig$lambda-23 */
    public static final Unit m884initHereConfig$lambda23(FeatureConfigEntityRepository featureConfigEntityRepository, HereConfigResponse hereConfigResponse) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(hereConfigResponse, "");
        featureConfigEntityRepository.hereOauthManager.get().setHereConfig(hereConfigResponse);
        return Unit.INSTANCE;
    }

    /* renamed from: getSendToLinkBannerConfig$lambda-24 */
    public static final BannerConfig m878getSendToLinkBannerConfig$lambda24(BannerConfigEntity bannerConfigEntity) {
        Intrinsics.checkNotNullParameter(bannerConfigEntity, "");
        return BannerConfigEntityKt.toBannerConfig(bannerConfigEntity);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<BannerConfig> getSendToLinkBannerConfig() {
        Observable map = createConfigSplitEntityData().getX2LBannerConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                BannerConfig m878getSendToLinkBannerConfig$lambda24;
                m878getSendToLinkBannerConfig$lambda24 = FeatureConfigEntityRepository.m878getSendToLinkBannerConfig$lambda24((BannerConfigEntity) obj);
                return m878getSendToLinkBannerConfig$lambda24;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getSocialLinks$lambda-25 */
    public static final List m879getSocialLinks$lambda25(List list) {
        Intrinsics.checkNotNullParameter(list, "");
        return SocialLinkEntityKt.toSocialLinks(list);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<SocialLink>> getSocialLinks() {
        Observable map = createConfigSplitEntityData().getX2LSocialLinks().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m879getSocialLinks$lambda25;
                m879getSocialLinks$lambda25 = FeatureConfigEntityRepository.m879getSocialLinks$lambda25((List) obj);
                return m879getSocialLinks$lambda25;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<SyncContactSplitConfigModel> getSyncContactWithNameConfig() {
        Observable<SyncContactSplitConfigModel> syncContactWithNameConfig = createConfigSplitEntityData().getSyncContactWithNameConfig();
        Intrinsics.checkNotNullExpressionValue(syncContactWithNameConfig, "");
        return syncContactWithNameConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<HelpButtonChatBot> getHelpButtonChatbotConfig() {
        Observable<HelpButtonChatBot> helpButtonChatbot = createConfigSplitEntityData().helpButtonChatbot();
        Intrinsics.checkNotNullExpressionValue(helpButtonChatbot, "");
        return helpButtonChatbot;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureElectronicMoneyBannerEnable() {
        Observable<Boolean> isFeatureElectronicMoneyBannerEnable = createConfigSplitEntityData().isFeatureElectronicMoneyBannerEnable();
        Intrinsics.checkNotNullExpressionValue(isFeatureElectronicMoneyBannerEnable, "");
        return isFeatureElectronicMoneyBannerEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<CashierMerchantWhitelistConfig> getCashierMerchantWhitelistConfig() {
        if (this.sharedPrefCashierConfig.get().isCashierMerchantWhitelistConfigTimeExpired()) {
            Observable map = createConfigSplitEntityData().getCashierMerchantWhitelistConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda24
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    CashierMerchantWhitelistConfig m855getCashierMerchantWhitelistConfig$lambda26;
                    m855getCashierMerchantWhitelistConfig$lambda26 = FeatureConfigEntityRepository.m855getCashierMerchantWhitelistConfig$lambda26((CashierMerchantWhitelistConfigResult) obj);
                    return m855getCashierMerchantWhitelistConfig$lambda26;
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            return map;
        }
        Observable<CashierMerchantWhitelistConfig> just = Observable.just(this.sharedPrefCashierConfig.get().getCashierMerchantWhitelistConfigs());
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    /* renamed from: getCashierMerchantWhitelistConfig$lambda-26 */
    public static final CashierMerchantWhitelistConfig m855getCashierMerchantWhitelistConfig$lambda26(CashierMerchantWhitelistConfigResult cashierMerchantWhitelistConfigResult) {
        Intrinsics.checkNotNullParameter(cashierMerchantWhitelistConfigResult, "");
        return CashierMerchantWhitelistConfigResultKt.toCashierMerchantWhitelistConfig(cashierMerchantWhitelistConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> getTwilioManualCheckConfig() {
        Observable<Boolean> isTwilioManualCheckEnable = createConfigSplitEntityData().isTwilioManualCheckEnable();
        Intrinsics.checkNotNullExpressionValue(isTwilioManualCheckEnable, "");
        return isTwilioManualCheckEnable;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isMePageNewEnabled() {
        Observable<Boolean> isMePageNewEnabled = createConfigSplitEntityData().isMePageNewEnabled();
        Intrinsics.checkNotNullExpressionValue(isMePageNewEnabled, "");
        return isMePageNewEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isRejectFakeNumberEnabled() {
        Observable<Boolean> isRejectFakeNumberEnabled = createConfigSplitEntityData().isRejectFakeNumberEnabled();
        Intrinsics.checkNotNullExpressionValue(isRejectFakeNumberEnabled, "");
        return isRejectFakeNumberEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureCashierDeeplinkKybEnabled() {
        if (this.scannerConfigPreference.get().isFeatureCashierDeeplinkKybTimeExpired()) {
            Observable<Boolean> isFeatureCashierDeeplinkKybEnabled = createConfigSplitEntityData().isFeatureCashierDeeplinkKybEnabled();
            Intrinsics.checkNotNullExpressionValue(isFeatureCashierDeeplinkKybEnabled, "");
            return isFeatureCashierDeeplinkKybEnabled;
        }
        Observable<Boolean> just = Observable.just(Boolean.valueOf(this.scannerConfigPreference.get().getFeatureCashierDeeplinkKybEnable()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getSocialMediaCategoryShare() {
        Observable<List<String>> socialMediaCategoryShare = createConfigSplitEntityData().getSocialMediaCategoryShare();
        Intrinsics.checkNotNullExpressionValue(socialMediaCategoryShare, "");
        return socialMediaCategoryShare;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<NearbyWidgetConfig> getNearbyWidgetConfig() {
        Observable<NearbyWidgetConfig> nearbyWidgetConfig = createConfigSplitEntityData().getNearbyWidgetConfig();
        Intrinsics.checkNotNullExpressionValue(nearbyWidgetConfig, "");
        return nearbyWidgetConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Integer> getPaymentCodeDigit() {
        Observable<Integer> paymentCodeDigit = createConfigSplitEntityData().getPaymentCodeDigit();
        Intrinsics.checkNotNullExpressionValue(paymentCodeDigit, "");
        return paymentCodeDigit;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<String> getUGCBannerConfig() {
        Observable<String> uGCBannerConfig = createConfigSplitEntityData().getUGCBannerConfig();
        Intrinsics.checkNotNullExpressionValue(uGCBannerConfig, "");
        return uGCBannerConfig;
    }

    /* renamed from: getPromoCenterVersion$lambda-27 */
    public static final Integer m871getPromoCenterVersion$lambda27(PromoCenterVersionResult promoCenterVersionResult) {
        Intrinsics.checkNotNullParameter(promoCenterVersionResult, "");
        return Integer.valueOf(promoCenterVersionResult.getVersion());
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Integer> getPromoCenterVersion() {
        Observable<Integer> onErrorReturnItem = createConfigSplitEntityData().getPromoCenterVersion().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda26
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer m871getPromoCenterVersion$lambda27;
                m871getPromoCenterVersion$lambda27 = FeatureConfigEntityRepository.m871getPromoCenterVersion$lambda27((PromoCenterVersionResult) obj);
                return m871getPromoCenterVersion$lambda27;
            }
        }).onErrorReturnItem(1);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        return onErrorReturnItem;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<PersonalizedReferralConfig>> getPersonalizedReferralConfig() {
        Observable<List<PersonalizedReferralConfig>> featurePersonalizedReferralConfig = createConfigSplitEntityData().getFeaturePersonalizedReferralConfig();
        Intrinsics.checkNotNullExpressionValue(featurePersonalizedReferralConfig, "");
        return featurePersonalizedReferralConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFrozenAccountChatbotEnabled() {
        Observable<Boolean> isFrozenAccountChatbotEnabled = createConfigSplitEntityData().isFrozenAccountChatbotEnabled();
        Intrinsics.checkNotNullExpressionValue(isFrozenAccountChatbotEnabled, "");
        return isFrozenAccountChatbotEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFirebaseLoginPerformanceTrackerOn() {
        Observable<Boolean> isFirebaseLoginPerformanceTrackerOn = createConfigSplitEntityData().isFirebaseLoginPerformanceTrackerOn();
        Intrinsics.checkNotNullExpressionValue(isFirebaseLoginPerformanceTrackerOn, "");
        return isFirebaseLoginPerformanceTrackerOn;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFirebaseRegisterPerformanceTrackerOn() {
        Observable<Boolean> isFirebaseRegisterPerformanceTrackerOn = createConfigSplitEntityData().isFirebaseRegisterPerformanceTrackerOn();
        Intrinsics.checkNotNullExpressionValue(isFirebaseRegisterPerformanceTrackerOn, "");
        return isFirebaseRegisterPerformanceTrackerOn;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getFeatureSendMoneyCashierNative() {
        Observable<List<String>> featureSendMoneyCashierNative = createConfigSplitEntityData().getFeatureSendMoneyCashierNative();
        Intrinsics.checkNotNullExpressionValue(featureSendMoneyCashierNative, "");
        return featureSendMoneyCashierNative;
    }

    private final ConfigEntityData createConfigSplitEntityData() {
        ConfigEntityData createData2 = this.configEntityDataFactory.get().createData2("split");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }

    private final FeatureNonAMCSEntityData createFeatureNonAmcsEntityData() {
        FeatureNonAMCSEntityData createData2 = this.featureNonAMCSEntityDataFactory.get().createData2("local");
        Intrinsics.checkNotNullExpressionValue(createData2, "");
        return createData2;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<DanaVizEntryPointConfig> getFeatureDanaVizEntryPointConfig() {
        Observable<DanaVizEntryPointConfig> featureDanaVizEntryPointConfig = createConfigSplitEntityData().getFeatureDanaVizEntryPointConfig();
        Intrinsics.checkNotNullExpressionValue(featureDanaVizEntryPointConfig, "");
        return featureDanaVizEntryPointConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<ContactInjectionConfig> getContactInjectionConfig() {
        Observable<ContactInjectionConfig> featureContactInjection = createConfigSplitEntityData().getFeatureContactInjection();
        Intrinsics.checkNotNullExpressionValue(featureContactInjection, "");
        return featureContactInjection;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isNearbyReviewPageEnabled() {
        Observable<Boolean> isNearbyReviewPageEnabled = createConfigSplitEntityData().isNearbyReviewPageEnabled();
        Intrinsics.checkNotNullExpressionValue(isNearbyReviewPageEnabled, "");
        return isNearbyReviewPageEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<MccListConfig> getDecodeTciCoListConfig() {
        Observable<MccListConfig> decodeTciCoListConfig = createConfigSplitEntityData().getDecodeTciCoListConfig();
        Intrinsics.checkNotNullExpressionValue(decodeTciCoListConfig, "");
        return decodeTciCoListConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getCashierNativeEntryPoints() {
        if (this.sharedPrefCashierConfig.get().isCashierNativeEntryPointsTimeExpired()) {
            Observable<List<String>> cashierNativeEntryPoints = createConfigSplitEntityData().getCashierNativeEntryPoints();
            Intrinsics.checkNotNullExpressionValue(cashierNativeEntryPoints, "");
            return cashierNativeEntryPoints;
        }
        Observable<List<String>> just = Observable.just(CollectionsKt.toMutableList((Collection) this.sharedPrefCashierConfig.get().getCashierNativeEntryPoints()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<EmergencyNotificationConfig> getEmergencyNotifConfig() {
        Observable<EmergencyNotificationConfig> emergencyNotifConfig = createConfigSplitEntityData().getEmergencyNotifConfig();
        Intrinsics.checkNotNullExpressionValue(emergencyNotifConfig, "");
        return emergencyNotifConfig;
    }

    /* renamed from: getDealsConfig$lambda-28 */
    public static final DealsConfig m858getDealsConfig$lambda28(DealsConfigResult dealsConfigResult) {
        Intrinsics.checkNotNullParameter(dealsConfigResult, "");
        return DealsConfigResultKt.toDealsConfig(dealsConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<DealsConfig> getDealsConfig() {
        Observable map = createConfigSplitEntityData().getDealsConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda35
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DealsConfig m858getDealsConfig$lambda28;
                m858getDealsConfig$lambda28 = FeatureConfigEntityRepository.m858getDealsConfig$lambda28((DealsConfigResult) obj);
                return m858getDealsConfig$lambda28;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<SmartFrictionConfig> getSmartFrictionConfig() {
        Observable<SmartFrictionConfig> smartFrictionConfig = createConfigSplitEntityData().getSmartFrictionConfig();
        Intrinsics.checkNotNullExpressionValue(smartFrictionConfig, "");
        return smartFrictionConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeatureTncCardPaymentEnabled() {
        Observable<Boolean> isFeatureTncCardPaymentEnabled = createConfigSplitEntityData().isFeatureTncCardPaymentEnabled();
        Intrinsics.checkNotNullExpressionValue(isFeatureTncCardPaymentEnabled, "");
        return isFeatureTncCardPaymentEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<UgcConfig> getUgcFeatureConfig() {
        Observable zipWith = createConfigSplitEntityData().checkVisibilityFeature("reviewmerchant").zipWith(createConfigSplitEntityData().getUgcConfigResult(), new BiFunction() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda27
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                UgcConfig m883getUgcFeatureConfig$lambda29;
                m883getUgcFeatureConfig$lambda29 = FeatureConfigEntityRepository.m883getUgcFeatureConfig$lambda29((Boolean) obj, (UgcConfigResult) obj2);
                return m883getUgcFeatureConfig$lambda29;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }

    /* renamed from: getUgcFeatureConfig$lambda-29 */
    public static final UgcConfig m883getUgcFeatureConfig$lambda29(Boolean bool, UgcConfigResult ugcConfigResult) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(ugcConfigResult, "");
        return UgcConfigResult.INSTANCE.toUgcConfig(ugcConfigResult, bool.booleanValue());
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getCustomLoading3dsUrls() {
        Observable<List<String>> customLoading3dsUrls = createConfigSplitEntityData().getCustomLoading3dsUrls();
        Intrinsics.checkNotNullExpressionValue(customLoading3dsUrls, "");
        return customLoading3dsUrls;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<QueryUserDataConfig> getQueryUserDataConfig() {
        Observable<QueryUserDataConfig> queryUserDataConfig = createConfigSplitEntityData().getQueryUserDataConfig();
        Intrinsics.checkNotNullExpressionValue(queryUserDataConfig, "");
        return queryUserDataConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<ResetAndChangePinNativeEntryConfig> getResetAndChangePinNativeConfig() {
        Observable<ResetAndChangePinNativeEntryConfig> resetAndChangePinNativeConfig = createConfigSplitEntityData().getResetAndChangePinNativeConfig();
        Intrinsics.checkNotNullExpressionValue(resetAndChangePinNativeConfig, "");
        return resetAndChangePinNativeConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<TransactionHistoryConfig> getTransactionHistoryConfig() {
        Observable map = createConfigSplitEntityData().getTransactionHistoryConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                TransactionHistoryConfig m881getTransactionHistoryConfig$lambda30;
                m881getTransactionHistoryConfig$lambda30 = FeatureConfigEntityRepository.m881getTransactionHistoryConfig$lambda30((TransactionHistoryConfigEntity) obj);
                return m881getTransactionHistoryConfig$lambda30;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getTransactionHistoryConfig$lambda-30 */
    public static final TransactionHistoryConfig m881getTransactionHistoryConfig$lambda30(TransactionHistoryConfigEntity transactionHistoryConfigEntity) {
        Intrinsics.checkNotNullParameter(transactionHistoryConfigEntity, "");
        return TransactionHistoryConfigEntityKt.toTransactionHistoryConfig(transactionHistoryConfigEntity);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getPreventScreenshotConfig() {
        Observable<List<String>> preventScreenshotConfig = createConfigSplitEntityData().getPreventScreenshotConfig();
        Intrinsics.checkNotNullExpressionValue(preventScreenshotConfig, "");
        return preventScreenshotConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<LoginRegisterConfig> getLoginRegisterConfig() {
        Observable map = createConfigSplitEntityData().getLoginRegisterConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                LoginRegisterConfig m864getLoginRegisterConfig$lambda31;
                m864getLoginRegisterConfig$lambda31 = FeatureConfigEntityRepository.m864getLoginRegisterConfig$lambda31((LoginRegisterConfigResult) obj);
                return m864getLoginRegisterConfig$lambda31;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getLoginRegisterConfig$lambda-31 */
    public static final LoginRegisterConfig m864getLoginRegisterConfig$lambda31(LoginRegisterConfigResult loginRegisterConfigResult) {
        Intrinsics.checkNotNullParameter(loginRegisterConfigResult, "");
        return LoginRegisterConfigResult.INSTANCE.toLoginRegisterConfig(loginRegisterConfigResult);
    }

    /* renamed from: getQrBindingConfig$lambda-32 */
    public static final QrBindingConfig m872getQrBindingConfig$lambda32(QrBindingConfigResult qrBindingConfigResult) {
        Intrinsics.checkNotNullParameter(qrBindingConfigResult, "");
        return QrBindingConfigResultMapperKt.toQrBindingConfig(qrBindingConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<QrBindingConfig> getQrBindingConfig() {
        Observable map = createConfigSplitEntityData().getQrBindingConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                QrBindingConfig m872getQrBindingConfig$lambda32;
                m872getQrBindingConfig$lambda32 = FeatureConfigEntityRepository.m872getQrBindingConfig$lambda32((QrBindingConfigResult) obj);
                return m872getQrBindingConfig$lambda32;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<Boolean> isFeaturePaylaterCicilScannerEnabled() {
        Observable<Boolean> isFeaturePaylaterCicilScannerEnabled = createConfigSplitEntityData().isFeaturePaylaterCicilScannerEnabled();
        Intrinsics.checkNotNullExpressionValue(isFeaturePaylaterCicilScannerEnabled, "");
        return isFeaturePaylaterCicilScannerEnabled;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<HashMap<String, Object>> getMultipleValueConfig(String configName) {
        Intrinsics.checkNotNullParameter(configName, "");
        Observable<HashMap<String, Object>> multipleBodyOnConfigFromFeature = createConfigSplitEntityData().getMultipleBodyOnConfigFromFeature(configName);
        Intrinsics.checkNotNullExpressionValue(multipleBodyOnConfigFromFeature, "");
        return multipleBodyOnConfigFromFeature;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<MarmotConfig> getMarmotConfig() {
        Observable map = createConfigSplitEntityData().getMarmotConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MarmotConfig m865getMarmotConfig$lambda33;
                m865getMarmotConfig$lambda33 = FeatureConfigEntityRepository.m865getMarmotConfig$lambda33((MarmotConfigResponse) obj);
                return m865getMarmotConfig$lambda33;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getMarmotConfig$lambda-33 */
    public static final MarmotConfig m865getMarmotConfig$lambda33(MarmotConfigResponse marmotConfigResponse) {
        Intrinsics.checkNotNullParameter(marmotConfigResponse, "");
        return MarmotConfigResponse.INSTANCE.toMarmotConfig(marmotConfigResponse);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<DanaProtectionWidgetConfig> getDanaProtectionWidgetConfig() {
        Observable<DanaProtectionWidgetConfig> doOnNext = createConfigSplitEntityData().getDanaProtectionWidgetConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DanaProtectionWidgetConfig m856getDanaProtectionWidgetConfig$lambda34;
                m856getDanaProtectionWidgetConfig$lambda34 = FeatureConfigEntityRepository.m856getDanaProtectionWidgetConfig$lambda34((DanaProtectionWidgetConfigResult) obj);
                return m856getDanaProtectionWidgetConfig$lambda34;
            }
        }).doOnNext(new Consumer() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                FeatureConfigEntityRepository.m857getDanaProtectionWidgetConfig$lambda35(FeatureConfigEntityRepository.this, (DanaProtectionWidgetConfig) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(doOnNext, "");
        return doOnNext;
    }

    /* renamed from: getDanaProtectionWidgetConfig$lambda-34 */
    public static final DanaProtectionWidgetConfig m856getDanaProtectionWidgetConfig$lambda34(DanaProtectionWidgetConfigResult danaProtectionWidgetConfigResult) {
        Intrinsics.checkNotNullParameter(danaProtectionWidgetConfigResult, "");
        return DanaProtectionWidgetConfigMapperKt.toDanaProtectionWidgetConfig(danaProtectionWidgetConfigResult);
    }

    /* renamed from: getDanaProtectionWidgetConfig$lambda-35 */
    public static final void m857getDanaProtectionWidgetConfig$lambda35(FeatureConfigEntityRepository featureConfigEntityRepository, DanaProtectionWidgetConfig danaProtectionWidgetConfig) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        DanaProtectionInfoRepository danaProtectionInfoRepository = featureConfigEntityRepository.danaProtectionInfoRepository.get();
        Intrinsics.checkNotNullExpressionValue(danaProtectionWidgetConfig, "");
        danaProtectionInfoRepository.setDanaProtectionWidgetConfigInCache(danaProtectionWidgetConfig);
    }

    /* renamed from: getCashierAutorouteConfig$lambda-36 */
    public static final CashierPaymentAutorouteConfig m854getCashierAutorouteConfig$lambda36(CashierPaymentAutorouteConfigResult cashierPaymentAutorouteConfigResult) {
        Intrinsics.checkNotNullParameter(cashierPaymentAutorouteConfigResult, "");
        return CashierPaymentAutorouteConfigResultKt.toCashierPaymentAutorouteConfig(cashierPaymentAutorouteConfigResult);
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<CashierPaymentAutorouteConfig> getCashierAutorouteConfig() {
        Observable map = createConfigSplitEntityData().getCashierPaymentAutorouteConfig().map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda34
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CashierPaymentAutorouteConfig m854getCashierAutorouteConfig$lambda36;
                m854getCashierAutorouteConfig$lambda36 = FeatureConfigEntityRepository.m854getCashierAutorouteConfig$lambda36((CashierPaymentAutorouteConfigResult) obj);
                return m854getCashierAutorouteConfig$lambda36;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<String>> getQrisCpmPrefixes() {
        Observable<List<String>> map = Observable.just(this.scannerConfigPreference.get().getQrisCpmPrefixs()).map(new Function() { // from class: id.dana.data.config.repository.FeatureConfigEntityRepository$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m873getQrisCpmPrefixes$lambda38;
                m873getQrisCpmPrefixes$lambda38 = FeatureConfigEntityRepository.m873getQrisCpmPrefixes$lambda38(FeatureConfigEntityRepository.this, (List) obj);
                return m873getQrisCpmPrefixes$lambda38;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* renamed from: getQrisCpmPrefixes$lambda-38 */
    public static final List m873getQrisCpmPrefixes$lambda38(FeatureConfigEntityRepository featureConfigEntityRepository, List list) {
        Intrinsics.checkNotNullParameter(featureConfigEntityRepository, "");
        Intrinsics.checkNotNullParameter(list, "");
        List list2 = list;
        if (list2.isEmpty()) {
            List<String> listOf = CollectionsKt.listOf("hQVDUFY");
            featureConfigEntityRepository.scannerConfigPreference.get().setQrisCpmPrefixs(listOf);
            return listOf;
        }
        return list2;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<OnboardingWarningTextConfig> getOnboardingWarningTextConfig() {
        Observable<OnboardingWarningTextConfig> onboardingWarningTextConfig = createConfigSplitEntityData().getOnboardingWarningTextConfig();
        Intrinsics.checkNotNullExpressionValue(onboardingWarningTextConfig, "");
        return onboardingWarningTextConfig;
    }

    @Override // id.dana.domain.featureconfig.FeatureConfigRepository
    public final Observable<List<ExpiryTimeConfig>> getExpiryTimeConfig() {
        Observable<List<ExpiryTimeConfig>> expiryTimeConfig = createConfigSplitEntityData().getExpiryTimeConfig();
        Intrinsics.checkNotNullExpressionValue(expiryTimeConfig, "");
        return expiryTimeConfig;
    }
}
