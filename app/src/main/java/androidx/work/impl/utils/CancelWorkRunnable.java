package androidx.work.impl.utils;

import androidx.work.Operation;
import androidx.work.WorkInfo;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Scheduler;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.WorkSpecDao;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class CancelWorkRunnable implements Runnable {
    public final OperationImpl getAuthRequestContext = new OperationImpl();

    abstract void KClassImpl$Data$declaredNonStaticMembers$2();

    @Override // java.lang.Runnable
    public void run() {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2();
            this.getAuthRequestContext.MyBillsEntityDataFactory(Operation.KClassImpl$Data$declaredNonStaticMembers$2);
        } catch (Throwable th) {
            this.getAuthRequestContext.MyBillsEntityDataFactory(new Operation.State.FAILURE(th));
        }
    }

    public static CancelWorkRunnable getAuthRequestContext(final UUID uuid, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.1
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            final void KClassImpl$Data$declaredNonStaticMembers$2() {
                WorkDatabase workDatabase = workManagerImpl.lookAheadTest;
                workDatabase.beginTransaction();
                try {
                    getAuthRequestContext(workManagerImpl, uuid.toString());
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    WorkManagerImpl workManagerImpl2 = workManagerImpl;
                    Schedulers.PlaceComponentResult(workManagerImpl2.getAuthRequestContext, workManagerImpl2.lookAheadTest, workManagerImpl2.BuiltInFictitiousFunctionClassFactory);
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable getAuthRequestContext(final String str, final WorkManagerImpl workManagerImpl) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.2
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            final void KClassImpl$Data$declaredNonStaticMembers$2() {
                WorkDatabase workDatabase = workManagerImpl.lookAheadTest;
                workDatabase.beginTransaction();
                try {
                    Iterator<String> it = workDatabase.getErrorConfigVersion().BuiltInFictitiousFunctionClassFactory(str).iterator();
                    while (it.hasNext()) {
                        getAuthRequestContext(workManagerImpl, it.next());
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    WorkManagerImpl workManagerImpl2 = workManagerImpl;
                    Schedulers.PlaceComponentResult(workManagerImpl2.getAuthRequestContext, workManagerImpl2.lookAheadTest, workManagerImpl2.BuiltInFictitiousFunctionClassFactory);
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
        };
    }

    public static CancelWorkRunnable BuiltInFictitiousFunctionClassFactory(final String str, final WorkManagerImpl workManagerImpl, final boolean z) {
        return new CancelWorkRunnable() { // from class: androidx.work.impl.utils.CancelWorkRunnable.3
            @Override // androidx.work.impl.utils.CancelWorkRunnable
            final void KClassImpl$Data$declaredNonStaticMembers$2() {
                WorkDatabase workDatabase = workManagerImpl.lookAheadTest;
                workDatabase.beginTransaction();
                try {
                    Iterator<String> it = workDatabase.getErrorConfigVersion().MyBillsEntityDataFactory(str).iterator();
                    while (it.hasNext()) {
                        getAuthRequestContext(workManagerImpl, it.next());
                    }
                    workDatabase.setTransactionSuccessful();
                    workDatabase.endTransaction();
                    if (z) {
                        WorkManagerImpl workManagerImpl2 = workManagerImpl;
                        Schedulers.PlaceComponentResult(workManagerImpl2.getAuthRequestContext, workManagerImpl2.lookAheadTest, workManagerImpl2.BuiltInFictitiousFunctionClassFactory);
                    }
                } catch (Throwable th) {
                    workDatabase.endTransaction();
                    throw th;
                }
            }
        };
    }

    /* renamed from: androidx.work.impl.utils.CancelWorkRunnable$4 */
    /* loaded from: classes3.dex */
    class AnonymousClass4 extends CancelWorkRunnable {
        final /* synthetic */ WorkManagerImpl MyBillsEntityDataFactory;

        @Override // androidx.work.impl.utils.CancelWorkRunnable
        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            WorkDatabase workDatabase = this.MyBillsEntityDataFactory.lookAheadTest;
            workDatabase.beginTransaction();
            try {
                Iterator<String> it = workDatabase.getErrorConfigVersion().MyBillsEntityDataFactory().iterator();
                while (it.hasNext()) {
                    getAuthRequestContext(this.MyBillsEntityDataFactory, it.next());
                }
                PreferenceUtils preferenceUtils = new PreferenceUtils(this.MyBillsEntityDataFactory.lookAheadTest);
                preferenceUtils.getAuthRequestContext.MyBillsEntityDataFactory().MyBillsEntityDataFactory(new Preference("last_cancel_all_time_ms", System.currentTimeMillis()));
                workDatabase.setTransactionSuccessful();
            } finally {
                workDatabase.endTransaction();
            }
        }
    }

    static void getAuthRequestContext(WorkManagerImpl workManagerImpl, String str) {
        WorkDatabase workDatabase = workManagerImpl.lookAheadTest;
        WorkSpecDao errorConfigVersion = workDatabase.getErrorConfigVersion();
        DependencyDao KClassImpl$Data$declaredNonStaticMembers$2 = workDatabase.KClassImpl$Data$declaredNonStaticMembers$2();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State PlaceComponentResult = errorConfigVersion.PlaceComponentResult(str2);
            if (PlaceComponentResult != WorkInfo.State.SUCCEEDED && PlaceComponentResult != WorkInfo.State.FAILED) {
                errorConfigVersion.KClassImpl$Data$declaredNonStaticMembers$2(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(str2));
        }
        workManagerImpl.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(str);
        Iterator<Scheduler> it = workManagerImpl.BuiltInFictitiousFunctionClassFactory.iterator();
        while (it.hasNext()) {
            it.next().KClassImpl$Data$declaredNonStaticMembers$2(str);
        }
    }
}
