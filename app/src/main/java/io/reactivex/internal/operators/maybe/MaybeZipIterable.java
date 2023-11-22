package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.internal.operators.maybe.MaybeZipArray;
import java.util.Arrays;

/* loaded from: classes9.dex */
public final class MaybeZipIterable<T, R> extends Maybe<R> {
    final Function<? super Object[], ? extends R> BuiltInFictitiousFunctionClassFactory;
    final Iterable<? extends MaybeSource<? extends T>> MyBillsEntityDataFactory;

    @Override // io.reactivex.Maybe
    public final void MyBillsEntityDataFactory(MaybeObserver<? super R> maybeObserver) {
        MaybeSource[] maybeSourceArr = new MaybeSource[8];
        try {
            int i = 0;
            for (MaybeSource<? extends T> maybeSource : this.MyBillsEntityDataFactory) {
                if (maybeSource == null) {
                    EmptyDisposable.error(new NullPointerException("One of the sources is null"), maybeObserver);
                    return;
                }
                if (i == maybeSourceArr.length) {
                    maybeSourceArr = (MaybeSource[]) Arrays.copyOf(maybeSourceArr, (i >> 2) + i);
                }
                maybeSourceArr[i] = maybeSource;
                i++;
            }
            if (i == 0) {
                EmptyDisposable.complete(maybeObserver);
            } else if (i == 1) {
                maybeSourceArr[0].PlaceComponentResult(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            } else {
                MaybeZipArray.ZipCoordinator zipCoordinator = new MaybeZipArray.ZipCoordinator(maybeObserver, i, this.BuiltInFictitiousFunctionClassFactory);
                maybeObserver.onSubscribe(zipCoordinator);
                for (int i2 = 0; i2 < i && !zipCoordinator.isDisposed(); i2++) {
                    maybeSourceArr[i2].PlaceComponentResult(zipCoordinator.observers[i2]);
                }
            }
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            EmptyDisposable.error(th, maybeObserver);
        }
    }

    /* loaded from: classes9.dex */
    final class SingletonArrayFunc implements Function<T, R> {
        SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final R apply(T t) throws Exception {
            return (R) ObjectHelper.PlaceComponentResult(MaybeZipIterable.this.BuiltInFictitiousFunctionClassFactory.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }
}
