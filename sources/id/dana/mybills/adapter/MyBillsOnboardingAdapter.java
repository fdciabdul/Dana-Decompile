package id.dana.mybills.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.mybills.model.MyBillsOnboardingContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB#\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\r\u0010\u000eR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/mybills/adapter/MyBillsOnboardingAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/mybills/adapter/MyBillsOnboardingAdapter$MyBillsOnboardingViewHolder;", "Lid/dana/mybills/model/MyBillsOnboardingContent;", "Lkotlin/Function1;", "", "", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Landroid/content/Context;", "p0", "p1", "<init>", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "MyBillsOnboardingViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyBillsOnboardingAdapter extends BaseRecyclerViewAdapter<MyBillsOnboardingViewHolder, MyBillsOnboardingContent> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Function1<Integer, Unit> getAuthRequestContext;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new MyBillsOnboardingViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.mybills.adapter.MyBillsOnboardingAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                Function1 function1;
                function1 = MyBillsOnboardingAdapter.this.getAuthRequestContext;
                function1.invoke(Integer.valueOf(MyBillsOnboardingAdapter.getAuthRequestContext(MyBillsOnboardingAdapter.this, i2)));
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MyBillsOnboardingAdapter(Context context, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.getAuthRequestContext = function1;
        String string = context.getString(R.string.my_bills_intro_first_content_subtitle);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = context.getString(R.string.my_bills_intro_first_content_description);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String string3 = context.getString(R.string.my_bills_intro_second_content_subtitle);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = context.getString(R.string.my_bills_intro_second_content_description);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        String string5 = context.getString(R.string.my_bills_intro_third_content_subtitle);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = context.getString(R.string.my_bills_intro_third_content_description);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        setItems(CollectionsKt.mutableListOf(new MyBillsOnboardingContent(R.drawable.ic_my_bills_pay, string, string2), new MyBillsOnboardingContent(R.drawable.ic_my_bills_reminder, string3, string4), new MyBillsOnboardingContent(R.drawable.ic_my_bills_subscription, string5, string6)));
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/mybills/adapter/MyBillsOnboardingAdapter$MyBillsOnboardingViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/mybills/model/MyBillsOnboardingContent;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class MyBillsOnboardingViewHolder extends BaseRecyclerViewHolder<MyBillsOnboardingContent> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(MyBillsOnboardingContent myBillsOnboardingContent) {
            MyBillsOnboardingContent myBillsOnboardingContent2 = myBillsOnboardingContent;
            if (myBillsOnboardingContent2 != null) {
                View view = this.itemView;
                ((TextView) view.findViewById(R.id.tv_mybills_intro_subtitle)).setText(myBillsOnboardingContent2.MyBillsEntityDataFactory);
                ((TextView) view.findViewById(R.id.tv_mybills_intro_description)).setText(myBillsOnboardingContent2.getAuthRequestContext);
                Context context = view.getContext();
                if (context != null) {
                    Intrinsics.checkNotNullExpressionValue(context, "");
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(context).getAuthRequestContext(Integer.valueOf(myBillsOnboardingContent2.KClassImpl$Data$declaredNonStaticMembers$2)).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) view.findViewById(R.id.iv_mybills_intro_image)));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyBillsOnboardingViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1) {
            super(viewGroup.getContext(), R.layout.item_my_bills_onboarding, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(function1, "");
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.itemView.findViewById(R.id.iv_mybills_intro_image);
            if (appCompatImageView != null) {
                appCompatImageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: id.dana.mybills.adapter.MyBillsOnboardingAdapter$MyBillsOnboardingViewHolder$special$$inlined$doOnNextLayout$1
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
                        Intrinsics.checkNotNullParameter(p0, "");
                        p0.removeOnLayoutChangeListener(this);
                        Function1.this.invoke(Integer.valueOf(this.getAbsoluteAdapterPosition()));
                    }
                });
            }
        }
    }

    public static final /* synthetic */ int getAuthRequestContext(MyBillsOnboardingAdapter myBillsOnboardingAdapter, int i) {
        return (i + 1) % myBillsOnboardingAdapter.getItems().size();
    }
}
