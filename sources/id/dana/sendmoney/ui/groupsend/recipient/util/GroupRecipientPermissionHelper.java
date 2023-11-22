package id.dana.sendmoney.ui.groupsend.recipient.util;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/util/GroupRecipientPermissionHelper;", "", "Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GroupRecipientPermissionHelper {
    public static final GroupRecipientPermissionHelper INSTANCE = new GroupRecipientPermissionHelper();

    private GroupRecipientPermissionHelper() {
    }

    public static boolean getAuthRequestContext(Context p0) {
        String[] strArr = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS"};
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= 2) {
                z = true;
                break;
            }
            if (!(ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, strArr[i]) == 0)) {
                break;
            }
            i++;
        }
        return !z;
    }
}
