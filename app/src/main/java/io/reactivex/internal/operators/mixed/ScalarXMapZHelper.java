package io.reactivex.internal.operators.mixed;

import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;

/* loaded from: classes9.dex */
final class ScalarXMapZHelper {
    private ScalarXMapZHelper() {
        throw new IllegalStateException("No instances!");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> boolean MyBillsEntityDataFactory(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        if (obj instanceof Callable) {
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                CompletableSource completableSource = obj2 != 0 ? (CompletableSource) ObjectHelper.PlaceComponentResult(function.apply(obj2), "The mapper returned a null CompletableSource") : null;
                if (completableSource == null) {
                    EmptyDisposable.complete(completableObserver);
                } else {
                    completableSource.getAuthRequestContext(completableObserver);
                }
                return true;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, completableObserver);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean MyBillsEntityDataFactory(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        if (obj instanceof Callable) {
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                MaybeSource maybeSource = obj2 != 0 ? (MaybeSource) ObjectHelper.PlaceComponentResult(function.apply(obj2), "The mapper returned a null MaybeSource") : null;
                if (maybeSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    maybeSource.PlaceComponentResult(MaybeToObservable.PlaceComponentResult(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R> boolean BuiltInFictitiousFunctionClassFactory(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        if (obj instanceof Callable) {
            try {
                Object obj2 = (Object) ((Callable) obj).call();
                SingleSource singleSource = obj2 != 0 ? (SingleSource) ObjectHelper.PlaceComponentResult(function.apply(obj2), "The mapper returned a null SingleSource") : null;
                if (singleSource == null) {
                    EmptyDisposable.complete(observer);
                } else {
                    singleSource.MyBillsEntityDataFactory(SingleToObservable.MyBillsEntityDataFactory(observer));
                }
                return true;
            } catch (Throwable th) {
                Exceptions.MyBillsEntityDataFactory(th);
                EmptyDisposable.error(th, observer);
                return true;
            }
        }
        return false;
    }
}
