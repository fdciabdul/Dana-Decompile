package id.dana.wallet_v3.vouchersandtickets.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.core.ui.util.DANAToast;
import id.dana.danah5.DanaH5;
import id.dana.data.constant.DanaUrl;
import id.dana.databinding.ActivityVoucherAndTicketExpiredListBinding;
import id.dana.domain.wallet_v3.constant.WalletAssetType;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.wallet_v3.constant.WalletConstant;
import id.dana.wallet_v3.listener.WalletCardAssetClickListener;
import id.dana.wallet_v3.model.NewPocketQueryListModel;
import id.dana.wallet_v3.model.VoucherAndTicketCardModel;
import id.dana.wallet_v3.model.WalletV3CardModel;
import id.dana.wallet_v3.view.search.adapter.WalletVerticalSpaceItemDecoration;
import id.dana.wallet_v3.vouchersandtickets.adapter.VouchersAndTicketsAdapter;
import id.dana.wallet_v3.vouchersandtickets.di.DaggerVoucherAndTicketExpiredListComponent;
import id.dana.wallet_v3.vouchersandtickets.di.VoucherAndTicketExpiredListModule;
import id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract;
import id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity$walletCardAssetClickListener$2;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;
import o.getCallingPid;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b8\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ\u000f\u0010\u000f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0016\u0010\u000bJ\u000f\u0010\u0017\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u000bR*\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010!R\u0018\u0010$\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038CX\u0083\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106"}, d2 = {"Lid/dana/wallet_v3/vouchersandtickets/view/VoucherAndTicketExpiredListActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityVoucherAndTicketExpiredListBinding;", "", "getLayout", "()I", "Lid/dana/wallet_v3/vouchersandtickets/di/VoucherAndTicketExpiredListModule;", "getVoucherAndTicketExpiredList", "()Lid/dana/wallet_v3/vouchersandtickets/di/VoucherAndTicketExpiredListModule;", "", "hideEmptyState", "()V", "hideLoadingVoucherAndTicket", "hideShimmeringSkeleton", IAPSyncCommand.COMMAND_INIT, "initArgsData", "initInjector", "initView", "initViewBinding", "()Lid/dana/databinding/ActivityVoucherAndTicketExpiredListBinding;", "loadData", "showEmptyState", "showLoadingVoucherAndTicket", "showShimmeringSkeleton", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "assetTypes", "Ljava/util/ArrayList;", "danaDealsVersion", "I", "", "hasMore", "Z", GriverMonitorConstants.KEY_IS_LOADING, "Lcom/ethanhua/skeleton/SkeletonScreen;", "skeletonScreen", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$Presenter;", "voucherAndTicketExpiredListPresenter", "Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$Presenter;", "getVoucherAndTicketExpiredListPresenter", "()Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$Presenter;", "setVoucherAndTicketExpiredListPresenter", "(Lid/dana/wallet_v3/vouchersandtickets/presenter/VoucherAndTicketExpiredListContract$Presenter;)V", "Lid/dana/wallet_v3/vouchersandtickets/adapter/VouchersAndTicketsAdapter;", "vouchersAndTicketsExpiredAdapter$delegate", "Lkotlin/Lazy;", "getVouchersAndTicketsExpiredAdapter", "()Lid/dana/wallet_v3/vouchersandtickets/adapter/VouchersAndTicketsAdapter;", "vouchersAndTicketsExpiredAdapter", "Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener$delegate", "getWalletCardAssetClickListener", "()Lid/dana/wallet_v3/listener/WalletCardAssetClickListener;", "walletCardAssetClickListener", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoucherAndTicketExpiredListActivity extends ViewBindingActivity<ActivityVoucherAndTicketExpiredListBinding> {
    private ArrayList<String> assetTypes;
    private boolean isLoading;
    private SkeletonScreen skeletonScreen;
    @Inject
    public VoucherAndTicketExpiredListContract.Presenter voucherAndTicketExpiredListPresenter;
    public static final byte[] $$a = {8, -125, -40, -38, TarHeader.LF_CHR, -48, 46, 10, 7, 14, -39, TarHeader.LF_NORMAL, 13, -4, 18, 12, -46, 36, Ascii.SUB, -12, -20, 34, 9, Ascii.CAN, 2, 10, 14, 5, 22, -44, 59, 6, -5, -15, Ascii.SUB, 19, 11, -9, Ascii.NAK, 8, -42, TarHeader.LF_CHR, 6, 13, -8, Ascii.SUB, 3, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 216;
    public static final byte[] PlaceComponentResult = {113, 46, 115, -60, 17, -6, 18, 1, -2, -1, -50, 57, 16, 3, 10, -11, 13, 10, -66, Ascii.EM, TarHeader.LF_NORMAL, 3, 10, -11, Ascii.ETB, 0, -1, 5, 13, 10, -7, 15, 9, -45, Ascii.GS, 22, -7, -33, TarHeader.LF_NORMAL, -7, 5, -5, Ascii.EM, -17, -47, 66, -7, 17, -3, -53, 41, 42, -2, 5, -11, 12, 2, 19, -47, TarHeader.LF_CHR, 4, 0, 1, -2, 2, Ascii.ETB, -7, 10, 3, -33, 41, -4, 13};
    public static final int getAuthRequestContext = 144;
    private static char lookAheadTest = 42066;
    private static char[] NetworkUserEntityData$$ExternalSyntheticLambda0 = {37370, 37357, 37366, 37368, 37290, 37262, 37365, 37375, 37311, 37307, 37294, 37280, 37372, 37287, 37306, 37292, 37371, 37302, 37346, 37345, 37293, 37353, 37358, 37344, 37356, 37275, 37289, 37286, 37373, 37279, 37349, 37347, 37374, 37288, 37281, 37350, 37310, 37283, 37291, 37351, 37359, 37305, 37348, 37308, 37369, 37282, 37274, 37367, 37309};
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: vouchersAndTicketsExpiredAdapter$delegate  reason: from kotlin metadata */
    private final Lazy vouchersAndTicketsExpiredAdapter = LazyKt.lazy(new Function0<VouchersAndTicketsAdapter>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity$vouchersAndTicketsExpiredAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VouchersAndTicketsAdapter invoke() {
            WalletCardAssetClickListener walletCardAssetClickListener;
            walletCardAssetClickListener = VoucherAndTicketExpiredListActivity.this.getWalletCardAssetClickListener();
            return new VouchersAndTicketsAdapter(walletCardAssetClickListener);
        }
    });
    private boolean hasMore = true;
    private int danaDealsVersion = 1;

    /* renamed from: walletCardAssetClickListener$delegate  reason: from kotlin metadata */
    private final Lazy walletCardAssetClickListener = LazyKt.lazy(new Function0<VoucherAndTicketExpiredListActivity$walletCardAssetClickListener$2.AnonymousClass1>() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity$walletCardAssetClickListener$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity$walletCardAssetClickListener$2$1] */
        @Override // kotlin.jvm.functions.Function0
        public final AnonymousClass1 invoke() {
            return new WalletCardAssetClickListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity$walletCardAssetClickListener$2.1
                @Override // id.dana.wallet_v3.listener.WalletCardAssetClickListener
                public final void onCardClicked(WalletV3CardModel data) {
                    Intrinsics.checkNotNullParameter(data, "");
                    if (data instanceof VoucherAndTicketCardModel.ParkingTicketCard) {
                        String qrUrl = ((VoucherAndTicketCardModel.ParkingTicketCard) data).getQrUrl();
                        if (qrUrl != null) {
                            DanaH5.startContainerFullUrl(qrUrl);
                        }
                    } else if (data instanceof VoucherAndTicketCardModel.VoucherCard) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(DanaUrl.VOUCHER_DETAIL, Arrays.copyOf(new Object[]{((VoucherAndTicketCardModel.VoucherCard) data).getPocketId()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "");
                        StringBuilder sb = new StringBuilder();
                        sb.append("https://m.dana.id");
                        sb.append(format);
                        DanaH5.startContainerFullUrl(sb.toString());
                    } else if (data instanceof VoucherAndTicketCardModel.DealsCard) {
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String format2 = String.format(DanaUrl.DEALS_DETAIL, Arrays.copyOf(new Object[]{((VoucherAndTicketCardModel.DealsCard) data).getPocketId()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("https://m.dana.id");
                        sb2.append(format2);
                        DanaH5.startContainerFullUrl(sb2.toString());
                    }
                }
            };
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0026 -> B:11:0x002f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r7, short r8, int r9, java.lang.Object[] r10) {
        /*
            int r8 = 55 - r8
            int r7 = r7 + 97
            int r9 = r9 + 16
            byte[] r0 = id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity.PlaceComponentResult
            byte[] r1 = new byte[r9]
            r2 = 0
            if (r0 != 0) goto L14
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            r9 = r8
            goto L2f
        L14:
            r3 = 0
        L15:
            int r4 = r3 + 1
            byte r5 = (byte) r7
            r1[r3] = r5
            int r8 = r8 + 1
            if (r4 != r9) goto L26
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L26:
            r3 = r0[r8]
            r6 = r9
            r9 = r8
            r8 = r3
            r3 = r1
            r1 = r0
            r0 = r10
            r10 = r6
        L2f:
            int r7 = r7 + r8
            int r7 = r7 + (-4)
            r8 = r9
            r9 = r10
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity.b(byte, short, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002d -> B:11:0x003a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(short r6, short r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 4
            int r6 = r6 * 3
            int r6 = 42 - r6
            int r7 = r7 * 2
            int r7 = r7 + 75
            byte[] r0 = id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity.$$a
            byte[] r1 = new byte[r6]
            int r6 = r6 + (-1)
            r2 = 0
            if (r0 != 0) goto L1a
            r7 = r6
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L3a
        L1a:
            r3 = 0
            r5 = r8
            r8 = r7
        L1d:
            r7 = r5
            int r7 = r7 + 1
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r6) goto L2d
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2d:
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
        L3a:
            int r9 = r9 + r6
            int r6 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r6
            r6 = r7
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity.c(short, short, short, java.lang.Object[]):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Object[] objArr;
        Object[] objArr2;
        Object[] objArr3;
        Object[] objArr4;
        super.attachBaseContext(context);
        Object[] objArr5 = new Object[1];
        a((byte) (56 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), new char[]{'\r', 31, ')', '-', '\r', 25, '(', 17, '\b', '.', 15, '!', '.', '\r', 18, 1, 13856, 13856}, 18 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a((byte) (93 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), new char[]{3, 24, '0', 25, 13916}, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 5, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.indexOf("", "", 0, 0), 35 - (ViewConfiguration.getPressedStateDuration() >> 16), (char) (Process.getGidForName("") + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a((byte) (AndroidCharacter.getMirror('0') + 31), new char[]{1, 17, '-', '0', '\n', '#', 5, ',', 4, 5, 19, 22, 0, InputCardNumberView.DIVIDER, 30, '.', 13818, 13818, '-', '\t', Typography.dollar, 17, 16, '+', '(', '\n', '-', '(', 31, '#', 11, 3, '\t', 2, 30, 0, 23, 5, '*', '\f', 5, 24, 23, 2, 19, '\r', '.', 2}, 48 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a((byte) (86 - Process.getGidForName("")), new char[]{7, 3, '-', '%', 23, 5, '\f', '*', Typography.dollar, 17, 3, 1, '\'', 31, 30, 18, 13823, 13823, 25, '!', '\'', 31, '/', '\t', '0', 16, 3, 5, '-', '(', 13823, 13823, 17, Typography.dollar, 19, ',', 13904, 13904, '\b', '\r', 7, 14, 11, '\'', 17, 1, 31, 4, 13824, 13824, 4, 3, 3, 4, 11, 28, 11, 28, 16, 14, '!', '.', '(', '\n'}, ExpandableListView.getPackedPositionGroup(0L) + 64, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a((byte) (Color.blue(0) + 100), new char[]{29, '!', 6, 18, 3, 4, 30, 14, 13830, 13830, '.', '!', '!', 11, '\n', 0, 11, 3, 17, '%', Typography.quote, 14, 11, '\r', 5, 24, 5, ',', 13920, 13920, 1, 17, '\n', '-', '!', '*', 17, 6, '-', '0', 5, '!', 30, 18, '*', '\f', '\r', 17, 23, 5, 18, 1, 29, '!', 21, 5, 4, 1, '\t', 2, 21, 5, 1, 3}, (ViewConfiguration.getTouchSlop() >> 8) + 64, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a((byte) (47 - KeyEvent.normalizeMetaState(0)), new char[]{7, '\n', '\n', '\t', '0', 1, 13796, 13796, '-', 17, 31, '\r', 16, '\f', 20, 6, 3, 11, '\b', 16, '\b', '-', '\f', 16, 28, 19, '\r', '-', Typography.dollar, '-', '#', 15, '\r', '-', 5, 18, 18, '\b', ',', 24, 11, '\t', 21, 24, Typography.quote, ')', InputCardNumberView.DIVIDER, 5, ',', '\b', 27, '%', 30, 21, 6, '\'', 6, InputCardNumberView.DIVIDER, '\b', ','}, 60 - TextUtils.getCapsMode("", 0, 0), objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a((byte) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 85), new char[]{5, 16, 17, 20, 29, '!'}, TextUtils.lastIndexOf("", '0') + 7, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - KeyEvent.keyCodeFromString(""), (ViewConfiguration.getPressedStateDuration() >> 16) + 18, (char) View.getDefaultSize(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                b(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                byte b = (byte) (PlaceComponentResult[32] - 1);
                Object[] objArr14 = new Object[1];
                b(b, (byte) (b | 22), PlaceComponentResult[25], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getTapTimeout() >> 16), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 4, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
                        Object[] objArr16 = new Object[1];
                        c($$a[31], $$a[78], $$a[47], objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.lastIndexOf("", '0') + SecExceptionCode.SEC_ERROR_PKG_VALID_INVALID_PARAM, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 16, (char) View.MeasureSpec.getSize(0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - TextUtils.indexOf((CharSequence) "", '0', 0), 15 - TextUtils.indexOf("", "", 0), (char) (TextUtils.indexOf((CharSequence) "", '0') + 1))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.resolveSizeAndState(0, 0, 0) + 815, ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.RS, (char) (57993 - Process.getGidForName("")))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.getOffsetAfter("", 0) + 15, (char) TextUtils.getOffsetBefore("", 0)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r7 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.green(0) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myPid() >> 22) + 35, (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {2018048278, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.argb(0, 0, 0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 18, (char) TextUtils.indexOf("", "", 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                byte b2 = (byte) (PlaceComponentResult[32] - 1);
                Object[] objArr20 = new Object[1];
                b(b2, (byte) (b2 | 22), PlaceComponentResult[25], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(61 - View.combineMeasuredStates(0, 0), 46 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (char) (ViewConfiguration.getEdgeSlop() >> 16));
                        Object[] objArr22 = new Object[1];
                        c($$a[8], $$a[9], $$a[28], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r1 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getOffsetAfter("", 0), ((byte) KeyEvent.getModifierMetaStateMask()) + 36, (char) (ViewConfiguration.getEdgeSlop() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {2018048278, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 18 - (Process.myTid() >> 22), (char) (ViewConfiguration.getWindowTouchSlop() >> 8))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                byte b3 = (byte) (PlaceComponentResult[32] - 1);
                Object[] objArr26 = new Object[1];
                b(b3, (byte) (b3 | 22), PlaceComponentResult[25], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 117, (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 2, (char) (38969 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1))));
                        Object[] objArr28 = new Object[1];
                        c($$a[8], $$a[9], $$a[28], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r1 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getTrimmedLength(""), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 34, (char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {2018048278, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), View.MeasureSpec.getSize(0) + 18, (char) View.resolveSizeAndState(0, 0, 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                b(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                byte b4 = (byte) (PlaceComponentResult[32] - 1);
                Object[] objArr32 = new Object[1];
                b(b4, (byte) (b4 | 22), PlaceComponentResult[25], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.getOffsetBefore("", 0) + 107, 3 - Color.green(0), (char) (ViewConfiguration.getScrollBarFadeDuration() >> 16));
                        byte b5 = (byte) ($$a[78] - 1);
                        Object[] objArr34 = new Object[1];
                        c(b5, b5, (byte) (-$$a[40]), objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r1 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + PDF417Common.MAX_CODEWORDS_IN_BARCODE, 35 - View.MeasureSpec.getSize(0), (char) TextUtils.getOffsetBefore("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {2018048278, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.indexOf("", ""), 17 - Process.getGidForName(""), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final int getLayout() {
        return R.layout.activity_voucher_and_ticket_expired_list;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr;
        Object[] objArr2 = new Object[1];
        a((byte) (super.getResources().getString(R.string.card_binding_bank_indonesia_disclaimer).substring(0, 15).codePointAt(9) - 55), new char[]{'\r', 31, ')', '-', '\r', 25, '(', 17, '\b', '.', 15, '!', '.', '\r', 18, 1, 13856, 13856}, getPackageName().codePointAt(5) - 92, objArr2);
        Class<?> cls = Class.forName((String) objArr2[0]);
        Object[] objArr3 = new Object[1];
        a((byte) (TextUtils.getCapsMode("", 0, 0) + 94), new char[]{3, 24, '0', 25, 13916}, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 5, objArr3);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr3[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr4 = new Object[1];
                a((byte) (18 - Color.argb(0, 0, 0, 0)), new char[]{'\r', 31, ')', '-', '\r', 25, '(', 17, 11, '\t', '\f', 15, 1, 19, '\r', 23, '0', Typography.quote, '\n', 16, 27, 11, '.', 6, 17, '-'}, super.getResources().getString(R.string.twilio_bottomsheet_countdown_timer).substring(6, 7).codePointAt(0) - 77, objArr4);
                Class<?> cls2 = Class.forName((String) objArr4[0]);
                Object[] objArr5 = new Object[1];
                a((byte) (getPackageName().length() + 51), new char[]{16, 15, 13858, 13858, 6, InputCardNumberView.DIVIDER, '\f', 2, 13860, 13860, ')', 23, 17, '\b', '\r', 23, '\r', InputCardNumberView.DIVIDER}, 18 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), objArr5);
                baseContext = (Context) cls2.getMethod((String) objArr5[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Color.rgb(0, 0, 0) + 16778145, 34 - TextUtils.lastIndexOf("", '0', 0), (char) KeyEvent.normalizeMetaState(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr6 = new Object[1];
                    a((byte) (super.getResources().getString(R.string.split_bill_qr_desc_title).substring(14, 15).codePointAt(0) + 47), new char[]{1, 17, '-', '0', '\n', '#', 5, ',', 4, 5, 19, 22, 0, InputCardNumberView.DIVIDER, 30, '.', 13818, 13818, '-', '\t', Typography.dollar, 17, 16, '+', '(', '\n', '-', '(', 31, '#', 11, 3, '\t', 2, 30, 0, 23, 5, '*', '\f', 5, 24, 23, 2, 19, '\r', '.', 2}, 48 - (ViewConfiguration.getScrollBarSize() >> 8), objArr6);
                    String str = (String) objArr6[0];
                    try {
                        byte b = PlaceComponentResult[25];
                        Object[] objArr7 = new Object[1];
                        b(b, (byte) (b | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr7);
                        Class<?> cls3 = Class.forName((String) objArr7[0]);
                        Object[] objArr8 = new Object[1];
                        b((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], objArr8);
                        Object[] objArr9 = new Object[1];
                        a((byte) (((ApplicationInfo) cls3.getMethod((String) objArr8[0], null).invoke(this, null)).targetSdkVersion + 54), new char[]{7, 3, '-', '%', 23, 5, '\f', '*', Typography.dollar, 17, 3, 1, '\'', 31, 30, 18, 13823, 13823, 25, '!', '\'', 31, '/', '\t', '0', 16, 3, 5, '-', '(', 13823, 13823, 17, Typography.dollar, 19, ',', 13904, 13904, '\b', '\r', 7, 14, 11, '\'', 17, 1, 31, 4, 13824, 13824, 4, 3, 3, 4, 11, 28, 11, 28, 16, 14, '!', '.', '(', '\n'}, getPackageName().length() + 57, objArr9);
                        String str2 = (String) objArr9[0];
                        try {
                            byte b2 = PlaceComponentResult[25];
                            Object[] objArr10 = new Object[1];
                            b(b2, (byte) (b2 | TarHeader.LF_BLK), (byte) (-PlaceComponentResult[30]), objArr10);
                            Class<?> cls4 = Class.forName((String) objArr10[0]);
                            Object[] objArr11 = new Object[1];
                            b((byte) (-PlaceComponentResult[5]), PlaceComponentResult[25], PlaceComponentResult[56], objArr11);
                            Object[] objArr12 = new Object[1];
                            a((byte) (((ApplicationInfo) cls4.getMethod((String) objArr11[0], null).invoke(this, null)).targetSdkVersion + 67), new char[]{29, '!', 6, 18, 3, 4, 30, 14, 13830, 13830, '.', '!', '!', 11, '\n', 0, 11, 3, 17, '%', Typography.quote, 14, 11, '\r', 5, 24, 5, ',', 13920, 13920, 1, 17, '\n', '-', '!', '*', 17, 6, '-', '0', 5, '!', 30, 18, '*', '\f', '\r', 17, 23, 5, 18, 1, 29, '!', 21, 5, 4, 1, '\t', 2, 21, 5, 1, 3}, getPackageName().codePointAt(4) - 33, objArr12);
                            String str3 = (String) objArr12[0];
                            Object[] objArr13 = new Object[1];
                            a((byte) (getPackageName().length() + 40), new char[]{7, '\n', '\n', '\t', '0', 1, 13796, 13796, '-', 17, 31, '\r', 16, '\f', 20, 6, 3, 11, '\b', 16, '\b', '-', '\f', 16, 28, 19, '\r', '-', Typography.dollar, '-', '#', 15, '\r', '-', 5, 18, 18, '\b', ',', 24, 11, '\t', 21, 24, Typography.quote, ')', InputCardNumberView.DIVIDER, 5, ',', '\b', 27, '%', 30, 21, 6, '\'', 6, InputCardNumberView.DIVIDER, '\b', ','}, super.getResources().getString(R.string.automation_passkey_btn_activate_passkey).substring(0, 20).codePointAt(12) + 15, objArr13);
                            String str4 = (String) objArr13[0];
                            Object[] objArr14 = new Object[1];
                            a((byte) (85 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), new char[]{5, 16, 17, 20, 29, '!'}, 6 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr14);
                            try {
                                Object[] objArr15 = {baseContext, str, str2, str3, str4, true, (String) objArr14[0], 995651014};
                                Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                                if (obj2 == null) {
                                    obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(912 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), View.resolveSize(0, 0) + 18, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
                                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-1276397751, obj2);
                                }
                                ((Method) obj2).invoke(invoke, objArr15);
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
                } catch (Throwable th4) {
                    Throwable cause4 = th4.getCause();
                    if (cause4 == null) {
                        throw th4;
                    }
                    throw cause4;
                }
            }
        }
        try {
            Object[] objArr16 = new Object[1];
            b(PlaceComponentResult[32], PlaceComponentResult[31], PlaceComponentResult[25], objArr16);
            Class<?> cls5 = Class.forName((String) objArr16[0]);
            byte b3 = (byte) (PlaceComponentResult[32] - 1);
            Object[] objArr17 = new Object[1];
            b(b3, (byte) (b3 | 22), PlaceComponentResult[25], objArr17);
            try {
                Object[] objArr18 = {Integer.valueOf(((Integer) cls5.getMethod((String) objArr17[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls6 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 493, TextUtils.lastIndexOf("", '0', 0) + 5, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)));
                    byte b4 = (byte) ($$a[78] - 1);
                    Object[] objArr19 = new Object[1];
                    c(b4, b4, (byte) (-$$a[40]), objArr19);
                    obj3 = cls6.getMethod((String) objArr19[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr20 = (Object[]) ((Method) obj3).invoke(null, objArr18);
                int i = ((int[]) objArr20[1])[0];
                if (((int[]) objArr20[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 != null) {
                            objArr = null;
                        } else {
                            objArr = null;
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getEdgeSlop() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (Process.myPid() >> 22) + 35, (char) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(objArr, objArr);
                        try {
                            Object[] objArr21 = {-2102951857, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Gravity.getAbsoluteGravity(0, 0), 18 - TextUtils.indexOf("", "", 0, 0), (char) View.MeasureSpec.getMode(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr21);
                        } catch (Throwable th5) {
                            Throwable cause5 = th5.getCause();
                            if (cause5 == null) {
                                throw th5;
                            }
                            throw cause5;
                        }
                    } catch (Throwable th6) {
                        Throwable cause6 = th6.getCause();
                        if (cause6 == null) {
                            throw th6;
                        }
                        throw cause6;
                    }
                }
                super.onCreate(bundle);
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
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (18 - (ViewConfiguration.getLongPressTimeout() >> 16)), new char[]{'\r', 31, ')', '-', '\r', 25, '(', 17, 11, '\t', '\f', 15, 1, 19, '\r', 23, '0', Typography.quote, '\n', 16, 27, 11, '.', 6, 17, '-'}, super.getResources().getString(R.string.summary_account_freeze_description).substring(37, 39).codePointAt(0) - 71, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (58 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), new char[]{16, 15, 13858, 13858, 6, InputCardNumberView.DIVIDER, '\f', 2, 13860, 13860, ')', 23, 17, '\b', '\r', 23, '\r', InputCardNumberView.DIVIDER}, TextUtils.lastIndexOf("", '0') + 19, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - TextUtils.getCapsMode("", 0, 0), Color.blue(0) + 35, (char) TextUtils.getOffsetAfter("", 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(KeyEvent.normalizeMetaState(0) + 911, (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 18, (char) (TextUtils.lastIndexOf("", '0') + 1))).getMethod("MyBillsEntityDataFactory", Context.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onResume() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a((byte) (ExpandableListView.getPackedPositionGroup(0L) + 18), new char[]{'\r', 31, ')', '-', '\r', 25, '(', 17, 11, '\t', '\f', 15, 1, 19, '\r', 23, '0', Typography.quote, '\n', 16, 27, 11, '.', 6, 17, '-'}, super.getResources().getString(R.string.error_saving_account_reach_monthly_limit).substring(4, 11).length() + 19, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a((byte) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 59), new char[]{16, 15, 13858, 13858, 6, InputCardNumberView.DIVIDER, '\f', 2, 13860, 13860, ')', 23, 17, '\b', '\r', 23, '\r', InputCardNumberView.DIVIDER}, 18 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ImageFormat.getBitsPerPixel(0) + 930, 36 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), (char) (Process.myTid() >> 22))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - TextUtils.getCapsMode("", 0, 0), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 17, (char) Color.alpha(0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(247288059, obj2);
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
        super.onResume();
    }

    @JvmName(name = "getVoucherAndTicketExpiredListPresenter")
    public final VoucherAndTicketExpiredListContract.Presenter getVoucherAndTicketExpiredListPresenter() {
        VoucherAndTicketExpiredListContract.Presenter presenter = this.voucherAndTicketExpiredListPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setVoucherAndTicketExpiredListPresenter")
    public final void setVoucherAndTicketExpiredListPresenter(VoucherAndTicketExpiredListContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.voucherAndTicketExpiredListPresenter = presenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getVouchersAndTicketsExpiredAdapter")
    public final VouchersAndTicketsAdapter getVouchersAndTicketsExpiredAdapter() {
        return (VouchersAndTicketsAdapter) this.vouchersAndTicketsExpiredAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getWalletCardAssetClickListener")
    public final WalletCardAssetClickListener getWalletCardAssetClickListener() {
        return (WalletCardAssetClickListener) this.walletCardAssetClickListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityVoucherAndTicketExpiredListBinding initViewBinding() {
        ActivityVoucherAndTicketExpiredListBinding authRequestContext = ActivityVoucherAndTicketExpiredListBinding.getAuthRequestContext(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        initArgsData();
        initInjector();
        initView();
        loadData();
    }

    private final void initArgsData() {
        Bundle extras = getIntent().getExtras();
        this.assetTypes = extras != null ? extras.getStringArrayList(WalletConstant.ASSET_TYPES) : null;
        Bundle extras2 = getIntent().getExtras();
        this.danaDealsVersion = extras2 != null ? extras2.getInt(WalletConstant.DANA_DEALS_VERSION) : 1;
    }

    private final void initInjector() {
        DaggerVoucherAndTicketExpiredListComponent.builder().applicationComponent(getApplicationComponent()).voucherAndTicketExpiredListModule(getVoucherAndTicketExpiredList()).build().inject(this);
    }

    private final VoucherAndTicketExpiredListModule getVoucherAndTicketExpiredList() {
        return new VoucherAndTicketExpiredListModule(new VoucherAndTicketExpiredListContract.View() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity$getVoucherAndTicketExpiredList$1
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

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.View
            public final void showLoadingShimmer() {
                VoucherAndTicketExpiredListActivity.this.showShimmeringSkeleton();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.View
            public final void dismissLoadingShimmer() {
                VoucherAndTicketExpiredListActivity.this.hideShimmeringSkeleton();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.View
            public final void showLoadingSpinnerAtBottomOfRecyclerView() {
                VoucherAndTicketExpiredListActivity.this.showLoadingVoucherAndTicket();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.View
            public final void dismissLoadingSpinnerAtBottomOfRecyclerView() {
                VoucherAndTicketExpiredListActivity.this.hideLoadingVoucherAndTicket();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.View
            public final void onSuccessGetExpiredVoucherAndTicket(NewPocketQueryListModel<VoucherAndTicketCardModel> assets) {
                VouchersAndTicketsAdapter vouchersAndTicketsExpiredAdapter;
                Intrinsics.checkNotNullParameter(assets, "");
                VoucherAndTicketExpiredListActivity.this.hideEmptyState();
                VoucherAndTicketExpiredListActivity.this.hasMore = assets.getHasMore();
                vouchersAndTicketsExpiredAdapter = VoucherAndTicketExpiredListActivity.this.getVouchersAndTicketsExpiredAdapter();
                vouchersAndTicketsExpiredAdapter.appendItems(assets.getPockets());
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.View
            public final void onEmptyGetExpiredVoucherAndTicket() {
                VoucherAndTicketExpiredListActivity.this.showEmptyState();
            }

            @Override // id.dana.wallet_v3.vouchersandtickets.presenter.VoucherAndTicketExpiredListContract.View
            public final void onErrorGetExpiredVoucherAndTicket() {
                DANAToast dANAToast = DANAToast.BuiltInFictitiousFunctionClassFactory;
                VoucherAndTicketExpiredListActivity voucherAndTicketExpiredListActivity = VoucherAndTicketExpiredListActivity.this;
                VoucherAndTicketExpiredListActivity voucherAndTicketExpiredListActivity2 = voucherAndTicketExpiredListActivity;
                String string = voucherAndTicketExpiredListActivity.getString(R.string.voucher_and_ticket_error_load_data);
                Intrinsics.checkNotNullExpressionValue(string, "");
                DANAToast.MyBillsEntityDataFactory(voucherAndTicketExpiredListActivity2, string, "");
            }
        });
    }

    private final void initView() {
        setTitle(getString(R.string.voucher_and_ticket_expired_tab_title));
        setMenuLeftButton(R.drawable.ic_close_white);
        RecyclerView recyclerView = getBinding().MyBillsEntityDataFactory;
        recyclerView.setItemAnimator(null);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getVouchersAndTicketsExpiredAdapter());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new WalletVerticalSpaceItemDecoration());
        getBinding().MyBillsEntityDataFactory.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.wallet_v3.vouchersandtickets.view.VoucherAndTicketExpiredListActivity$initView$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                boolean z;
                boolean z2;
                ArrayList arrayList;
                List<String> voucherAssetTypes;
                Intrinsics.checkNotNullParameter(recyclerView2, "");
                if (recyclerView2.canScrollVertically(1)) {
                    return;
                }
                z = VoucherAndTicketExpiredListActivity.this.hasMore;
                if (z) {
                    z2 = VoucherAndTicketExpiredListActivity.this.isLoading;
                    if (z2) {
                        return;
                    }
                    VoucherAndTicketExpiredListContract.Presenter voucherAndTicketExpiredListPresenter = VoucherAndTicketExpiredListActivity.this.getVoucherAndTicketExpiredListPresenter();
                    arrayList = VoucherAndTicketExpiredListActivity.this.assetTypes;
                    if (arrayList == null || (voucherAssetTypes = CollectionsKt.toList(arrayList)) == null) {
                        voucherAssetTypes = WalletAssetType.INSTANCE.getVoucherAssetTypes();
                    }
                    voucherAndTicketExpiredListPresenter.getExpiredVoucherAndTicket(voucherAssetTypes);
                }
            }
        });
    }

    private final void loadData() {
        List<String> voucherAssetTypes;
        VoucherAndTicketExpiredListContract.Presenter voucherAndTicketExpiredListPresenter = getVoucherAndTicketExpiredListPresenter();
        ArrayList<String> arrayList = this.assetTypes;
        if (arrayList == null || (voucherAssetTypes = CollectionsKt.toList(arrayList)) == null) {
            voucherAssetTypes = WalletAssetType.INSTANCE.getVoucherAssetTypes();
        }
        voucherAndTicketExpiredListPresenter.getExpiredVoucherAndTicket(voucherAssetTypes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showShimmeringSkeleton() {
        this.isLoading = true;
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().MyBillsEntityDataFactory);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.voucher_shimmer_loading;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = getVouchersAndTicketsExpiredAdapter();
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 5;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        this.skeletonScreen = recyclerViewSkeletonScreen;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideShimmeringSkeleton() {
        this.isLoading = false;
        SkeletonScreen skeletonScreen = this.skeletonScreen;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showEmptyState() {
        getBinding().getAuthRequestContext.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideEmptyState() {
        getBinding().getAuthRequestContext.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingVoucherAndTicket() {
        this.isLoading = true;
        getVouchersAndTicketsExpiredAdapter().showLoadingViewOnTheLastItem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoadingVoucherAndTicket() {
        this.isLoading = false;
        getVouchersAndTicketsExpiredAdapter().hideLoadingView();
    }

    private static void a(byte b, char[] cArr, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i3 = 0; i3 < length; i3++) {
                cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
            }
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ lookAheadTest);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            getcallingpid.getAuthRequestContext = 0;
            while (getcallingpid.getAuthRequestContext < i2) {
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if (getcallingpid.scheduleImpl == getcallingpid.lookAheadTest) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i4 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i5 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i4];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i5];
                    } else if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                        getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                        getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                        int i6 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i7 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i6];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i7];
                    } else {
                        int i8 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                        int i9 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i8];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i9];
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        for (int i10 = 0; i10 < i; i10++) {
            cArr4[i10] = (char) (cArr4[i10] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
