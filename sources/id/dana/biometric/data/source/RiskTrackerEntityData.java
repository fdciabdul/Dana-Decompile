package id.dana.biometric.data.source;

import id.dana.biometric.data.source.local.ScoringDeviceEntity;
import id.dana.biometric.data.source.network.result.InsertDeviceScoringDataResult;
import id.dana.domain.foundation.logger.PerformanceConstant;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J.\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0018À\u0006\u0001"}, d2 = {"Lid/dana/biometric/data/source/RiskTrackerEntityData;", "", "clearData", "Lio/reactivex/Observable;", "", "getAccelerometerData", "Lid/dana/biometric/data/source/local/ScoringDeviceEntity;", PerformanceConstant.PERFORMANCE_PHASE, "", "getAllAccelerometerData", "getAllGyroscopeData", "getAllKeystrokeData", "getGyroscopeData", "onPageEndAndZip", "Lid/dana/biometric/data/source/network/result/InsertDeviceScoringDataResult;", "scoringDeviceEntity", "saveAndGetAccelerometerDataState", "", "scheme", "data", "timestamp", "", "saveAndGetGyroscopeDataState", "saveKeystrokeDataState", "component-biometric_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface RiskTrackerEntityData {
    Observable<Unit> clearData();

    Observable<ScoringDeviceEntity> getAccelerometerData(String phase);

    Observable<ScoringDeviceEntity> getAllAccelerometerData();

    Observable<ScoringDeviceEntity> getAllGyroscopeData();

    Observable<ScoringDeviceEntity> getAllKeystrokeData();

    Observable<ScoringDeviceEntity> getGyroscopeData(String phase);

    Observable<InsertDeviceScoringDataResult> onPageEndAndZip(ScoringDeviceEntity scoringDeviceEntity);

    Observable<Boolean> saveAndGetAccelerometerDataState(String scheme, String phase, String data, long timestamp);

    Observable<Boolean> saveAndGetGyroscopeDataState(String scheme, String phase, String data, long timestamp);

    Observable<Unit> saveKeystrokeDataState(String scheme, String phase, String data, long timestamp);

    /* renamed from: id.dana.biometric.data.source.RiskTrackerEntityData$-CC  reason: invalid class name */
    /* loaded from: classes4.dex */
    public final /* synthetic */ class CC {
        public static Observable $default$saveAndGetAccelerometerDataState(RiskTrackerEntityData riskTrackerEntityData, String str, String str2, String str3, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$saveAndGetGyroscopeDataState(RiskTrackerEntityData riskTrackerEntityData, String str, String str2, String str3, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$saveKeystrokeDataState(RiskTrackerEntityData riskTrackerEntityData, String str, String str2, String str3, long j) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getAccelerometerData(RiskTrackerEntityData riskTrackerEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getGyroscopeData(RiskTrackerEntityData riskTrackerEntityData, String str) {
            Intrinsics.checkNotNullParameter(str, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$clearData(RiskTrackerEntityData riskTrackerEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$onPageEndAndZip(RiskTrackerEntityData riskTrackerEntityData, ScoringDeviceEntity scoringDeviceEntity) {
            Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getAllGyroscopeData(RiskTrackerEntityData riskTrackerEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getAllAccelerometerData(RiskTrackerEntityData riskTrackerEntityData) {
            throw new UnsupportedOperationException();
        }

        public static Observable $default$getAllKeystrokeData(RiskTrackerEntityData riskTrackerEntityData) {
            throw new UnsupportedOperationException();
        }
    }
}
