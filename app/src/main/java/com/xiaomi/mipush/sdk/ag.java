package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.bluetooth.altbeacon.beacon.service.RangedBeacon;
import com.google.common.base.Ascii;
import com.xiaomi.push.cz;
import com.xiaomi.push.da;
import com.xiaomi.push.db;
import com.xiaomi.push.df;
import com.xiaomi.push.di;
import com.xiaomi.push.dq;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.ea;
import com.xiaomi.push.ee;
import com.xiaomi.push.ef;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.aw;
import com.xiaomi.push.service.bd;
import com.xiaomi.push.service.bf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class ag {
    private static ag lookAheadTest;
    private static boolean moveToNextValue;
    Context KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    public long PlaceComponentResult;
    private Handler getErrorConfigVersion;
    private Messenger scheduleImpl;
    public static final byte[] getAuthRequestContext = {8, 17, -121, -18, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, 22, 1, 4, -9, 13, 10, -28, Ascii.CAN, 14, -9, 0, 7, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 42, Ascii.CAN, 14, -9, 0, 7, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int NetworkUserEntityData$$ExternalSyntheticLambda0 = 85;
    static final ArrayList<a> BuiltInFictitiousFunctionClassFactory = new ArrayList<>();
    private List<Message> initRecordTimeStamp = new ArrayList();
    private boolean PrepareContext = false;
    private String GetContactSyncConfig = null;
    public Intent MyBillsEntityDataFactory = null;
    private Integer NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    private String DatabaseTableConfigUtil = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a<T extends ef<T, ?>> {
        cz KClassImpl$Data$declaredNonStaticMembers$2;
        T MyBillsEntityDataFactory;
        boolean getAuthRequestContext;

        a() {
        }
    }

    private int BuiltInFictitiousFunctionClassFactory() {
        int i;
        synchronized (this) {
            i = this.KClassImpl$Data$declaredNonStaticMembers$2.getSharedPreferences("mipush_extra", 0).getInt("service_boot_mode", -1);
        }
        return i;
    }

    public static ag BuiltInFictitiousFunctionClassFactory(Context context) {
        ag agVar;
        synchronized (ag.class) {
            if (lookAheadTest == null) {
                lookAheadTest = new ag(context);
            }
            agVar = lookAheadTest;
        }
        return agVar;
    }

    private static <T extends ef<T, ?>> void KClassImpl$Data$declaredNonStaticMembers$2(T t, cz czVar, boolean z) {
        a aVar = new a();
        aVar.MyBillsEntityDataFactory = t;
        aVar.KClassImpl$Data$declaredNonStaticMembers$2 = czVar;
        aVar.getAuthRequestContext = z;
        ArrayList<a> arrayList = BuiltInFictitiousFunctionClassFactory;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean MyBillsEntityDataFactory(ag agVar) {
        agVar.PrepareContext = false;
        return false;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0() {
        String packageName = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName();
        if (!packageName.contains("miui") && !packageName.contains("xiaomi")) {
            Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
            try {
                Object[] objArr = new Object[1];
                a((byte) (getAuthRequestContext[20] + 1), getAuthRequestContext[25], getAuthRequestContext[14], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                Object[] objArr2 = new Object[1];
                a(getAuthRequestContext[25], (byte) (-getAuthRequestContext[5]), (byte) (-getAuthRequestContext[38]), objArr2);
                if ((((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).flags & 1) == 0) {
                    return false;
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0023 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(short r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = 52 - r6
            int r7 = r7 + 97
            byte[] r0 = com.xiaomi.mipush.sdk.ag.getAuthRequestContext
            int r8 = r8 + 13
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L15
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L30
        L15:
            r3 = 0
        L16:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L23
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L23:
            int r6 = r6 + 1
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L30:
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.ag.a(short, short, int, java.lang.Object[]):void");
    }

    private boolean getErrorConfigVersion() {
        try {
            PackageInfo packageInfo = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void initRecordTimeStamp() {
        try {
            PackageManager packageManager = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageManager();
            ComponentName componentName = new ComponentName(this.KClassImpl$Data$declaredNonStaticMembers$2, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    private boolean lookAheadTest() {
        if (getAuthRequestContext()) {
            try {
                return this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private String moveToNextValue() {
        String str = this.GetContactSyncConfig;
        if (str != null) {
            return str;
        }
        try {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.GetContactSyncConfig = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.GetContactSyncConfig = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    private void scheduleImpl() {
        try {
            PackageManager packageManager = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageManager();
            ComponentName componentName = new ComponentName(this.KClassImpl$Data$declaredNonStaticMembers$2, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void BuiltInFictitiousFunctionClassFactory(Intent intent) {
        try {
            if (KClassImpl$Data$declaredNonStaticMembers$2("startServiceSafely")) {
                return;
            }
            if (com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() || Build.VERSION.SDK_INT < 26) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.startService(intent);
            } else {
                KClassImpl$Data$declaredNonStaticMembers$2(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
        }
    }

    public final <T extends ef<T, ?>> void BuiltInFictitiousFunctionClassFactory(T t, cz czVar, boolean z, boolean z2, di diVar, boolean z3, String str, String str2, boolean z4) {
        KClassImpl$Data$declaredNonStaticMembers$2(t, czVar, z, z2, diVar, z3, str, str2, z4, true);
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str, am amVar, c cVar) {
        x.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(amVar, "syncing");
        PlaceComponentResult(str, amVar, false, g.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, cVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Intent KClassImpl$Data$declaredNonStaticMembers$2() {
        Intent intent = new Intent();
        String packageName = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName();
        initRecordTimeStamp();
        intent.setComponent(new ComponentName(this.KClassImpl$Data$declaredNonStaticMembers$2, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (!com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() || this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Error,Missing XMSF application in MIUI system. The calling method [");
        sb.append(str);
        sb.append("] was rejected by mipush service.");
        com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb.toString());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Intent MyBillsEntityDataFactory() {
        Intent intent = new Intent();
        String packageName = this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", moveToNextValue());
        intent.putExtra("mipush_app_package", packageName);
        scheduleImpl();
        return intent;
    }

    public final boolean PlaceComponentResult() {
        if (getAuthRequestContext() && NetworkUserEntityData$$ExternalSyntheticLambda0()) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1 == null) {
                Integer valueOf = Integer.valueOf(bf.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory());
                this.NetworkUserEntityData$$ExternalSyntheticLambda1 = valueOf;
                if (valueOf.intValue() == 0) {
                    aj ajVar = new aj(this, new Handler(Looper.getMainLooper()));
                    ContentResolver contentResolver = this.KClassImpl$Data$declaredNonStaticMembers$2.getContentResolver();
                    bf.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    contentResolver.registerContentObserver(bf.PlaceComponentResult(), false, ajVar);
                }
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda1.intValue() == 0) {
                return false;
            }
        }
        return true;
    }

    public final void getAuthRequestContext(Intent intent) {
        if (KClassImpl$Data$declaredNonStaticMembers$2("callService")) {
            return;
        }
        int authRequestContext = at.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(db.ServiceBootMode.a(), da.START.a());
        int BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory();
        boolean z = authRequestContext == da.BIND.a() && moveToNextValue;
        int a2 = (z ? da.BIND : da.START).a();
        if (a2 != BuiltInFictitiousFunctionClassFactory2) {
            getAuthRequestContext(a2);
        }
        if (z) {
            KClassImpl$Data$declaredNonStaticMembers$2(intent);
        } else {
            BuiltInFictitiousFunctionClassFactory(intent);
        }
    }

    public final void getAuthRequestContext(boolean z, String str) {
        am amVar;
        if (z) {
            x.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(am.DISABLE_PUSH, "syncing");
            x.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(am.ENABLE_PUSH, "");
            amVar = am.DISABLE_PUSH;
        } else {
            x.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(am.ENABLE_PUSH, "syncing");
            x.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).getAuthRequestContext(am.DISABLE_PUSH, "");
            amVar = am.ENABLE_PUSH;
        }
        PlaceComponentResult(str, amVar, true, null);
    }

    private ag(Context context) {
        Intent KClassImpl$Data$declaredNonStaticMembers$2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = false;
        this.getErrorConfigVersion = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context.getApplicationContext();
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = getErrorConfigVersion();
        moveToNextValue = lookAheadTest();
        this.getErrorConfigVersion = new ah(this, Looper.getMainLooper());
        if (com.xiaomi.channel.commonutils.android.f.PlaceComponentResult(context)) {
            com.xiaomi.push.service.i.KClassImpl$Data$declaredNonStaticMembers$2(new ai(this));
        }
        if ("com.xiaomi.xmsf".equals(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) {
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("pushChannel xmsf create own channel");
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        } else if (getAuthRequestContext()) {
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("pushChannel app start miui channel");
            KClassImpl$Data$declaredNonStaticMembers$2 = MyBillsEntityDataFactory();
        } else {
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("pushChannel app start  own channel");
            KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        }
        BuiltInFictitiousFunctionClassFactory(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PlaceComponentResult(String str, am amVar, boolean z, HashMap<String, String> hashMap) {
        String str2;
        String str3 = str;
        if (com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory() && com.xiaomi.push.y.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2)) {
            dt dtVar = new dt();
            dtVar.a(true);
            Intent KClassImpl$Data$declaredNonStaticMembers$2 = (!getAuthRequestContext() || "com.xiaomi.xmsf".equals(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) ? KClassImpl$Data$declaredNonStaticMembers$2() : MyBillsEntityDataFactory();
            if (TextUtils.isEmpty(str)) {
                str3 = aw.MyBillsEntityDataFactory();
                dtVar.a(str3);
                r4 = z ? new dt(str3, true) : null;
                synchronized (x.class) {
                    x.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult(str3);
                }
            } else {
                dtVar.a(str3);
                if (z) {
                    r4 = new dt(str3, true);
                }
            }
            dt dtVar2 = r4;
            switch (al.MyBillsEntityDataFactory[amVar.ordinal()]) {
                case 1:
                    dtVar.c(df.DisablePushMessage.f104a);
                    dtVar2.c(df.DisablePushMessage.f104a);
                    if (hashMap != null) {
                        dtVar.a(hashMap);
                        dtVar2.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    KClassImpl$Data$declaredNonStaticMembers$2.setAction(str2);
                    break;
                case 2:
                    dtVar.c(df.EnablePushMessage.f104a);
                    dtVar2.c(df.EnablePushMessage.f104a);
                    if (hashMap != null) {
                        dtVar.a(hashMap);
                        dtVar2.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    KClassImpl$Data$declaredNonStaticMembers$2.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    dtVar.c(df.ThirdPartyRegUpdate.f104a);
                    if (hashMap != null) {
                        dtVar.a(hashMap);
                        break;
                    }
                    break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("type:");
            sb.append(amVar);
            sb.append(", ");
            sb.append(str3);
            com.xiaomi.channel.commonutils.logger.b.moveToNextValue(sb.toString());
            dtVar.b(com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
            dtVar.d(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
            KClassImpl$Data$declaredNonStaticMembers$2(dtVar, cz.Notification, false, true, null, true, this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true, true);
            if (z) {
                dtVar2.b(com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                dtVar2.d(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
                byte[] PlaceComponentResult = ee.PlaceComponentResult(aa.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, dtVar2, cz.Notification, false, this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory));
                if (PlaceComponentResult != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_payload", PlaceComponentResult);
                    KClassImpl$Data$declaredNonStaticMembers$2.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
                    KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_app_token", com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory);
                    getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = amVar.ordinal();
            obtain.obj = str3;
            obtain.arg1 = ordinal;
            this.getErrorConfigVersion.sendMessageDelayed(obtain, RangedBeacon.DEFAULT_MAX_TRACKING_AGE);
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
        synchronized (this) {
            if (KClassImpl$Data$declaredNonStaticMembers$2("bindServiceSafely")) {
                return;
            }
            if (this.PrepareContext) {
                Message obtain = Message.obtain();
                obtain.what = 17;
                obtain.obj = intent;
                if (this.initRecordTimeStamp.size() >= 50) {
                    this.initRecordTimeStamp.remove(0);
                }
                this.initRecordTimeStamp.add(obtain);
                return;
            }
            if (this.scheduleImpl == null) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.bindService(intent, new ak(this), 1);
                this.PrepareContext = true;
                this.initRecordTimeStamp.clear();
                Message obtain2 = Message.obtain();
                obtain2.what = 17;
                obtain2.obj = intent;
                this.initRecordTimeStamp.add(obtain2);
            } else {
                Message obtain3 = Message.obtain();
                obtain3.what = 17;
                obtain3.obj = intent;
                try {
                    this.scheduleImpl.send(obtain3);
                } catch (RemoteException unused) {
                    this.scheduleImpl = null;
                    this.PrepareContext = false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        Intent KClassImpl$Data$declaredNonStaticMembers$2 = (!getAuthRequestContext() || "com.xiaomi.xmsf".equals(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) ? KClassImpl$Data$declaredNonStaticMembers$2() : MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra(bd.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra(bd.KClassImpl$Data$declaredNonStaticMembers$2, i);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra(bd.BuiltInFictitiousFunctionClassFactory, i2);
        getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final void MyBillsEntityDataFactory(du duVar, boolean z, boolean z2) {
        this.MyBillsEntityDataFactory = null;
        com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).MyBillsEntityDataFactory = duVar.a();
        Intent KClassImpl$Data$declaredNonStaticMembers$2 = (!getAuthRequestContext() || "com.xiaomi.xmsf".equals(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) ? KClassImpl$Data$declaredNonStaticMembers$2() : MyBillsEntityDataFactory();
        byte[] PlaceComponentResult = ee.PlaceComponentResult(aa.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, duVar, cz.Registration));
        if (PlaceComponentResult == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("register fail, because msgBytes is null.");
            return;
        }
        KClassImpl$Data$declaredNonStaticMembers$2.setAction("com.xiaomi.mipush.REGISTER_APP");
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_payload", PlaceComponentResult);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_session", this.DatabaseTableConfigUtil);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_env_chanage", z);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_env_type", com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_region_change", z2);
        if (!com.xiaomi.push.y.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2) || !PlaceComponentResult()) {
            this.MyBillsEntityDataFactory = KClassImpl$Data$declaredNonStaticMembers$2;
            return;
        }
        this.PlaceComponentResult = SystemClock.elapsedRealtime();
        getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final void PlaceComponentResult(ea eaVar) {
        byte[] PlaceComponentResult = ee.PlaceComponentResult(aa.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2, eaVar, cz.UnRegistration));
        if (PlaceComponentResult == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("unregister fail, because msgBytes is null.");
            return;
        }
        Intent KClassImpl$Data$declaredNonStaticMembers$2 = (!getAuthRequestContext() || "com.xiaomi.xmsf".equals(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) ? KClassImpl$Data$declaredNonStaticMembers$2() : MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_app_id", com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_payload", PlaceComponentResult);
        getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final <T extends ef<T, ?>> void getAuthRequestContext(T t, cz czVar) {
        KClassImpl$Data$declaredNonStaticMembers$2(t, czVar, !czVar.equals(cz.Registration), true, null, true, this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true, true);
    }

    public final <T extends ef<T, ?>> void KClassImpl$Data$declaredNonStaticMembers$2(T t, cz czVar, boolean z, boolean z2, di diVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        if (z5 && !com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (z2) {
                KClassImpl$Data$declaredNonStaticMembers$2(t, czVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("drop the message before initialization.");
                return;
            }
        }
        dq authRequestContext = z4 ? aa.getAuthRequestContext(this.KClassImpl$Data$declaredNonStaticMembers$2, t, czVar, z, str, str2) : aa.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2, t, czVar, z, str, str2);
        if (diVar != null) {
            authRequestContext.a(diVar);
        }
        byte[] PlaceComponentResult = ee.PlaceComponentResult(authRequestContext);
        if (PlaceComponentResult == null) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("send message fail, because msgBytes is null.");
            return;
        }
        Intent KClassImpl$Data$declaredNonStaticMembers$2 = (!getAuthRequestContext() || "com.xiaomi.xmsf".equals(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName())) ? KClassImpl$Data$declaredNonStaticMembers$2() : MyBillsEntityDataFactory();
        KClassImpl$Data$declaredNonStaticMembers$2.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("mipush_payload", PlaceComponentResult);
        KClassImpl$Data$declaredNonStaticMembers$2.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        getAuthRequestContext(KClassImpl$Data$declaredNonStaticMembers$2);
    }

    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2 && 1 == com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private boolean getAuthRequestContext(int i) {
        if (com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory()) {
            synchronized (this) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.getSharedPreferences("mipush_extra", 0).edit().putInt("service_boot_mode", i).commit();
            }
            dt dtVar = new dt();
            dtVar.a(aw.MyBillsEntityDataFactory());
            dtVar.b(com.xiaomi.mipush.sdk.a.PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
            dtVar.d(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName());
            dtVar.c(df.ClientABTest.f104a);
            dtVar.f241a = new HashMap();
            Map<String, String> map = dtVar.f241a;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            map.put("boot_mode", sb.toString());
            ag BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
            BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2(dtVar, cz.Notification, false, true, null, true, BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), com.xiaomi.mipush.sdk.a.PlaceComponentResult(BuiltInFictitiousFunctionClassFactory2.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, true, true);
            return true;
        }
        return false;
    }
}
