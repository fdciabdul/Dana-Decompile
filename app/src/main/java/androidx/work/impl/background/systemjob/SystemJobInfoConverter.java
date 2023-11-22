package androidx.work.impl.background.systemjob;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;
import androidx.work.NetworkType;

/* loaded from: classes3.dex */
class SystemJobInfoConverter {
    private static final String getAuthRequestContext = Logger.MyBillsEntityDataFactory("SystemJobInfoConverter");
    private final ComponentName BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemJobInfoConverter(Context context) {
        this.BuiltInFictitiousFunctionClassFactory = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006f, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.app.job.JobInfo KClassImpl$Data$declaredNonStaticMembers$2(androidx.work.impl.model.WorkSpec r13, int r14) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.background.systemjob.SystemJobInfoConverter.KClassImpl$Data$declaredNonStaticMembers$2(androidx.work.impl.model.WorkSpec, int):android.app.job.JobInfo");
    }

    /* renamed from: androidx.work.impl.background.systemjob.SystemJobInfoConverter$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[NetworkType.values().length];
            BuiltInFictitiousFunctionClassFactory = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                BuiltInFictitiousFunctionClassFactory[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
