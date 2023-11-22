package pl.charmas.android.reactivelocation2.observables;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;

/* loaded from: classes6.dex */
public class PendingResultObservableOnSubscribe<T extends Result> implements ObservableOnSubscribe<T> {
    private final PendingResult<T> KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory = false;

    static /* synthetic */ boolean MyBillsEntityDataFactory(PendingResultObservableOnSubscribe pendingResultObservableOnSubscribe) {
        pendingResultObservableOnSubscribe.MyBillsEntityDataFactory = true;
        return true;
    }

    public PendingResultObservableOnSubscribe(PendingResult<T> pendingResult) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = pendingResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.ObservableOnSubscribe
    public void subscribe(final ObservableEmitter<T> observableEmitter) throws Exception {
        this.KClassImpl$Data$declaredNonStaticMembers$2.setResultCallback(new ResultCallback<T>() { // from class: pl.charmas.android.reactivelocation2.observables.PendingResultObservableOnSubscribe.1
            @Override // com.google.android.gms.common.api.ResultCallback
            public void onResult(T t) {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onNext(t);
                    observableEmitter.onComplete();
                }
                PendingResultObservableOnSubscribe.MyBillsEntityDataFactory(PendingResultObservableOnSubscribe.this);
            }
        });
        observableEmitter.setDisposable(Disposables.BuiltInFictitiousFunctionClassFactory(new Action() { // from class: pl.charmas.android.reactivelocation2.observables.PendingResultObservableOnSubscribe.2
            @Override // io.reactivex.functions.Action
            public void run() {
                if (PendingResultObservableOnSubscribe.this.MyBillsEntityDataFactory) {
                    return;
                }
                PendingResultObservableOnSubscribe.this.KClassImpl$Data$declaredNonStaticMembers$2.cancel();
            }
        }));
    }
}
