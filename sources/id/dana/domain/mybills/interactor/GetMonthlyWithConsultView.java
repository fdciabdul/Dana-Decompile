package id.dana.domain.mybills.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.mybills.MyBillsRepository;
import id.dana.domain.mybills.model.MonthlyAmountAndHighlightRequest;
import id.dana.domain.mybills.model.MonthlyAmountWithConsultView;
import id.dana.domain.mybills.model.MyBillsHighlight;
import id.dana.domain.mybills.model.MyBillsHighlightRequestModel;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/domain/mybills/interactor/GetMonthlyWithConsultView;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/mybills/model/MonthlyAmountWithConsultView;", "Lid/dana/domain/mybills/model/MonthlyAmountAndHighlightRequest;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/mybills/model/MonthlyAmountAndHighlightRequest;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/MyBillsHighlight;", "consultView", "Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;", "monthlyAmount", "toMonthlyAmountWithConsultView", "(Lid/dana/domain/mybills/model/MyBillsHighlight;Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;)Lid/dana/domain/mybills/model/MonthlyAmountWithConsultView;", "Lid/dana/domain/mybills/MyBillsRepository;", "repository", "Lid/dana/domain/mybills/MyBillsRepository;", "<init>", "(Lid/dana/domain/mybills/MyBillsRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetMonthlyWithConsultView extends BaseUseCase<MonthlyAmountWithConsultView, MonthlyAmountAndHighlightRequest> {
    private final MyBillsRepository repository;

    @Inject
    public GetMonthlyWithConsultView(MyBillsRepository myBillsRepository) {
        Intrinsics.checkNotNullParameter(myBillsRepository, "");
        this.repository = myBillsRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<MonthlyAmountWithConsultView> buildUseCase(MonthlyAmountAndHighlightRequest params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable zipWith = this.repository.getMonthlyAmountSubscription(params.getIpRoleId(), params.getGoodsType(), params.getRecurringType()).zipWith(this.repository.getHighlightSubscription(new MyBillsHighlightRequestModel(params.getDivisionId(), params.getGoodsType(), params.getIpRoleId(), params.getMerchantId(), params.getNeedScheduleInfo(), params.getRecurringType(), false, params.getPageNum(), params.getPageSize(), 64, null)), new BiFunction() { // from class: id.dana.domain.mybills.interactor.GetMonthlyWithConsultView$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                MonthlyAmountWithConsultView m2370buildUseCase$lambda0;
                m2370buildUseCase$lambda0 = GetMonthlyWithConsultView.m2370buildUseCase$lambda0(GetMonthlyWithConsultView.this, (MyBillsMonthlyAmount) obj, (MyBillsHighlight) obj2);
                return m2370buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(zipWith, "");
        return zipWith;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final MonthlyAmountWithConsultView m2370buildUseCase$lambda0(GetMonthlyWithConsultView getMonthlyWithConsultView, MyBillsMonthlyAmount myBillsMonthlyAmount, MyBillsHighlight myBillsHighlight) {
        Intrinsics.checkNotNullParameter(getMonthlyWithConsultView, "");
        Intrinsics.checkNotNullParameter(myBillsMonthlyAmount, "");
        Intrinsics.checkNotNullParameter(myBillsHighlight, "");
        return getMonthlyWithConsultView.toMonthlyAmountWithConsultView(myBillsHighlight, myBillsMonthlyAmount);
    }

    private final MonthlyAmountWithConsultView toMonthlyAmountWithConsultView(MyBillsHighlight consultView, MyBillsMonthlyAmount monthlyAmount) {
        return new MonthlyAmountWithConsultView(monthlyAmount, consultView);
    }
}
