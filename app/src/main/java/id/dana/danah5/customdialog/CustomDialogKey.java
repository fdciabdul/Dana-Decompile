package id.dana.danah5.customdialog;

import com.google.android.gms.stats.CodePackage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danah5/customdialog/CustomDialogKey;", "", "<init>", "()V", "Event", "Response"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CustomDialogKey {
    public static final CustomDialogKey INSTANCE = new CustomDialogKey();

    private CustomDialogKey() {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/danah5/customdialog/CustomDialogKey$Response;", "", "", "CHECK_PERMISSION", "Ljava/lang/String;", "IS_CHECKED", "POSITIVE_CLICK", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Response {
        public static final String CHECK_PERMISSION = "checkPermission";
        public static final Response INSTANCE = new Response();
        public static final String IS_CHECKED = "isChecked";
        public static final String POSITIVE_CLICK = "positiveClick";

        private Response() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/danah5/customdialog/CustomDialogKey$Event;", "", "", CodePackage.COMMON, "Ljava/lang/String;", "LOCATION", "OVERLAY_DIALOG_ILLUSTRATION_HORIZONTAL", "OVERLAY_DIALOG_ILLUSTRATION_VERTICAL", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Event {
        public static final String COMMON = "common";
        public static final Event INSTANCE = new Event();
        public static final String LOCATION = "location";
        public static final String OVERLAY_DIALOG_ILLUSTRATION_HORIZONTAL = "overlay-dialog-illustration-horizontal";
        public static final String OVERLAY_DIALOG_ILLUSTRATION_VERTICAL = "overlay-dialog-illustration-vertical";

        private Event() {
        }
    }
}
