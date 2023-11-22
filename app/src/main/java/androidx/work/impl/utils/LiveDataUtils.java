package androidx.work.impl.utils;

import androidx.arch.core.util.Function;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* loaded from: classes3.dex */
public class LiveDataUtils {
    public static <In, Out> LiveData<Out> KClassImpl$Data$declaredNonStaticMembers$2(LiveData<In> liveData, Function<In, Out> function, TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.getAuthRequestContext(liveData, new AnonymousClass1(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [In] */
    /* renamed from: androidx.work.impl.utils.LiveDataUtils$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1<In> implements Observer<In> {
        final /* synthetic */ MediatorLiveData BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ Object KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ TaskExecutor MyBillsEntityDataFactory;
        Out PlaceComponentResult = null;
        final /* synthetic */ Function getAuthRequestContext;

        AnonymousClass1(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.MyBillsEntityDataFactory = taskExecutor;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = obj;
            this.getAuthRequestContext = function;
            this.BuiltInFictitiousFunctionClassFactory = mediatorLiveData;
        }

        @Override // androidx.view.Observer
        public void onChanged(final In in2) {
            this.MyBillsEntityDataFactory.getAuthRequestContext(new Runnable() { // from class: androidx.work.impl.utils.LiveDataUtils.1.1
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, Out] */
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (AnonymousClass1.this.KClassImpl$Data$declaredNonStaticMembers$2) {
                        ?? authRequestContext = AnonymousClass1.this.getAuthRequestContext.getAuthRequestContext(in2);
                        if (AnonymousClass1.this.PlaceComponentResult == 0 && authRequestContext != 0) {
                            AnonymousClass1.this.PlaceComponentResult = authRequestContext;
                            AnonymousClass1.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((MediatorLiveData) authRequestContext);
                        } else if (AnonymousClass1.this.PlaceComponentResult != 0 && !AnonymousClass1.this.PlaceComponentResult.equals(authRequestContext)) {
                            AnonymousClass1.this.PlaceComponentResult = authRequestContext;
                            AnonymousClass1.this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory((MediatorLiveData) authRequestContext);
                        }
                    }
                }
            });
        }
    }

    private LiveDataUtils() {
    }
}
