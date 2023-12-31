package id.dana.utils.foundation.logger.log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes9.dex */
public class DanaLogConstants {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BizType {
        public static final String AKULAKU = "akulaku";
        public static final String BRANCH_DEEPLINK_GENERATION = "branch_deeplink_generation";
        public static final String CASHIER = "cashier";
        public static final String CDP = "cdp";
        public static final String CONTACT_SYNC = "contactSync";
        public static final String DANA_CAMERA = "[DANACamera]";
        public static final String DEVICE_INFO = "deviceInfo";
        public static final String DONATION_WIDGET = "[donationWidget]";
        public static final String F2FPAY = "f2fpay";
        public static final String FACE_LOGIN = "faceLogin";
        public static final String FEEDS = "feeds";
        public static final String FUND_SOURCE = "skywalker_fund_source";
        public static final String GLOBAL_NETWORK = "globalNetwork";
        public static final String H5APHOME_REQUEST = "h5aphomerequest";
        public static final String KYC_RENEWAL = "kyc_renewal";
        public static final String LOGIN = "login";
        public static final String LOGOUT = "logout";
        public static final String MESSAGECENTER = "messagecenter";
        public static final String OAUTH = "[oauth]";
        public static final String OPEN_BANK = "[openBank]";
        public static final String PROMO_CENTER = "promoCenter";
        public static final String PUSH_NOTIFICATION = "push_notification";
        public static final String REGISTER = "register";
        public static final String RPC = "rpc";
        public static final String SAVE_RECENT_BANK = "saveRecentBank";
        public static final String SAVE_RECENT_CONTACT = "saveRecentContact";
        public static final String SAVE_RECENT_GROUP = "saveRecentGroup";
        public static final String SECURITY_SETTINGS = "securitysettings";
        public static final String SUBMIT_KYC_AML_EDD = "submit_kyc_aml_edd";
        public static final String TOPUP = "topup";
        public static final String TRANSFER_MONEY = "transfermoney";
        public static final String TRANSIT = "transit";
        public static final String UNKNOWN_BIZTYPE = "unknownbiztype";
        public static final String URL_ENCODE = "urlEncode";
        public static final String WITHDRAW = "withdraw";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ExceptionType {
        public static final String APHOME_HOLDLOGIN_FAIL_EXCEPTION = "dana_aphome_holdlogin_fail";
        public static final String CARD_BINDING_EXCEPTION = "card_binding_exception";
        public static final String CASHIER_NATIVE_EXCEPTION = "cashier_native_fail";
        public static final String CONTACT_SYNC_EXCEPTION = "contact_sync_fail";
        public static final String DEEPLINK_BRANCH_FAIL = "deeplink_branch-fail";
        public static final String DONATION_CAMPAIGN_EXCEPTION = "donation_campaign_fail";
        public static final String DOWNLOAD_FILE_FAIL = "download_file_to_plugin_fail";
        public static final String FACE_ENROL_EXCEPTION = "face_enrol_fail";
        public static final String FACE_LOGIN_EXCEPTION = "face_login_fail";
        public static final String GENERAL_ERROR_EXCEPTION = ":onError ";
        public static final String GET_USER_INFO_EXCEPTION = "get_user_info_fail";
        public static final String GLOBAL_NETWORK_EXCEPTION = "global_network_fail";
        public static final String GROUP_SEND_EXCEPTION = "group_send_fail";
        public static final String HOLDLOGIN_EXCEPTION = "dana_holdlogin_fail";
        public static final String INSTALLED_APP = "installed_app";
        public static final String LIFESTYLE_EXCEPTION = "lifestyle_fail";
        public static final String LOGIN_EXCEPTION = "dana_login_fail";
        public static final String LOGOUT_EXCEPTION = "logout_fail";
        public static final String MERCHANT_MANAGEMENT_EXCEPTION = "merchant_management_fail";
        public static final String MISSION_DETAIL_DEEPLINK_EXCEPTION = "mission_detail_deeplink_fail";
        public static final String MIXPANEL_MESSAGE_EXCEPTION = "To track data of mixpanel error";
        public static final String NAMECHECK_EXCEPTION = "dana_namecheck_fail";
        public static final String NEARBY_EXCEPTION = "nearby_fail";
        public static final String OAUTH_EXCEPTION = "oauth_fail";
        public static final String PAYMENT_AUTH_EXCEPTION = "payment_auth_fail";
        public static final String PROMO_CENTER_EXCEPTION = "promo_center_fail";
        public static final String PROMO_QUEST_EXCEPTION = "promo_quest_fail";
        public static final String REFERRAL_EXCEPTION = "referral_fail";
        public static final String REGISTER_EXCEPTION = "dana_register_fail";
        public static final String SAVE_RECENT_TRANSACTION_EXCEPTION = "save_recent_transaction_fail";
        public static final String SECURITY_SETTING_QUERY_EXCEPTION = "security_setting_query_fail";
        public static final String SPLIT_BILL_EXCEPTION = "split_bill_fail";
        public static final String STATEMENT_SCREENSHOT_EXCEPTION = "statement_screenshot_fail";
        public static final String UNKNOWN_EXCEPTION = "dana_unknown_fail";
        public static final String URL_ENCODE_EXCEPTION = "url_encode_fail";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Prefix {
        public static final String APPCONTAINER_UPDATE_SUBAPP_PREFIX = "[AppContainerUpdateSubApp]";
        public static final String APPLY_PROMO_CODE = "[ApplyPromoCode]";
        public static final String AUTO_ROUTE_INIT = "[AutoRouteInit]";
        public static final String AUTO_ROUTE_SWITCH = "[AutoRouteSwitch]";
        public static final String BOKU_REGISTER_PREFIX = "[BokuRegister]";
        public static final String CARD_BINDING_SUPPORTED_CARDS = "[CardBindingSupportedCards]";
        public static final String CARD_BINDING_TUTORIAL_FIRST_TIMER = "[CardBindingTutorialFirstTimer]";
        public static final String CASHIER_CHECKOUT_MAIN = "[CheckoutCashierMain]";
        public static final String CASHIER_CHECK_PAYLATER_CICIL_REGISTRATION_COOLDOWN_COUNT = "[CashierCheckPaylaterCicilRegistrationCacheCooldownCount]";
        public static final String CASHIER_CREATE_ORDER = "[CashierCreateOrder]";
        public static final String CASHIER_GET_KYB_PRODUCT = "[CashierGetKybProduct]";
        public static final String CASHIER_GET_LOAN_REGISTRATION_INFO = "[CashierGetLoanRegistrationInfo]";
        public static final String CASHIER_GET_PAYLATER_CICIL_AGREEMENT = "[CashierGetPaylaterCicilAgreement]";
        public static final String CASHIER_GET_SHOW_PAYLATER_CICIL_ONBOARDING = "[CashierGetShowPaylaterCicilOnboarding]";
        public static final String CASHIER_HIGHLIGHT_CACHE = "[CashierHighlightCache]";
        public static final String CASHIER_HIGHLIGHT_CONFIG = "[CashierHighlightConfig]";
        public static final String CASHIER_HIGHLIGHT_NEW_SHOWN = "[CashierHighlightNewShown]";
        public static final String CASHIER_HIGHLIGHT_VERSION = "[CashierHighlightVersion]";
        public static final String CASHIER_IS_SHOW_PAYLATER_CICIL_ONBOARDING = "[CashierIsShowPaylaterCicilOnboarding]";
        public static final String CASHIER_PAY = "[CashierPay]";
        public static final String CASHIER_RIBBON_HIGHLIGHT_TIME_SHOWN = "[CashierRibbonHighlightTimeShown]";
        public static final String CASHIER_SAVE_PAYLATER_CICIL_REGISTRATION_COOLDOWN_COUNT = "[CashierSavePaylaterCicilRegistrationCacheCooldownCount]";
        public static final String CASHIER_SAVE_PAYLATER_CICIL_REGISTRATION_COOLDOWN_DELAY_TIME = "[CashierSavePaylaterCicilRegistrationCacheCooldownDelay]";
        public static final String CASHIER_SAVE_SHOW_PAYLATER_CICIL_ONBOARDING = "[CashierSaveShowPaylaterCicilOnboarding]";
        public static final String CASHIER_SHARE_TRANSACTION = "[CashierShareTransaction]";
        public static final String CASHIER_UPDATE_ORDER = "[CashierUpdateOrder]";
        public static final String CATEGORY_LIFESTYLE_PREFIX = "[CategoryLifestyle]";
        public static final String CHECK_CASHIER_MERCHANT_WL = "[CheckCashierMerchantWhitelist]";
        public static final String CHECK_FEATURE_CASHIER = "[CheckFeatureCashier]";
        public static final String CHECK_FEATURE_CASHIER_DEEPLINK_KYB = "[CheckFeatureCashierDeeplinkKyb]";
        public static final String CHECK_REGISTERED_PHONE_NUMBER_PREFIX = "[CheckRegisteredPhoneNumber] ";
        public static final String CLOSE_SPLIT_BILL_PAYER = "[CloseSplitBillPayer]";
        public static final String CONFIRM_PIN_REGISTER_PREFIX = "[ConfirmPinAndRegister]";
        public static final String CONSULT_AND_OPEN_ELECTRONICMONEY = "[ConsultAndOpenElectronicmoney]";
        public static final String CONSULT_AND_OPEN_MINI_PROGRAM = "[ConsultAndOpenMiniProgram]";
        public static final String CONSULT_UNBIND_MERCHANT = "[ConsultUnbindMerchant]";
        public static final String CONTACT_SYNC_PREFIX = "[ContactSync]";
        public static final String COPY_CLIPBOARD = "[CopyToClipboard]";
        public static final String DEEPLINK_PREFIX = "[DeepLink]";
        public static final String DEEPLINK_PROFILE_QR = "[DeepLinkProfileQr]";
        public static final String DOWNLOAD_FILE_PLUGIN_PREFIX = "[AppContainerDownloadFilePlugin]";
        public static final String FAMILY_ACCOUNT_INVITE = "[FamilyAccountInvite]";
        public static final String FAMILY_ACCOUNT_JOIN = "[FamilyAccountJoin]";
        public static final String FAMILY_ACCOUNT_REMOVE = "[FamilyAccountRemove]";
        public static final String FAMILY_ACCOUNT_REMOVE_MEMBER = "[FamilyAccountRemoveMember]";
        public static final String FAMILY_ACCOUNT_RESEND_INVITE = "[FamilyAccountResendInvite]";
        public static final String FAMILY_APPROVE_SEND_MONEY = "[FamilyApproveSendMoney]";
        public static final String FAMILY_REJECT_SEND_MONEY = "[FamilyRejectSendMoney]";
        public static final String FAVORITE_SERVICES_LIFESTYLE_PREFIX = "[FavoriteServicesLifestyle]";
        public static final String FEED_COMMENT = "[FeedComment]";
        public static final String FEED_INPUT_COMMENT_PREFIX = "[FeedInputComment]";
        public static final String FEED_NOTIFICATION = "[FeedNotification]";
        public static final String FETCH_BANNER = "[FetchBanner]";
        public static final String FETCH_NPS_SURVEY = "[FetchNpsSurvey]";
        public static final String GET_ACTIVE_MISSIONS = "[GetActiveMissions]";
        public static final String GET_CASHIER_NATIVE_CONFIG = "[GetCashierNativeConfig]";
        public static final String GET_CLIENTKEY_PREFIX = "[GetClientKey]";
        public static final String GET_LINKED_MERCHANTS = "[GetLinkedMerchants]";
        public static final String GET_MISSIONS = "[GetMissions]";
        public static final String GET_MISSION_SUMMARIES = "[GetMissionSummary]";
        public static final String GET_MORE_LINKED_MERCHANTS = "[GetMoreLinkedMerchants]";
        public static final String GET_NEARBY_PROMO = "[GetNearbyPromo]";
        public static final String GET_ON_BOARDING_PREFIX = "[GetBottomOnBoarding]";
        public static final String GET_PAST_MISSIONS = "[GetMissionsWithQuestByStatus]";
        public static final String GET_SPLIT_BILL_DETAIL = "[GetSplitBillDetail]";
        public static final String GET_SPLIT_BILL_HISTORIES_PREFIX = "[GetSplitBillHistories]";
        public static final String HOLDLOGIN_PREFIX = "[HoldLogin] ";
        public static final String HOME_GETHOMEINFO_PREFIX = "[GetHOMEInfo]";
        public static final String HOME_GETPOCKET_PREFIX = "[GetPocketNumber]";
        public static final String INIT_PAYMENT_CONTROL = "[InitPaymentControl]";
        public static final String INSTALLED_APP = "[InstalledApp]";
        public static final String IS_NEED_TO_SHOW_SMARTPAY_DIALOG = "[IsNeedToShowSmartpayDialog]";
        public static final String IS_NEED_TO_SHOW_TOOLTIP_PREFIX = "[IsNeedToShowTooltip]";
        public static final String LOAN_CREDIT = "[LoanCredit]";
        public static final String LOAN_PERSONAL = "[LoanPersonal]";
        public static final String LOAN_WHITELIST = "[LoanWhitelist]";
        public static final String MIX_PAYMENT_CONFIG = "[CheckMixPaymentFeature]";
        public static final String NAME_CHECK = "[NameCheck]";
        public static final String OTPLOGIN_PREFIX = "[OtpLogin] ";
        public static final String OTP_AUTH_AGREEMENT_PREFIX = "[OtpAuthAgreement] ";
        public static final String OTP_CARD_BINDING_PREFIX = "[OtpCardBinding]";
        public static final String OTP_CASHIER_PREFIX = "[OtpCashier]";
        public static final String OTP_REGISTER_PREFIX = "[OtpRegister] ";
        public static final String OTP_TWILIO_PREFIX = "[OtpTwilio] ";
        public static final String PAYLATER_CHANNEL = "[PaylaterChannel]";
        public static final String PAYLATER_CICIL_METHOD_CONFIG = "[PayLaterCicilMethodConfig]";
        public static final String PAY_QUERY = "[PayQuery]";
        public static final String PINLOGIN_PREFIX = "[PinLogin] ";
        public static final String PREVIEW_ACTIVITY_PREFIX = "[PreviewActivity]";
        public static final String PROFILE_GETAVATARURL_PREFIX = "[GetAvatarUrl]";
        public static final String PROFILE_GETSECURITYQUESTIONSTATE_PREFIX = "[GetSecurityQuestionState]";
        public static final String PROFILE_GETUSEREMAILADDRESS_PREFIX = "[GetUserEmailAddress]";
        public static final String PROFILE_GETUSERINFO_PREFIX = "[ProfileGetUserInfo]";
        public static final String PROFILE_UPLOADAVATARURL_PREFIX = "[UploadAvatarUrl]";
        public static final String PROFILE_USERNAME_PREFIX = "[ProfileUsername]";
        public static final String PROMO_CENTER_GET_CATEGORIZED_PROMO_PREFIX = "[GetCategorizedPromo]";
        public static final String PROMO_CENTER_GET_CATEGORY_LIST_PREFIX = "[GetPromoCategoryList]";
        public static final String PROMO_CENTER_GET_PROMO_LIST_PREFIX = "[GetPromoList]";
        public static final String QRCODE_CHANGE_PAY_METHOD_PREFIX = "[ChangePayMethod]";
        public static final String QRCODE_GENERATE_PREFIX = "[QrcodeGenerate]";
        public static final String QRCODE_INIT_PREFIX = "[QrcodeInit]";
        public static final String QRCODE_PAY_RESULT_PREFIX = "[PayResult]";
        public static final String QRCODE_QUERY_PAY_METHOD_PREFIX = "[QUERYPayMethod]";
        public static final String REFERRAL_CONSULT = "[GetReferralConsult]";
        public static final String REFERRAL_GET_HOME_REFERRAL_BANNER = "[GetHomeReferralBanner]";
        public static final String REFERRAL_GET_HOME_REFERRAL_P2P_BANNER = "[GetHomeReferralP2PBanner]";
        public static final String REFERRAL_GET_REFERRAL_HOME_CONFIG = "[GetReferralHomeConfig]";
        public static final String REFERRAL_GET_REFERRAL_STATUS_CONSULT = "[GetReferralStatusConsult]";
        public static final String REFERRAL_MESSAGE_TEMPLATE = "[GetReferralMessageTemplate]";
        public static final String REQUEST_MONEY_BANK_QR_PREFIX = "[RequestMoneyBankQrCode]";
        public static final String REQUEST_MONEY_HOMEINFO_PREFIX = "[RequestMoneyGetHOMEInfo]";
        public static final String REQUEST_MONEY_QR_PREFIX = "[RequestMoneyQrCode]";
        public static final String SAVE_ON_BOARDING_PREFIX = "[SaveBottomOnBoarding]";
        public static final String SAVE_SHOW_TOOLTIP_PREFIX = "[SaveShowTooltip]";
        public static final String SCAN_QRCODE_PREFIX = "[ScanQr]";
        public static final String SEND_MONEY_CONFIRMATION_PREFIX = "[SendMoneyConfirmation]";
        public static final String SERVICES_LIFESTYLE_PREFIX = "[ServicesLifestyle]";
        public static final String SET_CLIENTKEY_PREFIX = "[SetClientKey]";
        public static final String SHARE_FEED_ACTIVITY_PREFIX = "[ShareFeedActivity]";
        public static final String SOCIAL_SHARE_INTENT_PREFIX = "[IntentSocialShare]";
        public static final String SPLIT_BILL_DEEPLINK_PREFIX = "[SplitBillDeepLink]";
        public static final String STATIC_QRCODE_PREFIX = "[StaticQr]";
        public static final String SUBMIT_NPS_SURVEY = "[SubmitNpsSurvey]";
        public static final String SWITCH_FACE_AUTHENTICATION_PREFIX = "[SwitchFaceAuthentication]";
        public static final String SWITCH_PAYMENT_CONTROL = "[SwitchPaymentControl]";
        public static final String TAKE_PICTURE = "[TakePicture]";
        public static final String UAP_FACE_AUTHENTICATION_PREFIX = "[UAPFaceAuthentication]";
        public static final String UNBIND_MERCHANT = "[UnbindMerchant]";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PushPermissionStatus {
        public static final String PUSH_DISABLED = "denied";
        public static final String PUSH_ENABLED = "authorized";
        public static final String STATUS = "status";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SeedId {
        public static final String PUSH_CLICKED = "MPPush_Push_Open";
        public static final String PUSH_PERMISSION = "MPPush_Notification_Status";
        public static final String PUSH_RECEIVED = "MPPush_Notification_Arrived";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface TAG {
        public static final String ACTIVITY_REACTIONS = "ActivityReactions";
        public static final String AKULAKU_TAG = "Akulaku";
        public static final String APPCONTAINER_SUBAPP_TAG = "AppContainerSubapp";
        public static final String APP_READY = "AppReady";
        public static final String AUTH_AGREEMENT_OTP_TAG = "AuthAgreementOtpChallenge";
        public static final String AUTO_ROUTE_SWITCH = "SwitchAutoRoute";
        public static final String BCA_WEBVIEW_INTERCEPT = "BcaWebviewIntercept";
        public static final String BEHAVIOR_TAG = "BehaviorLog";
        public static final String BOKU_LOGIN_TAG = "BokuLoginProcess";
        public static final String CANCEL_SURVEY_PRESENTER = "CancelSurveyPresenter";
        public static final String CARD_BINDING_TAG = "CardBinding";
        public static final String CASHIER_NATIVE = "CashierNative";
        public static final String CATEGORY_SERVICES = "CategoryServices";
        public static final String CHECKOUT = "Checkout";
        public static final String COMMON_TAG = "COMMONUtil";
        public static final String CONVERT_USER_CONFIG = "ConvertUserConfig";
        public static final String CREATE_FEED_ACTIVITY = "CreateFeedActivity";
        public static final String DANA_CAMERA = "DANACamera";
        public static final String DANA_PLUS = "DanaPlus";
        public static final String DATETIMEUTIL_TAG = "DateTimeUtil";
        public static final String DEEPLINK_SETTING_MORE_TAG = "DeeplinkSettingMore";
        public static final String DEEPLINK_TAG = "DeepLink";
        public static final String DELETE_FEED_ACTIVITY = "DeleteFeedActivity";
        public static final String DIAGNOSTIC_TAG = "DIAGNOSTICLog";
        public static final String DOWNLOAD_UTIL_TAG = "DownloadUtil";
        public static final String EMERGENCY_NOTIF = "EmergencyNotif";
        public static final String ENABLE_TLS_12_PRE_LOLLIPOP = "EnableTLS12PreLollipop";
        public static final String EXPRESS_PURCHASE_OFFER_PRODUCT_VIEW = "ExpressPurchaseOfferProductView";
        public static final String EXPRESS_PURCHASE_PRESENTER = "ExpressPurchasePresenter";
        public static final String FACE_LOGIN = "FaceLogin";
        public static final String FAMILY_ACCOUNT = "FamilyAccount";
        public static final String FCM_PUSH = "FCMPush";
        public static final String FEED_COMMENT = "FeedComment";
        public static final String FEED_INPUT_COMMENT = "FeedInputComment";
        public static final String FEED_NOTIFICATION = "FeedNotification";
        public static final String GEOCODE = "Geocode";
        public static final String GEOFENCE_TAG = "Geofence";
        public static final String GET_CATEGORY_EXPLORE_DANA_CONFIG = "GetCategoryExploreDanaConfig";
        public static final String GET_DEALS_CONFIG = "GetDealsConfig";
        public static final String GET_DEFAULT_FEED_FROM_CONFIG = "GetDefaultFeedFromConfig";
        public static final String GET_EXPLORE_POPULAR_PLACES_CONFIG = "GetExplorePopularPlaces";
        public static final String GET_EXPLORE_SERVICE = "GetExploreService";
        public static final String GET_FEEDS_REPORT_REASON = "GetFeedsReportReason";
        public static final String GET_FEED_CONFIG = "GetFeedConfig";
        public static final String GET_GLOBAL_SEARCH_CONFIG_TAG = "GetGlobalSearchConfig";
        public static final String GET_HOME_SEARCH_BAR = "GetHomeSearchBar";
        public static final String GET_IS_SYNC_PERMISSION = "GetIsSyncPermission";
        public static final String GET_KYB_NATIVE_CONFIG = "GetKybNativeConfig";
        public static final String GET_MARMOT_CONFIG = "GetMarmotConfig";
        public static final String GET_ME_PAGE_CONFIG = "GetProfileRevampConfig";
        public static final String GET_MUROTAL_CONFIG = "GetMurotalConfig";
        public static final String GET_ONLINE_MERCHANT = "GetOnlineMerchant";
        public static final String GET_ONLINE_MERCHANT_SEARCH = "GetOnlineMerchantSearch";
        public static final String GET_PREPAID_URL = "GetPrepaidUrl";
        public static final String GET_PREVENT_SCREENSHOT_CONFIG = "GetPreventScreenshotConfig";
        public static final String GET_PROFILE_CTA = "GetProfileCTA";
        public static final String GET_QRIS_PAYMENT_CONFIG = "GetQrisPaymentConfig";
        public static final String GET_SEND_MONEY_BANNER_SWITCH = "SendMoneyBannerSwitch";
        public static final String GET_SKU_EXPLORE = "GetSkuExplore";
        public static final String GET_SUBMITTED_USER_PREFERENCE = "GetSubmittedUserPreference";
        public static final String GET_SYNC_CONTACT_CONFIG = "GetSyncContactConfig";
        public static final String GET_SYNC_PERMISSION_CONFIG = "GetSyncPermissionConfig";
        public static final String GET_TRANSACTION_HISTORY_CONFIG = "GetTransactionHistoryConfig";
        public static final String GLOBAL_NETWORK = "GlobalNetwork";
        public static final String GLOBAL_SEARCH_TAG = "GlobalSearch";
        public static final String HIGHLIGHT_SWITCHING_RULES = "HighlightSwitchingRules";
        public static final String HOME_REFERRAL = "HomeReferral";
        public static final String HOME_TAG = "HOMETab";
        public static final String IMAGE_CAPTURE_GET_PHOTO_TIPS = "image_capture_get_photo_tips";
        public static final String INSTALLED_APP = "InstalledApp";
        public static final String INVESTMENT = "INVESTMENT";
        public static final String IPG_REGISTRATION_TAG = "IpgRegistration";
        public static final String JSONUTIL_TAG = "JSONUtil";
        public static final String JS_BRIDGE_TAG = "JsBridge";
        public static final String KYC_RENEWAL_TAG = "KycRenewal";
        public static final String LOGIN_TAG = "DanaLogin";
        public static final String MERCHANT_MANAGEMENT = "MerchantManagement";
        public static final String MERCHANT_REVIEW = "NearbyMeMerchantReview";
        public static final String MINI_PROGRAM = "MiniProgram";
        public static final String MISSION_DETAIL_TAG = "MissionDetail";
        public static final String MIXPANEL = "MixPanel";
        public static final String MIXPANEL_CARD_BINDING = "MixpanelCardBinding";
        public static final String MIXPANEL_CASHIER_NATIVE = "MixpanelCashierNative";
        public static final String MIXPANEL_EXPRESS_PURCHASE = "MixpanelExpressPurchase";
        public static final String MIXPANEL_IMAGE_CAPTURE = "MixpanelImageCapture";
        public static final String MIXPANEL_PASSIVE_BIOMETRIC = "MixpanelPassiveBiometric";
        public static final String MP_USER_INFO = "MP_GetUserInfo";
        public static final String NEARBY = "Nearby";
        public static final String NEARBY_HOME_SHOPPING = "NearbyHomeShopping";
        public static final String NEARBY_LOCATION = "NearbyLocationSearch";
        public static final String NEARBY_MERCHANT_SEARCH = "NearbyMerchantSearch";
        public static final String NEARBY_ME_MERCHANT_DETAIL = "NearbyMeMerchantDetail";
        public static final String OTP_CHALLENGE_TAG = "OtpChallenge";
        public static final String PAYLATER_BILL_DETAIL_VIEW = "PaylaterBillDetailView";
        public static final String PAYLATER_CASHIER_NATIVE = "PaylaterCashierNative";
        public static final String PAYLATER_CONSULT_LOAN_WHITELIST = "PayLaterConsultLoanWhitelist";
        public static final String PAYLATER_LOAN_CACHE = "PayLaterLoanCache";
        public static final String PAYMENT_SETTING_TAG = "HomePaymentSetting";
        public static final String PHONE_NUMBER_EMPTY_TAG = "PhoneNumberEmpty";
        public static final String PHONE_NUMBER_ONEPLUS_EMPTY_TAG = "PhoneNumberOneplusEmpty";
        public static final String PHONE_STATE_RECEIVER = "PhoneStateReceiver";
        public static final String PREFERENCE_ACCOUNT = "PreferenceAccount";
        public static final String PROFILE_TAG = "ProfileTab";
        public static final String PROMO_CENTER_BANNER = "PromoCenterBanner";
        public static final String PROMO_QUEST = "PromoQuest";
        public static final String QRCODE_TAG = "Qrcode";
        public static final String REFERRAL_TAG = "MyReferral";
        public static final String REGISTER_TAG = "DanaRegister";
        public static final String RELATIONSHIP = "Relationship";
        public static final String REQUEST_MONEY_TAG = "RequestMoney";
        public static final String SAVING = "Saving";
        public static final String SCANNER_FRAGMENT = "ScannerFragment";
        public static final String SELECTED_PAYER_TAG = "SelectedPayer";
        public static final String SENDMONEY_NAMECHECK_TAG = "SendMoneyNameCheck";
        public static final String SENDMONEY_SOCIAL_LINK_TAG = "SendMoneySocialLinks";
        public static final String SENDMONEY_TO_LINK_BANNER_TAG = "SendMoneyToLinkBanner";
        public static final String SEND_MONEY_CONFIRMATION_TAG = "SendMoneyConfirmation";
        public static final String SEND_MONEY_TAG = "SendMoney";
        public static final String SEND_MONEY_TO_BILLER_TAG = "SendMoneyToBiller";
        public static final String SEND_MONEY_TO_DIGITAL_WALLET_TAG = "SendMoneyToDigitalWallet";
        public static final String SHARE_FEED_ACTIVITY = "ShareFeedActivity";
        public static final String SHARE_TO_FEEDS_TAG = "ShareToFeeds";
        public static final String SHOWCASE_TARGET_TAG = "ShowcaseTarget";
        public static final String SIGN_CHECK = "SignCheck";
        public static final String SKIP_SHAREABLE_ACTIVITY = "SkipShareableActivity";
        public static final String SOCIAL_SHARE_TAG = "SocialShare";
        public static final String SPLIT = "Split";
        public static final String SPLIT_BILL_TAG = "SplitBill";
        public static final String STATEMENT = "Statement";
        public static final String SWITCH_FACE_AUTHENTICATION = "SwitchFaceAuthentication";
        public static final String SYNC_CONTACT_TAG = "SyncContact";
        public static final String TNC_CARD_PAYMENT = "TncCardPayment";
        public static final String TWILIO_CONSULT = "TwilioConsult";
        public static final String TWILIO_DELETE_LOCAL_FACTOR = "DeleteLocalFactorTwilio";
        public static final String TWILIO_DEROLL = "TwilioDeroll";
        public static final String TWILIO_GET_CHALLENGE = "TwilioGetChallenge";
        public static final String TWILIO_OTP_TAG = "TwilioOtpChallenge";
        public static final String TWILIO_PIN_TAG = "TwilioPinChallenge";
        public static final String TWILIO_REQUEST_CHALLENGE = "TwilioRequestChallenge";
        public static final String TWILIO_UPDATE_CHALLENGE = "TwilioUpdateChallenge";
        public static final String UAP_FACE_AUTHENTICATION = "UAPFaceAuthentication";
        public static final String USER_EDUCATION_TAG = "UserEducation";
        public static final String UTDID_UTIL_TAG = "UtdIdUtil";
    }

    private DanaLogConstants() {
    }
}
