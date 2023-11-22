package io.split.android.client.validators;

import io.split.android.client.utils.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class ValidationMessageLoggerImpl implements ValidationMessageLogger {
    private String sanitizeTag(String str) {
        return str == null ? "" : str;
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void log(ValidationErrorInfo validationErrorInfo, String str) {
        if (validationErrorInfo.isError() && validationErrorInfo.getErrorMessage() != null) {
            e(validationErrorInfo, str);
        } else {
            w(validationErrorInfo, str);
        }
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void e(ValidationErrorInfo validationErrorInfo, String str) {
        e(str, validationErrorInfo.getErrorMessage());
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void w(ValidationErrorInfo validationErrorInfo, String str) {
        Iterator it = new ArrayList(validationErrorInfo.getWarnings().values()).iterator();
        while (it.hasNext()) {
            w(str, (String) it.next());
        }
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void e(String str, String str2) {
        logError(str, str2);
    }

    @Override // io.split.android.client.validators.ValidationMessageLogger
    public void w(String str, String str2) {
        logWarning(str, str2);
    }

    private void logError(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sanitizeTag(str2));
        sb.append(": ");
        sb.append(str);
        Logger.e(sb.toString());
    }

    private void logWarning(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(sanitizeTag(str2));
        sb.append(": ");
        sb.append(str);
        Logger.w(sb.toString());
    }
}
