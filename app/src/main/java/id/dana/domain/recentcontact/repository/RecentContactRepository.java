package id.dana.domain.recentcontact.repository;

import io.reactivex.Observable;
import java.util.List;

/* loaded from: classes2.dex */
public interface RecentContactRepository {
    Observable<List<String>> getDanaUserContact();

    Observable<Boolean> saveDanaUserContact(String str, String str2);
}
