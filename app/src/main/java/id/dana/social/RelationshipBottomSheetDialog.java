package id.dana.social;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import com.alipay.iap.android.common.syncintegration.api.IAPSyncCommand;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.R;
import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseActivity;
import id.dana.base.BaseBottomSheetDialogFragment;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.services.ServicesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.domain.social.model.FeedConfig;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.model.ThirdPartyService;
import id.dana.myprofile.MyProfileBundleKey;
import id.dana.myprofile.SettingMoreProfileActivity;
import id.dana.social.adapter.FriendshipViewPagerAdapter;
import id.dana.social.base.FriendshipListBaseFragment;
import id.dana.social.contract.FriendRequestContract;
import id.dana.social.contract.RelationshipBottomSheetContract;
import id.dana.social.di.component.SocialCommonComponent;
import id.dana.social.di.module.FriendRequestListModule;
import id.dana.social.di.module.RelationshipBottomSheetModule;
import id.dana.social.view.ModifyRelationshipSnackbar;
import id.dana.utils.ErrorUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b*\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\nR\u0012\u0010\u0013\u001a\u00020\u0012X\u0087\"¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0016\u001a\u00020\u0015X\u0087\"¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0012\u0010!\u001a\u00020 X\u0087\"¢\u0006\u0006\n\u0004\b!\u0010\"R\u0012\u0010$\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020#X\u0087\"¢\u0006\u0006\n\u0004\b&\u0010%R\u0012\u0010(\u001a\u00020'X\u0087\"¢\u0006\u0006\n\u0004\b(\u0010)"}, d2 = {"Lid/dana/social/RelationshipBottomSheetDialog;", "Lid/dana/base/BaseBottomSheetDialogFragment;", "", "getDimAmount", "()F", "", "getLayout", "()I", "", IAPSyncCommand.COMMAND_INIT, "()V", "p0", "p1", "initBottomSheet", "(II)V", "onDismiss", "onShow", "onStart", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "clFriendship", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "Landroid/widget/FrameLayout;", "cvFriendship", "Landroid/widget/FrameLayout;", "Lid/dana/social/adapter/FriendshipViewPagerAdapter;", "lookAheadTest", "Lid/dana/social/adapter/FriendshipViewPagerAdapter;", "MyBillsEntityDataFactory", "Lid/dana/social/view/ModifyRelationshipSnackbar;", "moveToNextValue", "Lid/dana/social/view/ModifyRelationshipSnackbar;", "PlaceComponentResult", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "presenter", "Lid/dana/social/contract/RelationshipBottomSheetContract$Presenter;", "Landroid/widget/RadioButton;", "rbFollower", "Landroid/widget/RadioButton;", "rbFollowing", "Landroidx/viewpager/widget/ViewPager;", "vpFriendship", "Landroidx/viewpager/widget/ViewPager;", "<init>", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RelationshipBottomSheetDialog extends BaseBottomSheetDialogFragment {
    public Map<Integer, View> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedHashMap();
    @BindView(R.id.cl_friendship_bottom_sheet_coordinator)
    public CoordinatorLayout clFriendship;
    @BindView(R.id.cv_friendship)
    public FrameLayout cvFriendship;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private FriendshipViewPagerAdapter MyBillsEntityDataFactory;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private ModifyRelationshipSnackbar PlaceComponentResult;
    @Inject
    public RelationshipBottomSheetContract.Presenter presenter;
    @BindView(R.id.rb_follower)
    public RadioButton rbFollower;
    @BindView(R.id.rb_following)
    public RadioButton rbFollowing;
    @BindView(R.id.vp_friendship)
    public ViewPager vpFriendship;

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

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final float getDimAmount() {
        return 0.0f;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final int getLayout() {
        return R.layout.bottom_sheet_friend_list_coordinator;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void initBottomSheet(int p0, int p1) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        super.initBottomSheet(displayMetrics.heightPixels, 3);
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onShow() {
        super.onShow();
        initBottomSheet(9999, 3);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "");
        this.MyBillsEntityDataFactory = new FriendshipViewPagerAdapter(childFragmentManager, new FriendshipListBaseFragment.ShowSnackbarInterface() { // from class: id.dana.social.RelationshipBottomSheetDialog$createOnTapInterfaceInstance$1
            @Override // id.dana.social.base.FriendshipListBaseFragment.ShowSnackbarInterface
            public final void PlaceComponentResult(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                RelationshipBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetDialog.this, p0);
            }
        });
        ViewPager viewPager = this.vpFriendship;
        RadioButton radioButton = null;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewPager = null;
        }
        FriendshipViewPagerAdapter friendshipViewPagerAdapter = this.MyBillsEntityDataFactory;
        if (friendshipViewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            friendshipViewPagerAdapter = null;
        }
        viewPager.setAdapter(friendshipViewPagerAdapter);
        ViewPager viewPager2 = this.vpFriendship;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewPager2 = null;
        }
        viewPager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: id.dana.social.RelationshipBottomSheetDialog$setupFriendshipViewPager$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrollStateChanged(int p0) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageScrolled(int p0, float p1, int p2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public final void onPageSelected(int p0) {
                RadioButton radioButton2 = null;
                if (p0 == 0) {
                    RadioButton radioButton3 = RelationshipBottomSheetDialog.this.rbFollower;
                    if (radioButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        radioButton3 = null;
                    }
                    if (radioButton3.isChecked()) {
                        RadioButton radioButton4 = RelationshipBottomSheetDialog.this.rbFollowing;
                        if (radioButton4 != null) {
                            radioButton2 = radioButton4;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        radioButton2.setChecked(true);
                        return;
                    }
                }
                if (p0 == 1) {
                    RadioButton radioButton5 = RelationshipBottomSheetDialog.this.rbFollowing;
                    if (radioButton5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("");
                        radioButton5 = null;
                    }
                    if (radioButton5.isChecked()) {
                        RadioButton radioButton6 = RelationshipBottomSheetDialog.this.rbFollower;
                        if (radioButton6 != null) {
                            radioButton2 = radioButton6;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("");
                        }
                        radioButton2.setChecked(true);
                    }
                }
            }
        });
        RadioButton radioButton2 = this.rbFollowing;
        if (radioButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            radioButton2 = null;
        }
        radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.social.RelationshipBottomSheetDialog$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RelationshipBottomSheetDialog.getAuthRequestContext(RelationshipBottomSheetDialog.this, z);
            }
        });
        RadioButton radioButton3 = this.rbFollower;
        if (radioButton3 != null) {
            radioButton = radioButton3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.social.RelationshipBottomSheetDialog$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                RelationshipBottomSheetDialog.PlaceComponentResult(RelationshipBottomSheetDialog.this, z);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        final View findViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
        ViewGroup.LayoutParams layoutParams = findViewById != null ? findViewById.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = -1;
        }
        final View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: id.dana.social.RelationshipBottomSheetDialog$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    RelationshipBottomSheetDialog.PlaceComponentResult(view, findViewById, this);
                }
            });
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void init() {
        super.init();
        SocialCommonComponent socialCommonComponent = getBaseActivity().getDanaApplication().getSocialCommonComponent();
        byte b = 0;
        if (socialCommonComponent != null) {
            RelationshipBottomSheetModule relationshipBottomSheetModule = new RelationshipBottomSheetModule(new RelationshipBottomSheetContract.View() { // from class: id.dana.social.RelationshipBottomSheetDialog$initInjection$1
                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ String BuiltInFictitiousFunctionClassFactory() {
                    return RelationshipBottomSheetContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void MyBillsEntityDataFactory(boolean p0) {
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void PlaceComponentResult(List list) {
                    RelationshipBottomSheetContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void getAuthRequestContext(ModifyRelationOperationType modifyRelationOperationType) {
                    Intrinsics.checkNotNullParameter(modifyRelationOperationType, "");
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final /* synthetic */ void getAuthRequestContext(List list) {
                    RelationshipBottomSheetContract.View.CC.getAuthRequestContext(list);
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

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void BuiltInFictitiousFunctionClassFactory(SettingModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    RelationshipBottomSheetDialog.MyBillsEntityDataFactory(RelationshipBottomSheetDialog.this, p0);
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void MyBillsEntityDataFactory() {
                    Toast.makeText(RelationshipBottomSheetDialog.this.getActivity(), ErrorUtil.BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetDialog.this.getBaseActivity()), 0).show();
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void MyBillsEntityDataFactory(FeedConfig p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    RelationshipBottomSheetDialog.MyBillsEntityDataFactory(RelationshipBottomSheetDialog.this, p0.isAddFriendEnabled());
                }

                @Override // id.dana.social.contract.RelationshipBottomSheetContract.View
                public final void PlaceComponentResult() {
                    RelationshipBottomSheetDialog.MyBillsEntityDataFactory(RelationshipBottomSheetDialog.this, false);
                }
            });
            DeepLinkModule.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DeepLinkModule.KClassImpl$Data$declaredNonStaticMembers$2();
            KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory = getActivity();
            DeepLinkModule deepLinkModule = new DeepLinkModule(KClassImpl$Data$declaredNonStaticMembers$2, b);
            Intrinsics.checkNotNullExpressionValue(deepLinkModule, "");
            socialCommonComponent.getAuthRequestContext(relationshipBottomSheetModule, deepLinkModule, new ServicesModule(new ServicesContract.View() { // from class: id.dana.social.RelationshipBottomSheetDialog$initInjection$2
                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionFailed(String str) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionGet(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionMiniApp(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.PlaceComponentResult(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onActionPost(ThirdPartyService thirdPartyService, String str) {
                    ServicesContract.View.CC.getAuthRequestContext(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onCheckFavoriteServicesFeature(boolean z) {
                    ServicesContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onDirectOpen(ThirdPartyService thirdPartyService, Map map) {
                    Intrinsics.checkNotNullParameter(thirdPartyService, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onEmptySearchService() {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onFeatureServices(List list) {
                    ServicesContract.View.CC.PlaceComponentResult(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetFilteredThirdPartyServices(List list) {
                    ServicesContract.View.CC.MyBillsEntityDataFactory(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetInitThirdPartyServices(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onGetThirdPartyServices(List list) {
                    ServicesContract.View.CC.getAuthRequestContext(list);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onMaintenanceAction(ThirdPartyService thirdPartyService) {
                    ServicesContract.View.CC.BuiltInFictitiousFunctionClassFactory(thirdPartyService);
                }

                @Override // id.dana.contract.services.ServicesContract.View
                public final /* synthetic */ void onShowTooltip(boolean z) {
                    ServicesContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void showProgress() {
                    AbstractContractKt.AbstractView.CC.PlaceComponentResult();
                }
            }), new FriendRequestListModule(new FriendRequestContract.View() { // from class: id.dana.social.RelationshipBottomSheetDialog$initInjection$3
                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FriendModel friendModel) {
                    FriendRequestContract.View.CC.getAuthRequestContext(friendModel);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(FriendModel friendModel) {
                    FriendRequestContract.View.CC.MyBillsEntityDataFactory(friendModel);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void MyBillsEntityDataFactory(Throwable th, String str, String str2) {
                    FriendRequestContract.View.CC.PlaceComponentResult(th, str, str2);
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void PlaceComponentResult(FriendModel friendModel) {
                    Intrinsics.checkNotNullParameter(friendModel, "");
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void PlaceComponentResult(List list, boolean z) {
                    FriendRequestContract.View.CC.BuiltInFictitiousFunctionClassFactory(list);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void dismissProgress() {
                    AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void getAuthRequestContext() {
                    FriendRequestContract.View.CC.PlaceComponentResult();
                }

                @Override // id.dana.social.contract.FriendRequestContract.View
                public final /* synthetic */ void getAuthRequestContext(FriendModel friendModel) {
                    FriendRequestContract.View.CC.BuiltInFictitiousFunctionClassFactory(friendModel);
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
            })).BuiltInFictitiousFunctionClassFactory(this);
        }
        BaseActivity baseActivity = getBaseActivity();
        AbstractContract.AbstractPresenter[] abstractPresenterArr = new AbstractContract.AbstractPresenter[1];
        RelationshipBottomSheetContract.Presenter presenter = this.presenter;
        RelationshipBottomSheetContract.Presenter presenter2 = null;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        abstractPresenterArr[0] = presenter;
        baseActivity.registerPresenter(abstractPresenterArr);
        TypedValue typedValue = new TypedValue();
        getBaseActivity().getTheme().resolveAttribute(16843499, typedValue, true);
        int dimensionPixelSize = getResources().getDimensionPixelSize(typedValue.resourceId);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getBaseActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        FrameLayout frameLayout = this.cvFriendship;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            frameLayout = null;
        }
        frameLayout.getLayoutParams().height = i - dimensionPixelSize;
        FrameLayout frameLayout2 = this.cvFriendship;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            frameLayout2 = null;
        }
        frameLayout2.requestLayout();
        ImageButton imageButton = (ImageButton) BuiltInFictitiousFunctionClassFactory(R.id.btn_settings);
        if (imageButton != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.RelationshipBottomSheetDialog$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RelationshipBottomSheetDialog.PlaceComponentResult(RelationshipBottomSheetDialog.this);
                }
            });
        }
        RelationshipBottomSheetContract.Presenter presenter3 = this.presenter;
        if (presenter3 != null) {
            presenter2 = presenter3;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        presenter2.MyBillsEntityDataFactory();
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    public final void onDismiss() {
        super.onDismiss();
        dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(RelationshipBottomSheetDialog relationshipBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(relationshipBottomSheetDialog, "");
        relationshipBottomSheetDialog.dismiss();
    }

    public static /* synthetic */ void PlaceComponentResult(RelationshipBottomSheetDialog relationshipBottomSheetDialog, boolean z) {
        Intrinsics.checkNotNullParameter(relationshipBottomSheetDialog, "");
        if (z) {
            ViewPager viewPager = relationshipBottomSheetDialog.vpFriendship;
            ViewPager viewPager2 = null;
            if (viewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                viewPager = null;
            }
            if (viewPager.getCurrentItem() == 0) {
                ViewPager viewPager3 = relationshipBottomSheetDialog.vpFriendship;
                if (viewPager3 != null) {
                    viewPager2 = viewPager3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                viewPager2.setCurrentItem(1);
            }
        }
    }

    public static /* synthetic */ void PlaceComponentResult(RelationshipBottomSheetDialog relationshipBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(relationshipBottomSheetDialog, "");
        RelationshipBottomSheetContract.Presenter presenter = relationshipBottomSheetDialog.presenter;
        if (presenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            presenter = null;
        }
        presenter.KClassImpl$Data$declaredNonStaticMembers$2("setting_more");
    }

    public static /* synthetic */ void PlaceComponentResult(View view, View view2, final RelationshipBottomSheetDialog relationshipBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(view, "");
        Intrinsics.checkNotNullParameter(relationshipBottomSheetDialog, "");
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
        CoordinatorLayout coordinatorLayout = null;
        ViewParent parent2 = view2 != null ? view2.getParent() : null;
        if (parent2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        }
        ((View) parent2).setBackgroundColor(0);
        CoordinatorLayout coordinatorLayout2 = relationshipBottomSheetDialog.clFriendship;
        if (coordinatorLayout2 != null) {
            coordinatorLayout = coordinatorLayout2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        if (coordinatorLayout != null) {
            coordinatorLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.RelationshipBottomSheetDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    RelationshipBottomSheetDialog.getAuthRequestContext(RelationshipBottomSheetDialog.this);
                }
            });
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetDialog relationshipBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(relationshipBottomSheetDialog, "");
        ModifyRelationshipSnackbar modifyRelationshipSnackbar = relationshipBottomSheetDialog.PlaceComponentResult;
        if (modifyRelationshipSnackbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            modifyRelationshipSnackbar = null;
        }
        modifyRelationshipSnackbar.dismiss();
    }

    public static /* synthetic */ void getAuthRequestContext(RelationshipBottomSheetDialog relationshipBottomSheetDialog, boolean z) {
        Intrinsics.checkNotNullParameter(relationshipBottomSheetDialog, "");
        if (z) {
            ViewPager viewPager = relationshipBottomSheetDialog.vpFriendship;
            ViewPager viewPager2 = null;
            if (viewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                viewPager = null;
            }
            if (viewPager.getCurrentItem() == 1) {
                ViewPager viewPager3 = relationshipBottomSheetDialog.vpFriendship;
                if (viewPager3 != null) {
                    viewPager2 = viewPager3;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                }
                viewPager2.setCurrentItem(0);
            }
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(RelationshipBottomSheetDialog relationshipBottomSheetDialog) {
        Intrinsics.checkNotNullParameter(relationshipBottomSheetDialog, "");
        FragmentManager fragmentManager = relationshipBottomSheetDialog.getFragmentManager();
        if (fragmentManager != null) {
            new RelationshipBottomSheetDialog().show(fragmentManager, (String) null);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(RelationshipBottomSheetDialog relationshipBottomSheetDialog, SettingModel settingModel) {
        Context context = relationshipBottomSheetDialog.getContext();
        if (context != null) {
            Intent intent = new Intent(context, SettingMoreProfileActivity.class);
            intent.putExtra(MyProfileBundleKey.SETTING_MODEL, settingModel);
            relationshipBottomSheetDialog.startActivity(intent);
        }
    }

    public static final /* synthetic */ void MyBillsEntityDataFactory(final RelationshipBottomSheetDialog relationshipBottomSheetDialog, boolean z) {
        if (!z) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) relationshipBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a01b0_flowviewutil_textchanges_1);
            if (danaButtonPrimaryView != null) {
                danaButtonPrimaryView.setVisibility(8);
                return;
            }
            return;
        }
        DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) relationshipBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a01b0_flowviewutil_textchanges_1);
        if (danaButtonPrimaryView2 != null) {
            danaButtonPrimaryView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.RelationshipBottomSheetDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RelationshipBottomSheetDialog.MyBillsEntityDataFactory(RelationshipBottomSheetDialog.this);
                }
            });
        }
        DanaButtonPrimaryView danaButtonPrimaryView3 = (DanaButtonPrimaryView) relationshipBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(R.id.res_0x7f0a01b0_flowviewutil_textchanges_1);
        if (danaButtonPrimaryView3 != null) {
            danaButtonPrimaryView3.setVisibility(0);
        }
    }

    public static final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(final RelationshipBottomSheetDialog relationshipBottomSheetDialog, String str) {
        CoordinatorLayout coordinatorLayout = relationshipBottomSheetDialog.clFriendship;
        if (coordinatorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            coordinatorLayout = null;
        }
        FrameLayout frameLayout = coordinatorLayout != null ? (FrameLayout) coordinatorLayout.findViewById(R.id.cv_friendship) : null;
        View rootView = frameLayout != null ? frameLayout.getRootView() : null;
        ViewGroup viewGroup = rootView instanceof ViewGroup ? rootView : null;
        if (viewGroup != null) {
            ModifyRelationshipSnackbar.Builder builder = new ModifyRelationshipSnackbar.Builder(viewGroup);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: id.dana.social.RelationshipBottomSheetDialog$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RelationshipBottomSheetDialog.BuiltInFictitiousFunctionClassFactory(RelationshipBottomSheetDialog.this);
                }
            };
            Intrinsics.checkNotNullParameter(onClickListener, "");
            builder.getAuthRequestContext = onClickListener;
            String string = relationshipBottomSheetDialog.getString(R.string.dismiss_friendship);
            Intrinsics.checkNotNullExpressionValue(string, "");
            Intrinsics.checkNotNullParameter(string, "");
            builder.PlaceComponentResult = string;
            builder.BuiltInFictitiousFunctionClassFactory = 5000;
            Intrinsics.checkNotNullParameter(str, "");
            builder.getErrorConfigVersion = str;
            View inflate = LayoutInflater.from(builder.lookAheadTest.getContext()).inflate(builder.MyBillsEntityDataFactory, builder.lookAheadTest, false);
            ViewGroup viewGroup2 = builder.lookAheadTest;
            Intrinsics.checkNotNullExpressionValue(inflate, "");
            ModifyRelationshipSnackbar modifyRelationshipSnackbar = new ModifyRelationshipSnackbar(viewGroup2, inflate, new ModifyRelationshipSnackbar.Callback(inflate), builder, null);
            relationshipBottomSheetDialog.PlaceComponentResult = modifyRelationshipSnackbar;
            modifyRelationshipSnackbar.show();
        }
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment
    /* renamed from: getBottomSheet */
    public final /* synthetic */ View getPlaceComponentResult() {
        CoordinatorLayout coordinatorLayout = this.clFriendship;
        if (coordinatorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            coordinatorLayout = null;
        }
        return coordinatorLayout != null ? (FrameLayout) coordinatorLayout.findViewById(R.id.cv_friendship) : null;
    }

    @Override // id.dana.base.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.KClassImpl$Data$declaredNonStaticMembers$2.clear();
    }
}
