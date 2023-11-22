package id.dana.riskChallenges.domain.passkey.model;

import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony;", "", "<init>", "()V", "Params", "Type"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyCeremony {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0006¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0016\u001a\u00020\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\u0015"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Params;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "getAuthRequestContext", "()Z", "", "toString", "()Ljava/lang/String;", "Lcom/alibaba/fastjson/JSONObject;", "Lcom/alibaba/fastjson/JSONObject;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "PlaceComponentResult", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "p2", "p3", "<init>", "(Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;Lcom/alibaba/fastjson/JSONObject;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Params {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public final Type KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String getAuthRequestContext;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final JSONObject MyBillsEntityDataFactory;

        public Params() {
            this(null, null, null, null, 15, null);
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Params) {
                Params params = (Params) p0;
                return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, params.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, params.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.PlaceComponentResult, params.PlaceComponentResult) && Intrinsics.areEqual(this.getAuthRequestContext, params.getAuthRequestContext);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
            JSONObject jSONObject = this.MyBillsEntityDataFactory;
            int hashCode2 = jSONObject == null ? 0 : jSONObject.hashCode();
            String str = this.PlaceComponentResult;
            int hashCode3 = str == null ? 0 : str.hashCode();
            String str2 = this.getAuthRequestContext;
            return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(')');
            return sb.toString();
        }

        private Params(Type type, JSONObject jSONObject, String str, String str2) {
            Intrinsics.checkNotNullParameter(type, "");
            this.KClassImpl$Data$declaredNonStaticMembers$2 = type;
            this.MyBillsEntityDataFactory = jSONObject;
            this.PlaceComponentResult = str;
            this.getAuthRequestContext = str2;
        }

        public /* synthetic */ Params(Type.Registration registration, JSONObject jSONObject, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Type.Registration.INSTANCE : registration, (i & 2) != 0 ? null : jSONObject, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2);
        }

        public final boolean getAuthRequestContext() {
            return Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, Type.Registration.INSTANCE);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;", "", "Authentication", "Registration", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type$Registration;", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type$Authentication;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Type {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type$Registration;", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Registration implements Type {
            public static final Registration INSTANCE = new Registration();

            private Registration() {
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type$Authentication;", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Type;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class Authentication implements Type {
            public static final Authentication INSTANCE = new Authentication();

            private Authentication() {
            }
        }
    }
}
