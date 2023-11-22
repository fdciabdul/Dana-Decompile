package id.dana.richview.servicescard.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.ThirdPartyService;
import id.dana.richview.servicescard.adapter.viewholder.PromotedServiceV2ViewHolder;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.subjects.CompletableSubject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0001:\u0002!\"B)\u0012\b\b\u0002\u0010\b\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\b\u0010\b\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u00020\u000f8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\r\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\r\u001a\u00020\u00178\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0018R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0010"}, d2 = {"Lid/dana/richview/servicescard/adapter/ServiceV2Adapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lid/dana/model/ThirdPartyService;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Landroidx/viewbinding/ViewBinding;", "", "getItemCount", "()I", "p0", "getItemViewType", "(I)I", "Lid/dana/richview/servicescard/adapter/viewholder/PromotedServiceV2ViewHolder;", "Lio/reactivex/Completable;", "PlaceComponentResult", "(Lid/dana/richview/servicescard/adapter/viewholder/PromotedServiceV2ViewHolder;)Lio/reactivex/Completable;", "", "Z", "BuiltInFictitiousFunctionClassFactory", "()Z", "Ljava/lang/Runnable;", "getAuthRequestContext", "Ljava/lang/Runnable;", "MyBillsEntityDataFactory", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "Landroid/view/View$OnClickListener;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/View$OnClickListener;", "getErrorConfigVersion", "p1", "p2", "<init>", "(ZLandroid/view/View$OnClickListener;Ljava/lang/Runnable;)V", "Companion", "ServiceV2DiffCallback"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceV2Adapter extends ListAdapter<ThirdPartyService, ViewBindingRecyclerViewHolder<ThirdPartyService, ? extends ViewBinding>> {
    private final View.OnClickListener KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public BaseRecyclerViewHolder.OnItemClickListener PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Runnable MyBillsEntityDataFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private final boolean getAuthRequestContext;

    public ServiceV2Adapter() {
        this(false, null, null, 7, null);
    }

    public /* synthetic */ ServiceV2Adapter(boolean z, View.OnClickListener onClickListener, Runnable runnable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? null : onClickListener, (i & 4) != 0 ? null : runnable);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ViewBindingRecyclerViewHolder viewBindingRecyclerViewHolder = (ViewBindingRecyclerViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(viewBindingRecyclerViewHolder, "");
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener = null;
        if (i == 0) {
            if (this.BuiltInFictitiousFunctionClassFactory) {
                PlaceComponentResult(viewBindingRecyclerViewHolder instanceof PromotedServiceV2ViewHolder ? (PromotedServiceV2ViewHolder) viewBindingRecyclerViewHolder : null).q_();
            } else {
                final PromotedServiceV2ViewHolder promotedServiceV2ViewHolder = viewBindingRecyclerViewHolder instanceof PromotedServiceV2ViewHolder ? (PromotedServiceV2ViewHolder) viewBindingRecyclerViewHolder : null;
                final CompletableSubject BuiltInFictitiousFunctionClassFactory = CompletableSubject.BuiltInFictitiousFunctionClassFactory();
                Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
                Consumer<? super Disposable> consumer = new Consumer() { // from class: id.dana.richview.servicescard.adapter.ServiceV2Adapter$$ExternalSyntheticLambda0
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        Disposable disposable = (Disposable) obj;
                        ServiceV2Adapter.getAuthRequestContext(PromotedServiceV2ViewHolder.this, BuiltInFictitiousFunctionClassFactory);
                    }
                };
                Consumer<? super Throwable> PlaceComponentResult = Functions.PlaceComponentResult();
                Action action = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
                Action action2 = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
                Completable KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(consumer, PlaceComponentResult, action, action, action2, action2);
                Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
                KClassImpl$Data$declaredNonStaticMembers$2.q_();
            }
        }
        List<T> list = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        viewBindingRecyclerViewHolder.bindData(list.get(i));
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener2 = this.PlaceComponentResult;
        if (onItemClickListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            onItemClickListener = onItemClickListener2;
        }
        viewBindingRecyclerViewHolder.setOnItemClickListener(onItemClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ServiceV2ViewHolderFactory serviceV2ViewHolderFactory = ServiceV2ViewHolderFactory.INSTANCE;
        return ServiceV2ViewHolderFactory.BuiltInFictitiousFunctionClassFactory(i, viewGroup, this.KClassImpl$Data$declaredNonStaticMembers$2, this.MyBillsEntityDataFactory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        ViewBindingRecyclerViewHolder viewBindingRecyclerViewHolder = (ViewBindingRecyclerViewHolder) viewHolder;
        Intrinsics.checkNotNullParameter(viewBindingRecyclerViewHolder, "");
        PromotedServiceV2ViewHolder promotedServiceV2ViewHolder = viewBindingRecyclerViewHolder instanceof PromotedServiceV2ViewHolder ? (PromotedServiceV2ViewHolder) viewBindingRecyclerViewHolder : null;
        if (promotedServiceV2ViewHolder != null) {
            promotedServiceV2ViewHolder.getBinding().getAuthRequestContext.clearAnimation();
        }
    }

    private ServiceV2Adapter(boolean z, View.OnClickListener onClickListener, Runnable runnable) {
        super(new AsyncDifferConfig.Builder(new ServiceV2DiffCallback()).PlaceComponentResult());
        this.getAuthRequestContext = z;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = onClickListener;
        this.MyBillsEntityDataFactory = runnable;
    }

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        ServiceV2ViewHolderFactory serviceV2ViewHolderFactory = ServiceV2ViewHolderFactory.INSTANCE;
        return ServiceV2ViewHolderFactory.KClassImpl$Data$declaredNonStaticMembers$2(p0, this.getAuthRequestContext);
    }

    public static Completable PlaceComponentResult(final PromotedServiceV2ViewHolder p0) {
        final CompletableSubject BuiltInFictitiousFunctionClassFactory = CompletableSubject.BuiltInFictitiousFunctionClassFactory();
        Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
        Consumer<? super Disposable> consumer = new Consumer() { // from class: id.dana.richview.servicescard.adapter.ServiceV2Adapter$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                Disposable disposable = (Disposable) obj;
                ServiceV2Adapter.PlaceComponentResult(PromotedServiceV2ViewHolder.this, BuiltInFictitiousFunctionClassFactory);
            }
        };
        Consumer<? super Throwable> PlaceComponentResult = Functions.PlaceComponentResult();
        Action action = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        Action action2 = Functions.KClassImpl$Data$declaredNonStaticMembers$2;
        Completable KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2(consumer, PlaceComponentResult, action, action, action2, action2);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007"}, d2 = {"Lid/dana/richview/servicescard/adapter/ServiceV2Adapter$ServiceV2DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lid/dana/model/ThirdPartyService;", "p0", "p1", "", "getAuthRequestContext", "(Lid/dana/model/ThirdPartyService;Lid/dana/model/ThirdPartyService;)Z", "MyBillsEntityDataFactory", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ServiceV2DiffCallback extends DiffUtil.ItemCallback<ThirdPartyService> {
        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(ThirdPartyService thirdPartyService, ThirdPartyService thirdPartyService2) {
            return getAuthRequestContext2(thirdPartyService, thirdPartyService2);
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        public final /* synthetic */ boolean getAuthRequestContext(ThirdPartyService thirdPartyService, ThirdPartyService thirdPartyService2) {
            return MyBillsEntityDataFactory(thirdPartyService, thirdPartyService2);
        }

        private static boolean MyBillsEntityDataFactory(ThirdPartyService p0, ThirdPartyService p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return Intrinsics.areEqual(p0.toString(), p1.toString());
        }

        /* renamed from: getAuthRequestContext  reason: avoid collision after fix types in other method */
        private static boolean getAuthRequestContext2(ThirdPartyService p0, ThirdPartyService p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            return Intrinsics.areEqual(p0.toString(), p1.toString());
        }
    }

    public static /* synthetic */ void getAuthRequestContext(PromotedServiceV2ViewHolder promotedServiceV2ViewHolder, CompletableSubject completableSubject) {
        Intrinsics.checkNotNullParameter(completableSubject, "");
        if (promotedServiceV2ViewHolder != null) {
            LinearLayout linearLayout = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "");
            if (linearLayout.getVisibility() != 0) {
                LinearLayout linearLayout2 = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
                linearLayout2.getLayoutParams().height = ViewExtKt.PlaceComponentResult(52.0f);
                LinearLayout linearLayout3 = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "");
                linearLayout4.requestLayout();
                if (promotedServiceV2ViewHolder.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    promotedServiceV2ViewHolder.getBinding().getAuthRequestContext.cancelAnimation();
                }
            }
        }
        completableSubject.onComplete();
    }

    public static /* synthetic */ void PlaceComponentResult(PromotedServiceV2ViewHolder promotedServiceV2ViewHolder, CompletableSubject completableSubject) {
        Intrinsics.checkNotNullParameter(completableSubject, "");
        if (promotedServiceV2ViewHolder != null) {
            LinearLayout linearLayout = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "");
            if (linearLayout.getVisibility() != 8) {
                LinearLayout linearLayout2 = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout2, "");
                linearLayout2.getLayoutParams().height = 0;
                LinearLayout linearLayout3 = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout3, "");
                linearLayout3.setVisibility(8);
                LinearLayout linearLayout4 = promotedServiceV2ViewHolder.getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(linearLayout4, "");
                linearLayout4.requestLayout();
                if (promotedServiceV2ViewHolder.KClassImpl$Data$declaredNonStaticMembers$2 != null) {
                    promotedServiceV2ViewHolder.getBinding().getAuthRequestContext.playAnimation();
                }
            }
        }
        completableSubject.onComplete();
    }

    @Override // androidx.recyclerview.widget.ListAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        List<T> list = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        return list.size();
    }
}
