package androidx.credentials;

import android.content.Context;
import android.os.Build;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;

/* loaded from: classes3.dex */
public class DanaCredentialProviderFactory {
    private DanaCredentialProviderFactory() {
    }

    public static CredentialProvider getBestAvailableProvider(Context context) {
        if (Build.VERSION.SDK_INT >= 34) {
            return new CredentialProviderFrameworkImpl(context);
        }
        return new CredentialProviderPlayServicesImpl(context);
    }
}
