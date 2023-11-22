package id.dana.myprofile.mepagerevamp.profilesettings.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.animation.HomeTabActivity;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.di.component.ApplicationComponent;
import id.dana.dialog.LoadingDialog;
import id.dana.eventbus.models.TimerEventKey;
import id.dana.feeds.ui.tracker.FeedsSourceType;
import id.dana.feeds.ui.tracker.FriendshipAnalyticTracker;
import id.dana.nearbyme.OnRedirectListener;
import id.dana.social.RestrictedContactActivity;
import id.dana.social.contract.PrivacySettingContract;
import id.dana.social.di.component.DaggerPrivacySettingComponent;
import id.dana.social.di.component.PrivacySettingComponent;
import id.dana.social.di.module.PrivacySettingModule;
import id.dana.social.state.InitFeedState;
import id.dana.social.v2.FeedsActivity;
import id.dana.util.AndroidComponentUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u00108\u001a\u000207\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u000109\u0012\b\b\u0002\u0010;\u001a\u00020\u0007¢\u0006\u0004\b<\u0010=J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001b\u001a\u00020\u0019X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u001b\u0010\u0016\u001a\u00020\u00028CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u0018\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010$\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u0006R\u0013\u0010\u000e\u001a\u00020'X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR$\u0010/\u001a\u0004\u0018\u00010(8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00101\u001a\u0002008\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106"}, d2 = {"Lid/dana/myprofile/mepagerevamp/profilesettings/view/NewFeedSharingView;", "Lid/dana/base/BaseRichView;", "", "p0", "", "PlaceComponentResult", "(Z)V", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "MyBillsEntityDataFactory", "()V", "Lid/dana/social/state/InitFeedState;", "state", "render", "(Lid/dana/social/state/InitFeedState;)V", "setup", "Lid/dana/social/di/component/PrivacySettingComponent;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/di/component/PrivacySettingComponent;", "getAuthRequestContext", "Lcom/afollestad/materialdialogs/MaterialDialog;", "Lkotlin/Lazy;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "friendshipAnalyticTracker", "Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "getFriendshipAnalyticTracker", "()Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;", "setFriendshipAnalyticTracker", "(Lid/dana/feeds/ui/tracker/FriendshipAnalyticTracker;)V", "Z", "isFromFeedsSettingIcon", "setFromFeedsSettingIcon", "Lid/dana/dialog/LoadingDialog;", "Lid/dana/nearbyme/OnRedirectListener;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lid/dana/nearbyme/OnRedirectListener;", "getOnRedirectListener", "()Lid/dana/nearbyme/OnRedirectListener;", "setOnRedirectListener", "(Lid/dana/nearbyme/OnRedirectListener;)V", "onRedirectListener", "Lid/dana/social/contract/PrivacySettingContract$Presenter;", "privacySettingPresenter", "Lid/dana/social/contract/PrivacySettingContract$Presenter;", "getPrivacySettingPresenter", "()Lid/dana/social/contract/PrivacySettingContract$Presenter;", "setPrivacySettingPresenter", "(Lid/dana/social/contract/PrivacySettingContract$Presenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewFeedSharingView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private PrivacySettingComponent getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private OnRedirectListener onRedirectListener;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public FriendshipAnalyticTracker friendshipAnalyticTracker;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isFromFeedsSettingIcon;
    @Inject
    public PrivacySettingContract.Presenter privacySettingPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewFeedSharingView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewFeedSharingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.new_view_feed_sharing;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewFeedSharingView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$feedRevamp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                DanaApplication MyBillsEntityDataFactory = AndroidComponentUtilsKt.MyBillsEntityDataFactory(NewFeedSharingView.this);
                return Boolean.valueOf(MyBillsEntityDataFactory != null ? MyBillsEntityDataFactory.isFeedRevamp() : false);
            }
        });
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<LoadingDialog>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$loadingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LoadingDialog invoke() {
                return new LoadingDialog(NewFeedSharingView.this.getBaseActivity());
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$deactivateDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                CustomDialog.Builder builder = new CustomDialog.Builder(context);
                builder.SubSequence = context.getString(R.string.deactivate_feed_dialog_title);
                builder.GetContactSyncConfig = context.getString(R.string.deactivate_feed_dialog_desc);
                String string = context.getString(R.string.option_no);
                final NewFeedSharingView newFeedSharingView = this;
                CustomDialog.Builder KClassImpl$Data$declaredNonStaticMembers$2 = builder.KClassImpl$Data$declaredNonStaticMembers$2(string, new Function1<View, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$deactivateDialog$2.1
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
                        Intrinsics.checkNotNullParameter(view, "");
                        NewFeedSharingView.access$getDeactivateDialog(NewFeedSharingView.this).dismiss();
                    }
                });
                String string2 = context.getString(R.string.option_yes);
                final NewFeedSharingView newFeedSharingView2 = this;
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(string2, new Function1<View, Unit>() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$deactivateDialog$2.2
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
                        Intrinsics.checkNotNullParameter(view, "");
                        NewFeedSharingView.this.getFriendshipAnalyticTracker().PlaceComponentResult();
                        NewFeedSharingView.this.getPrivacySettingPresenter().BuiltInFictitiousFunctionClassFactory();
                        NewFeedSharingView.access$getDeactivateDialog(NewFeedSharingView.this).dismiss();
                        if (NewFeedSharingView.this.getIsFromFeedsSettingIcon()) {
                            NewFeedSharingView.this.MyBillsEntityDataFactory();
                        }
                    }
                });
                BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
                return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    public /* synthetic */ NewFeedSharingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getAuthRequestContext")
    private final boolean getAuthRequestContext() {
        return ((Boolean) this.BuiltInFictitiousFunctionClassFactory.getValue()).booleanValue();
    }

    @JvmName(name = "getPrivacySettingPresenter")
    public final PrivacySettingContract.Presenter getPrivacySettingPresenter() {
        PrivacySettingContract.Presenter presenter = this.privacySettingPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPrivacySettingPresenter")
    public final void setPrivacySettingPresenter(PrivacySettingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.privacySettingPresenter = presenter;
    }

    @JvmName(name = "getFriendshipAnalyticTracker")
    public final FriendshipAnalyticTracker getFriendshipAnalyticTracker() {
        FriendshipAnalyticTracker friendshipAnalyticTracker = this.friendshipAnalyticTracker;
        if (friendshipAnalyticTracker != null) {
            return friendshipAnalyticTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setFriendshipAnalyticTracker")
    public final void setFriendshipAnalyticTracker(FriendshipAnalyticTracker friendshipAnalyticTracker) {
        Intrinsics.checkNotNullParameter(friendshipAnalyticTracker, "");
        this.friendshipAnalyticTracker = friendshipAnalyticTracker;
    }

    @JvmName(name = "isFromFeedsSettingIcon")
    /* renamed from: isFromFeedsSettingIcon  reason: from getter */
    public final boolean getIsFromFeedsSettingIcon() {
        return this.isFromFeedsSettingIcon;
    }

    @JvmName(name = "setFromFeedsSettingIcon")
    public final void setFromFeedsSettingIcon(boolean z) {
        this.isFromFeedsSettingIcon = z;
    }

    @JvmName(name = "getOnRedirectListener")
    public final OnRedirectListener getOnRedirectListener() {
        return this.onRedirectListener;
    }

    @JvmName(name = "setOnRedirectListener")
    public final void setOnRedirectListener(OnRedirectListener onRedirectListener) {
        this.onRedirectListener = onRedirectListener;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        if (this.getAuthRequestContext == null && applicationComponent != null) {
            DaggerPrivacySettingComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerPrivacySettingComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (PrivacySettingModule) Preconditions.getAuthRequestContext(new PrivacySettingModule(new PrivacySettingContract.View() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$getPrivacySettingModule$1
                @Override // id.dana.base.AbstractContractKt.AbstractView
                public final /* synthetic */ String getErrorSource() {
                    return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final /* synthetic */ void onError(String str) {
                    AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
                }

                @Override // id.dana.social.contract.PrivacySettingContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                    NewFeedSharingView.access$setShareFeedSwitchWithNoSideEffect(NewFeedSharingView.this, p0);
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void showProgress() {
                    LoadingDialog access$getLoadingDialog = NewFeedSharingView.access$getLoadingDialog(NewFeedSharingView.this);
                    if (access$getLoadingDialog.BuiltInFictitiousFunctionClassFactory.isShowing()) {
                        return;
                    }
                    try {
                        access$getLoadingDialog.BuiltInFictitiousFunctionClassFactory.show();
                    } catch (Exception unused) {
                    }
                }

                @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
                public final void dismissProgress() {
                    NewFeedSharingView.access$getLoadingDialog(NewFeedSharingView.this).KClassImpl$Data$declaredNonStaticMembers$2();
                }

                @Override // id.dana.social.contract.PrivacySettingContract.View
                public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                    NewFeedSharingView.this.getFriendshipAnalyticTracker().KClassImpl$Data$declaredNonStaticMembers$2(p0);
                }

                @Override // id.dana.social.contract.PrivacySettingContract.View
                public final void MyBillsEntityDataFactory(boolean p0) {
                    NewFeedSharingView newFeedSharingView = NewFeedSharingView.this;
                    String string = newFeedSharingView.getContext().getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    Toast.makeText(newFeedSharingView.getBaseActivity(), string, 0).show();
                    NewFeedSharingView.access$setShareFeedSwitchWithNoSideEffect(NewFeedSharingView.this, !p0);
                }

                @Override // id.dana.social.contract.PrivacySettingContract.View
                public final void getAuthRequestContext(boolean p0) {
                    if (p0) {
                        return;
                    }
                    NewFeedSharingView.this.render(InitFeedState.NotActivated.INSTANCE);
                }

                @Override // id.dana.social.contract.PrivacySettingContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    NewFeedSharingView newFeedSharingView = NewFeedSharingView.this;
                    String string = newFeedSharingView.getContext().getString(R.string.SchedulerPoolFactory);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    Toast.makeText(newFeedSharingView.getBaseActivity(), string, 0).show();
                }
            }));
            PrivacySettingComponent BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory();
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory2, "");
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        }
        PrivacySettingComponent privacySettingComponent = this.getAuthRequestContext;
        if (privacySettingComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            privacySettingComponent = null;
        }
        privacySettingComponent.MyBillsEntityDataFactory(this);
        registerPresenter(getPrivacySettingPresenter());
    }

    public final void render(InitFeedState state) {
        Intrinsics.checkNotNullParameter(state, "");
        if (!(state instanceof InitFeedState.NotActivated)) {
            if (!(state instanceof InitFeedState.NoWording)) {
                if (!(state instanceof InitFeedState.Activated)) {
                    throw new NoWhenBranchMatchedException();
                }
                getPrivacySettingPresenter().MyBillsEntityDataFactory();
                AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
                if (appCompatTextView != null) {
                    appCompatTextView.setVisibility(8);
                }
                ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.cl_rightItem);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(8);
                }
                View _$_findCachedViewById = _$_findCachedViewById(R.id.res_0x7f0a1b33_daggerprofileqrisdialogcomponent_profileqrisdialogcomponentimpl_threadexecutorprovider);
                if (_$_findCachedViewById != null) {
                    _$_findCachedViewById.setVisibility(0);
                    return;
                }
                return;
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.setClientPackageName);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText("");
                return;
            }
            return;
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) _$_findCachedViewById(R.id.setDrawValueAboveBar);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setVisibility(0);
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_rightItem);
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
        View _$_findCachedViewById2 = _$_findCachedViewById(R.id.res_0x7f0a1b33_daggerprofileqrisdialogcomponent_profileqrisdialogcomponentimpl_threadexecutorprovider);
        if (_$_findCachedViewById2 != null) {
            _$_findCachedViewById2.setVisibility(8);
        }
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) _$_findCachedViewById(R.id.setClientPackageName);
        if (appCompatTextView4 != null) {
            Context context = getContext();
            appCompatTextView4.setText(context != null ? context.getString(R.string.feed_sharing_state_not_activated) : null);
        }
        ConstraintLayout constraintLayout3 = (ConstraintLayout) _$_findCachedViewById(R.id.cl_feed_sharing);
        if (constraintLayout3 != null) {
            constraintLayout3.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewFeedSharingView.$r8$lambda$xsE1XQ07fVPEQPhhaOond4muvxo(NewFeedSharingView.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MyBillsEntityDataFactory() {
        if (getAuthRequestContext()) {
            OnRedirectListener onRedirectListener = this.onRedirectListener;
            if (onRedirectListener != null) {
                onRedirectListener.KClassImpl$Data$declaredNonStaticMembers$2(TimerEventKey.FEED_OPEN);
            }
            Context context = getContext();
            Intent intent = new Intent(getContext(), FeedsActivity.class);
            intent.setFlags(603979776);
            intent.putExtra("source", FeedsSourceType.FEED_SETTINGS);
            context.startActivity(intent);
            return;
        }
        Context context2 = getContext();
        Intent intent2 = new Intent(getContext(), HomeTabActivity.class);
        intent2.putExtra("target", "friends");
        intent2.putExtra("Source", FeedsSourceType.FEED_SETTINGS);
        intent2.setFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
        context2.startActivity(intent2);
        getBaseActivity().finish();
    }

    private final void PlaceComponentResult(boolean p0) {
        ((SwitchCompat) _$_findCachedViewById(R.id.share_feed_switch)).setThumbTintList(AppCompatResources.getAuthRequestContext(getContext(), R.color.f27072131100488));
        if (p0) {
            ((SwitchCompat) _$_findCachedViewById(R.id.share_feed_switch)).setTrackTintList(AppCompatResources.getAuthRequestContext(getContext(), R.color.f22912131099753));
        } else {
            ((SwitchCompat) _$_findCachedViewById(R.id.share_feed_switch)).setTrackTintList(AppCompatResources.getAuthRequestContext(getContext(), R.color.f23962131099992));
        }
    }

    public static /* synthetic */ void $r8$lambda$41f9WPSnbL2q0gXOhDGDIu_YngU(NewFeedSharingView newFeedSharingView, View view) {
        Intrinsics.checkNotNullParameter(newFeedSharingView, "");
        newFeedSharingView.getContext().startActivity(new Intent(newFeedSharingView.getContext(), RestrictedContactActivity.class));
    }

    public static /* synthetic */ void $r8$lambda$KsJVWGxZf0q6UzRfpliGXbg98AA(NewFeedSharingView newFeedSharingView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(newFeedSharingView, "");
        newFeedSharingView.PlaceComponentResult(z);
    }

    public static /* synthetic */ void $r8$lambda$f3nQcGZs33MQdr8cOOI5N8lxiZY(NewFeedSharingView newFeedSharingView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(newFeedSharingView, "");
        newFeedSharingView.PlaceComponentResult(z);
        newFeedSharingView.getPrivacySettingPresenter().BuiltInFictitiousFunctionClassFactory(z);
    }

    public static /* synthetic */ void $r8$lambda$g_odfFt8ezQqtR5o9VrPp0e3zF8(NewFeedSharingView newFeedSharingView, View view) {
        Intrinsics.checkNotNullParameter(newFeedSharingView, "");
        ((MaterialDialog) newFeedSharingView.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).show();
    }

    public static /* synthetic */ void $r8$lambda$xsE1XQ07fVPEQPhhaOond4muvxo(NewFeedSharingView newFeedSharingView, View view) {
        Intrinsics.checkNotNullParameter(newFeedSharingView, "");
        newFeedSharingView.MyBillsEntityDataFactory();
    }

    public static final /* synthetic */ MaterialDialog access$getDeactivateDialog(NewFeedSharingView newFeedSharingView) {
        return (MaterialDialog) newFeedSharingView.KClassImpl$Data$declaredNonStaticMembers$2.getValue();
    }

    public static final /* synthetic */ LoadingDialog access$getLoadingDialog(NewFeedSharingView newFeedSharingView) {
        return (LoadingDialog) newFeedSharingView.MyBillsEntityDataFactory.getValue();
    }

    public static final /* synthetic */ void access$setShareFeedSwitchWithNoSideEffect(final NewFeedSharingView newFeedSharingView, boolean z) {
        SwitchCompat switchCompat = (SwitchCompat) newFeedSharingView._$_findCachedViewById(R.id.share_feed_switch);
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$$ExternalSyntheticLambda1
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    NewFeedSharingView.$r8$lambda$KsJVWGxZf0q6UzRfpliGXbg98AA(NewFeedSharingView.this, compoundButton, z2);
                }
            });
        }
        SwitchCompat switchCompat2 = (SwitchCompat) newFeedSharingView._$_findCachedViewById(R.id.share_feed_switch);
        if (switchCompat2 != null) {
            switchCompat2.setChecked(z);
        }
        SwitchCompat switchCompat3 = (SwitchCompat) newFeedSharingView._$_findCachedViewById(R.id.share_feed_switch);
        if (switchCompat3 != null) {
            switchCompat3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$$ExternalSyntheticLambda3
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    NewFeedSharingView.$r8$lambda$f3nQcGZs33MQdr8cOOI5N8lxiZY(NewFeedSharingView.this, compoundButton, z2);
                }
            });
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.ll_restricted_contacts);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewFeedSharingView.$r8$lambda$41f9WPSnbL2q0gXOhDGDIu_YngU(NewFeedSharingView.this, view);
                }
            });
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(R.id.ll_deactivate_feed);
        if (constraintLayout2 != null) {
            constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.myprofile.mepagerevamp.profilesettings.view.NewFeedSharingView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    NewFeedSharingView.$r8$lambda$g_odfFt8ezQqtR5o9VrPp0e3zF8(NewFeedSharingView.this, view);
                }
            });
        }
    }
}
