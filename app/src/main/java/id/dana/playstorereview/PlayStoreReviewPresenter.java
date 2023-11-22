package id.dana.playstorereview;

import dagger.Lazy;
import id.dana.domain.DefaultObserver;
import id.dana.domain.playstorereview.interactor.IsNeedToShowPlayStoreReview;
import id.dana.domain.playstorereview.interactor.SaveLastPlayStoreReviewShow;
import id.dana.domain.playstorereview.model.AppReviewInfo;
import id.dana.playstorereview.PlayStoreReviewContract;
import id.dana.playstorereview.PlayStoreReviewPresenter;
import id.dana.playstorereview.mapper.AppReviewInfoModelMapperKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B3\b\u0007\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\r\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J)\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u000f"}, d2 = {"Lid/dana/playstorereview/PlayStoreReviewPresenter;", "Lid/dana/playstorereview/PlayStoreReviewContract$Presenter;", "", "PlaceComponentResult", "()V", "onDestroy", "", "p0", "", "p1", "p2", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;JJ)V", "Ldagger/Lazy;", "Lid/dana/domain/playstorereview/interactor/IsNeedToShowPlayStoreReview;", "Ldagger/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/domain/playstorereview/interactor/SaveLastPlayStoreReviewShow;", "getAuthRequestContext", "Lid/dana/playstorereview/PlayStoreReviewContract$View;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayStoreReviewPresenter implements PlayStoreReviewContract.Presenter {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "PlayStoreReviewPresenter";

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy<IsNeedToShowPlayStoreReview> MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy<SaveLastPlayStoreReviewShow> getAuthRequestContext;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy<PlayStoreReviewContract.View> KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public PlayStoreReviewPresenter(Lazy<IsNeedToShowPlayStoreReview> lazy, Lazy<SaveLastPlayStoreReviewShow> lazy2, Lazy<PlayStoreReviewContract.View> lazy3) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        this.MyBillsEntityDataFactory = lazy;
        this.getAuthRequestContext = lazy2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy3;
    }

    @Override // id.dana.playstorereview.PlayStoreReviewContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.get().execute(new DefaultObserver<AppReviewInfo>() { // from class: id.dana.playstorereview.PlayStoreReviewPresenter$checkNeedToShowPlayStoreReview$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                AppReviewInfo appReviewInfo = (AppReviewInfo) obj;
                Intrinsics.checkNotNullParameter(appReviewInfo, "");
                lazy = PlayStoreReviewPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((PlayStoreReviewContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory(AppReviewInfoModelMapperKt.BuiltInFictitiousFunctionClassFactory(appReviewInfo));
            }

            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final void onError(Throwable p0) {
                String str;
                Intrinsics.checkNotNullParameter(p0, "");
                PlayStoreReviewPresenter.Companion companion = PlayStoreReviewPresenter.INSTANCE;
                str = PlayStoreReviewPresenter.KClassImpl$Data$declaredNonStaticMembers$2;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, p0.getMessage());
            }
        });
    }

    @Override // id.dana.playstorereview.PlayStoreReviewContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(String p0, long p1, long p2) {
        this.getAuthRequestContext.get().execute(new DefaultObserver<Boolean>() { // from class: id.dana.playstorereview.PlayStoreReviewPresenter$saveLastPlayStoreReviewShow$1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public final /* synthetic */ void onNext(Object obj) {
                Lazy lazy;
                Boolean bool = (Boolean) obj;
                lazy = PlayStoreReviewPresenter.this.KClassImpl$Data$declaredNonStaticMembers$2;
                ((PlayStoreReviewContract.View) lazy.get()).BuiltInFictitiousFunctionClassFactory();
            }
        }, SaveLastPlayStoreReviewShow.Params.forSaveLastPlayStoreReviewParams(p0, p1, p2));
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.get().dispose();
        this.getAuthRequestContext.get().dispose();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0006\u001a\u0006*\u00020\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005"}, d2 = {"Lid/dana/playstorereview/PlayStoreReviewPresenter$Companion;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "()Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
