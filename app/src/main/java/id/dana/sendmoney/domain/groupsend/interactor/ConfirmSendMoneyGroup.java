package id.dana.sendmoney.domain.groupsend.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import id.dana.sendmoney.domain.groupsend.model.submit.ParticipantSubmit;
import id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;", "Lid/dana/sendmoney/domain/groupsend/model/submit/SendMoneyGroupConfirm;", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "PlaceComponentResult", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "p0", "<init>", "(Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;)V", "Param"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfirmSendMoneyGroup extends BaseFlowUseCase<Param, SendMoneyGroupConfirm> {
    private final GroupSendRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<SendMoneyGroupConfirm> buildUseCase(Param param) {
        Param param2 = param;
        Intrinsics.checkNotNullParameter(param2, "");
        return this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(param2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ConfirmSendMoneyGroup(id.dana.sendmoney.domain.groupsend.GroupSendRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.PlaceComponentResult = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.domain.groupsend.interactor.ConfirmSendMoneyGroup.<init>(id.dana.sendmoney.domain.groupsend.GroupSendRepository):void");
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\t¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0011\u0010\u0010\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0011\u0010\f\u001a\u00020\tX\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\tX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0015\u0010\r"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "", "Lid/dana/sendmoney/domain/groupsend/model/submit/ParticipantSubmit;", "MyBillsEntityDataFactory", "Ljava/util/List;", "scheduleImpl", "moveToNextValue", "p1", "p2", "p3", "p4", "p5", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class Param {
        public final String BuiltInFictitiousFunctionClassFactory;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public final String getAuthRequestContext;
        public final List<ParticipantSubmit> MyBillsEntityDataFactory;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public final String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final String PlaceComponentResult;

        /* renamed from: scheduleImpl  reason: from kotlin metadata */
        public String moveToNextValue;

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Param) {
                Param param = (Param) p0;
                return Intrinsics.areEqual(this.PlaceComponentResult, param.PlaceComponentResult) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, param.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.getAuthRequestContext, param.getAuthRequestContext) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, param.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, param.MyBillsEntityDataFactory) && Intrinsics.areEqual(this.moveToNextValue, param.moveToNextValue);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.PlaceComponentResult.hashCode();
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            return (((((((((hashCode * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.getAuthRequestContext.hashCode()) * 31) + this.BuiltInFictitiousFunctionClassFactory.hashCode()) * 31) + this.MyBillsEntityDataFactory.hashCode()) * 31) + this.moveToNextValue.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Param(PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(')');
            return sb.toString();
        }

        private Param(String str, String str2, String str3, String str4, List<ParticipantSubmit> list, String str5) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str3, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(list, "");
            Intrinsics.checkNotNullParameter(str5, "");
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = str2;
            this.getAuthRequestContext = str3;
            this.BuiltInFictitiousFunctionClassFactory = str4;
            this.MyBillsEntityDataFactory = list;
            this.moveToNextValue = str5;
        }

        public /* synthetic */ Param(String str, String str2, String str3, String str4, List list, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "GROUP_TRANSFER" : str, str2, str3, (i & 8) != 0 ? "" : str4, list, (i & 32) != 0 ? "" : str5);
        }
    }
}
