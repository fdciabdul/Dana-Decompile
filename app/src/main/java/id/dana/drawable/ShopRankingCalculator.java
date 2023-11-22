package id.dana.drawable;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.nearbyme.model.ShopModel;
import id.dana.sendmoney.summary.SummaryActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0005\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u000eR\u0012\u0010\t\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0012\u0010\u0005\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0012\u0010\u0013\u001a\u00020\u0010X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0007\u001a\u00020\bX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u000f"}, d2 = {"Lid/dana/nearbyrevamp/ShopRankingCalculator;", "", "Lid/dana/nearbyme/model/ShopModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/nearbyme/model/ShopModel;)I", "getAuthRequestContext", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/nearbyme/model/ShopModel;)D", "p1", "p2", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", SummaryActivity.DAYS, "", "PlaceComponentResult", "Z", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShopRankingCalculator {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public double KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public double BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean MyBillsEntityDataFactory;
    public double getAuthRequestContext;

    @Inject
    public ShopRankingCalculator() {
    }

    public final void BuiltInFictitiousFunctionClassFactory(Integer p0, Integer p1, Integer p2) {
        if (p0 != null) {
            double intValue = p0.intValue();
            Double.isNaN(intValue);
            this.BuiltInFictitiousFunctionClassFactory = intValue / 100.0d;
        }
        if (p1 != null) {
            double intValue2 = p1.intValue();
            Double.isNaN(intValue2);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = intValue2 / 100.0d;
        }
        if (p2 != null) {
            double intValue3 = p2.intValue();
            Double.isNaN(intValue3);
            this.getAuthRequestContext = intValue3 / 100.0d;
        }
    }

    public final double KClassImpl$Data$declaredNonStaticMembers$2(ShopModel p0) {
        double ceil;
        Intrinsics.checkNotNullParameter(p0, "");
        double d = this.BuiltInFictitiousFunctionClassFactory;
        double BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(p0);
        double d2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (!this.MyBillsEntityDataFactory) {
            ceil = Math.ceil(p0.readMicros);
        } else {
            ceil = p0.readMicros;
        }
        double d3 = this.getAuthRequestContext;
        double authRequestContext = getAuthRequestContext(p0);
        Double.isNaN(BuiltInFictitiousFunctionClassFactory);
        Double.isNaN(authRequestContext);
        return (d * BuiltInFictitiousFunctionClassFactory) + (d2 * ceil) + (d3 * authRequestContext);
    }

    private final int BuiltInFictitiousFunctionClassFactory(ShopModel p0) {
        boolean z = false;
        if (this.MyBillsEntityDataFactory) {
            double d = p0.getErrorConfigVersion;
            if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE <= d && d <= 1.0d) {
                return 5;
            }
            if (1.1d <= d && d <= 2.0d) {
                return 4;
            }
            if (2.1d <= d && d <= 3.0d) {
                return 3;
            }
            if (3.1d <= d && d <= 4.0d) {
                z = true;
            }
            return !z ? 1 : 2;
        }
        double d2 = p0.getErrorConfigVersion;
        if (FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE <= d2 && d2 <= 0.6d) {
            return 5;
        }
        if (0.7d <= d2 && d2 <= 1.2d) {
            return 4;
        }
        if (1.3d <= d2 && d2 <= 1.8d) {
            return 3;
        }
        if (1.9d <= d2 && d2 <= 2.4d) {
            z = true;
        }
        return !z ? 1 : 2;
    }

    private static int getAuthRequestContext(ShopModel p0) {
        double d = p0.SubSequence;
        if (d > 25.0d) {
            return 5;
        }
        boolean z = false;
        if (21.0d <= d && d <= 25.0d) {
            return 4;
        }
        if (16.0d <= d && d <= 20.0d) {
            return 3;
        }
        if (11.0d <= d && d <= 15.0d) {
            z = true;
        }
        return z ? 2 : 1;
    }
}
