package io.reactivex;

/* loaded from: classes2.dex */
public interface ObservableTransformer<Upstream, Downstream> {
    ObservableSource<Downstream> MyBillsEntityDataFactory(Observable<Upstream> observable);
}
