package id.dana.core.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.databinding.DialogDanaAlertBinding;
import id.dana.core.ui.dialog.DanaAlertDialog;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0004 \u001f!\"B\u0007¢\u0006\u0004\b\u001e\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\tJ!\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/core/ui/dialog/DanaAlertDialog;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "Landroid/content/DialogInterface;", "", "cancel", "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "p1", "p2", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onDismiss", "(Landroid/content/DialogInterface;)V", "onSaveInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lid/dana/core/ui/databinding/DialogDanaAlertBinding;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/core/ui/databinding/DialogDanaAlertBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/core/ui/dialog/DanaAlertDialog$Controller;", "PlaceComponentResult", "Lid/dana/core/ui/dialog/DanaAlertDialog$Controller;", "MyBillsEntityDataFactory", "<init>", "Companion", "Builder", "Controller", "LinkKey"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaAlertDialog extends AppCompatDialogFragment implements DialogInterface {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private DialogDanaAlertBinding BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    Controller MyBillsEntityDataFactory;
    public static final byte[] $$a = {4, -87, 42, 65, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 224;
    public static final byte[] MyBillsEntityDataFactory = {SignedBytes.MAX_POWER_OF_TWO, 34, -50, 73, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int scheduleImpl = 148;

    /* JADX WARN: Removed duplicated region for block: B:32:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0028  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0028 -> B:35:0x0034). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r0 = id.dana.core.ui.dialog.DanaAlertDialog.MyBillsEntityDataFactory
            int r6 = r6 + 105
            int r8 = r8 * 3
            int r8 = r8 + 16
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
            goto L34
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L34:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + 2
            int r7 = r8 + 1
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.dialog.DanaAlertDialog.a(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002b -> B:35:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = 75 - r8
            int r6 = r6 * 2
            int r6 = r6 + 42
            byte[] r0 = id.dana.core.ui.dialog.DanaAlertDialog.$$a
            int r7 = r7 * 3
            int r7 = r7 + 4
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1d
            r8 = r7
            r3 = r1
            r4 = 0
            r7 = r6
            r1 = r0
            r0 = r9
            r9 = r8
            goto L38
        L1d:
            r3 = 0
        L1e:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r5
        L38:
            int r8 = r8 + 1
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L1e
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.core.ui.dialog.DanaAlertDialog.b(int, byte, byte, java.lang.Object[]):void");
    }

    @Override // android.content.DialogInterface
    public final void cancel() {
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        Parcelable parcelable;
        try {
            byte b = MyBillsEntityDataFactory[5];
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (MyBillsEntityDataFactory[5] - 1);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Gravity.getAbsoluteGravity(0, 0) + 494, (ViewConfiguration.getWindowTouchSlop() >> 8) + 4, (char) View.getDefaultSize(0, 0));
                    byte b5 = (byte) ($$a[35] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r3 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 34 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), (char) ExpandableListView.getPackedPositionType(0L))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {211492592, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), 19 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                if (p0 != null) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        parcelable = (Parcelable) p0.getParcelable("CONTROLLER_KEY", Controller.class);
                    } else {
                        Parcelable parcelable2 = p0.getParcelable("CONTROLLER_KEY");
                        parcelable = (Controller) (parcelable2 instanceof Controller ? parcelable2 : null);
                    }
                    Controller controller = (Controller) parcelable;
                    if (controller != null) {
                        this.MyBillsEntityDataFactory = controller;
                    }
                }
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
        Window window;
        Intrinsics.checkNotNullParameter(p0, "");
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        DialogDanaAlertBinding KClassImpl$Data$declaredNonStaticMembers$2 = DialogDanaAlertBinding.KClassImpl$Data$declaredNonStaticMembers$2(p0, p1);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2;
        ConstraintLayout constraintLayout = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
        return constraintLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View p0, Bundle p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onViewCreated(p0, p1);
        final Controller controller = this.MyBillsEntityDataFactory;
        if (controller != null) {
            CharSequence charSequence = controller.newProxyInstance;
            byte b = 0;
            DialogDanaAlertBinding dialogDanaAlertBinding = null;
            if (charSequence == null || charSequence.length() == 0) {
                DialogDanaAlertBinding dialogDanaAlertBinding2 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding2 = null;
                }
                TextView textView = dialogDanaAlertBinding2.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(textView, "");
                textView.setVisibility(8);
            } else {
                DialogDanaAlertBinding dialogDanaAlertBinding3 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding3 = null;
                }
                TextView textView2 = dialogDanaAlertBinding3.getErrorConfigVersion;
                Intrinsics.checkNotNullExpressionValue(textView2, "");
                textView2.setVisibility(0);
                DialogDanaAlertBinding dialogDanaAlertBinding4 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding4 = null;
                }
                dialogDanaAlertBinding4.getErrorConfigVersion.setText(controller.newProxyInstance);
                DialogDanaAlertBinding dialogDanaAlertBinding5 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding5 = null;
                }
                dialogDanaAlertBinding5.getErrorConfigVersion.setContentDescription(controller.NetworkUserEntityData$$ExternalSyntheticLambda6);
            }
            CharSequence charSequence2 = controller.getErrorConfigVersion;
            if (charSequence2 == null || charSequence2.length() == 0) {
                DialogDanaAlertBinding dialogDanaAlertBinding6 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding6 = null;
                }
                TextView textView3 = dialogDanaAlertBinding6.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(textView3, "");
                textView3.setVisibility(8);
            } else {
                DialogDanaAlertBinding dialogDanaAlertBinding7 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding7 = null;
                }
                TextView textView4 = dialogDanaAlertBinding7.getAuthRequestContext;
                Intrinsics.checkNotNullExpressionValue(textView4, "");
                textView4.setVisibility(0);
                DialogDanaAlertBinding dialogDanaAlertBinding8 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding8 = null;
                }
                dialogDanaAlertBinding8.getAuthRequestContext.setText(controller.getErrorConfigVersion);
                DialogDanaAlertBinding dialogDanaAlertBinding9 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding9 = null;
                }
                dialogDanaAlertBinding9.getAuthRequestContext.setContentDescription(controller.scheduleImpl);
                final LinksString linksString = controller.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (linksString != null) {
                    DialogDanaAlertBinding dialogDanaAlertBinding10 = this.BuiltInFictitiousFunctionClassFactory;
                    if (dialogDanaAlertBinding10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        dialogDanaAlertBinding10 = null;
                    }
                    final TextView textView5 = dialogDanaAlertBinding10.getAuthRequestContext;
                    Intrinsics.checkNotNullExpressionValue(textView5, "");
                    final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: id.dana.core.ui.dialog.DanaAlertDialog$installView$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                            invoke2(str);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(String str) {
                            Intrinsics.checkNotNullParameter(str, "");
                            Function1<? super String, Unit> function12 = DanaAlertDialog.Controller.this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                            if (function12 != null) {
                                function12.invoke(str);
                            }
                        }
                    };
                    Intrinsics.checkNotNullParameter(textView5, "");
                    Intrinsics.checkNotNullParameter(function1, "");
                    SpannableString spannableString = new SpannableString(textView5.getText());
                    int length = linksString.getAuthRequestContext.length;
                    for (final int i = 0; i < length; i++) {
                        ClickableSpan clickableSpan = new ClickableSpan() { // from class: id.dana.core.ui.dialog.LinksString$createLinks$clickableSpan$1
                            @Override // android.text.style.ClickableSpan
                            public final void onClick(View p02) {
                                ClickableString[] clickableStringArr;
                                Intrinsics.checkNotNullParameter(p02, "");
                                Function1<String, Unit> function12 = function1;
                                clickableStringArr = linksString.getAuthRequestContext;
                                function12.invoke(clickableStringArr[i].KClassImpl$Data$declaredNonStaticMembers$2);
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public final void updateDrawState(TextPaint p02) {
                                ClickableString[] clickableStringArr;
                                ClickableString[] clickableStringArr2;
                                Intrinsics.checkNotNullParameter(p02, "");
                                clickableStringArr = linksString.getAuthRequestContext;
                                Boolean bool = clickableStringArr[i].PlaceComponentResult;
                                if (bool != null) {
                                    p02.setUnderlineText(bool.booleanValue());
                                }
                                clickableStringArr2 = linksString.getAuthRequestContext;
                                Integer num = clickableStringArr2[i].BuiltInFictitiousFunctionClassFactory;
                                if (num != null) {
                                    TextView textView6 = textView5;
                                    p02.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(textView6.getContext(), num.intValue()));
                                }
                            }
                        };
                        String string = textView5.getContext().getString(linksString.getAuthRequestContext[i].getAuthRequestContext);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        CharSequence text = textView5.getText();
                        Intrinsics.checkNotNullExpressionValue(text, "");
                        int indexOf$default = StringsKt.indexOf$default(text, string, 0, false, 6, (Object) null);
                        spannableString.setSpan(clickableSpan, indexOf$default, string.length() + indexOf$default, 33);
                    }
                    textView5.setMovementMethod(LinkMovementMethod.getInstance());
                    textView5.setText(spannableString, TextView.BufferType.SPANNABLE);
                }
            }
            if (controller.MyBillsEntityDataFactory == 0 && controller.PlaceComponentResult == null) {
                DialogDanaAlertBinding dialogDanaAlertBinding11 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding11 = null;
                }
                AppCompatImageView appCompatImageView = dialogDanaAlertBinding11.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                appCompatImageView.setVisibility(8);
            } else {
                DialogDanaAlertBinding dialogDanaAlertBinding12 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding12 = null;
                }
                AppCompatImageView appCompatImageView2 = dialogDanaAlertBinding12.KClassImpl$Data$declaredNonStaticMembers$2;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                appCompatImageView2.setVisibility(0);
                if (controller.MyBillsEntityDataFactory != 0) {
                    DialogDanaAlertBinding dialogDanaAlertBinding13 = this.BuiltInFictitiousFunctionClassFactory;
                    if (dialogDanaAlertBinding13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        dialogDanaAlertBinding13 = null;
                    }
                    AppCompatImageView appCompatImageView3 = dialogDanaAlertBinding13.KClassImpl$Data$declaredNonStaticMembers$2;
                    int i2 = controller.MyBillsEntityDataFactory;
                    if (appCompatImageView3 instanceof ImageView) {
                        InstrumentInjector.Resources_setImageResource(appCompatImageView3, i2);
                    } else {
                        appCompatImageView3.setImageResource(i2);
                    }
                } else if (SvgLoader.getAuthRequestContext(controller.PlaceComponentResult)) {
                    SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
                    KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = controller.PlaceComponentResult;
                    DialogDanaAlertBinding dialogDanaAlertBinding14 = this.BuiltInFictitiousFunctionClassFactory;
                    if (dialogDanaAlertBinding14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        dialogDanaAlertBinding14 = null;
                    }
                    KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = dialogDanaAlertBinding14.KClassImpl$Data$declaredNonStaticMembers$2;
                    new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                } else {
                    GlideRequest<Drawable> MyBillsEntityDataFactory2 = GlideApp.getAuthRequestContext(requireContext()).PlaceComponentResult(controller.PlaceComponentResult).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext);
                    DialogDanaAlertBinding dialogDanaAlertBinding15 = this.BuiltInFictitiousFunctionClassFactory;
                    if (dialogDanaAlertBinding15 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        dialogDanaAlertBinding15 = null;
                    }
                    MyBillsEntityDataFactory2.MyBillsEntityDataFactory((ImageView) dialogDanaAlertBinding15.KClassImpl$Data$declaredNonStaticMembers$2);
                }
            }
            if (controller.BuiltInFictitiousFunctionClassFactory != null && controller.getAuthRequestContext != null) {
                DialogDanaAlertBinding dialogDanaAlertBinding16 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding16 = null;
                }
                ViewGroup.LayoutParams layoutParams = dialogDanaAlertBinding16.KClassImpl$Data$declaredNonStaticMembers$2.getLayoutParams();
                layoutParams.width = SizeUtil.PlaceComponentResult(controller.BuiltInFictitiousFunctionClassFactory.intValue());
                layoutParams.height = SizeUtil.PlaceComponentResult(controller.getAuthRequestContext.intValue());
            }
            CharSequence charSequence3 = controller.isLayoutRequested;
            if (charSequence3 == null || charSequence3.length() == 0) {
                DialogDanaAlertBinding dialogDanaAlertBinding17 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding17 = null;
                }
                Button button = dialogDanaAlertBinding17.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(button, "");
                button.setVisibility(8);
            } else {
                DialogDanaAlertBinding dialogDanaAlertBinding18 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding18 = null;
                }
                Button button2 = dialogDanaAlertBinding18.MyBillsEntityDataFactory;
                Intrinsics.checkNotNullExpressionValue(button2, "");
                button2.setVisibility(0);
                DialogDanaAlertBinding dialogDanaAlertBinding19 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding19 = null;
                }
                dialogDanaAlertBinding19.MyBillsEntityDataFactory.setText(controller.isLayoutRequested);
                DialogDanaAlertBinding dialogDanaAlertBinding20 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding20 = null;
                }
                dialogDanaAlertBinding20.MyBillsEntityDataFactory.setContentDescription(controller.NetworkUserEntityData$$ExternalSyntheticLambda7);
                DialogDanaAlertBinding dialogDanaAlertBinding21 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding21 = null;
                }
                dialogDanaAlertBinding21.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.dialog.DanaAlertDialog$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DanaAlertDialog.KClassImpl$Data$declaredNonStaticMembers$2(DanaAlertDialog.Controller.this, this);
                    }
                });
            }
            CharSequence charSequence4 = controller.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (charSequence4 == null || charSequence4.length() == 0) {
                DialogDanaAlertBinding dialogDanaAlertBinding22 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding22 = null;
                }
                Button button3 = dialogDanaAlertBinding22.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(button3, "");
                button3.setVisibility(8);
            } else {
                DialogDanaAlertBinding dialogDanaAlertBinding23 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding23 = null;
                }
                Button button4 = dialogDanaAlertBinding23.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(button4, "");
                button4.setVisibility(0);
                DialogDanaAlertBinding dialogDanaAlertBinding24 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding24 = null;
                }
                dialogDanaAlertBinding24.PlaceComponentResult.setText(controller.NetworkUserEntityData$$ExternalSyntheticLambda2);
                DialogDanaAlertBinding dialogDanaAlertBinding25 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding25 = null;
                }
                dialogDanaAlertBinding25.PlaceComponentResult.setContentDescription(controller.GetContactSyncConfig);
                DialogDanaAlertBinding dialogDanaAlertBinding26 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    dialogDanaAlertBinding26 = null;
                }
                dialogDanaAlertBinding26.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.core.ui.dialog.DanaAlertDialog$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DanaAlertDialog.BuiltInFictitiousFunctionClassFactory(DanaAlertDialog.Controller.this, this);
                    }
                });
            }
            Boolean bool = controller.KClassImpl$Data$declaredNonStaticMembers$2;
            if (bool != null) {
                setCancelable(bool.booleanValue());
            }
            Integer num = controller.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (num != null) {
                int intValue = num.intValue();
                DialogDanaAlertBinding dialogDanaAlertBinding27 = this.BuiltInFictitiousFunctionClassFactory;
                if (dialogDanaAlertBinding27 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    dialogDanaAlertBinding = dialogDanaAlertBinding27;
                }
                dialogDanaAlertBinding.BuiltInFictitiousFunctionClassFactory.setMinWidth(intValue);
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onSaveInstanceState(p0);
        p0.putParcelable("CONTROLLER_KEY", this.MyBillsEntityDataFactory);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface p0) {
        Function0<Unit> function0;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onDismiss(p0);
        Controller controller = this.MyBillsEntityDataFactory;
        if (controller == null || (function0 = controller.DatabaseTableConfigUtil) == null) {
            return;
        }
        function0.invoke();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000"}, d2 = {"Lid/dana/core/ui/dialog/DanaAlertDialog$LinkKey;", "", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public @interface LinkKey {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.getAuthRequestContext;
        public static final String TNC = "TNC";

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/core/ui/dialog/DanaAlertDialog$LinkKey$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes8.dex */
        public static final class Companion {
            static final /* synthetic */ Companion getAuthRequestContext = new Companion();

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B«\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\"\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\"\u0012\b\u00107\u001a\u0004\u0018\u00010\"\u0012\b\u00108\u001a\u0004\u0018\u00010\"\u0012\b\u00109\u001a\u0004\u0018\u00010&\u0012\b\u0010:\u001a\u0004\u0018\u00010\"\u0012\b\u0010;\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010<\u001a\u00020\u0007\u0012\b\u0010=\u001a\u0004\u0018\u00010\"\u0012\b\u0010>\u001a\u0004\u0018\u00010\"\u0012\u0006\u0010?\u001a\u00020\u0007\u0012\u0006\u0010@\u001a\u00020\u0002\u0012\b\u0010A\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bF\u0010GJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0006¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0017\u0010\u001eR\u001a\u0010!\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001a\u0010\u001eR\u0013\u0010$\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b!\u0010#R\u0013\u0010%\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b%\u0010#R\u0013\u0010'\u001a\u0004\u0018\u00010&X\u0007¢\u0006\u0006\n\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u001f\u0010\u0014R\u0013\u0010*\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b$\u0010#R\u0013\u0010+\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b)\u0010#R\u001a\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010,X\u0087\u0002¢\u0006\u0006\n\u0004\b*\u0010-R\u001a\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010,X\u0087\u0002¢\u0006\u0006\n\u0004\b.\u0010-R \u00102\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0010\u0018\u000100X\u0087\u0002¢\u0006\u0006\n\u0004\b+\u00101R\u0013\u00103\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b/\u0010#R\u0013\u00104\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b2\u0010#R\u001a\u00105\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010,X\u0087\u0002¢\u0006\u0006\n\u0004\b3\u0010-R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b5\u0010#R\u0013\u00106\u001a\u0004\u0018\u00010\"X\u0007¢\u0006\u0006\n\u0004\b4\u0010#"}, d2 = {"Lid/dana/core/ui/dialog/DanaAlertDialog$Controller;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Landroid/os/Parcel;", "p1", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getAuthRequestContext", "Ljava/lang/Integer;", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "MyBillsEntityDataFactory", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/Boolean;", "newProxyInstance", "Z", "()Z", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda3", "lookAheadTest", "", "Ljava/lang/CharSequence;", "getErrorConfigVersion", "scheduleImpl", "Lid/dana/core/ui/dialog/LinksString;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/core/ui/dialog/LinksString;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "GetContactSyncConfig", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "initRecordTimeStamp", "DatabaseTableConfigUtil", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "NetworkUserEntityData$$ExternalSyntheticLambda7", "isLayoutRequested", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda6", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "p11", "p12", "p13", "p14", "p15", "p16", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lid/dana/core/ui/dialog/LinksString;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZLjava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final /* data */ class Controller implements Parcelable {
        public static final Parcelable.Creator<Controller> CREATOR = new Creator();

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        final Boolean KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda7;

        /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
        Function0<Unit> initRecordTimeStamp;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final int MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        final Integer BuiltInFictitiousFunctionClassFactory;
        final LinksString NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        Function1<? super String, Unit> NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda3  reason: from kotlin metadata */
        private final boolean lookAheadTest;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
        Function0<Unit> PrepareContext;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        final CharSequence isLayoutRequested;
        final String PlaceComponentResult;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        final CharSequence newProxyInstance;
        final Integer getAuthRequestContext;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        final CharSequence GetContactSyncConfig;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        Function0<Unit> DatabaseTableConfigUtil;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        final CharSequence NetworkUserEntityData$$ExternalSyntheticLambda6;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        final CharSequence getErrorConfigVersion;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        final Integer NetworkUserEntityData$$ExternalSyntheticLambda1;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        private final boolean moveToNextValue;
        final CharSequence scheduleImpl;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(Object p0) {
            if (this == p0) {
                return true;
            }
            if (p0 instanceof Controller) {
                Controller controller = (Controller) p0;
                return Intrinsics.areEqual(this.newProxyInstance, controller.newProxyInstance) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda6, controller.NetworkUserEntityData$$ExternalSyntheticLambda6) && Intrinsics.areEqual(this.getErrorConfigVersion, controller.getErrorConfigVersion) && Intrinsics.areEqual(this.scheduleImpl, controller.scheduleImpl) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda0, controller.NetworkUserEntityData$$ExternalSyntheticLambda0) && Intrinsics.areEqual(this.isLayoutRequested, controller.isLayoutRequested) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda7, controller.NetworkUserEntityData$$ExternalSyntheticLambda7) && this.lookAheadTest == controller.lookAheadTest && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, controller.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.GetContactSyncConfig, controller.GetContactSyncConfig) && this.moveToNextValue == controller.moveToNextValue && this.MyBillsEntityDataFactory == controller.MyBillsEntityDataFactory && Intrinsics.areEqual(this.PlaceComponentResult, controller.PlaceComponentResult) && Intrinsics.areEqual(this.BuiltInFictitiousFunctionClassFactory, controller.BuiltInFictitiousFunctionClassFactory) && Intrinsics.areEqual(this.getAuthRequestContext, controller.getAuthRequestContext) && Intrinsics.areEqual(this.KClassImpl$Data$declaredNonStaticMembers$2, controller.KClassImpl$Data$declaredNonStaticMembers$2) && Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda1, controller.NetworkUserEntityData$$ExternalSyntheticLambda1);
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            CharSequence charSequence = this.newProxyInstance;
            int hashCode = charSequence == null ? 0 : charSequence.hashCode();
            CharSequence charSequence2 = this.NetworkUserEntityData$$ExternalSyntheticLambda6;
            int hashCode2 = charSequence2 == null ? 0 : charSequence2.hashCode();
            CharSequence charSequence3 = this.getErrorConfigVersion;
            int hashCode3 = charSequence3 == null ? 0 : charSequence3.hashCode();
            CharSequence charSequence4 = this.scheduleImpl;
            int hashCode4 = charSequence4 == null ? 0 : charSequence4.hashCode();
            LinksString linksString = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            int hashCode5 = linksString == null ? 0 : linksString.hashCode();
            CharSequence charSequence5 = this.isLayoutRequested;
            int hashCode6 = charSequence5 == null ? 0 : charSequence5.hashCode();
            CharSequence charSequence6 = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            int hashCode7 = charSequence6 == null ? 0 : charSequence6.hashCode();
            boolean z = this.lookAheadTest;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            CharSequence charSequence7 = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            int hashCode8 = charSequence7 == null ? 0 : charSequence7.hashCode();
            CharSequence charSequence8 = this.GetContactSyncConfig;
            int hashCode9 = charSequence8 == null ? 0 : charSequence8.hashCode();
            boolean z2 = this.moveToNextValue;
            int i2 = z2 ? 1 : z2 ? 1 : 0;
            int i3 = this.MyBillsEntityDataFactory;
            String str = this.PlaceComponentResult;
            int hashCode10 = str == null ? 0 : str.hashCode();
            Integer num = this.BuiltInFictitiousFunctionClassFactory;
            int hashCode11 = num == null ? 0 : num.hashCode();
            Integer num2 = this.getAuthRequestContext;
            int hashCode12 = num2 == null ? 0 : num2.hashCode();
            Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode13 = bool == null ? 0 : bool.hashCode();
            Integer num3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            return (((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + i) * 31) + hashCode8) * 31) + hashCode9) * 31) + i2) * 31) + i3) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (num3 != null ? num3.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Controller(newProxyInstance=");
            sb.append((Object) this.newProxyInstance);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda6=");
            sb.append((Object) this.NetworkUserEntityData$$ExternalSyntheticLambda6);
            sb.append(", getErrorConfigVersion=");
            sb.append((Object) this.getErrorConfigVersion);
            sb.append(", scheduleImpl=");
            sb.append((Object) this.scheduleImpl);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda0=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda0);
            sb.append(", isLayoutRequested=");
            sb.append((Object) this.isLayoutRequested);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda7=");
            sb.append((Object) this.NetworkUserEntityData$$ExternalSyntheticLambda7);
            sb.append(", lookAheadTest=");
            sb.append(this.lookAheadTest);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda2=");
            sb.append((Object) this.NetworkUserEntityData$$ExternalSyntheticLambda2);
            sb.append(", GetContactSyncConfig=");
            sb.append((Object) this.GetContactSyncConfig);
            sb.append(", moveToNextValue=");
            sb.append(this.moveToNextValue);
            sb.append(", MyBillsEntityDataFactory=");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append(", PlaceComponentResult=");
            sb.append(this.PlaceComponentResult);
            sb.append(", BuiltInFictitiousFunctionClassFactory=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory);
            sb.append(", getAuthRequestContext=");
            sb.append(this.getAuthRequestContext);
            sb.append(", KClassImpl$Data$declaredNonStaticMembers$2=");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(", NetworkUserEntityData$$ExternalSyntheticLambda1=");
            sb.append(this.NetworkUserEntityData$$ExternalSyntheticLambda1);
            sb.append(')');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel p0, int p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            TextUtils.writeToParcel(this.newProxyInstance, p0, p1);
            TextUtils.writeToParcel(this.NetworkUserEntityData$$ExternalSyntheticLambda6, p0, p1);
            TextUtils.writeToParcel(this.getErrorConfigVersion, p0, p1);
            TextUtils.writeToParcel(this.scheduleImpl, p0, p1);
            LinksString linksString = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (linksString == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                linksString.writeToParcel(p0, p1);
            }
            TextUtils.writeToParcel(this.isLayoutRequested, p0, p1);
            TextUtils.writeToParcel(this.NetworkUserEntityData$$ExternalSyntheticLambda7, p0, p1);
            p0.writeInt(this.lookAheadTest ? 1 : 0);
            TextUtils.writeToParcel(this.NetworkUserEntityData$$ExternalSyntheticLambda2, p0, p1);
            TextUtils.writeToParcel(this.GetContactSyncConfig, p0, p1);
            p0.writeInt(this.moveToNextValue ? 1 : 0);
            p0.writeInt(this.MyBillsEntityDataFactory);
            p0.writeString(this.PlaceComponentResult);
            Integer num = this.BuiltInFictitiousFunctionClassFactory;
            if (num == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                p0.writeInt(num.intValue());
            }
            Integer num2 = this.getAuthRequestContext;
            if (num2 == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                p0.writeInt(num2.intValue());
            }
            Boolean bool = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (bool == null) {
                p0.writeInt(0);
            } else {
                p0.writeInt(1);
                p0.writeInt(bool.booleanValue() ? 1 : 0);
            }
            Integer num3 = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (num3 == null) {
                p0.writeInt(0);
                return;
            }
            p0.writeInt(1);
            p0.writeInt(num3.intValue());
        }

        public Controller(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, LinksString linksString, CharSequence charSequence5, CharSequence charSequence6, boolean z, CharSequence charSequence7, CharSequence charSequence8, boolean z2, int i, String str, Integer num, Integer num2, Boolean bool, Integer num3) {
            this.newProxyInstance = charSequence;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = charSequence2;
            this.getErrorConfigVersion = charSequence3;
            this.scheduleImpl = charSequence4;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = linksString;
            this.isLayoutRequested = charSequence5;
            this.NetworkUserEntityData$$ExternalSyntheticLambda7 = charSequence6;
            this.lookAheadTest = z;
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = charSequence7;
            this.GetContactSyncConfig = charSequence8;
            this.moveToNextValue = z2;
            this.MyBillsEntityDataFactory = i;
            this.PlaceComponentResult = str;
            this.BuiltInFictitiousFunctionClassFactory = num;
            this.getAuthRequestContext = num2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = bool;
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = num3;
        }

        @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
        public final boolean getLookAheadTest() {
            return this.lookAheadTest;
        }

        @JvmName(name = "MyBillsEntityDataFactory")
        /* renamed from: MyBillsEntityDataFactory  reason: from getter */
        public final boolean getMoveToNextValue() {
            return this.moveToNextValue;
        }

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Creator implements Parcelable.Creator<Controller> {
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Controller createFromParcel(Parcel parcel) {
                Boolean valueOf;
                Intrinsics.checkNotNullParameter(parcel, "");
                CharSequence charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                CharSequence charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                CharSequence charSequence3 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                CharSequence charSequence4 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                LinksString createFromParcel = parcel.readInt() == 0 ? null : LinksString.CREATOR.createFromParcel(parcel);
                CharSequence charSequence5 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                CharSequence charSequence6 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                boolean z = parcel.readInt() != 0;
                CharSequence charSequence7 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                CharSequence charSequence8 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                boolean z2 = parcel.readInt() != 0;
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                if (parcel.readInt() == 0) {
                    valueOf = null;
                } else {
                    valueOf = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new Controller(charSequence, charSequence2, charSequence3, charSequence4, createFromParcel, charSequence5, charSequence6, z, charSequence7, charSequence8, z2, readInt, readString, valueOf2, valueOf3, valueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Controller[] newArray(int i) {
                return new Controller[i];
            }
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\f¢\u0006\u0004\b1\u00102J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005@BX\u0086\n¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R \u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\b@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R \u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0013\u0010\u0010R \u0010\u0018\u001a\u0004\u0018\u00010\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0015@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015@BX\u0086\n¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR \u0010\u0016\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b\u0018\u0010\u001dR \u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR \u0010\"\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001f@BX\u0086\n¢\u0006\u0006\n\u0004\b \u0010!R \u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005@BX\u0086\n¢\u0006\u0006\n\u0004\b#\u0010\u0010R \u0010 \u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b\"\u0010\u001dR \u0010%\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b$\u0010\u001dR,\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&@BX\u0086\n¢\u0006\u0006\n\u0004\b%\u0010'R,\u0010)\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&@BX\u0086\n¢\u0006\u0006\n\u0004\b(\u0010'R8\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007@BX\u0086\n¢\u0006\u0006\n\u0004\b)\u0010*R \u0010,\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b+\u0010\u001dR \u0010-\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b,\u0010\u001dR,\u0010(\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&@BX\u0086\n¢\u0006\u0006\n\u0004\b-\u0010'R \u0010/\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b.\u0010\u001dR \u00100\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001c@BX\u0086\n¢\u0006\u0006\n\u0004\b0\u0010\u001d"}, d2 = {"Lid/dana/core/ui/dialog/DanaAlertDialog$Builder;", "", "Lid/dana/core/ui/dialog/DanaAlertDialog;", "BuiltInFictitiousFunctionClassFactory", "()Lid/dana/core/ui/dialog/DanaAlertDialog;", "", "p0", "Lkotlin/Function1;", "", "", "p1", "(ILkotlin/jvm/functions/Function1;)Lid/dana/core/ui/dialog/DanaAlertDialog$Builder;", "Landroid/content/Context;", "getAuthRequestContext", "Landroid/content/Context;", "PlaceComponentResult", "Ljava/lang/Integer;", "MyBillsEntityDataFactory", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/lang/String;", "", "moveToNextValue", "Ljava/lang/Boolean;", "lookAheadTest", "getErrorConfigVersion", "Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "", "Ljava/lang/CharSequence;", "scheduleImpl", "Lid/dana/core/ui/dialog/LinksString;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/core/ui/dialog/LinksString;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "GetContactSyncConfig", "DatabaseTableConfigUtil", "initRecordTimeStamp", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "newProxyInstance", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Lkotlin/jvm/functions/Function1;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "isLayoutRequested", "PrepareContext", "NetworkUserEntityData$$ExternalSyntheticLambda5", "NetworkUserEntityData$$ExternalSyntheticLambda4", "NetworkUserEntityData$$ExternalSyntheticLambda3", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        public int KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
        public CharSequence initRecordTimeStamp;
        public Integer GetContactSyncConfig;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        public Integer PlaceComponentResult;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        public String getAuthRequestContext;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
        public boolean getErrorConfigVersion;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
        public LinksString NetworkUserEntityData$$ExternalSyntheticLambda2;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda1;
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda3;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda5  reason: from kotlin metadata */
        public CharSequence NetworkUserEntityData$$ExternalSyntheticLambda4;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
        public Function1<? super String, Unit> NetworkUserEntityData$$ExternalSyntheticLambda8;

        /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
        public CharSequence isLayoutRequested;

        /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
        public Integer MyBillsEntityDataFactory;

        /* renamed from: PrepareContext  reason: from kotlin metadata */
        public Function0<Unit> newProxyInstance;

        /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
        public final Context BuiltInFictitiousFunctionClassFactory;

        /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
        public boolean NetworkUserEntityData$$ExternalSyntheticLambda0;

        /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
        public Function0<Unit> DatabaseTableConfigUtil;

        /* renamed from: isLayoutRequested  reason: from kotlin metadata */
        public CharSequence PrepareContext;

        /* renamed from: lookAheadTest  reason: from kotlin metadata */
        public CharSequence moveToNextValue;

        /* renamed from: moveToNextValue  reason: from kotlin metadata */
        public Boolean lookAheadTest;

        /* renamed from: newProxyInstance  reason: from kotlin metadata */
        public Function0<Unit> NetworkUserEntityData$$ExternalSyntheticLambda7;
        public CharSequence scheduleImpl;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "");
            this.BuiltInFictitiousFunctionClassFactory = context;
            this.getErrorConfigVersion = true;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
        }

        public final Builder BuiltInFictitiousFunctionClassFactory(int p0, Function1<? super String, Unit> p1) {
            Intrinsics.checkNotNullParameter(p1, "");
            String string = this.BuiltInFictitiousFunctionClassFactory.getString(p0);
            Intrinsics.checkNotNullExpressionValue(string, "");
            p1.invoke(string);
            this.PrepareContext = string;
            return this;
        }

        public final DanaAlertDialog BuiltInFictitiousFunctionClassFactory() {
            DanaAlertDialog danaAlertDialog = new DanaAlertDialog();
            Controller controller = new Controller(this.NetworkUserEntityData$$ExternalSyntheticLambda4, this.NetworkUserEntityData$$ExternalSyntheticLambda3, this.moveToNextValue, this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.PrepareContext, this.isLayoutRequested, this.getErrorConfigVersion, this.initRecordTimeStamp, this.NetworkUserEntityData$$ExternalSyntheticLambda1, this.NetworkUserEntityData$$ExternalSyntheticLambda0, this.KClassImpl$Data$declaredNonStaticMembers$2, this.getAuthRequestContext, this.PlaceComponentResult, this.MyBillsEntityDataFactory, this.lookAheadTest, this.GetContactSyncConfig);
            controller.PrepareContext = this.newProxyInstance;
            controller.initRecordTimeStamp = this.DatabaseTableConfigUtil;
            controller.DatabaseTableConfigUtil = this.NetworkUserEntityData$$ExternalSyntheticLambda7;
            controller.NetworkUserEntityData$$ExternalSyntheticLambda8 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            Intrinsics.checkNotNullParameter(controller, "");
            danaAlertDialog.MyBillsEntityDataFactory = controller;
            return danaAlertDialog;
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Controller controller, DanaAlertDialog danaAlertDialog) {
        Intrinsics.checkNotNullParameter(controller, "");
        Intrinsics.checkNotNullParameter(danaAlertDialog, "");
        Function0<Unit> function0 = controller.initRecordTimeStamp;
        if (function0 != null) {
            function0.invoke();
        }
        if (controller.getMoveToNextValue()) {
            danaAlertDialog.dismiss();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Controller controller, DanaAlertDialog danaAlertDialog) {
        Intrinsics.checkNotNullParameter(controller, "");
        Intrinsics.checkNotNullParameter(danaAlertDialog, "");
        Function0<Unit> function0 = controller.PrepareContext;
        if (function0 != null) {
            function0.invoke();
        }
        if (controller.getLookAheadTest()) {
            danaAlertDialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
