package androidx.work;

import android.os.Build;
import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import id.dana.data.deeplink.DeepLinkPayloadManager;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class PeriodicWorkRequest extends WorkRequest {
    PeriodicWorkRequest(Builder builder) {
        super(builder.BuiltInFictitiousFunctionClassFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.PlaceComponentResult);
    }

    /* loaded from: classes2.dex */
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.WorkRequest.Builder
        public final /* bridge */ /* synthetic */ Builder MyBillsEntityDataFactory() {
            return this;
        }

        public Builder(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit) {
            super(cls);
            WorkSpec workSpec = this.KClassImpl$Data$declaredNonStaticMembers$2;
            long millis = timeUnit.toMillis(j);
            long j2 = DeepLinkPayloadManager.RESET_PAYLOAD_BACKUP_DELAY;
            Long valueOf = Long.valueOf((long) DeepLinkPayloadManager.RESET_PAYLOAD_BACKUP_DELAY);
            if (millis < DeepLinkPayloadManager.RESET_PAYLOAD_BACKUP_DELAY) {
                Logger.getAuthRequestContext().getAuthRequestContext(WorkSpec.KClassImpl$Data$declaredNonStaticMembers$2, String.format("Interval duration lesser than minimum allowed value; Changed to %s", valueOf), new Throwable[0]);
                millis = 900000;
            }
            if (millis < DeepLinkPayloadManager.RESET_PAYLOAD_BACKUP_DELAY) {
                Logger.getAuthRequestContext().getAuthRequestContext(WorkSpec.KClassImpl$Data$declaredNonStaticMembers$2, String.format("Interval duration lesser than minimum allowed value; Changed to %s", valueOf), new Throwable[0]);
            } else {
                j2 = millis;
            }
            if (millis < 300000) {
                Logger.getAuthRequestContext().getAuthRequestContext(WorkSpec.KClassImpl$Data$declaredNonStaticMembers$2, String.format("Flex duration lesser than minimum allowed value; Changed to %s", 300000L), new Throwable[0]);
                millis = 300000;
            }
            if (millis > j2) {
                Logger.getAuthRequestContext().getAuthRequestContext(WorkSpec.KClassImpl$Data$declaredNonStaticMembers$2, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j2)), new Throwable[0]);
                millis = j2;
            }
            workSpec.initRecordTimeStamp = j2;
            workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 = millis;
        }

        @Override // androidx.work.WorkRequest.Builder
        final /* synthetic */ PeriodicWorkRequest PlaceComponentResult() {
            if (this.MyBillsEntityDataFactory && Build.VERSION.SDK_INT >= 23 && this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getAuthRequestContext()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            return new PeriodicWorkRequest(this);
        }
    }
}
