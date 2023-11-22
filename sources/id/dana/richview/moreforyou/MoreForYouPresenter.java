package id.dana.richview.moreforyou;

import android.content.Context;
import android.net.Uri;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.Lazy;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BasePresenter;
import id.dana.domain.DefaultObserver;
import id.dana.domain.core.usecase.CompletableUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.csatsurvey.interactor.DismissCsatSurvey;
import id.dana.domain.csatsurvey.interactor.GetCsatSurveyCreatedDate;
import id.dana.domain.csatsurvey.interactor.SaveCsatSurveyCreatedDate;
import id.dana.domain.featureconfig.StartupConfigEntityData;
import id.dana.domain.home.interactor.GetMoreForYouDataFromPersistence;
import id.dana.domain.home.interactor.SaveMoreForYouDataIntoPersistence;
import id.dana.domain.home.model.MoreForYouData;
import id.dana.domain.homeinfo.HomeInfoResponse;
import id.dana.domain.homeinfo.interactor.GetHomeInfo;
import id.dana.domain.homeinfo.interactor.GetSurveyInfo;
import id.dana.domain.moreforyou.GetMoreForYou;
import id.dana.domain.promotion.CdpContent;
import id.dana.domain.promotion.Space;
import id.dana.domain.wallet_v3.model.SurveyInfoModel;
import id.dana.richview.moreforyou.MoreForYouContract;
import id.dana.richview.moreforyou.mapper.MoreForYouMapperKt;
import id.dana.richview.moreforyou.model.MoreForYouModel;
import id.dana.utils.DateTimeUtil;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B¥\u0001\b\u0007\u0012\u0006\u0010W\u001a\u00020V\u0012\u0006\u00104\u001a\u000203\u0012\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=06\u0012\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020P06\u0012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;06\u0012\f\u0010-\u001a\b\u0012\u0004\u0012\u00020R06\u0012\f\u0010:\u001a\b\u0012\u0004\u0012\u00020906\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020706\u0012\f\u0010U\u001a\b\u0012\u0004\u0012\u00020T06\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020A06\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020?06\u0012\f\u0010/\u001a\b\u0012\u0004\u0012\u00020S06¢\u0006\u0004\bY\u0010ZJ7\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\"\u0010\u001aJ\u000f\u0010#\u001a\u00020\nH\u0016¢\u0006\u0004\b#\u0010\u001fJ\u000f\u0010$\u001a\u00020\nH\u0016¢\u0006\u0004\b$\u0010\u001fJ\u0017\u0010%\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b%\u0010\u001aJ\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\u001fJ\u000f\u0010'\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010\u001fJ\u001d\u0010*\u001a\u00020\n2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070(H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b-\u0010\u000fJ\u001d\u0010/\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070(H\u0002¢\u0006\u0004\b/\u0010+J3\u00100\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u00101R\u0016\u0010\u001b\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u000207068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00108R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u000209068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00108R\u001a\u0010<\u001a\b\u0012\u0004\u0012\u00020;068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00108R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020=068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u00108R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020?068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u00108R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020A068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u00108R2\u0010C\u001a\f\u0012\b\u0012\u0006*\u00020\u00150\u00150B8\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0004\bC\u0010D\u0012\u0004\bH\u0010\u001f\u001a\u0004\bC\u0010E\"\u0004\bF\u0010GR(\u0010I\u001a\u00020\u00158\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0004\bI\u00102\u0012\u0004\bL\u0010\u001f\u001a\u0004\bI\u0010J\"\u0004\bK\u0010\u001dR2\u0010M\u001a\f\u0012\b\u0012\u0006*\u00020\u00150\u00150B8\u0007@\u0007X\u0086\u000e¢\u0006\u0018\n\u0004\bM\u0010D\u0012\u0004\bO\u0010\u001f\u001a\u0004\bM\u0010E\"\u0004\bN\u0010GR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020P068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bQ\u00108R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020R068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b-\u00108R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020S068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b/\u00108R\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020T068\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bU\u00108R\u0014\u0010W\u001a\u00020V8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bW\u0010X"}, d2 = {"Lid/dana/richview/moreforyou/MoreForYouPresenter;", "Lid/dana/richview/moreforyou/MoreForYouContract$Presenter;", "Lid/dana/base/BasePresenter;", "", "innerUrl", "csatSurveyCreatedDateString", "Ljava/util/ArrayList;", "Lid/dana/richview/moreforyou/model/MoreForYouModel;", "Lkotlin/collections/ArrayList;", "moreForYouModels", "", "decideToShowCsatSurvey", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "id", "dismissCsatSurvey", "(Ljava/lang/String;)V", "surveyUrl", "getCsatSurveyBannerEntryPoint", "(Ljava/lang/String;)Lid/dana/richview/moreforyou/model/MoreForYouModel;", "Lid/dana/domain/promotion/Space;", "space", "", "isHasActiveSurvey", "getCsatSurveyCreatedDateAndCheckforEligibilitySurvey", "(Lid/dana/domain/promotion/Space;Ljava/lang/String;Ljava/lang/Boolean;)V", "getHomeInfoForCsatSurveyEligibility", "(Lid/dana/domain/promotion/Space;)V", "beShouldUpdateUi", "getMoreForYouCDP", "(Z)V", "getMoreForYouCdpFromPersistence", "()V", "getSurveyIdFromSurveyUrl", "(Ljava/lang/String;)Ljava/lang/String;", "getSurveyInfo", "initMoreForYouHitBeObservable", "markSessionChecked", "moreForYouDefault", "onDestroy", "onGetMoreForYouErrorWithBeShouldUpdateUiChecking", "", "listOfItem", "onGetMoreForYouSuccessWithBeShouldUpdateUiChecking", "(Ljava/util/List;)V", "currentDateString", "saveCsatSurveyCreatedDate", "moreForYouModel", "saveMoreForYouDataIntoPersistence", "setupMoreForYouItems", "(Lid/dana/domain/promotion/Space;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Context;", "Ldagger/Lazy;", "Lid/dana/domain/csatsurvey/interactor/DismissCsatSurvey;", "Ldagger/Lazy;", "Lid/dana/domain/csatsurvey/interactor/GetCsatSurveyCreatedDate;", "getCsatSurveyCreatedDate", "Lid/dana/domain/homeinfo/interactor/GetHomeInfo;", "getHomeInfo", "Lid/dana/domain/moreforyou/GetMoreForYou;", "getMoreForYou", "Lid/dana/domain/home/interactor/GetMoreForYouDataFromPersistence;", "getMoreForYouDataFromPersistence", "Lid/dana/domain/homeinfo/interactor/GetSurveyInfo;", "Lio/reactivex/subjects/PublishSubject;", "isLocalDataLoadedWatcher", "Lio/reactivex/subjects/PublishSubject;", "()Lio/reactivex/subjects/PublishSubject;", "setLocalDataLoadedWatcher", "(Lio/reactivex/subjects/PublishSubject;)V", "isLocalDataLoadedWatcher$annotations", "isPersistenceEmpty", "()Z", "setPersistenceEmpty", "isPersistenceEmpty$annotations", "isSessionCheckedWatcher", "setSessionCheckedWatcher", "isSessionCheckedWatcher$annotations", "Lid/dana/richview/moreforyou/MoreForYouModelMapper;", "mapper", "Lid/dana/domain/csatsurvey/interactor/SaveCsatSurveyCreatedDate;", "Lid/dana/domain/home/interactor/SaveMoreForYouDataIntoPersistence;", "Lid/dana/domain/featureconfig/StartupConfigEntityData;", "sharedPrefStartupConfig", "Lid/dana/richview/moreforyou/MoreForYouContract$View;", "view", "Lid/dana/richview/moreforyou/MoreForYouContract$View;", "<init>", "(Lid/dana/richview/moreforyou/MoreForYouContract$View;Landroid/content/Context;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MoreForYouPresenter extends BasePresenter implements MoreForYouContract.Presenter {
    private static final int ONE_WEEK = 7;
    private static final int THREE_MONTHS = 90;
    private boolean beShouldUpdateUi;
    private final Context context;
    private final Lazy<DismissCsatSurvey> dismissCsatSurvey;
    private final Lazy<GetCsatSurveyCreatedDate> getCsatSurveyCreatedDate;
    private final Lazy<GetHomeInfo> getHomeInfo;
    private final Lazy<GetMoreForYou> getMoreForYou;
    private final Lazy<GetMoreForYouDataFromPersistence> getMoreForYouDataFromPersistence;
    private final Lazy<GetSurveyInfo> getSurveyInfo;
    private PublishSubject<Boolean> isLocalDataLoadedWatcher;
    private boolean isPersistenceEmpty;
    private PublishSubject<Boolean> isSessionCheckedWatcher;
    private final Lazy<MoreForYouModelMapper> mapper;
    private final Lazy<SaveCsatSurveyCreatedDate> saveCsatSurveyCreatedDate;
    private final Lazy<SaveMoreForYouDataIntoPersistence> saveMoreForYouDataIntoPersistence;
    private final Lazy<StartupConfigEntityData> sharedPrefStartupConfig;
    private final MoreForYouContract.View view;

    public static /* synthetic */ void isLocalDataLoadedWatcher$annotations() {
    }

    public static /* synthetic */ void isPersistenceEmpty$annotations() {
    }

    public static /* synthetic */ void isSessionCheckedWatcher$annotations() {
    }

    @Inject
    public MoreForYouPresenter(MoreForYouContract.View view, Context context, Lazy<GetMoreForYou> lazy, Lazy<MoreForYouModelMapper> lazy2, Lazy<GetHomeInfo> lazy3, Lazy<SaveCsatSurveyCreatedDate> lazy4, Lazy<GetCsatSurveyCreatedDate> lazy5, Lazy<DismissCsatSurvey> lazy6, Lazy<StartupConfigEntityData> lazy7, Lazy<GetSurveyInfo> lazy8, Lazy<GetMoreForYouDataFromPersistence> lazy9, Lazy<SaveMoreForYouDataIntoPersistence> lazy10) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        Intrinsics.checkNotNullParameter(lazy6, "");
        Intrinsics.checkNotNullParameter(lazy7, "");
        Intrinsics.checkNotNullParameter(lazy8, "");
        Intrinsics.checkNotNullParameter(lazy9, "");
        Intrinsics.checkNotNullParameter(lazy10, "");
        this.view = view;
        this.context = context;
        this.getMoreForYou = lazy;
        this.mapper = lazy2;
        this.getHomeInfo = lazy3;
        this.saveCsatSurveyCreatedDate = lazy4;
        this.getCsatSurveyCreatedDate = lazy5;
        this.dismissCsatSurvey = lazy6;
        this.sharedPrefStartupConfig = lazy7;
        this.getSurveyInfo = lazy8;
        this.getMoreForYouDataFromPersistence = lazy9;
        this.saveMoreForYouDataIntoPersistence = lazy10;
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.isSessionCheckedWatcher = PlaceComponentResult;
        PublishSubject<Boolean> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.isLocalDataLoadedWatcher = PlaceComponentResult2;
    }

    @JvmName(name = "isPersistenceEmpty")
    /* renamed from: isPersistenceEmpty  reason: from getter */
    public final boolean getIsPersistenceEmpty() {
        return this.isPersistenceEmpty;
    }

    @JvmName(name = "setPersistenceEmpty")
    public final void setPersistenceEmpty(boolean z) {
        this.isPersistenceEmpty = z;
    }

    @JvmName(name = "isSessionCheckedWatcher")
    public final PublishSubject<Boolean> isSessionCheckedWatcher() {
        return this.isSessionCheckedWatcher;
    }

    @JvmName(name = "setSessionCheckedWatcher")
    public final void setSessionCheckedWatcher(PublishSubject<Boolean> publishSubject) {
        Intrinsics.checkNotNullParameter(publishSubject, "");
        this.isSessionCheckedWatcher = publishSubject;
    }

    @JvmName(name = "isLocalDataLoadedWatcher")
    public final PublishSubject<Boolean> isLocalDataLoadedWatcher() {
        return this.isLocalDataLoadedWatcher;
    }

    @JvmName(name = "setLocalDataLoadedWatcher")
    public final void setLocalDataLoadedWatcher(PublishSubject<Boolean> publishSubject) {
        Intrinsics.checkNotNullParameter(publishSubject, "");
        this.isLocalDataLoadedWatcher = publishSubject;
    }

    @Override // id.dana.richview.moreforyou.MoreForYouContract.Presenter
    public final void initMoreForYouHitBeObservable() {
        addDisposable(Observable.combineLatest(this.isSessionCheckedWatcher, this.isLocalDataLoadedWatcher, new BiFunction() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean m2840initMoreForYouHitBeObservable$lambda0;
                m2840initMoreForYouHitBeObservable$lambda0 = MoreForYouPresenter.m2840initMoreForYouHitBeObservable$lambda0((Boolean) obj, (Boolean) obj2);
                return m2840initMoreForYouHitBeObservable$lambda0;
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean m2841initMoreForYouHitBeObservable$lambda1;
                m2841initMoreForYouHitBeObservable$lambda1 = MoreForYouPresenter.m2841initMoreForYouHitBeObservable$lambda1((Boolean) obj);
                return m2841initMoreForYouHitBeObservable$lambda1;
            }
        }).subscribe(new Consumer() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MoreForYouPresenter.m2842initMoreForYouHitBeObservable$lambda2(MoreForYouPresenter.this, (Boolean) obj);
            }
        }));
    }

    /* renamed from: initMoreForYouHitBeObservable$lambda-0 */
    public static final Boolean m2840initMoreForYouHitBeObservable$lambda0(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    /* renamed from: initMoreForYouHitBeObservable$lambda-1 */
    public static final boolean m2841initMoreForYouHitBeObservable$lambda1(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue();
    }

    /* renamed from: initMoreForYouHitBeObservable$lambda-2 */
    public static final void m2842initMoreForYouHitBeObservable$lambda2(MoreForYouPresenter moreForYouPresenter, Boolean bool) {
        Intrinsics.checkNotNullParameter(moreForYouPresenter, "");
        moreForYouPresenter.getMoreForYouCDP(moreForYouPresenter.beShouldUpdateUi);
    }

    @Override // id.dana.richview.moreforyou.MoreForYouContract.Presenter
    public final void markSessionChecked() {
        this.isSessionCheckedWatcher.onNext(Boolean.TRUE);
    }

    @Override // id.dana.richview.moreforyou.MoreForYouContract.Presenter
    public final void getMoreForYouCdpFromPersistence() {
        this.getMoreForYouDataFromPersistence.get().execute(NoParams.INSTANCE, new Function1<List<? extends MoreForYouData>, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getMoreForYouCdpFromPersistence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends MoreForYouData> list) {
                invoke2((List<MoreForYouData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<MoreForYouData> list) {
                MoreForYouContract.View view;
                Intrinsics.checkNotNullParameter(list, "");
                if ((!list.isEmpty()) != false) {
                    MoreForYouPresenter.this.beShouldUpdateUi = false;
                    view = MoreForYouPresenter.this.view;
                    view.onGetMoreForYouSuccess(MoreForYouMapperKt.toMoreForYouModels(list));
                } else {
                    MoreForYouPresenter.this.beShouldUpdateUi = true;
                }
                MoreForYouPresenter.this.isLocalDataLoadedWatcher().onNext(Boolean.TRUE);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getMoreForYouCdpFromPersistence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MoreForYouPresenter.this.beShouldUpdateUi = true;
                MoreForYouPresenter.this.isLocalDataLoadedWatcher().onNext(Boolean.TRUE);
            }
        });
    }

    @Override // id.dana.richview.moreforyou.MoreForYouContract.Presenter
    public final void getMoreForYouCDP(boolean beShouldUpdateUi) {
        this.beShouldUpdateUi = beShouldUpdateUi;
        this.getMoreForYou.get().execute(NoParams.INSTANCE, new Function1<Space, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getMoreForYouCDP$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Space space) {
                invoke2(space);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Space space) {
                Intrinsics.checkNotNullParameter(space, "");
                MoreForYouPresenter.this.getHomeInfoForCsatSurveyEligibility(space);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getMoreForYouCDP$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MoreForYouPresenter.this.onGetMoreForYouErrorWithBeShouldUpdateUiChecking();
            }
        });
    }

    private final void onGetMoreForYouSuccessWithBeShouldUpdateUiChecking(List<MoreForYouModel> listOfItem) {
        if (this.beShouldUpdateUi) {
            this.view.onGetMoreForYouSuccess(listOfItem);
        }
    }

    public final void onGetMoreForYouErrorWithBeShouldUpdateUiChecking() {
        if (this.beShouldUpdateUi) {
            this.view.onGetMoreForYouError();
        }
    }

    public final void getHomeInfoForCsatSurveyEligibility(final Space space) {
        if (this.sharedPrefStartupConfig.get().getQueryUserDataConfig().getSeperateSurveyInfo()) {
            getSurveyInfo(space);
        } else {
            this.getHomeInfo.get().execute(new DefaultObserver<HomeInfoResponse>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getHomeInfoForCsatSurveyEligibility$1
                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onNext(HomeInfoResponse homeInfoResponse) {
                    Intrinsics.checkNotNullParameter(homeInfoResponse, "");
                    MoreForYouPresenter.this.getCsatSurveyCreatedDateAndCheckforEligibilitySurvey(space, homeInfoResponse.getSurveyInfo().getInnerUrl(), Boolean.valueOf(homeInfoResponse.getSurveyInfo().isHasActiveSurvey()));
                }

                @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
                public final void onError(Throwable e) {
                    Intrinsics.checkNotNullParameter(e, "");
                    MoreForYouPresenter.this.moreForYouDefault(space);
                }
            });
        }
    }

    private final void getSurveyInfo(final Space space) {
        this.getSurveyInfo.get().execute(NoParams.INSTANCE, new Function1<SurveyInfoModel, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getSurveyInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SurveyInfoModel surveyInfoModel) {
                invoke2(surveyInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SurveyInfoModel surveyInfoModel) {
                Intrinsics.checkNotNullParameter(surveyInfoModel, "");
                MoreForYouPresenter.this.getCsatSurveyCreatedDateAndCheckforEligibilitySurvey(space, surveyInfoModel.getInnerUrl(), Boolean.valueOf(surveyInfoModel.getHasActiveSurvey()));
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getSurveyInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MoreForYouPresenter.this.moreForYouDefault(space);
            }
        });
    }

    public final void getCsatSurveyCreatedDateAndCheckforEligibilitySurvey(final Space space, final String innerUrl, final Boolean isHasActiveSurvey) {
        this.getCsatSurveyCreatedDate.get().execute(NoParams.INSTANCE, new Function1<String, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getCsatSurveyCreatedDateAndCheckforEligibilitySurvey$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                if (Space.this.getCdpContents() == null) {
                    return;
                }
                this.setupMoreForYouItems(Space.this, innerUrl, isHasActiveSurvey, str);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$getCsatSurveyCreatedDateAndCheckforEligibilitySurvey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MoreForYouPresenter.this.moreForYouDefault(space);
            }
        });
    }

    public final void moreForYouDefault(Space space) {
        ArrayList arrayList;
        List<CdpContent> cdpContents = space.getCdpContents();
        if (cdpContents == null) {
            arrayList = new ArrayList();
        } else {
            List<CdpContent> list = cdpContents;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(this.mapper.get().apply((CdpContent) it.next()));
            }
            arrayList = arrayList2;
        }
        saveMoreForYouDataIntoPersistence(arrayList);
        onGetMoreForYouSuccessWithBeShouldUpdateUiChecking(arrayList);
    }

    private final void saveMoreForYouDataIntoPersistence(List<MoreForYouModel> moreForYouModel) {
        SaveMoreForYouDataIntoPersistence saveMoreForYouDataIntoPersistence = this.saveMoreForYouDataIntoPersistence.get();
        Intrinsics.checkNotNullExpressionValue(saveMoreForYouDataIntoPersistence, "");
        CompletableUseCase.execute$default(saveMoreForYouDataIntoPersistence, new SaveMoreForYouDataIntoPersistence.Params(MoreForYouMapperKt.toMoreForYouData(moreForYouModel)), null, null, 6, null);
    }

    public final void setupMoreForYouItems(Space space, String innerUrl, Boolean isHasActiveSurvey, String csatSurveyCreatedDateString) {
        ArrayList<MoreForYouModel> arrayList = new ArrayList<>();
        if (Intrinsics.areEqual(isHasActiveSurvey, Boolean.TRUE)) {
            if (innerUrl == null) {
                innerUrl = "";
            }
            decideToShowCsatSurvey(innerUrl, csatSurveyCreatedDateString, arrayList);
        }
        List<CdpContent> cdpContents = space.getCdpContents();
        Intrinsics.checkNotNullExpressionValue(cdpContents, "");
        Iterator<T> it = cdpContents.iterator();
        while (it.hasNext()) {
            MoreForYouModel apply = this.mapper.get().apply((CdpContent) it.next());
            apply.setSpaceCode(space.getSpaceCode());
            arrayList.add(apply);
        }
        ArrayList<MoreForYouModel> arrayList2 = arrayList;
        saveMoreForYouDataIntoPersistence(arrayList2);
        onGetMoreForYouSuccessWithBeShouldUpdateUiChecking(arrayList2);
    }

    private final void decideToShowCsatSurvey(String innerUrl, String csatSurveyCreatedDateString, ArrayList<MoreForYouModel> moreForYouModels) {
        Locale locale;
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(innerUrl);
        String obj = sb.toString();
        String PlaceComponentResult = DateTimeUtil.PlaceComponentResult("dd MMM yyyy HH:mm");
        Date date = new Date();
        if (csatSurveyCreatedDateString.length() > 0) {
            locale = Locale.getDefault();
            long MyBillsEntityDataFactory = DateTimeUtil.MyBillsEntityDataFactory(date, new Date(DateTimeUtil.PlaceComponentResult(csatSurveyCreatedDateString, "dd MMM yyyy HH:mm", locale)));
            if (MyBillsEntityDataFactory > 90) {
                Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
                saveCsatSurveyCreatedDate(PlaceComponentResult);
                moreForYouModels.add(getCsatSurveyBannerEntryPoint(obj));
                return;
            } else if (MyBillsEntityDataFactory >= 7) {
                dismissCsatSurvey(getSurveyIdFromSurveyUrl(obj));
                return;
            } else {
                moreForYouModels.add(getCsatSurveyBannerEntryPoint(obj));
                return;
            }
        }
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        saveCsatSurveyCreatedDate(PlaceComponentResult);
        moreForYouModels.add(getCsatSurveyBannerEntryPoint(obj));
    }

    private final void saveCsatSurveyCreatedDate(String currentDateString) {
        this.saveCsatSurveyCreatedDate.get().execute(SaveCsatSurveyCreatedDate.Params.INSTANCE.create(currentDateString), new Function1<Boolean, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$saveCsatSurveyCreatedDate$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$saveCsatSurveyCreatedDate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MoreForYouPresenter.this.onGetMoreForYouErrorWithBeShouldUpdateUiChecking();
            }
        });
    }

    private final String getSurveyIdFromSurveyUrl(String surveyUrl) {
        String queryParameter = Uri.parse(surveyUrl).getQueryParameter("id");
        return queryParameter == null ? "" : queryParameter;
    }

    private final void dismissCsatSurvey(String id2) {
        this.dismissCsatSurvey.get().execute(DismissCsatSurvey.Params.INSTANCE.create(id2), new Function1<Boolean, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$dismissCsatSurvey$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.richview.moreforyou.MoreForYouPresenter$dismissCsatSurvey$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                MoreForYouPresenter.this.onGetMoreForYouErrorWithBeShouldUpdateUiChecking();
            }
        });
    }

    private final MoreForYouModel getCsatSurveyBannerEntryPoint(String surveyUrl) {
        return new MoreForYouModel(null, null, "URL", null, this.context.getString(R.string.csat_survey_title), this.context.getString(R.string.csat_survey_subtitle), surveyUrl, null, null, null, null, null, null, null, Integer.valueOf((int) R.drawable.csat_survey_banner), null, 49035, null);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.getHomeInfo.get().dispose();
        this.getSurveyInfo.get().dispose();
        this.getMoreForYouDataFromPersistence.get().dispose();
        this.saveMoreForYouDataIntoPersistence.get().dispose();
    }
}
