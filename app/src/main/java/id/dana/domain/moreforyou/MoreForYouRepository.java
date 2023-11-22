package id.dana.domain.moreforyou;

import id.dana.domain.promotion.Space;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/moreforyou/MoreForYouRepository;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/promotion/Space;", "getMoreForYouCDP", "()Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MoreForYouRepository {
    Observable<Space> getMoreForYouCDP();
}