package id.dana.data.csatsurvey.repository;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.csatsurvey.repository.source.CsatSurveyCreatedDateDataFactory;
import id.dana.data.csatsurvey.repository.source.CsatSurveyCreatedDateEntityData;
import id.dana.data.csatsurvey.repository.source.DismissCsatSurveyDataFactory;
import id.dana.data.csatsurvey.repository.source.DismissCsatSurveyEntityData;
import id.dana.domain.csatsurvey.CsatSurveyRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000f¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\u0013\u0010\u0015\u001a\u00020\u0012X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0013\u0010\f\u001a\u00020\u0016X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014"}, d2 = {"Lid/dana/data/csatsurvey/repository/CsatSurveyEntityRepository;", "Lid/dana/domain/csatsurvey/CsatSurveyRepository;", "", "p0", "Lio/reactivex/Observable;", "", "dismissCsatSurvey", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getCsatSurveyCreatedDate", "()Lio/reactivex/Observable;", "saveCsatSurveyCreatedDate", "Lid/dana/data/csatsurvey/repository/source/CsatSurveyCreatedDateDataFactory;", "PlaceComponentResult", "Lid/dana/data/csatsurvey/repository/source/CsatSurveyCreatedDateDataFactory;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/csatsurvey/repository/source/DismissCsatSurveyDataFactory;", "Lid/dana/data/csatsurvey/repository/source/DismissCsatSurveyDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/data/csatsurvey/repository/source/CsatSurveyCreatedDateEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/data/csatsurvey/repository/source/DismissCsatSurveyEntityData;", "p1", "<init>", "(Lid/dana/data/csatsurvey/repository/source/CsatSurveyCreatedDateDataFactory;Lid/dana/data/csatsurvey/repository/source/DismissCsatSurveyDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CsatSurveyEntityRepository implements CsatSurveyRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final DismissCsatSurveyDataFactory MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final CsatSurveyCreatedDateDataFactory BuiltInFictitiousFunctionClassFactory;

    @Inject
    public CsatSurveyEntityRepository(CsatSurveyCreatedDateDataFactory csatSurveyCreatedDateDataFactory, DismissCsatSurveyDataFactory dismissCsatSurveyDataFactory) {
        Intrinsics.checkNotNullParameter(csatSurveyCreatedDateDataFactory, "");
        Intrinsics.checkNotNullParameter(dismissCsatSurveyDataFactory, "");
        this.BuiltInFictitiousFunctionClassFactory = csatSurveyCreatedDateDataFactory;
        this.MyBillsEntityDataFactory = dismissCsatSurveyDataFactory;
        this.getAuthRequestContext = LazyKt.lazy(new Function0<CsatSurveyCreatedDateEntityData>() { // from class: id.dana.data.csatsurvey.repository.CsatSurveyEntityRepository$localCsatSurveyCreatedDateEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CsatSurveyCreatedDateEntityData invoke() {
                CsatSurveyCreatedDateDataFactory csatSurveyCreatedDateDataFactory2;
                csatSurveyCreatedDateDataFactory2 = CsatSurveyEntityRepository.this.BuiltInFictitiousFunctionClassFactory;
                return csatSurveyCreatedDateDataFactory2.PlaceComponentResult;
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<DismissCsatSurveyEntityData>() { // from class: id.dana.data.csatsurvey.repository.CsatSurveyEntityRepository$networkDismissCsatSurveyEntityData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DismissCsatSurveyEntityData invoke() {
                DismissCsatSurveyDataFactory dismissCsatSurveyDataFactory2;
                dismissCsatSurveyDataFactory2 = CsatSurveyEntityRepository.this.MyBillsEntityDataFactory;
                return dismissCsatSurveyDataFactory2.getAuthRequestContext;
            }
        });
    }

    public static /* synthetic */ Boolean PlaceComponentResult(BaseRpcResult baseRpcResult) {
        Intrinsics.checkNotNullParameter(baseRpcResult, "");
        return Boolean.valueOf(baseRpcResult.success);
    }

    @Override // id.dana.domain.csatsurvey.CsatSurveyRepository
    public final Observable<Boolean> dismissCsatSurvey(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable map = ((DismissCsatSurveyEntityData) this.PlaceComponentResult.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(p0).map(new Function() { // from class: id.dana.data.csatsurvey.repository.CsatSurveyEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return CsatSurveyEntityRepository.PlaceComponentResult((BaseRpcResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    @Override // id.dana.domain.csatsurvey.CsatSurveyRepository
    public final Observable<String> getCsatSurveyCreatedDate() {
        return ((CsatSurveyCreatedDateEntityData) this.getAuthRequestContext.getValue()).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.domain.csatsurvey.CsatSurveyRepository
    public final Observable<Boolean> saveCsatSurveyCreatedDate(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return ((CsatSurveyCreatedDateEntityData) this.getAuthRequestContext.getValue()).MyBillsEntityDataFactory(p0);
    }
}
