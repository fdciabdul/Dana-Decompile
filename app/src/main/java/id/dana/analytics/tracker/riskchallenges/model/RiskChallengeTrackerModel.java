package id.dana.analytics.tracker.riskchallenges.model;

import id.dana.analytics.tracker.TrackerKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u001d\b\u0004\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0002X\u0016¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0003\u001a\u00020\u0002X\u0016¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u0082\u0001\u0002\r\u000e"}, d2 = {"Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel;", "", "", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "p0", "p1", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "RiskChallengeCompleteModel", "RiskChallengeOpenModel", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public abstract class RiskChallengeTrackerModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    public /* synthetic */ RiskChallengeTrackerModel(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private RiskChallengeTrackerModel(@TrackerKey.RiskChallenge.Source String str, @TrackerKey.RiskChallenge.Type String str2) {
        this.BuiltInFictitiousFunctionClassFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0001\u0010\u0003\u001a\u00020\n\u0012\b\b\u0001\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\n\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0011\u0010\r\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0014\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0018\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0017"}, d2 = {"Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeOpenModel;", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda0", "MyBillsEntityDataFactory", "moveToNextValue", "Z", "()Z", "lookAheadTest", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class RiskChallengeOpenModel extends RiskChallengeTrackerModel {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String BuiltInFictitiousFunctionClassFactory;
        public final String getAuthRequestContext;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        private final boolean lookAheadTest;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        public /* synthetic */ RiskChallengeOpenModel(String str, String str2, String str3, boolean z, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, z, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
        }

        @JvmName(name = "getAuthRequestContext")
        /* renamed from: getAuthRequestContext  reason: from getter */
        public final boolean getLookAheadTest() {
            return this.lookAheadTest;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RiskChallengeOpenModel(@TrackerKey.RiskChallenge.Source String str, @TrackerKey.RiskChallenge.Type String str2, String str3, boolean z, String str4, String str5) {
            super(str, str2, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.MyBillsEntityDataFactory = str;
            this.PlaceComponentResult = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.lookAheadTest = z;
            this.getAuthRequestContext = str4;
            this.BuiltInFictitiousFunctionClassFactory = str5;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof RiskChallengeOpenModel) {
                RiskChallengeOpenModel riskChallengeOpenModel = (RiskChallengeOpenModel) p0;
                return Intrinsics.areEqual(this.MyBillsEntityDataFactory, riskChallengeOpenModel.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, riskChallengeOpenModel.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, riskChallengeOpenModel.KClassImpl$Data$declaredNonStaticMembers$2) && this.lookAheadTest == riskChallengeOpenModel.lookAheadTest && Intrinsics.areEqual(this.getAuthRequestContext, riskChallengeOpenModel.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, riskChallengeOpenModel.BuiltInFictitiousFunctionClassFactory);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.MyBillsEntityDataFactory.hashCode();
            int hashCode2 = this.PlaceComponentResult.hashCode();
            int hashCode3 = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            boolean z = this.lookAheadTest;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            String str = this.getAuthRequestContext;
            int hashCode4 = str == null ? 0 : str.hashCode();
            String str2 = this.BuiltInFictitiousFunctionClassFactory;
            return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RiskChallengeOpenModel(MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(')');
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0001\u0010\u0003\u001a\u00020\n\u0012\b\b\u0001\u0010\u001b\u001a\u00020\n\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\"\u0010#J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\u000f\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0017\u001a\u00020\nX\u0016¢\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u000f\u0010\u001aR\u001a\u0010\u0018\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0019\u001a\u0004\b\u0011\u0010\u001a"}, d2 = {"Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel$RiskChallengeCompleteModel;", "Lid/dana/analytics/tracker/riskchallenges/model/RiskChallengeTrackerModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "I", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "scheduleImpl", "getErrorConfigVersion", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "lookAheadTest", "Z", "()Z", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZIILjava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class RiskChallengeCompleteModel extends RiskChallengeTrackerModel {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final int BuiltInFictitiousFunctionClassFactory;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        private final boolean lookAheadTest;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String MyBillsEntityDataFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final int PlaceComponentResult;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        private final boolean scheduleImpl;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        public /* synthetic */ RiskChallengeCompleteModel(String str, String str2, boolean z, boolean z2, int i, int i2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, z, z2, i, i2, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? null : str4);
        }

        @JvmName(name = "PlaceComponentResult")
        /* renamed from: PlaceComponentResult  reason: from getter */
        public final boolean getScheduleImpl() {
            return this.scheduleImpl;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getLookAheadTest() {
            return this.lookAheadTest;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RiskChallengeCompleteModel(@TrackerKey.RiskChallenge.Source String str, @TrackerKey.RiskChallenge.Type String str2, boolean z, boolean z2, int i, int i2, String str3, String str4) {
            super(str, str2, null);
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str;
            this.MyBillsEntityDataFactory = str2;
            this.scheduleImpl = z;
            this.lookAheadTest = z2;
            this.PlaceComponentResult = i;
            this.BuiltInFictitiousFunctionClassFactory = i2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str3;
            this.getAuthRequestContext = str4;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof RiskChallengeCompleteModel) {
                RiskChallengeCompleteModel riskChallengeCompleteModel = (RiskChallengeCompleteModel) p0;
                return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, riskChallengeCompleteModel.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, riskChallengeCompleteModel.MyBillsEntityDataFactory) && this.scheduleImpl == riskChallengeCompleteModel.scheduleImpl && this.lookAheadTest == riskChallengeCompleteModel.lookAheadTest && this.PlaceComponentResult == riskChallengeCompleteModel.PlaceComponentResult && this.BuiltInFictitiousFunctionClassFactory == riskChallengeCompleteModel.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, riskChallengeCompleteModel.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, riskChallengeCompleteModel.getAuthRequestContext);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int hashCode = this.NetworkUserEntityData$$ExternalSyntheticLambda0.hashCode();
            int hashCode2 = this.MyBillsEntityDataFactory.hashCode();
            boolean z = this.scheduleImpl;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            boolean z2 = this.lookAheadTest;
            int i2 = z2 ? 1 : z2 ? 1 : 0;
            int i3 = this.PlaceComponentResult;
            int i4 = this.BuiltInFictitiousFunctionClassFactory;
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode3 = str == null ? 0 : str.hashCode();
            String str2 = this.getAuthRequestContext;
            return (((((((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + hashCode3) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("RiskChallengeCompleteModel(NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", scheduleImpl=");
            sb.append(this.scheduleImpl);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }
    }
}
