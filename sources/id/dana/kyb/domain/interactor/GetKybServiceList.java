package id.dana.kyb.domain.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.kyb.domain.KybRepository;
import id.dana.kyb.domain.constant.KybDefaultServices;
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/kyb/domain/interactor/GetKybServiceList;", "Lid/dana/domain/core/usecase/BaseUseCase;", "", "Lid/dana/kyb/domain/model/KybService;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/kyb/domain/KybRepository;", "PlaceComponentResult", "Lid/dana/kyb/domain/KybRepository;", "p0", "<init>", "(Lid/dana/kyb/domain/KybRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetKybServiceList extends BaseUseCase<List<? extends KybService>, NoParams> {
    private final KybRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<List<? extends KybService>> buildUseCase(NoParams noParams) {
        Observable<List<? extends KybService>> BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(noParams, "");
        Observable<List<String>> KClassImpl$Data$declaredNonStaticMembers$2 = this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2();
        KybDefaultServices kybDefaultServices = KybDefaultServices.INSTANCE;
        Observable<List<String>> onErrorReturnItem = KClassImpl$Data$declaredNonStaticMembers$2.onErrorReturnItem(KybDefaultServices.PlaceComponentResult());
        Intrinsics.checkNotNullExpressionValue(onErrorReturnItem, "");
        Single list = ObservableKt.BuiltInFictitiousFunctionClassFactory(onErrorReturnItem).filter(new Predicate() { // from class: id.dana.kyb.domain.interactor.GetKybServiceList$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean KClassImpl$Data$declaredNonStaticMembers$22;
                KClassImpl$Data$declaredNonStaticMembers$22 = GetKybServiceList.KClassImpl$Data$declaredNonStaticMembers$2((String) obj);
                return KClassImpl$Data$declaredNonStaticMembers$22;
            }
        }).concatMapEager(new Function() { // from class: id.dana.kyb.domain.interactor.GetKybServiceList$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetKybServiceList.MyBillsEntityDataFactory(GetKybServiceList.this, (String) obj);
            }
        }).filter(new Predicate() { // from class: id.dana.kyb.domain.interactor.GetKybServiceList$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean MyBillsEntityDataFactory;
                MyBillsEntityDataFactory = GetKybServiceList.MyBillsEntityDataFactory((KybService) obj);
                return MyBillsEntityDataFactory;
            }
        }).toList();
        if (list instanceof FuseToObservable) {
            BuiltInFictitiousFunctionClassFactory = ((FuseToObservable) list).getAuthRequestContext();
        } else {
            BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new SingleToObservable(list));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Inject
    public GetKybServiceList(KybRepository kybRepository) {
        Intrinsics.checkNotNullParameter(kybRepository, "");
        this.PlaceComponentResult = kybRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean MyBillsEntityDataFactory(KybService kybService) {
        Intrinsics.checkNotNullParameter(kybService, "");
        return kybService.getEnable();
    }

    public static /* synthetic */ KybService getAuthRequestContext(String str, KybService kybService) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(kybService, "");
        return KybService.copy$default(kybService, false, null, null, str, null, null, 55, null);
    }

    public static /* synthetic */ ObservableSource MyBillsEntityDataFactory(GetKybServiceList getKybServiceList, final String str) {
        Intrinsics.checkNotNullParameter(getKybServiceList, "");
        Intrinsics.checkNotNullParameter(str, "");
        Observable<R> map = getKybServiceList.PlaceComponentResult.MyBillsEntityDataFactory(str).map(new Function() { // from class: id.dana.kyb.domain.interactor.GetKybServiceList$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return GetKybServiceList.getAuthRequestContext(str, (KybService) obj);
            }
        });
        KybDefaultServices kybDefaultServices = KybDefaultServices.INSTANCE;
        return map.onErrorReturnItem(KybDefaultServices.getAuthRequestContext(str));
    }
}
