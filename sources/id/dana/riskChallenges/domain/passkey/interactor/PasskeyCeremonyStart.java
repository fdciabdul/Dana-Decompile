package id.dana.riskChallenges.domain.passkey.interactor;

import com.alibaba.fastjson.JSONObject;
import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.riskChallenges.domain.passkey.PasskeyRepository;
import id.dana.riskChallenges.domain.passkey.model.PasskeyCeremony;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002 \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0002\u0012\u0004\u0012\u00020\u00060\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/interactor/PasskeyCeremonyStart;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lkotlin/Pair;", "", "", "Lid/dana/riskChallenges/ui/resetpin/model/VerificationMethodModel;", "Lid/dana/riskChallenges/domain/passkey/model/PasskeyCeremony$Params;", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;", "MyBillsEntityDataFactory", "p0", "<init>", "(Lid/dana/riskChallenges/domain/passkey/PasskeyRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PasskeyCeremonyStart extends BaseUseCase<Pair<? extends String, ? extends List<? extends VerificationMethodModel>>, PasskeyCeremony.Params> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final PasskeyRepository MyBillsEntityDataFactory;

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final /* synthetic */ Observable<Pair<? extends String, ? extends List<? extends VerificationMethodModel>>> buildUseCase(PasskeyCeremony.Params params) {
        PasskeyCeremony.Params params2 = params;
        Intrinsics.checkNotNullParameter(params2, "");
        if (params2.getAuthRequestContext()) {
            Observable map = this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(params2.PlaceComponentResult, params2.getAuthRequestContext).map(new Function() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyStart$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return PasskeyCeremonyStart.PlaceComponentResult((Pair) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(map, "");
            return map;
        }
        Observable map2 = this.MyBillsEntityDataFactory.getAuthRequestContext().map(new Function() { // from class: id.dana.riskChallenges.domain.passkey.interactor.PasskeyCeremonyStart$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return PasskeyCeremonyStart.getAuthRequestContext((JSONObject) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map2, "");
        return map2;
    }

    @Inject
    public PasskeyCeremonyStart(PasskeyRepository passkeyRepository) {
        Intrinsics.checkNotNullParameter(passkeyRepository, "");
        this.MyBillsEntityDataFactory = passkeyRepository;
    }

    public static /* synthetic */ Pair getAuthRequestContext(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "");
        String obj = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return new Pair(obj, CollectionsKt.emptyList());
    }

    public static /* synthetic */ Pair PlaceComponentResult(Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "");
        return new Pair(((JSONObject) pair.getFirst()).toString(), pair.getSecond());
    }
}
