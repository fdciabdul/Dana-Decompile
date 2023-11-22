package io.split.android.client.utils;

import com.google.common.base.Strings;

/* loaded from: classes6.dex */
public class Utils {
    public static String sanitizeForFileName(String str) {
        return str == null ? "" : str.replaceAll("[^a-zA-Z0-9.\\-]", "_");
    }

    private static String sanitizeForFolderName(String str) {
        return str == null ? "" : str.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static String convertApiKeyToFolder(String str) {
        String sanitizeForFolderName = sanitizeForFolderName(str);
        StringBuilder sb = new StringBuilder("$2a$10$");
        if (sanitizeForFolderName.length() >= 22) {
            sb.append(sanitizeForFolderName.substring(0, 22));
        } else {
            sb.append(sanitizeForFolderName);
            sb.append(Strings.repeat("A", 22 - sanitizeForFolderName.length()));
        }
        String hashpw = BCrypt.hashpw(sanitizeForFolderName, sb.toString().substring(0, 29));
        if (hashpw != null) {
            return sanitizeForFolderName(hashpw);
        }
        return null;
    }
}
