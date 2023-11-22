package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;

/* loaded from: classes.dex */
public interface TypeParameterResolver {
    TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter);

    /* loaded from: classes.dex */
    public static final class EMPTY implements TypeParameterResolver {
        public static final EMPTY INSTANCE = new EMPTY();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver
        public final TypeParameterDescriptor resolveTypeParameter(JavaTypeParameter javaTypeParameter) {
            Intrinsics.checkNotNullParameter(javaTypeParameter, "");
            return null;
        }

        private EMPTY() {
        }
    }
}
