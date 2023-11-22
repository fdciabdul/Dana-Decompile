package id.dana.explore.domain.userpersonalization;

import id.dana.explore.domain.userpersonalization.model.UserPersonalizationModel;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000b\u0010\u0007J\u001b\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u0004H&¢\u0006\u0004\b\u0006\u0010\rJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004H&¢\u0006\u0004\b\u0010\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/domain/userpersonalization/UserPersonalizationRepository;", "", "", "p0", "Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lio/reactivex/Observable;", "", "p1", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "getAuthRequestContext", "Lid/dana/explore/domain/userpersonalization/model/UserPersonalizationModel;", "()Lio/reactivex/Observable;", "MyBillsEntityDataFactory", "", "PlaceComponentResult"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface UserPersonalizationRepository {
    Observable<List<UserPersonalizationModel>> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Observable<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(String p0, List<String> p1);

    Observable<Boolean> MyBillsEntityDataFactory();

    Observable<Unit> PlaceComponentResult();

    Observable<Boolean> getAuthRequestContext(String p0);
}
