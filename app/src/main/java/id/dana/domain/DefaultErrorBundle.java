package id.dana.domain;

/* loaded from: classes8.dex */
public class DefaultErrorBundle implements ErrorBundle {
    static final String DEFAULT_ERROR_MESSAGE = "Unknown Error";
    private final Exception exception;

    public DefaultErrorBundle(Exception exc) {
        this.exception = exc;
    }

    @Override // id.dana.domain.ErrorBundle
    public String getErrorMessage() {
        Exception exc = this.exception;
        return exc != null ? exc.getMessage() : "Unknown Error";
    }

    @Override // id.dana.domain.ErrorBundle
    public Exception getException() {
        return this.exception;
    }
}
