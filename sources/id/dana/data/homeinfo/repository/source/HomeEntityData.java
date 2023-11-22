package id.dana.data.homeinfo.repository.source;

import id.dana.data.homeinfo.repository.source.network.result.HomeDataResult;
import id.dana.data.homeinfo.repository.source.network.result.HomeInfoResult;
import io.reactivex.Observable;

/* loaded from: classes2.dex */
public interface HomeEntityData {
    Observable<HomeInfoResult> getHomeInfo();

    Observable<HomeDataResult> getUpdatedHomeData();
}
