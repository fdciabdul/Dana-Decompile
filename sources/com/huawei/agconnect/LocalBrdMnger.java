package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes7.dex */
public class LocalBrdMnger {
    private static final Object MyBillsEntityDataFactory = new Object();
    private final ArrayList<BroadcastRecord> BuiltInFictitiousFunctionClassFactory;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Context getAuthRequestContext;

    /* renamed from: com.huawei.agconnect.LocalBrdMnger$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 extends Handler {
        final /* synthetic */ LocalBrdMnger KClassImpl$Data$declaredNonStaticMembers$2;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                LocalBrdMnger.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
            } else {
                super.handleMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class BroadcastRecord {
        final ArrayList<ReceiverRecord> KClassImpl$Data$declaredNonStaticMembers$2;
        final Intent PlaceComponentResult;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class ReceiverRecord {
        final BroadcastReceiver PlaceComponentResult;
        final IntentFilter getAuthRequestContext;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Receiver{");
            sb.append(this.PlaceComponentResult);
            sb.append(" filter=");
            sb.append(this.getAuthRequestContext);
            sb.append("}");
            return sb.toString();
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(LocalBrdMnger localBrdMnger) {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (localBrdMnger.KClassImpl$Data$declaredNonStaticMembers$2) {
                size = localBrdMnger.BuiltInFictitiousFunctionClassFactory.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new BroadcastRecord[size];
                localBrdMnger.BuiltInFictitiousFunctionClassFactory.toArray(broadcastRecordArr);
                localBrdMnger.BuiltInFictitiousFunctionClassFactory.clear();
            }
            for (int i = 0; i < size; i++) {
                BroadcastRecord broadcastRecord = broadcastRecordArr[i];
                for (int i2 = 0; i2 < broadcastRecord.KClassImpl$Data$declaredNonStaticMembers$2.size(); i2++) {
                    broadcastRecord.KClassImpl$Data$declaredNonStaticMembers$2.get(i2).PlaceComponentResult.onReceive(localBrdMnger.getAuthRequestContext, broadcastRecord.PlaceComponentResult);
                }
            }
        }
    }
}
