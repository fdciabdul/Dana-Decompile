package id.dana.riskChallenges.domain.passkey.interactor;

import com.alibaba.fastjson.JSONObject;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.core.usecase.NoParams;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCeremony;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.plugins.RxJavaPlugins;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyFinish;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/core/usecase/NoParams;", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Params;", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "PlaceComponentResult", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyCeremonyFinish extends BaseUseCase<NoParams, PasskeyCeremony.Params> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final PasskeyRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<NoParams> buildUseCase(PasskeyCeremony.Params params) {
        PasskeyCeremony.Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        if (params2.getAuthRequestContext()) {
            PasskeyRepository passkeyRepository = this.MyBillsEntityDataFactory;
            JSONObject jSONObject = params2.MyBillsEntityDataFactory;
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            Observable map = passkeyRepository.MyBillsEntityDataFactory(jSONObject).map(new Function() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyFinish$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PasskeyCeremonyFinish.getAuthRequestContext((Boolean) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            return map;
        }
        PasskeyRepository passkeyRepository2 = this.MyBillsEntityDataFactory;
        JSONObject jSONObject2 = params2.MyBillsEntityDataFactory;
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        Completable PlaceComponentResult = passkeyRepository2.PlaceComponentResult(jSONObject2);
        Observable just = Observable.just(NoParams.INSTANCE);
        ObjectHelper.PlaceComponentResult(just, "next is null");
        Observable<NoParams> BuiltInFictitiousFunctionClassFactory = RxJavaPlugins.BuiltInFictitiousFunctionClassFactory(new CompletableAndThenObservable(PlaceComponentResult, just));
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Inject
    public PasskeyCeremonyFinish(PasskeyRepository passkeyRepository) {
        Intrinsics.checkNotNullParameter(passkeyRepository, "");
        this.MyBillsEntityDataFactory = passkeyRepository;
    }

    public static /* synthetic */ NoParams getAuthRequestContext(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "");
        return NoParams.INSTANCE;
    }
}
