package io.opentelemetry.exporter.internal;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.net.URI;
import java.net.URISyntaxException;

/* loaded from: classes9.dex */
public final class ExporterBuilderUtil {
    public static URI validateEndpoint(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getScheme() == null || !(uri.getScheme().equals(SemanticAttributes.FaasTriggerValues.HTTP) || uri.getScheme().equals("https"))) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid endpoint, must start with http:// or https://: ");
                sb.append(uri);
                throw new IllegalArgumentException(sb.toString());
            }
            return uri;
        } catch (URISyntaxException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Invalid endpoint, must be a URL: ");
            sb2.append(str);
            throw new IllegalArgumentException(sb2.toString(), e);
        }
    }

    private ExporterBuilderUtil() {
    }
}
