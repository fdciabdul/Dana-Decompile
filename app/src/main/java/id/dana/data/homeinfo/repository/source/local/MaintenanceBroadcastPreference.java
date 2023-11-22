package id.dana.data.homeinfo.repository.source.local;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.storage.LocalStorageFactory;
import id.dana.data.storage.PreferenceFacade;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/data/homeinfo/repository/source/local/MaintenanceBroadcastPreference;", "", "", "clearAll", "()V", "", "lastDismissedBroadcast", "", "saveLastDismissedBroadcast", "(Ljava/lang/String;)Z", "getLastDismissedBroadcast", "()Ljava/lang/String;", "Lid/dana/data/storage/PreferenceFacade;", "preferenceFacade", "Lid/dana/data/storage/PreferenceFacade;", "Landroid/content/Context;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MaintenanceBroadcastPreference {
    private static final String HOME_WIDGET_STATE_PREFERENCE = "HomeWidgetStatePreferenceproduction";
    private static final String LAST_DISMISSED_BROADCAST = "last_dismissed_broadcast";
    private final PreferenceFacade preferenceFacade;

    @Inject
    public MaintenanceBroadcastPreference(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        PreferenceFacade createData = new LocalStorageFactory(new LocalStorageFactory.Builder(context).setPreferenceGroup(HOME_WIDGET_STATE_PREFERENCE).setUseDrutherPreference(true)).createData("local");
        Intrinsics.checkNotNullExpressionValue(createData, "");
        this.preferenceFacade = createData;
    }

    @JvmName(name = "getLastDismissedBroadcast")
    public final String getLastDismissedBroadcast() {
        String string = this.preferenceFacade.getString(LAST_DISMISSED_BROADCAST);
        return string == null ? "" : string;
    }

    public final boolean saveLastDismissedBroadcast(String lastDismissedBroadcast) {
        Intrinsics.checkNotNullParameter(lastDismissedBroadcast, "");
        this.preferenceFacade.saveData(LAST_DISMISSED_BROADCAST, lastDismissedBroadcast);
        return true;
    }

    public final void clearAll() {
        this.preferenceFacade.clearAllData();
    }
}
