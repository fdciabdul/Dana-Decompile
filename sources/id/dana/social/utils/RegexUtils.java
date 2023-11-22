package id.dana.social.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.gson.Gson;
import id.dana.R;
import id.dana.danah5.share.ShareToFeedBridge;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.social.utils.RegexUtils;
import id.dana.utils.deeplink.DeepLinkConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/social/utils/RegexUtils;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegexUtils {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u00162&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J.\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00172\f\u0010)\u001a\b\u0012\u0004\u0012\u00020#0*2\u0006\u0010+\u001a\u00020%H\u0002J1\u0010,\u001a\u00020-2\u0006\u0010+\u001a\u00020%2\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0002\u00101J&\u00102\u001a\u00020\u00042\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J8\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001aH\u0002J\b\u00105\u001a\u00020\u0004H\u0002J\u0018\u00106\u001a\u00020\u00132\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0013H\u0002J$\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\u0014\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040<J3\u0010=\u001a\u00020-2\u0006\u0010$\u001a\u00020%2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/¢\u0006\u0002\u00101J8\u0010>\u001a\u00020/2\u0006\u00104\u001a\u00020\u00042&\u0010\u0018\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0019j\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\u001aH\u0002J\b\u0010?\u001a\u00020/H\u0002J\u0012\u0010@\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u0002J\u001e\u0010B\u001a\u00020/2\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0019H\u0002J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010+\u001a\u00020%H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lid/dana/social/utils/RegexUtils$Companion;", "", "()V", "CONTENT_ACTOR", "", "CONTENT_ACTOR_REDIRECT_KEY", "CONTENT_LUCKY_MONEY", "CONTENT_REDIRECT_TYPE_KEY", "CONTENT_REDIRECT_VALUE_KEY", "DISPLAY_NAME", "DISPLAY_NAME_EN", "DISPLAY_NAME_ID", "GENERIC_PATTERN", "LUCKY_MONEY_DEFAULT", "LUCKY_MONEY_REPLACE_URL", "NICKNAME_NAME", "REGEX_ACTOR_MERCHANT", "REGEX_JSON", "REGEX_START_INDEX", "", "REGEX_STRING_ONLY", "appendPatternWithDisplayName", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "extendInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", HummerConstants.CONTEXT, "Landroid/content/Context;", "changeFontType", "Landroid/text/style/MetricAffectingSpan;", "fontType", "createClickableSpan", "Landroid/text/style/ClickableSpan;", "content", "Lid/dana/social/utils/Content;", "feedRegexData", "Lid/dana/social/utils/FeedRegexData;", "doRegex", "fullText", "result", "contents", "", "feedModel", "findMatch", "Landroid/text/Spannable;", "actorTextBold", "", "clickableContent", "(Lid/dana/social/utils/FeedRegexData;Ljava/lang/Integer;ZZ)Landroid/text/Spannable;", "getActorContentForReplace", "getDisplayName", "key", "getDisplayNameLocaleAdjusted", "getMaxRange", "firstIndex", "valueLen", "getRedirectValue", "type", "map", "", "getReplacedFeedText", "isContentContainsLocale", "isCurrentLocaleIndo", "isJson", "text", "isLuckyMoneyInMyFeed", "processText", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Spannable PlaceComponentResult(FeedRegexData feedRegexData, Integer num, boolean z, boolean z2, int i) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                z2 = true;
            }
            return PlaceComponentResult(feedRegexData, num, z, z2);
        }

        private static boolean BuiltInFictitiousFunctionClassFactory(String str, HashMap<String, String> hashMap) {
            if (ExtendInfoUtilKt.getDisplayNameEn(hashMap, str).length() > 0) {
                return ExtendInfoUtilKt.getDisplayNameId(hashMap, str).length() > 0;
            }
            return false;
        }

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2(HashMap<String, String> hashMap) {
            return hashMap.get(ExtendInfoUtilKt.ACTOR_KEY) == null;
        }

        private static boolean KClassImpl$Data$declaredNonStaticMembers$2() {
            String obj = Locale.getDefault().toString();
            Intrinsics.checkNotNullExpressionValue(obj, "");
            return StringsKt.endsWith$default(obj, "ID", false, 2, (Object) null);
        }

        private static boolean MyBillsEntityDataFactory(Object obj) {
            if (obj == null || !(obj instanceof String)) {
                return false;
            }
            CharSequence charSequence = (CharSequence) obj;
            return !TextUtils.isEmpty(charSequence) && SequencesKt.count(new Regex("(?:\"\\w{1,}\":)((\"(.*?)(?:\"))|\\d{1,})").findAll(charSequence, 0)) > 0;
        }

        public static final /* synthetic */ String BuiltInFictitiousFunctionClassFactory(HashMap hashMap, Context context) {
            if (!KClassImpl$Data$declaredNonStaticMembers$2(hashMap)) {
                return ExtendInfoUtilKt.getDisplayName(hashMap).length() > 0 ? "%actor.displayName%" : "%actor.nickname%";
            }
            String string = context.getString(R.string.lookAheadTest);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }

        public static final /* synthetic */ String getAuthRequestContext(String str, HashMap hashMap) {
            return BuiltInFictitiousFunctionClassFactory(str, hashMap) ? KClassImpl$Data$declaredNonStaticMembers$2() ? ExtendInfoUtilKt.DISPLAY_NAME_ID_KEY : ExtendInfoUtilKt.DISPLAY_NAME_EN_KEY : ExtendInfoUtilKt.DISPLAY_NAME_KEY;
        }

        private static Spannable getAuthRequestContext(final FeedRegexData feedRegexData, Integer num, boolean z, boolean z2) {
            String str;
            String str2;
            String str3;
            String str4 = feedRegexData.getErrorConfigVersion;
            Regex regex = new Regex("%\\S.*?%");
            Companion companion = RegexUtils.INSTANCE;
            final HashMap<String, String> hashMap = feedRegexData.PlaceComponentResult;
            final Context context = feedRegexData.KClassImpl$Data$declaredNonStaticMembers$2;
            String replace = regex.replace(str4, new Function1<MatchResult, String>() { // from class: id.dana.social.utils.RegexUtils$Companion$appendPatternWithDisplayName$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(MatchResult matchResult) {
                    Intrinsics.checkNotNullParameter(matchResult, "");
                    String replace$default = StringsKt.replace$default(matchResult.getValue(), "%", "", false, 4, (Object) null);
                    if (Intrinsics.areEqual(replace$default, ExtendInfoUtilKt.ACTOR_KEY)) {
                        RegexUtils.Companion companion2 = RegexUtils.INSTANCE;
                        return RegexUtils.Companion.BuiltInFictitiousFunctionClassFactory(hashMap, context);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(StringsKt.removeSuffix(matchResult.getValue(), (CharSequence) "%"));
                    sb.append('.');
                    RegexUtils.Companion companion3 = RegexUtils.INSTANCE;
                    sb.append(RegexUtils.Companion.getAuthRequestContext(replace$default, hashMap));
                    sb.append('%');
                    return sb.toString();
                }
            });
            String str5 = replace;
            int i = 0;
            Sequence<MatchResult> findAll = new Regex("%{1}\\w{1,}\\.\\w{1,}%{1}").findAll(str5, 0);
            if (SequencesKt.count(findAll) <= 0) {
                Spannable newSpannable = Spannable.Factory.getInstance().newSpannable(str5);
                Intrinsics.checkNotNullExpressionValue(newSpannable, "");
                return newSpannable;
            }
            ArrayList<Content> arrayList = new ArrayList();
            Iterator<MatchResult> it = findAll.iterator();
            while (it.hasNext()) {
                MatchResult find = new Regex(it.next().getValue()).find(replace, i);
                if (find != null) {
                    Companion companion2 = RegexUtils.INSTANCE;
                    HashMap<String, String> hashMap2 = feedRegexData.PlaceComponentResult;
                    String value = find.getValue();
                    int first = find.getRange().getFirst();
                    String str6 = ExtendInfoUtilKt.ACTOR_KEY;
                    int i2 = 0;
                    for (MatchResult matchResult : new Regex("\\w{1,}").findAll(value, i)) {
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        MatchResult matchResult2 = matchResult;
                        if (i2 == 0) {
                            str6 = matchResult2.getValue();
                        }
                        String str7 = hashMap2.get(matchResult2.getValue());
                        if (str7 == null) {
                            str7 = "";
                        }
                        Companion companion3 = RegexUtils.INSTANCE;
                        if (MyBillsEntityDataFactory(str7)) {
                            Object fromJson = new Gson().fromJson(str7, (Class<Object>) HashMap.class);
                            if (fromJson == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String?>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String?> }");
                            }
                            hashMap2 = (HashMap) fromJson;
                        } else {
                            String replace2 = new Regex(value).replace(replace, str7);
                            String str8 = feedRegexData.MyBillsEntityDataFactory;
                            Companion companion4 = RegexUtils.INSTANCE;
                            HashMap<String, String> hashMap3 = hashMap2;
                            Intrinsics.checkNotNullParameter(str6, "");
                            Intrinsics.checkNotNullParameter(hashMap3, "");
                            if (Intrinsics.areEqual(ExtendInfoUtilKt.ACTOR_KEY, str6)) {
                                str = hashMap3.get("id");
                                str3 = replace2;
                            } else {
                                str = hashMap3.get(ShareToFeedBridge.REDIRECT_VALUE);
                                if (str != null) {
                                    str2 = str.toLowerCase();
                                    Intrinsics.checkNotNullExpressionValue(str2, "");
                                } else {
                                    str2 = null;
                                }
                                str3 = replace2;
                                if (Intrinsics.areEqual(str2, DeepLinkConstant.DeepLinkPath.LUCKY_MONEY)) {
                                    str = "/m/luckymoney?numberOfMember=201&minWinnerSize=2";
                                }
                            }
                            String str9 = str == null ? "" : str;
                            String str10 = hashMap2.get("redirectType");
                            String str11 = str10 == null ? "" : str10;
                            Companion companion5 = RegexUtils.INSTANCE;
                            arrayList.add(new Content(str8, str6, str9, str11, new IntRange(first, str7.length() + first), feedRegexData.getAuthRequestContext));
                            replace = str3;
                        }
                        i2++;
                        i = 0;
                    }
                }
            }
            Spannable newSpannable2 = Spannable.Factory.getInstance().newSpannable(replace);
            for (final Content content : arrayList) {
                boolean z3 = true;
                if (z && Intrinsics.areEqual(content.lookAheadTest, ExtendInfoUtilKt.ACTOR_KEY)) {
                    newSpannable2.setSpan(new StyleSpan(1), content.PlaceComponentResult.getFirst(), content.PlaceComponentResult.getLast(), 33);
                } else if (z2) {
                    String str12 = content.MyBillsEntityDataFactory;
                    if (str12 != null && !StringsKt.isBlank(str12)) {
                        z3 = false;
                    }
                    if (!z3) {
                        Companion companion6 = RegexUtils.INSTANCE;
                        Intrinsics.checkNotNullParameter(content, "");
                        Intrinsics.checkNotNullParameter(feedRegexData, "");
                        newSpannable2.setSpan(new ClickableSpan() { // from class: id.dana.social.utils.RegexUtils$Companion$createClickableSpan$1
                            @Override // android.text.style.ClickableSpan
                            public final void onClick(View p0) {
                                Intrinsics.checkNotNullParameter(p0, "");
                                if (Intrinsics.areEqual(ExtendInfoUtilKt.ACTOR_KEY, Content.this.lookAheadTest)) {
                                    return;
                                }
                                feedRegexData.BuiltInFictitiousFunctionClassFactory.invoke(Content.this);
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public final void updateDrawState(TextPaint p0) {
                                Intrinsics.checkNotNullParameter(p0, "");
                                p0.setUnderlineText(false);
                                if (Intrinsics.areEqual(ExtendInfoUtilKt.ACTOR_KEY, Content.this.lookAheadTest)) {
                                    return;
                                }
                                p0.setColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(feedRegexData.KClassImpl$Data$declaredNonStaticMembers$2, R.color.f25442131100151));
                            }
                        }, content.PlaceComponentResult.getFirst(), content.PlaceComponentResult.getLast(), 33);
                        if (num != null) {
                            final int intValue = num.intValue();
                            Companion companion7 = RegexUtils.INSTANCE;
                            final Context context2 = feedRegexData.KClassImpl$Data$declaredNonStaticMembers$2;
                            Intrinsics.checkNotNullParameter(context2, "");
                            newSpannable2.setSpan(new MetricAffectingSpan() { // from class: id.dana.social.utils.RegexUtils$Companion$changeFontType$1
                                @Override // android.text.style.CharacterStyle
                                public final void updateDrawState(TextPaint p0) {
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    KClassImpl$Data$declaredNonStaticMembers$2(p0);
                                }

                                @Override // android.text.style.MetricAffectingSpan
                                public final void updateMeasureState(TextPaint p0) {
                                    Intrinsics.checkNotNullParameter(p0, "");
                                    KClassImpl$Data$declaredNonStaticMembers$2(p0);
                                }

                                private final void KClassImpl$Data$declaredNonStaticMembers$2(TextPaint p0) {
                                    Typeface PlaceComponentResult = ResourcesCompat.PlaceComponentResult(context2, intValue);
                                    int style = PlaceComponentResult != null ? PlaceComponentResult.getStyle() : 0;
                                    if (style != 0) {
                                        p0.setTypeface(InstrumentInjector.typefaceCreateDerived(PlaceComponentResult, style));
                                    }
                                }
                            }, content.PlaceComponentResult.getFirst(), content.PlaceComponentResult.getLast(), 33);
                        }
                    }
                }
            }
            Intrinsics.checkNotNullExpressionValue(newSpannable2, "");
            return newSpannable2;
        }

        public static Spannable PlaceComponentResult(FeedRegexData feedRegexData, Integer num, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(feedRegexData, "");
            if (feedRegexData.getErrorConfigVersion.length() > 0) {
                Companion companion = RegexUtils.INSTANCE;
                return getAuthRequestContext(feedRegexData, num, z, z2);
            }
            return new SpannableString("");
        }
    }
}
