package id.dana.biometric.data.mapper;

import id.dana.biometric.data.source.local.ScoringDeviceEntity;
import id.dana.biometric.domain.model.ScoringDeviceModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/biometric/data/source/local/ScoringDeviceEntity;", "Lid/dana/biometric/domain/model/ScoringDeviceModel;", "toScoringDeviceModel", "(Lid/dana/biometric/data/source/local/ScoringDeviceEntity;)Lid/dana/biometric/domain/model/ScoringDeviceModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ScoringDeviceEntityMapperKt {
    public static final ScoringDeviceModel toScoringDeviceModel(ScoringDeviceEntity scoringDeviceEntity) {
        Intrinsics.checkNotNullParameter(scoringDeviceEntity, "");
        String scheme = scoringDeviceEntity.getScheme();
        String type = scoringDeviceEntity.getType();
        List<ScoringDeviceEntity.Value> value = scoringDeviceEntity.getValue();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(value, 10));
        for (ScoringDeviceEntity.Value value2 : value) {
            arrayList.add(new ScoringDeviceModel.Value(value2.getTimestamp(), value2.getData(), value2.getPhase()));
        }
        return new ScoringDeviceModel(scheme, type, arrayList);
    }
}
