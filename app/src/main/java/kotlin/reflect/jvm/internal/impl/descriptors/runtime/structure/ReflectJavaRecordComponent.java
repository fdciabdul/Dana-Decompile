package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* loaded from: classes.dex */
public final class ReflectJavaRecordComponent extends ReflectJavaMember implements JavaRecordComponent {
    private final Object recordComponent;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public final boolean isVararg() {
        return false;
    }

    public ReflectJavaRecordComponent(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "");
        this.recordComponent = obj;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaRecordComponent
    public final JavaType getType() {
        Class<?> loadGetType = Java16RecordComponentsLoader.INSTANCE.loadGetType(this.recordComponent);
        if (loadGetType != null) {
            return new ReflectJavaClassifierType(loadGetType);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public final Member getMember() {
        Method loadGetAccessor = Java16RecordComponentsLoader.INSTANCE.loadGetAccessor(this.recordComponent);
        if (loadGetAccessor != null) {
            return loadGetAccessor;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }
}
