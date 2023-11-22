package id.dana.data.recentcontact.repository.source.mock;

import id.dana.data.recentcontact.repository.source.RecentContactEntityData;
import id.dana.data.recentcontact.repository.source.persistence.entity.DanaUserContactEntity;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class MockRecentContactEntityData implements RecentContactEntityData {
    @Override // id.dana.data.recentcontact.repository.source.RecentContactEntityData
    public Observable<Long> saveDanaUserContact(DanaUserContactEntity danaUserContactEntity) {
        return null;
    }

    @Override // id.dana.data.recentcontact.repository.source.RecentContactEntityData
    public Observable<List<String>> getDanaUserContact() {
        return Observable.just(new ArrayList());
    }
}
