package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* loaded from: classes.dex */
public interface FlexibleTypeDeserializer {
    KotlinType create(ProtoBuf.Type type, String str, SimpleType simpleType, SimpleType simpleType2);

    /* loaded from: classes.dex */
    public static final class ThrowException implements FlexibleTypeDeserializer {
        public static final ThrowException INSTANCE = new ThrowException();

        private ThrowException() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
        public final KotlinType create(ProtoBuf.Type type, String str, SimpleType simpleType, SimpleType simpleType2) {
            Intrinsics.checkNotNullParameter(type, "");
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(simpleType, "");
            Intrinsics.checkNotNullParameter(simpleType2, "");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }
}
