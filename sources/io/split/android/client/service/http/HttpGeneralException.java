package io.split.android.client.service.http;

/* loaded from: classes6.dex */
public abstract class HttpGeneralException extends Exception {
    private final Integer mHttpStatus;

    public HttpGeneralException(String str, String str2, Integer num) {
        super(getMessage(str, str2, num));
        this.mHttpStatus = num;
    }

    public HttpGeneralException(String str, String str2) {
        super(getMessage(str, str2, null));
        this.mHttpStatus = null;
    }

    private static String getMessage(String str, String str2, Integer num) {
        String str3;
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        if (num != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(". Http status: ");
            sb.append(num);
            str3 = sb.toString();
        } else {
            str3 = "";
        }
        objArr[2] = str3;
        return String.format("Error while sending data to %s: %s%s", objArr);
    }

    public Integer getHttpStatus() {
        return this.mHttpStatus;
    }
}
