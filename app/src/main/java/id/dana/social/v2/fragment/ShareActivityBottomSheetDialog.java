package id.dana.social.v2.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.extension.view.InputExtKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.utils.FeedRegexData;
import id.dana.social.utils.FeedsContentUtils;
import id.dana.social.v2.fragment.ShareActivityBottomSheetDialog;
import id.dana.social.v2.view.ActivityFeedView;
import id.dana.social.view.BubbleFeedView;
import id.dana.utils.KeyboardHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 52\u00020\u0001:\u000265B\u000f\u0012\u0006\u0010\f\u001a\u000200¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0015\u0010\nJ!\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001a\u0010\nJ\u000f\u0010\u001b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\nJ\u000f\u0010\u001c\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\nR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u001eX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0013\u0010$\u001a\u00020!X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u001b\u001a\u0004\u0018\u00010%X\u0086\u0002¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u001d\u001a\u0004\u0018\u00010(X\u0086\u0002¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u001c\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010&\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102"}, d2 = {"Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/content/DialogInterface;", "onDismiss", "(Landroid/content/DialogInterface;)V", "onShow", "Landroid/view/View;", "p1", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "getAuthRequestContext", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "PlaceComponentResult", "", "moveToNextValue", "Ljava/lang/String;", "Lcom/afollestad/materialdialogs/MaterialDialog;", "GetContactSyncConfig", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/utils/FeedRegexData;", "lookAheadTest", "Lid/dana/social/utils/FeedRegexData;", "Lid/dana/social/model/FeedViewHolderModel;", "scheduleImpl", "Lid/dana/social/model/FeedViewHolderModel;", "", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda1", "getErrorConfigVersion", "Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog$Builder;", "initRecordTimeStamp", "Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog$Builder;", "<init>", "(Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog$Builder;)V", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ShareActivityBottomSheetDialog extends BaseBottomSheetDialogFragment {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private boolean getErrorConfigVersion;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final Builder lookAheadTest;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public FeedRegexData MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public FeedViewHolderModel PlaceComponentResult;
    public static final byte[] $$d = {111, 84, 114, 59, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = WSContextConstant.HANDSHAKE_SEND_SIZE;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {Ascii.EM, -104, -116, 103, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int getErrorConfigVersion = 245;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 16
            int r8 = r8 * 15
            int r8 = 18 - r8
            byte[] r0 = id.dana.social.v2.fragment.ShareActivityBottomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r9 = r9 + 105
            byte[] r1 = new byte[r7]
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r8
            goto L34
        L17:
            r3 = 0
            r6 = r9
            r9 = r8
            r8 = r6
        L1b:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            int r9 = r9 + 1
            r1[r3] = r5
            if (r4 != r7) goto L2c
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2c:
            r3 = r0[r9]
            r6 = r10
            r10 = r9
            r9 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L34:
            int r9 = -r9
            int r8 = r8 + r9
            int r8 = r8 + 2
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog.c(short, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r7, byte r8, short r9, java.lang.Object[] r10) {
        /*
            int r7 = r7 + 4
            int r8 = r8 * 2
            int r8 = 75 - r8
            byte[] r0 = id.dana.social.v2.fragment.ShareActivityBottomSheetDialog.$$d
            int r9 = r9 * 3
            int r9 = 42 - r9
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L34
        L18:
            r3 = 0
        L19:
            int r4 = r3 + 1
            byte r5 = (byte) r8
            r1[r3] = r5
            int r7 = r7 + 1
            if (r4 != r9) goto L2a
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L2a:
            r3 = r0[r7]
            r6 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r6
        L34:
            int r7 = -r7
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r6 = r8
            r8 = r7
            r7 = r6
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog.d(short, byte, short, java.lang.Object[]):void");
    }

    public final View BuiltInFictitiousFunctionClassFactory(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.bottom_sheet_share_activity_coordinator;
    }

    public ShareActivityBottomSheetDialog(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.lookAheadTest = builder;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$cancelShareActivityDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                ShareActivityBottomSheetDialog.Builder builder2;
                builder2 = ShareActivityBottomSheetDialog.this.lookAheadTest;
                CustomDialog.Builder builder3 = new CustomDialog.Builder(builder2.getAuthRequestContext);
                final ShareActivityBottomSheetDialog shareActivityBottomSheetDialog = ShareActivityBottomSheetDialog.this;
                builder3.SubSequence = shareActivityBottomSheetDialog.getString(R.string.share_activity_cancel_dialog_title);
                builder3.GetContactSyncConfig = shareActivityBottomSheetDialog.getString(R.string.share_activity_cancel_dialog_description);
                builder3.KClassImpl$Data$declaredNonStaticMembers$2(false);
                builder3.PlaceComponentResult(false);
                builder3.BuiltInFictitiousFunctionClassFactory(shareActivityBottomSheetDialog.getString(R.string.share_activity_cancel_dialog_button_positive), new Function1<View, Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$cancelShareActivityDialog$2$1$1
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
                        ShareActivityBottomSheetDialog.Builder builder4;
                        Intrinsics.checkNotNullParameter(view, "");
                        builder4 = ShareActivityBottomSheetDialog.this.lookAheadTest;
                        Function0<Unit> function0 = builder4.PlaceComponentResult;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        ShareActivityBottomSheetDialog.this.dismiss();
                    }
                });
                builder3.KClassImpl$Data$declaredNonStaticMembers$2(shareActivityBottomSheetDialog.getString(R.string.share_activity_cancel_dialog_button_negative), new Function1<View, Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$cancelShareActivityDialog$2$1$2
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
                        ShareActivityBottomSheetDialog.MyBillsEntityDataFactory(ShareActivityBottomSheetDialog.this).dismiss();
                    }
                });
                builder3.NetworkUserEntityData$$ExternalSyntheticLambda4 = shareActivityBottomSheetDialog.getString(R.string.btnYesCancelShareFeed);
                builder3.newProxyInstance = shareActivityBottomSheetDialog.getString(R.string.btnBackCancelShareFeed);
                return builder3.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        this.bottomSheetBehavior.setHideable(false);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        final Context requireContext = requireContext();
        final int theme = getTheme();
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext, theme) { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$onCreateDialog$1
            @Override // androidx.view.ComponentDialog, android.app.Dialog
            public final void onBackPressed() {
                ShareActivityBottomSheetDialog.MyBillsEntityDataFactory(ShareActivityBottomSheetDialog.this).show();
            }
        };
        bottomSheetDialog.getBehavior().setState(3);
        bottomSheetDialog.getBehavior().setDraggable(false);
        return bottomSheetDialog;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Window window;
        View decorView;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        Dialog dialog = getDialog();
        View findViewById = (dialog == null || (window = dialog.getWindow()) == null || (decorView = window.getDecorView()) == null) ? null : decorView.findViewById(R.id.touch_outside);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareActivityBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(ShareActivityBottomSheetDialog.this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] - 1);
            Object[] objArr = new Object[1];
            c(b, b, NetworkUserEntityData$$ExternalSyntheticLambda0[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda0[5] - 1);
            byte b3 = NetworkUserEntityData$$ExternalSyntheticLambda0[5];
            Object[] objArr2 = new Object[1];
            c(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 495, (ViewConfiguration.getScrollBarSize() >> 8) + 4, (char) KeyEvent.keyCodeFromString(""));
                    byte b4 = $$d[35];
                    byte b5 = (byte) (b4 + 1);
                    Object[] objArr4 = new Object[1];
                    d(b4, b5, b5, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getOffsetBefore("", 0), (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-400295930, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 910, 18 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                setStyle(0, R.style.f50122132017477);
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

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        ConstraintLayout constraintLayout = (ConstraintLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a032c_unicastprocessor_unicastqueuesubscription);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(this.lookAheadTest.getMyBillsEntityDataFactory() ? 0 : 8);
        }
        ActivityFeedView activityFeedView = (ActivityFeedView) BuiltInFictitiousFunctionClassFactory(R.id.BackgroundPowerSaver);
        if (activityFeedView != null) {
            activityFeedView.setVisibility(this.lookAheadTest.getMyBillsEntityDataFactory() ? 0 : 8);
        }
        BubbleFeedView bubbleFeedView = (BubbleFeedView) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0257_promocategorypresenter_1);
        if (bubbleFeedView != null) {
            bubbleFeedView.setVisibility(this.lookAheadTest.getMyBillsEntityDataFactory() ^ true ? 0 : 8);
        }
        CircleImageView circleImageView = (CircleImageView) BuiltInFictitiousFunctionClassFactory(R.id.civProfileAvatar);
        if (circleImageView != null) {
            circleImageView.setVisibility(this.lookAheadTest.getMyBillsEntityDataFactory() ^ true ? 0 : 8);
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setAvatar$1
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
                String str;
                FeedViewHolderModel feedViewHolderModel = ShareActivityBottomSheetDialog.this.PlaceComponentResult;
                if (feedViewHolderModel != null) {
                    FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
                    str = FeedsContentUtils.BuiltInFictitiousFunctionClassFactory(feedViewHolderModel);
                } else {
                    str = null;
                }
                ActivityFeedView activityFeedView2 = (ActivityFeedView) ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory(R.id.BackgroundPowerSaver);
                if (activityFeedView2 != null) {
                    if (str == null) {
                        str = "";
                    }
                    activityFeedView2.setAvatar(str);
                }
            }
        };
        Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setAvatar$2
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
                CircleImageView circleImageView2 = (CircleImageView) ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory(R.id.civProfileAvatar);
                if (circleImageView2 != null) {
                    CircleImageView circleImageView3 = circleImageView2;
                    String str = ShareActivityBottomSheetDialog.this.getAuthRequestContext;
                    if (str == null) {
                        str = "";
                    }
                    SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(circleImageView3, str, R.drawable.avatar_placeholder);
                }
            }
        };
        if (this.lookAheadTest.getMyBillsEntityDataFactory()) {
            function0.invoke();
        } else {
            function02.invoke();
        }
        Function0<Unit> function03 = new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setupView$1
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
                ShareActivityBottomSheetDialog.this.PlaceComponentResult();
            }
        };
        Function0<Unit> function04 = new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setupView$2
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
                ShareActivityBottomSheetDialog.GetContactSyncConfig(ShareActivityBottomSheetDialog.this);
            }
        };
        if (this.lookAheadTest.getMyBillsEntityDataFactory()) {
            function03.invoke();
        } else {
            function04.invoke();
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        PlaceComponentResult();
        AppCompatImageView appCompatImageView = (AppCompatImageView) BuiltInFictitiousFunctionClassFactory(R.id._release);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareActivityBottomSheetDialog.PlaceComponentResult(ShareActivityBottomSheetDialog.this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) BuiltInFictitiousFunctionClassFactory(R.id.btnShareToFeed);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareActivityBottomSheetDialog.PlaceComponentResult(ShareActivityBottomSheetDialog.this, view);
                }
            });
        }
        final AppCompatEditText appCompatEditText = (AppCompatEditText) BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
        if (appCompatEditText != null) {
            appCompatEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    ShareActivityBottomSheetDialog.PlaceComponentResult(AppCompatEditText.this, this, z);
                }
            });
            appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setTextChangeListener$1$2
                @Override // android.text.TextWatcher
                public final void beforeTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void onTextChanged(CharSequence p0, int p1, int p2, int p3) {
                }

                @Override // android.text.TextWatcher
                public final void afterTextChanged(final Editable p0) {
                    ShareActivityBottomSheetDialog$setTextChangeListener$1$2 shareActivityBottomSheetDialog$setTextChangeListener$1$2 = this;
                    AppCompatEditText.this.removeTextChangedListener(shareActivityBottomSheetDialog$setTextChangeListener$1$2);
                    ShareActivityBottomSheetDialog.moveToNextValue(this);
                    if (p0 != null) {
                        final ShareActivityBottomSheetDialog shareActivityBottomSheetDialog = this;
                        AppCompatEditText appCompatEditText2 = AppCompatEditText.this;
                        ShareActivityBottomSheetDialog.MyBillsEntityDataFactory(shareActivityBottomSheetDialog, new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setTextChangeListener$1$2$afterTextChanged$1$1
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
                                ActivityFeedView activityFeedView2 = (ActivityFeedView) ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory(R.id.BackgroundPowerSaver);
                                TextView textView = activityFeedView2 != null ? (TextView) activityFeedView2._$_findCachedViewById(R.id.res_0x7f0a13f2_daggerreferraltrackercomponent_referraltrackercomponentimpl_providepushverifytrackerprovider) : null;
                                if (textView != null) {
                                    textView.setVisibility(p0.length() > 0 ? 0 : 8);
                                }
                            }
                        }, new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setTextChangeListener$1$2$afterTextChanged$1$2
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
                                BubbleFeedView bubbleFeedView2 = (BubbleFeedView) ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0257_promocategorypresenter_1);
                                if (bubbleFeedView2 != null) {
                                    bubbleFeedView2.showCaptionSection(p0.length() > 0);
                                }
                            }
                        });
                        String obj = p0.toString();
                        if (StringsKt.contains$default((CharSequence) p0, (CharSequence) "\n", false, 2, (Object) null)) {
                            int selectionStart = appCompatEditText2.getSelectionStart();
                            obj = StringsKt.replace$default(obj, "\n", "", false, 4, (Object) null);
                            appCompatEditText2.setText(new SpannableStringBuilder(obj));
                            appCompatEditText2.setSelection(selectionStart - 1);
                        }
                        ShareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(shareActivityBottomSheetDialog, p0.length() > 150, obj);
                    }
                    AppCompatEditText.this.addTextChangedListener(shareActivityBottomSheetDialog$setTextChangeListener$1$2);
                }
            });
        }
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
        if (appCompatEditText2 != null) {
            appCompatEditText2.setOnTouchListener(new View.OnTouchListener() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean authRequestContext;
                    authRequestContext = ShareActivityBottomSheetDialog.getAuthRequestContext(view, motionEvent);
                    return authRequestContext;
                }
            });
        }
        KeyboardHelper.PlaceComponentResult(this.lookAheadTest.getAuthRequestContext.getWindow().getDecorView(), new KeyboardHelper.KeyboardVisibilityListener() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$setupKeyboardListener$1
            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                boolean z;
                z = ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory;
                if (z) {
                    return;
                }
                ShareActivityBottomSheetDialog.getErrorConfigVersion(ShareActivityBottomSheetDialog.this);
                ShareActivityBottomSheetDialog.moveToNextValue(ShareActivityBottomSheetDialog.this);
                ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory = true;
            }

            @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
            public final void MyBillsEntityDataFactory() {
                ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory();
                AppCompatEditText appCompatEditText3 = (AppCompatEditText) ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
                if (appCompatEditText3 != null) {
                    appCompatEditText3.clearFocus();
                }
                ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getAuthRequestContext(View view, MotionEvent motionEvent) {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        if ((motionEvent.getAction() & 255) == 1) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        ActivityFeedView activityFeedView = (ActivityFeedView) BuiltInFictitiousFunctionClassFactory(R.id.BackgroundPowerSaver);
        if (activityFeedView != null) {
            activityFeedView.setupActivityFeed(false, false, false, false, false, false);
            FeedRegexData feedRegexData = this.MyBillsEntityDataFactory;
            if (feedRegexData != null) {
                activityFeedView.setContent(feedRegexData);
            }
            FeedViewHolderModel feedViewHolderModel = this.PlaceComponentResult;
            if (feedViewHolderModel != null) {
                FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
                String authRequestContext = FeedsContentUtils.getAuthRequestContext(feedViewHolderModel);
                FeedsContentUtils feedsContentUtils2 = FeedsContentUtils.MyBillsEntityDataFactory;
                activityFeedView.setName(authRequestContext, FeedsContentUtils.PlaceComponentResult(feedViewHolderModel));
                activityFeedView.setContent(feedViewHolderModel.MyBillsEntityDataFactory);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        AppCompatEditText appCompatEditText = (AppCompatEditText) BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
        if (appCompatEditText != null) {
            InputExtKt.MyBillsEntityDataFactory(appCompatEditText);
        }
        this.MyBillsEntityDataFactory = null;
        super.onDismiss(p0);
    }

    private final void MyBillsEntityDataFactory() {
        View BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(R.id.setExpirySeconds);
        ViewGroup.LayoutParams layoutParams = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = ViewExtKt.PlaceComponentResult(70.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void BuiltInFictitiousFunctionClassFactory() {
        View BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(R.id.setExpirySeconds);
        ViewGroup.LayoutParams layoutParams = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = ViewExtKt.PlaceComponentResult(32.0f);
        }
    }

    private final void getAuthRequestContext() {
        View BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(R.id.setExpirySeconds);
        ViewGroup.LayoutParams layoutParams = BuiltInFictitiousFunctionClassFactory != null ? BuiltInFictitiousFunctionClassFactory.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = ViewExtKt.PlaceComponentResult(54.0f);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\b\u001a\u00020\u0005X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\t8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0087\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0011X\u0087\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013"}, d2 = {"Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog$Builder;", "", "Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog;", "PlaceComponentResult", "()Lid/dana/social/v2/fragment/ShareActivityBottomSheetDialog;", "Landroid/app/Activity;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/app/Activity;", "getAuthRequestContext", "", "Z", "MyBillsEntityDataFactory", "()Z", "Lkotlin/Function0;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "Lkotlin/Function2;", "", "Lkotlin/jvm/functions/Function2;", "p0", "p1", "p2", "p3", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroid/app/Activity;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public Function0<Unit> PlaceComponentResult;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        Activity getAuthRequestContext;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public Function2<? super String, ? super String, Unit> BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public boolean MyBillsEntityDataFactory;

        private Builder(Function2<? super String, ? super String, Unit> function2, Function0<Unit> function0, Activity activity, boolean z) {
            Intrinsics.checkNotNullParameter(activity, "");
            this.BuiltInFictitiousFunctionClassFactory = function2;
            this.PlaceComponentResult = function0;
            this.getAuthRequestContext = activity;
            this.MyBillsEntityDataFactory = z;
        }

        public /* synthetic */ Builder(Function2 function2, Function0 function0, Activity activity, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : function2, (i & 2) != 0 ? null : function0, activity, (i & 8) != 0 ? false : z);
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getMyBillsEntityDataFactory() {
            return this.MyBillsEntityDataFactory;
        }

        public final ShareActivityBottomSheetDialog PlaceComponentResult() {
            return new ShareActivityBottomSheetDialog(new Builder(this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.getAuthRequestContext, this.MyBillsEntityDataFactory));
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(shareActivityBottomSheetDialog, "");
        ((MaterialDialog) shareActivityBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).show();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(shareActivityBottomSheetDialog, "");
        ((NestedScrollView) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.nsvShareFeedContent)).fullScroll(130);
    }

    public static /* synthetic */ void PlaceComponentResult(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(shareActivityBottomSheetDialog, "");
        ((MaterialDialog) shareActivityBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).show();
    }

    public static /* synthetic */ void PlaceComponentResult(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(shareActivityBottomSheetDialog, "");
        AppCompatEditText appCompatEditText = (AppCompatEditText) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
        String obj = StringsKt.trim((CharSequence) String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null)).toString();
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(view);
        Function2<? super String, ? super String, Unit> function2 = shareActivityBottomSheetDialog.lookAheadTest.BuiltInFictitiousFunctionClassFactory;
        if (function2 != null) {
            FeedRegexData feedRegexData = shareActivityBottomSheetDialog.MyBillsEntityDataFactory;
            String str = feedRegexData != null ? feedRegexData.getErrorConfigVersion : null;
            function2.invoke(str != null ? str : "", obj);
        }
    }

    public static /* synthetic */ void PlaceComponentResult(AppCompatEditText appCompatEditText, ShareActivityBottomSheetDialog shareActivityBottomSheetDialog, boolean z) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "");
        Intrinsics.checkNotNullParameter(shareActivityBottomSheetDialog, "");
        if (z) {
            appCompatEditText.setHint("");
            appCompatEditText.setBackgroundResource(R.drawable.bg_review_focused);
            return;
        }
        KeyboardHelper.BuiltInFictitiousFunctionClassFactory(appCompatEditText);
        shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory();
        appCompatEditText.setHint(R.string.share_feed_description_hint);
        appCompatEditText.setBackgroundResource(R.drawable.bg_review_normal);
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog, Function0 function0, Function0 function02) {
        if (shareActivityBottomSheetDialog.lookAheadTest.getMyBillsEntityDataFactory()) {
            function0.invoke();
        } else {
            function02.invoke();
        }
    }

    public static final /* synthetic */ MaterialDialog MyBillsEntityDataFactory(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog) {
        return (MaterialDialog) shareActivityBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ void getErrorConfigVersion(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog) {
        AppCompatEditText appCompatEditText = (AppCompatEditText) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
        boolean z = String.valueOf(appCompatEditText != null ? appCompatEditText.getText() : null).length() > 0;
        boolean z2 = shareActivityBottomSheetDialog.getErrorConfigVersion;
        if (z && !z2) {
            shareActivityBottomSheetDialog.getAuthRequestContext();
        } else if (z && z2) {
            shareActivityBottomSheetDialog.MyBillsEntityDataFactory();
        } else {
            shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static final /* synthetic */ void moveToNextValue(final ShareActivityBottomSheetDialog shareActivityBottomSheetDialog) {
        NestedScrollView nestedScrollView = (NestedScrollView) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.nsvShareFeedContent);
        if (nestedScrollView != null) {
            nestedScrollView.post(new Runnable() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ShareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(ShareActivityBottomSheetDialog.this);
                }
            });
        }
    }

    public static final /* synthetic */ void GetContactSyncConfig(ShareActivityBottomSheetDialog shareActivityBottomSheetDialog) {
        BubbleFeedView bubbleFeedView = (BubbleFeedView) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0257_promocategorypresenter_1);
        if (bubbleFeedView != null) {
            bubbleFeedView.addPaddingBottom();
            bubbleFeedView.showCaptionSection(false);
            bubbleFeedView.showDateSection(false);
            bubbleFeedView.removeCaptionConstraint();
            FeedRegexData feedRegexData = shareActivityBottomSheetDialog.MyBillsEntityDataFactory;
            if (feedRegexData != null) {
                bubbleFeedView.setDesc(feedRegexData, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final ShareActivityBottomSheetDialog shareActivityBottomSheetDialog, boolean z, String str) {
        shareActivityBottomSheetDialog.getErrorConfigVersion = z;
        TextView textView = (TextView) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a145e_logfilemanager_1);
        if (textView != null) {
            textView.setVisibility(z ? 0 : 8);
        }
        ImageView imageView = (ImageView) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.getLottieParams);
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
        if (z) {
            AppCompatEditText appCompatEditText = (AppCompatEditText) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
            if (appCompatEditText != null) {
                appCompatEditText.setBackgroundResource(R.drawable.bg_review_full);
            }
        } else {
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
            if (appCompatEditText2 != null) {
                appCompatEditText2.setBackgroundResource(R.drawable.bg_review_focused);
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = str;
        if (z) {
            objectRef.element = StringsKt.dropLast(str, 1);
            AppCompatEditText appCompatEditText3 = (AppCompatEditText) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
            if (appCompatEditText3 != null) {
                appCompatEditText3.setText(new SpannableStringBuilder((CharSequence) objectRef.element));
            }
            AppCompatEditText appCompatEditText4 = (AppCompatEditText) shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.RoundedCornerTreatment_res_0x7f0a068b);
            if (appCompatEditText4 != null) {
                appCompatEditText4.setSelection(str.length() - 1);
            }
        }
        Function0<Unit> function0 = new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$showErrorMessage$1
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
                ActivityFeedView activityFeedView = (ActivityFeedView) ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory(R.id.BackgroundPowerSaver);
                TextView textView2 = activityFeedView != null ? (TextView) activityFeedView._$_findCachedViewById(R.id.res_0x7f0a13f2_daggerreferraltrackercomponent_referraltrackercomponentimpl_providepushverifytrackerprovider) : null;
                if (textView2 != null) {
                    textView2.setText(objectRef.element);
                }
            }
        };
        Function0<Unit> function02 = new Function0<Unit>() { // from class: id.dana.social.v2.fragment.ShareActivityBottomSheetDialog$showErrorMessage$2
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
                BubbleFeedView bubbleFeedView = (BubbleFeedView) ShareActivityBottomSheetDialog.this.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0257_promocategorypresenter_1);
                if (bubbleFeedView != null) {
                    bubbleFeedView.showCaption(objectRef.element);
                }
            }
        };
        if (shareActivityBottomSheetDialog.lookAheadTest.getMyBillsEntityDataFactory()) {
            function0.invoke();
        } else {
            function02.invoke();
        }
        boolean z2 = ((CharSequence) objectRef.element).length() > 0;
        if (z2 && !z) {
            shareActivityBottomSheetDialog.getAuthRequestContext();
        } else if (z2 && z) {
            shareActivityBottomSheetDialog.MyBillsEntityDataFactory();
        } else {
            shareActivityBottomSheetDialog.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) BuiltInFictitiousFunctionClassFactory(R.id.flShareActivity);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
