package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.GeofenceConfigResult;
import id.dana.domain.featureconfig.model.GeofenceConfig;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\t\b\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/config/mapper/GeofenceConfigMapper;", "Lid/dana/data/base/BaseMapper;", "Lid/dana/data/config/source/amcs/result/GeofenceConfigResult;", "Lid/dana/domain/featureconfig/model/GeofenceConfig;", "oldItem", "map", "(Lid/dana/data/config/source/amcs/result/GeofenceConfigResult;)Lid/dana/domain/featureconfig/model/GeofenceConfig;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GeofenceConfigMapper extends BaseMapper<GeofenceConfigResult, GeofenceConfig> {
    @Inject
    public GeofenceConfigMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public final GeofenceConfig map(GeofenceConfigResult oldItem) {
        Intrinsics.checkNotNullParameter(oldItem, "");
        return new GeofenceConfig(oldItem.getEnable(), oldItem.getCachedInterval(), oldItem.getMaxRetry());
    }
}
