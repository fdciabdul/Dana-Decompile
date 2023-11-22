package id.dana.savings.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRichView;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerSavingConfigComponent;
import id.dana.di.modules.SavingConfigModule;
import id.dana.richview.HideableBalanceView;
import id.dana.savings.contract.SavingConfigContract;
import id.dana.savings.parser.SavingErrorParser;
import id.dana.savings.presenter.SavingConfigPresenter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00028\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u00020\u00138\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019"}, d2 = {"Lid/dana/savings/view/TotalSavingAmountView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "setup", "()V", "value", "PlaceComponentResult", "I", "getAmount", "setAmount", "(I)V", "amount", "Lid/dana/savings/presenter/SavingConfigPresenter;", "savingConfigPresenter", "Lid/dana/savings/presenter/SavingConfigPresenter;", "getSavingConfigPresenter", "()Lid/dana/savings/presenter/SavingConfigPresenter;", "setSavingConfigPresenter", "(Lid/dana/savings/presenter/SavingConfigPresenter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TotalSavingAmountView extends BaseRichView {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int amount;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public SavingConfigPresenter savingConfigPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TotalSavingAmountView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TotalSavingAmountView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_total_saving_amount;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TotalSavingAmountView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ TotalSavingAmountView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @JvmName(name = "getSavingConfigPresenter")
    public final SavingConfigPresenter getSavingConfigPresenter() {
        SavingConfigPresenter savingConfigPresenter = this.savingConfigPresenter;
        if (savingConfigPresenter != null) {
            return savingConfigPresenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSavingConfigPresenter")
    public final void setSavingConfigPresenter(SavingConfigPresenter savingConfigPresenter) {
        Intrinsics.checkNotNullParameter(savingConfigPresenter, "");
        this.savingConfigPresenter = savingConfigPresenter;
    }

    @JvmName(name = "getAmount")
    public final int getAmount() {
        return this.amount;
    }

    @JvmName(name = "setAmount")
    public final void setAmount(int i) {
        this.amount = i;
        String valueOf = String.valueOf(i);
        HideableBalanceView hideableBalanceView = (HideableBalanceView) _$_findCachedViewById(R.id.tv_hideable_balance);
        if (hideableBalanceView != null) {
            hideableBalanceView.setAmount(valueOf);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        Intrinsics.checkNotNullParameter(applicationComponent, "");
        DaggerSavingConfigComponent.Builder authRequestContext = DaggerSavingConfigComponent.getAuthRequestContext();
        authRequestContext.getAuthRequestContext = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2 = (SavingConfigModule) Preconditions.getAuthRequestContext(new SavingConfigModule(new SavingConfigContract.View() { // from class: id.dana.savings.view.TotalSavingAmountView$getSavingConfigModule$1
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

            @Override // id.dana.savings.contract.SavingConfigContract.View
            public final void getAuthRequestContext(boolean p0) {
                TotalSavingAmountView.access$setBalanceVisibility(TotalSavingAmountView.this, p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, SavingConfigModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(authRequestContext.getAuthRequestContext, ApplicationComponent.class);
        new DaggerSavingConfigComponent.SavingConfigComponentImpl(authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2, authRequestContext.getAuthRequestContext, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getSavingConfigPresenter());
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        HideableBalanceView hideableBalanceView = (HideableBalanceView) _$_findCachedViewById(R.id.tv_hideable_balance);
        if (hideableBalanceView != null) {
            hideableBalanceView.setTextSize(2, 24.0f);
        }
        HideableBalanceView hideableBalanceView2 = (HideableBalanceView) _$_findCachedViewById(R.id.tv_hideable_balance);
        if (hideableBalanceView2 != null) {
            hideableBalanceView2.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f27072131100488));
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.iv_hide_balance);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.savings.view.TotalSavingAmountView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TotalSavingAmountView.$r8$lambda$lfa_Cw73Rrj5a9Iirp4sNwyZDGQ(TotalSavingAmountView.this, view);
                }
            });
            boolean isSelected = imageView.isSelected();
            HideableBalanceView hideableBalanceView3 = (HideableBalanceView) _$_findCachedViewById(R.id.tv_hideable_balance);
            if (hideableBalanceView3 != null) {
                hideableBalanceView3.setBalanceVisibility(isSelected);
            }
        }
        getSavingConfigPresenter().getAuthRequestContext();
    }

    public static /* synthetic */ void $r8$lambda$lfa_Cw73Rrj5a9Iirp4sNwyZDGQ(TotalSavingAmountView totalSavingAmountView, View view) {
        Intrinsics.checkNotNullParameter(totalSavingAmountView, "");
        ImageView imageView = view instanceof ImageView ? (ImageView) view : null;
        if (imageView != null) {
            imageView.setSelected(!imageView.isSelected());
            boolean isSelected = imageView.isSelected();
            HideableBalanceView hideableBalanceView = (HideableBalanceView) totalSavingAmountView._$_findCachedViewById(R.id.tv_hideable_balance);
            if (hideableBalanceView != null) {
                hideableBalanceView.setBalanceVisibility(isSelected);
            }
            final SavingConfigPresenter savingConfigPresenter = totalSavingAmountView.getSavingConfigPresenter();
            final boolean isSelected2 = imageView.isSelected();
            savingConfigPresenter.BuiltInFictitiousFunctionClassFactory.showProgress();
            savingConfigPresenter.KClassImpl$Data$declaredNonStaticMembers$2.execute(Boolean.valueOf(isSelected2), new Function1<Boolean, Unit>() { // from class: id.dana.savings.presenter.SavingConfigPresenter$saveSavingBalanceVisibility$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    SavingConfigContract.View view2;
                    SavingConfigContract.View view3;
                    view2 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.dismissProgress();
                    if (z) {
                        view3 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                        view3.getAuthRequestContext(isSelected2);
                        SavingConfigPresenter.this.getAuthRequestContext = isSelected2;
                    }
                }
            }, new Function1<Throwable, Unit>() { // from class: id.dana.savings.presenter.SavingConfigPresenter$saveSavingBalanceVisibility$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    SavingConfigContract.View view2;
                    SavingConfigContract.View view3;
                    Context context;
                    SavingConfigContract.View view4;
                    boolean z;
                    Intrinsics.checkNotNullParameter(th, "");
                    view2 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    view2.dismissProgress();
                    view3 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    SavingErrorParser savingErrorParser = SavingErrorParser.INSTANCE;
                    context = SavingConfigPresenter.this.MyBillsEntityDataFactory;
                    view3.onError(SavingErrorParser.PlaceComponentResult(context, th.getLocalizedMessage()));
                    view4 = SavingConfigPresenter.this.BuiltInFictitiousFunctionClassFactory;
                    z = SavingConfigPresenter.this.getAuthRequestContext;
                    view4.getAuthRequestContext(z);
                }
            });
        }
    }

    public static final /* synthetic */ void access$setBalanceVisibility(TotalSavingAmountView totalSavingAmountView, boolean z) {
        ImageView imageView = (ImageView) totalSavingAmountView._$_findCachedViewById(R.id.iv_hide_balance);
        if (imageView != null) {
            imageView.setSelected(z);
        }
        HideableBalanceView hideableBalanceView = (HideableBalanceView) totalSavingAmountView._$_findCachedViewById(R.id.tv_hideable_balance);
        if (hideableBalanceView != null) {
            hideableBalanceView.setBalanceVisibility(z);
        }
    }
}
