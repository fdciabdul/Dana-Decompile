package id.dana.domain.cancelsurvey.repository;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.cancelsurvey.model.CancelReason;
import id.dana.domain.cancelsurvey.model.CancellationSurveyConfig;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J3\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\u000b\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0010\u0010\nø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/cancelsurvey/repository/CancelSurveyRepository;", "", "", CashierKeyParams.CASHIER_ORDER_ID, "scenario", "goodsId", "Lio/reactivex/Observable;", "", "Lid/dana/domain/cancelsurvey/model/CancelReason;", "consultCancelSurveyReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "suffixKey", "Lid/dana/domain/cancelsurvey/model/CancellationSurveyConfig;", "fetchCancelSurveyReasonConfig", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "submitCancelReason"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CancelSurveyRepository {
    Observable<List<CancelReason>> consultCancelSurveyReason(String cashierOrderId, String scenario, String goodsId);

    Observable<CancellationSurveyConfig> fetchCancelSurveyReasonConfig(String suffixKey);

    Observable<Boolean> submitCancelReason(String cashierOrderId, String scenario, String goodsId);
}
