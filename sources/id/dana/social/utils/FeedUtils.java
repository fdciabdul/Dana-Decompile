package id.dana.social.utils;

import android.content.Context;
import id.dana.R;
import id.dana.utils.DateTimeUtil;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/social/utils/FeedUtils;", "", "Ljava/util/Date;", "p0", "", "getAuthRequestContext", "(Ljava/util/Date;)Z", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(JZ)Ljava/lang/String;", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedUtils {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context MyBillsEntityDataFactory;

    @Inject
    public FeedUtils(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        this.MyBillsEntityDataFactory = context;
    }

    private static boolean getAuthRequestContext(Date p0) {
        return DateTimeUtil.lookAheadTest(p0) < Calendar.getInstance().get(1);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/social/utils/FeedUtils$Companion;", "", "", "p0", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static String BuiltInFictitiousFunctionClassFactory(String p0) {
            StringBuilder sb = new StringBuilder();
            sb.append("https://link.dana.id/friendship?params=[target=friends,bizOrderId=");
            sb.append(p0);
            sb.append(",Source=Payment Success]");
            return sb.toString();
        }
    }

    public final String KClassImpl$Data$declaredNonStaticMembers$2(long p0, boolean p1) {
        String string;
        String str;
        int MyBillsEntityDataFactory = (int) DateTimeUtil.MyBillsEntityDataFactory(new Date(), new Date(p0));
        Date date = new Date(p0);
        FeedUtils$getContentDate$1 feedUtils$getContentDate$1 = new Function2<String, Date, String>() { // from class: id.dana.social.utils.FeedUtils$getContentDate$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str2, Date date2) {
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(date2, "");
                return str2;
            }
        };
        if (MyBillsEntityDataFactory == 0) {
            string = this.MyBillsEntityDataFactory.getString(R.string.feed_section_today);
        } else if (MyBillsEntityDataFactory == 1) {
            string = this.MyBillsEntityDataFactory.getString(R.string.feed_section_yesterday);
        } else {
            string = DateTimeUtil.MyBillsEntityDataFactory(date, p1 ? "dd MMM" : "dd MMMM");
        }
        if (getAuthRequestContext(date)) {
            Intrinsics.checkNotNullExpressionValue(string, "");
            string = feedUtils$getContentDate$1.invoke((FeedUtils$getContentDate$1) string, (String) date);
        }
        if (string != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(", ");
            sb.append(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(new Date(p0)));
            str = sb.toString();
        } else {
            str = null;
        }
        return str == null ? "" : str;
    }
}
