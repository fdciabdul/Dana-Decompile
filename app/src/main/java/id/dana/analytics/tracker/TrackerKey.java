package id.dana.analytics.tracker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public interface TrackerKey {

    /* loaded from: classes3.dex */
    public @interface AccountLockProperty {
        public static final String ACTION = "Action";
        public static final String CALL_HELP = "Call Help";
        public static final String WAIT = "Wait";
    }

    /* loaded from: classes3.dex */
    public @interface AppStartProperty {
        public static final String APP_START_COLD = "Cold";
        public static final String APP_START_HOT = "Hot";
        public static final String APP_START_WARM = "Warm";
    }

    /* loaded from: classes3.dex */
    public @interface AppUpdateAction {
        public static final String APP_UPDATE_INSTALL = "Install";
        public static final String APP_UPDATE_LATER = "Later";
    }

    /* loaded from: classes3.dex */
    public @interface AppUpdateProperty {
        public static final String APP_UPDATE_ACTION = "App Update Action";
        public static final String APP_UPDATE_TYPE = "App Update Type";
        public static final String LATEST_APP_VERSION = "Latest App Version";
        public static final String VALID_APP_VERSION = "Valid App Version";
    }

    /* loaded from: classes3.dex */
    public @interface AppUpdateType {
        public static final String APP_UPDATE_FORCE = "Force";
        public static final String APP_UPDATE_OPTIONAL = "Optional";
    }

    /* loaded from: classes3.dex */
    public @interface BindingProperties {
        public static final String BIND_DURATION = "Bind Duration";
        public static final String FULL_BIND_DURATION = "Full Bind Duration";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String MERCHANT_SITE_NAME = "Merchant Site Name";
        public static final String PURPOSE = "Purpose";
        public static final String RISK_TYPE = "Risk Type";
        public static final String SUCCESS = "Success";
    }

    /* loaded from: classes3.dex */
    public @interface CancelSurveyProperties {
        public static final String CANCEL_REASON = "Cancel Reason";
    }

    /* loaded from: classes3.dex */
    public @interface CardBindingInputType {
        public static final String MANUAL_INPUT = "Manual Input";
        public static final String OCR = "OCR";
    }

    /* loaded from: classes3.dex */
    public @interface CardBindingProperties {
        public static final String API_TIME = "API Time";
        public static final String CARD_ACQUIRER = "Card Acquirer";
        public static final String CARD_BIN = "Card BIN";
        public static final String CARD_EXPIRY_INPUT_TYPE = "Card Expiry Date Input Type";
        public static final String CARD_NUMBER_INPUT_TYPE = "Card Number Input Type";
        public static final String CARD_ORDER_ID = "Card Order ID";
        public static final String EXECUTION_TIME = "Execution Time";
        public static final String INSTITUTION_NAME = "Institution Name";
        public static final String INST_ID = "Inst ID";
        public static final String PAYMENT_METHOD = "Payment Method";
        public static final String PROCESSING_TIME = "Processing Time";
        public static final String RENDER_TIME = "Render Time";
        public static final String SUCCESS = "Success";
    }

    /* loaded from: classes3.dex */
    public @interface CardBindingSourceType {
        public static final String QR = "QR";
        public static final String WALLET = "Wallet";
    }

    /* loaded from: classes3.dex */
    public @interface CashierProperties {
        public static final String ADD_ON_AVAILABLE = "Add On Available";
        public static final String ADD_ON_CHOOSABLE = "Add On Choosable";
        public static final String ADD_ON_CHOOSEN = "Add On Chosen";
        public static final String ADD_ON_DEFAULT_STATE = "Add On Default State";
        public static final String ADD_ON_DISPLAYABLE = "Add On Displayable";
        public static final String ADD_ON_GOODS = "Add On Goods";
        public static final String ADD_ON_NAME = "Add On Name";
        public static final String BANNER_NAME = "Banner Name";
        public static final String BIZ_ORDER_ID = "Biz Order ID";
        public static final String BUSINESS_TYPE_ID = "Business Type ID";
        public static final String CASHIER_ORDER_ID = "Cashier Order ID";
        public static final String CONFIRMATION_READY = "Confirmation Ready";
        public static final String DEFAULT_PAYMENT_METHOD = "Default Payment Method";
        public static final String EXECUTION_TIME = "Execution Time";
        public static final String FEATURE_EXECUTION_TIME = "Feature Execution Time";
        public static final String FEATURE_NAME = "Feature Name";
        public static final String FEATURE_PROCESSING_TIME = "Feature Processing Time";
        public static final String FEATURE_TIME = "Feature Time";
        public static final String INDEX_CHANNEL = "Index Channel";
        public static final String INSTITUTION_NAME = "Institution Name";
        public static final String IS_AUTOROUTING = "isAutorouting";
        public static final String IS_BALANCE_SUFFICIENT = "isBalanceSufficient";
        public static final String IS_DEEPLINK_PAYMENT = "Is Deeplink Payment";
        public static final String IS_FACE_VERIFICATION = "IsFaceVerification";
        public static final String IS_MIX_PAYMENT = "isMixPayment";
        public static final String IS_SAVE_CARD = "isSaveCard";
        public static final String IS_SHOW_PIN = "isShowPIN";
        public static final String IS_UPGRADE_CARD = "isUpgradeCard";
        public static final String MERCHANT_ID = "Merchant ID";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String PAYLATER_REPAYMENT_SOURCE = "Paylater Repayment Source";
        public static final String PAYMENT_METHOD = "Payment Method";
        public static final String PAYMENT_RESULT_ACTION = "Purpose";
        public static final String PAYMENT_STATUS = "Payment Status";
        public static final String PAY_QUERY_COUNT = "Pay Query Count";
        public static final String PROCESSING_TIME = "Processing Time";
        public static final String PRODUCT_CODE = "productCode";
        public static final String RISK_TYPE = "Risk Type";
        public static final String SMARTPAY_ACTIVATION_RESULT = "Smartpay Activation Result";
        public static final String TOP_UP_PAYMENT_METHOD = "Top Up Payment Method";
        public static final String TRANSACTION_SCHEMA = "Transaction Schema";
    }

    /* loaded from: classes3.dex */
    public @interface CashierResultActionType {
        public static final String CLOSE_OR_DONE = "Close / Done";
        public static final String SEE_DETAILS = "See Details";
    }

    /* loaded from: classes3.dex */
    public @interface CashierRiskType {
        public static final String FACE_VERIFICATION_CASHIER = "Face Verification cashier";
        public static final String OTP = "OTP";
        public static final String PIN = "PIN";
    }

    /* loaded from: classes3.dex */
    public @interface DanaBalanceRecipientTypeProperty {
        public static final String DANA = "DANA";
        public static final String OTHER = "Other";
        public static final String PHONE = "Phone";
    }

    /* loaded from: classes3.dex */
    public @interface DanaVizPurpose {
        public static final String ENROLL_DANA_VIZ = "Enroll DANA Viz";
        public static final String RISK_CHALLENGE = "Risk Challenge";
        public static final String TOGGLE_OFF_DANA_VIZ = "Toggle Off DANA Viz";
        public static final String TRANSFER_ACCOUNT_MATCHING = "Transfer Account Matching";
    }

    /* loaded from: classes3.dex */
    public @interface DanaVizSource {
        public static final String CASHIER = "Cashier";
        public static final String DANA_PROTECTION = "DANA_PROTECTION";
        public static final String GROUP_SEND = "Group Send";
        public static final String LOGIN = "Login";
        public static final String REGISTRATION = "Registration";
        public static final String SEND_MONEY = "Send Money";
        public static final String SMARTPAY = "SmartPay";
        public static final String TOP_UP = "TopUp";
        public static final String TRANSFER_ACCOUNT = "Transfer Account";
    }

    /* loaded from: classes3.dex */
    public @interface DanaWalletAddSource {
        public static final String ADD_WALLET_FINANCIAL = "Financials Empty Placeholder";
        public static final String ADD_WALLET_HOME = "DANA Wallet Home (the + button)";
        public static final String ADD_WALLET_IDENTITY = "Identity Empty Placeholder";
        public static final String ADD_WALLET_LOYALTY = "Loyalty Empty Placeholder";
        public static final String ADD_WALLET_PAYMENT = "Payment Empty Placeholder";
        public static final String ADD_WALLET_VOUCHER = "Vouchers Empty Placeholder";
    }

    /* loaded from: classes3.dex */
    public @interface DanaWalletProperties {
        public static final String ADD_SOURCE = "Add Source";
        public static final String DANA_WALLET = "DANA Wallet";
        public static final String DEALS_VERSION = "Deals Version";
        public static final String KEYWORD_SEARCHED = "Keyword Searched";
        public static final String SEARCH_OPEN_PAGE = "Search Open Page";
        public static final String SEARCH_SUBMIT_PAGE = "Search Submit Page";
        public static final String SEARCH_SUBMIT_TRIGGER_SOURCE = "Search Submit Trigger Source";
        public static final String SECTION_NAME = "Section Name";
    }

    /* loaded from: classes3.dex */
    public @interface DanaWalletSearchPageSource {
        public static final String GLOBAL_SEARCH = "Global Search";
        public static final String SECTION_FINANCIALS_SEARCH = "Section Financials Search";
        public static final String SECTION_IDENTITY_SEARCH = "Section Identity Search";
        public static final String SECTION_LOYALTY_SEARCH = "Section Loyalty Search";
        public static final String SECTION_PAYMENT_SEARCH = "Section Payment Search";
        public static final String SECTION_VOUCHERS_SEARCH = "Section Vouchers Search";
    }

    /* loaded from: classes3.dex */
    public @interface DanaWalletSectionName {
        public static final String WALLET_FINANCIAL = "Financials";
        public static final String WALLET_IDENTITY = "Identity";
        public static final String WALLET_LOYALTY = "Loyalty";
        public static final String WALLET_PAYMENT = "Payment";
        public static final String WALLET_VOUCHER = "Voucher";
    }

    /* loaded from: classes3.dex */
    public @interface DeeplinkProperty {
        public static final String ADDITIONAL_FLOW = "Additional Flow";
        public static final String FULL_URL = "Full Url";
        public static final String GET_PAYLOAD_DURATION = "Get Payload Duration";
        public static final String METHOD = "Method";
        public static final String PATH = "Path";
        public static final String REDIRECTION = "Redirection";
        public static final String SOURCE = "Source";
        public static final String SUCCESS = "Success";
        public static final String TOTAL_DURATION = "Total Duration";
    }

    /* loaded from: classes3.dex */
    public @interface DefaultMixpanel {
        public static final String DISTINCT_ID = "$mixpanel_distinct_id";
        public static final String DURATION = "$duration";
    }

    /* loaded from: classes3.dex */
    public @interface DefaultValue {
        public static final String DEFAULT_ERROR_CODE = "error_code_is_empty";
        public static final String DEFAULT_ERROR_MESSAGE = "error_message_is_empty";
    }

    /* loaded from: classes3.dex */
    public @interface ElectronicMoneyProperties {
        public static final String DISPLAYED_MESSAGE = "Displayed Message";
        public static final String EMONEY_TYPE = "Emoney Type";
        public static final String ERROR_CODE = "Error Code";
        public static final String ERROR_MESSAGE = "Error Message";
        public static final String OPERATION_TYPE = "Operation Type";
        public static final String PROVIDER_NAME = "Provider Name";
        public static final String RESULT = "Result";
        public static final String SOURCE = "Source";
        public static final String SOURCE_CLICK = "Source Click";
        public static final String STATUS_RESULT = "Status Result";
        public static final String TRACE_ID = "Trace ID";
    }

    /* loaded from: classes3.dex */
    public @interface Event {
        public static final String ACCESS_REQUEST_OPEN = "Access Request Open";
        public static final String ACCOUNT_BIND = "Account Bind";
        public static final String ACCOUNT_LOCK_HELP = "Account Lock Help";
        public static final String AC_PROCESS = "AlipayConnect Process";
        public static final String ADD_CARD_EXECUTION = "Add Card Execution";
        public static final String ADD_CARD_OPEN = "Add Card Open";
        public static final String ADD_CARD_RESULT = "Add Card Result";
        public static final String ADD_CARD_THIRD_PARTY_RISK_CHALLENGE = "Add Card Third Party Risk Challenge";
        public static final String ADD_NAME_COMPLETED = "Add Name Completed";
        public static final String ADD_NAME_OPEN = "Add Name Open";
        public static final String ADD_NAME_SKIP = "Add Name Skip";
        public static final String ALL_SERVICE_OPEN = "All Service Open";
        public static final String ALL_SERVICE_SEARCH_OPEN = "All Service Search Open";
        public static final String ANNOUNCEMENT_WIDGET_OPEN = "Announcement Widget Open";
        public static final String ANNOUNCEMENT_WIDGET_SHOW = "Announcement Widget Show";
        public static final String APP_READY = "App Ready";
        public static final String APP_START = "App Start";
        public static final String APP_TOTAL_LOGIN_TIME = "app_total_login_time";
        public static final String APP_TOTAL_REGISTRATION_TIME = "app_total_registration_time";
        public static final String APP_UPDATE = "App Update";
        public static final String AUTO_SWITCH_PAYMENT = "Auto Switch Payment";
        public static final String CANCEL_SURVEY_EXPRESS_PURCHASE = "Express Purchase Cancel Survey";
        public static final String CASHIER_FACEAUTH_CANCELLED = "cashier_faceauth_cancelled";
        public static final String CASHIER_FACEAUTH_FAILED = "cashier_faceauth_failed";
        public static final String CASHIER_FACEAUTH_SUCCESS = "cashier_faceauth_success";
        public static final String CASHIER_FACEAUTH_TIME = "cashier_faceauth_time";
        public static final String CITCALL_VERIFICATION_DURATION_REGISTRATION = "citcall_verification_duration_registration";
        public static final String CI_AUTHENTICATION = "CI Authentication";
        public static final String CI_COVERAGE_CHECKING = "CI Coverage Checking";
        public static final String DANA_CICIL_TNC_RELOAD = "DANA CICIL TnC Reload";
        public static final String DANA_CICIL_TOOLTIP_CLICK = "DANA CICIL tooltip click";
        public static final String DANA_CICIL_TOOLTIP_SHOWN = "DANA CICIL tooltip show";
        public static final String DANA_NEWS_OPEN = "DANA News Open";
        public static final String DANA_PROTECTION_FACEAUTH_CANCELLED = "dana_protection_faceauth_cancelled";
        public static final String DANA_PROTECTION_FACEAUTH_ENROLLMENT_CANCELLED = "dana_protection_faceauth_enrollment_cancelled";
        public static final String DANA_PROTECTION_FACEAUTH_ENROLLMENT_FAILED = "dana_protection_faceauth_enrollment_failed";
        public static final String DANA_PROTECTION_FACEAUTH_ENROLLMENT_SUCCESS = "dana_protection_faceauth_enrollment_success";
        public static final String DANA_PROTECTION_FACEAUTH_ENROLLMENT_TIME = "dana_protection_faceauth_enrollment_time";
        public static final String DANA_PROTECTION_FACEAUTH_FAILED = "dana_protection_faceauth_failed";
        public static final String DANA_PROTECTION_FACEAUTH_SUCCESS = "dana_protection_faceauth_success";
        public static final String DANA_PROTECTION_FACEAUTH_TIME = "dana_protection_faceauth_time";
        public static final String DANA_PROTECTION_WIDGET_CTA = "DANA Protection Widget CTA";
        public static final String DANA_SIAGA_CLAIM_DOCUMENT_SAMPLE_OPEN = "DANA Siaga Claim Document Sample Open";
        public static final String DANA_STATEMENT_DOWNLOAD = "DANA Statement download";
        public static final String DANA_STATEMENT_OPEN = "DANA Statement Open";
        public static final String DANA_VIZ_COMPLETED = "DANA Viz Completed";
        public static final String DANA_VIZ_OPEN = "DANA Viz Open";
        public static final String DANA_WALLET_ADD_ASSET_OPEN = "DANA Wallet Add Asset Open";
        public static final String DANA_WALLET_OPEN = "DANA Wallet Open";
        public static final String DANA_WALLET_SEARCH_BAR_OPEN = "DANA Wallet Search Bar Open";
        public static final String DANA_WALLET_SEARCH_BAR_SUBMIT = "DANA Wallet Search Bar Submit";
        public static final String DANA_WALLET_SECTION_OPEN = "DANA Wallet Section Open";
        public static final String DANA_WALLET_V3_OPEN = "DANA Wallet V3 Open";
        public static final String DEEPLINK_OPEN = "Deep Link Open ";
        public static final String DEEPLINK_REDIRECTION = "Deeplink Redirection ";
        public static final String ELECTRONIC_MONEY_ACTIVATE_BALANCE = "Emoney Activate Balance";
        public static final String ELECTRONIC_MONEY_UPDATE_BALANCE = "Electronic Money Update Balance";
        public static final String ELECTRONIC_MONEY_UPDATE_RESULT = "Electronic Money Update Result";
        public static final String EP_DEALS_BUY = "EP Deals Buy";
        public static final String EXPLORE_ONLINE_MERCHANT_CLICK = "Explore Online Merchant Click";
        public static final String EXPLORE_ONLINE_MERCHANT_OPEN = "Explore Online Merchant List Open";
        public static final String EXPLORE_PAGE_OPEN = "Explore Page Open";
        public static final String EXPRESS_PURCHASE_CONFIRMATION = "Express Purchase Confirmation";
        public static final String EXPRESS_PURCHASE_OPEN = "Express Purchase Open";
        public static final String EXPRESS_PURCHASE_RESULT = "Express Purchase Result";
        public static final String FAMILY_ACCOUNT_CREATE = "Family Account Create";
        public static final String FAMILY_ACCOUNT_DELETE = "Family Account Delete";
        public static final String FAMILY_ACCOUNT_INVITATION_ACCEPT = "Family Account Invitation Accept";
        public static final String FAMILY_ACCOUNT_INVITATION_CANCEL = "Family Account Invitation Cancel";
        public static final String FAMILY_ACCOUNT_INVITATION_DECLINE = "Family Account Invitation Decline";
        public static final String FAMILY_ACCOUNT_INVITATION_RESEND = "Family Account Invitation Resend";
        public static final String FAMILY_ACCOUNT_INVITE_MEMBER = "Family Account Invite Member";
        public static final String FAMILY_ACCOUNT_MEMBER_DELETE = "Family Account Member Delete";
        public static final String FAMILY_ACCOUNT_MEMBER_MANAGE = "Family Account Member Manage";
        public static final String FAMILY_ACCOUNT_RESULT = "Family Account Result";
        public static final String FAMILY_ACCOUNT_TOP_UP_CREATION = "Top up Family Account Creation";
        public static final String FAMILY_ACCOUNT_TRANSACTION_APPROVE = "Family Account Transaction Approve";
        public static final String FIRST_ACTION = "First Action";
        public static final String GLOBAL_SEARCH_OPEN = "Global Search Open";
        public static final String GOAL_SAVINGS_CANCELLED = "Savings Goal Cancelled";
        public static final String GOAL_SAVINGS_CREATED = "Savings Goal Created";
        public static final String GOAL_SAVINGS_EDITED = "Savings Goal Edited";
        public static final String GOAL_SAVINGS_TOPUP_CREATION = "Top Up Savings Creation";
        public static final String GOAL_SAVINGS_WITHDRAW_CREATION = "Savings Goal Withdraw Creation";
        public static final String GROUP_SEND_CHOOSE_CONTACT = "Group Send Choose Contact";
        public static final String GROUP_SEND_CREATE_OPEN = "Group Send Create Open";
        public static final String GROUP_SEND_CREATE_SUBMIT = "Group Send Create Submit";
        public static final String GROUP_SEND_OPEN = "Group Send Open";
        public static final String GROUP_SEND_SEARCH_CONTACT_OPEN = "Group Send Search Contact Open";
        public static final String GROUP_SEND_SELECT = "Group Send Select";
        public static final String HOME_POP_UP_ACTION = "Home Pop Up Action";
        public static final String HOME_POP_UP_OPEN = "Home Pop Up Open";
        public static final String HOME_TOOLTIP_APPEAR = "Home Tooltip Appear";
        public static final String IDLE_INPUT_PHONE_NUMBER_SCREEN = "idle_input_phone_number_screen";
        public static final String IDLE_REGISTRATION_CITCALL_INPUT_OTP_SCREEN = "idle_registration_citcall_input_otp_screen";
        public static final String IDLE_REGISTRATION_CITCALL_INTRODUCTION_SCREEN = "idle_registration_citcall_introduction_screen";
        public static final String INTERSTITIAL_BANNER_DOWNLOAD_FINISH = "Interstitial Banner Download Finish";
        public static final String KYB_BALANCE_BREAKDOWN_CLICK = "KYB balance breakdown click";
        public static final String KYB_BALANCE_WITHDRAW_CLICK = "KYB balance withdraw click";
        public static final String KYB_BANNER_CLICK = "KYB banner click";
        public static final String KYB_FACE_ENROLL_CLICK = "KYB Face Enroll click";
        public static final String KYB_NATIVE_HOMEPAGE_OPEN = "KYB Native Homepage Open";
        public static final String KYB_PAYMENT_LINK_CLICK = "KYB Payment Link Click";
        public static final String KYB_QRIS_OPEN = "KYB QRIS Open";
        public static final String KYB_QRIS_SHARE = "KYB QRIS Share";
        public static final String KYB_REQUEST_PAYMENT_CLICK = "KYB request payment click";
        public static final String KYB_SERVICE_CLICK = "KYB services click";
        public static final String KYB_SETTINGS_CLICK = "KYB settings click";
        public static final String KYB_TAB_CLICK = "KYB tab click";
        public static final String KYB_TRANSACTION_LIST_CLICK = "KYB transaction list click";
        public static final String KYB_WITHDRAW_DESTINATION_CLICK = "KYB withdraw destination click";
        public static final String KYC_AML_EDD_APPEAR = "KYC AML EDD Appear";
        public static final String KYC_RENEWAL_APPEAR = "KYC Renewal Appear";
        public static final String LINKED_ACCOUNTS_OPEN = "Linked Accounts Open";
        public static final String LINKED_ACCOUNTS_REQUEST = "Linked Accounts Request";
        public static final String LINKED_ACCOUNTS_RESULT = "Linked Accounts Result";
        public static final String LOADING_STATE = "Loading State";
        public static final String LOCATION_PERMISSION = "Location Permission";
        public static final String LOGGED_IN = "Logged In";
        public static final String LOGGED_IN_SPLUNK = "dana.loggedIn";
        public static final String LOGIN_FACEAUTH_CANCELLED = "login_faceauth_cancelled";
        public static final String LOGIN_FACEAUTH_FAILED = "login_faceauth_failed";
        public static final String LOGIN_FACEAUTH_SUCCESS = "login_faceauth_success";
        public static final String LOGIN_FACEAUTH_TIME = "login_faceauth_time";
        public static final String LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_FAILED = "login_verif_method_carrier_identification_failed";
        public static final String LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_SUCCESS = "login_verif_method_carrier_identification_success";
        public static final String LOGIN_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME = "login_verif_method_carrier_identification_time";
        public static final String LOGIN_VERIFICATION_METHOD_SMS_FAILED = "login_verif_method_sms_failed";
        public static final String LOGIN_VERIFICATION_METHOD_SMS_SUCCESS = "login_verif_method_sms_success";
        public static final String LOGIN_VERIFICATION_METHOD_SMS_TIME = "login_verif_method_sms_time";
        public static final String LOGIN_VERIFICATION_METHOD_TWILIO_FAILED = "login_verif_method_twilio_failed";
        public static final String LOGIN_VERIFICATION_METHOD_TWILIO_SUCCESS = "login_verif_method_twilio_success";
        public static final String LOGIN_VERIFICATION_METHOD_TWILIO_TIME = "login_verif_method_twilio_time";
        public static final String LOGOUT = "Logout";
        public static final String MISCALL_INTRODUCTION = "Miss Call Introduction";
        public static final String NEARBY_DETAIL_OPEN = "Nearby Detail Open";
        public static final String NEARBY_DETAIL_PAGE_SHARE_LINK = "Nearby Detail Page Share Link ";
        public static final String NEARBY_DETAIL_REVIEW_OPEN = "Nearby Detail Review Open";
        public static final String NEARBY_HOME_SHOPPING_OPEN = "Nearby Home Shopping Open";
        public static final String NEARBY_HOME_SHOPPING_ORDER = "Nearby Home Shopping Order";
        public static final String NEARBY_ME_SEARCH_FILTER = "Nearby Search Filter";
        public static final String NEARBY_ME_SEARCH_KEYWORD = "Nearby Search Keyword";
        public static final String NEARBY_REVIEW_FORM_OPEN = "Nearby Review Form Open";
        public static final String NEARBY_REVIEW_FORM_SUBMIT = "Nearby Review Form Submit";
        public static final String NEARBY_REVIEW_LIST_EDIT = "Nearby Review List Edit";
        public static final String NEARBY_REVIEW_LIST_OPEN = "Nearby Review List Open";
        public static final String NEARBY_SEARCH_MAP_RESULT = "Nearby Search Map Result";
        public static final String NEARBY_SEARCH_PAGE_OPEN = "Nearby Search Page Open";
        public static final String NEARBY_SHOP_LIST_OPEN = "Nearby Shop List Open";
        public static final String NEARBY_UNREVIEWED_LIST_OPEN_ALL = "Nearby Unreviewed List Open All";
        public static final String NOTIFICATION_INBOX_READ = "Notification Inbox Read";
        public static final String NOTIFICATION_PUSH_READ = "Notification Push Read";
        public static final String NOTIFICATION_PUSH_RECEIVED = "Notification Push Received";
        public static final String NPS_SURVEY_OPEN = "NPS Survey Open";
        public static final String NPS_SURVEY_SUBMIT = "NPS Survey Submit";
        public static final String ONBOARDING_EXIT = "Onboarding Exit";
        public static final String ONBOARDING_PHONE_NUMBER_INPUT = "Onboarding Phone Number Input";
        public static final String ONBOARDING_PHONE_NUMBER_OPEN = "Onboarding Phone Number Open";
        public static final String OTP_COMPLETED = "OTP Completed";
        public static final String OTP_INPUT = "OTP Input";
        public static final String OTP_REQUEST = "OTP Request";
        public static final String OVERSEAS_CHOOSE_COUNTRY = "Overseas Choose Country";
        public static final String OVERSEAS_CHOOSE_USER = "Overseas Choose User";
        public static final String OVERSEAS_CREATE_CONFIRM = "Overseas Create Confirm";
        public static final String OVERSEAS_OPEN = "Overseas Open";
        public static final String OVERSEAS_RECEIVER_OPEN = "Overseas Receiver Open";
        public static final String OVERSEAS_RECEIVER_SUBMIT = "Overseas Receiver Submit";
        public static final String OVERSEAS_SENDER_DETAIL = "Overseas Sender Detail";
        public static final String PARTNER = "Partner";
        public static final String PASSIVE_BIOMETRIC = "Passive Biometric";
        public static final String PAYLATER_LOAN_AGREEMENT_OPEN = "Loan Agreement Open";
        public static final String PAYLATER_POP_UP_REGISTRATION_CLOSE = "PayLater pop up registration close";
        public static final String PAYLATER_POP_UP_REGISTRATION_OPEN = "PayLater pop up registration open";
        public static final String PAYLATER_REGISTRATION_APPROVED = "DANA CICIL approved cashier";
        public static final String PAYLATER_REPAYMENT_CONFIRMATION_OPEN = "Payment Confirmation Repayment Open";
        public static final String PAYLATER_SUBMIT_REGISTRATION = "PayLater Submit Registration";
        public static final String PAYLATER_TNC_OPEN = "PayLater Tnc Registration open";
        public static final String PAYMENT_CONFIRMATION_OPEN = "Payment Confirmation Open";
        public static final String PAYMENT_EXECUTION = "Payment Execution";
        public static final String PAYMENT_RESULT = "Payment Result";
        public static final String PAYMENT_RESULT_BANNER_OPEN = "Payment Banner Open";
        public static final String PAYMENT_RESULT_DETAIL_OPEN = "Payment Result Detail Open";
        public static final String PAYMENT_RISK_CHALLENGE = "Payment Risk Challenge";
        public static final String PAYMENT_SELECT_METHOD = "Payment Select Method";
        public static final String PAYMENT_SETTING_APPEAR = "Payment Setting Appear";
        public static final String PAYMENT_THIRD_PARTY_RISK_CHALLENGE = "Payment Third Party Risk Challenge";
        public static final String PAYMENT_TRY_AGAIN_ACTION = "Payment Try Again Action";
        public static final String PAY_QR_OPEN = "Pay QR Open";
        public static final String PAY_QR_RESULT = "Pay QR Result";
        public static final String PIN_COMPLETED = "PIN Completed";
        public static final String PIN_CREATE_COMPLETE = "Pin Create Complete";
        public static final String PIN_FORGOT = "PIN Forgot";
        public static final String PIN_FORGOT_BUTTON = "PIN Forgot Button";
        public static final String PIN_FORGOT_PAGE_OPEN = "Pin Forgot Page Open";
        public static final String PIN_REQUEST = "PIN Request";
        public static final String POCKET_OPEN = "Pocket Open";
        public static final String POP_UP_ENABLE_LOCATION_OPEN = "Pop Up Enable Location Open";
        public static final String PROFILE_PAGE_OPEN = "Profile Page Open";
        public static final String PROMOTION_BANNER_DOWNLOAD_FINISH = "Promotion Banner Download Finish";
        public static final String PROMOTION_BANNER_OPEN = "Promotion Banner Open";
        public static final String PROMOTION_BANNER_SLIDE_TO_PAGE = "Promotion Banner Appear";
        public static final String PROMOTION_CENTER_OPEN = "Promotion Center Open";
        public static final String PROMOTION_INTERSTITIAL_BANNER_APPEAR = "Promotion Banner Appear";
        public static final String PROMO_CENTER_ACTIONS = "Promo Center Actions";
        public static final String PROMO_CENTER_OPEN = "Promo Center Open";
        public static final String PROMO_CODE_OPEN = "Promo Code Open";
        public static final String PROMO_CODE_RESULT = "Promo Code Result";
        public static final String PROMO_QUEST_DETAILS_OPEN = "Promo Quest Details Open";
        public static final String PROMO_QUEST_FINISH = "Promo Quest Finish";
        public static final String PROMO_QUEST_MAIN_PAGE_OPEN = "Promo Quest Main Page Open";
        public static final String PROMO_QUEST_TASK_EXECUTE = "Promo Quest Task Execute";
        public static final String PUSH_VERIFY_COMPLETED = "Push Verify Completed";
        public static final String PUSH_VERIFY_CREATE_CHALLENGE = "Push Verify Create Challenge";
        public static final String PUSH_VERIFY_DETAIL_OPEN = "Verification Detail Open";
        public static final String PUSH_VERIFY_ENTRY_POINT_OPEN = "Push Verify Entry Point Open";
        public static final String PUSH_VERIFY_EXPIRY = "Push Verification Expiry";
        public static final String PUSH_VERIFY_NOTIFICATION_RECEIVED = "Push Verify Notification Received";
        public static final String PUSH_VERIFY_RETURN_CREATE_CHALLENGE = "Push Verify Return Create Challenge";
        public static final String PUSH_VERIFY_UPDATE_CHALLENGE = "Push Verify Update Challenge";
        public static final String RECOMMENDED_SECURITY_CHOSEN = "Recommended Security Chosen";
        public static final String REFERRAL_BANNER_CLICK = "Referral Banner Click";
        public static final String REFERRAL_ENGAGEMENT_POPUP = "Referral Engagement Pop Up";
        public static final String REFERRAL_SEE_MORE_ACTION = "Referral See More Action";
        public static final String REFERRER_INVITE_ATTEMPT = "Referrer Invite Attempt";
        public static final String REFERRER_PAGE_OPEN = "Referrer Page Open";
        public static final String REGISTRATION_COMPLETE = "Registration Complete";
        public static final String REGISTRATION_FACEAUTH_CANCELLED = "regis_faceauth_cancelled";
        public static final String REGISTRATION_FACEAUTH_ENROLLMENT_CANCELLED = "regis_faceauth_enrollment_cancelled";
        public static final String REGISTRATION_FACEAUTH_ENROLLMENT_FAILED = "regis_faceauth_enrollment_failed";
        public static final String REGISTRATION_FACEAUTH_ENROLLMENT_SUCCESS = "regis_faceauth_enrollment_success";
        public static final String REGISTRATION_FACEAUTH_ENROLLMENT_TIME = "registration_faceauth_enrollment_time";
        public static final String REGISTRATION_FACEAUTH_FAILED = "regis_faceauth_failed";
        public static final String REGISTRATION_FACEAUTH_SUCCESS = "regis_faceauth_success";
        public static final String REGISTRATION_FACEAUTH_TIME = "registration_faceauth_time";
        public static final String REGISTRATION_PIN_CONFIRM = "Registration PIN Confirm";
        public static final String REGISTRATION_PIN_CREATE = "Registration PIN Create";
        public static final String REGISTRATION_PROFILE_CREATE = "Registration Profile Create";
        public static final String REGISTRATION_REFERRAL_INPUT = "Registration Referral Input";
        public static final String REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_FAILED = "regis_verif_method_ci_failed";
        public static final String REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_SUCCESS = "regis_verif_method_ci_success";
        public static final String REGISTRATION_VERIFICATION_METHOD_CARRIER_IDENTIFICATION_TIME = "regis_verif_method_ci_time";
        public static final String REGISTRATION_VERIFICATION_METHOD_CITCALL_FAILED = "regis_verif_method_citcall_failed";
        public static final String REGISTRATION_VERIFICATION_METHOD_CITCALL_SUCCESS = "regis_verif_method_citcall_success";
        public static final String REGISTRATION_VERIFICATION_METHOD_CITCALL_TIME = "regis_verif_method_citcall_time";
        public static final String REGISTRATION_VERIFICATION_METHOD_SMS_FAILED = "regis_verif_method_sms_failed";
        public static final String REGISTRATION_VERIFICATION_METHOD_SMS_SUCCESS = "regis_verif_method_sms_success";
        public static final String REGISTRATION_VERIFICATION_METHOD_SMS_TIME = "regis_verif_method_sms_time";
        public static final String REGISTRATION_VERIFICATION_METHOD_WA_FAILED = "regis_verif_method_whatsapp_failed";
        public static final String REGISTRATION_VERIFICATION_METHOD_WA_SUCCESS = "regis_verif_method_whatsapp_success";
        public static final String REGISTRATION_VERIFICATION_METHOD_WA_TIME = "regis_verif_method_whatsapp_time";
        public static final String REQUEST_MONEY_GENERATE_QR = "Request Money Generate QR";
        public static final String REQUEST_MONEY_OPEN = "Request Money Open";
        public static final String REQUEST_MONEY_QR_BANK_ACCOUNT_NUMBER_INPUT = "Request Money QR Bank Account Number Input";
        public static final String REQUEST_MONEY_QR_BANK_CREATE = "Request Money QR Bank Create";
        public static final String REQUEST_MONEY_QR_BANK_SELECTION = "Request Money QR Bank Selection";
        public static final String REQUEST_MONEY_QR_BANK_SUBMIT = "Request Money QR Bank Submit";
        public static final String RESULT = "Result";
        public static final String RISK_CHALLENGE_COMPLETE = "Risk Challenge Complete";
        public static final String RISK_CHALLENGE_OPEN = "Risk Challenge Open";
        public static final String SAVINGS_GOAL_OPEN = "Savings Goal Open";
        public static final String SCAN_QR = "Scan QR";
        public static final String SCAN_QR_HELP = "Scan QR Help";
        public static final String SEARCH_RESULT_BOTTOM_SHEET_DETAIL_OPEN = "Search Result Bottom Sheet Detail Open";
        public static final String SEARCH_RESULT_PAGE_ACTION_BUTTON = "Search Result Page Action Button";
        public static final String SEARCH_RESULT_PAGE_OPEN = "Search Result Page Open";
        public static final String SECURITY_SETTINGS_PAGE_OPEN = "Security Settings Page Open";
        public static final String SEND_AND_WITHDRAW_OPEN = "Send & Withdraw Open";
        public static final String SEND_AND_WITHDRAW_SELECT = "Send & Withdraw Select";
        public static final String SEND_MONEY_ADD_NEW_BANK_OPEN = "Send Money Add New Bank Open";
        public static final String SEND_MONEY_BANK_ACCOUNT_NUMBER_INPUT = "Send Money Bank Account Number Input";
        public static final String SEND_MONEY_BANK_LIST_PAGE = "Send Money Bank List Page";
        public static final String SEND_MONEY_CHAT_OPEN = "Send Money Chat Open";
        public static final String SEND_MONEY_CONFIRM = "Send Money Confirm";
        public static final String SEND_MONEY_CONTACT_LIST_PAGE = "Send Money Contact List Page";
        public static final String SEND_MONEY_CREATE = "Send Money Create";
        public static final String SEND_MONEY_HELP_OPEN = "Send Money Help Open";
        public static final String SEND_MONEY_OPEN = "Send Money Open";
        public static final String SEND_MONEY_RECEIVER_DATA_INPUT = "Send Money Receiver Data Input";
        public static final String SEND_MONEY_SEARCH = "Send Money Search";
        public static final String SEND_MONEY_SEARCH_SELECTED = "Send Money Search Selected";
        public static final String SEND_MONEY_SELECT = "Send Money Select";
        public static final String SERVICE_OPEN = "Service Open";
        public static final String SMARTPAY_FACEAUTH_CANCELLED = "smartpay_faceauth_cancelled";
        public static final String SMARTPAY_FACEAUTH_ENROLLMENT_CANCELLED = "smartpay_faceauth_enrollment_cancelled";
        public static final String SMARTPAY_FACEAUTH_ENROLLMENT_FAILED = "smartpay_faceauth_enrollment_failed";
        public static final String SMARTPAY_FACEAUTH_ENROLLMENT_SUCCESS = "smartpay_faceauth_enrollment_success";
        public static final String SMARTPAY_FACEAUTH_ENROLLMENT_TIME = "smartpay_faceauth_enrollment_time";
        public static final String SMARTPAY_FACEAUTH_FAILED = "smartpay_faceauth_failed";
        public static final String SMARTPAY_FACEAUTH_SUCCESS = "smartpay_faceauth_success";
        public static final String SMARTPAY_FACEAUTH_TIME = "smartpay_faceauth_time";
        public static final String SMARTPAY_OFFERING = "Smartpay Offering";
        public static final String SMART_FRICTION_SEND_MONEY_CONFIRM = "Smart Friction Send Money Confirm";
        public static final String SMART_FRICTION_SEND_MONEY_OPEN = "Smart Friction Send Money Open";
        public static final String SMS_VERIFICATION_DURATION_LOGIN = "sms_verification_duration_login";
        public static final String SMS_VERIFICATION_DURATION_REGISTRATION = "sms_verification_duration_registration";
        public static final String SPLASH = "Splash";
        public static final String SPLIT_BILL_CONFIRM = "Split Bill Confirm";
        public static final String SPLIT_BILL_CREATE = "Split Bill Create";
        public static final String SPLIT_BILL_DETAIL_OPEN = "Split Bill Detail Open";
        public static final String SPLIT_BILL_MARK_AS_PAID = "Split Bill Mark as Paid";
        public static final String SPLIT_BILL_OPEN = "Split Bill Open";
        public static final String SPLIT_BILL_SHARE = "Split Bill Share";
        public static final String TNC_APPEAR = "TNC Appear";
        public static final String TOPUP_FACEAUTH_CANCELLED = "topup_faceauth_cancelled";
        public static final String TOPUP_FACEAUTH_FAILED = "topup_faceauth_failed";
        public static final String TOPUP_FACEAUTH_SUCCESS = "topup_faceauth_success";
        public static final String TOPUP_FACEAUTH_TIME = "topup_faceauth_time";
        public static final String TOPUP_METHOD_PAGE_OPEN = "Payment Topup and Pay";
        public static final String TRANSACTION_HISTORY_OPEN = "Transaction History Open";
        public static final String TRANSFER_ACCOUNT_FACEAUTH_CANCELLED = "transfer_account_faceauth_cancelled";
        public static final String TRANSFER_ACCOUNT_FACEAUTH_FAILED = "transfer_account_faceauth_failed";
        public static final String TRANSFER_ACCOUNT_FACEAUTH_SUCCESS = "transfer_account_faceauth_success";
        public static final String TRANSFER_ACCOUNT_FACEAUTH_TIME = "transfer_account_faceauth_time";
        public static final String TRANSFER_ACCOUNT_PROCESSING = "Transfer Account Processing";
        public static final String TWILIO_PUSH_ENROLL = "Twilio Push Enroll";
        public static final String UNSAFE_IDENTIFIED_DEVICE = "Unsafe Identified Device";
        public static final String USER_INTERACTION_LOGIN_PIN_INPUT = "user_interaction_login_pin_input";
        public static final String USER_INTERACTION_REGISTRATION_CITCALL_OTP_BACKUP_DIALOG = "user_interaction_registration_citcall_otp_backup_dialog";
        public static final String USER_INTERACTION_REGISTRATION_CITCALL_OTP_INPUT = "user_interaction_registration_citcall_otp_input";
        public static final String USER_INTERACTION_REGISTRATION_LOGIN_PERMISSION_INFO_APPROVAL = "user_interaction_registration_login_permission_info_approval";
        public static final String USER_INTERACTION_REGISTRATION_LOGIN_PHONE_NUMBER_INPUT = "user_interaction_registration_login_phone_number_input";
        public static final String USER_INTERACTION_REGISTRATION_PIN_CONFIRMATION = "user_interaction_registration_pin_confirmation";
        public static final String USER_INTERACTION_REGISTRATION_PIN_CREATION = "user_interaction_registration_pin_creation";
        public static final String USER_PREFERENCE_LIST_OPEN = "User Preference List Open";
        public static final String USER_PREFERENCE_LIST_SUBMIT = "User Preference List Submit";
        public static final String VERIFICATION_LIST_ACTIVE_TAB_OPEN = "Verification List Active Tab Open";
        public static final String VERIFICATION_LIST_HISTORY_TAB_OPEN = "Verification List History Tab Open";
        public static final String VERIFICATION_METHOD_REQUEST = "verification_method_request";
        public static final String WALLET_LIFESTYLE_OPEN = "Wallet Lifestyle Open";
        public static final String WALLET_PAYMENT_OPEN = "Wallet Payment Open";
        public static final String WALLET_POCKET_ADD_ASSET = "Wallet Pocket Add Asset";
        public static final String WALLET_POCKET_TAB_OPEN = "Wallet Pocket Open";
        public static final String WA_VERIFICATION_DURATION_REGISTRATION = "whatsapp_verification_duration_registration";
    }

    /* loaded from: classes3.dex */
    public @interface ExpressPurchaseProperties {
        public static final String ACTION = "Action";
        public static final String AGGREGATOR = "Aggregator";
        public static final String EP_CONFIRMATION_POP_UP = "EP Confirmation Pop up";
        public static final String FAILED_REASON = "Fail Reason";
        public static final String GOODS_BUSINESS_TYPE_ID = "Goods Business Type ID";
        public static final String GOODS_ID = "Goods ID";
        public static final String GOODS_MERCHANT_ID = "Goods Merchant ID";
        public static final String GOODS_MERCHANT_NAME = "Goods Merchant Name";
        public static final String GOODS_NAME = "Goods Name";
        public static final String IS_DISMISS = "isDismiss";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String PARTNER = "Partner";
        public static final String PENDING_REASON = "Pending Reason";
        public static final String PRICE_CHANGE = "Price Change";
        public static final String PRODUCT_CODE = "Product Code";
        public static final String STATUS = "Status";
        public static final String TEMPLATE = "Express Purchase Template";
        public static final String VOUCHER_CATEGORY = "Voucher Category";
    }

    /* loaded from: classes3.dex */
    public @interface FamilyAccountInvitationMemberStatus {
        public static final String FAILED = "Failed";
        public static final String PENDING = "Pending";
        public static final String SUCCESS = "Success";
    }

    /* loaded from: classes3.dex */
    public @interface FamilyAccountProperties {
        public static final String ADDRESS_POSITION = "Address Position";
        public static final String FAMILY_ACCOUNT_STATUS = "Family Account Status";
        public static final String INVITATION_MEMBER_STATUS = "Invitation Member Status";
        public static final String IS_APPROVE = "isApprove";
        public static final String IS_CANCEL = "isCancel";
        public static final String IS_DECLINE = "isDecline";
        public static final String IS_JOIN = "isJoin";
        public static final String IS_RESEND = "isResend";
        public static final String RELATION = "Relation";
        public static final String RESULT = "Result";
        public static final String SERVICE_ACCESS = "Service Access";
        public static final String USE_CASE = "Use Case";
    }

    /* loaded from: classes3.dex */
    public @interface GlobalSearchOpenProperties {
        public static final String KEYWORD_RESULT = "Keyword Result";
        public static final String KEYWORD_USAGE = "Keyword Usage";
        public static final String RESULT_STATUS = "Result Status";
        public static final String SOURCE = "Source";
        public static final String SUGGESTION_ORDER = "Suggestion Order";
    }

    /* loaded from: classes3.dex */
    public @interface GlobalSearchProperties {
        public static final String DISHES_NAME = "Dishes Name";
        public static final String MERCHANT_CATEGORY = "Merchant Category";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String SECTION = "Section";
        public static final String SHOP_NAME = "Shop Name";
    }

    /* loaded from: classes3.dex */
    public @interface ImageCaptureProperties {
        public static final String DANA_SIAGA_DOCUMENT_TYPE = "Document Type";
        public static final String DANA_SIAGA_INSURANCE_BENEFIT = "Insurance Benefit";
        public static final String DANA_SIAGA_INSURANCE_GOODS = "Insurance Goods";

        /* loaded from: classes3.dex */
        public @interface GlobalSendMethodTransfer {
            public static final String BANK = "bank";
            public static final String CASH = "cash";
            public static final String DEBIT = "debit";
            public static final String PEER = "peer";
        }

        /* loaded from: classes3.dex */
        public @interface GlobalSendSource {
            public static final String INPUT_RECEIVER = "Input Receiver";
            public static final String INTRO_PAGE = "Intro Page";
            public static final String LANDING_PAGE = "Landing Page";
            public static final String QUICK_SEND = "Quick Send";
        }
    }

    /* loaded from: classes3.dex */
    public @interface InviteType {
        public static final String SHARE_BUTTON = "Share Button";
        public static final String USER_CONTACT = "User Contact";
    }

    /* loaded from: classes3.dex */
    public @interface KeywordType {
        public static final String CUSTOM = "Custom";
        public static final String HISTORY = "History";
        public static final String POPULAR = "Popular";
        public static final String SUGGESTION = "Suggestion";
    }

    /* loaded from: classes3.dex */
    public @interface KybProperties {
        public static final String DATA_SOURCE = "Data Source";
        public static final String DESTINATION = "Destination";
        public static final String LOAD_TIME = "Load Time";
    }

    /* loaded from: classes3.dex */
    public @interface KybWithDrawTypeProperty {
        public static final String BANK_ACCOUNT = "Bank Account";
        public static final String DANA_BALANCE = "DANA Balance";
        public static final String NEW_UI = "New UI";
    }

    /* loaded from: classes3.dex */
    public @interface LoginProperties {
        public static final String FIRST_CHALLENGE_IN_MILLIS = "First Challenge in millis";
        public static final String LOGIN_CHALLENGE = "Login Challenge";
        public static final String LOGIN_TYPE = "Login Type";
        public static final String RISK_CHALLENGE = "Risk Challenge";
        public static final String SECOND_CHALLENGE_IN_MILLIS = "Second Challenge in millis";
    }

    /* loaded from: classes3.dex */
    public @interface LoginType {
        public static final String DANA_VIZ = "DANA_VIZ";
        public static final String LOGIN_PIN = "Password";
        public static final String NORMAL_LOGIN = "Normal";
        public static final String OTP_SMS = "OTP SMS";
        public static final String TRUST_RISK_LOGIN = "Trust Risk";
        public static final String TRUST_RISK_LOGIN_V2 = "Trust Risk Login V2";
    }

    /* loaded from: classes3.dex */
    public @interface LogoutType {
        public static final String LOGOUT_FORCE = "Force";
        public static final String LOGOUT_NORMAL = "Normal";
    }

    /* loaded from: classes3.dex */
    public @interface MerchantManagementProperties {
        public static final String APP_NAME = "App Name";
        public static final String DATE = "Date";
        public static final String MERCHANT_NAME = "Merchant Name";
    }

    /* loaded from: classes3.dex */
    public @interface MixpanelProperties {
        public static final String APP_ID = "App ID";
        public static final String CLIENT_ID = "Client ID";
        public static final String SERVICE_KEY = "Service Key";
    }

    /* loaded from: classes3.dex */
    public @interface NearbyMerchantProperty {
        public static final String CAMPAIGN_ID = "Campaign Id";
        public static final String HAS_REVIEW = "Has Review";
        public static final String MCC_TYPE = "MCC Type";
        public static final String MERCHANT_ID = "Merchant ID";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String PROMO_CODE = "Promo Code";
        public static final String SHOP_NAME = "Shop Name";
        public static final String STARS_SUBMITTED = "Stars Submitted";
        public static final String TAGS_SUBMITTED = "Tags Submitted";
        public static final String UPDATE_REVIEW = "Update Review";
    }

    /* loaded from: classes3.dex */
    public @interface NewsProperty {
        public static final String NEWS_TITLE = "News Title";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OnboardingPhoneNumberCheckResult {
        public static final String LOGIN = "Login";
        public static final String NETWORK_ERROR = "Network Error";
        public static final String REGISTER = "Register";
    }

    /* loaded from: classes3.dex */
    public @interface OnboardingProperty {
        public static final String LAST_VIEWED_ONBOARDING_PAGE = "Last Viewed Onboarding Page";
    }

    /* loaded from: classes3.dex */
    public @interface OnlineMerchantProperties {
        public static final String IS_NEW = "Is New";
        public static final String IS_TRENDING = "Is Trending";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String REDIRECT_URL = "Redirect Url";
    }

    /* loaded from: classes3.dex */
    public @interface OpenScanAction {
        public static final String RECENT_RECIPIENT = "Recent Recipient";
    }

    /* loaded from: classes3.dex */
    public @interface PassiveBioProperties {
        public static final String ACCELEROMETER = "Accelerometer";
        public static final String GYROSCOPE = "Gyroscope";
        public static final String KEYSTROKE = "Keystroke";
        public static final String PASSIVE_BIOMETRIC_READY = "Passive Biometric Ready";
    }

    /* loaded from: classes3.dex */
    public @interface PasskeyEvent {
        public static final String PASSKEY_COMPLETE = "Passkey Complete";
        public static final String PASSKEY_INTRODUCTION = "Passkey Introduction";
        public static final String PASSKEY_OPEN = "Passkey Open";
    }

    /* loaded from: classes3.dex */
    public @interface PaylaterProperties {
        public static final String ACTIVATION_SUBMIT = "Activation submit";
        public static final String AGREEMENT_KEY = "Agreement Key";
        public static final String DANA_CICIL_IS_TRUE = "DANACICILIsTrue";
        public static final String DANA_CICIL_STATUS = "DANA CICIL status";
        public static final String FIRST_TRANSACTION_TYPE = "First Transaction Type";
        public static final String IS_PAYLATER_CICIL = "IsPaylaterCicil";
        public static final String PAGE_NAME = "Page name";
        public static final String PARTNER = "Partner";
        public static final String PAYLATER_NAME = "Paylater name";
        public static final String PRODUCT_NAME = "Product name";
        public static final String RELOAD_TNC_ACTION = "Reload Tnc Action";
    }

    /* loaded from: classes3.dex */
    public @interface PeopleProperty {
        public static final String DANA_VIZ_ENROLL = "DANA Viz Enroll";
        public static final String DANA_VIZ_STATUS = "DANA Viz Status";
        public static final String FIRST_TRANSACTION_DATE = "First Transaction Date";
        public static final String FIRST_TRANSACTION_TYPE = "First Transaction Type";
        public static final String KYC_LEVEL = "KYC Level";
        public static final String LAST_TRANSACTION_DATE = "Last Transaction Date";
        public static final String LAST_TRANSACTION_TYPE = "Last Transaction Type";
        public static final String USER_ID = "$user_id";
        public static final String USER_LOCATION_PERMISSION = "User Location Permission";
    }

    /* loaded from: classes3.dex */
    public @interface PinRequestPurpose {
        public static final String DANA_VIZ_OPEN_FALLBACK = "DANA Viz Open Fallback";
        public static final String DANA_VIZ_PERMISSION_FALLBACK = "DANA Viz Permission Fallback";
    }

    /* loaded from: classes3.dex */
    public @interface PromoCenterSourceType {
        public static final String BANK_PROMO = "Saved Cards";
        public static final String DANA_DEALS = "DANA Deals";
        public static final String DANA_POINTS = "DANA Points";
        public static final String EXPIRING_VOUCHER = "Don’t miss It";
        public static final String LOYALTY_CARD = "Loyalty";
        public static final String MY_VOUCHER = "My Voucher";
        public static final String NEARBY = "Nearby";
        public static final String ONLY_FOR_YOU = "Just for You";
        public static final String PROMO_QUEST = "Promo Quest";
    }

    /* loaded from: classes3.dex */
    public @interface PromoQuestProperties {
        public static final String MISSION_ID = "Mission Id";
        public static final String MISSION_TITLE = "Mission Title";
    }

    /* loaded from: classes3.dex */
    public @interface PromotionProperty {
        public static final String BANNER_URL = "Banner URL";
        public static final String CATEGORY_NAME = "Category Name";
        public static final String FILE_SIZE = "File Size";
        public static final String MERCHANT_SPECIAL_SHOW = "Merchant's Special Show";
        public static final String PROMOTION_CONTENT_ID = "Promotion Content ID";
        public static final String PROMOTION_CONTENT_NAME = "Promotion Content Name";
        public static final String PROMOTION_CONTENT_TYPE = "Promotion Content Type";
        public static final String PROMOTION_EXPIRY_DATE = "Promotion Expiry Date";
        public static final String PROMOTION_LIST = "Promotion List";
        public static final String PROMOTION_SPACE_CODE = "Promotion Space Code";
        public static final String UUID = "UUID";
    }

    /* loaded from: classes3.dex */
    public @interface Property {
        public static final String ANNOUNCEMENT_SUBTITLE = "Announcement Subtitle";
        public static final String ANNOUNCEMENT_TITLE = "Announcement Title";
        public static final String ANNOUNCEMENT_TYPE = "Announcement Type";
        public static final String APP_INIT_DURATION = "App Init Duration in Milliseconds";
        public static final String APP_MINIMIZED = "App Minimized";
        public static final String APP_READY_STOP_CRITERIA = "App Ready Stop Criteria";
        public static final String APP_TERMINATED = "App Terminated";
        public static final String ASSET_TYPE = "Asset Type";
        public static final String ATTEMPT = "attemp";
        public static final String ATTEMPT_REQUEST = "Attempt Request";
        public static final String ATTEMPT_VERIFY = "Attempt Verify";
        public static final String CAMPAIGN_CHANNEL = "Campaign Channel";
        public static final String CAMPAIGN_DELIVERY_TYPE = "Delivery Type";
        public static final String CAMPAIGN_ID = "Campaign ID";
        public static final String CAMPAIGN_NAME = "Campaign Name";
        public static final String CAMPAIGN_TAGS = "Campaign Tags";
        public static final String CAMPAIGN_TYPE = "Campaign Type";
        public static final String CHALLENGE_SID = "Challenge Sid";
        public static final String CHALLENGE_TYPE = "Challenge Type";
        public static final String CONFIG_NAME = "Config name";
        public static final String CONTENT = "Content";
        public static final String CONTEXT_CODE = "Context Code";
        public static final String CONTEXT_VALUE = "Context Value";
        public static final String CONVERSION_TIME_IN_MILLIS = "Conversion Time in Millis";
        public static final String DANA_VIZ_ACTIVE = "Dana Viz Active";
        public static final String DEVICE_SOURCE = "Device Source";
        public static final String DISHES = "Dishes";
        public static final String DURATION = "Duration";
        public static final String ERROR_CODE = "Error Code";
        public static final String ERROR_CODE_FIREBASE = "error_code";
        public static final String ERROR_MESSAGE = "Error Message";
        public static final String ERROR_MESSAGE_FIREBASE = "error_message";
        public static final String FACE_LOGIN_PAGE_SHOWN = "Face Login Page Shown";
        public static final String FACTOR_SID = "Factor Sid";
        public static final String FAILED_CONSULT_RULE = "Failed consult rule";
        public static final String FAILED_REASON = "Failed Reason";
        public static final String FAIL_REASON = "Fail Reason";
        public static final String FALLBACK = "Fallback";
        public static final String FROM_DEEPLINK = "From Deeplink";
        public static final String FROM_NOTIFICATION = "From Notification";
        public static final String GOAL_AMOUNT = "Goal Amount";
        public static final String GOAL_CATEGORY = "Goal Category";
        public static final String GOAL_NAME = "Goal Name";
        public static final String HAPPY_PATH = "Happy Path";
        public static final String HOME_CHECK_SESSION_IN_MILLIS = "Home - Check Session in Millis";
        public static final String HOME_DURATION = "Home Duration in Milliseconds";
        public static final String HOME_ENTRY_POINT_CLICK = "Home Entry Point Click";
        public static final String HOME_REFACTOR_ENABLED = "Home Refactor Enable";
        public static final String ICON_NAME = "Icon name";
        public static final String IDLE_TIME = "Idle Time in Millisecond";
        public static final String INITIAL_LOAD = "Initial Load";
        public static final String INIT_TIME = "Init Time in Millisecond";
        public static final String INPUT_OTP_PAGE_SHOWN = "Input OTP Page Shown";
        public static final String INPUT_PIN_PAGE_SHOWN = "Input PIN Page Shown";
        public static final String INVITE_TYPE = "Invite Type";
        public static final String IS_CONFIRM = "Is Confirm";
        public static final String IS_DELIVERED = "isDelivered";
        public static final String IS_SUCCESS = "isSuccess";
        public static final String KYC_LEVEL = "KYC Level";
        public static final String LOAD_DURATION = "Load Duration";
        public static final String LOAD_TIME = "Ready in Milliseconds";
        public static final String LOCATION_PERMISSION_ACTIVE = "Location Permission Active";
        public static final String LOGOUT_TYPE = "Logout Type";
        public static final String MEDIA_SOURCE = "Media Source";
        public static final String MERCHANT_ID = "Merchant ID";
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String NAVIGATES_OUT = "User Navigates Out";
        public static final String NEARBY = "Nearby";
        public static final String NETWORK_TYPE = "Network Type";
        public static final String NON_BLOCKING_SPLASH = "Non Blocking Splash";
        public static final String NOTIFICATION_TYPE = "Notification Type";
        public static final String NUMBER_OF_ATTEMPTS = "Number of Attempts";
        public static final String NUMBER_OF_RECIPIENT = "Number of Recipient";
        public static final String NUMBER_OF_UNCOMPLETED_TASKS = "Number of uncompleted tasks";
        public static final String ONBOARDING_PHONE_NUMBER_CHECK_RESULT = "Onboarding Phone Number Check Result";
        public static final String ONLINE = "Online";
        public static final String OPERATION_TYPE = "Operation Type";
        public static final String OPTIONAL_UPDATE_POP_UP_SHOWN = "Optional Update Pop-up Shown";
        public static final String PASSIVE_BIOMETRIC_ENABLE = "Passive Biometric Enable";
        public static final String PAYLOAD = "Payload";
        public static final String PAYMENT_METHOD_COUNT = "Payment Method Count";
        public static final String PAY_QR_CHANNEL_NAME = "Pay QR Channel Name";
        public static final String PAY_QR_PAYMENT_METHOD = "Pay QR Payment Method";
        public static final String PHONE_NUMBER_PAGE_SHOWN = "Phone Number Page Shown";
        public static final String PROMO_QUEST_NAME = "Promo Quest Name";
        public static final String PURPOSE = "Purpose";
        public static final String PUSH_PLATFORM = "Push Platform";
        public static final String QR_PAYMENT_PROCESSING_RESULT = "QR Payment Processing Result";
        public static final String QUEST_DESCRIPTION = "Quest Description";
        public static final String REACH_LIMIT = "Reach Limit";
        public static final String READY_MILLIS = "Ready in Milliseconds";
        public static final String REINPUT_PIN_PAGE_SHOWN = "Reinput PIN Page Shown";
        public static final String RESTSAURANT = "Restaurant";
        public static final String RESULT = "Result";
        public static final String ROAMING_TIME = "Roaming Time in Millisecond";
        public static final String SCANNER_READY = "Scanner Ready";
        public static final String SEARCH_FILTER = "Search Filter";
        public static final String SEARCH_KEYWORD = "Search Keyword";
        public static final String SEARCH_TYPE = "Search Type";
        public static final String SECURITY_QUESTION_ACTIVE = "Security Question Active";
        public static final String SERVICE = "Service";
        public static final String SESSION_ID = "Session Id";
        public static final String SIMPLE_GET_USER_ID = "Simple Get User Id";
        public static final String SLOWEST_COMPONENT = "Slowest Component";
        public static final String SLOWEST_COMPONENT_TIME = "Slowest Component in Milliseconds";
        public static final String SOURCE = "Source";
        public static final String SPLASH_CHECK_SESSION_IN_MILLIS = "Splash - Check Session in Millis";
        public static final String SPLASH_DURATION = "Splash Duration in Milliseconds";
        public static final String START_TYPE = "Start Type";
        public static final String STATE = "State";
        public static final String SUCCESS = "Success";
        public static final String TIME = "Time";
        public static final String TOTAL_MAX_AMOUNT = "Total Max Amount";
        public static final String TOTAL_TIME = "Total Time in Millisecond";
        public static final String TRACK_SOURCE = "Track Source";
        public static final String UNFINISHED_COMPONENTS = "Unfinished Components";
        public static final String UNFINISHED_QUEST_EXIST = "Unfinished Quest Exist";
        public static final String USER_CANCEL = "User Cancel";
        public static final String USER_UPDATE_RESULT = "User Update Result";
    }

    /* loaded from: classes3.dex */
    public @interface PushVerifyProperty {
        public static final String ERROR_CODE = "Error code";
        public static final String ERROR_MESSAGE = "Error message";
        public static final String OS_MERCHANT_PLATFORM = "OS on Merchant Platform";
        public static final String PUSH_VERIFY_ENTRY_POINT = "PV Entry Point";
        public static final String REQUEST_TYPE = "Request Type";
        public static final String VERIFICATION_USER_INPUT = "Verification User Input";
        public static final String VERIFY_OPTION = "Verify Option";
    }

    /* loaded from: classes3.dex */
    public @interface RecipientDestinationTypeProperty {
        public static final String BANK = "BANK";
        public static final String CASH = "CASH";
        public static final String DANA_BALANCE = "DANA Balance";
        public static final String GROUP = "GROUP";
        public static final String LINK = "LINK";
        public static final String OVERSEAS = "OVERSEAS";
    }

    /* loaded from: classes3.dex */
    public @interface RecommendedSecurityChosenProperties {
        public static final String RECOMMENDED_SECURITY = "Recommended Security";
    }

    /* loaded from: classes3.dex */
    public @interface ReferralDestinationProperty {
        public static final String DESTINATION = "Destination";
    }

    /* loaded from: classes3.dex */
    public @interface ReferralProperty {
        public static final String FAILED_REASON = "Failed Reason";
        public static final String REFERRAL_CODE = "Referral Code";
    }

    /* loaded from: classes3.dex */
    public @interface RegistrationProperties {
        public static final String REFERRAL_CODE = "Referral Code";
        public static final String REFERRAL_TYPE = "Referral Type";
        public static final String REGISTRATION_CHALLENGE = "Registration Challenge";
        public static final String REGISTRATION_DATE = "Registration Date";
    }

    /* loaded from: classes3.dex */
    public @interface RequestMoneyProperties {
        public static final String IS_DEEPLINK = "Is Deeplink";
        public static final String QR_TRANSFER = "qr.transfer";
        public static final String QR_TRANSFER_BANK = "qr.transfer.bank";
        public static final String QR_TYPE = "QR Type";
        public static final String QR_USER = "qr.user";
        public static final String QR_USER_BANK = "qr.user.bank";
    }

    /* loaded from: classes3.dex */
    public @interface ResultStatusType {
        public static final String ERROR_PAGE = "Error Page";
        public static final String NO_RESULT_PAGE = "No Result Page";
        public static final String RESULT_NO_LOCATION = "Result No Location";
        public static final String RESULT_WITH_LOCATION = "Result With Location";
    }

    /* loaded from: classes3.dex */
    public @interface ResultType {
        public static final String FAILED = "Failed";
        public static final String PENDING = "Pending";
        public static final String SUCCESS = "Success";
    }

    /* loaded from: classes3.dex */
    public @interface RiskChallenge {

        /* loaded from: classes3.dex */
        public @interface Purpose {
            public static final String DIRECT_CHALLANGE = "Direct Challenge";
            public static final String FALLBACK = "Fallback";
        }

        /* loaded from: classes3.dex */
        public @interface Source {
            public static final String CHANGE_PIN = "Change PIN";
            public static final String LANDING_PAGE = "Landing Page";
            public static final String RESET_PIN = "Reset PIN";
            public static final String SELF_UNFREEZE = "Self Unfreeze";
        }

        /* loaded from: classes3.dex */
        public @interface Type {
            public static final String DANA_VIZ = "DANA Viz";
            public static final String MISSED_CALL_OTP = "Missed Call OTP";
            public static final String PIN = "PIN";
            public static final String REJECT = "REJECT";
            public static final String SMS_OTP = "SMS OTP";
            public static final String WHATSAPP_OTP = "WhatsApp OTP";
        }
    }

    /* loaded from: classes3.dex */
    public @interface ScanQRProperties {
        public static final String APP_ID = "App ID";
        public static final String CAMERA_LIGHT_TURNED_ON = "Camera Light Turned On";
        public static final String DECODE_TYPE = "Decode Type";
        public static final String IS_NATIVE = "isNative";
        public static final String QR_BIZ_TYPE = "Biz Type";
        public static final String QR_DECODE_RESULT = "QR Decode Result";
        public static final String QR_DECODE_TIME = "Decode Time";
        public static final String QR_RESULT_ACTION = "QR Result Action";
        public static final String QR_SCAN_TIME = "Scan Time";
        public static final String QR_SOURCE = "QR Source";
        public static final String SCANNER_FAIL_REASON = "Fail Reason";
        public static final String SCANNER_READY_TIME = "Camera Ready Time";
        public static final String SERVICE_KEY = "Service Key";
    }

    /* loaded from: classes3.dex */
    public @interface ScanQRSourceType {
        public static final String QR_SOURCE_GALLERY = "Gallery";
        public static final String QR_SOURCE_SCAN = "Scan";
    }

    /* loaded from: classes3.dex */
    public @interface ScannerAction {
        public static final String DECODE_CODE = "Decode Code";
        public static final String DECODE_CODE_GALLERY_ERROR = "Decode Gallery OnError";
        public static final String ERROR = "Error";
        public static final String ERROR_CODE_NOT_WHITE_LIST = "Error Code NotWhitelisted";
        public static final String ERROR_NON_SPLITBILL_PAYER = "Error Non SplitBillPayer";
        public static final String ERROR_QR_BARCODE = "Error QrBarcode";
        public static final String ERROR_SCAN_IT_SELF = "Error Scan ItSelf";
        public static final String OPEN_H5_SCAN = "H5 ScanHandler";
    }

    /* loaded from: classes3.dex */
    public @interface SendMoneyProperties {
        public static final String ADD_NEW_BANK = "Add New Bank";
        public static final String CONTINUE_OVERSEAS = "Continue Overseas";
        public static final String COUNTRY_ISO = "Country ISO";
        public static final String COUNTRY_NAME = "Country Name";
        public static final String DANA_HOME_PAGE = "DANA Home Page";
        public static final String DESTINATION = "Destination";
        public static final String DURATION = "Duration";
        public static final String FEATURE_JOURNEY = "Feature Journey";
        public static final String FEATURE_NAME = "Feature Name";
        public static final String FEATURE_TIME = "Feature Time";
        public static final String FRICTION_TYPE = "Friction Type";
        public static final String HAS_COMMENT = "Has Comment";
        public static final String HIT_TIME = "Hit Time";
        public static final String ISSUER_BANK_NAME = "Issuer Bank Name";
        public static final String IS_API_CALL_SUCCESS = "Is Success";
        public static final String IS_CONTINUE = "Is Continue";
        public static final String IS_FAVORITE = "isFavorite";
        public static final String IS_QRIS = "Is QRIS";
        public static final String IS_RECENT = "Is Recent";
        public static final String LAST_TRANSACTION = "Last Transaction";
        public static final String METHOD_TRANSFER = "Method Transfer";
        public static final String NEW_USER = "New User";
        public static final String NUMBER_OF_CONTACTS = "Number Of Contacts";
        public static final String NUMBER_OF_FREE_TRANSFER = "Send Money Number of Free Transfer";
        public static final String P2P_RECIPIENT_TYPE = "P2P Recipient Type";
        public static final String PAID_AMOUNT = "Paid Amount";
        public static final String RECIPIENT_DESTINATION_TYPE = "Recipient Destination Type";
        public static final String RECIPIENT_SOURCE = "Recipient Source";
        public static final String RECIPIENT_USER_ID = "Recipient User ID";
        public static final String RENDER_TIME = "Render Time";
        public static final String SENDER_CONTACT_COUNT = "Sender Contact Count";
        public static final String SENDER_PAYMENT_METHOD = "Sender Payment Method";
        public static final String SEND_AND_WITHDRAW_CHANNEL = "Send & Withdraw Channel";
        public static final String SEND_MONEY_AMOUNT = "Send Money Amount";
        public static final String SEND_MONEY_CLAIM_LINK_EXPIRY = "Send Money Claim Link Expiry";
        public static final String SEND_MONEY_PAGE = "Send Money Page";
        public static final String SEND_MONEY_SMART_FRICTION = "Send Money Smart Friction";
        public static final String SHARE_TO_FEED = "Share to Feed";
        public static final String TNC = "T&C";
        public static final String TOTAL_AMOUNT = "Total Amount";
        public static final String TRANSACTION_TYPE = "Transaction Type";
        public static final String X2C_HIT_TIME_BIZTRANSFER = "Hit Time (Biztransfer.init)";
        public static final String X2C_HIT_TIME_WITHDRAW = "Hit Time (Withdraw.init)";
    }

    /* loaded from: classes3.dex */
    public @interface ServiceProperty {
        public static final String SERVICE_CATEGORY = "Service Category";
        public static final String SERVICE_DIRECT_OPEN = "Direct Open";
        public static final String SERVICE_LINK = "Service Link";
        public static final String SERVICE_NAME = "Service Name";
        public static final String SERVICE_OPEN_SOURCE = "Service Open Source";
    }

    /* loaded from: classes3.dex */
    public @interface SmartFrictionProperties {
        public static final String ACCOUNT_FREEZE = "Account Freeze";
        public static final String BALANCE_LIMIT = "Balance Limit";
        public static final String BANK = "BANK";
        public static final String BLACKLIST = "Blacklist";
        public static final String IS_CONTINUE = "is Continue";
        public static final String MONTHLY_FUND_IN_LIMIT = "Monthly Fund In Limit";
        public static final String NON_DANA_USER = "Non DANA User";
        public static final String NOT_IN_CONTACT_LIST = "Not in Contact List";
        public static final String NOT_IN_RECENT_BANK = "Not in Recent Bank";
        public static final String RECIPIENT_DESTINATION = "Recipient Destination";
        public static final String SCENARIO = "Scenario";
        public static final String SUSPICOUS_ACCOUNT = "Suspicious Account";
    }

    /* loaded from: classes3.dex */
    public @interface SourceType {
        public static final String ACCOUNT_LINKING = "Account Linking";
        public static final String ALL_SERVICE = "All Service";
        public static final String BALANCE_ARROW = "Balance Arrow";
        public static final String BANNER = "Banner";
        public static final String CAMERA_CARD = "Camera Card";
        public static final String CHANGE_PIN = "Change PIN";
        public static final String CLICK = "Click";
        public static final String CPM = "CPM";
        public static final String DANA_CICIL_DASHBOARD = "DANA CICIL dashboard";
        public static final String DANA_NEWS = "Dana News";
        public static final String DANA_PROTECTION = "DANA Protection";
        public static final String DEEPLINK = "Deeplink";
        public static final String DEEP_LINK = "Deep Link";
        public static final String EXPLORE = "Explore";
        public static final String EXPLORE_FIRST_TIME = "Explore First Time";
        public static final String EXPLORE_PAGE = "Explore Page";
        public static final String EXPLORE_WIDGET = "Explore Widget";
        public static final String EXPRESS_PURCHASE = "Express Purchase";
        public static final String FAMILY_ACCOUNT = "Family Account";
        public static final String FEED_NOTIFICATOIN_PAGE = "Feed Notification Page";
        public static final String FORGOT_PIN = "Forgot PIN";
        public static final String FOUR_KING_KONG = "Four King Kong";
        public static final String FRIENDS_FEED = "Friends Feed";
        public static final String FROM_SPLIT_BILL_HISTORY = "From split bill history";
        public static final String GALLERY = "Gallery";
        public static final String GLOBAL_SEARCH = "Global Search";
        public static final String GROUP_SEND = "Group Send";
        public static final String HOME = "Home";
        public static final String HOMEPAGE_CLICK = "Homepage Click";
        public static final String HOME_PAY_BUTTON = "Home Pay Button";
        public static final String INBOX_ICON = "Inbox Icon";
        public static final String INBOX_PAGE = "Inbox Page";
        public static final String JS_API = "Js Api";
        public static final String LOGIN = "Login";
        public static final String ME = "Me";
        public static final String MERCHANT_DETAIL = "Merchant Detail";
        public static final String ME_PAGE = "Me Page";
        public static final String MINI_PROGRAM = "Mini Program";
        public static final String MY_BILLS = "My Bills";
        public static final String MY_BILLS_WIDGET = "Widget";
        public static final String NEARBY_DETAIL_OPEN = "Nearby Detail Open";
        public static final String NEARBY_MAPS = "Nearby Maps";
        public static final String NEARBY_ME_DETAIL = "Nearby Detail";
        public static final String NEARBY_ME_LIST = "Nearby List";
        public static final String NEARBY_OPEN = "Nearby Open";
        public static final String NEARBY_REVIEW_LIST_OPEN = "Nearby Review List Open";
        public static final String NEARBY_SHOP_LIST = "Nearby Shop List";
        public static final String NOTIFICATION = "Notification";
        public static final String ONLINE_MERCHANT_LIST = "Merchant List";
        public static final String PROFILE = "Profile";
        public static final String PROFILE_PAGE = "Profile Page";
        public static final String PROMOTION = "Promotion";
        public static final String PROMO_QUEST_AT_HOME = "Promo Quest At Home";
        public static final String PROMO_QUEST_DEEPLINK = "Promo Quest Deeplink";
        public static final String PUSH_NOTIFICATION = "Push Notification";
        public static final String QR_CARD = "QR Card";
        public static final String REFERRAL = "Referral";
        public static final String REFERRAL_DEEPLINK = "Referral Deeplink";
        public static final String REFERRAL_NONE = "None";
        public static final String REGISTER = "Register";
        public static final String REGISTRATION = "Registration";
        public static final String REQUEST_MONEY = "Request Money";
        public static final String REQUEST_MONEY_TO_BANK_WITHOUT_AMOUNT = "Request Money without Amount to Bank Account";
        public static final String REQUEST_MONEY_TO_BANK_WITH_AMOUNT = "Request Money with Amount to Bank Account";
        public static final String REQUEST_MONEY_WITHOUT_AMOUNT = "Request Money without Amount";
        public static final String REQUEST_MONEY_WITH_AMOUNT = "Request Money with Amount";
        public static final String RESULT_ON_MAP = "Result on Map";
        public static final String SCAN_QR = "Scan QR";
        public static final String SEARCH_LIST = "Search List";
        public static final String SEND_MONEY = "Send Money";
        public static final String SEND_TO_FRIEND_CONTACT_SELECT = "Send to Friend Contact Select";
        public static final String SEND_TO_FRIEND_SEARCH_SELECT = "Send to Friend Search Select";
        public static final String SERVICES = "Services";
        public static final String SHOP_LIST = "Shop List";
        public static final String SPLITBILL = "Split Bill";
        public static final String SPLITBILL_DEEPLINK = "Split Bill Deeplink";
        public static final String SPLIT_BILL_CREATED = "Split bill created";
        public static final String SPLIT_BILL_LANDING_PAGE = "Split Bill Landing Page";
        public static final String SWIPE = "Swipe";
        public static final String SWIPE_HOME = "Swipe Home";
        public static final String SWIPE_RIGHT = "Swipe Right";
        public static final String TAB_BAR = "Tab Bar";
        public static final String TRANSACTION_DETAIL = "Transaction Detail";
        public static final String TRANSFER_OVERSEAS = "Transfer Overseas";
        public static final String UNDEFINED = "Undefined";
        public static final String USER = "User";
        public static final String USER_INPUT = "User Input";
        public static final String VOICE_ASSISTANT = "Voice Assistant";
        public static final String WALLET_ADD_ASSET = "Wallet Add Asset";
        public static final String WALLET_CARD = "Wallet Card";
        public static final String WALLET_DETAIL = "Wallet Detail";
        public static final String WALLET_INVESTMENT_LIST = "Wallet Investment List";
        public static final String WALLET_SEARCH = "Wallet Search";
    }

    /* loaded from: classes3.dex */
    public @interface SplitBillProperties {
        public static final String INCLUDE_SELF = "Include Self";
        public static final String IS_PAYER = "Is payer";
        public static final String MARK_AS_PAID_USER = "Mark as Paid User";
        public static final String NOTES = "Notes";
        public static final String SPLIT_BILL_EXPIRED_COUNT = "Split Bill Expired Count";
        public static final String SPLIT_BILL_ON_PROCESS_COUNT = "Split Bill On Process Count";
        public static final String SPLIT_BILL_SHARE_TO = "Split Bill Share To";
        public static final String SPLIT_BILL_STATUS = "Split Bill Status";
        public static final String SPLIT_BILL_SUCCESS_COUNT = "Split Bill Success Count";
        public static final String TOTAL_AMOUNT = "Total Amount";
        public static final String TOTAL_PARTICIPANT = "Total Participant";
    }

    /* loaded from: classes3.dex */
    public @interface SuggestionOrderType {
        public static final String ORDER_FOUR = "Order 4";
        public static final String ORDER_MORE_THAN_FOUR = "More Than 4";
        public static final String ORDER_ONE = "Order 1";
        public static final String ORDER_THREE = "Order 3";
        public static final String ORDER_TWO = "Order 2";
    }

    /* loaded from: classes3.dex */
    public @interface SuperProperties {
        public static final String APP_NAME = "App Name";
        public static final String ENVIRONMENT = "Environment";
        public static final String GPS_STATUS = "GPS Status";
        public static final String LATITUDE = "Latitude";
        public static final String LOCATION_MOCKED = "Location Mocked";
        public static final String LONGITUDE = "Longitude";
        public static final String MIXPANEL_LATITUDE = "$latitude";
        public static final String MIXPANEL_LONGITUDE = "$longitude";
        public static final String UTDID = "UTDID";
    }

    /* loaded from: classes3.dex */
    public @interface TransactionType {
        public static final String ACQUIRING = "Acquiring";
        public static final String SEND_MONEY = "Send Money";
        public static final String SEND_TO_CASH = "Send to Cash";
        public static final String WITHDRAW = "Withdraw";
    }

    /* loaded from: classes3.dex */
    public @interface UserPersonalizationProperties {
        public static final String SELECTED_CATEGORY = "Selected Category";
    }

    /* loaded from: classes3.dex */
    public @interface WalletAddAssetSource {
        public static final String ADD_FINANCIAL_SECTION = "Financials Section Add";
        public static final String ADD_IDENTITY_SECTION = "Identity Section Add";
        public static final String ADD_LOYALTY_SECTION = "Loyalty Section Add";
        public static final String ADD_PAYMENT_SECTION = "Payment Section Add";
        public static final String ADD_VOUCHER_SECTION = "Vouchers Section Add";
    }

    /* loaded from: classes3.dex */
    public @interface WalletDanaDealsVersion {
        public static final String DANA_DEALS_NEW_UI = "New UI";
        public static final String DANA_DEALS_OLD_UI = "Old UI";
    }

    /* loaded from: classes3.dex */
    public @interface WalletPocketAssetType {
        public static final String LOYALTY = "Loyalty";
        public static final String TICKET = "Ticket";
        public static final String VOUCHER = "Voucher";
        public static final String VOUCHER_CODE = "Voucher Code";
    }
}
