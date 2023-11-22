package id.dana.myprofile;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import butterknife.BindView;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.anggrayudi.storage.permission.FragmentPermissionRequest;
import com.anggrayudi.storage.permission.PermissionCallback;
import com.anggrayudi.storage.permission.PermissionRequest;
import com.anggrayudi.storage.permission.PermissionResult;
import com.ethanhua.skeleton.SkeletonScreen;
import com.google.common.base.Ascii;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseWithToolbarFragment;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.contract.deeplink.generation.GenerateDeepLinkContract;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.deeplink.path.FeatureSaving;
import id.dana.contract.payasset.QueryPayMethodContract;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.staticqr.GetStaticQrContract;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.user.GetBalanceContract;
import id.dana.contract.user.GetBalanceModule;
import id.dana.core.ui.glide.GlideApp;
import id.dana.danah5.DanaH5;
import id.dana.danah5.DanaH5Key;
import id.dana.data.constant.DanaUrl;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.data.profilemenu.MyProfileMenuAction;
import id.dana.data.profilemenu.MyProfileMenuCategories;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerMyProfileComponent;
import id.dana.di.component.MyProfileComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.InvestmentModule;
import id.dana.di.modules.MyProfileModule;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.UserStatementModule;
import id.dana.dialog.LoadingDialog;
import id.dana.domain.familyaccount.model.ConsultFamilyAccountResult;
import id.dana.domain.homeinfo.ThirdPartyServiceResponse;
import id.dana.domain.model.KycStatus;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.profilemenu.model.UserConfigProfileNewFlag;
import id.dana.domain.statement.StatementType;
import id.dana.domain.user.DanaHomeBalanceConfigModel;
import id.dana.familyaccount.util.FamilyStatusActionUtil;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.model.UserInvestmentModel;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.mapper.ProfileServicesUrlMapper;
import id.dana.merchantmanagement.view.MerchantManagementActivity;
import id.dana.model.CurrencyAmountModel;
import id.dana.mybills.MyBillsActivity;
import id.dana.myprofile.MyProfileContract;
import id.dana.myprofile.adapter.MyProfileDiffutilAdapter;
import id.dana.myprofile.mapper.SavingSummarySettingMapper;
import id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener;
import id.dana.myprofile.model.QrisTciCoConfigModel;
import id.dana.onboarding.OnboardingParams;
import id.dana.pay.PayCardInfo;
import id.dana.pay.model.PayCardConfigModel;
import id.dana.productpage.ProductPageManagerExtKt;
import id.dana.promocode.views.RedeemPromoCodeActivity;
import id.dana.promoquest.activity.MissionListActivity;
import id.dana.referral.referraltracker.model.ReferralTrackerModel;
import id.dana.richview.SimpleProfileWithQrView;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.contract.SavingViewListener;
import id.dana.savings.model.SavingSummaryModel;
import id.dana.showcase.AbstractOnShowcaseStateListener;
import id.dana.showcase.Content;
import id.dana.showcase.Showcase;
import id.dana.showcase.SimpleShowcaseBuilder;
import id.dana.showcase.shape.RectangleShape;
import id.dana.showcase.target.Target;
import id.dana.showcase.target.TargetBuilder;
import id.dana.social.view.activity.ChangeUsernameActivity;
import id.dana.statement.TimeUnitInterval;
import id.dana.statement.UserStatementContract;
import id.dana.statement.UserStatementListener;
import id.dana.statement.model.StatementSummaryInit;
import id.dana.tracker.EventTracker;
import id.dana.tracker.EventTrackerModel;
import id.dana.tracker.mixpanel.TopupSource;
import id.dana.usereducation.BottomSheetOnBoardingContract;
import id.dana.utils.BalanceUtil;
import id.dana.utils.CustomLinearLayoutManager;
import id.dana.utils.ErrorUtil;
import id.dana.utils.FileUtil;
import id.dana.utils.PhoneCall;
import id.dana.utils.SizeUtil;
import id.dana.utils.StringWrapper;
import id.dana.utils.TagFormat;
import id.dana.utils.UrlUtil;
import id.dana.utils.danah5.DanaH5Listener;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import id.dana.utils.handpick.HandPicked;
import id.dana.utils.handpick.HandPickedResultHandler;
import id.dana.utils.permission.PermissionHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;
import o.getOnBoardingScenario;

