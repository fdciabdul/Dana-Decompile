package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.push.cu;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes8.dex */
public class ServiceClient {
    private static ServiceClient BuiltInFictitiousFunctionClassFactory;
    private static long MyBillsEntityDataFactory;
    private static String PlaceComponentResult;
    private Messenger NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Context getAuthRequestContext;
    private boolean moveToNextValue;
    private Messenger KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private List<Message> scheduleImpl = new ArrayList();
    private boolean lookAheadTest = false;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(cu.PlaceComponentResult());
        sb.append("-");
        PlaceComponentResult = sb.toString();
        MyBillsEntityDataFactory = 0L;
    }

    private ServiceClient(Context context) {
        this.moveToNextValue = false;
        this.getAuthRequestContext = context.getApplicationContext();
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("use miui push service");
            this.moveToNextValue = true;
        }
    }

    public static ServiceClient BuiltInFictitiousFunctionClassFactory(Context context) {
        if (BuiltInFictitiousFunctionClassFactory == null) {
            BuiltInFictitiousFunctionClassFactory = new ServiceClient(context);
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        if (com.xiaomi.push.j.lookAheadTest) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.getAuthRequestContext.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean PlaceComponentResult(ServiceClient serviceClient) {
        serviceClient.lookAheadTest = false;
        return false;
    }

    public final boolean getAuthRequestContext(Intent intent) {
        try {
            if (com.xiaomi.channel.commonutils.android.f.BuiltInFictitiousFunctionClassFactory() || Build.VERSION.SDK_INT < 26) {
                this.getAuthRequestContext.startService(intent);
                return true;
            }
            KClassImpl$Data$declaredNonStaticMembers$2(intent);
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            return false;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(Intent intent) {
        synchronized (this) {
            if (this.lookAheadTest) {
                Message obtain = Message.obtain();
                obtain.what = 17;
                obtain.obj = intent;
                if (this.scheduleImpl.size() >= 50) {
                    this.scheduleImpl.remove(0);
                }
                this.scheduleImpl.add(obtain);
                return;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
                this.getAuthRequestContext.bindService(intent, new bm(this), 1);
                this.lookAheadTest = true;
                this.scheduleImpl.clear();
                Message obtain2 = Message.obtain();
                obtain2.what = 17;
                obtain2.obj = intent;
                this.scheduleImpl.add(obtain2);
            } else {
                Message obtain3 = Message.obtain();
                obtain3.what = 17;
                obtain3.obj = intent;
                try {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0.send(obtain3);
                } catch (RemoteException unused) {
                    this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                    this.lookAheadTest = false;
                }
            }
        }
    }
}
