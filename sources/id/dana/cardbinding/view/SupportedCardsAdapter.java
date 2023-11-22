package id.dana.cardbinding.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.utils.MDUtil;
import id.dana.R;
import id.dana.cardbinding.model.SupportedCardModel;
import id.dana.core.ui.glide.GlideApp;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00142\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0014\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\fR&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/cardbinding/view/SupportedCardsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lid/dana/cardbinding/view/SupportedCardsAdapter$SupportedCardsViewHolder;", "", "getItemCount", "()I", "Ljava/util/ArrayList;", "Lid/dana/cardbinding/model/SupportedCardModel;", "Lkotlin/collections/ArrayList;", "KClassImpl$Data$declaredNonStaticMembers$2", "()Ljava/util/ArrayList;", "Landroid/content/Context;", "Landroid/content/Context;", "PlaceComponentResult", "MyBillsEntityDataFactory", "Ljava/util/ArrayList;", "BuiltInFictitiousFunctionClassFactory", "p0", "<init>", "(Landroid/content/Context;)V", "Companion", "SupportedCardsViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SupportedCardsAdapter extends RecyclerView.Adapter<SupportedCardsViewHolder> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Context PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    ArrayList<SupportedCardModel> BuiltInFictitiousFunctionClassFactory;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ void onBindViewHolder(SupportedCardsViewHolder supportedCardsViewHolder, int i) {
        SupportedCardsViewHolder supportedCardsViewHolder2 = supportedCardsViewHolder;
        Intrinsics.checkNotNullParameter(supportedCardsViewHolder2, "");
        SupportedCardModel supportedCardModel = this.BuiltInFictitiousFunctionClassFactory.get(i);
        Intrinsics.checkNotNullExpressionValue(supportedCardModel, "");
        SupportedCardModel supportedCardModel2 = supportedCardModel;
        Intrinsics.checkNotNullParameter(supportedCardModel2, "");
        AppCompatImageView appCompatImageView = (AppCompatImageView) supportedCardsViewHolder2.itemView.findViewById(R.id.res_0x7f0a0a4a_logintrackingconstants_holdlogin);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        SupportedCardsViewHolder.MyBillsEntityDataFactory(appCompatImageView, supportedCardModel2.getAuthRequestContext);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ SupportedCardsViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_supported_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "");
        return new SupportedCardsViewHolder(this, inflate);
    }

    public SupportedCardsAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.PlaceComponentResult = context;
        this.BuiltInFictitiousFunctionClassFactory = KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public final int getPlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory.size();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/cardbinding/view/SupportedCardsAdapter$SupportedCardsViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/appcompat/widget/AppCompatImageView;", "", "p0", "", "MyBillsEntityDataFactory", "(Landroidx/appcompat/widget/AppCompatImageView;Ljava/lang/String;)V", "Landroid/view/View;", "<init>", "(Lid/dana/cardbinding/view/SupportedCardsAdapter;Landroid/view/View;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public final class SupportedCardsViewHolder extends RecyclerView.ViewHolder {
        final /* synthetic */ SupportedCardsAdapter getAuthRequestContext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SupportedCardsViewHolder(SupportedCardsAdapter supportedCardsAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "");
            this.getAuthRequestContext = supportedCardsAdapter;
        }

        static void MyBillsEntityDataFactory(AppCompatImageView appCompatImageView, String str) {
            GlideApp.getAuthRequestContext(appCompatImageView.getContext()).PlaceComponentResult(str).MyBillsEntityDataFactory((ImageView) appCompatImageView);
        }
    }

    public final ArrayList<SupportedCardModel> KClassImpl$Data$declaredNonStaticMembers$2() {
        String[] stringArray = MDUtil.INSTANCE.getStringArray(this.PlaceComponentResult, Integer.valueOf((int) R.array.default_supported_cards_image_url));
        String[] stringArray2 = MDUtil.INSTANCE.getStringArray(this.PlaceComponentResult, Integer.valueOf((int) R.array.default_supported_cards));
        ArrayList<SupportedCardModel> arrayList = new ArrayList<>();
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            arrayList.add(new SupportedCardModel(stringArray[i], stringArray2[i]));
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cardbinding/view/SupportedCardsAdapter$Companion;", "", "Landroid/content/Context;", "p0", "", "p1", "", "p2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/content/Context;Z)Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static RecyclerView.ItemDecoration KClassImpl$Data$declaredNonStaticMembers$2(final Context context, final boolean z) {
            Intrinsics.checkNotNullParameter(context, "");
            return new RecyclerView.ItemDecoration() { // from class: id.dana.cardbinding.view.SupportedCardsAdapter$Companion$provideItemDecorator$1
                final /* synthetic */ int BuiltInFictitiousFunctionClassFactory = 8;

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public final void getItemOffsets(Rect p0, View p1, RecyclerView p2, RecyclerView.State p3) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    Intrinsics.checkNotNullParameter(p1, "");
                    Intrinsics.checkNotNullParameter(p2, "");
                    Intrinsics.checkNotNullParameter(p3, "");
                    int i = (int) (this.BuiltInFictitiousFunctionClassFactory * context.getResources().getDisplayMetrics().density);
                    if (z) {
                        if (p2.getChildAdapterPosition(p1) == 0) {
                            p0.top = i;
                        }
                        int i2 = i * 2;
                        p0.left = i2;
                        p0.right = i2;
                        p0.bottom = i;
                        return;
                    }
                    if (p2.getChildAdapterPosition(p1) == 0) {
                        p0.left = i;
                    }
                    int i3 = i * 2;
                    p0.top = i3;
                    p0.bottom = i3;
                    p0.right = i;
                }
            };
        }
    }
}
