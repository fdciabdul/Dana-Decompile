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

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0003X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0003X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005"}, d2 = {"Lid/dana/social/view/RestrictedContactItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/Lazy;", "getAuthRequestContext", "Landroid/view/ViewGroup;", "p0", "Lid/dana/social/adapter/FriendshipListInteraction;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/FriendshipListInteraction;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RestrictedContactItemViewHolder extends BaseRecyclerViewHolder<RelationshipItemModel> {
    private final Lazy BuiltInFictitiousFunctionClassFactory;
    private final Lazy getAuthRequestContext;

    /* JADX WARN: Code restructure failed: missing block: B:81:0x00db, code lost:
    
        if ((((java.lang.String) r8.getAuthRequestContext.getValue()).length() > 0) != false) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e9  */
    @Override // id.dana.base.BaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* synthetic */ void bindData(id.dana.feeds.ui.model.RelationshipItemModel r9) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.view.RestrictedContactItemViewHolder.bindData(java.lang.Object):void");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestrictedContactItemViewHolder(ViewGroup viewGroup, final FriendshipListInteraction friendshipListInteraction) {
        super(viewGroup.getContext(), R.layout.item_restricted_contact_list, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<String>() { // from class: id.dana.social.view.RestrictedContactItemViewHolder$activeButtonText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FriendshipListInteraction.this.getKClassImpl$Data$declaredNonStaticMembers$2();
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(new Function0<String>() { // from class: id.dana.social.view.RestrictedContactItemViewHolder$inactiveButtonText$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return FriendshipListInteraction.this.getGetAuthRequestContext();
            }
        });
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.res_0x7f0a0578_access_setgotomylocationvisibility);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.RestrictedContactItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RestrictedContactItemViewHolder.MyBillsEntityDataFactory(FriendshipListInteraction.this, this);
                }
            });
        }
        Button button = (Button) view.findViewById(R.id.btn_modify_relationship);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.RestrictedContactItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    RestrictedContactItemViewHolder.PlaceComponentResult(FriendshipListInteraction.this, this);
                }
            });
        }
    }

    public static /* synthetic */ void PlaceComponentResult(FriendshipListInteraction friendshipListInteraction, RestrictedContactItemViewHolder restrictedContactItemViewHolder) {
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        Intrinsics.checkNotNullParameter(restrictedContactItemViewHolder, "");
        friendshipListInteraction.MyBillsEntityDataFactory(restrictedContactItemViewHolder.getAdapterPosition());
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FriendshipListInteraction friendshipListInteraction, RestrictedContactItemViewHolder restrictedContactItemViewHolder) {
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        Intrinsics.checkNotNullParameter(restrictedContactItemViewHolder, "");
        friendshipListInteraction.KClassImpl$Data$declaredNonStaticMembers$2(restrictedContactItemViewHolder.getAdapterPosition());
    }
}
