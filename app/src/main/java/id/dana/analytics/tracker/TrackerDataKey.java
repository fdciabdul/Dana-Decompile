package id.dana.analytics.tracker;

/* loaded from: classes8.dex */
public interface TrackerDataKey {

    /* loaded from: classes3.dex */
    public @interface BindingProperties {
        public static final String MERCHANT_NAME = "Merchant Name";
        public static final String SUCCESS = "Success";
    }

    /* loaded from: classes3.dex */
    public @interface Event {
        public static final String BOT_DETECTION = "Bot Detection";
        public static final String CI_AUTHENTICATION = "CI Authentication";
        public static final String CONFIG_REQUEST_DURATION = "Config Request Duration";
        public static final String DISPLAYED_ERROR = "Displayed Error";
        public static final String GEOCODE_REVERSE = "Geocode Reverse";
        public static final String HERE_AUTO_SUGGEST = "HERE Auto Suggest";
        public static final String HERE_DISCOVER_CHAIN_QUERY = "HERE Discover Chain Query";
        public static final String HERE_USAGE = "HERE Usage";
        public static final String HOME_ASSET_READY = "Home Assets Ready";
        public static final String INBOX_PAGE_OPEN = "Inbox Page Open";
        public static final String LOCATION_PERMISSION_AT_ONBOARDING_OPEN = "Location Permission at Onboarding Page Open";
        public static final String LOGIN = "Login";
        public static final String MINIPROGRAM_BINDING_SUCCESS = "Mini Program Binding Success";
        public static final String MINIPROGRAM_REQUEST_AGREEMENT = "Mini Program Request Agreement";
        public static final String MINIPROGRAM_SHOW_AGREEMENT = "Mini Program Show Agreement";
        public static final String MINIPROGRAM_TRADE_PAY = "Mini Program Trade Pay";
        public static final String MORE_FOR_YOU_ARTICLE_OPEN = "More For You Article Open";
        public static final String NATIVE_LOCATION_PERMISSION = "Native System Location Permission during Onboarding Open";
        public static final String NETWORK_ERROR = "Network Error";
        public static final String PIN_CHANGE = "PIN Change";
        public static final String PIN_CHANGE_PROMPT = "PIN Change Prompt";
        public static final String PLACE_AUTO_COMPLETE = "Place Auto Complete";
        public static final String PLACE_DETAIL = "Place Detail";
        public static final String REGISTRATION = "Registration";
        public static final String REGISTRATION_CHALLENGE = "Registration Challenge";
        public static final String REGISTRATION_COMPLETE = "Registration Complete";
        public static final String SERVICE_FEATURED_DISPLAYED = "Service Featured Displayed";
        public static final String STORAGE_TAG = "Storage Size";
        public static final String SYNC_CONTACT = "Sync Contact";
        public static final String TAP_FOUR_KING = "Tap Four King";
        public static final String TRANSACTION_COMPLETE = "Transaction Complete";
        public static final String USER_CAMERA_PERMISSION = "User Camera Permission";
        public static final String USER_CONSENT = "User Consent";
        public static final String USER_CONTACT_PERMISSION = "User Contacts Permission";
        public static final String USER_FILE_PERMISSION = "User File Permission";
        public static final String USER_LOCATION_PERMISSION = "User Location Permission";
        public static final String USER_MICROPHONE_PERMISSION = "User Microphone Permission";
        public static final String USER_NFC_PERMISSION = "User NFC Permission";
        public static final String USER_PHONE_CALL_LOG_PERMISSION = "User Phone Call Log Permission";
        public static final String USER_PHONE_CALL_PERMISSION = "User Phone Call Permission";
        public static final String USER_PHONE_STATE_PERMISSION = "User Phone State Permission";
        public static final String USER_PHOTOS_AND_MEDIA_PERMISSION = "User Photos and Media Permission";
        public static final String USER_PUSH_NOTIFICATION_PERMISSION = "User Push Notification Permission";
    }

