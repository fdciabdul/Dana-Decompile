package com.iap.ac.android.biz.common.constants;

/* loaded from: classes8.dex */
public class Constants {
    public static final String BIZ_CODE_AC_FOR_MULTI_INSTANCE = "ac_biz";
    public static final String BIZ_CODE_FOR_REGION = "region_biz";
    public static final String PACKAGE_NAME_AC_CORE_MANAGER = "com.iap.ac.android.biz.core.ACCoreManager";
    public static final String PACKAGE_NAME_AC_JSAPI_INTERCEPTOR_MANAGER = "com.iap.ac.android.acs.plugin.downgrade.jsapi.IAPJSAPIInterceptorManager";
    public static final String PACKAGE_NAME_DECODE_CHECKER = "com.iap.ac.android.mpm.DecodeChecker";
    public static final String PACKAGE_NAME_PAYMENTCODE_MANAGER = "com.iap.ac.android.cpm.online.manager.OnlinePaymentCodeManager";
    public static final String PACKAGE_NAME_PA_CORE_MANAGER = "com.alipay.ac.pa.foundation.PSAadpterAC";
    public static final String PACKAGE_NAME_PLUGIN_MANAGER = "com.iap.ac.android.acs.plugin.core.IAPConnectPluginManager";
    public static final String PACKAGE_NAME_REGION_CDP = "com.iap.ac.android.region.cdp.WalletCdpKit";
    public static final String PACKAGE_NAME_REGION_MANAGER = "com.iap.ac.android.acs.operation.biz.region.RegionManager";
    public static final String PACKAGE_NAME_SIGNCONTRACT_MANAGER = "com.iap.ac.android.gol.SignContractManager";
    public static final String PACKAGE_NAME_TRANSLATE_MANAGER = "com.iap.ac.android.acs.translation.TranslateManager";
    public static final String TAG = "IAPConnect";

    /* loaded from: classes8.dex */
    public static class APlusRewardsOperationType {
        public static final String REWARDS_AUTH_LOGIN = "ap.alipayplusrewards.auth.authlogin";
        public static final String REWARDS_HOLD_LOGIN = "ap.alipayplusrewards.auth.holdlogin";
    }

    /* loaded from: classes8.dex */
    public static class H5Param {
        public static final String PARAM_BIZ_KEY = "AcBizProcessorKey";
        public static final String PARAM_H5_PRE_INJECT_JSBRIDGE = "preInjectJSBridge";
        public static final String PARAM_H5_SCENARIO = "bizScenario";
        public static final String PARAM_SDK_FLAG = "ACCode";
    }

    /* loaded from: classes8.dex */
    public static class OperationType {
        public static final String AGREEMENT_APPLY = "ac.mobilepayment.agreement.oauth.apply";
        public static final String AGREEMENT_PREPARE = "ac.mobilepayment.agreement.oauth.prepare";
        public static final String AUTH_LOGIN = "ac.mobilepayment.auth.authlogin";
        public static final String CODE_SCAN = "ac.mobilepayment.mpm.code.scan";
        public static final String COLLECTION_CODE_PREPARE = "ac.mobilepayment.mpm.oauth.aggregatecode.prepare";
        public static final String COMMON_HOOK = "ac.mobilepayment.common.client.hook";
        public static final String CPM_ENCODE = "ac.mobilepayment.instorepayment.cpm.encode";
        public static final String FETCH_CONFIG = "ac.mobilepayment.common.fetch.configs";
        public static final String HOLD_LOGIN = "ac.mobilepayment.auth.holdlogin";
        public static final String INQUIRE_QUOTE = "ac.mobilepayment.common.exchange.rate.query.by.currency.pair";
        public static final String LOGOUT = "ac.mobilepayment.auth.logout";
        public static final String OAUTH_PREPARE = "ac.mobilepayment.agreement.oauth.extension.prepare";
        public static final String OAUTH_PREPARE_CALLBACK = "ac.mobilepayment.agreement.oauth.prepare.callback";
        public static final String PAGE_QUERY = "ac.mobilepayment.basic.page.query";
        public static final String PHONE_QUERY = "ac.mobilepayment.user.phone.query";
        public static final String QUERY_CITY = "ac.mobilepayment.basic.region.city.query";
        public static final String QUERY_REGION_CODE = "ac.mobilepayment.basic.region.mobilephoneregioncode.query";
        public static final String SWAP_ORDER = "ac.mobilepayment.mpm.order.exchangeorderid";
        public static final String TOKEN_ID_POST = "ac.mobilepayment.device.tokenid.post";
        public static final String USER_INFO_QUERY = "ac.mobilepayment.user.info.query";
    }
}
