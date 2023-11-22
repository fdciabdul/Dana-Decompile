package id.dana.lib.gcontainer.app.bridge.imagepicker;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerResultType;", "", "Companion"}, k = 1, mv = {1, 5, 1}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface ImagePickerResultType {
    public static final String CAMERA_PERMISSION_NOT_GRANTED = "ERR_CAMERA_PERMISSION_NOT_GRANTED";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String FAILED_COMPRESS_IMAGE = "ERR_FAILED_COMPRESS_IMAGE";
    public static final String FAILED_CREATING_IMAGE = "ERR_FAILED_CREATING_IMAGE";
    public static final String FAILED_RESIZE_IMAGE = "ERR_FAILED_RESIZE_IMAGE";
    public static final String GALLERY_PERMISSION_NOT_GRANTED = "ERR_GALLERY_PERMISSION_NOT_GRANTED";
    public static final String GENERAL_ERROR = "GENERAL_ERROR";
    public static final String SUCCESS = "";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0087T¢\u0006\u0006\n\u0004\b\n\u0010\u0004"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/imagepicker/ImagePickerResultType$Companion;", "", "", "CAMERA_PERMISSION_NOT_GRANTED", "Ljava/lang/String;", "FAILED_COMPRESS_IMAGE", "FAILED_CREATING_IMAGE", "FAILED_RESIZE_IMAGE", "GALLERY_PERMISSION_NOT_GRANTED", "GENERAL_ERROR", "SUCCESS", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String CAMERA_PERMISSION_NOT_GRANTED = "ERR_CAMERA_PERMISSION_NOT_GRANTED";
        public static final String FAILED_COMPRESS_IMAGE = "ERR_FAILED_COMPRESS_IMAGE";
        public static final String FAILED_CREATING_IMAGE = "ERR_FAILED_CREATING_IMAGE";
        public static final String FAILED_RESIZE_IMAGE = "ERR_FAILED_RESIZE_IMAGE";
        public static final String GALLERY_PERMISSION_NOT_GRANTED = "ERR_GALLERY_PERMISSION_NOT_GRANTED";
        public static final String GENERAL_ERROR = "GENERAL_ERROR";
        public static final String SUCCESS = "";

        private Companion() {
        }
    }
}
