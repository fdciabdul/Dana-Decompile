package id.dana.investment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.danah5.DanaH5;
import id.dana.databinding.ViewHomeInvestmentBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerInvestmentComponent;
import id.dana.di.component.InvestmentComponent;
import id.dana.di.modules.InvestmentModule;
import id.dana.domain.investment.AccountInvestmentStatus;
import id.dana.investment.contract.InvestmentContract;
import id.dana.investment.model.MultiCurrencyMoneyViewModel;
import id.dana.investment.model.UserInvestmentModel;
import id.dana.investment.view.HomeInvestmentView;
import id.dana.utils.DateTimeUtil;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B'\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u000101\u0012\b\b\u0002\u00103\u001a\u00020\u0006¢\u0006\u0004\b4\u00105B+\b\u0016\u0012\u0006\u00100\u001a\u00020/\u0012\b\u00102\u001a\u0004\u0018\u000101\u0012\u0006\u00103\u001a\u00020\u0006\u0012\u0006\u00106\u001a\u00020\u0006¢\u0006\u0004\b4\u00107J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0010\u0010\u0005J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0005J1\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0005R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR(\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010.\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-"}, d2 = {"Lid/dana/investment/view/HomeInvestmentView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewHomeInvestmentBinding;", "", "disposeByActivity", "()V", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewHomeInvestmentBinding;", "", "isForRecyclerViewholder", "()Z", "onAttachedToWindow", "refreshPortfolio", "p0", "", "p1", "p2", "Lid/dana/investment/model/MultiCurrencyMoneyViewModel;", "p3", "MyBillsEntityDataFactory", "(ILjava/lang/String;Ljava/lang/String;Lid/dana/investment/model/MultiCurrencyMoneyViewModel;)V", "(II)V", "setup", "Lid/dana/di/component/InvestmentComponent;", "getAuthRequestContext", "Lid/dana/di/component/InvestmentComponent;", "Ldagger/Lazy;", "Lid/dana/investment/contract/InvestmentContract$Presenter;", "investmentPresenter", "Ldagger/Lazy;", "getInvestmentPresenter", "()Ldagger/Lazy;", "setInvestmentPresenter", "(Ldagger/Lazy;)V", "Lid/dana/investment/view/HomeInvestmentView$InvestmentViewListener;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/investment/view/HomeInvestmentView$InvestmentViewListener;", "getListener", "()Lid/dana/investment/view/HomeInvestmentView$InvestmentViewListener;", "setListener", "(Lid/dana/investment/view/HomeInvestmentView$InvestmentViewListener;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "InvestmentViewListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomeInvestmentView extends ViewBindingRichView<ViewHomeInvestmentBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private InvestmentViewListener listener;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private InvestmentComponent MyBillsEntityDataFactory;
    @Inject
    public Lazy<InvestmentContract.Presenter> investmentPresenter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/investment/view/HomeInvestmentView$InvestmentViewListener;", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface InvestmentViewListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeInvestmentView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomeInvestmentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_home_investment;
    }

    @Override // id.dana.base.BaseRichView
    public final boolean isForRecyclerViewholder() {
        return true;
    }

    @JvmName(name = "getInvestmentPresenter")
    public final Lazy<InvestmentContract.Presenter> getInvestmentPresenter() {
        Lazy<InvestmentContract.Presenter> lazy = this.investmentPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setInvestmentPresenter")
    public final void setInvestmentPresenter(Lazy<InvestmentContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.investmentPresenter = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeInvestmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ HomeInvestmentView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeInvestmentView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getListener")
    public final InvestmentViewListener getListener() {
        return this.listener;
    }

    @JvmName(name = "setListener")
    public final void setListener(InvestmentViewListener investmentViewListener) {
        this.listener = investmentViewListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewHomeInvestmentBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewHomeInvestmentBinding BuiltInFictitiousFunctionClassFactory = ViewHomeInvestmentBinding.BuiltInFictitiousFunctionClassFactory(view);
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        return BuiltInFictitiousFunctionClassFactory;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getBinding().scheduleImpl.KClassImpl$Data$declaredNonStaticMembers$2.setText(R.string.dana_plus_title);
        getBinding().scheduleImpl.MyBillsEntityDataFactory.setText(R.string.dana_plus_home_subtitle);
        getBinding().scheduleImpl.getAuthRequestContext.setActiveButton(getContext().getString(R.string.top_up), null);
        if (this.MyBillsEntityDataFactory == null) {
            DaggerInvestmentComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerInvestmentComponent.BuiltInFictitiousFunctionClassFactory();
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(getApplicationComponent());
            BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = (InvestmentModule) Preconditions.getAuthRequestContext(new InvestmentModule(new InvestmentContract.View() { // from class: id.dana.investment.view.HomeInvestmentView$getInvestmentModule$1
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

                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void getAuthRequestContext(boolean p0) {
                    if (p0) {
                        HomeInvestmentView.this.getInvestmentPresenter().get().getAuthRequestContext();
                        return;
                    }
                    HomeInvestmentView.InvestmentViewListener listener = HomeInvestmentView.this.getListener();
                    if (listener != null) {
                        listener.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }

                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void KClassImpl$Data$declaredNonStaticMembers$2() {
                    HomeInvestmentView.InvestmentViewListener listener = HomeInvestmentView.this.getListener();
                    if (listener != null) {
                        listener.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }

                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void MyBillsEntityDataFactory(UserInvestmentModel p0) {
                    ViewHomeInvestmentBinding binding;
                    ViewHomeInvestmentBinding binding2;
                    Intrinsics.checkNotNullParameter(p0, "");
                    HomeInvestmentView.InvestmentViewListener listener = HomeInvestmentView.this.getListener();
                    if (listener != null) {
                        listener.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                    if (p0.PlaceComponentResult == AccountInvestmentStatus.ACTIVE) {
                        binding2 = HomeInvestmentView.this.getBinding();
                        FrameLayout frameLayout = binding2.BuiltInFictitiousFunctionClassFactory;
                        Intrinsics.checkNotNullExpressionValue(frameLayout, "");
                        frameLayout.setVisibility(0);
                        HomeInvestmentView.access$renderInvestmentView(HomeInvestmentView.this, p0);
                        return;
                    }
                    binding = HomeInvestmentView.this.getBinding();
                    FrameLayout frameLayout2 = binding.BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(frameLayout2, "");
                    frameLayout2.setVisibility(8);
                }

                @Override // id.dana.investment.contract.InvestmentContract.View
                public final void BuiltInFictitiousFunctionClassFactory() {
                    HomeInvestmentView.InvestmentViewListener listener = HomeInvestmentView.this.getListener();
                    if (listener != null) {
                        listener.KClassImpl$Data$declaredNonStaticMembers$2();
                    }
                }
            }));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, InvestmentModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
            DaggerInvestmentComponent.InvestmentComponentImpl investmentComponentImpl = new DaggerInvestmentComponent.InvestmentComponentImpl(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0);
            this.MyBillsEntityDataFactory = investmentComponentImpl;
            investmentComponentImpl.getAuthRequestContext(this);
            registerPresenter(getInvestmentPresenter().get());
        }
        getInvestmentPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getBinding().scheduleImpl.getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.investment.view.HomeInvestmentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DanaH5.startContainerFullUrl("https://m.dana.id/i/dana-finance/mmf/topup");
            }
        });
    }

    public final void refreshPortfolio() {
        if (isInflated()) {
            getInvestmentPresenter().get().KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    private final void MyBillsEntityDataFactory(int p0, String p1, String p2, MultiCurrencyMoneyViewModel p3) {
        getBinding().scheduleImpl.MyBillsEntityDataFactory.setText(getContext().getString(p0));
        getBinding().lookAheadTest.setText(p1);
        getBinding().NetworkUserEntityData$$ExternalSyntheticLambda0.setText(p2);
        if (p3 != null) {
            getBinding().getAuthRequestContext.setText(p3.MyBillsEntityDataFactory());
            if (p3.PlaceComponentResult()) {
                MyBillsEntityDataFactory(R.color.f26712131100373, R.drawable.ic_investment_loss);
            } else {
                MyBillsEntityDataFactory(R.color.res_0x7f06014c_networkuserentitydata_externalsyntheticlambda0, R.drawable.ic_investment_gain);
            }
        }
    }

    private final void MyBillsEntityDataFactory(int p0, int p1) {
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(getBinding().MyBillsEntityDataFactory, p1);
        getBinding().getAuthRequestContext.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), p0));
    }

    public final void disposeByActivity() {
        getInvestmentPresenter().get().onDestroy();
    }

    public static final /* synthetic */ void access$renderInvestmentView(HomeInvestmentView homeInvestmentView, UserInvestmentModel userInvestmentModel) {
        String str;
        Long l;
        MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel = userInvestmentModel.MyBillsEntityDataFactory;
        if ((multiCurrencyMoneyViewModel == null || (l = multiCurrencyMoneyViewModel.BuiltInFictitiousFunctionClassFactory) == null || l.longValue() != 0) ? false : true) {
            String string = homeInvestmentView.getContext().getString(R.string.investment_balance_title_empty);
            Intrinsics.checkNotNullExpressionValue(string, "");
            String string2 = homeInvestmentView.getContext().getString(R.string.investment_balance_subtitle_empty);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            homeInvestmentView.MyBillsEntityDataFactory(R.string.investment_home_balance_description_empty, string, string2, null);
            AppCompatImageView appCompatImageView = homeInvestmentView.getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            appCompatImageView.setVisibility(8);
            AppCompatTextView appCompatTextView = homeInvestmentView.getBinding().getAuthRequestContext;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            appCompatTextView.setVisibility(8);
            TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(homeInvestmentView.getBinding().lookAheadTest, (int) R.style.f54172132017913);
            return;
        }
        MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel2 = userInvestmentModel.MyBillsEntityDataFactory;
        String MyBillsEntityDataFactory = multiCurrencyMoneyViewModel2 != null ? multiCurrencyMoneyViewModel2.MyBillsEntityDataFactory() : null;
        Intrinsics.checkNotNull(MyBillsEntityDataFactory);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Context context = homeInvestmentView.getContext();
        Object[] objArr = new Object[1];
        Long l2 = userInvestmentModel.getErrorConfigVersion;
        if (l2 != null) {
            Long l3 = l2.longValue() > 0 ? l2 : null;
            if (l3 != null) {
                str = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("dd/MM/yy", Locale.getDefault(), l3.longValue());
                Intrinsics.checkNotNullExpressionValue(str, "");
                objArr[0] = str;
                String string3 = context.getString(R.string.dana_plus_home_last_updated, objArr);
                Intrinsics.checkNotNullExpressionValue(string3, "");
                String format = String.format(string3, Arrays.copyOf(new Object[0], 0));
                Intrinsics.checkNotNullExpressionValue(format, "");
                homeInvestmentView.MyBillsEntityDataFactory(R.string.dana_plus_home_subtitle, MyBillsEntityDataFactory, format, userInvestmentModel.scheduleImpl);
                TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(homeInvestmentView.getBinding().lookAheadTest, (int) R.style.f54202132017916);
            }
        }
        str = "";
        objArr[0] = str;
        String string32 = context.getString(R.string.dana_plus_home_last_updated, objArr);
        Intrinsics.checkNotNullExpressionValue(string32, "");
        String format2 = String.format(string32, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "");
        homeInvestmentView.MyBillsEntityDataFactory(R.string.dana_plus_home_subtitle, MyBillsEntityDataFactory, format2, userInvestmentModel.scheduleImpl);
        TextViewCompat.KClassImpl$Data$declaredNonStaticMembers$2(homeInvestmentView.getBinding().lookAheadTest, (int) R.style.f54202132017916);
    }
}
