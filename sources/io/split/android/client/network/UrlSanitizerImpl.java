package io.split.android.client.network;

import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import java.net.URL;
import okhttp3.HttpUrl;

/* loaded from: classes6.dex */
public class UrlSanitizerImpl implements UrlSanitizer {
    private final HttpUrl.Builder mUrlBuilder = new HttpUrl.Builder();

    @Override // io.split.android.client.network.UrlSanitizer
    public URL getUrl(URI uri) {
        this.mUrlBuilder.fragment(uri.getFragment()).host(uri.getHost()).scheme(uri.getScheme()).encodedQuery(uri.getQuery());
        try {
            this.mUrlBuilder.encodedPath(uri.getPath());
        } catch (IllegalArgumentException e) {
            Logger.e(e);
        }
        int port = uri.getPort();
        if (port > 0 && port <= 65535) {
            try {
                this.mUrlBuilder.port(port);
            } catch (IllegalArgumentException e2) {
                Logger.e(e2);
            }
        }
        return this.mUrlBuilder.build().url();
    }
}
