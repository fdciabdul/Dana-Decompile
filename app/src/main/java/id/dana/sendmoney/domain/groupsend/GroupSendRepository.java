package id.dana.sendmoney.domain.groupsend;

import id.dana.sendmoney.domain.groupsend.interactor.ConfirmSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.interactor.InitSendMoneyGroup;
import id.dana.sendmoney.domain.groupsend.model.config.GroupSendScenarioConfig;
import id.dana.sendmoney.domain.groupsend.model.detail.BizGroupDetailResult;
import id.dana.sendmoney.domain.groupsend.model.init.SendMoneyGroupInit;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyRequest;
import id.dana.sendmoney.domain.groupsend.model.modify.BizGroupModifyResult;
import id.dana.sendmoney.domain.groupsend.model.query.BizGroupQueryResult;
import id.dana.sendmoney.domain.groupsend.model.submit.SendMoneyGroupConfirm;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004H&¢\u0006\u0004\b\f\u0010\nJ%\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\u0012\u0010\nJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H&¢\u0006\u0004\b\u0010\u0010\nJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0003\u001a\u00020\rH&¢\u0006\u0004\b\u0012\u0010\u0014J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u0004H&¢\u0006\u0004\b\u0006\u0010\nJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00180\u00042\u0006\u0010\u0003\u001a\u00020\u0017H&¢\u0006\u0004\b\u0006\u0010\u0019J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00042\u0006\u0010\u0003\u001a\u00020\u001aH&¢\u0006\u0004\b\t\u0010\u001cJ\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\u0012\u0010\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/domain/groupsend/GroupSendRepository;", "", "Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/groupsend/model/submit/SendMoneyGroupConfirm;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/domain/groupsend/interactor/ConfirmSendMoneyGroup$Param;)Lkotlinx/coroutines/flow/Flow;", "", "MyBillsEntityDataFactory", "()Lkotlinx/coroutines/flow/Flow;", "", "PlaceComponentResult", "", "p1", "Lid/dana/sendmoney/domain/groupsend/model/detail/BizGroupDetailResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "getAuthRequestContext", "Lid/dana/sendmoney/domain/groupsend/model/query/BizGroupQueryResult;", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/sendmoney/domain/groupsend/model/config/GroupSendScenarioConfig;", "Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup$Param;", "Lid/dana/sendmoney/domain/groupsend/model/init/SendMoneyGroupInit;", "(Lid/dana/sendmoney/domain/groupsend/interactor/InitSendMoneyGroup$Param;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;", "Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyResult;", "(Lid/dana/sendmoney/domain/groupsend/model/modify/BizGroupModifyRequest;)Lkotlinx/coroutines/flow/Flow;", "", "(I)Lkotlinx/coroutines/flow/Flow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface GroupSendRepository {
    Flow<List<GroupSendScenarioConfig>> BuiltInFictitiousFunctionClassFactory();

    Flow<SendMoneyGroupConfirm> BuiltInFictitiousFunctionClassFactory(ConfirmSendMoneyGroup.Param p0);

    Flow<SendMoneyGroupInit> BuiltInFictitiousFunctionClassFactory(InitSendMoneyGroup.Param p0);

    Flow<Integer> KClassImpl$Data$declaredNonStaticMembers$2();

    Flow<BizGroupDetailResult> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1);

    Flow<Integer> MyBillsEntityDataFactory();

    Flow<BizGroupModifyResult> MyBillsEntityDataFactory(BizGroupModifyRequest p0);

    Flow<Boolean> PlaceComponentResult();

    Flow<Integer> getAuthRequestContext();

    Flow<Unit> getAuthRequestContext(int p0);

    Flow<BizGroupQueryResult> getAuthRequestContext(String p0);
}
