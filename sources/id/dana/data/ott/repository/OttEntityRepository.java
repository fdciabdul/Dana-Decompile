package id.dana.data.ott.repository;

import id.dana.data.ott.OttVerifyEntity;
import id.dana.data.ott.mapper.OttEnityMapperKt;
import id.dana.data.ott.repository.source.OttEntityDataFactory;
import id.dana.data.ott.repository.source.network.NetworkOttEntityData;
import id.dana.domain.ott.OttVerifyResult;
import id.dana.domain.ott.repository.OttRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/ott/repository/OttEntityRepository;", "Lid/dana/domain/ott/repository/OttRepository;", "", "p0", "Lio/reactivex/Observable;", "Lid/dana/domain/ott/OttVerifyResult;", "getOttVerify", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/data/ott/repository/source/OttEntityDataFactory;", "PlaceComponentResult", "Lid/dana/data/ott/repository/source/OttEntityDataFactory;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lid/dana/data/ott/repository/source/OttEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OttEntityRepository implements OttRepository {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final OttEntityDataFactory KClassImpl$Data$declaredNonStaticMembers$2;

    @Inject
    public OttEntityRepository(OttEntityDataFactory ottEntityDataFactory) {
        Intrinsics.checkNotNullParameter(ottEntityDataFactory, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ottEntityDataFactory;
    }

    public static /* synthetic */ OttVerifyResult PlaceComponentResult(OttVerifyEntity ottVerifyEntity) {
        Intrinsics.checkNotNullParameter(ottVerifyEntity, "");
        return OttEnityMapperKt.getAuthRequestContext(ottVerifyEntity);
    }

    @Override // id.dana.domain.ott.repository.OttRepository
    public final Observable<OttVerifyResult> getOttVerify(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        OttEntityDataFactory ottEntityDataFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Observable map = new NetworkOttEntityData(ottEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ottEntityDataFactory.PlaceComponentResult, ottEntityDataFactory.BuiltInFictitiousFunctionClassFactory, ottEntityDataFactory.getAuthRequestContext).KClassImpl$Data$declaredNonStaticMembers$2(p0).map(new Function() { // from class: id.dana.data.ott.repository.OttEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return OttEntityRepository.PlaceComponentResult((OttVerifyEntity) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }
}
