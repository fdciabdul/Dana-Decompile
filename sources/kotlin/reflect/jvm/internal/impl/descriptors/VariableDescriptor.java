package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;

/* loaded from: classes.dex */
public interface VariableDescriptor extends ValueDescriptor {
    /* renamed from: getCompileTimeInitializer */
    ConstantValue<?> mo4436getCompileTimeInitializer();

    boolean isConst();

    boolean isLateInit();

    boolean isVar();
}
