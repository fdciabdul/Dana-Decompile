package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.credentials.CredentialManager$$ExternalSyntheticLambda0;
import androidx.profileinstaller.ProfileInstaller;

/* loaded from: classes6.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (ACTION_INSTALL_PROFILE.equals(action)) {
            ProfileInstaller.KClassImpl$Data$declaredNonStaticMembers$2(context, new CredentialManager$$ExternalSyntheticLambda0(), new ResultDiagnostics(), true);
        } else if (ACTION_SKIP_FILE.equals(action)) {
            String string = intent.getExtras().getString("EXTRA_SKIP_FILE_OPERATION");
            if ("WRITE_SKIP_FILE".equals(string)) {
                ProfileInstaller.getAuthRequestContext(context, new CredentialManager$$ExternalSyntheticLambda0(), new ResultDiagnostics());
            } else if ("DELETE_SKIP_FILE".equals(string)) {
                ProfileInstaller.MyBillsEntityDataFactory(context, new CredentialManager$$ExternalSyntheticLambda0(), new ResultDiagnostics());
            }
        }
    }

    /* loaded from: classes6.dex */
    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        ResultDiagnostics() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, Object obj) {
            ProfileInstaller.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(i, obj);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public final void BuiltInFictitiousFunctionClassFactory(int i, Object obj) {
            ProfileInstaller.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(i, obj);
            ProfileInstallReceiver.this.setResultCode(i);
        }
    }
}
