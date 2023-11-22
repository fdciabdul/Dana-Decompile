package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;

/* loaded from: classes.dex */
public final class ReflectJavaField extends ReflectJavaMember implements JavaField {
    private final Field member;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public final boolean getHasConstantNotNullInitializer() {
        return false;
    }

    public ReflectJavaField(Field field) {
        Intrinsics.checkNotNullParameter(field, "");
        this.member = field;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaMember
    public final Field getMember() {
        return this.member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public final boolean isEnumEntry() {
        return getMember().isEnumConstant();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField
    public final ReflectJavaType getType() {
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        Type genericType = getMember().getGenericType();
        Intrinsics.checkNotNullExpressionValue(genericType, "");
        return factory.create(genericType);
    }
}
