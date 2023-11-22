package id.dana.promodiscovery.viewholder;

import android.view.View;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.promodiscovery.model.DiscoverySectionModel;
import id.dana.promodiscovery.model.FourKingItem;
import id.dana.promodiscovery.model.FourKingModel;
import id.dana.promodiscovery.model.SectionState;
import id.dana.promodiscovery.richview.FourKingView;
import id.dana.promodiscovery.richview.PromoDiscoveryListItemListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u001d\u0012\u0006\u0010\r\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0006¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0012\u0010\f\u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u000b"}, d2 = {"Lid/dana/promodiscovery/viewholder/FourKingSectionViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/promodiscovery/model/DiscoverySectionModel;", "Lid/dana/promodiscovery/model/FourKingModel;", "", "BuiltInFictitiousFunctionClassFactory", "()V", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "PlaceComponentResult", "Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "p0", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/promodiscovery/richview/PromoDiscoveryListItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FourKingSectionViewHolder extends BaseRecyclerViewHolder<DiscoverySectionModel<FourKingModel>> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;
    public final PromoDiscoveryListItemListener<FourKingModel> PlaceComponentResult;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[SectionState.values().length];
            iArr[SectionState.ACTIVE.ordinal()] = 1;
            iArr[SectionState.LOADING.ordinal()] = 2;
            PlaceComponentResult = iArr;
            int[] iArr2 = new int[FourKingItem.values().length];
            iArr2[FourKingItem.POINT.ordinal()] = 1;
            iArr2[FourKingItem.VOUCHER.ordinal()] = 2;
            iArr2[FourKingItem.LOYALTY.ordinal()] = 3;
            iArr2[FourKingItem.QUEST.ordinal()] = 4;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr2;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(DiscoverySectionModel<FourKingModel> discoverySectionModel) {
        FourKingView fourKingView;
        DiscoverySectionModel<FourKingModel> discoverySectionModel2 = discoverySectionModel;
        if (discoverySectionModel2 != null) {
            int i = WhenMappings.PlaceComponentResult[discoverySectionModel2.BuiltInFictitiousFunctionClassFactory.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    BuiltInFictitiousFunctionClassFactory();
                    return;
                }
                FourKingView fourKingView2 = (FourKingView) this.itemView.findViewById(R.id.DynamicExtension);
                if (fourKingView2 != null) {
                    fourKingView2.showSkeleton();
                }
                FourKingView fourKingView3 = (FourKingView) this.itemView.findViewById(R.id.res_0x7f0a0785_logeventdropped_reason);
                if (fourKingView3 != null) {
                    fourKingView3.showSkeleton();
                }
                FourKingView fourKingView4 = (FourKingView) this.itemView.findViewById(R.id.setmSubmitInterface);
                if (fourKingView4 != null) {
                    fourKingView4.showSkeleton();
                }
                FourKingView fourKingView5 = (FourKingView) this.itemView.findViewById(R.id.fourKingQuest);
                if (fourKingView5 != null) {
                    fourKingView5.showSkeleton();
                    return;
                }
                return;
            }
            BuiltInFictitiousFunctionClassFactory();
            for (final FourKingModel fourKingModel : discoverySectionModel2.KClassImpl$Data$declaredNonStaticMembers$2) {
                int i2 = WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[fourKingModel.PlaceComponentResult.ordinal()];
                if (i2 == 1) {
                    FourKingView fourKingView6 = (FourKingView) this.itemView.findViewById(R.id.DynamicExtension);
                    if (fourKingView6 != null) {
                        Intrinsics.checkNotNullExpressionValue(fourKingView6, "");
                        fourKingView6.updateData(fourKingModel);
                        fourKingView6.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.FourKingSectionViewHolder$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                FourKingSectionViewHolder.BuiltInFictitiousFunctionClassFactory(FourKingSectionViewHolder.this, fourKingModel);
                            }
                        });
                    }
                } else if (i2 == 2) {
                    FourKingView fourKingView7 = (FourKingView) this.itemView.findViewById(R.id.res_0x7f0a0785_logeventdropped_reason);
                    if (fourKingView7 != null) {
                        Intrinsics.checkNotNullExpressionValue(fourKingView7, "");
                        fourKingView7.updateData(fourKingModel);
                        fourKingView7.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.FourKingSectionViewHolder$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                FourKingSectionViewHolder.BuiltInFictitiousFunctionClassFactory(FourKingSectionViewHolder.this, fourKingModel);
                            }
                        });
                    }
                } else if (i2 == 3) {
                    FourKingView fourKingView8 = (FourKingView) this.itemView.findViewById(R.id.setmSubmitInterface);
                    if (fourKingView8 != null) {
                        Intrinsics.checkNotNullExpressionValue(fourKingView8, "");
                        fourKingView8.updateData(fourKingModel);
                        fourKingView8.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.FourKingSectionViewHolder$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                FourKingSectionViewHolder.BuiltInFictitiousFunctionClassFactory(FourKingSectionViewHolder.this, fourKingModel);
                            }
                        });
                    }
                } else if (i2 == 4 && (fourKingView = (FourKingView) this.itemView.findViewById(R.id.fourKingQuest)) != null) {
                    if (Intrinsics.areEqual(fourKingModel.getAuthRequestContext, "0")) {
                        String string = getContext().getString(R.string.soon);
                        Intrinsics.checkNotNullExpressionValue(string, "");
                        Intrinsics.checkNotNullParameter(string, "");
                        fourKingModel.getAuthRequestContext = string;
                    }
                    Unit unit = Unit.INSTANCE;
                    fourKingView.updateData(fourKingModel);
                    fourKingView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.viewholder.FourKingSectionViewHolder$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            FourKingSectionViewHolder.BuiltInFictitiousFunctionClassFactory(FourKingSectionViewHolder.this, fourKingModel);
                        }
                    });
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FourKingSectionViewHolder(ViewGroup viewGroup, PromoDiscoveryListItemListener<? super FourKingModel> promoDiscoveryListItemListener) {
        super(viewGroup.getContext(), R.layout.four_king_section_layout, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(promoDiscoveryListItemListener, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        this.PlaceComponentResult = promoDiscoveryListItemListener;
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        FourKingView fourKingView = (FourKingView) this.itemView.findViewById(R.id.DynamicExtension);
        if (fourKingView != null) {
            fourKingView.hideSkeleton();
        }
        FourKingView fourKingView2 = (FourKingView) this.itemView.findViewById(R.id.res_0x7f0a0785_logeventdropped_reason);
        if (fourKingView2 != null) {
            fourKingView2.hideSkeleton();
        }
        FourKingView fourKingView3 = (FourKingView) this.itemView.findViewById(R.id.setmSubmitInterface);
        if (fourKingView3 != null) {
            fourKingView3.hideSkeleton();
        }
        FourKingView fourKingView4 = (FourKingView) this.itemView.findViewById(R.id.fourKingQuest);
        if (fourKingView4 != null) {
            fourKingView4.hideSkeleton();
        }
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FourKingSectionViewHolder fourKingSectionViewHolder, FourKingModel fourKingModel) {
        Intrinsics.checkNotNullParameter(fourKingSectionViewHolder, "");
        Intrinsics.checkNotNullParameter(fourKingModel, "");
        fourKingSectionViewHolder.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory(fourKingModel);
    }
}
