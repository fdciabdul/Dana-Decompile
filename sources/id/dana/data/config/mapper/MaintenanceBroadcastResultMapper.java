package id.dana.data.config.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.MaintenanceBroadcastResult;
import id.dana.domain.maintenance.model.MaintenanceBroadcast;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class MaintenanceBroadcastResultMapper extends BaseMapper<MaintenanceBroadcastResult, MaintenanceBroadcast> {
    @Inject
    public MaintenanceBroadcastResultMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public MaintenanceBroadcast map(MaintenanceBroadcastResult maintenanceBroadcastResult) {
        if (maintenanceBroadcastResult != null) {
            return new MaintenanceBroadcast(maintenanceBroadcastResult.getText(), maintenanceBroadcastResult.isVisible(), maintenanceBroadcastResult.getVersion(), maintenanceBroadcastResult.getDate(), maintenanceBroadcastResult.getIconUrl());
        }
        return null;
    }
}
