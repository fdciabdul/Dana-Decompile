package com.alipay.mobile.rome.syncservice.up;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.griver.ui.ant.api.AUAttrsConstant;
import com.alipay.mobile.rome.longlinkservice.ISyncUpCallback;
import com.alipay.mobile.rome.longlinkservice.ISyncUpResp;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncUpMessage;
import com.alipay.mobile.rome.longlinkservice.syncmodel.SyncUpResp;
import com.alipay.mobile.rome.syncsdk.util.e;
import com.alipay.mobile.rome.syncservice.c.a.f;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7309a = "b";
    private static b c;
    public d b;
    private com.alipay.mobile.rome.syncservice.sync.b.a.a d;
    private Context e;
    private HashMap<String, com.alipay.mobile.rome.syncservice.sync.d.b> f = new HashMap<>();
    private HashMap<c, List<com.alipay.mobile.rome.syncservice.sync.d.b>> g = new HashMap<>();
    private HashMap<String, ISyncUpResp<?>> h = new HashMap<>();
    private AtomicInteger i = new AtomicInteger(0);
    private int j = 30000;

    public static b a() {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b();
                }
            }
        }
        return c;
    }

    private b() {
        Context context = com.alipay.mobile.rome.syncservice.d.a.f7279a;
        this.e = context;
        this.d = com.alipay.mobile.rome.syncservice.sync.b.a.a.a(context);
        HandlerThread handlerThread = new HandlerThread("sync_up");
        handlerThread.start();
        this.b = new d(this, handlerThread.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        a(arrayList);
    }

    private <T> void a(com.alipay.mobile.rome.syncservice.sync.d.b bVar, ISyncUpResp<T> iSyncUpResp) {
        if (bVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "uplinkMsg uplinkMsgItem is null");
        } else if (TextUtils.isEmpty(bVar.c)) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "uplinkMsg userId is null");
        } else if (a(bVar.e, bVar.expireTime)) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "uplinkMsg msg is expired!");
            a(bVar, true);
        } else {
            String str = f7309a;
            StringBuilder sb = new StringBuilder("uplinkMsg: sendImmediate=");
            sb.append(bVar.g);
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
            if (!bVar.g) {
                a(bVar, bVar.sendTime);
            } else {
                a(bVar, 0L);
            }
            if (iSyncUpResp != null) {
                this.h.put(bVar.b, iSyncUpResp);
            }
            if (bVar.expireTime > 0) {
                a(bVar, false);
            }
        }
    }

    private void a(c cVar, List<com.alipay.mobile.rome.syncservice.sync.d.b> list) {
        if (list == null || list.isEmpty()) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "batchSendSyncUplinkMsg: uplinkMsgItemList is null or empty!");
        } else if (cVar == null) {
        } else {
            if (list == null || list.isEmpty()) {
                com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "send: uplinkMsgItemList is null or empty!");
            } else if (cVar != null) {
                String str = f7309a;
                StringBuilder sb = new StringBuilder("send: seqKey=");
                sb.append(cVar);
                com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
                com.alipay.mobile.rome.syncservice.sync.b a2 = com.alipay.mobile.rome.syncservice.sync.b.a();
                int i = cVar.f7310a;
                if (a2.f7291a.a(5001) instanceof f) {
                    com.alipay.mobile.rome.syncservice.a.a.a().a(f.a(i, list));
                }
                if (e.c(this.e) == 1) {
                    this.j = 15000;
                } else {
                    this.j = 30000;
                }
                this.b.sendMessageDelayed(this.b.obtainMessage(4, cVar), this.j);
            }
        }
    }

    private void a(List<com.alipay.mobile.rome.syncservice.sync.d.b> list) {
        if (list.isEmpty()) {
            return;
        }
        c cVar = new c(this.i.getAndIncrement());
        this.g.put(cVar, list);
        a(cVar, list);
    }

    private void b(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar != null && bVar.f == 1) {
            if (bVar.h == SyncUplinkCallbackType.TYPE_NORMAL) {
                if (com.alipay.mobile.rome.syncservice.sync.register.c.e(bVar.biz)) {
                    h(bVar);
                }
            } else if (bVar.h == SyncUplinkCallbackType.TYPE_NONE) {
                h(bVar);
            } else if (bVar.h == SyncUplinkCallbackType.TYPE_LIKE_RPC) {
                com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "dispatchSyncUplinkBizIfNeed: like rpc do nothing");
            }
        }
    }

    private static boolean a(long j, long j2) {
        return j2 > 0 && System.currentTimeMillis() > j + j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "onSyncUplinkExpired: uplinkMsgItem is null ");
            return;
        }
        String str = f7309a;
        StringBuilder sb = new StringBuilder("onSyncUplinkExpired: msgId=");
        sb.append(bVar.b);
        com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        if (a(bVar.e, bVar.expireTime)) {
            this.d.a(bVar);
            d(bVar);
            e(bVar);
        }
    }

    private com.alipay.mobile.rome.syncservice.sync.d.b d(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar.h == SyncUplinkCallbackType.TYPE_LIKE_RPC) {
            this.h.remove(bVar.b);
        }
        return this.f.remove(bVar.b);
    }

    private void e(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "deleteFromBatchList: toBeDeletedItem is null");
            return;
        }
        for (Map.Entry<c, List<com.alipay.mobile.rome.syncservice.sync.d.b>> entry : this.g.entrySet()) {
            List<com.alipay.mobile.rome.syncservice.sync.d.b> value = entry.getValue();
            if (value != null && value.contains(bVar)) {
                com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "deleteFromBatchList: uplinkMsgItem will be removed");
                value.remove(bVar);
                if (value.isEmpty()) {
                    this.g.remove(entry.getKey());
                    return;
                }
                return;
            }
        }
    }

    private void b(c cVar, List<com.alipay.mobile.rome.syncservice.sync.d.b> list) {
        if (list == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "entireAckRecevied: sendList is null");
            return;
        }
        String str = f7309a;
        StringBuilder sb = new StringBuilder("entireAckRecevied: sk=");
        sb.append(cVar);
        com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        Iterator<Map.Entry<c, List<com.alipay.mobile.rome.syncservice.sync.d.b>>> it = this.g.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c key = it.next().getKey();
            if (cVar.equals(key)) {
                String str2 = f7309a;
                StringBuilder sb2 = new StringBuilder("entireAckRecevied: removeMessage sequenceKey=");
                sb2.append(key);
                com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb2.toString());
                this.b.removeMessages(4, key);
                this.g.remove(key);
                break;
            }
        }
        Iterator<com.alipay.mobile.rome.syncservice.sync.d.b> it2 = list.iterator();
        while (it2.hasNext()) {
            f(it2.next());
        }
    }

    private void a(List<com.alipay.mobile.rome.syncservice.sync.d.b> list, List<com.alipay.mobile.rome.syncservice.sync.d.b> list2) {
        int size = list2.size();
        String str = f7309a;
        StringBuilder sb = new StringBuilder("partialAckReceived: recv size=");
        sb.append(size);
        com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        for (int i = 0; i < size; i++) {
            com.alipay.mobile.rome.syncservice.sync.d.b bVar = list2.get(i);
            if (bVar != null) {
                Iterator<com.alipay.mobile.rome.syncservice.sync.d.b> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    com.alipay.mobile.rome.syncservice.sync.d.b next = it.next();
                    if (bVar.equals(next)) {
                        f(next);
                        break;
                    }
                }
                list.remove(bVar);
            }
        }
    }

    private void f(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar == null) {
            return;
        }
        String str = f7309a;
        StringBuilder sb = new StringBuilder("ackReceivedOf: msgId=");
        sb.append(bVar.b);
        com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        String str2 = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        String str3 = bVar.biz;
        long j = bVar.f7301a;
        long j2 = bVar.e;
        int i = bVar.d;
        if (bVar.h == SyncUplinkCallbackType.TYPE_LIKE_RPC) {
            h(bVar);
        } else if (bVar.h == SyncUplinkCallbackType.TYPE_NORMAL) {
            if (com.alipay.mobile.rome.syncservice.sync.register.c.e(str3)) {
                h(bVar);
                return;
            }
            com.alipay.mobile.rome.syncservice.sync.b.a.a aVar = this.d;
            if (aVar.d.get()) {
                com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.sync.b.a.a.f7292a, "updateSendStatus...db recreating~");
            } else {
                aVar.b.a(str2, j, j2, i);
            }
        } else if (bVar.h == SyncUplinkCallbackType.TYPE_NONE) {
            h(bVar);
        } else {
            StringBuilder sb2 = new StringBuilder("ackReceivedOf: unsupported callbacktype=");
            sb2.append(bVar.h);
            com.alipay.mobile.rome.syncsdk.util.c.c(str, sb2.toString());
        }
    }

    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object, K] */
    private boolean g(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "callResponse: uplinkMsgItem is null");
            return false;
        } else if (TextUtils.isEmpty(bVar.i)) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "callResponse: result is null");
            return false;
        } else {
            ISyncUpResp<?> iSyncUpResp = this.h.get(bVar.b);
            if (iSyncUpResp == null) {
                com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "callResponse: callback is null");
                return false;
            }
            try {
                Type type = ((ParameterizedType) iSyncUpResp.getClass().getMethod("onUpResponse", SyncUpResp.class).getGenericParameterTypes()[0]).getActualTypeArguments()[0];
                SyncUpResp<?> syncUpResp = new SyncUpResp<>();
                syncUpResp.biz = bVar.biz;
                syncUpResp.bizId = bVar.bizId;
                syncUpResp.msgId = bVar.b;
                syncUpResp.respData = JSON.parseObject(bVar.i, type, new Feature[0]);
                iSyncUpResp.onUpResponse(syncUpResp);
                return true;
            } catch (NoSuchMethodException e) {
                String str = f7309a;
                StringBuilder sb = new StringBuilder("callResponse: ");
                sb.append(e);
                com.alipay.mobile.rome.syncsdk.util.c.d(str, sb.toString());
                return false;
            } catch (Exception e2) {
                String str2 = f7309a;
                StringBuilder sb2 = new StringBuilder("callResponse: ");
                sb2.append(e2);
                com.alipay.mobile.rome.syncsdk.util.c.d(str2, sb2.toString());
                return false;
            }
        }
    }

    private void a(com.alipay.mobile.rome.syncservice.sync.d.b bVar, boolean z) {
        Message obtainMessage = this.b.obtainMessage(1, bVar);
        if (z) {
            this.b.sendMessage(obtainMessage);
        } else {
            this.b.sendMessageDelayed(obtainMessage, bVar.expireTime);
        }
    }

    private void a(com.alipay.mobile.rome.syncservice.sync.d.b bVar, long j) {
        if (bVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "sendSyncUnplinkDelayed: uplinkMsgItem is null!");
            return;
        }
        this.f.put(bVar.b, bVar);
        if (j > 0) {
            this.b.sendMessageDelayed(this.b.obtainMessage(0, bVar), j);
            return;
        }
        a(bVar);
    }

    private void h(com.alipay.mobile.rome.syncservice.sync.d.b bVar) {
        if (bVar == null) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "onSyncUplinkFinished: uplinkMsgItem is null");
            return;
        }
        String str = f7309a;
        StringBuilder sb = new StringBuilder("onSyncUplinkFinished: msgId=");
        sb.append(bVar.b);
        sb.append(",callbackType=");
        sb.append(bVar.h);
        com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
        if (bVar.h == SyncUplinkCallbackType.TYPE_LIKE_RPC) {
            g(bVar);
        } else if (bVar != null && bVar.h == SyncUplinkCallbackType.TYPE_NORMAL) {
            String str2 = bVar.biz;
            String str3 = bVar.b;
            ISyncUpCallback d = com.alipay.mobile.rome.syncservice.sync.register.c.d(str2);
            if (d != null) {
                d.onSyncUpResult(str2, str3, ISyncUpCallback.SyncUpState.SUCCEED);
            } else {
                StringBuilder sb2 = new StringBuilder("onSyncUplinkCallback, callback is null[biz:");
                sb2.append(str2);
                sb2.append("][msgId:");
                sb2.append(str3);
                sb2.append("]");
                com.alipay.mobile.rome.syncsdk.util.c.a(str, sb2.toString());
            }
        }
        com.alipay.mobile.rome.syncservice.sync.b.a.a aVar = this.d;
        String str4 = bVar.c;
        long j = bVar.f7301a;
        long j2 = bVar.e;
        int i = bVar.d;
        if (aVar.d.get()) {
            com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.sync.b.a.a.f7292a, "deleteMsg...db recreating~");
        } else {
            aVar.b.b(str4, j, j2, i);
        }
        d(bVar);
    }

    public final void b() {
        this.b.sendEmptyMessage(2);
    }

    public static String a(long j, long j2, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.alipay.mobile.rome.syncservice.d.b.a(j2));
        sb.append("_");
        sb.append(i);
        sb.append("_");
        sb.append(j);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String a(b bVar, SyncUpMessage syncUpMessage, SyncUplinkCallbackType syncUplinkCallbackType, ISyncUpResp iSyncUpResp) {
        if (syncUpMessage == null) {
            com.alipay.mobile.rome.syncsdk.util.c.d(f7309a, "sendSyncUplinkMsg syncUpMessage is null");
            return "-1";
        }
        String str = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        if (TextUtils.isEmpty(str)) {
            com.alipay.mobile.rome.syncsdk.util.c.d(f7309a, "sendSyncUplinkMsg userId is null");
            return AUAttrsConstant.WRAP_CONTENT;
        }
        if (iSyncUpResp != null && syncUpMessage.reqData != null) {
            syncUpMessage.msgData = JSON.toJSONString(syncUpMessage.reqData, SerializerFeature.DisableCircularReferenceDetect);
        }
        com.alipay.mobile.rome.syncservice.sync.d.b bVar2 = new com.alipay.mobile.rome.syncservice.sync.d.b(syncUpMessage);
        bVar2.c = str;
        if (!TextUtils.isEmpty(bVar2.bizId)) {
            Iterator<Map.Entry<String, com.alipay.mobile.rome.syncservice.sync.d.b>> it = bVar.f.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.alipay.mobile.rome.syncservice.sync.d.b value = it.next().getValue();
                if (value != null) {
                    if (TextUtils.equals(value.bizId, bVar2.bizId) && TextUtils.equals(value.biz, bVar2.biz) && TextUtils.equals(value.c, bVar2.c)) {
                        com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "removeUnsendSyncUplinkMsg: the same entity");
                        com.alipay.mobile.rome.syncservice.sync.b.a.a aVar = bVar.d;
                        String str2 = value.c;
                        String str3 = value.biz;
                        String str4 = value.bizId;
                        if (aVar.d.get()) {
                            com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.sync.b.a.a.f7292a, "deleteMsgByBizId...db recreating~");
                        } else {
                            aVar.b.a(str2, str3, str4);
                        }
                        bVar.d(bVar2);
                        bVar.e(value);
                    }
                }
            }
        }
        int nextInt = new Random().nextInt(8999) + 1000;
        long currentTimeMillis = System.currentTimeMillis();
        com.alipay.mobile.rome.syncservice.sync.b.a.a aVar2 = bVar.d;
        long a2 = aVar2.b.a(str, nextInt, currentTimeMillis, syncUpMessage, syncUplinkCallbackType);
        if (a2 == -4) {
            a2 = aVar2.b.a(str, nextInt, currentTimeMillis, syncUpMessage, syncUplinkCallbackType);
        }
        if (a2 == -1) {
            com.alipay.mobile.rome.syncsdk.util.c.a(f7309a, "sendSyncUplinkMsg: insert to database error");
            return "-3";
        }
        String a3 = a(a2, currentTimeMillis, nextInt);
        bVar2.b = a3;
        bVar2.f7301a = a2;
        bVar2.d = nextInt;
        bVar2.e = currentTimeMillis;
        bVar2.g = syncUpMessage.sendTime <= 0;
        bVar2.h = syncUplinkCallbackType;
        String str5 = f7309a;
        StringBuilder sb = new StringBuilder("sendSyncUplinkMsg msgId:");
        sb.append(a3);
        com.alipay.mobile.rome.syncsdk.util.c.b(str5, sb.toString());
        bVar.a(bVar2, iSyncUpResp);
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, c cVar) {
        if (cVar != null) {
            cVar.b++;
            String str = f7309a;
            StringBuilder sb = new StringBuilder("RETRY_SEND_SYNC_UPLINK: retry=");
            sb.append(cVar.b);
            sb.append(",seq=");
            sb.append(cVar.f7310a);
            com.alipay.mobile.rome.syncsdk.util.c.a(str, sb.toString());
            if (cVar.b <= 2) {
                bVar.a(cVar, bVar.g.get(cVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar) {
        List<com.alipay.mobile.rome.syncservice.sync.d.b> b;
        String str = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        if (TextUtils.isEmpty(str)) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "startScanDatabaseAndParseMsg user does not login");
            return;
        }
        com.alipay.mobile.rome.syncservice.sync.b.a.a aVar = bVar.d;
        if (aVar.d.get()) {
            com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.sync.b.a.a.f7292a, "queryAllMsg...db recreating~");
            b = null;
        } else {
            b = aVar.b.b(str);
        }
        if (b == null) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "startScanDatabaseAndParseMsg: no item");
            return;
        }
        try {
            LinkedList linkedList = new LinkedList();
            String str2 = f7309a;
            StringBuilder sb = new StringBuilder("analysizeSyncUplinkList enter totalSize=");
            sb.append(b.size());
            com.alipay.mobile.rome.syncsdk.util.c.a(str2, sb.toString());
            loop0: while (true) {
                int i = 0;
                for (com.alipay.mobile.rome.syncservice.sync.d.b bVar2 : b) {
                    if (bVar2 != null) {
                        if (bVar2.f == 1) {
                            bVar.b(bVar2);
                        } else if (a(bVar2.e, bVar2.expireTime)) {
                            bVar.c(bVar2);
                        } else if (bVar2.g) {
                            i++;
                            linkedList.add(bVar2);
                            bVar.f.put(bVar2.b, bVar2);
                            if (bVar2.expireTime > 0) {
                                bVar.a(bVar2, false);
                            }
                            if (i % 5 == 0) {
                                break;
                            }
                        } else {
                            bVar.a(bVar2, (ISyncUpResp) null);
                        }
                    }
                }
                bVar.a(linkedList);
                linkedList = new LinkedList();
            }
            if (linkedList.isEmpty()) {
                return;
            }
            bVar.a(linkedList);
        } catch (Exception e) {
            String str3 = f7309a;
            StringBuilder sb2 = new StringBuilder("analysizeSyncUplinkList: [Exception=");
            sb2.append(e);
            sb2.append("]");
            com.alipay.mobile.rome.syncsdk.util.c.d(str3, sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e A[Catch: Exception -> 0x00a6, TryCatch #0 {Exception -> 0x00a6, blocks: (B:5:0x0008, B:7:0x0017, B:10:0x0021, B:13:0x0029, B:16:0x0030, B:17:0x0034, B:19:0x003a, B:20:0x0044, B:22:0x004a, B:24:0x0052, B:26:0x0058, B:28:0x0079, B:30:0x009e, B:32:0x00a2, B:27:0x0072), top: B:39:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a2 A[Catch: Exception -> 0x00a6, TRY_LEAVE, TryCatch #0 {Exception -> 0x00a6, blocks: (B:5:0x0008, B:7:0x0017, B:10:0x0021, B:13:0x0029, B:16:0x0030, B:17:0x0034, B:19:0x003a, B:20:0x0044, B:22:0x004a, B:24:0x0052, B:26:0x0058, B:28:0x0079, B:30:0x009e, B:32:0x00a2, B:27:0x0072), top: B:39:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void a(com.alipay.mobile.rome.syncservice.up.b r8, int r9, java.util.List r10) {
        /*
            if (r10 == 0) goto Lbb
            boolean r0 = r10.isEmpty()
            if (r0 != 0) goto Lbb
            com.alipay.mobile.rome.syncservice.up.c r0 = new com.alipay.mobile.rome.syncservice.up.c     // Catch: java.lang.Exception -> La6
            r0.<init>(r9)     // Catch: java.lang.Exception -> La6
            java.util.HashMap<com.alipay.mobile.rome.syncservice.up.c, java.util.List<com.alipay.mobile.rome.syncservice.sync.d.b>> r1 = r8.g     // Catch: java.lang.Exception -> La6
            java.lang.Object r1 = r1.get(r0)     // Catch: java.lang.Exception -> La6
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Exception -> La6
            if (r1 != 0) goto L1f
            java.lang.String r8 = com.alipay.mobile.rome.syncservice.up.b.f7309a     // Catch: java.lang.Exception -> La6
            java.lang.String r9 = "onSyncUplinkAckReceived: sendList is null or 0"
            com.alipay.mobile.rome.syncsdk.util.c.c(r8, r9)     // Catch: java.lang.Exception -> La6
            return
        L1f:
            if (r1 == 0) goto L72
            boolean r2 = r1.isEmpty()     // Catch: java.lang.Exception -> La6
            if (r2 != 0) goto L72
            if (r10 == 0) goto L72
            boolean r2 = r10.isEmpty()     // Catch: java.lang.Exception -> La6
            if (r2 == 0) goto L30
            goto L72
        L30:
            java.util.Iterator r2 = r10.iterator()     // Catch: java.lang.Exception -> La6
        L34:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Exception -> La6
            if (r3 == 0) goto L79
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Exception -> La6
            com.alipay.mobile.rome.syncservice.sync.d.b r3 = (com.alipay.mobile.rome.syncservice.sync.d.b) r3     // Catch: java.lang.Exception -> La6
            java.util.Iterator r4 = r1.iterator()     // Catch: java.lang.Exception -> La6
        L44:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Exception -> La6
            if (r5 == 0) goto L34
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Exception -> La6
            com.alipay.mobile.rome.syncservice.sync.d.b r5 = (com.alipay.mobile.rome.syncservice.sync.d.b) r5     // Catch: java.lang.Exception -> La6
            if (r3 == 0) goto L44
            boolean r6 = r3.equals(r5)     // Catch: java.lang.Exception -> La6
            if (r6 == 0) goto L44
            java.lang.String r5 = r5.i     // Catch: java.lang.Exception -> La6
            r3.i = r5     // Catch: java.lang.Exception -> La6
            java.lang.String r5 = com.alipay.mobile.rome.syncservice.up.b.f7309a     // Catch: java.lang.Exception -> La6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La6
            java.lang.String r7 = "copyResult: result="
            r6.<init>(r7)     // Catch: java.lang.Exception -> La6
            java.lang.String r7 = r3.i     // Catch: java.lang.Exception -> La6
            r6.append(r7)     // Catch: java.lang.Exception -> La6
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> La6
            com.alipay.mobile.rome.syncsdk.util.c.a(r5, r6)     // Catch: java.lang.Exception -> La6
            goto L44
        L72:
            java.lang.String r2 = com.alipay.mobile.rome.syncservice.up.b.f7309a     // Catch: java.lang.Exception -> La6
            java.lang.String r3 = "copyResult: empty list"
            com.alipay.mobile.rome.syncsdk.util.c.c(r2, r3)     // Catch: java.lang.Exception -> La6
        L79:
            int r2 = r10.size()     // Catch: java.lang.Exception -> La6
            java.lang.String r3 = com.alipay.mobile.rome.syncservice.up.b.f7309a     // Catch: java.lang.Exception -> La6
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La6
            java.lang.String r5 = "onSyncUplinkAckReceived: recv size="
            r4.<init>(r5)     // Catch: java.lang.Exception -> La6
            r4.append(r2)     // Catch: java.lang.Exception -> La6
            java.lang.String r5 = ", sequence="
            r4.append(r5)     // Catch: java.lang.Exception -> La6
            r4.append(r9)     // Catch: java.lang.Exception -> La6
            java.lang.String r9 = r4.toString()     // Catch: java.lang.Exception -> La6
            com.alipay.mobile.rome.syncsdk.util.c.a(r3, r9)     // Catch: java.lang.Exception -> La6
            int r9 = r1.size()     // Catch: java.lang.Exception -> La6
            if (r2 != r9) goto La2
            r8.b(r0, r1)     // Catch: java.lang.Exception -> La6
            return
        La2:
            r8.a(r1, r10)     // Catch: java.lang.Exception -> La6
            return
        La6:
            r8 = move-exception
            java.lang.String r9 = com.alipay.mobile.rome.syncservice.up.b.f7309a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "onSyncUplinkAckReceived exception: "
            r10.<init>(r0)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            com.alipay.mobile.rome.syncsdk.util.c.d(r9, r8)
            return
        Lbb:
            java.lang.String r8 = com.alipay.mobile.rome.syncservice.up.b.f7309a
            java.lang.String r9 = "onSyncUplinkAckReceived: recvList is null or 0"
            com.alipay.mobile.rome.syncsdk.util.c.a(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncservice.up.b.a(com.alipay.mobile.rome.syncservice.up.b, int, java.util.List):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(b bVar, com.alipay.mobile.rome.syncservice.sync.d.b bVar2) {
        if (bVar2 != null) {
            bVar.d.a(bVar2);
            bVar.b.removeMessages(0, bVar.d(bVar2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, String str) {
        List<com.alipay.mobile.rome.syncservice.sync.d.b> a2;
        String str2 = com.alipay.mobile.rome.syncsdk.a.a.a().f7211a;
        if (TextUtils.isEmpty(str2)) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "SACAN_AND_DISPATCH user does not login");
            return;
        }
        com.alipay.mobile.rome.syncservice.sync.b.a.a aVar = bVar.d;
        if (aVar.d.get()) {
            com.alipay.mobile.rome.syncsdk.util.c.a(com.alipay.mobile.rome.syncservice.sync.b.a.a.f7292a, "queryMsgByStatus...db recreating~");
            a2 = null;
        } else {
            a2 = aVar.b.a(str2, str);
        }
        if (a2 == null) {
            com.alipay.mobile.rome.syncsdk.util.c.c(f7309a, "SACAN_AND_DISPATCH: no item");
            return;
        }
        Iterator<com.alipay.mobile.rome.syncservice.sync.d.b> it = a2.iterator();
        while (it.hasNext()) {
            bVar.b(it.next());
        }
    }
}
