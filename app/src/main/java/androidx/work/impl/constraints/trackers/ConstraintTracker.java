package androidx.work.impl.constraints.trackers;

import android.content.Context;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class ConstraintTracker<T> {
    private static final String PlaceComponentResult = Logger.MyBillsEntityDataFactory("ConstraintTracker");
    T BuiltInFictitiousFunctionClassFactory;
    protected final TaskExecutor KClassImpl$Data$declaredNonStaticMembers$2;
    protected final Context MyBillsEntityDataFactory;
    private final Object getErrorConfigVersion = new Object();
    private final Set<ConstraintListener<T>> getAuthRequestContext = new LinkedHashSet();

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2();

    public abstract T MyBillsEntityDataFactory();

    public abstract void PlaceComponentResult();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintTracker(Context context, TaskExecutor taskExecutor) {
        this.MyBillsEntityDataFactory = context.getApplicationContext();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = taskExecutor;
    }

    public final void MyBillsEntityDataFactory(ConstraintListener<T> constraintListener) {
        synchronized (this.getErrorConfigVersion) {
            if (this.getAuthRequestContext.add(constraintListener)) {
                if (this.getAuthRequestContext.size() == 1) {
                    this.BuiltInFictitiousFunctionClassFactory = MyBillsEntityDataFactory();
                    Logger.getAuthRequestContext().PlaceComponentResult(PlaceComponentResult, String.format("%s: initial state = %s", getClass().getSimpleName(), this.BuiltInFictitiousFunctionClassFactory), new Throwable[0]);
                    PlaceComponentResult();
                }
                constraintListener.getAuthRequestContext(this.BuiltInFictitiousFunctionClassFactory);
            }
        }
    }

    public final void getAuthRequestContext(ConstraintListener<T> constraintListener) {
        synchronized (this.getErrorConfigVersion) {
            if (this.getAuthRequestContext.remove(constraintListener) && this.getAuthRequestContext.isEmpty()) {
                KClassImpl$Data$declaredNonStaticMembers$2();
            }
        }
    }

    public final void MyBillsEntityDataFactory(T t) {
        synchronized (this.getErrorConfigVersion) {
            T t2 = this.BuiltInFictitiousFunctionClassFactory;
            if (t2 != t && (t2 == null || !t2.equals(t))) {
                this.BuiltInFictitiousFunctionClassFactory = t;
                final ArrayList arrayList = new ArrayList(this.getAuthRequestContext);
                this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory().execute(new Runnable() { // from class: androidx.work.impl.constraints.trackers.ConstraintTracker.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((ConstraintListener) it.next()).getAuthRequestContext(ConstraintTracker.this.BuiltInFictitiousFunctionClassFactory);
                        }
                    }
                });
            }
        }
    }
}
