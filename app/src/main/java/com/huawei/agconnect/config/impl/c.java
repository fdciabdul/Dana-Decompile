package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.config.LazyInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class c extends AGConnectServicesConfig {
    private LazyInputStream KClassImpl$Data$declaredNonStaticMembers$2;
    private final String MyBillsEntityDataFactory;
    private final Context PlaceComponentResult;
    private volatile d getAuthRequestContext;
    private volatile e getErrorConfigVersion;
    private final Object BuiltInFictitiousFunctionClassFactory = new Object();
    private AGCRoutePolicy lookAheadTest = AGCRoutePolicy.getAuthRequestContext;
    private final Map<String, String> moveToNextValue = new HashMap();

    /* renamed from: com.huawei.agconnect.config.impl.c$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    static final class AnonymousClass1 extends LazyInputStream {
        final /* synthetic */ InputStream PlaceComponentResult;

        @Override // com.huawei.agconnect.config.LazyInputStream
        public final InputStream KClassImpl$Data$declaredNonStaticMembers$2() {
            return this.PlaceComponentResult;
        }
    }

    public c(Context context, String str) {
        this.PlaceComponentResult = context;
        this.MyBillsEntityDataFactory = str;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public final AGCRoutePolicy BuiltInFictitiousFunctionClassFactory() {
        if (this.lookAheadTest == null) {
            this.lookAheadTest = AGCRoutePolicy.getAuthRequestContext;
        }
        if (this.lookAheadTest == AGCRoutePolicy.getAuthRequestContext && this.getAuthRequestContext == null) {
            PlaceComponentResult();
        }
        AGCRoutePolicy aGCRoutePolicy = this.lookAheadTest;
        return aGCRoutePolicy == null ? AGCRoutePolicy.getAuthRequestContext : aGCRoutePolicy;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public final Context KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public final String MyBillsEntityDataFactory() {
        return "DEFAULT_INSTANCE";
    }

    private void PlaceComponentResult() {
        if (this.getAuthRequestContext == null) {
            synchronized (this.BuiltInFictitiousFunctionClassFactory) {
                if (this.getAuthRequestContext == null) {
                    LazyInputStream lazyInputStream = this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (lazyInputStream != null) {
                        if (lazyInputStream.BuiltInFictitiousFunctionClassFactory == null) {
                            Context context = lazyInputStream.getAuthRequestContext;
                            lazyInputStream.BuiltInFictitiousFunctionClassFactory = lazyInputStream.KClassImpl$Data$declaredNonStaticMembers$2();
                        }
                        this.getAuthRequestContext = new h(lazyInputStream.BuiltInFictitiousFunctionClassFactory);
                        Utils.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory);
                        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    } else {
                        this.getAuthRequestContext = new k(this.PlaceComponentResult, this.MyBillsEntityDataFactory);
                    }
                    this.getErrorConfigVersion = new e(this.getAuthRequestContext);
                }
                if (this.lookAheadTest == AGCRoutePolicy.getAuthRequestContext) {
                    if (this.getAuthRequestContext != null) {
                        this.lookAheadTest = Utils.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory("/region", null), this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory("/agcgw/url", null));
                    } else {
                        InstrumentInjector.log_w("AGConnectServiceConfig", "get route fail , config not ready");
                    }
                }
            }
        }
    }

    @Override // com.huawei.agconnect.AGConnectOptions
    public final String BuiltInFictitiousFunctionClassFactory(String str) {
        Map<String, JsonProcessingFactory.JsonProcessor> map;
        JsonProcessingFactory.JsonProcessor jsonProcessor;
        if (str != null) {
            if (this.getAuthRequestContext == null) {
                PlaceComponentResult();
            }
            int i = 0;
            if (str.length() > 0) {
                while (str.charAt(i) == '/') {
                    i++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append('/');
            sb.append(str.substring(i));
            String obj = sb.toString();
            String str2 = this.moveToNextValue.get(obj);
            if (str2 != null) {
                return str2;
            }
            map = JsonProcessingFactory.MyBillsEntityDataFactory;
            String authRequestContext = (!map.containsKey(obj) || (jsonProcessor = map.get(obj)) == null) ? null : jsonProcessor.getAuthRequestContext(this);
            if (authRequestContext != null) {
                return authRequestContext;
            }
            String BuiltInFictitiousFunctionClassFactory = this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(obj, null);
            return e.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory) ? this.getErrorConfigVersion.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory, null) : BuiltInFictitiousFunctionClassFactory;
        }
        throw new NullPointerException("path must not be null.");
    }
}
