package okhttp3.internal.http;

import com.alibaba.griver.api.common.network.HttpResponse;
import id.dana.cashier.view.InputCardNumberView;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;

/* loaded from: classes6.dex */
public final class StatusLine {
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public StatusLine(Protocol protocol, int i, String str) {
        this.protocol = protocol;
        this.code = i;
        this.message = str;
    }

    public static StatusLine get(Response response) {
        return new StatusLine(response.protocol(), response.code(), response.message());
    }

    public static StatusLine parse(String str) throws IOException {
        Protocol protocol;
        String str2;
        int i = 9;
        if (str.startsWith("HTTP/1.")) {
            if (str.length() < 9 || str.charAt(8) != ' ') {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected status line: ");
                sb.append(str);
                throw new ProtocolException(sb.toString());
            }
            int charAt = str.charAt(7) - '0';
            if (charAt == 0) {
                protocol = Protocol.HTTP_1_0;
            } else if (charAt == 1) {
                protocol = Protocol.HTTP_1_1;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected status line: ");
                sb2.append(str);
                throw new ProtocolException(sb2.toString());
            }
        } else if (str.startsWith("ICY ")) {
            protocol = Protocol.HTTP_1_0;
            i = 4;
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unexpected status line: ");
            sb3.append(str);
            throw new ProtocolException(sb3.toString());
        }
        int i2 = i + 3;
        if (str.length() < i2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unexpected status line: ");
            sb4.append(str);
            throw new ProtocolException(sb4.toString());
        }
        try {
            int parseInt = Integer.parseInt(str.substring(i, i2));
            if (str.length() <= i2) {
                str2 = "";
            } else if (str.charAt(i2) != ' ') {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Unexpected status line: ");
                sb5.append(str);
                throw new ProtocolException(sb5.toString());
            } else {
                str2 = str.substring(i + 4);
            }
            return new StatusLine(protocol, parseInt, str2);
        } catch (NumberFormatException unused) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Unexpected status line: ");
            sb6.append(str);
            throw new ProtocolException(sb6.toString());
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.protocol == Protocol.HTTP_1_0 ? "HTTP/1.0" : HttpResponse.PROTOCOL.HTTP_1_1);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(this.code);
        if (this.message != null) {
            sb.append(InputCardNumberView.DIVIDER);
            sb.append(this.message);
        }
        return sb.toString();
    }
}
