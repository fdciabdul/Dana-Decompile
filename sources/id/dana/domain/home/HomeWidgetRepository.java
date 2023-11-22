package id.dana.domain.home;

import id.dana.domain.feeds.model.ActivityData;
import id.dana.domain.home.model.DanaProtectionHomeWidgetInfoModel;
import id.dana.domain.home.model.DanaProtectionHomeWidgetModel;
import id.dana.domain.home.model.MoreForYouData;
import id.dana.domain.home.model.PromoBannerAnnouncementModel;
import id.dana.domain.home.model.PromoBannerContentModel;
import id.dana.domain.user.CurrencyAmount;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H&¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0002H&¢\u0006\u0004\b\n\u0010\u0005J\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\b0\u0002H&¢\u0006\u0004\b\f\u0010\u0005J\u001b\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\b0\u0002H&¢\u0006\u0004\b\u000e\u0010\u0005J\u001b\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\b0\u0002H&¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H&¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001a\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\u00122\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH&¢\u0006\u0004\b\u001d\u0010\u001bJ\u001d\u0010\u001f\u001a\u00020\u00122\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\bH&¢\u0006\u0004\b\u001f\u0010\u001bJ\u001d\u0010!\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\bH&¢\u0006\u0004\b!\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/home/HomeWidgetRepository;", "", "Lio/reactivex/Observable;", "Lid/dana/domain/user/CurrencyAmount;", "getBalanceFromPersistence", "()Lio/reactivex/Observable;", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetModel;", "getDanaProtectionHomeWidgetInfoWithConfigFromLocal", "", "Lid/dana/domain/home/model/MoreForYouData;", "getMoreForYouDataFromPersistence", "Lid/dana/domain/feeds/model/ActivityData;", "getNewsWidgetActivitiesFromPersistence", "Lid/dana/domain/home/model/PromoBannerAnnouncementModel;", "getPromoBannerAnnouncementFromPersistence", "Lid/dana/domain/home/model/PromoBannerContentModel;", "getPromoBannerCdpContentFromPersistence", "balance", "Lio/reactivex/Completable;", "saveBalanceIntoPersistence", "(Lid/dana/domain/user/CurrencyAmount;)Lio/reactivex/Completable;", "Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;", "danaProtectionHomeWidgetInfoModel", "saveDanaProtectionHomeWidgetInfoLocal", "(Lid/dana/domain/home/model/DanaProtectionHomeWidgetInfoModel;)Lio/reactivex/Completable;", "moreForYouData", "saveMoreForYouDataIntoPersistence", "(Ljava/util/List;)Lio/reactivex/Completable;", "activityDataList", "saveNewsWidgetActivitiesIntoPersistence", "promoBannerAnnouncementModels", "savePromoBannerAnnouncementIntoPersistence", "promoBannerContentModels", "savePromoBannerCdpContentIntoPersistence"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface HomeWidgetRepository {
    Observable<CurrencyAmount> getBalanceFromPersistence();

    Observable<DanaProtectionHomeWidgetModel> getDanaProtectionHomeWidgetInfoWithConfigFromLocal();

    Observable<List<MoreForYouData>> getMoreForYouDataFromPersistence();

    Observable<List<ActivityData>> getNewsWidgetActivitiesFromPersistence();

    Observable<List<PromoBannerAnnouncementModel>> getPromoBannerAnnouncementFromPersistence();

    Observable<List<PromoBannerContentModel>> getPromoBannerCdpContentFromPersistence();

    Completable saveBalanceIntoPersistence(CurrencyAmount balance);

    Completable saveDanaProtectionHomeWidgetInfoLocal(DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel);

    Completable saveMoreForYouDataIntoPersistence(List<MoreForYouData> moreForYouData);

    Completable saveNewsWidgetActivitiesIntoPersistence(List<? extends ActivityData> activityDataList);

    Completable savePromoBannerAnnouncementIntoPersistence(List<PromoBannerAnnouncementModel> promoBannerAnnouncementModels);

    Completable savePromoBannerCdpContentIntoPersistence(List<PromoBannerContentModel> promoBannerContentModels);
}
