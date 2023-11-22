package kotlin.reflect.jvm.internal;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Lkotlin/reflect/KTypeProjection;", BridgeDSL.INVOKE, "()Ljava/util/List;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class KTypeImpl$arguments$2 extends Lambda implements Function0<List<? extends KTypeProjection>> {
    final /* synthetic */ Function0<Type> $$computeJavaType;
    final /* synthetic */ KTypeImpl this$0;

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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public KTypeImpl$arguments$2(KTypeImpl kTypeImpl, Function0<? extends Type> function0) {
        super(0);
        this.this$0 = kTypeImpl;
        this.$$computeJavaType = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends KTypeProjection> invoke() {
        KTypeProjection invariant;
        List<TypeProjection> arguments = this.this$0.getType().getArguments();
        if (arguments.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.PUBLICATION;
        final KTypeImpl kTypeImpl = this.this$0;
        final Lazy lazy = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<List<? extends Type>>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$parameterizedTypeArguments$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends Type> invoke() {
                Type javaType = KTypeImpl.this.getJavaType();
                Intrinsics.checkNotNull(javaType);
                return ReflectClassUtilKt.getParameterizedTypeArguments(javaType);
            }
        });
        List<TypeProjection> list = arguments;
        Function0<Type> function0 = this.$$computeJavaType;
        final KTypeImpl kTypeImpl2 = this.this$0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        final int i = 0;
        for (Object obj : list) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TypeProjection typeProjection = (TypeProjection) obj;
            if (typeProjection.isStarProjection()) {
                invariant = KTypeProjection.INSTANCE.getSTAR();
            } else {
                KotlinType type = typeProjection.getType();
                Intrinsics.checkNotNullExpressionValue(type, "");
                KTypeImpl kTypeImpl3 = new KTypeImpl(type, function0 == null ? null : new Function0<Type>() { // from class: kotlin.reflect.jvm.internal.KTypeImpl$arguments$2$1$type$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Type invoke() {
                        List m4427invoke$lambda0;
                        Type type2;
                        Type javaType = KTypeImpl.this.getJavaType();
                        if (javaType instanceof Class) {
                            Class cls = (Class) javaType;
                            Class componentType = cls.isArray() ? cls.getComponentType() : Object.class;
                            Intrinsics.checkNotNullExpressionValue(componentType, "");
                            return componentType;
                        }
                        if (javaType instanceof GenericArrayType) {
                            if (i != 0) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Array type has been queried for a non-0th argument: ");
                                sb.append(KTypeImpl.this);
                                throw new KotlinReflectionInternalError(sb.toString());
                            }
                            type2 = ((GenericArrayType) javaType).getGenericComponentType();
                        } else if (javaType instanceof ParameterizedType) {
                            m4427invoke$lambda0 = KTypeImpl$arguments$2.m4427invoke$lambda0(lazy);
                            type2 = (Type) m4427invoke$lambda0.get(i);
                            if (type2 instanceof WildcardType) {
                                WildcardType wildcardType = (WildcardType) type2;
                                Type[] lowerBounds = wildcardType.getLowerBounds();
                                Intrinsics.checkNotNullExpressionValue(lowerBounds, "");
                                Type type3 = (Type) ArraysKt.firstOrNull(lowerBounds);
                                if (type3 == null) {
                                    Type[] upperBounds = wildcardType.getUpperBounds();
                                    Intrinsics.checkNotNullExpressionValue(upperBounds, "");
                                    type2 = (Type) ArraysKt.first(upperBounds);
                                } else {
                                    type2 = type3;
                                }
                            }
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Non-generic type has been queried for arguments: ");
                            sb2.append(KTypeImpl.this);
                            throw new KotlinReflectionInternalError(sb2.toString());
                        }
                        Intrinsics.checkNotNullExpressionValue(type2, "");
                        return type2;
                    }
                });
                int i2 = WhenMappings.$EnumSwitchMapping$0[typeProjection.getProjectionKind().ordinal()];
                if (i2 == 1) {
                    invariant = KTypeProjection.INSTANCE.invariant(kTypeImpl3);
                } else if (i2 == 2) {
                    invariant = KTypeProjection.INSTANCE.contravariant(kTypeImpl3);
                } else if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    invariant = KTypeProjection.INSTANCE.covariant(kTypeImpl3);
                }
            }
            arrayList.add(invariant);
            i++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final List<Type> m4427invoke$lambda0(Lazy<? extends List<? extends Type>> lazy) {
        return (List) lazy.getValue();
    }
}
