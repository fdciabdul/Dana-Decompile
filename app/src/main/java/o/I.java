package o;

import com.alipay.iap.android.wallet.acl.base.BaseResult;
import com.alipay.iap.android.wallet.acl.base.ResultError;
import com.alipay.iap.android.wallet.acl.oauth.OAuthCodeFlowType;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvLocationInfo;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.yellowmessenger.ymchat.models.YMBotEventResponse;
import com.yellowmessenger.ymchat.models.YellowUnreadMessageResponse;
import id.dana.biometric.data.source.local.RiskTrackerConfigEntity;
import id.dana.cardbinding.data.model.SupportedCardEntity;
import id.dana.cardbinding.data.model.SupportedCardsConfigEntity;
import id.dana.cashier.data.repository.source.network.request.MobileEnvInfoWithCity;
import id.dana.cashier.data.repository.source.network.request.MobileLocationInfoWithCity;
import id.dana.cashier.data.repository.source.network.result.CashierCurrencyFromCdnResult;
import id.dana.cashier.data.repository.source.network.result.CashierHighlightConfigResult;
import id.dana.danah5.mixpanel.model.JSApiRuleModel;
import id.dana.danah5.mixpanel.model.JSApiWhitelistModel;
import id.dana.data.banner.model.BannerEntity;
import id.dana.data.cancelsurvey.model.CancellationSurveyConfigModel;
import id.dana.data.config.model.CitcallPermissionConfig;
import id.dana.data.config.model.DanaHomeBalanceConfig;
import id.dana.data.config.model.DealsConfigResult;
import id.dana.data.config.model.MarmotConfigResponse;
import id.dana.data.config.model.MarmotDanaPromotionResponse;
import id.dana.data.config.model.NearbyTrendingKeywordEntity;
import id.dana.data.config.model.Permission;
import id.dana.data.config.model.PopupConfig;
import id.dana.data.config.model.PromoAdsLocationConfigResponse;
import id.dana.data.config.model.QrisTciCoConfigResult;
import id.dana.data.config.model.StartupConfigEntity;
import id.dana.data.config.model.TransactionHistoryConfigEntity;
import id.dana.data.config.model.UgcConfigResult;
import id.dana.data.config.source.amcs.result.BannerConfigResult;
import id.dana.data.config.source.amcs.result.CashierMerchantWhitelistConfigResult;
import id.dana.data.config.source.amcs.result.CashierPaymentAutorouteConfigResult;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.data.config.source.amcs.result.GeofenceConfigResult;
import id.dana.data.config.source.amcs.result.HelpButtonOtpLimitDevice;
import id.dana.data.config.source.amcs.result.MerchantCategoryContentResult;
import id.dana.data.config.source.amcs.result.NearbyConfigResult;
import id.dana.data.config.source.amcs.result.NearbyMigrateApiResult;
import id.dana.data.config.source.amcs.result.RepeatedBackgroundJobsResult;
import id.dana.data.config.source.amcs.result.TwilioTimeoutConfigResult;
import id.dana.data.config.source.sharedpreference.SocialFeedModelEntityData;
import id.dana.data.config.source.sharedpreference.SocialFeedWrapperModelEntityData;
import id.dana.data.danaprotection.repository.source.network.result.DanaProtectionInfoResult;
import id.dana.data.deeplink.model.SeamlessData;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import id.dana.data.devicestats.model.DeviceStatsConfig;
import id.dana.data.expresspurchase.model.ExpressPurchasePaylaterConfigResult;
import id.dana.data.feeds.model.ActivityEntity;
import id.dana.data.geocode.model.GeocodeReverseConfigResult;
import id.dana.data.globalnetwork.model.GnAuthResult;
import id.dana.data.globalnetwork.source.mock.MockGlobalNetworkEntityData$$ExternalSyntheticLambda0;
import id.dana.data.h5event.sendmoney.Attributes;
import id.dana.data.h5event.sendmoney.CheckoutFinishEntity;
import id.dana.data.h5event.sendmoney.PayQueryResponse;
import id.dana.data.here.model.ErrorHereResponse;
import id.dana.data.here.model.HereConfigResponse;
import id.dana.data.homeinfo.model.BannerLottieEntity;
import id.dana.data.homeinfo.model.SkuAttributeEntity;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import id.dana.data.login.source.network.result.LoginRegisterConfigResult;
import id.dana.data.login.source.network.result.RetryConfig;
import id.dana.data.nearbyme.model.MerchantConfigEntity;
import id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult;
import id.dana.data.profilemenu.model.SettingEntity;
import id.dana.data.promodiscovery.repository.source.split.model.PromoCenterVersionResult;
import id.dana.data.referral.source.local.model.ReferralDialogDailyLimitEntity;
import id.dana.data.referralwidget.model.ReferralWidgetResult;
import id.dana.data.resetpin.model.ConfigCountPinChange;
import id.dana.data.saving.model.MainEmptyStateEntity;
import id.dana.data.saving.model.SavingBenefitEntity;
import id.dana.data.saving.model.SavingEmptyStateEntity;
import id.dana.data.saving.model.SavingLimitEntity;
import id.dana.data.sendmoney.model.BillerX2BEntity;
import id.dana.data.sendmoney.model.DigitalMoneyResult;
import id.dana.data.sendmoney.model.SendMoneyScenarioEntity;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import id.dana.data.services.repository.source.model.ServiceHighlighted;
import id.dana.data.userconsent.repository.UserConsentEntityRepository;
import id.dana.data.usercredential.model.QueryCredentialInfoResult;
import id.dana.data.wallet_v3.model.RecommendationConfigKey;
import id.dana.domain.danah5.model.H5ShareData;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.model.AnbuConfig;
import id.dana.domain.featureconfig.model.CashierMerchantWhitelistConfig;
import id.dana.domain.featureconfig.model.Content;
import id.dana.domain.featureconfig.model.DiagnosticLogConfig;
import id.dana.domain.featureconfig.model.EmergencyNotificationConfig;
import id.dana.domain.featureconfig.model.HelpButtonChatBot;
import id.dana.domain.featureconfig.model.HelpButtonConfig;
import id.dana.domain.featureconfig.model.LinkInfo;
import id.dana.domain.featureconfig.model.OnboardingWarningTextConfig;
import id.dana.domain.featureconfig.model.PersonalizedReferralConfig;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import id.dana.domain.featureconfig.model.SplunkConfig;
import id.dana.domain.featureconfig.model.StartupConfig;
import id.dana.domain.home.model.DanaProtectionHomeWidgetInfoModel;
import id.dana.domain.nearbyme.model.NearbyAutoSearchConfig;
import id.dana.domain.paylater.model.LoanInfo;
import id.dana.domain.paylater.model.LoanStatusWhitelist;
import id.dana.domain.paylater.model.LoanWhitelist;
import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import id.dana.domain.permissionprompt.model.UserLocationPermissionPromptConfig;
import id.dana.domain.sendmoney.model.AddPayMethod;
import id.dana.domain.sendmoney.model.SmartFrictionConfig;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.ShareActivityConfig;
import id.dana.domain.uploadfiles.UploadFilesEntity;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import id.dana.domain.version.Version;
import id.dana.domain.wallet_v3.model.Rules;
import id.dana.domain.wallet_v3.model.WalletConfig;
import id.dana.domain.wallet_v3.model.WalletV3AddAssetServices;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import id.dana.domain.wallet_v3.model.WalletV3RecommendationConfig;
import id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse;
import id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse;
import id.dana.explore.data.globalsearch.model.GlobalSearchWidgetResponse;
import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import id.dana.expresspurchase.model.ExpressPurchaseModel;
import id.dana.feeds.data.config.model.FeedConfigResult;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import id.dana.kyb.data.model.KybInfoResult;
import id.dana.mybills.data.model.request.CreateSubscriptionExtendInfoEntity;
import id.dana.mybills.data.model.response.ExtendInfoQuerySubscriptionResult;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import id.dana.passkey.model.GetPasskeyResponse;
import id.dana.phototips.model.PhotoTipsModel;
import id.dana.sendmoney.domain.globalsend.model.sender.SenderDetail;
import id.dana.utils.config.model.Bluetooth;
import id.dana.utils.config.model.Cpu;
import id.dana.utils.config.model.Device;
import id.dana.utils.config.model.DeviceInfo;
import id.dana.utils.config.model.Display;
import id.dana.utils.config.model.ExternalStorage;
import id.dana.utils.config.model.Gps;
import id.dana.utils.config.model.IP;
import id.dana.utils.config.model.Memory;
import id.dana.utils.config.model.NetworkLoggingConfig;
import id.dana.utils.config.model.SysFeature;
import id.dana.utils.config.model.TimeLocation;
import id.dana.utils.config.model.Wifi;
import id.dana.utils.holdlogin.v2.model.FeatureHoldLoginConfig;
import id.dana.utils.holdlogin.v2.model.HoldLoginErrorCodesEntity;
import id.dana.utils.rpc.response.BaseNetworkRpcResponse;
import id.dana.utils.rpc.response.DefaultResponse;

