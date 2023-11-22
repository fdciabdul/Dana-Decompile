package io.split.android.client;

import android.content.Context;
import io.split.android.client.api.Key;
import io.split.android.client.localhost.LocalhostSplitFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class SplitFactoryBuilder {
    public static SplitFactory build(String str, String str2, Context context) throws IOException, InterruptedException, TimeoutException, URISyntaxException {
        return build(str, new Key(str2, null), context);
    }

    public static SplitFactory build(String str, Key key, Context context) throws IOException, InterruptedException, TimeoutException, URISyntaxException {
        return build(str, key, SplitClientConfig.builder().build(), context);
    }

    public static SplitFactory build(String str, Key key, SplitClientConfig splitClientConfig, Context context) throws IOException, InterruptedException, TimeoutException, URISyntaxException {
        synchronized (SplitFactoryBuilder.class) {
            if ("localhost".equals(str)) {
                return new LocalhostSplitFactory(key.matchingKey(), context, splitClientConfig);
            }
            return new SplitFactoryImpl(str, key, splitClientConfig, context);
        }
    }

    public static SplitFactory local(String str, Context context) throws IOException {
        return new LocalhostSplitFactory(str, context, SplitClientConfig.builder().build());
    }
}
