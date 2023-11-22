package id.dana.explore.data.globalsearch;

import id.dana.explore.data.globalsearch.model.PopularSearchCache;
import io.reactivex.Observable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0007H&¢\u0006\u0004\b\u000b\u0010\fJ1\u0010\b\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e`\u000f0\u0007H&¢\u0006\u0004\b\b\u0010\fJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0007\"\b\b\u0000\u0010\u0002*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0004\b\u0011\u0010\u0014J9\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e`\u000fH&¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u000b\u001a\u00020\u00152\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H&¢\u0006\u0004\b\u000b\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/explore/data/globalsearch/GlobalSearchCacheEntityData;", "", "T", "", "p0", "Ljava/lang/Class;", "p1", "Lio/reactivex/Observable;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/Class;)Lio/reactivex/Observable;", "Lid/dana/explore/data/globalsearch/model/PopularSearchCache;", "getAuthRequestContext", "()Lio/reactivex/Observable;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "", "PlaceComponentResult", "()Ljava/util/List;", "", "(Ljava/lang/String;Ljava/lang/Object;)Lio/reactivex/Observable;", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/HashMap;)Lio/reactivex/Observable;", "(Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GlobalSearchCacheEntityData {
    Observable<Unit> BuiltInFictitiousFunctionClassFactory(HashMap<String, Long> p0);

    Observable<HashMap<String, Long>> KClassImpl$Data$declaredNonStaticMembers$2();

    <T> Observable<T> KClassImpl$Data$declaredNonStaticMembers$2(String p0, Class<T> p1);

    <T> Observable<Boolean> PlaceComponentResult(String p0, T p1);

    List<String> PlaceComponentResult();

    Observable<PopularSearchCache> getAuthRequestContext();

    void getAuthRequestContext(List<String> p0);
}