    /* loaded from: classes3.dex */
    public @interface HEREProperties {
        public static final String FAIL_REASON = "Fail Reason";
        public static final String IS_SUCCESS = "Is Success";
        public static final String USAGE = "Usage";

        /* loaded from: classes3.dex */
        public @interface UsageProperties {
            public static final String AUTO_SUGGEST = "Auto Suggest";
            public static final String DISCOVER = "Discover";
            public static final String OAUTH_TOKEN = "oAuth Token";
            public static final String REVERSE_GEOCODE = "Reverse Geocode";
        }
    }

    /* loaded from: classes3.dex */
    public @interface LoginProperties {
        public static final String ERROR_CODE = "errorCode";
        public static final String ERROR_MESSAGE = "errorMessage";
        public static final String HOLD_LOGIN_VERSION = "Hold Version";
        public static final String IS_SUCCESS = "Is Success";
        public static final String LOGIN_CHALLENGE = "Login Challenge";
        public static final String LOGIN_TYPE = "Login Type";
        public static final String SMS_OTP_ARRIVAL_IN_MILLIS = "SMS OTP Arrival In Millis";
        public static final String SMS_OTP_FLOW_IN_MILLIS = "SMS OTP Flow In Millis";
        public static final String WHATSAPP_OTP_ARRIVAL_IN_MILLIS = "Whatsapp OTP Arrival In Millis";
        public static final String WHATSAPP_OTP_FLOW_IN_MILLIS = "Whatsapp OTP Flow In Millis";
    }

    /* loaded from: classes3.dex */
    public @interface LoginType {
        public static final String HOLD_LOGIN = "Hold";
        public static final String LOGIN_PIN = "Password";
        public static final String OTP_SMS = "OTP SMS";
    }

    /* loaded from: classes3.dex */
    public @interface MixpanelSourceType {
        public static final String ANALYTICS_SDK = "Analytics SDK";
        public static final String MIXPANEL_DATA_TRACKER = "MixpanelDataTracker";
    }

    /* loaded from: classes3.dex */
    public @interface MoreForYouProperties {
        public static final String CONTENT_ID = "Content ID";
        public static final String CONTENT_NAME = "Content Name";
        public static final String CONTENT_TYPE = "Content Type";
        public static final String EXPIRY_DATE = "Expiry Date";
        public static final String REDIRECT_URL = "Redirect URL";
        public static final String SPACE_CODE = "Space Code";
    }

