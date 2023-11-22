package io.reactivex;

/* loaded from: classes9.dex */
public interface MaybeOperator<Downstream, Upstream> {
    MaybeObserver<? super Upstream> getAuthRequestContext() throws Exception;
}
