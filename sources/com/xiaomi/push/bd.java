package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import com.xiaomi.push.bc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class bd implements bc.a {
    protected Context getAuthRequestContext;
    private PendingIntent PlaceComponentResult = null;
    private volatile long MyBillsEntityDataFactory = 0;

    public bd(Context context) {
        this.getAuthRequestContext = null;
        this.getAuthRequestContext = context;
    }

    @Override // com.xiaomi.push.bc.a
    public final void BuiltInFictitiousFunctionClassFactory() {
        if (this.PlaceComponentResult != null) {
            try {
                ((AlarmManager) this.getAuthRequestContext.getSystemService("alarm")).cancel(this.PlaceComponentResult);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.PlaceComponentResult = null;
                com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("[Alarm] unregister timer");
                this.MyBillsEntityDataFactory = 0L;
                throw th;
            }
            this.PlaceComponentResult = null;
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory("[Alarm] unregister timer");
            this.MyBillsEntityDataFactory = 0L;
        }
        this.MyBillsEntityDataFactory = 0L;
    }

    @Override // com.xiaomi.push.bc.a
    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        if (r10.MyBillsEntityDataFactory < r5) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106  */
    @Override // com.xiaomi.push.bc.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void MyBillsEntityDataFactory(boolean r11) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bd.MyBillsEntityDataFactory(boolean):void");
    }
}
