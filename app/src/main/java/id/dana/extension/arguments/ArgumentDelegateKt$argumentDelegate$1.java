package id.dana.extension.arguments;

import android.os.Bundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: Add missing generic type declarations: [T, F] */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/extension/arguments/ArgumentDelegateKt$argumentDelegate$1;", "Lid/dana/extension/arguments/LazyProvider;", "p0", "Lkotlin/reflect/KProperty;", "p1", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/Lazy;"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes5.dex */
public final class ArgumentDelegateKt$argumentDelegate$1<F, T> implements LazyProvider<F, T> {
    final /* synthetic */ Function1<F, Bundle> getAuthRequestContext;

    @Override // id.dana.extension.arguments.LazyProvider
    public final Lazy<T> KClassImpl$Data$declaredNonStaticMembers$2(final F p0, final KProperty<?> p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.needClassReification();
        final Function1<F, Bundle> function1 = this.getAuthRequestContext;
        return LazyKt.lazy(new Function0<T>() { // from class: id.dana.extension.arguments.ArgumentDelegateKt$argumentDelegate$1$provideDelegate$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Bundle invoke = function1.invoke(p0);
                T t = invoke != null ? (T) invoke.get(p1.getName()) : null;
                Intrinsics.reifiedOperationMarker(1, "T");
                T t2 = t;
                return t;
            }
        });
    }
}
