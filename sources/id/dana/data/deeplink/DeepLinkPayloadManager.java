package id.dana.data.deeplink;

import android.text.TextUtils;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import java.util.Timer;
import java.util.TimerTask;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* loaded from: classes2.dex */
public class DeepLinkPayloadManager {
    public static final long RESET_PAYLOAD_BACKUP_DELAY = 900000;
    private static DeepLinkPayloadEntity deepLinkPayloadEntity;
    private static DeepLinkPayloadEntity deepLinkPayloadEntityBackup;

    @Inject
    public DeepLinkPayloadManager() {
    }

    public void saveDeepLinkPayload(DeepLinkPayloadEntity deepLinkPayloadEntity2) {
        deepLinkPayloadEntity = deepLinkPayloadEntity2;
        deepLinkPayloadEntityBackup = deepLinkPayloadEntity2;
    }

    public void transferBackupPayload() {
        if (deepLinkPayloadEntity == null) {
            deepLinkPayloadEntity = deepLinkPayloadEntityBackup;
        }
    }

    public DeepLinkPayloadEntity getDeepLinkPayloadEntity(boolean z) {
        DeepLinkPayloadEntity deepLinkPayloadEntity2 = deepLinkPayloadEntity;
        if (!z || deepLinkPayloadEntity2.isSkipHomePage()) {
            removeDeepLinkPayload();
        }
        return deepLinkPayloadEntity2;
    }

    public void removeDeepLinkPayload() {
        deepLinkPayloadEntity = null;
    }

    public void removeDeepLinkPayloadBackup() {
        deepLinkPayloadEntityBackup = null;
    }

    public void removeDeepLinkPayloadBackupWithTimer(long j) {
        new Timer().schedule(new TimerTask() { // from class: id.dana.data.deeplink.DeepLinkPayloadManager.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                DeepLinkPayloadManager.this.removeDeepLinkPayloadBackup();
            }
        }, j);
    }

    public String getReferralCode() {
        if (hasReferralCode()) {
            return deepLinkPayloadEntity.getReferralCode();
        }
        return null;
    }

    public boolean hasReferralCode() {
        return hasPayload() && !TextUtils.isEmpty(deepLinkPayloadEntity.getReferralCode());
    }

    public boolean hasPayload() {
        return deepLinkPayloadEntity != null;
    }

    public boolean hasPayloadBackup() {
        return deepLinkPayloadEntityBackup != null;
    }
}
