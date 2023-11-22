package id.dana.data.cancelsurvey.repository.source;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.cancelsurvey.model.CancellationSurveyConfigModel;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonConsultResponse;
import id.dana.data.cancelsurvey.repository.source.network.response.SurveyCancelReasonSubmitResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J&\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lid/dana/data/cancelsurvey/repository/source/CancelSurveyEntityData;", "", "consultCancelSurvey", "Lio/reactivex/Observable;", "Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonConsultResponse;", CashierKeyParams.CASHIER_ORDER_ID, "", "scenario", "goodsId", "fetchCancelSurveyReasonConfig", "Lid/dana/data/cancelsurvey/model/CancellationSurveyConfigModel;", "suffixKey", "submitCancelSurvey", "Lid/dana/data/cancelsurvey/repository/source/network/response/SurveyCancelReasonSubmitResponse;", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CancelSurveyEntityData {
    Observable<SurveyCancelReasonConsultResponse> consultCancelSurvey(String cashierOrderId, String scenario, String goodsId);

    Observable<CancellationSurveyConfigModel> fetchCancelSurveyReasonConfig(String suffixKey);

    Observable<SurveyCancelReasonSubmitResponse> submitCancelSurvey(String cashierOrderId, String scenario, String goodsId);

    /* renamed from: id.dana.data.cancelsurvey.repository.source.CancelSurveyEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static Observable $default$fetchCancelSurveyReasonConfig(CancelSurveyEntityData cancelSurveyEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$consultCancelSurvey(CancelSurveyEntityData cancelSurveyEntityData, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$submitCancelSurvey(CancelSurveyEntityData cancelSurveyEntityData, String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }
    }
}
