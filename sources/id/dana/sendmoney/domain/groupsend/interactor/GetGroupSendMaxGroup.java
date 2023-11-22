package id.dana.sendmoney.domain.groupsend.interactor;

import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.sendmoney.domain.groupsend.GroupSendRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/interactor/GetGroupSendMaxGroup;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetGroupSendMaxGroup extends BaseFlowUseCase<NoParams, Integer> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final GroupSendRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<Integer> buildUseCase(NoParams noParams) {
        Intrinsics.checkNotNullParameter(noParams, "");
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetGroupSendMaxGroup(id.dana.sendmoney.domain.groupsend.GroupSendRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney.domain.groupsend.interactor.GetGroupSendMaxGroup.<init>(id.dana.sendmoney.domain.groupsend.GroupSendRepository):void");
    }
}
