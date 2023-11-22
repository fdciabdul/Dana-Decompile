package id.dana.core.ui.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/core/ui/util/TextUtil;", "", "Landroid/content/Context;", "p0", "", "p1", "p2", "", "getAuthRequestContext", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class TextUtil {
    public static final TextUtil INSTANCE = new TextUtil();

    private TextUtil() {
    }

    public static boolean getAuthRequestContext(Context p0, String p1, String p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        try {
            Object systemService = p0.getSystemService("clipboard");
            ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(p1, p2));
                return true;
            }
        } catch (Exception e) {
            Timber.Tree authRequestContext = Timber.getAuthRequestContext("TextUtil");
            StringBuilder sb = new StringBuilder();
            sb.append("[CopyToClipboard] ");
            sb.append(e.getMessage());
            authRequestContext.MyBillsEntityDataFactory(sb.toString(), new Object[0]);
        }
        return false;
    }
}
