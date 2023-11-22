package id.dana.data.toggle.traffictype.device;

import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.data.toggle.traffictype.TrafficType;
import id.dana.lib.toggle.ToggleManager;
import id.dana.utils.foundation.logger.log.DanaLog;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B'\u0012\u0006\u0010\u0003\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\b"}, d2 = {"Lid/dana/data/toggle/traffictype/device/TrafficTypeDevice;", "Lid/dana/data/toggle/traffictype/BaseTrafficType;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)V", "MyBillsEntityDataFactory", "()Ljava/lang/String;", "Landroid/content/Context;", "Lid/dana/lib/toggle/ToggleClientConfig$Builder;", "p1", "p2", "Lid/dana/data/tracker/MixpanelEntityRepository;", "p3", "<init>", "(Landroid/content/Context;Lid/dana/lib/toggle/ToggleClientConfig$Builder;Ljava/lang/String;Lid/dana/data/tracker/MixpanelEntityRepository;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TrafficTypeDevice extends BaseTrafficType {
    @Override // id.dana.data.toggle.traffictype.BaseTrafficType
    public final String BuiltInFictitiousFunctionClassFactory() {
        return TrafficType.DEVICE;
    }

    @Override // id.dana.data.toggle.traffictype.ITrafficTypeFactory
    public final void MyBillsEntityDataFactory(String p0) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(p0, "");
            if (!MyBillsEntityDataFactory()) {
                DanaLog.getAuthRequestContext("Split", "Creating Traffic Type Device");
                getErrorConfigVersion(p0);
                ToggleManager.MyBillsEntityDataFactory().MyBillsEntityDataFactory(TrafficType.DEVICE, this);
                StringBuilder sb = new StringBuilder();
                sb.append("Traffic Type Device created with matching key ");
                sb.append(p0);
                DanaLog.getAuthRequestContext("Split", sb.toString());
            }
        }
    }

    @Override // id.dana.data.toggle.traffictype.ITrafficTypeFactory
    public final void BuiltInFictitiousFunctionClassFactory(String p0) {
        synchronized (this) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p0, "");
            ((BaseTrafficType) this).BuiltInFictitiousFunctionClassFactory = p0;
            PlaceComponentResult(p0);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TrafficTypeDevice(android.content.Context r5, id.dana.lib.toggle.ToggleClientConfig.Builder r6, java.lang.String r7, id.dana.data.tracker.MixpanelEntityRepository r8) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r1 = "Device"
            r6.NetworkUserEntityData$$ExternalSyntheticLambda5 = r1
            io.split.android.client.SplitClientConfig$Builder r1 = io.split.android.client.SplitClientConfig.builder()
            int r2 = r6.getAuthRequestContext
            io.split.android.client.SplitClientConfig$Builder r1 = r1.connectionTimeout(r2)
            long r2 = r6.getErrorConfigVersion
            io.split.android.client.SplitClientConfig$Builder r1 = r1.eventFlushInterval(r2)
            int r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda0
            io.split.android.client.SplitClientConfig$Builder r1 = r1.eventsPerPush(r2)
            int r2 = r6.moveToNextValue
            io.split.android.client.SplitClientConfig$Builder r1 = r1.eventsQueueSize(r2)
            int r2 = r6.scheduleImpl
            io.split.android.client.SplitClientConfig$Builder r1 = r1.featuresRefreshRate(r2)
            java.lang.String r2 = r6.lookAheadTest
            io.split.android.client.SplitClientConfig$Builder r1 = r1.hostname(r2)
            long r2 = r6.DatabaseTableConfigUtil
            io.split.android.client.SplitClientConfig$Builder r1 = r1.impressionsChunkSize(r2)
            int r2 = r6.initRecordTimeStamp
            io.split.android.client.SplitClientConfig$Builder r1 = r1.impressionsQueueSize(r2)
            int r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda2
            io.split.android.client.SplitClientConfig$Builder r1 = r1.impressionsRefreshRate(r2)
            java.lang.String r2 = r6.GetContactSyncConfig
            io.split.android.client.SplitClientConfig$Builder r1 = r1.ip(r2)
            int r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda7
            io.split.android.client.SplitClientConfig$Builder r1 = r1.readTimeout(r2)
            int r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda8
            io.split.android.client.SplitClientConfig$Builder r1 = r1.ready(r2)
            int r2 = r6.PrepareContext
            io.split.android.client.SplitClientConfig$Builder r1 = r1.segmentsRefreshRate(r2)
            java.lang.String r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda5
            io.split.android.client.SplitClientConfig$Builder r1 = r1.trafficType(r2)
            java.lang.String r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda1
            io.split.android.client.SplitClientConfig$Builder r1 = r1.proxyHost(r2)
            boolean r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda4
            io.split.android.client.SplitClientConfig$Builder r1 = r1.synchronizeInBackground(r2)
            int r2 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            long r2 = (long) r2
            io.split.android.client.SplitClientConfig$Builder r1 = r1.synchronizeInBackgroundPeriod(r2)
            boolean r2 = r6.PlaceComponentResult
            io.split.android.client.SplitClientConfig$Builder r1 = r1.backgroundSyncWhenBatteryNotLow(r2)
            boolean r2 = r6.MyBillsEntityDataFactory
            io.split.android.client.SplitClientConfig$Builder r1 = r1.backgroundSyncWhenWifiOnly(r2)
            boolean r2 = r6.isLayoutRequested
            io.split.android.client.SplitClientConfig$Builder r1 = r1.streamingEnabled(r2)
            id.dana.lib.toggle.ToggleServiceEndpoints r2 = r6.NetworkUserEntityData$$ExternalSyntheticLambda3
            io.split.android.client.ServiceEndpoints r2 = r2.MyBillsEntityDataFactory
            io.split.android.client.SplitClientConfig$Builder r1 = r1.serviceEndpoints(r2)
            id.dana.lib.toggle.ToggleSyncConfig r2 = r6.newProxyInstance
            io.split.android.client.SyncConfig r2 = r2.KClassImpl$Data$declaredNonStaticMembers$2
            io.split.android.client.SplitClientConfig$Builder r1 = r1.syncConfig(r2)
            boolean r6 = r6.BuiltInFictitiousFunctionClassFactory
            if (r6 == 0) goto La7
            r6 = 3
            r1.logLevel(r6)
        La7:
            io.split.android.client.SplitClientConfig r6 = r1.build()
            id.dana.lib.toggle.ToggleClientConfig r1 = id.dana.lib.toggle.ToggleClientConfig.MyBillsEntityDataFactory()
            id.dana.lib.toggle.ToggleClientConfig r6 = id.dana.lib.toggle.ToggleClientConfig.PlaceComponentResult(r1, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            r4.<init>(r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.toggle.traffictype.device.TrafficTypeDevice.<init>(android.content.Context, id.dana.lib.toggle.ToggleClientConfig$Builder, java.lang.String, id.dana.data.tracker.MixpanelEntityRepository):void");
    }
}
