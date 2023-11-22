package id.dana.data.recentcontact.repository;

import id.dana.data.foundation.utils.CommonUtil;
import id.dana.data.recentcontact.repository.source.RecentContactEntityData;
import id.dana.data.recentcontact.repository.source.RecentContactEntityDataFactory;
import id.dana.data.recentcontact.repository.source.persistence.entity.DanaUserContactEntity;
import id.dana.domain.recentcontact.repository.RecentContactRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class RecentContactEntityRepository implements RecentContactRepository {
    private final RecentContactEntityDataFactory recentContactEntityDataFactory;

    @Inject
    public RecentContactEntityRepository(RecentContactEntityDataFactory recentContactEntityDataFactory) {
        this.recentContactEntityDataFactory = recentContactEntityDataFactory;
    }

    private RecentContactEntityData createContactEntityData() {
        return this.recentContactEntityDataFactory.createData2("local");
    }

    @Override // id.dana.domain.recentcontact.repository.RecentContactRepository
    public Observable<Boolean> saveDanaUserContact(String str, String str2) {
        return createContactEntityData().saveDanaUserContact(new DanaUserContactEntity(str, str2, CommonUtil.KClassImpl$Data$declaredNonStaticMembers$2())).flatMap(new Function() { // from class: id.dana.data.recentcontact.repository.RecentContactEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return RecentContactEntityRepository.lambda$saveDanaUserContact$0((Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ObservableSource lambda$saveDanaUserContact$0(Long l) throws Exception {
        if (l != null) {
            return Observable.just(Boolean.TRUE);
        }
        return Observable.just(Boolean.FALSE);
    }

    @Override // id.dana.domain.recentcontact.repository.RecentContactRepository
    public Observable<List<String>> getDanaUserContact() {
        return createContactEntityData().getDanaUserContact();
    }

    public Observable<Boolean> saveDanaUserContact(String str) {
        return saveDanaUserContact(null, str);
    }
}
