package io.split.android.client;

import io.split.android.client.api.Key;
import io.split.android.client.shared.UserConsent;

/* loaded from: classes6.dex */
public interface SplitFactory {
    SplitClient client();

    SplitClient client(Key key);

    SplitClient client(String str);

    SplitClient client(String str, String str2);

    void destroy();

    void flush();

    UserConsent getUserConsent();

    SplitManager manager();

    void setUserConsent(boolean z);
}