/* loaded from: classes5.dex */
public class MyProfileFragment extends BaseWithToolbarFragment implements MyProfileContract.View {
    private static int $10 = 0;
    private static int $11 = 1;
    public static final int KClassImpl$Data$declaredNonStaticMembers$2;
    public static final byte[] MyBillsEntityDataFactory;
    private static final int NetworkUserEntityData$$ExternalSyntheticLambda0;
    private static final int PlaceComponentResult;
    private static int[] SubSequence;
    private static int getCallingPid;
    private static long readMicros;
    private LoadingDialog DatabaseTableConfigUtil;
    private HomeTabActivity.SwitchFragment FragmentBottomSheetPaymentSettingBinding;
    private boolean GetContactSyncConfig;
    private Handler NetworkUserEntityData$$ExternalSyntheticLambda1;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda2;
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda3;
    private Showcase NetworkUserEntityData$$ExternalSyntheticLambda4;
    private FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda5;
    private boolean NetworkUserEntityData$$ExternalSyntheticLambda6;
    private FragmentPermissionRequest NetworkUserEntityData$$ExternalSyntheticLambda7;
    private MyProfileDiffutilAdapter NetworkUserEntityData$$ExternalSyntheticLambda8;
    private String PrepareContext;
    @Inject
    BottomSheetOnBoardingContract.Presenter bottomSheetOnBoardingPresenter;
    @BindView(R.id.btn_verify)
    Button buttonVerify;
    @Inject
    DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    GetBalanceContract.Presenter getBalancePresenter;
    private List<SettingModel> getErrorConfigVersion;
    @Inject
    GetStaticQrContract.Presenter getStaticQrPresenter;
    @Inject
    UserStatementContract.Presenter getUserStatementPresenter;
    private final HandPicked initRecordTimeStamp;
    @Inject
    InvestmentContract.Presenter investmentPresenter;
    private boolean isLayoutRequested;
    private FragmentPermissionRequest lookAheadTest;
    private MyProfileComponent moveToNextValue;
    @Inject
    MyProfileContract.Presenter myProfilePresenter;
    private boolean newProxyInstance;
    @BindView(R.id.nsv_profile)
    NestedScrollView nsvProfile;
    @Inject
    ProductPageManager productPageManager;
    @Inject
    GenerateDeepLinkContract.ProfilePresenter profileQrDeepLinkPresenter;
    @BindView(R.id.profile)
    SimpleProfileWithQrView profileView;
    @Inject
    QueryPayMethodContract.Presenter queryPayPresenter;
    @BindView(R.id.rv_profile_setting)
    RecyclerView rvProfileSetting;
    @Inject
    SavingContract.Presenter savingPresenter;
    private ConsultFamilyAccountResult scheduleImpl;
    public static final byte[] $$d = {116, 15, TarHeader.LF_BLK, -20, -3, -64, -15, -1, 60, -54, -14, 0, 4, -2, -4, -2, TarHeader.LF_NORMAL, -54, -20, 6, -16, 14, -16, 65, -63, -12, 15, -18, 4, 56, -65, -6, 5, -3, -5, -8, 4, TarHeader.LF_FIFO, -39, -7, 3, -24, -16, 9, Ascii.ETB, -38, 5, Ascii.CAN, -32, 0, -2, Ascii.US, -57, 19, -12, 4, Ascii.GS, -54, 1, 12, -12, -8, 7, -9, -2, 71, -17, -15, -1, 60, -54, -14, 0, -10, 12, -27, 72, -66, -5, 10, -10, -6, 4, TarHeader.LF_BLK, -72, 11, -1, -21, 0, 6, -14, -8, 72, -55, -10, -9, 62, -72, 11, -16, -7, 10, 3, -5, TarHeader.LF_BLK, -23, -42, -9, Ascii.EM, -36, 2, -6, 10, 18, -20, -20, 14, -15, 5, -18, 12, -16};
    public static final int $$e = 125;
    public static final byte[] $$a = {Ascii.ETB, -59, 18, 83, -58, 5, -10, -15, 36, -44, 33, -42, -1, -24, 4, -18, 4, -13, -13, -5, 38, -54, 0, 4, -24, 4, -13, -6, 36, -48, 4, -25, -7, 38, -34, -9, -24, -2, -10, -14, -51, TarHeader.LF_NORMAL, -46, -10, -7, -14, 39, -48, -13, 4, -18, -12, 46, -36, -26, 12, Ascii.DC4, -34, -9, -24, -2, -10, -14, -5, -22, 44, -59, -6, 5, 15, -26, -19, -11, 9, -21, -8, 42, -51, -6, -13, 8, -26, -3, -35, 4, -9, -9, Ascii.ESC, -51, -5, -10, -6, -6, 2, -16, -13, Ascii.ESC, -26, -21, -9, 2, -15, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$b = 153;
    private static int getSupportButtonTintMode = 1;

    static void GetContactSyncConfig() {
        try {
            int i = getCallingPid + 43;
            getSupportButtonTintMode = i % 128;
            char c = i % 2 == 0 ? 'X' : '*';
            Object[] objArr = null;
            readMicros = 932287543769905663L;
            if (c != '*') {
                int length = objArr.length;
            }
            int i2 = getSupportButtonTintMode + 113;
            getCallingPid = i2 % 128;
            if (!(i2 % 2 == 0)) {
                objArr.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment) {
        int i = getCallingPid + 3;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        myProfileFragment.M();
        int i3 = getCallingPid + 125;
        getSupportButtonTintMode = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    static void NetworkUserEntityData$$ExternalSyntheticLambda2() {
        SubSequence = new int[]{1295783016, -680615621, -1938204217, -1447014582, -1204744541, -1397449550, -1493008274, 2076021733, 395710860, 299644265, 146178, 2096484931, 1023276184, 403608121, -392394941, 237553289, -534027967, 2009645976};
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0024 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void c(int r7, int r8, int r9, java.lang.Object[] r10) {
        /*
            byte[] r0 = id.dana.myprofile.MyProfileFragment.$$a
            int r9 = r9 + 4
            int r8 = r8 + 66
            int r7 = r7 + 20
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L16
            r8 = r7
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r10
            r10 = r9
            goto L32
        L16:
            r3 = 0
        L17:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L24
            java.lang.String r7 = new java.lang.String
            r7.<init>(r1, r2)
            r10[r2] = r7
            return
        L24:
            int r3 = r3 + 1
            r4 = r0[r9]
            r5 = r8
            r8 = r7
            r7 = r5
            r6 = r10
            r10 = r9
            r9 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r6
        L32:
            int r9 = -r9
            int r7 = r7 + r9
            int r7 = r7 + (-7)
            int r9 = r10 + 1
            r10 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            r5 = r8
            r8 = r7
            r7 = r5
            goto L17
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.c(int, int, int, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x003b -> B:25:0x003f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void d(byte r8, int r9, byte r10, java.lang.Object[] r11) {
        /*
            byte[] r0 = id.dana.myprofile.MyProfileFragment.MyBillsEntityDataFactory
            int r9 = r9 * 15
            int r9 = 19 - r9
            int r8 = r8 * 4
            int r8 = r8 + 16
            int r10 = r10 + 105
            byte[] r1 = new byte[r8]
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L14
            r4 = 0
            goto L15
        L14:
            r4 = 1
        L15:
            if (r4 == 0) goto L20
            r4 = r1
            r5 = 0
            r1 = r0
            r0 = r11
            r7 = r9
            r9 = r8
            r8 = r10
            r10 = r7
            goto L3f
        L20:
            int r10 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r10 = r10 + 9
            int r4 = r10 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r4
            int r10 = r10 % 2
            int r10 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r10 = r10 + 77
            int r4 = r10 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r4
            int r10 = r10 % 2
            r10 = r9
            r4 = r1
            r5 = 0
            r9 = r8
            r1 = r0
            r0 = r11
            r11 = r10
        L3b:
            int r10 = r10 + r2
            int r8 = r8 + r11
            int r8 = r8 + 2
        L3f:
            byte r11 = (byte) r8
            int r6 = r5 + 1
            r4[r5] = r11
            if (r6 != r9) goto L4e
            java.lang.String r8 = new java.lang.String
            r8.<init>(r4, r3)
            r0[r3] = r8
            return
        L4e:
            r11 = r1[r10]
            r5 = r6
            goto L3b
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.d(byte, int, byte, java.lang.Object[]):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0027 -> B:23:0x0032). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(short r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 + 3
            int r7 = r7 * 63
            int r7 = 99 - r7
            byte[] r0 = id.dana.myprofile.MyProfileFragment.$$d
            int r6 = r6 + 4
            byte[] r1 = new byte[r8]
            int r8 = r8 + (-1)
            r2 = 0
            if (r0 != 0) goto L17
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L32
        L17:
            r3 = 0
        L18:
            int r6 = r6 + 1
            byte r4 = (byte) r7
            r1[r3] = r4
            if (r3 != r8) goto L27
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L27:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r8
            r8 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L32:
            int r8 = -r8
            int r7 = r7 + r8
            int r7 = r7 + (-3)
            r8 = r9
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L18
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.e(short, byte, byte, java.lang.Object[]):void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        try {
            int i = getCallingPid + 103;
            try {
                getSupportButtonTintMode = i % 128;
                int i2 = i % 2;
                MyProfileContract.View.CC.PlaceComponentResult();
                int i3 = getSupportButtonTintMode + 57;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ThirdPartyServiceResponse thirdPartyServiceResponse) {
        int i = getSupportButtonTintMode + 19;
        getCallingPid = i % 128;
        char c = i % 2 != 0 ? (char) 23 : (char) 19;
        MyProfileContract.View.CC.PlaceComponentResult(thirdPartyServiceResponse);
        if (c != 23) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(boolean z) {
        int i = getSupportButtonTintMode + 67;
        getCallingPid = i % 128;
        int i2 = i % 2;
        MyProfileContract.View.CC.BuiltInFictitiousFunctionClassFactory();
        int i3 = getSupportButtonTintMode + 97;
        getCallingPid = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(long j) {
        int i = getSupportButtonTintMode + 51;
        getCallingPid = i % 128;
        if (i % 2 == 0) {
            try {
                MyProfileContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        MyProfileContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
        Object[] objArr = null;
        int length = objArr.length;
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void MyBillsEntityDataFactory(UserConfigProfileNewFlag userConfigProfileNewFlag) {
        int i = getSupportButtonTintMode + 47;
        getCallingPid = i % 128;
        int i2 = i % 2;
        try {
            MyProfileContract.View.CC.getAuthRequestContext(userConfigProfileNewFlag);
            int i3 = getCallingPid + 75;
            getSupportButtonTintMode = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void PlaceComponentResult() {
        try {
            int i = getSupportButtonTintMode + 79;
            try {
                getCallingPid = i % 128;
                int i2 = i % 2;
                MyProfileContract.View.CC.MyBillsEntityDataFactory();
                int i3 = getSupportButtonTintMode + 47;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void PlaceComponentResult(UserConfigProfileNewFlag userConfigProfileNewFlag) {
        try {
            int i = getSupportButtonTintMode + 35;
            try {
                getCallingPid = i % 128;
                int i2 = i % 2;
                MyProfileContract.View.CC.PlaceComponentResult(userConfigProfileNewFlag);
                int i3 = getCallingPid + 71;
                getSupportButtonTintMode = i3 % 128;
                if (i3 % 2 != 0) {
                    return;
                }
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View, id.dana.base.AbstractContract.AbstractView
    public void dismissProgress() {
        try {
            int i = getCallingPid + 17;
            getSupportButtonTintMode = i % 128;
            if ((i % 2 == 0 ? Typography.dollar : (char) 5) != '$') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void getAuthRequestContext(ReferralTrackerModel referralTrackerModel) {
        try {
            int i = getCallingPid + 17;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            MyProfileContract.View.CC.MyBillsEntityDataFactory(referralTrackerModel);
            try {
                int i3 = getCallingPid + 113;
                getSupportButtonTintMode = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final /* synthetic */ void getAuthRequestContext(StringWrapper stringWrapper) {
        int i = getCallingPid + 123;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            MyProfileContract.View.CC.PlaceComponentResult(stringWrapper);
            try {
                int i3 = getSupportButtonTintMode + 19;
                getCallingPid = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    int i4 = 45 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.base.BaseFragment
    public int getLayout() {
        int i = getSupportButtonTintMode + 1;
        getCallingPid = i % 128;
        if (!(i % 2 == 0)) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = getSupportButtonTintMode + 21;
        getCallingPid = i2 % 128;
        if (i2 % 2 == 0) {
            return R.layout.fragment_myprofile;
        }
        int i3 = 31 / 0;
        return R.layout.fragment_myprofile;
    }

    @Override // id.dana.myprofile.MyProfileContract.View, id.dana.base.AbstractContract.AbstractView
    public void showProgress() {
        int i = getCallingPid + 57;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
    }

    public MyProfileFragment() {
        HandPicked.Builder builder = new HandPicked.Builder(this);
        builder.KClassImpl$Data$declaredNonStaticMembers$2 = GriverEnv.getApplicationContext().getString(R.string.pick_profile_photo_title);
        builder.PlaceComponentResult = new HandPickedResultHandler() { // from class: id.dana.myprofile.MyProfileFragment.1
            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Exception exc) {
            }

            {
                MyProfileFragment.this = this;
            }

            @Override // id.dana.utils.handpick.HandPickedResultHandler
            public final void MyBillsEntityDataFactory(Uri uri, String str) {
                MyProfileFragment.this.myProfilePresenter.BuiltInFictitiousFunctionClassFactory(FileUtil.MyBillsEntityDataFactory(MyProfileFragment.this.getActivity().getApplicationContext(), uri.toString()));
            }
        };
        builder.getAuthRequestContext = PermissionHelper.MyBillsEntityDataFactory(GriverEnv.getApplicationContext(), "android.permission.CAMERA");
        builder.NetworkUserEntityData$$ExternalSyntheticLambda0 = PermissionHelper.getAuthRequestContext(GriverEnv.getApplicationContext());
        this.initRecordTimeStamp = new HandPicked(builder, (byte) 0);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = new Handler();
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(MyProfileFragment myProfileFragment) {
        int i = getCallingPid + 23;
        getSupportButtonTintMode = i % 128;
        if ((i % 2 == 0 ? '\\' : (char) 6) != '\\') {
            myProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
        } else {
            myProfileFragment.BottomSheetCardBindingView$watcherCardNumberView$1();
            int i2 = 99 / 0;
        }
        int i3 = getCallingPid + 49;
        getSupportButtonTintMode = i3 % 128;
        int i4 = i3 % 2;
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment, SettingModel settingModel, String str, String str2) {
        int i = getCallingPid + 87;
        getSupportButtonTintMode = i % 128;
        char c = i % 2 == 0 ? 'F' : (char) 25;
        myProfileFragment.getAuthRequestContext(settingModel, str, str2);
        if (c != 'F') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment myProfileFragment, UserInvestmentModel userInvestmentModel) {
        int i = getSupportButtonTintMode + 113;
        getCallingPid = i % 128;
        int i2 = i % 2;
        myProfileFragment.getAuthRequestContext(userInvestmentModel);
        int i3 = getSupportButtonTintMode + 105;
        getCallingPid = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    static /* synthetic */ String MyBillsEntityDataFactory(MyProfileFragment myProfileFragment, String str) {
        int i = getSupportButtonTintMode + 13;
        getCallingPid = i % 128;
        int i2 = i % 2;
        myProfileFragment.PrepareContext = str;
        try {
            int i3 = getCallingPid + 63;
            getSupportButtonTintMode = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 23 : '(') != 23) {
                return str;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(MyProfileFragment myProfileFragment) {
        int i = getCallingPid + 69;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        myProfileFragment.C();
        int i3 = getSupportButtonTintMode + 89;
        getCallingPid = i3 % 128;
        int i4 = i3 % 2;
    }

    static /* synthetic */ void MyBillsEntityDataFactory(MyProfileFragment myProfileFragment, int i) {
        int i2 = getSupportButtonTintMode + 109;
        getCallingPid = i2 % 128;
        int i3 = i2 % 2;
        myProfileFragment.BuiltInFictitiousFunctionClassFactory(i);
        int i4 = getCallingPid + 119;
        getSupportButtonTintMode = i4 % 128;
        if (i4 % 2 != 0) {
            return;
        }
        int i5 = 12 / 0;
    }

    static /* synthetic */ void MyBillsEntityDataFactory(MyProfileFragment myProfileFragment, SettingModel settingModel) {
        try {
            int i = getCallingPid + 19;
            getSupportButtonTintMode = i % 128;
            char c = i % 2 == 0 ? 'U' : '?';
            myProfileFragment.lookAheadTest(settingModel);
            if (c != 'U') {
                return;
            }
            int i2 = 29 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(MyProfileFragment myProfileFragment, SettingModel settingModel, String str, String str2) {
        int i = getSupportButtonTintMode + 27;
        getCallingPid = i % 128;
        if (i % 2 != 0) {
            myProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(settingModel, str, str2);
            int i2 = 16 / 0;
            return;
        }
        myProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(settingModel, str, str2);
    }

    static /* synthetic */ void MyBillsEntityDataFactory(MyProfileFragment myProfileFragment, SavingSummaryModel savingSummaryModel) {
        int i = getSupportButtonTintMode + 5;
        getCallingPid = i % 128;
        int i2 = i % 2;
        myProfileFragment.PlaceComponentResult(savingSummaryModel);
        int i3 = getSupportButtonTintMode + 23;
        getCallingPid = i3 % 128;
        if ((i3 % 2 != 0 ? 'D' : '4') != 'D') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    static /* synthetic */ void MyBillsEntityDataFactory(MyProfileFragment myProfileFragment, boolean z, String str, String str2) {
        int i = getSupportButtonTintMode + 109;
        getCallingPid = i % 128;
        if ((i % 2 != 0 ? '_' : (char) 18) != '_') {
            myProfileFragment.MyBillsEntityDataFactory(z, str, str2);
            return;
        }
        myProfileFragment.MyBillsEntityDataFactory(z, str, str2);
        Object obj = null;
        obj.hashCode();
    }

    static /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0(MyProfileFragment myProfileFragment) {
        int i = getCallingPid + 45;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        myProfileFragment.B();
        int i3 = getSupportButtonTintMode + 49;
        getCallingPid = i3 % 128;
        int i4 = i3 % 2;
    }

    static /* synthetic */ void PlaceComponentResult(MyProfileFragment myProfileFragment) {
        int i = getCallingPid + 119;
        getSupportButtonTintMode = i % 128;
        char c = i % 2 == 0 ? 'E' : 'Q';
        myProfileFragment.VerifyPinStateManager$executeRiskChallenge$2$1();
        if (c != 'Q') {
            int i2 = 98 / 0;
        }
        int i3 = getCallingPid + 43;
        getSupportButtonTintMode = i3 % 128;
        if (i3 % 2 != 0) {
            return;
        }
        int i4 = 61 / 0;
    }

    static /* synthetic */ void PlaceComponentResult(MyProfileFragment myProfileFragment, String str) {
        int i = getSupportButtonTintMode + 125;
        getCallingPid = i % 128;
        int i2 = i % 2;
        myProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda2(str);
        try {
            int i3 = getCallingPid + 51;
            getSupportButtonTintMode = i3 % 128;
            if (i3 % 2 != 0) {
                return;
            }
            int i4 = 38 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ boolean PlaceComponentResult(MyProfileFragment myProfileFragment, boolean z) {
        int i = getSupportButtonTintMode + 3;
        getCallingPid = i % 128;
        int i2 = i % 2;
        myProfileFragment.GetContactSyncConfig = z;
        int i3 = getCallingPid + 63;
        getSupportButtonTintMode = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    static /* synthetic */ MyProfileDiffutilAdapter getAuthRequestContext(MyProfileFragment myProfileFragment) {
        int i = getSupportButtonTintMode + 25;
        getCallingPid = i % 128;
        int i2 = i % 2;
        try {
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = myProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int i3 = getCallingPid + 7;
            getSupportButtonTintMode = i3 % 128;
            int i4 = i3 % 2;
            return myProfileDiffutilAdapter;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ SettingModel getErrorConfigVersion(MyProfileFragment myProfileFragment) {
        SettingModel valueOfTouchPositionAbsolute;
        try {
            int i = getSupportButtonTintMode + 113;
            getCallingPid = i % 128;
            Object[] objArr = null;
            if ((i % 2 != 0 ? 'F' : (char) 24) != 24) {
                valueOfTouchPositionAbsolute = myProfileFragment.getValueOfTouchPositionAbsolute();
                objArr.hashCode();
            } else {
                valueOfTouchPositionAbsolute = myProfileFragment.getValueOfTouchPositionAbsolute();
            }
            try {
                int i2 = getSupportButtonTintMode + 101;
                getCallingPid = i2 % 128;
                if ((i2 % 2 != 0 ? ',' : '2') != ',') {
                    return valueOfTouchPositionAbsolute;
                }
                int length = objArr.length;
                return valueOfTouchPositionAbsolute;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ boolean lookAheadTest(MyProfileFragment myProfileFragment) {
        try {
            int i = getSupportButtonTintMode + 105;
            try {
                getCallingPid = i % 128;
                if ((i % 2 != 0 ? (char) 1 : (char) 24) != 24) {
                    boolean z = myProfileFragment.GetContactSyncConfig;
                    Object obj = null;
                    obj.hashCode();
                    return z;
                }
                return myProfileFragment.GetContactSyncConfig;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ Showcase moveToNextValue(MyProfileFragment myProfileFragment) {
        int i = getSupportButtonTintMode + 37;
        getCallingPid = i % 128;
        boolean z = i % 2 == 0;
        Object[] objArr = null;
        myProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda4 = null;
        if (!z) {
            int length = objArr.length;
        }
        try {
            int i2 = getCallingPid + 111;
            getSupportButtonTintMode = i2 % 128;
            int i3 = i2 % 2;
            return null;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ boolean scheduleImpl(MyProfileFragment myProfileFragment) {
        try {
            int i = getCallingPid + 35;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            myProfileFragment.newProxyInstance = false;
            int i3 = getSupportButtonTintMode + 119;
            getCallingPid = i3 % 128;
            int i4 = i3 % 2;
            return false;
        } catch (Exception e) {
            throw e;
        }
    }

    static {
        getCallingPid = 0;
        NetworkUserEntityData$$ExternalSyntheticLambda2();
        MyBillsEntityDataFactory = new byte[]{116, -27, -60, 115, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
        KClassImpl$Data$declaredNonStaticMembers$2 = 44;
        GetContactSyncConfig();
        NetworkUserEntityData$$ExternalSyntheticLambda0 = SizeUtil.getAuthRequestContext(6);
        PlaceComponentResult = SizeUtil.getAuthRequestContext(0);
        int i = getSupportButtonTintMode + 21;
        getCallingPid = i % 128;
        if ((i % 2 != 0 ? 'T' : Typography.dollar) != '$') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public static MyProfileFragment scheduleImpl() {
        MyProfileFragment myProfileFragment = new MyProfileFragment();
        int i = getSupportButtonTintMode + 5;
        getCallingPid = i % 128;
        if (!(i % 2 != 0)) {
            return myProfileFragment;
        }
        int i2 = 29 / 0;
        return myProfileFragment;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        try {
            int i = getSupportButtonTintMode + 87;
            getCallingPid = i % 128;
            if (!(i % 2 == 0)) {
                super.onResume();
                B();
                getCallingPid();
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                super.onResume();
                B();
                getCallingPid();
            }
            int i2 = getSupportButtonTintMode + 101;
            getCallingPid = i2 % 128;
            if ((i2 % 2 != 0 ? '\b' : '%') != '%') {
                int i3 = 47 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseFragment
    public void onSelected() {
        int i = getCallingPid + 91;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        this.isLayoutRequested = true;
        if (this.myProfilePresenter != null) {
            int i3 = getSupportButtonTintMode + 35;
            getCallingPid = i3 % 128;
            int i4 = i3 % 2;
            if (!(this.NetworkUserEntityData$$ExternalSyntheticLambda8.KClassImpl$Data$declaredNonStaticMembers$2())) {
                C();
                BottomSheetCardBindingView$watcherCardNumberView$1();
            } else {
                int i5 = getSupportButtonTintMode + 33;
                getCallingPid = i5 % 128;
                int i6 = i5 % 2;
                MyProfileContract.Presenter presenter = this.myProfilePresenter;
                Object[] objArr = new Object[1];
                a(View.getDefaultSize(0, 0) + 21, new int[]{-444045425, -1393988590, -1609268492, -1399820681, 1526218432, -516002749, 2103075750, -1327776922, 41169565, 1124538387, 126526007, 2142924825}, objArr);
                presenter.getAuthRequestContext(((String) objArr[0]).intern());
            }
            this.myProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda0();
        }
        VerifyPinStateManager$executeRiskChallenge$2$1();
        GetStaticQrContract.Presenter presenter2 = this.getStaticQrPresenter;
        if (presenter2 != null) {
            int i7 = getCallingPid + 17;
            getSupportButtonTintMode = i7 % 128;
            int i8 = i7 % 2;
            presenter2.MyBillsEntityDataFactory();
        }
        E();
    }

    @Override // id.dana.base.BaseFragment
    public void onUnSelected() {
        try {
            MyProfileContract.Presenter presenter = this.myProfilePresenter;
            if ((presenter != null ? 'c' : '[') == 'c') {
                int i = getCallingPid + 65;
                getSupportButtonTintMode = i % 128;
                int i2 = i % 2;
                presenter.NetworkUserEntityData$$ExternalSyntheticLambda4();
            }
            QueryPayMethodContract.Presenter presenter2 = this.queryPayPresenter;
            if (!(presenter2 == null)) {
                presenter2.onDestroy();
                int i3 = getSupportButtonTintMode + 75;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda1.removeCallbacksAndMessages(null);
        } catch (Exception e) {
            throw e;
        }
    }

    private void BottomSheetCardBindingView$watcherCardNumberView$1() {
        SettingModel settingModel;
        int i = getCallingPid + 55;
        getSupportButtonTintMode = i % 128;
        if (i % 2 == 0) {
            int i2 = 54 / 0;
            if (this.investmentPresenter == null) {
                return;
            }
        } else if (this.investmentPresenter == null) {
            return;
        }
        int i3 = getSupportButtonTintMode + 85;
        getCallingPid = i3 % 128;
        int i4 = i3 % 2;
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (!(myProfileDiffutilAdapter == null)) {
            try {
                int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory("setting_investment");
                if ((myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyBillsEntityDataFactory2) ? 'X' : ',') != 'X') {
                    settingModel = SettingModel.empty();
                } else {
                    try {
                        settingModel = myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue.get(MyBillsEntityDataFactory2);
                    } catch (Exception e) {
                        throw e;
                    }
                }
                if (settingModel.isNullObject()) {
                    return;
                }
                this.investmentPresenter.getAuthRequestContext();
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private void C() {
        try {
            int i = getCallingPid + 109;
            getSupportButtonTintMode = i % 128;
            if (!(i % 2 == 0)) {
                B();
                whenAvailable();
                getOnBoardingScenario();
                return;
            }
            B();
            whenAvailable();
            getOnBoardingScenario();
            int i2 = 72 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda5() {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.removeCallbacksAndMessages(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.postDelayed(new Runnable() { // from class: id.dana.myprofile.MyProfileFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                MyProfileFragment.this.getErrorConfigVersion();
            }
        }, 500L);
        int i = getCallingPid + 61;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
    }

    public final /* synthetic */ void getErrorConfigVersion() {
        int i = getSupportButtonTintMode + 39;
        getCallingPid = i % 128;
        if ((i % 2 != 0 ? 'M' : 'R') != 'M') {
            this.myProfilePresenter.MyBillsEntityDataFactory();
            return;
        }
        this.myProfilePresenter.MyBillsEntityDataFactory();
        Object[] objArr = null;
        int length = objArr.length;
    }

    private void E() {
        try {
            int i = getSupportButtonTintMode + 93;
            try {
                getCallingPid = i % 128;
                int i2 = i % 2;
                SavingContract.Presenter presenter = this.savingPresenter;
                if ((presenter != null ? 'Q' : '(') != 'Q') {
                    return;
                }
                int i3 = getCallingPid + 33;
                getSupportButtonTintMode = i3 % 128;
                if (!(i3 % 2 == 0)) {
                    presenter.MyBillsEntityDataFactory();
                    return;
                }
                presenter.MyBillsEntityDataFactory();
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void B() {
        try {
            int i = getCallingPid + 71;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            MyProfileContract.Presenter presenter = this.myProfilePresenter;
            if ((presenter != null ? '%' : (char) 22) != 22) {
                presenter.NetworkUserEntityData$$ExternalSyntheticLambda1();
            }
            int i3 = getCallingPid + 21;
            getSupportButtonTintMode = i3 % 128;
            if ((i3 % 2 == 0 ? Typography.less : '+') != '+') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void getCallingPid() {
        try {
            MyProfileContract.Presenter presenter = this.myProfilePresenter;
            if ((presenter != null ? ']' : 'W') != 'W') {
                try {
                    int i = getCallingPid + 117;
                    getSupportButtonTintMode = i % 128;
                    int i2 = i % 2;
                    presenter.PlaceComponentResult();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i3 = getCallingPid + 35;
            getSupportButtonTintMode = i3 % 128;
            if ((i3 % 2 == 0 ? '.' : (char) 25) != '.') {
                return;
            }
            int i4 = 34 / 0;
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void A() {
        Object[] objArr = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.removeCallbacksAndMessages(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda1.postDelayed(new Runnable() { // from class: id.dana.myprofile.MyProfileFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MyProfileFragment.this.NetworkUserEntityData$$ExternalSyntheticLambda0();
            }
        }, 1000L);
        int i = getSupportButtonTintMode + 103;
        getCallingPid = i % 128;
        if (i % 2 != 0) {
            int length = objArr.length;
        }
    }

    public final /* synthetic */ void NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int i = getSupportButtonTintMode + 65;
        getCallingPid = i % 128;
        int i2 = i % 2;
        MyProfileContract.Presenter presenter = this.myProfilePresenter;
        if (!(presenter == null)) {
            int i3 = getSupportButtonTintMode + 9;
            getCallingPid = i3 % 128;
            int i4 = i3 % 2;
            presenter.isLayoutRequested();
        }
    }

    private void whenAvailable() {
        int i = getSupportButtonTintMode + 79;
        getCallingPid = i % 128;
        int i2 = i % 2;
        GetBalanceContract.Presenter presenter = this.getBalancePresenter;
        if ((presenter != null ? (char) 20 : '8') != '8') {
            try {
                int i3 = getSupportButtonTintMode + 11;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
                presenter.PlaceComponentResult(Boolean.TRUE);
                int i5 = getCallingPid + 125;
                getSupportButtonTintMode = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void VerifyPinStateManager$executeRiskChallenge$2$1() {
        QueryPayMethodContract.Presenter presenter = this.queryPayPresenter;
        if ((presenter != null ? 'F' : InputCardNumberView.DIVIDER) != ' ') {
            int i = getSupportButtonTintMode + 29;
            getCallingPid = i % 128;
            int i2 = i % 2;
            presenter.MyBillsEntityDataFactory();
            int i3 = getCallingPid + 89;
            getSupportButtonTintMode = i3 % 128;
            int i4 = i3 % 2;
        }
    }

    private void getOnBoardingScenario() {
        int i = getSupportButtonTintMode + 51;
        getCallingPid = i % 128;
        int i2 = i % 2;
        if (this.getUserStatementPresenter != null) {
            SubSequence();
            try {
                int i3 = getSupportButtonTintMode + 39;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
    }

    private void SubSequence() {
        try {
            try {
                this.getUserStatementPresenter.PlaceComponentResult(new StatementSummaryInit(Calendar.getInstance().getTimeInMillis(), TimeUnitInterval.MONTH, StatementType.ALL));
                int i = getCallingPid + 15;
                getSupportButtonTintMode = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void H() {
        RecyclerView.ItemAnimator itemAnimator = this.rvProfileSetting.getItemAnimator();
        if ((itemAnimator instanceof SimpleItemAnimator ? (char) 14 : '4') == 14) {
            int i = getSupportButtonTintMode + 67;
            getCallingPid = i % 128;
            if ((i % 2 != 0 ? 'I' : '^') != '^') {
                ((SimpleItemAnimator) itemAnimator).NetworkUserEntityData$$ExternalSyntheticLambda1 = true;
            } else {
                ((SimpleItemAnimator) itemAnimator).NetworkUserEntityData$$ExternalSyntheticLambda1 = false;
            }
            int i2 = getCallingPid + 103;
            getSupportButtonTintMode = i2 % 128;
            int i3 = i2 % 2;
        }
        try {
            this.rvProfileSetting.setLayoutManager(new CustomLinearLayoutManager(getContext()));
            this.rvProfileSetting.setNestedScrollingEnabled(false);
            this.rvProfileSetting.setAdapter(this.NetworkUserEntityData$$ExternalSyntheticLambda8);
        } catch (Exception e) {
            throw e;
        }
    }

    private void F() {
        this.nsvProfile.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: id.dana.myprofile.MyProfileFragment$$ExternalSyntheticLambda5
            @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
            public final void getAuthRequestContext(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                MyProfileFragment.this.getAuthRequestContext(i2);
            }
        });
        int i = getSupportButtonTintMode + 87;
        getCallingPid = i % 128;
        int i2 = i % 2;
    }

    public final /* synthetic */ void getAuthRequestContext(int i) {
        try {
            int i2 = getSupportButtonTintMode + 19;
            getCallingPid = i2 % 128;
            int i3 = i2 % 2;
            this.NetworkUserEntityData$$ExternalSyntheticLambda6 = true;
            Object[] objArr = null;
            if (i == 0) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda6 = false;
                if (this.newProxyInstance) {
                    int i4 = getCallingPid + 17;
                    getSupportButtonTintMode = i4 % 128;
                    if (i4 % 2 == 0) {
                        BuiltInFictitiousFunctionClassFactory(readMicros());
                        int length = objArr.length;
                    } else {
                        BuiltInFictitiousFunctionClassFactory(readMicros());
                    }
                }
            }
            int i5 = getSupportButtonTintMode + 47;
            getCallingPid = i5 % 128;
            if (!(i5 % 2 != 0)) {
                return;
            }
            objArr.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    private void I() {
        try {
            int i = getCallingPid + 79;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            if (this.moveToNextValue == null) {
                DaggerMyProfileComponent.Builder PlaceComponentResult2 = DaggerMyProfileComponent.PlaceComponentResult();
                PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
                PlaceComponentResult2.getErrorConfigVersion = (MyProfileModule) Preconditions.getAuthRequestContext(new MyProfileModule(this));
                PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory = (GetStaticQrModule) Preconditions.getAuthRequestContext(new GetStaticQrModule(new GetStaticQrContract.View() { // from class: id.dana.myprofile.MyProfileFragment.9
                    @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                    public final void PlaceComponentResult(String str, String str2, String str3, String str4, String str5) {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void dismissProgress() {
                    }

                    @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                    public final void getAuthRequestContext(Long l) {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void onError(String str) {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void showProgress() {
                    }

                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                        MyProfileFragment.MyBillsEntityDataFactory(MyProfileFragment.this, str);
                    }

                    @Override // id.dana.contract.staticqr.GetStaticQrContract.View
                    public final void getAuthRequestContext(QrisTciCoConfigModel qrisTciCoConfigModel) {
                        MyProfileFragment.PlaceComponentResult(MyProfileFragment.this, qrisTciCoConfigModel.getPlaceComponentResult());
                        if (MyProfileFragment.lookAheadTest(MyProfileFragment.this)) {
                            return;
                        }
                        MyProfileFragment.this.getStaticQrPresenter.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }));
                PlaceComponentResult2.PlaceComponentResult = (GetBalanceModule) Preconditions.getAuthRequestContext(new GetBalanceModule(new GetBalanceContract.View() { // from class: id.dana.myprofile.MyProfileFragment.8
                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public void dismissProgress() {
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView
                    public /* synthetic */ String getErrorSource() {
                        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public void onError(String str) {
                    }

                    @Override // id.dana.contract.user.GetBalanceContract.View
                    public void onGetAllBalanceState(List<Boolean> list) {
                    }

                    @Override // id.dana.contract.user.GetBalanceContract.View
                    public /* synthetic */ void onGetBalanceDanaPlusActive(String str, String str2, DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                        GetBalanceContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                    }

                    @Override // id.dana.contract.user.GetBalanceContract.View
                    public /* synthetic */ void onGetBalanceDanaPlusError() {
                        GetBalanceContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                    }

                    @Override // id.dana.contract.user.GetBalanceContract.View
                    public /* synthetic */ void onGetBalanceDanaPlusUnActive(DanaHomeBalanceConfigModel danaHomeBalanceConfigModel) {
                        GetBalanceContract.View.CC.PlaceComponentResult();
                    }

                    @Override // id.dana.contract.user.GetBalanceContract.View
                    public /* synthetic */ void onGetBalanceError() {
                        GetBalanceContract.View.CC.MyBillsEntityDataFactory();
                    }

                    @Override // id.dana.contract.user.GetBalanceContract.View
                    public void onGetBalanceState(Boolean bool) {
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public void showProgress() {
                    }

                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.contract.user.GetBalanceContract.View
                    public void onGetBalance(CurrencyAmountModel currencyAmountModel) {
                        MyProfileFragment.this.BuiltInFictitiousFunctionClassFactory(BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(currencyAmountModel));
                    }
                }));
                PlaceComponentResult2.moveToNextValue = (QueryPayMethodModule) Preconditions.getAuthRequestContext(new QueryPayMethodModule(new QueryPayMethodContract.View() { // from class: id.dana.myprofile.MyProfileFragment.7
                    @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2, List<PayCardInfo> list) {
                    }

                    @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                    public final void MyBillsEntityDataFactory(Boolean bool) {
                    }

                    @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                    public final void PlaceComponentResult(PayCardConfigModel payCardConfigModel) {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void dismissProgress() {
                    }

                    @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                    public final void getAuthRequestContext() {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void showProgress() {
                    }

                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.contract.payasset.QueryPayMethodContract.View
                    public final void MyBillsEntityDataFactory(int i3) {
                        MyProfileFragment.MyBillsEntityDataFactory(MyProfileFragment.this, i3);
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void onError(String str) {
                        MyProfileFragment.this.PlaceComponentResult("-");
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.QRCODE_TAG, DanaLogConstants.Prefix.QRCODE_QUERY_PAY_METHOD_PREFIX, str);
                    }
                }));
                PlaceComponentResult2.MyBillsEntityDataFactory = (GenerateDeepLinkModule) Preconditions.getAuthRequestContext(new GenerateDeepLinkModule(new GenerateDeepLinkContract.ProfileView() { // from class: id.dana.myprofile.MyProfileFragment.6
                    @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
                    public final void MyBillsEntityDataFactory(Long l) {
                    }

                    @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
                    public final void PlaceComponentResult() {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void dismissProgress() {
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void showProgress() {
                    }

                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.contract.deeplink.generation.GenerateDeepLinkContract.ProfileView
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
                        MyProfileFragment.PlaceComponentResult(MyProfileFragment.this, str);
                    }

                    @Override // id.dana.base.AbstractContract.AbstractView
                    public void onError(String str) {
                        MyProfileFragment.this.showToast(str);
                    }
                }));
                PlaceComponentResult2.getAuthRequestContext = (BottomSheetOnBoardingModule) Preconditions.getAuthRequestContext(new BottomSheetOnBoardingModule(new BottomSheetOnBoardingContract.View() { // from class: id.dana.myprofile.MyProfileFragment.5
                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public void dismissProgress() {
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView
                    public /* synthetic */ String getErrorSource() {
                        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                    }

                    @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                    public /* synthetic */ void onGetBottomSheetOnBoardingAvailability(boolean z, String str) {
                        BottomSheetOnBoardingContract.View.CC.PlaceComponentResult();
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public void showProgress() {
                    }

                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.usereducation.BottomSheetOnBoardingContract.View
                    public void onGetBottomSheetOnBoardingAvailability(boolean z, String str, String str2) {
                        MyProfileFragment.MyBillsEntityDataFactory(MyProfileFragment.this, z, str, str2);
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public void onError(String str) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(getClass().getName());
                        sb.append(", on Error: ");
                        sb.append(str);
                        DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.TAG.USER_EDUCATION_TAG, sb.toString());
                    }
                }));
                PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0 = (UserStatementModule) Preconditions.getAuthRequestContext(new UserStatementModule(new UserStatementListener() { // from class: id.dana.myprofile.MyProfileFragment.4
                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
                    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str, String str2) {
                        MyProfileFragment myProfileFragment = MyProfileFragment.this;
                        MyProfileFragment.MyBillsEntityDataFactory(myProfileFragment, MyProfileFragment.getErrorConfigVersion(myProfileFragment), str, str2);
                    }

                    @Override // id.dana.statement.UserStatementListener, id.dana.statement.UserStatementContract.View
                    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
                        MyProfileFragment myProfileFragment = MyProfileFragment.this;
                        MyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(myProfileFragment, MyProfileFragment.getErrorConfigVersion(myProfileFragment), str, str2);
                    }
                }));
                PlaceComponentResult2.lookAheadTest = (SavingModule) Preconditions.getAuthRequestContext(new SavingModule(new SavingViewListener() { // from class: id.dana.myprofile.MyProfileFragment.3
                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
                    public final void MyBillsEntityDataFactory(SavingSummaryModel savingSummaryModel) {
                        MyProfileFragment.MyBillsEntityDataFactory(MyProfileFragment.this, savingSummaryModel);
                    }
                }));
                PlaceComponentResult2.scheduleImpl = (InvestmentModule) Preconditions.getAuthRequestContext(new InvestmentModule(new InvestmentContract.View() { // from class: id.dana.myprofile.MyProfileFragment.2
                    @Override // id.dana.investment.contract.InvestmentContract.View
                    public final void BuiltInFictitiousFunctionClassFactory() {
                    }

                    @Override // id.dana.investment.contract.InvestmentContract.View
                    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public /* synthetic */ void dismissProgress() {
                        AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                    }

                    @Override // id.dana.investment.contract.InvestmentContract.View
                    public final void getAuthRequestContext(boolean z) {
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView
                    public /* synthetic */ String getErrorSource() {
                        return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public /* synthetic */ void onError(String str) {
                        AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                    }

                    @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                    public /* synthetic */ void showProgress() {
                        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                    }

                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.investment.contract.InvestmentContract.View
                    public final void MyBillsEntityDataFactory(UserInvestmentModel userInvestmentModel) {
                        MyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(MyProfileFragment.this, userInvestmentModel);
                    }
                }));
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getErrorConfigVersion, MyProfileModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.PlaceComponentResult, GetBalanceModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, GetStaticQrModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.MyBillsEntityDataFactory, GenerateDeepLinkModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.moveToNextValue, QueryPayMethodModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.getAuthRequestContext, BottomSheetOnBoardingModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0, UserStatementModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.lookAheadTest, SavingModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.scheduleImpl, InvestmentModule.class);
                Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
                this.moveToNextValue = new DaggerMyProfileComponent.MyProfileComponentImpl(PlaceComponentResult2.getErrorConfigVersion, PlaceComponentResult2.PlaceComponentResult, PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory, PlaceComponentResult2.MyBillsEntityDataFactory, PlaceComponentResult2.moveToNextValue, PlaceComponentResult2.getAuthRequestContext, PlaceComponentResult2.NetworkUserEntityData$$ExternalSyntheticLambda0, PlaceComponentResult2.lookAheadTest, PlaceComponentResult2.scheduleImpl, PlaceComponentResult2.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
            }
            this.moveToNextValue.getAuthRequestContext(this);
            registerPresenter(this.myProfilePresenter, this.getStaticQrPresenter, this.profileQrDeepLinkPresenter, this.bottomSheetOnBoardingPresenter, this.savingPresenter, this.investmentPresenter);
            int i3 = getSupportButtonTintMode + 7;
            getCallingPid = i3 % 128;
            if (!(i3 % 2 == 0)) {
                int i4 = 9 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void isLayoutRequested(String str) {
        int i = getCallingPid + 51;
        getSupportButtonTintMode = i % 128;
        Object obj = null;
        if (i % 2 == 0) {
            try {
                boolean equals = Objects.equals(str, "loan_personal");
                obj.hashCode();
                if (!equals) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            try {
                if (!Objects.equals(str, "loan_personal")) {
                    return;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = getSupportButtonTintMode + 93;
        getCallingPid = i2 % 128;
        if (!(i2 % 2 != 0)) {
            this.bottomSheetOnBoardingPresenter.MyBillsEntityDataFactory("loan_personal");
            return;
        }
        this.bottomSheetOnBoardingPresenter.MyBillsEntityDataFactory("loan_personal");
        obj.hashCode();
    }

    private void MyBillsEntityDataFactory(boolean z, String str, String str2) {
        try {
            int i = getSupportButtonTintMode + 21;
            try {
                getCallingPid = i % 128;
                int i2 = i % 2;
                Object[] objArr = null;
                if (z) {
                    int i3 = getCallingPid + 13;
                    getSupportButtonTintMode = i3 % 128;
                    if (i3 % 2 == 0) {
                        str = UrlUtil.PlaceComponentResult(str, OnboardingParams.FIRST_TIME_TOP_UP);
                        isLayoutRequested(str2);
                        int length = objArr.length;
                    } else {
                        str = UrlUtil.PlaceComponentResult(str, OnboardingParams.FIRST_TIME_TOP_UP);
                        isLayoutRequested(str2);
                    }
                }
                NetworkUserEntityData$$ExternalSyntheticLambda1(str);
                int i4 = getCallingPid + 33;
                getSupportButtonTintMode = i4 % 128;
                if (i4 % 2 != 0) {
                    return;
                }
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(int i) {
        if (getContext() != null) {
            if ((isAdded() ? (char) 0 : (char) 16) == 0) {
                PlaceComponentResult(getResources().getQuantityString(R.plurals.f46612131820544, i, Integer.valueOf(i)));
                int i2 = getSupportButtonTintMode + 51;
                getCallingPid = i2 % 128;
                int i3 = i2 % 2;
            }
        }
        int i4 = getSupportButtonTintMode + 49;
        getCallingPid = i4 % 128;
        if ((i4 % 2 != 0 ? 'N' : '.') != 'N') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private void PlaceComponentResult(SavingSummaryModel savingSummaryModel) {
        SettingModel empty;
        if (savingSummaryModel != null) {
            int i = getCallingPid + 59;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (!(myProfileDiffutilAdapter == null)) {
                int i3 = getSupportButtonTintMode + 117;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
                int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory(ProfileUserServiceType.SAVING);
                if (myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyBillsEntityDataFactory2)) {
                    int i5 = getCallingPid + 37;
                    getSupportButtonTintMode = i5 % 128;
                    int i6 = i5 % 2;
                    empty = myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue.get(MyBillsEntityDataFactory2);
                } else {
                    empty = SettingModel.empty();
                    int i7 = getSupportButtonTintMode + 115;
                    getCallingPid = i7 % 128;
                    int i8 = i7 % 2;
                }
                if (empty.isNullObject()) {
                    return;
                }
                SavingSummarySettingMapper savingSummarySettingMapper = SavingSummarySettingMapper.INSTANCE;
                empty.setSubtitle(SavingSummarySettingMapper.BuiltInFictitiousFunctionClassFactory(savingSummaryModel, getString(R.string.saving_subtitle)));
                MyProfileDiffutilAdapter myProfileDiffutilAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                int MyBillsEntityDataFactory3 = myProfileDiffutilAdapter2.MyBillsEntityDataFactory(ProfileUserServiceType.SAVING);
                if (MyBillsEntityDataFactory3 != -1) {
                    myProfileDiffutilAdapter2.notifyItemChanged(MyBillsEntityDataFactory3);
                }
            }
        }
        int i9 = getCallingPid + 105;
        getSupportButtonTintMode = i9 % 128;
        if ((i9 % 2 == 0 ? 'B' : (char) 5) != 'B') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:107:0x007b, code lost:
    
        if (id.dana.data.profilemenu.MyProfileMenuCategories.PROFILE_FEATURES.equalsIgnoreCase(r2) != false) goto L108;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getAuthRequestContext(id.dana.investment.model.UserInvestmentModel r7) {
        /*
            r6 = this;
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r6.NetworkUserEntityData$$ExternalSyntheticLambda8
            if (r0 != 0) goto L5
            return
        L5:
            java.lang.String r1 = "setting_investment"
            int r2 = r0.MyBillsEntityDataFactory(r1)
            boolean r3 = r0.MyBillsEntityDataFactory(r2)
            r4 = 0
            if (r3 == 0) goto L3d
            int r3 = id.dana.myprofile.MyProfileFragment.getCallingPid     // Catch: java.lang.Exception -> L3a
            int r3 = r3 + 103
            int r5 = r3 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r5     // Catch: java.lang.Exception -> L37
            int r3 = r3 % 2
            if (r3 != 0) goto L2c
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r0 = r0.getAuthRequestContext
            java.util.List<T> r0 = r0.moveToNextValue
            java.lang.Object r0 = r0.get(r2)
            id.dana.domain.profilemenu.model.SettingModel r0 = (id.dana.domain.profilemenu.model.SettingModel) r0
            int r2 = r4.length     // Catch: java.lang.Throwable -> L2a
            goto L41
        L2a:
            r7 = move-exception
            throw r7
        L2c:
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r0 = r0.getAuthRequestContext     // Catch: java.lang.Exception -> L37
            java.util.List<T> r0 = r0.moveToNextValue
            java.lang.Object r0 = r0.get(r2)
            id.dana.domain.profilemenu.model.SettingModel r0 = (id.dana.domain.profilemenu.model.SettingModel) r0
            goto L41
        L37:
            r7 = move-exception
            goto Lb1
        L3a:
            r7 = move-exception
            goto Lb0
        L3d:
            id.dana.domain.profilemenu.model.SettingModel r0 = id.dana.domain.profilemenu.model.SettingModel.empty()
        L41:
            boolean r2 = r0.isNullObject()
            if (r2 == 0) goto L48
            return
        L48:
            java.lang.String r2 = r0.getCollection()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r5 = 1
            if (r3 == 0) goto L55
            r3 = 1
            goto L56
        L55:
            r3 = 0
        L56:
            if (r3 == r5) goto L59
            goto L7d
        L59:
            int r3 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r3 = r3 + 95
            int r5 = r3 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r5
            int r3 = r3 % 2
            java.lang.String r3 = "setting_category_user_service"
            boolean r3 = r3.equalsIgnoreCase(r2)
            r5 = 9
            if (r3 != 0) goto L70
            r3 = 9
            goto L72
        L70:
            r3 = 31
        L72:
            if (r3 == r5) goto L75
            goto L7d
        L75:
            java.lang.String r3 = "setting_category_features"
            boolean r2 = r3.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L3a
            if (r2 == 0) goto L8e
        L7d:
            id.dana.domain.investment.model.UserInvestmentInfo r2 = new id.dana.domain.investment.model.UserInvestmentInfo
            id.dana.domain.investment.AccountInvestmentStatus r3 = r7.PlaceComponentResult
            r2.<init>(r3)
            r0.setUserInvestmentInfo(r2)
            android.content.Context r3 = r6.requireContext()
            id.dana.myprofile.mapper.InvestmentSummaryMapperKt.BuiltInFictitiousFunctionClassFactory(r7, r3, r2, r0)
        L8e:
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r7 = r6.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r7.MyBillsEntityDataFactory(r1)
            r1 = -1
            if (r0 == r1) goto Laf
            int r1 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r1 = r1 + 117
            int r2 = r1 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r2
            int r1 = r1 % 2
            if (r1 != 0) goto Lac
            r7.notifyItemChanged(r0)
            r4.hashCode()     // Catch: java.lang.Throwable -> Laa
            goto Laf
        Laa:
            r7 = move-exception
            throw r7
        Lac:
            r7.notifyItemChanged(r0)
        Laf:
            return
        Lb0:
            throw r7
        Lb1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.getAuthRequestContext(id.dana.investment.model.UserInvestmentModel):void");
    }

    private void GetContactSyncConfig(String str) {
        RecyclerView recyclerView;
        int i = getCallingPid + 105;
        getSupportButtonTintMode = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? '9' : '\f') != '\f') {
            recyclerView = this.rvProfileSetting;
            obj.hashCode();
            if (recyclerView == null) {
                return;
            }
        } else {
            recyclerView = this.rvProfileSetting;
            if ((recyclerView != null ? '*' : '%') == '%') {
                return;
            }
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
            int i2 = getCallingPid + 23;
            getSupportButtonTintMode = i2 % 128;
            if ((i2 % 2 == 0 ? 'H' : '2') != '2') {
                boolean isComputingLayout = recyclerView.isComputingLayout();
                obj.hashCode();
                if (isComputingLayout) {
                    return;
                }
            } else {
                if ((!recyclerView.isComputingLayout() ? '#' : '=') == '=') {
                    return;
                }
            }
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory(str);
            if (MyBillsEntityDataFactory2 != -1) {
                int i3 = getSupportButtonTintMode + 11;
                getCallingPid = i3 % 128;
                if (i3 % 2 != 0) {
                    myProfileDiffutilAdapter.notifyItemChanged(MyBillsEntityDataFactory2);
                    int i4 = 96 / 0;
                    return;
                }
                try {
                    myProfileDiffutilAdapter.notifyItemChanged(MyBillsEntityDataFactory2);
                } catch (Exception e) {
                    throw e;
                }
            }
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda2(String str) {
        int i = getCallingPid + 55;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            this.PrepareContext = str;
            int i3 = getCallingPid + 51;
            getSupportButtonTintMode = i3 % 128;
            if (i3 % 2 == 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.base.BaseWithToolbarFragment
    public void onClickLeftMenuButton(View view) {
        int i = getSupportButtonTintMode + 73;
        getCallingPid = i % 128;
        int i2 = i % 2;
        try {
            int i3 = getCallingPid + 123;
            getSupportButtonTintMode = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 3 : '7') != '7') {
                int i4 = 8 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        int i = getSupportButtonTintMode + 29;
        getCallingPid = i % 128;
        int i2 = i % 2;
        try {
            SimpleProfileWithQrView simpleProfileWithQrView = this.profileView;
            if (!(simpleProfileWithQrView != null)) {
                return;
            }
            int i3 = getCallingPid + 103;
            getSupportButtonTintMode = i3 % 128;
            if (!(i3 % 2 == 0)) {
                simpleProfileWithQrView.setUserName(str);
                return;
            }
            try {
                simpleProfileWithQrView.setUserName(str);
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void getAuthRequestContext(String str) {
        SimpleProfileWithQrView simpleProfileWithQrView;
        int i = getSupportButtonTintMode + 125;
        getCallingPid = i % 128;
        if ((i % 2 != 0 ? '2' : '\'') != '\'') {
            try {
                simpleProfileWithQrView = this.profileView;
                Object[] objArr = null;
                int length = objArr.length;
                if (simpleProfileWithQrView == null) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        } else {
            simpleProfileWithQrView = this.profileView;
            if ((simpleProfileWithQrView != null ? '1' : 'Y') == 'Y') {
                return;
            }
        }
        try {
            simpleProfileWithQrView.setPhoneNumber(str);
            int i2 = getSupportButtonTintMode + 15;
            getCallingPid = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        SettingModel empty;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i = getCallingPid + 61;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            if (!(myProfileDiffutilAdapter != null)) {
                return;
            }
            int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory("setting_balance");
            if (myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyBillsEntityDataFactory2)) {
                int i3 = getSupportButtonTintMode + 15;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
                try {
                    empty = myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue.get(MyBillsEntityDataFactory2);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                empty = SettingModel.empty();
            }
            if (!empty.isNullObject()) {
                empty.setSubtitle(str);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.notifyDataSetChanged();
                return;
            }
            int i5 = getCallingPid + 21;
            getSupportButtonTintMode = i5 % 128;
            if ((i5 % 2 == 0 ? '-' : '`') != '`') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final void PlaceComponentResult(String str) {
        SettingModel settingModel;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory("setting_my_payment_cards");
        if ((myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyBillsEntityDataFactory2) ? '-' : '0') == '-') {
            int i = getCallingPid + 115;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            settingModel = myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue.get(MyBillsEntityDataFactory2);
        } else {
            settingModel = SettingModel.empty();
        }
        if (settingModel.isNullObject()) {
            return;
        }
        try {
            settingModel.setSubtitle(str);
            GetContactSyncConfig("setting_my_payment_cards");
            int i3 = getSupportButtonTintMode + 55;
            try {
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void MyBillsEntityDataFactory() {
        int i = getSupportButtonTintMode + 109;
        getCallingPid = i % 128;
        int i2 = i % 2;
        VerifyPinStateManager$executeRiskChallenge$2$2();
        int i3 = getSupportButtonTintMode + 33;
        getCallingPid = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 69 / 0;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void MyBillsEntityDataFactory(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != null) {
                NetworkUserEntityData$$ExternalSyntheticLambda0(str);
                int i = getCallingPid + 43;
                getSupportButtonTintMode = i % 128;
                int i2 = i % 2;
            }
        }
        int i3 = getCallingPid + 101;
        getSupportButtonTintMode = i3 % 128;
        int i4 = i3 % 2;
    }

    @Override // id.dana.myprofile.MyProfileContract.View, id.dana.base.AbstractContract.AbstractView
    public void onError(String str) {
        try {
            int i = getCallingPid + 67;
            try {
                getSupportButtonTintMode = i % 128;
                if (i % 2 == 0) {
                }
                Toast.makeText(getActivity(), ErrorUtil.BuiltInFictitiousFunctionClassFactory(getBaseActivity()), 0).show();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void getAuthRequestContext(List<? extends SettingModel> list) {
        int i = getSupportButtonTintMode + 99;
        getCallingPid = i % 128;
        int i2 = i % 2;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i4 = getCallingPid + 69;
            getSupportButtonTintMode = i4 % 128;
            int i5 = i4 % 2;
            try {
                try {
                    if ((list.get(i3).getViewType() == 0 ? 'I' : '\\') != '\\') {
                        if ((list.get(i3).getTitle().equals("USER SERVICE") ? 'X' : '6') != '6') {
                            int i6 = getCallingPid + 83;
                            getSupportButtonTintMode = i6 % 128;
                            char c = i6 % 2 == 0 ? 'O' : Typography.quote;
                            list.remove(i3);
                            if (c != 'O') {
                                continue;
                            } else {
                                int i7 = 45 / 0;
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2(new ArrayList(list));
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(new ArrayList(list), null);
        C();
        BottomSheetCardBindingView$watcherCardNumberView$1();
        E();
        getCallingPid();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:44:0x0047
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // id.dana.myprofile.MyProfileContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean r4) {
        /*
            r3 = this;
            r3.P()
            android.content.Intent r0 = new android.content.Intent
            id.dana.base.BaseActivity r1 = r3.getBaseActivity()     // Catch: java.lang.Exception -> L49
            java.lang.Class<id.dana.referral.MyReferralDetailActivity> r2 = id.dana.referral.MyReferralDetailActivity.class
            r0.<init>(r1, r2)
            id.dana.myprofile.MyProfileContract$Presenter r1 = r3.myProfilePresenter     // Catch: java.lang.Exception -> L49
            id.dana.referral.model.MyReferralConsult r1 = r1.GetContactSyncConfig()     // Catch: java.lang.Exception -> L49
            java.lang.String r2 = "referral_consult"
            r0.putExtra(r2, r1)     // Catch: java.lang.Exception -> L49
            id.dana.myprofile.MyProfileContract$Presenter r1 = r3.myProfilePresenter     // Catch: java.lang.Exception -> L49
            java.lang.String r1 = r1.scheduleImpl()     // Catch: java.lang.Exception -> L49
            java.lang.String r2 = "referral_deepLink"
            r0.putExtra(r2, r1)     // Catch: java.lang.Exception -> L49
            java.lang.String r1 = "referral_show"
            r0.putExtra(r1, r4)     // Catch: java.lang.Exception -> L49
            r3.startActivity(r0)     // Catch: java.lang.Exception -> L49
            int r4 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r4 = r4 + 39
            int r0 = r4 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r0
            int r4 = r4 % 2
            r0 = 64
            if (r4 == 0) goto L3d
            r4 = 13
            goto L3f
        L3d:
            r4 = 64
        L3f:
            if (r4 == r0) goto L46
            r4 = 0
            int r4 = r4.length     // Catch: java.lang.Throwable -> L44
            return
        L44:
            r4 = move-exception
            throw r4
        L46:
            return
        L47:
            r4 = move-exception
            throw r4
        L49:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.KClassImpl$Data$declaredNonStaticMembers$2(boolean):void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        int i = getCallingPid + 99;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int i3 = getCallingPid + 69;
            getSupportButtonTintMode = i3 % 128;
            int i4 = i3 % 2;
            try {
                boolean lookAheadTest = lookAheadTest(str);
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = lookAheadTest;
                if (!(!lookAheadTest)) {
                    L();
                } else {
                    DatabaseTableConfigUtil(str2);
                }
                if ((this.isLayoutRequested ? '3' : (char) 22) != '3') {
                    return;
                }
                A();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0024, code lost:
    
        if ((r0 != null ? '*' : '\'') != '*') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0032, code lost:
    
        if ((getContext() == null) != true) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0034, code lost:
    
        id.dana.social.utils.SocialSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
        id.dana.sync_engine.permission.workmanager.SyncPermissionWorker.BuiltInFictitiousFunctionClassFactory(getContext());
        id.dana.social.utils.SaveContactSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0049, code lost:
    
        PrepareContext("Normal");
        id.dana.utils.deeplink.DeepLinkParser.getAuthRequestContext();
        id.dana.familyaccount.util.TopUpUserConsultManager.MyBillsEntityDataFactory();
        id.dana.onboarding.OnboardingActivity.openAfterLogout(getBaseActivity());
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x005b, code lost:
    
        r0 = id.dana.myprofile.MyProfileFragment.getCallingPid + 101;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0065, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0066, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0067, code lost:
    
        throw r0;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext() {
        /*
            r2 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode     // Catch: java.lang.Exception -> L68
            int r0 = r0 + 23
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r1     // Catch: java.lang.Exception -> L68
            int r0 = r0 % 2
            r1 = 1
            if (r0 == 0) goto L10
            r0 = 56
            goto L11
        L10:
            r0 = 1
        L11:
            if (r0 == r1) goto L29
            android.content.Context r0 = r2.getContext()     // Catch: java.lang.Exception -> L68
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L27
            r1 = 42
            if (r0 == 0) goto L22
            r0 = 42
            goto L24
        L22:
            r0 = 39
        L24:
            if (r0 == r1) goto L34
            goto L49
        L27:
            r0 = move-exception
            throw r0
        L29:
            android.content.Context r0 = r2.getContext()
            if (r0 == 0) goto L31
            r0 = 0
            goto L32
        L31:
            r0 = 1
        L32:
            if (r0 == r1) goto L49
        L34:
            android.content.Context r0 = r2.getContext()
            id.dana.social.utils.SocialSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            android.content.Context r0 = r2.getContext()
            id.dana.sync_engine.permission.workmanager.SyncPermissionWorker.BuiltInFictitiousFunctionClassFactory(r0)
            android.content.Context r0 = r2.getContext()
            id.dana.social.utils.SaveContactSyncManagerKt.KClassImpl$Data$declaredNonStaticMembers$2(r0)
        L49:
            java.lang.String r0 = "Normal"
            r2.PrepareContext(r0)
            id.dana.utils.deeplink.DeepLinkParser.getAuthRequestContext()
            id.dana.familyaccount.util.TopUpUserConsultManager.MyBillsEntityDataFactory()
            id.dana.base.BaseActivity r0 = r2.getBaseActivity()
            id.dana.onboarding.OnboardingActivity.openAfterLogout(r0)
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid     // Catch: java.lang.Exception -> L66
            int r0 = r0 + 101
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1     // Catch: java.lang.Exception -> L66
            int r0 = r0 % 2
            return
        L66:
            r0 = move-exception
            throw r0
        L68:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.getAuthRequestContext():void");
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void lookAheadTest() {
        LoadingDialog loadingDialog = new LoadingDialog(getBaseActivity());
        this.DatabaseTableConfigUtil = loadingDialog;
        if (!(loadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing())) {
            int i = getSupportButtonTintMode + 13;
            getCallingPid = i % 128;
            int i2 = i % 2;
            try {
                loadingDialog.BuiltInFictitiousFunctionClassFactory.show();
            } catch (Exception unused) {
                return;
            }
        }
        int i3 = getCallingPid + 83;
        getSupportButtonTintMode = i3 % 128;
        if ((i3 % 2 == 0 ? 'L' : '.') != '.') {
            int i4 = 89 / 0;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        try {
            int i = getSupportButtonTintMode + 117;
            getCallingPid = i % 128;
            if (!(i % 2 == 0)) {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2();
                Object obj = null;
                obj.hashCode();
            } else {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2();
            }
            int i2 = getSupportButtonTintMode + 55;
            getCallingPid = i2 % 128;
            if (i2 % 2 != 0) {
                int i3 = 61 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void getAuthRequestContext(boolean z) {
        try {
            int i = getSupportButtonTintMode + 21;
            getCallingPid = i % 128;
            if ((i % 2 != 0 ? Typography.amp : '`') != '`') {
                try {
                    this.newProxyInstance = z;
                    int i2 = 71 / 0;
                    if (z ? false : true) {
                        return;
                    }
                } catch (Exception e) {
                    throw e;
                }
            } else {
                this.newProxyInstance = z;
                if (!z) {
                    return;
                }
            }
            NetworkUserEntityData$$ExternalSyntheticLambda6();
            int i3 = getSupportButtonTintMode + 33;
            getCallingPid = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    @Override // id.dana.myprofile.MyProfileContract.View
    public final void MyBillsEntityDataFactory(SettingModel settingModel) {
        if (!getNameOrBuilderList()) {
            try {
                MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
                try {
                    ArrayList arrayList = new ArrayList(myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue);
                    arrayList.add(0, settingModel);
                    myProfileDiffutilAdapter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, null);
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            if (getNameOrBuilderList()) {
                settingModel.setKycRevoked(!this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.getAuthRequestContext(settingModel);
            }
        }
        if ((this.isLayoutRequested ? Typography.dollar : '4') != '4') {
            int i = getCallingPid + 49;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            NetworkUserEntityData$$ExternalSyntheticLambda5();
        }
        int i3 = getCallingPid + 99;
        getSupportButtonTintMode = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0018, code lost:
    
        if ((r5.NetworkUserEntityData$$ExternalSyntheticLambda6) != true) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x001f, code lost:
    
        if (r5.NetworkUserEntityData$$ExternalSyntheticLambda6 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0021, code lost:
    
        BuiltInFictitiousFunctionClassFactory(readMicros());
        r0 = id.dana.myprofile.MyProfileFragment.getCallingPid + 107;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0032, code lost:
    
        if ((r0 % 2) != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0034, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0035, code lost:
    
        r0.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0038, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x003c, code lost:
    
        r0 = r5.nsvProfile;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0040, code lost:
    
        if (r0 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0042, code lost:
    
        r4 = 14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0045, code lost:
    
        r4 = 'T';
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0047, code lost:
    
        if (r4 == 'T') goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0049, code lost:
    
        r3 = id.dana.myprofile.MyProfileFragment.getCallingPid + 59;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r3 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0053, code lost:
    
        if ((r3 % 2) != 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0055, code lost:
    
        r0.smoothScrollTo(1, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0059, code lost:
    
        r0.smoothScrollTo(0, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x005d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x005e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x005f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void NetworkUserEntityData$$ExternalSyntheticLambda6() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r0 = r0 + 47
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L1d
            boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda6
            r3 = 46
            int r3 = r3 / r2
            if (r0 != 0) goto L17
            r0 = 0
            goto L18
        L17:
            r0 = 1
        L18:
            if (r0 == r1) goto L3c
            goto L21
        L1b:
            r0 = move-exception
            throw r0
        L1d:
            boolean r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda6
            if (r0 != 0) goto L3c
        L21:
            id.dana.showcase.target.Target r0 = r5.readMicros()
            r5.BuiltInFictitiousFunctionClassFactory(r0)
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3b
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L39
            return
        L39:
            r0 = move-exception
            throw r0
        L3b:
            return
        L3c:
            androidx.core.widget.NestedScrollView r0 = r5.nsvProfile
            r3 = 84
            if (r0 == 0) goto L45
            r4 = 14
            goto L47
        L45:
            r4 = 84
        L47:
            if (r4 == r3) goto L5f
            int r3 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r3 = r3 + 59
            int r4 = r3 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r4
            int r3 = r3 % 2
            if (r3 != 0) goto L59
            r0.smoothScrollTo(r1, r1)     // Catch: java.lang.Exception -> L5d
            goto L5f
        L59:
            r0.smoothScrollTo(r2, r2)     // Catch: java.lang.Exception -> L5d
            goto L5f
        L5d:
            r0 = move-exception
            throw r0
        L5f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda6():void");
    }

    private void P() {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getBaseActivity().getApplicationContext());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.REFERRER_PAGE_OPEN;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = builder.MyBillsEntityDataFactory("Source", "Me Page");
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
        int i = getCallingPid + 53;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
    }

    private void PrepareContext(String str) {
        EventTrackerModel.Builder builder = new EventTrackerModel.Builder(getBaseActivity());
        builder.MyBillsEntityDataFactory = TrackerKey.Event.LOGOUT;
        EventTrackerModel.Builder MyBillsEntityDataFactory2 = builder.MyBillsEntityDataFactory(TrackerKey.Property.LOGOUT_TYPE, str);
        MyBillsEntityDataFactory2.PlaceComponentResult();
        EventTracker.PlaceComponentResult(new EventTrackerModel(MyBillsEntityDataFactory2, (byte) 0));
        int i = getSupportButtonTintMode + 29;
        getCallingPid = i % 128;
        int i2 = i % 2;
    }

    private static boolean lookAheadTest(String str) {
        int i = getCallingPid + 5;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            boolean equals = "KYC2".equals(str);
            int i3 = getCallingPid + 95;
            getSupportButtonTintMode = i3 % 128;
            int i4 = i3 % 2;
            return equals;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x001b, code lost:
    
        if ((r0 != null ? kotlin.text.Typography.amp : 27) != 27) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0022, code lost:
    
        if (r0 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0024, code lost:
    
        r1 = id.dana.myprofile.MyProfileFragment.getCallingPid + 107;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0030, code lost:
    
        if ((r1 % 2) != 0) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0032, code lost:
    
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0035, code lost:
    
        r1 = 'R';
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0037, code lost:
    
        if (r1 == 'R') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x003b, code lost:
    
        r0.setVisibility(96);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x003f, code lost:
    
        r0.setVisibility(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0045, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0046, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0047, code lost:
    
        r0 = r3.profileView;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0049, code lost:
    
        if (r0 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x004b, code lost:
    
        r0.onPremiumUser(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x004f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L() {
        /*
            r3 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r0 = r0 + 39
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L20
            android.widget.Button r0 = r3.buttonVerify
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L1e
            r1 = 27
            if (r0 == 0) goto L19
            r2 = 38
            goto L1b
        L19:
            r2 = 27
        L1b:
            if (r2 == r1) goto L47
            goto L24
        L1e:
            r0 = move-exception
            throw r0
        L20:
            android.widget.Button r0 = r3.buttonVerify     // Catch: java.lang.Exception -> L50
            if (r0 == 0) goto L47
        L24:
            int r1 = id.dana.myprofile.MyProfileFragment.getCallingPid     // Catch: java.lang.Exception -> L45
            int r1 = r1 + 107
            int r2 = r1 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r2     // Catch: java.lang.Exception -> L45
            int r1 = r1 % 2
            r2 = 82
            if (r1 != 0) goto L35
            r1 = 16
            goto L37
        L35:
            r1 = 82
        L37:
            if (r1 == r2) goto L3f
            r1 = 96
            r0.setVisibility(r1)     // Catch: java.lang.Exception -> L50
            goto L47
        L3f:
            r1 = 8
            r0.setVisibility(r1)
            goto L47
        L45:
            r0 = move-exception
            throw r0
        L47:
            id.dana.richview.SimpleProfileWithQrView r0 = r3.profileView
            if (r0 == 0) goto L4f
            r1 = 1
            r0.onPremiumUser(r1)
        L4f:
            return
        L50:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.L():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0017, code lost:
    
        if (r5 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0027, code lost:
    
        if ((r5 == null) != true) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x002b, code lost:
    
        r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode + 47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x002f, code lost:
    
        id.dana.myprofile.MyProfileFragment.getCallingPid = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0033, code lost:
    
        r5.onPremiumUser(false);
        r5 = id.dana.myprofile.MyProfileFragment.getCallingPid + 59;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r5 % 128;
        r5 = r5 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0040, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0041, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0042, code lost:
    
        r5 = id.dana.myprofile.MyProfileFragment.getCallingPid + 23;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r5 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x004e, code lost:
    
        if ((r5 % 2) != 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0050, code lost:
    
        r1 = 'I';
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0052, code lost:
    
        if (r1 == 'I') goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0054, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0055, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0056, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0059, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void DatabaseTableConfigUtil(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode     // Catch: java.lang.Exception -> L5c
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r1     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            r1 = 59
            r2 = 0
            if (r0 == 0) goto L1c
            r4.newProxyInstance(r5)
            id.dana.richview.SimpleProfileWithQrView r5 = r4.profileView
            r0 = 17
            int r0 = r0 / r2
            if (r5 == 0) goto L42
            goto L29
        L1a:
            r5 = move-exception
            throw r5
        L1c:
            r4.newProxyInstance(r5)
            id.dana.richview.SimpleProfileWithQrView r5 = r4.profileView
            r0 = 1
            if (r5 == 0) goto L26
            r3 = 0
            goto L27
        L26:
            r3 = 1
        L27:
            if (r3 == r0) goto L42
        L29:
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode     // Catch: java.lang.Exception -> L40
            int r0 = r0 + 47
            int r3 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r3     // Catch: java.lang.Exception -> L5c
            int r0 = r0 % 2
            r5.onPremiumUser(r2)
            int r5 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r5 = r5 + r1
            int r0 = r5 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0
            int r5 = r5 % 2
            goto L42
        L40:
            r5 = move-exception
            throw r5
        L42:
            int r5 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r5 = r5 + 23
            int r0 = r5 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0
            int r5 = r5 % 2
            r0 = 73
            if (r5 != 0) goto L52
            r1 = 73
        L52:
            if (r1 == r0) goto L55
            return
        L55:
            r5 = 0
            r5.hashCode()     // Catch: java.lang.Throwable -> L5a
            return
        L5a:
            r5 = move-exception
            throw r5
        L5c:
            r5 = move-exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.DatabaseTableConfigUtil(java.lang.String):void");
    }

    private void newProxyInstance(String str) {
        Button button = this.buttonVerify;
        if (button != null) {
            int i = getSupportButtonTintMode + 117;
            getCallingPid = i % 128;
            if ((i % 2 != 0 ? 'X' : 'W') != 'X') {
                try {
                    button.setVisibility(0);
                    this.buttonVerify.setCompoundDrawablesWithIntrinsicBounds(0, 0, scheduleImpl(str), 0);
                    this.buttonVerify.setText(getErrorConfigVersion(str));
                } catch (Exception e) {
                    throw e;
                }
            } else {
                button.setVisibility(1);
                this.buttonVerify.setCompoundDrawablesWithIntrinsicBounds(0, 0, scheduleImpl(str), 1);
                this.buttonVerify.setText(getErrorConfigVersion(str));
            }
            int i2 = getSupportButtonTintMode + 101;
            getCallingPid = i2 % 128;
            int i3 = i2 % 2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x004c, code lost:
    
        if ((!r0 ? 30 : '4') != 30) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x005c, code lost:
    
        if ((!id.dana.domain.model.KycStatus.WAITING_DOC.equals(r4) ? '.' : 'T') != '.') goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x005f, code lost:
    
        r0 = id.dana.myprofile.MyProfileFragment.getCallingPid + 49;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x006f, code lost:
    
        if ("FAILED".equals(r4) == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0071, code lost:
    
        return id.dana.R.drawable.kyc_failed;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return id.dana.R.drawable.kyc_default;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int scheduleImpl(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L76
            java.lang.String r0 = "IN_PROGRESS"
            boolean r0 = r0.equals(r4)
            r1 = 2131233971(0x7f080cb3, float:1.8084095E38)
            if (r0 == 0) goto L1c
            int r4 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r4 = r4 + 37
            int r0 = r4 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r0
            int r4 = r4 % 2
            return r1
        L1c:
            java.lang.String r0 = "MANUAL_REVIEW"
            boolean r0 = r0.equals(r4)
            r2 = 46
            if (r0 != 0) goto L29
            r0 = 19
            goto L2b
        L29:
            r0 = 46
        L2b:
            if (r0 == r2) goto L75
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r0 = r0 + 57
            int r3 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r3
            int r0 = r0 % 2
            java.lang.String r3 = "WAITING_DOC"
            if (r0 != 0) goto L51
            boolean r0 = r3.equals(r4)
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L4f
            r2 = 30
            if (r0 != 0) goto L4a
            r0 = 30
            goto L4c
        L4a:
            r0 = 52
        L4c:
            if (r0 == r2) goto L5f
            goto L75
        L4f:
            r4 = move-exception
            throw r4
        L51:
            boolean r0 = r3.equals(r4)
            if (r0 != 0) goto L5a
            r0 = 46
            goto L5c
        L5a:
            r0 = 84
        L5c:
            if (r0 == r2) goto L5f
            goto L75
        L5f:
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r0 = r0 + 49
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            java.lang.String r0 = "FAILED"
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L76
            r4 = 2131233970(0x7f080cb2, float:1.8084093E38)
            return r4
        L75:
            return r1
        L76:
            r4 = 2131233968(0x7f080cb0, float:1.8084088E38)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.scheduleImpl(java.lang.String):int");
    }

    private static int getErrorConfigVersion(String str) {
        int i = getCallingPid + 87;
        getSupportButtonTintMode = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'F' : '#') == 'F') {
            boolean isEmpty = TextUtils.isEmpty(str);
            int length = objArr.length;
            if (isEmpty) {
                return R.string.kyc_0_title;
            }
        } else if (TextUtils.isEmpty(str)) {
            return R.string.kyc_0_title;
        }
        if ("IN_PROGRESS".equals(str)) {
            return R.string.kyc_processing_title;
        }
        if ((KycStatus.WAITING_DOC.equals(str) ? ')' : '^') != '^') {
            return R.string.kyc_waiting_doc_title;
        }
        if (KycStatus.MANUAL_REVIEW.equals(str)) {
            int i2 = getCallingPid + 35;
            getSupportButtonTintMode = i2 % 128;
            if (i2 % 2 == 0) {
                objArr.hashCode();
                return R.string.kyc_manual_review_title;
            }
            return R.string.kyc_manual_review_title;
        }
        if ("FAILED".equals(str)) {
            int i3 = getCallingPid + 43;
            getSupportButtonTintMode = i3 % 128;
            int i4 = i3 % 2;
            return R.string.kyc_failed_title;
        }
        return R.string.kyc_0_title;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        int i = getCallingPid + 87;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        if (getContext() != null) {
            if ((NetworkUserEntityData$$ExternalSyntheticLambda4() ? '?' : 'c') != 'c') {
                GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).PlaceComponentResult((int) R.drawable.avatar_placeholder).MyBillsEntityDataFactory(this.profileView.getUserProfileImageView());
                this.profileView.stopRefreshAnimation();
            }
        }
        int i3 = getSupportButtonTintMode + 41;
        getCallingPid = i3 % 128;
        int i4 = i3 % 2;
    }

    private void VerifyPinStateManager$executeRiskChallenge$2$2() {
        SkeletonScreen skeletonScreen;
        int i = getCallingPid + 83;
        getSupportButtonTintMode = i % 128;
        if (i % 2 == 0) {
            skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            int i2 = 55 / 0;
            if (skeletonScreen == null) {
                return;
            }
        } else {
            skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda3;
            if (skeletonScreen == null) {
                return;
            }
        }
        skeletonScreen.PlaceComponentResult();
        this.NetworkUserEntityData$$ExternalSyntheticLambda3 = null;
        int i3 = getSupportButtonTintMode + 43;
        getCallingPid = i3 % 128;
        int i4 = i3 % 2;
    }

    private void G() {
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = new MyProfileDiffutilAdapter();
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = myProfileDiffutilAdapter;
        myProfileDiffutilAdapter.PlaceComponentResult = new GroupedSettingItemClickListener() { // from class: id.dana.myprofile.MyProfileFragment.10
            {
                MyProfileFragment.this = this;
            }

            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public void onItemClick(int i) {
                SettingModel empty;
                MyProfileDiffutilAdapter authRequestContext = MyProfileFragment.getAuthRequestContext(MyProfileFragment.this);
                if (authRequestContext.MyBillsEntityDataFactory(i)) {
                    empty = authRequestContext.getAuthRequestContext.moveToNextValue.get(i);
                } else {
                    empty = SettingModel.empty();
                }
                MyProfileFragment.MyBillsEntityDataFactory(MyProfileFragment.this, empty);
            }

            @Override // id.dana.myprofile.mepagerevamp.GroupedSettingItemClickListener
            public final void getAuthRequestContext(SettingModel settingModel) {
                MyProfileFragment.MyBillsEntityDataFactory(MyProfileFragment.this, settingModel);
            }
        };
        int i = getCallingPid + 19;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x006b, code lost:
    
        if (r0 != 'c') goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0107, code lost:
    
        if (r0 != 'A') goto L231;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void lookAheadTest(id.dana.domain.profilemenu.model.SettingModel r11) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.lookAheadTest(id.dana.domain.profilemenu.model.SettingModel):void");
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda3() {
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        ArrayList arrayList = new ArrayList(myProfileDiffutilAdapter.getAuthRequestContext.moveToNextValue);
        arrayList.remove(0);
        myProfileDiffutilAdapter.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(arrayList, null);
        this.myProfilePresenter.MyBillsEntityDataFactory(true);
        int i = getCallingPid + 9;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda8() {
        try {
            int i = getCallingPid + 35;
            try {
                getSupportButtonTintMode = i % 128;
                if ((i % 2 == 0 ? '1' : 'M') != '1') {
                    startActivity(getIntentClassWithTracking(RedeemPromoCodeActivity.class, "Me Page"));
                } else {
                    startActivity(getIntentClassWithTracking(RedeemPromoCodeActivity.class, "Me Page"));
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                int i2 = getSupportButtonTintMode + 1;
                getCallingPid = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void isLayoutRequested() {
        HashMap hashMap = new HashMap();
        hashMap.put("source", TrackerKey.SourceType.PROFILE_PAGE);
        FeatureSaving.BuiltInFictitiousFunctionClassFactory(requireActivity(), hashMap);
        int i = getCallingPid + 11;
        getSupportButtonTintMode = i % 128;
        if (!(i % 2 != 0)) {
            Object obj = null;
            obj.hashCode();
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda1() {
        int i = getCallingPid + 91;
        getSupportButtonTintMode = i % 128;
        if ((i % 2 == 0 ? (char) 11 : 'C') != 'C') {
            try {
                try {
                    FamilyStatusActionUtil.getAuthRequestContext(getContext(), this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.dynamicUrlWrapper);
                    Object[] objArr = null;
                    int length = objArr.length;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            FamilyStatusActionUtil.getAuthRequestContext(getContext(), this.scheduleImpl, this.NetworkUserEntityData$$ExternalSyntheticLambda7, this.dynamicUrlWrapper);
        }
        int i2 = getCallingPid + 23;
        getSupportButtonTintMode = i2 % 128;
        int i3 = i2 % 2;
    }

    private void DatabaseTableConfigUtil() {
        startActivity(new Intent(getBaseActivity(), MyBillsActivity.class));
        int i = getSupportButtonTintMode + 35;
        getCallingPid = i % 128;
        int i2 = i % 2;
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda7() {
        startActivity(new Intent("android.intent.action.VIEW").setClassName(getBaseActivity().getPackageName(), "id.dana.mybills.ui.v2.MyBillsHomeActivity"));
        int i = getSupportButtonTintMode + 67;
        getCallingPid = i % 128;
        if ((i % 2 != 0 ? 'P' : 'V') != 'P') {
            return;
        }
        int i2 = 34 / 0;
    }

    private void getAuthRequestContext(SettingModel settingModel) {
        try {
            Intent intent = new Intent(getBaseActivity(), SettingMoreProfileActivity.class);
            intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
            startActivity(intent);
            int i = getCallingPid + 39;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void initRecordTimeStamp() {
        Object[] objArr = null;
        new MaterialDialog(requireContext(), MaterialDialog.getDEFAULT_BEHAVIOR()).message(Integer.valueOf((int) R.string.logout_dialog_message), null, null).positiveButton(Integer.valueOf((int) R.string.dialog_positive), null, new Function1() { // from class: id.dana.myprofile.MyProfileFragment$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MaterialDialog materialDialog = (MaterialDialog) obj;
                return MyProfileFragment.this.moveToNextValue();
            }
        }).negativeButton(Integer.valueOf((int) R.string.dialog_negative), null, null).show();
        int i = getCallingPid + 51;
        getSupportButtonTintMode = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        int length = objArr.length;
    }

    public final /* synthetic */ Unit moveToNextValue() {
        int i = getCallingPid + 89;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        this.myProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda5();
        int i3 = getCallingPid + 95;
        getSupportButtonTintMode = i3 % 128;
        int i4 = i3 % 2;
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x001f, code lost:
    
        if ((r0 != null ? '8' : 'Q') != '8') goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x002d, code lost:
    
        if ((getActivity() != null) != true) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0030, code lost:
    
        r0 = id.dana.myprofile.MyProfileFragment.getCallingPid + 115;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x003a, code lost:
    
        if ((r0 % 2) != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x003c, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x003d, code lost:
    
        if (r1 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x003f, code lost:
    
        id.dana.productpage.ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r5.productPageManager, getActivity(), r5.dynamicUrlWrapper.getKycFromProfileUrl());
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x004e, code lost:
    
        r2.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0054, code lost:
    
        id.dana.productpage.ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r5.productPageManager, getActivity(), r5.dynamicUrlWrapper.getKycFromProfileUrl());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0063, code lost:
    
        r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode + 107;
        id.dana.myprofile.MyProfileFragment.getCallingPid = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x006d, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void SummaryVoucherView$$ExternalSyntheticLambda0() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L24
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            r2.hashCode()     // Catch: java.lang.Throwable -> L22
            r4 = 56
            if (r0 == 0) goto L1d
            r0 = 56
            goto L1f
        L1d:
            r0 = 81
        L1f:
            if (r0 == r4) goto L30
            goto L63
        L22:
            r0 = move-exception
            throw r0
        L24:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            if (r0 == 0) goto L2c
            r0 = 1
            goto L2d
        L2c:
            r0 = 0
        L2d:
            if (r0 == r3) goto L30
            goto L63
        L30:
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r0 = r0 + 115
            int r4 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r4
            int r0 = r0 % 2
            if (r0 != 0) goto L3d
            r1 = 1
        L3d:
            if (r1 == 0) goto L54
            id.dana.lib.bio.productpage.ProductPageManager r0 = r5.productPageManager
            androidx.fragment.app.FragmentActivity r1 = r5.getActivity()
            id.dana.data.dynamicurl.DynamicUrlWrapper r3 = r5.dynamicUrlWrapper
            java.lang.String r3 = r3.getKycFromProfileUrl()
            id.dana.productpage.ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1, r3)
            r2.hashCode()     // Catch: java.lang.Throwable -> L52
            goto L63
        L52:
            r0 = move-exception
            throw r0
        L54:
            id.dana.lib.bio.productpage.ProductPageManager r0 = r5.productPageManager
            androidx.fragment.app.FragmentActivity r1 = r5.getActivity()
            id.dana.data.dynamicurl.DynamicUrlWrapper r2 = r5.dynamicUrlWrapper
            java.lang.String r2 = r2.getKycFromProfileUrl()
            id.dana.productpage.ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r0, r1, r2)
        L63:
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r0 = r0 + 107
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.SummaryVoucherView$$ExternalSyntheticLambda0():void");
    }

    private void PrepareContext() {
        int i = getCallingPid + 69;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        startActivity(getIntentClassWithTracking(MissionListActivity.class, "Me Page"));
        int i3 = getSupportButtonTintMode + 113;
        getCallingPid = i3 % 128;
        int i4 = i3 % 2;
    }

    private static void O() {
        int i = getSupportButtonTintMode + 3;
        getCallingPid = i % 128;
        int i2 = i % 2;
        DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(DanaUrl.TERMS_AND_CONDITION));
        int i3 = getCallingPid + 45;
        getSupportButtonTintMode = i3 % 128;
        int i4 = i3 % 2;
    }

    private void newProxyInstance() {
        int i = getSupportButtonTintMode + 119;
        getCallingPid = i % 128;
        int i2 = i % 2;
        this.myProfilePresenter.BuiltInFictitiousFunctionClassFactory();
        try {
            int i3 = getSupportButtonTintMode + 9;
            getCallingPid = i3 % 128;
            if (i3 % 2 == 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(SettingModel settingModel) {
        try {
            int i = getSupportButtonTintMode + 39;
            getCallingPid = i % 128;
            int i2 = i % 2;
            try {
                if (settingModel.getName().equals("setting_kyb")) {
                    BuiltInFictitiousFunctionClassFactory(settingModel);
                } else if (settingModel.getName().equals("setting_tnc")) {
                    O();
                } else {
                    if ((settingModel.getName().equals("setting_aku") ? (char) 16 : 'M') == 16) {
                        int i3 = getCallingPid + 65;
                        getSupportButtonTintMode = i3 % 128;
                        int i4 = i3 % 2;
                        NetworkUserEntityData$$ExternalSyntheticLambda0(settingModel);
                        return;
                    }
                    if ((settingModel.getName().equals(MyProfileMenuCategories.LOAN_PERSONAL_FEATURE) ? 'W' : '\f') != '\f') {
                        this.bottomSheetOnBoardingPresenter.PlaceComponentResult("loan_personal", settingModel.getRedirectUrl());
                    } else if (settingModel.getName().equals("setting_my_bills")) {
                        this.bottomSheetOnBoardingPresenter.PlaceComponentResult("my_bills", ProfileServicesUrlMapper.MyBillsEntityDataFactory(settingModel.getRedirectUrl()));
                    } else {
                        if (!(!settingModel.getName().equals("setting_investment"))) {
                            int i5 = getSupportButtonTintMode + 73;
                            getCallingPid = i5 % 128;
                            if (!(i5 % 2 == 0)) {
                                PlaceComponentResult(settingModel);
                                int i6 = 61 / 0;
                                return;
                            }
                            PlaceComponentResult(settingModel);
                            return;
                        }
                        NetworkUserEntityData$$ExternalSyntheticLambda1(settingModel.getRedirectUrl());
                        int i7 = getCallingPid + 103;
                        getSupportButtonTintMode = i7 % 128;
                        int i8 = i7 % 2;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void PlaceComponentResult(SettingModel settingModel) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("https://m.dana.id");
            sb.append(settingModel.getRedirectUrl());
            DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(sb.toString()), FragmentBottomSheetPaymentSettingBinding());
            int i = getSupportButtonTintMode + 69;
            getCallingPid = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void BuiltInFictitiousFunctionClassFactory(SettingModel settingModel) {
        if ((settingModel.isKycRevoked() ? ':' : '\r') != ':') {
            NetworkUserEntityData$$ExternalSyntheticLambda1(settingModel.getRedirectUrl());
            try {
                int i = getSupportButtonTintMode + 51;
                try {
                    getCallingPid = i % 128;
                    if ((i % 2 != 0 ? JSONLexer.EOI : (char) 20) != 20) {
                        Object[] objArr = null;
                        int length = objArr.length;
                        return;
                    }
                    return;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i2 = getSupportButtonTintMode + 117;
        getCallingPid = i2 % 128;
        int i3 = i2 % 2;
        K();
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda1(String str) {
        int i = getSupportButtonTintMode + 103;
        getCallingPid = i % 128;
        if (i % 2 != 0) {
            try {
                try {
                    DanaH5.startContainerFullUrl(moveToNextValue(UrlUtil.getAuthRequestContext(str)), FragmentBottomSheetPaymentSettingBinding());
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        } else {
            DanaH5.startContainerFullUrl(moveToNextValue(UrlUtil.getAuthRequestContext(str)), FragmentBottomSheetPaymentSettingBinding());
        }
        int i2 = getSupportButtonTintMode + 35;
        getCallingPid = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 9 / 0;
        }
    }

    private static String moveToNextValue(String str) {
        int i = getCallingPid + 57;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 4, new int[]{1473949296, -281539843, -1800062038, -603724219}, objArr);
        if (!(str.contains(((String) objArr[0]).intern()) ? false : true)) {
            String D = D();
            int i3 = getSupportButtonTintMode + 97;
            getCallingPid = i3 % 128;
            int i4 = i3 % 2;
            return D;
        }
        return str;
    }

    private static String D() {
        int i = getCallingPid + 9;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            String MyBillsEntityDataFactory2 = TagFormat.MyBillsEntityDataFactory("https://m.dana.id/m/portal/topup?entryPoint={entryPoint}").MyBillsEntityDataFactory("entryPoint", TopupSource.PROFILE_PAGE).MyBillsEntityDataFactory();
            try {
                int i3 = getSupportButtonTintMode + 103;
                getCallingPid = i3 % 128;
                if ((i3 % 2 != 0 ? (char) 18 : ')') != 18) {
                    return MyBillsEntityDataFactory2;
                }
                Object obj = null;
                obj.hashCode();
                return MyBillsEntityDataFactory2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void NetworkUserEntityData$$ExternalSyntheticLambda0(SettingModel settingModel) {
        Bundle bundle = new Bundle();
        try {
            bundle.putString("url", DanaH5.correctedUrl(UrlUtil.getAuthRequestContext(UrlUtil.getAuthRequestContext(settingModel.getRedirectUrl()), "Me Page")));
            bundle.putString(DanaH5Key.Param.ADJUSTRESIZE, "YES");
            DanaH5.startContainerActivity(bundle, FragmentBottomSheetPaymentSettingBinding());
            int i = getSupportButtonTintMode + 63;
            getCallingPid = i % 128;
            if (i % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(SettingModel settingModel, String str, String str2) {
        int i = getCallingPid + 11;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        if ((settingModel != null ? '=' : '8') != '=') {
            return;
        }
        int i3 = getSupportButtonTintMode + 1;
        getCallingPid = i3 % 128;
        if ((i3 % 2 != 0 ? '5' : '.') != '.') {
            settingModel.setIncome(str);
            settingModel.setCurrency(str2);
            this.NetworkUserEntityData$$ExternalSyntheticLambda8.notifyDataSetChanged();
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            settingModel.setIncome(str);
            settingModel.setCurrency(str2);
            try {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.notifyDataSetChanged();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void getAuthRequestContext(SettingModel settingModel, String str, String str2) {
        int i = getSupportButtonTintMode + 79;
        getCallingPid = i % 128;
        int i2 = i % 2;
        if ((settingModel != null ? 'W' : 'D') != 'W') {
            return;
        }
        int i3 = getSupportButtonTintMode + 125;
        getCallingPid = i3 % 128;
        if (!(i3 % 2 != 0)) {
            try {
                settingModel.setExpense(str);
                settingModel.setCurrency(str2);
                this.NetworkUserEntityData$$ExternalSyntheticLambda8.notifyDataSetChanged();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        settingModel.setExpense(str);
        settingModel.setCurrency(str2);
        this.NetworkUserEntityData$$ExternalSyntheticLambda8.notifyDataSetChanged();
        int i4 = 92 / 0;
    }

    private DanaH5Listener FragmentBottomSheetPaymentSettingBinding() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.myprofile.MyProfileFragment.11
            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerCreated(Bundle bundle) {
            }

            {
                MyProfileFragment.this = this;
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerDestroyed(Bundle bundle) {
                MyProfileFragment.MyBillsEntityDataFactory(MyProfileFragment.this);
                MyProfileFragment.BuiltInFictitiousFunctionClassFactory(MyProfileFragment.this);
                MyProfileFragment.PlaceComponentResult(MyProfileFragment.this);
            }
        };
        int i = getCallingPid + 93;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        return danaH5Listener;
    }

    private DanaH5Listener getSupportButtonTintMode() {
        DanaH5Listener danaH5Listener = new DanaH5Listener() { // from class: id.dana.myprofile.MyProfileFragment.12
            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerCreated(Bundle bundle) {
            }

            {
                MyProfileFragment.this = this;
            }

            @Override // id.dana.utils.danah5.DanaH5Listener
            public void onContainerDestroyed(Bundle bundle) {
                MyProfileFragment.NetworkUserEntityData$$ExternalSyntheticLambda0(MyProfileFragment.this);
            }
        };
        try {
            int i = getSupportButtonTintMode + 109;
            try {
                getCallingPid = i % 128;
                int i2 = i % 2;
                return danaH5Listener;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    @OnClick({R.id.btn_verify})
    public void onKycClick(View view) {
        try {
            int i = getCallingPid + 75;
            getSupportButtonTintMode = i % 128;
            char c = i % 2 == 0 ? ')' : 'Z';
            Q();
            if (c == ')') {
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = getSupportButtonTintMode + 113;
            getCallingPid = i2 % 128;
            if (i2 % 2 == 0) {
                return;
            }
            int i3 = 75 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    private void Q() {
        StringBuilder sb = new StringBuilder();
        sb.append("https://m.dana.id");
        sb.append(this.dynamicUrlWrapper.getKycFromProfileUrl());
        NetworkUserEntityData$$ExternalSyntheticLambda1(sb.toString());
        int i = getSupportButtonTintMode + 119;
        getCallingPid = i % 128;
        int i2 = i % 2;
    }

    private void K() {
        int i = getSupportButtonTintMode + 123;
        getCallingPid = i % 128;
        if (!(i % 2 != 0)) {
            NetworkUserEntityData$$ExternalSyntheticLambda1("https://m.dana.id/m/kyb?entryPoint=profile");
            return;
        }
        NetworkUserEntityData$$ExternalSyntheticLambda1("https://m.dana.id/m/kyb?entryPoint=profile");
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0023, code lost:
    
        if ((r5.NetworkUserEntityData$$ExternalSyntheticLambda8.getItemViewType(1) == 100 ? 'L' : 1) != 'L') goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean getNameOrBuilderList() {
        /*
            r5 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r0 = r0 + 67
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r1
            int r0 = r0 % 2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            if (r0 == 0) goto L27
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8
            int r0 = r0.getItemViewType(r2)
            r1 = 100
            r3 = 76
            if (r0 != r1) goto L22
            r0 = 76
            goto L23
        L22:
            r0 = 1
        L23:
            if (r0 == r3) goto L3a
        L25:
            r1 = 1
            goto L4f
        L27:
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L50
            int r0 = r0.getItemViewType(r1)     // Catch: java.lang.Exception -> L50
            r3 = 13
            r4 = 70
            if (r0 != r3) goto L36
            r0 = 60
            goto L38
        L36:
            r0 = 70
        L38:
            if (r0 == r4) goto L4f
        L3a:
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid     // Catch: java.lang.Exception -> L50
            int r0 = r0 + 29
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1     // Catch: java.lang.Exception -> L50
            int r0 = r0 % 2
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r0 = r0 + 11
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            goto L25
        L4f:
            return r1
        L50:
            r0 = move-exception
            goto L53
        L52:
            throw r0
        L53:
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.getNameOrBuilderList():boolean");
    }

    private Target readMicros() {
        if (getContext() == null) {
            int i = getCallingPid + 21;
            getSupportButtonTintMode = i % 128;
            if (i % 2 == 0) {
                int i2 = 62 / 0;
                return null;
            }
            return null;
        }
        RecyclerView recyclerView = this.rvProfileSetting;
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = recyclerView != null ? recyclerView.findViewHolderForLayoutPosition(0) : null;
        if (findViewHolderForLayoutPosition == null) {
            return null;
        }
        View findViewById = findViewHolderForLayoutPosition.itemView.findViewById(R.id.vg_profile_completion_container);
        if (!(findViewById == null)) {
            Drawable BuiltInFictitiousFunctionClassFactory = ResourcesCompat.BuiltInFictitiousFunctionClassFactory(requireContext().getResources(), R.drawable.red_dot, null);
            String string = getString(R.string.lbl_profile_completion_tooltip_message);
            int indexOf = string.indexOf(42);
            int indexOf2 = string.indexOf(41);
            SpannableString spannableString = new SpannableString(string);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                BuiltInFictitiousFunctionClassFactory.setBounds(0, 0, 16, 16);
                spannableString.setSpan(new ImageSpan(BuiltInFictitiousFunctionClassFactory, 1), indexOf, indexOf2, 33);
            }
            TargetBuilder BuiltInFictitiousFunctionClassFactory2 = new TargetBuilder(getActivity()).BuiltInFictitiousFunctionClassFactory(findViewById);
            float f = NetworkUserEntityData$$ExternalSyntheticLambda0;
            int i3 = PlaceComponentResult;
            return BuiltInFictitiousFunctionClassFactory2.BuiltInFictitiousFunctionClassFactory(new RectangleShape(findViewById, f, f, i3, i3, i3, i3)).getAuthRequestContext(new Content(getString(R.string.lbl_profile_completion_tooltip_title), spannableString)).KClassImpl$Data$declaredNonStaticMembers$2();
        }
        int i4 = getCallingPid + 5;
        getSupportButtonTintMode = i4 % 128;
        if (i4 % 2 == 0) {
            int i5 = 73 / 0;
        }
        return null;
    }

    private void BuiltInFictitiousFunctionClassFactory(Target target) {
        try {
            int i = getSupportButtonTintMode + 95;
            getCallingPid = i % 128;
            if (!(i % 2 == 0)) {
                Object[] objArr = null;
                int length = objArr.length;
                if (target == null) {
                    return;
                }
            } else if (target == null) {
                return;
            }
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda4 == null) {
                SimpleShowcaseBuilder simpleShowcaseBuilder = new SimpleShowcaseBuilder(getBaseActivity());
                simpleShowcaseBuilder.NetworkUserEntityData$$ExternalSyntheticLambda2 = target;
                this.NetworkUserEntityData$$ExternalSyntheticLambda4 = simpleShowcaseBuilder.BuiltInFictitiousFunctionClassFactory(SizeUtil.getAuthRequestContext(16)).BuiltInFictitiousFunctionClassFactory(false).BuiltInFictitiousFunctionClassFactory(new AbstractOnShowcaseStateListener() { // from class: id.dana.myprofile.MyProfileFragment.13
                    {
                        MyProfileFragment.this = this;
                    }

                    @Override // id.dana.showcase.AbstractOnShowcaseStateListener, id.dana.showcase.OnShowcaseStateListener
                    public void onFinished(int i2) {
                        MyProfileFragment.moveToNextValue(MyProfileFragment.this);
                        MyProfileFragment.scheduleImpl(MyProfileFragment.this);
                        MyProfileFragment.this.myProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda6();
                    }
                }).PlaceComponentResult();
                int i2 = getSupportButtonTintMode + 61;
                getCallingPid = i2 % 128;
                int i3 = i2 % 2;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void initRecordTimeStamp(String str) {
        Object[] objArr = null;
        if (str.equals(getString(R.string.profile_completion_task_email))) {
            int i = getCallingPid + 123;
            getSupportButtonTintMode = i % 128;
            if ((i % 2 == 0 ? '*' : '2') == '2') {
                DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext("/m/portal/emailSettings"), getSupportButtonTintMode());
                return;
            }
            DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext("/m/portal/emailSettings"), getSupportButtonTintMode());
            int length = objArr.length;
            return;
        }
        if ((str.equals(getString(R.string.profile_completion_task_username)) ? '\'' : '@') != '@') {
            int i2 = getSupportButtonTintMode + 27;
            getCallingPid = i2 % 128;
            int i3 = i2 % 2;
            J();
            return;
        }
        if (!(!str.equals(getString(R.string.profile_completion_task_security_question)))) {
            if (getActivity() != null) {
                ProductPageManagerExtKt.BuiltInFictitiousFunctionClassFactory(this.productPageManager, getActivity());
            }
        } else if (str.equals(getString(R.string.profile_completion_task_nickname))) {
            int i4 = getSupportButtonTintMode + 5;
            getCallingPid = i4 % 128;
            if (i4 % 2 != 0) {
                DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(DanaUrl.CHANGE_NAME), getSupportButtonTintMode());
                objArr.hashCode();
            } else {
                DanaH5.startContainerFullUrl(UrlUtil.getAuthRequestContext(DanaUrl.CHANGE_NAME), getSupportButtonTintMode());
            }
            int i5 = getSupportButtonTintMode + 81;
            getCallingPid = i5 % 128;
            int i6 = i5 % 2;
        }
    }

    private void AppCompatEmojiTextHelper() {
        FragmentPermissionRequest.Builder builder = new FragmentPermissionRequest.Builder(this);
        String[] strArr = {"android.permission.CAMERA"};
        Intrinsics.checkNotNullParameter(strArr, "");
        builder.getAuthRequestContext = ArraysKt.toSet(strArr);
        PermissionCallback permissionCallback = new PermissionCallback() { // from class: id.dana.myprofile.MyProfileFragment$$ExternalSyntheticLambda1
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                MyProfileFragment.this.KClassImpl$Data$declaredNonStaticMembers$2(permissionResult);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback, "");
        builder.BuiltInFictitiousFunctionClassFactory = permissionCallback;
        this.lookAheadTest = builder.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder2 = new FragmentPermissionRequest.Builder(this);
        String[] strArr2 = {"android.permission.WRITE_EXTERNAL_STORAGE"};
        Intrinsics.checkNotNullParameter(strArr2, "");
        builder2.getAuthRequestContext = ArraysKt.toSet(strArr2);
        PermissionCallback permissionCallback2 = new PermissionCallback() { // from class: id.dana.myprofile.MyProfileFragment$$ExternalSyntheticLambda2
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                MyProfileFragment.this.getAuthRequestContext(permissionResult);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback2, "");
        builder2.BuiltInFictitiousFunctionClassFactory = permissionCallback2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda5 = builder2.PlaceComponentResult();
        FragmentPermissionRequest.Builder builder3 = new FragmentPermissionRequest.Builder(this);
        String[] strArr3 = {"android.permission.CALL_PHONE"};
        Intrinsics.checkNotNullParameter(strArr3, "");
        builder3.getAuthRequestContext = ArraysKt.toSet(strArr3);
        PermissionCallback permissionCallback3 = new PermissionCallback() { // from class: id.dana.myprofile.MyProfileFragment$$ExternalSyntheticLambda3
            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onDisplayConsentDialog(PermissionRequest permissionRequest) {
                PermissionCallback.CC.getAuthRequestContext(permissionRequest);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final void onPermissionsChecked(PermissionResult permissionResult, boolean z) {
                MyProfileFragment.this.PlaceComponentResult(permissionResult);
            }

            @Override // com.anggrayudi.storage.permission.PermissionCallback
            public final /* synthetic */ void onShouldRedirectToSystemSettings(List list) {
                PermissionCallback.CC.BuiltInFictitiousFunctionClassFactory(list);
            }
        };
        Intrinsics.checkNotNullParameter(permissionCallback3, "");
        builder3.BuiltInFictitiousFunctionClassFactory = permissionCallback3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = builder3.PlaceComponentResult();
        try {
            int i = getCallingPid + 113;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(PermissionResult permissionResult) {
        try {
            if (!permissionResult.MyBillsEntityDataFactory()) {
                return;
            }
            int i = getCallingPid + 51;
            getSupportButtonTintMode = i % 128;
            if (i % 2 == 0) {
                try {
                    this.initRecordTimeStamp.getAuthRequestContext();
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            } else {
                this.initRecordTimeStamp.getAuthRequestContext();
            }
            int i2 = getSupportButtonTintMode + 65;
            getCallingPid = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final /* synthetic */ void getAuthRequestContext(PermissionResult permissionResult) {
        if ((permissionResult.MyBillsEntityDataFactory() ? '#' : '\r') == '#') {
            try {
                int i = getSupportButtonTintMode + 61;
                getCallingPid = i % 128;
                int i2 = i % 2;
                this.lookAheadTest.check();
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = getSupportButtonTintMode + 41;
        getCallingPid = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public final /* synthetic */ void PlaceComponentResult(PermissionResult permissionResult) {
        try {
            int i = getCallingPid + 53;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
            if (!(permissionResult.MyBillsEntityDataFactory())) {
                return;
            }
            try {
                int i3 = getSupportButtonTintMode + 29;
                getCallingPid = i3 % 128;
                int i4 = i3 % 2;
                PhoneCall.KClassImpl$Data$declaredNonStaticMembers$2(getBaseActivity(), "1500445", true);
                int i5 = getSupportButtonTintMode + 117;
                getCallingPid = i5 % 128;
                int i6 = i5 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void M() {
        Intent intent;
        int i = getSupportButtonTintMode + 27;
        getCallingPid = i % 128;
        int i2 = i % 2;
        if (this.GetContactSyncConfig) {
            intent = new Intent(getBaseActivity(), ProfileQrisDialogActivity.class);
            int i3 = getCallingPid + 41;
            getSupportButtonTintMode = i3 % 128;
            int i4 = i3 % 2;
        } else {
            intent = new Intent(getBaseActivity(), ShareQrDialog.class);
        }
        intent.putExtra("USER_ID", this.myProfilePresenter.NetworkUserEntityData$$ExternalSyntheticLambda2());
        intent.putExtra("QR_CODE", this.PrepareContext);
        intent.putExtra(ShareQrDialog.KYC_STATUS, this.myProfilePresenter.getFragmentBottomSheetPaymentSettingBinding());
        intent.putExtra(ShareQrDialog.AVATAR_URL, this.myProfilePresenter.getErrorConfigVersion());
        intent.setFlags(536870912);
        startActivity(intent);
    }

    private void J() {
        startActivity(new Intent(getBaseActivity(), ChangeUsernameActivity.class));
        int i = getSupportButtonTintMode + 57;
        getCallingPid = i % 128;
        int i2 = i % 2;
    }

    private boolean NetworkUserEntityData$$ExternalSyntheticLambda4() {
        int i = getCallingPid + 93;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        try {
            SimpleProfileWithQrView simpleProfileWithQrView = this.profileView;
            try {
                if (simpleProfileWithQrView != null) {
                    if ((simpleProfileWithQrView.getUserProfileImageView() != null ? (char) 23 : '/') == 23) {
                        int i3 = getSupportButtonTintMode + 105;
                        getCallingPid = i3 % 128;
                        boolean z = (i3 % 2 != 0 ? ')' : 'J') != ')';
                        int i4 = getCallingPid + 51;
                        getSupportButtonTintMode = i4 % 128;
                        int i5 = i4 % 2;
                        return z;
                    }
                }
                int i6 = getCallingPid + 57;
                getSupportButtonTintMode = i6 % 128;
                int i7 = i6 % 2;
                return false;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void N() {
        try {
            startActivity(new Intent(getBaseActivity(), MerchantManagementActivity.class));
            int i = getCallingPid + 111;
            getSupportButtonTintMode = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static List<SettingModel> MyBillsEntityDataFactory(List<SettingModel> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (!(i < list.size())) {
                return arrayList;
            }
            SettingModel settingModel = list.get(i);
            if (!settingModel.isNullObject()) {
                if (("setting_family_account".equals(settingModel.getName()) ? 'D' : '5') != '5') {
                    int i2 = getCallingPid + 1;
                    getSupportButtonTintMode = i2 % 128;
                    int i3 = i2 % 2;
                    try {
                        settingModel.setPosition(i);
                        try {
                            arrayList.add(settingModel);
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }
            }
            i++;
            int i4 = getCallingPid + 53;
            getSupportButtonTintMode = i4 % 128;
            int i5 = i4 % 2;
        }
    }

    private void KClassImpl$Data$declaredNonStaticMembers$2(List<SettingModel> list) {
        List<SettingModel> MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(list);
        this.getErrorConfigVersion = MyBillsEntityDataFactory2;
        if ((MyBillsEntityDataFactory2.size() == 1 ? '8' : '=') == '8') {
            try {
                int i = getSupportButtonTintMode + 57;
                getCallingPid = i % 128;
                list.remove((i % 2 != 0 ? this.getErrorConfigVersion.get(1) : this.getErrorConfigVersion.get(0)).getPosition());
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        if (this.getErrorConfigVersion.size() != 2) {
            return;
        }
        list.remove(this.getErrorConfigVersion.get(0).getPosition());
        this.getErrorConfigVersion.get(1).setPosition(this.getErrorConfigVersion.get(1).getPosition() - 1);
        list.remove(this.getErrorConfigVersion.get(1).getPosition());
        int i2 = getSupportButtonTintMode + 57;
        getCallingPid = i2 % 128;
        int i3 = i2 % 2;
    }

    private SettingModel getValueOfTouchPositionAbsolute() {
        int i = getCallingPid + 39;
        getSupportButtonTintMode = i % 128;
        int i2 = i % 2;
        MyProfileDiffutilAdapter myProfileDiffutilAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int MyBillsEntityDataFactory2 = myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyProfileMenuAction.SETTING_STATEMENT);
        if ((myProfileDiffutilAdapter.MyBillsEntityDataFactory(MyBillsEntityDataFactory2) ? '\n' : 'c') != '\n') {
            return SettingModel.empty();
        }
        int i3 = getSupportButtonTintMode + 67;
        getCallingPid = i3 % 128;
        boolean z = i3 % 2 == 0;
        AsyncListDiffer<SettingModel> asyncListDiffer = myProfileDiffutilAdapter.getAuthRequestContext;
        if (!z) {
            SettingModel settingModel = asyncListDiffer.moveToNextValue.get(MyBillsEntityDataFactory2);
            int i4 = 55 / 0;
            return settingModel;
        }
        return asyncListDiffer.moveToNextValue.get(MyBillsEntityDataFactory2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x007d, code lost:
    
        r1 = 99 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x007e, code lost:
    
        if (id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CANNOT_CREATE.equalsIgnoreCase(r5.scheduleImpl.getStatus()) != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0083, code lost:
    
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0084, code lost:
    
        throw r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x008f, code lost:
    
        if (id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CANNOT_CREATE.equalsIgnoreCase(r5.scheduleImpl.getStatus()) != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0091, code lost:
    
        r5.myProfilePresenter.PlaceComponentResult(r5.getErrorConfigVersion.get(0), r7, false);
        r6 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8;
        r7 = r5.getErrorConfigVersion.get(0).getPosition();
        r1 = r5.getErrorConfigVersion.get(0);
        r2 = new java.util.ArrayList(r6.getAuthRequestContext.moveToNextValue);
        r2.add(r7, r1);
        r6.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(r2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00c5, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00c6, code lost:
    
        r5.myProfilePresenter.PlaceComponentResult(r5.getErrorConfigVersion.get(1), r7, false);
        r6 = r5.NetworkUserEntityData$$ExternalSyntheticLambda8;
        r7 = r5.getErrorConfigVersion.get(1).getPosition();
        r1 = r5.getErrorConfigVersion.get(1);
        r2 = new java.util.ArrayList(r6.getAuthRequestContext.moveToNextValue);
        r2.add(r7, r1);
        r6.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(r2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x00fa, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00ff, code lost:
    
        if (r6.isNullObject() != false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0101, code lost:
    
        r0 = id.dana.myprofile.MyProfileFragment.getCallingPid + 125;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0 % 128;
        r0 = r0 % 2;
        r5.myProfilePresenter.PlaceComponentResult(r6, r7, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x010f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0024, code lost:
    
        if ((r5.getErrorConfigVersion.size() != 2) != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0036, code lost:
    
        if ((r5.getErrorConfigVersion.size() != 4) != true) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x003e, code lost:
    
        if (r6.isNullObject() == false) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0040, code lost:
    
        r0 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0043, code lost:
    
        r0 = 'Y';
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0045, code lost:
    
        if (r0 == 'Y') goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0047, code lost:
    
        r6 = id.dana.myprofile.MyProfileFragment.getCallingPid + 9;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r6 % 128;
        r6 = r6 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x005c, code lost:
    
        if (id.dana.familyaccount.constants.FamilyStatusConsultConstant.HAS_NOT_FAMILY_ACCOUNT_CAN_CREATE.equalsIgnoreCase(r5.scheduleImpl.getStatus()) != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x005e, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0060, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0062, code lost:
    
        if (r6 == true) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0064, code lost:
    
        r6 = id.dana.myprofile.MyProfileFragment.getCallingPid + 97;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r6 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x006f, code lost:
    
        if ((r6 % 2) != 0) goto L107;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void getAuthRequestContext(id.dana.domain.profilemenu.model.SettingModel r6, id.dana.domain.familyaccount.model.ConsultFamilyAccountResult r7) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.getAuthRequestContext(id.dana.domain.profilemenu.model.SettingModel, id.dana.domain.familyaccount.model.ConsultFamilyAccountResult):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:244:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x05c8 A[Catch: Exception -> 0x0bf6, TRY_LEAVE, TryCatch #5 {Exception -> 0x0bf6, blocks: (B:275:0x0583, B:277:0x05c8), top: B:402:0x0583 }] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0761  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0770  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0a5e  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0a63  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0bd5  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0bd9  */
    @Override // id.dana.base.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init() {
        /*
            Method dump skipped, instructions count: 3150
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.init():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0035, code lost:
    
        if (r0.MyBillsEntityDataFactory(r1) != false) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x004b, code lost:
    
        if ((r2 ? ',' : 5) != 5) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x004d, code lost:
    
        r2 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode + 103;
        id.dana.myprofile.MyProfileFragment.getCallingPid = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0057, code lost:
    
        r0 = r0.getAuthRequestContext.moveToNextValue.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0062, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0063, code lost:
    
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0064, code lost:
    
        r0 = id.dana.domain.profilemenu.model.SettingModel.empty();
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void BuiltInFictitiousFunctionClassFactory(id.dana.domain.familyaccount.model.ConsultFamilyAccountResult r5) {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r0 = r0 + 63
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r1
            int r0 = r0 % 2
            r1 = 0
            if (r0 == 0) goto L17
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            r2 = 98
            int r2 = r2 / r1
            if (r0 == 0) goto L73
            goto L1b
        L15:
            r5 = move-exception
            throw r5
        L17:
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            if (r0 == 0) goto L73
        L1b:
            int r2 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r2 = r2 + 47
            int r3 = r2 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L28
            goto L29
        L28:
            r1 = 1
        L29:
            java.lang.String r2 = "setting_family_account"
            if (r1 == 0) goto L38
            int r1 = r0.MyBillsEntityDataFactory(r2)
            boolean r2 = r0.MyBillsEntityDataFactory(r1)
            if (r2 == 0) goto L64
            goto L4d
        L38:
            int r1 = r0.MyBillsEntityDataFactory(r2)
            boolean r2 = r0.MyBillsEntityDataFactory(r1)
            r3 = 0
            r3.hashCode()     // Catch: java.lang.Throwable -> L71
            r3 = 5
            if (r2 == 0) goto L4a
            r2 = 44
            goto L4b
        L4a:
            r2 = 5
        L4b:
            if (r2 == r3) goto L64
        L4d:
            int r2 = id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode
            int r2 = r2 + 103
            int r3 = r2 % 128
            id.dana.myprofile.MyProfileFragment.getCallingPid = r3
            int r2 = r2 % 2
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r0 = r0.getAuthRequestContext     // Catch: java.lang.Exception -> L62
            java.util.List<T> r0 = r0.moveToNextValue     // Catch: java.lang.Exception -> L62
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Exception -> L62
            id.dana.domain.profilemenu.model.SettingModel r0 = (id.dana.domain.profilemenu.model.SettingModel) r0     // Catch: java.lang.Exception -> L62
            goto L68
        L62:
            r5 = move-exception
            throw r5
        L64:
            id.dana.domain.profilemenu.model.SettingModel r0 = id.dana.domain.profilemenu.model.SettingModel.empty()
        L68:
            r4.getAuthRequestContext(r0, r5)
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            r5.notifyDataSetChanged()
            goto L73
        L71:
            r5 = move-exception
            throw r5
        L73:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.BuiltInFictitiousFunctionClassFactory(id.dana.domain.familyaccount.model.ConsultFamilyAccountResult):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0031, code lost:
    
        if (r0.MyBillsEntityDataFactory(r1) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x003e, code lost:
    
        if (r0.MyBillsEntityDataFactory(r1) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0040, code lost:
    
        r0 = r0.getAuthRequestContext.moveToNextValue.get(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x004b, code lost:
    
        r0 = id.dana.domain.profilemenu.model.SettingModel.empty();
        r1 = id.dana.myprofile.MyProfileFragment.getCallingPid + 71;
        id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1 % 128;
        r1 = r1 % 2;
     */
    @Override // id.dana.myprofile.MyProfileContract.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(id.dana.model.UserInfo r5) {
        /*
            r4 = this;
            int r0 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r0 = r0 + 37
            int r1 = r0 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r1
            int r0 = r0 % 2
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r0 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8
            r1 = 33
            if (r0 == 0) goto L13
            r2 = 12
            goto L15
        L13:
            r2 = 33
        L15:
            if (r2 == r1) goto L83
            int r1 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r1 = r1 + 103
            int r2 = r1 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r2
            int r1 = r1 % 2
            java.lang.String r2 = "setting_kyb"
            if (r1 != 0) goto L36
            int r1 = r0.MyBillsEntityDataFactory(r2)
            boolean r2 = r0.MyBillsEntityDataFactory(r1)
            r3 = 80
            int r3 = r3 / 0
            if (r2 == 0) goto L4b
            goto L40
        L34:
            r5 = move-exception
            throw r5
        L36:
            int r1 = r0.MyBillsEntityDataFactory(r2)
            boolean r2 = r0.MyBillsEntityDataFactory(r1)
            if (r2 == 0) goto L4b
        L40:
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r0 = r0.getAuthRequestContext
            java.util.List<T> r0 = r0.moveToNextValue
            java.lang.Object r0 = r0.get(r1)
            id.dana.domain.profilemenu.model.SettingModel r0 = (id.dana.domain.profilemenu.model.SettingModel) r0
            goto L59
        L4b:
            id.dana.domain.profilemenu.model.SettingModel r0 = id.dana.domain.profilemenu.model.SettingModel.empty()
            int r1 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r1 = r1 + 71
            int r2 = r1 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r2
            int r1 = r1 % 2
        L59:
            boolean r1 = r0.isNullObject()
            if (r1 == 0) goto L60
            return
        L60:
            id.dana.myprofile.MyProfileContract$Presenter r1 = r4.myProfilePresenter     // Catch: java.lang.Exception -> L81
            r1.getAuthRequestContext(r0, r5)     // Catch: java.lang.Exception -> L81
            id.dana.myprofile.adapter.MyProfileDiffutilAdapter r5 = r4.NetworkUserEntityData$$ExternalSyntheticLambda8     // Catch: java.lang.Exception -> L81
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r0 = r5.getAuthRequestContext     // Catch: java.lang.Exception -> L81
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> L81
            androidx.recyclerview.widget.AsyncListDiffer<id.dana.domain.profilemenu.model.SettingModel> r5 = r5.getAuthRequestContext     // Catch: java.lang.Exception -> L81
            java.util.List<T> r5 = r5.moveToNextValue     // Catch: java.lang.Exception -> L81
            r1.<init>(r5)     // Catch: java.lang.Exception -> L81
            r5 = 0
            r0.KClassImpl$Data$declaredNonStaticMembers$2(r1, r5)     // Catch: java.lang.Exception -> L81
            int r5 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r5 = r5 + 23
            int r0 = r5 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0
            int r5 = r5 % 2
            goto L83
        L81:
            r5 = move-exception
            throw r5
        L83:
            int r5 = id.dana.myprofile.MyProfileFragment.getCallingPid
            int r5 = r5 + 5
            int r0 = r5 % 128
            id.dana.myprofile.MyProfileFragment.getSupportButtonTintMode = r0
            int r5 = r5 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.MyProfileFragment.getAuthRequestContext(id.dana.model.UserInfo):void");
    }

    private static void b(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 11 : '`') == '`') {
                break;
            }
            int i2 = $11 + 113;
            $10 = i2 % 128;
            int i3 = i2 % 2;
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (readMicros ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i4 = $10 + 65;
        $11 = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 22 : (char) 3) != 22) {
                objArr[0] = new String(cArr2);
                return;
            }
            int i6 = $10 + 77;
            $11 = i6 % 128;
            int i7 = i6 % 2;
            try {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                try {
                    getonboardingscenario.getAuthRequestContext++;
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = SubSequence;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            int i2 = 0;
            while (true) {
                if ((i2 < length ? 'E' : '7') != 'E') {
                    break;
                }
                int i3 = $10 + 87;
                $11 = i3 % 128;
                if (i3 % 2 == 0) {
                    try {
                        iArr3[i2] = (int) (iArr2[i2] / (-3152031022165484798L));
                        i2 %= 0;
                    } catch (Exception e) {
                        throw e;
                    }
                } else {
                    iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
                    i2++;
                }
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = SubSequence;
        if (iArr5 != null) {
            int i4 = $10 + 5;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            for (int i6 = 0; i6 < length3; i6++) {
                iArr6[i6] = (int) (iArr5[i6] ^ (-3152031022165484798L));
            }
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        try {
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
                cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
                cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                int i7 = $10 + 1;
                $11 = i7 % 128;
                int i8 = i7 % 2;
                int i9 = 0;
                while (true) {
                    if (!(i9 < 16)) {
                        break;
                    }
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i9];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i10 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i10;
                    i9++;
                }
                int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i11;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
                int i14 = $11 + 15;
                $10 = i14 % 128;
                int i15 = i14 % 2;
            }
            objArr[0] = new String(cArr2, 0, i);
        } catch (Exception e2) {
            throw e2;
        }
    }
}
