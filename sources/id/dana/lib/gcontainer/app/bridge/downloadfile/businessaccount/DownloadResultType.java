package id.dana.lib.gcontainer.app.bridge.downloadfile.businessaccount;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/businessaccount/DownloadResultType;", "", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface DownloadResultType {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String GENERAL_ERROR = "GENERAL_ERROR";
    public static final String NO_PERMISSION = "NO_PERMISSION";
    public static final String STORAGE_LOW = "STORAGE_LOW";
    public static final String SUCCESS = "SUCCESS";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/businessaccount/DownloadResultType$Companion;", "", "", "GENERAL_ERROR", "Ljava/lang/String;", "NO_PERMISSION", "STORAGE_LOW", "SUCCESS", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String GENERAL_ERROR = "GENERAL_ERROR";
        public static final String NO_PERMISSION = "NO_PERMISSION";
        public static final String STORAGE_LOW = "STORAGE_LOW";
        public static final String SUCCESS = "SUCCESS";

        private Companion() {
        }
    }
}
