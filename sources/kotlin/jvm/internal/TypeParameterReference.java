package kotlin.jvm.internal;

import id.dana.data.constant.BranchLinkConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B)\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00048\u0017X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0017\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00108\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0012R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8WX\u0096\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\"\u001a\u00020!8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "Lkotlin/reflect/KType;", "upperBounds", "", "setUpperBounds", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "bounds", "Ljava/util/List;", BranchLinkConstant.PathTarget.CONTAINER, "Ljava/lang/Object;", "isReified", "Z", "()Z", "name", "Ljava/lang/String;", "getName", "getUpperBounds", "()Ljava/util/List;", "getUpperBounds$annotations", "()V", "Lkotlin/reflect/KVariance;", "variance", "Lkotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "<init>", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TypeParameterReference implements KTypeParameter {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private volatile List<? extends KType> bounds;
    private final Object container;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    public TypeParameterReference(Object obj, String str, KVariance kVariance, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(kVariance, "");
        this.container = obj;
        this.name = str;
        this.variance = kVariance;
        this.isReified = z;
    }

    @Override // kotlin.reflect.KTypeParameter
    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @Override // kotlin.reflect.KTypeParameter
    @JvmName(name = "getVariance")
    public final KVariance getVariance() {
        return this.variance;
    }

    @Override // kotlin.reflect.KTypeParameter
    @JvmName(name = "isReified")
    /* renamed from: isReified  reason: from getter */
    public final boolean getIsReified() {
        return this.isReified;
    }

    @Override // kotlin.reflect.KTypeParameter
    @JvmName(name = "getUpperBounds")
    public final List<KType> getUpperBounds() {
        List list = this.bounds;
        if (list == null) {
            List<KType> listOf = CollectionsKt.listOf(Reflection.nullableTypeOf(Object.class));
            this.bounds = listOf;
            return listOf;
        }
        return list;
    }

    public final void setUpperBounds(List<? extends KType> upperBounds) {
        Intrinsics.checkNotNullParameter(upperBounds, "");
        if (this.bounds != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Upper bounds of type parameter '");
            sb.append(this);
            sb.append("' have already been initialized.");
            throw new IllegalStateException(sb.toString().toString());
        }
        this.bounds = upperBounds;
    }

    public final boolean equals(Object other) {
        if (other instanceof TypeParameterReference) {
            TypeParameterReference typeParameterReference = (TypeParameterReference) other;
            if (Intrinsics.areEqual(this.container, typeParameterReference.container) && Intrinsics.areEqual(getName(), typeParameterReference.getName())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.container;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    public final String toString() {
        return INSTANCE.toString(this);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "Lkotlin/reflect/KTypeParameter;", "typeParameter", "", "toString", "(Lkotlin/reflect/KTypeParameter;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[KVariance.values().length];
                iArr[KVariance.INVARIANT.ordinal()] = 1;
                iArr[KVariance.IN.ordinal()] = 2;
                iArr[KVariance.OUT.ordinal()] = 3;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String toString(KTypeParameter typeParameter) {
            Intrinsics.checkNotNullParameter(typeParameter, "");
            StringBuilder sb = new StringBuilder();
            int i = WhenMappings.$EnumSwitchMapping$0[typeParameter.getVariance().ordinal()];
            if (i == 2) {
                sb.append("in ");
            } else if (i == 3) {
                sb.append("out ");
            }
            sb.append(typeParameter.getName());
            String obj = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return obj;
        }
    }
}
