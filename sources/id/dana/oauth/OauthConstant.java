package id.dana.oauth;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public @interface OauthConstant {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface BindingType {
        public static final String GLOBAL_NETWORK = "GN";
        public static final String IPG = "IPG";
        public static final String SDK = "SDK";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ErrorPathOauth {
        public static final String CANCEL = "ERROR_CANCEL";
        public static final String TRY_AGAIN = "ERROR_TRY_AGAIN";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LocalErrorCode {
        public static final String ACCESS_CANCEL = "ACCESS_CANCEL";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface OauthType {
        public static final String ONLINE_MERCHANT_TYPE = "online_merchant";
        public static final String SDK_TYPE = "sdk";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface PathParams {
        public static final String ERROR_CODE = "errorCode";
        public static final String ERROR_DESCRIPTION = "errorDescription";
        public static final String MOBILE_AUTH_CODE = "mobileAuthCode";
        public static final String SERVER_AUTH_CODE = "serverAuthCode";
        public static final String STATE_CODE = "stateCode";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface RequestResourceType {
        public static final String GLOBAL_NETWORK = "ALIPAY";
    }
}
