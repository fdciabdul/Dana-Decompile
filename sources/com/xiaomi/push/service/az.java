package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.iap.ac.android.mpm.base.model.hook.HookConstants;
import com.xiaomi.push.service.XMPushService;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes8.dex */
public class az {
    private static az MyBillsEntityDataFactory;
    ConcurrentHashMap<String, HashMap<String, b>> PlaceComponentResult = new ConcurrentHashMap<>();
    List<a> getAuthRequestContext = new ArrayList();

    /* loaded from: classes8.dex */
    public interface a {
        void BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes8.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    private az() {
    }

    public static az BuiltInFictitiousFunctionClassFactory() {
        az azVar;
        synchronized (az.class) {
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = new az();
            }
            azVar = MyBillsEntityDataFactory;
        }
        return azVar;
    }

    public final ArrayList<b> KClassImpl$Data$declaredNonStaticMembers$2() {
        ArrayList<b> arrayList;
        synchronized (this) {
            arrayList = new ArrayList<>();
            Iterator<HashMap<String, b>> it = this.PlaceComponentResult.values().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().values());
            }
        }
        return arrayList;
    }

    public final int MyBillsEntityDataFactory() {
        int size;
        synchronized (this) {
            size = this.PlaceComponentResult.size();
        }
        return size;
    }

    public final List<String> MyBillsEntityDataFactory(String str) {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            Iterator<HashMap<String, b>> it = this.PlaceComponentResult.values().iterator();
            while (it.hasNext()) {
                for (b bVar : it.next().values()) {
                    if (str.equals(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0)) {
                        arrayList.add(bVar.newProxyInstance);
                    }
                }
            }
        }
        return arrayList;
    }

    public final void PlaceComponentResult(int i) {
        synchronized (this) {
            Iterator<HashMap<String, b>> it = this.PlaceComponentResult.values().iterator();
            while (it.hasNext()) {
                Iterator<b> it2 = it.next().values().iterator();
                while (it2.hasNext()) {
                    it2.next().KClassImpl$Data$declaredNonStaticMembers$2(c.unbind, 2, i, (String) null, (String) null);
                }
            }
        }
    }

    public final void PlaceComponentResult(String str) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.PlaceComponentResult.get(str);
            if (hashMap != null) {
                Iterator<b> it = hashMap.values().iterator();
                while (it.hasNext()) {
                    it.next().MyBillsEntityDataFactory();
                }
                hashMap.clear();
                this.PlaceComponentResult.remove(str);
            }
            Iterator<a> it2 = this.getAuthRequestContext.iterator();
            while (it2.hasNext()) {
                it2.next().BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    public final Collection<b> getAuthRequestContext(String str) {
        synchronized (this) {
            if (this.PlaceComponentResult.containsKey(str)) {
                return ((HashMap) this.PlaceComponentResult.get(str).clone()).values();
            }
            return new ArrayList();
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        Messenger BuiltInFictitiousFunctionClassFactory;
        public String DatabaseTableConfigUtil;
        private XMPushService FragmentBottomSheetPaymentSettingBinding;
        public String GetContactSyncConfig;
        public Context KClassImpl$Data$declaredNonStaticMembers$2;
        public String NetworkUserEntityData$$ExternalSyntheticLambda0;
        public String NetworkUserEntityData$$ExternalSyntheticLambda1;
        public String NetworkUserEntityData$$ExternalSyntheticLambda2;
        public String NetworkUserEntityData$$ExternalSyntheticLambda8;
        public String PrepareContext;
        public j getErrorConfigVersion;
        public String isLayoutRequested;
        public String newProxyInstance;
        public boolean scheduleImpl;
        c lookAheadTest = c.unbind;
        int PlaceComponentResult = 0;
        final CopyOnWriteArrayList<a> moveToNextValue = new CopyOnWriteArrayList<>();
        c initRecordTimeStamp = null;
        private boolean NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
        private XMPushService.c NetworkUserEntityData$$ExternalSyntheticLambda7 = new XMPushService.c(this);
        IBinder.DeathRecipient MyBillsEntityDataFactory = null;
        final C0159b getAuthRequestContext = new C0159b();

        /* loaded from: classes8.dex */
        public interface a {
            void PlaceComponentResult(c cVar);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.az$b$b  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class C0159b extends XMPushService.j {
            int KClassImpl$Data$declaredNonStaticMembers$2;
            String MyBillsEntityDataFactory;
            int PlaceComponentResult;
            String getAuthRequestContext;

            public C0159b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                if (b.this.KClassImpl$Data$declaredNonStaticMembers$2()) {
                    b.this.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.getAuthRequestContext);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(" ignore notify client :");
                sb.append(b.this.newProxyInstance);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public final String getAuthRequestContext() {
                return "notify job";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes8.dex */
        public class c implements IBinder.DeathRecipient {
            final b BuiltInFictitiousFunctionClassFactory;
            final Messenger MyBillsEntityDataFactory;

            c(b bVar, Messenger messenger) {
                this.BuiltInFictitiousFunctionClassFactory = bVar;
                this.MyBillsEntityDataFactory = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                StringBuilder sb = new StringBuilder();
                sb.append("peer died, chid = ");
                sb.append(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
                b.this.FragmentBottomSheetPaymentSettingBinding.a(new bb(this), 0L);
                if (PrepareException.ERROR_OFFLINE_APP.equals(this.BuiltInFictitiousFunctionClassFactory.newProxyInstance) && "com.xiaomi.xmsf".equals(b.this.FragmentBottomSheetPaymentSettingBinding.getPackageName())) {
                    b.this.FragmentBottomSheetPaymentSettingBinding.a(new bc(this), 60000L);
                }
            }
        }

        public b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            boolean z;
            StringBuilder sb;
            String str;
            c cVar = this.initRecordTimeStamp;
            if (cVar == null || !(z = this.NetworkUserEntityData$$ExternalSyntheticLambda3)) {
                return true;
            }
            if (cVar == this.lookAheadTest) {
                sb = new StringBuilder();
                str = " status recovered, don't notify client:";
            } else if (this.BuiltInFictitiousFunctionClassFactory != null && z) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Peer alive notify status to client:");
                sb2.append(this.newProxyInstance);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb2.toString());
                return true;
            } else {
                sb = new StringBuilder();
                str = "peer died, ignore notify ";
            }
            sb.append(str);
            sb.append(this.newProxyInstance);
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
            return false;
        }

        private boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2, String str) {
            if (i == 1) {
                return (this.lookAheadTest == c.binded || !this.FragmentBottomSheetPaymentSettingBinding.m394d() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            } else if (i != 2) {
                if (i != 3) {
                    return false;
                }
                return !"wait".equals(str);
            } else {
                return this.FragmentBottomSheetPaymentSettingBinding.m394d();
            }
        }

        public static String MyBillsEntityDataFactory(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void MyBillsEntityDataFactory(int i, int i2, String str, String str2) {
            c cVar = this.lookAheadTest;
            this.initRecordTimeStamp = cVar;
            if (i == 2) {
                j.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, this, i2);
            } else if (i == 3) {
                j.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, this, str2, str);
            } else if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.PlaceComponentResult++;
                } else if (z) {
                    this.PlaceComponentResult = 0;
                    if (this.BuiltInFictitiousFunctionClassFactory != null) {
                        try {
                            this.BuiltInFictitiousFunctionClassFactory.send(Message.obtain(null, 16, this.FragmentBottomSheetPaymentSettingBinding.f395a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.getErrorConfigVersion.PlaceComponentResult(this.FragmentBottomSheetPaymentSettingBinding, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void BuiltInFictitiousFunctionClassFactory(Messenger messenger) {
            MyBillsEntityDataFactory();
            try {
                if (messenger != null) {
                    this.BuiltInFictitiousFunctionClassFactory = messenger;
                    this.NetworkUserEntityData$$ExternalSyntheticLambda3 = true;
                    this.MyBillsEntityDataFactory = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.MyBillsEntityDataFactory, 0);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("peer linked with old sdk chid = ");
                sb.append(this.newProxyInstance);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb.toString());
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("peer linkToDeath err: ");
                sb2.append(e.getMessage());
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory(sb2.toString());
                this.BuiltInFictitiousFunctionClassFactory = null;
                this.NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void MyBillsEntityDataFactory() {
            try {
                Messenger messenger = this.BuiltInFictitiousFunctionClassFactory;
                if (messenger != null && this.MyBillsEntityDataFactory != null) {
                    messenger.getBinder().unlinkToDeath(this.MyBillsEntityDataFactory, 0);
                }
            } catch (Exception unused) {
            }
            this.initRecordTimeStamp = null;
        }

        public b(XMPushService xMPushService) {
            this.FragmentBottomSheetPaymentSettingBinding = xMPushService;
            this.moveToNextValue.add(new ba(this));
        }

        public final void KClassImpl$Data$declaredNonStaticMembers$2(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            Iterator<a> it = this.moveToNextValue.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.PlaceComponentResult(cVar);
                }
            }
            c cVar2 = this.lookAheadTest;
            int i3 = 0;
            if (cVar2 != cVar) {
                Object[] objArr = new Object[7];
                objArr[0] = cVar2;
                objArr[1] = cVar;
                objArr[2] = i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : HookConstants.HookAction.HOOK_ACTION_OPEN;
                objArr[3] = bd.MyBillsEntityDataFactory(i2);
                objArr[4] = str;
                objArr[5] = str2;
                objArr[6] = this.newProxyInstance;
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", objArr));
                this.lookAheadTest = cVar;
            }
            if (this.getErrorConfigVersion == null) {
                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2("status changed while the client dispatcher is missing");
            } else if (cVar == c.binding) {
            } else {
                if (this.initRecordTimeStamp != null && (z = this.NetworkUserEntityData$$ExternalSyntheticLambda3)) {
                    i3 = (this.BuiltInFictitiousFunctionClassFactory == null || !z) ? 10100 : 1000;
                }
                this.FragmentBottomSheetPaymentSettingBinding.b(this.getAuthRequestContext);
                if (KClassImpl$Data$declaredNonStaticMembers$2(i, i2, str2)) {
                    MyBillsEntityDataFactory(i, i2, str, str2);
                    return;
                }
                XMPushService xMPushService = this.FragmentBottomSheetPaymentSettingBinding;
                C0159b c0159b = this.getAuthRequestContext;
                c0159b.KClassImpl$Data$declaredNonStaticMembers$2 = i;
                c0159b.PlaceComponentResult = i2;
                c0159b.getAuthRequestContext = str2;
                c0159b.MyBillsEntityDataFactory = str;
                xMPushService.a(c0159b, i3);
            }
        }
    }

    public final b MyBillsEntityDataFactory(String str, String str2) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.PlaceComponentResult.get(str);
            String str3 = null;
            if (hashMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                int indexOf = str2.indexOf(AUScreenAdaptTool.PREFIX_ID);
                if (indexOf > 0) {
                    str2 = str2.substring(0, indexOf);
                }
                str3 = str2;
            }
            return hashMap.get(str3);
        }
    }

    public final void getAuthRequestContext(b bVar) {
        synchronized (this) {
            HashMap<String, b> hashMap = this.PlaceComponentResult.get(bVar.newProxyInstance);
            if (hashMap == null) {
                hashMap = new HashMap<>();
                this.PlaceComponentResult.put(bVar.newProxyInstance, hashMap);
            }
            String str = bVar.DatabaseTableConfigUtil;
            if (TextUtils.isEmpty(str)) {
                str = null;
            } else {
                int indexOf = str.indexOf(AUScreenAdaptTool.PREFIX_ID);
                if (indexOf > 0) {
                    str = str.substring(0, indexOf);
                }
            }
            hashMap.put(str, bVar);
            StringBuilder sb = new StringBuilder();
            sb.append("add active client. ");
            sb.append(bVar.NetworkUserEntityData$$ExternalSyntheticLambda0);
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
            Iterator<a> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                it.next().BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        String substring;
        synchronized (this) {
            HashMap<String, b> hashMap = this.PlaceComponentResult.get(str);
            if (hashMap != null) {
                String str3 = null;
                if (TextUtils.isEmpty(str2)) {
                    substring = null;
                } else {
                    int indexOf = str2.indexOf(AUScreenAdaptTool.PREFIX_ID);
                    substring = indexOf > 0 ? str2.substring(0, indexOf) : str2;
                }
                b bVar = hashMap.get(substring);
                if (bVar != null) {
                    bVar.MyBillsEntityDataFactory();
                }
                if (!TextUtils.isEmpty(str2)) {
                    int indexOf2 = str2.indexOf(AUScreenAdaptTool.PREFIX_ID);
                    if (indexOf2 > 0) {
                        str2 = str2.substring(0, indexOf2);
                    }
                    str3 = str2;
                }
                hashMap.remove(str3);
                if (hashMap.isEmpty()) {
                    this.PlaceComponentResult.remove(str);
                }
            }
            Iterator<a> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                it.next().BuiltInFictitiousFunctionClassFactory();
            }
        }
    }
}
