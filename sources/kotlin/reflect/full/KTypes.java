package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0019\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lkotlin/reflect/KType;", "other", "", "isSubtypeOf", "(Lkotlin/reflect/KType;Lkotlin/reflect/KType;)Z", "isSupertypeOf", "nullable", "withNullability", "(Lkotlin/reflect/KType;Z)Lkotlin/reflect/KType;"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes9.dex */
public final class KTypes {
    public static final KType withNullability(KType kType, boolean z) {
        Intrinsics.checkNotNullParameter(kType, "");
        return ((KTypeImpl) kType).makeNullableAsSpecified$kotlin_reflection(z);
    }

    public static final boolean isSubtypeOf(KType kType, KType kType2) {
        Intrinsics.checkNotNullParameter(kType, "");
        Intrinsics.checkNotNullParameter(kType2, "");
        return TypeUtilsKt.isSubtypeOf(((KTypeImpl) kType).getType(), ((KTypeImpl) kType2).getType());
    }

    public static final boolean isSupertypeOf(KType kType, KType kType2) {
        Intrinsics.checkNotNullParameter(kType, "");
        Intrinsics.checkNotNullParameter(kType2, "");
        return isSubtypeOf(kType2, kType);
    }
}
