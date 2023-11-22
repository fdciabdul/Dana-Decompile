package id.dana.geofence.model;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\f\u0012\b\b\u0002\u0010\u0019\u001a\u00020\f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0012\u001a\u00020\fX\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0013\u0010\r\u001a\u00020\fX\u0086\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0016"}, d2 = {"Lid/dana/geofence/model/PoiModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "BuiltInFictitiousFunctionClassFactory", SummaryActivity.DAYS, "PlaceComponentResult", "MyBillsEntityDataFactory", "Lkotlin/Lazy;", "getAuthRequestContext", "scheduleImpl", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "I", "getErrorConfigVersion", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;DDI)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PoiModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final double PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final int getErrorConfigVersion;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final Lazy getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private final double KClassImpl$Data$declaredNonStaticMembers$2;

    public PoiModel() {
        this(null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, 15, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof PoiModel) {
            PoiModel poiModel = (PoiModel) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, poiModel.MyBillsEntityDataFactory) && Intrinsics.areEqual((Object) Double.valueOf(this.PlaceComponentResult), (Object) Double.valueOf(poiModel.PlaceComponentResult)) && Intrinsics.areEqual((Object) Double.valueOf(this.KClassImpl$Data$declaredNonStaticMembers$2), (Object) Double.valueOf(poiModel.KClassImpl$Data$declaredNonStaticMembers$2)) && this.getErrorConfigVersion == poiModel.getErrorConfigVersion;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.MyBillsEntityDataFactory.hashCode() * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.PlaceComponentResult)) * 31) + BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.KClassImpl$Data$declaredNonStaticMembers$2)) * 31) + this.getErrorConfigVersion;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PoiModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(')');
        return sb.toString();
    }

    public PoiModel(String str, double d, double d2, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory = str;
        this.PlaceComponentResult = d;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = d2;
        this.getErrorConfigVersion = i;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<Double>() { // from class: id.dana.geofence.model.PoiModel$latitude$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                double d3;
                double d4;
                double d5;
                double d6;
                d3 = PoiModel.this.PlaceComponentResult;
                if (d3 >= -90.0d) {
                    d6 = PoiModel.this.PlaceComponentResult;
                    if (90.0d >= d6) {
                        d5 = PoiModel.this.PlaceComponentResult;
                        return Double.valueOf(d5);
                    }
                }
                d4 = PoiModel.this.PlaceComponentResult;
                d5 = d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -89.0d : 89.0d;
                return Double.valueOf(d5);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Double>() { // from class: id.dana.geofence.model.PoiModel$longitude$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Double invoke() {
                double d3;
                double d4;
                double d5;
                double d6;
                d3 = PoiModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (d3 >= -180.0d) {
                    d6 = PoiModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    if (180.0d >= d6) {
                        d5 = PoiModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                        return Double.valueOf(d5);
                    }
                }
                d4 = PoiModel.this.KClassImpl$Data$declaredNonStaticMembers$2;
                d5 = d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? -179.0d : 179.0d;
                return Double.valueOf(d5);
            }
        });
    }

    public /* synthetic */ PoiModel(String str, double d, double d2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0.0d : d, (i2 & 4) == 0 ? d2 : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, (i2 & 8) != 0 ? 100 : i);
    }
}
