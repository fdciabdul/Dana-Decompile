package id.dana.utils;

import android.graphics.drawable.Drawable;
import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u0006\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010!\u001a\u00020\u0006\u0012\u0006\u0010\"\u001a\u00020\u001b\u0012\b\b\u0002\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0016X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0011\u0010\u001a\u001a\u00020\fX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0018\u001a\u00020\u001bX\u0006¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d"}, d2 = {"Lid/dana/utils/MarkerPayload;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lcom/google/android/gms/maps/model/LatLng;", "MyBillsEntityDataFactory", "()Lcom/google/android/gms/maps/model/LatLng;", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "getAuthRequestContext", "Landroid/location/Location;", "Landroid/location/Location;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "lookAheadTest", "Ljava/lang/String;", "getErrorConfigVersion", "", "NetworkUserEntityData$$ExternalSyntheticLambda0", LogConstants.RESULT_FALSE, "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Landroid/location/Location;Landroid/graphics/drawable/Drawable;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final /* data */ class MarkerPayload {
    public final int BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int PlaceComponentResult;
    public final Drawable MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final float lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final int getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Location KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof MarkerPayload) {
            MarkerPayload markerPayload = (MarkerPayload) p0;
            return Intrinsics.areEqual(this.getErrorConfigVersion, markerPayload.getErrorConfigVersion) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, markerPayload.KClassImpl$Data$declaredNonStaticMembers$2) && this.PlaceComponentResult == markerPayload.PlaceComponentResult && Intrinsics.areEqual(this.MyBillsEntityDataFactory, markerPayload.MyBillsEntityDataFactory) && this.getAuthRequestContext == markerPayload.getAuthRequestContext && Intrinsics.areEqual((Object) Float.valueOf(this.lookAheadTest), (Object) Float.valueOf(markerPayload.lookAheadTest)) && this.BuiltInFictitiousFunctionClassFactory == markerPayload.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.getErrorConfigVersion.hashCode();
        Location location = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode2 = location == null ? 0 : location.hashCode();
        int i = this.PlaceComponentResult;
        Drawable drawable = this.MyBillsEntityDataFactory;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + (drawable != null ? drawable.hashCode() : 0)) * 31) + this.getAuthRequestContext) * 31) + Float.floatToIntBits(this.lookAheadTest)) * 31) + this.BuiltInFictitiousFunctionClassFactory;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MarkerPayload(getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", lookAheadTest=");
        sb.append(this.lookAheadTest);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public MarkerPayload(String str, Location location, Drawable drawable) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getErrorConfigVersion = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = location;
        this.PlaceComponentResult = id.dana.R.layout.view_promo_marker;
        this.MyBillsEntityDataFactory = drawable;
        this.getAuthRequestContext = id.dana.R.id.iv_promo_marker_loadable;
        this.lookAheadTest = 0.1f;
        this.BuiltInFictitiousFunctionClassFactory = id.dana.R.drawable.ic_img_merchant_promo;
    }

    public final LatLng MyBillsEntityDataFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            return new LatLng(this.KClassImpl$Data$declaredNonStaticMembers$2.getLatitude(), this.KClassImpl$Data$declaredNonStaticMembers$2.getLongitude());
        }
        LatLng KClassImpl$Data$declaredNonStaticMembers$2 = LocationUtil.KClassImpl$Data$declaredNonStaticMembers$2();
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
