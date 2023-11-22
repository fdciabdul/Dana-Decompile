package io.reactivex;

/* loaded from: classes9.dex */
public interface SingleOperator<Downstream, Upstream> {
    SingleObserver<? super Upstream> getAuthRequestContext() throws Exception;
}
