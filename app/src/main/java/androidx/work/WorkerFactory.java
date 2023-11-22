package androidx.work;

import android.content.Context;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;

/* loaded from: classes.dex */
public abstract class WorkerFactory {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {11, -83, -14, 91, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int PlaceComponentResult = 65;
    private static final String MyBillsEntityDataFactory = Logger.MyBillsEntityDataFactory("WorkerFactory");

    public abstract ListenableWorker PlaceComponentResult(Context context, String str, WorkerParameters workerParameters);

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e A[Catch: all -> 0x00a2, TryCatch #0 {all -> 0x00a2, blocks: (B:16:0x006a, B:18:0x006e, B:19:0x0090), top: B:36:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0090 A[Catch: all -> 0x00a2, TRY_LEAVE, TryCatch #0 {all -> 0x00a2, blocks: (B:16:0x006a, B:18:0x006e, B:19:0x0090), top: B:36:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00cd  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0092 -> B:21:0x0099). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final androidx.work.ListenableWorker getAuthRequestContext(android.content.Context r19, java.lang.String r20, androidx.work.WorkerParameters r21) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.WorkerFactory.getAuthRequestContext(android.content.Context, java.lang.String, androidx.work.WorkerParameters):androidx.work.ListenableWorker");
    }

    public static WorkerFactory BuiltInFictitiousFunctionClassFactory() {
        return new WorkerFactory() { // from class: androidx.work.WorkerFactory.1
            @Override // androidx.work.WorkerFactory
            public final ListenableWorker PlaceComponentResult(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }
}
