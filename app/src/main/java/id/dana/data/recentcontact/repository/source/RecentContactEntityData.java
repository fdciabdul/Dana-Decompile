package id.dana.data.recentcontact.repository.source;

import id.dana.data.recentcontact.repository.source.persistence.entity.DanaUserContactEntity;
import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface RecentContactEntityData {
    Observable<List<String>> getDanaUserContact();

    Observable<Long> saveDanaUserContact(DanaUserContactEntity danaUserContactEntity);
}
