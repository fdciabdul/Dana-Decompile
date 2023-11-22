package id.dana.riskChallenges.data.danaprotection;

import id.dana.riskChallenges.data.danaprotection.mapper.RiskChallengeStatusMapperKt;
import id.dana.riskChallenges.data.danaprotection.source.DanaProtectionEntityData;
import id.dana.riskChallenges.data.danaprotection.source.DanaProtectionEntityDataFactory;
import id.dana.riskChallenges.data.danaprotection.source.network.result.RiskChallengeStatusResult;
import id.dana.riskChallenges.domain.danaprotection.DanaProtectionRepository;
import id.dana.riskChallenges.domain.danaprotection.model.RiskChallengeStatusModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012J5\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\t\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0013\u0010\f\u001a\u00020\u000eX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/riskChallenges/data/danaprotection/DanaProtectionEntityRepository;", "Lid/dana/riskChallenges/domain/danaprotection/DanaProtectionRepository;", "", "p0", "p1", "p2", "p3", "Lio/reactivex/Observable;", "Lid/dana/riskChallenges/domain/danaprotection/model/RiskChallengeStatusModel;", "PlaceComponentResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/riskChallenges/data/danaprotection/source/DanaProtectionEntityDataFactory;", "MyBillsEntityDataFactory", "Lid/dana/riskChallenges/data/danaprotection/source/DanaProtectionEntityDataFactory;", "Lid/dana/riskChallenges/data/danaprotection/source/DanaProtectionEntityData;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "<init>", "(Lid/dana/riskChallenges/data/danaprotection/source/DanaProtectionEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaProtectionEntityRepository implements DanaProtectionRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final DanaProtectionEntityDataFactory PlaceComponentResult;

    @Inject
    public DanaProtectionEntityRepository(DanaProtectionEntityDataFactory danaProtectionEntityDataFactory) {
        Intrinsics.checkNotNullParameter(danaProtectionEntityDataFactory, "");
        this.PlaceComponentResult = danaProtectionEntityDataFactory;
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<DanaProtectionEntityData>() { // from class: id.dana.riskChallenges.data.danaprotection.DanaProtectionEntityRepository$networkDanaProtectionInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final DanaProtectionEntityData invoke() {
                DanaProtectionEntityDataFactory danaProtectionEntityDataFactory2;
                danaProtectionEntityDataFactory2 = DanaProtectionEntityRepository.this.PlaceComponentResult;
                return danaProtectionEntityDataFactory2.getAuthRequestContext;
            }
        });
    }

    public static /* synthetic */ RiskChallengeStatusModel getAuthRequestContext(RiskChallengeStatusResult riskChallengeStatusResult) {
        Intrinsics.checkNotNullParameter(riskChallengeStatusResult, "");
        return RiskChallengeStatusMapperKt.getAuthRequestContext(riskChallengeStatusResult);
    }

    @Override // id.dana.riskChallenges.domain.danaprotection.DanaProtectionRepository
    public final Observable<RiskChallengeStatusModel> PlaceComponentResult(String p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Observable map = ((DanaProtectionEntityData) this.MyBillsEntityDataFactory.getValue()).getAuthRequestContext(p0, p1, p2, p3).map(new Function() { // from class: id.dana.riskChallenges.data.danaprotection.DanaProtectionEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return DanaProtectionEntityRepository.getAuthRequestContext((RiskChallengeStatusResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
