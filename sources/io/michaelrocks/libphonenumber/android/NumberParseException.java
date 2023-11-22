package io.michaelrocks.libphonenumber.android;

/* loaded from: classes6.dex */
public class NumberParseException extends Exception {
    private ErrorType errorType;
    private String message;

    /* loaded from: classes6.dex */
    public enum ErrorType {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public NumberParseException(ErrorType errorType, String str) {
        super(str);
        this.message = str;
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return this.errorType;
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Error type: ");
        sb.append(this.errorType);
        sb.append(". ");
        sb.append(this.message);
        return sb.toString();
    }
}
