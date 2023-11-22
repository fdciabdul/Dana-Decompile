package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u001a)\u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u000f\u001a\u00020\u0005*\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0015\u001a\u00020\u0005*\u00020\f8G¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"\u001e\u0010\u0015\u001a\u00020\u0005*\u00020\u00038CX\u0082\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0016"}, d2 = {"Ljava/lang/Class;", "jClass", "", "Lkotlin/reflect/KTypeProjection;", "arguments", "Ljava/lang/reflect/Type;", "createPossiblyInnerType", "(Ljava/lang/Class;Ljava/util/List;)Ljava/lang/reflect/Type;", "type", "", "typeToString", "(Ljava/lang/reflect/Type;)Ljava/lang/String;", "Lkotlin/reflect/KType;", "", "forceWrapper", "computeJavaType", "(Lkotlin/reflect/KType;Z)Ljava/lang/reflect/Type;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "javaType", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "(Lkotlin/reflect/KTypeProjection;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.IN.ordinal()] = 1;
            iArr[KVariance.INVARIANT.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getJavaType$annotations(KType kType) {
    }

    private static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    @JvmName(name = "getJavaType")
    public static final Type getJavaType(KType kType) {
        Type javaType;
        Intrinsics.checkNotNullParameter(kType, "");
        return (!(kType instanceof KTypeBase) || (javaType = ((KTypeBase) kType).getJavaType()) == null) ? computeJavaType$default(kType, false, 1, null) : javaType;
    }

    static /* synthetic */ Type computeJavaType$default(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return computeJavaType(kType, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type computeJavaType(KType kType, boolean z) {
        KClassifier classifier = kType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            return new TypeVariableImpl((KTypeParameter) classifier);
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            Class javaObjectType = z ? JvmClassMappingKt.getJavaObjectType(kClass) : JvmClassMappingKt.getJavaClass(kClass);
            List<KTypeProjection> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return javaObjectType;
            }
            if (javaObjectType.isArray()) {
                if (javaObjectType.getComponentType().isPrimitive()) {
                    return javaObjectType;
                }
                KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull((List) arguments);
                if (kTypeProjection == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("kotlin.Array must have exactly one type argument: ");
                    sb.append(kType);
                    throw new IllegalArgumentException(sb.toString());
                }
                KVariance variance = kTypeProjection.getVariance();
                KType type = kTypeProjection.getType();
                int i = variance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
                if (i == -1 || i == 1) {
                    return javaObjectType;
                }
                if (i == 2 || i == 3) {
                    Intrinsics.checkNotNull(type);
                    Type computeJavaType$default = computeJavaType$default(type, false, 1, null);
                    Type type2 = javaObjectType;
                    if (!(computeJavaType$default instanceof Class)) {
                        type2 = new GenericArrayTypeImpl(computeJavaType$default);
                    }
                    return type2;
                }
                throw new NoWhenBranchMatchedException();
            }
            return createPossiblyInnerType(javaObjectType, arguments);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unsupported type classifier: ");
        sb2.append(kType);
        throw new UnsupportedOperationException(sb2.toString());
    }

    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<KTypeProjection> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(getJavaType((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            Class<?> cls2 = declaringClass;
            List<KTypeProjection> list3 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                arrayList2.add(getJavaType((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, cls2, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type createPossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
            List<KTypeProjection> subList = list.subList(0, length);
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(subList, 10));
            Iterator<T> it3 = subList.iterator();
            while (it3.hasNext()) {
                arrayList3.add(getJavaType((KTypeProjection) it3.next()));
            }
            return new ParameterizedTypeImpl(cls, createPossiblyInnerType, arrayList3);
        }
    }

    @JvmName(name = "getJavaType")
    private static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }
        KType type = kTypeProjection.getType();
        Intrinsics.checkNotNull(type);
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new WildcardTypeImpl(computeJavaType(type, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return computeJavaType(type, true);
        }
        return new WildcardTypeImpl(null, computeJavaType(type, true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String typeToString(Type type) {
        String name;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                Sequence generateSequence = SequencesKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                StringBuilder sb = new StringBuilder();
                sb.append(((Class) SequencesKt.last(generateSequence)).getName());
                sb.append(StringsKt.repeat("[]", SequencesKt.count(generateSequence)));
                name = sb.toString();
            } else {
                name = cls.getName();
            }
            Intrinsics.checkNotNullExpressionValue(name, "");
            return name;
        }
        return type.toString();
    }
}
