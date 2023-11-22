package id.dana.sendmoney.domain.groupsend.model.modify;

import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eBK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0019\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "PlaceComponentResult", "", "Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;", "getErrorConfigVersion", "Ljava/util/List;", "scheduleImpl", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupModifyRequest {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final String getAuthRequestContext;
    public final String MyBillsEntityDataFactory;
    public final String PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final List<ParticipantModify> scheduleImpl;

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof BizGroupModifyRequest) {
            BizGroupModifyRequest bizGroupModifyRequest = (BizGroupModifyRequest) p0;
            return Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, bizGroupModifyRequest.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, bizGroupModifyRequest.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, bizGroupModifyRequest.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.PlaceComponentResult, bizGroupModifyRequest.PlaceComponentResult) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, bizGroupModifyRequest.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.scheduleImpl, bizGroupModifyRequest.scheduleImpl);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.BuiltInFictitiousFunctionClassFactory.hashCode();
        int hashCode2 = this.getAuthRequestContext.hashCode();
        int hashCode3 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        String str = this.PlaceComponentResult;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.MyBillsEntityDataFactory;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        List<ParticipantModify> list = this.scheduleImpl;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupModifyRequest(BuiltInFictitiousFunctionClassFactory=");
        sb.append(this.BuiltInFictitiousFunctionClassFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", PlaceComponentResult=");
        sb.append(this.PlaceComponentResult);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", scheduleImpl=");
        sb.append(this.scheduleImpl);
        sb.append(')');
        return sb.toString();
    }

    private BizGroupModifyRequest(String str, String str2, String str3, String str4, String str5, List<ParticipantModify> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.getAuthRequestContext = str2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
        this.PlaceComponentResult = str4;
        this.MyBillsEntityDataFactory = str5;
        this.scheduleImpl = list;
    }

    public /* synthetic */ BizGroupModifyRequest(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "GROUP_TRANSFER" : str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007J#\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest$Companion;", "", "", "p0", "p1", "Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "MyBillsEntityDataFactory", "", "Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "(Ljava/lang/String;)Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static BizGroupModifyRequest MyBillsEntityDataFactory(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new BizGroupModifyRequest(null, p0, "GROUP_NAME", p1, null, null, 49, null);
        }

        public static BizGroupModifyRequest getAuthRequestContext(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new BizGroupModifyRequest(null, p0, CdpContentInfo.CONTENT_TYPE_IMAGE, null, p1, null, 41, null);
        }

        public static BizGroupModifyRequest PlaceComponentResult(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new BizGroupModifyRequest(null, p0, "REMOVE_GROUP", null, null, null, 57, null);
        }

        public static BizGroupModifyRequest PlaceComponentResult(String p0, List<ParticipantModify> p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new BizGroupModifyRequest(null, p0, "MODIFY_PARTICIPANT", null, null, p1, 25, null);
        }
    }
}
