package id.dana.explore.data.userpersonalization.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.explore.data.userpersonalization.UserPersonalizationEntityData;
import id.dana.explore.data.userpersonalization.source.network.request.CreateUserPersonalizationRequest;
import id.dana.explore.data.userpersonalization.source.network.request.UserPreferenceRequest;
import id.dana.explore.data.userpersonalization.source.network.result.PreferenceOptionListEntity;
import id.dana.explore.data.userpersonalization.source.network.result.UserPreferenceResultEntity;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0019\u0012\u0006\u0010\u0016\u001a\u00020\u001a\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00110\u00062\u0006\u0010\u0005\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\b\u0010\u0012J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00062\u0006\u0010\u0005\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u000fJ+\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0005\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0011H\u0016¢\u0006\u0004\b\b\u0010\u0017J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00180\u0006H\u0016¢\u0006\u0004\b\b\u0010\u000f"}, d2 = {"Lid/dana/explore/data/userpersonalization/source/network/NetworkUserPersonalizationEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/explore/data/userpersonalization/source/network/UserPersonalizationFacade;", "Lid/dana/explore/data/userpersonalization/UserPersonalizationEntityData;", "Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;", "p0", "Lio/reactivex/Observable;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/explore/data/userpersonalization/source/network/request/CreateUserPersonalizationRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/explore/data/userpersonalization/source/network/result/PreferenceOptionListEntity;", "PlaceComponentResult", "()Lio/reactivex/Observable;", "", "", "(Ljava/lang/String;)Lio/reactivex/Observable;", "Lid/dana/explore/data/userpersonalization/source/network/result/UserPreferenceResultEntity;", "MyBillsEntityDataFactory", "", "p1", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkUserPersonalizationEntityData extends SecureBaseNetwork<UserPersonalizationFacade> implements UserPersonalizationEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<UserPersonalizationFacade> getFacadeClass() {
        return UserPersonalizationFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkUserPersonalizationEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<PreferenceOptionListEntity> PlaceComponentResult() {
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.explore.data.userpersonalization.source.network.NetworkUserPersonalizationEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserPersonalizationEntityData.MyBillsEntityDataFactory(NetworkUserPersonalizationEntityData.this, (UserPersonalizationFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<UserPreferenceResultEntity> MyBillsEntityDataFactory(final String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.explore.data.userpersonalization.source.network.NetworkUserPersonalizationEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserPersonalizationEntityData.MyBillsEntityDataFactory(p0, this, (UserPersonalizationFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<Boolean> MyBillsEntityDataFactory() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<Unit> BuiltInFictitiousFunctionClassFactory() {
        ?? r1 = 0;
        throw new NotImplementedError(r1, 1, r1);
    }

    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<BaseRpcResult> BuiltInFictitiousFunctionClassFactory(final CreateUserPersonalizationRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable<S> wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.explore.data.userpersonalization.source.network.NetworkUserPersonalizationEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkUserPersonalizationEntityData.KClassImpl$Data$declaredNonStaticMembers$2(CreateUserPersonalizationRequest.this, this, (UserPersonalizationFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<List<String>> BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ?? r0 = 0;
        throw new NotImplementedError(r0, 1, r0);
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.explore.data.userpersonalization.UserPersonalizationEntityData
    public final Observable<Boolean> BuiltInFictitiousFunctionClassFactory(String p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ?? r3 = 0;
        throw new NotImplementedError(r3, 1, r3);
    }

    public static /* synthetic */ PreferenceOptionListEntity MyBillsEntityDataFactory(NetworkUserPersonalizationEntityData networkUserPersonalizationEntityData, UserPersonalizationFacade userPersonalizationFacade) {
        Intrinsics.checkNotNullParameter(networkUserPersonalizationEntityData, "");
        BaseRpcRequest baseRpcRequest = new BaseRpcRequest();
        baseRpcRequest.envInfo = networkUserPersonalizationEntityData.generateMobileEnvInfo();
        return userPersonalizationFacade.getPreferenceOptionList(baseRpcRequest);
    }

    public static /* synthetic */ UserPreferenceResultEntity MyBillsEntityDataFactory(String str, NetworkUserPersonalizationEntityData networkUserPersonalizationEntityData, UserPersonalizationFacade userPersonalizationFacade) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(networkUserPersonalizationEntityData, "");
        UserPreferenceRequest userPreferenceRequest = new UserPreferenceRequest(str);
        userPreferenceRequest.envInfo = networkUserPersonalizationEntityData.generateMobileEnvInfo();
        return userPersonalizationFacade.getUserPreference(userPreferenceRequest);
    }

    public static /* synthetic */ BaseRpcResult KClassImpl$Data$declaredNonStaticMembers$2(CreateUserPersonalizationRequest createUserPersonalizationRequest, NetworkUserPersonalizationEntityData networkUserPersonalizationEntityData, UserPersonalizationFacade userPersonalizationFacade) {
        Intrinsics.checkNotNullParameter(createUserPersonalizationRequest, "");
        Intrinsics.checkNotNullParameter(networkUserPersonalizationEntityData, "");
        createUserPersonalizationRequest.envInfo = networkUserPersonalizationEntityData.generateMobileEnvInfo();
        return userPersonalizationFacade.createUserPreference(createUserPersonalizationRequest);
    }
}
