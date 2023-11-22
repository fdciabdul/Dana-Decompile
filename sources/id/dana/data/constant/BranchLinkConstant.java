package id.dana.data.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes8.dex */
public interface BranchLinkConstant {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AcCashierParams {
        public static final String CODE_VALUE = "codeValue";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ActionTarget {
        public static final String AC_CASHIER_PAYMENT = "accashierpayment";
        public static final String APPLE_ZONE = "apple_zone";
        public static final String CARD_BINDING = "cardbinding";
        public static final String DANAPOLY = "danapoly";
        public static final String DEEPLINK_PAYMENT = "deeplinkpayment";
        public static final String EXPLORE_ONLINE_MERCHANTS = "onlinemerchants";
        public static final String FAMILY_ACCOUNT = "familyaccount";
        public static final String FAMILY_ACCOUNT_SERVICE = "familyaccountservice";
        public static final String FRIENDSHIP = "home_friendship";
        public static final String HOME = "openhome";
        public static final String IPGREGISTRATION = "ipgregistration";
        public static final String KYBPAGE = "kyb_page";
        public static final String KYB_TRANSACTION_LIST = "kyb_transaction_list";
        public static final String LAZADA = "lazada";
        public static final String MERCHANT_BINDING = "merchantbinding";
        public static final String MERCHANT_DETAIL = "merchantdetail";
        public static final String MINI_APP = "miniapp";
        public static final String MINI_PROGRAM_STORE = "miniprogramstore";
        public static final String MISSION_DETAIL = "missiondetail";
        public static final String MY_BILLS = "mybills";
        public static final String NEARBY = "nearby";
        public static final String NEARBY_ALL_SHOP = "allshops";
        public static final String NEARBY_DETAIL = "nearbydetail";
        public static final String NEARBY_SHOP_LIST = "nearbyshoplist";
        public static final String OAUTH = "oauth";
        public static final String OPEN_ACTIVITY_DETAIL = "activitydetail";
        public static final String OPEN_APP = "openapp";
        public static final String OPEN_GLOBAL_SEARCH = "globalsearch";
        public static final String OPEN_SERVICE = "openservice";
        public static final String PAY_QR = "payqr";
        public static final String PROFILE_PAGE = "profile";
        public static final String PROFILE_QRIS_ALERT = "dummyQRISAlert";
        public static final String PROMO_CENTER = "promocenter";
        public static final String PROMO_CODE = "promocode";
        public static final String PROMO_QUEST = "promoquest";
        public static final String PURCHASE_HISTORY_APPLE_ZONE = "purchase_history_apple_zone";
        public static final String PUSH_VERIFY = "pushverify";
        public static final String QRIS_CASHIER_PAYMENT = "qrisCashierPayment";
        public static final String QR_BIND = "qrBind";
        public static final String REFERRAL = "myreferral";
        public static final String REQUEST_MONEY = "requestmoney";
        public static final String REVIEWMERCHANT = "reviewmerchant";
        public static final String REVIEW_PAGE = "review_page";
        public static final String SAVING = "goals";
        public static final String SCAN = "scan";
        public static final String SEND_MONEY = "sendmoney";
        public static final String SEND_MONEY_BANK = "sendmoneybank";
        public static final String SEND_MONEY_CASHOUT_WITHDRAW = "sendmoneywithdraw";
        public static final String SEND_MONEY_CHAT = "sendmoneychat";
        public static final String SEND_MONEY_GLOBAL = "globaltransfer";
        public static final String SEND_MONEY_GROUPSEND = "groupsend";
        public static final String SEND_MONEY_OUTLET = "sendmoneyoutlet";
        public static final String SEND_MONEY_PHONE = "sendmoneyphone";
        public static final String SERVICES = "services";
        public static final String SETTING_MORE = "setting_more";
        public static final String SMARTPAY = "smartpay";
        public static final String SPLIT_BILL = "splitbill";
        public static final String SPLIT_BILL_DETAIL = "splitbill_detail";
        public static final String STATEMENT = "statement";
        public static final String UPDATE_USERNAME = "updateusername";
        public static final String WALLET = "wallet";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface AppleZoneParams {
        public static final String BIZ_ORDER_ID = "bizOrderId";
        public static final String PAYMENT_ORDER_ID = "paymentOrderId";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface CanonicalIdStarter {
        public static final String MINI_PROGRAM = "miniprogram/%s";
        public static final String MINTA = "minta/%s";
        public static final String PATUNGAN = "patungan/%s";
        public static final String PROFILE = "teman/%s";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DeepLinkErrorCode {
        public static final int SAME_ALIAS = -105;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DeepLinkErrorCodeView {
        public static final String PHONE_NUMBER_NOT_EQUALS = "PHONE_NUMBER_NOT_EQUALS";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface DeepLinkImageUrl {
        public static final String PROFILE_QR = "profile_qr.png";
        public static final String REQUEST_MONEY = "request_money_qr.png";
        public static final String SPLIT_BILL = "split_bill.png";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FamilyAccountDestinations {
        public static final String FAMILY_ACCOUNT_DELETED = "family_account_deleted";
        public static final String INVITATION = "invitation";
        public static final String INVITATION_ACCEPT = "invitation_accept";
        public static final String INVITATION_CANCELLED = "invitation_canceled";
        public static final String INVITATION_DECLINE = "invitation_decline";
        public static final String MEMBER_ACCESS_CHANGED = "member_access_changed";
        public static final String MEMBER_DELETED = "member_deleted";
        public static final String MEMBER_LIMIT_CHANGED = "member_limit_changed";
        public static final String SENDMONEY_REQUEST_APPROVAL = "sendmoney_request_approval";
        public static final String SENDMONEY_REQUEST_DECLINED = "sendmoney_request_declined";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface FamilyAccountParam {
        public static final String DESTINATION = "dest";
        public static final String INVITATION_ID = "invitation_id";
        public static final String ORDER_ID = "orderId";
        public static final String ORGANIZER_NAME = "organizer_name";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface MiniAppParams {
        public static final String BIZ_TYPE = "bizType";
        public static final String NEED_OAUTH = "needOauth";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OauthParams {
        public static final String ACQ_SITE_ID = "acqSiteId";
        public static final String BIND_DANA_TYPE = "bindDanaType";
        public static final String CLIENT_ID = "clientId";
        public static final String IS_IPG_BINDING = "isIpgBinding";
        public static final String MCC = "mcc";
        public static final String MERCHANT_ID = "merchantId";
        public static final String MERCHANT_NAME = "merchantName";
        public static final String NET_AUTH_ID = "netAuthId";
        public static final String PAY_SITE_ID = "paySiteId";
        public static final String PHONE_NUMBER = "phoneNumber";
        public static final String REDIRECT_URL = "redirectUrl";
        public static final String REFERRING_LINK = "referring_link";
        public static final String SCOPES = "scopes";
        public static final String SIGNATURE = "signature";
        public static final String STATE = "state";
        public static final String TERMINAL_TYPE = "terminalType";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ParamValue {
        public static final String PAYEE = "payee";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Params {
        public static final String AMOUNT = "amount";
        public static final String APP_ID = "appId";
        public static final String HAS_NICKNAME = "hasNickname";
        public static final String ID = "id";
        public static final String IGNORE_NICKNAME = "ignoreNickname";
        public static final String LOGIN_ID = "loginId";
        public static final String MISSION_ID = "missionId";
        public static final String PREMIUM_USER = "premiumUser";
        public static final String SCENE = "scene";
        public static final String TYPE = "type";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PathTarget {
        public static final String CONTAINER = "container";
        public static final String CUSTOM_CONTAINER = "custom_container";
        public static final String DECODE = "decode";
        public static final String EXPAND = "expand";
        public static final String FEATURE = "feature";
        public static final String ITUNES = "itunes";
        public static final String MINI_PROGRAM = "miniprogram";
        public static final String OAUTH = "oauth";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PayloadKey {
        public static final String ACTION = "action";
        public static final String ANDROID_URL = "android_url";
        public static final String EXTENDED_INFO = "extendedInfo";
        public static final String FULL_URL = "full_url";
        public static final String INNER_URL = "inner_url";
        public static final String IS_SKIP = "is_skip";
        public static final String PARAMS = "params";
        public static final String PATH = "path";
        public static final String PROMO_CODE = "p";
        public static final String REFERRAL = "r";
        public static final String SHORT_CODE = "c";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PaymentParams {
        public static final String ANDROID_URL = "android_url";
        public static final String OTT = "ott";
        public static final String QRIS = "qrisString";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PrefixAlias {
        public static final String KAGET = "kaget/%s";
        public static final String MINTA = "minta/%s";
        public static final String PATUNGAN = "patungan/%s";
        public static final String QR = "qr/%s";
        public static final String REFERRAL = "ajak?r=%s";
        public static final String SPLIT_BILL_DETAIL = "splitbill-detail?params=[id=%s]";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PushVerifyParams {
        public static final String CACHE_KEY = "cacheKey";
        public static final String TOKEN = "token";
        public static final String TRANSACTION_ID = "trxId";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface WalletSectionParams {
        public static final String FINANCIAL = "financial";
        public static final String IDENTITY = "identity";
        public static final String LOYALTY = "loyalty";
        public static final String PAYMENT = "payment";
        public static final String VOUCHER_AND_TICKET = "voucher_and_ticket";
    }
}
