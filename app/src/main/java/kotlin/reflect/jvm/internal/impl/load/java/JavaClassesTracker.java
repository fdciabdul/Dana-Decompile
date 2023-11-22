package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor;

/* loaded from: classes.dex */
public interface JavaClassesTracker {
    void reportClass(JavaClassDescriptor javaClassDescriptor);

    /* loaded from: classes.dex */
    public static final class Default implements JavaClassesTracker {
        public static final Default INSTANCE = new Default();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.JavaClassesTracker
        public final void reportClass(JavaClassDescriptor javaClassDescriptor) {
            Intrinsics.checkNotNullParameter(javaClassDescriptor, "");
        }

        private Default() {
        }
    }
}
