package id.dana.biometric.presentation;

import id.dana.biometric.domain.model.RiskTrackerConfig;
import id.dana.biometric.domain.model.RiskType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/biometric/presentation/RiskTrackerState;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/biometric/domain/model/RiskTrackerConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/biometric/domain/model/RiskTrackerConfig;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "Lid/dana/biometric/domain/model/RiskType;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "p1", "p2", "<init>", "(Lid/dana/biometric/domain/model/RiskTrackerConfig;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RiskTrackerState {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    RiskTrackerConfig getAuthRequestContext;
    Function1<? super RiskType, Unit> PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    String BuiltInFictitiousFunctionClassFactory;

    public RiskTrackerState() {
        this(null, null, null, 7, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RiskTrackerState) {
            RiskTrackerState riskTrackerState = (RiskTrackerState) p0;
            return Intrinsics.areEqual(this.getAuthRequestContext, riskTrackerState.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, riskTrackerState.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, riskTrackerState.PlaceComponentResult);
        }
        return false;
    }

    public final int hashCode() {
        RiskTrackerConfig riskTrackerConfig = this.getAuthRequestContext;
        int hashCode = riskTrackerConfig == null ? 0 : riskTrackerConfig.hashCode();
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode2 = str == null ? 0 : str.hashCode();
        Function1<? super RiskType, Unit> function1 = this.PlaceComponentResult;
        return (((hashCode * 31) + hashCode2) * 31) + (function1 != null ? function1.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskTrackerState(getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(')');
        return sb.toString();
    }

    private RiskTrackerState(RiskTrackerConfig riskTrackerConfig, String str, Function1<? super RiskType, Unit> function1) {
        this.getAuthRequestContext = riskTrackerConfig;
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = function1;
    }

    public /* synthetic */ RiskTrackerState(RiskTrackerConfig riskTrackerConfig, String str, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : riskTrackerConfig, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : function1);
    }

    public static /* synthetic */ RiskTrackerState getAuthRequestContext(RiskTrackerState riskTrackerState, RiskTrackerConfig riskTrackerConfig, String str, Function1 function1, int i) {
        if ((i & 1) != 0) {
            riskTrackerConfig = riskTrackerState.getAuthRequestContext;
        }
        if ((i & 2) != 0) {
            str = riskTrackerState.BuiltInFictitiousFunctionClassFactory;
        }
        if ((i & 4) != 0) {
            function1 = riskTrackerState.PlaceComponentResult;
        }
        return new RiskTrackerState(riskTrackerConfig, str, function1);
    }
}
