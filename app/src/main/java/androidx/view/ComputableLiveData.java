package androidx.view;

import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes6.dex */
public abstract class ComputableLiveData<T> {
    final AtomicBoolean BuiltInFictitiousFunctionClassFactory;
    final LiveData<T> KClassImpl$Data$declaredNonStaticMembers$2;
    final Runnable MyBillsEntityDataFactory;
    final Runnable NetworkUserEntityData$$ExternalSyntheticLambda0;
    final AtomicBoolean PlaceComponentResult;
    final Executor getAuthRequestContext;

    protected abstract T getAuthRequestContext();

    public ComputableLiveData() {
        this(ArchTaskExecutor.getAuthRequestContext());
    }

    private ComputableLiveData(Executor executor) {
        this.PlaceComponentResult = new AtomicBoolean(true);
        this.BuiltInFictitiousFunctionClassFactory = new AtomicBoolean(false);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                do {
                    boolean z = false;
                    if (ComputableLiveData.this.BuiltInFictitiousFunctionClassFactory.compareAndSet(false, true)) {
                        Object obj = null;
                        boolean z2 = false;
                        while (ComputableLiveData.this.PlaceComponentResult.compareAndSet(true, false)) {
                            try {
                                obj = ComputableLiveData.this.getAuthRequestContext();
                                z2 = true;
                            } catch (Throwable th) {
                                ComputableLiveData.this.BuiltInFictitiousFunctionClassFactory.set(false);
                                throw th;
                            }
                        }
                        if (z2) {
                            ComputableLiveData.this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory((LiveData<T>) obj);
                        }
                        ComputableLiveData.this.BuiltInFictitiousFunctionClassFactory.set(false);
                        z = z2;
                    }
                    if (!z) {
                        return;
                    }
                } while (ComputableLiveData.this.PlaceComponentResult.get());
            }
        };
        this.MyBillsEntityDataFactory = new Runnable() { // from class: androidx.lifecycle.ComputableLiveData.3
            @Override // java.lang.Runnable
            public void run() {
                boolean MyBillsEntityDataFactory = ComputableLiveData.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory();
                if (ComputableLiveData.this.PlaceComponentResult.compareAndSet(false, true) && MyBillsEntityDataFactory) {
                    ComputableLiveData.this.getAuthRequestContext.execute(ComputableLiveData.this.NetworkUserEntityData$$ExternalSyntheticLambda0);
                }
            }
        };
        this.getAuthRequestContext = executor;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LiveData<T>() { // from class: androidx.lifecycle.ComputableLiveData.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.view.LiveData
            public final void BuiltInFictitiousFunctionClassFactory() {
                ComputableLiveData.this.getAuthRequestContext.execute(ComputableLiveData.this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            }
        };
    }
}
