package com.iap.ac.android.common.account;

/* loaded from: classes3.dex */
public interface IUserInfoManager {
    String getOpenId();

    ACUserInfo getUserInfo();

    boolean setUserInfo(ACUserInfo aCUserInfo);
}
