package id.dana.extension.arguments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0002\u001a\u00028\u00002\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007¸\u0006\b"}, d2 = {"Lid/dana/extension/arguments/ArgumentDelegateKt$argumentDelegate$1;", "Lid/dana/extension/arguments/LazyProvider;", "p0", "Lkotlin/reflect/KProperty;", "p1", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Lkotlin/Lazy;", "id/dana/extension/arguments/ArgumentDelegateKt$argumentDelegate$1"}, k = 1, mv = {1, 6, 0}, xi = 176)
/* loaded from: classes8.dex */
public final class ArgumentsExtKt$argumentDelegate$$inlined$argumentDelegate$1<T> implements LazyProvider<Fragment, T> {
    @Override // id.dana.extension.arguments.LazyProvider
    public final Lazy<T> KClassImpl$Data$declaredNonStaticMembers$2(final Fragment p0, final KProperty<?> p1) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new Function0<T>() { // from class: id.dana.extension.arguments.ArgumentsExtKt$argumentDelegate$$inlined$argumentDelegate$1.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                Bundle arguments = ((Fragment) p0).getArguments();
                T t = arguments != null ? (T) arguments.get(p1.getName()) : null;
                Intrinsics.reifiedOperationMarker(1, "T");
                T t2 = t;
                return t;
            }
        });
    }
}
