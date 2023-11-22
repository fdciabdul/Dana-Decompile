package id.dana.biometric.domain.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import androidx.fragment.app.FragmentActivity;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010!\u001a\u00020\u0014¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0013\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0011\u0010\f\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0015R\u0012\u0010\u0019\u001a\u00020\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018"}, d2 = {"Lid/dana/biometric/domain/model/RiskEventMapper;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroidx/fragment/app/FragmentActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/fragment/app/FragmentActivity;", "getAuthRequestContext", "PlaceComponentResult", "", "J", "", "lookAheadTest", LogConstants.RESULT_FALSE, "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFLandroidx/fragment/app/FragmentActivity;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RiskEventMapper {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;
    public final FragmentActivity KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public float scheduleImpl;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final long BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public float moveToNextValue;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof RiskEventMapper) {
            RiskEventMapper riskEventMapper = (RiskEventMapper) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, riskEventMapper.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, riskEventMapper.getAuthRequestContext) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, riskEventMapper.MyBillsEntityDataFactory) && Intrinsics.areEqual((Object) Float.valueOf(this.moveToNextValue), (Object) Float.valueOf(riskEventMapper.moveToNextValue)) && Intrinsics.areEqual((Object) Float.valueOf(this.scheduleImpl), (Object) Float.valueOf(riskEventMapper.scheduleImpl)) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, riskEventMapper.KClassImpl$Data$declaredNonStaticMembers$2) && this.BuiltInFictitiousFunctionClassFactory == riskEventMapper.BuiltInFictitiousFunctionClassFactory;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int hashCode3 = this.MyBillsEntityDataFactory.hashCode();
        int floatToIntBits = Float.floatToIntBits(this.moveToNextValue);
        int floatToIntBits2 = Float.floatToIntBits(this.scheduleImpl);
        FragmentActivity fragmentActivity = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + floatToIntBits) * 31) + floatToIntBits2) * 31) + (fragmentActivity == null ? 0 : fragmentActivity.hashCode())) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.BuiltInFictitiousFunctionClassFactory);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RiskEventMapper(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", moveToNextValue=");
        sb.append(this.moveToNextValue);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(')');
        return sb.toString();
    }

    public RiskEventMapper(String str, String str2, String str3, float f, float f2, FragmentActivity fragmentActivity, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = str2;
        this.MyBillsEntityDataFactory = str3;
        this.moveToNextValue = f;
        this.scheduleImpl = f2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = fragmentActivity;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }
}
