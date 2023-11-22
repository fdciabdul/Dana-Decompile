package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.constant.KybDefaultServices;
import id.dana.kyb.domain.constant.KybServiceCategory;
import id.dana.kyb.domain.model.KybService;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.rxkotlin.ObservableKt;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\fB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybTopServices;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/kyb/domain/model/KybService;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/kyb/domain/KybRepository;", "PlaceComponentResult", "Lid/dana/kyb/domain/KybRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/kyb/domain/KybRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetKybTopServices extends BaseUseCase<List<? extends KybService>, NoParams> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final KybRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends KybService>> buildUseCase(NoParams noParams) {
        List<String> listOf;
        Observable<List<? extends KybService>> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<List<String>> errorConfigVersion = this.MyBillsEntityDataFactory.getErrorConfigVersion();
        KybDefaultServices kybDefaultServices = KybDefaultServices.INSTANCE;
        listOf = CollectionsKt.listOf((Object[]) new String[]{KybServiceCategory.REQUEST_PAYMENT, KybServiceCategory.PRODUCT_CATALOG, KybServiceCategory.QRIS_BUSINESS});
        Observable<List<String>> onErrorReturnItem = errorConfigVersion.onErrorReturnItem(listOf);
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        Single list = ObservableKt.BuiltInFictitiousFunctionClassFactory(onErrorReturnItem).filter(new Predicate() { // from class: id.dana.kyb.domain.interactor.GetKybTopServices$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean authRequestContext;
                authRequestContext = GetKybTopServices.getAuthRequestContext((String) obj);
                return authRequestContext;
            }
        }).concatMapEager(new Function() { // from class: id.dana.kyb.domain.interactor.GetKybTopServices$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetKybTopServices.MyBillsEntityDataFactory(GetKybTopServices.this, (String) obj);
            }
        }).filter(new Predicate() { // from class: id.dana.kyb.domain.interactor.GetKybTopServices$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean BuiltInFictitiousFunctionClassFactory2;
                BuiltInFictitiousFunctionClassFactory2 = GetKybTopServices.BuiltInFictitiousFunctionClassFactory((KybService) obj);
                return BuiltInFictitiousFunctionClassFactory2;
            }
        }).take(3L).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Inject
    public GetKybTopServices(KybRepository kybRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        this.MyBillsEntityDataFactory = kybRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean BuiltInFictitiousFunctionClassFactory(KybService kybService) {
        Intrinsics.checkNotNullParameter(kybService, "");
        return kybService.getEnable();
    }

    public static /* synthetic */ KybService getAuthRequestContext(String str, KybService kybService) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(kybService, "");
        return KybService.copy$default(kybService, false, null, null, str, null, null, 55, null);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(GetKybTopServices getKybTopServices, final String str) {
        Intrinsics.checkNotNullParameter(getKybTopServices, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<R> map = getKybTopServices.MyBillsEntityDataFactory.MyBillsEntityDataFactory(str).map(new Function() { // from class: id.dana.kyb.domain.interactor.GetKybTopServices$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetKybTopServices.getAuthRequestContext(str, (KybService) obj);
            }
        });
        KybDefaultServices kybDefaultServices = KybDefaultServices.INSTANCE;
        return map.onErrorReturnItem(KybDefaultServices.getAuthRequestContext(str));
    }
}
