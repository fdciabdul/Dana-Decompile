package id.dana.social.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.databinding.ViewholderFeedSectionTitleBinding;
import id.dana.social.adapter.FriendRequestAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003B!\u0012\u0006\u0010\u0005\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/social/adapter/viewholder/FeedsSectionTitleViewHolder;", "", "T", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/databinding/ViewholderFeedSectionTitleBinding;", "p0", "", "bindData", "(Ljava/lang/Object;)V", "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestSectionFontType;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestSectionFontType;", "getAuthRequestContext", "", "PlaceComponentResult", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Landroid/view/ViewGroup;", "p1", "p2", "<init>", "(Landroid/view/ViewGroup;Ljava/lang/String;Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestSectionFontType;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsSectionTitleViewHolder<T> extends ViewBindingRecyclerViewHolder<T, ViewholderFeedSectionTitleBinding> {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final FriendRequestAdapter.FriendRequestSectionFontType getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final String BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
    public final /* synthetic */ ViewholderFeedSectionTitleBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewholderFeedSectionTitleBinding PlaceComponentResult = ViewholderFeedSectionTitleBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    public /* synthetic */ FeedsSectionTitleViewHolder(ViewGroup viewGroup, String str, FriendRequestAdapter.FriendRequestSectionFontType friendRequestSectionFontType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewGroup, str, (i & 4) != 0 ? FriendRequestAdapter.FriendRequestSectionFontType.DEFAULT : friendRequestSectionFontType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsSectionTitleViewHolder(android.view.ViewGroup r3, java.lang.String r4, id.dana.social.adapter.FriendRequestAdapter.FriendRequestSectionFontType r5) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.content.Context r1 = r3.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r0 = 2131560271(0x7f0d074f, float:1.874591E38)
            r2.<init>(r1, r0, r3)
            r2.BuiltInFictitiousFunctionClassFactory = r4
            r2.getAuthRequestContext = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.adapter.viewholder.FeedsSectionTitleViewHolder.<init>(android.view.ViewGroup, java.lang.String, id.dana.social.adapter.FriendRequestAdapter$FriendRequestSectionFontType):void");
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void bindData(T p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        if (this.getAuthRequestContext == FriendRequestAdapter.FriendRequestSectionFontType.BOLD_GREY) {
            getBinding().getAuthRequestContext.setTextSize(2, 14.0f);
            getBinding().getAuthRequestContext.setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), (int) R.font.f34282131296266));
            getBinding().getAuthRequestContext.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f24002131099997));
        } else {
            getBinding().getAuthRequestContext.setTextSize(2, 12.0f);
            getBinding().getAuthRequestContext.setTypeface(ResourcesCompat.PlaceComponentResult(getContext(), (int) R.font.sf_pro_regular));
            getBinding().getAuthRequestContext.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(getContext(), R.color.f23982131099995));
        }
        getBinding().getAuthRequestContext.setText(this.BuiltInFictitiousFunctionClassFactory);
    }
}
