package id.dana.social.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.adapter.FriendshipListInteraction;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0007\u001a\u00020\u0003X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0013\u0010\b\u001a\u00020\u0003X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/social/view/FriendshipItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "PlaceComponentResult", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "p0", "Lid/dana/social/adapter/FriendshipListInteraction;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/FriendshipListInteraction;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendshipItemViewHolder extends BaseRecyclerViewHolder<RelationshipItemModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy KClassImpl$Data$declaredNonStaticMembers$2;
    private final Lazy getAuthRequestContext;

    /* JADX WARN: Code restructure failed: missing block: B:87:0x00fb, code lost:
    
        if ((((java.lang.String) r8.KClassImpl$Data$declaredNonStaticMembers$2.getValue()).length() > 0) != false) goto L90;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0109  */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(id.dana.feeds.ui.model.RelationshipItemModel r9) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.FriendshipItemViewHolder.bindData(java.lang.Object):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendshipItemViewHolder(ViewGroup viewGroup, final FriendshipListInteraction friendshipListInteraction) {
        super(viewGroup.getContext(), R.layout.item_friendship_list, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        this.getAuthRequestContext = LazyKt.lazy(new Function0<String>() { // from class: id.dana.social.view.FriendshipItemViewHolder$activeButtonText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FriendshipListInteraction.this.getKClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.KClassImpl$Data$declaredNonStaticMembers$2 = LazyKt.lazy(new Function0<String>() { // from class: id.dana.social.view.FriendshipItemViewHolder$inactiveButtonText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FriendshipListInteraction.this.getGetAuthRequestContext();
            }
        });
        this.PlaceComponentResult = LazyKt.lazy(new Function0<String>() { // from class: id.dana.social.view.FriendshipItemViewHolder$activeButtonContentDescription$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FriendshipListInteraction.this.getPlaceComponentResult();
            }
        });
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.res_0x7f0a0578_access_setgotomylocationvisibility);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FriendshipItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FriendshipItemViewHolder.getAuthRequestContext(FriendshipListInteraction.this, this);
                }
            });
        }
        Button button = (Button) view.findViewById(R.id.btn_modify_relationship);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FriendshipItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FriendshipItemViewHolder.MyBillsEntityDataFactory(FriendshipListInteraction.this, this);
                }
            });
        }
    }

    public static /* synthetic */ void getAuthRequestContext(FriendshipListInteraction friendshipListInteraction, FriendshipItemViewHolder friendshipItemViewHolder) {
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        Intrinsics.checkNotNullParameter(friendshipItemViewHolder, "");
        friendshipListInteraction.KClassImpl$Data$declaredNonStaticMembers$2(friendshipItemViewHolder.getAdapterPosition());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FriendshipListInteraction friendshipListInteraction, FriendshipItemViewHolder friendshipItemViewHolder) {
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        Intrinsics.checkNotNullParameter(friendshipItemViewHolder, "");
        friendshipListInteraction.MyBillsEntityDataFactory(friendshipItemViewHolder.getAdapterPosition());
    }
}
