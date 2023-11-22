package id.dana.domain.tncsummary;

import id.dana.domain.tncsummary.model.TermsConditionsResponse;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface TncSummaryRepository {
    Observable<Boolean> getFeatureTncSummary();

    Observable<TermsConditionsResponse> getTncSummaryConfigWithSpaceCode();
}
