package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.WorkContinuation;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class WorkContinuationImpl extends WorkContinuation {
    private static final String NetworkUserEntityData$$ExternalSyntheticLambda0 = Logger.MyBillsEntityDataFactory("WorkContinuationImpl");
    public final List<WorkContinuationImpl> BuiltInFictitiousFunctionClassFactory;
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean MyBillsEntityDataFactory;
    public final List<String> PlaceComponentResult;
    public final ExistingWorkPolicy getAuthRequestContext;
    private Operation getErrorConfigVersion;
    public final WorkManagerImpl lookAheadTest;
    private final List<String> moveToNextValue;
    public final List<? extends WorkRequest> scheduleImpl;

    public final boolean getAuthRequestContext() {
        return this.MyBillsEntityDataFactory;
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, List<? extends WorkRequest> list) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, list, null);
    }

    public WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list) {
        this(workManagerImpl, str, existingWorkPolicy, list, null);
    }

    private WorkContinuationImpl(WorkManagerImpl workManagerImpl, String str, ExistingWorkPolicy existingWorkPolicy, List<? extends WorkRequest> list, List<WorkContinuationImpl> list2) {
        this.lookAheadTest = workManagerImpl;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.getAuthRequestContext = existingWorkPolicy;
        this.scheduleImpl = list;
        this.BuiltInFictitiousFunctionClassFactory = list2;
        this.PlaceComponentResult = new ArrayList(list.size());
        this.moveToNextValue = new ArrayList();
        if (list2 != null) {
            Iterator<WorkContinuationImpl> it = list2.iterator();
            while (it.hasNext()) {
                this.moveToNextValue.addAll(it.next().moveToNextValue);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String obj = list.get(i).KClassImpl$Data$declaredNonStaticMembers$2.toString();
            this.PlaceComponentResult.add(obj);
            this.moveToNextValue.add(obj);
        }
    }

    @Override // androidx.work.WorkContinuation
    public final WorkContinuation PlaceComponentResult(List<OneTimeWorkRequest> list) {
        return list.isEmpty() ? this : new WorkContinuationImpl(this.lookAheadTest, this.KClassImpl$Data$declaredNonStaticMembers$2, ExistingWorkPolicy.KEEP, list, Collections.singletonList(this));
    }

    @Override // androidx.work.WorkContinuation
    public final Operation KClassImpl$Data$declaredNonStaticMembers$2() {
        if (!this.MyBillsEntityDataFactory) {
            EnqueueRunnable enqueueRunnable = new EnqueueRunnable(this);
            this.lookAheadTest.getErrorConfigVersion.getAuthRequestContext(enqueueRunnable);
            this.getErrorConfigVersion = enqueueRunnable.KClassImpl$Data$declaredNonStaticMembers$2;
        } else {
            Logger.getAuthRequestContext().getAuthRequestContext(NetworkUserEntityData$$ExternalSyntheticLambda0, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.PlaceComponentResult)), new Throwable[0]);
        }
        return this.getErrorConfigVersion;
    }

    public final boolean PlaceComponentResult() {
        return PlaceComponentResult(this, new HashSet());
    }

    public static Set<String> MyBillsEntityDataFactory(WorkContinuationImpl workContinuationImpl) {
        HashSet hashSet = new HashSet();
        List<WorkContinuationImpl> list = workContinuationImpl.BuiltInFictitiousFunctionClassFactory;
        if (list != null && !list.isEmpty()) {
            Iterator<WorkContinuationImpl> it = list.iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next().PlaceComponentResult);
            }
        }
        return hashSet;
    }

    private static boolean PlaceComponentResult(WorkContinuationImpl workContinuationImpl, Set<String> set) {
        set.addAll(workContinuationImpl.PlaceComponentResult);
        Set<String> MyBillsEntityDataFactory = MyBillsEntityDataFactory(workContinuationImpl);
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (MyBillsEntityDataFactory.contains(it.next())) {
                return true;
            }
        }
        List<WorkContinuationImpl> list = workContinuationImpl.BuiltInFictitiousFunctionClassFactory;
        if (list != null && !list.isEmpty()) {
            Iterator<WorkContinuationImpl> it2 = list.iterator();
            while (it2.hasNext()) {
                if (PlaceComponentResult(it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(workContinuationImpl.PlaceComponentResult);
        return false;
    }
}
