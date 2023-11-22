package id.dana.sendmoney_v2.paymethod;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.ariver.kernel.RVEvents;
import com.anggrayudi.storage.extension.ContextUtils;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.contract.sendmoney.PayMethodContract;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.dialog.WarningDialogUtil;
import id.dana.databinding.ViewChangePayMethodListBinding;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerPayMethodComponent;
import id.dana.di.component.PayMethodComponent;
import id.dana.di.modules.PayMethodModule;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.model.CurrencyAmountModel;
import id.dana.model.PayMethodModel;
import id.dana.sendmoney.paymethod.PayMethodAdapter;
import id.dana.sendmoney.premium.PremiumNoticeActivity;
import id.dana.sendmoney_v2.paymethod.helper.ChangePayMethodViewHelper;
import id.dana.sendmoney_v2.paymethod.mapper.PayMethodMapper;
import id.dana.utils.ErrorUtil;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001NB'\b\u0016\u0012\u0006\u0010E\u001a\u00020D\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010F\u0012\b\b\u0002\u0010I\u001a\u00020H¢\u0006\u0004\bJ\u0010KB+\b\u0016\u0012\u0006\u0010E\u001a\u00020D\u0012\b\u0010G\u001a\u0004\u0018\u00010F\u0012\u0006\u0010I\u001a\u00020H\u0012\u0006\u0010L\u001a\u00020H¢\u0006\u0004\bJ\u0010MJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u000bJ\u0019\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ)\u0010#\u001a\u00020\t2\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH\u0002¢\u0006\u0004\b%\u0010\u000bJ\u0017\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020 H\u0002¢\u0006\u0004\b\u0007\u0010&J\u0015\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u000bJ\u000f\u0010,\u001a\u00020\tH\u0016¢\u0006\u0004\b,\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020 H\u0002¢\u0006\u0004\b\f\u0010&R\u0016\u0010%\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010.R\"\u00101\u001a\u0002008\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0018\u0010\u0007\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00108R\"\u0010:\u001a\u0002098\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010@R\u0018\u0010\f\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010C"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/PayMethodView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewChangePayMethodListBinding;", "Lid/dana/contract/sendmoney/PayMethodContract$View;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "", "dismissProgress", "()V", "getAuthRequestContext", "recipientType", "Lid/dana/domain/sendmoney/model/TransferInit;", "transferInit", "fetchData", "(Ljava/lang/String;Lid/dana/domain/sendmoney/model/TransferInit;)V", "inflateViewBinding", "()Lid/dana/databinding/ViewChangePayMethodListBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "errorMessage", RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/String;)V", "onGetDefaultCardError", WalletConstant.CARD_INDEX_NO, "onGetDefaultCardSuccess", "onGetPayMethodError", "", "Lid/dana/model/PayMethodModel;", "payMethodModels", WalletConstant.KYC_LEVEL, "onGetPayMethodListSuccess", "(Ljava/util/List;Ljava/lang/String;)V", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/model/PayMethodModel;)V", "Lid/dana/sendmoney_v2/paymethod/PayMethodView$PayMethodListener;", "changePayMethodListener", "setChangePayMethodListener", "(Lid/dana/sendmoney_v2/paymethod/PayMethodView$PayMethodListener;)V", "setup", "showProgress", "Z", "Lid/dana/sendmoney_v2/paymethod/PayMethodView$PayMethodListener;", "PlaceComponentResult", "Lid/dana/sendmoney/paymethod/PayMethodAdapter;", "payMethodAdapter", "Lid/dana/sendmoney/paymethod/PayMethodAdapter;", "getPayMethodAdapter", "()Lid/dana/sendmoney/paymethod/PayMethodAdapter;", "setPayMethodAdapter", "(Lid/dana/sendmoney/paymethod/PayMethodAdapter;)V", "Lid/dana/di/component/PayMethodComponent;", "Lid/dana/di/component/PayMethodComponent;", "Lid/dana/contract/sendmoney/PayMethodContract$Presenter;", "presenter", "Lid/dana/contract/sendmoney/PayMethodContract$Presenter;", "getPresenter", "()Lid/dana/contract/sendmoney/PayMethodContract$Presenter;", "setPresenter", "(Lid/dana/contract/sendmoney/PayMethodContract$Presenter;)V", "Lid/dana/model/PayMethodModel;", "MyBillsEntityDataFactory", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "PayMethodListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PayMethodView extends BaseViewBindingRichView<ViewChangePayMethodListBinding> implements PayMethodContract.View {
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private PayMethodModel MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SkeletonScreen getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private PayMethodComponent KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private PayMethodListener PlaceComponentResult;
    @Inject
    public PayMethodAdapter payMethodAdapter;
    @Inject
    public PayMethodContract.Presenter presenter;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney_v2/paymethod/PayMethodView$PayMethodListener;", "", "Lid/dana/model/PayMethodModel;", "p0", "", "getAuthRequestContext", "(Lid/dana/model/PayMethodModel;)V", "()V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface PayMethodListener {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void getAuthRequestContext();

        void getAuthRequestContext(PayMethodModel p0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PayMethodView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PayMethodView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewChangePayMethodListBinding inflateViewBinding() {
        ViewChangePayMethodListBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewChangePayMethodListBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "getPresenter")
    public final PayMethodContract.Presenter getPresenter() {
        PayMethodContract.Presenter presenter = this.presenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPresenter")
    public final void setPresenter(PayMethodContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.presenter = presenter;
    }

    @JvmName(name = "getPayMethodAdapter")
    public final PayMethodAdapter getPayMethodAdapter() {
        PayMethodAdapter payMethodAdapter = this.payMethodAdapter;
        if (payMethodAdapter != null) {
            return payMethodAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setPayMethodAdapter")
    public final void setPayMethodAdapter(PayMethodAdapter payMethodAdapter) {
        Intrinsics.checkNotNullParameter(payMethodAdapter, "");
        this.payMethodAdapter = payMethodAdapter;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayMethodView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ PayMethodView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PayMethodView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void injectComponent(ApplicationComponent applicationComponent) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            DaggerPayMethodComponent.Builder MyBillsEntityDataFactory = DaggerPayMethodComponent.MyBillsEntityDataFactory();
            MyBillsEntityDataFactory.MyBillsEntityDataFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
            MyBillsEntityDataFactory.PlaceComponentResult = (PayMethodModule) Preconditions.getAuthRequestContext(new PayMethodModule(this));
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, PayMethodModule.class);
            Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.MyBillsEntityDataFactory, ApplicationComponent.class);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new DaggerPayMethodComponent.PayMethodComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.MyBillsEntityDataFactory, (byte) 0);
        }
        PayMethodComponent payMethodComponent = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (payMethodComponent != null) {
            payMethodComponent.KClassImpl$Data$declaredNonStaticMembers$2(this);
        }
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        injectComponent(ComponentHolder.getAuthRequestContext());
        getBinding().PlaceComponentResult.setLayoutManager(new LinearLayoutManager(getContext()));
        getPayMethodAdapter().setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.sendmoney_v2.paymethod.PayMethodView$$ExternalSyntheticLambda1
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                PayMethodView.$r8$lambda$rBVNbg0EYF16APWo1ctJLNhmv5c(PayMethodView.this, i);
            }
        });
        getPayMethodAdapter().PlaceComponentResult = true;
        getPayMethodAdapter().MyBillsEntityDataFactory = new PayMethodAdapter.TopUpButtonListener() { // from class: id.dana.sendmoney_v2.paymethod.PayMethodView$$ExternalSyntheticLambda2
            @Override // id.dana.sendmoney.paymethod.PayMethodAdapter.TopUpButtonListener
            public final void getAuthRequestContext() {
                PayMethodView.$r8$lambda$oanArzbXeQJYCQPshF_4kv0a4OQ(PayMethodView.this);
            }
        };
        getBinding().PlaceComponentResult.setAdapter(getPayMethodAdapter());
    }

    public final void fetchData(String recipientType, TransferInit transferInit) {
        Intrinsics.checkNotNullParameter(recipientType, "");
        Intrinsics.checkNotNullParameter(transferInit, "");
        PayMethodContract.Presenter presenter = getPresenter();
        PayMethodMapper payMethodMapper = PayMethodMapper.INSTANCE;
        presenter.PlaceComponentResult(PayMethodMapper.BuiltInFictitiousFunctionClassFactory(recipientType), transferInit);
    }

    @Override // id.dana.contract.sendmoney.PayMethodContract.View
    public final void onGetPayMethodListSuccess(List<PayMethodModel> payMethodModels, String kycLevel) {
        if (kycLevel == null) {
            kycLevel = "";
        }
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2(kycLevel);
        getPayMethodAdapter().KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory;
        getPayMethodAdapter().setItems(payMethodModels);
        getPresenter().KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.contract.sendmoney.PayMethodContract.View
    public final void onGetDefaultCardSuccess(String cardIndexNo) {
        String str = cardIndexNo;
        if (str == null || str.length() == 0) {
            getAuthRequestContext();
            return;
        }
        ChangePayMethodViewHelper changePayMethodViewHelper = ChangePayMethodViewHelper.INSTANCE;
        PayMethodModel BuiltInFictitiousFunctionClassFactory = ChangePayMethodViewHelper.BuiltInFictitiousFunctionClassFactory(getPayMethodAdapter(), cardIndexNo);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
        } else {
            getAuthRequestContext();
        }
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void onError(String errorMessage) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        WarningDialogUtil.MyBillsEntityDataFactory(context, errorMessage);
    }

    @Override // id.dana.contract.sendmoney.PayMethodContract.View
    public final void onGetPayMethodError() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        WarningDialogUtil.MyBillsEntityDataFactory(context, ErrorUtil.BuiltInFictitiousFunctionClassFactory(getContext()));
    }

    @Override // id.dana.contract.sendmoney.PayMethodContract.View
    public final void onGetDefaultCardError() {
        onError(ErrorUtil.BuiltInFictitiousFunctionClassFactory(getContext()));
    }

    private final void KClassImpl$Data$declaredNonStaticMembers$2(PayMethodModel p0) {
        PayMethodListener payMethodListener = this.PlaceComponentResult;
        if (payMethodListener != null) {
            payMethodListener.getAuthRequestContext(p0);
        }
        if (!this.BuiltInFictitiousFunctionClassFactory && Intrinsics.areEqual("BALANCE", p0.newProxyInstance)) {
            BuiltInFictitiousFunctionClassFactory();
        }
        getAuthRequestContext(p0);
    }

    private final void getAuthRequestContext(PayMethodModel p0) {
        PayMethodModel payMethodModel = this.MyBillsEntityDataFactory;
        if (payMethodModel != null) {
            payMethodModel.PrepareContext = false;
        }
        p0.PrepareContext = true;
        this.MyBillsEntityDataFactory = p0;
        getBinding().PlaceComponentResult.post(new Runnable() { // from class: id.dana.sendmoney_v2.paymethod.PayMethodView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PayMethodView.m2933$r8$lambda$_PIG1I2hWIm8bSfoof7KViq4z4(PayMethodView.this);
            }
        });
    }

    public final void setChangePayMethodListener(PayMethodListener changePayMethodListener) {
        Intrinsics.checkNotNullParameter(changePayMethodListener, "");
        this.PlaceComponentResult = changePayMethodListener;
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        if (getPayMethodAdapter().KClassImpl$Data$declaredNonStaticMembers$2() != null) {
            PayMethodModel KClassImpl$Data$declaredNonStaticMembers$2 = getPayMethodAdapter().KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2);
        }
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
        }
        BaseActivity baseActivity = (BaseActivity) context;
        int i = PremiumNoticeActivity.PREMIUM_NOTICE_REQUEST_CODE;
        Context context2 = getContext();
        if (context2 != null) {
            ContextUtils.KClassImpl$Data$declaredNonStaticMembers$2(baseActivity, i, new Intent((BaseActivity) context2, PremiumNoticeActivity.class));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type id.dana.base.BaseActivity");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        return Intrinsics.areEqual(p0, "02") || Intrinsics.areEqual(p0, "KYC2");
    }

    /* renamed from: $r8$lambda$_PIG1I2hWIm8bSfoof7KViq4z-4  reason: not valid java name */
    public static /* synthetic */ void m2933$r8$lambda$_PIG1I2hWIm8bSfoof7KViq4z4(PayMethodView payMethodView) {
        Intrinsics.checkNotNullParameter(payMethodView, "");
        payMethodView.getPayMethodAdapter().notifyDataSetChanged();
    }

    public static /* synthetic */ void $r8$lambda$oanArzbXeQJYCQPshF_4kv0a4OQ(PayMethodView payMethodView) {
        Intrinsics.checkNotNullParameter(payMethodView, "");
        PayMethodListener payMethodListener = payMethodView.PlaceComponentResult;
        if (payMethodListener != null) {
            payMethodListener.KClassImpl$Data$declaredNonStaticMembers$2();
        }
    }

    public static /* synthetic */ void $r8$lambda$rBVNbg0EYF16APWo1ctJLNhmv5c(PayMethodView payMethodView, int i) {
        Intrinsics.checkNotNullParameter(payMethodView, "");
        PayMethodModel item = payMethodView.getPayMethodAdapter().getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        payMethodView.KClassImpl$Data$declaredNonStaticMembers$2(item);
        PayMethodListener payMethodListener = payMethodView.PlaceComponentResult;
        if (payMethodListener != null) {
            payMethodListener.getAuthRequestContext();
        }
    }

    private final void getAuthRequestContext() {
        PayMethodModel payMethodModel;
        PayMethodModel payMethodModel2;
        if (this.BuiltInFictitiousFunctionClassFactory || getPayMethodAdapter().KClassImpl$Data$declaredNonStaticMembers$2() == null) {
            Iterator<PayMethodModel> it = getPayMethodAdapter().getItems().iterator();
            while (true) {
                if (!it.hasNext()) {
                    payMethodModel = null;
                    break;
                }
                payMethodModel = it.next();
                if ("BALANCE".equals(payMethodModel.newProxyInstance)) {
                    break;
                }
            }
            if (payMethodModel == null) {
                payMethodModel2 = new PayMethodModel();
            } else {
                CurrencyAmountModel currencyAmountModel = payMethodModel.PlaceComponentResult;
                if (!Intrinsics.areEqual(currencyAmountModel == null ? "" : currencyAmountModel.MyBillsEntityDataFactory, "0") || getPayMethodAdapter().KClassImpl$Data$declaredNonStaticMembers$2() == null) {
                    payMethodModel2 = payMethodModel;
                } else {
                    payMethodModel2 = getPayMethodAdapter().KClassImpl$Data$declaredNonStaticMembers$2();
                    Intrinsics.checkNotNullExpressionValue(payMethodModel2, "");
                }
            }
        } else {
            payMethodModel2 = getPayMethodAdapter().KClassImpl$Data$declaredNonStaticMembers$2();
            Intrinsics.checkNotNullExpressionValue(payMethodModel2, "");
        }
        KClassImpl$Data$declaredNonStaticMembers$2(payMethodModel2);
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void dismissProgress() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
        this.getAuthRequestContext = null;
    }

    @Override // id.dana.base.AbstractContract.AbstractView
    public final void showProgress() {
        SkeletonScreen skeletonScreen = this.getAuthRequestContext;
        if (skeletonScreen != null) {
            if (skeletonScreen != null) {
                skeletonScreen.MyBillsEntityDataFactory();
                return;
            }
            return;
        }
        ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().BuiltInFictitiousFunctionClassFactory);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_skeleton_change_pay_method;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1500;
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
        BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
        ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
        viewSkeletonScreen.MyBillsEntityDataFactory();
        this.getAuthRequestContext = viewSkeletonScreen;
    }
}