/* loaded from: classes3.dex */
public final class I implements TypeAdapterFactory {
    private static final F PlaceComponentResult = new F();
    private static final H getAuthRequestContext = new H();

    @Override // com.google.gson.TypeAdapterFactory
    public final <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        try {
            if (typeToken.getRawType() == ActivityWidget.class) {
                return new setNationality(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused) {
        }
        try {
            if (typeToken.getRawType() == FeedConfigResult.class) {
                return new FlowLiveDataConversions$asLiveData$1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused2) {
        }
        try {
            if (typeToken.getRawType() == NetworkLoggingConfig.class) {
                return new RoundedCornerTreatment(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused3) {
        }
        try {
            if (typeToken.getRawType() == ActivityEntity.class) {
                return new C$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused4) {
        }
        try {
            if (typeToken.getRawType() == ShareActivityConfig.class) {
                return new ViewPayConfirmationAddOnBinding(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused5) {
        }
        try {
            if (typeToken.getRawType() == Gps.class) {
                return new AbstractMapBasedMultimap$AsMap(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused6) {
        }
        try {
            if (typeToken.getRawType() == CategoryHighlightedFeature.class) {
                return new BarcodeUtil$$ExternalSyntheticLambda0(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused7) {
        }
        try {
            if (typeToken.getRawType() == UploadFilesEntity.class) {
                return new getImageAssetsFolder(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused8) {
        }
        try {
            if (typeToken.getRawType() == Permission.class) {
                return new setIndex$kotlin_stdlib(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused9) {
        }
        try {
            if (typeToken.getRawType() == SavingEmptyStateEntity.class) {
                return new toFullstoryConfig(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused10) {
        }
        try {
            if (typeToken.getRawType() == DeviceInfo.class) {
                return new C$r8$lambda$TGidIAE3L8As7QVHBZ6_rXBA0k(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused11) {
        }
        try {
            if (typeToken.getRawType() == DeviceStatsConfig.class) {
                return new indexOfAny(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused12) {
        }
        try {
            if (typeToken.getRawType() == DeepLinkPayloadEntity.class) {
                return new access$getServiceItemDecorator$p(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused13) {
        }
        try {
            if (typeToken.getRawType() == RepeatedBackgroundJobsResult.class) {
                return new onLayoutDirectionChanged(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused14) {
        }
        try {
            if (typeToken.getRawType() == YellowUnreadMessageResponse.class) {
                return new PlaybackStateCompat$MediaKeyAction(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused15) {
        }
        try {
            if (typeToken.getRawType() == MarmotConfigResponse.class) {
                return new isAllowRetry(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused16) {
        }
        try {
            if (typeToken.getRawType() == PaylaterCicilMethodConfigResult.class) {
                return new SearchConditionEntityKt(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused17) {
        }
        try {
            if (typeToken.getRawType() == OnboardingWarningTextConfig.class) {
                return new forEach(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused18) {
        }
        try {
            if (typeToken.getRawType() == NumberOfLocationPermissionPromptShown.class) {
                return new getThread(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused19) {
        }
        try {
            if (typeToken.getRawType() == BaseResult.class) {
                return new PlaceComponentResult(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused20) {
        }
        try {
            if (typeToken.getRawType() == LoanWhitelist.class) {
                return new TaskListBlock(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused21) {
        }
        try {
            if (typeToken.getRawType() == ExpressPurchasePaylaterConfigResult.class) {
                return new CacheBuilderSpec$AccessDurationParser(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused22) {
        }
        try {
            if (typeToken.getRawType() == MobileEnvLocationInfo.class) {
                return new moveToNextValue(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused23) {
        }
        try {
            if (typeToken.getRawType() == DanaHomeBalanceConfig.class) {
                return new EmergencyNotifActivity$getEmergencyNotifModule$1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused24) {
        }
        try {
            if (typeToken.getRawType() == ConfigCountPinChange.class) {
                return new ServiceStarter(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused25) {
        }
        try {
            if (typeToken.getRawType() == BannerLottieEntity.class) {
                return new ImageCaptureViewModel$getTipUploadPhoto$1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused26) {
        }
        try {
            if (typeToken.getRawType() == CashierHighlightConfigResult.class) {
                return new TypeToken$TypeSet(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused27) {
        }
        try {
            if (typeToken.getRawType() == SocialFeedWrapperModelEntityData.class) {
                return new ListenerMethod(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused28) {
        }
        try {
            if (typeToken.getRawType() == CheckoutFinishEntity.class) {
                return new targetValue(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused29) {
        }
        try {
            if (typeToken.getRawType() == SupportedCardEntity.class) {
                return new outerType(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused30) {
        }
        try {
            if (typeToken.getRawType() == DanaHomeBalanceConfigModel.class) {
                return new onSuccessLoadMoreReview(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused31) {
        }
        try {
            if (typeToken.getRawType() == HoldLoginErrorCodesEntity.class) {
                return new readBoolean(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused32) {
        }
        try {
            if (typeToken.getRawType() == WalletV3AddAssetServices.class) {
                return new PopupModel(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused33) {
        }
        try {
            if (typeToken.getRawType() == PopupConfig.class) {
                return new RepaymentPlan(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused34) {
        }
        try {
            if (typeToken.getRawType() == DanaProtectionWidgetConfig.class) {
                return new VerifyPushDerollRequest(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused35) {
        }
        try {
            if (typeToken.getRawType() == CashierMerchantWhitelistConfig.class) {
                return new EventLoopImplBase$DelayedRunnableTask(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused36) {
        }
        try {
            if (typeToken.getRawType() == GeocodeReverseConfigResult.class) {
                return new KeyEvent$DispatcherState(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused37) {
        }
        try {
            if (typeToken.getRawType() == LoanStatusWhitelist.class) {
                return new OcrImagePreprocessingConfigModel(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused38) {
        }
        try {
            if (typeToken.getRawType() == QrisTciCoConfigResult.class) {
                return new AppCategory(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused39) {
        }
        try {
            if (typeToken.getRawType() == H5ShareData.class) {
                return new setBackgroundTime(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused40) {
        }
        try {
            if (typeToken.getRawType() == SenderDetail.class) {
                return new calcCaptureRect(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused41) {
        }
        try {
            if (typeToken.getRawType() == CancellationSurveyConfigModel.class) {
                return new getStackFromEnd(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused42) {
        }
        try {
            if (typeToken.getRawType() == ExternalStorage.class) {
                return new getNewPassword(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused43) {
        }
        try {
            if (typeToken.getRawType() == MobileEnvInfoWithCity.class) {
                return new checkMarmotConfig(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused44) {
        }
        try {
            if (typeToken.getRawType() == DigitalMoneyResult.class) {
                return new longitude(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused45) {
        }
        try {
            if (typeToken.getRawType() == SmartFrictionConfig.class) {
                return new OrAudience(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused46) {
        }
        try {
            if (typeToken.getRawType() == FeatureHoldLoginConfig.class) {
                return new CreateFamilyAccountEntity(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused47) {
        }
        try {
            if (typeToken.getRawType() == BaseRpcRequest.class) {
                return new DatabaseTableConfigUtil(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused48) {
        }
        try {
            if (typeToken.getRawType() == HelpButtonConfig.class) {
                return new FloatPoint(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused49) {
        }
        try {
            if (typeToken.getRawType() == TransactionHistoryConfigEntity.class) {
                return new flow(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused50) {
        }
        try {
            if (typeToken.getRawType() == SavingBenefitEntity.class) {
                return new CreateCredentialCustomException(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused51) {
        }
        try {
            if (typeToken.getRawType() == MoneyViewModel.class) {
                return new QuickBuyBillsAdapter$onQuickBuyItemClickListener$1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused52) {
        }
        try {
            if (typeToken.getRawType() == IP.class) {
                return new DaggerKycAmlEddActivityComponent$KycAmlEddActivityComponentImpl$KycAmlEddRepositoryProvider(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused53) {
        }
        try {
            if (typeToken.getRawType() == LoanInfo.class) {
                return new getKybKaFilter(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused54) {
        }
        try {
            if (typeToken.getRawType() == ErrorHereResponse.class) {
                return new FontsContractCompat$FontRequestCallback(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused55) {
        }
        try {
            if (typeToken.getRawType() == UserConsentEntityRepository.EnIn.class) {
                return new getSharingAgreementIds(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused56) {
        }
        try {
            if (typeToken.getRawType() == CashierPaymentAutorouteConfigResult.class) {
                return new ISO8601Utils(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused57) {
        }
        try {
            if (typeToken.getRawType() == ReferralWidgetResult.class) {
                return new ListPopupWindow$Api29Impl(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused58) {
        }
        try {
            if (typeToken.getRawType() == NearbyAutoSearchConfig.class) {
                return new setValue(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused59) {
        }
        try {
            if (typeToken.getRawType() == GetPasskeyResponse.class) {
                return new setLastTelemetrySync(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused60) {
        }
        try {
            if (typeToken.getRawType() == PhotoTipsModel.class) {
                return new getMaxAppJavaHeapMemoryKb(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused61) {
        }
        try {
            if (typeToken.getRawType() == WalletV3Config.class) {
                return new notifyTakenPictureError(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused62) {
        }
        try {
            if (typeToken.getRawType() == BaseNetworkRpcResponse.class) {
                return new SpanSuppressionStrategy$3(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused63) {
        }
        try {
            if (typeToken.getRawType() == EmergencyNotificationConfig.class) {
                return new times(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused64) {
        }
        try {
            if (typeToken.getRawType() == JSApiWhitelistModel.class) {
                return new C$r8$lambda$gXtix1gdajL8EsNG4zKaNNB4Tb0(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused65) {
        }
        try {
            if (typeToken.getRawType() == ServiceHighlighted.class) {
                return new BridgeActivity(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused66) {
        }
        try {
            if (typeToken.getRawType() == KybInfoResult.class) {
                return new toContactAddress(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused67) {
        }
        try {
            if (typeToken.getRawType() == UserLocationPermissionPromptConfig.class) {
                return new Clause(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused68) {
        }
        try {
            if (typeToken.getRawType() == PromoAdsLocationConfigResponse.class) {
                return new DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused69) {
        }
        try {
            if (typeToken.getRawType() == SettingEntity.class) {
                return new QueryPayMethod(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused70) {
        }
        try {
            if (typeToken.getRawType() == QueryUserDataConfig.class) {
                return new WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused71) {
        }
        try {
            if (typeToken.getRawType() == Display.class) {
                return new parseLineAndAppendValue(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused72) {
        }
        try {
            if (typeToken.getRawType() == StartupConfig.class) {
                return new PaylaterRegistrationCooldownCache(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused73) {
        }
        try {
            if (typeToken.getRawType() == TwilioTimeoutConfigResult.class) {
                return new getNrCsiRsrq(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused74) {
        }
        try {
            if (typeToken.getRawType() == PromoCenterVersionResult.class) {
                return new VerifyPasswordFacade(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused75) {
        }
        try {
            if (typeToken.getRawType() == Cpu.class) {
                return new C$r8$lambda$7v3KTaJFlJz89NRMIclzm3mWc(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused76) {
        }
        try {
            if (typeToken.getRawType() == PinRegularChangesConfig.class) {
                return new MyBillsActivity$provideServicesModule$1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused77) {
        }
        try {
            if (typeToken.getRawType() == MoneyViewEntity.class) {
                return new getBackgroundScanPeriod(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused78) {
        }
        try {
            if (typeToken.getRawType() == GlobalSearchConfigResponse.class) {
                return new OtpChallengeUIState$VerifyInvalidOtp(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused79) {
        }
        try {
            if (typeToken.getRawType() == ResultError.class) {
                return new getAuthRequestContext(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused80) {
        }
        try {
            if (typeToken.getRawType() == YMBotEventResponse.class) {
                return new getExceptionOrNull(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused81) {
        }
        try {
            if (typeToken.getRawType() == SysFeature.class) {
                return new throwNpe(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused82) {
        }
        try {
            if (typeToken.getRawType() == NearbyTrendingKeywordEntity.class) {
                return new getWalletV3RecommendationConfig$lambda193(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused83) {
        }
        try {
            if (typeToken.getRawType() == CitcallPermissionConfig.class) {
                return new FamilyDashboardPresenter_Factory(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused84) {
        }
        try {
            if (typeToken.getRawType() == DealsConfigResult.class) {
                return new doCommonLog(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused85) {
        }
        try {
            if (typeToken.getRawType() == CashierMerchantWhitelistConfigResult.class) {
                return new TwilioRepository(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused86) {
        }
        try {
            if (typeToken.getRawType() == SeamlessData.class) {
                return new CreateOrderTopUpFamilyBalance(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused87) {
        }
        try {
            if (typeToken.getRawType() == Memory.class) {
                return new createOauthGrantLoadingIntent(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused88) {
        }
        try {
            if (typeToken.getRawType() == HereConfigResponse.class) {
                return new TimeoutError(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused89) {
        }
        try {
            if (typeToken.getRawType() == SocialFeedModelEntityData.class) {
                return new CreateRemoteWorkerExtension(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused90) {
        }
        try {
            if (typeToken.getRawType() == BillerX2BEntity.class) {
                return new C$r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused91) {
        }
        try {
            if (typeToken.getRawType() == RiskTrackerConfigEntity.class) {
                return new MultiLanguageHttpClient(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused92) {
        }
        try {
            if (typeToken.getRawType() == GeofenceConfigResult.class) {
                return new allowedTargets(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused93) {
        }
        try {
            if (typeToken.getRawType() == CashierCurrencyFromCdnResult.class) {
                return new setValuePrefixBytes(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused94) {
        }
        try {
            if (typeToken.getRawType() == GnAuthResult.class) {
                return new onGetActiveNotifications(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused95) {
        }
        try {
            if (typeToken.getRawType() == Version.class) {
                return new access$setGoToMyLocationVisibility(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused96) {
        }
        try {
            if (typeToken.getRawType() == SavingLimitEntity.class) {
                return new buildStats(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused97) {
        }
        try {
            if (typeToken.getRawType() == NearbyConfigResult.class) {
                return new getNrCsiRsrp(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused98) {
        }
        try {
            if (typeToken.getRawType() == CreateSubscriptionExtendInfoEntity.class) {
                return new clearName(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused99) {
        }
        try {
            if (typeToken.getRawType() == MainEmptyStateEntity.class) {
                return new SourceParamUtil$DanaKagetClaimSource(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused100) {
        }
        try {
            if (typeToken.getRawType() == ExpressPurchaseModel.Paylater.BenefitContent.class) {
                return new LimitedDispatcher(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused101) {
        }
        try {
            if (typeToken.getRawType() == Wifi.class) {
                return new MatrixEvaluator(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused102) {
        }
        try {
            if (typeToken.getRawType() == NearbyMigrateApiResult.class) {
                return new setAkuEntranceOpen(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused103) {
        }
        try {
            if (typeToken.getRawType() == DefaultResponse.class) {
                return new sipHash24(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused104) {
        }
        try {
            if (typeToken.getRawType() == ReferralDialogDailyLimitEntity.class) {
                return new onCubeAppPerfEvent(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused105) {
        }
        try {
            if (typeToken.getRawType() == StartupConfigEntity.class) {
                return new glVertexAttrib1fv(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused106) {
        }
        try {
            if (typeToken.getRawType() == MerchantCategoryContentResult.class) {
                return new SplitReferralConfigEntityData_Factory(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused107) {
        }
        try {
            if (typeToken.getRawType() == TimeLocation.class) {
                return new NetworkMerchantInfoEntityData_Factory(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused108) {
        }
        try {
            if (typeToken.getRawType() == WalletV3RecommendationConfig.class) {
                return new NearbySearchPresenter$getNearbyTrendingKeyword$1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused109) {
        }
        try {
            if (typeToken.getRawType() == ContactSyncConfigResult.class) {
                return new getSavingConfigPresenter(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused110) {
        }
        try {
            if (typeToken.getRawType() == MockGlobalNetworkEntityData$$ExternalSyntheticLambda0.class) {
                return new ViewInputOtpBinding(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused111) {
        }
        try {
            if (typeToken.getRawType() == LinkInfo.class) {
                return new setDistrictAdcode(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused112) {
        }
        try {
            if (typeToken.getRawType() == AnbuConfig.class) {
                return new ItemSnapshotList(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused113) {
        }
        try {
            if (typeToken.getRawType() == UgcConfigResult.class) {
                return new getTypeMappings(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused114) {
        }
        try {
            if (typeToken.getRawType() == ExtendInfoQuerySubscriptionResult.class) {
                return new FalconFacade$FalconImageCutProxy(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused115) {
        }
        try {
            if (typeToken.getRawType() == OAuthResult.class) {
                return new getErrorConfigVersion(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused116) {
        }
        try {
            if (typeToken.getRawType() == SplunkConfig.class) {
                return new clearStatesNotIn(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused117) {
        }
        try {
            if (typeToken.getRawType() == ThirdPartyEntity.class) {
                return new itemClicked$core(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused118) {
        }
        try {
            if (typeToken.getRawType() == SupportedCardsConfigEntity.class) {
                return new getOpPackageName(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused119) {
        }
        try {
            if (typeToken.getRawType() == MarmotDanaPromotionResponse.class) {
                return new NavigationMenuPresenter$HeaderViewHolder(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused120) {
        }
        try {
            if (typeToken.getRawType() == Attributes.class) {
                return new createSecondaryAnimatorProvider(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused121) {
        }
        try {
            if (typeToken.getRawType() == PayQueryResponse.class) {
                return new ContentDeliveryCacheEntityDataFactory(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused122) {
        }
        try {
            if (typeToken.getRawType() == RetryConfig.class) {
                return new DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused123) {
        }
        try {
            if (typeToken.getRawType() == Device.class) {
                return new GetFriendsFeedWithInitFeedAndFeatureCheck(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused124) {
        }
        try {
            if (typeToken.getRawType() == BannerConfigResult.class) {
                return new connectionSpecs(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused125) {
        }
        try {
            if (typeToken.getRawType() == Rules.class) {
                return new TrustedListenableFutureTask$TrustedFutureInterruptibleAsyncTask(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused126) {
        }
        try {
            if (typeToken.getRawType() == RecommendationConfigKey.class) {
                return new setNewRibbon(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused127) {
        }
        try {
            if (typeToken.getRawType() == DanaProtectionHomeWidgetInfoModel.class) {
                return new setBackgroundTint(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused128) {
        }
        try {
            if (typeToken.getRawType() == PopularPlaceInfo.class) {
                return new ThreadLocalKey(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused129) {
        }
        try {
            if (typeToken.getRawType() == BannerEntity.class) {
                return new SplitSavingConfigEntityData(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused130) {
        }
        try {
            if (typeToken.getRawType() == AddPayMethod.class) {
                return new GifDrawableTransformation(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused131) {
        }
        try {
            if (OAuthCodeFlowType.class.isAssignableFrom(typeToken.getRawType())) {
                return new KClassImpl$Data$declaredNonStaticMembers$2(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused132) {
        }
        try {
            if (typeToken.getRawType() == MobileEnvInfo.class) {
                return new scheduleImpl(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused133) {
        }
        try {
            if (typeToken.getRawType() == HelpButtonChatBot.class) {
                return new LinearSmoothScroller(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused134) {
        }
        try {
            if (typeToken.getRawType() == GetPasskeyResponse.Response.class) {
                return new getSchemeBytes(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused135) {
        }
        try {
            if (typeToken.getRawType() == UserConsentEntityRepository.UserConsentAgreementContent.class) {
                return new SeekBarStopChangeEvent(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused136) {
        }
        try {
            if (typeToken.getRawType() == DiagnosticLogConfig.class) {
                return new getDirName(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused137) {
        }
        try {
            if (typeToken.getRawType() == BaseRpcResult.class) {
                return new NetworkUserEntityData$$ExternalSyntheticLambda1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused138) {
        }
        try {
            if (typeToken.getRawType() == MerchantConfigEntity.class) {
                return new TrustRiskLogin$Params(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused139) {
        }
        try {
            if (typeToken.getRawType() == FeedConfig.class) {
                return new AttributeView(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused140) {
        }
        try {
            if (typeToken.getRawType() == MobileLocationInfoWithCity.class) {
                return new PrefetchDownloadStatus(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused141) {
        }
        try {
            if (typeToken.getRawType() == WalletConfig.class) {
                return new setAmountToSent(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused142) {
        }
        try {
            if (typeToken.getRawType() == HelpButtonOtpLimitDevice.class) {
                return new roundToPowerOfTwo(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused143) {
        }
        try {
            if (typeToken.getRawType() == DanaProtectionInfoResult.class) {
                return new FamilyManageAvailableServicesAdapter(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused144) {
        }
        try {
            if (typeToken.getRawType() == QueryCredentialInfoResult.class) {
                return new BarcodeUtil$$ExternalSyntheticLambda1(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused145) {
        }
        try {
            if (typeToken.getRawType() == GlobalSearchWidgetResponse.class) {
                return new getOnCreateTime(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused146) {
        }
        try {
            if (typeToken.getRawType() == ExplorePromoConfigResponse.class) {
                return new isNeedUpload(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused147) {
        }
        try {
            if (typeToken.getRawType() == SkuAttributeEntity.class) {
                return new ImageCaptureViewModel$getTipUploadPhoto$2(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused148) {
        }
        try {
            if (typeToken.getRawType() == UserConsentEntityRepository.UserConsentThreshold.class) {
                return new onLoadComplete(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused149) {
        }
        try {
            if (typeToken.getRawType() == SendMoneyScenarioEntity.class) {
                return new initResult(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused150) {
        }
        try {
            if (typeToken.getRawType() == PersonalizedReferralConfig.class) {
                return new addAutoLogActivity(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused151) {
        }
        try {
            if (typeToken.getRawType() == LoginRegisterConfigResult.class) {
                return new SightCameraView$ICameraFrameListener(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused152) {
        }
        try {
            if (typeToken.getRawType() == Content.class) {
                return new getMessaging(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused153) {
        }
        try {
            if (typeToken.getRawType() == JSApiRuleModel.class) {
                return new C$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM(gson, PlaceComponentResult, getAuthRequestContext);
            }
        } catch (NoClassDefFoundError unused154) {
        }
        try {
            if (typeToken.getRawType() == Bluetooth.class) {
                return new getHashMap(gson, PlaceComponentResult, getAuthRequestContext);
            }
            return null;
        } catch (NoClassDefFoundError unused155) {
            return null;
        }
    }
}
