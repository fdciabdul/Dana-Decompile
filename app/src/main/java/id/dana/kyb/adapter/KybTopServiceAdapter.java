package id.dana.kyb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemKybTopServiceBinding;
import id.dana.kyb.adapter.KybTopServiceAdapter;
import id.dana.kyb.model.KybServiceModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001:\u0001\u0013B%\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000e¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR&\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\u0004\u0018\u0001`\u000eX\u0086\u0002¢\u0006\u0006\n\u0004\b\n\u0010\u000f"}, d2 = {"Lid/dana/kyb/adapter/KybTopServiceAdapter;", "Lid/dana/core/ui/recyclerview/BaseRecyclerViewDiffUtilAdapter;", "Lid/dana/kyb/model/KybServiceModel;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Landroid/view/LayoutInflater;", "p0", "Landroid/view/ViewGroup;", "p1", "", "p2", "PlaceComponentResult", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;I)Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lkotlin/Function1;", "", "Lid/dana/kyb/helper/service/listener/KybServiceClickListener;", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "ViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybTopServiceAdapter extends BaseRecyclerViewDiffUtilAdapter<KybServiceModel, BaseViewBindingViewHolder<KybServiceModel>> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public Function1<? super KybServiceModel, Unit> BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KybTopServiceAdapter() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.adapter.KybTopServiceAdapter.<init>():void");
    }

    public /* synthetic */ KybTopServiceAdapter(Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : function1);
    }

    private KybTopServiceAdapter(Function1<? super KybServiceModel, Unit> function1) {
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // id.dana.core.ui.recyclerview.BaseRecyclerViewDiffUtilAdapter
    public final BaseViewBindingViewHolder<KybServiceModel> PlaceComponentResult(LayoutInflater p0, ViewGroup p1, int p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        ItemKybTopServiceBinding MyBillsEntityDataFactory = ItemKybTopServiceBinding.MyBillsEntityDataFactory(LayoutInflater.from(p1.getContext()), p1);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return new ViewHolder(this, MyBillsEntityDataFactory);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0006\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/kyb/adapter/KybTopServiceAdapter$ViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/kyb/model/KybServiceModel;", "Lid/dana/databinding/ItemKybTopServiceBinding;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/databinding/ItemKybTopServiceBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "<init>", "(Lid/dana/kyb/adapter/KybTopServiceAdapter;Lid/dana/databinding/ItemKybTopServiceBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class ViewHolder extends BaseViewBindingViewHolder<KybServiceModel> {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        private final ItemKybTopServiceBinding KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ KybTopServiceAdapter getAuthRequestContext;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public ViewHolder(id.dana.kyb.adapter.KybTopServiceAdapter r3, id.dana.databinding.ItemKybTopServiceBinding r4) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                r2.getAuthRequestContext = r3
                r3 = r4
                androidx.viewbinding.ViewBinding r3 = (androidx.viewbinding.ViewBinding) r3
                r0 = 0
                r1 = 2
                r2.<init>(r3, r0, r1, r0)
                r2.KClassImpl$Data$declaredNonStaticMembers$2 = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.kyb.adapter.KybTopServiceAdapter.ViewHolder.<init>(id.dana.kyb.adapter.KybTopServiceAdapter, id.dana.databinding.ItemKybTopServiceBinding):void");
        }

        @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
        public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(KybServiceModel kybServiceModel, int i) {
            final KybServiceModel kybServiceModel2 = kybServiceModel;
            Intrinsics.checkNotNullParameter(kybServiceModel2, "");
            ItemKybTopServiceBinding itemKybTopServiceBinding = this.KClassImpl$Data$declaredNonStaticMembers$2;
            final KybTopServiceAdapter kybTopServiceAdapter = this.getAuthRequestContext;
            itemKybTopServiceBinding.BuiltInFictitiousFunctionClassFactory.setText(kybServiceModel2.getErrorConfigVersion);
            AppCompatImageView appCompatImageView = itemKybTopServiceBinding.MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            AppCompatImageView appCompatImageView2 = appCompatImageView;
            GlideApp.getAuthRequestContext(appCompatImageView2.getContext()).PlaceComponentResult(kybServiceModel2.getAuthRequestContext).getErrorConfigVersion((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).PlaceComponentResult((int) R.drawable.res_0x7f080633_networkuserentitydata_externalsyntheticlambda2).MyBillsEntityDataFactory((ImageView) appCompatImageView2);
            itemKybTopServiceBinding.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.adapter.KybTopServiceAdapter$ViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    KybTopServiceAdapter.ViewHolder.MyBillsEntityDataFactory(KybTopServiceAdapter.this, kybServiceModel2);
                }
            });
        }

        public static /* synthetic */ void MyBillsEntityDataFactory(KybTopServiceAdapter kybTopServiceAdapter, KybServiceModel kybServiceModel) {
            Intrinsics.checkNotNullParameter(kybTopServiceAdapter, "");
            Intrinsics.checkNotNullParameter(kybServiceModel, "");
            Function1<? super KybServiceModel, Unit> function1 = kybTopServiceAdapter.BuiltInFictitiousFunctionClassFactory;
            if (function1 != null) {
                function1.invoke(kybServiceModel);
            }
        }
    }
}
