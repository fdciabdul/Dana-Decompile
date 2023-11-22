package id.dana.domain.homeinfo.repository;

import id.dana.domain.homeinfo.HomeData;
import id.dana.domain.homeinfo.HomeInfoResponse;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface HomeInfoRepository {
    Observable<HomeInfoResponse> getHomeInfo(List<String> list);

    Observable<HomeData> getUpdatedHomeData();
}
