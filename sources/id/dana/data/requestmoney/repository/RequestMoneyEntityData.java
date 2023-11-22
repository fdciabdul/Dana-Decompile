package id.dana.data.requestmoney.repository;

import id.dana.data.requestmoney.repository.model.NameCheckConfigEntity;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/requestmoney/repository/RequestMoneyEntityData;", "", "Lio/reactivex/Observable;", "Lid/dana/data/requestmoney/repository/model/NameCheckConfigEntity;", "getNameCheckConfig", "()Lio/reactivex/Observable;", "", "", "getTopFeatureBanks"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RequestMoneyEntityData {
    Observable<NameCheckConfigEntity> getNameCheckConfig();

    Observable<List<String>> getTopFeatureBanks();
}
