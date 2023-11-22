package Catalano.Core.Concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes6.dex */
public class MulticoreExecutor {
    private static ThreadPoolExecutor BuiltInFictitiousFunctionClassFactory;
    private static final int MyBillsEntityDataFactory;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        MyBillsEntityDataFactory = availableProcessors;
        if (availableProcessors > 1) {
            BuiltInFictitiousFunctionClassFactory = (ThreadPoolExecutor) Executors.newFixedThreadPool(availableProcessors, new SimpleDeamonThreadFactory());
        }
    }
}
