package com.alibaba.ariver.kernel.api.extension.registry;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ExtensionBlackListStore {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Set<String>> f6089a = new ConcurrentHashMap();

    public static void setupExtensionBlackList(ExtensionMetaInfo extensionMetaInfo) {
        if (extensionMetaInfo.getExcludeNodes().isEmpty()) {
            return;
        }
        f6089a.put(extensionMetaInfo.extensionClass, extensionMetaInfo.getExcludeNodes());
    }

    public static boolean isInExtensionBlackList(String str, String str2) {
        Set<String> set = f6089a.get(str);
        if (set != null) {
            return set.contains(str2);
        }
        return false;
    }
}
