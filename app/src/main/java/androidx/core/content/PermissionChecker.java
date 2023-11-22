package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class PermissionChecker {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int getAuthRequestContext(Context context, String str) {
        int KClassImpl$Data$declaredNonStaticMembers$2;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        String BuiltInFictitiousFunctionClassFactory = AppOpsManagerCompat.BuiltInFictitiousFunctionClassFactory(str);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return 0;
        }
        if (packageName == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            packageName = packagesForUid[0];
        }
        if (Process.myUid() == myUid && ObjectsCompat.MyBillsEntityDataFactory(context.getPackageName(), packageName)) {
            KClassImpl$Data$declaredNonStaticMembers$2 = AppOpsManagerCompat.BuiltInFictitiousFunctionClassFactory(context, myUid, BuiltInFictitiousFunctionClassFactory, packageName);
        } else {
            KClassImpl$Data$declaredNonStaticMembers$2 = AppOpsManagerCompat.KClassImpl$Data$declaredNonStaticMembers$2(context, BuiltInFictitiousFunctionClassFactory, packageName);
        }
        return KClassImpl$Data$declaredNonStaticMembers$2 == 0 ? 0 : -2;
    }
}
