package pl.charmas.android.reactivelocation2;

import com.google.android.gms.common.data.AbstractDataBuffer;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.Iterator;

/* loaded from: classes9.dex */
public final class DataBufferObservable {
    private DataBufferObservable() {
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: pl.charmas.android.reactivelocation2.DataBufferObservable$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass1<T> implements ObservableOnSubscribe<T> {
        final /* synthetic */ AbstractDataBuffer getAuthRequestContext;

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<T> observableEmitter) {
            Iterator<T> it = this.getAuthRequestContext.iterator();
            while (it.hasNext()) {
                observableEmitter.onNext(it.next());
            }
            observableEmitter.setDisposable(Disposables.BuiltInFictitiousFunctionClassFactory(new Action() { // from class: pl.charmas.android.reactivelocation2.DataBufferObservable.1.1
                @Override // io.reactivex.functions.Action
                public void run() throws Exception {
                    AnonymousClass1.this.getAuthRequestContext.release();
                }
            }));
        }
    }
}
