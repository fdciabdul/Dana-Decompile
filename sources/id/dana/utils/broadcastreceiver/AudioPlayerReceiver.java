package id.dana.utils.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0002\u0013\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/utils/broadcastreceiver/AudioPlayerReceiver;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/content/Intent;", "intent", "", "onReceive", "(Landroid/content/Context;Landroid/content/Intent;)V", "Lid/dana/utils/broadcastreceiver/AudioPlayerReceiver$AudioPlayerReceiverListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRingerModeListener", "(Lid/dana/utils/broadcastreceiver/AudioPlayerReceiver$AudioPlayerReceiverListener;)V", "PlaceComponentResult", "Lid/dana/utils/broadcastreceiver/AudioPlayerReceiver$AudioPlayerReceiverListener;", "BuiltInFictitiousFunctionClassFactory", "<init>", "()V", "Companion", "AudioPlayerReceiverListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioPlayerReceiver extends BroadcastReceiver {
    public static final String RINGER_MODE_CHANGED = "android.media.RINGER_MODE_CHANGED";

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private AudioPlayerReceiverListener BuiltInFictitiousFunctionClassFactory;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/utils/broadcastreceiver/AudioPlayerReceiver$AudioPlayerReceiverListener;", "", "", "p0", "", "getAuthRequestContext", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface AudioPlayerReceiverListener {
        void getAuthRequestContext(int p0);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        if ((intent != null ? intent.getAction() : null) == null || (action = intent.getAction()) == null || action.hashCode() != 2070024785 || !action.equals(RINGER_MODE_CHANGED)) {
            return;
        }
        Object systemService = context != null ? context.getSystemService(H5ResourceHandlerUtil.AUDIO) : null;
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
        }
        AudioManager audioManager = (AudioManager) systemService;
        AudioPlayerReceiverListener audioPlayerReceiverListener = this.BuiltInFictitiousFunctionClassFactory;
        if (audioPlayerReceiverListener != null) {
            audioPlayerReceiverListener.getAuthRequestContext(audioManager.getRingerMode());
        }
    }

    public final void setRingerModeListener(AudioPlayerReceiverListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.BuiltInFictitiousFunctionClassFactory = listener;
    }
}
