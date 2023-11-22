package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    public ConstraintTracker<T> BuiltInFictitiousFunctionClassFactory;
    public final List<String> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
    public T MyBillsEntityDataFactory;
    public OnConstraintUpdatedCallback getAuthRequestContext;

    /* loaded from: classes3.dex */
    public interface OnConstraintUpdatedCallback {
        void KClassImpl$Data$declaredNonStaticMembers$2(List<String> list);

        void MyBillsEntityDataFactory(List<String> list);
    }

    abstract boolean BuiltInFictitiousFunctionClassFactory(WorkSpec workSpec);

    abstract boolean BuiltInFictitiousFunctionClassFactory(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.BuiltInFictitiousFunctionClassFactory = constraintTracker;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Iterable<WorkSpec> iterable) {
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
        for (WorkSpec workSpec : iterable) {
            if (BuiltInFictitiousFunctionClassFactory(workSpec)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(workSpec.getErrorConfigVersion);
            }
        }
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
            this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(this);
        } else {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory((ConstraintListener) this);
        }
        getAuthRequestContext(this.getAuthRequestContext, this.MyBillsEntityDataFactory);
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        T t = this.MyBillsEntityDataFactory;
        return t != null && BuiltInFictitiousFunctionClassFactory((ConstraintController<T>) t) && this.KClassImpl$Data$declaredNonStaticMembers$2.contains(str);
    }

    public final void getAuthRequestContext(OnConstraintUpdatedCallback onConstraintUpdatedCallback, T t) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty() || onConstraintUpdatedCallback == null) {
            return;
        }
        if (t == null || BuiltInFictitiousFunctionClassFactory((ConstraintController<T>) t)) {
            onConstraintUpdatedCallback.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2);
        } else {
            onConstraintUpdatedCallback.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public final void getAuthRequestContext(T t) {
        this.MyBillsEntityDataFactory = t;
        getAuthRequestContext(this.getAuthRequestContext, t);
    }
}