    /* loaded from: classes3.dex */
    public @interface NetworkErrorOperationTypeProperty {
        public static final String BIZTRANSFER_INIT = "alipayplus.mobilewallet.biztransfer.init";
        public static final String BIZTRANSFER_SUBMIT = "alipayplus.mobilewallet.biztransfer.submit";
        public static final String CHECK_PHONE_NUMBER_AND_SEND_OTP = "alipayplus.mobilewallet.user.checkRegisteredUserAndSendOTP";
        public static final String CREATE_PAYMENT_ORDER_CPM = "dana.kybprod.merchant.paymentrequest.createOrderCPM";
        public static final String DECODE_QR = "alipayplus.mobilewallet.qr.decode";
        public static final String FORGET_PASSWORD_CONSULT = "wallet/api/alipayplus.mobilewallet.user.security.forgetPwdConsult.json";
        public static final String GET_AUTH_CODE = "alipayplus.mobilewallet.oauth.authcode.apply";
        public static final String GET_MERCHANT_INFO = "dana.kybprod.merchant.information.get";
        public static final String GET_USER_INFO = "alipayplus.mobilewallet.wallet.user.info";
        public static final String LOGIN = "alipayplus.mobilewallet.user.login";
        public static final String PASSWORD_VERIFY = "id.dana.userprod.user.password.verify";
        public static final String QUERY_AUTH_INFO = "id.dana.authprod.queryAuthInfo";
        public static final String QUERY_DETAIL_PUSH_CHALLENGE = "id.dana.userprod.user.pushverification.querydetailpushchallenge";
        public static final String QUERY_LIST_PUSH_CHALLENGE = "id.dana.userprod.user.pushverification.querylistpushchallenge";
        public static final String REGISTER = "alipayplus.mobilewallet.user.register.normalRegister";
        public static final String REQUEST_MONEY_QR_TRANSFER = "alipayplus.mobilewallet.qr.transfer";
        public static final String REQUEST_MONEY_QR_TRANSFER_BANK = "alipayplus.mobilewallet.qr.transfer.bank";
        public static final String REQUEST_MONEY_QR_USER = "alipayplus.mobilewallet.qr.user";
        public static final String REQUEST_MONEY_QR_USER_BANK = "alipayplus.mobilewallet.qr.user.bank";
        public static final String SAVE_USER_CONFIG = "alipayplus.mobilewallet.user.config.store";
        public static final String SEND_OTP = "alipayplus.mobilewallet.user.security.sendOtp";
        public static final String SEND_OTP_BANK = "alipayplus.mobilewallet.user.asset.sendBankOtp.json";
        public static final String SPLIT_BILL_DETAIL = "dana.mobilewallet.get.splitbill.detail";
        public static final String SPLIT_BILL_GET_HISTORY = "dana.mobilewallet.splitbill.gethistory";
        public static final String SPLIT_BILL_QR = "alipayplus.mobilewallet.qr.splitbill";
        public static final String TRANSFER_BALANCE_INIT = "id.dana.transferprod.transfer.balance.init";
        public static final String TRUST_RISK_LOGIN_V2 = "id.dana.userprod.user.trust.risk.login";
        public static final String VERIFY_BANK_PHONE = "alipayplus.mobilewallet.user.asset.verifyBankPhoneNoAndSendOtp.json";
        public static final String VERIFY_OTP = "alipayplus.mobilewallet.user.security.verifyOtp";
        public static final String VERIFY_OTP_RISK = "alipayplus.mobilewallet.product.security.verify";
        public static final String VERIFY_PUSH_CHALLENGE = "id.dana.userprod.user.pushverification.verify";
        public static final String VERIFY_SECURITY_PRODUCT = "id.dana.userprod.product.security.verify";
        public static final String WITHDRAW_INIT = "alipayplus.mobilewallet.withdraw.init";
        public static final String WITHDRAW_NAME_CHECK = "alipayplus.mobilewallet.withdraw.namecheck";
    }

    /* loaded from: classes3.dex */
    public @interface NotificationInboxProperty {
        public static final String CONTENT_TYPE = "Content Type";
        public static final String ICON_URL = "Icon URL";
        public static final String NOTIFICATION_ID = "Notification ID";
        public static final String REDIRECT_TYPE = "Redirect Type";
        public static final String REDIRECT_VALUE = "Redirect Value";
        public static final String USECASE_TYPE = "Usecase Type";
    }

    /* loaded from: classes3.dex */
    public @interface PeopleProperty {
        public static final String USER_COHORT = "User Cohort";
        public static final String USER_ID = "$user_id";
    }

