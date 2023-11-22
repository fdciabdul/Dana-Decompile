package id.dana.data.config.source.amcs.result;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class ContactSyncConfigResult {
    private static final int DEFAULT_MAX_BATCH_SIZE = 20;
    @JSONField(name = "interval_time_in_millis")
    public long intervalTimeInMillis;
    @JSONField(name = "max_contact_sync_batch_size")
    public int maxContactSyncBatchSize;
    @JSONField(name = "repeated_background_jobs")
    public RepeatedBackgroundJobsResult repeatedBackgroundJobsResult;
    @JSONField(name = "synchronize_contact")
    public boolean synchronizeContact;
    @JSONField(name = "version")
    public int version;
    private static final long DEFAULT_BACKGROUND_JOB_INTERVAL = TimeUnit.DAYS.toMillis(7);
    private static final long DEFAULT_RE_SYNC_NON_DANA_INTERVAL = TimeUnit.DAYS.toMillis(7);

    public static ContactSyncConfigResult generateDefault() {
        ContactSyncConfigResult contactSyncConfigResult = new ContactSyncConfigResult();
        contactSyncConfigResult.synchronizeContact = false;
        contactSyncConfigResult.maxContactSyncBatchSize = 20;
        contactSyncConfigResult.intervalTimeInMillis = DEFAULT_RE_SYNC_NON_DANA_INTERVAL;
        RepeatedBackgroundJobsResult repeatedBackgroundJobsResult = new RepeatedBackgroundJobsResult();
        contactSyncConfigResult.repeatedBackgroundJobsResult = repeatedBackgroundJobsResult;
        repeatedBackgroundJobsResult.setEnable(false);
        contactSyncConfigResult.repeatedBackgroundJobsResult.setIntervalTimeInMillis(DEFAULT_BACKGROUND_JOB_INTERVAL);
        contactSyncConfigResult.repeatedBackgroundJobsResult.setRequiredCharging(true);
        contactSyncConfigResult.repeatedBackgroundJobsResult.setRequiredCharging(false);
        return contactSyncConfigResult;
    }

    public boolean isSynchronizeContact() {
        return this.synchronizeContact;
    }

    public void setSynchronizeContact(boolean z) {
        this.synchronizeContact = z;
    }

    public int getMaxContactSyncBatchSize() {
        return this.maxContactSyncBatchSize;
    }

    public void setMaxContactSyncBatchSize(int i) {
        this.maxContactSyncBatchSize = i;
    }

    public long getIntervalTimeInMillis() {
        return this.intervalTimeInMillis;
    }

    public void setIntervalTimeInMillis(long j) {
        this.intervalTimeInMillis = j;
    }

    public RepeatedBackgroundJobsResult getRepeatedBackgroundJobs() {
        return this.repeatedBackgroundJobsResult;
    }

    public void setRepeatedBackgroundJobs(RepeatedBackgroundJobsResult repeatedBackgroundJobsResult) {
        this.repeatedBackgroundJobsResult = repeatedBackgroundJobsResult;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
