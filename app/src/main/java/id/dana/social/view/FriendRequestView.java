package id.dana.social.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import id.dana.DanaApplication;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.databinding.ViewFriendRequestBinding;
import id.dana.feeds.ui.enums.FriendshipStatus;
import id.dana.feeds.ui.model.FriendModel;
import id.dana.social.adapter.FriendRequestAdapter;
import id.dana.social.extension.SocialFeedExtKt;
import id.dana.social.utils.FeedUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"B+\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003¢\u0006\u0004\b!\u0010$J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0016\u001a\u00020\u0013X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001b\u0010\u001b\u001a\u00020\u00188CX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0014\u0010\u001a"}, d2 = {"Lid/dana/social/view/FriendRequestView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewFriendRequestBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewFriendRequestBinding;", "Lid/dana/feeds/ui/model/FriendModel;", "friendModel", "", "setData", "(Lid/dana/feeds/ui/model/FriendModel;)V", "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setListener", "(Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;)V", "Lid/dana/social/utils/FeedUtils;", "PlaceComponentResult", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/FriendRequestAdapter$FriendRequestListener;", "", "getAuthRequestContext", "()Z", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FriendRequestView extends ViewBindingRichView<ViewFriendRequestBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private FriendRequestAdapter.FriendRequestListener PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final Lazy BuiltInFictitiousFunctionClassFactory;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[FriendshipStatus.values().length];
            iArr[FriendshipStatus.PROCESSING.ordinal()] = 1;
            iArr[FriendshipStatus.PENDING.ordinal()] = 2;
            iArr[FriendshipStatus.APPROVED.ordinal()] = 3;
            iArr[FriendshipStatus.REJECTED.ordinal()] = 4;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FriendRequestView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FriendRequestView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_friend_request;
    }

    @JvmName(name = "PlaceComponentResult")
    private final boolean PlaceComponentResult() {
        return ((Boolean) this.BuiltInFictitiousFunctionClassFactory.getValue()).booleanValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendRequestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<FeedUtils>() { // from class: id.dana.social.view.FriendRequestView$feedUtils$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedUtils invoke() {
                Context context2 = FriendRequestView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                return new FeedUtils(context2);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.social.view.FriendRequestView$isFeedRevamp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Context applicationContext = FriendRequestView.this.getContext().getApplicationContext();
                DanaApplication danaApplication = applicationContext instanceof DanaApplication ? (DanaApplication) applicationContext : null;
                return Boolean.valueOf(danaApplication != null ? danaApplication.isFeedRevamp() : false);
            }
        });
    }

    public /* synthetic */ FriendRequestView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FriendRequestView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<FeedUtils>() { // from class: id.dana.social.view.FriendRequestView$feedUtils$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FeedUtils invoke() {
                Context context2 = FriendRequestView.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "");
                return new FeedUtils(context2);
            }
        });
        this.BuiltInFictitiousFunctionClassFactory = LazyKt.lazy(new Function0<Boolean>() { // from class: id.dana.social.view.FriendRequestView$isFeedRevamp$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                Context applicationContext = FriendRequestView.this.getContext().getApplicationContext();
                DanaApplication danaApplication = applicationContext instanceof DanaApplication ? (DanaApplication) applicationContext : null;
                return Boolean.valueOf(danaApplication != null ? danaApplication.isFeedRevamp() : false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewFriendRequestBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewFriendRequestBinding MyBillsEntityDataFactory = ViewFriendRequestBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public final void setListener(FriendRequestAdapter.FriendRequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "");
        this.PlaceComponentResult = listener;
    }

    public final void setData(final FriendModel friendModel) {
        Intrinsics.checkNotNullParameter(friendModel, "");
        ShapeableImageView shapeableImageView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        Intrinsics.checkNotNullExpressionValue(shapeableImageView, "");
        SocialFeedExtKt.BuiltInFictitiousFunctionClassFactory(shapeableImageView, friendModel.getErrorConfigVersion, R.drawable.avatar_placeholder);
        getBinding().lookAheadTest.setText(((FeedUtils) this.MyBillsEntityDataFactory.getValue()).KClassImpl$Data$declaredNonStaticMembers$2(friendModel.moveToNextValue, PlaceComponentResult()));
        TextView textView = getBinding().scheduleImpl;
        String str = friendModel.lookAheadTest;
        if (!(str.length() > 0)) {
            str = null;
        }
        if (str == null) {
            str = friendModel.BuiltInFictitiousFunctionClassFactory;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(getContext().getString(R.string.friend_request_message));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(sb.toString());
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, str.length(), 33);
        textView.setText(spannableStringBuilder);
        int i = WhenMappings.getAuthRequestContext[friendModel.scheduleImpl.ordinal()];
        if (i == 1) {
            Group group = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(group, "");
            group.setVisibility(4);
            CircularProgressIndicator circularProgressIndicator = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(circularProgressIndicator, "");
            circularProgressIndicator.setVisibility(0);
        } else if (i == 2) {
            Group group2 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(group2, "");
            group2.setVisibility(0);
            CircularProgressIndicator circularProgressIndicator2 = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(circularProgressIndicator2, "");
            circularProgressIndicator2.setVisibility(4);
        } else if (i == 3 || i == 4) {
            Group group3 = getBinding().BuiltInFictitiousFunctionClassFactory;
            Intrinsics.checkNotNullExpressionValue(group3, "");
            group3.setVisibility(4);
            CircularProgressIndicator circularProgressIndicator3 = getBinding().MyBillsEntityDataFactory;
            Intrinsics.checkNotNullExpressionValue(circularProgressIndicator3, "");
            circularProgressIndicator3.setVisibility(4);
        }
        getBinding().PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FriendRequestView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendRequestView.m2963$r8$lambda$KWNrTIJpQ2U6rUp97Z6jrE99vQ(FriendRequestView.this, friendModel, view);
            }
        });
        getBinding().getAuthRequestContext.setOnClickListener(new View.OnClickListener() { // from class: id.dana.social.view.FriendRequestView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FriendRequestView.$r8$lambda$ueutu3si5q9e4I55THbpdyz7X0o(FriendRequestView.this, friendModel, view);
            }
        });
    }

    /* renamed from: $r8$lambda$KWNrTIJp-Q2U6rUp97Z6jrE99vQ  reason: not valid java name */
    public static /* synthetic */ void m2963$r8$lambda$KWNrTIJpQ2U6rUp97Z6jrE99vQ(FriendRequestView friendRequestView, FriendModel friendModel, View view) {
        Intrinsics.checkNotNullParameter(friendRequestView, "");
        Intrinsics.checkNotNullParameter(friendModel, "");
        FriendRequestAdapter.FriendRequestListener friendRequestListener = friendRequestView.PlaceComponentResult;
        if (friendRequestListener != null) {
            friendRequestListener.BuiltInFictitiousFunctionClassFactory(friendModel);
        }
    }

    public static /* synthetic */ void $r8$lambda$ueutu3si5q9e4I55THbpdyz7X0o(FriendRequestView friendRequestView, FriendModel friendModel, View view) {
        Intrinsics.checkNotNullParameter(friendRequestView, "");
        Intrinsics.checkNotNullParameter(friendModel, "");
        FriendRequestAdapter.FriendRequestListener friendRequestListener = friendRequestView.PlaceComponentResult;
        if (friendRequestListener != null) {
            friendRequestListener.getAuthRequestContext(friendModel);
        }
    }
}
