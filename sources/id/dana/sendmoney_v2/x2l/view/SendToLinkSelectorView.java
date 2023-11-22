package id.dana.sendmoney_v2.x2l.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.databinding.ViewSendToLinkSelectorBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.sendmoney_v2.x2l.adapter.SocialLinkAdapter;
import id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract;
import id.dana.sendmoney_v2.x2l.di.DaggerSendToLinkSelectorComponent;
import id.dana.sendmoney_v2.x2l.di.SendToLinkSelectorModule;
import id.dana.sendmoney_v2.x2l.model.SocialLinkModel;
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

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B'\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u0003¢\u0006\u0004\b.\u0010/B+\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003¢\u0006\u0004\b.\u00101J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R5\u0010\u001a\u001a\u0015\u0012\u000b\u0012\t\u0018\u00010\u0012¢\u0006\u0002\b\u0013\u0012\u0004\u0012\u00020\f0\u00118\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010("}, d2 = {"Lid/dana/sendmoney_v2/x2l/view/SendToLinkSelectorView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewSendToLinkSelectorBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewSendToLinkSelectorBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "setup", "()V", "Lkotlin/Function1;", "Lid/dana/sendmoney_v2/x2l/model/SocialLinkModel;", "Lkotlin/ParameterName;", "getAuthRequestContext", "Lkotlin/jvm/functions/Function1;", "getOnSocialLinkSelected", "()Lkotlin/jvm/functions/Function1;", "setOnSocialLinkSelected", "(Lkotlin/jvm/functions/Function1;)V", "onSocialLinkSelected", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$Presenter;", "sendToLinkSelectorPresenter", "Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$Presenter;", "getSendToLinkSelectorPresenter", "()Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$Presenter;", "setSendToLinkSelectorPresenter", "(Lid/dana/sendmoney_v2/x2l/contract/SendToLinkSelectorContract$Presenter;)V", "Lid/dana/sendmoney_v2/x2l/adapter/SocialLinkAdapter;", "socialLinkAdapter", "Lid/dana/sendmoney_v2/x2l/adapter/SocialLinkAdapter;", "getSocialLinkAdapter", "()Lid/dana/sendmoney_v2/x2l/adapter/SocialLinkAdapter;", "setSocialLinkAdapter", "(Lid/dana/sendmoney_v2/x2l/adapter/SocialLinkAdapter;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendToLinkSelectorView extends ViewBindingRichView<ViewSendToLinkSelectorBinding> {
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private Function1<? super SocialLinkModel, Unit> onSocialLinkSelected;
    @Inject
    public SendToLinkSelectorContract.Presenter sendToLinkSelectorPresenter;
    public SocialLinkAdapter socialLinkAdapter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendToLinkSelectorView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendToLinkSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
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
        return R.layout.view_send_to_link_selector;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendToLinkSelectorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onSocialLinkSelected = SendToLinkSelectorView$onSocialLinkSelected$1.INSTANCE;
    }

    public /* synthetic */ SendToLinkSelectorView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendToLinkSelectorView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onSocialLinkSelected = SendToLinkSelectorView$onSocialLinkSelected$1.INSTANCE;
    }

    @JvmName(name = "getSendToLinkSelectorPresenter")
    public final SendToLinkSelectorContract.Presenter getSendToLinkSelectorPresenter() {
        SendToLinkSelectorContract.Presenter presenter = this.sendToLinkSelectorPresenter;
        if (presenter != null) {
            return presenter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSendToLinkSelectorPresenter")
    public final void setSendToLinkSelectorPresenter(SendToLinkSelectorContract.Presenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "");
        this.sendToLinkSelectorPresenter = presenter;
    }

    @JvmName(name = "getSocialLinkAdapter")
    public final SocialLinkAdapter getSocialLinkAdapter() {
        SocialLinkAdapter socialLinkAdapter = this.socialLinkAdapter;
        if (socialLinkAdapter != null) {
            return socialLinkAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setSocialLinkAdapter")
    public final void setSocialLinkAdapter(SocialLinkAdapter socialLinkAdapter) {
        Intrinsics.checkNotNullParameter(socialLinkAdapter, "");
        this.socialLinkAdapter = socialLinkAdapter;
    }

    @JvmName(name = "getOnSocialLinkSelected")
    public final Function1<SocialLinkModel, Unit> getOnSocialLinkSelected() {
        return this.onSocialLinkSelected;
    }

    @JvmName(name = "setOnSocialLinkSelected")
    public final void setOnSocialLinkSelected(Function1<? super SocialLinkModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onSocialLinkSelected = function1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewSendToLinkSelectorBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewSendToLinkSelectorBinding authRequestContext = ViewSendToLinkSelectorBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerSendToLinkSelectorComponent.Builder BuiltInFictitiousFunctionClassFactory = DaggerSendToLinkSelectorComponent.BuiltInFictitiousFunctionClassFactory();
        BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = (SendToLinkSelectorModule) Preconditions.getAuthRequestContext(new SendToLinkSelectorModule(new SendToLinkSelectorContract.View() { // from class: id.dana.sendmoney_v2.x2l.view.SendToLinkSelectorView$sendToLinkSelectorModule$1
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

            @Override // id.dana.sendmoney_v2.x2l.contract.SendToLinkSelectorContract.View
            public final void BuiltInFictitiousFunctionClassFactory(List<SocialLinkModel> p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                SendToLinkSelectorView.this.getSocialLinkAdapter().setItems(p0);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, SendToLinkSelectorModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, ApplicationComponent.class);
        new DaggerSendToLinkSelectorComponent.SendToLinkSelectorComponentImpl(BuiltInFictitiousFunctionClassFactory.getAuthRequestContext, BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory, (byte) 0).KClassImpl$Data$declaredNonStaticMembers$2(this);
        registerPresenter(getSendToLinkSelectorPresenter());
    }

    /* renamed from: $r8$lambda$gOTLcgQFEzb-tI7cGuQDuSqy7b4  reason: not valid java name */
    public static /* synthetic */ void m2940$r8$lambda$gOTLcgQFEzbtI7cGuQDuSqy7b4(SendToLinkSelectorView sendToLinkSelectorView, SocialLinkAdapter socialLinkAdapter, int i) {
        Intrinsics.checkNotNullParameter(sendToLinkSelectorView, "");
        Intrinsics.checkNotNullParameter(socialLinkAdapter, "");
        Function1<? super SocialLinkModel, Unit> function1 = sendToLinkSelectorView.onSocialLinkSelected;
        SocialLinkModel item = socialLinkAdapter.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        function1.invoke(item);
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        final SocialLinkAdapter socialLinkAdapter = new SocialLinkAdapter();
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 3));
        recyclerView.setAdapter(socialLinkAdapter);
        setSocialLinkAdapter(socialLinkAdapter);
        socialLinkAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.sendmoney_v2.x2l.view.SendToLinkSelectorView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                SendToLinkSelectorView.m2940$r8$lambda$gOTLcgQFEzbtI7cGuQDuSqy7b4(SendToLinkSelectorView.this, socialLinkAdapter, i);
            }
        });
        getSendToLinkSelectorPresenter().getAuthRequestContext();
    }
}
