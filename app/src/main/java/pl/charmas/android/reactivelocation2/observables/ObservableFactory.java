package pl.charmas.android.reactivelocation2.observables;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.BiPredicate;

/* loaded from: classes6.dex */
public class ObservableFactory {
    public final ObservableContext getAuthRequestContext;

    public ObservableFactory(ObservableContext observableContext) {
        this.getAuthRequestContext = observableContext;
    }

    /* loaded from: classes6.dex */
    public static class RetryOnConnectionSuspension<T> implements ObservableTransformer<T, T> {
        private final boolean BuiltInFictitiousFunctionClassFactory;

        public RetryOnConnectionSuspension(boolean z) {
            this.BuiltInFictitiousFunctionClassFactory = z;
        }

        @Override // io.reactivex.ObservableTransformer
        public final ObservableSource<T> MyBillsEntityDataFactory(Observable<T> observable) {
            return this.BuiltInFictitiousFunctionClassFactory ? observable.retry(new IsConnectionSuspendedException((byte) 0)) : observable;
        }

        /* loaded from: classes6.dex */
        static class IsConnectionSuspendedException implements BiPredicate<Integer, Throwable> {
            private IsConnectionSuspendedException() {
            }

            /* synthetic */ IsConnectionSuspendedException(byte b) {
                this();
            }

            @Override // io.reactivex.functions.BiPredicate
            public final /* synthetic */ boolean BuiltInFictitiousFunctionClassFactory(Integer num, Throwable th) throws Exception {
                return getAuthRequestContext(th);
            }

            private static boolean getAuthRequestContext(Throwable th) throws Exception {
                return th instanceof GoogleAPIConnectionSuspendedException;
            }
        }
    }
}
