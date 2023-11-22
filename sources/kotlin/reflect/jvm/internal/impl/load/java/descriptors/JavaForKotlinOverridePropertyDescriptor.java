package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* loaded from: classes.dex */
public final class JavaForKotlinOverridePropertyDescriptor extends JavaPropertyDescriptor {
    private final SimpleFunctionDescriptor getterMethod;
    private final PropertyDescriptor overriddenProperty;
    private final SimpleFunctionDescriptor setterMethod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JavaForKotlinOverridePropertyDescriptor(ClassDescriptor classDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor, SimpleFunctionDescriptor simpleFunctionDescriptor2, PropertyDescriptor propertyDescriptor) {
        super(classDescriptor, Annotations.Companion.getEMPTY(), simpleFunctionDescriptor.getModality(), simpleFunctionDescriptor.getVisibility(), simpleFunctionDescriptor2 != null, propertyDescriptor.getName(), simpleFunctionDescriptor.getSource(), null, CallableMemberDescriptor.Kind.DECLARATION, false, null);
        Intrinsics.checkNotNullParameter(classDescriptor, "");
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "");
        Intrinsics.checkNotNullParameter(propertyDescriptor, "");
        this.getterMethod = simpleFunctionDescriptor;
        this.setterMethod = simpleFunctionDescriptor2;
        this.overriddenProperty = propertyDescriptor;
    }
}
