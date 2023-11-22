package io.branch.referral;

import android.graphics.PointF;
import android.view.View;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.common.log.PageLog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.oauth.OauthConstant;
import id.dana.tracker.constant.TrackerType;
import o.E;

/* loaded from: classes.dex */
public class Defines {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'AppVersion' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class Jsonkey {
        private static int $10 = 0;
        private static int $11 = 1;
        private static final /* synthetic */ Jsonkey[] $VALUES;
        public static final Jsonkey AAID;
        public static final Jsonkey AdType;
        public static final Jsonkey AddressCity;
        public static final Jsonkey AddressCountry;
        public static final Jsonkey AddressPostalCode;
        public static final Jsonkey AddressRegion;
        public static final Jsonkey AddressStreet;
        public static final Jsonkey Affiliation;
        public static final Jsonkey Amount;
        public static final Jsonkey AndroidAppLinkURL;
        public static final Jsonkey AndroidDeepLinkPath;
        public static final Jsonkey AndroidID;
        public static final Jsonkey AndroidPushIdentifier;
        public static final Jsonkey AndroidPushNotificationKey;
        public static final Jsonkey AppIdentifier;
        public static final Jsonkey AppLinks;
        public static final Jsonkey AppVersion;
        public static final Jsonkey BeginAfterID;
        public static final Jsonkey BranchData;
        public static final Jsonkey BranchIdentity;
        public static final Jsonkey BranchKey;
        public static final Jsonkey BranchLinkUsed;
        public static final Jsonkey BranchViewAction;
        public static final Jsonkey BranchViewData;
        public static final Jsonkey BranchViewHtml;
        public static final Jsonkey BranchViewID;
        public static final Jsonkey BranchViewNumOfUse;
        public static final Jsonkey BranchViewUrl;
        public static final Jsonkey Branch_Instrumentation;
        public static final Jsonkey Branch_Round_Trip_Time;
        public static final Jsonkey Brand;
        public static final Jsonkey Bucket;
        private static int BuiltInFictitiousFunctionClassFactory = 1;
        public static final Jsonkey CalculationType;
        public static final Jsonkey CanonicalIdentifier;
        public static final Jsonkey CanonicalUrl;
        public static final Jsonkey ClickedReferrerTimeStamp;
        public static final Jsonkey Clicked_Branch_Link;
        public static final Jsonkey CommerceData;
        public static final Jsonkey Condition;
        public static final Jsonkey ContentActionView;
        public static final Jsonkey ContentAnalyticsMode;
        public static final Jsonkey ContentData;
        public static final Jsonkey ContentDesc;
        public static final Jsonkey ContentDiscovery;
        public static final Jsonkey ContentEvents;
        public static final Jsonkey ContentExpiryTime;
        public static final Jsonkey ContentImgUrl;
        public static final Jsonkey ContentItems;
        public static final Jsonkey ContentKeyWords;
        public static final Jsonkey ContentNavPath;
        public static final Jsonkey ContentPath;
        public static final Jsonkey ContentSchema;
        public static final Jsonkey ContentTitle;
        public static final Jsonkey ContentType;
        public static final Jsonkey Country;
        public static final Jsonkey Coupon;
        public static final Jsonkey CreationSource;
        public static final Jsonkey CreationTimestamp;
        public static final Jsonkey Currency;
        public static final Jsonkey CustomData;
        public static final Jsonkey CustomerEventAlias;
        public static final Jsonkey Data;
        public static final Jsonkey Debug;
        public static final Jsonkey DeepLinkPath;
        public static final Jsonkey DefaultBucket;
        public static final Jsonkey Description;
        public static final Jsonkey DeveloperIdentity;
        public static final Jsonkey DeviceFingerprintID;
        public static final Jsonkey Direction;
        public static final Jsonkey Environment;
        public static final Jsonkey Event;
        public static final Jsonkey EventData;
        public static final Jsonkey Expiration;
        public static final Jsonkey External_Intent_Extra;
        public static final Jsonkey External_Intent_URI;
        public static final Jsonkey FaceBookAppLinkChecked;
        public static final Jsonkey FirstInstallTime;
        public static final Jsonkey ForceNewBranchSession;
        public static final Jsonkey GoogleAdvertisingID;
        public static final Jsonkey GooglePlayInstallReferrer;
        public static final Jsonkey GoogleSearchInstallReferrer;
        public static final Jsonkey HardwareID;
        public static final Jsonkey HardwareIDType;
        public static final Jsonkey HardwareIDTypeRandom;
        public static final Jsonkey HardwareIDTypeVendor;
        public static final Jsonkey Identity;
        public static final Jsonkey IdentityID;
        public static final Jsonkey ImageCaptions;
        public static final Jsonkey InstallBeginTimeStamp;
        public static final Jsonkey InstallMetadata;
        public static final Jsonkey Instant;
        public static final Jsonkey InstantApp;
        public static final Jsonkey InstantDeepLinkSession;
        public static final Jsonkey IsFirstSession;
        public static final Jsonkey IsFullAppConv;
        public static final Jsonkey IsHardwareIDReal;
        public static final Jsonkey IsReferrable;
        private static int KClassImpl$Data$declaredNonStaticMembers$2;
        public static final Jsonkey LATDAttributionWindow;
        public static final Jsonkey LATVal;
        public static final Jsonkey Language;
        public static final Jsonkey LastUpdateTime;
        public static final Jsonkey Last_Round_Trip_Time;
        public static final Jsonkey Latitude;
        public static final Jsonkey Length;
        public static final Jsonkey LimitedAdTracking;
        public static final Jsonkey Link;
        public static final Jsonkey LinkClickID;
        public static final Jsonkey LinkIdentifier;
        public static final Jsonkey LocalIP;
        public static final Jsonkey LocallyIndexable;
        public static final Jsonkey Location;
        public static final Jsonkey Longitude;
        public static final Jsonkey Metadata;
        public static final Jsonkey Model;
        private static int MyBillsEntityDataFactory;
        public static final Jsonkey Name;
        public static final Jsonkey NativeApp;
        public static final Jsonkey OS;
        public static final Jsonkey OSVersion;
        public static final Jsonkey OriginalInstallTime;
        public static final Jsonkey Params;
        public static final Jsonkey Path;
        private static char PlaceComponentResult;
        public static final Jsonkey Prefix;
        public static final Jsonkey PreviousUpdateTime;
        public static final Jsonkey Price;
        public static final Jsonkey PriceCurrency;
        public static final Jsonkey ProductBrand;
        public static final Jsonkey ProductCategory;
        public static final Jsonkey ProductName;
        public static final Jsonkey ProductVariant;
        public static final Jsonkey PublicallyIndexable;
        public static final Jsonkey Quantity;
        public static final Jsonkey Queue_Wait_Time;
        public static final Jsonkey Rating;
        public static final Jsonkey RatingAverage;
        public static final Jsonkey RatingCount;
        public static final Jsonkey RatingMax;
        public static final Jsonkey ReferralCode;
        public static final Jsonkey ReferralLink;
        public static final Jsonkey ReferringBranchIdentity;
        public static final Jsonkey ReferringData;
        public static final Jsonkey ReferringLink;
        public static final Jsonkey Revenue;
        public static final Jsonkey SDK;
        public static final Jsonkey SKU;
        public static final Jsonkey ScreenDpi;
        public static final Jsonkey ScreenHeight;
        public static final Jsonkey ScreenWidth;
        public static final Jsonkey SdkVersion;
        public static final Jsonkey SearchQuery;
        public static final Jsonkey SessionID;
        public static final Jsonkey ShareError;
        public static final Jsonkey SharedLink;
        public static final Jsonkey Shipping;
        public static final Jsonkey Tax;
        public static final Jsonkey Total;
        public static final Jsonkey TrackingDisabled;
        public static final Jsonkey TransactionID;
        public static final Jsonkey Type;
        public static final Jsonkey UIMode;
        public static final Jsonkey URIScheme;
        public static final Jsonkey UnidentifiedDevice;
        public static final Jsonkey Unique;
        public static final Jsonkey Update;
        public static final Jsonkey UserAgent;
        public static final Jsonkey UserData;
        public static final Jsonkey ViewList;
        public static final Jsonkey WiFi;
        private static long getAuthRequestContext;
        public static final Jsonkey limitFacebookTracking;
        private String key;

