package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes.dex */
public final class DeserializedArrayValue extends ArrayValue {
    private final KotlinType type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedArrayValue(List<? extends ConstantValue<?>> list, final KotlinType kotlinType) {
        super(list, new Function1<ModuleDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedArrayValue.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(ModuleDescriptor moduleDescriptor) {
                Intrinsics.checkNotNullParameter(moduleDescriptor, "");
                return KotlinType.this;
            }
        });
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(kotlinType, "");
        this.type = kotlinType;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
