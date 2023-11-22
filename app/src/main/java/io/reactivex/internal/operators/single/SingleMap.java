package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* loaded from: classes2.dex */
public final class SingleMap<T, R> extends Single<R> {
    final Function<? super T, ? extends R> MyBillsEntityDataFactory;
    final SingleSource<? extends T> PlaceComponentResult;

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        this.PlaceComponentResult = singleSource;
        this.MyBillsEntityDataFactory = function;
    }

    @Override // io.reactivex.Single
    public final void PlaceComponentResult(SingleObserver<? super R> singleObserver) {
        this.PlaceComponentResult.MyBillsEntityDataFactory(new MapSingleObserver(singleObserver, this.MyBillsEntityDataFactory));
    }

    /* loaded from: classes6.dex */
    static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        final Function<? super T, ? extends R> BuiltInFictitiousFunctionClassFactory;
        final SingleObserver<? super R> PlaceComponentResult;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            this.PlaceComponentResult = singleObserver;
            this.BuiltInFictitiousFunctionClassFactory = function;
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable disposable) {
            this.PlaceComponentResult.onSubscribe(disposable);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T t) {
            try {
                this.PlaceComponentResult.onSuccess(ObjectHelper.PlaceComponentResult(this.BuiltInFictitiousFunctionClassFactory.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable th) {
            this.PlaceComponentResult.onError(th);
        }
    }
}
