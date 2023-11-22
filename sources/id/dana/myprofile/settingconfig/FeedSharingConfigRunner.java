package id.dana.myprofile.settingconfig;

import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.domain.social.model.FeedInit;
import id.dana.feeds.domain.activation.FeedInitRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/myprofile/settingconfig/FeedSharingConfigRunner;", "Lid/dana/domain/profilemenu/settingconfig/SettingConfigurationRunner;", "", "getSettingName", "()Ljava/lang/String;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "Lio/reactivex/Observable;", "performConfiguration", "(Lid/dana/domain/profilemenu/model/SettingModel;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "PlaceComponentResult", "Lid/dana/feeds/domain/activation/FeedInitRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/feeds/domain/activation/FeedInitRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedSharingConfigRunner implements SettingConfigurationRunner {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final FeedInitRepository KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final String getSettingName() {
        return MyProfileMenuAction.FEED_SHARING;
    }

    @Inject
    public FeedSharingConfigRunner(FeedInitRepository feedInitRepository) {
        Intrinsics.checkNotNullParameter(feedInitRepository, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = feedInitRepository;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final Observable<SettingModel> performConfiguration(final SettingModel p0) {
        if (p0 == null) {
            Observable<SettingModel> just = Observable.just(SettingModel.empty());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<SettingModel> onErrorResumeNext = this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda0().map(new Function() { // from class: id.dana.myprofile.settingconfig.FeedSharingConfigRunner$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedSharingConfigRunner.MyBillsEntityDataFactory(SettingModel.this, (FeedInit) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.FeedSharingConfigRunner$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return FeedSharingConfigRunner.MyBillsEntityDataFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    public static /* synthetic */ SettingModel MyBillsEntityDataFactory(SettingModel settingModel, FeedInit feedInit) {
        Intrinsics.checkNotNullParameter(feedInit, "");
        settingModel.setInitFeedStatus(feedInit.toInitFeed());
        return settingModel;
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(SettingModel.empty());
    }
}
