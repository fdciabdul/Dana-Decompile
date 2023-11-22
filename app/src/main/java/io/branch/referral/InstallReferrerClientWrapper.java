package io.branch.referral;

import android.content.Context;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class InstallReferrerClientWrapper {
    private Context MyBillsEntityDataFactory;
    private Object PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface InstallReferrerWrapperListener {
        void PlaceComponentResult(Context context, String str, long j, long j2);

        void getAuthRequestContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstallReferrerClientWrapper(Context context) {
        this.MyBillsEntityDataFactory = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext(final InstallReferrerWrapperListener installReferrerWrapperListener) {
        try {
            InstallReferrerClient build = InstallReferrerClient.newBuilder(this.MyBillsEntityDataFactory).build();
            this.PlaceComponentResult = build;
            build.startConnection(new InstallReferrerStateListener() { // from class: io.branch.referral.InstallReferrerClientWrapper.1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int i) {
                    long j;
                    long j2;
                    if (i != 0) {
                        if (i == 1) {
                            installReferrerWrapperListener.getAuthRequestContext();
                            return;
                        } else if (i == 2) {
                            installReferrerWrapperListener.getAuthRequestContext();
                            return;
                        } else if (i == 3) {
                            installReferrerWrapperListener.getAuthRequestContext();
                            return;
                        } else {
                            return;
                        }
                    }
                    try {
                        if (InstallReferrerClientWrapper.this.PlaceComponentResult != null) {
                            ReferrerDetails installReferrer = ((InstallReferrerClient) InstallReferrerClientWrapper.this.PlaceComponentResult).getInstallReferrer();
                            String str = null;
                            if (installReferrer != null) {
                                str = installReferrer.getInstallReferrer();
                                long referrerClickTimestampSeconds = installReferrer.getReferrerClickTimestampSeconds();
                                j2 = installReferrer.getInstallBeginTimestampSeconds();
                                j = referrerClickTimestampSeconds;
                            } else {
                                j = 0;
                                j2 = 0;
                            }
                            installReferrerWrapperListener.PlaceComponentResult(InstallReferrerClientWrapper.this.MyBillsEntityDataFactory, str, j, j2);
                        }
                    } catch (RemoteException e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onInstallReferrerSetupFinished() Exception: ");
                        sb.append(e.getMessage());
                        PrefHelper.MyBillsEntityDataFactory(sb.toString());
                        installReferrerWrapperListener.getAuthRequestContext();
                    }
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    installReferrerWrapperListener.getAuthRequestContext();
                }
            });
            return true;
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("ReferrerClientWrapper Exception: ");
            sb.append(th.getMessage());
            PrefHelper.MyBillsEntityDataFactory(sb.toString());
            return false;
        }
    }
}
