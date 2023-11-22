package id.dana.nearbyme.merchantreview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LiveData;
import androidx.view.Observer;
import androidx.work.WorkInfo;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingActivity;
import id.dana.contract.nearbyme.MyReviewContract;
import id.dana.core.ui.richview.DanaDefaultPullToRefresh;
import id.dana.core.ui.richview.DanaPullToRefreshListener;
import id.dana.databinding.ActivityMyReviewListBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.model.DisplayedErrorModel;
import id.dana.nearbyme.di.component.DaggerMyReviewComponent;
import id.dana.nearbyme.di.module.MyReviewModule;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewViewModel;
import id.dana.nearbyme.merchantreview.CreateReviewWorker;
import id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment;
import id.dana.nearbyme.merchantreview.MyUnReviewedListActivity;
import id.dana.nearbyme.merchantreview.adapter.MerchantReviewAdapter;
import id.dana.nearbyme.merchantreview.adapter.MyReviewAdapter;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewViewHolderModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewDialogDismissState;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.nearbyme.tracker.NearbyAnalyticTracker;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.tracker.mixpanel.MixPanelTracker;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import o.BottomSheetCardBindingView$watcherCardNumberView$1;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001<B\u0007¢\u0006\u0004\b;\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000b\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0013\u0010\u001d\u001a\u00020\u001aX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010\u001f\u001a\u00020\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R0\u0010\u0010\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u0012\u0018\u00010%8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b'\u0010(R(\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0013\u00103\u001a\u000201X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b2\u0010\u001cR\u001f\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u001204X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b6\u0010\u001cR$\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u0012\u0018\u0001088\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b9\u0010:"}, d2 = {"Lid/dana/nearbyme/merchantreview/MyReviewListActivity;", "Lid/dana/base/viewbinding/ViewBindingActivity;", "Lid/dana/databinding/ActivityMyReviewListBinding;", "", "configToolbar", "()V", "getAuthRequestContext", IAPSyncCommand.COMMAND_INIT, "initViewBinding", "()Lid/dana/databinding/ActivityMyReviewListBinding;", "onDestroy", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroidx/recyclerview/widget/ConcatAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroidx/recyclerview/widget/ConcatAdapter;", "", "lookAheadTest", "Ljava/lang/String;", "", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewViewHolderModel;", "NetworkUserEntityData$$ExternalSyntheticLambda2", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewViewModel;", "GetContactSyncConfig", "PlaceComponentResult", "Lid/dana/nearbyme/merchantreview/adapter/MyReviewAdapter;", "initRecordTimeStamp", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "nearbyAnalyticTracker", "Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "getNearbyAnalyticTracker", "()Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;", "setNearbyAnalyticTracker", "(Lid/dana/nearbyme/tracker/NearbyAnalyticTracker;)V", "Lkotlin/Pair;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewTagModel;", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lkotlin/Pair;", "Ldagger/Lazy;", "Lid/dana/contract/nearbyme/MyReviewContract$Presenter;", "presenter", "Ldagger/Lazy;", "getPresenter", "()Ldagger/Lazy;", "setPresenter", "(Ldagger/Lazy;)V", "Lid/dana/nearbyme/merchantreview/adapter/MerchantReviewAdapter;", "DatabaseTableConfigUtil", "scheduleImpl", "Landroidx/lifecycle/Observer;", "Landroidx/work/WorkInfo;", "isLayoutRequested", "getErrorConfigVersion", "Landroidx/lifecycle/LiveData;", "NetworkUserEntityData$$ExternalSyntheticLambda7", "Landroidx/lifecycle/LiveData;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyReviewListActivity extends ViewBindingActivity<ActivityMyReviewListBinding> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static boolean NetworkUserEntityData$$ExternalSyntheticLambda4;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda8;
    private static char[] PrepareContext;
    private static boolean newProxyInstance;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private List<MerchantReviewViewModel> PlaceComponentResult;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ConcatAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private Pair<? extends List<MerchantReviewTagModel>, ? extends List<MerchantReviewTagModel>> lookAheadTest;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda2  reason: from kotlin metadata */
    private List<MerchantConsultReviewViewHolderModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda7  reason: from kotlin metadata */
    private LiveData<List<WorkInfo>> NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public NearbyAnalyticTracker nearbyAnalyticTracker;
    @Inject
    public Lazy<MyReviewContract.Presenter> presenter;
    public static final byte[] $$a = {108, 11, -123, -39, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 215;
    public static final byte[] getAuthRequestContext = {TarHeader.LF_CHR, -70, 75, 72, -17, 6, -18, -1, 2, 1, TarHeader.LF_SYMLINK, -57, -16, -3, -10, 11, -13, -10, 66, -25, -48, -3, -10, 11, -23, 0, 1, -5, -13, -10, 7, -15, -9, 45, -29, -22, 7, 33, -48, 7, -5, 5, -25, 17, 47, -66, 7, -17, 3, TarHeader.LF_DIR, -41, -42, 2, -5, 11, -12, -2, -19, 47, -51, -4, 0, -1, 2, -2, -23, 7, -10, -3, 33, -41, 4, -13};
    public static final int PlaceComponentResult = 39;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private final kotlin.Lazy scheduleImpl = LazyKt.lazy(new Function0<MerchantReviewAdapter>() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$unreviewedMerchantAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.nearbyme.merchantreview.MyReviewListActivity$unreviewedMerchantAdapter$2$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class AnonymousClass1 extends AdaptedFunctionReference implements Function2<MerchantConsultReviewModel, Integer, Unit> {
            AnonymousClass1(Object obj) {
                super(2, obj, MyReviewListActivity.class, "showMerchantReviewDialog", "showMerchantReviewDialog(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;ILid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(MerchantConsultReviewModel merchantConsultReviewModel, Integer num) {
                invoke(merchantConsultReviewModel, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(MerchantConsultReviewModel merchantConsultReviewModel, int i) {
                Intrinsics.checkNotNullParameter(merchantConsultReviewModel, "");
                MyReviewListActivity.showMerchantReviewDialog$default((MyReviewListActivity) this.receiver, merchantConsultReviewModel, i, null, 4, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: id.dana.nearbyme.merchantreview.MyReviewListActivity$unreviewedMerchantAdapter$2$2  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
            AnonymousClass2(Object obj) {
                super(0, obj, MyReviewListActivity.class, "openUnreviewedActivity", "openUnreviewedActivity()V", 0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MyReviewListActivity.access$openUnreviewedActivity((MyReviewListActivity) this.receiver);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MerchantReviewAdapter invoke() {
            return new MerchantReviewAdapter(new AnonymousClass1(MyReviewListActivity.this), new AnonymousClass2(MyReviewListActivity.this));
        }
    });

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private final kotlin.Lazy MyBillsEntityDataFactory = LazyKt.lazy(new Function0<MyReviewAdapter>() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$myReviewAdapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MyReviewAdapter invoke() {
            final MyReviewListActivity myReviewListActivity = MyReviewListActivity.this;
            return new MyReviewAdapter(new Function1<MerchantReviewModel, Unit>() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$myReviewAdapter$2.1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(MerchantReviewModel merchantReviewModel) {
                    invoke2(merchantReviewModel);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(MerchantReviewModel merchantReviewModel) {
                    Pair pair;
                    List emptyList;
                    List emptyList2;
                    Intrinsics.checkNotNullParameter(merchantReviewModel, "");
                    MyReviewListActivity.this.getNearbyAnalyticTracker().MyBillsEntityDataFactory(TrackerKey.Event.NEARBY_REVIEW_LIST_EDIT, merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda0, merchantReviewModel.scheduleImpl, merchantReviewModel.GetContactSyncConfig);
                    MyReviewListActivity myReviewListActivity2 = MyReviewListActivity.this;
                    pair = myReviewListActivity2.lookAheadTest;
                    ShopModel shopModel = new ShopModel();
                    shopModel.BottomSheetCardBindingView$watcherCardNumberView$1 = merchantReviewModel.GetContactSyncConfig;
                    shopModel.newProxyInstance = merchantReviewModel.getErrorConfigVersion;
                    shopModel.VerifyPinStateManager$executeRiskChallenge$2$2 = Long.valueOf(merchantReviewModel.moveToNextValue);
                    shopModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = merchantReviewModel.getAuthRequestContext;
                    shopModel.NetworkUserEntityData$$ExternalSyntheticLambda6 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3 = merchantReviewModel.scheduleImpl;
                    if (pair == null || (emptyList = (List) pair.getFirst()) == null) {
                        emptyList = CollectionsKt.emptyList();
                    }
                    List list = emptyList;
                    if (pair == null || (emptyList2 = (List) pair.getSecond()) == null) {
                        emptyList2 = CollectionsKt.emptyList();
                    }
                    MyReviewListActivity.showMerchantReviewDialog$default(myReviewListActivity2, new MerchantConsultReviewModel(shopModel, list, emptyList2, "Nearby Review List Open", merchantReviewModel.scheduleImpl, merchantReviewModel.initRecordTimeStamp), 0, merchantReviewModel, 2, null);
                }
            });
        }
    });

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private String getAuthRequestContext = "";

    /* renamed from: isLayoutRequested  reason: from kotlin metadata */
    private final kotlin.Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<Observer<List<? extends WorkInfo>>>() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$userCreatedReviewLiveDataObserver$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Observer<List<? extends WorkInfo>> invoke() {
            return MyReviewListActivity.access$getReviewWorkManagerObserver(MyReviewListActivity.this);
        }
    });

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[MerchantReviewDialogDismissState.values().length];
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_CANCEL.ordinal()] = 1;
            iArr[MerchantReviewDialogDismissState.DISMISSED_BY_SUBMIT.ordinal()] = 2;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    static {
        PlaceComponentResult();
        INSTANCE = new Companion(null);
    }

    static void PlaceComponentResult() {
        PrepareContext = new char[]{39462, 39451, 39461, 39447, 39448, 39454, 39899, 39449, 39878, 39460, 39445, 39443, 39438, 39477, 39457, 39458, 39442, 39453, 39444, 39481, 39450, 39474, 39888, 39891, 39889, 39897, 39886, 39459, 39895, 39894, 39892, 39893, 39463, 39890, 39887, 39896, 39456, 39446};
        newProxyInstance = true;
        NetworkUserEntityData$$ExternalSyntheticLambda4 = true;
        NetworkUserEntityData$$ExternalSyntheticLambda8 = 909155209;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0022 -> B:11:0x0028). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, short r7, int r8, java.lang.Object[] r9) {
        /*
            int r8 = 106 - r8
            int r7 = r7 + 4
            int r6 = r6 + 16
            byte[] r0 = id.dana.nearbyme.merchantreview.MyReviewListActivity.getAuthRequestContext
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L12
            r8 = r7
            r4 = r8
            r3 = 0
            r7 = r6
            goto L28
        L12:
            r3 = 0
        L13:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L22
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L22:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L28:
            int r4 = -r4
            int r6 = r6 + r4
            int r8 = r8 + 1
            int r6 = r6 + (-4)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L13
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MyReviewListActivity.b(byte, short, int, java.lang.Object[]):void");
    }

    private static void c(short s, short s2, byte b, Object[] objArr) {
        int i = 42 - (s2 * 3);
        byte[] bArr = $$a;
        int i2 = 47 - b;
        int i3 = (s * 2) + 75;
        byte[] bArr2 = new byte[i];
        int i4 = -1;
        int i5 = i - 1;
        if (bArr == null) {
            i3 = (i5 + (-i3)) - 7;
            i5 = i5;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = -1;
        }
        while (true) {
            int i6 = i4 + 1;
            bArr2[i6] = (byte) i3;
            if (i6 == i5) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            i3 = (i3 + (-bArr[i2])) - 7;
            i5 = i5;
            i2++;
            objArr = objArr;
            bArr = bArr;
            bArr2 = bArr2;
            i4 = i6;
        }
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
        a(null, View.combineMeasuredStates(0, 0) + 127, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr5);
        Class<?> cls = Class.forName((String) objArr5[0]);
        Object[] objArr6 = new Object[1];
        a(null, 127 - (ViewConfiguration.getPressedStateDuration() >> 16), new byte[]{-125, -122, -106, -115, -107}, null, objArr6);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr6[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context applicationContext = context != null ? context.getApplicationContext() : context;
            if (applicationContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - TextUtils.getTrimmedLength(""), (char) Color.blue(0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr7 = new Object[1];
                    a(null, 126 - TextUtils.lastIndexOf("", '0', 0), new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr7);
                    String str = (String) objArr7[0];
                    Object[] objArr8 = new Object[1];
                    a(null, 128 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                    String str2 = (String) objArr8[0];
                    Object[] objArr9 = new Object[1];
                    a(null, 127 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                    String str3 = (String) objArr9[0];
                    Object[] objArr10 = new Object[1];
                    a(null, 126 - MotionEvent.axisFromString(""), new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                    String str4 = (String) objArr10[0];
                    Object[] objArr11 = new Object[1];
                    a(null, 127 - View.MeasureSpec.makeMeasureSpec(0, 0), new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                    try {
                        Object[] objArr12 = {applicationContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getJumpTapTimeout() >> 16) + 911, 18 - TextUtils.indexOf("", "", 0, 0), (char) (KeyEvent.getMaxKeyCode() >> 16))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                byte b = getAuthRequestContext[25];
                Object[] objArr13 = new Object[1];
                b(b, (byte) (b | 37), getAuthRequestContext[25], objArr13);
                Class<?> cls2 = Class.forName((String) objArr13[0]);
                Object[] objArr14 = new Object[1];
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[35]), getAuthRequestContext[9], objArr14);
                try {
                    Object[] objArr15 = {applicationContext2, Integer.valueOf(((Integer) cls2.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                    Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1691739267);
                    if (obj3 == null) {
                        Class cls3 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(55 - (ViewConfiguration.getKeyRepeatDelay() >> 16), View.resolveSize(0, 0) + 3, (char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')));
                        Object[] objArr16 = new Object[1];
                        c($$a[47], $$a[68], (byte) (-$$a[53]), objArr16);
                        obj3 = cls3.getMethod((String) objArr16[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1691739267, obj3);
                    }
                    Object invoke2 = ((Method) obj3).invoke(null, objArr15);
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(40157535);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.combineMeasuredStates(0, 0) + 800, View.resolveSizeAndState(0, 0, 0) + 15, (char) Color.argb(0, 0, 0, 0))).getMethod("getAuthRequestContext", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(40157535, obj4);
                        }
                        int intValue2 = ((Integer) ((Method) obj4).invoke(invoke2, null)).intValue();
                        try {
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1621779126);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(799 - Process.getGidForName(""), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 15, (char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)))).getMethod("PlaceComponentResult", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1621779126, obj5);
                            }
                            if (((Integer) ((Method) obj5).invoke(invoke2, null)).intValue() != intValue2) {
                                ArrayList arrayList = new ArrayList();
                                try {
                                    Object[] objArr17 = {invoke2};
                                    Object obj6 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(658700871);
                                    if (obj6 == null) {
                                        obj6 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(Process.getGidForName("") + 816, Color.red(0) + 29, (char) ((ViewConfiguration.getEdgeSlop() >> 16) + 57994))).getMethod("getAuthRequestContext", (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(800 - Color.alpha(0), 15 - TextUtils.getOffsetBefore("", 0), (char) (ViewConfiguration.getEdgeSlop() >> 16)));
                                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(658700871, obj6);
                                    }
                                    arrayList.add(((Method) obj6).invoke(null, objArr17));
                                    long j = ((r9 ^ intValue2) & 4294967295L) | 60129542144L;
                                    try {
                                        Object obj7 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                                        if (obj7 != null) {
                                            objArr = null;
                                        } else {
                                            objArr = null;
                                            obj7 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((-16776287) - Color.rgb(0, 0, 0), 36 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj7);
                                        }
                                        Object invoke3 = ((Method) obj7).invoke(objArr, objArr);
                                        try {
                                            Object[] objArr18 = {-831311825, Long.valueOf(j), arrayList, LauncherActivity.getAuid()};
                                            Object obj8 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                            if (obj8 == null) {
                                                obj8 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), AndroidCharacter.getMirror('0') - 30, (char) ((-1) - ExpandableListView.getPackedPositionChild(0L)))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b2 = getAuthRequestContext[25];
                Object[] objArr19 = new Object[1];
                b(b2, (byte) (b2 | 37), getAuthRequestContext[25], objArr19);
                Class<?> cls4 = Class.forName((String) objArr19[0]);
                Object[] objArr20 = new Object[1];
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[35]), getAuthRequestContext[9], objArr20);
                try {
                    Object[] objArr21 = {applicationContext3, Integer.valueOf(((Integer) cls4.getMethod((String) objArr20[0], Object.class).invoke(null, this)).intValue())};
                    Object obj9 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(345757441);
                    if (obj9 == null) {
                        Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(62 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), 46 - View.MeasureSpec.getMode(0), (char) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1));
                        Object[] objArr22 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[8]), $$a[20], objArr22);
                        obj9 = cls5.getMethod((String) objArr22[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(345757441, obj9);
                    }
                    Object[] objArr23 = (Object[]) ((Method) obj9).invoke(null, objArr21);
                    int i = ((int[]) objArr23[1])[0];
                    if (((int[]) objArr23[0])[0] != i) {
                        long j2 = ((r2 ^ i) & 4294967295L) | 17179869184L;
                        try {
                            Object obj10 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj10 != null) {
                                objArr2 = null;
                            } else {
                                objArr2 = null;
                                obj10 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(TextUtils.indexOf((CharSequence) "", '0', 0) + 930, (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 34, (char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj10);
                            }
                            Object invoke4 = ((Method) obj10).invoke(objArr2, objArr2);
                            try {
                                Object[] objArr24 = {-831311825, Long.valueOf(j2), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj11 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj11 == null) {
                                    obj11 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - ExpandableListView.getPackedPositionType(0L), (char) TextUtils.getOffsetBefore("", 0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b3 = getAuthRequestContext[25];
                Object[] objArr25 = new Object[1];
                b(b3, (byte) (b3 | 37), getAuthRequestContext[25], objArr25);
                Class<?> cls6 = Class.forName((String) objArr25[0]);
                Object[] objArr26 = new Object[1];
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[35]), getAuthRequestContext[9], objArr26);
                try {
                    Object[] objArr27 = {applicationContext4, Integer.valueOf(((Integer) cls6.getMethod((String) objArr26[0], Object.class).invoke(null, this)).intValue())};
                    Object obj12 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-697999596);
                    if (obj12 == null) {
                        Class cls7 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + 118, 3 - Color.green(0), (char) (38968 - View.combineMeasuredStates(0, 0)));
                        Object[] objArr28 = new Object[1];
                        c((byte) (-$$a[9]), (byte) (-$$a[8]), $$a[20], objArr28);
                        obj12 = cls7.getMethod((String) objArr28[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-697999596, obj12);
                    }
                    Object[] objArr29 = (Object[]) ((Method) obj12).invoke(null, objArr27);
                    int i2 = ((int[]) objArr29[1])[0];
                    if (((int[]) objArr29[0])[0] != i2) {
                        long j3 = ((r2 ^ i2) & 4294967295L) | 8589934592L;
                        try {
                            Object obj13 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj13 != null) {
                                objArr3 = null;
                            } else {
                                objArr3 = null;
                                obj13 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (Process.myTid() >> 22), View.MeasureSpec.getSize(0) + 35, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj13);
                            }
                            Object invoke5 = ((Method) obj13).invoke(objArr3, objArr3);
                            try {
                                Object[] objArr30 = {-831311825, Long.valueOf(j3), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj14 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj14 == null) {
                                    obj14 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - (KeyEvent.getMaxKeyCode() >> 16), 19 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) ((-1) - MotionEvent.axisFromString("")))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                byte b4 = getAuthRequestContext[25];
                Object[] objArr31 = new Object[1];
                b(b4, (byte) (b4 | 37), getAuthRequestContext[25], objArr31);
                Class<?> cls8 = Class.forName((String) objArr31[0]);
                Object[] objArr32 = new Object[1];
                b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[35]), getAuthRequestContext[9], objArr32);
                try {
                    Object[] objArr33 = {applicationContext5, Integer.valueOf(((Integer) cls8.getMethod((String) objArr32[0], Object.class).invoke(null, this)).intValue())};
                    Object obj15 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-16683571);
                    if (obj15 == null) {
                        Class cls9 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 106, 3 - TextUtils.indexOf("", "", 0, 0), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
                        byte b5 = (byte) ($$a[47] - 1);
                        byte b6 = b5;
                        Object[] objArr34 = new Object[1];
                        c(b5, b6, b6, objArr34);
                        obj15 = cls9.getMethod((String) objArr34[0], Context.class, Integer.TYPE);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(-16683571, obj15);
                    }
                    Object[] objArr35 = (Object[]) ((Method) obj15).invoke(null, objArr33);
                    int i3 = ((int[]) objArr35[1])[0];
                    if (((int[]) objArr35[0])[0] != i3) {
                        long j4 = ((r2 ^ i3) & 4294967295L) | 4294967296L;
                        try {
                            Object obj16 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                            if (obj16 != null) {
                                objArr4 = null;
                            } else {
                                objArr4 = null;
                                obj16 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - Color.green(0), 35 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (ViewConfiguration.getScrollBarSize() >> 8))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj16);
                            }
                            Object invoke6 = ((Method) obj16).invoke(objArr4, objArr4);
                            try {
                                Object[] objArr36 = {-831311825, Long.valueOf(j4), new ArrayList(), LauncherActivity.getAuid()};
                                Object obj17 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                                if (obj17 == null) {
                                    obj17 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getWindowTouchSlop() >> 8) + 911, 18 - View.resolveSizeAndState(0, 0, 0), (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return super.getResources();
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        Object[] objArr = new Object[1];
        a(null, super.getResources().getString(R.string.device_limit_error_title).substring(5, 6).codePointAt(0) + 95, new byte[]{-109, -109, -112, -118, -123, -124, -108, -121, -109, -123, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
        Class<?> cls = Class.forName((String) objArr[0]);
        Object[] objArr2 = new Object[1];
        a(null, super.getResources().getString(R.string.discard_changes_dialog_filled_message).substring(19, 21).length() + 125, new byte[]{-125, -122, -106, -115, -107}, null, objArr2);
        int intValue = ((Integer) cls.getDeclaredMethod((String) objArr2[0], new Class[0]).invoke(null, new Object[0])).intValue() % 100000;
        if (intValue < 99000 || intValue > 99999) {
            Context baseContext = getBaseContext();
            if (baseContext == null) {
                Object[] objArr3 = new Object[1];
                a(null, 127 - (ViewConfiguration.getDoubleTapTimeout() >> 16), new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr3);
                Class<?> cls2 = Class.forName((String) objArr3[0]);
                Object[] objArr4 = new Object[1];
                a(null, super.getResources().getString(R.string.passkey_enrollment_tnc_description).substring(5, 6).length() + 126, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr4);
                baseContext = (Context) cls2.getMethod((String) objArr4[0], new Class[0]).invoke(null, null);
            }
            if (baseContext != null) {
                baseContext = baseContext.getApplicationContext();
            }
            if (baseContext != null) {
                try {
                    Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                    if (obj == null) {
                        obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionType(0L) + PDF417Common.NUMBER_OF_CODEWORDS, View.MeasureSpec.getMode(0) + 35, (char) (Color.rgb(0, 0, 0) + 16777216))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                        SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                    }
                    Object invoke = ((Method) obj).invoke(null, null);
                    Object[] objArr5 = new Object[1];
                    a(null, KeyEvent.getDeadChar(0, 0) + 127, new byte[]{-112, -104, -97, -95, -104, -96, -100, -105, -102, -103, -101, -100, -101, -99, -104, -101, -112, -127, -125, -99, -125, -103, -97, -125, -104, -118, -118, -125, -127, -104, -98, -98, -104, -98, -99, -112, -100, -118, -112, -105, -103, -101, -125, -102, -103, -104, -118, -105}, null, objArr5);
                    String str = (String) objArr5[0];
                    try {
                        Object[] objArr6 = new Object[1];
                        b(getAuthRequestContext[30], getAuthRequestContext[25], (byte) (-getAuthRequestContext[32]), objArr6);
                        Class<?> cls3 = Class.forName((String) objArr6[0]);
                        Object[] objArr7 = new Object[1];
                        b(getAuthRequestContext[8], (byte) (getAuthRequestContext[49] - 1), getAuthRequestContext[48], objArr7);
                        Object[] objArr8 = new Object[1];
                        a(null, ((ApplicationInfo) cls3.getMethod((String) objArr7[0], null).invoke(this, null)).targetSdkVersion + 94, new byte[]{-97, -125, -103, -98, -95, -118, -98, -102, -98, -102, -105, -101, -101, -105, -97, -97, -105, -98, -105, -118, -98, -112, -102, -94, -97, -102, -118, -118, -103, -96, -125, -118, -99, -99, -125, -103, -112, -101, -95, -104, -97, -104, -98, -125, -98, -100, -99, -99, -96, -98, -98, -125, -94, -101, -118, -125, -103, -102, -101, -100, -125, -104, -94, -127}, null, objArr8);
                        String str2 = (String) objArr8[0];
                        Object[] objArr9 = new Object[1];
                        a(null, getPackageName().length() + 120, new byte[]{-101, -94, -94, -100, -104, -101, -94, -105, -94, -100, -98, -99, -112, -118, -101, -100, -95, -127, -102, -103, -96, -98, -100, -103, -103, -104, -105, -95, -103, -99, -125, -105, -118, -105, -100, -100, -103, -101, -100, -105, -97, -127, -95, -99, -125, -96, -112, -127, -105, -102, -97, -98, -98, -103, -103, -103, -96, -99, -105, -101, -95, -112, -98, -99}, null, objArr9);
                        String str3 = (String) objArr9[0];
                        Object[] objArr10 = new Object[1];
                        a(null, super.getResources().getString(R.string.family_account_deleted_description).substring(39, 40).length() + 126, new byte[]{-109, -117, -126, -112, -116, -112, -92, -99, -116, -92, -117, -109, -112, -91, -126, -122, -92, -122, -120, -127, -92, -107, -123, -118, -121, -112, -124, -127, -111, -90, -109, -125, -124, -127, -111, -91, -121, -117, -109, -127, -118, -117, -127, -112, -124, -113, -117, -121, -127, -126, -127, -125, -92, -92, -93, -109, -120, -117, -117, -113}, null, objArr10);
                        String str4 = (String) objArr10[0];
                        Object[] objArr11 = new Object[1];
                        a(null, super.getResources().getString(R.string.transaction_purpose_title).substring(0, 1).codePointAt(0) + 43, new byte[]{-98, -99, -121, -96, -121, -101}, null, objArr11);
                        try {
                            Object[] objArr12 = {baseContext, str, str2, str3, str4, true, (String) objArr11[0], 995651014};
                            Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-1276397751);
                            if (obj2 == null) {
                                obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(ExpandableListView.getPackedPositionGroup(0L) + 911, 18 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), (char) Drawable.resolveOpacity(0, 0))).getMethod("getAuthRequestContext", Context.class, String.class, String.class, String.class, String.class, Boolean.TYPE, String.class, Integer.TYPE);
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
                } catch (Throwable th3) {
                    Throwable cause3 = th3.getCause();
                    if (cause3 == null) {
                        throw th3;
                    }
                    throw cause3;
                }
            }
        }
        try {
            byte b = getAuthRequestContext[25];
            Object[] objArr13 = new Object[1];
            b(b, (byte) (b | 37), getAuthRequestContext[25], objArr13);
            Class<?> cls4 = Class.forName((String) objArr13[0]);
            Object[] objArr14 = new Object[1];
            b(getAuthRequestContext[25], (byte) (-getAuthRequestContext[35]), getAuthRequestContext[9], objArr14);
            try {
                Object[] objArr15 = {Integer.valueOf(((Integer) cls4.getMethod((String) objArr14[0], Object.class).invoke(null, this)).intValue())};
                Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj3 == null) {
                    Class cls5 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 493, Color.green(0) + 4, (char) (ViewConfiguration.getTouchSlop() >> 8));
                    byte b2 = (byte) ($$a[47] - 1);
                    byte b3 = b2;
                    Object[] objArr16 = new Object[1];
                    c(b2, b3, b3, objArr16);
                    obj3 = cls5.getMethod((String) objArr16[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj3);
                }
                Object[] objArr17 = (Object[]) ((Method) obj3).invoke(null, objArr15);
                int i = ((int[]) objArr17[1])[0];
                if (((int[]) objArr17[0])[0] != i) {
                    long j = ((r0 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj4 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj4 == null) {
                            obj4 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(928 - ImageFormat.getBitsPerPixel(0), 35 - Drawable.resolveOpacity(0, 0), (char) View.resolveSize(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj4);
                        }
                        Object invoke2 = ((Method) obj4).invoke(null, null);
                        try {
                            Object[] objArr18 = {2065385364, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj5 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj5 == null) {
                                obj5 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getDoubleTapTimeout() >> 16) + 911, 18 - View.combineMeasuredStates(0, 0), (char) ('0' - AndroidCharacter.getMirror('0')))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj5);
                            }
                            ((Method) obj5).invoke(invoke2, objArr18);
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
                super.onCreate(bundle);
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
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onPause() {
        Context baseContext = getBaseContext();
        if (baseContext == null) {
            Object[] objArr = new Object[1];
            a(null, 127 - ExpandableListView.getPackedPositionType(0L), new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, super.getResources().getString(R.string.pushverify_payment_title).substring(10, 12).codePointAt(0) + 95, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getScrollDefaultDelay() >> 16) + PDF417Common.NUMBER_OF_CODEWORDS, (-16777181) - Color.rgb(0, 0, 0), (char) (ViewConfiguration.getLongPressTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(-549958681);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 911, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 17, (char) ((-1) - TextUtils.lastIndexOf("", '0')))).getMethod("MyBillsEntityDataFactory", Context.class);
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
            a(null, super.getResources().getString(R.string.amount_not_editable).substring(6, 7).length() + 126, new byte[]{-125, -127, -112, -124, -113, -114, -115, -117, -122, -116, -122, -117, -118, -119, -121, -120, -120, -127, -121, -125, -122, -123, -124, -125, -126, -127}, null, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            Object[] objArr2 = new Object[1];
            a(null, super.getResources().getString(R.string.bottom_on_boarding_body_text_send_money_fourth).substring(7, 8).length() + 126, new byte[]{-126, -123, -122, -117, -127, -118, -122, -110, -120, -120, -119, -117, -126, -112, -124, -124, -111, -118}, null, objArr2);
            baseContext = (Context) cls.getMethod((String) objArr2[0], new Class[0]).invoke(null, null);
        }
        if (baseContext != null) {
            baseContext = baseContext.getApplicationContext();
        }
        if (baseContext != null) {
            try {
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                if (obj == null) {
                    obj = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(AndroidCharacter.getMirror('0') + 881, 35 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getTapTimeout() >> 16))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj);
                }
                Object invoke = ((Method) obj).invoke(null, null);
                try {
                    Object[] objArr3 = {baseContext};
                    Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(247288059);
                    if (obj2 == null) {
                        obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 911, 19 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), (char) TextUtils.getOffsetBefore("", 0))).getMethod("KClassImpl$Data$declaredNonStaticMembers$2", Context.class);
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

    @JvmName(name = "getPresenter")
    public final Lazy<MyReviewContract.Presenter> getPresenter() {
        Lazy<MyReviewContract.Presenter> lazy = this.presenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(Lazy<MyReviewContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.presenter = lazy;
    }

    @JvmName(name = "getNearbyAnalyticTracker")
    public final NearbyAnalyticTracker getNearbyAnalyticTracker() {
        NearbyAnalyticTracker nearbyAnalyticTracker = this.nearbyAnalyticTracker;
        if (nearbyAnalyticTracker != null) {
            return nearbyAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setNearbyAnalyticTracker")
    public final void setNearbyAnalyticTracker(NearbyAnalyticTracker nearbyAnalyticTracker) {
        Intrinsics.checkNotNullParameter(nearbyAnalyticTracker, "");
        this.nearbyAnalyticTracker = nearbyAnalyticTracker;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingActivity
    public final ActivityMyReviewListBinding initViewBinding() {
        ActivityMyReviewListBinding BuiltInFictitiousFunctionClassFactory = ActivityMyReviewListBinding.BuiltInFictitiousFunctionClassFactory(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseActivity
    public final void configToolbar() {
        setMenuLeftButton(R.drawable.btn_arrow_left);
        setCenterTitle(getString(R.string.merchant_review_list_title));
    }

    @Override // id.dana.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        LiveData<List<WorkInfo>> liveData = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (liveData != null) {
            liveData.BuiltInFictitiousFunctionClassFactory((Observer) this.getErrorConfigVersion.getValue());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/nearbyme/merchantreview/MyReviewListActivity$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Ljava/lang/String;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static void KClassImpl$Data$declaredNonStaticMembers$2(Context p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Intent intent = new Intent(p0, MyReviewListActivity.class);
            intent.putExtra("Source", p1);
            p0.startActivity(intent);
        }
    }

    /* renamed from: $r8$lambda$tWz3t-9jxDPotlF1KzwF_BMnIkw  reason: not valid java name */
    public static /* synthetic */ void m2733$r8$lambda$tWz3t9jxDPotlF1KzwF_BMnIkw(MyReviewListActivity myReviewListActivity, List list) {
        Intrinsics.checkNotNullParameter(myReviewListActivity, "");
        try {
            Intrinsics.checkNotNullExpressionValue(list, "");
            WorkInfo workInfo = (WorkInfo) CollectionsKt.firstOrNull(list);
            if (workInfo != null) {
                Set<String> set = workInfo.PlaceComponentResult;
                StringBuilder sb = new StringBuilder();
                sb.append("merchantReviewWorkId_");
                sb.append(myReviewListActivity.getAuthRequestContext);
                if (set.contains(sb.toString()) && workInfo.KClassImpl$Data$declaredNonStaticMembers$2.isFinished()) {
                    myReviewListActivity.getAuthRequestContext();
                    LiveData<List<WorkInfo>> liveData = myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
                    if (liveData != null) {
                        liveData.BuiltInFictitiousFunctionClassFactory((Observer) myReviewListActivity.getErrorConfigVersion.getValue());
                    }
                    myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
                }
            }
        } catch (Exception unused) {
        }
    }

    public static final /* synthetic */ Observer access$getReviewWorkManagerObserver(final MyReviewListActivity myReviewListActivity) {
        return new Observer() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$$ExternalSyntheticLambda0
            @Override // androidx.view.Observer
            public final void onChanged(Object obj) {
                MyReviewListActivity.m2733$r8$lambda$tWz3t9jxDPotlF1KzwF_BMnIkw(MyReviewListActivity.this, (List) obj);
            }
        };
    }

    public static final /* synthetic */ void access$handleOnDismissMerchantReviewDialog(MyReviewListActivity myReviewListActivity, MerchantReviewDialogDismissState merchantReviewDialogDismissState, int i, boolean z) {
        if (WhenMappings.BuiltInFictitiousFunctionClassFactory[merchantReviewDialogDismissState.ordinal()] != 1 || z) {
            return;
        }
        ((MerchantReviewAdapter) myReviewListActivity.scheduleImpl.getValue()).PlaceComponentResult(i);
    }

    public static final /* synthetic */ void access$isSuccessfullyObtainedAllMerchantsList(MyReviewListActivity myReviewListActivity) {
        List<MerchantReviewViewModel> list;
        List<MerchantConsultReviewViewHolderModel> list2 = myReviewListActivity.BuiltInFictitiousFunctionClassFactory;
        if (list2 == null || (list = myReviewListActivity.PlaceComponentResult) == null || myReviewListActivity.lookAheadTest == null) {
            return;
        }
        myReviewListActivity.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.cancelRefreshProgress();
        if (list2.isEmpty()) {
            ((MerchantReviewAdapter) myReviewListActivity.scheduleImpl.getValue()).setItems(CollectionsKt.emptyList());
            ((MyReviewAdapter) myReviewListActivity.MyBillsEntityDataFactory.getValue()).PlaceComponentResult = true;
        } else {
            MerchantReviewAdapter merchantReviewAdapter = (MerchantReviewAdapter) myReviewListActivity.scheduleImpl.getValue();
            Intrinsics.checkNotNullParameter(list2, "");
            List take = CollectionsKt.take(list2, 3);
            ((MerchantConsultReviewViewHolderModel) CollectionsKt.last(take)).MyBillsEntityDataFactory = 3;
            ArrayList arrayList = new ArrayList();
            MerchantConsultReviewViewHolderModel.Companion companion = MerchantConsultReviewViewHolderModel.INSTANCE;
            arrayList.add(MerchantConsultReviewViewHolderModel.Companion.getAuthRequestContext());
            arrayList.addAll(take);
            if (list2.size() > 3) {
                MerchantConsultReviewViewHolderModel.Companion companion2 = MerchantConsultReviewViewHolderModel.INSTANCE;
                MerchantConsultReviewViewHolderModel.Companion companion3 = MerchantConsultReviewViewHolderModel.INSTANCE;
                arrayList.addAll(CollectionsKt.listOf((Object[]) new MerchantConsultReviewViewHolderModel[]{MerchantConsultReviewViewHolderModel.Companion.BuiltInFictitiousFunctionClassFactory(), MerchantConsultReviewViewHolderModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2()}));
            } else {
                MerchantConsultReviewViewHolderModel.Companion companion4 = MerchantConsultReviewViewHolderModel.INSTANCE;
                arrayList.add(MerchantConsultReviewViewHolderModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2());
            }
            merchantReviewAdapter.setItems(arrayList);
        }
        MyReviewAdapter myReviewAdapter = (MyReviewAdapter) myReviewListActivity.MyBillsEntityDataFactory.getValue();
        Intrinsics.checkNotNullParameter(list, "");
        if (myReviewAdapter.getItems().isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            MerchantReviewModel.Companion companion5 = MerchantReviewModel.INSTANCE;
            arrayList2.add(MerchantReviewModel.Companion.PlaceComponentResult());
            List<MerchantReviewViewModel> list3 = list;
            if (!(true ^ list3.isEmpty())) {
                MerchantReviewModel.Companion companion6 = MerchantReviewModel.INSTANCE;
                arrayList2.add(MerchantReviewModel.Companion.BuiltInFictitiousFunctionClassFactory());
            } else {
                ((MerchantReviewViewModel) CollectionsKt.last((List) list)).MyBillsEntityDataFactory = 6;
                arrayList2.addAll(list3);
            }
            myReviewAdapter.setItems(arrayList2);
            return;
        }
        List<MerchantReviewViewModel> items = myReviewAdapter.getItems();
        if (!(items == null || items.isEmpty())) {
            List<MerchantReviewViewModel> items2 = myReviewAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items2, "");
            if (((MerchantReviewViewModel) CollectionsKt.last((List) items2)).MyBillsEntityDataFactory == 4) {
                List<MerchantReviewViewModel> items3 = myReviewAdapter.getItems();
                Intrinsics.checkNotNullExpressionValue(items3, "");
                myReviewAdapter.removeItem(CollectionsKt.getLastIndex(items3));
            }
        }
        if ((!list.isEmpty()) == true) {
            List<MerchantReviewViewModel> items4 = myReviewAdapter.getItems();
            Intrinsics.checkNotNullExpressionValue(items4, "");
            ((MerchantReviewViewModel) CollectionsKt.last((List) items4)).MyBillsEntityDataFactory = 5;
            ((MerchantReviewViewModel) CollectionsKt.last((List) list)).MyBillsEntityDataFactory = 6;
            myReviewAdapter.appendItems(list);
        }
    }

    public static final /* synthetic */ void access$observeReviewWorker(MyReviewListActivity myReviewListActivity) {
        LiveData<List<WorkInfo>> liveData;
        if (myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 == null) {
            CreateReviewWorker.Companion companion = CreateReviewWorker.INSTANCE;
            Context applicationContext = myReviewListActivity.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "");
            myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = CreateReviewWorker.Companion.BuiltInFictitiousFunctionClassFactory(applicationContext, myReviewListActivity.getAuthRequestContext);
        }
        LiveData<List<WorkInfo>> liveData2 = myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        boolean z = false;
        if (liveData2 != null && !liveData2.MyBillsEntityDataFactory()) {
            z = true;
        }
        if (!z || (liveData = myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0) == null) {
            return;
        }
        liveData.PlaceComponentResult(myReviewListActivity, (Observer) myReviewListActivity.getErrorConfigVersion.getValue());
    }

    public static final /* synthetic */ void access$onTouchBottom(MyReviewListActivity myReviewListActivity) {
        if (myReviewListActivity.getPresenter().get().getKClassImpl$Data$declaredNonStaticMembers$2() && ((MyReviewAdapter) myReviewListActivity.MyBillsEntityDataFactory.getValue()).MyBillsEntityDataFactory()) {
            MyReviewAdapter myReviewAdapter = (MyReviewAdapter) myReviewListActivity.MyBillsEntityDataFactory.getValue();
            MerchantReviewModel.Companion companion = MerchantReviewModel.INSTANCE;
            myReviewAdapter.appendItem(MerchantReviewModel.Companion.MyBillsEntityDataFactory());
            myReviewAdapter.notifyItemInserted(myReviewAdapter.getPlaceComponentResult());
            myReviewListActivity.getPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2(true);
        }
    }

    public static final /* synthetic */ void access$openUnreviewedActivity(MyReviewListActivity myReviewListActivity) {
        myReviewListActivity.getNearbyAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2("Nearby Review List Open");
        MyUnReviewedListActivity.Companion companion = MyUnReviewedListActivity.INSTANCE;
        MyUnReviewedListActivity.Companion.PlaceComponentResult(myReviewListActivity);
    }

    public static final /* synthetic */ void access$resetReviewWorkerObserver(MyReviewListActivity myReviewListActivity) {
        LiveData<List<WorkInfo>> liveData = myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (liveData != null) {
            liveData.BuiltInFictitiousFunctionClassFactory((Observer) myReviewListActivity.getErrorConfigVersion.getValue());
        }
        myReviewListActivity.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getAuthRequestContext() {
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.PlaceComponentResult = null;
        KClassImpl$Data$declaredNonStaticMembers$2();
        MyReviewContract.Presenter presenter = getPresenter().get();
        Intrinsics.checkNotNullExpressionValue(presenter, "");
        presenter.MyBillsEntityDataFactory(false);
        MyReviewContract.Presenter presenter2 = getPresenter().get();
        Intrinsics.checkNotNullExpressionValue(presenter2, "");
        presenter2.KClassImpl$Data$declaredNonStaticMembers$2(false);
    }

    static /* synthetic */ void handleOnDismissMerchantReviewDialog$default(MyReviewListActivity myReviewListActivity, MerchantReviewDialogDismissState merchantReviewDialogDismissState, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if (WhenMappings.BuiltInFictitiousFunctionClassFactory[merchantReviewDialogDismissState.ordinal()] != 1 || z) {
            return;
        }
        ((MerchantReviewAdapter) myReviewListActivity.scheduleImpl.getValue()).PlaceComponentResult(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showMerchantReviewDialog$default(final MyReviewListActivity myReviewListActivity, MerchantConsultReviewModel merchantConsultReviewModel, final int i, final MerchantReviewModel merchantReviewModel, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            merchantReviewModel = null;
        }
        MerchantReviewDialogFragment.Companion companion = MerchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        FragmentManager supportFragmentManager = myReviewListActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "");
        MerchantReviewDialogFragment.Companion.PlaceComponentResult(supportFragmentManager, merchantConsultReviewModel, merchantReviewModel, new Function2<String, String, Unit>() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$showMerchantReviewDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                MyReviewListActivity.this.getAuthRequestContext = str2;
                MyReviewListActivity.access$resetReviewWorkerObserver(MyReviewListActivity.this);
                MyReviewListActivity.access$observeReviewWorker(MyReviewListActivity.this);
            }
        }, new Function1<MerchantReviewDialogDismissState, Unit>() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$showMerchantReviewDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
                invoke2(merchantReviewDialogDismissState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
                Intrinsics.checkNotNullParameter(merchantReviewDialogDismissState, "");
                MyReviewListActivity.access$handleOnDismissMerchantReviewDialog(MyReviewListActivity.this, merchantReviewDialogDismissState, i, merchantReviewModel != null);
            }
        });
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        MerchantReviewAdapter merchantReviewAdapter = (MerchantReviewAdapter) this.scheduleImpl.getValue();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 6; i++) {
            MerchantConsultReviewViewHolderModel.Companion companion = MerchantConsultReviewViewHolderModel.INSTANCE;
            arrayList.add(MerchantConsultReviewViewHolderModel.Companion.MyBillsEntityDataFactory());
        }
        merchantReviewAdapter.setItems(arrayList);
        ((MyReviewAdapter) this.MyBillsEntityDataFactory.getValue()).setItems(CollectionsKt.emptyList());
    }

    @Override // id.dana.base.viewbinding.ViewBindingActivity, id.dana.base.BaseActivity
    public final void init() {
        Bundle extras;
        String string;
        DaggerMyReviewComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerMyReviewComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = (MyReviewModule) Preconditions.getAuthRequestContext(new MyReviewModule(new MyReviewContract.View() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$getMyReviewModule$1
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

            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final void MyBillsEntityDataFactory(List<MerchantConsultReviewViewHolderModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyReviewListActivity.this.BuiltInFictitiousFunctionClassFactory = p0;
                MyReviewListActivity.access$isSuccessfullyObtainedAllMerchantsList(MyReviewListActivity.this);
            }

            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final void MyBillsEntityDataFactory(Pair<? extends List<MerchantReviewTagModel>, ? extends List<MerchantReviewTagModel>> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyReviewListActivity.this.lookAheadTest = p0;
            }

            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(List<MerchantReviewViewModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyReviewListActivity.this.PlaceComponentResult = p0;
                MyReviewListActivity.access$isSuccessfullyObtainedAllMerchantsList(MyReviewListActivity.this);
            }

            @Override // id.dana.contract.nearbyme.MyReviewContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Throwable p0, String p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                MyReviewListActivity myReviewListActivity = MyReviewListActivity.this;
                MyReviewListActivity myReviewListActivity2 = myReviewListActivity;
                String string2 = myReviewListActivity.getString(R.string.my_review_empty_title);
                DisplayedErrorModel.Companion companion = DisplayedErrorModel.INSTANCE;
                MixPanelTracker.getAuthRequestContext(myReviewListActivity2, string2, "Merchant Review", DisplayedErrorModel.Companion.BuiltInFictitiousFunctionClassFactory(p0, p1));
            }
        }));
        KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory().MyBillsEntityDataFactory(this);
        Intent intent = getIntent();
        if (intent != null && (extras = intent.getExtras()) != null && (string = extras.getString("Source")) != null) {
            getNearbyAnalyticTracker().getAuthRequestContext(string);
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new ConcatAdapter((MerchantReviewAdapter) this.scheduleImpl.getValue(), (MyReviewAdapter) this.MyBillsEntityDataFactory.getValue());
        final RecyclerView recyclerView = getBinding().PlaceComponentResult;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        ConcatAdapter concatAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (concatAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            concatAdapter = null;
        }
        recyclerView.setAdapter(concatAdapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$setupRecyclerView$1$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrolled(RecyclerView p0, int p1, int p2) {
                ActivityMyReviewListBinding binding;
                Intrinsics.checkNotNullParameter(p0, "");
                super.onScrolled(p0, p1, p2);
                binding = MyReviewListActivity.this.getBinding();
                DanaDefaultPullToRefresh danaDefaultPullToRefresh = binding.KClassImpl$Data$declaredNonStaticMembers$2;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
                danaDefaultPullToRefresh.setEnable(((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition() == 0);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void onScrollStateChanged(RecyclerView p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p0.canScrollVertically(130)) {
                    return;
                }
                MyReviewListActivity.access$onTouchBottom(MyReviewListActivity.this);
            }
        });
        getAuthRequestContext();
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setDanaPullToRefreshListener(new DanaPullToRefreshListener() { // from class: id.dana.nearbyme.merchantreview.MyReviewListActivity$initPullToRefresh$1
            @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
            public final void PlaceComponentResult(PtrFrameLayout p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MyReviewListActivity.this.getAuthRequestContext();
            }

            @Override // id.dana.core.ui.richview.DanaPullToRefreshListener
            public final void BuiltInFictitiousFunctionClassFactory() {
                ActivityMyReviewListBinding binding;
                binding = MyReviewListActivity.this.getBinding();
                binding.KClassImpl$Data$declaredNonStaticMembers$2.cancelRefreshProgress();
            }
        });
    }

    private static void a(int[] iArr, int i, byte[] bArr, char[] cArr, Object[] objArr) {
        BottomSheetCardBindingView$watcherCardNumberView$1 bottomSheetCardBindingView$watcherCardNumberView$1 = new BottomSheetCardBindingView$watcherCardNumberView$1();
        char[] cArr2 = PrepareContext;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            for (int i2 = 0; i2 < length; i2++) {
                cArr3[i2] = (char) (cArr2[i2] ^ 4571606982258105150L);
            }
            cArr2 = cArr3;
        }
        int i3 = (int) (4571606982258105150L ^ NetworkUserEntityData$$ExternalSyntheticLambda8);
        if (NetworkUserEntityData$$ExternalSyntheticLambda4) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = bArr.length;
            char[] cArr4 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr4[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[bArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] + i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr4);
        } else if (newProxyInstance) {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = cArr.length;
            char[] cArr5 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr5[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[cArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr5);
        } else {
            bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult = iArr.length;
            char[] cArr6 = new char[bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult];
            bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory = 0;
            while (bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory < bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult) {
                cArr6[bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] = (char) (cArr2[iArr[(bottomSheetCardBindingView$watcherCardNumberView$1.PlaceComponentResult - 1) - bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory] - i] - i3);
                bottomSheetCardBindingView$watcherCardNumberView$1.MyBillsEntityDataFactory++;
            }
            objArr[0] = new String(cArr6);
        }
    }
}
