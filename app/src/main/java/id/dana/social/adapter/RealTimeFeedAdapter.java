package id.dana.social.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewSwitcher;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.social.adapter.viewholder.RealTimeFeedViewHolder;
import id.dana.social.adapter.viewholder.RealTimeGroupFeedViewHolder;
import id.dana.social.model.SocialFeedModel;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00182\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\f\u0012\u0006\u0010\b\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0015\u001a\u00020\u0013X\u0086\u0002¢\u0006\u0006\n\u0004\b\u000f\u0010\u0014"}, d2 = {"Lid/dana/social/adapter/RealTimeFeedAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/social/model/SocialFeedModel;", "", "p0", "getItemViewType", "(I)I", "p1", "", "onBindViewHolder", "(Lid/dana/base/BaseRecyclerViewHolder;I)V", "Landroid/content/Context;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "MyBillsEntityDataFactory", "Lid/dana/social/adapter/SocialFeedClickListener;", "", "Z", "PlaceComponentResult", "<init>", "(Landroid/content/Context;Lid/dana/social/adapter/SocialFeedClickListener;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RealTimeFeedAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<SocialFeedModel>, SocialFeedModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public boolean PlaceComponentResult;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context BuiltInFictitiousFunctionClassFactory;
    private final SocialFeedClickListener MyBillsEntityDataFactory;

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((RealTimeFeedAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RealTimeFeedViewHolder realTimeFeedViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 2) {
            realTimeFeedViewHolder = new RealTimeGroupFeedViewHolder(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, viewGroup);
        } else {
            realTimeFeedViewHolder = new RealTimeFeedViewHolder(this.MyBillsEntityDataFactory, this.BuiltInFictitiousFunctionClassFactory, viewGroup);
        }
        return realTimeFeedViewHolder;
    }

    public RealTimeFeedAdapter(Context context, SocialFeedClickListener socialFeedClickListener) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = context;
        this.MyBillsEntityDataFactory = socialFeedClickListener;
        this.PlaceComponentResult = true;
        setItems(new ArrayList());
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void onBindViewHolder(BaseRecyclerViewHolder<SocialFeedModel> p0, int p1) {
        ViewSwitcher viewSwitcher;
        Intrinsics.checkNotNullParameter(p0, "");
        super.onBindViewHolder((RealTimeFeedAdapter) p0, p1);
        if (this.PlaceComponentResult && (p0 instanceof RealTimeFeedViewHolder) && p1 == 0) {
            final RealTimeFeedViewHolder realTimeFeedViewHolder = (RealTimeFeedViewHolder) p0;
            if (realTimeFeedViewHolder.KClassImpl$Data$declaredNonStaticMembers$2) {
                return;
            }
            realTimeFeedViewHolder.KClassImpl$Data$declaredNonStaticMembers$2 = true;
            View view = realTimeFeedViewHolder.itemView;
            ViewSwitcher viewSwitcher2 = (ViewSwitcher) view.findViewById(R.id.button_view_switch);
            if (!Intrinsics.areEqual(viewSwitcher2 != null ? viewSwitcher2.getCurrentView() : null, (LottieAnimationView) view.findViewById(R.id.res_0x7f0a0f22_daggermybillscomponent_mybillscomponentimpl_providefamilyaccountrepositoryprovider)) && (viewSwitcher = (ViewSwitcher) view.findViewById(R.id.button_view_switch)) != null) {
                viewSwitcher.showNext();
            }
            CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.UCropFragment);
            if (circleImageView != null) {
                circleImageView.setBorderColor(-65536);
            }
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.res_0x7f0a0f22_daggermybillscomponent_mybillscomponentimpl_providefamilyaccountrepositoryprovider);
            if (lottieAnimationView != null) {
                lottieAnimationView.playAnimation();
            }
            Disposable subscribe = Observable.timer(3L, TimeUnit.SECONDS).subscribeOn(Schedulers.getAuthRequestContext()).observeOn(AndroidSchedulers.PlaceComponentResult()).subscribe(new Consumer() { // from class: id.dana.social.adapter.viewholder.RealTimeFeedViewHolder$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    Long l = (Long) obj;
                    RealTimeFeedViewHolder.MyBillsEntityDataFactory(RealTimeFeedViewHolder.this);
                }
            });
            Intrinsics.checkNotNullExpressionValue(subscribe, "");
            realTimeFeedViewHolder.MyBillsEntityDataFactory = subscribe;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        return getItems().get(p0).GetContactSyncConfig;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/social/adapter/RealTimeFeedAdapter$Companion;", "", "Landroid/content/Context;", "p0", "", "MyBillsEntityDataFactory", "(Landroid/content/Context;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static int MyBillsEntityDataFactory(Context p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            RealTimeFeedViewHolder.Companion companion = RealTimeFeedViewHolder.INSTANCE;
            return RealTimeFeedViewHolder.Companion.KClassImpl$Data$declaredNonStaticMembers$2(p0);
        }
    }
}
