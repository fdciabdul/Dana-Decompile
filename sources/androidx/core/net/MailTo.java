package androidx.core.net;

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes6.dex */
public final class MailTo {
    private HashMap<String, String> KClassImpl$Data$declaredNonStaticMembers$2 = new HashMap<>();

    private MailTo() {
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("mailto:");
        sb.append('?');
        for (Map.Entry<String, String> entry : this.KClassImpl$Data$declaredNonStaticMembers$2.entrySet()) {
            sb.append(Uri.encode(entry.getKey()));
            sb.append('=');
            sb.append(Uri.encode(entry.getValue()));
            sb.append(Typography.amp);
        }
        return sb.toString();
    }
}
