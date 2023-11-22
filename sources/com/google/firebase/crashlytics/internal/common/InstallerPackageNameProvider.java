package com.google.firebase.crashlytics.internal.common;

import android.content.Context;

/* loaded from: classes7.dex */
class InstallerPackageNameProvider {
    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private String installerPackageName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getInstallerPackageName(Context context) {
        String str;
        synchronized (this) {
            if (this.installerPackageName == null) {
                this.installerPackageName = loadInstallerPackageName(context);
            }
            str = "".equals(this.installerPackageName) ? null : this.installerPackageName;
        }
        return str;
    }

    private static String loadInstallerPackageName(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }
}