    /* loaded from: classes3.dex */
    public @interface Property {
        public static final String ACTION_TAKEN = "Action Taken";
        public static final String ALL_SERVICE_LOAD_TIME = "All Service Load Time";
        public static final String APP_ID = "App ID";
        public static final String BALANCE_LOAD_TIME = "Balance Load Time";
        public static final String BOTTOM_BAR_LOAD_TIME = "Bottom Bar Load Time";
        public static final String BOT_SCORE = "Bot Score";
        public static final String CHECK_PHONE_NUMBER_LOGIC_IN_MILLIS = "Native Logic - Check Phone Number Logic In Millis";
        public static final String CLIENT_IP = "Client IP";
        public static final String CONNECTION_STATUS = "Connection Status";
        public static final String CONTENT_TYPE = "Content Type";
        public static final String CONVERSION_TIME = "Conversion Time";
        public static final String CORRELATION_ID = "Correlation Id";
        public static final String DANA_PROTECTION_LOAD_TIME = "Dana Protection Load Time";
        public static final String DISPLAYED_MESSAGE = "Displayed Message";
        public static final String ENABLE_QUEUE_POOL_TIME_LIMIT = "Enable Queue Pool Time Limit";
        public static final String ENABLE_REWRITE_SESSION = "Enable Rewrite Session";
        public static final String ERROR_CODE = "Error Code";
        public static final String ERROR_MESSAGE = "Error Message";
        public static final String ERROR_REASON = "Error Reason";
        public static final String EVURL = "EVURL";
        public static final String FACE_AUTH_PROCESS_IN_MILLIS = "Face Auth Process in Millis";
        public static final String FEATURE = "Feature";
        public static final String FEED_LOAD_TIME = "Feed Load Time";
        public static final String FOUR_KING = "Four King Load Time";
        public static final String GEOCODER_APP_LAYER_CALLER = "Geocoder App Layer Caller";
        public static final String GEOCODER_DOMAIN_LAYER_CALLER = "Geocoder Domain Layer Caller";
        public static final String GEOCODER_ERROR = "Geocoder Error";
        public static final String GEOCODER_IS_DATA_COMPLETED = "Geocoder Data Completed";
        public static final String GEOCODER_SOURCE = "Geocoder Source";
        public static final String GEOCODER_UUID = "Geocoder UUID";
        public static final String HOLD_LOGIN_PROCESS_DURATION = "Hold Login Process Duration";
        public static final String HOME_INVESTMENT_LOAD_TIME = "Home Investment Load Time";
        public static final String HOME_PERSONALIZATION_LOAD_TIME = "Home Personalization Load Time";
        public static final String HTTP = "HTTP";
        public static final String IS_HEADER_ENRICHMENT = "Is Header Enrichment";
        public static final String IS_REQUEST_NETWORK = "Is Request Network";
        public static final String IS_WIFI = "Is Wifi";
        public static final String KEYWORD_LIST = "Keyword List";
        public static final String KYC_LEVEL = "KYC Level";
        public static final String MORE_FOR_YOU_LOAD_TIME = "More For You Load Time";
        public static final String NATIVE_PERFORMANCE_DURATION_IN_MILLIS = "Native Performance Duration in Millis";
        public static final String NEARBY_LOAD_TIME = "Nearby Load Time";
        public static final String NON_NATIVE_PERFORMANCE_DURATION_IN_MILLIS = "Non Native Performance Duration in Millis";
        public static final String NOTIFICATION_LOAD_TIME = "Notification Icon Load Time";
        public static final String OPERATION_TYPE = "Operation Type";
        public static final String PERMISSION_PROCESSING_LOGIN_IN_MILLIS = "Native Logic - Permission Processing Logic in Millis";
        public static final String PROCESSING_STATUS = "Processing Status";
        public static final String PROMO_CAROUSEL_LOAD_TIME = "Promo Carousel Load Time";
        public static final String REFERENCE_ID = "Reference Id";
        public static final String RENDER_INPUT_PIN_SCREEN = "Render Input PIN Screen";
        public static final String RENDER_INTRODUCTION_SCREEN = "Render Introduction Screen";
        public static final String RENDER_PERMISSION_SCREEN = "Render Permission Screen";
        public static final String RENDER_PHONE_NUMBER_SCREEN = "Render Phone Number Screen";
        public static final String RENDER_SMS_OTP_DIALOG_SCREEN = "Render SMS OTP Dialog";
        public static final String RENDER_WA_OTP_DIALOG_SCREEN = "Render WhatsApp OTP Dialog";
        public static final String REQUESTER_OPERATION_TYPE = "Requester Operation Type";
        public static final String RESEND_SMS_OTP_LOGIC_IN_MILLIS = "Native Logic - Resend SMS OTP Logic in Millis";
        public static final String RESEND_WHATSAPP_OTP_LOGIC_IN_MILLIS = "Native Logic - Resend WhatsApp OTP Logic in Millis";
        public static final String RESPONSE_CODE = "Response Code";
        public static final String RESPONSE_MESSAGE = "Response Message";
        public static final String RESULT_STATUS = "Result Status";
        public static final String RETRIES = "Retries";
        public static final String SEND_SMS_OTP_LOGIC_IN_MILLIS = "Native Logic - Send SMS OTP Logic in Millis";
        public static final String SEND_WA_OTP_LOGIC_IN_MILLIS = "Native Logic - Send WhatsApp OTP Logic in Millis";
        public static final String SERVICE_HIGHLIGHT = "Service Highlight";
        public static final String SERVICE_HIGHLIGHT_BUTTON = "Service Highlight Button";
        public static final String SERVICE_HIGHLIGHT_DESCRIPTION = "Service Highlight Description";
        public static final String SERVICE_HIGHLIGHT_SLOT = "Service Highlight Slot";
        public static final String SESSION_ID_AFTER = "Session Id After";
        public static final String SESSION_ID_BEFORE = "Session Id Before";
        public static final String SESSION_ID_IN_COOKIEMANAGER = "Session Id in Cookie Manager";
        public static final String SOURCE = "Source";
        public static final String STATUS = "Status";
        public static final String STORAGE_INFO = "Total Size Used";
        public static final String STORAGE_LOG = "Storage Log";
        public static final String SUCCESS = "Success";
        public static final String SYNC_CONTACT_VERSION = "Sync Contact Version";
        public static final String TOTAL_CONTACT_SIZE = "Total Contact Size";
        public static final String TRACE_ID = "Trace ID";
        public static final String TRANS_TYPE = "Transaction Type";
        public static final String TYPING_PHONE_NUMBER_IN_MILLIS = "Typing Phone Number In Millis";
        public static final String TYPING_PIN_IN_MILLIS = "Typing PIN In Millis";
        public static final String TYPING_SMS_OTP_IN_MILLIS = "Typing SMS OTP in Millis";
        public static final String TYPING_WA_OTP_IN_MILLIS = "Typing WhatsApp OTP in Millis";
        public static final String UI_VERSION = "UI Version";
        public static final String UPLOADED_CONTACT = "Uploaded Contact";
        public static final String UPLOADING_CONTACT = "Uploading Contact";
        public static final String USER_IDLE_INPUT_PIN_SCREEN = "User Idle Input PIN Screen";
        public static final String USER_IDLE_INTRODUCTION_SCREEN = "User Idle Introduction Screen";
        public static final String USER_IDLE_PERMISSION_SCREEN = "User Idle Permission Screen";
        public static final String USER_IDLE_PHONE_NUMBER_SCREEN = "User Idle Phone Number Screen";
        public static final String UUID = "UUID";
        public static final String VERIFY_PIN_LOGIC_IN_MILLIS = "Native Logic - Verify PIN Logic In Millis";
        public static final String VERIFY_SMS_OTP_LOGIC_IN_MILLIS = "Native Logic - Verify SMS OTP Logic in Millis";
        public static final String VERIFY_WHATSAPP_OTP_LOGIC_IN_MILLIS = "Native Logic - Verify WhatsApp OTP Logic in Millis";
        public static final String WAITING_TIME = "Waiting Time";
        public static final String WHAT_S_NEW_LOAD_TIME = "What's New Load Time";
    }

