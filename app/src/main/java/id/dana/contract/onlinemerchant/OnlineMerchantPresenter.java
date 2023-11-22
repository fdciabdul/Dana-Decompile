package id.dana.contract.onlinemerchant;

import android.content.Context;
import id.dana.contract.onlinemerchant.OnlineMerchantContract;
import id.dana.explore.domain.globalsearch.interactor.GetOnlineMerchant;
import id.dana.explore.domain.globalsearch.model.Paginator;
import id.dana.explore.domain.globalsearch.model.PaySearchInfo;
import id.dana.explore.domain.globalsearch.model.SearchResultResponse;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.SearchResult;
import id.dana.globalsearch.model.SearchResultExtKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001-B)\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0013\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010)\u001a\u00020\u0019\u0012\u0006\u0010*\u001a\u00020\u0019¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0005\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\b\u0007\u0010\u0012R\u0014\u0010\r\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u000f\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\t8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\nR\u0012\u0010\u0017\u001a\u00020\tX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u001c\u0010!\u001a\f\u0012\b\u0012\u0006*\u00020\t0\t0\u001fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010 R\u001c\u0010\u001a\u001a\f\u0012\b\u0012\u0006*\u00020\t0\t0\u001fX\u0087\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0087\u0002¢\u0006\u0006\n\u0004\b\r\u0010\"R\u0012\u0010\u0014\u001a\u00020#X\u0087\u0002¢\u0006\u0006\n\u0004\b!\u0010$R\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0087\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\"R\u0014\u0010&\u001a\u00020%8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/contract/onlinemerchant/OnlineMerchantPresenter;", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$Presenter;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "()V", "", "()Z", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "PlaceComponentResult", "onDestroy", "getAuthRequestContext", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "(Ljava/util/List;)V", "Landroid/content/Context;", "getErrorConfigVersion", "Landroid/content/Context;", "Lio/reactivex/disposables/CompositeDisposable;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lio/reactivex/disposables/CompositeDisposable;", "Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant;", "lookAheadTest", "Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Z", "scheduleImpl", "Lio/reactivex/subjects/PublishSubject;", "Lio/reactivex/subjects/PublishSubject;", "moveToNextValue", "Ljava/util/List;", "", "I", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;", "GetContactSyncConfig", "Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;", "p1", "p2", "p3", "<init>", "(Landroid/content/Context;Lid/dana/contract/onlinemerchant/OnlineMerchantContract$View;Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant;Lid/dana/explore/domain/globalsearch/interactor/GetOnlineMerchant;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OnlineMerchantPresenter implements OnlineMerchantContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    PublishSubject<Boolean> moveToNextValue;
    private final OnlineMerchantContract.View GetContactSyncConfig;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    PublishSubject<Boolean> lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final CompositeDisposable KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final GetOnlineMerchant MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    List<PaySearchInfoModel> scheduleImpl;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final GetOnlineMerchant getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    int getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    List<PaySearchInfoModel> NetworkUserEntityData$$ExternalSyntheticLambda1;

    @Inject
    public OnlineMerchantPresenter(Context context, OnlineMerchantContract.View view, GetOnlineMerchant getOnlineMerchant, GetOnlineMerchant getOnlineMerchant2) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(getOnlineMerchant, "");
        Intrinsics.checkNotNullParameter(getOnlineMerchant2, "");
        this.PlaceComponentResult = context;
        this.GetContactSyncConfig = view;
        this.getAuthRequestContext = getOnlineMerchant;
        this.MyBillsEntityDataFactory = getOnlineMerchant2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = CollectionsKt.emptyList();
        this.scheduleImpl = CollectionsKt.emptyList();
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.lookAheadTest = PlaceComponentResult;
        PublishSubject<Boolean> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.moveToNextValue = PlaceComponentResult2;
        this.getErrorConfigVersion = 1;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new CompositeDisposable();
    }

    @JvmName(name = "scheduleImpl")
    public final boolean scheduleImpl() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.execute(new GetOnlineMerchant.Params(p0, 1, 32, GetOnlineMerchant.OnlineMerchantType.SEARCH), new Function1<SearchResultResponse, Unit>() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$getOnlineMerchantSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SearchResultResponse searchResultResponse) {
                invoke2(searchResultResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SearchResultResponse searchResultResponse) {
                OnlineMerchantContract.View view;
                OnlineMerchantContract.View view2;
                Intrinsics.checkNotNullParameter(searchResultResponse, "");
                SearchResult PlaceComponentResult = SearchResultExtKt.PlaceComponentResult(searchResultResponse);
                List<PaySearchInfo> list = PlaceComponentResult.PlaceComponentResult;
                if (!(list == null || list.isEmpty())) {
                    view2 = OnlineMerchantPresenter.this.GetContactSyncConfig;
                    view2.BuiltInFictitiousFunctionClassFactory(PlaceComponentResult);
                    return;
                }
                view = OnlineMerchantPresenter.this.GetContactSyncConfig;
                view.MyBillsEntityDataFactory();
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$getOnlineMerchantSearch$2
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
                OnlineMerchantContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                view = OnlineMerchantPresenter.this.GetContactSyncConfig;
                view.KClassImpl$Data$declaredNonStaticMembers$2();
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.GET_ONLINE_MERCHANT, th.toString());
            }
        });
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.execute(new GetOnlineMerchant.Params(null, 1, 8, GetOnlineMerchant.OnlineMerchantType.TRENDING, 1, null), new Function1<SearchResultResponse, Unit>() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$loadTrendingMerchants$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SearchResultResponse searchResultResponse) {
                invoke2(searchResultResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SearchResultResponse searchResultResponse) {
                Context context;
                Intrinsics.checkNotNullParameter(searchResultResponse, "");
                OnlineMerchantPresenter onlineMerchantPresenter = OnlineMerchantPresenter.this;
                List<PaySearchInfo> searchResultList = searchResultResponse.getSearchResultList();
                if (searchResultList == null) {
                    searchResultList = CollectionsKt.emptyList();
                }
                context = OnlineMerchantPresenter.this.PlaceComponentResult;
                List<PaySearchInfoModel> KClassImpl$Data$declaredNonStaticMembers$2 = SearchResultExtKt.KClassImpl$Data$declaredNonStaticMembers$2(searchResultList, context);
                Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                onlineMerchantPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1 = KClassImpl$Data$declaredNonStaticMembers$2;
                OnlineMerchantPresenter.this.lookAheadTest.onNext(Boolean.TRUE);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$loadTrendingMerchants$2
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
                OnlineMerchantPresenter.this.lookAheadTest.onNext(Boolean.TRUE);
            }
        });
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory(final boolean p0) {
        this.getAuthRequestContext.execute(new GetOnlineMerchant.Params(null, this.getErrorConfigVersion, 32, GetOnlineMerchant.OnlineMerchantType.ALL, 1, null), new Function1<SearchResultResponse, Unit>() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$loadOnlineMerchants$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(SearchResultResponse searchResultResponse) {
                invoke2(searchResultResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(SearchResultResponse searchResultResponse) {
                Integer totalPage;
                OnlineMerchantContract.View view;
                Context context;
                Context context2;
                Intrinsics.checkNotNullParameter(searchResultResponse, "");
                Paginator paginator = searchResultResponse.getPaginator();
                if (paginator == null || (totalPage = paginator.getTotalPage()) == null) {
                    return;
                }
                OnlineMerchantPresenter onlineMerchantPresenter = OnlineMerchantPresenter.this;
                int intValue = totalPage.intValue();
                if (onlineMerchantPresenter.getErrorConfigVersion != 1) {
                    view = onlineMerchantPresenter.GetContactSyncConfig;
                    List<PaySearchInfo> searchResultList = searchResultResponse.getSearchResultList();
                    if (searchResultList == null) {
                        searchResultList = CollectionsKt.emptyList();
                    }
                    context = onlineMerchantPresenter.PlaceComponentResult;
                    view.KClassImpl$Data$declaredNonStaticMembers$2(SearchResultExtKt.KClassImpl$Data$declaredNonStaticMembers$2(searchResultList, context));
                } else {
                    List<PaySearchInfo> searchResultList2 = searchResultResponse.getSearchResultList();
                    if (searchResultList2 == null) {
                        searchResultList2 = CollectionsKt.emptyList();
                    }
                    context2 = onlineMerchantPresenter.PlaceComponentResult;
                    List<PaySearchInfoModel> KClassImpl$Data$declaredNonStaticMembers$2 = SearchResultExtKt.KClassImpl$Data$declaredNonStaticMembers$2(searchResultList2, context2);
                    Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
                    onlineMerchantPresenter.scheduleImpl = KClassImpl$Data$declaredNonStaticMembers$2;
                    onlineMerchantPresenter.moveToNextValue.onNext(Boolean.TRUE);
                }
                onlineMerchantPresenter.BuiltInFictitiousFunctionClassFactory = onlineMerchantPresenter.getErrorConfigVersion < intValue;
                if (onlineMerchantPresenter.scheduleImpl()) {
                    onlineMerchantPresenter.getErrorConfigVersion++;
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$loadOnlineMerchants$2
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
                OnlineMerchantContract.View view;
                Intrinsics.checkNotNullParameter(th, "");
                if (p0) {
                    this.moveToNextValue.onNext(Boolean.TRUE);
                }
                if (!this.scheduleImpl() || p0) {
                    return;
                }
                view = this.GetContactSyncConfig;
                view.PlaceComponentResult();
            }
        });
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        PublishSubject<Boolean> publishSubject = this.lookAheadTest;
        Boolean bool = Boolean.FALSE;
        publishSubject.onNext(bool);
        this.moveToNextValue.onNext(bool);
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    public final void MyBillsEntityDataFactory(List<PaySearchInfoModel> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = p0;
        this.lookAheadTest.onNext(Boolean.TRUE);
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
        Disposable subscribe = Observable.zip(this.lookAheadTest, this.moveToNextValue, new BiFunction() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Boolean valueOf;
                ((Boolean) obj).booleanValue();
                ((Boolean) obj2).booleanValue();
                valueOf = Boolean.valueOf(r0 && r1);
                return valueOf;
            }
        }).subscribe(new Consumer() { // from class: id.dana.contract.onlinemerchant.OnlineMerchantPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                OnlineMerchantPresenter.PlaceComponentResult(OnlineMerchantPresenter.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(subscribe);
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    public final void getAuthRequestContext() {
        this.getErrorConfigVersion = 1;
    }

    @Override // id.dana.contract.onlinemerchant.OnlineMerchantContract.Presenter
    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
        this.getAuthRequestContext.dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.dispose();
    }

    public static /* synthetic */ void PlaceComponentResult(OnlineMerchantPresenter onlineMerchantPresenter, boolean z) {
        Intrinsics.checkNotNullParameter(onlineMerchantPresenter, "");
        if (z) {
            if (onlineMerchantPresenter.scheduleImpl.isEmpty()) {
                onlineMerchantPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                onlineMerchantPresenter.GetContactSyncConfig.getAuthRequestContext();
                return;
            }
            onlineMerchantPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
            if (onlineMerchantPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.isEmpty()) {
                onlineMerchantPresenter.GetContactSyncConfig.BuiltInFictitiousFunctionClassFactory();
            } else {
                onlineMerchantPresenter.GetContactSyncConfig.PlaceComponentResult(onlineMerchantPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
            onlineMerchantPresenter.GetContactSyncConfig.MyBillsEntityDataFactory(onlineMerchantPresenter.scheduleImpl);
        }
    }
}