        static void BuiltInFictitiousFunctionClassFactory() {
            PlaceComponentResult = (char) 49152;
            getAuthRequestContext = 4360990799332652212L;
            MyBillsEntityDataFactory = -956812108;
        }

        public static Jsonkey valueOf(String str) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 111;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            Jsonkey jsonkey = (Jsonkey) Enum.valueOf(Jsonkey.class, str);
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 77;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    Object[] objArr = null;
                    int length = objArr.length;
                    return jsonkey;
                }
                return jsonkey;
            } catch (Exception e) {
                throw e;
            }
        }

        public static Jsonkey[] values() {
            int i = BuiltInFictitiousFunctionClassFactory + 87;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            if ((i % 2 != 0 ? (char) 4 : 'M') != 4) {
                return (Jsonkey[]) $VALUES.clone();
            }
            try {
                Jsonkey[] jsonkeyArr = (Jsonkey[]) $VALUES.clone();
                Object obj = null;
                obj.hashCode();
                return jsonkeyArr;
            } catch (Exception e) {
                throw e;
            }
        }

        static {
            BuiltInFictitiousFunctionClassFactory();
            Jsonkey jsonkey = new Jsonkey("IdentityID", 0, "identity_id");
            IdentityID = jsonkey;
            Jsonkey jsonkey2 = new Jsonkey(TrackerKey.DanaWalletSectionName.WALLET_IDENTITY, 1, "identity");
            Identity = jsonkey2;
            Jsonkey jsonkey3 = new Jsonkey("DeviceFingerprintID", 2, "device_fingerprint_id");
            DeviceFingerprintID = jsonkey3;
            Jsonkey jsonkey4 = new Jsonkey("SessionID", 3, "session_id");
            SessionID = jsonkey4;
            Jsonkey jsonkey5 = new Jsonkey("LinkClickID", 4, "link_click_id");
            LinkClickID = jsonkey5;
            Jsonkey jsonkey6 = new Jsonkey("GoogleSearchInstallReferrer", 5, "google_search_install_referrer");
            GoogleSearchInstallReferrer = jsonkey6;
            Jsonkey jsonkey7 = new Jsonkey("GooglePlayInstallReferrer", 6, "install_referrer_extras");
            GooglePlayInstallReferrer = jsonkey7;
            Jsonkey jsonkey8 = new Jsonkey("ClickedReferrerTimeStamp", 7, "clicked_referrer_ts");
            ClickedReferrerTimeStamp = jsonkey8;
            Jsonkey jsonkey9 = new Jsonkey("InstallBeginTimeStamp", 8, "install_begin_ts");
            InstallBeginTimeStamp = jsonkey9;
            Jsonkey jsonkey10 = new Jsonkey("FaceBookAppLinkChecked", 9, "facebook_app_link_checked");
            FaceBookAppLinkChecked = jsonkey10;
            Jsonkey jsonkey11 = new Jsonkey("BranchLinkUsed", 10, "branch_used");
            BranchLinkUsed = jsonkey11;
            Jsonkey jsonkey12 = new Jsonkey("ReferringBranchIdentity", 11, "referring_branch_identity");
            ReferringBranchIdentity = jsonkey12;
            Jsonkey jsonkey13 = new Jsonkey("BranchIdentity", 12, "branch_identity");
            BranchIdentity = jsonkey13;
            Jsonkey jsonkey14 = new Jsonkey("BranchKey", 13, "branch_key");
            BranchKey = jsonkey14;
            Jsonkey jsonkey15 = new Jsonkey("BranchData", 14, "branch_data");
            BranchData = jsonkey15;
            Jsonkey jsonkey16 = new Jsonkey("Bucket", 15, "bucket");
            Bucket = jsonkey16;
            Jsonkey jsonkey17 = new Jsonkey("DefaultBucket", 16, "default");
            DefaultBucket = jsonkey17;
            Jsonkey jsonkey18 = new Jsonkey("Amount", 17, "amount");
            Amount = jsonkey18;
            Jsonkey jsonkey19 = new Jsonkey("CalculationType", 18, "calculation_type");
            CalculationType = jsonkey19;
            Jsonkey jsonkey20 = new Jsonkey("Location", 19, "location");
            Location = jsonkey20;
            Jsonkey jsonkey21 = new Jsonkey("Type", 20, "type");
            Type = jsonkey21;
            Jsonkey jsonkey22 = new Jsonkey("CreationSource", 21, "creation_source");
            CreationSource = jsonkey22;
            Jsonkey jsonkey23 = new Jsonkey("Prefix", 22, "prefix");
            Prefix = jsonkey23;
            Jsonkey jsonkey24 = new Jsonkey("Expiration", 23, "expiration");
            Expiration = jsonkey24;
            Jsonkey jsonkey25 = new Jsonkey("Event", 24, "event");
            Event = jsonkey25;
            Jsonkey jsonkey26 = new Jsonkey("Metadata", 25, "metadata");
            Metadata = jsonkey26;
            Jsonkey jsonkey27 = new Jsonkey("CommerceData", 26, "commerce_data");
            CommerceData = jsonkey27;
            Jsonkey jsonkey28 = new Jsonkey("ReferralCode", 27, "referral_code");
            ReferralCode = jsonkey28;
            Jsonkey jsonkey29 = new Jsonkey("Total", 28, "total");
            Total = jsonkey29;
            Jsonkey jsonkey30 = new Jsonkey("Unique", 29, "unique");
            Unique = jsonkey30;
            Jsonkey jsonkey31 = new Jsonkey("Length", 30, "length");
            Length = jsonkey31;
            Jsonkey jsonkey32 = new Jsonkey("Direction", 31, "direction");
            Direction = jsonkey32;
            Jsonkey jsonkey33 = new Jsonkey("BeginAfterID", 32, "begin_after_id");
            BeginAfterID = jsonkey33;
            Jsonkey jsonkey34 = new Jsonkey(HttpHeaders.LINK, 33, "link");
            Link = jsonkey34;
            Jsonkey jsonkey35 = new Jsonkey("ReferringData", 34, "referring_data");
            ReferringData = jsonkey35;
            Jsonkey jsonkey36 = new Jsonkey("ReferringLink", 35, "referring_link");
            ReferringLink = jsonkey36;
            Jsonkey jsonkey37 = new Jsonkey("IsFullAppConv", 36, "is_full_app_conversion");
            IsFullAppConv = jsonkey37;
            Jsonkey jsonkey38 = new Jsonkey("Data", 37, "data");
            Data = jsonkey38;
            Jsonkey jsonkey39 = new Jsonkey("OS", 38, H5GetLogInfoBridge.RESULT_OS);
            OS = jsonkey39;
            Jsonkey jsonkey40 = new Jsonkey("HardwareID", 39, "hardware_id");
            HardwareID = jsonkey40;
            Jsonkey jsonkey41 = new Jsonkey("AndroidID", 40, "android_id");
            AndroidID = jsonkey41;
            Jsonkey jsonkey42 = new Jsonkey("UnidentifiedDevice", 41, "unidentified_device");
            UnidentifiedDevice = jsonkey42;
            Jsonkey jsonkey43 = new Jsonkey("HardwareIDType", 42, "hardware_id_type");
            HardwareIDType = jsonkey43;
            Jsonkey jsonkey44 = new Jsonkey("HardwareIDTypeVendor", 43, "vendor_id");
            HardwareIDTypeVendor = jsonkey44;
            Jsonkey jsonkey45 = new Jsonkey("HardwareIDTypeRandom", 44, "random");
            HardwareIDTypeRandom = jsonkey45;
            Jsonkey jsonkey46 = new Jsonkey("IsHardwareIDReal", 45, "is_hardware_id_real");
            IsHardwareIDReal = jsonkey46;
            Object[] objArr = new Object[1];
            a(new char[]{48262, 65204, 33979, 28946, 32892, 6055, 27056, 20882, 46008, 13059, 3493}, new char[]{60744, 1065, 62256, 45314}, (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), new char[]{0, 0, 0, 0}, 805579245 - View.MeasureSpec.getMode(0), objArr);
            Jsonkey jsonkey47 = new Jsonkey("AppVersion", 46, ((String) objArr[0]).intern());
            AppVersion = jsonkey47;
            Jsonkey jsonkey48 = new Jsonkey("OSVersion", 47, "os_version");
            OSVersion = jsonkey48;
            Jsonkey jsonkey49 = new Jsonkey("Country", 48, GeocoderResultMapperKt.COUNTRY);
            Country = jsonkey49;
            Jsonkey jsonkey50 = new Jsonkey("Language", 49, "language");
            Language = jsonkey50;
            Jsonkey jsonkey51 = new Jsonkey("IsReferrable", 50, "is_referrable");
            IsReferrable = jsonkey51;
            Jsonkey jsonkey52 = new Jsonkey("Update", 51, "update");
            Update = jsonkey52;
            Jsonkey jsonkey53 = new Jsonkey("OriginalInstallTime", 52, "first_install_time");
            OriginalInstallTime = jsonkey53;
            Jsonkey jsonkey54 = new Jsonkey("FirstInstallTime", 53, "latest_install_time");
            FirstInstallTime = jsonkey54;
            Jsonkey jsonkey55 = new Jsonkey("LastUpdateTime", 54, "latest_update_time");
            LastUpdateTime = jsonkey55;
            Jsonkey jsonkey56 = new Jsonkey("PreviousUpdateTime", 55, "previous_update_time");
            PreviousUpdateTime = jsonkey56;
            Jsonkey jsonkey57 = new Jsonkey("URIScheme", 56, "uri_scheme");
            URIScheme = jsonkey57;
            Jsonkey jsonkey58 = new Jsonkey("AppLinks", 57, "app_links");
            AppLinks = jsonkey58;
            Jsonkey jsonkey59 = new Jsonkey("AppIdentifier", 58, "app_identifier");
            AppIdentifier = jsonkey59;
            Jsonkey jsonkey60 = new Jsonkey("LinkIdentifier", 59, "link_identifier");
            LinkIdentifier = jsonkey60;
            Jsonkey jsonkey61 = new Jsonkey("GoogleAdvertisingID", 60, "google_advertising_id");
            GoogleAdvertisingID = jsonkey61;
            Jsonkey jsonkey62 = new Jsonkey("AAID", 61, "aaid");
            AAID = jsonkey62;
            Jsonkey jsonkey63 = new Jsonkey("LATVal", 62, "lat_val");
            LATVal = jsonkey63;
            Jsonkey jsonkey64 = new Jsonkey("LimitedAdTracking", 63, "limit_ad_tracking");
            LimitedAdTracking = jsonkey64;
            Jsonkey jsonkey65 = new Jsonkey("limitFacebookTracking", 64, "limit_facebook_tracking");
            limitFacebookTracking = jsonkey65;
            Jsonkey jsonkey66 = new Jsonkey("Debug", 65, com.alibaba.exthub.BuildConfig.BUILD_TYPE);
            Debug = jsonkey66;
            Jsonkey jsonkey67 = new Jsonkey("Brand", 66, H5GetLogInfoBridge.RESULT_BRAND);
            Brand = jsonkey67;
            Jsonkey jsonkey68 = new Jsonkey("Model", 67, H5GetLogInfoBridge.RESULT_MODEL);
            Model = jsonkey68;
            Jsonkey jsonkey69 = new Jsonkey("ScreenDpi", 68, "screen_dpi");
            ScreenDpi = jsonkey69;
            Jsonkey jsonkey70 = new Jsonkey("ScreenHeight", 69, "screen_height");
            ScreenHeight = jsonkey70;
            Jsonkey jsonkey71 = new Jsonkey("ScreenWidth", 70, "screen_width");
            ScreenWidth = jsonkey71;
            Jsonkey jsonkey72 = new Jsonkey("WiFi", 71, "wifi");
            WiFi = jsonkey72;
            Jsonkey jsonkey73 = new Jsonkey("LocalIP", 72, "local_ip");
            LocalIP = jsonkey73;
            Jsonkey jsonkey74 = new Jsonkey("UserData", 73, "user_data");
            UserData = jsonkey74;
            Jsonkey jsonkey75 = new Jsonkey("DeveloperIdentity", 74, "developer_identity");
            DeveloperIdentity = jsonkey75;
            Jsonkey jsonkey76 = new Jsonkey("UserAgent", 75, "user_agent");
            UserAgent = jsonkey76;
            Jsonkey jsonkey77 = new Jsonkey(OauthConstant.BindingType.SDK, 76, OauthConstant.OauthType.SDK_TYPE);
            SDK = jsonkey77;
            Jsonkey jsonkey78 = new Jsonkey("SdkVersion", 77, HianalyticsBaseData.SDK_VERSION);
            SdkVersion = jsonkey78;
            Jsonkey jsonkey79 = new Jsonkey("UIMode", 78, "ui_mode");
            UIMode = jsonkey79;
            Jsonkey jsonkey80 = new Jsonkey("InstallMetadata", 79, "install_metadata");
            InstallMetadata = jsonkey80;
            Jsonkey jsonkey81 = new Jsonkey("LATDAttributionWindow", 80, "attribution_window");
            LATDAttributionWindow = jsonkey81;
            Jsonkey jsonkey82 = new Jsonkey("Clicked_Branch_Link", 81, "+clicked_branch_link");
            Clicked_Branch_Link = jsonkey82;
            Jsonkey jsonkey83 = new Jsonkey("IsFirstSession", 82, "+is_first_session");
            IsFirstSession = jsonkey83;
            Jsonkey jsonkey84 = new Jsonkey("AndroidDeepLinkPath", 83, "$android_deeplink_path");
            AndroidDeepLinkPath = jsonkey84;
            Jsonkey jsonkey85 = new Jsonkey("DeepLinkPath", 84, "$deeplink_path");
            DeepLinkPath = jsonkey85;
            Jsonkey jsonkey86 = new Jsonkey("AndroidAppLinkURL", 85, "android_app_link_url");
            AndroidAppLinkURL = jsonkey86;
            Jsonkey jsonkey87 = new Jsonkey("AndroidPushNotificationKey", 86, TrackerType.BRANCH);
            AndroidPushNotificationKey = jsonkey87;
            Jsonkey jsonkey88 = new Jsonkey("AndroidPushIdentifier", 87, "push_identifier");
            AndroidPushIdentifier = jsonkey88;
            Jsonkey jsonkey89 = new Jsonkey("ForceNewBranchSession", 88, "branch_force_new_session");
            ForceNewBranchSession = jsonkey89;
            Jsonkey jsonkey90 = new Jsonkey("CanonicalIdentifier", 89, "$canonical_identifier");
            CanonicalIdentifier = jsonkey90;
            Jsonkey jsonkey91 = new Jsonkey("ContentTitle", 90, "$og_title");
            ContentTitle = jsonkey91;
            Jsonkey jsonkey92 = new Jsonkey("ContentDesc", 91, "$og_description");
            ContentDesc = jsonkey92;
            Jsonkey jsonkey93 = new Jsonkey("ContentImgUrl", 92, "$og_image_url");
            ContentImgUrl = jsonkey93;
            Jsonkey jsonkey94 = new Jsonkey("CanonicalUrl", 93, "$canonical_url");
            CanonicalUrl = jsonkey94;
            Jsonkey jsonkey95 = new Jsonkey("ContentType", 94, "$content_type");
            ContentType = jsonkey95;
            Jsonkey jsonkey96 = new Jsonkey("PublicallyIndexable", 95, "$publicly_indexable");
            PublicallyIndexable = jsonkey96;
            Jsonkey jsonkey97 = new Jsonkey("LocallyIndexable", 96, "$locally_indexable");
            LocallyIndexable = jsonkey97;
            Jsonkey jsonkey98 = new Jsonkey("ContentKeyWords", 97, "$keywords");
            ContentKeyWords = jsonkey98;
            Jsonkey jsonkey99 = new Jsonkey("ContentExpiryTime", 98, "$exp_date");
            ContentExpiryTime = jsonkey99;
            Jsonkey jsonkey100 = new Jsonkey("Params", 99, "params");
            Params = jsonkey100;
            Jsonkey jsonkey101 = new Jsonkey("SharedLink", 100, "$shared_link");
            SharedLink = jsonkey101;
            Jsonkey jsonkey102 = new Jsonkey("ShareError", 101, "$share_error");
            ShareError = jsonkey102;
            Jsonkey jsonkey103 = new Jsonkey("External_Intent_URI", 102, "external_intent_uri");
            External_Intent_URI = jsonkey103;
            Jsonkey jsonkey104 = new Jsonkey("External_Intent_Extra", 103, "external_intent_extra");
            External_Intent_Extra = jsonkey104;
            Jsonkey jsonkey105 = new Jsonkey("Last_Round_Trip_Time", 104, "lrtt");
            Last_Round_Trip_Time = jsonkey105;
            Jsonkey jsonkey106 = new Jsonkey("Branch_Round_Trip_Time", 105, "brtt");
            Branch_Round_Trip_Time = jsonkey106;
            Jsonkey jsonkey107 = new Jsonkey("Branch_Instrumentation", 106, "instrumentation");
            Branch_Instrumentation = jsonkey107;
            Jsonkey jsonkey108 = new Jsonkey("Queue_Wait_Time", 107, "qwt");
            Queue_Wait_Time = jsonkey108;
            Jsonkey jsonkey109 = new Jsonkey("InstantDeepLinkSession", 108, "instant_dl_session");
            InstantDeepLinkSession = jsonkey109;
            Jsonkey jsonkey110 = new Jsonkey("BranchViewData", 109, "branch_view_data");
            BranchViewData = jsonkey110;
            Jsonkey jsonkey111 = new Jsonkey("BranchViewID", 110, "id");
            BranchViewID = jsonkey111;
            Jsonkey jsonkey112 = new Jsonkey("BranchViewAction", 111, "action");
            BranchViewAction = jsonkey112;
            Jsonkey jsonkey113 = new Jsonkey("BranchViewNumOfUse", 112, "number_of_use");
            BranchViewNumOfUse = jsonkey113;
            Jsonkey jsonkey114 = new Jsonkey("BranchViewUrl", 113, "url");
            BranchViewUrl = jsonkey114;
            Jsonkey jsonkey115 = new Jsonkey("BranchViewHtml", 114, "html");
            BranchViewHtml = jsonkey115;
            Jsonkey jsonkey116 = new Jsonkey(TrackerKey.DeeplinkProperty.PATH, 115, "path");
            Path = jsonkey116;
            Jsonkey jsonkey117 = new Jsonkey("ViewList", 116, "view_list");
            ViewList = jsonkey117;
            Jsonkey jsonkey118 = new Jsonkey("ContentActionView", 117, "view");
            ContentActionView = jsonkey118;
            Jsonkey jsonkey119 = new Jsonkey("ContentPath", 118, "content_path");
            ContentPath = jsonkey119;
            Jsonkey jsonkey120 = new Jsonkey("ContentNavPath", 119, "content_nav_path");
            ContentNavPath = jsonkey120;
            Jsonkey jsonkey121 = new Jsonkey("ReferralLink", 120, "referral_link");
            ReferralLink = jsonkey121;
            Jsonkey jsonkey122 = new Jsonkey("ContentData", 121, "content_data");
            ContentData = jsonkey122;
            Jsonkey jsonkey123 = new Jsonkey("ContentEvents", 122, "events");
            ContentEvents = jsonkey123;
            Jsonkey jsonkey124 = new Jsonkey("ContentAnalyticsMode", 123, "content_analytics_mode");
            ContentAnalyticsMode = jsonkey124;
            Jsonkey jsonkey125 = new Jsonkey("ContentDiscovery", 124, RVParams.CAN_DESTROY);
            ContentDiscovery = jsonkey125;
            Jsonkey jsonkey126 = new Jsonkey(TrackerKey.SuperProperties.ENVIRONMENT, 125, "environment");
            Environment = jsonkey126;
            Jsonkey jsonkey127 = new Jsonkey("InstantApp", 126, "INSTANT_APP");
            InstantApp = jsonkey127;
            Jsonkey jsonkey128 = new Jsonkey("NativeApp", 127, "FULL_APP");
            NativeApp = jsonkey128;
            Jsonkey jsonkey129 = new Jsonkey("CustomerEventAlias", 128, "customer_event_alias");
            CustomerEventAlias = jsonkey129;
            Jsonkey jsonkey130 = new Jsonkey("TransactionID", 129, "transaction_id");
            TransactionID = jsonkey130;
            Jsonkey jsonkey131 = new Jsonkey("Currency", 130, FirebaseAnalytics.Param.CURRENCY);
            Currency = jsonkey131;
            Jsonkey jsonkey132 = new Jsonkey("Revenue", 131, "revenue");
            Revenue = jsonkey132;
            Jsonkey jsonkey133 = new Jsonkey("Shipping", 132, FirebaseAnalytics.Param.SHIPPING);
            Shipping = jsonkey133;
            Jsonkey jsonkey134 = new Jsonkey("Tax", 133, FirebaseAnalytics.Param.TAX);
            Tax = jsonkey134;
            Jsonkey jsonkey135 = new Jsonkey("Coupon", 134, FirebaseAnalytics.Param.COUPON);
            Coupon = jsonkey135;
            Jsonkey jsonkey136 = new Jsonkey("Affiliation", 135, FirebaseAnalytics.Param.AFFILIATION);
            Affiliation = jsonkey136;
            Jsonkey jsonkey137 = new Jsonkey("Description", 136, "description");
            Description = jsonkey137;
            Jsonkey jsonkey138 = new Jsonkey("SearchQuery", 137, "search_query");
            SearchQuery = jsonkey138;
            Jsonkey jsonkey139 = new Jsonkey("AdType", 138, "ad_type");
            AdType = jsonkey139;
            Jsonkey jsonkey140 = new Jsonkey("Name", 139, "name");
            Name = jsonkey140;
            Jsonkey jsonkey141 = new Jsonkey("CustomData", 140, "custom_data");
            CustomData = jsonkey141;
            Jsonkey jsonkey142 = new Jsonkey("EventData", 141, "event_data");
            EventData = jsonkey142;
            Jsonkey jsonkey143 = new Jsonkey("ContentItems", 142, "content_items");
            ContentItems = jsonkey143;
            Jsonkey jsonkey144 = new Jsonkey("ContentSchema", 143, "$content_schema");
            ContentSchema = jsonkey144;
            Jsonkey jsonkey145 = new Jsonkey("Price", 144, "$price");
            Price = jsonkey145;
            Jsonkey jsonkey146 = new Jsonkey("PriceCurrency", 145, "$currency");
            PriceCurrency = jsonkey146;
            Jsonkey jsonkey147 = new Jsonkey("Quantity", 146, "$quantity");
            Quantity = jsonkey147;
            Jsonkey jsonkey148 = new Jsonkey("SKU", 147, "$sku");
            SKU = jsonkey148;
            Jsonkey jsonkey149 = new Jsonkey("ProductName", 148, "$product_name");
            ProductName = jsonkey149;
            Jsonkey jsonkey150 = new Jsonkey("ProductBrand", 149, "$product_brand");
            ProductBrand = jsonkey150;
            Jsonkey jsonkey151 = new Jsonkey("ProductCategory", 150, "$product_category");
            ProductCategory = jsonkey151;
            Jsonkey jsonkey152 = new Jsonkey("ProductVariant", 151, "$product_variant");
            ProductVariant = jsonkey152;
            Jsonkey jsonkey153 = new Jsonkey("Rating", 152, "$rating");
            Rating = jsonkey153;
            Jsonkey jsonkey154 = new Jsonkey("RatingAverage", 153, "$rating_average");
            RatingAverage = jsonkey154;
            Jsonkey jsonkey155 = new Jsonkey("RatingCount", 154, "$rating_count");
            RatingCount = jsonkey155;
            Jsonkey jsonkey156 = new Jsonkey("RatingMax", TarHeader.USTAR_FILENAME_PREFIX, "$rating_max");
            RatingMax = jsonkey156;
            Jsonkey jsonkey157 = new Jsonkey("AddressStreet", 156, "$address_street");
            AddressStreet = jsonkey157;
            Jsonkey jsonkey158 = new Jsonkey("AddressCity", 157, "$address_city");
            AddressCity = jsonkey158;
            Jsonkey jsonkey159 = new Jsonkey("AddressRegion", 158, "$address_region");
            AddressRegion = jsonkey159;
            Jsonkey jsonkey160 = new Jsonkey("AddressCountry", 159, "$address_country");
            AddressCountry = jsonkey160;
            Jsonkey jsonkey161 = new Jsonkey("AddressPostalCode", BlobStatic.MONITOR_IMAGE_WIDTH, "$address_postal_code");
            AddressPostalCode = jsonkey161;
            Jsonkey jsonkey162 = new Jsonkey(TrackerKey.SuperProperties.LATITUDE, 161, TrackerKey.SuperProperties.MIXPANEL_LATITUDE);
            Latitude = jsonkey162;
            Jsonkey jsonkey163 = new Jsonkey(TrackerKey.SuperProperties.LONGITUDE, 162, TrackerKey.SuperProperties.MIXPANEL_LONGITUDE);
            Longitude = jsonkey163;
            Jsonkey jsonkey164 = new Jsonkey("ImageCaptions", 163, "$image_captions");
            ImageCaptions = jsonkey164;
            Jsonkey jsonkey165 = new Jsonkey("Condition", 164, "$condition");
            Condition = jsonkey165;
            Jsonkey jsonkey166 = new Jsonkey("CreationTimestamp", 165, "$creation_timestamp");
            CreationTimestamp = jsonkey166;
            Jsonkey jsonkey167 = new Jsonkey("TrackingDisabled", 166, "tracking_disabled");
            TrackingDisabled = jsonkey167;
            Jsonkey jsonkey168 = new Jsonkey("Instant", 167, "instant");
            Instant = jsonkey168;
            $VALUES = new Jsonkey[]{jsonkey, jsonkey2, jsonkey3, jsonkey4, jsonkey5, jsonkey6, jsonkey7, jsonkey8, jsonkey9, jsonkey10, jsonkey11, jsonkey12, jsonkey13, jsonkey14, jsonkey15, jsonkey16, jsonkey17, jsonkey18, jsonkey19, jsonkey20, jsonkey21, jsonkey22, jsonkey23, jsonkey24, jsonkey25, jsonkey26, jsonkey27, jsonkey28, jsonkey29, jsonkey30, jsonkey31, jsonkey32, jsonkey33, jsonkey34, jsonkey35, jsonkey36, jsonkey37, jsonkey38, jsonkey39, jsonkey40, jsonkey41, jsonkey42, jsonkey43, jsonkey44, jsonkey45, jsonkey46, jsonkey47, jsonkey48, jsonkey49, jsonkey50, jsonkey51, jsonkey52, jsonkey53, jsonkey54, jsonkey55, jsonkey56, jsonkey57, jsonkey58, jsonkey59, jsonkey60, jsonkey61, jsonkey62, jsonkey63, jsonkey64, jsonkey65, jsonkey66, jsonkey67, jsonkey68, jsonkey69, jsonkey70, jsonkey71, jsonkey72, jsonkey73, jsonkey74, jsonkey75, jsonkey76, jsonkey77, jsonkey78, jsonkey79, jsonkey80, jsonkey81, jsonkey82, jsonkey83, jsonkey84, jsonkey85, jsonkey86, jsonkey87, jsonkey88, jsonkey89, jsonkey90, jsonkey91, jsonkey92, jsonkey93, jsonkey94, jsonkey95, jsonkey96, jsonkey97, jsonkey98, jsonkey99, jsonkey100, jsonkey101, jsonkey102, jsonkey103, jsonkey104, jsonkey105, jsonkey106, jsonkey107, jsonkey108, jsonkey109, jsonkey110, jsonkey111, jsonkey112, jsonkey113, jsonkey114, jsonkey115, jsonkey116, jsonkey117, jsonkey118, jsonkey119, jsonkey120, jsonkey121, jsonkey122, jsonkey123, jsonkey124, jsonkey125, jsonkey126, jsonkey127, jsonkey128, jsonkey129, jsonkey130, jsonkey131, jsonkey132, jsonkey133, jsonkey134, jsonkey135, jsonkey136, jsonkey137, jsonkey138, jsonkey139, jsonkey140, jsonkey141, jsonkey142, jsonkey143, jsonkey144, jsonkey145, jsonkey146, jsonkey147, jsonkey148, jsonkey149, jsonkey150, jsonkey151, jsonkey152, jsonkey153, jsonkey154, jsonkey155, jsonkey156, jsonkey157, jsonkey158, jsonkey159, jsonkey160, jsonkey161, jsonkey162, jsonkey163, jsonkey164, jsonkey165, jsonkey166, jsonkey167, jsonkey168};
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 != 0)) {
                int i2 = 83 / 0;
            }
        }

        private Jsonkey(String str, int i, String str2) {
            this.key = str2;
        }

        public final String getKey() {
            int i = BuiltInFictitiousFunctionClassFactory + 47;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            try {
                String str = this.key;
                int i3 = BuiltInFictitiousFunctionClassFactory + 9;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if ((i3 % 2 != 0 ? 'X' : (char) 16) != 16) {
                    int i4 = 93 / 0;
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        }

        @Override // java.lang.Enum
        public final String toString() {
            String str;
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 53;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 != 0)) {
                str = this.key;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                try {
                    str = this.key;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 11;
            KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
            int i3 = i2 % 2;
            return str;
        }

        private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
            E e = new E();
            int length = cArr2.length;
            char[] cArr4 = new char[length];
            int length2 = cArr3.length;
            char[] cArr5 = new char[length2];
            System.arraycopy(cArr2, 0, cArr4, 0, length);
            System.arraycopy(cArr3, 0, cArr5, 0, length2);
            cArr4[0] = (char) (cArr4[0] ^ c);
            cArr5[2] = (char) (cArr5[2] + ((char) i));
            int length3 = cArr.length;
            char[] cArr6 = new char[length3];
            e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            while (true) {
                if ((e.KClassImpl$Data$declaredNonStaticMembers$2 < length3 ? 'P' : 'J') == 'J') {
                    objArr[0] = new String(cArr6);
                    return;
                }
                int i2 = $10 + 101;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
                int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
                e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
                cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
                cArr4[i5] = e.MyBillsEntityDataFactory;
                cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (getAuthRequestContext ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (PlaceComponentResult ^ 4360990799332652212L)));
                e.KClassImpl$Data$declaredNonStaticMembers$2++;
                int i6 = $10 + 33;
                $11 = i6 % 128;
                int i7 = i6 % 2;
            }
        }
    }

    /* loaded from: classes.dex */
    public enum RequestPath {
        RedeemRewards("v1/redeem"),
        GetURL("v1/url"),
        GetApp("v1/app-link-settings"),
        RegisterInstall("v1/install"),
        RegisterClose("v1/close"),
        RegisterOpen("v1/open"),
        RegisterView("v1/register-view"),
        GetCredits("v1/credits/"),
        GetCreditHistory("v1/credithistory"),
        CompletedAction("v1/event"),
        IdentifyUser("v1/profile"),
        Logout("v1/logout"),
        GetReferralCode("v1/referralcode"),
        ValidateReferralCode("v1/referralcode/"),
        ApplyReferralCode("v1/applycode/"),
        DebugConnect("v1/debug/connect"),
        ContentEvent("v1/content-events"),
        TrackStandardEvent("v2/event/standard"),
        TrackCustomEvent("v2/event/custom"),
        GetCPID("v1/cpid"),
        GetLATD("v1/cpid/latd");

        private String key;

        RequestPath(String str) {
            this.key = str;
        }

        public final String getPath() {
            return this.key;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.key;
        }
    }

    /* loaded from: classes.dex */
    public enum LinkParam {
        Tags(PageLog.PAGE_LOG_TAGS),
        Alias("alias"),
        Type("type"),
        Duration("duration"),
        Channel("channel"),
        Feature(BranchLinkConstant.PathTarget.FEATURE),
        Stage("stage"),
        Campaign("campaign"),
        Data("data"),
        URL("url");

        private String key;

        LinkParam(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.key;
        }
    }

    /* loaded from: classes2.dex */
    public enum PreinstallKey {
        campaign("preinstall_campaign"),
        partner("preinstall_partner");

        private String key;

        PreinstallKey(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.key;
        }
    }

    /* loaded from: classes.dex */
    public enum ModuleNameKeys {
        imei("imei");

        private String key;

        ModuleNameKeys(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.key;
        }
    }
}
