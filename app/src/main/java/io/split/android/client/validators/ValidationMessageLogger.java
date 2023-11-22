package io.split.android.client.validators;

/* loaded from: classes6.dex */
public interface ValidationMessageLogger {
    void e(ValidationErrorInfo validationErrorInfo, String str);

    void e(String str, String str2);

    void log(ValidationErrorInfo validationErrorInfo, String str);

    void w(ValidationErrorInfo validationErrorInfo, String str);

    void w(String str, String str2);
}
