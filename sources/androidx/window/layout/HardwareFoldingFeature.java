package androidx.window.layout;

import android.graphics.Rect;
import androidx.window.core.Bounds;
import androidx.window.layout.FoldingFeature;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0010\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u0018X\u0017¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0011\u0010\u001d\u001a\u00020\u001bX\u0001¢\u0006\u0006\n\u0004\b\u000e\u0010\u001c"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature;", "Landroidx/window/layout/FoldingFeature;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Landroid/graphics/Rect;", "getAuthRequestContext", "()Landroid/graphics/Rect;", "Landroidx/window/core/Bounds;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/window/core/Bounds;", "()Z", "BuiltInFictitiousFunctionClassFactory", "Landroidx/window/layout/FoldingFeature$Orientation;", "()Landroidx/window/layout/FoldingFeature$Orientation;", "PlaceComponentResult", "Landroidx/window/layout/FoldingFeature$State;", "Landroidx/window/layout/FoldingFeature$State;", "MyBillsEntityDataFactory", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "moveToNextValue", "p1", "p2", "<init>", "(Landroidx/window/core/Bounds;Landroidx/window/layout/HardwareFoldingFeature$Type;Landroidx/window/layout/FoldingFeature$State;)V", "Companion", "Type"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HardwareFoldingFeature implements FoldingFeature {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final FoldingFeature.State MyBillsEntityDataFactory;
    private final Bounds KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Type moveToNextValue;

    public HardwareFoldingFeature(Bounds bounds, Type type, FoldingFeature.State state) {
        Intrinsics.checkNotNullParameter(bounds, "");
        Intrinsics.checkNotNullParameter(type, "");
        Intrinsics.checkNotNullParameter(state, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = bounds;
        this.moveToNextValue = type;
        this.MyBillsEntityDataFactory = state;
        Companion.BuiltInFictitiousFunctionClassFactory(bounds);
    }

    @Override // androidx.window.layout.DisplayFeature
    @JvmName(name = "getAuthRequestContext")
    public final Rect getAuthRequestContext() {
        Bounds bounds = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return new Rect(bounds.BuiltInFictitiousFunctionClassFactory, bounds.KClassImpl$Data$declaredNonStaticMembers$2, bounds.MyBillsEntityDataFactory, bounds.PlaceComponentResult);
    }

    @Override // androidx.window.layout.FoldingFeature
    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        Type type = this.moveToNextValue;
        Type.Companion companion = Type.INSTANCE;
        if (!Intrinsics.areEqual(type, Type.Companion.getAuthRequestContext())) {
            Type type2 = this.moveToNextValue;
            Type.Companion companion2 = Type.INSTANCE;
            if (!Intrinsics.areEqual(type2, Type.Companion.BuiltInFictitiousFunctionClassFactory()) || !Intrinsics.areEqual(this.MyBillsEntityDataFactory, FoldingFeature.State.MyBillsEntityDataFactory)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.window.layout.FoldingFeature
    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    public final FoldingFeature.Orientation BuiltInFictitiousFunctionClassFactory() {
        Bounds bounds = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int i = bounds.MyBillsEntityDataFactory - bounds.BuiltInFictitiousFunctionClassFactory;
        Bounds bounds2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (i > bounds2.PlaceComponentResult - bounds2.KClassImpl$Data$declaredNonStaticMembers$2) {
            return FoldingFeature.Orientation.BuiltInFictitiousFunctionClassFactory;
        }
        return FoldingFeature.Orientation.getAuthRequestContext;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) "HardwareFoldingFeature");
        sb.append(" { ");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", type=");
        sb.append(this.moveToNextValue);
        sb.append(", state=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(" }");
        return sb.toString();
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), p0 == null ? null : p0.getClass())) {
            if (p0 != null) {
                HardwareFoldingFeature hardwareFoldingFeature = (HardwareFoldingFeature) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, hardwareFoldingFeature.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.moveToNextValue, hardwareFoldingFeature.moveToNextValue) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, hardwareFoldingFeature.MyBillsEntityDataFactory);
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        }
        return false;
    }

    public final int hashCode() {
        return (((this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode() * 31) + this.moveToNextValue.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Companion;", "", "Landroidx/window/core/Bounds;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroidx/window/core/Bounds;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void BuiltInFictitiousFunctionClassFactory(Bounds p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (!((p0.MyBillsEntityDataFactory - p0.BuiltInFictitiousFunctionClassFactory == 0 && p0.PlaceComponentResult - p0.KClassImpl$Data$declaredNonStaticMembers$2 == 0) ? false : true)) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (!(p0.BuiltInFictitiousFunctionClassFactory == 0 || p0.KClassImpl$Data$declaredNonStaticMembers$2 == 0)) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type;", "", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "p0", "<init>", "(Ljava/lang/String;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Type {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final Type KClassImpl$Data$declaredNonStaticMembers$2 = new Type("FOLD");
        private static final Type PlaceComponentResult = new Type("HINGE");

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final String PlaceComponentResult;

        private Type(String str) {
            this.PlaceComponentResult = str;
        }

        /* renamed from: toString  reason: from getter */
        public final String getPlaceComponentResult() {
            return this.PlaceComponentResult;
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Landroidx/window/layout/HardwareFoldingFeature$Type$Companion;", "", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/window/layout/HardwareFoldingFeature$Type;", "BuiltInFictitiousFunctionClassFactory", "()Landroidx/window/layout/HardwareFoldingFeature$Type;", "PlaceComponentResult", "getAuthRequestContext", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
            public static Type BuiltInFictitiousFunctionClassFactory() {
                return Type.KClassImpl$Data$declaredNonStaticMembers$2;
            }

            @JvmName(name = "getAuthRequestContext")
            public static Type getAuthRequestContext() {
                return Type.PlaceComponentResult;
            }
        }
    }
}
