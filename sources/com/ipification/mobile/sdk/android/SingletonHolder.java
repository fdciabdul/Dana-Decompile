package com.ipification.mobile.sdk.android;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\n\b\u0000\u0010\u0002 \u0001*\u00020\u0001*\u0006\b\u0001\u0010\u0003 \u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00078\b@\bX\u0088\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00018\u00008\b@\bX\u0088\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lcom/ipification/mobile/sdk/android/SingletonHolder;", "", "T", "A", "p0", "PlaceComponentResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/Object;", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class SingletonHolder<T, A> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public Function1<? super A, ? extends T> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public volatile T PlaceComponentResult;

    public SingletonHolder(Function1<? super A, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
    }

    public final T PlaceComponentResult(A p0) {
        T t;
        T t2 = this.PlaceComponentResult;
        if (t2 != null) {
            return t2;
        }
        synchronized (this) {
            t = this.PlaceComponentResult;
            if (t == null) {
                Function1<? super A, ? extends T> function1 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (function1 == null) {
                    Intrinsics.throwNpe();
                }
                t = function1.invoke(p0);
                this.PlaceComponentResult = t;
                this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
            }
        }
        return t;
    }
}
