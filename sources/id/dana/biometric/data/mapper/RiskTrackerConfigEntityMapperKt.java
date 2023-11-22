package id.dana.biometric.data.mapper;

import id.dana.biometric.data.source.local.RiskTrackerConfigEntity;
import id.dana.biometric.domain.model.RiskTrackerConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/biometric/data/source/local/RiskTrackerConfigEntity;", "Lid/dana/biometric/domain/model/RiskTrackerConfig;", "toRiskTrackerConfig", "(Lid/dana/biometric/data/source/local/RiskTrackerConfigEntity;)Lid/dana/biometric/domain/model/RiskTrackerConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RiskTrackerConfigEntityMapperKt {
    public static final RiskTrackerConfig toRiskTrackerConfig(RiskTrackerConfigEntity riskTrackerConfigEntity) {
        Intrinsics.checkNotNullParameter(riskTrackerConfigEntity, "");
        boolean enable = riskTrackerConfigEntity.getEnable();
        Boolean gyroscopeDataTracker = riskTrackerConfigEntity.getGyroscopeDataTracker();
        boolean booleanValue = gyroscopeDataTracker != null ? gyroscopeDataTracker.booleanValue() : false;
        Boolean accelerometerDataTracker = riskTrackerConfigEntity.getAccelerometerDataTracker();
        boolean booleanValue2 = accelerometerDataTracker != null ? accelerometerDataTracker.booleanValue() : false;
        Boolean keystrokeDataTracker = riskTrackerConfigEntity.getKeystrokeDataTracker();
        boolean booleanValue3 = keystrokeDataTracker != null ? keystrokeDataTracker.booleanValue() : false;
        Integer maxRequestLimitInHour = riskTrackerConfigEntity.getMaxRequestLimitInHour();
        return new RiskTrackerConfig(enable, booleanValue, booleanValue2, booleanValue3, maxRequestLimitInHour != null ? maxRequestLimitInHour.intValue() : 0);
    }
}
