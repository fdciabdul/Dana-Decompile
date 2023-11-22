package id.dana.social;

import android.content.Context;
import id.dana.R;
import id.dana.social.FriendshipBottomSheetHelpActivity;
import id.dana.usereducation.model.ContentOnBoardingModel;
import id.dana.usereducation.model.OnBoardingModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J/\u0010\f\u001a\u00020\u000b2\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rR$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0010"}, d2 = {"Lid/dana/social/FeedsIntroduction;", "", "", "MyBillsEntityDataFactory", "()V", "Ljava/util/ArrayList;", "Lid/dana/usereducation/model/ContentOnBoardingModel;", "Lkotlin/collections/ArrayList;", "p0", "Landroid/content/Context;", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/ArrayList;Landroid/content/Context;)Z", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/ArrayList;", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsIntroduction {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final ArrayList<ContentOnBoardingModel> BuiltInFictitiousFunctionClassFactory;

    public FeedsIntroduction(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        ArrayList<ContentOnBoardingModel> arrayList = new ArrayList<>();
        this.BuiltInFictitiousFunctionClassFactory = arrayList;
        BuiltInFictitiousFunctionClassFactory(arrayList, context);
    }

    public final void MyBillsEntityDataFactory() {
        Context context = this.KClassImpl$Data$declaredNonStaticMembers$2;
        FriendshipBottomSheetHelpActivity.Companion companion = FriendshipBottomSheetHelpActivity.INSTANCE;
        Context context2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String string = context.getString(R.string.feed_introfuction_page_header_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        context.startActivity(FriendshipBottomSheetHelpActivity.Companion.getAuthRequestContext(context2, new OnBoardingModel(string, "list", this.BuiltInFictitiousFunctionClassFactory, "friendship", null, null, null, 112, null)));
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(ArrayList<ContentOnBoardingModel> p0, Context p1) {
        String string = p1.getString(R.string.feed_introduction_first_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String string2 = p1.getString(R.string.feed_introduction_first_description);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        p0.add(new ContentOnBoardingModel((int) R.drawable.ic_friendship_proceed, string, string2));
        String string3 = p1.getString(R.string.feed_introduction_second_title);
        Intrinsics.checkNotNullExpressionValue(string3, "");
        String string4 = p1.getString(R.string.feed_introduction_second_description);
        Intrinsics.checkNotNullExpressionValue(string4, "");
        p0.add(new ContentOnBoardingModel((int) R.drawable.ic_friendship_people, string3, string4));
        String string5 = p1.getString(R.string.feed_introduction_third_title);
        Intrinsics.checkNotNullExpressionValue(string5, "");
        String string6 = p1.getString(R.string.feed_introduction_third_description);
        Intrinsics.checkNotNullExpressionValue(string6, "");
        return p0.add(new ContentOnBoardingModel((int) R.drawable.ic_friendship_ok, string5, string6));
    }
}
