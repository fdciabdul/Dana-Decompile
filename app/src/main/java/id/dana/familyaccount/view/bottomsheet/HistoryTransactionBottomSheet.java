package id.dana.familyaccount.view.bottomsheet;

import android.app.Dialog;
import android.content.Context;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.databinding.ViewTransactionHistorySheetBinding;
import id.dana.familyaccount.adapter.FamilyDashboardTransactionHistoryAdapter;
import id.dana.familyaccount.model.TransactionHistoryModel;
import id.dana.familyaccount.view.dashboard.FamilyCheckboxHistoryTransactionListener;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import id.dana.onboarding.splash.LauncherActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b!\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0014\u0010\u000bJ\u001d\u0010\u0017\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\u001f"}, d2 = {"Lid/dana/familyaccount/view/bottomsheet/HistoryTransactionBottomSheet;", "Lid/dana/core/ui/BaseViewBindingBottomSheetDialogFragment;", "Lid/dana/databinding/ViewTransactionHistorySheetBinding;", "", "BuiltInFictitiousFunctionClassFactory", "()F", "Landroid/view/View;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroid/view/View;", "", "getAuthRequestContext", "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "p_", "MyBillsEntityDataFactory", "", "Lid/dana/familyaccount/model/TransactionHistoryModel;", "PlaceComponentResult", "(Ljava/util/List;)V", "Lid/dana/familyaccount/adapter/FamilyDashboardTransactionHistoryAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Lid/dana/familyaccount/adapter/FamilyDashboardTransactionHistoryAdapter;", "", "", "GetContactSyncConfig", "Ljava/util/List;", "initRecordTimeStamp", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryTransactionBottomSheet extends BaseViewBindingBottomSheetDialogFragment<ViewTransactionHistorySheetBinding> {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private FamilyDashboardTransactionHistoryAdapter BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$a = {122, TarHeader.LF_CONTIG, -29, -99, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE;
    public static final byte[] MyBillsEntityDataFactory = {TarHeader.LF_DIR, 18, -76, 65, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 109;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private List<String> MyBillsEntityDataFactory = new ArrayList();

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private List<String> getAuthRequestContext = new ArrayList();

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r6 = 16 - r6
            byte[] r0 = id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet.MyBillsEntityDataFactory
            int r8 = r8 + 105
            int r7 = r7 * 15
            int r7 = 18 - r7
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L30
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            int r7 = r7 + 1
            r1[r3] = r4
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L30:
            int r4 = -r4
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet.a(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0029 -> B:11:0x0036). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, int r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 4
            int r6 = 75 - r6
            int r7 = r7 * 4
            int r7 = 3 - r7
            int r8 = r8 * 3
            int r8 = r8 + 42
            byte[] r0 = id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet.$$a
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L1b
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L36
        L1b:
            r3 = 0
        L1c:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r8) goto L29
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L29:
            int r3 = r3 + 1
            int r7 = r7 + 1
            r4 = r0[r7]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L36:
            int r6 = r6 + r8
            int r6 = r6 + (-7)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet.b(byte, byte, int, java.lang.Object[]):void");
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final float BuiltInFictitiousFunctionClassFactory() {
        return 0.5f;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void PlaceComponentResult() {
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final /* synthetic */ ViewTransactionHistorySheetBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "");
        ViewTransactionHistorySheetBinding KClassImpl$Data$declaredNonStaticMembers$22 = ViewTransactionHistorySheetBinding.KClassImpl$Data$declaredNonStaticMembers$2(layoutInflater, viewGroup);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$22, "");
        return KClassImpl$Data$declaredNonStaticMembers$22;
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void getAuthRequestContext() {
        List<TransactionHistoryModel> transactionHistoryModels;
        super.getAuthRequestContext();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        setCancelable(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        final FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter = new FamilyDashboardTransactionHistoryAdapter();
        FragmentActivity activity = getActivity();
        FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter2 = null;
        OrganizerDashboardActivity organizerDashboardActivity = activity instanceof OrganizerDashboardActivity ? (OrganizerDashboardActivity) activity : null;
        if (organizerDashboardActivity != null && (transactionHistoryModels = organizerDashboardActivity.getTransactionHistoryModels()) != null) {
            BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(familyDashboardTransactionHistoryAdapter, transactionHistoryModels);
        }
        familyDashboardTransactionHistoryAdapter.MyBillsEntityDataFactory = new FamilyCheckboxHistoryTransactionListener() { // from class: id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet$getCheckboxHistoryTransactionListener$1
            @Override // id.dana.familyaccount.view.dashboard.FamilyCheckboxHistoryTransactionListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                HistoryTransactionBottomSheet.MyBillsEntityDataFactory(HistoryTransactionBottomSheet.this);
            }
        };
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((ViewTransactionHistorySheetBinding) vb).getAuthRequestContext.setOnCheckedTwoStatesChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    HistoryTransactionBottomSheet.getAuthRequestContext(HistoryTransactionBottomSheet.this, familyDashboardTransactionHistoryAdapter);
                }
            });
            this.MyBillsEntityDataFactory.clear();
            this.getAuthRequestContext.clear();
            Iterable iterable = familyDashboardTransactionHistoryAdapter.getAuthRequestContext;
            ArrayList arrayList = new ArrayList();
            for (Object obj : iterable) {
                if (((TransactionHistoryModel) obj).getBuiltInFictitiousFunctionClassFactory()) {
                    arrayList.add(obj);
                }
            }
            PlaceComponentResult(arrayList);
            this.BuiltInFictitiousFunctionClassFactory = familyDashboardTransactionHistoryAdapter;
            VB vb2 = this.MyBillsEntityDataFactory;
            if (vb2 != 0) {
                RecyclerView recyclerView = ((ViewTransactionHistorySheetBinding) vb2).NetworkUserEntityData$$ExternalSyntheticLambda0;
                FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter3 = this.BuiltInFictitiousFunctionClassFactory;
                if (familyDashboardTransactionHistoryAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    familyDashboardTransactionHistoryAdapter2 = familyDashboardTransactionHistoryAdapter3;
                }
                recyclerView.setAdapter(familyDashboardTransactionHistoryAdapter2);
                recyclerView.setLayoutManager(linearLayoutManager);
                VB vb3 = this.MyBillsEntityDataFactory;
                if (vb3 != 0) {
                    ((ViewTransactionHistorySheetBinding) vb3).MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            HistoryTransactionBottomSheet.KClassImpl$Data$declaredNonStaticMembers$2(HistoryTransactionBottomSheet.this);
                        }
                    });
                    VB vb4 = this.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        ((ViewTransactionHistorySheetBinding) vb4).PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet$$ExternalSyntheticLambda2
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                HistoryTransactionBottomSheet.BuiltInFictitiousFunctionClassFactory(HistoryTransactionBottomSheet.this);
                            }
                        });
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (MyBillsEntityDataFactory[5] - 1);
            Object[] objArr = new Object[1];
            a(b, b, MyBillsEntityDataFactory[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = (byte) (MyBillsEntityDataFactory[5] - 1);
            byte b3 = MyBillsEntityDataFactory[5];
            Object[] objArr2 = new Object[1];
            a(b2, b3, (byte) (b3 - 1), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - TextUtils.getTrimmedLength(""), 4 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                    byte b4 = (byte) ($$a[35] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    b(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getMode(0) + PDF417Common.NUMBER_OF_CODEWORDS, TextUtils.getCapsMode("", 0, 0) + 35, (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1110803995, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getKeyRepeatDelay() >> 16) + 911, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 18, (char) (Process.myPid() >> 22))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
        return new BottomSheetDialog(requireContext, theme) { // from class: id.dana.familyaccount.view.bottomsheet.HistoryTransactionBottomSheet$onCreateDialog$1
            @Override // androidx.view.ComponentDialog, android.app.Dialog
            public final void onBackPressed() {
                cancel();
            }
        };
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void MyBillsEntityDataFactory() {
        super.MyBillsEntityDataFactory();
        Dialog dialog = getDialog();
        if (dialog != null) {
            a_(PlaceComponentResult(dialog));
        }
        BottomSheetBehavior<View> o_ = o_();
        if (o_ != null) {
            o_.setHideable(true);
        }
    }

    private final void PlaceComponentResult(List<TransactionHistoryModel> p0) {
        for (TransactionHistoryModel transactionHistoryModel : p0) {
            List<String> list = this.MyBillsEntityDataFactory;
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            sb.append(transactionHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(Typography.quote);
            list.addAll(CollectionsKt.listOf(sb.toString()));
            List<String> list2 = this.getAuthRequestContext;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Typography.quote);
            sb2.append(transactionHistoryModel.getAuthRequestContext);
            sb2.append(Typography.quote);
            list2.addAll(CollectionsKt.listOf(sb2.toString()));
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(HistoryTransactionBottomSheet historyTransactionBottomSheet) {
        Intrinsics.checkNotNullParameter(historyTransactionBottomSheet, "");
        String format = String.format(DanaUrl.FAMILY_ACCOUNT_HISTORY_TRANSACTION, Arrays.copyOf(new Object[]{PhoneNumberUtilKt.removeWhitespaceAndDash(historyTransactionBottomSheet.MyBillsEntityDataFactory.toString()), PhoneNumberUtilKt.removeWhitespaceAndDash(historyTransactionBottomSheet.getAuthRequestContext.toString())}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "");
        DanaH5.startContainerFullUrl(format);
        historyTransactionBottomSheet.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void getAuthRequestContext(HistoryTransactionBottomSheet historyTransactionBottomSheet, FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter) {
        Intrinsics.checkNotNullParameter(historyTransactionBottomSheet, "");
        Intrinsics.checkNotNullParameter(familyDashboardTransactionHistoryAdapter, "");
        VB vb = historyTransactionBottomSheet.MyBillsEntityDataFactory;
        if (vb != 0) {
            int getAuthRequestContext = ((ViewTransactionHistorySheetBinding) vb).getAuthRequestContext.getGetAuthRequestContext();
            if (getAuthRequestContext == -1) {
                VB vb2 = historyTransactionBottomSheet.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ((ViewTransactionHistorySheetBinding) vb2).getAuthRequestContext.setState(-1);
                    VB vb3 = historyTransactionBottomSheet.MyBillsEntityDataFactory;
                    if (vb3 != 0) {
                        DanaButtonPrimaryView danaButtonPrimaryView = ((ViewTransactionHistorySheetBinding) vb3).PlaceComponentResult;
                        danaButtonPrimaryView.setActiveButton(historyTransactionBottomSheet.getString(R.string.bottom_apply), null);
                        danaButtonPrimaryView.setEnabled(true);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            } else if (getAuthRequestContext != 0) {
                if (getAuthRequestContext == 1) {
                    familyDashboardTransactionHistoryAdapter.getAuthRequestContext();
                    VB vb4 = historyTransactionBottomSheet.MyBillsEntityDataFactory;
                    if (vb4 != 0) {
                        DanaButtonPrimaryView danaButtonPrimaryView2 = ((ViewTransactionHistorySheetBinding) vb4).PlaceComponentResult;
                        danaButtonPrimaryView2.setActiveButton(historyTransactionBottomSheet.getString(R.string.bottom_apply), null);
                        danaButtonPrimaryView2.setEnabled(true);
                        return;
                    }
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                return;
            } else {
                Iterable<TransactionHistoryModel> iterable = familyDashboardTransactionHistoryAdapter.getAuthRequestContext;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (TransactionHistoryModel transactionHistoryModel : iterable) {
                    if (transactionHistoryModel.getBuiltInFictitiousFunctionClassFactory()) {
                        transactionHistoryModel = TransactionHistoryModel.KClassImpl$Data$declaredNonStaticMembers$2(transactionHistoryModel, false);
                    }
                    arrayList.add(transactionHistoryModel);
                }
                BaseRecyclerViewDiffUtilAdapter.getAuthRequestContext(familyDashboardTransactionHistoryAdapter, arrayList);
                VB vb5 = historyTransactionBottomSheet.MyBillsEntityDataFactory;
                if (vb5 != 0) {
                    DanaButtonPrimaryView danaButtonPrimaryView3 = ((ViewTransactionHistorySheetBinding) vb5).PlaceComponentResult;
                    danaButtonPrimaryView3.setDisabled(historyTransactionBottomSheet.getString(R.string.bottom_apply));
                    danaButtonPrimaryView3.setEnabled(false);
                    return;
                }
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(HistoryTransactionBottomSheet historyTransactionBottomSheet) {
        Intrinsics.checkNotNullParameter(historyTransactionBottomSheet, "");
        Dialog dialog = historyTransactionBottomSheet.getDialog();
        if (dialog != null) {
            dialog.cancel();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(HistoryTransactionBottomSheet historyTransactionBottomSheet) {
        historyTransactionBottomSheet.MyBillsEntityDataFactory.clear();
        historyTransactionBottomSheet.getAuthRequestContext.clear();
        FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter = historyTransactionBottomSheet.BuiltInFictitiousFunctionClassFactory;
        FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter2 = null;
        if (familyDashboardTransactionHistoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            familyDashboardTransactionHistoryAdapter = null;
        }
        Iterable iterable = familyDashboardTransactionHistoryAdapter.getAuthRequestContext;
        ArrayList arrayList = new ArrayList();
        for (Object obj : iterable) {
            if (((TransactionHistoryModel) obj).getBuiltInFictitiousFunctionClassFactory()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        if (size != 0) {
            FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter3 = historyTransactionBottomSheet.BuiltInFictitiousFunctionClassFactory;
            if (familyDashboardTransactionHistoryAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                familyDashboardTransactionHistoryAdapter2 = familyDashboardTransactionHistoryAdapter3;
            }
            if (size == familyDashboardTransactionHistoryAdapter2.getItemCount()) {
                VB vb = historyTransactionBottomSheet.MyBillsEntityDataFactory;
                if (vb != 0) {
                    ((ViewTransactionHistorySheetBinding) vb).getAuthRequestContext.setState(1);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            } else {
                VB vb2 = historyTransactionBottomSheet.MyBillsEntityDataFactory;
                if (vb2 != 0) {
                    ((ViewTransactionHistorySheetBinding) vb2).getAuthRequestContext.setState(-1);
                } else {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
            }
        } else {
            VB vb3 = historyTransactionBottomSheet.MyBillsEntityDataFactory;
            if (vb3 != 0) {
                ((ViewTransactionHistorySheetBinding) vb3).getAuthRequestContext.setState(0);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        historyTransactionBottomSheet.PlaceComponentResult(arrayList2);
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            FrameLayout frameLayout = ((ViewTransactionHistorySheetBinding) vb).KClassImpl$Data$declaredNonStaticMembers$2;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "");
            return frameLayout;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingBottomSheetDialogFragment
    public final void p_() {
        VB vb = this.MyBillsEntityDataFactory;
        if (vb != 0) {
            ((ViewTransactionHistorySheetBinding) vb).getAuthRequestContext.setState(1);
            FamilyDashboardTransactionHistoryAdapter familyDashboardTransactionHistoryAdapter = this.BuiltInFictitiousFunctionClassFactory;
            if (familyDashboardTransactionHistoryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                familyDashboardTransactionHistoryAdapter = null;
            }
            familyDashboardTransactionHistoryAdapter.getAuthRequestContext();
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