    /* loaded from: classes3.dex */
    public @interface Source {
        public static final String CAMERA_CARD_DECODE_GALLERY = "Camera Card Decode Gallery";
        public static final String CAMERA_CARD_DECODE_ONLINE = "Camera Card Decode Online";
        public static final String CAMERA_CARD_FETCH_DEEPLINK_PROPERTIES = "Camera Card Fetch Deeplink Properties";
        public static final String CAMERA_CARD_GALLERY_PICKER = "Camera Card Gallery Picker";
        public static final String CAMERA_CARD_PROCESS_DEEPLINK = "Camera Card Process Deeplink";
        public static final String CASHIER_NATIVE = "Cashier Native";
        public static final String CASHIER_NATIVE_DEEPLINK = "Cashier Native - Deeplink Payment";
        public static final String DANA_STATEMENT = "Dana Statement";
        public static final String DEEPLINK_BINDING = "Deeplink Binding";
        public static final String HOLD_LOGIN = "Hold login";
        public static final String HOME = "Home";
        public static final String KYB_NATIVE_HOMEPAGE = "KYB Native Homepage";
        public static final String LOGIN = "Login";
        public static final String ME_PAGE = "Me Page";
        public static final String MINI_PROGRAM = "Mini Program";
        public static final String NEARBY_2 = "Nearby 2.0";
        public static final String NEARBY_X = "Nearby X";
        public static final String ONBOARDING_PAGE_INPUT_PHONE_NUMBER = "Onboarding phone number input";
        public static final String ONBOARING_PAGE_LOCATION_PERMISSION = "Location Permission at Onboarding Page";
        public static final String PIN_CHANGE_PROMPT = "PIN Change Prompt";
        public static final String PUSH_VERIFY = "Push Verify";
        public static final String REGISTRATION = "Registration";
        public static final String REQUEST_MONEY = "Request Money Landing Page";
        public static final String REQUEST_MONEY_ADD_NEW_BANK = "Request Money Add New Bank";
        public static final String SEND_AND_WITHDRAW_CASH = "Send and Withdraw Cash";
        public static final String SEND_MONEY_ADD_NEW_BANK = "Send Money Add New Bank";
        public static final String SEND_MONEY_CONFIRM = "Send Money Confirm";
        public static final String SEND_MONEY_LANDING_PAGE = "Send Money Landing Page";
        public static final String SEND_MONEY_QUICK_SEND_REMOVE_BANK = "Send Money Quick Send Remove Bank";
        public static final String SEND_MONEY_QUICK_SEND_REMOVE_CONTACT = "Send Money Quick Send Remove Contact";
        public static final String SEND_MONEY_QUICK_SEND_REMOVE_GROUP = "Send Money Quick Send Remove Group";
        public static final String SEND_MONEY_SUMMARY_OPEN = "Send Money Summary Open";
        public static final String SEND_MONEY_UPDATE_BANK_NAME = "Send Money Update Bank Name";
        public static final String SPLIT = "Split";
        public static final String SPLIT_BILL_HISTORY = "Split Bill History";
        public static final String SPLIT_BILL_SUMMARY = "Split Bill Summary";
        public static final String VERIFY_PHONE_NUMBER = "Onboarding Input Phone";
    }

