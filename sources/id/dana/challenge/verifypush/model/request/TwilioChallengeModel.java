package id.dana.challenge.verifypush.model.request;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\f\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001d\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\fX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\r\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011"}, d2 = {"Lid/dana/challenge/verifypush/model/request/TwilioChallengeModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "PlaceComponentResult", "Ljava/util/Map;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "getAuthRequestContext", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TwilioChallengeModel {
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Map<String, String> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    public TwilioChallengeModel() {
        this(null, null, null, 7, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof TwilioChallengeModel) {
            TwilioChallengeModel twilioChallengeModel = (TwilioChallengeModel) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, twilioChallengeModel.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, twilioChallengeModel.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, twilioChallengeModel.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int hashCode2 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TwilioChallengeModel(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    public TwilioChallengeModel(String str, Map<String, String> map, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(map, "");
        this.PlaceComponentResult = str;
        this.BuiltInFictitiousFunctionClassFactory = map;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
    }

    public /* synthetic */ TwilioChallengeModel(String str, Map map, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? null : str2);
    }
}
