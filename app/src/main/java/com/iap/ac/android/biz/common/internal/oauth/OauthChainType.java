package com.iap.ac.android.biz.common.internal.oauth;

/* loaded from: classes3.dex */
public enum OauthChainType {
    STATUS_UNKNOW,
    STATUS_COOKIE_IS_NULL,
    STATUS_COOKIE_NOT_EXPIRED,
    STATUS_ONLY_COOKIE_EXPIRED,
    STATUS_CLIENTKEY_EXPIRED,
    STATUS_UPDATETIME_INVALID
}
