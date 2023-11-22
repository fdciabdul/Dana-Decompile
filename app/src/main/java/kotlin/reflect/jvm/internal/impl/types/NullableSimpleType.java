package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class NullableSimpleType extends DelegatingSimpleTypeImpl {
    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType, kotlin.reflect.jvm.internal.impl.types.KotlinType
    public final boolean isMarkedNullable() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NullableSimpleType(SimpleType simpleType) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType
    public final NullableSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "");
        return new NullableSimpleType(simpleType);
    }
}
