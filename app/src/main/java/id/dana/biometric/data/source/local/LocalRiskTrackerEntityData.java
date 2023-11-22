package id.dana.biometric.data.source.local;

import id.dana.biometric.data.source.RiskTrackerEntityData;
import id.dana.biometric.data.source.local.ScoringDeviceEntity;
import id.dana.biometric.domain.model.RiskType;
import id.dana.domain.foundation.logger.PerformanceConstant;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0005J\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0005J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J5\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b!\u0010 J5\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\"\u0010 J7\u0010#\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b#\u0010$R.\u0010&\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0%0%8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b&\u0010'"}, d2 = {"Lid/dana/biometric/data/source/local/LocalRiskTrackerEntityData;", "Lid/dana/biometric/data/source/RiskTrackerEntityData;", "Lio/reactivex/Observable;", "", "clearData", "()Lio/reactivex/Observable;", "", PerformanceConstant.PERFORMANCE_PHASE, "Lid/dana/biometric/data/source/local/ScoringDeviceEntity;", "getAccelerometerData", "(Ljava/lang/String;)Lio/reactivex/Observable;", "getAllAccelerometerData", "getAllGyroscopeData", "getAllKeystrokeData", "getGyroscopeData", "Lid/dana/biometric/domain/model/RiskType;", "type", "getScoringDeviceByType", "(Lid/dana/biometric/domain/model/RiskType;)Lid/dana/biometric/data/source/local/ScoringDeviceEntity;", "initScoringDevice", "(Ljava/lang/String;)V", "scheme", "", "Lid/dana/biometric/data/source/local/ScoringDeviceEntity$Value;", "value", "", "isScoringDataEmpty", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Z", "data", "", "timestamp", "saveAndGetAccelerometerDataState", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lio/reactivex/Observable;", "saveAndGetGyroscopeDataState", "saveKeystrokeDataState", "saveScoringDeviceByType", "(Lid/dana/biometric/domain/model/RiskType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "", "scoringDevices", "Ljava/util/Map;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalRiskTrackerEntityData implements RiskTrackerEntityData {
    private Map<String, Map<String, ScoringDeviceEntity>> scoringDevices;

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final /* synthetic */ Observable onPageEndAndZip(ScoringDeviceEntity scoringDeviceEntity) {
        return RiskTrackerEntityData.CC.$default$onPageEndAndZip(this, scoringDeviceEntity);
    }

    @Inject
    public LocalRiskTrackerEntityData() {
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<Boolean> saveAndGetAccelerometerDataState(final String scheme, final String phase, final String data, final long timestamp) {
        Intrinsics.checkNotNullParameter(scheme, "");
        Intrinsics.checkNotNullParameter(phase, "");
        Intrinsics.checkNotNullParameter(data, "");
        Observable<Boolean> map = Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.source.local.LocalRiskTrackerEntityData$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m468saveAndGetAccelerometerDataState$lambda0;
                m468saveAndGetAccelerometerDataState$lambda0 = LocalRiskTrackerEntityData.m468saveAndGetAccelerometerDataState$lambda0(LocalRiskTrackerEntityData.this, scheme, phase, data, timestamp);
                return m468saveAndGetAccelerometerDataState$lambda0;
            }
        }).map(new Function() { // from class: id.dana.biometric.data.source.local.LocalRiskTrackerEntityData$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m469saveAndGetAccelerometerDataState$lambda1;
                m469saveAndGetAccelerometerDataState$lambda1 = LocalRiskTrackerEntityData.m469saveAndGetAccelerometerDataState$lambda1(LocalRiskTrackerEntityData.this, phase, (Unit) obj);
                return m469saveAndGetAccelerometerDataState$lambda1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveAndGetAccelerometerDataState$lambda-0  reason: not valid java name */
    public static final Unit m468saveAndGetAccelerometerDataState$lambda0(LocalRiskTrackerEntityData localRiskTrackerEntityData, String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(localRiskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        localRiskTrackerEntityData.saveScoringDeviceByType(RiskType.ACCELEROMETER, str, str2, str3, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveAndGetAccelerometerDataState$lambda-1  reason: not valid java name */
    public static final Boolean m469saveAndGetAccelerometerDataState$lambda1(LocalRiskTrackerEntityData localRiskTrackerEntityData, String str, Unit unit) {
        Intrinsics.checkNotNullParameter(localRiskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(unit, "");
        Map<String, Map<String, ScoringDeviceEntity>> map = localRiskTrackerEntityData.scoringDevices;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            map = null;
        }
        return Boolean.valueOf(((ScoringDeviceEntity) MapsKt.getValue((Map) MapsKt.getValue(map, str), RiskType.ACCELEROMETER.name())).getValue().size() == 100);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<Boolean> saveAndGetGyroscopeDataState(final String scheme, final String phase, final String data, final long timestamp) {
        Intrinsics.checkNotNullParameter(scheme, "");
        Intrinsics.checkNotNullParameter(phase, "");
        Intrinsics.checkNotNullParameter(data, "");
        Observable<Boolean> map = Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.source.local.LocalRiskTrackerEntityData$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m470saveAndGetGyroscopeDataState$lambda2;
                m470saveAndGetGyroscopeDataState$lambda2 = LocalRiskTrackerEntityData.m470saveAndGetGyroscopeDataState$lambda2(LocalRiskTrackerEntityData.this, scheme, phase, data, timestamp);
                return m470saveAndGetGyroscopeDataState$lambda2;
            }
        }).map(new Function() { // from class: id.dana.biometric.data.source.local.LocalRiskTrackerEntityData$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean m471saveAndGetGyroscopeDataState$lambda3;
                m471saveAndGetGyroscopeDataState$lambda3 = LocalRiskTrackerEntityData.m471saveAndGetGyroscopeDataState$lambda3(LocalRiskTrackerEntityData.this, phase, (Unit) obj);
                return m471saveAndGetGyroscopeDataState$lambda3;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveAndGetGyroscopeDataState$lambda-2  reason: not valid java name */
    public static final Unit m470saveAndGetGyroscopeDataState$lambda2(LocalRiskTrackerEntityData localRiskTrackerEntityData, String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(localRiskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        localRiskTrackerEntityData.saveScoringDeviceByType(RiskType.GYROSCOPE, str, str2, str3, j);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveAndGetGyroscopeDataState$lambda-3  reason: not valid java name */
    public static final Boolean m471saveAndGetGyroscopeDataState$lambda3(LocalRiskTrackerEntityData localRiskTrackerEntityData, String str, Unit unit) {
        Intrinsics.checkNotNullParameter(localRiskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(unit, "");
        Map<String, Map<String, ScoringDeviceEntity>> map = localRiskTrackerEntityData.scoringDevices;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            map = null;
        }
        return Boolean.valueOf(((ScoringDeviceEntity) MapsKt.getValue((Map) MapsKt.getValue(map, str), RiskType.GYROSCOPE.name())).getValue().size() == 100);
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<Unit> saveKeystrokeDataState(final String scheme, final String phase, final String data, final long timestamp) {
        Intrinsics.checkNotNullParameter(scheme, "");
        Intrinsics.checkNotNullParameter(phase, "");
        Intrinsics.checkNotNullParameter(data, "");
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.source.local.LocalRiskTrackerEntityData$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m472saveKeystrokeDataState$lambda4;
                m472saveKeystrokeDataState$lambda4 = LocalRiskTrackerEntityData.m472saveKeystrokeDataState$lambda4(LocalRiskTrackerEntityData.this, scheme, phase, data, timestamp);
                return m472saveKeystrokeDataState$lambda4;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: saveKeystrokeDataState$lambda-4  reason: not valid java name */
    public static final Unit m472saveKeystrokeDataState$lambda4(LocalRiskTrackerEntityData localRiskTrackerEntityData, String str, String str2, String str3, long j) {
        Intrinsics.checkNotNullParameter(localRiskTrackerEntityData, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        localRiskTrackerEntityData.saveScoringDeviceByType(RiskType.KEYSTROKE, str, str2, str3, j);
        return Unit.INSTANCE;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<ScoringDeviceEntity> getAccelerometerData(String phase) {
        Intrinsics.checkNotNullParameter(phase, "");
        initScoringDevice(phase);
        Map<String, Map<String, ScoringDeviceEntity>> map = this.scoringDevices;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            map = null;
        }
        Observable<ScoringDeviceEntity> just = Observable.just((ScoringDeviceEntity) MapsKt.getValue((Map) MapsKt.getValue(map, phase), RiskType.GYROSCOPE.name()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<ScoringDeviceEntity> getGyroscopeData(String phase) {
        Intrinsics.checkNotNullParameter(phase, "");
        initScoringDevice(phase);
        Map<String, Map<String, ScoringDeviceEntity>> map = this.scoringDevices;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            map = null;
        }
        Observable<ScoringDeviceEntity> just = Observable.just((ScoringDeviceEntity) MapsKt.getValue((Map) MapsKt.getValue(map, phase), RiskType.GYROSCOPE.name()));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<Unit> clearData() {
        Observable<Unit> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.source.local.LocalRiskTrackerEntityData$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit m467clearData$lambda5;
                m467clearData$lambda5 = LocalRiskTrackerEntityData.m467clearData$lambda5(LocalRiskTrackerEntityData.this);
                return m467clearData$lambda5;
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        return fromCallable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearData$lambda-5  reason: not valid java name */
    public static final Unit m467clearData$lambda5(LocalRiskTrackerEntityData localRiskTrackerEntityData) {
        Intrinsics.checkNotNullParameter(localRiskTrackerEntityData, "");
        localRiskTrackerEntityData.scoringDevices = new LinkedHashMap();
        return Unit.INSTANCE;
    }

    private final void initScoringDevice(String phase) {
        if (this.scoringDevices == null) {
            this.scoringDevices = new LinkedHashMap();
        }
        Map<String, Map<String, ScoringDeviceEntity>> map = this.scoringDevices;
        Map<String, Map<String, ScoringDeviceEntity>> map2 = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            map = null;
        }
        if (map.get(phase) != null) {
            return;
        }
        Map<String, Map<String, ScoringDeviceEntity>> map3 = this.scoringDevices;
        if (map3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            map2 = map3;
        }
        String str = null;
        String str2 = null;
        List list = null;
        int i = 7;
        DefaultConstructorMarker defaultConstructorMarker = null;
        map2.put(phase, MapsKt.mutableMapOf(TuplesKt.to(RiskType.ACCELEROMETER.name(), new ScoringDeviceEntity(str, str2, list, i, defaultConstructorMarker)), TuplesKt.to(RiskType.GYROSCOPE.name(), new ScoringDeviceEntity(str, str2, list, i, defaultConstructorMarker)), TuplesKt.to(RiskType.KEYSTROKE.name(), new ScoringDeviceEntity(str, str2, list, i, defaultConstructorMarker))));
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<ScoringDeviceEntity> getAllGyroscopeData() {
        Observable<ScoringDeviceEntity> just = Observable.just(getScoringDeviceByType(RiskType.GYROSCOPE));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<ScoringDeviceEntity> getAllAccelerometerData() {
        Observable<ScoringDeviceEntity> just = Observable.just(getScoringDeviceByType(RiskType.ACCELEROMETER));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerEntityData
    public final Observable<ScoringDeviceEntity> getAllKeystrokeData() {
        Observable<ScoringDeviceEntity> just = Observable.just(getScoringDeviceByType(RiskType.KEYSTROKE));
        Intrinsics.checkNotNullExpressionValue(just, "");
        return just;
    }

    private final ScoringDeviceEntity getScoringDeviceByType(RiskType type) {
        ScoringDeviceEntity scoringDeviceEntity = new ScoringDeviceEntity(null, null, null, 7, null);
        Map<String, Map<String, ScoringDeviceEntity>> map = this.scoringDevices;
        if (map == null) {
            return scoringDeviceEntity;
        }
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            map = null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, Map<String, ScoringDeviceEntity>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            ScoringDeviceEntity scoringDeviceEntity2 = (ScoringDeviceEntity) MapsKt.getValue(it.next().getValue(), type.name());
            if (!isScoringDataEmpty(scoringDeviceEntity2.getScheme(), scoringDeviceEntity2.getType(), scoringDeviceEntity2.getValue())) {
                scoringDeviceEntity = scoringDeviceEntity.copy(scoringDeviceEntity2.getScheme(), scoringDeviceEntity2.getType(), CollectionsKt.plus((Collection) scoringDeviceEntity.getValue(), (Iterable) scoringDeviceEntity2.getValue()));
            }
            arrayList.add(Unit.INSTANCE);
        }
        return scoringDeviceEntity;
    }

    private final boolean isScoringDataEmpty(String scheme, String type, List<ScoringDeviceEntity.Value> value) {
        if (!(scheme.length() == 0)) {
            if (!(type.length() == 0) && !value.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private final void saveScoringDeviceByType(RiskType type, String scheme, String phase, String data, long timestamp) {
        initScoringDevice(phase);
        Map<String, Map<String, ScoringDeviceEntity>> map = this.scoringDevices;
        Map<String, Map<String, ScoringDeviceEntity>> map2 = null;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            map = null;
        }
        ScoringDeviceEntity scoringDeviceEntity = (ScoringDeviceEntity) MapsKt.getValue((Map) MapsKt.getValue(map, phase), type.name());
        if (scoringDeviceEntity.getValue().size() == 100) {
            return;
        }
        Map<String, Map<String, ScoringDeviceEntity>> map3 = this.scoringDevices;
        if (map3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            map2 = map3;
        }
        Map<String, ScoringDeviceEntity> map4 = map2.get(phase);
        if (map4 != null) {
            map4.put(type.name(), scoringDeviceEntity.copy(scheme, type.name(), CollectionsKt.plus((Collection) scoringDeviceEntity.getValue(), (Iterable) CollectionsKt.listOf(new ScoringDeviceEntity.Value(timestamp, data, phase)))));
        }
    }
}
