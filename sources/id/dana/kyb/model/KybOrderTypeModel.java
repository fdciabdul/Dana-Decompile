package id.dana.kyb.model;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/kyb/model/KybOrderTypeModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Integer;", "p1", "p2", "<init>", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybOrderTypeModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Integer PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Drawable BuiltInFictitiousFunctionClassFactory;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof KybOrderTypeModel) {
            KybOrderTypeModel kybOrderTypeModel = (KybOrderTypeModel) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, kybOrderTypeModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, kybOrderTypeModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, kybOrderTypeModel.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.getAuthRequestContext.hashCode();
        Drawable drawable = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = drawable == null ? 0 : drawable.hashCode();
        Integer num = this.PlaceComponentResult;
        return (((hashCode * 31) + hashCode2) * 31) + (num != null ? num.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybOrderTypeModel(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    public KybOrderTypeModel(String str, Drawable drawable, Integer num) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getAuthRequestContext = str;
        this.BuiltInFictitiousFunctionClassFactory = drawable;
        this.PlaceComponentResult = num;
    }
}
