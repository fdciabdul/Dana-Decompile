package id.dana.danah5.imagecapture;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentManager;
import androidx.view.ComponentActivity;
import androidx.view.LifecycleOwnerKt;
import androidx.view.ViewModelLazy;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.viewmodel.CreationExtras;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.anggrayudi.storage.permission.ActivityPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Executors;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import com.otaliastudios.cameraview.CameraView;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingActivity;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.extension.ViewExtKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.util.OSUtil;
import id.dana.core.ui.util.PermissionHelper;
import id.dana.danah5.imagecapture.model.ImageCaptureModel;
import id.dana.danah5.imagecapture.viewmodel.ImageCaptureViewModel;
import id.dana.databinding.ActivityImageCaptureBinding;
import id.dana.di.component.ImageCaptureComponent;
import id.dana.di.modules.features.imagecapture.ImageCaptureComponentProvider;
import id.dana.extension.view.InputExtKt;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.permissionprompt.constant.PermissionPromptSource;
import id.dana.permissionprompt.view.PermissionPromptBottomSheetDialog;
import id.dana.phototips.PhotoTipsBottomSheetFragment;
import id.dana.phototips.model.PhotoTipsModel;
import id.dana.tracker.EventPropertiesModel;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.utils.BitmapUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.SafeClickListenerExtensionKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001tB\u0007¢\u0006\u0004\bs\u0010)J*\u0010\b\u001a\u00020\u00052\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0002\b\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJY\u0010\u0013\u001a\u00020\u00122\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00050\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u001a\u001a\u00020\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b!\u0010 J-\u0010$\u001a\u00020\u00052\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0002H\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010)J\u0019\u0010,\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0005H\u0002¢\u0006\u0004\b.\u0010)J\u000f\u0010/\u001a\u00020\u0005H\u0002¢\u0006\u0004\b/\u0010)J\u000f\u00100\u001a\u00020\u0005H\u0002¢\u0006\u0004\b0\u0010)J\u000f\u00101\u001a\u00020\u0005H\u0014¢\u0006\u0004\b1\u0010)J\u000f\u00102\u001a\u00020\u0005H\u0002¢\u0006\u0004\b2\u0010)J\u000f\u00103\u001a\u00020\u0005H\u0002¢\u0006\u0004\b3\u0010)J\u000f\u00104\u001a\u00020\u0005H\u0002¢\u0006\u0004\b4\u0010)J\u001f\u00106\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b6\u00107J\u001f\u00109\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b9\u00107J\u000f\u0010:\u001a\u00020\u0005H\u0002¢\u0006\u0004\b:\u0010)J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010;\u001a\u00020\u000bH\u0002¢\u0006\u0004\b+\u0010<J\u000f\u0010=\u001a\u00020\u0005H\u0002¢\u0006\u0004\b=\u0010)J\u000f\u0010>\u001a\u00020\u0005H\u0002¢\u0006\u0004\b>\u0010)J\u0017\u0010@\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u001cH\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\u0005H\u0002¢\u0006\u0004\bB\u0010)J\u000f\u0010C\u001a\u00020\u0005H\u0002¢\u0006\u0004\bC\u0010)J.\u0010G\u001a\u00020\u00052\u0006\u0010E\u001a\u00020D2\u0014\b\u0004\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\b¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0005H\u0002¢\u0006\u0004\bI\u0010)J\u0017\u0010J\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bJ\u0010AJ\u0017\u0010K\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bK\u0010AJ\u0017\u0010M\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u0018H\u0002¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0005H\u0002¢\u0006\u0004\bO\u0010)R\u0016\u0010Q\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010S\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001e\u0010V\u001a\f\u0012\b\u0012\u0006*\u00020\u000b0\u000b0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010X\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010Z\u001a\u00020P8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bZ\u0010RR\u0016\u0010\\\u001a\u00020[8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010^\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b^\u0010_R\u001a\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00120`8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\"\u0010g\u001a\u00020f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u001b\u0010r\u001a\u00020m8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q"}, d2 = {"Lid/dana/danah5/imagecapture/ImageCaptureActivity;", "Lid/dana/core/ui/BaseViewBindingActivity;", "Lid/dana/databinding/ActivityImageCaptureBinding;", "Lkotlin/Function1;", "Lid/dana/tracker/EventTrackerModel$Builder;", "", "Lkotlin/ExtensionFunctionType;", "composeEvent", "execute", "(Lkotlin/jvm/functions/Function1;)V", "", "", RequestPermission.PERMISSIONS, "Lkotlin/Function0;", "onCameraPermissionGranted", "onGalleryPermissionGranted", "Lcom/anggrayudi/storage/permission/PermissionRequest;", "onDisplayConsentDialog", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "getActivityPermissionRequest", "([Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "docId", "getDocIdWithDefaultValue", "(Ljava/lang/String;)Ljava/lang/String;", "", "isOpenGalleryAction", "getGalleryPermissionRequest", "(Z)Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "Landroid/graphics/Bitmap;", "bitmap", "", "getHeight", "(Landroid/graphics/Bitmap;)I", "getWidth", "doAction", "otherwise", "ifAndroid10Below", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "inflateViewBinding", "()Lid/dana/databinding/ActivityImageCaptureBinding;", IAPSyncCommand.COMMAND_INIT, "()V", "Lid/dana/danah5/imagecapture/model/ImageCaptureModel;", H5GetLogInfoBridge.RESULT_MODEL, "initBasedOnEvent", "(Lid/dana/danah5/imagecapture/model/ImageCaptureModel;)V", "initButtonCheckTip", "initCameraPermissionRequest", "initCameraView", "initComponent", "initLifecycle", "initListeners", "initPermissionRequest", "spaceCode", "initTipUploadPhoto", "(Ljava/lang/String;Ljava/lang/String;)V", "title", "initToolbar", "initViews", "event", "(Ljava/lang/String;)Lid/dana/danah5/imagecapture/model/ImageCaptureModel;", "nextPermissionRequest", "onGalleryIconClicked", "capturedImageBitmap", "onUploadImage", "(Landroid/graphics/Bitmap;)V", "openBottomSheetPhotoTips", "openGallery", "", "source", "onBitmapReady", "proceedBitmap", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "redirectToSystemSettings", "setScaleTypeBaseOnOrientation", "showChosenImage", "isPicturePreviewShown", "showPicturePreviewView", "(Z)V", "toggleLight", "Lid/dana/permissionprompt/view/PermissionPromptBottomSheetDialog;", "cameraPromptPermissionBottomSheetDialog", "Lid/dana/permissionprompt/view/PermissionPromptBottomSheetDialog;", IpcMessageConstants.EXTRA_EVENT, "Ljava/lang/String;", "Landroidx/activity/result/ActivityResultLauncher;", "galleryLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "galleryPermissionRequestWithOpenGalleryAction", "Lcom/anggrayudi/storage/permission/ActivityPermissionRequest;", "galleryPromptPermissionBottomSheetDialog", "Lid/dana/di/component/ImageCaptureComponent;", "imageCaptureComponent", "Lid/dana/di/component/ImageCaptureComponent;", "imageCaptureModel", "Lid/dana/danah5/imagecapture/model/ImageCaptureModel;", "Ljava/util/LinkedList;", "permissionQueue", "Ljava/util/LinkedList;", "Lid/dana/phototips/model/PhotoTipsModel;", "photoTipsModel", "Lid/dana/phototips/model/PhotoTipsModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "viewModelFactory", "Lid/dana/core/ui/di/module/ViewModelFactory;", "getViewModelFactory", "()Lid/dana/core/ui/di/module/ViewModelFactory;", "setViewModelFactory", "(Lid/dana/core/ui/di/module/ViewModelFactory;)V", "Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureViewModel;", "vm$delegate", "Lkotlin/Lazy;", "getVm", "()Lid/dana/danah5/imagecapture/viewmodel/ImageCaptureViewModel;", "vm", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ImageCaptureActivity extends BaseViewBindingActivity<ActivityImageCaptureBinding> {
    private static final String ALLOWED_IMAGE_FORMAT = "image/png|image/jpeg|image/jpg";
    private static final String CAMERA_PAGE = "Camera Page";
    private static final String CAMERA_WITH_FRAME = "cameraWithFrame";
    private static final String EMPTY_LABEL = "empty";
    private static final long GUIDELINE_SHOW_DURATION = 1300;
    public static final String IMAGE_CAPTURE_EVENT = "image_capture_event";
    public static final String IMAGE_CAPTURE_MODEL_EXTRA = "image_capture_model_extra";
    public static final String IMAGE_CAPTURE_URI_EXTRA = "image_capture_uri_extra";
    private static final String IMAGE_TYPE = "image";
    private static int[] KClassImpl$Data$declaredNonStaticMembers$2 = null;
    private static final String TEMP_FILE_NAME = "JPEG_";
    private static final String TEMP_FILE_SUFFIX = ".jpg";
    private static final int ZERO = 0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private PermissionPromptBottomSheetDialog cameraPromptPermissionBottomSheetDialog;
    private String eventName;
    private final ActivityResultLauncher<String> galleryLauncher;
    private ActivityPermissionRequest galleryPermissionRequestWithOpenGalleryAction;
    private PermissionPromptBottomSheetDialog galleryPromptPermissionBottomSheetDialog;
    private ImageCaptureComponent imageCaptureComponent;
    private ImageCaptureModel imageCaptureModel;
    private final LinkedList<ActivityPermissionRequest> permissionQueue;
    private PhotoTipsModel photoTipsModel;
    @Inject
    public ViewModelFactory viewModelFactory;

    /* renamed from: vm$delegate  reason: from kotlin metadata */
    private final Lazy vm;
    public static final byte[] $$a = {79, Ascii.DC4, Ascii.EM, -22, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 149;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_CHR, -70, 75, 72, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int PlaceComponentResult = 96;

    static {
        getAuthRequestContext();
        INSTANCE = new Companion(null);
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0023 -> B:23:0x002b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r7, int r8, byte r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.danah5.imagecapture.ImageCaptureActivity.getAuthRequestContext
            int r8 = 106 - r8
            int r9 = 56 - r9
            int r7 = 23 - r7
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L13
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L2b
        L13:
            r3 = 0
        L14:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            if (r4 != r7) goto L23
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L23:
            r3 = r0[r9]
            r6 = r10
            r10 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L2b:
            int r9 = r9 + 1
            int r10 = r10 + r8
            int r8 = r10 + (-4)
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.imagecapture.ImageCaptureActivity.b(int, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002a -> B:23:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 + 4
            int r6 = r6 * 2
            int r6 = 103 - r6
            int r8 = r8 * 3
            int r8 = r8 + 21
            byte[] r0 = id.dana.danah5.imagecapture.ImageCaptureActivity.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L37
        L1a:
            r3 = 0
        L1b:
            int r7 = r7 + 1
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L37:
            int r7 = r7 + r6
            int r6 = r7 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.imagecapture.ImageCaptureActivity.c(short, byte, short, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        KClassImpl$Data$declaredNonStaticMembers$2 = new int[]{1993418254, 283787600, 643718674, 307258505, 1099655152, -22192175, 1707664073, -1715811204, 184788899, -729592807, 1870523785, -887406913, -1750395182, -1026068794, 1872241616, -401440214, 389673393, 1304396791};
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a(18 - (ViewConfiguration.getPressedStateDuration() >> 16), new int[]{-911454851, 896034896, -1402711990, 543294345, -1350417238, -2016184673, 1691200595, 883942906, 1205958230, 802989668}, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 5, new int[]{-966321824, 666395029, 1606022272, 2112818361}, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 930, (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 34, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(48 - TextUtils.getTrimmedLength(""), new int[]{1056367538, 1528829433, -1345761164, 352733734, -509176858, -622018222, 1959938281, 171712298, 1375345105, -2061684474, -1688717853, 558950590, 928285546, 2146064940, 1759936448, -1552609957, -418348550, -469741945, 1202070341, -2051347363, -1801422712, 1687435495, 299922301, 1841649077}, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(65 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), new int[]{1942408493, 442121699, 398457208, 927761179, 2094871738, 1502714043, -1113935700, -1660162830, 1509805788, -2017426302, 1365998754, -1630034955, -1981810476, -1947078965, 843744798, 1408881650, 372356350, -719972156, 696433289, -1662981033, 1454680940, -728892202, -335991229, -249066194, -1816675058, 83732990, -49106619, -596557667, 699871009, 521736209, -1426071786, -1790262698}, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(64 - (ViewConfiguration.getScrollDefaultDelay() >> 16), new int[]{-706515449, -211773619, -450015471, -1593225829, -992221556, -175521075, -1516152743, -449336643, 2037825858, 227773318, 1534441873, 1857867182, -314402684, 31262043, 1837265891, -327350052, -713666192, 1270657239, 906677945, -1911197571, -192050790, -1011268180, 837702564, 1486719325, -378470116, 533921114, -276580892, 1217638183, 636651878, 598716634, 549144425, 676248940}, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(60 - (ViewConfiguration.getEdgeSlop() >> 16), new int[]{997515826, 1523956037, -1775502278, 1699114398, -1094495616, 81204802, 2088851846, -927292020, -1326426279, 2058337716, -1131304255, 763892026, 1876204231, -1558297880, 1792265330, 607476960, 197884994, -136809984, -1072319445, 1736319562, -674483372, -1975828523, 1937158671, -802265876, 1683786538, 583804511, -512084961, -823707408, -1526369845, -229680976}, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(6 - View.MeasureSpec.getMode(0), new int[]{166214230, 1414858007, -133373062, 1028248408}, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((KeyEvent.getMaxKeyCode() >> 16) + 911, 18 - KeyEvent.normalizeMetaState(0), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                        }
                        ((Method) obj2).invoke(invoke, objArr12);
                    } catch (Throwable th) {
                        Throwable cause = th.getCause();
                        if (cause == null) {
                            throw th;
                        }
                        throw cause;
                    }
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            }
        }
        Context applicationContext2 = context != null ? context.getApplicationContext() : context;
        if (applicationContext2 != null) {
            try {
                Object[] objArr13 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], getAuthRequestContext[31], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - Color.alpha(0), TextUtils.indexOf((CharSequence) "", '0') + 4, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)));
                        Object[] objArr16 = new Object[1];
                        c($$a[12], $$a[47], $$a[78], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 15, (char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), View.resolveSizeAndState(0, 0, 0) + 15, (char) TextUtils.getOffsetAfter("", 0))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 815, ((Process.getThreadPriority(0) + 20) >> 6) + 29, (char) (57993 - TextUtils.lastIndexOf("", '0', 0)))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - View.MeasureSpec.getSize(0), Color.argb(0, 0, 0, 0) + 15, (char) TextUtils.getOffsetAfter("", 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getScrollBarSize() >> 8), TextUtils.lastIndexOf("", '0') + 36, (char) View.getDefaultSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-2029045833, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 912, 'B' - AndroidCharacter.getMirror('0'), (char) View.resolveSize(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj8);
                                            }
                                            ((Method) obj8).invoke(invoke3, objArr18);
                                        } catch (Throwable th3) {
                                            Throwable cause3 = th3.getCause();
                                            if (cause3 == null) {
                                                throw th3;
                                            }
                                            throw cause3;
                                        }
                                    } catch (Throwable th4) {
                                        Throwable cause4 = th4.getCause();
                                        if (cause4 == null) {
                                            throw th4;
                                        }
                                        throw cause4;
                                    }
                                } catch (Throwable th5) {
                                    Throwable cause5 = th5.getCause();
                                    if (cause5 == null) {
                                        throw th5;
                                    }
                                    throw cause5;
                                }
                            }
                        } catch (Throwable th6) {
                            Throwable cause6 = th6.getCause();
                            if (cause6 == null) {
                                throw th6;
                            }
                            throw cause6;
                        }
                    } catch (Throwable th7) {
                        Throwable cause7 = th7.getCause();
                        if (cause7 == null) {
                            throw th7;
                        }
                        throw cause7;
                    }
                } catch (Throwable th8) {
                    Throwable cause8 = th8.getCause();
                    if (cause8 == null) {
                        throw th8;
                    }
                    throw cause8;
                }
            } catch (Throwable th9) {
                Throwable cause9 = th9.getCause();
                if (cause9 == null) {
                    throw th9;
                }
                throw cause9;
            }
        }
        Context applicationContext3 = context != null ? context.getApplicationContext() : context;
        if (applicationContext3 != null) {
            try {
                Object[] objArr19 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], getAuthRequestContext[31], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 61, (ViewConfiguration.getTapTimeout() >> 16) + 46, (char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))));
                        Object[] objArr22 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[28], (byte) ($$a[78] - 1), objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.red(0), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 35, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-2029045833, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Drawable.resolveOpacity(0, 0), 18 - KeyEvent.normalizeMetaState(0), (char) Color.alpha(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj11);
                                }
                                ((Method) obj11).invoke(invoke4, objArr24);
                            } catch (Throwable th10) {
                                Throwable cause10 = th10.getCause();
                                if (cause10 == null) {
                                    throw th10;
                                }
                                throw cause10;
                            }
                        } catch (Throwable th11) {
                            Throwable cause11 = th11.getCause();
                            if (cause11 == null) {
                                throw th11;
                            }
                            throw cause11;
                        }
                    }
                } catch (Throwable th12) {
                    Throwable cause12 = th12.getCause();
                    if (cause12 == null) {
                        throw th12;
                    }
                    throw cause12;
                }
            } catch (Throwable th13) {
                Throwable cause13 = th13.getCause();
                if (cause13 == null) {
                    throw th13;
                }
                throw cause13;
            }
        }
        Context applicationContext4 = context != null ? context.getApplicationContext() : context;
        if (applicationContext4 != null) {
            try {
                Object[] objArr25 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], getAuthRequestContext[31], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(118 - (ViewConfiguration.getScrollDefaultDelay() >> 16), 3 - TextUtils.getOffsetBefore("", 0), (char) (38967 - ((byte) KeyEvent.getModifierMetaStateMask())));
                        Object[] objArr28 = new Object[1];
                        c((byte) ($$a[78] - 1), $$a[28], (byte) ($$a[78] - 1), objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-2029045833, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.red(0) + 911, 18 - View.resolveSize(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj14);
                                }
                                ((Method) obj14).invoke(invoke5, objArr30);
                            } catch (Throwable th14) {
                                Throwable cause14 = th14.getCause();
                                if (cause14 == null) {
                                    throw th14;
                                }
                                throw cause14;
                            }
                        } catch (Throwable th15) {
                            Throwable cause15 = th15.getCause();
                            if (cause15 == null) {
                                throw th15;
                            }
                            throw cause15;
                        }
                    }
                } catch (Throwable th16) {
                    Throwable cause16 = th16.getCause();
                    if (cause16 == null) {
                        throw th16;
                    }
                    throw cause16;
                }
            } catch (Throwable th17) {
                Throwable cause17 = th17.getCause();
                if (cause17 == null) {
                    throw th17;
                }
                throw cause17;
            }
        }
        Context applicationContext5 = context != null ? context.getApplicationContext() : context;
        if (applicationContext5 != null) {
            try {
                Object[] objArr31 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], getAuthRequestContext[31], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(107 - (KeyEvent.getMaxKeyCode() >> 16), View.MeasureSpec.getMode(0) + 3, (char) KeyEvent.getDeadChar(0, 0));
                        Object[] objArr34 = new Object[1];
                        c($$a[9], (byte) (-$$a[40]), $$a[8], objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 930, 35 - (ViewConfiguration.getEdgeSlop() >> 16), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-2029045833, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(MotionEvent.axisFromString("") + 912, 18 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getMinimumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj17);
                                }
                                ((Method) obj17).invoke(invoke6, objArr36);
                            } catch (Throwable th18) {
                                Throwable cause18 = th18.getCause();
                                if (cause18 == null) {
                                    throw th18;
                                }
                                throw cause18;
                            }
                        } catch (Throwable th19) {
                            Throwable cause19 = th19.getCause();
                            if (cause19 == null) {
                                throw th19;
                            }
                            throw cause19;
                        }
                    }
                } catch (Throwable th20) {
                    Throwable cause20 = th20.getCause();
                    if (cause20 == null) {
                        throw th20;
                    }
                    throw cause20;
                }
            } catch (Throwable th21) {
                Throwable cause21 = th21.getCause();
                if (cause21 == null) {
                    throw th21;
                }
                throw cause21;
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        a(18 - (ViewConfiguration.getEdgeSlop() >> 16), new int[]{-911454851, 896034896, -1402711990, 543294345, -1350417238, -2016184673, 1691200595, 883942906, 1205958230, 802989668}, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 5, new int[]{-966321824, 666395029, 1606022272, 2112818361}, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                a((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 25, new int[]{-911454851, 896034896, -1402711990, 543294345, -2043297206, -946724035, 1639618965, -1660190930, -1164230608, 1426301585, 1103695526, 615173580, 146218225, -237051985}, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a(super.getResources().getString(R.string.msg_referrer_description).substring(10, 11).length() + 17, new int[]{746638751, -65191952, -696659512, 1200816313, 510779895, 1300361261, 1942376153, 2123229823, 1128585912, 519453852}, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + PDF417Common.NUMBER_OF_CODEWORDS, (ViewConfiguration.getTouchSlop() >> 8) + 35, (char) (ImageFormat.getBitsPerPixel(0) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    try {
                        Object[] objArr5 = new Object[1];
                        b(getAuthRequestContext[25], getAuthRequestContext[32], (byte) (getAuthRequestContext[0] + 1), objArr5);
                        Class<?> cls3 = Class.forName((String) objArr5[0]);
                        Object[] objArr6 = new Object[1];
                        b(getAuthRequestContext[27], getAuthRequestContext[13], getAuthRequestContext[25], objArr6);
                        Object[] objArr7 = new Object[1];
                        a(((ApplicationInfo) cls3.getMethod((String) objArr6[0], null).invoke(this, null)).targetSdkVersion + 15, new int[]{1056367538, 1528829433, -1345761164, 352733734, -509176858, -622018222, 1959938281, 171712298, 1375345105, -2061684474, -1688717853, 558950590, 928285546, 2146064940, 1759936448, -1552609957, -418348550, -469741945, 1202070341, -2051347363, -1801422712, 1687435495, 299922301, 1841649077}, objArr7);
                        String str = (String) objArr7[0];
                        Object[] objArr8 = new Object[1];
                        a(super.getResources().getString(R.string.title_block_registration).substring(9, 11).length() + 62, new int[]{1942408493, 442121699, 398457208, 927761179, 2094871738, 1502714043, -1113935700, -1660162830, 1509805788, -2017426302, 1365998754, -1630034955, -1981810476, -1947078965, 843744798, 1408881650, 372356350, -719972156, 696433289, -1662981033, 1454680940, -728892202, -335991229, -249066194, -1816675058, 83732990, -49106619, -596557667, 699871009, 521736209, -1426071786, -1790262698}, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(super.getResources().getString(R.string.see_detail_member).substring(12, 17).codePointAt(3) - 36, new int[]{-706515449, -211773619, -450015471, -1593225829, -992221556, -175521075, -1516152743, -449336643, 2037825858, 227773318, 1534441873, 1857867182, -314402684, 31262043, 1837265891, -327350052, -713666192, 1270657239, 906677945, -1911197571, -192050790, -1011268180, 837702564, 1486719325, -378470116, 533921114, -276580892, 1217638183, 636651878, 598716634, 549144425, 676248940}, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(getPackageName().length() + 53, new int[]{997515826, 1523956037, -1775502278, 1699114398, -1094495616, 81204802, 2088851846, -927292020, -1326426279, 2058337716, -1131304255, 763892026, 1876204231, -1558297880, 1792265330, 607476960, 197884994, -136809984, -1072319445, 1736319562, -674483372, -1975828523, 1937158671, -802265876, 1683786538, 583804511, -512084961, -823707408, -1526369845, -229680976}, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(super.getResources().getString(R.string.nearby_header).substring(1, 2).length() + 5, new int[]{166214230, 1414858007, -133373062, 1028248408}, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatTimeout() >> 16) + 911, TextUtils.lastIndexOf("", '0') + 19, (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                            }
                            ((Method) obj2).invoke(invoke, objArr12);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            Object[] objArr13 = new Object[1];
            b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[25], getAuthRequestContext[31], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            Object[] objArr14 = new Object[1];
            b((byte) (-getAuthRequestContext[30]), getAuthRequestContext[7], (byte) (getAuthRequestContext[34] + 1), objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(495 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), 5 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), (char) View.MeasureSpec.getMode(0));
                    Object[] objArr16 = new Object[1];
                    c($$a[9], (byte) (-$$a[40]), $$a[8], objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - View.MeasureSpec.makeMeasureSpec(0, 0), 35 - TextUtils.indexOf("", "", 0, 0), (char) ExpandableListView.getPackedPositionGroup(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr18 = {579880604, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 18 - ((Process.getThreadPriority(0) + 20) >> 6), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
                        } catch (Throwable th4) {
                            Throwable cause4 = th4.getCause();
                            if (cause4 == null) {
                                throw th4;
                            }
                            throw cause4;
                        }
                    } catch (Throwable th5) {
                        Throwable cause5 = th5.getCause();
                        if (cause5 == null) {
                            throw th5;
                        }
                        throw cause5;
                    }
                }
                super.onCreate(bundle);
            } catch (Throwable th6) {
                Throwable cause6 = th6.getCause();
                if (cause6 == null) {
                    throw th6;
                }
                throw cause6;
            }
        } catch (Throwable th7) {
            Throwable cause7 = th7.getCause();
            if (cause7 == null) {
                throw th7;
            }
            throw cause7;
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(TextUtils.lastIndexOf("", '0', 0, 0) + 27, new int[]{-911454851, 896034896, -1402711990, 543294345, -2043297206, -946724035, 1639618965, -1660190930, -1164230608, 1426301585, 1103695526, 615173580, 146218225, -237051985}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 19, new int[]{746638751, -65191952, -696659512, 1200816313, 510779895, 1300361261, 1942376153, 2123229823, 1128585912, 519453852}, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) (Process.myPid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0), 17 - TextUtils.indexOf((CharSequence) "", '0'), (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1))).getMethod("MyBillsEntityDataFactory", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-549958681, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr3);
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause == null) {
                        throw th;
                    }
                    throw cause;
                }
            } catch (Throwable th2) {
                Throwable cause2 = th2.getCause();
                if (cause2 == null) {
                    throw th2;
                }
                throw cause2;
            }
        }
        super.onPause();
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(25 - TextUtils.lastIndexOf("", '0', 0), new int[]{-911454851, 896034896, -1402711990, 543294345, -2043297206, -946724035, 1639618965, -1660190930, -1164230608, 1426301585, 1103695526, 615173580, 146218225, -237051985}, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            try {
                Object[] objArr2 = new Object[1];
                b(getAuthRequestContext[25], getAuthRequestContext[32], (byte) (getAuthRequestContext[0] + 1), objArr2);
                Class<?> cls2 = Class.forName((String) objArr2[0]);
                b(getAuthRequestContext[27], getAuthRequestContext[13], getAuthRequestContext[25], new Object[1]);
                Object[] objArr3 = new Object[1];
                a(((ApplicationInfo) cls2.getMethod((String) r9[0], null).invoke(this, null)).targetSdkVersion - 15, new int[]{746638751, -65191952, -696659512, 1200816313, 510779895, 1300361261, 1942376153, 2123229823, 1128585912, 519453852}, objArr3);
                baseContext = (Context) cls.getMethod((String) objArr3[0], new Class[0]).invoke(null, null);
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 35, (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr4 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 911, View.getDefaultSize(0, 0) + 18, (char) Color.alpha(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
                    }
                    ((Method) obj2).invoke(invoke, objArr4);
                } catch (Throwable th2) {
                    Throwable cause2 = th2.getCause();
                    if (cause2 == null) {
                        throw th2;
                    }
                    throw cause2;
                }
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        }
        super.onResume();
    }

    public ImageCaptureActivity() {
        final ImageCaptureActivity imageCaptureActivity = this;
        final Function0 function0 = null;
        this.vm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ImageCaptureViewModel.class), new Function0<ViewModelStore>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ComponentActivity.this.getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ImageCaptureActivity.this.getViewModelFactory();
            }
        }, new Function0<CreationExtras>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) {
                    CreationExtras defaultViewModelCreationExtras = imageCaptureActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "");
                    return defaultViewModelCreationExtras;
                }
                return creationExtras;
            }
        });
        ActivityResultLauncher<String> registerForActivityResult = registerForActivityResult(new GalleryResultContract(), new ActivityResultCallback() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$$ExternalSyntheticLambda6
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                ImageCaptureActivity.m663galleryLauncher$lambda1(ImageCaptureActivity.this, (Uri) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.galleryLauncher = registerForActivityResult;
        this.eventName = "";
        this.permissionQueue = new LinkedList<>();
    }

    @JvmName(name = "getViewModelFactory")
    public final ViewModelFactory getViewModelFactory() {
        ViewModelFactory viewModelFactory = this.viewModelFactory;
        if (viewModelFactory != null) {
            return viewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setViewModelFactory")
    public final void setViewModelFactory(ViewModelFactory viewModelFactory) {
        Intrinsics.checkNotNullParameter(viewModelFactory, "");
        this.viewModelFactory = viewModelFactory;
    }

    @JvmName(name = "getVm")
    public final ImageCaptureViewModel getVm() {
        return (ImageCaptureViewModel) this.vm.getValue();
    }

    /* renamed from: galleryLauncher$lambda-1 */
    public static final void m663galleryLauncher$lambda1(final ImageCaptureActivity imageCaptureActivity, Uri uri) {
        Executor executor;
        Intrinsics.checkNotNullParameter(imageCaptureActivity, "");
        if (uri != null) {
            String type = imageCaptureActivity.getContentResolver().getType(uri);
            if (type == null) {
                type = "";
            }
            if (StringsKt.contains$default((CharSequence) type, (CharSequence) "image", false, 2, (Object) null)) {
                GlideRequest<Bitmap> BuiltInFictitiousFunctionClassFactory = GlideApp.PlaceComponentResult(imageCaptureActivity).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(uri);
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                CustomTarget<Bitmap> customTarget = new CustomTarget<Bitmap>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$galleryLauncher$lambda-1$$inlined$proceedBitmap$1
                    @Override // com.bumptech.glide.request.target.Target
                    public final void onLoadCleared(Drawable placeholder) {
                    }

                    @Override // com.bumptech.glide.request.target.Target
                    public final /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                        onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                    }

                    public final void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        Intrinsics.checkNotNullParameter(resource, "");
                        ImageCaptureActivity.this.showChosenImage(resource);
                    }
                };
                executor = Executors.PlaceComponentResult;
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(customTarget, null, BuiltInFictitiousFunctionClassFactory, executor);
            }
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final ActivityImageCaptureBinding inflateViewBinding() {
        ActivityImageCaptureBinding MyBillsEntityDataFactory = ActivityImageCaptureBinding.MyBillsEntityDataFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void initComponent() {
        Context applicationContext = getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.di.modules.features.imagecapture.ImageCaptureComponentProvider");
        }
        ImageCaptureComponent PlaceComponentResult2 = ((ImageCaptureComponentProvider) applicationContext).provideImageCaptureComponent().PlaceComponentResult();
        this.imageCaptureComponent = PlaceComponentResult2;
        PlaceComponentResult2.MyBillsEntityDataFactory(this);
    }

    @Override // id.dana.core.ui.BaseViewBindingActivity
    public final void init() {
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("image_capture_event", "") : null;
        this.eventName = string;
        initBasedOnEvent(model(string != null ? string : ""));
    }

    private final ImageCaptureModel model(String str) {
        if (Intrinsics.areEqual(str, "cameraWithFrame")) {
            return new ImageCaptureModel(getString(R.string.image_capture_toolbar_title), null, null, null, null, null, null, null, 254, null);
        }
        return (ImageCaptureModel) getIntent().getParcelableExtra(IMAGE_CAPTURE_MODEL_EXTRA);
    }

    private final void initBasedOnEvent(ImageCaptureModel r4) {
        if (r4 != null) {
            this.imageCaptureModel = r4;
            String title = r4.getTitle();
            if (title == null) {
                title = "";
            }
            initToolbar(title, getDocIdWithDefaultValue(r4.getDocId()));
            initViews();
            String spaceCode = r4.getSpaceCode();
            if (spaceCode == null) {
                spaceCode = "";
            }
            String docId = r4.getDocId();
            initTipUploadPhoto(spaceCode, docId != null ? docId : "");
            initListeners();
            initPermissionRequest();
            initLifecycle();
            nextPermissionRequest();
        }
    }

    private final String getDocIdWithDefaultValue(String docId) {
        if (docId == null) {
            docId = "";
        }
        String str = docId;
        if (str.length() == 0) {
            str = "empty";
        }
        return str;
    }

    private final void initPermissionRequest() {
        initCameraPermissionRequest();
        ifAndroid10Below$default(this, new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initPermissionRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinkedList linkedList;
                ActivityPermissionRequest galleryPermissionRequest;
                ActivityPermissionRequest galleryPermissionRequest$default = ImageCaptureActivity.getGalleryPermissionRequest$default(ImageCaptureActivity.this, false, 1, null);
                linkedList = ImageCaptureActivity.this.permissionQueue;
                linkedList.add(galleryPermissionRequest$default);
                ImageCaptureActivity imageCaptureActivity = ImageCaptureActivity.this;
                galleryPermissionRequest = imageCaptureActivity.getGalleryPermissionRequest(true);
                imageCaptureActivity.galleryPermissionRequestWithOpenGalleryAction = galleryPermissionRequest;
            }
        }, null, 2, null);
    }

    public final void nextPermissionRequest() {
        ActivityPermissionRequest pollFirst = this.permissionQueue.pollFirst();
        if (pollFirst != null) {
            pollFirst.check();
        }
    }

    private final void initCameraPermissionRequest() {
        this.permissionQueue.add(getActivityPermissionRequest$default(this, (String[]) Arrays.copyOf(new String[]{"android.permission.CAMERA"}, 1), new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initCameraPermissionRequest$cameraPermissionRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageCaptureActivity.this.initCameraView();
            }
        }, null, new Function1<PermissionRequest, Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initCameraPermissionRequest$cameraPermissionRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PermissionRequest permissionRequest) {
                invoke2(permissionRequest);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final PermissionRequest permissionRequest) {
                PermissionPromptBottomSheetDialog permissionPromptBottomSheetDialog;
                Intrinsics.checkNotNullParameter(permissionRequest, "");
                ImageCaptureActivity imageCaptureActivity = ImageCaptureActivity.this;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initCameraPermissionRequest$cameraPermissionRequest$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PermissionRequest.this.continueToPermissionRequest();
                    }
                };
                final ImageCaptureActivity imageCaptureActivity2 = ImageCaptureActivity.this;
                imageCaptureActivity.cameraPromptPermissionBottomSheetDialog = new PermissionPromptBottomSheetDialog(PermissionPromptSource.IMAGE_CAPTURE_CAMERA, function0, new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initCameraPermissionRequest$cameraPermissionRequest$2.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ImageCaptureActivity.this.nextPermissionRequest();
                    }
                });
                permissionPromptBottomSheetDialog = ImageCaptureActivity.this.cameraPromptPermissionBottomSheetDialog;
                if (permissionPromptBottomSheetDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    permissionPromptBottomSheetDialog = null;
                }
                FragmentManager supportFragmentManager = ImageCaptureActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                permissionPromptBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(supportFragmentManager);
            }
        }, 4, null));
    }

    public static /* synthetic */ ActivityPermissionRequest getGalleryPermissionRequest$default(ImageCaptureActivity imageCaptureActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return imageCaptureActivity.getGalleryPermissionRequest(z);
    }

    public final ActivityPermissionRequest getGalleryPermissionRequest(final boolean isOpenGalleryAction) {
        return getActivityPermissionRequest$default(this, (String[]) Arrays.copyOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2), null, new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$getGalleryPermissionRequest$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (isOpenGalleryAction) {
                    this.openGallery();
                }
            }
        }, new Function1<PermissionRequest, Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$getGalleryPermissionRequest$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(PermissionRequest permissionRequest) {
                invoke2(permissionRequest);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(final PermissionRequest permissionRequest) {
                PermissionPromptBottomSheetDialog permissionPromptBottomSheetDialog;
                Intrinsics.checkNotNullParameter(permissionRequest, "");
                ImageCaptureActivity.this.galleryPromptPermissionBottomSheetDialog = new PermissionPromptBottomSheetDialog(PermissionPromptSource.IMAGE_CAPTURE_GALLERY, new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$getGalleryPermissionRequest$2.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PermissionRequest.this.continueToPermissionRequest();
                    }
                }, null, 4, null);
                permissionPromptBottomSheetDialog = ImageCaptureActivity.this.galleryPromptPermissionBottomSheetDialog;
                if (permissionPromptBottomSheetDialog == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    permissionPromptBottomSheetDialog = null;
                }
                FragmentManager supportFragmentManager = ImageCaptureActivity.this.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
                permissionPromptBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(supportFragmentManager);
            }
        }, 2, null);
    }

    private final void initTipUploadPhoto(String spaceCode, String docId) {
        if (spaceCode.length() > 0) {
            getVm().getTipUploadPhoto(docId, spaceCode);
        }
    }

    private final void initToolbar(String title, String docId) {
        ActivityImageCaptureBinding binding = getBinding();
        binding.DatabaseTableConfigUtil.initRecordTimeStamp.setText(title);
        binding.DatabaseTableConfigUtil.initRecordTimeStamp.setContentDescription(getString(R.string.image_capture_title_upload, docId));
        AppCompatImageView appCompatImageView = binding.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(0);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(binding.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2, R.drawable.arrow_left_white);
        binding.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageCaptureActivity.m668initToolbar$lambda5$lambda4(ImageCaptureActivity.this, view);
            }
        });
        binding.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(getString(R.string.image_capture_btn_back));
    }

    /* renamed from: initToolbar$lambda-5$lambda-4 */
    public static final void m668initToolbar$lambda5$lambda4(ImageCaptureActivity imageCaptureActivity, View view) {
        Intrinsics.checkNotNullParameter(imageCaptureActivity, "");
        imageCaptureActivity.onBackPressed();
    }

    private final void initViews() {
        final ActivityImageCaptureBinding binding = getBinding();
        binding.NetworkUserEntityData$$ExternalSyntheticLambda2.setText(getString(R.string.image_capture_see_photo_tip_remark));
        String str = this.eventName;
        if (str == null || !Intrinsics.areEqual(str, "cameraWithFrame")) {
            return;
        }
        binding.lookAheadTest.setVisibility(4);
        binding.moveToNextValue.setVisibility(4);
        ConstraintLayout constraintLayout = binding.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        constraintLayout.setVisibility(0);
        AppCompatTextView appCompatTextView = binding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(0);
        binding.initRecordTimeStamp.postDelayed(new Runnable() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ImageCaptureActivity.m669initViews$lambda8$lambda7$lambda6(ActivityImageCaptureBinding.this);
            }
        }, GUIDELINE_SHOW_DURATION);
    }

    /* renamed from: initViews$lambda-8$lambda-7$lambda-6 */
    public static final void m669initViews$lambda8$lambda7$lambda6(ActivityImageCaptureBinding activityImageCaptureBinding) {
        Intrinsics.checkNotNullParameter(activityImageCaptureBinding, "");
        AppCompatTextView appCompatTextView = activityImageCaptureBinding.initRecordTimeStamp;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(8);
    }

    private final void initListeners() {
        final ActivityImageCaptureBinding binding = getBinding();
        binding.lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageCaptureActivity.m667initListeners$lambda13$lambda9(ImageCaptureActivity.this, view);
            }
        });
        binding.moveToNextValue.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageCaptureActivity.m664initListeners$lambda13$lambda10(ImageCaptureActivity.this, view);
            }
        });
        binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageCaptureActivity.m665initListeners$lambda13$lambda11(ActivityImageCaptureBinding.this, view);
            }
        });
        binding.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImageCaptureActivity.m666initListeners$lambda13$lambda12(ActivityImageCaptureBinding.this, this, view);
            }
        });
    }

    /* renamed from: initListeners$lambda-13$lambda-9 */
    public static final void m667initListeners$lambda13$lambda9(ImageCaptureActivity imageCaptureActivity, View view) {
        Intrinsics.checkNotNullParameter(imageCaptureActivity, "");
        imageCaptureActivity.onGalleryIconClicked();
    }

    /* renamed from: initListeners$lambda-13$lambda-10 */
    public static final void m664initListeners$lambda13$lambda10(ImageCaptureActivity imageCaptureActivity, View view) {
        Intrinsics.checkNotNullParameter(imageCaptureActivity, "");
        imageCaptureActivity.toggleLight();
    }

    /* renamed from: initListeners$lambda-13$lambda-11 */
    public static final void m665initListeners$lambda13$lambda11(ActivityImageCaptureBinding activityImageCaptureBinding, View view) {
        Intrinsics.checkNotNullParameter(activityImageCaptureBinding, "");
        if (activityImageCaptureBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.isTakingPicture()) {
            return;
        }
        activityImageCaptureBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.takePicture();
    }

    /* renamed from: initListeners$lambda-13$lambda-12 */
    public static final void m666initListeners$lambda13$lambda12(ActivityImageCaptureBinding activityImageCaptureBinding, ImageCaptureActivity imageCaptureActivity, View view) {
        Intrinsics.checkNotNullParameter(activityImageCaptureBinding, "");
        Intrinsics.checkNotNullParameter(imageCaptureActivity, "");
        activityImageCaptureBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.open();
        imageCaptureActivity.showPicturePreviewView(false);
        activityImageCaptureBinding.scheduleImpl.setImageBitmap(null);
    }

    private final void proceedBitmap(Object source, final Function1<? super Bitmap, Unit> onBitmapReady) {
        Executor executor;
        GlideRequest<Bitmap> BuiltInFictitiousFunctionClassFactory = GlideApp.PlaceComponentResult(this).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(source);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        if (source instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) source;
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(getWidth(bitmap), getHeight(bitmap));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        CustomTarget<Bitmap> customTarget = new CustomTarget<Bitmap>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$proceedBitmap$1
            @Override // com.bumptech.glide.request.target.Target
            public final void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public final /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public final void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "");
                onBitmapReady.invoke(resource);
            }
        };
        executor = Executors.PlaceComponentResult;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(customTarget, null, BuiltInFictitiousFunctionClassFactory, executor);
    }

    private final int getWidth(Bitmap bitmap) {
        ImageCaptureModel imageCaptureModel = this.imageCaptureModel;
        if (imageCaptureModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            imageCaptureModel = null;
        }
        Integer width = imageCaptureModel.getWidth();
        int intValue = width != null ? width.intValue() : 0;
        return intValue <= 0 ? bitmap.getWidth() : intValue;
    }

    private final int getHeight(Bitmap bitmap) {
        ImageCaptureModel imageCaptureModel = this.imageCaptureModel;
        if (imageCaptureModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            imageCaptureModel = null;
        }
        Integer height = imageCaptureModel.getHeight();
        int intValue = height != null ? height.intValue() : 0;
        return intValue <= 0 ? bitmap.getHeight() : intValue;
    }

    private final void onGalleryIconClicked() {
        ifAndroid10Below(new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$onGalleryIconClicked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LinkedList linkedList;
                ActivityPermissionRequest activityPermissionRequest;
                linkedList = ImageCaptureActivity.this.permissionQueue;
                activityPermissionRequest = ImageCaptureActivity.this.galleryPermissionRequestWithOpenGalleryAction;
                if (activityPermissionRequest == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    activityPermissionRequest = null;
                }
                linkedList.add(activityPermissionRequest);
                ImageCaptureActivity.this.nextPermissionRequest();
            }
        }, new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$onGalleryIconClicked$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ImageCaptureActivity.this.openGallery();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void ifAndroid10Below$default(ImageCaptureActivity imageCaptureActivity, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function02 = new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$ifAndroid10Below$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        imageCaptureActivity.ifAndroid10Below(function0, function02);
    }

    private final void ifAndroid10Below(Function0<Unit> doAction, Function0<Unit> otherwise) {
        OSUtil oSUtil = OSUtil.INSTANCE;
        if (!OSUtil.KClassImpl$Data$declaredNonStaticMembers$2()) {
            doAction.invoke();
        } else {
            otherwise.invoke();
        }
    }

    private final void toggleLight() {
        Flash flash;
        CameraView cameraView = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (getBinding().NetworkUserEntityData$$ExternalSyntheticLambda1.getFlash() == Flash.OFF) {
            flash = Flash.TORCH;
        } else {
            flash = Flash.OFF;
        }
        cameraView.setFlash(flash);
    }

    public final void openGallery() {
        this.galleryLauncher.MyBillsEntityDataFactory(ALLOWED_IMAGE_FORMAT, null);
    }

    public final void redirectToSystemSettings() {
        PermissionHelper.BuiltInFictitiousFunctionClassFactory(this);
    }

    public final void initCameraView() {
        ActivityImageCaptureBinding binding = getBinding();
        binding.NetworkUserEntityData$$ExternalSyntheticLambda1.setLifecycleOwner(this);
        binding.NetworkUserEntityData$$ExternalSyntheticLambda1.mapGesture(Gesture.TAP, GestureAction.AUTO_FOCUS);
        binding.NetworkUserEntityData$$ExternalSyntheticLambda1.addCameraListener(new ImageCaptureActivity$initCameraView$1$1(this));
    }

    public final void showChosenImage(final Bitmap bitmap) {
        ActivityImageCaptureBinding binding = getBinding();
        showPicturePreviewView(true);
        setScaleTypeBaseOnOrientation(bitmap);
        AppCompatImageView appCompatImageView = binding.scheduleImpl;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        ViewExtKt.PlaceComponentResult(appCompatImageView, bitmap);
        binding.NetworkUserEntityData$$ExternalSyntheticLambda1.close();
        DanaButtonPrimaryView danaButtonPrimaryView = binding.PlaceComponentResult;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        SafeClickListenerExtensionKt.MyBillsEntityDataFactory(danaButtonPrimaryView, new Function1<View, Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$showChosenImage$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                ImageCaptureActivity.this.onUploadImage(bitmap);
            }
        });
    }

    private final void setScaleTypeBaseOnOrientation(Bitmap bitmap) {
        ActivityImageCaptureBinding binding = getBinding();
        if (bitmap.getWidth() > bitmap.getHeight()) {
            binding.scheduleImpl.setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            binding.scheduleImpl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private final void showPicturePreviewView(boolean isPicturePreviewShown) {
        ActivityImageCaptureBinding binding = getBinding();
        Group group = binding.getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(group, "");
        group.setVisibility(isPicturePreviewShown ? 0 : 8);
        CameraView cameraView = binding.NetworkUserEntityData$$ExternalSyntheticLambda1;
        Intrinsics.checkNotNullExpressionValue(cameraView, "");
        boolean z = !isPicturePreviewShown;
        cameraView.setVisibility(z ? 0 : 8);
        AppCompatImageView appCompatImageView = binding.NetworkUserEntityData$$ExternalSyntheticLambda0;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        appCompatImageView.setVisibility(z ? 0 : 8);
        String str = this.eventName;
        if (str != null) {
            if (Intrinsics.areEqual(str, "cameraWithFrame")) {
                binding.lookAheadTest.setVisibility(4);
                binding.moveToNextValue.setVisibility(4);
            } else {
                AppCompatImageView appCompatImageView2 = binding.lookAheadTest;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                appCompatImageView2.setVisibility(z ? 0 : 8);
                AppCompatImageView appCompatImageView3 = binding.moveToNextValue;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "");
                appCompatImageView3.setVisibility(z ? 0 : 8);
            }
        }
        boolean z2 = this.photoTipsModel != null;
        AppCompatTextView appCompatTextView = binding.GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        appCompatTextView.setVisibility(!isPicturePreviewShown && z2 ? 0 : 8);
        AppCompatTextView appCompatTextView2 = binding.NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "");
        appCompatTextView2.setVisibility(isPicturePreviewShown && z2 ? 0 : 8);
    }

    private final void initLifecycle() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.PlaceComponentResult(this), null, null, new ImageCaptureActivity$initLifecycle$1(this, null), 3, null);
    }

    public final void initButtonCheckTip() {
        boolean z = this.photoTipsModel != null;
        AppCompatTextView appCompatTextView = getBinding().GetContactSyncConfig;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
        AppCompatTextView appCompatTextView2 = appCompatTextView;
        appCompatTextView2.setVisibility(z ? 0 : 8);
        SafeClickListenerExtensionKt.MyBillsEntityDataFactory(appCompatTextView2, new Function1<View, Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initButtonCheckTip$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                ImageCaptureActivity.this.openBottomSheetPhotoTips();
            }
        });
        AppCompatTextView appCompatTextView3 = getBinding().NetworkUserEntityData$$ExternalSyntheticLambda2;
        Intrinsics.checkNotNullExpressionValue(appCompatTextView3, "");
        AppCompatTextView appCompatTextView4 = appCompatTextView3;
        appCompatTextView4.setVisibility(z ? 0 : 8);
        String string = getString(R.string.image_capture_see_photo_tip_spannable);
        Intrinsics.checkNotNullExpressionValue(string, "");
        InputExtKt.PlaceComponentResult(appCompatTextView3, string, false, null, 8);
        SafeClickListenerExtensionKt.MyBillsEntityDataFactory(appCompatTextView4, new Function1<View, Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$initButtonCheckTip$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics.checkNotNullParameter(view, "");
                ImageCaptureActivity.this.openBottomSheetPhotoTips();
            }
        });
    }

    public final void openBottomSheetPhotoTips() {
        PhotoTipsModel photoTipsModel = this.photoTipsModel;
        if (photoTipsModel != null) {
            PhotoTipsBottomSheetFragment.Companion companion = PhotoTipsBottomSheetFragment.INSTANCE;
            ImageCaptureModel imageCaptureModel = this.imageCaptureModel;
            if (imageCaptureModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageCaptureModel = null;
            }
            PhotoTipsBottomSheetFragment authRequestContext = PhotoTipsBottomSheetFragment.Companion.getAuthRequestContext(photoTipsModel, getDocIdWithDefaultValue(imageCaptureModel.getDocId()));
            authRequestContext.setCancelable(true);
            authRequestContext.show(getSupportFragmentManager(), Reflection.getOrCreateKotlinClass(ImageCaptureActivity.class).getSimpleName());
            execute(new Function1<EventTrackerModel.Builder, Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$openBottomSheetPhotoTips$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(EventTrackerModel.Builder builder) {
                    invoke2(builder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(EventTrackerModel.Builder builder) {
                    ImageCaptureModel imageCaptureModel2;
                    ImageCaptureModel imageCaptureModel3;
                    ImageCaptureModel imageCaptureModel4;
                    Intrinsics.checkNotNullParameter(builder, "");
                    builder.MyBillsEntityDataFactory = TrackerKey.Event.DANA_SIAGA_CLAIM_DOCUMENT_SAMPLE_OPEN;
                    imageCaptureModel2 = ImageCaptureActivity.this.imageCaptureModel;
                    ImageCaptureModel imageCaptureModel5 = null;
                    if (imageCaptureModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        imageCaptureModel2 = null;
                    }
                    builder.MyBillsEntityDataFactory(TrackerKey.ImageCaptureProperties.DANA_SIAGA_INSURANCE_GOODS, imageCaptureModel2.getGoodsId());
                    imageCaptureModel3 = ImageCaptureActivity.this.imageCaptureModel;
                    if (imageCaptureModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        imageCaptureModel3 = null;
                    }
                    builder.MyBillsEntityDataFactory(TrackerKey.ImageCaptureProperties.DANA_SIAGA_INSURANCE_BENEFIT, imageCaptureModel3.getBenefitId());
                    imageCaptureModel4 = ImageCaptureActivity.this.imageCaptureModel;
                    if (imageCaptureModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        imageCaptureModel5 = imageCaptureModel4;
                    }
                    builder.MyBillsEntityDataFactory(TrackerKey.ImageCaptureProperties.DANA_SIAGA_DOCUMENT_TYPE, imageCaptureModel5.getDocId());
                    builder.MyBillsEntityDataFactory("Source", "Camera Page");
                }
            });
        }
    }

    private final void execute(Function1<? super EventTrackerModel.Builder, Unit> composeEvent) {
        String str;
        EventPropertiesModel eventPropertiesModel;
        EventTrackerModel.Builder PlaceComponentResult2 = EventTrackerModel.Builder.PlaceComponentResult(this);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult2, "");
        composeEvent.invoke(PlaceComponentResult2);
        PlaceComponentResult2.PlaceComponentResult();
        EventTrackerModel eventTrackerModel = new EventTrackerModel(PlaceComponentResult2, (byte) 0);
        EventTracker.PlaceComponentResult(eventTrackerModel);
        StringBuilder sb = new StringBuilder();
        sb.append("key=");
        str = eventTrackerModel.getAuthRequestContext.MyBillsEntityDataFactory;
        sb.append(str);
        sb.append(" \n properties=");
        eventPropertiesModel = eventTrackerModel.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2;
        sb.append(eventPropertiesModel.MyBillsEntityDataFactory);
        DanaLog.MyBillsEntityDataFactory(DanaLogConstants.TAG.MIXPANEL_IMAGE_CAPTURE, sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ActivityPermissionRequest getActivityPermissionRequest$default(ImageCaptureActivity imageCaptureActivity, String[] strArr, Function0 function0, Function0 function02, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$getActivityPermissionRequest$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$getActivityPermissionRequest$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i & 8) != 0) {
            function1 = new Function1<PermissionRequest, Unit>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$getActivityPermissionRequest$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(PermissionRequest permissionRequest) {
                    Intrinsics.checkNotNullParameter(permissionRequest, "");
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(PermissionRequest permissionRequest) {
                    invoke2(permissionRequest);
                    return Unit.INSTANCE;
                }
            };
        }
        return imageCaptureActivity.getActivityPermissionRequest(strArr, function0, function02, function1);
    }

    private final ActivityPermissionRequest getActivityPermissionRequest(String[] r4, final Function0<Unit> onCameraPermissionGranted, final Function0<Unit> onGalleryPermissionGranted, final Function1<? super PermissionRequest, Unit> onDisplayConsentDialog) {
        ActivityPermissionRequest.Builder builder = new ActivityPermissionRequest.Builder((ComponentActivity) this);
        String[] strArr = (String[]) Arrays.copyOf(r4, r4.length);
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.PlaceComponentResult = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$getActivityPermissionRequest$4
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onShouldRedirectToSystemSettings(List<PermissionReport> blockedPermissions) {
                Intrinsics.checkNotNullParameter(blockedPermissions, "");
                this.redirectToSystemSettings();
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onDisplayConsentDialog(PermissionRequest request) {
                Intrinsics.checkNotNullParameter(request, "");
                onDisplayConsentDialog.invoke(request);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                Object obj;
                Object obj2;
                Intrinsics.checkNotNullParameter(result, "");
                Iterator<T> it = result.BuiltInFictitiousFunctionClassFactory.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (Intrinsics.areEqual(((PermissionReport) obj2).KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.CAMERA")) {
                        break;
                    }
                }
                PermissionReport permissionReport = (PermissionReport) obj2;
                Iterator<T> it2 = result.BuiltInFictitiousFunctionClassFactory.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    PermissionReport permissionReport2 = (PermissionReport) next;
                    if (Intrinsics.areEqual(permissionReport2.KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.READ_EXTERNAL_STORAGE") || Intrinsics.areEqual(permissionReport2.KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                        obj = next;
                        break;
                    }
                }
                PermissionReport permissionReport3 = (PermissionReport) obj;
                if (permissionReport != null && permissionReport.getBuiltInFictitiousFunctionClassFactory()) {
                    onCameraPermissionGranted.invoke();
                }
                if (permissionReport3 != null && permissionReport3.getBuiltInFictitiousFunctionClassFactory()) {
                    onGalleryPermissionGranted.invoke();
                }
                this.nextPermissionRequest();
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.getAuthRequestContext = permissionCallback;
        return builder.PlaceComponentResult();
    }

    public final void onUploadImage(Bitmap capturedImageBitmap) {
        Executor executor;
        GlideRequest<Bitmap> BuiltInFictitiousFunctionClassFactory = GlideApp.PlaceComponentResult(this).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(capturedImageBitmap);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        if (capturedImageBitmap instanceof Bitmap) {
            BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(getWidth(capturedImageBitmap), getHeight(capturedImageBitmap));
        }
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        CustomTarget<Bitmap> customTarget = new CustomTarget<Bitmap>() { // from class: id.dana.danah5.imagecapture.ImageCaptureActivity$onUploadImage$$inlined$proceedBitmap$1
            @Override // com.bumptech.glide.request.target.Target
            public final void onLoadCleared(Drawable placeholder) {
            }

            @Override // com.bumptech.glide.request.target.Target
            public final /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
            }

            public final void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                Intrinsics.checkNotNullParameter(resource, "");
                File MyBillsEntityDataFactory = FileUtil.MyBillsEntityDataFactory(ImageCaptureActivity.this, "JPEG_", ".jpg");
                BitmapUtil.MyBillsEntityDataFactory(resource, MyBillsEntityDataFactory);
                Uri BuiltInFictitiousFunctionClassFactory2 = FileUtil.BuiltInFictitiousFunctionClassFactory(ImageCaptureActivity.this, MyBillsEntityDataFactory);
                Intent intent = new Intent();
                intent.putExtra(ImageCaptureActivity.IMAGE_CAPTURE_URI_EXTRA, BuiltInFictitiousFunctionClassFactory2);
                ImageCaptureActivity.this.setResult(-1, intent);
                ImageCaptureActivity.this.finish();
            }
        };
        executor = Executors.PlaceComponentResult;
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(customTarget, null, BuiltInFictitiousFunctionClassFactory, executor);
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i3 = 0; i3 < length3; i3++) {
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i4 = 0; i4 < 16; i4++) {
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i4];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                int i5 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i5;
            }
            int i6 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i6;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i7 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i8 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
