package id.dana.sendmoney.domain.groupsend.model.modify;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantInfoModify;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantInfoModify;", "MyBillsEntityDataFactory", "p1", "p2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantInfoModify;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantModify {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;
    public final String MyBillsEntityDataFactory;
    public final ParticipantInfoModify getAuthRequestContext;

    public ParticipantModify() {
        this(null, null, null, 7, null);
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        if (p0 instanceof ParticipantModify) {
            ParticipantModify participantModify = (ParticipantModify) p0;
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, participantModify.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, participantModify.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.getAuthRequestContext, participantModify.getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.MyBillsEntityDataFactory;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        ParticipantInfoModify participantInfoModify = this.getAuthRequestContext;
        return (((hashCode * 31) + hashCode2) * 31) + (participantInfoModify != null ? participantInfoModify.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantModify(KClassImpl$Data$declaredNonStaticMembers$2=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
        sb.append(", MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(", getAuthRequestContext=");
        sb.append(this.getAuthRequestContext);
        sb.append(')');
        return sb.toString();
    }

    private ParticipantModify(String str, String str2, ParticipantInfoModify participantInfoModify) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.MyBillsEntityDataFactory = str2;
        this.getAuthRequestContext = participantInfoModify;
    }

    public /* synthetic */ ParticipantModify(String str, String str2, ParticipantInfoModify participantInfoModify, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : participantInfoModify);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify$Companion;", "", "", "p0", "p1", "Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;", "getAuthRequestContext", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lid/dana/sendmoney/domain/groupsend/model/modify/ParticipantModify;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ParticipantModify MyBillsEntityDataFactory(String p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            return new ParticipantModify(p0, null, null, 6, null);
        }

        public static ParticipantModify getAuthRequestContext(String p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return new ParticipantModify(null, "BALANCE", new ParticipantInfoModify(p0, p1), 1, null);
        }
    }
}
