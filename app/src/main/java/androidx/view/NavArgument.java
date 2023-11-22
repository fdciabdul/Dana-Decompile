package androidx.view;

import android.os.Bundle;
import androidx.view.NavType;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001fB3\b\u0000\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0001X\u0007¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\r\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\r\u0010\u0017R\u001a\u0010\u0011\u001a\u00020\u00038\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\u001a"}, d2 = {"Landroidx/navigation/NavArgument;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "Landroid/os/Bundle;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Landroid/os/Bundle;)V", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "(Ljava/lang/String;Landroid/os/Bundle;)Z", "MyBillsEntityDataFactory", "Ljava/lang/Object;", "PlaceComponentResult", "Z", "()Z", "BuiltInFictitiousFunctionClassFactory", "Landroidx/navigation/NavType;", "Landroidx/navigation/NavType;", "p2", "p3", "<init>", "(Landroidx/navigation/NavType;ZLjava/lang/Object;Z)V", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavArgument {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;
    public final Object MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final NavType<Object> BuiltInFictitiousFunctionClassFactory;

    public NavArgument(NavType<Object> navType, boolean z, Object obj, boolean z2) {
        Intrinsics.checkNotNullParameter(navType, "");
        if (!(navType.getGetAuthRequestContext() || !z)) {
            StringBuilder sb = new StringBuilder();
            sb.append(navType.getMyBillsEntityDataFactory());
            sb.append(" does not allow nullable values");
            throw new IllegalArgumentException(sb.toString().toString());
        }
        if (!((!z && z2 && obj == null) ? false : true)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Argument with type ");
            sb2.append(navType.getMyBillsEntityDataFactory());
            sb2.append(" has null value but is not nullable.");
            throw new IllegalArgumentException(sb2.toString().toString());
        }
        this.BuiltInFictitiousFunctionClassFactory = navType;
        this.getAuthRequestContext = z;
        this.MyBillsEntityDataFactory = obj;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z2;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getGetAuthRequestContext() {
        return this.getAuthRequestContext;
    }

    @JvmName(name = "KClassImpl$Data$declaredNonStaticMembers$2")
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p1, p0, this.MyBillsEntityDataFactory);
        }
    }

    public final boolean getAuthRequestContext(String p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (!this.getAuthRequestContext && p1.containsKey(p0) && p1.get(p0) == null) {
            return false;
        }
        try {
            this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(p1, p0);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(" Type: ");
        sb2.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(" Nullable: ");
        sb3.append(this.getAuthRequestContext);
        sb.append(sb3.toString());
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(" DefaultValue: ");
            sb4.append(this.MyBillsEntityDataFactory);
            sb.append(sb4.toString());
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 == null || !Intrinsics.areEqual(getClass(), p0.getClass())) {
            return false;
        }
        NavArgument navArgument = (NavArgument) p0;
        if (this.getAuthRequestContext == navArgument.getAuthRequestContext && this.KClassImpl$Data$declaredNonStaticMembers$2 == navArgument.KClassImpl$Data$declaredNonStaticMembers$2 && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, navArgument.BuiltInFictitiousFunctionClassFactory)) {
            Object obj = this.MyBillsEntityDataFactory;
            if (obj != null) {
                return Intrinsics.areEqual(obj, navArgument.MyBillsEntityDataFactory);
            }
            return navArgument.MyBillsEntityDataFactory == null;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        boolean z = this.getAuthRequestContext;
        boolean z2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Object obj = this.MyBillsEntityDataFactory;
        return (((((hashCode * 31) + (z ? 1 : 0)) * 31) + (z2 ? 1 : 0)) * 31) + (obj != null ? obj.hashCode() : 0);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0005\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\bR \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Landroidx/navigation/NavArgument$Builder;", "", "Landroidx/navigation/NavArgument;", "PlaceComponentResult", "()Landroidx/navigation/NavArgument;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Object;", "", "Z", "getAuthRequestContext", "Landroidx/navigation/NavType;", "MyBillsEntityDataFactory", "Landroidx/navigation/NavType;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        Object PlaceComponentResult;
        NavType<Object> MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        boolean BuiltInFictitiousFunctionClassFactory;
        boolean getAuthRequestContext;

        public final NavArgument PlaceComponentResult() {
            NavType<Object> navType = this.MyBillsEntityDataFactory;
            if (navType == null) {
                NavType.Companion companion = NavType.INSTANCE;
                navType = NavType.Companion.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult);
            }
            return new NavArgument(navType, this.getAuthRequestContext, this.PlaceComponentResult, this.BuiltInFictitiousFunctionClassFactory);
        }
    }
}
