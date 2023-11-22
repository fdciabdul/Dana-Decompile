package id.dana.sendmoney_v2.x2l;

import id.dana.R;
import id.dana.data.socialshare.ShareAppKey;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney_v2/x2l/SocialLinkUtil;", "", "", "p0", "", "PlaceComponentResult", "(Ljava/lang/String;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SocialLinkUtil {
    public static final SocialLinkUtil INSTANCE = new SocialLinkUtil();

    private SocialLinkUtil() {
    }

    public static int PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = p0.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        switch (lowerCase.hashCode()) {
            case -1436108013:
                if (lowerCase.equals(ShareAppKey.MESSENGER)) {
                    return R.drawable.ic_social_messenger;
                }
                break;
            case -1360467711:
                if (lowerCase.equals(ShareAppKey.TELEGRAM)) {
                    return R.drawable.ic_social_telegram;
                }
                break;
            case -791770330:
                if (lowerCase.equals(ShareAppKey.WECHAT)) {
                    return R.drawable.ic_social_wechat;
                }
                break;
            case 3321844:
                if (lowerCase.equals(ShareAppKey.LINE)) {
                    return R.drawable.ic_social_line;
                }
                break;
            case 28903346:
                if (lowerCase.equals(ShareAppKey.INSTAGRAM)) {
                    return R.drawable.ic_social_instagram;
                }
                break;
            case 109518736:
                if (lowerCase.equals(ShareAppKey.SLACK)) {
                    return R.drawable.ic_social_slack;
                }
                break;
            case 133862058:
                if (lowerCase.equals(ShareAppKey.DINGTALK)) {
                    return R.drawable.ic_social_dingtalk;
                }
                break;
            case 497130182:
                if (lowerCase.equals(ShareAppKey.FACEBOOK)) {
                    return R.drawable.ic_social_facebook;
                }
                break;
            case 1934780818:
                if (lowerCase.equals(ShareAppKey.WHATSAPP)) {
                    return R.drawable.ic_social_whatsapp;
                }
                break;
        }
        return R.drawable.ic_more_social_link;
    }
}
