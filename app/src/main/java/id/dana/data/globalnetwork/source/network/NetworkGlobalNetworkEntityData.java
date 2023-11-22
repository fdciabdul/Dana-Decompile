package id.dana.data.globalnetwork.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.GsonBuilder;
import com.iap.ac.android.biz.common.constants.ACConstants;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.globalnetwork.GlobalNetworkEntityData;
import id.dana.data.globalnetwork.model.GnConsultRequest;
import id.dana.data.globalnetwork.model.GnConsultResult;
import id.dana.data.globalnetwork.source.network.facade.GlobalNetworkFacade;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B1\b\u0007\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J'\u0010\u0007\u001a\u0006*\u00020\u00050\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\f\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050\u000b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\f\u0012\b\u0012\u0006*\u00020\u00130\u00130\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u0015J\u0019\u0010\u001c\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u0015J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bH\u0016¢\u0006\u0004\b\u001d\u0010\u0015J!\u0010\u001f\u001a\f\u0012\b\u0012\u0006*\u00020\u00130\u00130\u000b2\u0006\u0010\u001e\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\"\u0010#J\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010$\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010&R%\u0010,\u001a\f\u0012\b\u0012\u0006*\u00020\u00050\u00050'8CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0014\u0010.\u001a\u00020-8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/data/globalnetwork/source/network/NetworkGlobalNetworkEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/globalnetwork/source/network/facade/GlobalNetworkFacade;", "Lid/dana/data/globalnetwork/GlobalNetworkEntityData;", "", "", "mapData", "convertMapToJson", "(Ljava/util/Map;)Ljava/lang/String;", "acDecodeValue", ACConstants.PARAMETER_KEY_AC_DECODE_CONFIG, "Lio/reactivex/Observable;", "decodeGnQr", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "sdkRequestHeaderMap", "sdkRequestData", "Lid/dana/data/globalnetwork/model/GnConsultResult;", "doGnConsult", "(Ljava/util/Map;Ljava/lang/String;)Lid/dana/data/globalnetwork/model/GnConsultResult;", "", "getAlipayConnectServiceFirstTime", "()Lio/reactivex/Observable;", "getCurrentCountryCode", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "", "getLastTimeGetLocation", "getSelectedCountryCode", "isCScanBEnabled", "acFirstTime", "saveAlipayConnectServiceFirstTime", "(Z)Lio/reactivex/Observable;", RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE, "saveCurrentCountryCode", "(Ljava/lang/String;)Lio/reactivex/Observable;", "lastTime", "saveLastTimeGetLocation", "(J)Lio/reactivex/Observable;", "Lio/reactivex/subjects/PublishSubject;", "countryCodeSubject$delegate", "Lkotlin/Lazy;", "getCountryCodeSubject", "()Lio/reactivex/subjects/PublishSubject;", "countryCodeSubject", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "featureConfigRepository", "Lid/dana/domain/featureconfig/FeatureConfigRepository;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/domain/featureconfig/FeatureConfigRepository;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NetworkGlobalNetworkEntityData extends SecureBaseNetwork<GlobalNetworkFacade> implements GlobalNetworkEntityData {
    public static final int LOCATION_RESULT = 1;
    private static final String STATUS_OK = "OK";

    /* renamed from: countryCodeSubject$delegate  reason: from kotlin metadata */
    private final Lazy countryCodeSubject;
    private final FeatureConfigRepository featureConfigRepository;

    @Override // id.dana.network.base.BaseNetwork
    public final Class<GlobalNetworkFacade> getFacadeClass() {
        return GlobalNetworkFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkGlobalNetworkEntityData(Context context, FeatureConfigRepository featureConfigRepository, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(featureConfigRepository, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        this.featureConfigRepository = featureConfigRepository;
        this.countryCodeSubject = LazyKt.lazy(new Function0<PublishSubject<String>>() { // from class: id.dana.data.globalnetwork.source.network.NetworkGlobalNetworkEntityData$countryCodeSubject$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PublishSubject<String> invoke() {
                return PublishSubject.PlaceComponentResult();
            }
        });
    }

    @JvmName(name = "getCountryCodeSubject")
    private final PublishSubject<String> getCountryCodeSubject() {
        return (PublishSubject) this.countryCodeSubject.getValue();
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final GnConsultResult doGnConsult(Map<String, String> sdkRequestHeaderMap, String sdkRequestData) {
        Intrinsics.checkNotNullParameter(sdkRequestHeaderMap, "");
        Intrinsics.checkNotNullParameter(sdkRequestData, "");
        ?? r2 = 0;
        final GnConsultRequest gnConsultRequest = new GnConsultRequest(r2, r2, 3, r2);
        gnConsultRequest.setSdkRequestHeader(convertMapToJson(sdkRequestHeaderMap));
        gnConsultRequest.setSdkRequestData(sdkRequestData);
        BaseRpcResult wrapperMainThread = wrapperMainThread(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.globalnetwork.source.network.NetworkGlobalNetworkEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                GnConsultResult m1334doGnConsult$lambda0;
                m1334doGnConsult$lambda0 = NetworkGlobalNetworkEntityData.m1334doGnConsult$lambda0(GnConsultRequest.this, (GlobalNetworkFacade) obj);
                return m1334doGnConsult$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapperMainThread, "");
        return (GnConsultResult) wrapperMainThread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doGnConsult$lambda-0  reason: not valid java name */
    public static final GnConsultResult m1334doGnConsult$lambda0(GnConsultRequest gnConsultRequest, GlobalNetworkFacade globalNetworkFacade) {
        Intrinsics.checkNotNullParameter(gnConsultRequest, "");
        return globalNetworkFacade.gnConsult(gnConsultRequest);
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<String> getSelectedCountryCode() {
        Observable<String> just = Observable.just("");
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<Boolean> saveAlipayConnectServiceFirstTime(boolean acFirstTime) {
        Observable<Boolean> just = Observable.just(Boolean.valueOf(acFirstTime));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<Boolean> isCScanBEnabled() {
        Observable<Boolean> isCScanBEnabled = this.featureConfigRepository.isCScanBEnabled();
        Intrinsics.checkNotNullExpressionValue(isCScanBEnabled, "");
        return isCScanBEnabled;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<String> decodeGnQr(String acDecodeValue, String acDecodeConfig) {
        Intrinsics.checkNotNullParameter(acDecodeValue, "");
        Intrinsics.checkNotNullParameter(acDecodeConfig, "");
        Observable<String> just = Observable.just("");
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<Boolean> getAlipayConnectServiceFirstTime() {
        Observable<Boolean> just = Observable.just(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<String> getCurrentCountryCode() {
        Observable<String> just = Observable.just("");
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<Boolean> saveCurrentCountryCode(String countryCode) {
        Observable<Boolean> just = Observable.just(Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<Boolean> saveLastTimeGetLocation(long lastTime) {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.data.globalnetwork.GlobalNetworkEntityData
    public final Observable<Long> getLastTimeGetLocation() {
        throw new UnsupportedOperationException();
    }

    private final String convertMapToJson(Map<String, String> mapData) {
        return new GsonBuilder().create().toJson(mapData);
    }
}
