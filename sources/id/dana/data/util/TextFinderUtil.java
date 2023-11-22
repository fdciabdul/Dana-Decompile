package id.dana.data.util;

import java.util.regex.Pattern;

/* loaded from: classes8.dex */
public class TextFinderUtil {
    public static boolean isTextListContains(String str, String... strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2);
            sb.append("\n");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(".*\\Q");
        sb2.append(str);
        sb2.append("\\E.*");
        return Pattern.compile(sb2.toString(), 42).matcher(sb.toString()).matches();
    }
}
