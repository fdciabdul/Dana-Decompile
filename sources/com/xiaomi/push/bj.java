package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.bm;

/* loaded from: classes8.dex */
class bj {
    private static final boolean PlaceComponentResult = Log.isLoggable("BCompressed", 3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] MyBillsEntityDataFactory(bi biVar, byte[] bArr) {
        try {
            byte[] PlaceComponentResult2 = bm.a.PlaceComponentResult(bArr);
            if (PlaceComponentResult) {
                StringBuilder sb = new StringBuilder();
                sb.append("decompress ");
                sb.append(bArr.length);
                sb.append(" to ");
                sb.append(PlaceComponentResult2.length);
                sb.append(" for ");
                sb.append(biVar);
                com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("BCompressed", sb.toString());
                if (biVar.BuiltInFictitiousFunctionClassFactory == 1) {
                    com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("BCompressed", "decompress not support upStream");
                }
            }
            return PlaceComponentResult2;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("decompress error ");
            sb2.append(e);
            com.xiaomi.channel.commonutils.logger.b.MyBillsEntityDataFactory("BCompressed", sb2.toString());
            return bArr;
        }
    }
}
