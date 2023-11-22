package androidx.credentials.exceptions.domerrors;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/credentials/exceptions/domerrors/ReadOnlyError;", "Landroidx/credentials/exceptions/domerrors/DomError;", "<init>", "()V", "Companion"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReadOnlyError extends DomError {
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR = "androidx.credentials.TYPE_READ_ONLY_ERROR";

    public ReadOnlyError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_READ_ONLY_ERROR);
    }
}
