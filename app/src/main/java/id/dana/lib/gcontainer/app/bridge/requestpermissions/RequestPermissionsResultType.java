package id.dana.lib.gcontainer.app.bridge.requestpermissions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/requestpermissions/RequestPermissionsResultType;", "", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface RequestPermissionsResultType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String GENERAL_ERROR = "001";
    public static final String PERMISSION_DENIED = "002";
    public static final String PERMISSION_NOT_SET = "003";
    public static final String SOME_PERMISSION_DENIED = "004";
    public static final String SOME_PERMISSION_NOT_SET = "005";
    public static final String SUCCESS = "000";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/requestpermissions/RequestPermissionsResultType$Companion;", "", "", "GENERAL_ERROR", "Ljava/lang/String;", "PERMISSION_DENIED", "PERMISSION_NOT_SET", "SOME_PERMISSION_DENIED", "SOME_PERMISSION_NOT_SET", "SUCCESS", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String GENERAL_ERROR = "001";
        public static final String PERMISSION_DENIED = "002";
        public static final String PERMISSION_NOT_SET = "003";
        public static final String SOME_PERMISSION_DENIED = "004";
        public static final String SOME_PERMISSION_NOT_SET = "005";
        public static final String SUCCESS = "000";

        private Companion() {
        }
    }
}
