package id.dana.social.view.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog$bottomSheetCallback$2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0014\u0012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u0014¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0013\u001a\u00020\u0010X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0006¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c"}, d2 = {"Lid/dana/social/view/fragment/SocialModifyRelationBotttomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "Landroid/os/Bundle;", "p0", "", "onCreate", "(Landroid/os/Bundle;)V", "onShow", "()V", "onStart", "Lid/dana/social/view/fragment/SocialModifyRelationBotttomSheetDialog$bottomSheetCallback$2$1;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lkotlin/Lazy;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function0;", "lookAheadTest", "Lkotlin/jvm/functions/Function0;", "MyBillsEntityDataFactory", "scheduleImpl", "getAuthRequestContext", "", "moveToNextValue", "Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "p1", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialModifyRelationBotttomSheetDialog extends BaseBottomSheetDialogFragment {
    public static final byte[] $$d = {15, -40, -114, -21, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$e = 165;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {0, Byte.MIN_VALUE, -111, -10, 6, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getErrorConfigVersion = 125;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    public final Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    public String KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final Function0<Unit> getAuthRequestContext;

    private View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        View findViewById;
        Map<Integer, View> map = this.KClassImpl$Data$declaredNonStaticMembers$2;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null || (findViewById = view2.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, int r8, short r9, java.lang.Object[] r10) {
        /*
            int r8 = r8 * 3
            int r8 = r8 + 16
            int r9 = r9 + 5
            int r7 = 106 - r7
            byte[] r0 = id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog.NetworkUserEntityData$$ExternalSyntheticLambda0
            byte[] r1 = new byte[r8]
            r2 = 0
            if (r0 != 0) goto L16
            r3 = r1
            r5 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L31
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r7
            int r5 = r3 + 1
            r1[r3] = r4
            int r9 = r9 + 1
            if (r5 != r8) goto L28
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L28:
            r3 = r0[r9]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L31:
            int r7 = r7 + r8
            int r7 = r7 + 2
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog.c(int, int, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 + 4
            byte[] r0 = id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog.$$d
            int r8 = r8 * 4
            int r8 = 75 - r8
            int r7 = r7 * 2
            int r7 = r7 + 42
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L36
        L1a:
            r3 = 0
        L1b:
            int r6 = r6 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r4 = r0[r6]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L36:
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog.d(byte, short, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.bottom_sheet_modify_relationship_coordinator;
    }

    public SocialModifyRelationBotttomSheetDialog(Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
        this.getAuthRequestContext = function0;
        this.MyBillsEntityDataFactory = function02;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = "";
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<SocialModifyRelationBotttomSheetDialog$bottomSheetCallback$2.AnonymousClass1>() { // from class: id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog$bottomSheetCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog$bottomSheetCallback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                final SocialModifyRelationBotttomSheetDialog socialModifyRelationBotttomSheetDialog = SocialModifyRelationBotttomSheetDialog.this;
                return new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog$bottomSheetCallback$2.1
                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onSlide(View p0, float p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                    }

                    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                    public final void onStateChanged(View p0, int p1) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        if (5 == p1) {
                            SocialModifyRelationBotttomSheetDialog.this.dismissAllowingStateLoss();
                        }
                    }
                };
            }
        });
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = NetworkUserEntityData$$ExternalSyntheticLambda0[0];
            byte b2 = b;
            Object[] objArr = new Object[1];
            c(b, b2, (byte) (b2 | 14), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            c((byte) (-NetworkUserEntityData$$ExternalSyntheticLambda0[6]), NetworkUserEntityData$$ExternalSyntheticLambda0[0], NetworkUserEntityData$$ExternalSyntheticLambda0[6], objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getFadingEdgeLength() >> 16), View.resolveSizeAndState(0, 0, 0) + 4, (char) TextUtils.indexOf("", "", 0, 0));
                    byte b3 = $$d[4];
                    byte b4 = (byte) (b3 + 1);
                    Object[] objArr4 = new Object[1];
                    d(b3, b4, b4, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetAfter("", 0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-2082805658, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - TextUtils.lastIndexOf("", '0', 0, 0), 18 - Color.blue(0), (char) Drawable.resolveOpacity(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        initMatchParentDialog(getDialog());
        initTransparentDialogDim(getDialog());
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(getScreenHeight(getDialog()), 3);
        BottomSheetBehavior<View> bottomSheetBehavior = this.bottomSheetBehavior;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.addBottomSheetCallback((SocialModifyRelationBotttomSheetDialog$bottomSheetCallback$2.AnonymousClass1) this.BuiltInFictitiousFunctionClassFactory.getValue());
        }
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        AppCompatTextView appCompatTextView = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.modify_relationship_mute);
        if (appCompatTextView != null) {
            appCompatTextView.setText(Intrinsics.areEqual(str, "ACTIVE") ? getString(R.string.mute_friendship_profile) : getString(R.string.unmute_friendship_profile));
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.modify_relationship_mute);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SocialModifyRelationBotttomSheetDialog.MyBillsEntityDataFactory(SocialModifyRelationBotttomSheetDialog.this);
                }
            });
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.modify_relationship_block);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.fragment.SocialModifyRelationBotttomSheetDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SocialModifyRelationBotttomSheetDialog.PlaceComponentResult(SocialModifyRelationBotttomSheetDialog.this);
                }
            });
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(SocialModifyRelationBotttomSheetDialog socialModifyRelationBotttomSheetDialog) {
        Intrinsics.checkNotNullParameter(socialModifyRelationBotttomSheetDialog, "");
        socialModifyRelationBotttomSheetDialog.getAuthRequestContext.invoke();
        socialModifyRelationBotttomSheetDialog.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void PlaceComponentResult(SocialModifyRelationBotttomSheetDialog socialModifyRelationBotttomSheetDialog) {
        Intrinsics.checkNotNullParameter(socialModifyRelationBotttomSheetDialog, "");
        socialModifyRelationBotttomSheetDialog.MyBillsEntityDataFactory.invoke();
        socialModifyRelationBotttomSheetDialog.dismissAllowingStateLoss();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
