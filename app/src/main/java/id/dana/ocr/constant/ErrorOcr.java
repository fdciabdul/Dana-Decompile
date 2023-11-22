package id.dana.ocr.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/ocr/constant/ErrorOcr;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes2.dex */
public @interface ErrorOcr {
    public static final String BASE64_ENCODING_FAILED = "009";
    public static final String CAMERA_RESULT_NULL = "010";
    public static final String CANNOT_RECOGNIZE_RECEIPT = "006";

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;
    public static final String DATA_NOT_ENOUGH = "004";
    public static final String DONT_HAVE_CAMERA_PERMISSION = "005";
    public static final String FILE_NOT_FOUND = "013";
    public static final String GENERAL_ERROR = "001";
    public static final String PARAM_NOT_ENOUGH = "007";
    public static final String STORAGE_FULL = "003";
    public static final String USER_CANCELLED = "002";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/ocr/constant/ErrorOcr$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}
