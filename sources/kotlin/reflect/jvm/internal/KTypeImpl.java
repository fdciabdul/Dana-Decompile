package kotlin.reflect.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KProperty;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0012\u0010\"\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0013\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u001bH\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020,H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000f\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006-²\u0006\u0010\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u008a\u0084\u0002"}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeImpl;", "Lkotlin/jvm/internal/KTypeBase;", "type", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "computeJavaType", "Lkotlin/Function0;", "Ljava/lang/reflect/Type;", "(Lorg/jetbrains/kotlin/types/KotlinType;Lkotlin/jvm/functions/Function0;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "arguments$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "classifier$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "getComputeJavaType$annotations", "()V", "isMarkedNullable", "", "()Z", "javaType", "getJavaType", "()Ljava/lang/reflect/Type;", "getType", "()Lorg/jetbrains/kotlin/types/KotlinType;", "convert", "equals", "other", "", "hashCode", "", "makeNullableAsSpecified", "nullable", "makeNullableAsSpecified$kotlin_reflection", "toString", "", "kotlin-reflection", "parameterizedTypeArguments"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class KTypeImpl implements KTypeBase {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeImpl.class), "arguments", "getArguments()Ljava/util/List;"))};

    /* renamed from: arguments$delegate  reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal arguments;

    /* renamed from: classifier$delegate  reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal classifier;
    private final ReflectProperties.LazySoftVal<Type> computeJavaType;
    private final KotlinType type;

    public KTypeImpl(KotlinType kotlinType, Function0<? extends Type> function0) {
        Intrinsics.checkNotNullParameter(kotlinType, "");
        this.type = kotlinType;
        ReflectProperties.LazySoftVal<Type> lazySoftVal = null;
        ReflectProperties.LazySoftVal<Type> lazySoftVal2 = function0 instanceof ReflectProperties.LazySoftVal ? (ReflectProperties.LazySoftVal) function0 : null;
        if (lazySoftVal2 != null) {
            lazySoftVal = lazySoftVal2;
        } else if (function0 != null) {
            lazySoftVal = ReflectProperties.lazySoft(function0);
        }
        this.computeJavaType = lazySoftVal;
        this.classifier = ReflectProperties.lazySoft(new Function0<KClassifier>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$classifier$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KClassifier invoke() {
                KClassifier convert;
                KTypeImpl kTypeImpl = KTypeImpl.this;
                convert = kTypeImpl.convert(kTypeImpl.getType());
                return convert;
            }
        });
        this.arguments = ReflectProperties.lazySoft(new KTypeImpl$arguments$2(this, function0));
    }

    public /* synthetic */ KTypeImpl(KotlinType kotlinType, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinType, (i & 2) != 0 ? null : function0);
    }

    public final KotlinType getType() {
        return this.type;
    }

    @Override // kotlin.jvm.internal.KTypeBase
    public final Type getJavaType() {
        ReflectProperties.LazySoftVal<Type> lazySoftVal = this.computeJavaType;
        if (lazySoftVal != null) {
            return lazySoftVal.invoke();
        }
        return null;
    }

    @Override // kotlin.reflect.KType
    public final KClassifier getClassifier() {
        return (KClassifier) this.classifier.getValue(this, $$delegatedProperties[0]);
    }

    public final KClassifier convert(KotlinType type) {
        KotlinType type2;
        ClassifierDescriptor mo4441getDeclarationDescriptor = type.getConstructor().mo4441getDeclarationDescriptor();
        if (mo4441getDeclarationDescriptor instanceof ClassDescriptor) {
            Class<?> javaClass = UtilKt.toJavaClass((ClassDescriptor) mo4441getDeclarationDescriptor);
            if (javaClass == null) {
                return null;
            }
            if (javaClass.isArray()) {
                TypeProjection typeProjection = (TypeProjection) CollectionsKt.singleOrNull((List) type.getArguments());
                if (typeProjection == null || (type2 = typeProjection.getType()) == null) {
                    return new KClassImpl(javaClass);
                }
                KClassifier convert = convert(type2);
                if (convert == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Cannot determine classifier for array element type: ");
                    sb.append(this);
                    throw new KotlinReflectionInternalError(sb.toString());
                }
                return new KClassImpl(UtilKt.createArrayType(JvmClassMappingKt.getJavaClass((KClass) KTypesJvm.getJvmErasure(convert))));
            } else if (!TypeUtils.isNullableType(type)) {
                Class<?> primitiveByWrapper = ReflectClassUtilKt.getPrimitiveByWrapper(javaClass);
                if (primitiveByWrapper != null) {
                    javaClass = primitiveByWrapper;
                }
                return new KClassImpl(javaClass);
            } else {
                return new KClassImpl(javaClass);
            }
        } else if (mo4441getDeclarationDescriptor instanceof TypeParameterDescriptor) {
            return new KTypeParameterImpl(null, (TypeParameterDescriptor) mo4441getDeclarationDescriptor);
        } else {
            if (mo4441getDeclarationDescriptor instanceof TypeAliasDescriptor) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("An operation is not implemented: ");
                sb2.append("Type alias classifiers are not yet supported");
                throw new NotImplementedError(sb2.toString());
            }
            return null;
        }
    }

    @Override // kotlin.reflect.KType
    public final List<KTypeProjection> getArguments() {
        T value = this.arguments.getValue(this, $$delegatedProperties[1]);
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (List) value;
    }

    @Override // kotlin.reflect.KType
    public final boolean isMarkedNullable() {
        return this.type.isMarkedNullable();
    }

    @Override // kotlin.reflect.KAnnotatedElement
    public final List<Annotation> getAnnotations() {
        return UtilKt.computeAnnotations(this.type);
    }

    public final KTypeImpl makeNullableAsSpecified$kotlin_reflection(boolean nullable) {
        if (FlexibleTypesKt.isFlexible(this.type) || isMarkedNullable() != nullable) {
            KotlinType makeNullableAsSpecified = TypeUtils.makeNullableAsSpecified(this.type, nullable);
            Intrinsics.checkNotNullExpressionValue(makeNullableAsSpecified, "");
            return new KTypeImpl(makeNullableAsSpecified, this.computeJavaType);
        }
        return this;
    }

    public final boolean equals(Object other) {
        return (other instanceof KTypeImpl) && Intrinsics.areEqual(this.type, ((KTypeImpl) other).type);
    }

    public final int hashCode() {
        return this.type.hashCode();
    }

    public final String toString() {
        return ReflectionObjectRenderer.INSTANCE.renderType(this.type);
    }
}
