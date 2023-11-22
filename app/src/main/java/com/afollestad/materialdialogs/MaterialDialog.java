package com.afollestad.materialdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.actions.DialogActionExtKt;
import com.afollestad.materialdialogs.callbacks.DialogCallbackExtKt;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.list.DialogAdapter;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.list.DialogListExtKt;
import com.afollestad.materialdialogs.message.DialogMessageSettings;
import com.afollestad.materialdialogs.utils.ColorsKt;
import com.afollestad.materialdialogs.utils.DialogsKt;
import com.afollestad.materialdialogs.utils.FontsKt;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.afollestad.materialdialogs.utils.ViewsKt;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.domain.expresspurchase.interaction.SaveLastActionToPreference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 }2\u00020\u0001:\u0001}B\u0019\u0012\u0006\u0010w\u001a\u00020v\u0012\b\b\u0002\u0010`\u001a\u00020_¢\u0006\u0004\b{\u0010|J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\t\u0010\u0007J\u001b\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001d\u0010\u0018J%\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001f\u0010 JB\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u001b\b\u0002\u0010&\u001a\u0015\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u0016\u0018\u00010#¢\u0006\u0002\b%¢\u0006\u0004\b'\u0010(JC\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u001c\b\u0002\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0016\u0018\u00010#j\u0004\u0018\u0001`)¢\u0006\u0004\b+\u0010(JE\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u001c\b\u0002\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0016\u0018\u00010#j\u0004\u0018\u0001`)H\u0007¢\u0006\u0004\b,\u0010(J\r\u0010-\u001a\u00020\u0000¢\u0006\u0004\b-\u0010\u0007J\u0017\u00100\u001a\u00020\u00162\u0006\u0010/\u001a\u00020.H\u0000¢\u0006\u0004\b0\u00101JC\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!2\u001c\b\u0002\u0010*\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0016\u0018\u00010#j\u0004\u0018\u0001`)¢\u0006\u0004\b2\u0010(J\u0017\u00103\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b3\u00104J\u0017\u00105\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0002H\u0017¢\u0006\u0004\b5\u00104J\u000f\u00106\u001a\u00020\u0016H\u0002¢\u0006\u0004\b6\u0010\u0018J\u000f\u00107\u001a\u00020\u0016H\u0016¢\u0006\u0004\b7\u0010\u0018J+\u00107\u001a\u00020\u00002\u0019\u00108\u001a\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0016\u0018\u00010#¢\u0006\u0002\b%H\u0086\b¢\u0006\u0004\b7\u00109J%\u0010:\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b:\u0010;R*\u0010=\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00028\u0007@AX\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u00104R.\u0010C\u001a\u0004\u0018\u00010B2\b\u0010<\u001a\u0004\u0018\u00010B8\u0007@AX\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010I\u001a\u0004\u0018\u00010B2\b\u0010<\u001a\u0004\u0018\u00010B8\u0007@AX\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR0\u0010M\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160#j\u0002`)0L8\u0001X\u0081\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR*\u0010\u0004\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00028\u0007@AX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010>\u001a\u0004\bQ\u0010@\"\u0004\bR\u00104R*\u0010\u0003\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00028\u0007@AX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010>\u001a\u0004\bS\u0010@\"\u0004\bT\u00104R&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020V0U8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010W\u001a\u0004\bX\u0010YR.\u0010\u0013\u001a\u0004\u0018\u00010\u000f2\b\u0010<\u001a\u0004\u0018\u00010\u000f8\u0007@AX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u001a\u0010`\u001a\u00020_8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bb\u0010cR0\u0010d\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160#j\u0002`)0L8\u0001X\u0081\u0004¢\u0006\f\n\u0004\bd\u0010N\u001a\u0004\be\u0010PR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010fR*\u0010g\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160#j\u0002`)0L8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bg\u0010NR*\u0010h\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160#j\u0002`)0L8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bh\u0010NR*\u0010i\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160#j\u0002`)0L8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\bi\u0010NR0\u0010j\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160#j\u0002`)0L8\u0001X\u0081\u0004¢\u0006\f\n\u0004\bj\u0010N\u001a\u0004\bk\u0010PR0\u0010l\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00160#j\u0002`)0L8\u0001X\u0081\u0004¢\u0006\f\n\u0004\bl\u0010N\u001a\u0004\bm\u0010PR.\u0010n\u001a\u0004\u0018\u00010B2\b\u0010<\u001a\u0004\u0018\u00010B8\u0007@AX\u0087\u000e¢\u0006\u0012\n\u0004\bn\u0010D\u001a\u0004\bo\u0010F\"\u0004\bp\u0010HR\u001a\u0010r\u001a\u00020q8\u0007X\u0087\u0004¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001a\u0010w\u001a\u00020v8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010z"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog;", "Landroid/app/Dialog;", "", "cancelable", "cancelOnTouchOutside", "(Z)Lcom/afollestad/materialdialogs/MaterialDialog;", "clearNegativeListeners", "()Lcom/afollestad/materialdialogs/MaterialDialog;", "clearNeutralListeners", "clearPositiveListeners", "T", "", "key", "config", "(Ljava/lang/String;)Ljava/lang/Object;", "", "literalDp", "", "res", CdpConstants.CONTENT_CORNER_RADIUS, "(Ljava/lang/Float;Ljava/lang/Integer;)Lcom/afollestad/materialdialogs/MaterialDialog;", "debugMode", "", SaveLastActionToPreference.DISMISS_EP, "()V", "Landroid/graphics/drawable/Drawable;", "drawable", "icon", "(Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Lcom/afollestad/materialdialogs/MaterialDialog;", "invalidateBackgroundColorAndRadius", "literal", "maxWidth", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/afollestad/materialdialogs/MaterialDialog;", "", "text", "Lkotlin/Function1;", "Lcom/afollestad/materialdialogs/message/DialogMessageSettings;", "Lkotlin/ExtensionFunctionType;", "applySettings", "message", "(Ljava/lang/Integer;Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Lcom/afollestad/materialdialogs/MaterialDialog;", "Lcom/afollestad/materialdialogs/DialogCallback;", DynamicLayerModel.TYPE_CLICK, "negativeButton", "neutralButton", "noAutoDismiss", "Lcom/afollestad/materialdialogs/WhichButton;", "which", "onActionButtonClicked$core", "(Lcom/afollestad/materialdialogs/WhichButton;)V", "positiveButton", "setCancelable", "(Z)V", "setCanceledOnTouchOutside", "setWindowConstraints", ContainerUIProvider.KEY_SHOW, "func", "(Lkotlin/jvm/functions/Function1;)Lcom/afollestad/materialdialogs/MaterialDialog;", "title", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/afollestad/materialdialogs/MaterialDialog;", "<set-?>", "autoDismissEnabled", "Z", "getAutoDismissEnabled", "()Z", "setAutoDismissEnabled$core", "Landroid/graphics/Typeface;", "bodyFont", "Landroid/graphics/Typeface;", "getBodyFont", "()Landroid/graphics/Typeface;", "setBodyFont$core", "(Landroid/graphics/Typeface;)V", "buttonFont", "getButtonFont", "setButtonFont$core", "", "cancelListeners", "Ljava/util/List;", "getCancelListeners$core", "()Ljava/util/List;", "getCancelOnTouchOutside", "setCancelOnTouchOutside$core", "getCancelable", "setCancelable$core", "", "", "Ljava/util/Map;", "getConfig", "()Ljava/util/Map;", "Ljava/lang/Float;", "getCornerRadius", "()Ljava/lang/Float;", "setCornerRadius$core", "(Ljava/lang/Float;)V", "Lcom/afollestad/materialdialogs/DialogBehavior;", "dialogBehavior", "Lcom/afollestad/materialdialogs/DialogBehavior;", "getDialogBehavior", "()Lcom/afollestad/materialdialogs/DialogBehavior;", "dismissListeners", "getDismissListeners$core", "Ljava/lang/Integer;", "negativeListeners", "neutralListeners", "positiveListeners", "preShowListeners", "getPreShowListeners$core", "showListeners", "getShowListeners$core", "titleFont", "getTitleFont", "setTitleFont$core", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "view", "Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "getView", "()Lcom/afollestad/materialdialogs/internal/main/DialogLayout;", "Landroid/content/Context;", "windowContext", "Landroid/content/Context;", "getWindowContext", "()Landroid/content/Context;", "<init>", "(Landroid/content/Context;Lcom/afollestad/materialdialogs/DialogBehavior;)V", "Companion"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes2.dex */
public final class MaterialDialog extends Dialog {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static DialogBehavior DEFAULT_BEHAVIOR = ModalDialog.INSTANCE;
    private boolean autoDismissEnabled;
    private Typeface bodyFont;
    private Typeface buttonFont;
    private final List<Function1<MaterialDialog, Unit>> cancelListeners;
    private boolean cancelOnTouchOutside;
    private boolean cancelable;
    private final Map<String, Object> config;
    private Float cornerRadius;
    private final DialogBehavior dialogBehavior;
    private final List<Function1<MaterialDialog, Unit>> dismissListeners;
    private Integer maxWidth;
    private final List<Function1<MaterialDialog, Unit>> negativeListeners;
    private final List<Function1<MaterialDialog, Unit>> neutralListeners;
    private final List<Function1<MaterialDialog, Unit>> positiveListeners;
    private final List<Function1<MaterialDialog, Unit>> preShowListeners;
    private final List<Function1<MaterialDialog, Unit>> showListeners;
    private Typeface titleFont;
    private final DialogLayout view;
    private final Context windowContext;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 8, 0})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WhichButton.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[WhichButton.POSITIVE.ordinal()] = 1;
            iArr[WhichButton.NEGATIVE.ordinal()] = 2;
            iArr[WhichButton.NEUTRAL.ordinal()] = 3;
        }
    }

    public static final DialogBehavior getDEFAULT_BEHAVIOR() {
        return DEFAULT_BEHAVIOR;
    }

    public static final void setDEFAULT_BEHAVIOR(DialogBehavior dialogBehavior) {
        DEFAULT_BEHAVIOR = dialogBehavior;
    }

    @JvmName(name = "getWindowContext")
    public final Context getWindowContext() {
        return this.windowContext;
    }

    public /* synthetic */ MaterialDialog(Context context, DialogBehavior dialogBehavior, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? DEFAULT_BEHAVIOR : dialogBehavior);
    }

    @JvmName(name = "getDialogBehavior")
    public final DialogBehavior getDialogBehavior() {
        return this.dialogBehavior;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialDialog(Context context, DialogBehavior dialogBehavior) {
        super(context, ThemeKt.inferTheme(context, dialogBehavior));
        Intrinsics.checkParameterIsNotNull(context, "");
        Intrinsics.checkParameterIsNotNull(dialogBehavior, "");
        this.windowContext = context;
        this.dialogBehavior = dialogBehavior;
        this.config = new LinkedHashMap();
        this.autoDismissEnabled = true;
        this.cancelOnTouchOutside = true;
        this.cancelable = true;
        this.preShowListeners = new ArrayList();
        this.showListeners = new ArrayList();
        this.dismissListeners = new ArrayList();
        this.cancelListeners = new ArrayList();
        this.positiveListeners = new ArrayList();
        this.negativeListeners = new ArrayList();
        this.neutralListeners = new ArrayList();
        LayoutInflater from = LayoutInflater.from(context);
        Window window = getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window, "");
        Intrinsics.checkExpressionValueIsNotNull(from, "");
        ViewGroup createView = dialogBehavior.createView(context, window, from, this);
        setContentView(createView);
        DialogLayout dialogLayout = dialogBehavior.getDialogLayout(createView);
        dialogLayout.attachDialog(this);
        this.view = dialogLayout;
        this.titleFont = FontsKt.font$default(this, null, Integer.valueOf(R.attr.md_font_title), 1, null);
        this.bodyFont = FontsKt.font$default(this, null, Integer.valueOf(R.attr.md_font_body), 1, null);
        this.buttonFont = FontsKt.font$default(this, null, Integer.valueOf(R.attr.md_font_button), 1, null);
        invalidateBackgroundColorAndRadius();
    }

    @JvmName(name = "getConfig")
    public final Map<String, Object> getConfig() {
        return this.config;
    }

    public final <T> T config(String key) {
        Intrinsics.checkParameterIsNotNull(key, "");
        return (T) this.config.get(key);
    }

    @JvmName(name = "getAutoDismissEnabled")
    public final boolean getAutoDismissEnabled() {
        return this.autoDismissEnabled;
    }

    @JvmName(name = "setAutoDismissEnabled$core")
    public final void setAutoDismissEnabled$core(boolean z) {
        this.autoDismissEnabled = z;
    }

    @JvmName(name = "getTitleFont")
    public final Typeface getTitleFont() {
        return this.titleFont;
    }

    @JvmName(name = "setTitleFont$core")
    public final void setTitleFont$core(Typeface typeface) {
        this.titleFont = typeface;
    }

    @JvmName(name = "getBodyFont")
    public final Typeface getBodyFont() {
        return this.bodyFont;
    }

    @JvmName(name = "setBodyFont$core")
    public final void setBodyFont$core(Typeface typeface) {
        this.bodyFont = typeface;
    }

    @JvmName(name = "getButtonFont")
    public final Typeface getButtonFont() {
        return this.buttonFont;
    }

    @JvmName(name = "setButtonFont$core")
    public final void setButtonFont$core(Typeface typeface) {
        this.buttonFont = typeface;
    }

    @JvmName(name = "getCancelOnTouchOutside")
    public final boolean getCancelOnTouchOutside() {
        return this.cancelOnTouchOutside;
    }

    @JvmName(name = "setCancelOnTouchOutside$core")
    public final void setCancelOnTouchOutside$core(boolean z) {
        this.cancelOnTouchOutside = z;
    }

    @JvmName(name = "getCancelable")
    public final boolean getCancelable() {
        return this.cancelable;
    }

    @JvmName(name = "setCancelable$core")
    public final void setCancelable$core(boolean z) {
        this.cancelable = z;
    }

    @JvmName(name = "getCornerRadius")
    public final Float getCornerRadius() {
        return this.cornerRadius;
    }

    @JvmName(name = "setCornerRadius$core")
    public final void setCornerRadius$core(Float f) {
        this.cornerRadius = f;
    }

    @JvmName(name = "getView")
    public final DialogLayout getView() {
        return this.view;
    }

    @JvmName(name = "getPreShowListeners$core")
    public final List<Function1<MaterialDialog, Unit>> getPreShowListeners$core() {
        return this.preShowListeners;
    }

    @JvmName(name = "getShowListeners$core")
    public final List<Function1<MaterialDialog, Unit>> getShowListeners$core() {
        return this.showListeners;
    }

    @JvmName(name = "getDismissListeners$core")
    public final List<Function1<MaterialDialog, Unit>> getDismissListeners$core() {
        return this.dismissListeners;
    }

    @JvmName(name = "getCancelListeners$core")
    public final List<Function1<MaterialDialog, Unit>> getCancelListeners$core() {
        return this.cancelListeners;
    }

    public static /* synthetic */ MaterialDialog icon$default(MaterialDialog materialDialog, Integer num, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            drawable = null;
        }
        return materialDialog.icon(num, drawable);
    }

    public final MaterialDialog icon(Integer res, Drawable drawable) {
        MDUtil.INSTANCE.assertOneSet("icon", drawable, res);
        DialogsKt.populateIcon(this, this.view.getTitleLayout().getIconView$core(), res, drawable);
        return this;
    }

    public static /* synthetic */ MaterialDialog title$default(MaterialDialog materialDialog, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return materialDialog.title(num, str);
    }

    public final MaterialDialog title(Integer res, String text) {
        MDUtil.INSTANCE.assertOneSet("title", text, res);
        DialogsKt.populateText$default(this, this.view.getTitleLayout().getTitleView$core(), res, text, 0, this.titleFont, Integer.valueOf(R.attr.md_color_title), 8, null);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaterialDialog message$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return materialDialog.message(num, charSequence, function1);
    }

    public final MaterialDialog message(Integer res, CharSequence text, Function1<? super DialogMessageSettings, Unit> applySettings) {
        MDUtil.INSTANCE.assertOneSet("message", text, res);
        this.view.getContentLayout().setMessage(this, res, text, this.bodyFont, applySettings);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaterialDialog positiveButton$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return materialDialog.positiveButton(num, charSequence, function1);
    }

    public final MaterialDialog positiveButton(Integer res, CharSequence text, Function1<? super MaterialDialog, Unit> click) {
        if (click != null) {
            this.positiveListeners.add(click);
        }
        DialogActionButton actionButton = DialogActionExtKt.getActionButton(this, WhichButton.POSITIVE);
        if (res == null && text == null && ViewsKt.isVisible(actionButton)) {
            return this;
        }
        DialogsKt.populateText$default(this, actionButton, res, text, 17039370, this.buttonFont, null, 32, null);
        return this;
    }

    public final MaterialDialog clearPositiveListeners() {
        this.positiveListeners.clear();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaterialDialog negativeButton$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return materialDialog.negativeButton(num, charSequence, function1);
    }

    public final MaterialDialog negativeButton(Integer res, CharSequence text, Function1<? super MaterialDialog, Unit> click) {
        if (click != null) {
            this.negativeListeners.add(click);
        }
        DialogActionButton actionButton = DialogActionExtKt.getActionButton(this, WhichButton.NEGATIVE);
        if (res != null || text != null || !ViewsKt.isVisible(actionButton)) {
            DialogsKt.populateText$default(this, actionButton, res, text, 17039360, this.buttonFont, null, 32, null);
        }
        return this;
    }

    public final MaterialDialog clearNegativeListeners() {
        this.negativeListeners.clear();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaterialDialog neutralButton$default(MaterialDialog materialDialog, Integer num, CharSequence charSequence, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            charSequence = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        return materialDialog.neutralButton(num, charSequence, function1);
    }

    @Deprecated(message = "Use of neutral buttons is discouraged, see https://material.io/design/components/dialogs.html#actions.")
    public final MaterialDialog neutralButton(Integer res, CharSequence text, Function1<? super MaterialDialog, Unit> click) {
        if (click != null) {
            this.neutralListeners.add(click);
        }
        DialogActionButton actionButton = DialogActionExtKt.getActionButton(this, WhichButton.NEUTRAL);
        if (res != null || text != null || !ViewsKt.isVisible(actionButton)) {
            DialogsKt.populateText$default(this, actionButton, res, text, 0, this.buttonFont, null, 40, null);
        }
        return this;
    }

    @Deprecated(message = "Use of neutral buttons is discouraged, see https://material.io/design/components/dialogs.html#actions.")
    public final MaterialDialog clearNeutralListeners() {
        this.neutralListeners.clear();
        return this;
    }

    public final MaterialDialog noAutoDismiss() {
        this.autoDismissEnabled = false;
        return this;
    }

    public static /* synthetic */ MaterialDialog maxWidth$default(MaterialDialog materialDialog, Integer num, Integer num2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            num2 = null;
        }
        return materialDialog.maxWidth(num, num2);
    }

    public final MaterialDialog maxWidth(Integer res, Integer literal) {
        MDUtil.INSTANCE.assertOneSet("maxWidth", res, literal);
        Integer num = this.maxWidth;
        boolean z = (num == null || num == null || num.intValue() != 0) ? false : true;
        if (res != null) {
            literal = Integer.valueOf(this.windowContext.getResources().getDimensionPixelSize(res.intValue()));
        } else if (literal == null) {
            Intrinsics.throwNpe();
        }
        this.maxWidth = literal;
        if (z) {
            setWindowConstraints();
        }
        return this;
    }

    public static /* synthetic */ MaterialDialog cornerRadius$default(MaterialDialog materialDialog, Float f, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        return materialDialog.cornerRadius(f, num);
    }

    public final MaterialDialog cornerRadius(Float literalDp, Integer res) {
        Float valueOf;
        MDUtil.INSTANCE.assertOneSet(CdpConstants.CONTENT_CORNER_RADIUS, literalDp, res);
        if (res != null) {
            valueOf = Float.valueOf(this.windowContext.getResources().getDimension(res.intValue()));
        } else {
            Resources resources = this.windowContext.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (literalDp == null) {
                Intrinsics.throwNpe();
            }
            valueOf = Float.valueOf(TypedValue.applyDimension(1, literalDp.floatValue(), displayMetrics));
        }
        this.cornerRadius = valueOf;
        invalidateBackgroundColorAndRadius();
        return this;
    }

    public static /* synthetic */ MaterialDialog debugMode$default(MaterialDialog materialDialog, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return materialDialog.debugMode(z);
    }

    public final MaterialDialog debugMode(boolean debugMode) {
        this.view.setDebugMode(debugMode);
        return this;
    }

    @Override // android.app.Dialog
    public final void show() {
        setWindowConstraints();
        DialogsKt.preShow(this);
        this.dialogBehavior.onPreShow(this);
        super.show();
        this.dialogBehavior.onPostShow(this);
    }

    public final MaterialDialog show(Function1<? super MaterialDialog, Unit> func) {
        Intrinsics.checkParameterIsNotNull(func, "");
        func.invoke(this);
        show();
        return this;
    }

    public final MaterialDialog cancelable(boolean cancelable) {
        setCancelable(cancelable);
        return this;
    }

    @Override // android.app.Dialog
    @Deprecated(message = "Use fluent cancelable(Boolean) instead.", replaceWith = @ReplaceWith(expression = "cancelable(cancelable)", imports = {}))
    public final void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        super.setCancelable(cancelable);
    }

    public final MaterialDialog cancelOnTouchOutside(boolean cancelable) {
        setCanceledOnTouchOutside(cancelable);
        return this;
    }

    @Override // android.app.Dialog
    @Deprecated(message = "Use fluent cancelOnTouchOutside(Boolean) instead.", replaceWith = @ReplaceWith(expression = "cancelOnTouchOutside(cancelOnTouchOutside)", imports = {}))
    public final void setCanceledOnTouchOutside(boolean cancelOnTouchOutside) {
        this.cancelOnTouchOutside = cancelOnTouchOutside;
        super.setCanceledOnTouchOutside(cancelOnTouchOutside);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (this.dialogBehavior.onDismiss()) {
            return;
        }
        DialogsKt.hideKeyboard(this);
        super.dismiss();
    }

    public final void onActionButtonClicked$core(WhichButton which) {
        Intrinsics.checkParameterIsNotNull(which, "");
        int i = WhenMappings.$EnumSwitchMapping$0[which.ordinal()];
        if (i == 1) {
            DialogCallbackExtKt.invokeAll(this.positiveListeners, this);
            RecyclerView.Adapter<?> listAdapter = DialogListExtKt.getListAdapter(this);
            if (!(listAdapter instanceof DialogAdapter)) {
                listAdapter = null;
            }
            DialogAdapter dialogAdapter = (DialogAdapter) listAdapter;
            if (dialogAdapter != null) {
                dialogAdapter.positiveButtonClicked();
            }
        } else if (i == 2) {
            DialogCallbackExtKt.invokeAll(this.negativeListeners, this);
        } else if (i == 3) {
            DialogCallbackExtKt.invokeAll(this.neutralListeners, this);
        }
        if (this.autoDismissEnabled) {
            dismiss();
        }
    }

    private final void setWindowConstraints() {
        DialogBehavior dialogBehavior = this.dialogBehavior;
        Context context = this.windowContext;
        Integer num = this.maxWidth;
        Window window = getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window, "");
        dialogBehavior.setWindowConstraints(context, window, this.view, num);
    }

    private final void invalidateBackgroundColorAndRadius() {
        int resolveColor$default = ColorsKt.resolveColor$default(this, null, Integer.valueOf(R.attr.md_background_color), new Function0<Integer>() { // from class: com.afollestad.materialdialogs.MaterialDialog$invalidateBackgroundColorAndRadius$backgroundColor$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Integer invoke() {
                return Integer.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final int invoke2() {
                return ColorsKt.resolveColor$default(MaterialDialog.this, null, Integer.valueOf(R.attr.colorBackgroundFloating), null, 5, null);
            }
        }, 1, null);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        DialogBehavior dialogBehavior = this.dialogBehavior;
        DialogLayout dialogLayout = this.view;
        Float f = this.cornerRadius;
        dialogBehavior.setBackgroundColor(dialogLayout, resolveColor$default, f != null ? f.floatValue() : MDUtil.INSTANCE.resolveDimen(this.windowContext, R.attr.md_corner_radius, new Function0<Float>() { // from class: com.afollestad.materialdialogs.MaterialDialog$invalidateBackgroundColorAndRadius$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Float invoke() {
                return Float.valueOf(invoke2());
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final float invoke2() {
                Context context = MaterialDialog.this.getContext();
                Intrinsics.checkExpressionValueIsNotNull(context, "");
                return context.getResources().getDimension(R.dimen.md_dialog_default_corner_radius);
            }
        }));
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\nR(\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/afollestad/materialdialogs/MaterialDialog$Companion;", "", "Lcom/afollestad/materialdialogs/DialogBehavior;", "DEFAULT_BEHAVIOR", "Lcom/afollestad/materialdialogs/DialogBehavior;", "getDEFAULT_BEHAVIOR", "()Lcom/afollestad/materialdialogs/DialogBehavior;", "setDEFAULT_BEHAVIOR", "(Lcom/afollestad/materialdialogs/DialogBehavior;)V", "DEFAULT_BEHAVIOR$annotations", "()V", "<init>"}, k = 1, mv = {1, 8, 0})
    /* loaded from: classes2.dex */
    public static final class Companion {
        @JvmStatic
        public static /* synthetic */ void DEFAULT_BEHAVIOR$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmName(name = "getDEFAULT_BEHAVIOR")
        public final DialogBehavior getDEFAULT_BEHAVIOR() {
            return MaterialDialog.DEFAULT_BEHAVIOR;
        }

        @JvmName(name = "setDEFAULT_BEHAVIOR")
        public final void setDEFAULT_BEHAVIOR(DialogBehavior dialogBehavior) {
            Intrinsics.checkParameterIsNotNull(dialogBehavior, "");
            MaterialDialog.DEFAULT_BEHAVIOR = dialogBehavior;
        }
    }
}
