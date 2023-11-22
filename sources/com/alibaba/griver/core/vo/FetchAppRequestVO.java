package com.alibaba.griver.core.vo;

import android.text.TextUtils;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;

/* loaded from: classes6.dex */
public class FetchAppRequestVO {
    public static final String APP_CREATE_TIME = "APP_CREATE_TIME";
    public static final String APP_DESC = "APP_DESC";
    public static final String APP_ID = "APP_ID";
    public static final String APP_NAME = "APP_NAME";
    public static final String PUBLISH_TIME = "PUBLISH_TIME";

    /* renamed from: a  reason: collision with root package name */
    private int f6480a;
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g;

    public FetchAppRequestVO(int i, int i2) {
        this.f6480a = i;
        this.b = i2;
        if (!TextUtils.isEmpty(GriverEnv.getEnvironment())) {
            setRelatedEnv(GriverEnv.getEnvironment());
        }
        try {
            setUserId(GriverAccount.getUserId());
        } catch (Exception e) {
            GriverLogger.e("FetchAppRequestVO", "get usedId failed", e);
        }
    }

    public int getQueryStartIndex() {
        return this.f6480a;
    }

    public void setQueryStartIndex(int i) {
        this.f6480a = i;
    }

    public int getQuerySize() {
        return this.b;
    }

    public void setQuerySize(int i) {
        this.b = i;
    }

    public String getSortDescriptor() {
        return this.f;
    }

    public void setSortDescriptor(String str) {
        this.f = str;
    }

    public Boolean getAscending() {
        return Boolean.valueOf(this.g);
    }

    public void setAscending(Boolean bool) {
        this.g = bool.booleanValue();
    }

    public String getRelatedEnv() {
        return this.c;
    }

    public void setRelatedEnv(String str) {
        this.c = str;
    }

    public String getUserId() {
        return this.d;
    }

    public void setUserId(String str) {
        this.d = str;
    }

    public String getCategory() {
        return this.e;
    }

    public void setCategory(String str) {
        this.e = str;
    }
}
