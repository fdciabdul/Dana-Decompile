package com.appsflyer.internal;

import android.util.Base64;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class h {
    String AFInAppEventParameterName;
    String AFKeystoreWrapper;
    String valueOf;
    private byte[] values;

    public h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str, byte[] bArr, String str2) {
        this.AFInAppEventParameterName = str;
        this.values = bArr;
        this.AFKeystoreWrapper = str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i = 0;
        int i2 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.AFInAppEventParameterName = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.AFKeystoreWrapper = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.AFKeystoreWrapper);
                if (matcher.matches()) {
                    i = Integer.parseInt(matcher.group(1));
                    i2 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.values = (i > 4 || i2 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            }
        }
        scanner.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] values() {
        return this.values;
    }
}
