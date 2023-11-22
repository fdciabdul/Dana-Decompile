package id.dana.domain.synccontact.model;

/* loaded from: classes4.dex */
public class ContactSyncConfig {
    private long intervalTimeInMillis;
    private int maxContactSyncBatchSize;
    private RepeatBackgroundJobs repeatBackgroundJobs;
    private boolean synchronizeContactEnable;
    private int version;

    public boolean isSynchronizeContactEnable() {
        return this.synchronizeContactEnable;
    }

    public void setSynchronizeContactEnable(boolean z) {
        this.synchronizeContactEnable = z;
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

    public RepeatBackgroundJobs getRepeatBackgroundJobs() {
        return this.repeatBackgroundJobs;
    }

    public void setRepeatBackgroundJobs(RepeatBackgroundJobs repeatBackgroundJobs) {
        this.repeatBackgroundJobs = repeatBackgroundJobs;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }
}
