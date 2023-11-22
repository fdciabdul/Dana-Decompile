package id.dana.social.adapter.viewholder;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.request.BaseRequestOptions;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.domain.social.ModifyRelationOperationType;
import id.dana.feeds.ui.model.RelationshipItemModel;
import id.dana.social.adapter.FriendshipListInteraction;
import id.dana.utils.ImageResize;
import id.dana.utils.UrlUtil;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0004\u001a\u00020\u0011\u0012\u0006\u0010\u0006\u001a\u00020\r\u0012\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\n¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/social/adapter/viewholder/ReciprocalFriendListViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/feeds/ui/model/RelationshipItemModel;", "Landroid/view/View;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/view/View;I)V", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/FriendshipListInteraction;", "getAuthRequestContext", "Lid/dana/social/adapter/FriendshipListInteraction;", "PlaceComponentResult", "Landroid/view/ViewGroup;", "p2", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/FriendshipListInteraction;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReciprocalFriendListViewHolder extends BaseRecyclerViewHolder<RelationshipItemModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Function1<Integer, RelationshipItemModel> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final FriendshipListInteraction PlaceComponentResult;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(RelationshipItemModel relationshipItemModel) {
        RelationshipItemModel relationshipItemModel2 = relationshipItemModel;
        Intrinsics.checkNotNullParameter(relationshipItemModel2, "");
        super.bindData(relationshipItemModel2);
        String str = relationshipItemModel2.initRecordTimeStamp;
        if (!(str.length() > 0)) {
            str = null;
        }
        if (str == null) {
            str = relationshipItemModel2.scheduleImpl;
        }
        TextView textView = (TextView) this.itemView.findViewById(R.id.onRequestSendAccessibilityEvent);
        if (textView != null) {
            textView.setText(str);
        }
        String str2 = relationshipItemModel2.BuiltInFictitiousFunctionClassFactory;
        if (str2 != null) {
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(UrlUtil.getAuthRequestContext(str2)).BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) ImageResize.getAuthRequestContext()).getErrorConfigVersion((int) R.drawable.ic_avatar_grey_default).PlaceComponentResult((int) R.drawable.ic_avatar_grey_default).MyBillsEntityDataFactory((ImageView) this.itemView.findViewById(R.id.iv_friend_photo));
        } else {
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.iv_friend_photo);
            if (imageView != null) {
                InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_avatar_grey_default);
            }
        }
        View findViewById = this.itemView.findViewById(R.id.setLastTelemetrySync);
        if (findViewById != null) {
            Intrinsics.checkNotNullExpressionValue(findViewById, "");
            findViewById.setVisibility(relationshipItemModel2.getLookAheadTest() ? 0 : 8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ReciprocalFriendListViewHolder(ViewGroup viewGroup, FriendshipListInteraction friendshipListInteraction, Function1<? super Integer, RelationshipItemModel> function1) {
        super(viewGroup.getContext(), R.layout.item_all_friend_list, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        Intrinsics.checkNotNullParameter(friendshipListInteraction, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.PlaceComponentResult = friendshipListInteraction;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = function1;
        View view = this.itemView;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_friend_info);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.ReciprocalFriendListViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReciprocalFriendListViewHolder.PlaceComponentResult(ReciprocalFriendListViewHolder.this);
                }
            });
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.iv_more_action);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.ReciprocalFriendListViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReciprocalFriendListViewHolder.BuiltInFictitiousFunctionClassFactory(ReciprocalFriendListViewHolder.this, view2);
                }
            });
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(View p0, int p1) {
        Context context = getContext();
        if (context != null) {
            PopupMenu popupMenu = new PopupMenu(context, p0);
            new SupportMenuInflater(popupMenu.BuiltInFictitiousFunctionClassFactory).inflate(p1, popupMenu.PlaceComponentResult);
            popupMenu.KClassImpl$Data$declaredNonStaticMembers$2 = new PopupMenu.OnMenuItemClickListener() { // from class: id.dana.social.adapter.viewholder.ReciprocalFriendListViewHolder$$ExternalSyntheticLambda2
                @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
                public final boolean getAuthRequestContext(MenuItem menuItem) {
                    boolean MyBillsEntityDataFactory;
                    MyBillsEntityDataFactory = ReciprocalFriendListViewHolder.MyBillsEntityDataFactory(ReciprocalFriendListViewHolder.this, menuItem);
                    return MyBillsEntityDataFactory;
                }
            };
            if (!popupMenu.mPopup.MyBillsEntityDataFactory()) {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
        }
    }

    public static final boolean MyBillsEntityDataFactory(ReciprocalFriendListViewHolder reciprocalFriendListViewHolder, MenuItem menuItem) {
        ModifyRelationOperationType modifyRelationOperationType;
        Intrinsics.checkNotNullParameter(reciprocalFriendListViewHolder, "");
        Integer valueOf = Integer.valueOf(reciprocalFriendListViewHolder.getBindingAdapterPosition());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            FriendshipListInteraction friendshipListInteraction = reciprocalFriendListViewHolder.PlaceComponentResult;
            int itemId = menuItem.getItemId();
            if (itemId == R.id.option_mute) {
                modifyRelationOperationType = ModifyRelationOperationType.MUTE;
            } else if (itemId == R.id.option_unmute) {
                modifyRelationOperationType = ModifyRelationOperationType.UNMUTE;
            } else {
                modifyRelationOperationType = ModifyRelationOperationType.BLOCK;
            }
            friendshipListInteraction.MyBillsEntityDataFactory(intValue, modifyRelationOperationType);
            return true;
        }
        return false;
    }

    public static /* synthetic */ void PlaceComponentResult(ReciprocalFriendListViewHolder reciprocalFriendListViewHolder) {
        Intrinsics.checkNotNullParameter(reciprocalFriendListViewHolder, "");
        reciprocalFriendListViewHolder.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(reciprocalFriendListViewHolder.getBindingAdapterPosition());
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(ReciprocalFriendListViewHolder reciprocalFriendListViewHolder, View view) {
        Intrinsics.checkNotNullParameter(reciprocalFriendListViewHolder, "");
        if (Intrinsics.areEqual(reciprocalFriendListViewHolder.KClassImpl$Data$declaredNonStaticMembers$2.invoke(Integer.valueOf(reciprocalFriendListViewHolder.getBindingAdapterPosition())).getErrorConfigVersion, "MUTE")) {
            Intrinsics.checkNotNullExpressionValue(view, "");
            reciprocalFriendListViewHolder.BuiltInFictitiousFunctionClassFactory(view, R.menu.f46582131623943);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(view, "");
        reciprocalFriendListViewHolder.BuiltInFictitiousFunctionClassFactory(view, R.menu.f46542131623939);
    }
}
