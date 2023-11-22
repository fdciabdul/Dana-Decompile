package id.dana.richview.boundcard;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewKt;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.contract.deeplink.path.FeatureSaving;
import id.dana.danah5.DanaH5;
import id.dana.data.dynamicurl.DynamicUrlWrapper;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerWalletComponent;
import id.dana.di.modules.SavingModule;
import id.dana.extension.view.ViewExtKt;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.richview.ToggleBalanceView;
import id.dana.richview.boundcard.model.BoundCard;
import id.dana.savings.contract.SavingContract;
import id.dana.savings.contract.SavingViewListener;
import id.dana.savings.model.SavingSummaryModel;
import id.dana.utils.LocaleUtil;
import id.dana.utils.MaskedTextUtil;
import id.dana.utils.danah5.DanaH5Listener;
import java.text.NumberFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u0001:\u0002<=B'\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u0002¢\u0006\u0004\b8\u00109B+\b\u0016\u0012\u0006\u00104\u001a\u000203\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00107\u001a\u00020\u0002\u0012\u0006\u0010:\u001a\u00020\u0002¢\u0006\u0004\b8\u0010;J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0007R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R(\u0010\u001f\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00178G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u00020 8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010'R\"\u0010)\u001a\u00020(8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b1\u00102"}, d2 = {"Lid/dana/richview/boundcard/DanaBalanceCardView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V", "Lid/dana/richview/boundcard/DanaBalanceCardView$OnBalanceCardViewListener;", "onBalanceCardViewListener", "initListener", "(Lid/dana/richview/boundcard/DanaBalanceCardView$OnBalanceCardViewListener;)V", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "onAttachedToWindow", "BuiltInFictitiousFunctionClassFactory", "", "entryPoint", "setEntryPoint", "(Ljava/lang/String;)V", "setup", "Lid/dana/richview/boundcard/model/BoundCard;", "MyBillsEntityDataFactory", "Lid/dana/richview/boundcard/model/BoundCard;", "boundCard", "getData", "()Lid/dana/richview/boundcard/model/BoundCard;", "setData", "(Lid/dana/richview/boundcard/model/BoundCard;)V", "data", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "dynamicUrlWrapper", "Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "getDynamicUrlWrapper", "()Lid/dana/data/dynamicurl/DynamicUrlWrapper;", "setDynamicUrlWrapper", "(Lid/dana/data/dynamicurl/DynamicUrlWrapper;)V", "Ljava/lang/String;", "Lid/dana/savings/contract/SavingContract$Presenter;", "goalsPresenter", "Lid/dana/savings/contract/SavingContract$Presenter;", "getGoalsPresenter", "()Lid/dana/savings/contract/SavingContract$Presenter;", "setGoalsPresenter", "(Lid/dana/savings/contract/SavingContract$Presenter;)V", "Lid/dana/richview/boundcard/DanaBalanceCardView$OnBalanceCardViewListener;", "Lid/dana/richview/ToggleBalanceView;", "PlaceComponentResult", "Lid/dana/richview/ToggleBalanceView;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "OnBalanceCardViewListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class DanaBalanceCardView extends BaseRichView {
    public static final long LOADING_ANIMATION_DELAYED = 1000;
    private OnBalanceCardViewListener BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private BoundCard KClassImpl$Data$declaredNonStaticMembers$2;
    private ToggleBalanceView PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public DynamicUrlWrapper dynamicUrlWrapper;
    @Inject
    public SavingContract.Presenter goalsPresenter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/richview/boundcard/DanaBalanceCardView$OnBalanceCardViewListener;", "", "", "getAuthRequestContext", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public interface OnBalanceCardViewListener {
        void getAuthRequestContext();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaBalanceCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DanaBalanceCardView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_base_dana_balance_card;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaBalanceCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = new ToggleBalanceView(getContext());
    }

    public /* synthetic */ DanaBalanceCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanaBalanceCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = new ToggleBalanceView(getContext());
    }

    @JvmName(name = "getDynamicUrlWrapper")
    public final DynamicUrlWrapper getDynamicUrlWrapper() {
        DynamicUrlWrapper dynamicUrlWrapper = this.dynamicUrlWrapper;
        if (dynamicUrlWrapper != null) {
            return dynamicUrlWrapper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setDynamicUrlWrapper")
    public final void setDynamicUrlWrapper(DynamicUrlWrapper dynamicUrlWrapper) {
        Intrinsics.checkNotNullParameter(dynamicUrlWrapper, "");
        this.dynamicUrlWrapper = dynamicUrlWrapper;
    }

    @JvmName(name = "getGoalsPresenter")
    public final SavingContract.Presenter getGoalsPresenter() {
        SavingContract.Presenter presenter = this.goalsPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setGoalsPresenter")
    public final void setGoalsPresenter(SavingContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.goalsPresenter = presenter;
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerWalletComponent.Builder authRequestContext = DaggerWalletComponent.getAuthRequestContext();
        authRequestContext.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.getAuthRequestContext = (SavingModule) Preconditions.getAuthRequestContext(new SavingModule(new SavingViewListener() { // from class: id.dana.richview.boundcard.DanaBalanceCardView$injectComponent$1
            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void MyBillsEntityDataFactory() {
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void PlaceComponentResult() {
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void getAuthRequestContext(boolean p0) {
                ConstraintLayout constraintLayout = (ConstraintLayout) DanaBalanceCardView.this._$_findCachedViewById(R.id.res_0x7f0a0414_imagecaptureviewmodel_gettipuploadphoto_1);
                if (constraintLayout != null) {
                    constraintLayout.setVisibility(p0 ^ true ? 0 : 8);
                }
                ConstraintLayout constraintLayout2 = (ConstraintLayout) DanaBalanceCardView.this._$_findCachedViewById(R.id.cl_card_dana_goal_balance);
                if (constraintLayout2 != null) {
                    constraintLayout2.setVisibility(p0 ? 0 : 8);
                }
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.savings.contract.SavingContract.View
            public final void MyBillsEntityDataFactory(SavingSummaryModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaBalanceCardView.access$setGoalAndTotalBalance(DanaBalanceCardView.this, p0);
                DanaBalanceCardView.access$setGoalBalanceClickListener(DanaBalanceCardView.this);
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void showProgress() {
                DanaBalanceCardView.access$startThreeDotsLoadingBalance(DanaBalanceCardView.this, true);
                AppCompatTextView appCompatTextView = (AppCompatTextView) DanaBalanceCardView.this._$_findCachedViewById(R.id.tv_goal_balance_content);
                if (appCompatTextView != null) {
                    appCompatTextView.setClickable(false);
                }
            }

            @Override // id.dana.savings.contract.SavingViewListener, id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final void dismissProgress() {
                ViewKt.MyBillsEntityDataFactory(r0, new Function0<Unit>() { // from class: id.dana.richview.boundcard.DanaBalanceCardView$delayLoadingAnimationBalance$1
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
                        AppCompatTextView appCompatTextView = (AppCompatTextView) DanaBalanceCardView.this._$_findCachedViewById(R.id.tv_goal_balance_content);
                        CharSequence text = appCompatTextView != null ? appCompatTextView.getText() : null;
                        if (text == null || StringsKt.isBlank(text)) {
                            ThreeDotsLoadingLottieAnimationView threeDotsLoadingLottieAnimationView = (ThreeDotsLoadingLottieAnimationView) DanaBalanceCardView.this._$_findCachedViewById(R.id.lav_loading_goal_balance);
                            if (threeDotsLoadingLottieAnimationView != null) {
                                threeDotsLoadingLottieAnimationView.setVisibility(0);
                            }
                            ThreeDotsLoadingLottieAnimationView threeDotsLoadingLottieAnimationView2 = (ThreeDotsLoadingLottieAnimationView) DanaBalanceCardView.this._$_findCachedViewById(R.id.lav_loading_total_balance);
                            if (threeDotsLoadingLottieAnimationView2 != null) {
                                threeDotsLoadingLottieAnimationView2.setVisibility(0);
                                return;
                            }
                            return;
                        }
                        DanaBalanceCardView.access$startThreeDotsLoadingBalance(DanaBalanceCardView.this, false);
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) DanaBalanceCardView.this._$_findCachedViewById(R.id.tv_goal_balance_content);
                        if (appCompatTextView2 != null) {
                            appCompatTextView2.setClickable(true);
                        }
                    }
                });
            }
        }));
        authRequestContext.BuiltInFictitiousFunctionClassFactory().PlaceComponentResult(this);
        registerPresenter(getGoalsPresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getGoalsPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
        getGoalsPresenter().MyBillsEntityDataFactory();
        BuiltInFictitiousFunctionClassFactory();
        TextView textView = (TextView) _$_findCachedViewById(R.id.SubscriptionIntervalType);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.boundcard.DanaBalanceCardView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaBalanceCardView.$r8$lambda$e5inK3BpAne8wjZbGwW8Yyp8vZ8(DanaBalanceCardView.this, view);
                }
            });
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.tv_goal_pay_topup_button);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.boundcard.DanaBalanceCardView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaBalanceCardView.$r8$lambda$MHhdi5gtfZBBUMq0FxHV3QLsTng(DanaBalanceCardView.this, view);
                }
            });
        }
        View findViewById = findViewById(R.id.tbv_pay_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        ToggleBalanceView toggleBalanceView = (ToggleBalanceView) findViewById;
        this.PlaceComponentResult = toggleBalanceView;
        toggleBalanceView.setToggleBalanceClickListener(new ToggleBalanceView.ToggleBalanceClickListener() { // from class: id.dana.richview.boundcard.DanaBalanceCardView$$ExternalSyntheticLambda3
            @Override // id.dana.richview.ToggleBalanceView.ToggleBalanceClickListener
            public final void PlaceComponentResult(boolean z) {
                DanaBalanceCardView.$r8$lambda$azsurd8QzynRDXYqQdUnUjfHBDc(DanaBalanceCardView.this, z);
            }
        });
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2() {
        String topupUrl = getDynamicUrlWrapper().getTopupUrl(this.MyBillsEntityDataFactory);
        Intrinsics.checkNotNullExpressionValue(topupUrl, "");
        DanaH5.startContainerFullUrl(topupUrl, new DanaH5Listener() { // from class: id.dana.richview.boundcard.DanaBalanceCardView$gotoTopupPage$1
            @Override // id.dana.utils.danah5.DanaH5Listener
            public final /* synthetic */ void onContainerCreated(Bundle bundle) {
                DanaH5Listener.CC.getAuthRequestContext();
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
            
                r1 = r0.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
             */
            @Override // id.dana.utils.danah5.DanaH5Listener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onContainerDestroyed(android.os.Bundle r1) {
                /*
                    r0 = this;
                    id.dana.richview.boundcard.DanaBalanceCardView r1 = id.dana.richview.boundcard.DanaBalanceCardView.this
                    id.dana.richview.boundcard.DanaBalanceCardView$OnBalanceCardViewListener r1 = id.dana.richview.boundcard.DanaBalanceCardView.access$getOnBalanceCardViewListener$p(r1)
                    if (r1 == 0) goto L13
                    id.dana.richview.boundcard.DanaBalanceCardView r1 = id.dana.richview.boundcard.DanaBalanceCardView.this
                    id.dana.richview.boundcard.DanaBalanceCardView$OnBalanceCardViewListener r1 = id.dana.richview.boundcard.DanaBalanceCardView.access$getOnBalanceCardViewListener$p(r1)
                    if (r1 == 0) goto L13
                    r1.getAuthRequestContext()
                L13:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.boundcard.DanaBalanceCardView$gotoTopupPage$1.onContainerDestroyed(android.os.Bundle):void");
            }
        });
    }

    public final void setEntryPoint(String entryPoint) {
        this.MyBillsEntityDataFactory = entryPoint;
    }

    @JvmName(name = "getData")
    /* renamed from: getData  reason: from getter */
    public final BoundCard getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "setData")
    public final void setData(BoundCard boundCard) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = boundCard;
        BuiltInFictitiousFunctionClassFactory();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        TextView textView;
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null || ((ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0414_imagecaptureviewmodel_gettipuploadphoto_1)) == null) {
            return;
        }
        BoundCard boundCard = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNull(boundCard);
        if (MaskedTextUtil.PlaceComponentResult(boundCard.isLayoutRequested, "****") == null || (textView = (TextView) _$_findCachedViewById(R.id.tv_mask_number)) == null) {
            return;
        }
        BoundCard boundCard2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNull(boundCard2);
        textView.setText(MaskedTextUtil.BuiltInFictitiousFunctionClassFactory(MaskedTextUtil.PlaceComponentResult(boundCard2.isLayoutRequested, "****"), true));
    }

    public final void initListener(OnBalanceCardViewListener onBalanceCardViewListener) {
        this.BuiltInFictitiousFunctionClassFactory = onBalanceCardViewListener;
    }

    /* renamed from: $r8$lambda$5iW7HUeoGE-7EE7YRSKMBqJRlnc  reason: not valid java name */
    public static /* synthetic */ void m2831$r8$lambda$5iW7HUeoGE7EE7YRSKMBqJRlnc(DanaBalanceCardView danaBalanceCardView, View view) {
        Intrinsics.checkNotNullParameter(danaBalanceCardView, "");
        BaseActivity baseActivity = danaBalanceCardView.getBaseActivity();
        Intrinsics.checkNotNullExpressionValue(baseActivity, "");
        FeatureSaving.BuiltInFictitiousFunctionClassFactory(baseActivity, MapsKt.mapOf(TuplesKt.to("source", TrackerKey.SourceType.WALLET_CARD)));
    }

    public static /* synthetic */ void $r8$lambda$MHhdi5gtfZBBUMq0FxHV3QLsTng(DanaBalanceCardView danaBalanceCardView, View view) {
        Intrinsics.checkNotNullParameter(danaBalanceCardView, "");
        danaBalanceCardView.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void $r8$lambda$azsurd8QzynRDXYqQdUnUjfHBDc(DanaBalanceCardView danaBalanceCardView, boolean z) {
        Intrinsics.checkNotNullParameter(danaBalanceCardView, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_goal_balance_content);
        if (appCompatTextView != null) {
            ViewExtKt.MyBillsEntityDataFactory(appCompatTextView, z, 8);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_total_balance_content);
        if (appCompatTextView2 != null) {
            ViewExtKt.MyBillsEntityDataFactory(appCompatTextView2, z, 8);
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_goal_balance_hide);
        if (appCompatTextView3 != null) {
            ViewExtKt.MyBillsEntityDataFactory(appCompatTextView3, !z, 8);
        }
        AppCompatTextView appCompatTextView4 = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_total_balance_hide);
        if (appCompatTextView4 != null) {
            ViewExtKt.MyBillsEntityDataFactory(appCompatTextView4, !z, 8);
        }
    }

    public static /* synthetic */ void $r8$lambda$e5inK3BpAne8wjZbGwW8Yyp8vZ8(DanaBalanceCardView danaBalanceCardView, View view) {
        Intrinsics.checkNotNullParameter(danaBalanceCardView, "");
        danaBalanceCardView.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static final /* synthetic */ void access$setGoalAndTotalBalance(DanaBalanceCardView danaBalanceCardView, SavingSummaryModel savingSummaryModel) {
        String format;
        String format2;
        Locale authRequestContext = LocaleUtil.getAuthRequestContext();
        MoneyViewModel moneyViewModel = savingSummaryModel.moveToNextValue;
        Long l = null;
        Long valueOf = moneyViewModel != null ? Long.valueOf(moneyViewModel.BuiltInFictitiousFunctionClassFactory()) : null;
        format = NumberFormat.getNumberInstance(authRequestContext).format(valueOf != null ? valueOf.longValue() : 0L);
        MoneyViewModel moneyViewModel2 = savingSummaryModel.moveToNextValue;
        Long valueOf2 = moneyViewModel2 != null ? Long.valueOf(moneyViewModel2.BuiltInFictitiousFunctionClassFactory()) : null;
        MoneyViewModel activeBalance = danaBalanceCardView.PlaceComponentResult.getActiveBalance();
        Long valueOf3 = activeBalance != null ? Long.valueOf(activeBalance.BuiltInFictitiousFunctionClassFactory()) : null;
        if (valueOf3 != null) {
            long longValue = valueOf3.longValue();
            if (valueOf2 != null) {
                l = Long.valueOf(valueOf2.longValue() + longValue);
            }
        }
        format2 = NumberFormat.getNumberInstance(LocaleUtil.getAuthRequestContext()).format(l != null ? l.longValue() : 0L);
        Intrinsics.checkNotNullExpressionValue(format2, "");
        AppCompatTextView appCompatTextView = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_goal_balance_content);
        if (appCompatTextView != null) {
            appCompatTextView.setText(format);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_total_balance_content);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(format2);
        }
    }

    public static final /* synthetic */ void access$setGoalBalanceClickListener(final DanaBalanceCardView danaBalanceCardView) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_goal_balance_content);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.richview.boundcard.DanaBalanceCardView$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DanaBalanceCardView.m2831$r8$lambda$5iW7HUeoGE7EE7YRSKMBqJRlnc(DanaBalanceCardView.this, view);
                }
            });
        }
    }

    public static final /* synthetic */ void access$startThreeDotsLoadingBalance(DanaBalanceCardView danaBalanceCardView, boolean z) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_goal_balance_symbol);
        if (appCompatTextView != null) {
            ViewExtKt.MyBillsEntityDataFactory(appCompatTextView, !z, 4);
        }
        LinearLayout linearLayout = (LinearLayout) danaBalanceCardView._$_findCachedViewById(R.id.KybServiceActionTypeStrategy_Factory);
        if (linearLayout != null) {
            ViewExtKt.MyBillsEntityDataFactory(linearLayout, !z, 8);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) danaBalanceCardView._$_findCachedViewById(R.id.tv_total_balance_symbol);
        if (appCompatTextView2 != null) {
            ViewExtKt.MyBillsEntityDataFactory(appCompatTextView2, !z, 4);
        }
        LinearLayout linearLayout2 = (LinearLayout) danaBalanceCardView._$_findCachedViewById(R.id.ll_total_balance);
        if (linearLayout2 != null) {
            ViewExtKt.MyBillsEntityDataFactory(linearLayout2, !z, 4);
        }
        ThreeDotsLoadingLottieAnimationView threeDotsLoadingLottieAnimationView = (ThreeDotsLoadingLottieAnimationView) danaBalanceCardView._$_findCachedViewById(R.id.lav_loading_goal_balance);
        if (threeDotsLoadingLottieAnimationView != null) {
            ViewExtKt.MyBillsEntityDataFactory(threeDotsLoadingLottieAnimationView, z, 8);
        }
        ThreeDotsLoadingLottieAnimationView threeDotsLoadingLottieAnimationView2 = (ThreeDotsLoadingLottieAnimationView) danaBalanceCardView._$_findCachedViewById(R.id.lav_loading_total_balance);
        if (threeDotsLoadingLottieAnimationView2 != null) {
            ViewExtKt.MyBillsEntityDataFactory(threeDotsLoadingLottieAnimationView2, z, 8);
        }
    }
}
