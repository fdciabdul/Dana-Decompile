package kotlin.reflect.jvm.internal;

import id.dana.data.constant.BranchLinkConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeParameterReference;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectKotlinClass;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmPackagePartSource;
import kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinJvmBinaryClass;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.Variance;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u001c\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0096\u0002J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u0010\u0010\"\u001a\u0006\u0012\u0002\b\u00030#*\u00020$H\u0002J\u0010\u0010%\u001a\u0006\u0012\u0002\b\u00030&*\u00020'H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "Lkotlin/reflect/KTypeParameter;", "Lkotlin/reflect/jvm/internal/KClassifierImpl;", BranchLinkConstant.PathTarget.CONTAINER, "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/TypeParameterDescriptor;", "(Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;)V", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/TypeParameterDescriptor;", "isReified", "", "()Z", "name", "", "getName", "()Ljava/lang/String;", "upperBounds", "", "Lkotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "upperBounds$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "", "hashCode", "", "toString", "getContainerClass", "Ljava/lang/Class;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/descriptors/DeserializedMemberDescriptor;", "toKClassImpl", "Lkotlin/reflect/jvm/internal/KClassImpl;", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class KTypeParameterImpl implements KTypeParameter, KClassifierImpl {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(KTypeParameterImpl.class), "upperBounds", "getUpperBounds()Ljava/util/List;"))};
    private final KTypeParameterOwnerImpl container;
    private final TypeParameterDescriptor descriptor;

    /* renamed from: upperBounds$delegate  reason: from kotlin metadata */
    private final ReflectProperties.LazySoftVal upperBounds;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Variance.values().length];
            iArr[Variance.INVARIANT.ordinal()] = 1;
            iArr[Variance.IN_VARIANCE.ordinal()] = 2;
            iArr[Variance.OUT_VARIANCE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public KTypeParameterImpl(KTypeParameterOwnerImpl kTypeParameterOwnerImpl, TypeParameterDescriptor typeParameterDescriptor) {
        KClassImpl<?> kClassImpl;
        Object accept;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "");
        this.descriptor = typeParameterDescriptor;
        this.upperBounds = ReflectProperties.lazySoft(new Function0<List<? extends KTypeImpl>>() { // from class: kotlin.reflect.jvm.internal.KTypeParameterImpl$upperBounds$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function0] */
            @Override // kotlin.jvm.functions.Function0
            public final List<? extends KTypeImpl> invoke() {
                List<KotlinType> upperBounds = KTypeParameterImpl.this.getDescriptor().getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "");
                List<KotlinType> list = upperBounds;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    ?? r5 = 0;
                    arrayList.add(new KTypeImpl((KotlinType) it.next(), r5, 2, r5));
                }
                return arrayList;
            }
        });
        if (kTypeParameterOwnerImpl == null) {
            DeclarationDescriptor containingDeclaration = getDescriptor().getContainingDeclaration();
            Intrinsics.checkNotNullExpressionValue(containingDeclaration, "");
            if (containingDeclaration instanceof ClassDescriptor) {
                accept = toKClassImpl((ClassDescriptor) containingDeclaration);
            } else if (containingDeclaration instanceof CallableMemberDescriptor) {
                DeclarationDescriptor containingDeclaration2 = ((CallableMemberDescriptor) containingDeclaration).getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration2, "");
                if (containingDeclaration2 instanceof ClassDescriptor) {
                    kClassImpl = toKClassImpl((ClassDescriptor) containingDeclaration2);
                } else {
                    DeserializedMemberDescriptor deserializedMemberDescriptor = containingDeclaration instanceof DeserializedMemberDescriptor ? (DeserializedMemberDescriptor) containingDeclaration : null;
                    if (deserializedMemberDescriptor == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Non-class callable descriptor must be deserialized: ");
                        sb.append(containingDeclaration);
                        throw new KotlinReflectionInternalError(sb.toString());
                    }
                    KClass kotlinClass = JvmClassMappingKt.getKotlinClass(getContainerClass(deserializedMemberDescriptor));
                    Intrinsics.checkNotNull(kotlinClass);
                    kClassImpl = (KClassImpl) kotlinClass;
                }
                accept = containingDeclaration.accept(new CreateKCallableVisitor(kClassImpl), Unit.INSTANCE);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown type parameter container: ");
                sb2.append(containingDeclaration);
                throw new KotlinReflectionInternalError(sb2.toString());
            }
            Intrinsics.checkNotNullExpressionValue(accept, "");
            kTypeParameterOwnerImpl = (KTypeParameterOwnerImpl) accept;
        }
        this.container = kTypeParameterOwnerImpl;
    }

    @Override // kotlin.reflect.jvm.internal.KClassifierImpl
    public final TypeParameterDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final String getName() {
        String asString = getDescriptor().getName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "");
        return asString;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final List<KType> getUpperBounds() {
        T value = this.upperBounds.getValue(this, $$delegatedProperties[0]);
        Intrinsics.checkNotNullExpressionValue(value, "");
        return (List) value;
    }

    @Override // kotlin.reflect.KTypeParameter
    public final KVariance getVariance() {
        int i = WhenMappings.$EnumSwitchMapping$0[getDescriptor().getVariance().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return KVariance.OUT;
                }
                throw new NoWhenBranchMatchedException();
            }
            return KVariance.IN;
        }
        return KVariance.INVARIANT;
    }

    @Override // kotlin.reflect.KTypeParameter
    /* renamed from: isReified */
    public final boolean getIsReified() {
        return getDescriptor().isReified();
    }

    private final KClassImpl<?> toKClassImpl(ClassDescriptor classDescriptor) {
        Class<?> javaClass = UtilKt.toJavaClass(classDescriptor);
        KClassImpl<?> kClassImpl = (KClassImpl) (javaClass != null ? JvmClassMappingKt.getKotlinClass(javaClass) : null);
        if (kClassImpl != null) {
            return kClassImpl;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Type parameter container is not resolved: ");
        sb.append(classDescriptor.getContainingDeclaration());
        throw new KotlinReflectionInternalError(sb.toString());
    }

    private final Class<?> getContainerClass(DeserializedMemberDescriptor deserializedMemberDescriptor) {
        Class<?> klass;
        DeserializedContainerSource containerSource = deserializedMemberDescriptor.getContainerSource();
        if (!(containerSource instanceof JvmPackagePartSource)) {
            containerSource = null;
        }
        JvmPackagePartSource jvmPackagePartSource = (JvmPackagePartSource) containerSource;
        KotlinJvmBinaryClass knownJvmBinaryClass = jvmPackagePartSource != null ? jvmPackagePartSource.getKnownJvmBinaryClass() : null;
        ReflectKotlinClass reflectKotlinClass = knownJvmBinaryClass instanceof ReflectKotlinClass ? knownJvmBinaryClass : null;
        if (reflectKotlinClass == null || (klass = reflectKotlinClass.getKlass()) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Container of deserialized member is not resolved: ");
            sb.append(deserializedMemberDescriptor);
            throw new KotlinReflectionInternalError(sb.toString());
        }
        return klass;
    }

    public final boolean equals(Object other) {
        if (other instanceof KTypeParameterImpl) {
            KTypeParameterImpl kTypeParameterImpl = (KTypeParameterImpl) other;
            if (Intrinsics.areEqual(this.container, kTypeParameterImpl.container) && Intrinsics.areEqual(getName(), kTypeParameterImpl.getName())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    public final String toString() {
        return TypeParameterReference.INSTANCE.toString(this);
    }
}
