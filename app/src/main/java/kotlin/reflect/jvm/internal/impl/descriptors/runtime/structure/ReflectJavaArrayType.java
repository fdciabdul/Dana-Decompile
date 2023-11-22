package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;

/* loaded from: classes.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    private final Collection<JavaAnnotation> annotations;
    private final ReflectJavaType componentType;
    private final boolean isDeprecatedInJavaDoc;
    private final Type reflectType;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType create;
        Intrinsics.checkNotNullParameter(type, "");
        this.reflectType = type;
        Type reflectType = getReflectType();
        if (!(reflectType instanceof GenericArrayType)) {
            if (reflectType instanceof Class) {
                Class cls = (Class) reflectType;
                if (cls.isArray()) {
                    ReflectJavaType.Factory factory = ReflectJavaType.Factory;
                    Class<?> componentType = cls.getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType, "");
                    create = factory.create(componentType);
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Not an array type (");
            sb.append(getReflectType().getClass());
            sb.append("): ");
            sb.append(getReflectType());
            throw new IllegalArgumentException(sb.toString());
        }
        ReflectJavaType.Factory factory2 = ReflectJavaType.Factory;
        Type genericComponentType = ((GenericArrayType) reflectType).getGenericComponentType();
        Intrinsics.checkNotNullExpressionValue(genericComponentType, "");
        create = factory2.create(genericComponentType);
        this.componentType = create;
        this.annotations = CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    protected final Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public final ReflectJavaType getComponentType() {
        return this.componentType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }
}
