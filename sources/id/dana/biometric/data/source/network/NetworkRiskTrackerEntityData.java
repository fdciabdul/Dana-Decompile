package id.dana.biometric.data.source.network;

import android.content.Context;
import id.dana.biometric.data.source.RiskTrackerEntityData;
import id.dana.biometric.data.source.local.ScoringDeviceEntity;
import id.dana.biometric.data.source.network.request.InsertDeviceScoringDataRequest;
import id.dana.biometric.data.source.network.result.InsertDeviceScoringDataResult;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/biometric/data/source/network/NetworkRiskTrackerEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/biometric/data/source/network/RiskTrackerFacade;", "Lid/dana/biometric/data/source/RiskTrackerEntityData;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/biometric/data/source/local/ScoringDeviceEntity;", "scoringDeviceEntity", "Lio/reactivex/Observable;", "Lid/dana/biometric/data/source/network/result/InsertDeviceScoringDataResult;", "onPageEndAndZip", "(Lid/dana/biometric/data/source/local/ScoringDeviceEntity;)Lio/reactivex/Observable;", "Landroid/content/Context;", "appContext", "Lid/dana/network/rpc/RpcConnector;", "rpcConnector", "Lid/dana/utils/concurrent/ThreadExecutor;", "threadExecutor", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "apSecurityFacade", "<init>", "(Landroid/content/Context;Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NetworkRiskTrackerEntityData extends SecureBaseNetwork<RiskTrackerFacade> implements RiskTrackerEntityData {
    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable clearData() {
        return RiskTrackerEntityData.CC.$default$clearData(this);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable getAccelerometerData(String str) {
        return RiskTrackerEntityData.CC.$default$getAccelerometerData(this, str);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable getAllAccelerometerData() {
        return RiskTrackerEntityData.CC.$default$getAllAccelerometerData(this);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable getAllGyroscopeData() {
        return RiskTrackerEntityData.CC.$default$getAllGyroscopeData(this);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable getAllKeystrokeData() {
        return RiskTrackerEntityData.CC.$default$getAllKeystrokeData(this);
    }

    @Override // id.dana.network.base.BaseNetwork
    public final Class<RiskTrackerFacade> getFacadeClass() {
        return RiskTrackerFacade.class;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable getGyroscopeData(String str) {
        return RiskTrackerEntityData.CC.$default$getGyroscopeData(this, str);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable saveAndGetAccelerometerDataState(String str, String str2, String str3, long j) {
        return RiskTrackerEntityData.CC.$default$saveAndGetAccelerometerDataState(this, str, str2, str3, j);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable saveAndGetGyroscopeDataState(String str, String str2, String str3, long j) {
        return RiskTrackerEntityData.CC.$default$saveAndGetGyroscopeDataState(this, str, str2, str3, j);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable saveKeystrokeDataState(String str, String str2, String str3, long j) {
        return RiskTrackerEntityData.CC.$default$saveKeystrokeDataState(this, str, str2, str3, j);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkRiskTrackerEntityData(Context context, RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<InsertDeviceScoringDataResult> onPageEndAndZip(ScoringDeviceEntity scoringDeviceEntity) {
        Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
        String scheme = scoringDeviceEntity.getScheme();
        String type = scoringDeviceEntity.getType();
        List<ScoringDeviceEntity.Value> value = scoringDeviceEntity.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        for (ScoringDeviceEntity.Value value2 : value) {
            arrayList.add(new InsertDeviceScoringDataRequest.ScoringDataInfo(value2.getTimestamp(), value2.getData(), value2.getPhase()));
        }
        final InsertDeviceScoringDataRequest insertDeviceScoringDataRequest = new InsertDeviceScoringDataRequest(scheme, type, arrayList);
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.biometric.data.source.network.NetworkRiskTrackerEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                InsertDeviceScoringDataResult m473onPageEndAndZip$lambda1;
                m473onPageEndAndZip$lambda1 = NetworkRiskTrackerEntityData.m473onPageEndAndZip$lambda1(InsertDeviceScoringDataRequest.this, (RiskTrackerFacade) obj);
                return m473onPageEndAndZip$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onPageEndAndZip$lambda-1  reason: not valid java name */
    public static final InsertDeviceScoringDataResult m473onPageEndAndZip$lambda1(InsertDeviceScoringDataRequest insertDeviceScoringDataRequest, RiskTrackerFacade riskTrackerFacade) {
        Intrinsics.checkNotNullParameter(insertDeviceScoringDataRequest, "");
        return riskTrackerFacade.insertDeviceScoringData(insertDeviceScoringDataRequest);
    }
}
