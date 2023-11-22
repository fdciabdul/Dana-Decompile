package id.dana.danah5.imagecapture.viewmodel;

import id.dana.phototips.model.PhotoTipsModel;
import id.dana.scanner.handler.ScannerActionState;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007"}, d2 = {"Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState;", "", "<init>", "()V", ScannerActionState.IDLE, "InitPhotoTips", "Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState$Idle;", "Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState$InitPhotoTips;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public abstract class ImageCaptureUiState {
    public /* synthetic */ ImageCaptureUiState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ImageCaptureUiState() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState$Idle;", "Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Idle extends ImageCaptureUiState {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState$InitPhotoTips;", "Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureUiState;", "Lid/dana/phototips/model/PhotoTipsModel;", "photoTipsModel", "Lid/dana/phototips/model/PhotoTipsModel;", "getPhotoTipsModel", "()Lid/dana/phototips/model/PhotoTipsModel;", "<init>", "(Lid/dana/phototips/model/PhotoTipsModel;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class InitPhotoTips extends ImageCaptureUiState {
        private final PhotoTipsModel photoTipsModel;

        public InitPhotoTips(PhotoTipsModel photoTipsModel) {
            super(null);
            this.photoTipsModel = photoTipsModel;
        }

        @JvmName(name = "getPhotoTipsModel")
        public final PhotoTipsModel getPhotoTipsModel() {
            return this.photoTipsModel;
        }
    }
}
