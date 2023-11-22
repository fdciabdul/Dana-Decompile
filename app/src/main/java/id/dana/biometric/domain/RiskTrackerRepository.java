package id.dana.biometric.domain;

import id.dana.biometric.domain.model.BiometricDataSize;
import id.dana.biometric.domain.model.RiskTrackerConfig;
import id.dana.biometric.domain.model.ScoringDeviceModel;
import id.dana.domain.foundation.logger.PerformanceConstant;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H&¢\u0006\u0004\b\r\u0010\u0005J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H&¢\u0006\u0004\b\u000f\u0010\u0005J5\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0017\u0010\u0016J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0018\u0010\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/biometric/domain/RiskTrackerRepository;", "", "Lio/reactivex/Observable;", "", "clearData", "()Lio/reactivex/Observable;", "", PerformanceConstant.PERFORMANCE_PHASE, "Lid/dana/biometric/domain/model/ScoringDeviceModel;", "getAccelerometerData", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getGyroscopeData", "Lid/dana/biometric/domain/model/RiskTrackerConfig;", "getRiskTrackerConfig", "Lid/dana/biometric/domain/model/BiometricDataSize;", "onPageEndAndZip", "scheme", "data", "", "timestamp", "", "saveAndGetAccelerometerDataState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Observable;", "saveAndGetGyroscopeDataState", "saveKeystrokeDataState"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RiskTrackerRepository {
    Observable<Unit> clearData();

    Observable<ScoringDeviceModel> getAccelerometerData(String phase);

    Observable<ScoringDeviceModel> getGyroscopeData(String phase);

    Observable<RiskTrackerConfig> getRiskTrackerConfig();

    Observable<BiometricDataSize> onPageEndAndZip();

    Observable<Boolean> saveAndGetAccelerometerDataState(String scheme, String phase, String data, long timestamp);

    Observable<Boolean> saveAndGetGyroscopeDataState(String scheme, String phase, String data, long timestamp);

    Observable<Unit> saveKeystrokeDataState(String scheme, String phase, String data, long timestamp);
}
