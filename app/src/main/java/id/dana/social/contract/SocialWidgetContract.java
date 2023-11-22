package id.dana.social.contract;

import id.dana.base.AbstractContractKt;
import id.dana.social.model.SocialFeedWrapperModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/SocialWidgetContract;", "", "Presenter", "View"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SocialWidgetContract {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u0004\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0004\u0010\rJ/\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\n\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\rJ\u000f\u0010\u0015\u001a\u00020\u0006H&¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/contract/SocialWidgetContract$View;", "Lid/dana/base/AbstractContractKt$AbstractView;", "", "Lid/dana/utils/DisplayedErrorMessage;", "BuiltInFictitiousFunctionClassFactory", "()Ljava/lang/String;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "getAuthRequestContext", "PlaceComponentResult", "Lid/dana/social/model/SocialFeedWrapperModel;", "p0", "(Lid/dana/social/model/SocialFeedWrapperModel;)V", "", "p1", "p2", "", "p3", "(ZZZI)V", "MyBillsEntityDataFactory", "getErrorConfigVersion", "scheduleImpl", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        String BuiltInFictitiousFunctionClassFactory();

        void BuiltInFictitiousFunctionClassFactory(SocialFeedWrapperModel p0);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void MyBillsEntityDataFactory();

        void MyBillsEntityDataFactory(SocialFeedWrapperModel p0);

        void NetworkUserEntityData$$ExternalSyntheticLambda0();

        void PlaceComponentResult();

        void PlaceComponentResult(boolean p0, boolean p1, boolean p2, int p3);

        void getAuthRequestContext();

        void getErrorConfigVersion();

        void moveToNextValue();

        void scheduleImpl();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\nH&J\b\u0010\u0017\u001a\u00020\nH&J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0002\u001a\u00020\nH&J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0012H&J\b\u0010\u001c\u001a\u00020\nH&J\b\u0010\u001d\u001a\u00020\nH\u0016R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX¦\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lid/dana/social/contract/SocialWidgetContract$Presenter;", "Lid/dana/base/AbstractContractKt$AbstractPresenter;", "initFeed", "Lid/dana/domain/social/model/InitFeed;", "getInitFeed", "()Lid/dana/domain/social/model/InitFeed;", "setInitFeed", "(Lid/dana/domain/social/model/InitFeed;)V", "onFeedInitializing", "Lkotlin/Function0;", "", "getOnFeedInitializing", "()Lkotlin/jvm/functions/Function0;", "setOnFeedInitializing", "(Lkotlin/jvm/functions/Function0;)V", "disposeTimelineObserver", "getAndMigrateFeedUserConfig", "isFromTryAgain", "", "getCachedFeeds", "getInitFeedIsObserved", "getLatestWidgetTimeline", "getShareFeedConsent", "getSocialConfig", "initDataWatcherObservable", "notifyFinishCheckSession", "observeInitFeed", "getCurrentInitFeedStatusIfObserved", "refreshWidgetTimeline", "setToInactive", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContractKt.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory(boolean z);

        /* renamed from: id.dana.social.contract.SocialWidgetContract$Presenter$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void PlaceComponentResult() {
            }
        }
    }
}
