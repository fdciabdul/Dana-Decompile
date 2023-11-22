package com.alipay.plus.android.unipayresult.sdk.executor.a;

import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCallback;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncMessage;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncProvider;
import com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback;
import com.alipay.plus.android.unipayresult.sdk.client.UnifierQueryClient;
import com.alipay.plus.android.unipayresult.sdk.client.UnifierQueryClientContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7402a;
    private Map<String, List<a>> b = new HashMap();
    private IAPSyncCallback c = new IAPSyncMessageParsedCallback() { // from class: com.alipay.plus.android.unipayresult.sdk.executor.a.b.1
        @Override // com.alipay.iap.android.common.syncintegration.impl.IAPSyncMessageParsedCallback
        public void onReceiveParsedSyncMessage(IAPSyncMessage iAPSyncMessage, String str, List<String> list) {
            LoggerWrapper.e("UnifierSyncCenter", String.format("Receive pay result sync message!\nmessageId = %s, userId = %s, biz = %s, message = %s", iAPSyncMessage.messageId, iAPSyncMessage.userId, iAPSyncMessage.biz, iAPSyncMessage.msgData));
            b.this.a(list);
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void handleSyncMessage(List<String> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        Map<String, List<String>> a2 = com.alipay.plus.android.unipayresult.sdk.executor.a.a.a(list);
        if (a2.isEmpty()) {
            LoggerWrapper.e("UnifierSyncCenter", "Cannot parse sync orders!");
            return;
        }
        synchronized (this) {
            for (Map.Entry<String, List<String>> entry : a2.entrySet()) {
                String key = entry.getKey();
                List<a> list2 = this.b.get(key);
                if (list2 == null) {
                    LoggerWrapper.e("UnifierSyncCenter", String.format("Skip sync order info! bizType = %s.", key));
                } else {
                    Iterator<a> it = list2.iterator();
                    while (it.hasNext()) {
                        it.next().handleSyncMessage(entry.getValue());
                    }
                }
            }
        }
    }

    private IAPSyncProvider b() {
        String str;
        UnifierQueryClientContext clientContext = UnifierQueryClient.getInstance().getClientContext();
        if (clientContext == null) {
            str = "Cannot start sync executor! you must initialize UnifierQueryClient first!";
        } else if (clientContext.mSyncProvider != null) {
            return clientContext.mSyncProvider;
        } else {
            str = "Cannot start sync executor! you must provide ISyncProvider!";
        }
        LoggerWrapper.e("UnifierSyncCenter", str);
        return null;
    }

    public void a() {
        IAPSyncProvider b;
        if (this.f7402a || (b = b()) == null) {
            return;
        }
        this.f7402a = true;
        b.registerReceiveCallback("UNI-RESULT-PAGE", this.c);
    }

    public void a(String str, a aVar) {
        synchronized (this) {
            List<a> list = this.b.get(str);
            if (list == null) {
                list = new ArrayList<>();
                this.b.put(str, list);
            }
            list.add(aVar);
        }
    }

    public void b(String str, a aVar) {
        synchronized (this) {
            List<a> list = this.b.get(str);
            if (list != null && !list.isEmpty()) {
                list.remove(aVar);
            }
        }
    }
}
