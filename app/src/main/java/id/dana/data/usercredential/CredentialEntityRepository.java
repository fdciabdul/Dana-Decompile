package id.dana.data.usercredential;

import id.dana.data.config.source.ConfigEntityData;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.data.usercredential.mapper.QueryCredentialInfoMapperKt;
import id.dana.data.usercredential.model.QueryCredentialInfoResult;
import id.dana.data.usercredential.repository.CredentialEntityData;
import id.dana.data.usercredential.repository.source.CredentialEntityDataFactory;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.usercredential.CredentialRepository;
import id.dana.domain.usercredential.model.PinRegularChangesConfig;
import id.dana.domain.usercredential.model.QueryCredentialInfoModel;
import id.dana.domain.util.DateTimeUtils;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0013\u0010\u0016\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0018R\u0013\u0010\u0012\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0017\u0010\u001a\u001a\u0006*\u00020\u00190\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001a\u0010\u0018"}, d2 = {"Lid/dana/data/usercredential/CredentialEntityRepository;", "Lid/dana/domain/usercredential/CredentialRepository;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/domain/usercredential/model/PinRegularChangesConfig;", "getFeaturePinRegularChangesConfig", "(Z)Lio/reactivex/Observable;", "", "p1", "Lid/dana/domain/usercredential/model/QueryCredentialInfoModel;", "getPasswordLastModified", "(ZI)Lio/reactivex/Observable;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(IJ)Z", "Ldagger/Lazy;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "getAuthRequestContext", "Ldagger/Lazy;", "PlaceComponentResult", "Lid/dana/data/usercredential/repository/source/CredentialEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/usercredential/repository/CredentialEntityData;", "Lkotlin/Lazy;", "Lid/dana/data/config/source/ConfigEntityData;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Ldagger/Lazy;Ldagger/Lazy;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CredentialEntityRepository implements CredentialRepository {
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final dagger.Lazy<CredentialEntityDataFactory> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final dagger.Lazy<ConfigEntityDataFactory> PlaceComponentResult;

    @Inject
    public CredentialEntityRepository(dagger.Lazy<CredentialEntityDataFactory> lazy, dagger.Lazy<ConfigEntityDataFactory> lazy2) {
        Intrinsics.checkNotNullParameter(lazy, "");
        Intrinsics.checkNotNullParameter(lazy2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy;
        this.PlaceComponentResult = lazy2;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<CredentialEntityData>() { // from class: id.dana.data.usercredential.CredentialEntityRepository$networkCredentialEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CredentialEntityData invoke() {
                dagger.Lazy lazy3;
                lazy3 = CredentialEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                CredentialEntityDataFactory credentialEntityDataFactory = (CredentialEntityDataFactory) lazy3.get();
                return Intrinsics.areEqual("network", "network") ? credentialEntityDataFactory.PlaceComponentResult : credentialEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<CredentialEntityData>() { // from class: id.dana.data.usercredential.CredentialEntityRepository$localCredentialEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CredentialEntityData invoke() {
                dagger.Lazy lazy3;
                lazy3 = CredentialEntityRepository.this.KClassImpl$Data$declaredNonStaticMembers$2;
                CredentialEntityDataFactory credentialEntityDataFactory = (CredentialEntityDataFactory) lazy3.get();
                return Intrinsics.areEqual("local", "network") ? credentialEntityDataFactory.PlaceComponentResult : credentialEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2;
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<ConfigEntityData>() { // from class: id.dana.data.usercredential.CredentialEntityRepository$splitConfigEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ConfigEntityData invoke() {
                dagger.Lazy lazy3;
                lazy3 = CredentialEntityRepository.this.PlaceComponentResult;
                return ((ConfigEntityDataFactory) lazy3.get()).createData2("split");
            }
        });
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int p0, long p1) {
        return DateTimeUtils.getDifference24HoursTimePeriod(DateTimeUtil.getCurrentTimeMillis(), p1) > ((long) p0);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(CredentialEntityRepository credentialEntityRepository, PinRegularChangesConfig pinRegularChangesConfig) {
        Intrinsics.checkNotNullParameter(credentialEntityRepository, "");
        CredentialEntityData credentialEntityData = (CredentialEntityData) credentialEntityRepository.MyBillsEntityDataFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(pinRegularChangesConfig, "");
        credentialEntityData.getAuthRequestContext(pinRegularChangesConfig);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(CredentialEntityRepository credentialEntityRepository, QueryCredentialInfoResult queryCredentialInfoResult) {
        Intrinsics.checkNotNullParameter(credentialEntityRepository, "");
        CredentialEntityData credentialEntityData = (CredentialEntityData) credentialEntityRepository.MyBillsEntityDataFactory.getValue();
        Intrinsics.checkNotNullExpressionValue(queryCredentialInfoResult, "");
        credentialEntityData.BuiltInFictitiousFunctionClassFactory(queryCredentialInfoResult);
    }

    public static /* synthetic */ QueryCredentialInfoModel BuiltInFictitiousFunctionClassFactory(int i, QueryCredentialInfoResult queryCredentialInfoResult) {
        Intrinsics.checkNotNullParameter(queryCredentialInfoResult, "");
        return QueryCredentialInfoMapperKt.BuiltInFictitiousFunctionClassFactory(queryCredentialInfoResult, i);
    }

    public static /* synthetic */ ObservableSource getAuthRequestContext(boolean z, final CredentialEntityRepository credentialEntityRepository, int i, QueryCredentialInfoResult queryCredentialInfoResult) {
        Observable<QueryCredentialInfoResult> doOnNext;
        Intrinsics.checkNotNullParameter(credentialEntityRepository, "");
        Intrinsics.checkNotNullParameter(queryCredentialInfoResult, "");
        if (z || queryCredentialInfoResult.getPasswordLastModifiedInEpoch() < 0 || KClassImpl$Data$declaredNonStaticMembers$2(i, queryCredentialInfoResult.getPasswordLastModifiedInEpoch())) {
            doOnNext = ((CredentialEntityData) credentialEntityRepository.getAuthRequestContext.getValue()).getAuthRequestContext().doOnNext(new Consumer() { // from class: id.dana.data.usercredential.CredentialEntityRepository$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    CredentialEntityRepository.MyBillsEntityDataFactory(CredentialEntityRepository.this, (QueryCredentialInfoResult) obj);
                }
            });
        } else {
            doOnNext = Observable.just(queryCredentialInfoResult);
        }
        return doOnNext;
    }

    @Override // id.dana.domain.usercredential.CredentialRepository
    public final Observable<PinRegularChangesConfig> getFeaturePinRegularChangesConfig(boolean p0) {
        PinRegularChangesConfig KClassImpl$Data$declaredNonStaticMembers$2 = ((CredentialEntityData) this.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
        if (p0 || KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            Observable<PinRegularChangesConfig> doOnNext = ((ConfigEntityData) this.BuiltInFictitiousFunctionClassFactory.getValue()).getFeaturePinRegularChanges().doOnNext(new Consumer() { // from class: id.dana.data.usercredential.CredentialEntityRepository$$ExternalSyntheticLambda3
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    CredentialEntityRepository.KClassImpl$Data$declaredNonStaticMembers$2(CredentialEntityRepository.this, (PinRegularChangesConfig) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(doOnNext, "");
            return doOnNext;
        }
        Observable<PinRegularChangesConfig> just = Observable.just(KClassImpl$Data$declaredNonStaticMembers$2);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.domain.usercredential.CredentialRepository
    public final Observable<QueryCredentialInfoModel> getPasswordLastModified(final boolean p0, final int p1) {
        Observable<QueryCredentialInfoModel> map = ((CredentialEntityData) this.MyBillsEntityDataFactory.getValue()).getAuthRequestContext().flatMap(new Function() { // from class: id.dana.data.usercredential.CredentialEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CredentialEntityRepository.getAuthRequestContext(p0, this, p1, (QueryCredentialInfoResult) obj);
            }
        }).map(new Function() { // from class: id.dana.data.usercredential.CredentialEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CredentialEntityRepository.BuiltInFictitiousFunctionClassFactory(p1, (QueryCredentialInfoResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
