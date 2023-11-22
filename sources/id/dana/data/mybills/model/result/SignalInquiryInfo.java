package id.dana.data.mybills.model.result;

import id.dana.domain.nearbyme.model.MoneyView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0013"}, d2 = {"Lid/dana/data/mybills/model/result/SignalInquiryInfo;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "Lid/dana/data/mybills/model/result/InquiryStatus;", "getAuthRequestContext", "Lid/dana/data/mybills/model/result/InquiryStatus;", "PlaceComponentResult", "Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/domain/nearbyme/model/MoneyView;", "p1", "p2", "<init>", "(Ljava/lang/String;Lid/dana/data/mybills/model/result/InquiryStatus;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SignalInquiryInfo {
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final MoneyView getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final InquiryStatus PlaceComponentResult;

    public SignalInquiryInfo() {
        this(null, null, null, 7, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof SignalInquiryInfo) {
            SignalInquiryInfo signalInquiryInfo = (SignalInquiryInfo) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, signalInquiryInfo.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.PlaceComponentResult, signalInquiryInfo.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, signalInquiryInfo.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.BuiltInFictitiousFunctionClassFactory;
        int hashCode = str == null ? 0 : str.hashCode();
        InquiryStatus inquiryStatus = this.PlaceComponentResult;
        int hashCode2 = inquiryStatus == null ? 0 : inquiryStatus.hashCode();
        MoneyView moneyView = this.getAuthRequestContext;
        return (((hashCode * 31) + hashCode2) * 31) + (moneyView != null ? moneyView.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalInquiryInfo(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    private SignalInquiryInfo(String str, InquiryStatus inquiryStatus, MoneyView moneyView) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.PlaceComponentResult = inquiryStatus;
        this.getAuthRequestContext = moneyView;
    }

    public /* synthetic */ SignalInquiryInfo(String str, InquiryStatus inquiryStatus, MoneyView moneyView, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : inquiryStatus, (i & 4) != 0 ? null : moneyView);
    }
}
