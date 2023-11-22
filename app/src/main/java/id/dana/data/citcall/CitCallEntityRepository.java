package id.dana.data.citcall;

import id.dana.data.citcall.mapper.CitcallMapperKt;
import id.dana.data.citcall.source.CitCallEntityData;
import id.dana.data.citcall.source.CitCallEntityDataFactory;
import id.dana.data.config.model.CitcallPermissionConfig;
import id.dana.data.config.model.CitcallPermissionConfigKt;
import id.dana.data.config.source.ConfigEntityDataFactory;
import id.dana.domain.citcall.CitcallRepository;
import id.dana.domain.citcall.model.CitcallPermission;
import id.dana.domain.citcall.model.MiscallConsult;
import id.dana.domain.citcall.model.MiscallResponse;
import id.dana.network.response.citcall.MiscallResult;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007H\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lid/dana/data/citcall/CitCallEntityRepository;", "Lid/dana/domain/citcall/CitcallRepository;", "Lid/dana/data/citcall/source/CitCallEntityData;", "createNetworkCitcallEntityData", "()Lid/dana/data/citcall/source/CitCallEntityData;", "Lid/dana/domain/citcall/model/MiscallConsult;", "miscallConsult", "Lio/reactivex/Observable;", "Lid/dana/domain/citcall/model/MiscallResponse;", "createToken", "(Lid/dana/domain/citcall/model/MiscallConsult;)Lio/reactivex/Observable;", "Lid/dana/domain/citcall/model/CitcallPermission;", "getCitcallPermission", "()Lio/reactivex/Observable;", "Lid/dana/data/citcall/source/CitCallEntityDataFactory;", "citcallEntityDataFactory", "Lid/dana/data/citcall/source/CitCallEntityDataFactory;", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "configEntityDataFactory", "Lid/dana/data/config/source/ConfigEntityDataFactory;", "<init>", "(Lid/dana/data/citcall/source/CitCallEntityDataFactory;Lid/dana/data/config/source/ConfigEntityDataFactory;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CitCallEntityRepository implements CitcallRepository {
    private final CitCallEntityDataFactory citcallEntityDataFactory;
    private final ConfigEntityDataFactory configEntityDataFactory;

    @Inject
    public CitCallEntityRepository(CitCallEntityDataFactory citCallEntityDataFactory, ConfigEntityDataFactory configEntityDataFactory) {
        Intrinsics.checkNotNullParameter(citCallEntityDataFactory, "");
        Intrinsics.checkNotNullParameter(configEntityDataFactory, "");
        this.citcallEntityDataFactory = citCallEntityDataFactory;
        this.configEntityDataFactory = configEntityDataFactory;
    }

    @Override // id.dana.domain.citcall.CitcallRepository
    public final Observable<MiscallResponse> createToken(MiscallConsult miscallConsult) {
        Intrinsics.checkNotNullParameter(miscallConsult, "");
        Observable map = createNetworkCitcallEntityData().createToken(CitcallMapperKt.toMiscallRequest(miscallConsult)).map(new Function() { // from class: id.dana.data.citcall.CitCallEntityRepository$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                MiscallResponse m828createToken$lambda0;
                m828createToken$lambda0 = CitCallEntityRepository.m828createToken$lambda0((MiscallResult) obj);
                return m828createToken$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createToken$lambda-0  reason: not valid java name */
    public static final MiscallResponse m828createToken$lambda0(MiscallResult miscallResult) {
        Intrinsics.checkNotNullParameter(miscallResult, "");
        return CitcallMapperKt.toMiscallResponse(miscallResult);
    }

    private final CitCallEntityData createNetworkCitcallEntityData() {
        return this.citcallEntityDataFactory.createData2("network");
    }

    @Override // id.dana.domain.citcall.CitcallRepository
    public final Observable<CitcallPermission> getCitcallPermission() {
        Observable map = this.configEntityDataFactory.createData2("split").getCitCallPermission().map(new Function() { // from class: id.dana.data.citcall.CitCallEntityRepository$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                CitcallPermission m829getCitcallPermission$lambda1;
                m829getCitcallPermission$lambda1 = CitCallEntityRepository.m829getCitcallPermission$lambda1((CitcallPermissionConfig) obj);
                return m829getCitcallPermission$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getCitcallPermission$lambda-1  reason: not valid java name */
    public static final CitcallPermission m829getCitcallPermission$lambda1(CitcallPermissionConfig citcallPermissionConfig) {
        Intrinsics.checkNotNullParameter(citcallPermissionConfig, "");
        return CitcallPermissionConfigKt.toCitcallPermission(citcallPermissionConfig);
    }
}
