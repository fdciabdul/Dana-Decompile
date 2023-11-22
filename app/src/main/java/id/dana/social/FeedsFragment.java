package id.dana.social;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.view.Lifecycle;
import androidx.viewpager2.widget.ViewPager2;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseFragment;
import id.dana.base.BaseWithToolbarFragment;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.myprofile.mepagerevamp.profilesettings.ProfileSettingsActivity;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.fragment.FriendsFeedsFragment;
import id.dana.social.fragment.MyFeedsFragment;
import id.dana.social.view.activity.ChangeUsernameActivity;
import id.dana.utils.ExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b1\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0015\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0003\u0010\u0019J!\u0010\u0006\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0006\u0010\u0019R-\u0010\u0006\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c¢\u0006\u0002\b\u001d0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010!R\u0012\u0010$\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\r\u0010&R\u0016\u0010\u0003\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b)\u0010&R\u0016\u0010)\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b*\u0010&R\u0012\u0010,\u001a\u00020+X\u0087\"¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b/\u00100"}, d2 = {"Lid/dana/social/FeedsFragment;", "Lid/dana/base/BaseWithToolbarFragment;", "", "PlaceComponentResult", "()V", "Landroidx/fragment/app/Fragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Landroidx/fragment/app/Fragment;", "", "getLayout", "()I", IAPSyncCommand.COMMAND_INIT, "", "MyBillsEntityDataFactory", "()Z", "Landroid/view/View;", "p0", "onClickLeftMenuButton", "(Landroid/view/View;)V", "onPause", "onResume", "onSelected", "onStart", "onUnSelected", "", "(Ljava/lang/String;)V", "p1", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "Ljava/util/List;", "Lid/dana/social/FeedsIntroduction;", "getErrorConfigVersion", "Lid/dana/social/FeedsIntroduction;", "getAuthRequestContext", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticsTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "Z", "BuiltInFictitiousFunctionClassFactory", "scheduleImpl", "lookAheadTest", "moveToNextValue", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "settingPresenter", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "Lid/dana/social/adapter/BaseTabFragmentAdapter;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/social/adapter/BaseTabFragmentAdapter;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FeedsFragment extends BaseWithToolbarFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;
    private id.dana.social.adapter.BaseTabFragmentAdapter NetworkUserEntityData$$ExternalSyntheticLambda0;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticsTracker;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private FeedsIntroduction getAuthRequestContext;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean lookAheadTest;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean PlaceComponentResult;
    @Inject
    public RelationshipBottomSheetContract.Presenter settingPresenter;
    public Map<Integer, View> PlaceComponentResult = new LinkedHashMap();
    public final List<Function1<FeedsFragment, Unit>> KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();

    @JvmStatic
    public static final FeedsFragment BuiltInFictitiousFunctionClassFactory(boolean z) {
        return Companion.MyBillsEntityDataFactory(z);
    }

    public final View PlaceComponentResult(int i) {
        View findViewById;
        Map<Integer, View> map = this.PlaceComponentResult;
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

    @Override // id.dana.base.BaseFragment
    public final int getLayout() {
        return R.layout.fragment_social_feed;
    }

    @Override // id.dana.base.BaseFragment
    public final void init() {
        FragmentActivity activity = getActivity();
        RelationshipBottomSheetContract.Presenter presenter = null;
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.DanaApplication");
        }
        Boolean isMePageRevamp = ((DanaApplication) application).getIsMePageRevamp();
        this.MyBillsEntityDataFactory = isMePageRevamp == null ? false : isMePageRevamp.booleanValue();
        Bundle arguments = getArguments();
        this.PlaceComponentResult = arguments != null ? arguments.getBoolean("feedRevampEnabled") : false;
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        if (socialCommonComponent != null) {
            socialCommonComponent.MyBillsEntityDataFactory(new RelationshipBottomSheetModule(new RelationshipBottomSheetContract.View() { // from class: id.dana.social.FeedsFragment$initComponent$1
                private static int $10 = 0;
                private static int $11 = 1;
                private static char[] BuiltInFictitiousFunctionClassFactory = {35500, 35576, 35572, 35577, 35578, 35579, 35583, 35580, 35575, 35577, 35577, 35566, 35573, 35570, 35562, 35572, 35581, 35572, 35573, 35568, 35562, 35570, 35570};
                private static int PlaceComponentResult = 1;
                private static int getAuthRequestContext;

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ String BuiltInFictitiousFunctionClassFactory() {
                    int i = getAuthRequestContext + 97;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    try {
                        String PlaceComponentResult2 = RelationshipBottomSheetContract.View.CC.PlaceComponentResult();
                        int i3 = getAuthRequestContext + 7;
                        try {
                            PlaceComponentResult = i3 % 128;
                            if (i3 % 2 != 0) {
                                return PlaceComponentResult2;
                            }
                            int i4 = 19 / 0;
                            return PlaceComponentResult2;
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory() {
                    int i = getAuthRequestContext + 85;
                    PlaceComponentResult = i % 128;
                    if (i % 2 == 0) {
                        RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory();
                        int i2 = 42 / 0;
                        return;
                    }
                    try {
                        RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory();
                    } catch (Exception e) {
                        throw e;
                    }
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(FeedConfig feedConfig) {
                    int i = PlaceComponentResult + 27;
                    getAuthRequestContext = i % 128;
                    char c = i % 2 != 0 ? (char) 27 : (char) 7;
                    Intrinsics.checkNotNullParameter(feedConfig, "");
                    if (c == 27) {
                        int i2 = 47 / 0;
                    }
                    int i3 = getAuthRequestContext + 81;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void PlaceComponentResult() {
                    try {
                        int i = getAuthRequestContext + 113;
                        try {
                            PlaceComponentResult = i % 128;
                            int i2 = i % 2;
                            RelationshipBottomSheetContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                            int i3 = PlaceComponentResult + 73;
                            getAuthRequestContext = i3 % 128;
                            if (!(i3 % 2 == 0)) {
                                int i4 = 32 / 0;
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    } catch (Exception e2) {
                        throw e2;
                    }
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void PlaceComponentResult(List list) {
                    int i = getAuthRequestContext + 83;
                    PlaceComponentResult = i % 128;
                    char c = i % 2 == 0 ? '\b' : (char) 22;
                    RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory(list);
                    if (c != 22) {
                        int i2 = 25 / 0;
                    }
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    int i = PlaceComponentResult + 91;
                    getAuthRequestContext = i % 128;
                    char c = i % 2 != 0 ? (char) 30 : 'R';
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                    if (c != 'R') {
                        int i2 = 5 / 0;
                    }
                    try {
                        int i3 = PlaceComponentResult + 63;
                        getAuthRequestContext = i3 % 128;
                        if (!(i3 % 2 == 0)) {
                            int i4 = 43 / 0;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void getAuthRequestContext(ModifyRelationOperationType modifyRelationOperationType) {
                    int i = PlaceComponentResult + 111;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    Intrinsics.checkNotNullParameter(modifyRelationOperationType, "");
                    int i3 = getAuthRequestContext + 85;
                    PlaceComponentResult = i3 % 128;
                    int i4 = i3 % 2;
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void getAuthRequestContext(List list) {
                    int i = getAuthRequestContext + 119;
                    PlaceComponentResult = i % 128;
                    if (!(i % 2 == 0)) {
                        RelationshipBottomSheetContract.View.CC.getAuthRequestContext(list);
                    } else {
                        try {
                            RelationshipBottomSheetContract.View.CC.getAuthRequestContext(list);
                            int i2 = 92 / 0;
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    int i3 = PlaceComponentResult + 65;
                    getAuthRequestContext = i3 % 128;
                    if (!(i3 % 2 != 0)) {
                        return;
                    }
                    int i4 = 23 / 0;
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    String authRequestContext;
                    int i = PlaceComponentResult + 25;
                    getAuthRequestContext = i % 128;
                    if ((i % 2 != 0 ? (char) 17 : (char) 30) != 30) {
                        authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                        int i2 = 82 / 0;
                    } else {
                        authRequestContext = AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                    }
                    int i3 = PlaceComponentResult + 103;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return authRequestContext;
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    int i = PlaceComponentResult + 47;
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                    try {
                        int i3 = PlaceComponentResult + 15;
                        getAuthRequestContext = i3 % 128;
                        int i4 = i3 % 2;
                    } catch (Exception e) {
                        throw e;
                    }
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    int i = PlaceComponentResult + 87;
                    getAuthRequestContext = i % 128;
                    if (!(i % 2 != 0)) {
                        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                        return;
                    }
                    try {
                        AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                        int i2 = 79 / 0;
                    } catch (Exception e) {
                        throw e;
                    }
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void BuiltInFictitiousFunctionClassFactory(SettingModel p0) {
                    int i = getAuthRequestContext + 77;
                    PlaceComponentResult = i % 128;
                    int i2 = i % 2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    String action = p0.getAction();
                    Object[] objArr = new Object[1];
                    a(new int[]{0, 23, 0, 0}, true, new byte[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0}, objArr);
                    if ((Intrinsics.areEqual(action, ((String) objArr[0]).intern()) ? 'M' : (char) 1) != 'M') {
                        FeedsFragment.getAuthRequestContext(FeedsFragment.this, p0);
                        int i3 = PlaceComponentResult + 103;
                        getAuthRequestContext = i3 % 128;
                        if (i3 % 2 != 0) {
                            int i4 = 88 / 0;
                            return;
                        }
                        return;
                    }
                    int i5 = getAuthRequestContext + 23;
                    PlaceComponentResult = i5 % 128;
                    if ((i5 % 2 == 0 ? '8' : '9') != '8') {
                        FeedsFragment.scheduleImpl(FeedsFragment.this);
                        return;
                    }
                    FeedsFragment.scheduleImpl(FeedsFragment.this);
                    int i6 = 36 / 0;
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void MyBillsEntityDataFactory(boolean p0) {
                    try {
                        int i = getAuthRequestContext + 97;
                        PlaceComponentResult = i % 128;
                        Object[] objArr = null;
                        if ((i % 2 == 0 ? '!' : 'U') != 'U') {
                            FeedsFragment.getAuthRequestContext(FeedsFragment.this, p0);
                            int length = objArr.length;
                        } else {
                            try {
                                FeedsFragment.getAuthRequestContext(FeedsFragment.this, p0);
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        int i2 = PlaceComponentResult + 23;
                        getAuthRequestContext = i2 % 128;
                        if (i2 % 2 == 0) {
                            return;
                        }
                        objArr.hashCode();
                    } catch (Exception e2) {
                        throw e2;
                    }
                }

                private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
                    char[] cArr;
                    VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                    int i = iArr[0];
                    int i2 = iArr[1];
                    int i3 = iArr[2];
                    int i4 = iArr[3];
                    char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
                    if ((cArr2 != null ? '\b' : 'W') == '\b') {
                        int length = cArr2.length;
                        char[] cArr3 = new char[length];
                        for (int i5 = 0; i5 < length; i5++) {
                            int i6 = $11 + 101;
                            $10 = i6 % 128;
                            int i7 = i6 % 2;
                            cArr3[i5] = (char) (cArr2[i5] ^ 5097613533456403102L);
                        }
                        cArr2 = cArr3;
                    }
                    char[] cArr4 = new char[i2];
                    System.arraycopy(cArr2, i, cArr4, 0, i2);
                    if (bArr != null) {
                        char[] cArr5 = new char[i2];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        char c = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                            int i8 = $10 + 25;
                            $11 = i8 % 128;
                            if (i8 % 2 != 0 ? bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] != 1 : bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] != 1) {
                                cArr5[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                            } else {
                                int i9 = $11 + 27;
                                $10 = i9 % 128;
                                int i10 = i9 % 2;
                                cArr5[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                            }
                            try {
                                c = cArr5[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                            } catch (Exception e) {
                                throw e;
                            }
                        }
                        cArr4 = cArr5;
                    }
                    if (i4 > 0) {
                        char[] cArr6 = new char[i2];
                        System.arraycopy(cArr4, 0, cArr6, 0, i2);
                        int i11 = i2 - i4;
                        System.arraycopy(cArr6, 0, cArr4, i11, i4);
                        System.arraycopy(cArr6, i4, cArr4, 0, i11);
                    }
                    if (z) {
                        int i12 = $11 + 45;
                        $10 = i12 % 128;
                        if (i12 % 2 == 0) {
                            cArr = new char[i2];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        } else {
                            cArr = new char[i2];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        }
                        while (true) {
                            if (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory >= i2) {
                                break;
                            }
                            cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i2 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                        cArr4 = cArr;
                    }
                    if (i3 > 0) {
                        int i13 = $10 + 111;
                        $11 = i13 % 128;
                        int i14 = i13 % 2;
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i2) {
                            int i15 = $11 + 109;
                            $10 = i15 % 128;
                            int i16 = i15 % 2;
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                    }
                    objArr[0] = new String(cArr4);
                }
            })).MyBillsEntityDataFactory(this);
        }
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        RelationshipBottomSheetContract.Presenter presenter2 = this.settingPresenter;
        if (presenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter2 = null;
        }
        abstractPresenterArr[0] = presenter2;
        registerPresenter(abstractPresenterArr);
        MyBillsEntityDataFactory(R.drawable.arrow_left_white);
        if (this.PlaceComponentResult) {
            String string = getString(R.string.feeds_tab_only_me);
            TextView textView = this.toolbarTitle;
            if (textView != null) {
                textView.setText(string);
            }
        } else {
            String string2 = getString(R.string.feeds_page_title);
            TextView textView2 = this.toolbarTitle;
            if (textView2 != null) {
                textView2.setText(string2);
            }
            int dimension = (int) getResources().getDimension(R.dimen.MyBillsEntityDataFactory_res_0x7f07005f);
            TextView textView3 = this.rightButton;
            if (textView3 != null) {
                textView3.setBackground(ContextCompat.PlaceComponentResult(requireContext(), (int) R.drawable.ic_tooltip_help));
                TextView textView4 = this.rightButton;
                if (textView4 != null) {
                    textView4.setEnabled(true);
                    this.rightButton.setVisibility(0);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rightButton.getLayoutParams();
                    layoutParams.setMargins(0, 0, dimension, 0);
                    this.rightButton.setLayoutParams(layoutParams);
                }
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) PlaceComponentResult(R.id.LTOMLengthOf);
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(0);
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.FeedsFragment$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedsFragment.BuiltInFictitiousFunctionClassFactory(FeedsFragment.this);
                    }
                });
                appCompatImageView.setContentDescription(appCompatImageView.getContext().getString(R.string.btnSetting));
            }
            Context context = getContext();
            if (context != null) {
                this.getAuthRequestContext = new FeedsIntroduction(context);
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.social.FeedsFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2(FeedsFragment.this);
                    }
                };
                TextView textView5 = this.rightButton;
                if (textView5 != null) {
                    textView5.setOnClickListener(onClickListener);
                }
                String string3 = context.getString(R.string.btnBack);
                TextView textView6 = this.leftButton;
                if (textView6 != null) {
                    textView6.setContentDescription(string3);
                }
                String string4 = context.getString(R.string.btnHelp);
                TextView textView7 = this.rightButton;
                if (textView7 != null) {
                    textView7.setContentDescription(string4);
                }
                String string5 = context.getString(R.string.lblFeed);
                TextView textView8 = this.toolbarTitle;
                if (textView8 != null) {
                    textView8.setContentDescription(string5);
                }
            }
        }
        RelationshipBottomSheetContract.Presenter presenter3 = this.settingPresenter;
        if (presenter3 != null) {
            presenter = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter.PlaceComponentResult();
    }

    @Override // id.dana.base.BaseFragment
    public final void onSelected() {
        super.onSelected();
        Fragment KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        this.lookAheadTest = true;
        if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof BaseFragment) {
            ((BaseFragment) KClassImpl$Data$declaredNonStaticMembers$2).onSelected();
        }
    }

    @Override // id.dana.base.BaseFragment
    public final void onUnSelected() {
        super.onUnSelected();
        Fragment KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        this.lookAheadTest = false;
        if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof BaseFragment) {
            ((BaseFragment) KClassImpl$Data$declaredNonStaticMembers$2).onUnSelected();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (getUserVisibleHint()) {
            Fragment KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
            this.lookAheadTest = true;
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof BaseFragment) {
                ((BaseFragment) KClassImpl$Data$declaredNonStaticMembers$2).onSelected();
            }
        }
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        Fragment KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
        this.lookAheadTest = false;
        if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof BaseFragment) {
            ((BaseFragment) KClassImpl$Data$declaredNonStaticMembers$2).onUnSelected();
        }
    }

    public final void PlaceComponentResult(String p0) {
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseTabFragmentAdapter != null) {
            if (baseTabFragmentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            }
            if (MyBillsEntityDataFactory()) {
                ((ViewPager2) PlaceComponentResult(R.id.LogFileLogAppender)).setCurrentItem(0);
                Fragment KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2();
                if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    KClassImpl$Data$declaredNonStaticMembers$2.onResume();
                }
                KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }
            PlaceComponentResult();
        }
    }

    private final boolean MyBillsEntityDataFactory() {
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter;
        Fragment fragment;
        try {
            id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            baseTabFragmentAdapter = null;
            if (baseTabFragmentAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseTabFragmentAdapter2 = null;
            }
            fragment = baseTabFragmentAdapter2.NetworkUserEntityData$$ExternalSyntheticLambda0.get(0);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (this.PlaceComponentResult) {
            return fragment instanceof MyFeedsFragment;
        }
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseTabFragmentAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            baseTabFragmentAdapter = baseTabFragmentAdapter3;
        }
        return baseTabFragmentAdapter.getItemCount() > 1 && (fragment instanceof MyFeedsFragment);
    }

    private final Fragment KClassImpl$Data$declaredNonStaticMembers$2() {
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseTabFragmentAdapter != null) {
            if (baseTabFragmentAdapter == null) {
                try {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    baseTabFragmentAdapter = null;
                } catch (IndexOutOfBoundsException unused) {
                    return null;
                }
            }
            return baseTabFragmentAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0.get(((ViewPager2) PlaceComponentResult(R.id.LogFileLogAppender)).getCurrentItem());
        }
        return null;
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda0 != null) {
            PlaceComponentResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void PlaceComponentResult() {
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseTabFragmentAdapter = null;
        }
        int itemCount = baseTabFragmentAdapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (baseTabFragmentAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseTabFragmentAdapter2 = null;
            }
            baseTabFragmentAdapter2.NetworkUserEntityData$$ExternalSyntheticLambda0.get(i).onResume();
        }
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        FriendshipAnalyticTracker friendshipAnalyticTracker = this.friendshipAnalyticsTracker;
        if (friendshipAnalyticTracker != null) {
            if (friendshipAnalyticTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                friendshipAnalyticTracker = null;
            }
            friendshipAnalyticTracker.NetworkUserEntityData$$ExternalSyntheticLambda0(str);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/FeedsFragment$Companion;", "", "", "p0", "Lid/dana/social/FeedsFragment;", "MyBillsEntityDataFactory", "(Z)Lid/dana/social/FeedsFragment;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static FeedsFragment MyBillsEntityDataFactory(boolean p0) {
            FeedsFragment feedsFragment = new FeedsFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("feedRevampEnabled", p0);
            feedsFragment.setArguments(bundle);
            return feedsFragment;
        }
    }

    @Override // id.dana.base.BaseWithToolbarFragment
    public final void onClickLeftMenuButton(View p0) {
        getBaseActivity().onBackPressed();
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FeedsFragment feedsFragment) {
        Intrinsics.checkNotNullParameter(feedsFragment, "");
        RelationshipBottomSheetContract.Presenter presenter = feedsFragment.settingPresenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2("setting_more");
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedsFragment feedsFragment, TabLayout.Tab tab, int i) {
        Intrinsics.checkNotNullParameter(feedsFragment, "");
        Intrinsics.checkNotNullParameter(tab, "");
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseTabFragmentAdapter = null;
        }
        tab.setText(baseTabFragmentAdapter.moveToNextValue.get(i));
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FeedsFragment feedsFragment) {
        Intrinsics.checkNotNullParameter(feedsFragment, "");
        FeedsIntroduction feedsIntroduction = feedsFragment.getAuthRequestContext;
        if (feedsIntroduction == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            feedsIntroduction = null;
        }
        feedsIntroduction.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ void getAuthRequestContext(final FeedsFragment feedsFragment, boolean z) {
        ((ConstraintLayout) feedsFragment.PlaceComponentResult(R.id.fl_feeds_tab)).setVisibility((!z || feedsFragment.PlaceComponentResult) ? 8 : 0);
        FragmentManager childFragmentManager = feedsFragment.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "");
        Lifecycle lifecycle = feedsFragment.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "");
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter = new id.dana.social.adapter.BaseTabFragmentAdapter(childFragmentManager, lifecycle);
        if (z) {
            MyFeedsFragment myFeedsFragment = new MyFeedsFragment();
            String string = feedsFragment.getString(R.string.feeds_tab_only_me);
            Intrinsics.checkNotNullExpressionValue(string, "");
            baseTabFragmentAdapter.PlaceComponentResult(myFeedsFragment, string, "");
        }
        if (!feedsFragment.PlaceComponentResult) {
            FriendsFeedsFragment friendsFeedsFragment = new FriendsFeedsFragment(new FriendsFeedsFragment.Interaction() { // from class: id.dana.social.FeedsFragment$setFeedAdapter$1$1
                private static int $10 = 0;
                private static int $11 = 1;
                private static char[] BuiltInFictitiousFunctionClassFactory = {35500, 35576, 35572, 35577, 35578, 35579, 35583, 35580, 35575, 35577, 35577, 35566, 35573, 35570, 35562, 35572, 35581, 35572, 35573, 35568, 35562, 35570, 35570};
                private static int MyBillsEntityDataFactory = 1;
                private static int getAuthRequestContext;

                @Override // id.dana.social.fragment.FriendsFeedsFragment.Interaction
                public final void getAuthRequestContext() {
                    int i;
                    RelationshipBottomSheetContract.Presenter presenter = FeedsFragment.this.settingPresenter;
                    if (presenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        presenter = null;
                        i = MyBillsEntityDataFactory + 79;
                    } else {
                        i = MyBillsEntityDataFactory + 21;
                    }
                    getAuthRequestContext = i % 128;
                    int i2 = i % 2;
                    Object[] objArr = new Object[1];
                    a(new int[]{0, 23, 0, 0}, true, new byte[]{1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0}, objArr);
                    presenter.KClassImpl$Data$declaredNonStaticMembers$2(((String) objArr[0]).intern());
                }

                private static void a(int[] iArr, boolean z2, byte[] bArr, Object[] objArr) {
                    char[] cArr;
                    int i;
                    VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
                    int i2 = iArr[0];
                    int i3 = iArr[1];
                    int i4 = iArr[2];
                    int i5 = iArr[3];
                    char[] cArr2 = BuiltInFictitiousFunctionClassFactory;
                    if (cArr2 != null) {
                        int i6 = $10 + 73;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        int length = cArr2.length;
                        char[] cArr3 = new char[length];
                        for (int i8 = 0; i8 < length; i8++) {
                            cArr3[i8] = (char) (cArr2[i8] ^ 5097613533456403102L);
                        }
                        cArr2 = cArr3;
                    }
                    char[] cArr4 = new char[i3];
                    System.arraycopy(cArr2, i2, cArr4, 0, i3);
                    if (bArr != null) {
                        char[] cArr5 = new char[i3];
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        char c = 0;
                        while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3) {
                            try {
                                if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                                    try {
                                        cArr5[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                                    } catch (Exception e) {
                                        throw e;
                                    }
                                } else {
                                    cArr5[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                                }
                                c = cArr5[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                                int i9 = $10 + 87;
                                $11 = i9 % 128;
                                int i10 = i9 % 2;
                            } catch (Exception e2) {
                                throw e2;
                            }
                        }
                        cArr4 = cArr5;
                    }
                    if (i5 > 0) {
                        int i11 = $10 + 65;
                        $11 = i11 % 128;
                        if (i11 % 2 == 0) {
                            char[] cArr6 = new char[i3];
                            System.arraycopy(cArr4, 1, cArr6, 1, i3);
                            System.arraycopy(cArr6, 0, cArr4, i3 << i5, i5);
                            System.arraycopy(cArr6, i5, cArr4, 1, i3 * i5);
                        } else {
                            char[] cArr7 = new char[i3];
                            System.arraycopy(cArr4, 0, cArr7, 0, i3);
                            int i12 = i3 - i5;
                            System.arraycopy(cArr7, 0, cArr4, i12, i5);
                            System.arraycopy(cArr7, i5, cArr4, 0, i12);
                        }
                    }
                    if ((z2 ? (char) 29 : '1') == 29) {
                        int i13 = $10 + 63;
                        $11 = i13 % 128;
                        if ((i13 % 2 == 0 ? (char) 31 : ']') != ']') {
                            cArr = new char[i3];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        } else {
                            cArr = new char[i3];
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        }
                        while (true) {
                            if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3)) {
                                break;
                            }
                            int i14 = $10 + 57;
                            $11 = i14 % 128;
                            if (i14 % 2 == 0) {
                                cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + i3) >> 0];
                                i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory * 0;
                            } else {
                                cArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr4[(i3 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                                i = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                            }
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i;
                        }
                        cArr4 = cArr;
                    }
                    if (i4 > 0) {
                        verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
                        while (true) {
                            if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i3)) {
                                break;
                            }
                            int i15 = $11 + 83;
                            $10 = i15 % 128;
                            int i16 = i15 % 2;
                            cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                        }
                    }
                    objArr[0] = new String(cArr4);
                }
            });
            String string2 = feedsFragment.getString(R.string.feeds_tab_friends);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            baseTabFragmentAdapter.PlaceComponentResult(friendsFeedsFragment, string2, "");
        }
        feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0 = baseTabFragmentAdapter;
        feedsFragment.BuiltInFictitiousFunctionClassFactory = true;
        List<Function1<FeedsFragment, Unit>> list = feedsFragment.KClassImpl$Data$declaredNonStaticMembers$2;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(feedsFragment);
        }
        list.clear();
        ViewPager2 viewPager2 = (ViewPager2) feedsFragment.PlaceComponentResult(R.id.LogFileLogAppender);
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter2 = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (baseTabFragmentAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseTabFragmentAdapter2 = null;
        }
        viewPager2.setAdapter(baseTabFragmentAdapter2);
        viewPager2.setOffscreenPageLimit(1);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: id.dana.social.FeedsFragment$createFeedsTab$1$1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public final void onPageSelected(int p0) {
                if (FeedsFragment.this.getUserVisibleHint()) {
                    if (p0 == 0) {
                        FeedsFragment.getAuthRequestContext(FeedsFragment.this, "Friends Feed", p0);
                    } else if (p0 == 1) {
                        FeedsFragment.MyBillsEntityDataFactory(FeedsFragment.this, TrackerKey.SourceType.INBOX_PAGE);
                    }
                    FeedsFragment.getAuthRequestContext(FeedsFragment.this);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(viewPager2, "");
        ExtensionsKt.getAuthRequestContext(viewPager2, 6);
        Context context = feedsFragment.getContext();
        if (context != null) {
            List listOf = CollectionsKt.listOf((Object[]) new String[]{context.getString(R.string.lblTabInbox), context.getString(R.string.lblTabActivities)});
            int size = listOf.size();
            id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter3 = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (baseTabFragmentAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseTabFragmentAdapter3 = null;
            }
            if (size == baseTabFragmentAdapter3.getItemCount()) {
                id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter4 = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (baseTabFragmentAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    baseTabFragmentAdapter4 = null;
                }
                int itemCount = baseTabFragmentAdapter4.getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    TabLayout tabLayout = (TabLayout) feedsFragment.PlaceComponentResult(R.id.res_0x7f0a1350_r8_lambda_68eytycucywsvbd4v6baosvoouk);
                    TabLayout.Tab tabAt = tabLayout != null ? tabLayout.getTabAt(i) : null;
                    if (tabAt != null) {
                        tabAt.setContentDescription((CharSequence) listOf.get(i));
                    }
                }
            }
        }
        new TabLayoutMediator((TabLayout) feedsFragment.PlaceComponentResult(R.id.res_0x7f0a1350_r8_lambda_68eytycucywsvbd4v6baosvoouk), (ViewPager2) feedsFragment.PlaceComponentResult(R.id.LogFileLogAppender), new TabLayoutMediator.TabConfigurationStrategy() { // from class: id.dana.social.FeedsFragment$$ExternalSyntheticLambda2
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i2) {
                FeedsFragment.KClassImpl$Data$declaredNonStaticMembers$2(FeedsFragment.this, tab, i2);
            }
        }).attach();
        if (feedsFragment.lookAheadTest) {
            Fragment KClassImpl$Data$declaredNonStaticMembers$2 = feedsFragment.KClassImpl$Data$declaredNonStaticMembers$2();
            feedsFragment.lookAheadTest = true;
            if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof BaseFragment) {
                ((BaseFragment) KClassImpl$Data$declaredNonStaticMembers$2).onSelected();
                return;
            }
            return;
        }
        Fragment KClassImpl$Data$declaredNonStaticMembers$22 = feedsFragment.KClassImpl$Data$declaredNonStaticMembers$2();
        feedsFragment.lookAheadTest = false;
        if (KClassImpl$Data$declaredNonStaticMembers$22 instanceof BaseFragment) {
            ((BaseFragment) KClassImpl$Data$declaredNonStaticMembers$22).onUnSelected();
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(FeedsFragment feedsFragment, SettingModel settingModel) {
        Intent intent;
        Context context = feedsFragment.getContext();
        if (context != null) {
            if (feedsFragment.MyBillsEntityDataFactory) {
                intent = new Intent(context, ProfileSettingsActivity.class);
            } else {
                intent = new Intent(context, SettingMoreProfileActivity.class);
            }
            intent.putExtra(MyProfileBundleKey.FROM_FEEDS_SETTING_ICON, true);
            intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
            feedsFragment.startActivity(intent);
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(FeedsFragment feedsFragment) {
        Fragment KClassImpl$Data$declaredNonStaticMembers$2 = feedsFragment.KClassImpl$Data$declaredNonStaticMembers$2();
        feedsFragment.lookAheadTest = true;
        if (KClassImpl$Data$declaredNonStaticMembers$2 instanceof BaseFragment) {
            ((BaseFragment) KClassImpl$Data$declaredNonStaticMembers$2).onSelected();
        }
    }

    public static final /* synthetic */ void scheduleImpl(FeedsFragment feedsFragment) {
        Context context = feedsFragment.getContext();
        if (context != null) {
            feedsFragment.startActivity(new Intent(context, ChangeUsernameActivity.class));
        }
    }

    public static final /* synthetic */ void lookAheadTest(FeedsFragment feedsFragment) {
        Fragment KClassImpl$Data$declaredNonStaticMembers$2 = feedsFragment.KClassImpl$Data$declaredNonStaticMembers$2();
        if (KClassImpl$Data$declaredNonStaticMembers$2 != null) {
            KClassImpl$Data$declaredNonStaticMembers$2.onResume();
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(FeedsFragment feedsFragment, String str) {
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
        id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter2 = null;
        if (baseTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            baseTabFragmentAdapter = null;
        }
        if (baseTabFragmentAdapter.getItemCount() > 1) {
            id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter3 = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (baseTabFragmentAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                baseTabFragmentAdapter3 = null;
            }
            if (baseTabFragmentAdapter3.NetworkUserEntityData$$ExternalSyntheticLambda0.get(1) instanceof FriendsFeedsFragment) {
                id.dana.social.adapter.BaseTabFragmentAdapter baseTabFragmentAdapter4 = feedsFragment.NetworkUserEntityData$$ExternalSyntheticLambda0;
                if (baseTabFragmentAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    baseTabFragmentAdapter2 = baseTabFragmentAdapter4;
                }
                FriendsFeedsFragment friendsFeedsFragment = (FriendsFeedsFragment) baseTabFragmentAdapter2.NetworkUserEntityData$$ExternalSyntheticLambda0.get(1);
                if (str == null) {
                    str = "";
                }
                Intrinsics.checkNotNullParameter(str, "");
                friendsFeedsFragment.FragmentBottomSheetPaymentSettingBinding = str;
                friendsFeedsFragment.BuiltInFictitiousFunctionClassFactory(TimerEventKey.FEED_OPEN);
            }
        }
    }

    public static final /* synthetic */ void getAuthRequestContext(FeedsFragment feedsFragment, String str, int i) {
        FriendshipAnalyticTracker friendshipAnalyticTracker = feedsFragment.friendshipAnalyticsTracker;
        if (friendshipAnalyticTracker == null || i != 0) {
            return;
        }
        if (friendshipAnalyticTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendshipAnalyticTracker = null;
        }
        friendshipAnalyticTracker.NetworkUserEntityData$$ExternalSyntheticLambda0(str);
    }

    @Override // id.dana.base.BaseFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.PlaceComponentResult.clear();
    }
}
