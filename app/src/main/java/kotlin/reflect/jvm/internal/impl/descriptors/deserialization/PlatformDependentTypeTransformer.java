package kotlin.reflect.jvm.internal.impl.descriptors.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes.dex */
public interface PlatformDependentTypeTransformer {
    SimpleType transformPlatformType(ClassId classId, SimpleType simpleType);

    /* loaded from: classes.dex */
    public static final class None implements PlatformDependentTypeTransformer {
        public static final None INSTANCE = new None();

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentTypeTransformer
        public final SimpleType transformPlatformType(ClassId classId, SimpleType simpleType) {
            Intrinsics.checkNotNullParameter(classId, "");
            Intrinsics.checkNotNullParameter(simpleType, "");
            return simpleType;
        }

        private None() {
        }
    }
}
