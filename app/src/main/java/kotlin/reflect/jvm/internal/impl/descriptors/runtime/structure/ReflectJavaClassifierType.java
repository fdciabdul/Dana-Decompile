package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* loaded from: classes.dex */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    private final JavaClassifier classifier;
    private final Type reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final JavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaClassifierType(Type type) {
        ReflectJavaClass reflectJavaClass;
        Intrinsics.checkNotNullParameter(type, "");
        this.reflectType = type;
        Type reflectType = getReflectType();
        if (reflectType instanceof Class) {
            reflectJavaClass = new ReflectJavaClass((Class) reflectType);
        } else if (reflectType instanceof TypeVariable) {
            reflectJavaClass = new ReflectJavaTypeParameter((TypeVariable) reflectType);
        } else if (!(reflectType instanceof ParameterizedType)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Not a classifier type (");
            sb.append(reflectType.getClass());
            sb.append("): ");
            sb.append(reflectType);
            throw new IllegalStateException(sb.toString());
        } else {
            Type rawType = ((ParameterizedType) reflectType).getRawType();
            Intrinsics.checkNotNull(rawType);
            reflectJavaClass = new ReflectJavaClass((Class) rawType);
        }
        this.classifier = reflectJavaClass;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public final Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final String getClassifierQualifiedName() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type not found: ");
        sb.append(getReflectType());
        throw new UnsupportedOperationException(sb.toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final boolean isRaw() {
        Type reflectType = getReflectType();
        if (reflectType instanceof Class) {
            TypeVariable[] typeParameters = ((Class) reflectType).getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "");
            if ((!(typeParameters.length == 0)) != false) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public final List<JavaType> getTypeArguments() {
        List<Type> parameterizedTypeArguments = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory factory = ReflectJavaType.Factory;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        Iterator<T> it = parameterizedTypeArguments.iterator();
        while (it.hasNext()) {
            arrayList.add(factory.create((Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public final Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }
}
