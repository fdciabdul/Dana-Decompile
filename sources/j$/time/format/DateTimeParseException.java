package j$.time.format;

import j$.time.DateTimeException;

/* loaded from: classes9.dex */
public final class DateTimeParseException extends DateTimeException {
    private static final long serialVersionUID = 4304633501674722597L;

    public DateTimeParseException(String str, CharSequence charSequence) {
        super(str);
    }

    public DateTimeParseException(String str, CharSequence charSequence, RuntimeException runtimeException) {
        super(str, runtimeException);
    }
}
