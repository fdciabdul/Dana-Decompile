package id.dana.social.utils;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.widget.TextView;
import com.alibaba.griver.base.resource.cache.CacheTypeDef;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.danah5.constant.BridgeName;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.social.adapter.SocialFeedClickListener;
import id.dana.social.model.FeedModel;
import id.dana.social.model.FeedViewHolderModel;
import id.dana.social.model.GroupedFeedModel;
import id.dana.social.utils.RegexUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0013J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\nJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u001aJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eJ\u0012\u0010\u001f\u001a\u00020\u0004*\u00020\u00042\u0006\u0010 \u001a\u00020\u0004J\u0012\u0010!\u001a\u00020\u001c*\u00020\"2\u0006\u0010#\u001a\u00020\u0004J\u001a\u0010$\u001a\u00020\u000e*\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lid/dana/social/utils/FeedsContentUtils;", "", "()V", CacheTypeDef.CACHE_TYPE_STRING, "", "getAndPredicate", HummerConstants.CONTEXT, "Landroid/content/Context;", "getDisplayName", "data", "Lid/dana/social/model/FeedViewHolderModel;", "getFeedDescription", "Landroid/text/Spannable;", "feedRegexData", "Lid/dana/social/utils/FeedRegexData;", "actorTextBold", "", "clickableContent", "getGroupedFeedAvatar", "", "listOfActivity", "Lid/dana/social/model/FeedModel;", "getOtherPredicate", "getSingleFeedAvatar", "feedViewHolderModel", BridgeName.GET_USERNAME, "Lid/dana/feeds/ui/model/MyFeedHeaderModel;", "setGroupedFeedNicknameAndDisplayName", "", "groupedFeedModel", "Lid/dana/social/model/GroupedFeedModel;", "addSuffix", "suffix", "setTextAndVisibility", "Landroid/widget/TextView;", "text", "toFeedRegexData", "socialFeedListener", "Lid/dana/social/adapter/SocialFeedClickListener;", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsContentUtils {
    public static final FeedsContentUtils MyBillsEntityDataFactory = new FeedsContentUtils();

    private FeedsContentUtils() {
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "");
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = str;
        if (str2.length() == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str2);
    }

    public static List<String> KClassImpl$Data$declaredNonStaticMembers$2(List<FeedModel> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<FeedModel> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            HashMap<String, String> hashMap = ((FeedModel) it.next()).lookAheadTest;
            String profileAvatar = hashMap != null ? ExtendInfoUtilKt.getProfileAvatar(hashMap) : null;
            if (profileAvatar == null) {
                profileAvatar = "";
            }
            arrayList.add(profileAvatar);
        }
        return CollectionsKt.distinct(arrayList);
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String getAuthRequestContext(FeedViewHolderModel feedViewHolderModel) {
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(feedViewHolderModel, "");
        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
        String headerName = (feedModel == null || (hashMap = feedModel.lookAheadTest) == null) ? null : ExtendInfoUtilKt.getHeaderName(hashMap);
        String str = headerName;
        if ((!(str == null || str.length() == 0)) == false) {
            headerName = null;
        }
        if (headerName == null) {
            FeedModel feedModel2 = feedViewHolderModel.MyBillsEntityDataFactory;
            if (feedModel2 != null) {
                HashMap<String, String> hashMap2 = feedModel2.lookAheadTest;
                r2 = hashMap2 != null ? ExtendInfoUtilKt.getNickName(hashMap2) : null;
                if (r2 == null) {
                    r2 = "";
                }
            }
            return r2 == null ? "" : r2;
        }
        return headerName;
    }

    public static Spannable PlaceComponentResult(FeedRegexData feedRegexData, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(feedRegexData, "");
        if ((!feedRegexData.PlaceComponentResult.isEmpty()) != false) {
            RegexUtils.Companion companion = RegexUtils.INSTANCE;
            return RegexUtils.Companion.PlaceComponentResult(feedRegexData, Integer.valueOf((int) R.font.f34282131296266), z, z2);
        }
        return new SpannableString(feedRegexData.getErrorConfigVersion);
    }

    public static String BuiltInFictitiousFunctionClassFactory(FeedViewHolderModel feedViewHolderModel) {
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(feedViewHolderModel, "");
        String str = null;
        if (feedViewHolderModel.getErrorConfigVersion != 9 && feedViewHolderModel.getErrorConfigVersion != 15) {
            FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
            if (feedModel != null) {
                str = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda2;
            }
        } else {
            FeedModel feedModel2 = feedViewHolderModel.MyBillsEntityDataFactory;
            if (feedModel2 != null && (hashMap = feedModel2.lookAheadTest) != null) {
                str = ExtendInfoUtilKt.getProfileAvatar(hashMap);
            }
        }
        return str == null ? "" : str;
    }

    public static String PlaceComponentResult(FeedViewHolderModel feedViewHolderModel) {
        HashMap<String, String> hashMap;
        Intrinsics.checkNotNullParameter(feedViewHolderModel, "");
        FeedModel feedModel = feedViewHolderModel.MyBillsEntityDataFactory;
        String username = (feedModel == null || (hashMap = feedModel.lookAheadTest) == null) ? null : ExtendInfoUtilKt.getUsername(hashMap);
        if (username == null) {
            username = "";
        }
        if (username.length() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append(username);
            return sb.toString();
        }
        return "";
    }

    public static void MyBillsEntityDataFactory(Context context, GroupedFeedModel groupedFeedModel) {
        String nickName;
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(groupedFeedModel, "");
        List<? extends HashMap<String, String>> list = groupedFeedModel.getErrorConfigVersion;
        if (list.size() > 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExtendInfoUtilKt.getNickName(list.get(0)));
            sb.append(", ");
            sb.append(ExtendInfoUtilKt.getNickName(list.get(1)));
            sb.append(InputCardNumberView.DIVIDER);
            String string = context.getString(R.string.and_predicate);
            Intrinsics.checkNotNullExpressionValue(string, "");
            sb.append(string);
            sb.append(InputCardNumberView.DIVIDER);
            String string2 = context.getString(R.string.other_predicate);
            Intrinsics.checkNotNullExpressionValue(string2, "");
            sb.append(string2);
            nickName = sb.toString();
        } else if (list.size() > 2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ExtendInfoUtilKt.getNickName(list.get(0)));
            sb2.append(", ");
            sb2.append(ExtendInfoUtilKt.getNickName(list.get(1)));
            sb2.append(InputCardNumberView.DIVIDER);
            String string3 = context.getString(R.string.and_predicate);
            Intrinsics.checkNotNullExpressionValue(string3, "");
            sb2.append(string3);
            sb2.append(InputCardNumberView.DIVIDER);
            sb2.append(ExtendInfoUtilKt.getNickName(list.get(2)));
            nickName = sb2.toString();
        } else if (list.size() > 1) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(ExtendInfoUtilKt.getNickName(list.get(0)));
            sb3.append(InputCardNumberView.DIVIDER);
            String string4 = context.getString(R.string.and_predicate);
            Intrinsics.checkNotNullExpressionValue(string4, "");
            sb3.append(string4);
            sb3.append(InputCardNumberView.DIVIDER);
            sb3.append(ExtendInfoUtilKt.getNickName(list.get(1)));
            nickName = sb3.toString();
        } else {
            nickName = ExtendInfoUtilKt.getNickName(list.get(0));
        }
        ExtendInfoUtilKt.setActorNickname(groupedFeedModel.PlaceComponentResult, nickName);
        ExtendInfoUtilKt.setDisplayName(groupedFeedModel.PlaceComponentResult, nickName);
    }

    public static FeedRegexData PlaceComponentResult(FeedModel feedModel, Context context, SocialFeedClickListener socialFeedClickListener) {
        Intrinsics.checkNotNullParameter(feedModel, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(socialFeedClickListener, "");
        String str = feedModel.NetworkUserEntityData$$ExternalSyntheticLambda1;
        String str2 = feedModel.scheduleImpl;
        String str3 = str2 == null ? "" : str2;
        HashMap<String, String> hashMap = feedModel.lookAheadTest;
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        HashMap<String, String> hashMap2 = hashMap;
        FeedsContentUtils$toFeedRegexData$1 feedsContentUtils$toFeedRegexData$1 = new FeedsContentUtils$toFeedRegexData$1(socialFeedClickListener);
        String str4 = feedModel.PlaceComponentResult;
        return new FeedRegexData(str, str3, hashMap2, feedsContentUtils$toFeedRegexData$1, context, str4 == null ? "" : str4);
    }
}
