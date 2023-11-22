package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.CreateCredentialRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000f"}, d2 = {"Landroidx/credentials/CreateCustomCredentialRequest;", "Landroidx/credentials/CreateCredentialRequest;", "", "type", "Landroid/os/Bundle;", "credentialData", "candidateQueryData", "", "isSystemProviderRequired", "Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "displayInfo", "isAutoSelectAllowed", "origin", "preferImmediatelyAvailableCredentials", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;ZLandroidx/credentials/CreateCredentialRequest$DisplayInfo;ZLjava/lang/String;Z)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public class CreateCustomCredentialRequest extends CreateCredentialRequest {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateCustomCredentialRequest(String str, Bundle bundle, Bundle bundle2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo) {
        this(str, bundle, bundle2, z, displayInfo, false, null, false, 224, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(bundle2, "");
        Intrinsics.checkNotNullParameter(displayInfo, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateCustomCredentialRequest(String str, Bundle bundle, Bundle bundle2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo, boolean z2) {
        this(str, bundle, bundle2, z, displayInfo, z2, null, false, 192, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(bundle2, "");
        Intrinsics.checkNotNullParameter(displayInfo, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateCustomCredentialRequest(String str, Bundle bundle, Bundle bundle2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo, boolean z2, String str2) {
        this(str, bundle, bundle2, z, displayInfo, z2, str2, false, 128, null);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(bundle2, "");
        Intrinsics.checkNotNullParameter(displayInfo, "");
    }

    public /* synthetic */ CreateCustomCredentialRequest(String str, Bundle bundle, Bundle bundle2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo, boolean z2, String str2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle, bundle2, z, displayInfo, (i & 32) != 0 ? false : z2, (i & 64) != 0 ? null : str2, (i & 128) != 0 ? false : z3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateCustomCredentialRequest(String str, Bundle bundle, Bundle bundle2, boolean z, CreateCredentialRequest.DisplayInfo displayInfo, boolean z2, String str2, boolean z3) {
        super(str, bundle, bundle2, z, z2, displayInfo, str2, z3);
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(bundle, "");
        Intrinsics.checkNotNullParameter(bundle2, "");
        Intrinsics.checkNotNullParameter(displayInfo, "");
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("type should not be empty".toString());
        }
    }
}
