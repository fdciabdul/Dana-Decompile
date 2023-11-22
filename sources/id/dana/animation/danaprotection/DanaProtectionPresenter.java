package id.dana.animation.danaprotection;

import dagger.Lazy;
import id.dana.animation.danaprotection.DanaProtectionContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BasePresenter;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionInfo;
import id.dana.domain.danaprotection.interactor.GetDanaProtectionRecommendation;
import id.dana.domain.danaprotection.model.DanaProtectionInfoModel;
import id.dana.domain.danaprotection.model.DanaProtectionRecommendationModel;
import id.dana.domain.danaprotection.model.DanaProtectionWidgetConfig;
import id.dana.domain.featureconfig.interactor.GetDanaProtectionWidgetConfig;
import id.dana.domain.home.interactor.GetDanaProtectionHomeWidgetInfoWithConfigFromLocal;
import id.dana.domain.home.interactor.SaveDanaProtectionHomeWidgetInfoLocal;
import id.dana.domain.home.model.DanaProtectionHomeWidgetInfoModel;
import id.dana.domain.home.model.DanaProtectionHomeWidgetModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002BW\b\u0007\u0012\u0006\u0010%\u001a\u00020#\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u0012\u0012\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012\u0012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020!0\u0012¢\u0006\u0004\b+\u0010,J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0005R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\t\u001a\f\u0012\b\u0012\u0006*\u00020\u000e0\u000e0\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00180\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\f\u0012\b\u0012\u0006*\u00020\u000e0\u000e0\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0012\u0010\u0017\u001a\u00020\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u001c\u0010\u001d\u001a\f\u0012\b\u0012\u0006*\u00020\u000e0\u000e0\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u000fR\u0012\u0010\u0019\u001a\u00020\u001eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR\u001c\u0010 \u001a\f\u0012\b\u0012\u0006*\u00020\u000e0\u000e0\rX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010\u0015R\u0014\u0010\u001b\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010$"}, d2 = {"Lid/dana/home/danaprotection/DanaProtectionPresenter;", "Lid/dana/home/danaprotection/DanaProtectionContract$Presenter;", "Lid/dana/base/BasePresenter;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "onDestroy", "getAuthRequestContext", "Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "MyBillsEntityDataFactory", "Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "Lio/reactivex/subjects/PublishSubject;", "", "Lio/reactivex/subjects/PublishSubject;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Z", "Ldagger/Lazy;", "Lid/dana/domain/home/interactor/GetDanaProtectionHomeWidgetInfoWithConfigFromLocal;", "moveToNextValue", "Ldagger/Lazy;", "Lid/dana/domain/danaprotection/interactor/GetDanaProtectionInfo;", "getErrorConfigVersion", "Lid/dana/domain/danaprotection/interactor/GetDanaProtectionRecommendation;", "GetContactSyncConfig", "Lid/dana/domain/featureconfig/interactor/GetDanaProtectionWidgetConfig;", "initRecordTimeStamp", "scheduleImpl", "lookAheadTest", "", "I", "DatabaseTableConfigUtil", "Lid/dana/domain/home/interactor/SaveDanaProtectionHomeWidgetInfoLocal;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/home/danaprotection/DanaProtectionContract$View;", "Lid/dana/home/danaprotection/DanaProtectionContract$View;", "p0", "p1", "p2", "p3", "p4", "p5", "<init>", "(Lid/dana/home/danaprotection/DanaProtectionContract$View;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaProtectionPresenter extends BasePresenter implements DanaProtectionContract.Presenter {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    boolean getErrorConfigVersion;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final DanaProtectionContract.View initRecordTimeStamp;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy<GetDanaProtectionRecommendation> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public PublishSubject<Boolean> lookAheadTest;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    DanaProtectionInfoModel PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    private final Lazy<SaveDanaProtectionHomeWidgetInfoLocal> NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public PublishSubject<Boolean> scheduleImpl;
    PublishSubject<Boolean> getAuthRequestContext;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final Lazy<GetDanaProtectionInfo> MyBillsEntityDataFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Lazy<GetDanaProtectionWidgetConfig> moveToNextValue;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    int GetContactSyncConfig;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final Lazy<GetDanaProtectionHomeWidgetInfoWithConfigFromLocal> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    PublishSubject<Boolean> DatabaseTableConfigUtil;

    @Inject
    public DanaProtectionPresenter(DanaProtectionContract.View view, Lazy<GetDanaProtectionInfo> lazy, Lazy<GetDanaProtectionRecommendation> lazy2, Lazy<GetDanaProtectionWidgetConfig> lazy3, Lazy<GetDanaProtectionHomeWidgetInfoWithConfigFromLocal> lazy4, Lazy<SaveDanaProtectionHomeWidgetInfoLocal> lazy5) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        Intrinsics.checkNotNullParameter(lazy3, "");
        Intrinsics.checkNotNullParameter(lazy4, "");
        Intrinsics.checkNotNullParameter(lazy5, "");
        this.initRecordTimeStamp = view;
        this.MyBillsEntityDataFactory = lazy;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = lazy2;
        this.moveToNextValue = lazy3;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = lazy5;
        PublishSubject<Boolean> PlaceComponentResult = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        this.DatabaseTableConfigUtil = PlaceComponentResult;
        PublishSubject<Boolean> PlaceComponentResult2 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        this.getAuthRequestContext = PlaceComponentResult2;
        PublishSubject<Boolean> PlaceComponentResult3 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult3, "");
        this.lookAheadTest = PlaceComponentResult3;
        PublishSubject<Boolean> PlaceComponentResult4 = PublishSubject.PlaceComponentResult();
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult4, "");
        this.scheduleImpl = PlaceComponentResult4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return bool.booleanValue();
    }

    @Override // id.dana.home.danaprotection.DanaProtectionContract.Presenter
    public final void PlaceComponentResult() {
        this.lookAheadTest.onNext(Boolean.TRUE);
    }

    @Override // id.dana.home.danaprotection.DanaProtectionContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().execute(NoParams.INSTANCE, new Function1<DanaProtectionHomeWidgetModel, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionDataFromMemory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DanaProtectionHomeWidgetModel danaProtectionHomeWidgetModel) {
                invoke2(danaProtectionHomeWidgetModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DanaProtectionHomeWidgetModel danaProtectionHomeWidgetModel) {
                Intrinsics.checkNotNullParameter(danaProtectionHomeWidgetModel, "");
                DanaProtectionPresenter.PlaceComponentResult(DanaProtectionPresenter.this, danaProtectionHomeWidgetModel);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionDataFromMemory$2
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
                DanaProtectionPresenter.MyBillsEntityDataFactory(DanaProtectionPresenter.this);
            }
        });
    }

    @Override // id.dana.home.danaprotection.DanaProtectionContract.Presenter
    public final void getAuthRequestContext() {
        PublishSubject<Boolean> publishSubject = this.getAuthRequestContext;
        Boolean bool = Boolean.FALSE;
        publishSubject.onNext(bool);
        this.DatabaseTableConfigUtil.onNext(bool);
    }

    @Override // id.dana.base.AbstractContractKt.AbstractPresenter, id.dana.base.AbstractContract.AbstractPresenter
    public final void onDestroy() {
        AbstractContractKt.AbstractPresenter.CC.BuiltInFictitiousFunctionClassFactory();
        this.MyBillsEntityDataFactory.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.get().dispose();
        this.moveToNextValue.get().dispose();
        this.KClassImpl$Data$declaredNonStaticMembers$2.get().dispose();
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.get().dispose();
    }

    public static /* synthetic */ Boolean MyBillsEntityDataFactory(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final DanaProtectionPresenter danaProtectionPresenter) {
        Intrinsics.checkNotNullParameter(danaProtectionPresenter, "");
        danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory = danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory;
        danaProtectionPresenter.moveToNextValue.get().execute(NoParams.INSTANCE, new Function1<DanaProtectionWidgetConfig, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionInfoFromBE$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DanaProtectionWidgetConfig danaProtectionWidgetConfig) {
                invoke2(danaProtectionWidgetConfig);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DanaProtectionWidgetConfig danaProtectionWidgetConfig) {
                boolean z = false;
                DanaProtectionPresenter.this.getErrorConfigVersion = danaProtectionWidgetConfig != null ? danaProtectionWidgetConfig.isNewWidgetEnabled() : false;
                DanaProtectionPresenter.MyBillsEntityDataFactory(DanaProtectionPresenter.this, (danaProtectionWidgetConfig != null && danaProtectionWidgetConfig.isApiToggleEnabled()) && danaProtectionWidgetConfig.isNewWidgetEnabled(), danaProtectionWidgetConfig != null ? danaProtectionWidgetConfig.getExpiredCacheTimeInMinute() : 0);
                DanaProtectionPresenter danaProtectionPresenter2 = DanaProtectionPresenter.this;
                if (danaProtectionWidgetConfig != null && danaProtectionWidgetConfig.isNewWidgetEnabled()) {
                    z = true;
                }
                if (danaProtectionWidgetConfig != null) {
                    danaProtectionWidgetConfig.isApiToggleEnabled();
                }
                DanaProtectionPresenter.BuiltInFictitiousFunctionClassFactory(danaProtectionPresenter2, z);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionInfoFromBE$2
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
                PublishSubject<Boolean> publishSubject = DanaProtectionPresenter.this.getAuthRequestContext;
                Boolean bool = Boolean.TRUE;
                publishSubject.onNext(bool);
                DanaProtectionPresenter.this.DatabaseTableConfigUtil.onNext(bool);
            }
        });
    }

    public static /* synthetic */ Boolean KClassImpl$Data$declaredNonStaticMembers$2(Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(bool, "");
        Intrinsics.checkNotNullParameter(bool2, "");
        return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
    }

    public static /* synthetic */ void getAuthRequestContext(DanaProtectionPresenter danaProtectionPresenter) {
        Intrinsics.checkNotNullParameter(danaProtectionPresenter, "");
        if (danaProtectionPresenter.getErrorConfigVersion) {
            DanaProtectionInfoModel danaProtectionInfoModel = danaProtectionPresenter.PlaceComponentResult;
            if (danaProtectionInfoModel != null) {
                int i = danaProtectionPresenter.GetContactSyncConfig;
                if (danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory) {
                    danaProtectionPresenter.initRecordTimeStamp.PlaceComponentResult(danaProtectionInfoModel, i);
                }
                DanaProtectionInfoModel danaProtectionInfoModel2 = danaProtectionPresenter.PlaceComponentResult;
                int i2 = danaProtectionPresenter.GetContactSyncConfig;
                if (danaProtectionInfoModel2 != null) {
                    danaProtectionPresenter.NetworkUserEntityData$$ExternalSyntheticLambda1.get().execute(new DanaProtectionHomeWidgetInfoModel(danaProtectionInfoModel2.getProtectedActivity(), danaProtectionInfoModel2.getSuspiciousActivity(), danaProtectionInfoModel2.getTimeRange(), i2), new Function0<Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$saveDanaProtectionHomeWidgetInfoLocal$1$1
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, new Function1<Throwable, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$saveDanaProtectionHomeWidgetInfoLocal$1$2
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(Throwable th) {
                            Intrinsics.checkNotNullParameter(th, "");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                            invoke2(th);
                            return Unit.INSTANCE;
                        }
                    });
                }
            } else if (danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory) {
                danaProtectionPresenter.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory();
            }
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final DanaProtectionPresenter danaProtectionPresenter, boolean z, int i) {
        if (!z) {
            danaProtectionPresenter.getAuthRequestContext.onNext(Boolean.TRUE);
            danaProtectionPresenter.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
            return;
        }
        danaProtectionPresenter.MyBillsEntityDataFactory.get().execute(Integer.valueOf(i), new Function1<DanaProtectionInfoModel, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionInfoModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(DanaProtectionInfoModel danaProtectionInfoModel) {
                invoke2(danaProtectionInfoModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DanaProtectionInfoModel danaProtectionInfoModel) {
                Intrinsics.checkNotNullParameter(danaProtectionInfoModel, "");
                DanaProtectionPresenter.this.PlaceComponentResult = danaProtectionInfoModel;
                DanaProtectionPresenter.this.getAuthRequestContext.onNext(Boolean.TRUE);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionInfoModel$2
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
                DanaProtectionPresenter.this.getAuthRequestContext.onNext(Boolean.TRUE);
            }
        });
        danaProtectionPresenter.NetworkUserEntityData$$ExternalSyntheticLambda0.get().execute(new GetDanaProtectionRecommendation.Params("1.0.0", false, 2, null), new Function1<List<DanaProtectionRecommendationModel>, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionRecommendation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<DanaProtectionRecommendationModel> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<DanaProtectionRecommendationModel> list) {
                Intrinsics.checkNotNullParameter(list, "");
                DanaProtectionPresenter danaProtectionPresenter2 = DanaProtectionPresenter.this;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if ((!((DanaProtectionRecommendationModel) obj).getEnable()) != false) {
                        arrayList.add(obj);
                    }
                }
                danaProtectionPresenter2.GetContactSyncConfig = arrayList.size();
                DanaProtectionPresenter.this.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$getDanaProtectionRecommendation$2
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
                DanaProtectionPresenter.this.DatabaseTableConfigUtil.onNext(Boolean.TRUE);
            }
        });
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(DanaProtectionPresenter danaProtectionPresenter) {
        danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory = true;
        danaProtectionPresenter.scheduleImpl.onNext(Boolean.TRUE);
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(DanaProtectionPresenter danaProtectionPresenter, boolean z) {
        if (danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory) {
            danaProtectionPresenter.initRecordTimeStamp.KClassImpl$Data$declaredNonStaticMembers$2(z);
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(DanaProtectionPresenter danaProtectionPresenter, DanaProtectionHomeWidgetModel danaProtectionHomeWidgetModel) {
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel = danaProtectionHomeWidgetModel.getDanaProtectionHomeWidgetInfoModel();
        Boolean bool = Boolean.TRUE;
        if (danaProtectionHomeWidgetInfoModel == null || danaProtectionHomeWidgetModel.getConfig() == null) {
            danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory = true;
            danaProtectionPresenter.scheduleImpl.onNext(bool);
            return;
        }
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel2 = danaProtectionHomeWidgetModel.getDanaProtectionHomeWidgetInfoModel();
        Intrinsics.checkNotNull(danaProtectionHomeWidgetInfoModel2);
        int protectedActivity = danaProtectionHomeWidgetInfoModel2.getProtectedActivity();
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel3 = danaProtectionHomeWidgetModel.getDanaProtectionHomeWidgetInfoModel();
        Intrinsics.checkNotNull(danaProtectionHomeWidgetInfoModel3);
        int suspiciousActivity = danaProtectionHomeWidgetInfoModel3.getSuspiciousActivity();
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel4 = danaProtectionHomeWidgetModel.getDanaProtectionHomeWidgetInfoModel();
        Intrinsics.checkNotNull(danaProtectionHomeWidgetInfoModel4);
        danaProtectionPresenter.PlaceComponentResult = new DanaProtectionInfoModel(protectedActivity, suspiciousActivity, danaProtectionHomeWidgetInfoModel4.getSuspiciousActivity());
        DanaProtectionHomeWidgetInfoModel danaProtectionHomeWidgetInfoModel5 = danaProtectionHomeWidgetModel.getDanaProtectionHomeWidgetInfoModel();
        Intrinsics.checkNotNull(danaProtectionHomeWidgetInfoModel5);
        danaProtectionPresenter.GetContactSyncConfig = danaProtectionHomeWidgetInfoModel5.getRecommendationCount();
        DanaProtectionContract.View view = danaProtectionPresenter.initRecordTimeStamp;
        DanaProtectionWidgetConfig config = danaProtectionHomeWidgetModel.getConfig();
        boolean z = config != null && config.isNewWidgetEnabled();
        DanaProtectionWidgetConfig config2 = danaProtectionHomeWidgetModel.getConfig();
        if (config2 != null) {
            config2.isApiToggleEnabled();
        }
        view.KClassImpl$Data$declaredNonStaticMembers$2(z);
        DanaProtectionWidgetConfig config3 = danaProtectionHomeWidgetModel.getConfig();
        if (config3 != null && config3.isNewWidgetEnabled()) {
            danaProtectionPresenter.initRecordTimeStamp.PlaceComponentResult(danaProtectionPresenter.PlaceComponentResult, danaProtectionPresenter.GetContactSyncConfig);
        }
        danaProtectionPresenter.BuiltInFictitiousFunctionClassFactory = false;
        danaProtectionPresenter.scheduleImpl.onNext(bool);
    }

    @Override // id.dana.home.danaprotection.DanaProtectionContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        addDisposable(Observable.combineLatest(this.getAuthRequestContext, this.DatabaseTableConfigUtil, new BiFunction() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DanaProtectionPresenter.KClassImpl$Data$declaredNonStaticMembers$2((Boolean) obj, (Boolean) obj2);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean authRequestContext;
                authRequestContext = DanaProtectionPresenter.getAuthRequestContext((Boolean) obj);
                return authRequestContext;
            }
        }).subscribe(new Consumer() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Boolean bool = (Boolean) obj;
                DanaProtectionPresenter.getAuthRequestContext(DanaProtectionPresenter.this);
            }
        }));
        addDisposable(Observable.combineLatest(this.lookAheadTest, this.scheduleImpl, new BiFunction() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DanaProtectionPresenter.MyBillsEntityDataFactory((Boolean) obj, (Boolean) obj2);
            }
        }).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribeOn(Schedulers.MyBillsEntityDataFactory()).filter(new Predicate() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean BuiltInFictitiousFunctionClassFactory;
                BuiltInFictitiousFunctionClassFactory = DanaProtectionPresenter.BuiltInFictitiousFunctionClassFactory((Boolean) obj);
                return BuiltInFictitiousFunctionClassFactory;
            }
        }).subscribe(new Consumer() { // from class: id.dana.home.danaprotection.DanaProtectionPresenter$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Boolean bool = (Boolean) obj;
                DanaProtectionPresenter.BuiltInFictitiousFunctionClassFactory(DanaProtectionPresenter.this);
            }
        }));
    }
}
