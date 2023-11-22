package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.promodiscovery.model.SectionState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\n\u001a\u00020\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0011\u0010\f\u001a\u00020\u000fX\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u0010"}, d2 = {"Lid/dana/promodiscovery/viewholder/ErrorViewHolder;", "T", "Lid/dana/base/BaseRecyclerViewHolder;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Lid/dana/promodiscovery/model/SectionState;", "getAuthRequestContext", "Lid/dana/promodiscovery/model/SectionState;", "MyBillsEntityDataFactory", "Lkotlin/Function1;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/model/SectionState;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ErrorViewHolder<T> extends BaseRecyclerViewHolder<T> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    public final ViewGroup PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<SectionState, Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final SectionState MyBillsEntityDataFactory;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] BuiltInFictitiousFunctionClassFactory;

        static {
            int[] iArr = new int[SectionState.values().length];
            iArr[SectionState.ERROR_GENERAL.ordinal()] = 1;
            iArr[SectionState.ERROR_NETWORK.ordinal()] = 2;
            iArr[SectionState.ERROR_LOCATION_PERMISSION.ordinal()] = 3;
            BuiltInFictitiousFunctionClassFactory = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lid/dana/promodiscovery/model/SectionState;", "it", "", BridgeDSL.INVOKE, "(Lid/dana/promodiscovery/model/SectionState;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.promodiscovery.viewholder.ErrorViewHolder$1 */
    /* loaded from: classes5.dex */
    static final class AnonymousClass1 extends Lambda implements Function1<SectionState, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        /* renamed from: invoke */
        public final void invoke2(SectionState sectionState) {
            Intrinsics.checkNotNullParameter(sectionState, "");
        }

        @Override // kotlin.jvm.functions.Function1
        public final /* bridge */ /* synthetic */ Unit invoke(SectionState sectionState) {
            invoke2(sectionState);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ErrorViewHolder(ViewGroup viewGroup, SectionState sectionState, Function1<? super SectionState, Unit> function1) {
        super(viewGroup.getContext(), R.layout.error_promo_discovery_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(sectionState, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = viewGroup;
        this.MyBillsEntityDataFactory = sectionState;
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
        int i = WhenMappings.BuiltInFictitiousFunctionClassFactory[this.MyBillsEntityDataFactory.ordinal()];
        if (i == 1) {
            View view = this.itemView;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.ProductFlavor);
            if (appCompatImageView instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView, R.drawable.ic_maintenance_page);
            } else {
                appCompatImageView.setImageResource(R.drawable.ic_maintenance_page);
            }
            ((AppCompatTextView) view.findViewById(R.id.unsubscribe)).setText(view.getResources().getString(R.string.promo_discovery_error_general_title));
            ((AppCompatTextView) view.findViewById(R.id.MerchantReviewFormAnalyticTracker)).setText(view.getResources().getString(R.string.promo_discovery_error_general_description));
            ((DanaButtonPrimaryView) view.findViewById(R.id.btnError)).setActiveButton(view.getResources().getString(R.string.try_again), null);
        } else if (i == 2) {
            View view2 = this.itemView;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view2.findViewById(R.id.ProductFlavor);
            if (appCompatImageView2 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView2, R.drawable.ic_network_error);
            } else {
                appCompatImageView2.setImageResource(R.drawable.ic_network_error);
            }
            ((AppCompatTextView) view2.findViewById(R.id.unsubscribe)).setText(view2.getResources().getString(R.string.promo_discovery_error_network_title));
            ((AppCompatTextView) view2.findViewById(R.id.MerchantReviewFormAnalyticTracker)).setText(view2.getResources().getString(R.string.promo_discovery_error_network_description));
            ((DanaButtonPrimaryView) view2.findViewById(R.id.btnError)).setActiveButton(view2.getResources().getString(R.string.try_again), null);
        } else if (i == 3) {
            View view3 = this.itemView;
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) view3.findViewById(R.id.ProductFlavor);
            if (appCompatImageView3 instanceof ImageView) {
                InstrumentInjector.Resources_setImageResource(appCompatImageView3, R.drawable.ic_location_permission_new);
            } else {
                appCompatImageView3.setImageResource(R.drawable.ic_location_permission_new);
            }
            ((AppCompatTextView) view3.findViewById(R.id.unsubscribe)).setText(view3.getResources().getString(R.string.promo_discovery_error_location_title));
            ((AppCompatTextView) view3.findViewById(R.id.MerchantReviewFormAnalyticTracker)).setText(view3.getResources().getString(R.string.promo_discovery_error_location_description));
            ((DanaButtonPrimaryView) view3.findViewById(R.id.btnError)).setActiveButton(view3.getResources().getString(R.string.allow_access), null);
        }
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) this.itemView.findViewById(R.id.btnError);
        if (danaButtonPrimaryView != null) {
            danaButtonPrimaryView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.ErrorViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    ErrorViewHolder.BuiltInFictitiousFunctionClassFactory(ErrorViewHolder.this);
                }
            });
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ErrorViewHolder errorViewHolder) {
        Intrinsics.checkNotNullParameter(errorViewHolder, "");
        errorViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(errorViewHolder.MyBillsEntityDataFactory);
    }
}
