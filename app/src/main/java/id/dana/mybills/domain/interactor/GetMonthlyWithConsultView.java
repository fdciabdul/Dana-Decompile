package id.dana.mybills.domain.interactor;

import id.dana.analytics.executiontime.TrackerExecutionCounter;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.mybills.domain.MyBillsRepository;
import id.dana.mybills.domain.model.MonthlyAmountAndHighlightRequest;
import id.dana.mybills.domain.model.MonthlyAmountWithConsultView;
import id.dana.mybills.domain.model.MyBillsHighlight;
import id.dana.mybills.domain.model.MyBillsHighlightRequestModel;
import id.dana.mybills.domain.model.MyBillsMonthlyAmount;
import id.dana.mybills.ui.model.MonthlyHighlightBillModelKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/mybills/domain/interactor/GetMonthlyWithConsultView;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/mybills/domain/model/MonthlyAmountAndHighlightRequest;", "Lid/dana/mybills/domain/model/MonthlyAmountWithConsultView;", "Lid/dana/mybills/domain/MyBillsRepository;", "MyBillsEntityDataFactory", "Lid/dana/mybills/domain/MyBillsRepository;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "getAuthRequestContext", "Lid/dana/analytics/executiontime/TrackerExecutionCounter;", "p0", "<init>", "(Lid/dana/mybills/domain/MyBillsRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMonthlyWithConsultView extends BaseFlowUseCase<MonthlyAmountAndHighlightRequest, MonthlyAmountWithConsultView> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final MyBillsRepository BuiltInFictitiousFunctionClassFactory;
    private final TrackerExecutionCounter getAuthRequestContext;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<MonthlyAmountWithConsultView> buildUseCase(MonthlyAmountAndHighlightRequest monthlyAmountAndHighlightRequest) {
        MonthlyAmountAndHighlightRequest monthlyAmountAndHighlightRequest2 = monthlyAmountAndHighlightRequest;
        Intrinsics.checkNotNullParameter(monthlyAmountAndHighlightRequest2, "");
        this.getAuthRequestContext.initiateStartTime();
        return FlowKt.zip(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(monthlyAmountAndHighlightRequest2.getIpRoleId(), monthlyAmountAndHighlightRequest2.getGoodsType(), monthlyAmountAndHighlightRequest2.getRecurringType()), this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory(new MyBillsHighlightRequestModel(monthlyAmountAndHighlightRequest2.getDivisionId(), monthlyAmountAndHighlightRequest2.getGoodsType(), monthlyAmountAndHighlightRequest2.getIpRoleId(), monthlyAmountAndHighlightRequest2.getMerchantId(), monthlyAmountAndHighlightRequest2.getNeedScheduleInfo(), monthlyAmountAndHighlightRequest2.getRecurringType(), false, monthlyAmountAndHighlightRequest2.getPageNum(), monthlyAmountAndHighlightRequest2.getPageSize(), monthlyAmountAndHighlightRequest2.getDueType(), 64, null)), new GetMonthlyWithConsultView$buildUseCase$1(this, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetMonthlyWithConsultView(id.dana.mybills.domain.MyBillsRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.BuiltInFictitiousFunctionClassFactory = r3
            id.dana.analytics.executiontime.TrackerExecutionCounter r3 = new id.dana.analytics.executiontime.TrackerExecutionCounter
            r3.<init>()
            r2.getAuthRequestContext = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.domain.interactor.GetMonthlyWithConsultView.<init>(id.dana.mybills.domain.MyBillsRepository):void");
    }

    public static final /* synthetic */ MonthlyAmountWithConsultView PlaceComponentResult(MyBillsHighlight myBillsHighlight, MyBillsMonthlyAmount myBillsMonthlyAmount) {
        return new MonthlyAmountWithConsultView(myBillsMonthlyAmount, MonthlyHighlightBillModelKt.toMonthlyHighlightBillModel(myBillsHighlight));
    }
}
