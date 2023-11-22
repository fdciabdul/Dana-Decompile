package androidx.window.core;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015B'\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0019J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\f\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\u0012\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0011\u0010\u0010\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0012\u0010\r"}, d2 = {"Landroidx/window/core/Bounds;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "I", "PlaceComponentResult", "()Z", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Landroid/graphics/Rect;", "<init>", "(Landroid/graphics/Rect;)V", "p1", "p2", "p3", "(IIII)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Bounds {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final int MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final int PlaceComponentResult;

    private Bounds(int i, int i2, int i3, int i4) {
        this.BuiltInFictitiousFunctionClassFactory = i;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
        this.MyBillsEntityDataFactory = i3;
        this.PlaceComponentResult = i4;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Bounds(Rect rect) {
        this(rect.left, rect.top, rect.right, rect.bottom);
        Intrinsics.checkNotNullParameter(rect, "");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) "Bounds");
        sb.append(" { [");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(',');
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(',');
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(',');
        sb.append(this.PlaceComponentResult);
        sb.append("] }");
        return sb.toString();
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (Intrinsics.areEqual(getClass(), p0 == null ? null : p0.getClass())) {
            if (p0 != null) {
                Bounds bounds = (Bounds) p0;
                return this.BuiltInFictitiousFunctionClassFactory == bounds.BuiltInFictitiousFunctionClassFactory && this.KClassImpl$Data$declaredNonStaticMembers$2 == bounds.KClassImpl$Data$declaredNonStaticMembers$2 && this.MyBillsEntityDataFactory == bounds.MyBillsEntityDataFactory && this.PlaceComponentResult == bounds.PlaceComponentResult;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.window.core.Bounds");
        }
        return false;
    }

    public final int hashCode() {
        int i = this.BuiltInFictitiousFunctionClassFactory;
        return (((((i * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2) * 31) + this.MyBillsEntityDataFactory) * 31) + this.PlaceComponentResult;
    }

    @JvmName(name = "getAuthRequestContext")
    public final boolean getAuthRequestContext() {
        return this.PlaceComponentResult - this.KClassImpl$Data$declaredNonStaticMembers$2 == 0 && this.MyBillsEntityDataFactory - this.BuiltInFictitiousFunctionClassFactory == 0;
    }
}
