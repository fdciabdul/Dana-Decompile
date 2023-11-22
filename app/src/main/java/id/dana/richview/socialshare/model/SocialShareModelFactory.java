package id.dana.richview.socialshare.model;

import android.content.Context;
import id.dana.R;
import id.dana.data.socialshare.ShareAppKey;
import id.dana.richview.socialshare.AppPackageName;
import id.dana.richview.socialshare.model.SocialShareModel;

/* loaded from: classes5.dex */
public class SocialShareModelFactory {
    private SocialShareModelFactory() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SocialShareModel BuiltInFictitiousFunctionClassFactory(Context context, String str) {
        char c;
        str.hashCode();
        byte b = 0;
        switch (str.hashCode()) {
            case -1436108013:
                if (str.equals(ShareAppKey.MESSENGER)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1360467711:
                if (str.equals(ShareAppKey.TELEGRAM)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -791770330:
                if (str.equals(ShareAppKey.WECHAT)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3321844:
                if (str.equals(ShareAppKey.LINE)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 28903346:
                if (str.equals(ShareAppKey.INSTAGRAM)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 109518736:
                if (str.equals(ShareAppKey.SLACK)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 133862058:
                if (str.equals(ShareAppKey.DINGTALK)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 497130182:
                if (str.equals(ShareAppKey.FACEBOOK)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1934780818:
                if (str.equals(ShareAppKey.WHATSAPP)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                SocialShareModel.Builder builder = new SocialShareModel.Builder();
                builder.getAuthRequestContext = context.getString(R.string.messenger);
                builder.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.MESSENGER;
                builder.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_messenger;
                return new SocialShareModel(builder, b);
            case 1:
                SocialShareModel.Builder builder2 = new SocialShareModel.Builder();
                builder2.getAuthRequestContext = context.getString(R.string.telegram);
                builder2.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.TELEGRAM;
                builder2.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_telegram;
                return new SocialShareModel(builder2, b);
            case 2:
                SocialShareModel.Builder builder3 = new SocialShareModel.Builder();
                builder3.getAuthRequestContext = context.getString(R.string.wechat);
                builder3.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.WECHAT;
                builder3.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_wechat;
                return new SocialShareModel(builder3, b);
            case 3:
                SocialShareModel.Builder builder4 = new SocialShareModel.Builder();
                builder4.getAuthRequestContext = context.getString(R.string.line);
                builder4.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.LINE;
                builder4.PlaceComponentResult = context.getString(R.string.btnShareLine);
                builder4.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_line;
                return new SocialShareModel(builder4, b);
            case 4:
                SocialShareModel.Builder builder5 = new SocialShareModel.Builder();
                builder5.getAuthRequestContext = context.getString(R.string.instagram);
                builder5.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.INSTAGRAM;
                builder5.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_instagram;
                return new SocialShareModel(builder5, b);
            case 5:
                SocialShareModel.Builder builder6 = new SocialShareModel.Builder();
                builder6.getAuthRequestContext = context.getString(R.string.slack);
                builder6.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.SLACK;
                builder6.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_slack;
                return new SocialShareModel(builder6, b);
            case 6:
                SocialShareModel.Builder builder7 = new SocialShareModel.Builder();
                builder7.getAuthRequestContext = context.getString(R.string.dingtalk);
                builder7.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.DINGTALK;
                builder7.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_dingtalk;
                return new SocialShareModel(builder7, b);
            case 7:
                SocialShareModel.Builder builder8 = new SocialShareModel.Builder();
                builder8.getAuthRequestContext = context.getString(R.string.facebook);
                builder8.KClassImpl$Data$declaredNonStaticMembers$2 = AppPackageName.FACEBOOK;
                builder8.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_facebook;
                return new SocialShareModel(builder8, b);
            case '\b':
                SocialShareModel.Builder builder9 = new SocialShareModel.Builder();
                builder9.getAuthRequestContext = context.getString(R.string.whatsapp);
                builder9.KClassImpl$Data$declaredNonStaticMembers$2 = "com.whatsapp";
                builder9.PlaceComponentResult = context.getString(R.string.btnShareWa);
                builder9.BuiltInFictitiousFunctionClassFactory = R.drawable.ic_social_whatsapp;
                return new SocialShareModel(builder9, b);
            default:
                return null;
        }
    }
}
