package com.alibaba.ariver.integration.ipc.server;

import androidx.collection.LongSparseArray;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ServerSideCallbackHolder {

    /* renamed from: a  reason: collision with root package name */
    private static ServerSideCallbackHolder f6060a;
    private static LongSparseArray<Set<String>> b = new LongSparseArray<>();
    private static Map<String, SendToNativeCallback> c = new HashMap();

    public static ServerSideCallbackHolder getInstance() {
        if (f6060a == null) {
            synchronized (ServerSideCallbackHolder.class) {
                if (f6060a == null) {
                    f6060a = new ServerSideCallbackHolder();
                }
            }
        }
        return f6060a;
    }

    public void registerCallback(long j, String str, SendToNativeCallback sendToNativeCallback) {
        synchronized (this) {
            if (sendToNativeCallback == null) {
                return;
            }
            Set<String> MyBillsEntityDataFactory = b.MyBillsEntityDataFactory(j, null);
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new HashSet<>();
                b.getAuthRequestContext(j, MyBillsEntityDataFactory);
            }
            MyBillsEntityDataFactory.add(str);
            c.put(str, sendToNativeCallback);
        }
    }

    public void unbindStartToken(long j) {
        synchronized (this) {
            Set<String> MyBillsEntityDataFactory = b.MyBillsEntityDataFactory(j, null);
            if (MyBillsEntityDataFactory != null) {
                Iterator<String> it = MyBillsEntityDataFactory.iterator();
                while (it.hasNext()) {
                    c.remove(it.next());
                }
                b.PlaceComponentResult(j);
            }
        }
    }

    public SendToNativeCallback getCallback(long j, String str, boolean z) {
        SendToNativeCallback sendToNativeCallback;
        synchronized (this) {
            sendToNativeCallback = c.get(str);
            if (!z) {
                c.remove(str);
                Set<String> MyBillsEntityDataFactory = b.MyBillsEntityDataFactory(j, null);
                if (MyBillsEntityDataFactory != null) {
                    MyBillsEntityDataFactory.remove(str);
                }
            }
        }
        return sendToNativeCallback;
    }
}
