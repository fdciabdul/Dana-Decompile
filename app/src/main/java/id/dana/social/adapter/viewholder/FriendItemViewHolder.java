package id.dana.social.adapter.viewholder;

import android.view.View;
import android.widget.TextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.databinding.ViewholderFriendSearchItemBinding;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.adapter.FindFriendAdapter;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.utils.FeedsContentUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/social/adapter/viewholder/FriendItemViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/feeds/ui/model/FriendModel;", "Lid/dana/databinding/ViewholderFriendSearchItemBinding;", "", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "Lid/dana/social/adapter/FindFriendAdapter$FriendItemListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/FindFriendAdapter$FriendItemListener;", "Landroid/view/ViewGroup;", "p1", "<init>", "(Landroid/view/ViewGroup;Lid/dana/social/adapter/FindFriendAdapter$FriendItemListener;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendItemViewHolder extends ViewBindingRecyclerViewHolder<FriendModel, ViewholderFriendSearchItemBinding> {
    private final FindFriendAdapter.FriendItemListener MyBillsEntityDataFactory;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] KClassImpl$Data$declaredNonStaticMembers$2;

        static {
            int[] iArr = new int[FriendshipStatus.values().length];
            iArr[FriendshipStatus.NOT_AFFILIATED.ordinal()] = 1;
            iArr[FriendshipStatus.REJECTED.ordinal()] = 2;
            iArr[FriendshipStatus.CANCELLED.ordinal()] = 3;
            iArr[FriendshipStatus.PENDING.ordinal()] = 4;
            iArr[FriendshipStatus.PROCESSING.ordinal()] = 5;
            iArr[FriendshipStatus.APPROVED.ordinal()] = 6;
            iArr[FriendshipStatus.CURRENT_USER.ordinal()] = 7;
            KClassImpl$Data$declaredNonStaticMembers$2 = iArr;
        }
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        String str;
        final FriendModel friendModel = (FriendModel) obj;
        if (friendModel != null) {
            ShapeableImageView shapeableImageView = getBinding().getErrorConfigVersion;
            Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
            SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView, friendModel.getErrorConfigVersion, R.drawable.avatar_placeholder);
            TextView textView = getBinding().DatabaseTableConfigUtil;
            if (!friendModel.getMyBillsEntityDataFactory()) {
                StringBuilder sb = new StringBuilder();
                sb.append('@');
                sb.append(friendModel.lookAheadTest);
                str = sb.toString();
            } else {
                str = friendModel.lookAheadTest;
            }
            textView.setText(str);
            FeedsContentUtils feedsContentUtils = FeedsContentUtils.MyBillsEntityDataFactory;
            TextView textView2 = getBinding().moveToNextValue;
            Intrinsics.checkNotNullExpressionValue(textView2, "");
            FeedsContentUtils.KClassImpl$Data$declaredNonStaticMembers$2(textView2, friendModel.BuiltInFictitiousFunctionClassFactory);
            getBinding().lookAheadTest.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FriendItemViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendItemViewHolder.PlaceComponentResult(FriendItemViewHolder.this, friendModel);
                }
            });
            switch (WhenMappings.KClassImpl$Data$declaredNonStaticMembers$2[friendModel.scheduleImpl.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    DanaButtonPrimaryView danaButtonPrimaryView = getBinding().MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
                    danaButtonPrimaryView.setVisibility(0);
                    DanaButtonSecondaryView danaButtonSecondaryView = getBinding().BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
                    danaButtonSecondaryView.setVisibility(4);
                    CircularProgressIndicator circularProgressIndicator = getBinding().scheduleImpl;
                    Intrinsics.checkNotNullExpressionValue(circularProgressIndicator, "");
                    circularProgressIndicator.setVisibility(4);
                    BuiltInFictitiousFunctionClassFactory(false);
                    break;
                case 4:
                    DanaButtonSecondaryView danaButtonSecondaryView2 = getBinding().BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView2, "");
                    danaButtonSecondaryView2.setVisibility(friendModel.getGetAuthRequestContext() ? 0 : 8);
                    DanaButtonPrimaryView danaButtonPrimaryView2 = getBinding().MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView2, "");
                    danaButtonPrimaryView2.setVisibility(4);
                    CircularProgressIndicator circularProgressIndicator2 = getBinding().scheduleImpl;
                    Intrinsics.checkNotNullExpressionValue(circularProgressIndicator2, "");
                    circularProgressIndicator2.setVisibility(4);
                    BuiltInFictitiousFunctionClassFactory(!friendModel.getGetAuthRequestContext());
                    break;
                case 5:
                    CircularProgressIndicator circularProgressIndicator3 = getBinding().scheduleImpl;
                    Intrinsics.checkNotNullExpressionValue(circularProgressIndicator3, "");
                    circularProgressIndicator3.setVisibility(0);
                    DanaButtonPrimaryView danaButtonPrimaryView3 = getBinding().MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView3, "");
                    danaButtonPrimaryView3.setVisibility(4);
                    DanaButtonSecondaryView danaButtonSecondaryView3 = getBinding().BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView3, "");
                    danaButtonSecondaryView3.setVisibility(4);
                    BuiltInFictitiousFunctionClassFactory(false);
                    break;
                case 6:
                case 7:
                    DanaButtonPrimaryView danaButtonPrimaryView4 = getBinding().MyBillsEntityDataFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView4, "");
                    danaButtonPrimaryView4.setVisibility(4);
                    DanaButtonSecondaryView danaButtonSecondaryView4 = getBinding().BuiltInFictitiousFunctionClassFactory;
                    Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView4, "");
                    danaButtonSecondaryView4.setVisibility(4);
                    CircularProgressIndicator circularProgressIndicator4 = getBinding().scheduleImpl;
                    Intrinsics.checkNotNullExpressionValue(circularProgressIndicator4, "");
                    circularProgressIndicator4.setVisibility(4);
                    BuiltInFictitiousFunctionClassFactory(false);
                    break;
            }
            getBinding().MyBillsEntityDataFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FriendItemViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendItemViewHolder.getAuthRequestContext(FriendItemViewHolder.this, friendModel);
                }
            });
            getBinding().BuiltInFictitiousFunctionClassFactory.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FriendItemViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendItemViewHolder.MyBillsEntityDataFactory(FriendItemViewHolder.this, friendModel);
                }
            });
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FriendItemViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendItemViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(FriendItemViewHolder.this, friendModel);
                }
            });
            getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.adapter.viewholder.FriendItemViewHolder$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FriendItemViewHolder.BuiltInFictitiousFunctionClassFactory(FriendItemViewHolder.this, friendModel);
                }
            });
        }
    }

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewholderFriendSearchItemBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewholderFriendSearchItemBinding PlaceComponentResult = ViewholderFriendSearchItemBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FriendItemViewHolder(android.view.ViewGroup r3, id.dana.social.adapter.FindFriendAdapter.FriendItemListener r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560283(0x7f0d075b, float:1.8745934E38)
            r2.<init>(r1, r0, r3)
            r2.MyBillsEntityDataFactory = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.viewholder.FriendItemViewHolder.<init>(android.view.ViewGroup, id.dana.social.adapter.FindFriendAdapter$FriendItemListener):void");
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        DanaButtonPrimaryView danaButtonPrimaryView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(danaButtonPrimaryView, "");
        danaButtonPrimaryView.setVisibility(p0 ? 0 : 8);
        DanaButtonSecondaryView danaButtonSecondaryView = getBinding().getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(danaButtonSecondaryView, "");
        danaButtonSecondaryView.setVisibility(p0 ? 0 : 8);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FriendItemViewHolder friendItemViewHolder, FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendItemViewHolder, "");
        friendItemViewHolder.MyBillsEntityDataFactory.PlaceComponentResult(friendModel);
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(FriendItemViewHolder friendItemViewHolder, FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendItemViewHolder, "");
        friendItemViewHolder.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(friendModel);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(FriendItemViewHolder friendItemViewHolder, FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendItemViewHolder, "");
        friendItemViewHolder.MyBillsEntityDataFactory.MyBillsEntityDataFactory(friendModel);
    }

    public static /* synthetic */ void PlaceComponentResult(FriendItemViewHolder friendItemViewHolder, FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendItemViewHolder, "");
        friendItemViewHolder.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(friendModel);
    }

    public static /* synthetic */ void getAuthRequestContext(FriendItemViewHolder friendItemViewHolder, FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendItemViewHolder, "");
        friendItemViewHolder.MyBillsEntityDataFactory.getAuthRequestContext(friendModel);
    }
}
