package kotlin.reflect;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001b\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J(\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "Lkotlin/reflect/KVariance;", "component1", "()Lkotlin/reflect/KVariance;", "Lkotlin/reflect/KType;", "component2", "()Lkotlin/reflect/KType;", "variance", "type", "copy", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlin/reflect/KType;", "getType", "Lkotlin/reflect/KVariance;", "getVariance", "<init>", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KTypeProjection {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final KTypeProjection star = new KTypeProjection(null, null);
    private final KType type;
    private final KVariance variance;

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

    @JvmStatic
    public static final KTypeProjection contravariant(KType kType) {
        return INSTANCE.contravariant(kType);
    }

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int i, Object obj) {
        if ((i & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((i & 2) != 0) {
            kType = kTypeProjection.type;
        }
        return kTypeProjection.copy(kVariance, kType);
    }

    @JvmStatic
    public static final KTypeProjection covariant(KType kType) {
        return INSTANCE.covariant(kType);
    }

    @JvmStatic
    public static final KTypeProjection invariant(KType kType) {
        return INSTANCE.invariant(kType);
    }

    /* renamed from: component1  reason: from getter */
    public final KVariance getVariance() {
        return this.variance;
    }

    /* renamed from: component2  reason: from getter */
    public final KType getType() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance variance, KType type) {
        return new KTypeProjection(variance, type);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KTypeProjection) {
            KTypeProjection kTypeProjection = (KTypeProjection) other;
            return this.variance == kTypeProjection.variance && Intrinsics.areEqual(this.type, kTypeProjection.type);
        }
        return false;
    }

    public final int hashCode() {
        KVariance kVariance = this.variance;
        int hashCode = kVariance == null ? 0 : kVariance.hashCode();
        KType kType = this.type;
        return (hashCode * 31) + (kType != null ? kType.hashCode() : 0);
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        String obj;
        this.variance = kVariance;
        this.type = kType;
        if ((kVariance == null) == (kType == null)) {
            return;
        }
        if (kVariance == null) {
            obj = "Star projection must have no type specified.";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("The projection variance ");
            sb.append(kVariance);
            sb.append(" requires type to be specified.");
            obj = sb.toString();
        }
        throw new IllegalArgumentException(obj.toString());
    }

    @JvmName(name = "getVariance")
    public final KVariance getVariance() {
        return this.variance;
    }

    @JvmName(name = "getType")
    public final KType getType() {
        return this.type;
    }

    public final String toString() {
        KVariance kVariance = this.variance;
        int i = kVariance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[kVariance.ordinal()];
        if (i != -1) {
            if (i != 1) {
                if (i == 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("in ");
                    sb.append(this.type);
                    return sb.toString();
                } else if (i == 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("out ");
                    sb2.append(this.type);
                    return sb2.toString();
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            return String.valueOf(this.type);
        }
        return "*";
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\b\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u0012\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "Lkotlin/reflect/KType;", "type", "Lkotlin/reflect/KTypeProjection;", "contravariant", "(Lkotlin/reflect/KType;)Lkotlin/reflect/KTypeProjection;", "covariant", "invariant", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "STAR", "star", "Lkotlin/reflect/KTypeProjection;", "getStar$annotations", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getStar$annotations() {
        }

        private Companion() {
        }

        @JvmName(name = "getSTAR")
        public final KTypeProjection getSTAR() {
            return KTypeProjection.star;
        }

        @JvmStatic
        public final KTypeProjection invariant(KType type) {
            Intrinsics.checkNotNullParameter(type, "");
            return new KTypeProjection(KVariance.INVARIANT, type);
        }

        @JvmStatic
        public final KTypeProjection contravariant(KType type) {
            Intrinsics.checkNotNullParameter(type, "");
            return new KTypeProjection(KVariance.IN, type);
        }

        @JvmStatic
        public final KTypeProjection covariant(KType type) {
            Intrinsics.checkNotNullParameter(type, "");
            return new KTypeProjection(KVariance.OUT, type);
        }
    }
}
