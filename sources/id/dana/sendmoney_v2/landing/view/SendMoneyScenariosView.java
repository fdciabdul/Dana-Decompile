package id.dana.sendmoney_v2.landing.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.ThrottledOnItemClickListener;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewRecipientSelectorBinding;
import id.dana.di.ComponentHolder;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.SendMoneyScenarioModule;
import id.dana.mapper.FreeTransferMapper;
import id.dana.model.SendMoneyScenarioModel;
import id.dana.sendmoney.adapter.BankPromoMenuHelper;
import id.dana.sendmoney.recipienthome.SendMoneyScenariosContract;
import id.dana.sendmoney_v2.landing.adapter.SendMoneyMenuAdapter;
import id.dana.sendmoney_v2.landing.di.component.DaggerSendMoneyScenariosComponent;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B'\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\r¢\u0006\u0004\b0\u00101B+\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\u0006\u0010/\u001a\u00020\r\u0012\u0006\u00102\u001a\u00020\r¢\u0006\u0004\b0\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0014R.\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00168\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\"8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010\u0017\u001a\u00020)8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b!\u0010*"}, d2 = {"Lid/dana/sendmoney_v2/landing/view/SendMoneyScenariosView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewRecipientSelectorBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewRecipientSelectorBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "onDetachedFromWindow", "()V", "setup", "", "freeBankTransferCount", "updateSendmoneyScenarios", "(I)V", "getAuthRequestContext", "", "Lid/dana/model/SendMoneyScenarioModel;", "Ljava/util/List;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Function1;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "getOnMenuSelected", "()Lkotlin/jvm/functions/Function1;", "setOnMenuSelected", "(Lkotlin/jvm/functions/Function1;)V", "onMenuSelected", "Lid/dana/sendmoney_v2/landing/adapter/SendMoneyMenuAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/sendmoney_v2/landing/adapter/SendMoneyMenuAdapter;", "MyBillsEntityDataFactory", "Lid/dana/sendmoney/recipienthome/SendMoneyScenariosContract$Presenter;", "sendMoneyScenarioPresenter", "Lid/dana/sendmoney/recipienthome/SendMoneyScenariosContract$Presenter;", "getSendMoneyScenarioPresenter", "()Lid/dana/sendmoney/recipienthome/SendMoneyScenariosContract$Presenter;", "setSendMoneyScenarioPresenter", "(Lid/dana/sendmoney/recipienthome/SendMoneyScenariosContract$Presenter;)V", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyScenariosView extends BaseViewBindingRichView<ViewRecipientSelectorBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SendMoneyMenuAdapter MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private SkeletonScreen PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function1<? super SendMoneyScenarioModel, Unit> onMenuSelected;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private List<SendMoneyScenarioModel> BuiltInFictitiousFunctionClassFactory;
    @Inject
    public SendMoneyScenariosContract.Presenter sendMoneyScenarioPresenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendMoneyScenariosView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendMoneyScenariosView(Context context, AttributeSet attributeSet) {
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
    public final ViewRecipientSelectorBinding inflateViewBinding() {
        ViewRecipientSelectorBinding PlaceComponentResult = ViewRecipientSelectorBinding.PlaceComponentResult(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMoneyScenariosView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onMenuSelected = SendMoneyScenariosView$onMenuSelected$1.INSTANCE;
    }

    public /* synthetic */ SendMoneyScenariosView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendMoneyScenariosView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onMenuSelected = SendMoneyScenariosView$onMenuSelected$1.INSTANCE;
    }

    @JvmName(name = "getSendMoneyScenarioPresenter")
    public final SendMoneyScenariosContract.Presenter getSendMoneyScenarioPresenter() {
        SendMoneyScenariosContract.Presenter presenter = this.sendMoneyScenarioPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendMoneyScenarioPresenter")
    public final void setSendMoneyScenarioPresenter(SendMoneyScenariosContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendMoneyScenarioPresenter = presenter;
    }

    @JvmName(name = "getOnMenuSelected")
    public final Function1<SendMoneyScenarioModel, Unit> getOnMenuSelected() {
        return this.onMenuSelected;
    }

    @JvmName(name = "setOnMenuSelected")
    public final void setOnMenuSelected(Function1<? super SendMoneyScenarioModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onMenuSelected = function1;
    }

    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSendMoneyScenariosComponent.Builder KClassImpl$Data$declaredNonStaticMembers$2 = DaggerSendMoneyScenariosComponent.KClassImpl$Data$declaredNonStaticMembers$2();
        KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = (SendMoneyScenarioModule) Preconditions.getAuthRequestContext(new SendMoneyScenarioModule(new SendMoneyScenariosContract.View() { // from class: id.dana.sendmoney_v2.landing.view.SendMoneyScenariosView$$ExternalSyntheticLambda1
            @Override // id.dana.sendmoney.recipienthome.SendMoneyScenariosContract.View
            public final void PlaceComponentResult(List list) {
                SendMoneyScenariosView.$r8$lambda$qNafJslEug2mHSujCKY6Vg9g1ss(SendMoneyScenariosView.this, list);
            }

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
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, SendMoneyScenarioModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, ApplicationComponent.class);
        new DaggerSendMoneyScenariosComponent.SendMoneyScenariosComponentImpl(KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext, KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult, (byte) 0).MyBillsEntityDataFactory(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getSendMoneyScenarioPresenter().onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [id.dana.sendmoney_v2.landing.adapter.SendMoneyMenuAdapter] */
    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        injectComponent(ComponentHolder.getAuthRequestContext());
        RecyclerView recyclerView = getBinding().PlaceComponentResult;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z = false;
        final SendMoneyMenuAdapter sendMoneyMenuAdapter = new SendMoneyMenuAdapter(3, z, 2, defaultConstructorMarker);
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.sendmoney_v2.landing.view.SendMoneyScenariosView$getLayoutManager$1$1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public final int PlaceComponentResult(int p0) {
                int itemViewType = SendMoneyMenuAdapter.this.getItemViewType(p0);
                if (itemViewType == -2 || itemViewType == -1 || itemViewType == 1) {
                    return gridLayoutManager.getErrorConfigVersion;
                }
                return 1;
            }
        };
        recyclerView.setLayoutManager(gridLayoutManager);
        this.MyBillsEntityDataFactory = sendMoneyMenuAdapter;
        recyclerView.setAdapter(sendMoneyMenuAdapter);
        sendMoneyMenuAdapter.setOnItemClickListener(new ThrottledOnItemClickListener(0L, new Function1<Integer, Unit>() { // from class: id.dana.sendmoney_v2.landing.view.SendMoneyScenariosView$setupRecyclerView$1$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i) {
                SendMoneyScenarioModel item = SendMoneyMenuAdapter.this.getItem(i);
                if (item != null) {
                    this.onMenuSelected.invoke(item);
                }
            }
        }, 1, null));
        SendMoneyScenariosView$setupRecyclerView$1$1$2 sendMoneyScenariosView$setupRecyclerView$1$1$2 = new SendMoneyScenariosView$setupRecyclerView$1$1$2(this);
        Intrinsics.checkNotNullParameter(sendMoneyScenariosView$setupRecyclerView$1$1$2, "");
        sendMoneyMenuAdapter.getAuthRequestContext = sendMoneyScenariosView$setupRecyclerView$1$1$2;
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney_v2.landing.view.SendMoneyScenariosView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendMoneyScenariosView.$r8$lambda$n98XgiTi6JbdJGLV0ozSi5SuDiw(SendMoneyScenariosView.this, view);
            }
        });
        getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(8);
        RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(getBinding().PlaceComponentResult);
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.view_skeleton_x2x_scenario;
        ?? r1 = this.MyBillsEntityDataFactory;
        if (r1 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            defaultConstructorMarker = r1;
        }
        BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (RecyclerView.Adapter) defaultConstructorMarker;
        BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
        BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
        BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
        BuiltInFictitiousFunctionClassFactory.lookAheadTest = 20;
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 3;
        RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, z ? (byte) 1 : (byte) 0);
        recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
        Intrinsics.checkNotNullExpressionValue(recyclerViewSkeletonScreen, "");
        this.PlaceComponentResult = recyclerViewSkeletonScreen;
        getSendMoneyScenarioPresenter().PlaceComponentResult();
    }

    private final void getAuthRequestContext() {
        ShowMoreView showMoreView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(showMoreView, "");
        ShowMoreView showMoreView2 = showMoreView;
        SendMoneyMenuAdapter sendMoneyMenuAdapter = this.MyBillsEntityDataFactory;
        SendMoneyMenuAdapter sendMoneyMenuAdapter2 = null;
        if (sendMoneyMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneyMenuAdapter = null;
        }
        showMoreView2.setVisibility(sendMoneyMenuAdapter.BuiltInFictitiousFunctionClassFactory() ? 0 : 8);
        SendMoneyMenuAdapter sendMoneyMenuAdapter3 = this.MyBillsEntityDataFactory;
        if (sendMoneyMenuAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            sendMoneyMenuAdapter2 = sendMoneyMenuAdapter3;
        }
        showMoreView.setExpanded(sendMoneyMenuAdapter2.getMyBillsEntityDataFactory());
    }

    public final void updateSendmoneyScenarios(int freeBankTransferCount) {
        int authRequestContext;
        SendMoneyMenuAdapter sendMoneyMenuAdapter = this.MyBillsEntityDataFactory;
        if (sendMoneyMenuAdapter != null) {
            SendMoneyScenarioModel sendMoneyScenarioModel = null;
            if (sendMoneyMenuAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                sendMoneyMenuAdapter = null;
            }
            if (sendMoneyMenuAdapter.NetworkUserEntityData$$ExternalSyntheticLambda0()) {
                SendMoneyMenuAdapter sendMoneyMenuAdapter2 = this.MyBillsEntityDataFactory;
                if (sendMoneyMenuAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    sendMoneyMenuAdapter2 = null;
                }
                new FreeTransferMapper();
                List<SendMoneyScenarioModel> list = this.BuiltInFictitiousFunctionClassFactory;
                if (list == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    list = null;
                }
                Iterator<SendMoneyScenarioModel> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    SendMoneyScenarioModel next = it.next();
                    if (next.MyBillsEntityDataFactory()) {
                        sendMoneyScenarioModel = next;
                        break;
                    }
                }
                if (sendMoneyScenarioModel != null) {
                    if (FreeTransferMapper.MyBillsEntityDataFactory(Integer.valueOf(freeBankTransferCount))) {
                        Integer valueOf = Integer.valueOf(freeBankTransferCount);
                        sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = true;
                        StringBuilder sb = new StringBuilder();
                        sb.append(valueOf);
                        sb.append("X");
                        String obj = sb.toString();
                        Intrinsics.checkNotNullParameter(obj, "");
                        sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = obj;
                    } else {
                        sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
                    }
                }
                BankPromoMenuHelper bankPromoMenuHelper = sendMoneyMenuAdapter2.getAuthRequestContext;
                if (sendMoneyScenarioModel != null && bankPromoMenuHelper.PlaceComponentResult.getItems() != null && (authRequestContext = BankPromoMenuHelper.getAuthRequestContext(bankPromoMenuHelper.PlaceComponentResult.getItems())) != -1 && bankPromoMenuHelper.PlaceComponentResult.getItem(authRequestContext) != null) {
                    SendMoneyScenarioModel item = bankPromoMenuHelper.PlaceComponentResult.getItem(authRequestContext);
                    Intrinsics.checkNotNullExpressionValue(item, "");
                    String str = bankPromoMenuHelper.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullParameter(str, "");
                    item.isLayoutRequested = str;
                    bankPromoMenuHelper.PlaceComponentResult.getItems().set(authRequestContext, item);
                    bankPromoMenuHelper.PlaceComponentResult.notifyItemChanged(authRequestContext);
                }
                getAuthRequestContext();
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$n98XgiTi6JbdJGLV0ozSi5SuDiw(SendMoneyScenariosView sendMoneyScenariosView, View view) {
        Intrinsics.checkNotNullParameter(sendMoneyScenariosView, "");
        SendMoneyMenuAdapter sendMoneyMenuAdapter = sendMoneyScenariosView.MyBillsEntityDataFactory;
        if (sendMoneyMenuAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sendMoneyMenuAdapter = null;
        }
        sendMoneyMenuAdapter.getAuthRequestContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void $r8$lambda$qNafJslEug2mHSujCKY6Vg9g1ss(SendMoneyScenariosView sendMoneyScenariosView, List list) {
        Intrinsics.checkNotNullParameter(sendMoneyScenariosView, "");
        SendMoneyMenuAdapter sendMoneyMenuAdapter = sendMoneyScenariosView.MyBillsEntityDataFactory;
        if (sendMoneyMenuAdapter != null) {
            SkeletonScreen skeletonScreen = null;
            if (sendMoneyMenuAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                sendMoneyMenuAdapter = null;
            }
            if (list != null) {
                if ((!list.isEmpty()) == false) {
                    list = null;
                }
                if (list != null) {
                    Intrinsics.checkNotNullParameter(list, "");
                    BankPromoMenuHelper bankPromoMenuHelper = sendMoneyMenuAdapter.getAuthRequestContext;
                    Intrinsics.checkNotNullParameter(list, "");
                    int authRequestContext = BankPromoMenuHelper.getAuthRequestContext(list);
                    if (authRequestContext != -1 && ((SendMoneyScenarioModel) list.get(authRequestContext)).getNetworkUserEntityData$$ExternalSyntheticLambda7()) {
                        SendMoneyScenarioModel sendMoneyScenarioModel = (SendMoneyScenarioModel) list.get(authRequestContext);
                        bankPromoMenuHelper.KClassImpl$Data$declaredNonStaticMembers$2 = sendMoneyScenarioModel.isLayoutRequested;
                        bankPromoMenuHelper.MyBillsEntityDataFactory = sendMoneyScenarioModel.getNetworkUserEntityData$$ExternalSyntheticLambda7();
                        Intrinsics.checkNotNullParameter("", "");
                        sendMoneyScenarioModel.isLayoutRequested = "";
                        Intrinsics.checkNotNullParameter("", "");
                        sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda8 = "";
                        sendMoneyScenarioModel.NetworkUserEntityData$$ExternalSyntheticLambda7 = false;
                    }
                    bankPromoMenuHelper.PlaceComponentResult.setItems(list);
                    sendMoneyScenariosView.BuiltInFictitiousFunctionClassFactory = list;
                }
            }
            sendMoneyScenariosView.getAuthRequestContext();
            SkeletonScreen skeletonScreen2 = sendMoneyScenariosView.PlaceComponentResult;
            if (skeletonScreen2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                skeletonScreen = skeletonScreen2;
            }
            skeletonScreen.PlaceComponentResult();
        }
    }

    public static final /* synthetic */ void access$onRecyclerViewExpanded(SendMoneyScenariosView sendMoneyScenariosView, boolean z) {
        ViewParent parent = sendMoneyScenariosView.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            AutoTransition autoTransition = new AutoTransition();
            autoTransition.setInterpolator(new DecelerateInterpolator());
            TransitionManager.getAuthRequestContext(viewGroup, autoTransition);
        }
        sendMoneyScenariosView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setExpanded(z);
    }
}
