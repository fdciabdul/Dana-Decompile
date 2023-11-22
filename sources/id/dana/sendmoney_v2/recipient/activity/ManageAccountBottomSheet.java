package id.dana.sendmoney_v2.recipient.activity;

import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.component.edittextcomponent.DanaEditTextView;
import id.dana.component.extension.ViewExtKt;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.databinding.BaseBottomSheetManageBankAccountBinding;
import id.dana.databinding.ViewBottomSheetManageBankAccountBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.model.RecentRecipientModel;
import id.dana.sendmoney.model.RecipientModel;
import id.dana.sendmoney.model.RecipientModelExtKt;
import id.dana.sendmoney.recipient.RecipientIdType;
import id.dana.sendmoney.recipient.RecipientType;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;
import id.dana.sendmoney_v2.landing.contract.ManageAccountContract;
import id.dana.sendmoney_v2.landing.di.component.DaggerManageAccountComponent;
import id.dana.sendmoney_v2.landing.di.module.ManageAccountModule;
import id.dana.utils.CustomToastUtil;
import id.dana.utils.TextUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001DBk\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n0/\u0012\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\n02\u0012\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0/\u0012&\b\u0002\u0010#\u001a \u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n06¢\u0006\u0004\bB\u0010CJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0005\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00172\b\u0010\u000e\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u000b\u0010\u001bJ\u0017\u0010\u0005\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u0005\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u001e\u0010\fJ1\u0010\u0005\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b\u0005\u0010$J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b%\u0010\fJ\u000f\u0010&\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010\fJ\u0017\u0010'\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010\b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\b\u0010)R\u0016\u0010\u0005\u001a\u00020 8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010,R\u0016\u0010\b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\"\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\n0/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n0/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00101R4\u00109\u001a \u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\n068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0012\u0010;\u001a\u00020:X\u0087\"¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u001c8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b=\u0010>R\u0012\u0010%\u001a\u00020\u001cX\u0087\"¢\u0006\u0006\n\u0004\b\b\u0010>R\u0016\u0010A\u001a\u00020 8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b@\u0010+"}, d2 = {"Lid/dana/sendmoney_v2/recipient/activity/ManageAccountBottomSheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/BaseBottomSheetManageBankAccountBinding;", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$View;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "Lid/dana/sendmoney/model/RecentRecipientModel;", "p0", "", "(Lid/dana/sendmoney/model/RecentRecipientModel;)Z", "Landroid/content/DialogInterface;", "onCancel", "(Landroid/content/DialogInterface;)V", "Landroid/os/Bundle;", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "", "(I)V", "Lid/dana/sendmoney/model/RecipientModel;", "(Lid/dana/sendmoney/model/RecipientModel;)V", "MyBillsEntityDataFactory", "", "", "p1", "p2", "p3", "(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorConfigVersion", "lookAheadTest", "PlaceComponentResult", "(Z)V", "(Ljava/lang/Throwable;)V", "initRecordTimeStamp", "Ljava/lang/String;", "Ljava/lang/Integer;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "I", "Lkotlin/Function1;", "GetContactSyncConfig", "Lkotlin/jvm/functions/Function1;", "Lkotlin/Function0;", "isLayoutRequested", "Lkotlin/jvm/functions/Function0;", "PrepareContext", "Lkotlin/Function4;", "NetworkUserEntityData$$ExternalSyntheticLambda8", "Lkotlin/jvm/functions/Function4;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$Presenter;", "presenter", "Lid/dana/sendmoney_v2/landing/contract/ManageAccountContract$Presenter;", "newProxyInstance", "Lid/dana/sendmoney/model/RecipientModel;", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda7", "moveToNextValue", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManageAccountBottomSheet extends BaseViewBindingBottomSheetDialogFragment<BaseBottomSheetManageBankAccountBinding> implements ManageAccountContract.View {

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private Function1<? super Throwable, Unit> PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public RecipientModel getErrorConfigVersion;
    public Map<Integer, View> MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private String moveToNextValue;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda8  reason: from kotlin metadata */
    private Function4<? super Throwable, ? super String, ? super String, ? super String, Unit> NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Integer getAuthRequestContext;

    /* renamed from: PrepareContext  reason: from kotlin metadata */
    private Function1<? super RecipientModel, Unit> lookAheadTest;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private Function0<Unit> MyBillsEntityDataFactory;

    /* renamed from: newProxyInstance  reason: from kotlin metadata */
    private RecipientModel scheduleImpl;
    @Inject
    public ManageAccountContract.Presenter presenter;
    public static final byte[] $$a = {15, -40, -114, -21, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 240;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda2 = {41, -91, 83, 107, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int DatabaseTableConfigUtil = 194;

    public ManageAccountBottomSheet() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.NetworkUserEntityData$$ExternalSyntheticLambda2
            int r6 = r6 * 4
            int r6 = 16 - r6
            int r7 = r7 * 15
            int r7 = 19 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L33
        L1a:
            r3 = 0
        L1b:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            r3 = r0[r7]
            r5 = r8
            r8 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L33:
            int r9 = r9 + r7
            int r7 = r9 + 2
            int r8 = r8 + 1
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L1b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.a(int, short, short, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002c -> B:11:0x0038). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = 42 - r8
            int r6 = r6 * 4
            int r6 = r6 + 75
            int r7 = r7 * 4
            int r7 = 3 - r7
            byte[] r0 = id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            r8 = r7
            goto L38
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r7 = r7 + 1
            if (r3 != r8) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r4 = r0[r7]
            int r3 = r3 + 1
            r5 = r8
            r8 = r7
            r7 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r9
            r9 = r5
        L38:
            int r7 = -r7
            int r6 = r6 + r7
            int r6 = r6 + (-7)
            r7 = r8
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.b(byte, short, short, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void dismissProgress() {
        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView
    public final /* synthetic */ String getErrorSource() {
        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void onError(String str) {
        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
    public final /* synthetic */ void showProgress() {
        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
    }

    private ManageAccountBottomSheet(Function1<? super RecipientModel, Unit> function1, Function0<Unit> function0, Function1<? super Throwable, Unit> function12, Function4<? super Throwable, ? super String, ? super String, ? super String, Unit> function4) {
        Intrinsics.checkNotNullParameter(function1, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function12, "");
        Intrinsics.checkNotNullParameter(function4, "");
        this.MyBillsEntityDataFactory = new LinkedHashMap();
        this.lookAheadTest = function1;
        this.MyBillsEntityDataFactory = function0;
        this.PlaceComponentResult = function12;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = function4;
        this.getAuthRequestContext = 0;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ BaseBottomSheetManageBankAccountBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        BaseBottomSheetManageBankAccountBinding authRequestContext = BaseBottomSheetManageBankAccountBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public /* synthetic */ ManageAccountBottomSheet(AnonymousClass1 anonymousClass1, AnonymousClass2 anonymousClass2, AnonymousClass3 anonymousClass3, AnonymousClass4 anonymousClass4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new Function1<RecipientModel, Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(RecipientModel recipientModel) {
                Intrinsics.checkNotNullParameter(recipientModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(RecipientModel recipientModel) {
                invoke2(recipientModel);
                return Unit.INSTANCE;
            }
        } : anonymousClass1, (i & 2) != 0 ? new Function0<Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.2
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : anonymousClass2, (i & 4) != 0 ? new Function1<Throwable, Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.3
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }
        } : anonymousClass3, (i & 8) != 0 ? new Function4<Throwable, String, String, String, Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet.4
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th, String str, String str2, String str3) {
                Intrinsics.checkNotNullParameter(th, "");
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
            }

            @Override // kotlin.jvm.functions.Function4
            public final /* bridge */ /* synthetic */ Unit invoke(Throwable th, String str, String str2, String str3) {
                invoke2(th, str, str2, str3);
                return Unit.INSTANCE;
            }
        } : anonymousClass4);
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        super.getAuthRequestContext();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        setCancelable(true);
        this.BuiltInFictitiousFunctionClassFactory = String.valueOf(getTag());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda2[5] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda2[5] + 1);
            byte b4 = (byte) (-NetworkUserEntityData$$ExternalSyntheticLambda2[5]);
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.MeasureSpec.makeMeasureSpec(0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 5, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)));
                    byte b5 = (byte) ($$a[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    b(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 36 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), (char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {770664298, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + 911, 18 - (ViewConfiguration.getJumpTapTimeout() >> 16), (char) KeyEvent.getDeadChar(0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle p0) {
        final Context requireContext = requireContext();
        final int theme = getTheme();
        return new BottomSheetDialog(requireContext, theme) { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$onCreateDialog$1
            @Override // androidx.view.ComponentDialog, android.app.Dialog
            public final void onBackPressed() {
                cancel();
            }
        };
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        DaggerManageAccountComponent.Builder PlaceComponentResult = DaggerManageAccountComponent.PlaceComponentResult();
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        PlaceComponentResult.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) application).getApplicationComponent());
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = (ManageAccountModule) Preconditions.getAuthRequestContext(new ManageAccountModule(this));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, ManageAccountModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult.getAuthRequestContext, ApplicationComponent.class);
        new DaggerManageAccountComponent.ManageAccountComponentImpl(PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2, PlaceComponentResult.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        ManageAccountContract.Presenter presenter = this.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.BuiltInFictitiousFunctionClassFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
            BottomSheetBehavior<View> o_ = o_();
            if (o_ != null) {
                o_.setHideable(false);
            }
            String str = this.BuiltInFictitiousFunctionClassFactory;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                str = null;
            }
            if (!Intrinsics.areEqual(str, "MANAGE_SAVED_BANK")) {
                if (Intrinsics.areEqual(str, "MANAGE_QUICK_ACTION")) {
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        final RecentRecipientModel recipientHoldClickAction = ((SendMoneyActivity) activity2).getRecipientHoldClickAction();
                        if (recipientHoldClickAction != null) {
                            VB vb = this.MyBillsEntityDataFactory;
                            if (vb != 0) {
                                ViewBottomSheetManageBankAccountBinding viewBottomSheetManageBankAccountBinding = ((BaseBottomSheetManageBankAccountBinding) vb).BuiltInFictitiousFunctionClassFactory;
                                if (recipientHoldClickAction.isLayoutRequested == 2) {
                                    if (!Intrinsics.areEqual(recipientHoldClickAction.getAuthRequestContext, "-") && !Intrinsics.areEqual(recipientHoldClickAction.PlaceComponentResult(), "-")) {
                                        String str2 = recipientHoldClickAction.getAuthRequestContext;
                                        if (str2 == null) {
                                            str2 = recipientHoldClickAction.PlaceComponentResult();
                                        }
                                        String MyBillsEntityDataFactory = TextUtil.MyBillsEntityDataFactory(str2, "\\*");
                                        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                                        this.moveToNextValue = MyBillsEntityDataFactory;
                                    } else {
                                        String str3 = recipientHoldClickAction.getErrorConfigVersion;
                                        Intrinsics.checkNotNullExpressionValue(str3, "");
                                        this.moveToNextValue = str3;
                                        VB vb2 = this.MyBillsEntityDataFactory;
                                        if (vb2 != 0) {
                                            ((BaseBottomSheetManageBankAccountBinding) vb2).BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion.setVisibility(8);
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    }
                                    TextView textView = viewBottomSheetManageBankAccountBinding.DatabaseTableConfigUtil;
                                    String str4 = this.moveToNextValue;
                                    if (str4 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("");
                                    } else {
                                        r2 = str4;
                                    }
                                    textView.setText(r2);
                                    viewBottomSheetManageBankAccountBinding.getErrorConfigVersion.setText(recipientHoldClickAction.getErrorConfigVersion);
                                    viewBottomSheetManageBankAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(8);
                                    viewBottomSheetManageBankAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
                                    viewBottomSheetManageBankAccountBinding.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                                    viewBottomSheetManageBankAccountBinding.MyBillsEntityDataFactory.setVisibility(0);
                                    PlaceComponentResult(recipientHoldClickAction.getErrorConfigVersion());
                                } else if (recipientHoldClickAction.isLayoutRequested == 4) {
                                    TextView textView2 = viewBottomSheetManageBankAccountBinding.DatabaseTableConfigUtil;
                                    String str5 = recipientHoldClickAction.getAuthRequestContext;
                                    if (str5 == null) {
                                        str5 = recipientHoldClickAction.PlaceComponentResult();
                                    }
                                    textView2.setText(str5);
                                    viewBottomSheetManageBankAccountBinding.getErrorConfigVersion.setText(TextUtil.BuiltInFictitiousFunctionClassFactory(TextUtil.MyBillsEntityDataFactory(recipientHoldClickAction.getErrorConfigVersion)));
                                    viewBottomSheetManageBankAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(recipientHoldClickAction.BuiltInFictitiousFunctionClassFactory);
                                    viewBottomSheetManageBankAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(0);
                                    viewBottomSheetManageBankAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(0);
                                    viewBottomSheetManageBankAccountBinding.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                                    viewBottomSheetManageBankAccountBinding.MyBillsEntityDataFactory.setVisibility(0);
                                    PlaceComponentResult(recipientHoldClickAction.getErrorConfigVersion());
                                } else if (recipientHoldClickAction.isLayoutRequested == 7) {
                                    TextView textView3 = viewBottomSheetManageBankAccountBinding.DatabaseTableConfigUtil;
                                    String str6 = recipientHoldClickAction.getAuthRequestContext;
                                    if (str6 == null) {
                                        str6 = recipientHoldClickAction.PlaceComponentResult();
                                    }
                                    textView3.setText(str6);
                                    viewBottomSheetManageBankAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda1.setVisibility(8);
                                    viewBottomSheetManageBankAccountBinding.NetworkUserEntityData$$ExternalSyntheticLambda0.setVisibility(8);
                                    TextView textView4 = viewBottomSheetManageBankAccountBinding.getErrorConfigVersion;
                                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                    String string = getString(R.string.group_x2p_description);
                                    Intrinsics.checkNotNullExpressionValue(string, "");
                                    String format = String.format(string, Arrays.copyOf(new Object[]{recipientHoldClickAction.moveToNextValue}, 1));
                                    Intrinsics.checkNotNullExpressionValue(format, "");
                                    textView4.setText(format);
                                    viewBottomSheetManageBankAccountBinding.BuiltInFictitiousFunctionClassFactory.setVisibility(8);
                                    viewBottomSheetManageBankAccountBinding.MyBillsEntityDataFactory.setVisibility(0);
                                    viewBottomSheetManageBankAccountBinding.MyBillsEntityDataFactory.setCellLeftIconLabel(R.drawable.ic_delete_account_bank, getString(R.string.delete_group));
                                    PlaceComponentResult(recipientHoldClickAction.getErrorConfigVersion());
                                    String string2 = getString(R.string.add_group_to_favorite);
                                    Intrinsics.checkNotNullExpressionValue(string2, "");
                                    String string3 = getString(R.string.delete_group_from_favorite);
                                    Intrinsics.checkNotNullExpressionValue(string3, "");
                                    VB vb3 = this.MyBillsEntityDataFactory;
                                    if (vb3 != 0) {
                                        ((BaseBottomSheetManageBankAccountBinding) vb3).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setCellLeftIconLabel(R.drawable.ic_favorite_star_orange, string3);
                                        VB vb4 = this.MyBillsEntityDataFactory;
                                        if (vb4 != 0) {
                                            ((BaseBottomSheetManageBankAccountBinding) vb4).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setCellLeftIconLabel(R.drawable.ic_favorite_star, string2);
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                }
                                VB vb5 = this.MyBillsEntityDataFactory;
                                if (vb5 != 0) {
                                    ((BaseBottomSheetManageBankAccountBinding) vb5).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda1
                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            ManageAccountBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(ManageAccountBottomSheet.this, recipientHoldClickAction);
                                        }
                                    });
                                    VB vb6 = this.MyBillsEntityDataFactory;
                                    if (vb6 != 0) {
                                        ((BaseBottomSheetManageBankAccountBinding) vb6).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda2
                                            @Override // android.view.View.OnClickListener
                                            public final void onClick(View view) {
                                                ManageAccountBottomSheet.PlaceComponentResult(ManageAccountBottomSheet.this, recipientHoldClickAction);
                                            }
                                        });
                                        VB vb7 = this.MyBillsEntityDataFactory;
                                        if (vb7 != 0) {
                                            ((BaseBottomSheetManageBankAccountBinding) vb7).BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda3
                                                @Override // android.view.View.OnClickListener
                                                public final void onClick(View view) {
                                                    ManageAccountBottomSheet.MyBillsEntityDataFactory(ManageAccountBottomSheet.this, recipientHoldClickAction);
                                                }
                                            });
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.SendMoneyActivity");
                    }
                }
            } else {
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    final RecipientModel recipientSelectedMoreAction = ((BankRecipientActivity) activity3).getRecipientSelectedMoreAction();
                    if (recipientSelectedMoreAction != null) {
                        VB vb8 = this.MyBillsEntityDataFactory;
                        if (vb8 != 0) {
                            TextView textView5 = ((BaseBottomSheetManageBankAccountBinding) vb8).BuiltInFictitiousFunctionClassFactory.DatabaseTableConfigUtil;
                            String str7 = recipientSelectedMoreAction.getAuthRequestContext;
                            if (str7 == null) {
                                str7 = recipientSelectedMoreAction.PlaceComponentResult();
                            }
                            textView5.setText(str7);
                            VB vb9 = this.MyBillsEntityDataFactory;
                            if (vb9 != 0) {
                                ((BaseBottomSheetManageBankAccountBinding) vb9).BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion.setText(TextUtil.BuiltInFictitiousFunctionClassFactory(TextUtil.MyBillsEntityDataFactory(recipientSelectedMoreAction.getErrorConfigVersion)));
                                VB vb10 = this.MyBillsEntityDataFactory;
                                if (vb10 != 0) {
                                    ((BaseBottomSheetManageBankAccountBinding) vb10).BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(recipientSelectedMoreAction.BuiltInFictitiousFunctionClassFactory);
                                    VB vb11 = this.MyBillsEntityDataFactory;
                                    if (vb11 != 0) {
                                        ((BaseBottomSheetManageBankAccountBinding) vb11).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.setVisibility(0);
                                        VB vb12 = this.MyBillsEntityDataFactory;
                                        if (vb12 != 0) {
                                            ((BaseBottomSheetManageBankAccountBinding) vb12).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setVisibility(0);
                                            VB vb13 = this.MyBillsEntityDataFactory;
                                            if (vb13 != 0) {
                                                ((BaseBottomSheetManageBankAccountBinding) vb13).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setVisibility(8);
                                                Intrinsics.checkNotNullParameter(recipientSelectedMoreAction, "");
                                                this.getErrorConfigVersion = recipientSelectedMoreAction;
                                                VB vb14 = this.MyBillsEntityDataFactory;
                                                if (vb14 != 0) {
                                                    ((BaseBottomSheetManageBankAccountBinding) vb14).BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda5
                                                        @Override // android.view.View.OnClickListener
                                                        public final void onClick(View view) {
                                                            ManageAccountBottomSheet.PlaceComponentResult(ManageAccountBottomSheet.this);
                                                        }
                                                    });
                                                    VB vb15 = this.MyBillsEntityDataFactory;
                                                    if (vb15 != 0) {
                                                        ((BaseBottomSheetManageBankAccountBinding) vb15).MyBillsEntityDataFactory.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda0
                                                            @Override // android.view.View.OnClickListener
                                                            public final void onClick(View view) {
                                                                ManageAccountBottomSheet.PlaceComponentResult(ManageAccountBottomSheet.this, recipientSelectedMoreAction);
                                                            }
                                                        });
                                                        VB vb16 = this.MyBillsEntityDataFactory;
                                                        if (vb16 != 0) {
                                                            ((BaseBottomSheetManageBankAccountBinding) vb16).BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda7
                                                                @Override // android.view.View.OnClickListener
                                                                public final void onClick(View view) {
                                                                    ManageAccountBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(ManageAccountBottomSheet.this);
                                                                }
                                                            });
                                                            VB vb17 = this.MyBillsEntityDataFactory;
                                                            if (vb17 != 0) {
                                                                DanaEditTextView danaEditTextView = ((BaseBottomSheetManageBankAccountBinding) vb17).MyBillsEntityDataFactory.getAuthRequestContext;
                                                                danaEditTextView.setEnabled(true);
                                                                Intrinsics.checkNotNullExpressionValue(danaEditTextView, "");
                                                                FragmentActivity activity4 = getActivity();
                                                                if (activity4 != null) {
                                                                    RecipientModel recipientSelectedMoreAction2 = ((BankRecipientActivity) activity4).getRecipientSelectedMoreAction();
                                                                    String str8 = recipientSelectedMoreAction2 != null ? recipientSelectedMoreAction2.getAuthRequestContext : null;
                                                                    if (((str8 == null || str8.length() == 0) ? (byte) 1 : (byte) 0) == 0) {
                                                                        FragmentActivity activity5 = getActivity();
                                                                        if (activity5 != null) {
                                                                            RecipientModel recipientSelectedMoreAction3 = ((BankRecipientActivity) activity5).getRecipientSelectedMoreAction();
                                                                            danaEditTextView.setText(recipientSelectedMoreAction3 != null ? recipientSelectedMoreAction3.getAuthRequestContext : null);
                                                                        } else {
                                                                            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                                                                        }
                                                                    } else {
                                                                        FragmentActivity activity6 = getActivity();
                                                                        if (activity6 != null) {
                                                                            RecipientModel recipientSelectedMoreAction4 = ((BankRecipientActivity) activity6).getRecipientSelectedMoreAction();
                                                                            danaEditTextView.setText(recipientSelectedMoreAction4 != null ? recipientSelectedMoreAction4.PlaceComponentResult() : null);
                                                                        } else {
                                                                            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                                                                        }
                                                                    }
                                                                } else {
                                                                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                                                                }
                                                            } else {
                                                                throw new IllegalArgumentException("Required value was null.".toString());
                                                            }
                                                        } else {
                                                            throw new IllegalArgumentException("Required value was null.".toString());
                                                        }
                                                    } else {
                                                        throw new IllegalArgumentException("Required value was null.".toString());
                                                    }
                                                } else {
                                                    throw new IllegalArgumentException("Required value was null.".toString());
                                                }
                                            } else {
                                                throw new IllegalArgumentException("Required value was null.".toString());
                                            }
                                        } else {
                                            throw new IllegalArgumentException("Required value was null.".toString());
                                        }
                                    } else {
                                        throw new IllegalArgumentException("Required value was null.".toString());
                                    }
                                } else {
                                    throw new IllegalArgumentException("Required value was null.".toString());
                                }
                            } else {
                                throw new IllegalArgumentException("Required value was null.".toString());
                            }
                        } else {
                            throw new IllegalArgumentException("Required value was null.".toString());
                        }
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                }
            }
        }
        VB vb18 = this.MyBillsEntityDataFactory;
        if (vb18 != 0) {
            ((BaseBottomSheetManageBankAccountBinding) vb18).BuiltInFictitiousFunctionClassFactory.lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ManageAccountBottomSheet.getAuthRequestContext(ManageAccountBottomSheet.this);
                }
            });
            VB vb19 = this.MyBillsEntityDataFactory;
            if (vb19 != 0) {
                ((BaseBottomSheetManageBankAccountBinding) vb19).MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ManageAccountBottomSheet.BuiltInFictitiousFunctionClassFactory(ManageAccountBottomSheet.this);
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.View
    public final void BuiltInFictitiousFunctionClassFactory(Throwable p0, String p1, String p2, String p3) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        Intrinsics.checkNotNullParameter(p3, "");
        Function4<? super Throwable, ? super String, ? super String, ? super String, Unit> function4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (p0 == null) {
            p0 = new Throwable();
        }
        function4.invoke(p0, p1, p2, p3);
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.PlaceComponentResult.invoke(p0);
        dismissAllowingStateLoss();
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.View
    public final void getAuthRequestContext(int p0) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = p0;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.onCancel(p0);
        dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(ManageAccountBottomSheet manageAccountBottomSheet) {
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        manageAccountBottomSheet.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(ManageAccountBottomSheet manageAccountBottomSheet, RecentRecipientModel recentRecipientModel) {
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        manageAccountBottomSheet.dismissAllowingStateLoss();
        FragmentActivity activity = manageAccountBottomSheet.getActivity();
        if (activity != null) {
            ((SendMoneyActivity) activity).updateRecentTransactionFavoriteState(false, recentRecipientModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.SendMoneyActivity");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(final ManageAccountBottomSheet manageAccountBottomSheet, final RecentRecipientModel recentRecipientModel) {
        String string;
        String string2;
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        manageAccountBottomSheet.dismissAllowingStateLoss();
        FragmentActivity activity = manageAccountBottomSheet.getActivity();
        if (activity != null) {
            if (((SendMoneyActivity) activity).isActivityAvailable()) {
                if (BuiltInFictitiousFunctionClassFactory(recentRecipientModel)) {
                    string = manageAccountBottomSheet.getString(R.string.delete_group_title);
                } else {
                    string = manageAccountBottomSheet.getString(R.string.send_money_delete_this_account);
                }
                Intrinsics.checkNotNullExpressionValue(string, "");
                if (BuiltInFictitiousFunctionClassFactory(recentRecipientModel)) {
                    string2 = manageAccountBottomSheet.getString(R.string.delete_group_description);
                } else {
                    string2 = manageAccountBottomSheet.getString(R.string.send_money_text_desc_dialog_delete_quick_action);
                }
                Intrinsics.checkNotNullExpressionValue(string2, "");
                FragmentActivity activity2 = manageAccountBottomSheet.getActivity();
                if (activity2 != null) {
                    CustomDialog.Builder builder = new CustomDialog.Builder((SendMoneyActivity) activity2);
                    builder.SubSequence = string;
                    builder.GetContactSyncConfig = string2;
                    CustomDialog.Builder PlaceComponentResult = builder.KClassImpl$Data$declaredNonStaticMembers$2(false).PlaceComponentResult(false);
                    PlaceComponentResult.moveToNextValue = 0L;
                    CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(manageAccountBottomSheet.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$showDialogConfirmationToRemoveAccountFromDialog$1
                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(View view) {
                            Intrinsics.checkNotNullParameter(view, "");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final /* bridge */ /* synthetic */ Unit invoke(View view) {
                            invoke2(view);
                            return Unit.INSTANCE;
                        }
                    }).BuiltInFictitiousFunctionClassFactory(manageAccountBottomSheet.getString(R.string.option_delete), new Function1<View, Unit>() { // from class: id.dana.sendmoney_v2.recipient.activity.ManageAccountBottomSheet$showDialogConfirmationToRemoveAccountFromDialog$2
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
                            RecipientModel MyBillsEntityDataFactory;
                            RecipientModel recipientModel;
                            Intrinsics.checkNotNullParameter(view, "");
                            ManageAccountBottomSheet manageAccountBottomSheet2 = ManageAccountBottomSheet.this;
                            if (recentRecipientModel.isLayoutRequested == 4) {
                                MyBillsEntityDataFactory = RecipientModelExtKt.MyBillsEntityDataFactory("bank", recentRecipientModel, RecipientIdType.INSTITUTION);
                                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                            } else if (recentRecipientModel.isLayoutRequested == 2) {
                                MyBillsEntityDataFactory = RecipientModelExtKt.MyBillsEntityDataFactory("contact", recentRecipientModel, "phonenumber");
                                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                            } else {
                                MyBillsEntityDataFactory = RecipientModelExtKt.MyBillsEntityDataFactory(RecipientType.GROUP_CONTACT, recentRecipientModel, "phonenumber");
                                Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
                            }
                            manageAccountBottomSheet2.scheduleImpl = MyBillsEntityDataFactory;
                            ManageAccountContract.Presenter presenter = ManageAccountBottomSheet.this.presenter;
                            RecipientModel recipientModel2 = null;
                            if (presenter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                                presenter = null;
                            }
                            recipientModel = ManageAccountBottomSheet.this.scheduleImpl;
                            if (recipientModel == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("");
                            } else {
                                recipientModel2 = recipientModel;
                            }
                            presenter.KClassImpl$Data$declaredNonStaticMembers$2(recipientModel2);
                            ManageAccountBottomSheet.this.dismissAllowingStateLoss();
                        }
                    });
                    ViewExtKt.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory(), BuiltInFictitiousFunctionClassFactory.moveToNextValue);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.SendMoneyActivity");
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.SendMoneyActivity");
    }

    public static /* synthetic */ void PlaceComponentResult(ManageAccountBottomSheet manageAccountBottomSheet, RecentRecipientModel recentRecipientModel) {
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        Intrinsics.checkNotNullParameter(recentRecipientModel, "");
        manageAccountBottomSheet.dismissAllowingStateLoss();
        Integer num = manageAccountBottomSheet.getAuthRequestContext;
        int i = manageAccountBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2;
        if (num != null && num.intValue() == i) {
            FragmentActivity activity = manageAccountBottomSheet.getActivity();
            if (activity != null) {
                ((SendMoneyActivity) activity).showFavoriteAccountExceedLimitDialog(recentRecipientModel, manageAccountBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.SendMoneyActivity");
        }
        FragmentActivity activity2 = manageAccountBottomSheet.getActivity();
        if (activity2 != null) {
            ((SendMoneyActivity) activity2).updateRecentTransactionFavoriteState(true, recentRecipientModel);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.landing.SendMoneyActivity");
    }

    public static /* synthetic */ void PlaceComponentResult(ManageAccountBottomSheet manageAccountBottomSheet, RecipientModel recipientModel) {
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        Intrinsics.checkNotNullParameter(recipientModel, "");
        VB vb = manageAccountBottomSheet.MyBillsEntityDataFactory;
        if (vb != 0) {
            Editable text = ((BaseBottomSheetManageBankAccountBinding) vb).MyBillsEntityDataFactory.getAuthRequestContext.getText();
            ManageAccountContract.Presenter presenter = null;
            if (!(text == null || text.length() == 0)) {
                ManageAccountContract.Presenter presenter2 = manageAccountBottomSheet.presenter;
                if (presenter2 != null) {
                    presenter = presenter2;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                VB vb2 = manageAccountBottomSheet.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    presenter.BuiltInFictitiousFunctionClassFactory(recipientModel, String.valueOf(((BaseBottomSheetManageBankAccountBinding) vb2).MyBillsEntityDataFactory.getAuthRequestContext.getText()), false);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            ManageAccountContract.Presenter presenter3 = manageAccountBottomSheet.presenter;
            if (presenter3 != null) {
                presenter = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.BuiltInFictitiousFunctionClassFactory(recipientModel, recipientModel.PlaceComponentResult(), false);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void PlaceComponentResult(ManageAccountBottomSheet manageAccountBottomSheet) {
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        FragmentActivity activity = manageAccountBottomSheet.getActivity();
        if (activity != null) {
            RecipientModel recipientSelectedMoreAction = ((BankRecipientActivity) activity).getRecipientSelectedMoreAction();
            if (recipientSelectedMoreAction != null) {
                ManageAccountContract.Presenter presenter = manageAccountBottomSheet.presenter;
                if (presenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    presenter = null;
                }
                presenter.KClassImpl$Data$declaredNonStaticMembers$2(recipientSelectedMoreAction);
            }
            manageAccountBottomSheet.dismissAllowingStateLoss();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ManageAccountBottomSheet manageAccountBottomSheet) {
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        manageAccountBottomSheet.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ManageAccountBottomSheet manageAccountBottomSheet) {
        Intrinsics.checkNotNullParameter(manageAccountBottomSheet, "");
        VB vb = manageAccountBottomSheet.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((BaseBottomSheetManageBankAccountBinding) vb).BuiltInFictitiousFunctionClassFactory.scheduleImpl.setVisibility(8);
            VB vb2 = manageAccountBottomSheet.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                ((BaseBottomSheetManageBankAccountBinding) vb2).MyBillsEntityDataFactory.MyBillsEntityDataFactory.setVisibility(0);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(RecentRecipientModel p0) {
        return p0.isLayoutRequested == 7 || p0.isLayoutRequested == 6;
    }

    private final void PlaceComponentResult(boolean p0) {
        if (p0) {
            VB vb = this.MyBillsEntityDataFactory;
            if (vb != 0) {
                ((BaseBottomSheetManageBankAccountBinding) vb).BuiltInFictitiousFunctionClassFactory.getAuthRequestContext.setVisibility(0);
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        VB vb2 = this.MyBillsEntityDataFactory;
        if (vb2 != 0) {
            ((BaseBottomSheetManageBankAccountBinding) vb2).BuiltInFictitiousFunctionClassFactory.PlaceComponentResult.setVisibility(0);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((BaseBottomSheetManageBankAccountBinding) vb).PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.View
    public final void BuiltInFictitiousFunctionClassFactory(RecipientModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = this.BuiltInFictitiousFunctionClassFactory;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            str = null;
        }
        if (Intrinsics.areEqual(str, "MANAGE_QUICK_ACTION") ? true : Intrinsics.areEqual(str, "MANAGE_SAVED_BANK")) {
            this.lookAheadTest.invoke(p0);
        }
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.View
    public final void getErrorConfigVersion() {
        this.MyBillsEntityDataFactory.invoke();
    }

    @Override // id.dana.sendmoney_v2.landing.contract.ManageAccountContract.View
    public final void lookAheadTest() {
        this.MyBillsEntityDataFactory.invoke();
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            Editable text = ((BaseBottomSheetManageBankAccountBinding) vb).MyBillsEntityDataFactory.getAuthRequestContext.getText();
            if (!(text == null || text.length() == 0)) {
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    BankRecipientActivity bankRecipientActivity = (BankRecipientActivity) activity;
                    StringBuilder sb = new StringBuilder();
                    sb.append(getString(R.string.send_money_wording_toast_after_rename_recent_saved_bank));
                    sb.append(Typography.quote);
                    VB vb2 = this.MyBillsEntityDataFactory;
                    if (vb2 != 0) {
                        sb.append((Object) ((BaseBottomSheetManageBankAccountBinding) vb2).MyBillsEntityDataFactory.getAuthRequestContext.getText());
                        sb.append("\".");
                        CustomToastUtil.PlaceComponentResult(bankRecipientActivity, 0, R.drawable.bg_rounded_border_green_50, sb.toString(), 80, 20, true, null, 256);
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                }
            } else {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    BankRecipientActivity bankRecipientActivity2 = (BankRecipientActivity) activity2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(getString(R.string.send_money_wording_toast_after_rename_recent_saved_bank));
                    sb2.append(Typography.quote);
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        RecipientModel recipientSelectedMoreAction = ((BankRecipientActivity) activity3).getRecipientSelectedMoreAction();
                        sb2.append(recipientSelectedMoreAction != null ? recipientSelectedMoreAction.PlaceComponentResult() : null);
                        sb2.append("\".");
                        CustomToastUtil.PlaceComponentResult(bankRecipientActivity2, 0, R.drawable.bg_rounded_border_green_50, sb2.toString(), 80, 20, true, null, 256);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type id.dana.sendmoney_v2.recipient.activity.BankRecipientActivity");
                }
            }
            dismissAllowingStateLoss();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
