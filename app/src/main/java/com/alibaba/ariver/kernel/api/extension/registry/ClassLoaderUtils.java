package com.alibaba.ariver.kernel.api.extension.registry;

import com.alibaba.ariver.kernel.api.classloader.RVClassLoaderFactory;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.exthub.common.ExtHubLogger;

/* loaded from: classes3.dex */
class ClassLoaderUtils {
    ClassLoaderUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<? extends Extension> loadClass(String str, String str2) {
        try {
            return ((RVClassLoaderFactory) RVProxy.get(RVClassLoaderFactory.class)).getClassLoader(str).loadClass(str2);
        } catch (Throwable th) {
            ExtHubLogger.e("AriverKernel:ClassLoaderUtils", "failed to load class", th);
            return null;
        }
    }
}
