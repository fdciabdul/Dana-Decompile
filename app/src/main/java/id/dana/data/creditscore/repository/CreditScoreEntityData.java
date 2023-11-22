package id.dana.data.creditscore.repository;

import id.dana.data.creditscore.repository.source.network.request.InsertDeviceScoringDataRequest;
import id.dana.data.creditscore.repository.source.network.response.InsertDeviceScoringDataResult;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lid/dana/data/creditscore/repository/CreditScoreEntityData;", "", "insertDeviceScoringData", "Lio/reactivex/Observable;", "Lid/dana/data/creditscore/repository/source/network/response/InsertDeviceScoringDataResult;", "request", "Lid/dana/data/creditscore/repository/source/network/request/InsertDeviceScoringDataRequest;", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CreditScoreEntityData {
    Observable<InsertDeviceScoringDataResult> getAuthRequestContext(InsertDeviceScoringDataRequest insertDeviceScoringDataRequest);
}
