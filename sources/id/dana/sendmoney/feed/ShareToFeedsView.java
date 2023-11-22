package id.dana.sendmoney.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.afollestad.materialdialogs.MaterialDialog;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.component.dialogcomponent.CustomDialog;
import id.dana.danah5.customdialog.CustomDialogKey;
import id.dana.di.component.ApplicationComponent;
import id.dana.social.FeedsIntroduction;
import id.dana.social.contract.share.ShareToFeedsContract;
import id.dana.social.contract.share.ShareToFeedsModule;
import id.dana.social.di.component.DaggerShareToFeedsComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u000103\u0012\b\b\u0002\u00105\u001a\u00020\u0005¢\u0006\u0004\b6\u00107B+\b\u0016\u0012\u0006\u00102\u001a\u000201\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\u0006\u00105\u001a\u00020\u0005\u0012\u0006\u00108\u001a\u00020\u0005¢\u0006\u0004\b6\u00109J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0014\u0010\u0004R\u0013\u0010\u0016\u001a\u00020\u0015X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0013\u0010\u001a\u001a\u00020\u0018X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\"\u0010\u001d\u001a\u00020\f8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u000fR\"\u0010%\u001a\u00020\u001f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010'\u001a\u00020&8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00100\u001a\u00020\f8\u0005@\u0005X\u0085\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u000f"}, d2 = {"Lid/dana/sendmoney/feed/ShareToFeedsView;", "Lid/dana/base/BaseRichView;", "", "autoEnableShareFeed", "()V", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "", "isInjected", "injected", "(Z)V", CustomDialogKey.Response.IS_CHECKED, "()Z", "isNeedToActivateFeedsSharing", "setup", "showActivateFeedSharingDialog", "Lcom/afollestad/materialdialogs/MaterialDialog;", "PlaceComponentResult", "Lkotlin/Lazy;", "Lid/dana/social/FeedsIntroduction;", "MyBillsEntityDataFactory", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Z", "isShareFeedFeatureEnabled", "setShareFeedFeatureEnabled", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "getOnActivateButtonClickListener", "()Landroid/view/View$OnClickListener;", "setOnActivateButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "onActivateButtonClickListener", "Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;", "presenter", "Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;", "getPresenter", "()Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;", "setPresenter", "(Lid/dana/social/contract/share/ShareToFeedsContract$Presenter;)V", "getAuthRequestContext", "getShareFeedConsent", "setShareFeedConsent", "shareFeedConsent", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public class ShareToFeedsView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private boolean isShareFeedFeatureEnabled;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private View.OnClickListener onActivateButtonClickListener;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean shareFeedConsent;
    @Inject
    public ShareToFeedsContract.Presenter presenter;

    /* renamed from: $r8$lambda$Y30w2c8TW6Rc8FwqE0r-ZgO1ceM  reason: not valid java name */
    public static /* synthetic */ void m2908$r8$lambda$Y30w2c8TW6Rc8FwqE0rZgO1ceM(View view) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareToFeedsView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShareToFeedsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i) {
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
    public int getLayout() {
        return R.layout.view_share_to_feed;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareToFeedsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<FeedsIntroduction>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedsIntroduction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsIntroduction invoke() {
                Context context2 = ShareToFeedsView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                return new FeedsIntroduction(context2);
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedSharingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = ShareToFeedsView.this.getContext();
                final ShareToFeedsView shareToFeedsView = ShareToFeedsView.this;
                Context context3 = shareToFeedsView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context3);
                builder.SubSequence = context2.getString(R.string.feed_sharing_activation_dialog_title);
                builder.GetContactSyncConfig = context2.getString(R.string.feed_sharing_activation_dialog_desc);
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2(context2.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedSharingDialog$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ShareToFeedsView.this._$_findCachedViewById(R.id.ConcurrentKt);
                        if (appCompatCheckBox != null) {
                            appCompatCheckBox.setChecked(false);
                        }
                        ShareToFeedsView.access$getFeedSharingDialog(ShareToFeedsView.this).dismiss();
                    }
                }).BuiltInFictitiousFunctionClassFactory(context2.getString(R.string.activate), new Function1<View, Unit>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedSharingDialog$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ShareToFeedsView.this._$_findCachedViewById(R.id.ConcurrentKt);
                        if (appCompatCheckBox != null) {
                            appCompatCheckBox.setChecked(true);
                        }
                        ShareToFeedsView.this.setShareFeedConsent(true);
                        ShareToFeedsView.access$getFeedSharingDialog(ShareToFeedsView.this).dismiss();
                        ShareToFeedsView.this.getOnActivateButtonClickListener().onClick(view);
                    }
                });
                BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
                return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.onActivateButtonClickListener = new View.OnClickListener() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareToFeedsView.m2908$r8$lambda$Y30w2c8TW6Rc8FwqE0rZgO1ceM(view);
            }
        };
    }

    public /* synthetic */ ShareToFeedsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShareToFeedsView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<FeedsIntroduction>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedsIntroduction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedsIntroduction invoke() {
                Context context2 = ShareToFeedsView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                return new FeedsIntroduction(context2);
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<MaterialDialog>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedSharingDialog$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MaterialDialog invoke() {
                Context context2 = ShareToFeedsView.this.getContext();
                final ShareToFeedsView shareToFeedsView = ShareToFeedsView.this;
                Context context3 = shareToFeedsView.getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "");
                CustomDialog.Builder builder = new CustomDialog.Builder(context3);
                builder.SubSequence = context2.getString(R.string.feed_sharing_activation_dialog_title);
                builder.GetContactSyncConfig = context2.getString(R.string.feed_sharing_activation_dialog_desc);
                CustomDialog.Builder BuiltInFictitiousFunctionClassFactory = builder.KClassImpl$Data$declaredNonStaticMembers$2(context2.getString(R.string.option_cancel), new Function1<View, Unit>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedSharingDialog$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ShareToFeedsView.this._$_findCachedViewById(R.id.ConcurrentKt);
                        if (appCompatCheckBox != null) {
                            appCompatCheckBox.setChecked(false);
                        }
                        ShareToFeedsView.access$getFeedSharingDialog(ShareToFeedsView.this).dismiss();
                    }
                }).BuiltInFictitiousFunctionClassFactory(context2.getString(R.string.activate), new Function1<View, Unit>() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$feedSharingDialog$2$1$2
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ShareToFeedsView.this._$_findCachedViewById(R.id.ConcurrentKt);
                        if (appCompatCheckBox != null) {
                            appCompatCheckBox.setChecked(true);
                        }
                        ShareToFeedsView.this.setShareFeedConsent(true);
                        ShareToFeedsView.access$getFeedSharingDialog(ShareToFeedsView.this).dismiss();
                        ShareToFeedsView.this.getOnActivateButtonClickListener().onClick(view);
                    }
                });
                BuiltInFictitiousFunctionClassFactory.moveToNextValue = 0L;
                return BuiltInFictitiousFunctionClassFactory.PlaceComponentResult(false).BuiltInFictitiousFunctionClassFactory();
            }
        });
        this.onActivateButtonClickListener = new View.OnClickListener() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShareToFeedsView.m2908$r8$lambda$Y30w2c8TW6Rc8FwqE0rZgO1ceM(view);
            }
        };
    }

    @JvmName(name = "getShareFeedConsent")
    public final boolean getShareFeedConsent() {
        return this.shareFeedConsent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @JvmName(name = "setShareFeedConsent")
    public final void setShareFeedConsent(boolean z) {
        this.shareFeedConsent = z;
    }

    @JvmName(name = "isShareFeedFeatureEnabled")
    /* renamed from: isShareFeedFeatureEnabled  reason: from getter */
    public final boolean getIsShareFeedFeatureEnabled() {
        return this.isShareFeedFeatureEnabled;
    }

    @JvmName(name = "setShareFeedFeatureEnabled")
    public final void setShareFeedFeatureEnabled(boolean z) {
        this.isShareFeedFeatureEnabled = z;
    }

    @JvmName(name = "getOnActivateButtonClickListener")
    public final View.OnClickListener getOnActivateButtonClickListener() {
        return this.onActivateButtonClickListener;
    }

    @JvmName(name = "setOnActivateButtonClickListener")
    public final void setOnActivateButtonClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "");
        this.onActivateButtonClickListener = onClickListener;
    }

    @JvmName(name = "getPresenter")
    public final ShareToFeedsContract.Presenter getPresenter() {
        ShareToFeedsContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(ShareToFeedsContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.getGrowthFactor);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ShareToFeedsView.$r8$lambda$ldQgSSOwvlPa8qZFvmWLyd4EWaY(ShareToFeedsView.this, view);
                }
            });
        }
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) _$_findCachedViewById(R.id.ConcurrentKt);
        if (appCompatCheckBox != null) {
            appCompatCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    ShareToFeedsView.$r8$lambda$p8uODefOmuVOj7mM47kKMS2oFnc(ShareToFeedsView.this, compoundButton, z);
                }
            });
        }
    }

    @Override // id.dana.base.BaseRichView
    public void injected(boolean isInjected) {
        if (!isInjected || this.presenter == null) {
            return;
        }
        getPresenter().PlaceComponentResult();
    }

    @Override // id.dana.base.BaseRichView
    public void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerShareToFeedsComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerShareToFeedsComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = (ShareToFeedsModule) Preconditions.getAuthRequestContext(new ShareToFeedsModule(new ShareToFeedsContract.View() { // from class: id.dana.sendmoney.feed.ShareToFeedsView$getShareToFeedsModule$1
            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final /* synthetic */ void MyBillsEntityDataFactory() {
                ShareToFeedsContract.View.CC.KClassImpl$Data$declaredNonStaticMembers$2();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final /* synthetic */ void getAuthRequestContext(boolean z) {
                ShareToFeedsContract.View.CC.getAuthRequestContext();
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

            @Override // id.dana.social.contract.share.ShareToFeedsContract.View
            public final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
                ShareToFeedsView.this.setShareFeedConsent(p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, ShareToFeedsModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, ApplicationComponent.class);
        new DaggerShareToFeedsComponent.ShareToFeedsComponentImpl(BuiltInFictitiousFunctionClassFactory.PlaceComponentResult, BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, (byte) 0).BuiltInFictitiousFunctionClassFactory(this);
        registerPresenter(getPresenter());
    }

    public final boolean isChecked() {
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) _$_findCachedViewById(R.id.ConcurrentKt);
        return (appCompatCheckBox != null ? appCompatCheckBox.isChecked() : false) && this.isShareFeedFeatureEnabled;
    }

    public final boolean isNeedToActivateFeedsSharing() {
        return isChecked() && !this.shareFeedConsent;
    }

    public final void autoEnableShareFeed() {
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) _$_findCachedViewById(R.id.ConcurrentKt);
        if (appCompatCheckBox != null) {
            appCompatCheckBox.setChecked(this.shareFeedConsent);
        }
    }

    public static /* synthetic */ void $r8$lambda$ldQgSSOwvlPa8qZFvmWLyd4EWaY(ShareToFeedsView shareToFeedsView, View view) {
        Intrinsics.checkNotNullParameter(shareToFeedsView, "");
        ((FeedsIntroduction) shareToFeedsView.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).MyBillsEntityDataFactory();
    }

    public static /* synthetic */ void $r8$lambda$p8uODefOmuVOj7mM47kKMS2oFnc(ShareToFeedsView shareToFeedsView, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(shareToFeedsView, "");
        if (z && !shareToFeedsView.shareFeedConsent && shareToFeedsView.isShareFeedFeatureEnabled) {
            shareToFeedsView.showActivateFeedSharingDialog();
        }
    }

    public static final /* synthetic */ MaterialDialog access$getFeedSharingDialog(ShareToFeedsView shareToFeedsView) {
        return (MaterialDialog) shareToFeedsView.PlaceComponentResult.getValue();
    }

    protected final void showActivateFeedSharingDialog() {
        ((MaterialDialog) this.PlaceComponentResult.getValue()).show();
    }
}
