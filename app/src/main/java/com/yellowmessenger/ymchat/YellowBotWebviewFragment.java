package com.yellowmessenger.ymchat;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.image.framework.api.APImageFormat;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;
import com.google.common.base.Ascii;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yellowmessenger.ymchat.models.ConfigService;
import com.yellowmessenger.ymchat.models.JavaScriptInterface;
import com.yellowmessenger.ymchat.models.YMBotEventResponse;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.util.permission.ManifestPermission;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u0001:\u0002STB\u0007¢\u0006\u0004\bR\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\b\u0010\u0006J\r\u0010\b\u001a\u00020\t¢\u0006\u0004\b\b\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J%\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0007\u0010\u0014J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0015J\u000f\u0010\u0007\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0007\u0010\nJ\u000f\u0010\u0005\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0005\u0010\nJ)\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0019\u0010\u001c\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u0003\u001a\u00020\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\nJ\u000f\u0010$\u001a\u00020\tH\u0016¢\u0006\u0004\b$\u0010\nJ\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\nJ!\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020 2\b\u0010\u0013\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010(\u001a\u00020\tH\u0002¢\u0006\u0004\b(\u0010\nJ\u000f\u0010)\u001a\u00020\tH\u0002¢\u0006\u0004\b)\u0010\nJ\u000f\u0010*\u001a\u00020\tH\u0002¢\u0006\u0004\b*\u0010\nR\u0014\u0010\b\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u000f\u0010+R\u0014\u0010\u0005\u001a\u00020\u00128\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010,R\u0016\u0010\u0007\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u000e\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010,R\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00105R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00105R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00105R\u0018\u00104\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010,R&\u0010.\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010<0\u0011\u0018\u00010;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u00103\u001a\u00020?8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u00101\u001a\u00020B8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0007\u0010CR\u0016\u00106\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010ER\u0012\u00108\u001a\u00020\u0012X\u0086\u0002¢\u0006\u0006\n\u0004\b\b\u0010,R4\u00109\u001a\"\u0012\u001e\u0012\u001c\u0012\b\u0012\u0006*\u00020\u00120\u0012*\u000e\u0012\n\b\u0001\u0012\u0006*\u00020\u00120\u00120\u00110\u00110F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001e\u00107\u001a\f\u0012\b\u0012\u0006*\u00020\u00120\u00120F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010HR\u0018\u0010=\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010,R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u00105R\u0014\u0010J\u001a\u0004\u0018\u00010LX\u0086\u0002¢\u0006\u0006\n\u0004\b\u000e\u0010MR\u0018\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0010\u0010NR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010NR\u0018\u0010D\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010,R\u0016\u0010@\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u00105"}, d2 = {"Lcom/yellowmessenger/ymchat/YellowBotWebviewFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/Context;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/content/Context;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "", "()V", "Ljava/io/File;", "getAuthRequestContext", "()Ljava/io/File;", "MyBillsEntityDataFactory", "moveToNextValue", "getErrorConfigVersion", "", "", "p1", "(Landroid/content/Context;[Ljava/lang/String;)Z", "()Z", "", "Landroid/content/Intent;", "p2", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/os/Bundle;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDestroy", "onStart", "onStop", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda0", "scheduleImpl", "I", "Ljava/lang/String;", "Landroid/widget/ImageView;", "DatabaseTableConfigUtil", "Landroid/widget/ImageView;", "Landroid/webkit/GeolocationPermissions$Callback;", "initRecordTimeStamp", "Landroid/webkit/GeolocationPermissions$Callback;", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda7", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "isLayoutRequested", "Landroid/webkit/ValueCallback;", "Lcom/yellowmessenger/ymchat/YmMovableFloatingActionButton;", "NetworkUserEntityData$$ExternalSyntheticLambda3", "Lcom/yellowmessenger/ymchat/YmMovableFloatingActionButton;", "Landroid/webkit/WebView;", "Landroid/webkit/WebView;", "NetworkUserEntityData$$ExternalSyntheticLambda4", "Landroid/view/View;", "Landroidx/activity/result/ActivityResultLauncher;", "NetworkUserEntityData$$ExternalSyntheticLambda6", "Landroidx/activity/result/ActivityResultLauncher;", "NetworkUserEntityData$$ExternalSyntheticLambda5", "FragmentBottomSheetPaymentSettingBinding", "readMicros", "Landroid/speech/SpeechRecognizer;", "Landroid/speech/SpeechRecognizer;", "[Ljava/lang/String;", "SubSequence", "getSupportButtonTintMode", "whenAvailable", "<init>", "Companion", "CustomRecognitionListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class YellowBotWebviewFragment extends Fragment {

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private ImageView KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: FragmentBottomSheetPaymentSettingBinding  reason: from kotlin metadata */
    private String isLayoutRequested;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    WebView initRecordTimeStamp;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    SpeechRecognizer FragmentBottomSheetPaymentSettingBinding;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
    private YmMovableFloatingActionButton GetContactSyncConfig;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda4  reason: from kotlin metadata */
    private View NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
    private final ActivityResultLauncher<String> PrepareContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda6  reason: from kotlin metadata */
    private final ActivityResultLauncher<String[]> newProxyInstance;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private boolean scheduleImpl;

    /* renamed from: getSupportButtonTintMode  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda4;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private GeolocationPermissions.Callback MyBillsEntityDataFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private ValueCallback<Uri[]> DatabaseTableConfigUtil;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: whenAvailable  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda3;
    public static final byte[] $$a = {TarHeader.LF_DIR, 93, -14, -126, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 112;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {77, -56, -115, -110, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int scheduleImpl = 232;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public String NetworkUserEntityData$$ExternalSyntheticLambda7 = "https://app.yellowmessenger.com/api/chat/upload?bot=";

    /* renamed from: readMicros  reason: from kotlin metadata */
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda8 = true;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory = "YMChat";

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private final int PlaceComponentResult = 1;

    /* renamed from: SubSequence  reason: from kotlin metadata */
    private String[] NetworkUserEntityData$$ExternalSyntheticLambda6 = {"android.permission.READ_EXTERNAL_STORAGE"};

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public String[] NetworkUserEntityData$$ExternalSyntheticLambda5 = {"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO"};

    /* JADX WARN: Removed duplicated region for block: B:32:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0029 -> B:35:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = com.yellowmessenger.ymchat.YellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r8 = r8 * 15
            int r8 = 19 - r8
            int r6 = r6 * 3
            int r6 = r6 + 16
            int r7 = 106 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r6) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            r4 = r0[r8]
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
        L36:
            int r8 = r8 + r6
            int r6 = r9 + 1
            int r8 = r8 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yellowmessenger.ymchat.YellowBotWebviewFragment.a(int, byte, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002d -> B:35:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 4
            int r7 = 42 - r7
            int r6 = r6 + 4
            int r8 = r8 * 4
            int r8 = r8 + 75
            byte[] r0 = com.yellowmessenger.ymchat.YellowBotWebviewFragment.$$a
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
            r3 = r0[r6]
            r5 = r7
            r7 = r6
            r6 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r6 = -r6
            int r8 = r8 + r6
            int r8 = r8 + (-7)
            r6 = r7
            r7 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yellowmessenger.ymchat.YellowBotWebviewFragment.b(short, int, short, java.lang.Object[]):void");
    }

    public YellowBotWebviewFragment() {
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda13
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                YellowBotWebviewFragment.KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment.this, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.newProxyInstance = registerForActivityResult;
        ActivityResultLauncher<String> registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda14
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                YellowBotWebviewFragment.PlaceComponentResult(YellowBotWebviewFragment.this, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult2, "");
        this.PrepareContext = registerForActivityResult2;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] + 1);
            byte b4 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[5]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - KeyEvent.keyCodeFromString(""), View.resolveSizeAndState(0, 0, 0) + 4, (char) View.MeasureSpec.getMode(0));
                    byte b5 = $$a[35];
                    byte b6 = (byte) (b5 + 1);
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r1 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), Drawable.resolveOpacity(0, 0) + 35, (char) (ViewConfiguration.getKeyRepeatDelay() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1569942912, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", "", 0, 0), ExpandableListView.getPackedPositionChild(0L) + 19, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
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
                super.onCreate(p0);
                try {
                    int i2 = ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.isLayoutRequested;
                    if (i2 != -1) {
                        Window window = requireActivity().getWindow();
                        Intrinsics.checkNotNullExpressionValue(window, "");
                        window.clearFlags(67108864);
                        window.addFlags(Integer.MIN_VALUE);
                        Context context = getContext();
                        if (context != null) {
                            window.setStatusBarColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context, i2));
                        }
                    }
                } catch (Exception unused) {
                }
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                this.getErrorConfigVersion = MyBillsEntityDataFactory(requireContext);
                YMChat.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(new BotEventListener() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda12
                    @Override // com.yellowmessenger.ymchat.BotEventListener
                    public final void BuiltInFictitiousFunctionClassFactory(YMBotEventResponse yMBotEventResponse) {
                        YellowBotWebviewFragment.KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment.this, yMBotEventResponse);
                    }
                });
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
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater p0, ViewGroup p1, Bundle p2) {
        String string;
        File filesDir;
        Intrinsics.checkNotNullParameter(p0, "");
        View inflate = p0.inflate(R.layout.fragment_yellow_bot_webview, p1, false);
        View findViewById = inflate.findViewById(R.id.scheduleImpl_res_0x7f0a1c02);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.initRecordTimeStamp = (WebView) findViewById;
        final FragmentActivity activity = getActivity();
        WebView webView = this.initRecordTimeStamp;
        WebView webView2 = null;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView = null;
        }
        webView.getSettings().setJavaScriptEnabled(true);
        WebView webView3 = this.initRecordTimeStamp;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView3 = null;
        }
        webView3.getSettings().setDomStorageEnabled(true);
        WebView webView4 = this.initRecordTimeStamp;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView4 = null;
        }
        webView4.getSettings().setSupportMultipleWindows(true);
        WebView webView5 = this.initRecordTimeStamp;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView5 = null;
        }
        webView5.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        WebView webView6 = this.initRecordTimeStamp;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView6 = null;
        }
        webView6.getSettings().setAllowFileAccess(true);
        WebView webView7 = this.initRecordTimeStamp;
        if (webView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView7 = null;
        }
        webView7.getSettings().setGeolocationDatabasePath((activity == null || (filesDir = activity.getFilesDir()) == null) ? null : filesDir.getPath());
        WebView webView8 = this.initRecordTimeStamp;
        if (webView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView8 = null;
        }
        webView8.getSettings().setMediaPlaybackRequiresUserGesture(false);
        WebView webView9 = this.initRecordTimeStamp;
        if (webView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView9 = null;
        }
        FragmentActivity requireActivity = requireActivity();
        WebView webView10 = this.initRecordTimeStamp;
        if (webView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView10 = null;
        }
        webView9.addJavascriptInterface(new JavaScriptInterface(requireActivity, webView10), "YMHandler");
        WebView webView11 = this.initRecordTimeStamp;
        if (webView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView11 = null;
        }
        InstrumentInjector.setWebViewClient(webView11, new WebViewClient());
        WebView webView12 = this.initRecordTimeStamp;
        if (webView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView12 = null;
        }
        webView12.setWebChromeClient(new WebChromeClient() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$preLoadWebView$1
            private int BuiltInFictitiousFunctionClassFactory;

            /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
            private WebChromeClient.CustomViewCallback MyBillsEntityDataFactory;
            private View getAuthRequestContext;

            /* renamed from: lookAheadTest  reason: from kotlin metadata */
            private int KClassImpl$Data$declaredNonStaticMembers$2;

            @Override // android.webkit.WebChromeClient
            public final boolean onConsoleMessage(ConsoleMessage p02) {
                Intrinsics.checkNotNullParameter(p02, "");
                if (ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.DatabaseTableConfigUtil) {
                    InstrumentInjector.log_d("WebView", p02.message());
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onShowFileChooser(WebView p02, ValueCallback<Uri[]> p12, WebChromeClient.FileChooserParams p22) {
                ValueCallback valueCallback;
                ValueCallback valueCallback2;
                Intrinsics.checkNotNullParameter(p02, "");
                Intrinsics.checkNotNullParameter(p12, "");
                Intrinsics.checkNotNullParameter(p22, "");
                valueCallback = YellowBotWebviewFragment.this.DatabaseTableConfigUtil;
                if (valueCallback != null) {
                    valueCallback2 = YellowBotWebviewFragment.this.DatabaseTableConfigUtil;
                    Intrinsics.checkNotNull(valueCallback2);
                    valueCallback2.onReceiveValue(null);
                }
                YellowBotWebviewFragment.this.DatabaseTableConfigUtil = p12;
                YellowBotWebviewFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = false;
                YellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda7(YellowBotWebviewFragment.this);
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final Bitmap getDefaultVideoPoster() {
                if (this.getAuthRequestContext == null) {
                    return null;
                }
                Context context = activity;
                return BitmapFactory.decodeResource(context != null ? context.getResources() : null, 2130837573);
            }

            @Override // android.webkit.WebChromeClient
            public final void onHideCustomView() {
                if (YellowBotWebviewFragment.this.getActivity() != null) {
                    FragmentActivity activity2 = YellowBotWebviewFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity2);
                    ((FrameLayout) activity2.getWindow().getDecorView()).removeView(this.getAuthRequestContext);
                    FragmentActivity activity3 = YellowBotWebviewFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity3);
                    activity3.getWindow().getDecorView().setSystemUiVisibility(this.KClassImpl$Data$declaredNonStaticMembers$2);
                    FragmentActivity activity4 = YellowBotWebviewFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity4);
                    activity4.setRequestedOrientation(this.BuiltInFictitiousFunctionClassFactory);
                }
                this.getAuthRequestContext = null;
                WebChromeClient.CustomViewCallback customViewCallback = this.MyBillsEntityDataFactory;
                Intrinsics.checkNotNull(customViewCallback);
                customViewCallback.onCustomViewHidden();
                this.MyBillsEntityDataFactory = null;
            }

            @Override // android.webkit.WebChromeClient
            public final void onShowCustomView(View p02, WebChromeClient.CustomViewCallback p12) {
                Intrinsics.checkNotNullParameter(p02, "");
                Intrinsics.checkNotNullParameter(p12, "");
                if (this.getAuthRequestContext != null) {
                    onHideCustomView();
                    return;
                }
                this.getAuthRequestContext = p02;
                if (YellowBotWebviewFragment.this.getActivity() != null) {
                    FragmentActivity activity2 = YellowBotWebviewFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity2);
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = activity2.getWindow().getDecorView().getSystemUiVisibility();
                    FragmentActivity activity3 = YellowBotWebviewFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity3);
                    this.BuiltInFictitiousFunctionClassFactory = activity3.getRequestedOrientation();
                }
                this.MyBillsEntityDataFactory = p12;
                if (YellowBotWebviewFragment.this.getActivity() != null) {
                    FragmentActivity activity4 = YellowBotWebviewFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity4);
                    ((FrameLayout) activity4.getWindow().getDecorView()).addView(this.getAuthRequestContext, new FrameLayout.LayoutParams(-1, -1));
                    FragmentActivity activity5 = YellowBotWebviewFragment.this.getActivity();
                    Intrinsics.checkNotNull(activity5);
                    activity5.getWindow().getDecorView().setSystemUiVisibility(3846);
                }
            }

            @Override // android.webkit.WebChromeClient
            public final boolean onCreateWindow(WebView p02, boolean p12, boolean p22, Message p3) {
                Intrinsics.checkNotNullParameter(p02, "");
                Intrinsics.checkNotNullParameter(p3, "");
                Context context = activity;
                WebView webView13 = context != null ? new WebView(context) : null;
                Object obj = p3.obj;
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.webkit.WebView.WebViewTransport");
                }
                ((WebView.WebViewTransport) obj).setWebView(webView13);
                p3.sendToTarget();
                if (webView13 != null) {
                    final YellowBotWebviewFragment yellowBotWebviewFragment = YellowBotWebviewFragment.this;
                    InstrumentInjector.setWebViewClient(webView13, new WebViewClient() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$preLoadWebView$1$onCreateWindow$1
                        @Override // android.webkit.WebViewClient
                        public final boolean shouldOverrideUrlLoading(WebView p03, String p13) {
                            Intrinsics.checkNotNullParameter(p03, "");
                            Intrinsics.checkNotNullParameter(p13, "");
                            try {
                                Intent intent = new Intent("android.intent.action.VIEW");
                                intent.setData(Uri.parse(p13));
                                YellowBotWebviewFragment.this.startActivity(intent);
                                return true;
                            } catch (Exception unused) {
                                return true;
                            }
                        }
                    });
                    return true;
                }
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public final void onGeolocationPermissionsShowPrompt(String p02, GeolocationPermissions.Callback p12) {
                boolean errorConfigVersion;
                boolean KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullParameter(p02, "");
                Intrinsics.checkNotNullParameter(p12, "");
                if (YellowBotWebviewFragment.this.getContext() == null) {
                    return;
                }
                Context requireContext = YellowBotWebviewFragment.this.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "");
                errorConfigVersion = YellowBotWebviewFragment.getErrorConfigVersion(requireContext);
                if (!errorConfigVersion) {
                    View view = YellowBotWebviewFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        view = null;
                    }
                    YmHelper.BuiltInFictitiousFunctionClassFactory(view, YellowBotWebviewFragment.this.getString(R.string.ym_no_location_permission_declared));
                    return;
                }
                YellowBotWebviewFragment yellowBotWebviewFragment = YellowBotWebviewFragment.this;
                Context requireContext2 = yellowBotWebviewFragment.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "");
                KClassImpl$Data$declaredNonStaticMembers$2 = yellowBotWebviewFragment.KClassImpl$Data$declaredNonStaticMembers$2(requireContext2);
                if (!KClassImpl$Data$declaredNonStaticMembers$2) {
                    YellowBotWebviewFragment.this.getAuthRequestContext = p02;
                    YellowBotWebviewFragment.this.MyBillsEntityDataFactory = p12;
                    return;
                }
                p12.invoke(p02, true, false);
            }
        });
        if (ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.PrepareContext) {
            string = getString(R.string.ym_lite_chatbot_base_url);
        } else {
            string = getString(R.string.ym_chatbot_base_url);
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        ConfigService MyBillsEntityDataFactory = ConfigService.MyBillsEntityDataFactory();
        Uri.Builder appendQueryParameter = Uri.parse(string).buildUpon().appendQueryParameter("botId", MyBillsEntityDataFactory.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
        HashMap<String, Object> hashMap = MyBillsEntityDataFactory.PlaceComponentResult.initRecordTimeStamp != null ? MyBillsEntityDataFactory.PlaceComponentResult.initRecordTimeStamp : new HashMap<>();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = hashMap;
        hashMap.put("Platform", "Android-App");
        String obj = appendQueryParameter.appendQueryParameter("ym.payload", new Gson().toJson(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2)).appendQueryParameter("ymAuthenticationToken", MyBillsEntityDataFactory.PlaceComponentResult.newProxyInstance == null ? "" : MyBillsEntityDataFactory.PlaceComponentResult.newProxyInstance).appendQueryParameter("deviceToken", MyBillsEntityDataFactory.PlaceComponentResult.lookAheadTest == null ? "" : MyBillsEntityDataFactory.PlaceComponentResult.lookAheadTest).appendQueryParameter("customBaseUrl", MyBillsEntityDataFactory.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2).appendQueryParameter("version", Integer.toString(MyBillsEntityDataFactory.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8)).appendQueryParameter("customLoaderUrl", MyBillsEntityDataFactory.PlaceComponentResult.moveToNextValue).appendQueryParameter("disableActionsOnLoad", String.valueOf(MyBillsEntityDataFactory.PlaceComponentResult.scheduleImpl)).build().toString();
        WebView webView13 = this.initRecordTimeStamp;
        if (webView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView13 = null;
        }
        InstrumentInjector.trackWebView(webView13);
        webView13.loadUrl(obj);
        WebView webView14 = this.initRecordTimeStamp;
        if (webView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            webView2 = webView14;
        }
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:240:0x0096 A[Catch: Exception -> 0x0091, TryCatch #2 {Exception -> 0x0091, blocks: (B:229:0x007e, B:231:0x0082, B:240:0x0096, B:242:0x009a, B:243:0x009e, B:245:0x00ad, B:247:0x00b1, B:255:0x00c3, B:257:0x00c7, B:258:0x00cb), top: B:304:0x007e }] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x00c3 A[Catch: Exception -> 0x0091, TryCatch #2 {Exception -> 0x0091, blocks: (B:229:0x007e, B:231:0x0082, B:240:0x0096, B:242:0x009a, B:243:0x009e, B:245:0x00ad, B:247:0x00b1, B:255:0x00c3, B:257:0x00c7, B:258:0x00cb), top: B:304:0x007e }] */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yellowmessenger.ymchat.YellowBotWebviewFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int p0, int p1, Intent p2) {
        Uri[] uriArr;
        if (p0 != this.PlaceComponentResult || this.DatabaseTableConfigUtil == null) {
            super.onActivityResult(p0, p1, p2);
            return;
        }
        if (p1 == -1) {
            if (p2 != null && p2.getDataString() != null) {
                uriArr = new Uri[]{Uri.parse(p2.getDataString())};
            } else if (p2 != null && p2.getClipData() != null) {
                ClipData clipData = p2.getClipData();
                Intrinsics.checkNotNull(clipData);
                int itemCount = clipData.getItemCount();
                if (itemCount > 0) {
                    Uri[] uriArr2 = new Uri[itemCount];
                    for (int i = 0; i < itemCount; i++) {
                        ClipData clipData2 = p2.getClipData();
                        Intrinsics.checkNotNull(clipData2);
                        uriArr2[i] = clipData2.getItemAt(i).getUri();
                    }
                    uriArr = uriArr2;
                }
            } else {
                String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
                if (str != null) {
                    uriArr = new Uri[]{Uri.parse(str)};
                }
            }
            ValueCallback<Uri[]> valueCallback = this.DatabaseTableConfigUtil;
            Intrinsics.checkNotNull(valueCallback);
            valueCallback.onReceiveValue(uriArr);
            this.DatabaseTableConfigUtil = null;
        }
        uriArr = null;
        ValueCallback<Uri[]> valueCallback2 = this.DatabaseTableConfigUtil;
        Intrinsics.checkNotNull(valueCallback2);
        valueCallback2.onReceiveValue(uriArr);
        this.DatabaseTableConfigUtil = null;
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        File file;
        View view = null;
        try {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (getActivity() == null || intent.resolveActivity(requireActivity().getPackageManager()) == null) {
                return;
            }
            try {
                file = getAuthRequestContext();
                try {
                    intent.putExtra("PhotoPath", this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                file = null;
            }
            if (file != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("file:");
                sb.append(file.getAbsolutePath());
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = sb.toString();
                if (getContext() == null) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(requireContext().getPackageName());
                sb2.append(".yellow.chatbot.provider");
                Uri uriForFile = FileProvider.getUriForFile(requireContext(), sb2.toString(), file);
                Intrinsics.checkNotNullExpressionValue(uriForFile, "");
                intent.putExtra(TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, uriForFile);
                intent.addFlags(1);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
                startActivityForResult(intent, this.PlaceComponentResult);
                return;
            }
            View view2 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                view2 = null;
            }
            YmHelper.BuiltInFictitiousFunctionClassFactory(view2, requireContext().getString(R.string.ym_message_camera_error));
        } catch (Exception unused3) {
            View view3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                view = view3;
            }
            YmHelper.BuiltInFictitiousFunctionClassFactory(view, requireContext().getString(R.string.ym_message_camera_error));
        }
    }

    private static boolean moveToNextValue(Context p0) {
        try {
            String[] strArr = p0.getPackageManager().getPackageInfo(p0.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    for (String str : strArr) {
                        if (Intrinsics.areEqual(str, "android.permission.CAMERA")) {
                            return true;
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean getErrorConfigVersion(Context p0) {
        try {
            String[] strArr = p0.getPackageManager().getPackageInfo(p0.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    for (String str : strArr) {
                        if (Intrinsics.areEqual(str, "android.permission.ACCESS_FINE_LOCATION")) {
                            return true;
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Context p0) {
        if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            return true;
        }
        this.isLayoutRequested = "android.permission.ACCESS_FINE_LOCATION";
        this.PrepareContext.MyBillsEntityDataFactory("android.permission.ACCESS_FINE_LOCATION", null);
        return false;
    }

    private final boolean BuiltInFictitiousFunctionClassFactory(Context p0) {
        if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, "android.permission.CAMERA") == 0) {
            return true;
        }
        this.isLayoutRequested = "android.permission.CAMERA";
        this.PrepareContext.MyBillsEntityDataFactory("android.permission.CAMERA", null);
        return false;
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        if (getLookAheadTest()) {
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        if (getActivity() != null) {
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = false;
            startActivityForResult(intent, this.PlaceComponentResult);
        }
    }

    private final File getAuthRequestContext() throws IOException {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        StringBuilder sb = new StringBuilder();
        sb.append("JPEG_");
        sb.append(format);
        sb.append('_');
        return File.createTempFile(sb.toString(), ".jpg", requireContext().getExternalCacheDir());
    }

    private final boolean PlaceComponentResult(Context p0) {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = this.NetworkUserEntityData$$ExternalSyntheticLambda5;
        } else {
            strArr = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
        }
        if (KClassImpl$Data$declaredNonStaticMembers$2(p0, strArr)) {
            return true;
        }
        this.newProxyInstance.MyBillsEntityDataFactory(strArr, null);
        return false;
    }

    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    private final boolean getLookAheadTest() {
        return this.lookAheadTest;
    }

    private final void moveToNextValue() {
        try {
            int i = ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.PlaceComponentResult;
            if (i == -1 || getContext() == null) {
                return;
            }
            ImageView imageView = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                imageView = null;
            }
            DrawableCompat.MyBillsEntityDataFactory(DrawableCompat.scheduleImpl(imageView.getDrawable()), ContextCompat.BuiltInFictitiousFunctionClassFactory(requireContext(), i));
        } catch (Exception unused) {
        }
    }

    private final void getErrorConfigVersion() {
        ImageView imageView = null;
        if (ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda1) {
            ImageView imageView2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                imageView = imageView2;
            }
            imageView.setVisibility(0);
            moveToNextValue();
            return;
        }
        ImageView imageView3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void lookAheadTest() {
        YmMovableFloatingActionButton ymMovableFloatingActionButton = null;
        if (ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.getErrorConfigVersion) {
            YmMovableFloatingActionButton ymMovableFloatingActionButton2 = this.GetContactSyncConfig;
            if (ymMovableFloatingActionButton2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                ymMovableFloatingActionButton = ymMovableFloatingActionButton2;
            }
            ymMovableFloatingActionButton.show();
            return;
        }
        YmMovableFloatingActionButton ymMovableFloatingActionButton3 = this.GetContactSyncConfig;
        if (ymMovableFloatingActionButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            ymMovableFloatingActionButton = ymMovableFloatingActionButton3;
        }
        ymMovableFloatingActionButton.hide();
    }

    private static boolean MyBillsEntityDataFactory(Context p0) {
        try {
            String[] strArr = p0.getPackageManager().getPackageInfo(p0.getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                if (!(strArr.length == 0)) {
                    for (String str : strArr) {
                        if (Intrinsics.areEqual(str, ManifestPermission.RECORD_AUDIO)) {
                            return true;
                        }
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x002e, code lost:
    
        if ((kotlin.text.StringsKt.trim((java.lang.CharSequence) r1).toString().length() == 0) != false) goto L56;
     */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onStart() {
        /*
            r4 = this;
            r0 = 0
            r4.scheduleImpl = r0
            com.yellowmessenger.ymchat.models.ConfigService r1 = com.yellowmessenger.ymchat.models.ConfigService.MyBillsEntityDataFactory()
            com.yellowmessenger.ymchat.YMConfig r1 = r1.PlaceComponentResult
            java.lang.String r1 = r1.BuiltInFictitiousFunctionClassFactory
            r2 = 1
            java.lang.String r3 = ""
            if (r1 == 0) goto L30
            com.yellowmessenger.ymchat.models.ConfigService r1 = com.yellowmessenger.ymchat.models.ConfigService.MyBillsEntityDataFactory()
            com.yellowmessenger.ymchat.YMConfig r1 = r1.PlaceComponentResult
            java.lang.String r1 = r1.BuiltInFictitiousFunctionClassFactory
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.CharSequence r1 = kotlin.text.StringsKt.trim(r1)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 != 0) goto L2e
            r0 = 1
        L2e:
            if (r0 == 0) goto L39
        L30:
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            if (r0 == 0) goto L39
            r0.onBackPressed()
        L39:
            boolean r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            if (r0 == 0) goto L57
            boolean r0 = r4.moveToNextValue
            if (r0 != 0) goto L4b
            com.yellowmessenger.ymchat.models.ConfigService r0 = com.yellowmessenger.ymchat.models.ConfigService.MyBillsEntityDataFactory()
            com.yellowmessenger.ymchat.YMConfig r0 = r0.PlaceComponentResult
            boolean r0 = r0.MyBillsEntityDataFactory
            if (r0 == 0) goto L57
        L4b:
            android.webkit.WebView r0 = r4.initRecordTimeStamp
            if (r0 != 0) goto L53
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r0 = 0
        L53:
            r0.reload()
            goto L59
        L57:
            r4.NetworkUserEntityData$$ExternalSyntheticLambda8 = r2
        L59:
            com.yellowmessenger.ymchat.YMChat r0 = com.yellowmessenger.ymchat.YMChat.KClassImpl$Data$declaredNonStaticMembers$2()
            com.yellowmessenger.ymchat.models.YMBotEventResponse r1 = new com.yellowmessenger.ymchat.models.YMBotEventResponse
            int r2 = com.yellowmessenger.ymchat.R.string.ym_chat_bot_foreground_event
            java.lang.String r2 = r4.getString(r2)
            r1.<init>(r2, r3)
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1)
            super.onStart()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yellowmessenger.ymchat.YellowBotWebviewFragment.onStart():void");
    }

    private final void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        if (getContext() != null) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
            HashMap<String, Object> hashMap = ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.initRecordTimeStamp;
            String str = hashMap != null ? (String) hashMap.get("defaultLanguage") : null;
            if (str == null) {
                str = Locale.getDefault().toString();
            }
            intent.putExtra("android.speech.extra.LANGUAGE", str);
            intent.putExtra("android.speech.extra.LANGUAGE_PREFERENCE", str);
            intent.putExtra("android.speech.extra.ONLY_RETURN_LANGUAGE_PREFERENCE", str);
            intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
            intent.putExtra("android.speech.extra.PARTIAL_RESULTS", true);
            intent.putExtra("android.speech.extra.MAX_RESULTS", 5);
            intent.putExtra("calling_package", requireContext.getPackageName());
            this.FragmentBottomSheetPaymentSettingBinding = SpeechRecognizer.createSpeechRecognizer(requireContext);
            CustomRecognitionListener customRecognitionListener = new CustomRecognitionListener();
            SpeechRecognizer speechRecognizer = this.FragmentBottomSheetPaymentSettingBinding;
            Intrinsics.checkNotNull(speechRecognizer);
            speechRecognizer.setRecognitionListener(customRecognitionListener);
            SpeechRecognizer speechRecognizer2 = this.FragmentBottomSheetPaymentSettingBinding;
            Intrinsics.checkNotNull(speechRecognizer2);
            speechRecognizer2.startListening(intent);
        }
    }

    private final void scheduleImpl() {
        Drawable BuiltInFictitiousFunctionClassFactory;
        Drawable BuiltInFictitiousFunctionClassFactory2;
        if (getContext() == null) {
            return;
        }
        View view = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        View findViewById = view.findViewById(R.id.getErrorConfigVersion_res_0x7f0a1bb8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        View view3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a0770);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        YmMovableFloatingActionButton ymMovableFloatingActionButton = (YmMovableFloatingActionButton) findViewById2;
        View view4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            view2 = view4;
        }
        View findViewById3 = view2.findViewById(R.id.speechTranscription);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        TextView textView = (TextView) findViewById3;
        if (relativeLayout.getVisibility() == 4) {
            textView.setText(R.string.res_0x7f13197b_networkuserentitydata_externalsyntheticlambda2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda3 = false;
            relativeLayout.setVisibility(0);
            NetworkUserEntityData$$ExternalSyntheticLambda0();
            BuiltInFictitiousFunctionClassFactory2 = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(requireContext(), R.drawable.ic_back_button_ym);
            ymMovableFloatingActionButton.setImageDrawable(BuiltInFictitiousFunctionClassFactory2);
            return;
        }
        relativeLayout.setVisibility(4);
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(requireContext(), R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f080a53);
        ymMovableFloatingActionButton.setImageDrawable(BuiltInFictitiousFunctionClassFactory);
        SpeechRecognizer speechRecognizer = this.FragmentBottomSheetPaymentSettingBinding;
        if (speechRecognizer != null) {
            Intrinsics.checkNotNull(speechRecognizer);
            speechRecognizer.stopListening();
        }
    }

    public final void PlaceComponentResult() {
        Drawable BuiltInFictitiousFunctionClassFactory;
        if (getContext() == null) {
            return;
        }
        View view = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        View findViewById = view.findViewById(R.id.getErrorConfigVersion_res_0x7f0a1bb8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById;
        View view3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view3 = null;
        }
        View findViewById2 = view3.findViewById(R.id.BuiltInFictitiousFunctionClassFactory_res_0x7f0a0770);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        YmMovableFloatingActionButton ymMovableFloatingActionButton = (YmMovableFloatingActionButton) findViewById2;
        View view4 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            view2 = view4;
        }
        View findViewById3 = view2.findViewById(R.id.speechTranscription);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        TextView textView = (TextView) findViewById3;
        relativeLayout.setVisibility(4);
        BuiltInFictitiousFunctionClassFactory = ResourceManagerInternal.KClassImpl$Data$declaredNonStaticMembers$2().BuiltInFictitiousFunctionClassFactory(requireContext(), R.drawable.BuiltInFictitiousFunctionClassFactory_res_0x7f080a53);
        ymMovableFloatingActionButton.setImageDrawable(BuiltInFictitiousFunctionClassFactory);
        SpeechRecognizer speechRecognizer = this.FragmentBottomSheetPaymentSettingBinding;
        if (speechRecognizer != null) {
            Intrinsics.checkNotNull(speechRecognizer);
            speechRecognizer.stopListening();
            SpeechRecognizer speechRecognizer2 = this.FragmentBottomSheetPaymentSettingBinding;
            Intrinsics.checkNotNull(speechRecognizer2);
            speechRecognizer2.destroy();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004J\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0012\u0010\u001b\u001a\u00020\u0018X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lcom/yellowmessenger/ymchat/YellowBotWebviewFragment$CustomRecognitionListener;", "Landroid/speech/RecognitionListener;", "", "onBeginningOfSpeech", "()V", "", "p0", "onBufferReceived", "([B)V", "onEndOfSpeech", "", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(I)V", "Landroid/os/Bundle;", "p1", "onEvent", "(ILandroid/os/Bundle;)V", "onPartialResults", "(Landroid/os/Bundle;)V", "onReadyForSpeech", "onResults", "", "onRmsChanged", "(F)V", "", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Lcom/yellowmessenger/ymchat/YellowBotWebviewFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public final class CustomRecognitionListener implements RecognitionListener {

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public boolean KClassImpl$Data$declaredNonStaticMembers$2 = true;

        @Override // android.speech.RecognitionListener
        public final void onBeginningOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public final void onBufferReceived(byte[] p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        @Override // android.speech.RecognitionListener
        public final void onEndOfSpeech() {
        }

        @Override // android.speech.RecognitionListener
        public final void onEvent(int p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p1, "");
        }

        @Override // android.speech.RecognitionListener
        public final void onReadyForSpeech(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
        }

        @Override // android.speech.RecognitionListener
        public final void onRmsChanged(float p0) {
        }

        public CustomRecognitionListener() {
            YellowBotWebviewFragment.this = r1;
        }

        @Override // android.speech.RecognitionListener
        public final void onError(int i) {
            YellowBotWebviewFragment.this.PlaceComponentResult();
            View view = YellowBotWebviewFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                view = null;
            }
            Snackbar make = Snackbar.make(view, "We've encountered an error. Please press Mic to continue with voice input.", 0);
            Intrinsics.checkNotNullExpressionValue(make, "");
            make.show();
        }

        @Override // android.speech.RecognitionListener
        public final void onResults(Bundle p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ArrayList<String> stringArrayList = p0.getStringArrayList("results_recognition");
            View view = YellowBotWebviewFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            WebView webView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                view = null;
            }
            View findViewById = view.findViewById(R.id.speechTranscription);
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            ((TextView) findViewById).setText((stringArrayList == null || stringArrayList.size() <= 0) ? "" : stringArrayList.get(0));
            if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
                if (stringArrayList != null && stringArrayList.size() > 0) {
                    if (YellowBotWebviewFragment.this.FragmentBottomSheetPaymentSettingBinding != null) {
                        SpeechRecognizer speechRecognizer = YellowBotWebviewFragment.this.FragmentBottomSheetPaymentSettingBinding;
                        Intrinsics.checkNotNull(speechRecognizer);
                        speechRecognizer.cancel();
                    }
                    YellowBotWebviewFragment yellowBotWebviewFragment = YellowBotWebviewFragment.this;
                    String str = stringArrayList.get(0);
                    Intrinsics.checkNotNullExpressionValue(str, "");
                    String str2 = str;
                    Intrinsics.checkNotNullParameter(str2, "");
                    WebView webView2 = yellowBotWebviewFragment.initRecordTimeStamp;
                    if (webView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                    } else {
                        webView = webView2;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("javascript:sendEvent(\"");
                    sb.append(str2);
                    sb.append("\");");
                    String obj = sb.toString();
                    InstrumentInjector.trackWebView(webView);
                    webView.loadUrl(obj);
                }
                YellowBotWebviewFragment.this.PlaceComponentResult();
                this.KClassImpl$Data$declaredNonStaticMembers$2 = false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0032  */
        @Override // android.speech.RecognitionListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void onPartialResults(android.os.Bundle r4) {
            /*
                r3 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.lang.String r1 = "results_recognition"
                java.util.ArrayList r2 = r4.getStringArrayList(r1)
                if (r2 == 0) goto L29
                java.util.ArrayList r2 = r4.getStringArrayList(r1)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                int r2 = r2.size()
                if (r2 <= 0) goto L29
                java.util.ArrayList r4 = r4.getStringArrayList(r1)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
                r1 = 0
                java.lang.Object r4 = r4.get(r1)
                java.lang.String r4 = (java.lang.String) r4
                goto L2a
            L29:
                r4 = r0
            L2a:
                com.yellowmessenger.ymchat.YellowBotWebviewFragment r1 = com.yellowmessenger.ymchat.YellowBotWebviewFragment.this
                android.view.View r1 = com.yellowmessenger.ymchat.YellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(r1)
                if (r1 != 0) goto L36
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                r1 = 0
            L36:
                int r2 = com.yellowmessenger.ymchat.R.id.speechTranscription
                android.view.View r1 = r1.findViewById(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                android.widget.TextView r1 = (android.widget.TextView) r1
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                r1.setText(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yellowmessenger.ymchat.YellowBotWebviewFragment.CustomRecognitionListener.onPartialResults(android.os.Bundle):void");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 && (this.moveToNextValue || ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.MyBillsEntityDataFactory)) {
            OkHttpClient okHttpClient = new OkHttpClient();
            StringBuilder sb = new StringBuilder();
            sb.append(ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("/api/presence/usersPresence/log_user_profile");
            String obj = sb.toString();
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 != null) {
                FormBody.Builder builder = new FormBody.Builder(null, 1, null);
                String str = this.NetworkUserEntityData$$ExternalSyntheticLambda4;
                Intrinsics.checkNotNull(str);
                FormBody.Builder add = builder.add("user", str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("bot_");
                sb2.append(ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
                FirebasePerfOkHttpClient.enqueue(okHttpClient.newCall(new Request.Builder().url(obj).post(add.add("resource", sb2.toString()).add("status", "offline").build()).build()), new Callback() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$updateAgentStatus$1
                    @Override // okhttp3.Callback
                    public final void onResponse(Call p0, Response p1) throws IOException {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                    }

                    @Override // okhttp3.Callback
                    public final void onFailure(Call p0, IOException p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        Intrinsics.checkNotNullParameter(p1, "");
                        p0.cancel();
                    }
                });
            }
        }
        if (!this.scheduleImpl) {
            YMChat.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(new YMBotEventResponse(getString(R.string.ym_chat_bot_background_event), ""));
        }
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        YMChat.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2((BotEventListener) null);
        super.onDestroy();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/yellowmessenger/ymchat/YellowBotWebviewFragment$Companion;", "", "Lcom/yellowmessenger/ymchat/YellowBotWebviewFragment;", "BuiltInFictitiousFunctionClassFactory", "()Lcom/yellowmessenger/ymchat/YellowBotWebviewFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static YellowBotWebviewFragment BuiltInFictitiousFunctionClassFactory() {
            return new YellowBotWebviewFragment();
        }
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String[] p1) {
        for (String str : p1) {
            if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(p0, str) == 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        yellowBotWebviewFragment.getErrorConfigVersion();
        yellowBotWebviewFragment.lookAheadTest();
    }

    public static /* synthetic */ void PlaceComponentResult(YellowBotWebviewFragment yellowBotWebviewFragment, boolean z) {
        GeolocationPermissions.Callback callback;
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        if (TextUtils.isEmpty(yellowBotWebviewFragment.isLayoutRequested)) {
            return;
        }
        View view = null;
        if (Intrinsics.areEqual(yellowBotWebviewFragment.isLayoutRequested, "android.permission.CAMERA")) {
            if (z) {
                yellowBotWebviewFragment.KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            ValueCallback<Uri[]> valueCallback = yellowBotWebviewFragment.DatabaseTableConfigUtil;
            if (valueCallback != null) {
                Intrinsics.checkNotNull(valueCallback);
                valueCallback.onReceiveValue(null);
                yellowBotWebviewFragment.DatabaseTableConfigUtil = null;
            }
            if (yellowBotWebviewFragment.getContext() != null) {
                Context requireContext = yellowBotWebviewFragment.requireContext();
                View view2 = yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    view = view2;
                }
                YmHelper.getAuthRequestContext(requireContext, view, yellowBotWebviewFragment.getString(R.string.ym_message_camera_permission));
            }
        } else if (!Intrinsics.areEqual(yellowBotWebviewFragment.isLayoutRequested, "android.permission.ACCESS_FINE_LOCATION")) {
            if (!Intrinsics.areEqual(yellowBotWebviewFragment.isLayoutRequested, ManifestPermission.RECORD_AUDIO)) {
                ValueCallback<Uri[]> valueCallback2 = yellowBotWebviewFragment.DatabaseTableConfigUtil;
                if (valueCallback2 != null) {
                    Intrinsics.checkNotNull(valueCallback2);
                    valueCallback2.onReceiveValue(null);
                    yellowBotWebviewFragment.DatabaseTableConfigUtil = null;
                }
            } else if (z) {
                yellowBotWebviewFragment.scheduleImpl();
            } else {
                Context requireContext2 = yellowBotWebviewFragment.requireContext();
                View view3 = yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    view = view3;
                }
                YmHelper.getAuthRequestContext(requireContext2, view, yellowBotWebviewFragment.getString(R.string.res_0x7f131979_networkuserentitydata_externalsyntheticlambda0));
            }
        } else if (z && (callback = yellowBotWebviewFragment.MyBillsEntityDataFactory) != null && yellowBotWebviewFragment.getAuthRequestContext != null) {
            Intrinsics.checkNotNull(callback);
            callback.invoke(yellowBotWebviewFragment.getAuthRequestContext, true, false);
            yellowBotWebviewFragment.MyBillsEntityDataFactory = null;
            yellowBotWebviewFragment.getAuthRequestContext = null;
        } else {
            GeolocationPermissions.Callback callback2 = yellowBotWebviewFragment.MyBillsEntityDataFactory;
            if (callback2 != null && yellowBotWebviewFragment.getAuthRequestContext != null) {
                Intrinsics.checkNotNull(callback2);
                callback2.invoke(yellowBotWebviewFragment.getAuthRequestContext, false, false);
            }
            yellowBotWebviewFragment.MyBillsEntityDataFactory = null;
            yellowBotWebviewFragment.getAuthRequestContext = null;
            if (yellowBotWebviewFragment.getContext() != null) {
                Context requireContext3 = yellowBotWebviewFragment.requireContext();
                View view4 = yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    view = view4;
                }
                YmHelper.getAuthRequestContext(requireContext3, view, yellowBotWebviewFragment.getString(R.string.ym_message_location_permission));
            }
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment yellowBotWebviewFragment) {
        ValueCallback<Uri[]> valueCallback;
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        if (yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 || (valueCallback = yellowBotWebviewFragment.DatabaseTableConfigUtil) == null) {
            return;
        }
        Intrinsics.checkNotNull(valueCallback);
        valueCallback.onReceiveValue(null);
        yellowBotWebviewFragment.DatabaseTableConfigUtil = null;
    }

    public static /* synthetic */ void PlaceComponentResult(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        yellowBotWebviewFragment.lookAheadTest = true;
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        yellowBotWebviewFragment.lookAheadTest = false;
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment yellowBotWebviewFragment, Map map) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        boolean containsKey = map.containsKey("android.permission.READ_MEDIA_IMAGES");
        Boolean bool = Boolean.TRUE;
        if ((containsKey && Intrinsics.areEqual(map.get("android.permission.READ_MEDIA_IMAGES"), bool)) || ((map.containsKey("android.permission.READ_MEDIA_VIDEO") && Intrinsics.areEqual(map.get("android.permission.READ_MEDIA_VIDEO"), bool)) || ((map.containsKey("android.permission.READ_MEDIA_AUDIO") && Intrinsics.areEqual(map.get("android.permission.READ_MEDIA_AUDIO"), bool)) || (map.containsKey("android.permission.READ_EXTERNAL_STORAGE") && Intrinsics.areEqual(map.get("android.permission.READ_EXTERNAL_STORAGE"), bool))))) {
            yellowBotWebviewFragment.BuiltInFictitiousFunctionClassFactory();
            return;
        }
        ValueCallback<Uri[]> valueCallback = yellowBotWebviewFragment.DatabaseTableConfigUtil;
        View view = null;
        if (valueCallback != null) {
            Intrinsics.checkNotNull(valueCallback);
            valueCallback.onReceiveValue(null);
            yellowBotWebviewFragment.DatabaseTableConfigUtil = null;
        }
        if (yellowBotWebviewFragment.getContext() != null) {
            Context requireContext = yellowBotWebviewFragment.requireContext();
            View view2 = yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                view = view2;
            }
            YmHelper.getAuthRequestContext(requireContext, view, yellowBotWebviewFragment.getString(R.string.ym_message_storgae_permission));
        }
    }

    public static /* synthetic */ void getAuthRequestContext(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        YMChat.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(new YMBotEventResponse("bot-closed", ""));
        if (yellowBotWebviewFragment.getActivity() instanceof YellowBotWebViewActivity) {
            try {
                yellowBotWebviewFragment.requireActivity().runOnUiThread(new YellowBotWebviewFragment$$ExternalSyntheticLambda17(yellowBotWebviewFragment));
            } catch (Exception unused) {
            }
            FragmentActivity activity = yellowBotWebviewFragment.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            yellowBotWebviewFragment.scheduleImpl = true;
        }
    }

    public static /* synthetic */ void scheduleImpl(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        WebView webView = yellowBotWebviewFragment.initRecordTimeStamp;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView = null;
        }
        webView.reload();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0029, code lost:
    
        if (r2.BuiltInFictitiousFunctionClassFactory(r1) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(com.yellowmessenger.ymchat.YellowBotWebviewFragment r2, com.google.android.material.bottomsheet.BottomSheetDialog r3) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r1 = 1
            r2.NetworkUserEntityData$$ExternalSyntheticLambda0 = r1
            android.content.Context r1 = r2.getContext()
            if (r1 == 0) goto L2e
            android.content.Context r1 = r2.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            boolean r1 = moveToNextValue(r1)
            if (r1 == 0) goto L2b
            android.content.Context r1 = r2.requireContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            boolean r0 = r2.BuiltInFictitiousFunctionClassFactory(r1)
            if (r0 == 0) goto L2e
        L2b:
            r2.KClassImpl$Data$declaredNonStaticMembers$2()
        L2e:
            r3.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yellowmessenger.ymchat.YellowBotWebviewFragment.BuiltInFictitiousFunctionClassFactory(com.yellowmessenger.ymchat.YellowBotWebviewFragment, com.google.android.material.bottomsheet.BottomSheetDialog):void");
    }

    public static /* synthetic */ void lookAheadTest(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        YmMovableFloatingActionButton ymMovableFloatingActionButton = yellowBotWebviewFragment.GetContactSyncConfig;
        ImageView imageView = null;
        if (ymMovableFloatingActionButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            ymMovableFloatingActionButton = null;
        }
        ymMovableFloatingActionButton.hide();
        ImageView imageView2 = yellowBotWebviewFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        yellowBotWebviewFragment.moveToNextValue = true;
    }

    public static /* synthetic */ void moveToNextValue(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        Rect rect = new Rect();
        View view = yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        YmMovableFloatingActionButton ymMovableFloatingActionButton = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view = null;
        }
        view.getWindowVisibleDisplayFrame(rect);
        View view2 = yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            view2 = null;
        }
        int height = view2.getRootView().getHeight();
        double d = height - rect.bottom;
        double d2 = height;
        Double.isNaN(d2);
        if (d <= d2 * 0.15d) {
            yellowBotWebviewFragment.lookAheadTest();
            return;
        }
        YmMovableFloatingActionButton ymMovableFloatingActionButton2 = yellowBotWebviewFragment.GetContactSyncConfig;
        if (ymMovableFloatingActionButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            ymMovableFloatingActionButton = ymMovableFloatingActionButton2;
        }
        ymMovableFloatingActionButton.hide();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment yellowBotWebviewFragment, final YMBotEventResponse yMBotEventResponse) {
        String str;
        FragmentActivity activity;
        FragmentActivity activity2;
        FragmentActivity activity3;
        FragmentActivity activity4;
        FragmentActivity activity5;
        FragmentActivity activity6;
        FragmentActivity activity7;
        FragmentActivity activity8;
        Map map;
        String str2;
        FragmentActivity activity9;
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        Intrinsics.checkNotNullParameter(yMBotEventResponse, "");
        if (yMBotEventResponse.PlaceComponentResult == null || (str = yMBotEventResponse.PlaceComponentResult) == null) {
            return;
        }
        try {
            switch (str.hashCode()) {
                case -1504632187:
                    if (!str.equals("agent-ticket-closed") || (activity = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda6
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.getErrorConfigVersion(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                case -1247543405:
                    if (!str.equals("reload-bot") || (activity2 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity2.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda9
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.scheduleImpl(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                case -1140951522:
                    if (!str.equals("image-closed") || (activity3 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity3.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda3
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.BuiltInFictitiousFunctionClassFactory(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                case -794010341:
                    if (!str.equals("image-opened") || (activity4 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity4.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.lookAheadTest(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                case -483650446:
                    if (!str.equals("close-bot") || (activity5 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity5.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.DatabaseTableConfigUtil(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                case 1190067162:
                    if (!str.equals("disable-multi-upload") || (activity6 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity6.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda8
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.MyBillsEntityDataFactory(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                case 1191117077:
                    if (!str.equals("multi-upload") || (activity7 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity7.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda7
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.PlaceComponentResult(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                case 1243098783:
                    if (!str.equals("yellowai-uid") || (activity8 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity8.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda4
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.BuiltInFictitiousFunctionClassFactory(YellowBotWebviewFragment.this, yMBotEventResponse);
                        }
                    });
                    return;
                case 1508673167:
                    if (str.equals("upload-image") && (map = (Map) new Gson().fromJson(yMBotEventResponse.getAuthRequestContext, new TypeToken<HashMap<String, Object>>() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$onCreate$1$retMap$1
                    }.getType())) != null && map.containsKey("uid") && (map.get("uid") instanceof String) && (str2 = (String) map.get("uid")) != null) {
                        try {
                            String str3 = ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.BuiltInFictitiousFunctionClassFactory;
                            StringBuilder sb = new StringBuilder();
                            sb.append(yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda7);
                            sb.append(str3);
                            sb.append("&uid=");
                            sb.append(str2);
                            sb.append("&secure=false");
                            yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda7 = sb.toString();
                            OkHttpClient okHttpClient = new OkHttpClient();
                            String str4 = ConfigService.MyBillsEntityDataFactory().MyBillsEntityDataFactory.get("imagePath");
                            if (str4 != null) {
                                if (str4.length() == 0) {
                                    return;
                                }
                                File file = new File(str4);
                                FirebasePerfOkHttpClient.enqueue(okHttpClient.newCall(new Request.Builder().url(yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda7).post(new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM).addFormDataPart("images", file.getName(), RequestBody.Companion.create(StringsKt.endsWith$default(str4, APImageFormat.SUFFIX_PNG, false, 2, (Object) null) ? MediaType.Companion.parse("image/png") : MediaType.Companion.parse("image/jpeg"), file)).build()).build()), new Callback() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$run$1
                                    @Override // okhttp3.Callback
                                    public final void onResponse(Call p0, Response p1) throws IOException {
                                        Intrinsics.checkNotNullParameter(p0, "");
                                        Intrinsics.checkNotNullParameter(p1, "");
                                    }

                                    @Override // okhttp3.Callback
                                    public final void onFailure(Call p0, IOException p1) {
                                        Intrinsics.checkNotNullParameter(p0, "");
                                        Intrinsics.checkNotNullParameter(p1, "");
                                        p0.cancel();
                                    }
                                });
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    return;
                case 1979084624:
                    if (!str.equals("agent-ticket-connected") || (activity9 = yellowBotWebviewFragment.getActivity()) == null) {
                        return;
                    }
                    activity9.runOnUiThread(new Runnable() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda5
                        @Override // java.lang.Runnable
                        public final void run() {
                            YellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(YellowBotWebviewFragment.this);
                        }
                    });
                    return;
                default:
                    return;
            }
        } catch (Exception unused2) {
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment yellowBotWebviewFragment, BottomSheetDialog bottomSheetDialog) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "");
        yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        if (yellowBotWebviewFragment.getContext() != null) {
            Context requireContext = yellowBotWebviewFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "");
            if (yellowBotWebviewFragment.PlaceComponentResult(requireContext)) {
                yellowBotWebviewFragment.BuiltInFictitiousFunctionClassFactory();
            }
        }
        bottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void getErrorConfigVersion(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        yellowBotWebviewFragment.moveToNextValue = false;
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(YellowBotWebviewFragment yellowBotWebviewFragment, YMBotEventResponse yMBotEventResponse) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        Intrinsics.checkNotNullParameter(yMBotEventResponse, "");
        yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = yMBotEventResponse.getAuthRequestContext;
    }

    public static /* synthetic */ void initRecordTimeStamp(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        WebView webView = yellowBotWebviewFragment.initRecordTimeStamp;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            webView = null;
        }
        InstrumentInjector.trackWebView(webView);
        webView.loadUrl("");
    }

    public static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda1(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        View view = null;
        if (!yellowBotWebviewFragment.getErrorConfigVersion) {
            View view2 = yellowBotWebviewFragment.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                view = view2;
            }
            YmHelper.BuiltInFictitiousFunctionClassFactory(view, yellowBotWebviewFragment.getString(R.string.ym_declare_audio_permission));
        } else if (ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(yellowBotWebviewFragment.requireContext(), ManifestPermission.RECORD_AUDIO) == 0) {
            yellowBotWebviewFragment.scheduleImpl();
        } else {
            yellowBotWebviewFragment.isLayoutRequested = ManifestPermission.RECORD_AUDIO;
            yellowBotWebviewFragment.PrepareContext.MyBillsEntityDataFactory(ManifestPermission.RECORD_AUDIO, null);
        }
    }

    public static /* synthetic */ void DatabaseTableConfigUtil(YellowBotWebviewFragment yellowBotWebviewFragment) {
        Intrinsics.checkNotNullParameter(yellowBotWebviewFragment, "");
        YMChat.KClassImpl$Data$declaredNonStaticMembers$2().KClassImpl$Data$declaredNonStaticMembers$2(new YMBotEventResponse("bot-closed", ""));
        if (yellowBotWebviewFragment.getActivity() instanceof YellowBotWebViewActivity) {
            try {
                yellowBotWebviewFragment.requireActivity().runOnUiThread(new YellowBotWebviewFragment$$ExternalSyntheticLambda17(yellowBotWebviewFragment));
            } catch (Exception unused) {
            }
            FragmentActivity activity = yellowBotWebviewFragment.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
            yellowBotWebviewFragment.scheduleImpl = true;
        }
    }

    public static final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda7(YellowBotWebviewFragment yellowBotWebviewFragment) {
        if (ConfigService.MyBillsEntityDataFactory().PlaceComponentResult.GetContactSyncConfig || yellowBotWebviewFragment.getLookAheadTest()) {
            Context context = yellowBotWebviewFragment.getContext();
            if (context != null && yellowBotWebviewFragment.PlaceComponentResult(context)) {
                yellowBotWebviewFragment.BuiltInFictitiousFunctionClassFactory();
            }
        } else if (yellowBotWebviewFragment.getContext() != null) {
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(yellowBotWebviewFragment.requireContext());
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_attachment);
            LinearLayout linearLayout = (LinearLayout) bottomSheetDialog.findViewById(R.id.MyBillsEntityDataFactory_res_0x7f0a0276);
            LinearLayout linearLayout2 = (LinearLayout) bottomSheetDialog.findViewById(R.id.res_0x7f0a06f4_kclassimpl_data_declarednonstaticmembers_2);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YellowBotWebviewFragment.BuiltInFictitiousFunctionClassFactory(YellowBotWebviewFragment.this, bottomSheetDialog);
                    }
                });
            }
            if (linearLayout2 != null) {
                linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda10
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        YellowBotWebviewFragment.KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment.this, bottomSheetDialog);
                    }
                });
            }
            bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.yellowmessenger.ymchat.YellowBotWebviewFragment$$ExternalSyntheticLambda11
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    YellowBotWebviewFragment.KClassImpl$Data$declaredNonStaticMembers$2(YellowBotWebviewFragment.this);
                }
            });
            bottomSheetDialog.show();
        }
    }
}
