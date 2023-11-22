package com.airbnb.lottie;

import com.airbnb.lottie.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final /* synthetic */ class LottieTask$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ LottieTask BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        LottieTask lottieTask = this.BuiltInFictitiousFunctionClassFactory;
        LottieResult<T> lottieResult = lottieTask.MyBillsEntityDataFactory;
        if (lottieResult != 0) {
            if (lottieResult.PlaceComponentResult != 0) {
                V v = lottieResult.PlaceComponentResult;
                synchronized (lottieTask) {
                    Iterator it = new ArrayList(lottieTask.getAuthRequestContext).iterator();
                    while (it.hasNext()) {
                        ((LottieListener) it.next()).KClassImpl$Data$declaredNonStaticMembers$2(v);
                    }
                }
                return;
            }
            Throwable th = lottieResult.KClassImpl$Data$declaredNonStaticMembers$2;
            synchronized (lottieTask) {
                ArrayList arrayList = new ArrayList(lottieTask.KClassImpl$Data$declaredNonStaticMembers$2);
                if (arrayList.isEmpty()) {
                    Logger.getAuthRequestContext("Lottie encountered an error but no failure listener was added:", th);
                    return;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((LottieListener) it2.next()).KClassImpl$Data$declaredNonStaticMembers$2(th);
                }
            }
        }
    }
}
