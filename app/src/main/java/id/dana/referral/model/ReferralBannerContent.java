package id.dana.referral.model;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\t\u0012\b\b\u0002\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\fX\u0086\u0002¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0012\u0010\r\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0010\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0012\u0010\u0013\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0012\u0010\u0015\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0012\u0010\u0017\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0011"}, d2 = {"Lid/dana/referral/model/ReferralBannerContent;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/util/Date;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/Date;", "MyBillsEntityDataFactory", "PlaceComponentResult", "Ljava/lang/String;", "getAuthRequestContext", "BuiltInFictitiousFunctionClassFactory", "moveToNextValue", "scheduleImpl", "lookAheadTest", "getErrorConfigVersion", "p1", "p2", "p3", "p4", "p5", "p6", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ReferralBannerContent {
    public String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public Date MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public String PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;
    public String getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public String getErrorConfigVersion;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String scheduleImpl;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ReferralBannerContent) {
            ReferralBannerContent referralBannerContent = (ReferralBannerContent) p0;
            return Intrinsics.areEqual(this.PlaceComponentResult, referralBannerContent.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, referralBannerContent.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, referralBannerContent.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.scheduleImpl, referralBannerContent.scheduleImpl) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, referralBannerContent.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, referralBannerContent.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getErrorConfigVersion, referralBannerContent.getErrorConfigVersion);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.PlaceComponentResult.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int hashCode3 = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode4 = this.scheduleImpl.hashCode();
        Date date = this.MyBillsEntityDataFactory;
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (date == null ? 0 : date.hashCode())) * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode()) * 31) + this.getErrorConfigVersion.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ReferralBannerContent(PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", getErrorConfigVersion=");
        sb.append(this.getErrorConfigVersion);
        sb.append(')');
        return sb.toString();
    }

    public ReferralBannerContent(String str, String str2, String str3, String str4, Date date, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.PlaceComponentResult = str;
        this.getAuthRequestContext = str2;
        this.BuiltInFictitiousFunctionClassFactory = str3;
        this.scheduleImpl = str4;
        this.MyBillsEntityDataFactory = date;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str5;
        this.getErrorConfigVersion = str6;
    }
}
