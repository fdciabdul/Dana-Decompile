package androidx.room.util;

import java.io.File;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes3.dex */
public class CopyLock {
    private static final Map<String, Lock> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap();
    public final boolean BuiltInFictitiousFunctionClassFactory;
    public final File MyBillsEntityDataFactory;
    public final Lock PlaceComponentResult;
    public FileChannel getAuthRequestContext;

    public CopyLock(String str, File file, boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".lck");
        File file2 = new File(file, sb.toString());
        this.MyBillsEntityDataFactory = file2;
        this.PlaceComponentResult = KClassImpl$Data$declaredNonStaticMembers$2(file2.getAbsolutePath());
        this.BuiltInFictitiousFunctionClassFactory = z;
    }

    private static Lock KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Lock lock;
        Map<String, Lock> map = KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }
}
