package com.bumptech.glide.manager;

import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ActivityFragmentLifecycle implements Lifecycle {
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final Set<LifecycleListener> MyBillsEntityDataFactory = Collections.newSetFromMap(new WeakHashMap());
    private boolean PlaceComponentResult;

    @Override // com.bumptech.glide.manager.Lifecycle
    public final void PlaceComponentResult(LifecycleListener lifecycleListener) {
        this.MyBillsEntityDataFactory.add(lifecycleListener);
        if (this.BuiltInFictitiousFunctionClassFactory) {
            lifecycleListener.onDestroy();
        } else if (this.PlaceComponentResult) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public final void MyBillsEntityDataFactory(LifecycleListener lifecycleListener) {
        this.MyBillsEntityDataFactory.remove(lifecycleListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void getAuthRequestContext() {
        this.PlaceComponentResult = true;
        Iterator it = Util.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult = false;
        Iterator it = Util.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult() {
        this.BuiltInFictitiousFunctionClassFactory = true;
        Iterator it = Util.KClassImpl$Data$declaredNonStaticMembers$2(this.MyBillsEntityDataFactory).iterator();
        while (it.hasNext()) {
            ((LifecycleListener) it.next()).onDestroy();
        }
    }
}
