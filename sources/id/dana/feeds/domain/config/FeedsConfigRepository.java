package id.dana.feeds.domain.config;

import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.domain.config.model.ProfileCtaConfig;
import id.dana.feeds.domain.config.model.ReportReasons;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00060\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H&¢\u0006\u0004\b\f\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/feeds/domain/config/FeedsConfigRepository;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/social/model/FeedConfig;", "PlaceComponentResult", "()Lio/reactivex/Observable;", "", "Lid/dana/feeds/domain/config/model/ProfileCtaConfig;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/feeds/domain/config/model/ReportReasons;", "MyBillsEntityDataFactory", "", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FeedsConfigRepository {
    Observable<Boolean> BuiltInFictitiousFunctionClassFactory();

    Observable<List<ProfileCtaConfig>> KClassImpl$Data$declaredNonStaticMembers$2();

    Observable<List<ReportReasons>> MyBillsEntityDataFactory();

    Observable<FeedConfig> PlaceComponentResult();
}
