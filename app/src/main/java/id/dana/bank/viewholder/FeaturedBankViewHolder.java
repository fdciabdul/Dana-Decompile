package id.dana.bank.viewholder;

import android.view.View;
import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemTopBankListBinding;
import id.dana.sendmoney.model.BankModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B+\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R#\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/bank/viewholder/FeaturedBankViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/sendmoney/model/BankModel;", "Lid/dana/databinding/ItemTopBankListBinding;", "PlaceComponentResult", "Lid/dana/databinding/ItemTopBankListBinding;", "Lkotlin/Function2;", "", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function2;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Lid/dana/databinding/ItemTopBankListBinding;Lkotlin/jvm/functions/Function2;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeaturedBankViewHolder extends BaseViewBindingViewHolder<BankModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final Function2<BankModel, Integer, Unit> KClassImpl$Data$declaredNonStaticMembers$2;
    private final ItemTopBankListBinding PlaceComponentResult;

    @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BankModel bankModel, int i) {
        final BankModel bankModel2 = bankModel;
        Intrinsics.checkNotNullParameter(bankModel2, "");
        super.KClassImpl$Data$declaredNonStaticMembers$2((FeaturedBankViewHolder) bankModel2, i);
        this.PlaceComponentResult.MyBillsEntityDataFactory.setText(bankModel2.NetworkUserEntityData$$ExternalSyntheticLambda0);
        ImageView imageView = this.PlaceComponentResult.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(bankModel2.PlaceComponentResult()).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).SubSequence().MyBillsEntityDataFactory(imageView);
        if (StringsKt.equals(bankModel2.NetworkUserEntityData$$ExternalSyntheticLambda0, "bca", true)) {
            this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2.setContentDescription(this.PlaceComponentResult.PlaceComponentResult.getContext().getString(R.string.btnTopBca));
        }
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.bank.viewholder.FeaturedBankViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeaturedBankViewHolder.PlaceComponentResult(FeaturedBankViewHolder.this, bankModel2);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/model/BankModel;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Lid/dana/sendmoney/model/BankModel;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.bank.viewholder.FeaturedBankViewHolder$1 */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements Function2<BankModel, Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        public final void invoke(BankModel bankModel, int i) {
            Intrinsics.checkNotNullParameter(bankModel, "");
        }

        @Override // kotlin.jvm.functions.Function2
        public final /* synthetic */ Unit invoke(BankModel bankModel, Integer num) {
            invoke(bankModel, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlin.jvm.functions.Function2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeaturedBankViewHolder(id.dana.databinding.ItemTopBankListBinding r4, kotlin.jvm.functions.Function2<? super id.dana.sendmoney.model.BankModel, ? super java.lang.Integer, kotlin.Unit> r5) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r4
            androidx.viewbinding.ViewBinding r0 = (androidx.viewbinding.ViewBinding) r0
            r1 = 0
            r2 = 2
            r3.<init>(r0, r1, r2, r1)
            r3.PlaceComponentResult = r4
            r3.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.bank.viewholder.FeaturedBankViewHolder.<init>(id.dana.databinding.ItemTopBankListBinding, kotlin.jvm.functions.Function2):void");
    }

    public static /* synthetic */ void PlaceComponentResult(FeaturedBankViewHolder featuredBankViewHolder, BankModel bankModel) {
        Intrinsics.checkNotNullParameter(featuredBankViewHolder, "");
        Intrinsics.checkNotNullParameter(bankModel, "");
        if (featuredBankViewHolder.getAbsoluteAdapterPosition() >= 0) {
            featuredBankViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke(bankModel, Integer.valueOf(featuredBankViewHolder.getAbsoluteAdapterPosition()));
        }
    }
}
