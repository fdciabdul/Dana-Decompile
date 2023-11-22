package id.dana.social.bottomsheet;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.domain.config.model.ReportReasons;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog$bottomSheetCallback$2;
import id.dana.social.contract.FeedsCommentReportContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FeedsCommentReportModule;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u00020\u0001:\u0002#\"B\u0007¢\u0006\u0004\b!\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nR\u0013\u0010\u0015\u001a\u00020\u0012X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u0016X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u001aX\u0087\"¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "Landroid/os/Bundle;", "p0", "onCreate", "(Landroid/os/Bundle;)V", "onDismiss", "onShow", "onStart", "Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetDialog$bottomSheetCallback$2$1;", "lookAheadTest", "Lkotlin/Lazy;", "getAuthRequestContext", "Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetDialog$BottomSheetListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetDialog$BottomSheetListener;", "PlaceComponentResult", "Lid/dana/social/contract/FeedsCommentReportContract$Presenter;", "feedsCommentReportPresenter", "Lid/dana/social/contract/FeedsCommentReportContract$Presenter;", "Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetAdapter;", "getErrorConfigVersion", "Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetAdapter;", "BuiltInFictitiousFunctionClassFactory", "<init>", "Companion", "BottomSheetListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReportFeedCommentsBottomSheetDialog extends BaseBottomSheetDialogFragment {

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public BottomSheetListener PlaceComponentResult;
    @Inject
    public FeedsCommentReportContract.Presenter feedsCommentReportPresenter;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private ReportFeedCommentsBottomSheetAdapter BuiltInFictitiousFunctionClassFactory;
    public static final byte[] $$d = {Ascii.ETB, -59, 18, 83, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 168;
    public static final byte[] moveToNextValue = {108, -22, 67, 3, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int scheduleImpl = 33;
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext = LazyKt.lazy(new Function0<ReportFeedCommentsBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1>() { // from class: id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog$bottomSheetCallback$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog$bottomSheetCallback$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            final ReportFeedCommentsBottomSheetDialog reportFeedCommentsBottomSheetDialog = ReportFeedCommentsBottomSheetDialog.this;
            return new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog$bottomSheetCallback$2.1
                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onSlide(View p0, float p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                }

                @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
                public final void onStateChanged(View p0, int p1) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    if (5 == p1) {
                        ReportFeedCommentsBottomSheetDialog.this.dismissAllowingStateLoss();
                    }
                }
            };
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/social/bottomsheet/ReportFeedCommentsBottomSheetDialog$BottomSheetListener;", "", "", "BuiltInFictitiousFunctionClassFactory", "()V", "", "p0", "getAuthRequestContext", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface BottomSheetListener {
        void BuiltInFictitiousFunctionClassFactory();

        void getAuthRequestContext(String p0);
    }

    private View BuiltInFictitiousFunctionClassFactory(int i) {
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(byte r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 16
            int r7 = r7 * 15
            int r7 = r7 + 4
            byte[] r0 = id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog.moveToNextValue
            int r8 = 106 - r8
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L18
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L26
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L26:
            int r3 = r3 + 1
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + 2
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog.c(byte, byte, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002b -> B:11:0x0030). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r7 = r7 * 3
            int r7 = r7 + 75
            int r8 = r8 * 4
            int r8 = 3 - r8
            byte[] r0 = id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog.$$d
            int r6 = r6 * 3
            int r6 = r6 + 42
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r7
            r4 = 0
            r7 = r6
            goto L30
        L19:
            r3 = 0
        L1a:
            int r8 = r8 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r6) goto L2b
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2b:
            r3 = r0[r8]
            r5 = r7
            r7 = r6
            r6 = r5
        L30:
            int r3 = -r3
            int r6 = r6 + r3
            int r6 = r6 + (-7)
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog.d(short, short, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.5f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.view_bottomsheet_report_feed_comment_list;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        if (socialCommonComponent != null) {
            socialCommonComponent.MyBillsEntityDataFactory(new FeedsCommentReportModule(new FeedsCommentReportContract.View() { // from class: id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog$initInjector$1
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

                @Override // id.dana.social.contract.FeedsCommentReportContract.View
                public final void getAuthRequestContext(List<ReportReasons> p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    ReportFeedCommentsBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(ReportFeedCommentsBottomSheetDialog.this, p0);
                }
            })).MyBillsEntityDataFactory(this);
        }
        ReportFeedCommentsBottomSheetAdapter reportFeedCommentsBottomSheetAdapter = new ReportFeedCommentsBottomSheetAdapter();
        reportFeedCommentsBottomSheetAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                ReportFeedCommentsBottomSheetDialog.KClassImpl$Data$declaredNonStaticMembers$2(ReportFeedCommentsBottomSheetDialog.this, i);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = reportFeedCommentsBottomSheetAdapter;
        ImageButton imageButton = (ImageButton) BuiltInFictitiousFunctionClassFactory(R.id.RecurringAnnouncementEntity);
        if (imageButton != null) {
            imageButton.setImageDrawable(ContextCompat.PlaceComponentResult(requireContext(), (int) R.drawable.MyBillsEntityDataFactory));
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.bottomsheet.ReportFeedCommentsBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReportFeedCommentsBottomSheetDialog.getAuthRequestContext(ReportFeedCommentsBottomSheetDialog.this);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) BuiltInFictitiousFunctionClassFactory(R.id.rv_bottom_sheet);
        FeedsCommentReportContract.Presenter presenter = null;
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            ReportFeedCommentsBottomSheetAdapter reportFeedCommentsBottomSheetAdapter2 = this.BuiltInFictitiousFunctionClassFactory;
            if (reportFeedCommentsBottomSheetAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                reportFeedCommentsBottomSheetAdapter2 = null;
            }
            recyclerView.setAdapter(reportFeedCommentsBottomSheetAdapter2);
        }
        FeedsCommentReportContract.Presenter presenter2 = this.feedsCommentReportPresenter;
        if (presenter2 != null) {
            presenter = presenter2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.getAuthRequestContext();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle p0) {
        try {
            byte b = (byte) (moveToNextValue[5] + 1);
            byte b2 = (byte) (-moveToNextValue[5]);
            Object[] objArr = new Object[1];
            c(b, b2, (byte) (b2 - 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (moveToNextValue[5] + 1);
            Object[] objArr2 = new Object[1];
            c(b3, b3, (byte) (-moveToNextValue[5]), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - (ViewConfiguration.getEdgeSlop() >> 16), Color.alpha(0) + 4, (char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1));
                    byte b4 = (byte) ($$d[4] - 1);
                    byte b5 = b4;
                    Object[] objArr4 = new Object[1];
                    d(b4, b5, b5, objArr4);
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
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.MeasureSpec.getMode(0), (char) KeyEvent.keyCodeFromString(""))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-884207469, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(910 - MotionEvent.axisFromString(""), 18 - Color.alpha(0), (char) ((-1) - TextUtils.lastIndexOf("", '0', 0, 0)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
            bottomSheetBehavior.setBottomSheetCallback((ReportFeedCommentsBottomSheetDialog$bottomSheetCallback$2.AnonymousClass1) this.getAuthRequestContext.getValue());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(ReportFeedCommentsBottomSheetDialog reportFeedCommentsBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(reportFeedCommentsBottomSheetDialog, "");
        BottomSheetListener bottomSheetListener = reportFeedCommentsBottomSheetDialog.PlaceComponentResult;
        if (bottomSheetListener != null) {
            bottomSheetListener.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ReportFeedCommentsBottomSheetDialog reportFeedCommentsBottomSheetDialog, int i) {
        BottomSheetListener bottomSheetListener;
        Intrinsics.checkNotNullParameter(reportFeedCommentsBottomSheetDialog, "");
        ReportFeedCommentsBottomSheetAdapter reportFeedCommentsBottomSheetAdapter = reportFeedCommentsBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
        if (reportFeedCommentsBottomSheetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reportFeedCommentsBottomSheetAdapter = null;
        }
        ReportReasons item = reportFeedCommentsBottomSheetAdapter.getItem(i);
        if (item == null || (bottomSheetListener = reportFeedCommentsBottomSheetDialog.PlaceComponentResult) == null) {
            return;
        }
        bottomSheetListener.getAuthRequestContext(item.getReasonId());
    }

    public static final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ReportFeedCommentsBottomSheetDialog reportFeedCommentsBottomSheetDialog, List list) {
        ReportFeedCommentsBottomSheetAdapter reportFeedCommentsBottomSheetAdapter = reportFeedCommentsBottomSheetDialog.BuiltInFictitiousFunctionClassFactory;
        if (reportFeedCommentsBottomSheetAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            reportFeedCommentsBottomSheetAdapter = null;
        }
        reportFeedCommentsBottomSheetAdapter.appendItems(list);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        FrameLayout frameLayout = (FrameLayout) BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
        return frameLayout;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        FeedsCommentReportContract.Presenter presenter = this.feedsCommentReportPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.onDestroy();
        super.onDismiss();
    }
}
