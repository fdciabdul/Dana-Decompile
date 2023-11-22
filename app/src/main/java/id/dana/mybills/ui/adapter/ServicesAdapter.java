package id.dana.mybills.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.mybills.databinding.ItemAllServiceV2Binding;
import id.dana.mybills.ui.model.MyBillsServiceModel;
import id.dana.mybills.ui.model.MyBillsServiceModelKt;
import id.dana.mybills.ui.viewholder.ServiceItemViewHolder;
import id.dana.utils.safeonclicklistener.SafeClickListenerExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006*\u00020\u000b0\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011"}, d2 = {"Lid/dana/mybills/ui/adapter/ServicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder;", "", "getItemCount", "()I", "Lid/dana/mybills/ui/adapter/ServicesAdapter$diffCallBack$1;", "getAuthRequestContext", "Lid/dana/mybills/ui/adapter/ServicesAdapter$diffCallBack$1;", "PlaceComponentResult", "Landroidx/recyclerview/widget/AsyncListDiffer;", "Lid/dana/mybills/ui/model/MyBillsServiceModel;", "MyBillsEntityDataFactory", "Landroidx/recyclerview/widget/AsyncListDiffer;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder$OnServiceClickCallback;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/mybills/ui/viewholder/ServiceItemViewHolder$OnServiceClickCallback;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ServicesAdapter extends RecyclerView.Adapter<ServiceItemViewHolder> {
    public ServiceItemViewHolder.OnServiceClickCallback KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final AsyncListDiffer<MyBillsServiceModel> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final ServicesAdapter$diffCallBack$1 PlaceComponentResult;

    /* JADX WARN: Type inference failed for: r0v0, types: [id.dana.mybills.ui.adapter.ServicesAdapter$diffCallBack$1] */
    public ServicesAdapter() {
        ?? r0 = new DiffUtil.ItemCallback<MyBillsServiceModel>() { // from class: id.dana.mybills.ui.adapter.ServicesAdapter$diffCallBack$1
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public final /* synthetic */ boolean KClassImpl$Data$declaredNonStaticMembers$2(MyBillsServiceModel myBillsServiceModel, MyBillsServiceModel myBillsServiceModel2) {
                return BuiltInFictitiousFunctionClassFactory(myBillsServiceModel, myBillsServiceModel2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            public final /* synthetic */ boolean getAuthRequestContext(MyBillsServiceModel myBillsServiceModel, MyBillsServiceModel myBillsServiceModel2) {
                return MyBillsEntityDataFactory(myBillsServiceModel, myBillsServiceModel2);
            }

            private static boolean MyBillsEntityDataFactory(MyBillsServiceModel p0, MyBillsServiceModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                return Intrinsics.areEqual(p0.getKey(), p1.getKey());
            }

            private static boolean BuiltInFictitiousFunctionClassFactory(MyBillsServiceModel p0, MyBillsServiceModel p1) {
                Intrinsics.checkNotNullParameter(p0, "");
                Intrinsics.checkNotNullParameter(p1, "");
                return Intrinsics.areEqual(p0, p1);
            }
        };
        this.PlaceComponentResult = r0;
        this.BuiltInFictitiousFunctionClassFactory = new AsyncListDiffer<>(this, (DiffUtil.ItemCallback) r0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(ServiceItemViewHolder serviceItemViewHolder, int i) {
        final ServiceItemViewHolder serviceItemViewHolder2 = serviceItemViewHolder;
        Intrinsics.checkNotNullParameter(serviceItemViewHolder2, "");
        List<MyBillsServiceModel> list = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        final MyBillsServiceModel myBillsServiceModel = list.get(i);
        Intrinsics.checkNotNullParameter(myBillsServiceModel, "");
        ItemAllServiceV2Binding itemAllServiceV2Binding = serviceItemViewHolder2.BuiltInFictitiousFunctionClassFactory;
        TextView textView = itemAllServiceV2Binding.getAuthRequestContext;
        Context context = itemAllServiceV2Binding.BuiltInFictitiousFunctionClassFactory.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        textView.setText(MyBillsServiceModelKt.getLocalizedName(myBillsServiceModel, context));
        String icon = myBillsServiceModel.getIcon();
        if (icon == null) {
            icon = "";
        }
        if (SvgLoader.getAuthRequestContext(icon)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(serviceItemViewHolder2.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getContext());
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = icon;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = serviceItemViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0);
        } else {
            GlideApp.getAuthRequestContext(serviceItemViewHolder2.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory.getContext()).PlaceComponentResult(icon).MyBillsEntityDataFactory((ImageView) serviceItemViewHolder2.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory);
        }
        MaterialCardView materialCardView = serviceItemViewHolder2.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        SafeClickListenerExtKt.MyBillsEntityDataFactory(materialCardView, new Function1<View, Unit>() { // from class: id.dana.mybills.ui.viewholder.ServiceItemViewHolder$bindData$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ServiceItemViewHolder.OnServiceClickCallback onServiceClickCallback;
                Intrinsics.checkNotNullParameter(view, "");
                onServiceClickCallback = ServiceItemViewHolder.this.MyBillsEntityDataFactory;
                onServiceClickCallback.getAuthRequestContext(myBillsServiceModel);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ ServiceItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        ItemAllServiceV2Binding authRequestContext = ItemAllServiceV2Binding.getAuthRequestContext(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        ServiceItemViewHolder.OnServiceClickCallback onServiceClickCallback = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (onServiceClickCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            onServiceClickCallback = null;
        }
        return new ServiceItemViewHolder(authRequestContext, onServiceClickCallback);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        List<MyBillsServiceModel> list = this.BuiltInFictitiousFunctionClassFactory.moveToNextValue;
        Intrinsics.checkNotNullExpressionValue(list, "");
        return list.size();
    }
}
