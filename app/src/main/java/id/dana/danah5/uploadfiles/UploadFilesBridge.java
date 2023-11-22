package id.dana.danah5.uploadfiles;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.provider.MediaStore;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.permission.PermissionConstant;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.anggrayudi.storage.extension.UriUtils;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionReport;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.danah5.uploadfiles.UploadFilesKey;
import id.dana.danah5.uploadfiles.validator.ResolutionCenterUploadFileValidator;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerGContainerComponent;
import id.dana.di.modules.GContainerModule;
import id.dana.domain.core.usecase.NoParams;
import id.dana.domain.uploadfiles.AddSelectedFiles;
import id.dana.domain.uploadfiles.ClearFiles;
import id.dana.domain.uploadfiles.GetSelectedFiles;
import id.dana.domain.uploadfiles.GetTotalFilesSize;
import id.dana.domain.uploadfiles.RemoveSelectedFile;
import id.dana.domain.uploadfiles.SetTotalFilesSize;
import id.dana.domain.uploadfiles.UploadFile;
import id.dana.domain.uploadfiles.UploadFilesEntity;
import id.dana.lib.gcontainer.app.bridge.core.BaseBridge;
import id.dana.lib.gcontainer.extension.BridgeExtensionExtKt;
import id.dana.util.media.FileUtil;
import id.dana.utils.BitmapUtil;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  \u00012\u00020\u0001:\u0002 \u0001B\b¢\u0006\u0005\b\u009f\u0001\u0010GJ1\u0010\t\u001a\u00020\b2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010!\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010$J\u0017\u0010'\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0002¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010$J\u000f\u0010*\u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b,\u0010-J'\u0010/\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b/\u00100J5\u00103\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00182\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001a\u001a\u00020\u0014H\u0002¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020\f2\u0006\u00101\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b5\u00106J\u0019\u00108\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b8\u00109J1\u0010<\u001a\u00020\b2\u0006\u0010;\u001a\u00020:2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\b<\u0010=J'\u0010>\u001a\u00020\b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u00107\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b>\u0010?J\u001f\u0010@\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b@\u0010AJ)\u0010D\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000e2\b\u00107\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\bH\u0016¢\u0006\u0004\bH\u0010GJ\u000f\u0010I\u001a\u00020\bH\u0016¢\u0006\u0004\bI\u0010GJ\u0019\u0010K\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\b2\u0006\u0010N\u001a\u00020MH\u0002¢\u0006\u0004\bO\u0010PJ'\u0010Q\u001a\u00020\b2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u00107\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\bQ\u0010?J\u000f\u0010R\u001a\u00020\bH\u0002¢\u0006\u0004\bR\u0010GJ\u000f\u0010S\u001a\u00020\bH\u0002¢\u0006\u0004\bS\u0010GJ\u0019\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010T\u001a\u00020\u0018H\u0002¢\u0006\u0004\bV\u0010WJ\u0017\u0010Y\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u000eH\u0002¢\u0006\u0004\bY\u0010ZJ\u001d\u0010\\\u001a\u00020\b2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002¢\u0006\u0004\b\\\u0010]J9\u0010c\u001a\u00020\b2\b\b\u0001\u0010^\u001a\u00020\f2\n\b\u0001\u0010J\u001a\u0004\u0018\u00010\u00102\b\b\u0001\u0010`\u001a\u00020_2\b\b\u0001\u0010b\u001a\u00020aH\u0007¢\u0006\u0004\bc\u0010dR\u0016\u0010N\u001a\u00020M8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bN\u0010eR\"\u0010g\u001a\u00020f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b`\u0010mR\"\u0010o\u001a\u00020n8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\"\u00108\u001a\u00020u8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b8\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010|\u001a\u00020{8\u0007@\u0007X\u0087.¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0082\u0001\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u0010\u0088\u0001\u001a\u00020\f8CX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R*\u0010\u008a\u0001\u001a\u00030\u0089\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R*\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0007@\u0007X\u0087.¢\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R\u0019\u0010\u0097\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R(\u0010\\\u001a\u00030\u0099\u00018\u0007@\u0007X\u0087.¢\u0006\u0017\n\u0005\b\\\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001"}, d2 = {"Lid/dana/danah5/uploadfiles/UploadFilesBridge;", "Lid/dana/lib/gcontainer/app/bridge/core/BaseBridge;", "", "Landroid/content/Intent;", "intents", "addedIntent", "", "isOnlyNeedOneIntent", "", "appendIntentList", "(Ljava/util/List;Landroid/content/Intent;Z)V", "success", "", "message", "", "error", "Lcom/alibaba/fastjson/JSONObject;", "assembleChooseFileResponse", "(ZLjava/lang/String;I)Lcom/alibaba/fastjson/JSONObject;", "", "Lid/dana/domain/uploadfiles/UploadFilesEntity;", "selectedFiles", "assembleUploadFilesResponse", "(ZLjava/util/List;)Lcom/alibaba/fastjson/JSONObject;", "Landroid/net/Uri;", "uri", "selectedFile", "assignFileSize", "(Landroid/net/Uri;Lid/dana/domain/uploadfiles/UploadFilesEntity;)Lid/dana/domain/uploadfiles/UploadFilesEntity;", "convertImageToJpeg", "(Landroid/net/Uri;)Ljava/lang/String;", "Ljava/io/File;", "folder", "copyFile", "(Landroid/net/Uri;Ljava/io/File;Lid/dana/domain/uploadfiles/UploadFilesEntity;)Z", "createCameraIntent", "()Landroid/content/Intent;", "createChooseFileIntent", "format", "createFileName", "(Ljava/lang/String;)Ljava/lang/String;", "createGalleryIntent", "createImageFile", "()Ljava/io/File;", "createTempFile", "(Landroid/net/Uri;Lid/dana/domain/uploadfiles/UploadFilesEntity;)Z", "errorCode", "createTemporaryFile", "(Landroid/net/Uri;ILid/dana/domain/uploadfiles/UploadFilesEntity;)V", "mimeType", "files", "getErrorCode", "(Ljava/lang/String;Landroid/net/Uri;Ljava/util/List;Lid/dana/domain/uploadfiles/UploadFilesEntity;)I", "getMessage", "(Ljava/lang/String;Landroid/net/Uri;)Ljava/lang/String;", "data", "getSelectedFiles", "(Landroid/content/Intent;)V", "Landroid/content/pm/ResolveInfo;", "resolveInfo", "getTargetedIntent", "(Landroid/content/pm/ResolveInfo;Landroid/content/Intent;Ljava/util/List;)V", "getTotalSavedFileSize", "(Ljava/util/List;Landroid/content/Intent;)V", "modifyHeicImage", "(Lid/dana/domain/uploadfiles/UploadFilesEntity;Landroid/net/Uri;)Z", RequestPermission.REQUEST_CODE, "resultCode", "onActivityResult", "(IILandroid/content/Intent;)V", "onClearAllFiles", "()V", "onFinalized", "onInitialized", "info", "onRemoveFile", "(Ljava/lang/Integer;)V", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "onSelectFile", "(Landroid/app/Activity;)V", "onSuccessChooseFile", "onUploadFiles", "openFileChooser", "imageUri", "", "rotateImage", "(Landroid/net/Uri;)Ljava/lang/Float;", "selectedFileSize", "saveSelectedFileSizeToLocal", "(I)V", "list", PermissionConstant.UPLOAD_FILE, "(Ljava/util/List;)V", IpcMessageConstants.EXTRA_EVENT, "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "bridgeCallback", "Lcom/alibaba/ariver/app/api/Page;", "page", "uploadFiles", "(Ljava/lang/String;Lcom/alibaba/fastjson/JSONObject;Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;Lcom/alibaba/ariver/app/api/Page;)V", "Landroid/app/Activity;", "Lid/dana/domain/uploadfiles/AddSelectedFiles;", "addSelectedFiles", "Lid/dana/domain/uploadfiles/AddSelectedFiles;", "getAddSelectedFiles", "()Lid/dana/domain/uploadfiles/AddSelectedFiles;", "setAddSelectedFiles", "(Lid/dana/domain/uploadfiles/AddSelectedFiles;)V", "Lcom/alibaba/ariver/engine/api/bridge/extension/BridgeCallback;", "Lid/dana/domain/uploadfiles/ClearFiles;", "clearFiles", "Lid/dana/domain/uploadfiles/ClearFiles;", "getClearFiles", "()Lid/dana/domain/uploadfiles/ClearFiles;", "setClearFiles", "(Lid/dana/domain/uploadfiles/ClearFiles;)V", "Lid/dana/domain/uploadfiles/GetSelectedFiles;", "Lid/dana/domain/uploadfiles/GetSelectedFiles;", "getGetSelectedFiles", "()Lid/dana/domain/uploadfiles/GetSelectedFiles;", "setGetSelectedFiles", "(Lid/dana/domain/uploadfiles/GetSelectedFiles;)V", "Lid/dana/domain/uploadfiles/GetTotalFilesSize;", "getTotalFilesSize", "Lid/dana/domain/uploadfiles/GetTotalFilesSize;", "getGetTotalFilesSize", "()Lid/dana/domain/uploadfiles/GetTotalFilesSize;", "setGetTotalFilesSize", "(Lid/dana/domain/uploadfiles/GetTotalFilesSize;)V", "isUpload", "Z", "photoUri", "Landroid/net/Uri;", "getProviderAuthority", "()Ljava/lang/String;", "providerAuthority", "Lid/dana/domain/uploadfiles/RemoveSelectedFile;", "removeSelectedFile", "Lid/dana/domain/uploadfiles/RemoveSelectedFile;", "getRemoveSelectedFile", "()Lid/dana/domain/uploadfiles/RemoveSelectedFile;", "setRemoveSelectedFile", "(Lid/dana/domain/uploadfiles/RemoveSelectedFile;)V", "Lid/dana/domain/uploadfiles/SetTotalFilesSize;", "setTotalFilesSize", "Lid/dana/domain/uploadfiles/SetTotalFilesSize;", "getSetTotalFilesSize", "()Lid/dana/domain/uploadfiles/SetTotalFilesSize;", "setSetTotalFilesSize", "(Lid/dana/domain/uploadfiles/SetTotalFilesSize;)V", "totalFilesSize", "I", "Lid/dana/domain/uploadfiles/UploadFile;", "Lid/dana/domain/uploadfiles/UploadFile;", "getUploadFile", "()Lid/dana/domain/uploadfiles/UploadFile;", "setUploadFile", "(Lid/dana/domain/uploadfiles/UploadFile;)V", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UploadFilesBridge extends BaseBridge {
    private static final String ALL_MIME_TYPE = "*/*";
    private static final String AVI_MIME_TYPE = "video/avi";
    private static final int FILE_TOO_BIG = 11;
    private static final String HEIC_MIME_TYPE = "image/heic";
    private static final int INVALID_TYPE = 13;
    private static final int MAX_BYTES = 320000;
    private static final String MSVIDEO_MIME_TYPE = "video/x-msvideo";
    private static final String PNG_MIME_TYPE = "image/png";
    private static final String PROVIDER_SUFFIX = ".provider";
    private static final int REQUEST_CODE_CHOOSE_FILE = 101;
    private static final int REQUEST_CODE_STORAGE_PERMISSION = 100;
    private static final int SUCCESS = 0;
    private static final String TEMP_UPLOAD_FILES_PATH = "/upload_file/";
    private Activity activity;
    @Inject
    public AddSelectedFiles addSelectedFiles;
    private BridgeCallback bridgeCallback;
    @Inject
    public ClearFiles clearFiles;
    @Inject
    public GetSelectedFiles getSelectedFiles;
    @Inject
    public GetTotalFilesSize getTotalFilesSize;
    private boolean isUpload;
    private Uri photoUri;
    @Inject
    public RemoveSelectedFile removeSelectedFile;
    @Inject
    public SetTotalFilesSize setTotalFilesSize;
    private int totalFilesSize;
    @Inject
    public UploadFile uploadFile;
    private static final String TAG = "UploadFilesBridge";

    @JvmName(name = "getGetSelectedFiles")
    public final GetSelectedFiles getGetSelectedFiles() {
        GetSelectedFiles getSelectedFiles = this.getSelectedFiles;
        if (getSelectedFiles != null) {
            return getSelectedFiles;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetSelectedFiles")
    public final void setGetSelectedFiles(GetSelectedFiles getSelectedFiles) {
        Intrinsics.checkNotNullParameter(getSelectedFiles, "");
        this.getSelectedFiles = getSelectedFiles;
    }

    @JvmName(name = "getAddSelectedFiles")
    public final AddSelectedFiles getAddSelectedFiles() {
        AddSelectedFiles addSelectedFiles = this.addSelectedFiles;
        if (addSelectedFiles != null) {
            return addSelectedFiles;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setAddSelectedFiles")
    public final void setAddSelectedFiles(AddSelectedFiles addSelectedFiles) {
        Intrinsics.checkNotNullParameter(addSelectedFiles, "");
        this.addSelectedFiles = addSelectedFiles;
    }

    @JvmName(name = "getRemoveSelectedFile")
    public final RemoveSelectedFile getRemoveSelectedFile() {
        RemoveSelectedFile removeSelectedFile = this.removeSelectedFile;
        if (removeSelectedFile != null) {
            return removeSelectedFile;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setRemoveSelectedFile")
    public final void setRemoveSelectedFile(RemoveSelectedFile removeSelectedFile) {
        Intrinsics.checkNotNullParameter(removeSelectedFile, "");
        this.removeSelectedFile = removeSelectedFile;
    }

    @JvmName(name = "getUploadFile")
    public final UploadFile getUploadFile() {
        UploadFile uploadFile = this.uploadFile;
        if (uploadFile != null) {
            return uploadFile;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setUploadFile")
    public final void setUploadFile(UploadFile uploadFile) {
        Intrinsics.checkNotNullParameter(uploadFile, "");
        this.uploadFile = uploadFile;
    }

    @JvmName(name = "getClearFiles")
    public final ClearFiles getClearFiles() {
        ClearFiles clearFiles = this.clearFiles;
        if (clearFiles != null) {
            return clearFiles;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setClearFiles")
    public final void setClearFiles(ClearFiles clearFiles) {
        Intrinsics.checkNotNullParameter(clearFiles, "");
        this.clearFiles = clearFiles;
    }

    @JvmName(name = "getSetTotalFilesSize")
    public final SetTotalFilesSize getSetTotalFilesSize() {
        SetTotalFilesSize setTotalFilesSize = this.setTotalFilesSize;
        if (setTotalFilesSize != null) {
            return setTotalFilesSize;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSetTotalFilesSize")
    public final void setSetTotalFilesSize(SetTotalFilesSize setTotalFilesSize) {
        Intrinsics.checkNotNullParameter(setTotalFilesSize, "");
        this.setTotalFilesSize = setTotalFilesSize;
    }

    @JvmName(name = "getGetTotalFilesSize")
    public final GetTotalFilesSize getGetTotalFilesSize() {
        GetTotalFilesSize getTotalFilesSize = this.getTotalFilesSize;
        if (getTotalFilesSize != null) {
            return getTotalFilesSize;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGetTotalFilesSize")
    public final void setGetTotalFilesSize(GetTotalFilesSize getTotalFilesSize) {
        Intrinsics.checkNotNullParameter(getTotalFilesSize, "");
        this.getTotalFilesSize = getTotalFilesSize;
    }

    @JvmName(name = "getProviderAuthority")
    private final String getProviderAuthority() {
        StringBuilder sb = new StringBuilder();
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        sb.append(activity.getPackageName());
        sb.append(PROVIDER_SUFFIX);
        return sb.toString();
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter(canOverride = false)
    public final void uploadFiles(@BindingParam(name = {"event"}) String eventName, @BindingParam(name = {"info"}) JSONObject info, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        Intrinsics.checkNotNullParameter(eventName, "");
        Intrinsics.checkNotNullParameter(bridgeCallback, "");
        Intrinsics.checkNotNullParameter(page, "");
        Activity activity = BridgeExtensionExtKt.getActivity(page);
        if (activity == null) {
            return;
        }
        this.activity = activity;
        this.bridgeCallback = bridgeCallback;
        Activity activity2 = null;
        switch (eventName.hashCode()) {
            case -1656373096:
                if (eventName.equals(UploadFilesKey.Event.SELECT_FILE)) {
                    Activity activity3 = this.activity;
                    if (activity3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        activity2 = activity3;
                    }
                    onSelectFile(activity2);
                    return;
                }
                return;
            case 180405754:
                if (eventName.equals(UploadFilesKey.Event.REMOVE_ALL_FILES)) {
                    onClearAllFiles();
                    return;
                }
                return;
            case 1041585398:
                if (!eventName.equals("uploadFiles") || this.isUpload) {
                    return;
                }
                onUploadFiles();
                return;
            case 1098154016:
                if (eventName.equals(UploadFilesKey.Event.REMOVE_FILE)) {
                    onRemoveFile(info != null ? info.getInteger("index") : null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClearAllFiles() {
        getClearFiles().execute(NoParams.INSTANCE, new Function1<Boolean, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$onClearAllFiles$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$onClearAllFiles$2
            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String str;
                Intrinsics.checkNotNullParameter(th, "");
                str = UploadFilesBridge.TAG;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, "clearFiles", th);
            }
        });
    }

    private final void onUploadFiles() {
        this.isUpload = true;
        getGetSelectedFiles().execute(NoParams.INSTANCE, new Function1<List<? extends UploadFilesEntity>, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$onUploadFiles$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UploadFilesEntity> list) {
                invoke2((List<UploadFilesEntity>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UploadFilesEntity> list) {
                Activity activity;
                File file;
                Activity activity2;
                Intrinsics.checkNotNullParameter(list, "");
                for (UploadFilesEntity uploadFilesEntity : list) {
                    Activity activity3 = null;
                    if (uploadFilesEntity.isHeic()) {
                        activity2 = UploadFilesBridge.this.activity;
                        if (activity2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            activity3 = activity2;
                        }
                        File cacheDir = activity3.getCacheDir();
                        StringBuilder sb = new StringBuilder();
                        sb.append("/images/");
                        sb.append(uploadFilesEntity.getFileName());
                        file = new File(cacheDir, sb.toString());
                    } else {
                        activity = UploadFilesBridge.this.activity;
                        if (activity == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        } else {
                            activity3 = activity;
                        }
                        File cacheDir2 = activity3.getCacheDir();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("/upload_file/");
                        sb2.append(uploadFilesEntity.getFileName());
                        file = new File(cacheDir2, sb2.toString());
                    }
                    uploadFilesEntity.setFile(FilesKt.readBytes(file));
                }
                UploadFilesBridge.this.uploadFile(list);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$onUploadFiles$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String str;
                BridgeCallback bridgeCallback;
                JSONObject assembleUploadFilesResponse;
                Intrinsics.checkNotNullParameter(th, "");
                str = UploadFilesBridge.TAG;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, "getSelectedFiles", th);
                bridgeCallback = UploadFilesBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                assembleUploadFilesResponse = UploadFilesBridge.this.assembleUploadFilesResponse(false, null);
                bridgeCallback.sendJSONResponse(assembleUploadFilesResponse);
                UploadFilesBridge.this.isUpload = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void uploadFile(List<UploadFilesEntity> list) {
        getUploadFile().execute(list, new Function1<List<? extends UploadFilesEntity>, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$uploadFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UploadFilesEntity> list2) {
                invoke2((List<UploadFilesEntity>) list2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UploadFilesEntity> list2) {
                BridgeCallback bridgeCallback;
                BridgeCallback bridgeCallback2;
                JSONObject assembleUploadFilesResponse;
                Intrinsics.checkNotNullParameter(list2, "");
                Iterator<T> it = list2.iterator();
                while (true) {
                    bridgeCallback = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    ((UploadFilesEntity) it.next()).setFile(null);
                }
                bridgeCallback2 = UploadFilesBridge.this.bridgeCallback;
                if (bridgeCallback2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    bridgeCallback = bridgeCallback2;
                }
                assembleUploadFilesResponse = UploadFilesBridge.this.assembleUploadFilesResponse(true, list2);
                bridgeCallback.sendJSONResponse(assembleUploadFilesResponse);
                UploadFilesBridge.this.onClearAllFiles();
                UploadFilesBridge.this.isUpload = false;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$uploadFile$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                String str;
                BridgeCallback bridgeCallback;
                JSONObject assembleUploadFilesResponse;
                Intrinsics.checkNotNullParameter(th, "");
                str = UploadFilesBridge.TAG;
                DanaLog.BuiltInFictitiousFunctionClassFactory(str, PermissionConstant.UPLOAD_FILE, th);
                bridgeCallback = UploadFilesBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                assembleUploadFilesResponse = UploadFilesBridge.this.assembleUploadFilesResponse(false, null);
                bridgeCallback.sendJSONResponse(assembleUploadFilesResponse);
                UploadFilesBridge.this.isUpload = false;
            }
        });
    }

    private final void onRemoveFile(Integer info) {
        if (info != null) {
            getRemoveSelectedFile().execute(Integer.valueOf(info.intValue()), new Function1<Boolean, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$onRemoveFile$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    BridgeCallback bridgeCallback;
                    bridgeCallback = UploadFilesBridge.this.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bridgeCallback = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("success", (Object) Boolean.TRUE);
                    bridgeCallback.sendJSONResponse(jSONObject);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$onRemoveFile$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    String str;
                    BridgeCallback bridgeCallback;
                    Intrinsics.checkNotNullParameter(th, "");
                    str = UploadFilesBridge.TAG;
                    DanaLog.BuiltInFictitiousFunctionClassFactory(str, "removeSelectedFile", th);
                    bridgeCallback = UploadFilesBridge.this.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bridgeCallback = null;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("success", (Object) Boolean.FALSE);
                    bridgeCallback.sendJSONResponse(jSONObject);
                }
            });
        }
    }

    private final void onSelectFile(Activity activity) {
        String[] strArr;
        if (Build.VERSION.SDK_INT < 29) {
            strArr = new String[]{"android.permission.CAMERA", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        } else {
            strArr = new String[]{"android.permission.CAMERA"};
        }
        requestPermissions(activity, strArr, new PermissionCallback() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$onSelectFile$1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult result, boolean fromSystemDialog) {
                Object obj;
                Intrinsics.checkNotNullParameter(result, "");
                Iterator<T> it = result.BuiltInFictitiousFunctionClassFactory.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((PermissionReport) obj).KClassImpl$Data$declaredNonStaticMembers$2, "android.permission.READ_EXTERNAL_STORAGE")) {
                        break;
                    }
                }
                PermissionReport permissionReport = (PermissionReport) obj;
                if ((permissionReport != null && permissionReport.getBuiltInFictitiousFunctionClassFactory()) || Build.VERSION.SDK_INT >= 29) {
                    UploadFilesBridge.this.openFileChooser();
                }
            }
        });
    }

    private final Intent createGalleryIntent() {
        Intent type = new Intent("android.intent.action.GET_CONTENT", MediaStore.Images.Media.EXTERNAL_CONTENT_URI).setType(ALL_MIME_TYPE);
        Intrinsics.checkNotNullExpressionValue(type, "");
        return type;
    }

    private final Intent createCameraIntent() {
        File createImageFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            try {
                createImageFile = createImageFile();
            } catch (IOException e) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, "createCameraIntent", e);
            }
            try {
                Activity activity = this.activity;
                if (activity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    activity = null;
                }
                this.photoUri = FileProvider.getUriForFile(activity, getProviderAuthority(), createImageFile);
                intent.putExtra("return-date", true).putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, this.photoUri);
                return intent;
            } catch (Exception e2) {
                DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, "createCameraIntent", e2);
                return null;
            }
        } catch (ActivityNotFoundException unused) {
        }
    }

    private final File createImageFile() throws IOException {
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        File createTempFile = File.createTempFile(createFileName(".jpg"), ".jpg", FileUtil.getAuthRequestContext(activity));
        Intrinsics.checkNotNullExpressionValue(createTempFile, "");
        return createTempFile;
    }

    private final void appendIntentList(List<Intent> intents, Intent addedIntent, boolean isOnlyNeedOneIntent) {
        if (intents == null || addedIntent == null) {
            return;
        }
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(addedIntent, 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "");
        if (isOnlyNeedOneIntent) {
            getTargetedIntent((ResolveInfo) CollectionsKt.last((List) queryIntentActivities), addedIntent, intents);
            return;
        }
        Iterator<ResolveInfo> it = queryIntentActivities.iterator();
        while (it.hasNext()) {
            getTargetedIntent(it.next(), addedIntent, intents);
        }
    }

    private final void getTargetedIntent(ResolveInfo resolveInfo, Intent addedIntent, List<Intent> intents) {
        String str = resolveInfo.activityInfo.packageName;
        Intent intent = new Intent(addedIntent);
        intent.setPackage(str);
        if (intents != null) {
            intents.add(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openFileChooser() {
        ArrayList arrayList = new ArrayList();
        appendIntentList(arrayList, createGalleryIntent(), true);
        arrayList.add(createChooseFileIntent());
        Activity activity = this.activity;
        Activity activity2 = null;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(activity, "android.permission.CAMERA") == 0) {
            appendIntentList(arrayList, createCameraIntent(), false);
        }
        Intent remove = arrayList.remove(arrayList.size() - 1);
        Activity activity3 = this.activity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity3 = null;
        }
        Intent createChooser = Intent.createChooser(remove, activity3.getString(R.string.upload_files_bridge_bottomsheet_title));
        Object[] array = arrayList.toArray(new Intent[0]);
        if (array != null) {
            createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) array);
            Activity activity4 = this.activity;
            if (activity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                activity2 = activity4;
            }
            Intrinsics.checkNotNullExpressionValue(createChooser, "");
            startActivityForResult(activity2, createChooser, 101);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    private final Intent createChooseFileIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(ALL_MIME_TYPE);
        return intent;
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge
    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == -1 && requestCode == 101) {
            getSelectedFiles(data);
        }
    }

    private final void getSelectedFiles(final Intent data) {
        getGetSelectedFiles().execute(NoParams.INSTANCE, new Function1<List<? extends UploadFilesEntity>, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$getSelectedFiles$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(List<? extends UploadFilesEntity> list) {
                invoke2((List<UploadFilesEntity>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(List<UploadFilesEntity> list) {
                Intrinsics.checkNotNullParameter(list, "");
                UploadFilesBridge.this.getTotalSavedFileSize(list, data);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$getSelectedFiles$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                BridgeCallback bridgeCallback;
                JSONObject assembleChooseFileResponse;
                Intrinsics.checkNotNullParameter(th, "");
                bridgeCallback = UploadFilesBridge.this.bridgeCallback;
                if (bridgeCallback == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    bridgeCallback = null;
                }
                assembleChooseFileResponse = UploadFilesBridge.this.assembleChooseFileResponse(false, "", 1);
                bridgeCallback.sendJSONResponse(assembleChooseFileResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSuccessChooseFile(List<UploadFilesEntity> files, Intent data) {
        Uri uri;
        if (data == null || (uri = data.getData()) == null) {
            uri = this.photoUri;
        }
        if (uri != null) {
            Activity activity = this.activity;
            BridgeCallback bridgeCallback = null;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity = null;
            }
            String type = activity.getContentResolver().getType(uri);
            if (type == null) {
                type = "";
            }
            Intrinsics.checkNotNullExpressionValue(type, "");
            if (Intrinsics.areEqual(type, AVI_MIME_TYPE)) {
                type = MSVIDEO_MIME_TYPE;
            }
            String obj = uri.toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            UploadFilesEntity uploadFilesEntity = new UploadFilesEntity(obj, type, "", "", "", null, false, 64, null);
            int errorCode = getErrorCode(type, uri, files, uploadFilesEntity);
            if (errorCode == 0) {
                createTemporaryFile(uri, errorCode, assignFileSize(uri, uploadFilesEntity));
                return;
            }
            BridgeCallback bridgeCallback2 = this.bridgeCallback;
            if (bridgeCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                bridgeCallback = bridgeCallback2;
            }
            bridgeCallback.sendJSONResponse(assembleChooseFileResponse(false, "", errorCode));
        }
    }

    private final UploadFilesEntity assignFileSize(Uri uri, UploadFilesEntity selectedFile) {
        ResolutionCenterUploadFileValidator resolutionCenterUploadFileValidator = ResolutionCenterUploadFileValidator.INSTANCE;
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        int checkFileSize = resolutionCenterUploadFileValidator.checkFileSize(activity, uri);
        saveSelectedFileSizeToLocal(checkFileSize);
        StringBuilder sb = new StringBuilder();
        sb.append(checkFileSize / 1024);
        sb.append("kb");
        selectedFile.setSize(sb.toString());
        return selectedFile;
    }

    private final void saveSelectedFileSizeToLocal(int selectedFileSize) {
        getSetTotalFilesSize().execute(Integer.valueOf(this.totalFilesSize + selectedFileSize), new Function1<Boolean, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$saveSelectedFileSizeToLocal$1
            public final void invoke(boolean z) {
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$saveSelectedFileSizeToLocal$2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getTotalSavedFileSize(final List<UploadFilesEntity> files, final Intent data) {
        getGetTotalFilesSize().execute(NoParams.INSTANCE, new Function1<Integer, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$getTotalSavedFileSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                UploadFilesBridge.this.totalFilesSize = i;
                UploadFilesBridge.this.onSuccessChooseFile(files, data);
            }
        }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$getTotalSavedFileSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
                UploadFilesBridge.this.totalFilesSize = 0;
            }
        });
    }

    private final void createTemporaryFile(final Uri uri, final int errorCode, final UploadFilesEntity selectedFile) {
        if (createTempFile(uri, selectedFile)) {
            getAddSelectedFiles().execute(selectedFile, new Function1<Boolean, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$createTemporaryFile$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    String message;
                    BridgeCallback bridgeCallback;
                    JSONObject assembleChooseFileResponse;
                    message = UploadFilesBridge.this.getMessage(selectedFile.getContentType(), uri);
                    bridgeCallback = UploadFilesBridge.this.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bridgeCallback = null;
                    }
                    assembleChooseFileResponse = UploadFilesBridge.this.assembleChooseFileResponse(true, message, errorCode);
                    bridgeCallback.sendJSONResponse(assembleChooseFileResponse);
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.danah5.uploadfiles.UploadFilesBridge$createTemporaryFile$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    BridgeCallback bridgeCallback;
                    JSONObject assembleChooseFileResponse;
                    Intrinsics.checkNotNullParameter(th, "");
                    bridgeCallback = UploadFilesBridge.this.bridgeCallback;
                    if (bridgeCallback == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        bridgeCallback = null;
                    }
                    assembleChooseFileResponse = UploadFilesBridge.this.assembleChooseFileResponse(false, "", errorCode);
                    bridgeCallback.sendJSONResponse(assembleChooseFileResponse);
                }
            });
            return;
        }
        BridgeCallback bridgeCallback = this.bridgeCallback;
        if (bridgeCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            bridgeCallback = null;
        }
        bridgeCallback.sendJSONResponse(assembleChooseFileResponse(false, "", -1));
    }

    private final int getErrorCode(String mimeType, Uri uri, List<UploadFilesEntity> files, UploadFilesEntity selectedFile) {
        Activity activity = null;
        if (ResolutionCenterUploadFileValidator.INSTANCE.isFileFormatAllowed(mimeType)) {
            ResolutionCenterUploadFileValidator resolutionCenterUploadFileValidator = ResolutionCenterUploadFileValidator.INSTANCE;
            Activity activity2 = this.activity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity2 = null;
            }
            if (resolutionCenterUploadFileValidator.isFileSizeAllowed(activity2, uri) && ResolutionCenterUploadFileValidator.INSTANCE.checkFileCount(files, selectedFile)) {
                return 0;
            }
        }
        ResolutionCenterUploadFileValidator resolutionCenterUploadFileValidator2 = ResolutionCenterUploadFileValidator.INSTANCE;
        Activity activity3 = this.activity;
        if (activity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            activity = activity3;
        }
        return (resolutionCenterUploadFileValidator2.isFileSizeAllowed(activity, uri) && ResolutionCenterUploadFileValidator.INSTANCE.checkFileCount(files, selectedFile)) ? 13 : 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getMessage(String mimeType, Uri uri) {
        String fileCategory = ResolutionCenterUploadFileValidator.INSTANCE.getFileCategory(mimeType);
        if (Intrinsics.areEqual(fileCategory, "image")) {
            Float rotateImage = rotateImage(uri);
            Activity activity = this.activity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity = null;
            }
            ContentResolver contentResolver = activity.getContentResolver();
            Matrix matrix = new Matrix();
            matrix.postRotate(rotateImage != null ? rotateImage.floatValue() : 0.0f);
            Unit unit = Unit.INSTANCE;
            String BuiltInFictitiousFunctionClassFactory = BitmapUtil.BuiltInFictitiousFunctionClassFactory(uri, contentResolver, matrix);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            return BuiltInFictitiousFunctionClassFactory;
        }
        return fileCategory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject assembleChooseFileResponse(boolean success, String message, int error) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.valueOf(success));
        jSONObject.put("message", (Object) message);
        jSONObject.put("error", (Object) Integer.valueOf(error));
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject assembleUploadFilesResponse(boolean success, List<UploadFilesEntity> selectedFiles) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.valueOf(success));
        jSONObject.put("info", (Object) selectedFiles);
        return jSONObject;
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onInitialized() {
        super.onInitialized();
        DaggerGContainerComponent.Builder PlaceComponentResult = DaggerGContainerComponent.PlaceComponentResult();
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        PlaceComponentResult.getAuthRequestContext = (GContainerModule) Preconditions.getAuthRequestContext(new GContainerModule());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2().getAuthRequestContext(this);
    }

    @Override // id.dana.lib.gcontainer.app.bridge.core.BaseBridge, com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension, com.alibaba.ariver.kernel.api.extension.Extension
    public final void onFinalized() {
        super.onFinalized();
        getAddSelectedFiles().dispose();
        getGetSelectedFiles().dispose();
        getRemoveSelectedFile().dispose();
        getUploadFile().dispose();
        getClearFiles().dispose();
        getSetTotalFilesSize().dispose();
        getGetTotalFilesSize().dispose();
    }

    private final boolean createTempFile(Uri uri, UploadFilesEntity selectedFile) {
        try {
            Activity activity = this.activity;
            if (activity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity = null;
            }
            File file = new File(activity.getCacheDir(), TEMP_UPLOAD_FILES_PATH);
            if (!file.exists()) {
                if (!file.mkdir()) {
                    return false;
                }
                file.mkdirs();
            }
            Activity activity2 = this.activity;
            if (activity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                activity2 = null;
            }
            Cursor query = activity2.getContentResolver().query(uri, null, null, null, null);
            if (query != null) {
                Cursor cursor = query;
                try {
                    Cursor cursor2 = cursor;
                    int columnIndex = cursor2.getColumnIndex("_display_name");
                    cursor2.moveToFirst();
                    String string = cursor2.getString(columnIndex);
                    if (string == null) {
                        string = "";
                    }
                    selectedFile.setFileName(createFileName(StringsKt.substringAfterLast(string, '.', "")));
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(cursor, null);
                } finally {
                }
            }
            if (Intrinsics.areEqual(selectedFile.getContentType(), HEIC_MIME_TYPE)) {
                return modifyHeicImage(selectedFile, uri);
            }
            return copyFile(uri, file, selectedFile);
        } catch (Exception e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, "createTempFile", e);
            return false;
        }
    }

    private final String convertImageToJpeg(Uri uri) {
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        return id.dana.utils.FileUtil.MyBillsEntityDataFactory(activity, uri.toString()).toURI().toString();
    }

    private final boolean modifyHeicImage(UploadFilesEntity selectedFile, Uri uri) {
        String convertImageToJpeg = convertImageToJpeg(uri);
        if (convertImageToJpeg == null) {
            convertImageToJpeg = "";
        }
        selectedFile.setUri(convertImageToJpeg);
        if (selectedFile.getUri().length() == 0) {
            return false;
        }
        selectedFile.setContentType(PNG_MIME_TYPE);
        selectedFile.setFileName(StringsKt.substringAfterLast$default(selectedFile.getUri(), "/", (String) null, 2, (Object) null));
        selectedFile.setHeic(true);
        return true;
    }

    private final boolean copyFile(Uri uri, File folder, UploadFilesEntity selectedFile) {
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        ParcelFileDescriptor openFileDescriptor = activity.getContentResolver().openFileDescriptor(uri, BranchLinkConstant.PayloadKey.REFERRAL);
        if (openFileDescriptor == null) {
            return false;
        }
        FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
        FileOutputStream fileOutputStream = new FileOutputStream(new File(folder, selectedFile.getFileName()));
        ByteStreamsKt.copyTo$default(fileInputStream, fileOutputStream, 0, 2, null);
        fileInputStream.close();
        openFileDescriptor.close();
        fileOutputStream.flush();
        fileOutputStream.close();
        return true;
    }

    private final Float rotateImage(Uri imageUri) throws IOException {
        ExifInterface exifInterface;
        Float valueOf;
        Activity activity = this.activity;
        if (activity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            activity = null;
        }
        InputStream BuiltInFictitiousFunctionClassFactory = UriUtils.BuiltInFictitiousFunctionClassFactory(imageUri, activity);
        if (BuiltInFictitiousFunctionClassFactory == null) {
            return null;
        }
        InputStream inputStream = BuiltInFictitiousFunctionClassFactory;
        try {
            InputStream inputStream2 = inputStream;
            if (Build.VERSION.SDK_INT >= 24) {
                exifInterface = new ExifInterface(inputStream2);
            } else {
                String path = imageUri.getPath();
                if (path == null) {
                    CloseableKt.closeFinally(inputStream, null);
                    return Float.valueOf(0.0f);
                }
                exifInterface = new ExifInterface(path);
            }
            int attributeInt = exifInterface.getAttributeInt("Orientation", 1);
            if (attributeInt == 3) {
                valueOf = Float.valueOf(180.0f);
            } else if (attributeInt == 6) {
                valueOf = Float.valueOf(90.0f);
            } else if (attributeInt == 8) {
                valueOf = Float.valueOf(270.0f);
            } else {
                valueOf = Float.valueOf(0.0f);
            }
            CloseableKt.closeFinally(inputStream, null);
            return valueOf;
        } finally {
        }
    }

    private final String createFileName(String format) {
        String format2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("FILE_");
        sb.append(format2);
        sb.append("_.");
        sb.append(format);
        return sb.toString();
    }
}
