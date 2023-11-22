package id.dana.myprofile.settingconfig;

import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner;
import id.dana.feeds.domain.share.FeedsShareRepository;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/myprofile/settingconfig/ShareFeedSettingConfigRunner;", "Lid/dana/domain/profilemenu/settingconfig/SettingConfigurationRunner;", "", "getSettingName", "()Ljava/lang/String;", "Lid/dana/domain/profilemenu/model/SettingModel;", "p0", "Lio/reactivex/Observable;", "performConfiguration", "(Lid/dana/domain/profilemenu/model/SettingModel;)Lio/reactivex/Observable;", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "MyBillsEntityDataFactory", "Lid/dana/feeds/domain/share/FeedsShareRepository;", "getAuthRequestContext", "<init>", "(Lid/dana/feeds/domain/share/FeedsShareRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareFeedSettingConfigRunner implements SettingConfigurationRunner {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FeedsShareRepository getAuthRequestContext;

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final String getSettingName() {
        return MyProfileMenuAction.SHARE_FEED;
    }

    @Inject
    public ShareFeedSettingConfigRunner(FeedsShareRepository feedsShareRepository) {
        Intrinsics.checkNotNullParameter(feedsShareRepository, "");
        this.getAuthRequestContext = feedsShareRepository;
    }

    @Override // id.dana.domain.profilemenu.settingconfig.SettingConfigurationRunner
    public final Observable<SettingModel> performConfiguration(final SettingModel p0) {
        if (p0 == null) {
            Observable<SettingModel> just = Observable.just(SettingModel.empty());
            Intrinsics.checkNotNullExpressionValue(just, "");
            return just;
        }
        Observable<SettingModel> onErrorResumeNext = Observable.fromCallable(new Callable() { // from class: id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ShareFeedSettingConfigRunner.getAuthRequestContext(ShareFeedSettingConfigRunner.this);
            }
        }).map(new Function() { // from class: id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ShareFeedSettingConfigRunner.MyBillsEntityDataFactory(SettingModel.this, (Boolean) obj);
            }
        }).onErrorResumeNext(new Function() { // from class: id.dana.myprofile.settingconfig.ShareFeedSettingConfigRunner$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ShareFeedSettingConfigRunner.MyBillsEntityDataFactory((Throwable) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
        return onErrorResumeNext;
    }

    public static /* synthetic */ SettingModel MyBillsEntityDataFactory(SettingModel settingModel, Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return settingModel.setShareFeed(bool.booleanValue());
    }

    public static /* synthetic */ Boolean getAuthRequestContext(ShareFeedSettingConfigRunner shareFeedSettingConfigRunner) {
        Intrinsics.checkNotNullParameter(shareFeedSettingConfigRunner, "");
        return Boolean.valueOf(shareFeedSettingConfigRunner.getAuthRequestContext.PlaceComponentResult());
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return Observable.just(SettingModel.empty());
    }
}
