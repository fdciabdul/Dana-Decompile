package com.alipay.plus.android.ab.sdk;

import android.content.Context;
import com.alipay.plus.android.ab.sdk.monitor.AbTestingMonitor;
import com.alipay.plus.android.ab.sdk.rpc.AbTestingRpcProvider;
import com.alipay.plus.android.ab.sdk.rpc.DefaultAbTestingRpcProvider;
import com.alipay.plus.android.ab.sdk.trigger.AbTestingSyncTrigger;
import com.alipay.plus.android.ab.sdk.trigger.AbTestingTrigger;
import com.alipay.plus.android.config.sdk.a.e;
import com.alipay.plus.android.config.sdk.a.g;
import com.alipay.plus.android.config.sdk.delegate.ConfigIdentifierProvider;
import java.util.Map;

/* loaded from: classes7.dex */
public class AbTestingContext {
    public static final String PROD_ENVIRONMENT = "prod";

    /* renamed from: a  reason: collision with root package name */
    private static final String f7340a = e.a("AbTestingContext");
    private Context b;
    private String c;
    private String g;
    private String h;
    private Map<String, String> i;
    private String j;
    private AbTestingTrigger d = new AbTestingSyncTrigger();
    private AbTestingRpcProvider e = new DefaultAbTestingRpcProvider();
    private AbTestingMonitor f = new AbTestingMonitor.IAPLogMonitor();
    private ConfigIdentifierProvider k = new g();

    public AbTestingContext(Context context, String str) {
        this.b = context;
        this.c = str;
    }

    public AbTestingMonitor getAbTestingMonitor() {
        return this.f;
    }

    public AbTestingRpcProvider getAbTestingRpcProvider() {
        return this.e;
    }

    public AbTestingTrigger getAbTestingTrigger() {
        return this.d;
    }

    public Map<String, String> getCondition() {
        return this.i;
    }

    public Context getContext() {
        return this.b;
    }

    public String getCookie() {
        return this.h;
    }

    public String getDeviceId() {
        String str = this.j;
        return str == null ? this.k.getUtdId(this.b) : str;
    }

    public String getEnvironment() {
        return this.c;
    }

    public ConfigIdentifierProvider getIdentifierProvider() {
        return this.k;
    }

    public String getUserId() {
        return this.g;
    }

    public void setAbTestingMonitor(AbTestingMonitor abTestingMonitor) {
        this.f = abTestingMonitor;
    }

    public void setAbTestingRpcProvider(AbTestingRpcProvider abTestingRpcProvider) {
        this.e = abTestingRpcProvider;
    }

    public void setAbTestingTrigger(AbTestingTrigger abTestingTrigger) {
        this.d = abTestingTrigger;
    }

    public void setCondition(Map<String, String> map) {
        this.i = map;
    }

    public void setContext(Context context) {
        this.b = context;
    }

    public void setCookie(String str) {
        this.h = str;
    }

    public void setDeviceId(String str) {
        this.j = str;
    }

    public void setEnvironment(String str) {
        this.c = str;
    }

    public void setIdentifierProvider(ConfigIdentifierProvider configIdentifierProvider) {
        this.k = configIdentifierProvider;
    }

    public void setUserId(String str) {
        this.g = str;
    }
}
