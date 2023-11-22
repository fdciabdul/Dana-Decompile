package retrofit2;

import java.util.Objects;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    private static String getMessage(Response<?> response) {
        Objects.requireNonNull(response, "response == null");
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP ");
        sb.append(response.getAuthRequestContext.code());
        sb.append(" ");
        sb.append(response.getAuthRequestContext.message());
        return sb.toString();
    }

    public HttpException(Response<?> response) {
        super(getMessage(response));
        this.code = response.getAuthRequestContext.code();
        this.message = response.getAuthRequestContext.message();
        this.response = response;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public Response<?> response() {
        return this.response;
    }
}
