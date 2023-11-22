package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableOperator;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* loaded from: classes2.dex */
public final class ObservableLift<R, T> extends AbstractObservableWithUpstream<T, R> {
    final ObservableOperator<? extends R, ? super T> MyBillsEntityDataFactory;

    public ObservableLift(ObservableSource<T> observableSource, ObservableOperator<? extends R, ? super T> observableOperator) {
        super(observableSource);
        this.MyBillsEntityDataFactory = observableOperator;
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> observer) {
        try {
            Observer<? super Object> KClassImpl$Data$declaredNonStaticMembers$2 = this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2();
            StringBuilder sb = new StringBuilder();
            sb.append("Operator ");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(" returned a null Observer");
            this.getAuthRequestContext.subscribe((Observer) ObjectHelper.PlaceComponentResult(KClassImpl$Data$declaredNonStaticMembers$2, sb.toString()));
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            Exceptions.MyBillsEntityDataFactory(th);
            RxJavaPlugins.PlaceComponentResult(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
