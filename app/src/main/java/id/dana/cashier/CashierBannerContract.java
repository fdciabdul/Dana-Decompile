package id.dana.cashier;

import id.dana.base.AbstractContractKt;
import id.dana.cashier.model.FetchBannerModel;
import id.dana.cashier.model.FetchBannerRequestModel;
import id.dana.cashier.model.npssurvey.NpsSurveyModel;
import id.dana.cashier.model.npssurvey.NpsSurveyRequestModel;
import id.dana.cashier.model.npssurvey.NpsSurveySubmitRequestModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierBannerContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface CashierBannerContract {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierBannerContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "Lid/dana/cashier/model/FetchBannerRequestModel;", "p0", "", "PlaceComponentResult", "(Lid/dana/cashier/model/FetchBannerRequestModel;)V", "Lid/dana/cashier/model/npssurvey/NpsSurveyRequestModel;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cashier/model/npssurvey/NpsSurveyRequestModel;)V", "Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/model/npssurvey/NpsSurveySubmitRequestModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(NpsSurveySubmitRequestModel p0);

        void KClassImpl$Data$declaredNonStaticMembers$2(NpsSurveyRequestModel p0);

        void PlaceComponentResult(FetchBannerRequestModel p0);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH&¢\u0006\u0004\b\u000b\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/cashier/CashierBannerContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cashier/model/FetchBannerModel;", "p0", "getAuthRequestContext", "(Lid/dana/cashier/model/FetchBannerModel;)V", "Lid/dana/cashier/model/npssurvey/NpsSurveyModel;", "PlaceComponentResult", "(Lid/dana/cashier/model/npssurvey/NpsSurveyModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void BuiltInFictitiousFunctionClassFactory();

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult(NpsSurveyModel p0);

        void getAuthRequestContext(FetchBannerModel p0);
    }
}
