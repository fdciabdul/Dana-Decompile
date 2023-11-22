package com.alipay.androidinter.app.safepaybase.alikeyboard;

import com.alipay.androidinter.app.safepaybase.log.LogTracer;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class KeyboardManager {
    private static Map<Integer, AlipayKeyboard> keyboardMap = new ConcurrentHashMap();

    public static void bindKeyboard(int i, AlipayKeyboard alipayKeyboard) {
        if (alipayKeyboard == null) {
            return;
        }
        LogTracer logTracer = LogTracer.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("KeyboardManager-bindKeyboard:");
        sb.append(i);
        logTracer.traceInfo("KeyboardManager::bindKeyboard", sb.toString());
        keyboardMap.put(Integer.valueOf(i), alipayKeyboard);
    }

    public static void unBindKeyboard(int i) {
        LogTracer logTracer = LogTracer.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("KeyboardManager-unBindKeyboard:");
        sb.append(i);
        logTracer.traceInfo("KeyboardManager::unBindKeyboard", sb.toString());
        if (keyboardMap.containsKey(Integer.valueOf(i))) {
            keyboardMap.remove(Integer.valueOf(i));
        }
    }

    public static AlipayKeyboard getKeyboard(int i) {
        LogTracer logTracer = LogTracer.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("KeyboardManager-getKeyboard:");
        sb.append(i);
        logTracer.traceInfo("KeyboardManager::getKeyboard", sb.toString());
        if (keyboardMap.containsKey(Integer.valueOf(i))) {
            return keyboardMap.get(Integer.valueOf(i));
        }
        return null;
    }

    public static boolean isBindKeyboard(int i) {
        return getKeyboard(i) != null;
    }
}
