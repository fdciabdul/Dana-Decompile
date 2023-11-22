package com.huawei.agconnect.core.a;

import android.content.Context;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.JsonProcessingFactory;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.huawei.agconnect.core.service.auth.AuthProvider;
import com.huawei.agconnect.core.service.auth.CredentialsProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class b extends AGConnectInstance {
    private static List<Service> MyBillsEntityDataFactory;
    private static String getAuthRequestContext;
    private final AGConnectOptions BuiltInFictitiousFunctionClassFactory;
    private final d getErrorConfigVersion;
    private final d lookAheadTest;
    private static final Object PlaceComponentResult = new Object();
    private static final Map<String, AGConnectInstance> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();

    /* renamed from: com.huawei.agconnect.core.a.b$4  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass4 implements CredentialsProvider {
    }

    /* renamed from: com.huawei.agconnect.core.a.b$5  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass5 implements AuthProvider {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AGConnectInstance BuiltInFictitiousFunctionClassFactory(AGConnectOptions aGConnectOptions, boolean z) {
        AGConnectInstance aGConnectInstance;
        synchronized (PlaceComponentResult) {
            Map<String, AGConnectInstance> map = KClassImpl$Data$declaredNonStaticMembers$2;
            aGConnectInstance = map.get(aGConnectOptions.MyBillsEntityDataFactory());
            if (aGConnectInstance == null || z) {
                aGConnectInstance = new b(aGConnectOptions);
                map.put(aGConnectOptions.MyBillsEntityDataFactory(), aGConnectInstance);
            }
        }
        return aGConnectInstance;
    }

    public static AGConnectInstance getAuthRequestContext() {
        String str = getAuthRequestContext;
        if (str == null) {
            str = "DEFAULT_INSTANCE";
        }
        return getAuthRequestContext(str);
    }

    private static AGConnectInstance getAuthRequestContext(String str) {
        AGConnectInstance aGConnectInstance;
        String str2;
        String obj;
        synchronized (PlaceComponentResult) {
            aGConnectInstance = KClassImpl$Data$declaredNonStaticMembers$2.get(str);
            if (aGConnectInstance == null) {
                if ("DEFAULT_INSTANCE".equals(str)) {
                    str2 = "AGC_Instance";
                    obj = "please call `initialize()` first";
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("not find instance for : ");
                    sb.append(str);
                    str2 = "AGC_Instance";
                    obj = sb.toString();
                }
                InstrumentInjector.log_w(str2, obj);
            }
        }
        return aGConnectInstance;
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public final Context MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // com.huawei.agconnect.AGConnectInstance
    public final AGConnectOptions PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    private b(AGConnectOptions aGConnectOptions) {
        this.BuiltInFictitiousFunctionClassFactory = aGConnectOptions;
        if (MyBillsEntityDataFactory == null) {
            InstrumentInjector.log_e("AGConnectInstance", "please call `initialize()` first");
        }
        this.getErrorConfigVersion = new d(MyBillsEntityDataFactory, aGConnectOptions.KClassImpl$Data$declaredNonStaticMembers$2());
        d dVar = new d(null, aGConnectOptions.KClassImpl$Data$declaredNonStaticMembers$2());
        this.lookAheadTest = dVar;
        if (aGConnectOptions instanceof com.huawei.agconnect.config.impl.b) {
            dVar.BuiltInFictitiousFunctionClassFactory(((com.huawei.agconnect.config.impl.b) aGConnectOptions).getAuthRequestContext, aGConnectOptions.KClassImpl$Data$declaredNonStaticMembers$2());
        }
    }

    public static void BuiltInFictitiousFunctionClassFactory(Context context) {
        synchronized (b.class) {
            if (KClassImpl$Data$declaredNonStaticMembers$2.size() > 0) {
                InstrumentInjector.log_w("AGC_Instance", "Repeated invoking initialize");
                return;
            }
            AGConnectServicesConfig PlaceComponentResult2 = AGConnectServicesConfig.PlaceComponentResult(context);
            synchronized (b.class) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    InstrumentInjector.log_w("AGC_Instance", "context.getApplicationContext null");
                } else {
                    context = applicationContext;
                }
                JsonProcessingFactory.BuiltInFictitiousFunctionClassFactory("/agcgw/url", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.1
                    @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
                    public final String getAuthRequestContext(AGConnectOptions aGConnectOptions) {
                        String str;
                        if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.MyBillsEntityDataFactory)) {
                            str = "/agcgw_all/CN";
                        } else if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.BuiltInFictitiousFunctionClassFactory)) {
                            str = "/agcgw_all/RU";
                        } else if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.KClassImpl$Data$declaredNonStaticMembers$2)) {
                            str = "/agcgw_all/DE";
                        } else if (!aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.PlaceComponentResult)) {
                            return null;
                        } else {
                            str = "/agcgw_all/SG";
                        }
                        return aGConnectOptions.BuiltInFictitiousFunctionClassFactory(str);
                    }
                });
                JsonProcessingFactory.BuiltInFictitiousFunctionClassFactory("/agcgw/backurl", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.2
                    @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
                    public final String getAuthRequestContext(AGConnectOptions aGConnectOptions) {
                        String str;
                        if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.MyBillsEntityDataFactory)) {
                            str = "/agcgw_all/CN_back";
                        } else if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.BuiltInFictitiousFunctionClassFactory)) {
                            str = "/agcgw_all/RU_back";
                        } else if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.KClassImpl$Data$declaredNonStaticMembers$2)) {
                            str = "/agcgw_all/DE_back";
                        } else if (!aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.PlaceComponentResult)) {
                            return null;
                        } else {
                            str = "/agcgw_all/SG_back";
                        }
                        return aGConnectOptions.BuiltInFictitiousFunctionClassFactory(str);
                    }
                });
                JsonProcessingFactory.BuiltInFictitiousFunctionClassFactory("/service/analytics/collector_url", new JsonProcessingFactory.JsonProcessor() { // from class: com.huawei.agconnect.core.a.b.3
                    @Override // com.huawei.agconnect.JsonProcessingFactory.JsonProcessor
                    public final String getAuthRequestContext(AGConnectOptions aGConnectOptions) {
                        String str;
                        if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.MyBillsEntityDataFactory)) {
                            str = "/service/analytics/collector_url_cn";
                        } else if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.BuiltInFictitiousFunctionClassFactory)) {
                            str = "/service/analytics/collector_url_ru";
                        } else if (aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.KClassImpl$Data$declaredNonStaticMembers$2)) {
                            str = "/service/analytics/collector_url_de";
                        } else if (!aGConnectOptions.BuiltInFictitiousFunctionClassFactory().equals(AGCRoutePolicy.PlaceComponentResult)) {
                            return null;
                        } else {
                            str = "/service/analytics/collector_url_sg";
                        }
                        return aGConnectOptions.BuiltInFictitiousFunctionClassFactory(str);
                    }
                });
                com.huawei.agconnect.config.impl.a.getAuthRequestContext(context);
                if (MyBillsEntityDataFactory == null) {
                    c cVar = new c(context);
                    InstrumentInjector.log_i("ServiceRegistrarParser", "getServices");
                    List<String> MyBillsEntityDataFactory2 = cVar.MyBillsEntityDataFactory();
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> it = MyBillsEntityDataFactory2.iterator();
                    while (it.hasNext()) {
                        ServiceRegistrar KClassImpl$Data$declaredNonStaticMembers$22 = c.KClassImpl$Data$declaredNonStaticMembers$2(it.next());
                        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
                            Context context2 = cVar.MyBillsEntityDataFactory;
                            Context context3 = cVar.MyBillsEntityDataFactory;
                            List<Service> MyBillsEntityDataFactory3 = KClassImpl$Data$declaredNonStaticMembers$22.MyBillsEntityDataFactory();
                            if (MyBillsEntityDataFactory3 != null) {
                                arrayList.addAll(MyBillsEntityDataFactory3);
                            }
                        }
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("services:");
                    sb.append(Integer.valueOf(arrayList.size()));
                    InstrumentInjector.log_i("ServiceRegistrarParser", sb.toString());
                    MyBillsEntityDataFactory = arrayList;
                }
                BuiltInFictitiousFunctionClassFactory(PlaceComponentResult2, true);
                getAuthRequestContext = PlaceComponentResult2.MyBillsEntityDataFactory();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("AGC SDK initialize end, default route:");
                int i = PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory().getErrorConfigVersion;
                sb2.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "SG" : "RU" : "DE" : "CN");
                InstrumentInjector.log_i("AGC_Instance", sb2.toString());
                a.PlaceComponentResult();
            }
        }
    }
}
