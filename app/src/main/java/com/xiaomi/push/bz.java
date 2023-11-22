package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public abstract class bz extends bt {
    protected volatile long FragmentBottomSheetPaymentSettingBinding;
    String NetworkUserEntityData$$ExternalSyntheticLambda3;
    protected volatile long NetworkUserEntityData$$ExternalSyntheticLambda4;
    protected volatile long NetworkUserEntityData$$ExternalSyntheticLambda5;
    private int NetworkUserEntityData$$ExternalSyntheticLambda6;
    protected Socket NetworkUserEntityData$$ExternalSyntheticLambda8;
    protected XMPushService PrepareContext;
    private long getCallingPid;
    private String getSupportButtonTintMode;
    protected Exception isLayoutRequested;

    public bz(XMPushService xMPushService, bu buVar) {
        super(xMPushService, buVar);
        this.isLayoutRequested = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0L;
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0L;
        this.FragmentBottomSheetPaymentSettingBinding = 0L;
        this.getCallingPid = 0L;
        this.PrepareContext = xMPushService;
    }

    protected void BuiltInFictitiousFunctionClassFactory() {
        synchronized (this) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BuiltInFictitiousFunctionClassFactory(int i, Exception exc) {
        synchronized (this) {
            if (getAuthRequestContext() == 2) {
                return;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(2, i, exc);
            this.getErrorConfigVersion = "";
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.close();
            } catch (Throwable unused) {
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda5 = 0L;
            this.NetworkUserEntityData$$ExternalSyntheticLambda4 = 0L;
        }
    }

    public final void DatabaseTableConfigUtil() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = SystemClock.elapsedRealtime();
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Exception exc) {
        this.PrepareContext.a(new cb(this, i, exc));
    }

    protected abstract void KClassImpl$Data$declaredNonStaticMembers$2(boolean z);

    public final String NetworkUserEntityData$$ExternalSyntheticLambda1() {
        return this.getErrorConfigVersion;
    }

    public final void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda4 = SystemClock.elapsedRealtime();
    }

    @Override // com.xiaomi.push.bt
    public void getAuthRequestContext(bi[] biVarArr) {
        throw new cd("Don't support send Blob");
    }

    @Override // com.xiaomi.push.bt
    public final String lookAheadTest() {
        return this.getSupportButtonTintMode;
    }

    @Override // com.xiaomi.push.bt
    public final void getAuthRequestContext(int i, Exception exc) {
        BuiltInFictitiousFunctionClassFactory(i, exc);
        if ((exc != null || i == 18) && this.FragmentBottomSheetPaymentSettingBinding != 0) {
            if (SystemClock.elapsedRealtime() - this.FragmentBottomSheetPaymentSettingBinding < 300000) {
                if (!y.MyBillsEntityDataFactory(this.PrepareContext)) {
                    return;
                }
                int i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6 + 1;
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = i2;
                if (i2 < 2) {
                    return;
                }
                String str = this.getSupportButtonTintMode;
                StringBuilder sb = new StringBuilder();
                sb.append("max short conn time reached, sink down current host:");
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb.toString());
                ag MyBillsEntityDataFactory = ak.MyBillsEntityDataFactory().MyBillsEntityDataFactory(bu.PlaceComponentResult(), false);
                if (MyBillsEntityDataFactory != null) {
                    MyBillsEntityDataFactory.MyBillsEntityDataFactory(str, new af(-1, 0L, 0L, exc));
                    ak.MyBillsEntityDataFactory().scheduleImpl();
                }
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = 0;
        }
    }

    @Override // com.xiaomi.push.bt
    public final void MyBillsEntityDataFactory(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        KClassImpl$Data$declaredNonStaticMembers$2(z);
        com.xiaomi.push.service.n KClassImpl$Data$declaredNonStaticMembers$2 = com.xiaomi.push.service.n.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext);
        if (KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext()) {
            KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue = KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
        }
        if (z) {
            return;
        }
        this.PrepareContext.a(new ca(this, elapsedRealtime, currentTimeMillis), 10000L);
    }

    public final void initRecordTimeStamp() {
        boolean z;
        synchronized (this) {
            try {
                if (!moveToNextValue() && !NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                    KClassImpl$Data$declaredNonStaticMembers$2(0, 0, null);
                    bu buVar = this.PlaceComponentResult;
                    String authRequestContext = buVar.getAuthRequestContext();
                    int i = buVar.BuiltInFictitiousFunctionClassFactory;
                    this.isLayoutRequested = null;
                    ArrayList<String> arrayList = new ArrayList<>();
                    StringBuilder sb = new StringBuilder();
                    sb.append("get bucket for host : ");
                    sb.append(authRequestContext);
                    int intValue = com.xiaomi.channel.commonutils.logger.b.PlaceComponentResult(sb.toString()).intValue();
                    ag MyBillsEntityDataFactory = ak.MyBillsEntityDataFactory().MyBillsEntityDataFactory(authRequestContext, false);
                    if (!MyBillsEntityDataFactory.getAuthRequestContext()) {
                        cv.BuiltInFictitiousFunctionClassFactory(new cc(this, authRequestContext));
                    }
                    com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(Integer.valueOf(intValue));
                    if (MyBillsEntityDataFactory != null) {
                        arrayList = MyBillsEntityDataFactory.PlaceComponentResult(true);
                    }
                    ak.MyBillsEntityDataFactory();
                    ag BuiltInFictitiousFunctionClassFactory = ak.BuiltInFictitiousFunctionClassFactory(authRequestContext);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        Iterator<String> it = BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(true).iterator();
                        while (it.hasNext()) {
                            String next = it.next();
                            if (arrayList.indexOf(next) == -1) {
                                arrayList.add(next);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        arrayList.add(authRequestContext);
                    }
                    this.FragmentBottomSheetPaymentSettingBinding = 0L;
                    SystemClock.elapsedRealtime();
                    String KClassImpl$Data$declaredNonStaticMembers$2 = y.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext);
                    StringBuilder sb2 = new StringBuilder();
                    Iterator<String> it2 = arrayList.iterator();
                    String str = "";
                    while (it2.hasNext()) {
                        String next2 = it2.next();
                        long currentTimeMillis = System.currentTimeMillis();
                        this.MyBillsEntityDataFactory++;
                        try {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("begin to connect to ");
                            sb3.append(next2);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb3.toString());
                            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = new Socket();
                            this.NetworkUserEntityData$$ExternalSyntheticLambda8.connect(ai.MyBillsEntityDataFactory(next2, i), 8000);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("tcp connected");
                            this.NetworkUserEntityData$$ExternalSyntheticLambda8.setTcpNoDelay(true);
                            this.getSupportButtonTintMode = next2;
                            BuiltInFictitiousFunctionClassFactory();
                            this.KClassImpl$Data$declaredNonStaticMembers$2 = System.currentTimeMillis() - currentTimeMillis;
                            this.GetContactSyncConfig = KClassImpl$Data$declaredNonStaticMembers$2;
                            if (MyBillsEntityDataFactory != null) {
                                MyBillsEntityDataFactory.MyBillsEntityDataFactory(next2, new af(0, this.KClassImpl$Data$declaredNonStaticMembers$2, 0L, null));
                            }
                            this.FragmentBottomSheetPaymentSettingBinding = SystemClock.elapsedRealtime();
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("connected to ");
                            sb4.append(next2);
                            sb4.append(" in ");
                            sb4.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
                            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(sb4.toString());
                            z = true;
                            break;
                        } catch (Exception e) {
                            this.isLayoutRequested = e;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("SMACK: Could not connect to:");
                            sb5.append(next2);
                            com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb5.toString());
                            sb2.append("SMACK: Could not connect to ");
                            sb2.append(next2);
                            sb2.append(" port:");
                            sb2.append(i);
                            sb2.append(" err:");
                            sb2.append(this.isLayoutRequested.getClass().getSimpleName());
                            sb2.append("\n");
                            if (TextUtils.isEmpty(str)) {
                                str = next2;
                            } else {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(str);
                                sb6.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                sb6.append(next2);
                                str = sb6.toString();
                            }
                            if (MyBillsEntityDataFactory != null) {
                                MyBillsEntityDataFactory.MyBillsEntityDataFactory(next2, new af(-1, System.currentTimeMillis() - currentTimeMillis, 0L, this.isLayoutRequested));
                            }
                            if (!TextUtils.equals(KClassImpl$Data$declaredNonStaticMembers$2, y.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext))) {
                                break;
                            }
                        } catch (Throwable th) {
                            try {
                                this.isLayoutRequested = new Exception("abnormal exception", th);
                                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(th);
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append("SMACK: Could not connect to:");
                                sb7.append(next2);
                                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb7.toString());
                                sb2.append("SMACK: Could not connect to ");
                                sb2.append(next2);
                                sb2.append(" port:");
                                sb2.append(i);
                                sb2.append(" err:");
                                sb2.append(this.isLayoutRequested.getClass().getSimpleName());
                                sb2.append("\n");
                                if (TextUtils.isEmpty(str)) {
                                    str = next2;
                                } else {
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append(str);
                                    sb8.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    sb8.append(next2);
                                    str = sb8.toString();
                                }
                                if (MyBillsEntityDataFactory != null) {
                                    MyBillsEntityDataFactory.MyBillsEntityDataFactory(next2, new af(-1, System.currentTimeMillis() - currentTimeMillis, 0L, this.isLayoutRequested));
                                }
                                if (!TextUtils.equals(KClassImpl$Data$declaredNonStaticMembers$2, y.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext))) {
                                    break;
                                }
                            } catch (Throwable th2) {
                                StringBuilder sb9 = new StringBuilder();
                                sb9.append("SMACK: Could not connect to:");
                                sb9.append(next2);
                                com.xiaomi.channel.commonutils.logger.b.KClassImpl$Data$declaredNonStaticMembers$2(sb9.toString());
                                sb2.append("SMACK: Could not connect to ");
                                sb2.append(next2);
                                sb2.append(" port:");
                                sb2.append(i);
                                sb2.append(" err:");
                                sb2.append(this.isLayoutRequested.getClass().getSimpleName());
                                sb2.append("\n");
                                TextUtils.isEmpty(str);
                                if (MyBillsEntityDataFactory != null) {
                                    MyBillsEntityDataFactory.MyBillsEntityDataFactory(next2, new af(-1, System.currentTimeMillis() - currentTimeMillis, 0L, this.isLayoutRequested));
                                }
                                if (TextUtils.equals(KClassImpl$Data$declaredNonStaticMembers$2, y.KClassImpl$Data$declaredNonStaticMembers$2(this.PrepareContext))) {
                                    throw th2;
                                }
                            }
                        }
                    }
                    z = false;
                    ak.MyBillsEntityDataFactory().scheduleImpl();
                    SystemClock.elapsedRealtime();
                    if (z) {
                        return;
                    }
                    if (this.getCallingPid == 0 || SystemClock.elapsedRealtime() - this.getCallingPid > 480000) {
                        this.getCallingPid = SystemClock.elapsedRealtime();
                        y.BuiltInFictitiousFunctionClassFactory(this.PrepareContext.getApplicationContext());
                    }
                    throw new cd(sb2.toString());
                }
                com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext("WARNING: current xmpp has connected");
            } catch (IOException e2) {
                throw new cd(e2);
            }
        }
    }
}
