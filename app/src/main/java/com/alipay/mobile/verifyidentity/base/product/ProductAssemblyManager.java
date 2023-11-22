package com.alipay.mobile.verifyidentity.base.product;

import android.text.TextUtils;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ProductAssemblyManager {
    private static Map<String, ProductAssembly> productAssemblyMap = new ConcurrentHashMap();

    public static void addProductAssembly(String str, ProductAssembly productAssembly) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        productAssemblyMap.put(str, productAssembly);
    }

    public static ProductAssembly getProductAssembly(String str) {
        if (!TextUtils.isEmpty(str) && productAssemblyMap.containsKey(str)) {
            return productAssemblyMap.get(str);
        }
        return null;
    }
}
