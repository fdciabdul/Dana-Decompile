package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    @Nullable
    private final String charset;
    private final String mediaType;
    private final String subtype;
    private final String type;
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    private MediaType(String str, String str2, String str3, @Nullable String str4) {
        this.mediaType = str;
        this.type = str2;
        this.subtype = str3;
        this.charset = str4;
    }

    public static MediaType get(String str) {
        Matcher matcher = TYPE_SUBTYPE.matcher(str);
        if (!matcher.lookingAt()) {
            StringBuilder sb = new StringBuilder();
            sb.append("No subtype found for: \"");
            sb.append(str);
            sb.append(Typography.quote);
            throw new IllegalArgumentException(sb.toString());
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = PARAMETER.matcher(str);
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Parameter is not formatted correctly: \"");
                sb2.append(str.substring(end));
                sb2.append("\" for: \"");
                sb2.append(str);
                sb2.append(Typography.quote);
                throw new IllegalArgumentException(sb2.toString());
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 != null) {
                    if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                        group2 = group2.substring(1, group2.length() - 1);
                    }
                } else {
                    group2 = matcher2.group(3);
                }
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Multiple charsets defined: \"");
                    sb3.append(str2);
                    sb3.append("\" and: \"");
                    sb3.append(group2);
                    sb3.append("\" for: \"");
                    sb3.append(str);
                    sb3.append(Typography.quote);
                    throw new IllegalArgumentException(sb3.toString());
                }
                str2 = group2;
            }
        }
        return new MediaType(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    public static MediaType parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    @Nullable
    public final Charset charset() {
        return charset(null);
    }

    @Nullable
    public final Charset charset(@Nullable Charset charset) {
        try {
            String str = this.charset;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public final String toString() {
        return this.mediaType;
    }

    public final boolean equals(@Nullable Object obj) {
        return (obj instanceof MediaType) && ((MediaType) obj).mediaType.equals(this.mediaType);
    }

    public final int hashCode() {
        return this.mediaType.hashCode();
    }
}
