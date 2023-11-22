package com.alibaba.ariver.engine.api.bridge.remote;

import android.text.TextUtils;
import androidx.collection.LongSparseArray;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class RemoteCallbackPool {
    private static RemoteCallbackPool b;

    /* renamed from: a  reason: collision with root package name */
    private final LongSparseArray<Map<String, SendToNativeCallback>> f6025a = new LongSparseArray<>();
    private int c = 0;

    public static RemoteCallbackPool getInstance() {
        if (b == null) {
            synchronized (RemoteCallbackPool.class) {
                if (b == null) {
                    b = new RemoteCallbackPool();
                }
            }
        }
        return b;
    }

    public int getCallbackCount() {
        return this.c;
    }

    public void registerCallback(NativeCallContext nativeCallContext, SendToNativeCallback sendToNativeCallback) {
        synchronized (this) {
            Node node = nativeCallContext.getNode();
            if (node == null) {
                RVLogger.w("AriverEngine:RemoteCallbackPool", "registerCallback but node == null!");
                return;
            }
            Map<String, SendToNativeCallback> MyBillsEntityDataFactory = this.f6025a.MyBillsEntityDataFactory(node.getNodeId(), null);
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new HashMap<>();
                this.f6025a.getAuthRequestContext(node.getNodeId(), MyBillsEntityDataFactory);
            }
            this.c++;
            MyBillsEntityDataFactory.put(nativeCallContext.getId(), sendToNativeCallback);
        }
    }

    public SendToNativeCallback getCallback(long j, String str, boolean z) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Map<String, SendToNativeCallback> MyBillsEntityDataFactory = this.f6025a.MyBillsEntityDataFactory(j, null);
            if (MyBillsEntityDataFactory == null) {
                return null;
            }
            SendToNativeCallback sendToNativeCallback = MyBillsEntityDataFactory.get(str);
            if (sendToNativeCallback != null && z) {
                MyBillsEntityDataFactory.remove(str);
                this.c--;
                if (MyBillsEntityDataFactory.isEmpty()) {
                    this.f6025a.PlaceComponentResult(j);
                }
            }
            return sendToNativeCallback;
        }
    }
}
