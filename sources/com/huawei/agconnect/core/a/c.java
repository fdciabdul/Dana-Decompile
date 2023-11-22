package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class c {
    final Context MyBillsEntityDataFactory;

    /* loaded from: classes7.dex */
    static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a  reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.MyBillsEntityDataFactory = context;
    }

    private Bundle BuiltInFictitiousFunctionClassFactory() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.MyBillsEntityDataFactory.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.MyBillsEntityDataFactory, ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get ServiceDiscovery exception.");
            sb.append(e.getLocalizedMessage());
            InstrumentInjector.log_e("ServiceRegistrarParser", sb.toString());
        }
        if (serviceInfo == null) {
            InstrumentInjector.log_e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
            return null;
        }
        return serviceInfo.metaData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends ServiceRegistrar> T KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        StringBuilder sb;
        String obj;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(cls);
            sb2.append(" must extends from ServiceRegistrar.");
            InstrumentInjector.log_e("ServiceRegistrarParser", sb2.toString());
            return null;
        } catch (ClassNotFoundException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Can not found service class, ");
            sb3.append(e.getMessage());
            obj = sb3.toString();
            InstrumentInjector.log_e("ServiceRegistrarParser", obj);
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            obj = sb.toString();
            InstrumentInjector.log_e("ServiceRegistrarParser", obj);
            return null;
        } catch (InstantiationException e3) {
            e = e3;
            sb = new StringBuilder();
            sb.append("instantiate service class exception ");
            sb.append(e.getLocalizedMessage());
            obj = sb.toString();
            InstrumentInjector.log_e("ServiceRegistrarParser", obj);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<String> MyBillsEntityDataFactory() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : BuiltInFictitiousFunctionClassFactory.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(BuiltInFictitiousFunctionClassFactory.getString(str))) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder();
                        sb.append("registrar configuration format error:");
                        str = e.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb = new StringBuilder();
                    sb.append("registrar configuration error, ");
                    sb.append(str);
                    InstrumentInjector.log_e("ServiceRegistrarParser", sb.toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }
}
