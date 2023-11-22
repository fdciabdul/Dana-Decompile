package id.dana.nearbyme.merchantreview;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.view.LiveData;
import androidx.view.MediatorLiveData;
import androidx.view.MutableLiveData;
import androidx.view.Observer;
import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.firebase.Crashlytics;
import id.dana.base.AbstractContractKt;
import id.dana.core.ui.glide.GlideApp;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.di.component.ApplicationComponent;
import id.dana.domain.nearbyme.model.Tag;
import id.dana.nearbyme.di.component.DaggerMerchantReviewFormComponent;
import id.dana.nearbyme.di.module.MerchantReviewFormModule;
import id.dana.nearbyme.extension.NearbyViewExtKt;
import id.dana.nearbyme.merchantdetail.model.MerchantReviewModel;
import id.dana.nearbyme.merchantreview.CreateReviewWorker;
import id.dana.nearbyme.merchantreview.MerchantReviewFormContract;
import id.dana.nearbyme.merchantreview.MerchantReviewMainView;
import id.dana.nearbyme.merchantreview.MerchantReviewPhotosView;
import id.dana.nearbyme.merchantreview.ViewRatingStarBar;
import id.dana.nearbyme.merchantreview.model.MerchantConsultReviewModel;
import id.dana.nearbyme.merchantreview.model.MerchantReviewDialogDismissState;
import id.dana.nearbyme.merchantreview.model.MerchantReviewTagModel;
import id.dana.nearbyme.merchantreview.model.SentimentState;
import id.dana.nearbyme.merchantreview.tracker.MerchantReviewFormAnalyticTracker;
import id.dana.onboarding.splash.LauncherActivity;
import id.dana.sendmoney.feed.ShareToFeedsView;
import id.dana.utils.DateTimeUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0001|B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u00107\u001a\u00020\u00112\u0006\u00108\u001a\u00020&H\u0002J\u000f\u00109\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010:J\u0010\u0010;\u001a\n \u0007*\u0004\u0018\u00010<0<H\u0002J\b\u0010=\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020\u0011H\u0002J\u0018\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020&2\u0006\u00108\u001a\u00020&H\u0002J\u001c\u0010A\u001a\u00020\u00112\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u00108\u001a\u00020&H\u0002J\b\u0010B\u001a\u00020\u0011H\u0002J\u0012\u0010C\u001a\u00020\u00112\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010F\u001a\u00020\u0011H\u0016J\u0010\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u00020\u00112\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J&\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010P2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010Q\u001a\u00020\u0011H\u0016J\u0010\u0010\u000e\u001a\u00020\u00112\u0006\u0010H\u001a\u00020IH\u0016J-\u0010R\u001a\u00020\u00112\u0006\u0010S\u001a\u00020&2\u000e\u0010T\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180U2\u0006\u0010V\u001a\u00020WH\u0016¢\u0006\u0002\u0010XJ\u001a\u0010Y\u001a\u00020\u00112\u0006\u0010Z\u001a\u00020L2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010[\u001a\u00020\u0011H\u0002J\b\u0010\\\u001a\u00020\u0011H\u0002J\u0010\u0010]\u001a\u00020\u00112\u0006\u0010^\u001a\u00020\u0018H\u0002J\u0016\u0010_\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010a0a0`H\u0002J\b\u0010b\u001a\u00020\u0011H\u0002J\b\u0010c\u001a\u00020\u0011H\u0002J\u000f\u0010d\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010:J\n\u0010e\u001a\u0004\u0018\u00010fH\u0002J\b\u0010g\u001a\u00020\u0011H\u0002J\u000f\u0010h\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010:J\u000f\u0010i\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010:J\u000f\u0010j\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010:J\u0010\u0010k\u001a\u00020\u00112\u0006\u0010l\u001a\u00020&H\u0002J\b\u0010m\u001a\u00020\u0011H\u0002J\u0010\u0010n\u001a\u00020\u00112\u0006\u0010l\u001a\u00020&H\u0002J\u0010\u0010o\u001a\u00020\u00112\u0006\u00108\u001a\u00020&H\u0002J\u0010\u0010p\u001a\u00020\u00112\u0006\u0010q\u001a\u00020\u0006H\u0016J\u001b\u0010r\u001a\u00020\u00112\f\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00180UH\u0016¢\u0006\u0002\u0010tJ\u0017\u0010u\u001a\u0004\u0018\u00010\u00112\u0006\u0010v\u001a\u00020\u0018H\u0002¢\u0006\u0002\u0010wJ\b\u0010x\u001a\u00020\u0011H\u0002J\b\u0010y\u001a\u00020\u0011H\u0002J\u0014\u0010z\u001a\u00020{*\u0002022\u0006\u0010v\u001a\u00020\u0018H\u0002R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006}"}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Lid/dana/nearbyme/merchantreview/MerchantReviewPhotosView$PhotosViewInteraction;", "()V", "imageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "isShareFeedFeatureEnabled", "", "isUpdateReview", "()Z", "setUpdateReview", "(Z)V", "onDismiss", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewDialogDismissState;", "", "getOnDismiss", "()Lkotlin/jvm/functions/Function1;", "setOnDismiss", "(Lkotlin/jvm/functions/Function1;)V", "onSubmitListener", "Lkotlin/Function2;", "", "presenter", "Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$Presenter;", "getPresenter", "()Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$Presenter;", "setPresenter", "(Lid/dana/nearbyme/merchantreview/MerchantReviewFormContract$Presenter;)V", "previousMerchantReview", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "getPreviousMerchantReview", "()Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "setPreviousMerchantReview", "(Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;)V", "previousRating", "", "getPreviousRating", "()I", "setPreviousRating", "(I)V", "tracker", "Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormAnalyticTracker;", "getTracker", "()Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormAnalyticTracker;", "setTracker", "(Lid/dana/nearbyme/merchantreview/tracker/MerchantReviewFormAnalyticTracker;)V", "viewState", "Lid/dana/nearbyme/merchantreview/MerchantReviewViewState;", "getViewState", "()Lid/dana/nearbyme/merchantreview/MerchantReviewViewState;", "setViewState", "(Lid/dana/nearbyme/merchantreview/MerchantReviewViewState;)V", "checkPreviousMerchantReview", "newRating", "determineExpansionState", "()Lkotlin/Unit;", "getApplicationComponent", "Lid/dana/di/component/ApplicationComponent;", "getBannerView", "getFeedFeatureSwitch", "hasSameSentiment", "oldRating", "loadMerchantReview", "loadPreviousMerchantPhotos", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAddPhotoClick", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", BranchLinkConstant.PathTarget.CONTAINER, "Landroid/view/ViewGroup;", "onDestroy", "onRequestPermissionsResult", RequestPermission.REQUEST_CODE, RequestPermission.PERMISSIONS, "", RequestPermission.GRANT_RESULTS, "", "(I[Ljava/lang/String;[I)V", "onViewCreated", "view", "setFullScreenDialog", "setupAddPhoto", "setupBannerView", "url", "setupBottomSheet", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/FrameLayout;", "setupDependency", "setupDivider", "setupHeaderView", "setupMerchantRatingView", "Lid/dana/nearbyme/merchantreview/MerchantReviewRatingView;", "setupPhotosView", "setupReviewView", "setupSentimentObserver", "setupSubmitButton", "setupTagSelected", "rating", "setupViewState", "showPreviousReview", "showRecentComment", "startImageIntent", "intent", "startRequestPermission", "requiredPermission", "([Ljava/lang/String;)V", "submitReview", "workUuid", "(Ljava/lang/String;)Lkotlin/Unit;", "trackActivity", "trackReviewSubmit", "toCreateReviewParam", "Lid/dana/nearbyme/merchantreview/CreateReviewWorker$Param;", "Companion", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantReviewDialogFragment extends BottomSheetDialogFragment implements MerchantReviewPhotosView.PhotosViewInteraction {
    public static MerchantConsultReviewModel PlaceComponentResult;
    private final ActivityResultLauncher<Intent> GetContactSyncConfig;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    MerchantReviewModel getErrorConfigVersion;
    private Function2<? super String, ? super String, Unit> initRecordTimeStamp;
    MerchantReviewViewState lookAheadTest;
    @Inject
    public MerchantReviewFormContract.Presenter presenter;
    public boolean scheduleImpl;
    @Inject
    public MerchantReviewFormAnalyticTracker tracker;
    public static final byte[] $$a = {123, 85, -72, 69, -1, TarHeader.LF_NORMAL, -4, Ascii.EM, 7, -35, 43, 10, 3, -65, 39, 36, Ascii.SUB, -12, -54, 71, 8, 5, 16, -4, Ascii.CAN, -6, 6, -15, 40, 6, -20, 40, -12, Ascii.SUB, -4, 1, -15, Ascii.US, 15, -4, 10, Ascii.DC4, 8, -72, Ascii.NAK};
    public static final int $$b = 181;
    public static final byte[] NetworkUserEntityData$$ExternalSyntheticLambda1 = {SignedBytes.MAX_POWER_OF_TWO, 19, 79, -17, 7, 1, -7, -4, 13, -9, -3, TarHeader.LF_CHR, -23, -16, 13, 39, -42, 13, 1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -36, 8, 1, 17, -6};
    public static final int DatabaseTableConfigUtil = 78;
    public static final Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion(null);
    public Map<Integer, View> MyBillsEntityDataFactory = new LinkedHashMap();
    Function1<? super MerchantReviewDialogDismissState, Unit> moveToNextValue = new Function1<MerchantReviewDialogDismissState, Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$onDismiss$1
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
            Intrinsics.checkNotNullParameter(merchantReviewDialogDismissState, "");
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(MerchantReviewDialogDismissState merchantReviewDialogDismissState) {
            invoke2(merchantReviewDialogDismissState);
            return Unit.INSTANCE;
        }
    };
    int NetworkUserEntityData$$ExternalSyntheticLambda0 = -1;

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(int i, int i2) {
        return (i > 3 && i2 > 3) || (i <= 3 && i2 <= 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0025 -> B:35:0x002c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(byte r6, short r7, byte r8, java.lang.Object[] r9) {
        /*
            byte[] r0 = id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.NetworkUserEntityData$$ExternalSyntheticLambda1
            int r8 = r8 * 15
            int r8 = r8 + 4
            int r6 = 106 - r6
            int r7 = r7 * 2
            int r7 = 16 - r7
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r6 = r7
            r4 = r8
            r3 = 0
            goto L2c
        L17:
            r3 = 0
        L18:
            byte r4 = (byte) r6
            r1[r3] = r4
            if (r3 != r7) goto L25
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L25:
            r4 = r0[r8]
            int r3 = r3 + 1
            r5 = r7
            r7 = r6
            r6 = r5
        L2c:
            int r8 = r8 + 1
            int r4 = -r4
            int r7 = r7 + r4
            int r7 = r7 + 2
            r5 = r7
            r7 = r6
            r6 = r5
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.a(byte, short, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x002c -> B:35:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(byte r6, byte r7, short r8, java.lang.Object[] r9) {
        /*
            int r6 = r6 * 3
            int r6 = r6 + 75
            byte[] r0 = id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.$$a
            int r7 = r7 * 3
            int r7 = r7 + 42
            int r8 = r8 * 3
            int r8 = 4 - r8
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L1c
            r6 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L1c:
            r3 = 0
        L1d:
            byte r4 = (byte) r6
            r1[r3] = r4
            int r4 = r3 + 1
            if (r3 != r7) goto L2c
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2c:
            r3 = r0[r8]
            r5 = r9
            r9 = r6
            r6 = r7
            r7 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L35:
            int r8 = r8 + 1
            int r9 = r9 + r7
            int r7 = r9 + (-7)
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r7
            r7 = r6
            r6 = r5
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.b(byte, byte, short, java.lang.Object[]):void");
    }

    public final View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        View findViewById;
        Map<Integer, View> map = this.MyBillsEntityDataFactory;
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

    public MerchantReviewDialogFragment() {
        ActivityResultLauncher<Intent> registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda1
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                MerchantReviewDialogFragment.getAuthRequestContext(MerchantReviewDialogFragment.this, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "");
        this.GetContactSyncConfig = registerForActivityResult;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle savedInstanceState) {
        try {
            byte b = (byte) (NetworkUserEntityData$$ExternalSyntheticLambda1[5] - 1);
            Object[] objArr = new Object[1];
            a(b, b, NetworkUserEntityData$$ExternalSyntheticLambda1[5], objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b2 = NetworkUserEntityData$$ExternalSyntheticLambda1[5];
            byte b3 = (byte) (b2 - 1);
            Object[] objArr2 = new Object[1];
            a(b2, b3, b3, objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(494 - View.MeasureSpec.makeMeasureSpec(0, 0), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 5, (char) Color.argb(0, 0, 0, 0));
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
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(929 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 34 - ((byte) KeyEvent.getModifierMetaStateMask()), (char) View.MeasureSpec.makeMeasureSpec(0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {-1179764793, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 18, (char) TextUtils.indexOf("", ""))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
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
                super.onCreate(savedInstanceState);
                setStyle(0, R.style.f50062132017470);
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
    public final View onCreateView(LayoutInflater inflater, ViewGroup r3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "");
        return inflater.inflate(R.layout.view_merchant_review, r3, false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(final View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "");
        super.onViewCreated(view, savedInstanceState);
        MerchantReviewMainView merchantReviewMainView = (MerchantReviewMainView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.positiveButtonClicked);
        if (merchantReviewMainView != null) {
            merchantReviewMainView.setOnEditTextClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MerchantReviewDialogFragment.PlaceComponentResult(MerchantReviewDialogFragment.this);
                }
            });
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda4
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    MerchantReviewDialogFragment.BuiltInFictitiousFunctionClassFactory(MerchantReviewDialogFragment.this);
                }
            });
        }
        ((ShareToFeedsView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.share_to_feed_view)).setOnActivateButtonClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MerchantReviewDialogFragment.getAuthRequestContext(MerchantReviewDialogFragment.this);
            }
        });
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$onViewCreated$4
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                View findViewById;
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Dialog dialog2 = this.getDialog();
                if (dialog2 == null || (findViewById = dialog2.findViewById(R.id.design_bottom_sheet)) == null) {
                    return;
                }
                BottomSheetBehavior.from(findViewById).setState(3);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle savedInstanceState) {
        Unit unit;
        MerchantReviewFormAnalyticTracker merchantReviewFormAnalyticTracker;
        MediatorLiveData<Boolean> mediatorLiveData;
        LiveData<SentimentState> liveData;
        MutableLiveData<Integer> mutableLiveData;
        String str;
        MerchantReviewPhotosView merchantReviewPhotosView;
        Unit unit2;
        MutableLiveData<Integer> mutableLiveData2;
        List<Tag> emptyList;
        List<Tag> emptyList2;
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        byte b = 0;
        MerchantReviewFormContract.Presenter presenter = null;
        if (arguments != null) {
            MerchantConsultReviewModel merchantConsultReviewModel = (MerchantConsultReviewModel) arguments.getParcelable("MERCHANT_REVIEW_DATA_KEY");
            if (merchantConsultReviewModel != null) {
                this.lookAheadTest = new MerchantReviewViewState(merchantConsultReviewModel);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                dismiss();
            }
            MerchantReviewViewState merchantReviewViewState = this.lookAheadTest;
            MutableLiveData<Integer> mutableLiveData3 = merchantReviewViewState != null ? merchantReviewViewState.lookAheadTest : null;
            if (mutableLiveData3 != null) {
                mutableLiveData3.PlaceComponentResult((MutableLiveData<Integer>) Integer.valueOf(arguments.getInt("MERCHANT_REVIEW_STAR_COUNT_KEY")));
            }
            MerchantReviewModel merchantReviewModel = (MerchantReviewModel) arguments.getParcelable("PREVIOUS_MERCHANT_REVIEW_DATA_KEY");
            if (merchantReviewModel != null) {
                this.getErrorConfigVersion = merchantReviewModel;
                this.scheduleImpl = true;
                MerchantReviewViewState merchantReviewViewState2 = this.lookAheadTest;
                if (merchantReviewViewState2 != null && (mutableLiveData2 = merchantReviewViewState2.lookAheadTest) != null) {
                    Object obj = mutableLiveData2.BuiltInFictitiousFunctionClassFactory;
                    if (obj == LiveData.MyBillsEntityDataFactory) {
                        obj = null;
                    }
                    Integer num = (Integer) obj;
                    if (num != null) {
                        Intrinsics.checkNotNullExpressionValue(num, "");
                        int intValue = num.intValue();
                        if (intValue > 3) {
                            MerchantReviewViewState merchantReviewViewState3 = this.lookAheadTest;
                            if (merchantReviewViewState3 != null) {
                                MerchantReviewModel merchantReviewModel2 = this.getErrorConfigVersion;
                                merchantReviewViewState3.MyBillsEntityDataFactory = merchantReviewModel2 != null ? merchantReviewModel2.NetworkUserEntityData$$ExternalSyntheticLambda1 : null;
                            }
                        } else {
                            MerchantReviewViewState merchantReviewViewState4 = this.lookAheadTest;
                            if (merchantReviewViewState4 != null) {
                                MerchantReviewModel merchantReviewModel3 = this.getErrorConfigVersion;
                                merchantReviewViewState4.BuiltInFictitiousFunctionClassFactory = merchantReviewModel3 != null ? merchantReviewModel3.NetworkUserEntityData$$ExternalSyntheticLambda1 : null;
                            }
                        }
                        PlaceComponentResult(intValue);
                        if (num.intValue() > 3) {
                            MerchantReviewViewState merchantReviewViewState5 = this.lookAheadTest;
                            if (merchantReviewViewState5 != null) {
                                MerchantReviewModel merchantReviewModel4 = this.getErrorConfigVersion;
                                if (merchantReviewModel4 == null || (emptyList2 = merchantReviewModel4.NetworkUserEntityData$$ExternalSyntheticLambda2) == null) {
                                    emptyList2 = CollectionsKt.emptyList();
                                }
                                merchantReviewViewState5.KClassImpl$Data$declaredNonStaticMembers$2(emptyList2, true);
                            }
                        } else {
                            MerchantReviewViewState merchantReviewViewState6 = this.lookAheadTest;
                            if (merchantReviewViewState6 != null) {
                                MerchantReviewModel merchantReviewModel5 = this.getErrorConfigVersion;
                                if (merchantReviewModel5 == null || (emptyList = merchantReviewModel5.lookAheadTest) == null) {
                                    emptyList = CollectionsKt.emptyList();
                                }
                                merchantReviewViewState6.KClassImpl$Data$declaredNonStaticMembers$2(emptyList, false);
                            }
                        }
                    }
                }
                MerchantReviewViewState merchantReviewViewState7 = this.lookAheadTest;
                if (merchantReviewViewState7 != null) {
                    String str2 = merchantReviewModel.DatabaseTableConfigUtil;
                    if (!(str2.length() > 0)) {
                        str2 = null;
                    }
                    merchantReviewViewState7.NetworkUserEntityData$$ExternalSyntheticLambda0 = str2;
                }
            }
        }
        if (this.getErrorConfigVersion != null) {
            if ((!r12.BuiltInFictitiousFunctionClassFactory.isEmpty()) == true) {
                MerchantReviewPhotosView merchantReviewPhotosView2 = (MerchantReviewPhotosView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.view_photo);
                if (merchantReviewPhotosView2 != null) {
                    merchantReviewPhotosView2.hideAddPhotos();
                }
            } else {
                MerchantReviewPhotosView merchantReviewPhotosView3 = (MerchantReviewPhotosView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.view_photo);
                if (merchantReviewPhotosView3 != null) {
                    merchantReviewPhotosView3.setVisibility(8);
                }
            }
        }
        MerchantReviewModel merchantReviewModel6 = this.getErrorConfigVersion;
        if (merchantReviewModel6 != null && (merchantReviewPhotosView = (MerchantReviewPhotosView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.view_photo)) != null) {
            merchantReviewPhotosView.addItemFromMerchantReview(CollectionsKt.take(merchantReviewModel6.BuiltInFictitiousFunctionClassFactory, 10));
        }
        BottomSheetBehavior from = BottomSheetBehavior.from((FrameLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator));
        from.setPeekHeight(Resources.getSystem().getDisplayMetrics().heightPixels);
        from.setState(3);
        from.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$setupBottomSheet$1$1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onSlide(View p0, float p1) {
                Intrinsics.checkNotNullParameter(p0, "");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public final void onStateChanged(View p0, int p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                if (p1 != 1) {
                    if (p1 == 5) {
                        MerchantReviewDialogFragment.this.dismiss();
                        return;
                    }
                    return;
                }
                ConstraintLayout constraintLayout = (ConstraintLayout) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.VerifyPushDerollRequest_res_0x7f0a04a9);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
                ShareToFeedsView shareToFeedsView = (ShareToFeedsView) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.share_to_feed_view);
                if (shareToFeedsView != null) {
                    shareToFeedsView.setVisibility(0);
                }
                AppCompatButton appCompatButton = (AppCompatButton) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.getDefaultSenderId_res_0x7f0a0238);
                if (appCompatButton != null) {
                    appCompatButton.setVisibility(0);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(from, "");
        MerchantReviewViewState merchantReviewViewState8 = this.lookAheadTest;
        if (merchantReviewViewState8 != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.iv_merchant_logo);
            if (appCompatImageView != null) {
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                AppCompatImageView appCompatImageView2 = appCompatImageView;
                String str3 = merchantReviewViewState8.PlaceComponentResult.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda8;
                if (str3 == null) {
                    str3 = "";
                }
                NearbyViewExtKt.MyBillsEntityDataFactory(appCompatImageView2, str3);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tv_merchant_name);
            if (appCompatTextView != null) {
                String str4 = merchantReviewViewState8.PlaceComponentResult.MyBillsEntityDataFactory.newProxyInstance;
                if (str4 == null) {
                    str4 = "";
                }
                appCompatTextView.setText(str4);
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tv_transaction_date);
            if (appCompatTextView2 != null) {
                if (merchantReviewViewState8.PlaceComponentResult.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$2 != null) {
                    Long l = merchantReviewViewState8.PlaceComponentResult.MyBillsEntityDataFactory.VerifyPinStateManager$executeRiskChallenge$2$2;
                    Intrinsics.checkNotNullExpressionValue(l, "");
                    str = DateTimeUtil.MyBillsEntityDataFactory(new Date(l.longValue()), "dd MMM yyyy • HH:mm", Locale.US);
                    Intrinsics.checkNotNullExpressionValue(str, "");
                } else {
                    str = "";
                }
                appCompatTextView2.setText(str);
            }
            Unit unit3 = Unit.INSTANCE;
        }
        final MerchantReviewRatingView merchantReviewRatingView = (MerchantReviewRatingView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1b6d_com_alibaba_ariver_engine_api_extopt_9);
        if (merchantReviewRatingView != null) {
            MerchantReviewViewState merchantReviewViewState9 = this.lookAheadTest;
            if (merchantReviewViewState9 != null && (mutableLiveData = merchantReviewViewState9.lookAheadTest) != null) {
                mutableLiveData.PlaceComponentResult(getViewLifecycleOwner(), new Observer() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda9
                    @Override // androidx.view.Observer
                    public final void onChanged(Object obj2) {
                        MerchantReviewRatingView.this.setStarRating(((Integer) obj2).intValue());
                    }
                });
            }
            merchantReviewRatingView.setClickListener(new ViewRatingStarBar.ClickListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$setupMerchantRatingView$1$2
                @Override // id.dana.nearbyme.merchantreview.ViewRatingStarBar.ClickListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(int p0) {
                    MutableLiveData<Integer> mutableLiveData4;
                    MerchantReviewViewState merchantReviewViewState10 = MerchantReviewDialogFragment.this.lookAheadTest;
                    if (merchantReviewViewState10 != null && (mutableLiveData4 = merchantReviewViewState10.lookAheadTest) != null) {
                        Object obj2 = mutableLiveData4.BuiltInFictitiousFunctionClassFactory;
                        if (obj2 == LiveData.MyBillsEntityDataFactory) {
                            obj2 = null;
                        }
                        Integer num2 = (Integer) obj2;
                        if (num2 != null) {
                            MerchantReviewDialogFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0 = num2.intValue();
                        }
                    }
                    MerchantReviewViewState merchantReviewViewState11 = MerchantReviewDialogFragment.this.lookAheadTest;
                    MutableLiveData<Integer> mutableLiveData5 = merchantReviewViewState11 != null ? merchantReviewViewState11.lookAheadTest : null;
                    if (mutableLiveData5 != null) {
                        mutableLiveData5.PlaceComponentResult((MutableLiveData<Integer>) Integer.valueOf(p0));
                    }
                    if (MerchantReviewDialogFragment.this.getErrorConfigVersion != null) {
                        MerchantReviewDialogFragment.BuiltInFictitiousFunctionClassFactory(MerchantReviewDialogFragment.this, p0);
                    } else {
                        MerchantReviewDialogFragment.this.MyBillsEntityDataFactory((MerchantReviewModel) null, p0);
                    }
                    MerchantReviewDialogFragment.this.PlaceComponentResult(p0);
                    ConstraintLayout constraintLayout = (ConstraintLayout) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.VerifyPushDerollRequest_res_0x7f0a04a9);
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(0);
                    }
                    ShareToFeedsView shareToFeedsView = (ShareToFeedsView) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.share_to_feed_view);
                    if (shareToFeedsView != null) {
                        shareToFeedsView.setVisibility(0);
                    }
                    AppCompatButton appCompatButton = (AppCompatButton) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.getDefaultSenderId_res_0x7f0a0238);
                    if (appCompatButton != null) {
                        appCompatButton.setVisibility(0);
                    }
                    BottomSheetBehavior.from((FrameLayout) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator)).setState(3);
                    MerchantReviewDialogFragment.MyBillsEntityDataFactory(MerchantReviewDialogFragment.this);
                    MerchantReviewMainView merchantReviewMainView = (MerchantReviewMainView) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.positiveButtonClicked);
                    if (merchantReviewMainView != null) {
                        merchantReviewMainView.removeFocus();
                    }
                }
            });
        }
        final MerchantReviewSentimentView merchantReviewSentimentView = (MerchantReviewSentimentView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a1b80_com_alibaba_ariver_engine_api_extopt_5);
        if (merchantReviewSentimentView != null) {
            MerchantReviewViewState merchantReviewViewState10 = this.lookAheadTest;
            if (merchantReviewViewState10 != null && (liveData = merchantReviewViewState10.getErrorConfigVersion) != null) {
                liveData.PlaceComponentResult(getViewLifecycleOwner(), new Observer() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda2
                    @Override // androidx.view.Observer
                    public final void onChanged(Object obj2) {
                        MerchantReviewSentimentView.this.updateSentiment((SentimentState) obj2);
                    }
                });
            }
            merchantReviewSentimentView.setOnTagClick(new Function0<Unit>() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$setupSentimentObserver$1$2
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
                    MerchantReviewMainView merchantReviewMainView = (MerchantReviewMainView) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.positiveButtonClicked);
                    if (merchantReviewMainView != null) {
                        merchantReviewMainView.removeFocus();
                    }
                }
            });
            Unit unit4 = Unit.INSTANCE;
        }
        MerchantReviewMainView merchantReviewMainView = (MerchantReviewMainView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.positiveButtonClicked);
        if (merchantReviewMainView != null) {
            merchantReviewMainView.setTextListener(new MerchantReviewMainView.TextListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$setupReviewView$1
                @Override // id.dana.nearbyme.merchantreview.MerchantReviewMainView.TextListener
                public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    MerchantReviewViewState merchantReviewViewState11 = MerchantReviewDialogFragment.this.lookAheadTest;
                    if (merchantReviewViewState11 != null) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        merchantReviewViewState11.moveToNextValue = p0;
                    }
                    MerchantReviewViewState merchantReviewViewState12 = MerchantReviewDialogFragment.this.lookAheadTest;
                    MutableLiveData<Boolean> mutableLiveData4 = merchantReviewViewState12 != null ? merchantReviewViewState12.scheduleImpl : null;
                    if (mutableLiveData4 != null) {
                        mutableLiveData4.PlaceComponentResult((MutableLiveData<Boolean>) Boolean.valueOf(p0.length() > 150));
                    }
                }
            });
            Unit unit5 = Unit.INSTANCE;
        }
        MerchantReviewPhotosView merchantReviewPhotosView4 = (MerchantReviewPhotosView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.view_photo);
        if (merchantReviewPhotosView4 != null) {
            merchantReviewPhotosView4.setListener(this);
        }
        NestedScrollView nestedScrollView = (NestedScrollView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_merchant_review);
        if (nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda8
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void getAuthRequestContext(NestedScrollView nestedScrollView2, int i, int i2, int i3, int i4) {
                    MerchantReviewDialogFragment.MyBillsEntityDataFactory(MerchantReviewDialogFragment.this, nestedScrollView2);
                }
            });
        }
        final AppCompatButton appCompatButton = (AppCompatButton) KClassImpl$Data$declaredNonStaticMembers$2(R.id.getDefaultSenderId_res_0x7f0a0238);
        if (appCompatButton != null) {
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantReviewDialogFragment.PlaceComponentResult(MerchantReviewDialogFragment.this, appCompatButton);
                }
            });
            MerchantReviewViewState merchantReviewViewState11 = this.lookAheadTest;
            if (merchantReviewViewState11 != null && (mediatorLiveData = merchantReviewViewState11.getAuthRequestContext) != null) {
                mediatorLiveData.PlaceComponentResult(getViewLifecycleOwner(), new Observer() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda7
                    @Override // androidx.view.Observer
                    public final void onChanged(Object obj2) {
                        AppCompatButton.this.setEnabled(((Boolean) obj2).booleanValue());
                    }
                });
                Unit unit6 = Unit.INSTANCE;
            }
        }
        DaggerMerchantReviewFormComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerMerchantReviewFormComponent.BuiltInFictitiousFunctionClassFactory();
        FragmentActivity activity = getActivity();
        Context applicationContext = activity != null ? activity.getApplicationContext() : null;
        if (applicationContext == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(((DanaApplication) applicationContext).getApplicationComponent());
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (MerchantReviewFormModule) Preconditions.getAuthRequestContext(new MerchantReviewFormModule(new MerchantReviewFormContract.View() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$setupDependency$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str5) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.nearbyme.merchantreview.MerchantReviewFormContract.View
            public final void getAuthRequestContext(boolean p0) {
                MerchantReviewDialogFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda2 = p0;
                ShareToFeedsView shareToFeedsView = (ShareToFeedsView) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.share_to_feed_view);
                if (shareToFeedsView != null) {
                    shareToFeedsView.setShareFeedFeatureEnabled(p0);
                }
                ShareToFeedsView shareToFeedsView2 = (ShareToFeedsView) MerchantReviewDialogFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(R.id.share_to_feed_view);
                if (shareToFeedsView2 != null) {
                    shareToFeedsView2.autoEnableShareFeed();
                }
            }

            @Override // id.dana.nearbyme.merchantreview.MerchantReviewFormContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                MerchantReviewDialogFragment.PlaceComponentResult(MerchantReviewDialogFragment.this, p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, MerchantReviewFormModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ApplicationComponent.class);
        new DaggerMerchantReviewFormComponent.MerchantReviewFormComponentImpl(BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2, BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, b).BuiltInFictitiousFunctionClassFactory(this);
        MerchantConsultReviewModel merchantConsultReviewModel2 = PlaceComponentResult;
        if (merchantConsultReviewModel2 != null) {
            MerchantReviewFormAnalyticTracker merchantReviewFormAnalyticTracker2 = this.tracker;
            if (merchantReviewFormAnalyticTracker2 != null) {
                merchantReviewFormAnalyticTracker = merchantReviewFormAnalyticTracker2;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantReviewFormAnalyticTracker = null;
            }
            String str5 = merchantConsultReviewModel2.scheduleImpl;
            String str6 = merchantConsultReviewModel2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda6;
            String str7 = str6 == null ? "" : str6;
            String str8 = merchantConsultReviewModel2.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda3;
            String str9 = str8 == null ? "" : str8;
            String str10 = merchantConsultReviewModel2.MyBillsEntityDataFactory.newProxyInstance;
            merchantReviewFormAnalyticTracker.getAuthRequestContext(str5, str7, str9, str10 == null ? "" : str10, this.scheduleImpl);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            Crashlytics.Companion companion = Crashlytics.INSTANCE;
            Crashlytics authRequestContext = Crashlytics.Companion.getAuthRequestContext();
            Exception exc = new Exception("Try tracking but model still null");
            Intrinsics.checkNotNullParameter(exc, "");
            authRequestContext.getAuthRequestContext.recordException(exc);
        }
        MerchantReviewFormContract.Presenter presenter2 = this.presenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        presenter2.getAuthRequestContext();
        MerchantReviewFormContract.Presenter presenter3 = this.presenter;
        if (presenter3 != null) {
            if (presenter3 != null) {
                presenter = presenter3;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            presenter.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "");
        super.onCancel(dialog);
        MerchantReviewViewState merchantReviewViewState = this.lookAheadTest;
        if (merchantReviewViewState != null) {
            MerchantReviewDialogDismissState merchantReviewDialogDismissState = MerchantReviewDialogDismissState.DISMISSED_BY_CANCEL;
            Intrinsics.checkNotNullParameter(merchantReviewDialogDismissState, "");
            merchantReviewViewState.KClassImpl$Data$declaredNonStaticMembers$2 = merchantReviewDialogDismissState;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "");
        super.onDismiss(dialog);
        MerchantReviewViewState merchantReviewViewState = this.lookAheadTest;
        if (merchantReviewViewState != null) {
            Iterator<T> it = merchantReviewViewState.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.iterator();
            while (it.hasNext()) {
                ((MerchantReviewTagModel) it.next()).MyBillsEntityDataFactory = false;
            }
            Iterator<T> it2 = merchantReviewViewState.PlaceComponentResult.PlaceComponentResult.iterator();
            while (it2.hasNext()) {
                ((MerchantReviewTagModel) it2.next()).MyBillsEntityDataFactory = false;
            }
            this.moveToNextValue.invoke(merchantReviewViewState.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewPhotosView.PhotosViewInteraction
    public final void getAuthRequestContext() {
        MerchantReviewPhotosView merchantReviewPhotosView = (MerchantReviewPhotosView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.view_photo);
        if (merchantReviewPhotosView != null) {
            merchantReviewPhotosView.checkForPermission();
        }
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewPhotosView.PhotosViewInteraction
    public final void PlaceComponentResult(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "");
        this.GetContactSyncConfig.MyBillsEntityDataFactory(intent, null);
    }

    @Override // id.dana.nearbyme.merchantreview.MerchantReviewPhotosView.PhotosViewInteraction
    public final void PlaceComponentResult(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "");
        requestPermissions(strArr, 1002);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "");
        Intrinsics.checkNotNullParameter(r4, "");
        super.onRequestPermissionsResult(r2, r3, r4);
        MerchantReviewPhotosView merchantReviewPhotosView = (MerchantReviewPhotosView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.view_photo);
        if (merchantReviewPhotosView != null) {
            merchantReviewPhotosView.onRequestPermissionResult(r2, r4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x001e, code lost:
    
        if (r2 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0027, code lost:
    
        if (r2 == null) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0029, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x002c, code lost:
    
        r4 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PlaceComponentResult(int r4) {
        /*
            r3 = this;
            int r0 = id.dana.R.id.positiveButtonClicked
            android.view.View r0 = r3.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            id.dana.nearbyme.merchantreview.MerchantReviewMainView r0 = (id.dana.nearbyme.merchantreview.MerchantReviewMainView) r0
            if (r0 == 0) goto L32
            int r1 = id.dana.R.id.res_0x7f0a069f_spansuppressionstrategy_3
            android.view.View r0 = r0._$_findCachedViewById(r1)
            androidx.appcompat.widget.AppCompatEditText r0 = (androidx.appcompat.widget.AppCompatEditText) r0
            if (r0 == 0) goto L32
            r1 = 3
            r2 = 0
            if (r4 <= r1) goto L21
            id.dana.nearbyme.merchantreview.MerchantReviewViewState r4 = r3.lookAheadTest
            if (r4 == 0) goto L1e
            java.lang.String r2 = r4.MyBillsEntityDataFactory
        L1e:
            if (r2 != 0) goto L2c
            goto L29
        L21:
            id.dana.nearbyme.merchantreview.MerchantReviewViewState r4 = r3.lookAheadTest
            if (r4 == 0) goto L27
            java.lang.String r2 = r4.BuiltInFictitiousFunctionClassFactory
        L27:
            if (r2 != 0) goto L2c
        L29:
            java.lang.String r4 = ""
            goto L2d
        L2c:
            r4 = r2
        L2d:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0.setText(r4)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.PlaceComponentResult(int):void");
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001bH\u0002J^\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u001c\b\u0002\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0007J@\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Lid/dana/nearbyme/merchantreview/MerchantReviewDialogFragment$Companion;", "", "()V", "MERCHANT_REVIEW_DATA_KEY", "", "MERCHANT_REVIEW_FULL_EXPAND", "MERCHANT_REVIEW_STAR_COUNT_KEY", "PREVIOUS_MERCHANT_REVIEW_DATA_KEY", "TAG", "consultReviewModel", "Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "getConsultReviewModel", "()Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;", "setConsultReviewModel", "(Lid/dana/nearbyme/merchantreview/model/MerchantConsultReviewModel;)V", "buildDialog", "Lid/dana/nearbyme/merchantreview/MerchantReviewDialogFragment;", "modelConsult", "fullExpand", "", "onDismiss", "Lkotlin/Function1;", "Lid/dana/nearbyme/merchantreview/model/MerchantReviewDialogDismissState;", "", "previousMerchantReview", "Lid/dana/nearbyme/merchantdetail/model/MerchantReviewModel;", "onSubmitListener", "Lkotlin/Function2;", ContainerUIProvider.KEY_SHOW, "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "consultReviewData", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static void MyBillsEntityDataFactory(FragmentManager fragmentManager, MerchantConsultReviewModel merchantConsultReviewModel, boolean z, MerchantReviewModel merchantReviewModel, Function1<? super MerchantReviewDialogDismissState, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragmentManager, "");
            Intrinsics.checkNotNullParameter(merchantConsultReviewModel, "");
            Intrinsics.checkNotNullParameter(function1, "");
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
            if (fragmentManager.findFragmentByTag("MerchantReviewDialog") != null) {
                return;
            }
            getAuthRequestContext(merchantConsultReviewModel, z, function1, merchantReviewModel, null).show(beginTransaction, "MerchantReviewDialog");
            MerchantReviewDialogFragment.PlaceComponentResult = merchantConsultReviewModel;
        }

        @JvmStatic
        public static void PlaceComponentResult(FragmentManager fragmentManager, MerchantConsultReviewModel merchantConsultReviewModel, MerchantReviewModel merchantReviewModel, Function2<? super String, ? super String, Unit> function2, Function1<? super MerchantReviewDialogDismissState, Unit> function1) {
            Intrinsics.checkNotNullParameter(fragmentManager, "");
            Intrinsics.checkNotNullParameter(merchantConsultReviewModel, "");
            Intrinsics.checkNotNullParameter(function1, "");
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "");
            if (fragmentManager.findFragmentByTag("MerchantReviewDialog") != null) {
                return;
            }
            getAuthRequestContext(merchantConsultReviewModel, true, function1, merchantReviewModel, function2).show(beginTransaction, "MerchantReviewDialog");
            MerchantReviewDialogFragment.PlaceComponentResult = merchantConsultReviewModel;
        }

        private static MerchantReviewDialogFragment getAuthRequestContext(MerchantConsultReviewModel merchantConsultReviewModel, boolean z, Function1<? super MerchantReviewDialogDismissState, Unit> function1, MerchantReviewModel merchantReviewModel, Function2<? super String, ? super String, Unit> function2) {
            MerchantReviewDialogFragment merchantReviewDialogFragment = new MerchantReviewDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("MERCHANT_REVIEW_DATA_KEY", merchantConsultReviewModel);
            bundle.putParcelable("PREVIOUS_MERCHANT_REVIEW_DATA_KEY", merchantReviewModel);
            bundle.putInt("MERCHANT_REVIEW_STAR_COUNT_KEY", merchantConsultReviewModel.KClassImpl$Data$declaredNonStaticMembers$2);
            bundle.putBoolean("MERCHANT_REVIEW_FULL_EXPAND", z);
            merchantReviewDialogFragment.setArguments(bundle);
            Intrinsics.checkNotNullParameter(function1, "");
            merchantReviewDialogFragment.moveToNextValue = function1;
            merchantReviewDialogFragment.initRecordTimeStamp = function2;
            return merchantReviewDialogFragment;
        }
    }

    public static /* synthetic */ void getAuthRequestContext(MerchantReviewDialogFragment merchantReviewDialogFragment, ActivityResult activityResult) {
        MerchantReviewPhotosView merchantReviewPhotosView;
        Intrinsics.checkNotNullParameter(merchantReviewDialogFragment, "");
        if (activityResult.BuiltInFictitiousFunctionClassFactory != -1 || (merchantReviewPhotosView = (MerchantReviewPhotosView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.view_photo)) == null) {
            return;
        }
        merchantReviewPhotosView.activityForResult(activityResult.MyBillsEntityDataFactory);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewParent parent = view.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        ViewGroup.LayoutParams layoutParams = ((View) parent).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).lookAheadTest;
        if (behavior == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetBehavior<@[FlexibleNullability] android.view.View?>");
        }
        ((BottomSheetBehavior) behavior).setPeekHeight(view.getMeasuredHeight());
    }

    public static /* synthetic */ void PlaceComponentResult(MerchantReviewDialogFragment merchantReviewDialogFragment) {
        Intrinsics.checkNotNullParameter(merchantReviewDialogFragment, "");
        NestedScrollView nestedScrollView = (NestedScrollView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_merchant_review);
        if (nestedScrollView != null) {
            nestedScrollView.scrollTo(0, ((MerchantReviewMainView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.positiveButtonClicked)).getBottom());
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(MerchantReviewDialogFragment merchantReviewDialogFragment, NestedScrollView nestedScrollView) {
        Intrinsics.checkNotNullParameter(merchantReviewDialogFragment, "");
        Intrinsics.checkNotNullParameter(nestedScrollView, "");
        int bottom = ((NestedScrollView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_merchant_review)).getChildAt(((NestedScrollView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_merchant_review)).getChildCount() - 1).getBottom();
        int height = ((NestedScrollView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_merchant_review)).getHeight();
        int scrollY = ((NestedScrollView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.nsv_merchant_review)).getScrollY();
        View KClassImpl$Data$declaredNonStaticMembers$22 = merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.calculateCollapsedTextBounds);
        if (KClassImpl$Data$declaredNonStaticMembers$22 != null) {
            KClassImpl$Data$declaredNonStaticMembers$22.setVisibility(bottom - (height + scrollY) == 0 ? 0 : 8);
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MerchantReviewDialogFragment merchantReviewDialogFragment) {
        Intrinsics.checkNotNullParameter(merchantReviewDialogFragment, "");
        Bundle arguments = merchantReviewDialogFragment.getArguments();
        if (arguments != null) {
            Boolean valueOf = Boolean.valueOf(arguments.getBoolean("MERCHANT_REVIEW_FULL_EXPAND"));
            if (!valueOf.booleanValue()) {
                valueOf = null;
            }
            if (valueOf != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.VerifyPushDerollRequest_res_0x7f0a04a9);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(0);
                }
                ShareToFeedsView shareToFeedsView = (ShareToFeedsView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.share_to_feed_view);
                if (shareToFeedsView != null) {
                    shareToFeedsView.setVisibility(0);
                }
                AppCompatButton appCompatButton = (AppCompatButton) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.getDefaultSenderId_res_0x7f0a0238);
                if (appCompatButton != null) {
                    appCompatButton.setVisibility(0);
                }
                BottomSheetBehavior.from((FrameLayout) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator)).setState(3);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:179:0x0067, code lost:
    
        if (r4 != null) goto L185;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void PlaceComponentResult(id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment r17, androidx.appcompat.widget.AppCompatButton r18) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment.PlaceComponentResult(id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment, androidx.appcompat.widget.AppCompatButton):void");
    }

    public static /* synthetic */ void getAuthRequestContext(MerchantReviewDialogFragment merchantReviewDialogFragment) {
        Intrinsics.checkNotNullParameter(merchantReviewDialogFragment, "");
        MerchantReviewFormContract.Presenter presenter = merchantReviewDialogFragment.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.PlaceComponentResult();
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MerchantReviewDialogFragment merchantReviewDialogFragment, int i) {
        merchantReviewDialogFragment.MyBillsEntityDataFactory(merchantReviewDialogFragment.getErrorConfigVersion, i);
        merchantReviewDialogFragment.getErrorConfigVersion = null;
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(MerchantReviewDialogFragment merchantReviewDialogFragment) {
        Dialog dialog = merchantReviewDialogFragment.getDialog();
        View findViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
        ViewGroup.LayoutParams layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        final View getAuthRequestContext = merchantReviewDialogFragment.getGetAuthRequestContext();
        if (getAuthRequestContext != null) {
            getAuthRequestContext.post(new Runnable() { // from class: id.dana.nearbyme.merchantreview.MerchantReviewDialogFragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    MerchantReviewDialogFragment.BuiltInFictitiousFunctionClassFactory(getAuthRequestContext);
                }
            });
        }
    }

    public static final /* synthetic */ void PlaceComponentResult(MerchantReviewDialogFragment merchantReviewDialogFragment, String str) {
        Context context = merchantReviewDialogFragment.getContext();
        if (context != null) {
            GlideApp.getAuthRequestContext(context).PlaceComponentResult(str).getErrorConfigVersion((int) R.drawable.bg_merchant_review_banner).PlaceComponentResult((int) R.drawable.bg_merchant_review_banner).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) merchantReviewDialogFragment.KClassImpl$Data$declaredNonStaticMembers$2(R.id.CashierDailyLimitVerifyFragment)));
        }
    }

    public final void MyBillsEntityDataFactory(MerchantReviewModel merchantReviewModel, int i) {
        int i2;
        List<Tag> list;
        MerchantReviewViewState merchantReviewViewState;
        AppCompatEditText appCompatEditText;
        String str;
        List<Tag> list2;
        MerchantReviewViewState merchantReviewViewState2;
        AppCompatEditText appCompatEditText2;
        String str2;
        List<Tag> list3;
        MerchantReviewViewState merchantReviewViewState3;
        String str3;
        List<Tag> list4;
        MerchantReviewViewState merchantReviewViewState4;
        String str4;
        if (merchantReviewModel == null) {
            i2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        } else {
            i2 = merchantReviewModel.initRecordTimeStamp;
        }
        String str5 = null;
        if (KClassImpl$Data$declaredNonStaticMembers$2(i2, i)) {
            if (i == 4 || i == 5) {
                MerchantReviewViewState merchantReviewViewState5 = this.lookAheadTest;
                if (merchantReviewViewState5 != null) {
                    if (merchantReviewModel == null || (str3 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
                        MerchantReviewViewState merchantReviewViewState6 = this.lookAheadTest;
                        if (merchantReviewViewState6 != null) {
                            str5 = merchantReviewViewState6.moveToNextValue;
                        }
                    } else {
                        str5 = str3;
                    }
                    merchantReviewViewState5.MyBillsEntityDataFactory = str5;
                }
                if (merchantReviewModel == null || (list3 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda2) == null || (merchantReviewViewState3 = this.lookAheadTest) == null) {
                    return;
                }
                merchantReviewViewState3.KClassImpl$Data$declaredNonStaticMembers$2(list3, true);
                return;
            }
            MerchantReviewViewState merchantReviewViewState7 = this.lookAheadTest;
            if (merchantReviewViewState7 != null) {
                if (merchantReviewModel == null || (str4 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
                    MerchantReviewViewState merchantReviewViewState8 = this.lookAheadTest;
                    if (merchantReviewViewState8 != null) {
                        str5 = merchantReviewViewState8.moveToNextValue;
                    }
                } else {
                    str5 = str4;
                }
                merchantReviewViewState7.BuiltInFictitiousFunctionClassFactory = str5;
            }
            if (merchantReviewModel == null || (list4 = merchantReviewModel.lookAheadTest) == null || (merchantReviewViewState4 = this.lookAheadTest) == null) {
                return;
            }
            merchantReviewViewState4.KClassImpl$Data$declaredNonStaticMembers$2(list4, false);
        } else if (i == 4 || i == 5) {
            MerchantReviewViewState merchantReviewViewState9 = this.lookAheadTest;
            if (merchantReviewViewState9 != null) {
                if (merchantReviewModel == null || (str = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
                    MerchantReviewViewState merchantReviewViewState10 = this.lookAheadTest;
                    if (merchantReviewViewState10 != null) {
                        str5 = merchantReviewViewState10.moveToNextValue;
                    }
                } else {
                    str5 = str;
                }
                merchantReviewViewState9.BuiltInFictitiousFunctionClassFactory = str5;
            }
            MerchantReviewMainView merchantReviewMainView = (MerchantReviewMainView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.positiveButtonClicked);
            if (merchantReviewMainView != null && (appCompatEditText = (AppCompatEditText) merchantReviewMainView._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3)) != null) {
                appCompatEditText.setText("");
            }
            if (merchantReviewModel == null || (list = merchantReviewModel.lookAheadTest) == null || (merchantReviewViewState = this.lookAheadTest) == null) {
                return;
            }
            merchantReviewViewState.KClassImpl$Data$declaredNonStaticMembers$2(list, false);
        } else {
            MerchantReviewViewState merchantReviewViewState11 = this.lookAheadTest;
            if (merchantReviewViewState11 != null) {
                if (merchantReviewModel == null || (str2 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda1) == null) {
                    MerchantReviewViewState merchantReviewViewState12 = this.lookAheadTest;
                    if (merchantReviewViewState12 != null) {
                        str5 = merchantReviewViewState12.moveToNextValue;
                    }
                } else {
                    str5 = str2;
                }
                merchantReviewViewState11.MyBillsEntityDataFactory = str5;
            }
            MerchantReviewMainView merchantReviewMainView2 = (MerchantReviewMainView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.positiveButtonClicked);
            if (merchantReviewMainView2 != null && (appCompatEditText2 = (AppCompatEditText) merchantReviewMainView2._$_findCachedViewById(R.id.res_0x7f0a069f_spansuppressionstrategy_3)) != null) {
                appCompatEditText2.setText("");
            }
            if (merchantReviewModel == null || (list2 = merchantReviewModel.NetworkUserEntityData$$ExternalSyntheticLambda2) == null || (merchantReviewViewState2 = this.lookAheadTest) == null) {
                return;
            }
            merchantReviewViewState2.KClassImpl$Data$declaredNonStaticMembers$2(list2, true);
        }
    }

    private final CreateReviewWorker.Param BuiltInFictitiousFunctionClassFactory(MerchantReviewViewState merchantReviewViewState, String str) {
        AppCompatCheckBox appCompatCheckBox;
        Object obj = merchantReviewViewState.lookAheadTest.BuiltInFictitiousFunctionClassFactory;
        if (obj == LiveData.MyBillsEntityDataFactory) {
            obj = null;
        }
        int i = (Integer) obj;
        if (i == null) {
            i = 0;
        }
        int intValue = i.intValue();
        String str2 = merchantReviewViewState.moveToNextValue;
        List<String> KClassImpl$Data$declaredNonStaticMembers$22 = 4 <= intValue && intValue < 6 ? merchantReviewViewState.KClassImpl$Data$declaredNonStaticMembers$2() : CollectionsKt.emptyList();
        List<String> PlaceComponentResult2 = intValue > 0 && intValue < 4 ? merchantReviewViewState.PlaceComponentResult() : CollectionsKt.emptyList();
        String str3 = merchantReviewViewState.PlaceComponentResult.MyBillsEntityDataFactory.BottomSheetCardBindingView$watcherCardNumberView$1;
        if (str3 == null) {
            str3 = "";
        }
        String str4 = str3;
        ShareToFeedsView shareToFeedsView = (ShareToFeedsView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.share_to_feed_view);
        return new CreateReviewWorker.Param(str2, intValue, KClassImpl$Data$declaredNonStaticMembers$22, PlaceComponentResult2, str4, ((shareToFeedsView == null || (appCompatCheckBox = (AppCompatCheckBox) shareToFeedsView._$_findCachedViewById(R.id.ConcurrentKt)) == null) ? false : appCompatCheckBox.isChecked()) && this.NetworkUserEntityData$$ExternalSyntheticLambda2, this.scheduleImpl, merchantReviewViewState.NetworkUserEntityData$$ExternalSyntheticLambda0, str);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        MerchantReviewFormContract.Presenter presenter = this.presenter;
        MerchantReviewFormContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.MyBillsEntityDataFactory();
        MerchantReviewViewState merchantReviewViewState = this.lookAheadTest;
        if (merchantReviewViewState != null) {
            String str = merchantReviewViewState.PlaceComponentResult.MyBillsEntityDataFactory.BottomSheetCardBindingView$watcherCardNumberView$1;
            if (str == null) {
                str = "";
            }
            if (str != null) {
                MerchantReviewFormContract.Presenter presenter3 = this.presenter;
                if (presenter3 != null) {
                    presenter2 = presenter3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                presenter2.KClassImpl$Data$declaredNonStaticMembers$2(str);
            }
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.MyBillsEntityDataFactory.clear();
    }
}
