package id.dana.data.synccontact.mapper;

import id.dana.data.base.BaseMapper;
import id.dana.data.config.source.amcs.result.ContactSyncConfigResult;
import id.dana.domain.synccontact.model.ContactSyncConfig;
import id.dana.domain.synccontact.model.RepeatBackgroundJobs;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public class ContactSyncConfigMapper extends BaseMapper<ContactSyncConfigResult, ContactSyncConfig> {
    @Inject
    public ContactSyncConfigMapper() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.data.base.BaseMapper
    public ContactSyncConfig map(ContactSyncConfigResult contactSyncConfigResult) {
        if (contactSyncConfigResult != null) {
            ContactSyncConfig contactSyncConfig = new ContactSyncConfig();
            contactSyncConfig.setSynchronizeContactEnable(contactSyncConfigResult.isSynchronizeContact());
            contactSyncConfig.setMaxContactSyncBatchSize(contactSyncConfigResult.getMaxContactSyncBatchSize());
            contactSyncConfig.setIntervalTimeInMillis(contactSyncConfigResult.getIntervalTimeInMillis());
            contactSyncConfig.setVersion(contactSyncConfigResult.getVersion());
            if (contactSyncConfigResult.getRepeatedBackgroundJobs() != null) {
                contactSyncConfig.setRepeatBackgroundJobs(new RepeatBackgroundJobs(contactSyncConfigResult.getRepeatedBackgroundJobs().isEnable(), contactSyncConfigResult.getRepeatedBackgroundJobs().getIntervalTimeInMillis(), contactSyncConfigResult.getRepeatedBackgroundJobs().isRequiredCharging(), contactSyncConfigResult.getRepeatedBackgroundJobs().isRequiredDeviceIdle()));
                return contactSyncConfig;
            }
            return contactSyncConfig;
        }
        return null;
    }
}
