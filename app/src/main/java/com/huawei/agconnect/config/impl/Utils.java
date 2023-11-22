package com.huawei.agconnect.config.impl;

import com.fullstory.instrumentation.InstrumentInjector;
import com.huawei.agconnect.AGCRoutePolicy;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public final class Utils {
    public static AGCRoutePolicy BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        if (str != null) {
            str.hashCode();
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 2155) {
                if (hashCode != 2177) {
                    if (hashCode != 2627) {
                        if (hashCode == 2644 && str.equals("SG")) {
                            c = 3;
                        }
                    } else if (str.equals("RU")) {
                        c = 2;
                    }
                } else if (str.equals("DE")) {
                    c = 1;
                }
            } else if (str.equals("CN")) {
                c = 0;
            }
            if (c == 0) {
                return AGCRoutePolicy.MyBillsEntityDataFactory;
            }
            if (c == 1) {
                return AGCRoutePolicy.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (c == 2) {
                return AGCRoutePolicy.BuiltInFictitiousFunctionClassFactory;
            }
            if (c == 3) {
                return AGCRoutePolicy.PlaceComponentResult;
            }
        }
        if (str2 != null) {
            if (str2.contains("connect-drcn")) {
                return AGCRoutePolicy.MyBillsEntityDataFactory;
            }
            if (str2.contains("connect-dre")) {
                return AGCRoutePolicy.KClassImpl$Data$declaredNonStaticMembers$2;
            }
            if (str2.contains("connect-drru")) {
                return AGCRoutePolicy.BuiltInFictitiousFunctionClassFactory;
            }
            if (str2.contains("connect-dra")) {
                return AGCRoutePolicy.PlaceComponentResult;
            }
        }
        return AGCRoutePolicy.getAuthRequestContext;
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        int i = 0;
        if (str.length() > 0) {
            while (str.charAt(i) == '/') {
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        sb.append(str.substring(i));
        return sb.toString();
    }

    public static Map<String, String> PlaceComponentResult(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(BuiltInFictitiousFunctionClassFactory(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static void PlaceComponentResult(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                InstrumentInjector.log_e("Utils", "Exception when closing the 'Closeable'.");
            }
        }
    }

    public static String getAuthRequestContext(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, str);
        char[] cArr = new char[4096];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (-1 == read) {
                return stringWriter.toString();
            }
            stringWriter.write(cArr, 0, read);
        }
    }
}