    /* loaded from: classes3.dex */
    public @interface SuperProperties {
        public static final String MIXPANEL_SOURCE = "Mixpanel Source";
        public static final String SPLUNK_SESSION_ID = "Splunk Session ID";
    }

    /* loaded from: classes3.dex */
    public @interface UserConsentProperties {
        public static final String DO_CONSENT = "Do Consent";
        public static final String PURPOSE = "Purpose";
        public static final String TYPE = "Type";

        /* loaded from: classes3.dex */
        public @interface UserConsentType {
            public static final String MINI_PROGRAM = "mini program";
            public static final String SERVICE = "service";
        }
    }

    /* loaded from: classes3.dex */
    public @interface ViewScreenName {
        public static final String DANA_VIZ_SCREEN = "DANA_VIZ_SCREEN";
        public static final String INPUT_PIN_SCREEN = "INPUT_PIN_SCREEN";
        public static final String INTRODUCTION_SCREEN = "INTRODUCTION_SCREEN";
        public static final String PERMISSION_LOCATION_SCREEN = "PERMISSION_LOCATION_SCREEN";
        public static final String PHONE_NUMBER_SCREEN = "PHONE_NUMBER_SCREEN";
        public static final String SMS_OTP_SCREEN = "SMS_OTP_SCREEN";
        public static final String WA_OTP_SCREEN = "WA_OTP_SCREEN";
    }
}
