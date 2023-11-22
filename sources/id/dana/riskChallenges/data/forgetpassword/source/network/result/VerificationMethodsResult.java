package id.dana.riskChallenges.data.forgetpassword.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0087\u0002¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010"}, d2 = {"Lid/dana/riskChallenges/data/forgetpassword/source/network/result/VerificationMethodsResult;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/Integer;", "MyBillsEntityDataFactory", "PlaceComponentResult", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class VerificationMethodsResult {
    @SerializedName("verificationMethodCode")
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    @SerializedName(CashierKeyParams.VERIFICATION_METHOD)

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String getAuthRequestContext;
    @SerializedName("priority")

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public Integer MyBillsEntityDataFactory;

    public VerificationMethodsResult() {
        this(null, null, null, 7, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof VerificationMethodsResult) {
            VerificationMethodsResult verificationMethodsResult = (VerificationMethodsResult) p0;
            return Intrinsics.areEqual(this.MyBillsEntityDataFactory, verificationMethodsResult.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, verificationMethodsResult.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, verificationMethodsResult.KClassImpl$Data$declaredNonStaticMembers$2);
        }
        return false;
    }

    public final int hashCode() {
        Integer num = this.MyBillsEntityDataFactory;
        int hashCode = num == null ? 0 : num.hashCode();
        String str = this.getAuthRequestContext;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        return (((hashCode * 31) + hashCode2) * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerificationMethodsResult(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(')');
        return sb.toString();
    }

    private VerificationMethodsResult(Integer num, String str, String str2) {
        this.MyBillsEntityDataFactory = num;
        this.getAuthRequestContext = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
    }

    public /* synthetic */ VerificationMethodsResult(Integer num, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }
}
