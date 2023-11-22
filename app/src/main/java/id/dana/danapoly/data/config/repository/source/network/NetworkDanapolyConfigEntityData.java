package id.dana.danapoly.data.config.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import id.dana.danapoly.data.config.model.request.GetConfigurationRequest;
import id.dana.danapoly.data.config.model.request.GetPlayerRequest;
import id.dana.danapoly.data.config.model.request.PlayBoardRequest;
import id.dana.danapoly.data.config.model.response.GetConfigurationResponse;
import id.dana.danapoly.data.config.model.response.PlayBoardResponse;
import id.dana.danapoly.data.config.model.response.PlayerInfoResponse;
import id.dana.danapoly.data.config.repository.source.DanapolyConfigData;
import id.dana.danapoly.di.DanapolyScope;
import id.dana.danapoly.ui.model.BackgroundColorType;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@DanapolyScope
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0019B!\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u000f"}, d2 = {"Lid/dana/danapoly/data/config/repository/source/network/NetworkDanapolyConfigEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/danapoly/data/config/repository/source/network/DanapolyConfigFacade;", "Lid/dana/danapoly/data/config/repository/source/DanapolyConfigData;", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/config/model/response/GetConfigurationResponse;", "PlaceComponentResult", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "p0", "Lid/dana/danapoly/data/config/model/response/PlayBoardResponse;", "getAuthRequestContext", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/danapoly/data/config/model/response/PlayerInfoResponse;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/foundation/facede/ApSecurity;", "p1", "Landroid/content/Context;", "p2", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkDanapolyConfigEntityData extends SecureBaseNetworkFlow<DanapolyConfigFacade> implements DanapolyConfigData {
    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final /* synthetic */ Flow KClassImpl$Data$declaredNonStaticMembers$2(BackgroundColorType backgroundColorType) {
        return DanapolyConfigData.CC.KClassImpl$Data$declaredNonStaticMembers$2(backgroundColorType);
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        DanapolyConfigData.CC.MyBillsEntityDataFactory(str);
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final /* synthetic */ Flow MyBillsEntityDataFactory(String str) {
        return DanapolyConfigData.CC.getAuthRequestContext(str);
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final /* synthetic */ Flow getAuthRequestContext() {
        return DanapolyConfigData.CC.PlaceComponentResult();
    }

    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<DanapolyConfigFacade> getFacadeClass() {
        return DanapolyConfigFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkDanapolyConfigEntityData(RpcConnector rpcConnector, ApSecurity apSecurity, Context context) {
        super(apSecurity, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final Flow<PlayBoardResponse> getAuthRequestContext(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<DanapolyConfigFacade, PlayBoardResponse>() { // from class: id.dana.danapoly.data.config.repository.source.network.NetworkDanapolyConfigEntityData$getPlayBoard$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PlayBoardResponse invoke(DanapolyConfigFacade danapolyConfigFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(danapolyConfigFacade, "");
                PlayBoardRequest playBoardRequest = new PlayBoardRequest(p0);
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                playBoardRequest.envInfo = generateMobileEnvInfo;
                return danapolyConfigFacade.getPlayBoard(playBoardRequest);
            }
        });
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final Flow<GetConfigurationResponse> PlaceComponentResult() {
        return wrapper(new Function1<DanapolyConfigFacade, GetConfigurationResponse>() { // from class: id.dana.danapoly.data.config.repository.source.network.NetworkDanapolyConfigEntityData$getConfig$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.util.Map] */
            @Override // kotlin.jvm.functions.Function1
            public final GetConfigurationResponse invoke(DanapolyConfigFacade danapolyConfigFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(danapolyConfigFacade, "");
                ?? r2 = 0;
                GetConfigurationRequest getConfigurationRequest = new GetConfigurationRequest(CollectionsKt.listOf((Object[]) new String[]{"eventActive", "lastActiveEvent"}), r2, 2, r2);
                generateMobileEnvInfo = NetworkDanapolyConfigEntityData.this.generateMobileEnvInfo();
                getConfigurationRequest.envInfo = generateMobileEnvInfo;
                return danapolyConfigFacade.getConfig(getConfigurationRequest);
            }
        });
    }

    @Override // id.dana.danapoly.data.config.repository.source.DanapolyConfigData
    public final Flow<PlayerInfoResponse> BuiltInFictitiousFunctionClassFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<DanapolyConfigFacade, PlayerInfoResponse>() { // from class: id.dana.danapoly.data.config.repository.source.network.NetworkDanapolyConfigEntityData$getPlayerInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final PlayerInfoResponse invoke(DanapolyConfigFacade danapolyConfigFacade) {
                MobileEnvInfo generateMobileEnvInfo;
                Intrinsics.checkNotNullParameter(danapolyConfigFacade, "");
                GetPlayerRequest getPlayerRequest = new GetPlayerRequest(p0, CollectionsKt.listOf((Object[]) new String[]{"DANA_POINT", "POSITION"}));
                generateMobileEnvInfo = this.generateMobileEnvInfo();
                getPlayerRequest.envInfo = generateMobileEnvInfo;
                return danapolyConfigFacade.getPlayerInfo(getPlayerRequest);
            }
        });
    }
}
