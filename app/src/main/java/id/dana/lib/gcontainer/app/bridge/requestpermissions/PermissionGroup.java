package id.dana.lib.gcontainer.app.bridge.requestpermissions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/requestpermissions/PermissionGroup;", "", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface PermissionGroup {
    public static final String CALENDAR = "CALENDAR";
    public static final String CAMERA = "CAMERA";
    public static final String CONTACT = "CONTACT";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String LOCATION = "LOCATION";
    public static final String MICROPHONE = "MICROPHONE";
    public static final String NOTIFICATION = "NOTIFICATION";
    public static final String PHONE = "PHONE";
    public static final String PHONE_STATE = "PHONE_STATE";
    public static final String STORAGE = "STORAGE";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\f\u0010\u0004"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/requestpermissions/PermissionGroup$Companion;", "", "", "CALENDAR", "Ljava/lang/String;", "CAMERA", "CONTACT", "LOCATION", "MICROPHONE", "NOTIFICATION", "PHONE", "PHONE_STATE", "STORAGE", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CALENDAR = "CALENDAR";
        public static final String CAMERA = "CAMERA";
        public static final String CONTACT = "CONTACT";
        public static final String LOCATION = "LOCATION";
        public static final String MICROPHONE = "MICROPHONE";
        public static final String NOTIFICATION = "NOTIFICATION";
        public static final String PHONE = "PHONE";
        public static final String PHONE_STATE = "PHONE_STATE";
        public static final String STORAGE = "STORAGE";

        private Companion() {
        }
    }
}