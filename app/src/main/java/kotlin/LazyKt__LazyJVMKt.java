package kotlin;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\b\u001a/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0004\u0010\u000b"}, d2 = {"T", "Lkotlin/Function0;", "initializer", "Lkotlin/Lazy;", "lazy", "(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "", "lock", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;", "Lkotlin/LazyThreadSafetyMode;", "mode", "(Lkotlin/LazyThreadSafetyMode;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/LazyKt")
/* loaded from: classes.dex */
public class LazyKt__LazyJVMKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LazyThreadSafetyMode.values().length];
            iArr[LazyThreadSafetyMode.SYNCHRONIZED.ordinal()] = 1;
            iArr[LazyThreadSafetyMode.PUBLICATION.ordinal()] = 2;
            iArr[LazyThreadSafetyMode.NONE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        DefaultConstructorMarker defaultConstructorMarker = null;
        return new SynchronizedLazyImpl(function0, defaultConstructorMarker, 2, defaultConstructorMarker);
    }

    public static final <T> Lazy<T> lazy(LazyThreadSafetyMode lazyThreadSafetyMode, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(lazyThreadSafetyMode, "");
        Intrinsics.checkNotNullParameter(function0, "");
        int i = WhenMappings.$EnumSwitchMapping$0[lazyThreadSafetyMode.ordinal()];
        int i2 = 2;
        if (i == 1) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new SynchronizedLazyImpl(function0, defaultConstructorMarker, i2, defaultConstructorMarker);
        } else if (i != 2) {
            if (i == 3) {
                return new UnsafeLazyImpl(function0);
            }
            throw new NoWhenBranchMatchedException();
        } else {
            return new SafePublicationLazyImpl(function0);
        }
    }

    public static final <T> Lazy<T> lazy(Object obj, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "");
        return new SynchronizedLazyImpl(function0, obj);
    }
}
