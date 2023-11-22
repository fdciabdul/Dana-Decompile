package id.dana.biometric.data.source;

import com.alibaba.ariver.engine.common.track.watchdog.ARiverTrackWatchDogEventConstant;
import id.dana.biometric.data.source.local.LocalRiskTrackerEntityData;
import id.dana.biometric.data.source.network.NetworkRiskTrackerEntityData;
import java.security.InvalidParameterException;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/biometric/data/source/RiskTrackerEntityDataFactory;", "", "", "source", "Lid/dana/biometric/data/source/RiskTrackerEntityData;", ARiverTrackWatchDogEventConstant.FLAG_START_UP_CREATE, "(Ljava/lang/String;)Lid/dana/biometric/data/source/RiskTrackerEntityData;", "Lid/dana/biometric/data/source/local/LocalRiskTrackerEntityData;", "localRiskTrackerEntityData", "Lid/dana/biometric/data/source/local/LocalRiskTrackerEntityData;", "Lid/dana/biometric/data/source/network/NetworkRiskTrackerEntityData;", "networkRiskTrackerEntityData", "Lid/dana/biometric/data/source/network/NetworkRiskTrackerEntityData;", "<init>", "(Lid/dana/biometric/data/source/local/LocalRiskTrackerEntityData;Lid/dana/biometric/data/source/network/NetworkRiskTrackerEntityData;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RiskTrackerEntityDataFactory {
    private final LocalRiskTrackerEntityData localRiskTrackerEntityData;
    private final NetworkRiskTrackerEntityData networkRiskTrackerEntityData;

    @Inject
    public RiskTrackerEntityDataFactory(LocalRiskTrackerEntityData localRiskTrackerEntityData, NetworkRiskTrackerEntityData networkRiskTrackerEntityData) {
        Intrinsics.checkNotNullParameter(localRiskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(networkRiskTrackerEntityData, "");
        this.localRiskTrackerEntityData = localRiskTrackerEntityData;
        this.networkRiskTrackerEntityData = networkRiskTrackerEntityData;
    }

    public final RiskTrackerEntityData create(String source) {
        Intrinsics.checkNotNullParameter(source, "");
        if (Intrinsics.areEqual(source, "local")) {
            return this.localRiskTrackerEntityData;
        }
        if (Intrinsics.areEqual(source, "network")) {
            return this.networkRiskTrackerEntityData;
        }
        throw new InvalidParameterException();
    }
}
