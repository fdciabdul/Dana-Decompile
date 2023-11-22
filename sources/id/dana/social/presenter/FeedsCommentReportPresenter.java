package id.dana.social.presenter;

import id.dana.domain.core.usecase.NoParams;
import id.dana.feeds.domain.config.interactor.GetReportReasonsConfig;
import id.dana.feeds.domain.config.model.ReportReasons;
import id.dana.social.contract.FeedsCommentReportContract;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/presenter/FeedsCommentReportPresenter;", "Lid/dana/social/contract/FeedsCommentReportContract$Presenter;", "", "getAuthRequestContext", "()V", "onDestroy", "Lid/dana/feeds/domain/config/interactor/GetReportReasonsConfig;", "Lid/dana/feeds/domain/config/interactor/GetReportReasonsConfig;", "PlaceComponentResult", "Lid/dana/social/contract/FeedsCommentReportContract$View;", "MyBillsEntityDataFactory", "Lid/dana/social/contract/FeedsCommentReportContract$View;", "p0", "p1", "<init>", "(Lid/dana/social/contract/FeedsCommentReportContract$View;Lid/dana/feeds/domain/config/interactor/GetReportReasonsConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsCommentReportPresenter implements FeedsCommentReportContract.Presenter {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsCommentReportContract.View getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final GetReportReasonsConfig PlaceComponentResult;

    @Inject
    public FeedsCommentReportPresenter(FeedsCommentReportContract.View view, GetReportReasonsConfig getReportReasonsConfig) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getReportReasonsConfig, "");
        this.getAuthRequestContext = view;
        this.PlaceComponentResult = getReportReasonsConfig;
    }

    @Override // id.dana.social.contract.FeedsCommentReportContract.Presenter
    public final void getAuthRequestContext() {
        this.PlaceComponentResult.execute(NoParams.INSTANCE, new Function1<List<? extends ReportReasons>, Unit>() { // from class: id.dana.social.presenter.FeedsCommentReportPresenter$getReportReason$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends ReportReasons> list) {
                invoke2((List<ReportReasons>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<ReportReasons> list) {
                FeedsCommentReportContract.View view;
                FeedsCommentReportContract.View unused;
                Intrinsics.checkNotNullParameter(list, "");
                if ((!list.isEmpty()) != false) {
                    view = FeedsCommentReportPresenter.this.getAuthRequestContext;
                    view.getAuthRequestContext(list);
                    return;
                }
                unused = FeedsCommentReportPresenter.this.getAuthRequestContext;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.social.presenter.FeedsCommentReportPresenter$getReportReason$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                FeedsCommentReportContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = FeedsCommentReportPresenter.this.getAuthRequestContext;
                view.onError("");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_FEEDS_REPORT_REASON, th.getMessage(), th);
            }
        });
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.PlaceComponentResult.dispose();
    }
}
