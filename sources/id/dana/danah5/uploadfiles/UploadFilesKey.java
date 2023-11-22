package id.dana.danah5.uploadfiles;

import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danah5/uploadfiles/UploadFilesKey;", "", "<init>", "()V", "Error", "Event", "UploadFilesResultParamsKey"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class UploadFilesKey {
    public static final UploadFilesKey INSTANCE = new UploadFilesKey();

    private UploadFilesKey() {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Lid/dana/danah5/uploadfiles/UploadFilesKey$Event;", "", "", "REMOVE_ALL_FILES", "Ljava/lang/String;", "REMOVE_FILE", "SELECT_FILE", "UPLOAD_FILES", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Event {
        public static final Event INSTANCE = new Event();
        public static final String REMOVE_ALL_FILES = "removeAllFiles";
        public static final String REMOVE_FILE = "removeFile";
        public static final String SELECT_FILE = "selectFile";
        public static final String UPLOAD_FILES = "uploadFiles";

        private Event() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004"}, d2 = {"Lid/dana/danah5/uploadfiles/UploadFilesKey$Error;", "", "", "ERROR_MAX_FILE", "I", "ERROR_TIMEOUT", "ERROR_TYPE_NOT_MATCH", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Error {
        public static final int ERROR_MAX_FILE = 11;
        public static final int ERROR_TIMEOUT = 12;
        public static final int ERROR_TYPE_NOT_MATCH = 13;
        public static final Error INSTANCE = new Error();

        private Error() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004"}, d2 = {"Lid/dana/danah5/uploadfiles/UploadFilesKey$UploadFilesResultParamsKey;", "", "", "ERROR", "Ljava/lang/String;", "INDEX", MonitorItemConstants.LEVEL_INFO, "MESSAGE", "SUCCESS", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class UploadFilesResultParamsKey {
        public static final String ERROR = "error";
        public static final String INDEX = "index";
        public static final String INFO = "info";
        public static final UploadFilesResultParamsKey INSTANCE = new UploadFilesResultParamsKey();
        public static final String MESSAGE = "message";
        public static final String SUCCESS = "success";

        private UploadFilesResultParamsKey() {
        }
    }
}
