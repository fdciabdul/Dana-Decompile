package androidx.credentials.provider;

import android.content.Intent;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialResponse;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import androidx.credentials.provider.utils.BeginGetCredentialUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroid/content/Intent;", "Landroidx/credentials/provider/BeginGetCredentialResponse;", "getBeginGetResponse", "(Landroid/content/Intent;)Landroidx/credentials/provider/BeginGetCredentialResponse;", "Landroid/credentials/CreateCredentialResponse;", "getCreateCredentialCredentialResponse", "(Landroid/content/Intent;)Landroid/credentials/CreateCredentialResponse;", "Landroid/credentials/CreateCredentialException;", "getCreateCredentialException", "(Landroid/content/Intent;)Landroid/credentials/CreateCredentialException;", "Landroid/credentials/GetCredentialException;", "getGetCredentialException", "(Landroid/content/Intent;)Landroid/credentials/GetCredentialException;", "Landroid/credentials/GetCredentialResponse;", "getGetCredentialResponse", "(Landroid/content/Intent;)Landroid/credentials/GetCredentialResponse;"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class IntentHandlerConverters {
    public static final CreateCredentialException getCreateCredentialException(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        if (intent.hasExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION")) {
            return (CreateCredentialException) intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_EXCEPTION", CreateCredentialException.class);
        }
        return null;
    }

    public static final GetCredentialException getGetCredentialException(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        if (intent.hasExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION")) {
            return (GetCredentialException) intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_EXCEPTION", GetCredentialException.class);
        }
        return null;
    }

    public static final BeginGetCredentialResponse getBeginGetResponse(Intent intent) {
        android.service.credentials.BeginGetCredentialResponse beginGetCredentialResponse;
        Intrinsics.checkNotNullParameter(intent, "");
        if (intent.hasExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE") && (beginGetCredentialResponse = (android.service.credentials.BeginGetCredentialResponse) intent.getParcelableExtra("android.service.credentials.extra.BEGIN_GET_CREDENTIAL_RESPONSE", android.service.credentials.BeginGetCredentialResponse.class)) != null) {
            return BeginGetCredentialUtil.INSTANCE.convertToJetpackResponse(beginGetCredentialResponse);
        }
        return null;
    }

    public static final GetCredentialResponse getGetCredentialResponse(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        if (intent.hasExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE")) {
            return (GetCredentialResponse) intent.getParcelableExtra("android.service.credentials.extra.GET_CREDENTIAL_RESPONSE", GetCredentialResponse.class);
        }
        return null;
    }

    public static final CreateCredentialResponse getCreateCredentialCredentialResponse(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        if (intent.hasExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE")) {
            return (CreateCredentialResponse) intent.getParcelableExtra("android.service.credentials.extra.CREATE_CREDENTIAL_RESPONSE", CreateCredentialResponse.class);
        }
        return null;
    }
}
