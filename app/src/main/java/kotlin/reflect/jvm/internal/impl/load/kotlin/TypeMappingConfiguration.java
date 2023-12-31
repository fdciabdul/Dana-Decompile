package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* loaded from: classes.dex */
public interface TypeMappingConfiguration<T> {

    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static <T> String getPredefinedFullInternalNameForClass(TypeMappingConfiguration<? extends T> typeMappingConfiguration, ClassDescriptor classDescriptor) {
            Intrinsics.checkNotNullParameter(classDescriptor, "");
            return null;
        }

        public static <T> KotlinType preprocessType(TypeMappingConfiguration<? extends T> typeMappingConfiguration, KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "");
            return null;
        }
    }

    KotlinType commonSupertype(Collection<KotlinType> collection);

    String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor);

    String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor);

    T getPredefinedTypeForClass(ClassDescriptor classDescriptor);

    KotlinType preprocessType(KotlinType kotlinType);

    void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor);
}
