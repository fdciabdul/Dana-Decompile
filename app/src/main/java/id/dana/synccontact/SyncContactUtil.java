package id.dana.synccontact;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.WorkManagerImpl;
import id.dana.synccontact.worker.BaseSyncContactWorker;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import javax.inject.Inject;

/* loaded from: classes5.dex */
public class SyncContactUtil {
    private static final String getAuthRequestContext = "SyncContactUtil";
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {108, 11, -123, -39, 16, -5, -2, -15, 7, 4, -34, 18, 8, -15, -6, 1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 36, 18, 8, -15, -6, 1};
    public static final int BuiltInFictitiousFunctionClassFactory = 33;

    private static void a(short s, short s2, short s3, Object[] objArr) {
        int i = 16 - (s2 * 3);
        int i2 = (s * 7) + 99;
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = (s3 * 12) + 4;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            i2 = i2 + i5 + 2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
            i3++;
            i5 = i5;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i2;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i3;
            i2 = i2 + bArr[i3] + 2;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
            i3 = i7 + 1;
            i5 = i5;
        }
    }

    @Inject
    public SyncContactUtil() {
    }

    public final boolean getAuthRequestContext(Context context) {
        return getAuthRequestContext(context, "sync_all_contact_worker");
    }

    public final boolean BuiltInFictitiousFunctionClassFactory(Context context) {
        return getAuthRequestContext(context, "sync_changed_contact_worker");
    }

    private boolean getAuthRequestContext(Context context, String str) {
        WorkManager PlaceComponentResult;
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            for (WorkInfo workInfo : PlaceComponentResult.PlaceComponentResult(str).get()) {
                if (WorkInfo.State.RUNNING.equals(workInfo.KClassImpl$Data$declaredNonStaticMembers$2) || WorkInfo.State.ENQUEUED.equals(workInfo.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    return true;
                }
            }
        } catch (IllegalStateException unused) {
        } catch (InterruptedException e) {
            String str2 = getAuthRequestContext;
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
            sb.append(getClass().getName());
            sb.append(":onError");
            DanaLog.BuiltInFictitiousFunctionClassFactory(str2, sb.toString(), e);
            try {
                byte b = KClassImpl$Data$declaredNonStaticMembers$2[15];
                Object[] objArr = new Object[1];
                a(b, (byte) (b - 1), KClassImpl$Data$declaredNonStaticMembers$2[15], objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] - 1);
                byte b3 = KClassImpl$Data$declaredNonStaticMembers$2[15];
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 - 1), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).interrupt();
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause != null) {
                    throw cause;
                }
                throw th;
            }
        } catch (ExecutionException e2) {
            String str3 = getAuthRequestContext;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
            sb2.append(getClass().getName());
            sb2.append(":onError");
            DanaLog.BuiltInFictitiousFunctionClassFactory(str3, sb2.toString(), e2);
        }
        return false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Context context, String str, Class<? extends BaseSyncContactWorker> cls) {
        WorkManager PlaceComponentResult;
        Constraints.Builder builder = new Constraints.Builder();
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = false;
        builder.MyBillsEntityDataFactory = true;
        builder.PlaceComponentResult = NetworkType.CONNECTED;
        OneTimeWorkRequest.Builder builder2 = new OneTimeWorkRequest.Builder(cls);
        builder2.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = new Constraints(builder);
        OneTimeWorkRequest.Builder MyBillsEntityDataFactory = builder2.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.PlaceComponentResult.add(str);
        OneTimeWorkRequest KClassImpl$Data$declaredNonStaticMembers$22 = MyBillsEntityDataFactory.MyBillsEntityDataFactory().KClassImpl$Data$declaredNonStaticMembers$2();
        try {
            PlaceComponentResult = WorkManagerImpl.PlaceComponentResult(context);
            PlaceComponentResult.getAuthRequestContext(str, ExistingWorkPolicy.REPLACE, Collections.singletonList(KClassImpl$Data$declaredNonStaticMembers$22)).KClassImpl$Data$declaredNonStaticMembers$2();
        } catch (IllegalStateException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(DanaLogConstants.Prefix.CONTACT_SYNC_PREFIX);
            sb.append(getClass().getName());
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" : ");
            sb2.append(e.getMessage());
            DanaLog.BuiltInFictitiousFunctionClassFactory(obj, DanaLogConstants.ExceptionType.CONTACT_SYNC_EXCEPTION, sb2.toString());
        }
    }
}
