package io.split.android.client.network;

import androidx.core.util.Pair;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class URIBuilder {
    private final Set<Pair<String, String>> mParams;
    private String mPath;
    private String mQueryString;
    private final URI mRootURI;

    public URIBuilder(URI uri, String str) {
        URI uri2 = (URI) Preconditions.checkNotNull(uri);
        this.mRootURI = uri2;
        String rawPath = uri2.getRawPath();
        if (str != null && rawPath != null) {
            String format = String.format("%s/%s", rawPath, str);
            this.mPath = format;
            String replace = format.replace("///", "/");
            this.mPath = replace;
            this.mPath = replace.replace("//", "/");
        } else if (rawPath != null) {
            this.mPath = rawPath;
            this.mQueryString = uri.getQuery();
        } else {
            this.mPath = str;
        }
        this.mParams = new HashSet();
    }

    public URIBuilder(URI uri) {
        this(uri, null);
    }

    public URIBuilder addParameter(String str, String str2) {
        if (str != null && str2 != null) {
            this.mParams.add(new Pair<>(str, str2));
        }
        return this;
    }

    public URIBuilder defaultQueryString(String str) {
        if (!Strings.isNullOrEmpty(str)) {
            this.mQueryString = str;
        }
        return this;
    }

    public URI build() throws URISyntaxException {
        String str;
        if (this.mParams.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (Pair<String, String> pair : this.mParams) {
                sb.append(pair.getAuthRequestContext);
                sb.append("=");
                sb.append(pair.PlaceComponentResult);
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
            str = sb.substring(0, sb.length() - 1);
        } else {
            str = null;
        }
        if (!Strings.isNullOrEmpty(this.mQueryString)) {
            if (!Strings.isNullOrEmpty(str)) {
                if (!ContainerUtils.FIELD_DELIMITER.equals(this.mQueryString.substring(0, 1))) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(ContainerUtils.FIELD_DELIMITER);
                    str = sb2.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(this.mQueryString);
                str = sb3.toString();
            } else {
                str = this.mQueryString;
            }
        }
        return new URI(this.mRootURI.getScheme(), null, this.mRootURI.getHost(), this.mRootURI.getPort(), this.mPath, str, null);
    }
}
