package id.dana.danah5.checksendevent;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.lib.gcontainer.extension.ContentExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danah5/checksendevent/CheckSendEventBridge;", "Lid/dana/lib/gcontainer/app/bridge/sendevent/CheckSendEventBridge;", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "isEventValid", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CheckSendEventBridge extends id.dana.lib.gcontainer.app.bridge.sendevent.CheckSendEventBridge {
    @Override // id.dana.lib.gcontainer.app.bridge.sendevent.CheckSendEventBridge
    public final boolean isEventValid(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        return ContentExtKt.hasActivityHandler(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), context);
    }
}
