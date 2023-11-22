package id.dana.danapoly.data.dailycheck.repository.source;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danapoly.data.dailycheck.model.response.CheckInInfoResponse;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/danapoly/data/dailycheck/repository/source/DanapolyCheckInData;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/dailycheck/model/response/CheckInInfoResponse;", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface DanapolyCheckInData {
    Flow<BaseRpcResult> KClassImpl$Data$declaredNonStaticMembers$2();

    Flow<CheckInInfoResponse> PlaceComponentResult();
}
