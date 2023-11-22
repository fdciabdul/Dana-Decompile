package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.File;

/* loaded from: classes8.dex */
public class i {
    private static boolean BuiltInFictitiousFunctionClassFactory() {
        return KClassImpl$Data$declaredNonStaticMembers$2() <= 102400;
    }

    private static long KClassImpl$Data$declaredNonStaticMembers$2() {
        File externalStorageDirectory;
        if (!PlaceComponentResult() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    public static boolean MyBillsEntityDataFactory() {
        return (PlaceComponentResult() || BuiltInFictitiousFunctionClassFactory() || getAuthRequestContext()) ? false : true;
    }

    private static boolean PlaceComponentResult() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("check SDCard is busy: ");
            sb.append(e);
            InstrumentInjector.log_e("XMPush-", sb.toString());
            return true;
        }
    }

    private static boolean getAuthRequestContext() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.getAuthRequestContext(e);
            return true;
        }
    }
}
