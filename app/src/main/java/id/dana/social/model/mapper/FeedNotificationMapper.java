package id.dana.social.model.mapper;

import android.content.Context;
import id.dana.R;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.domain.social.ExtendInfoUtilKt;
import id.dana.social.model.FeedModel;
import id.dana.utils.DateTimeUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u001c\u0012\u0006\u0010\t\u001a\u00020\u0019¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0005\u0010\u000bJC\u0010\u0010\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000ej\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000f0\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\u0012J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0013J1\u0010\u0005\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0018R\u0014\u0010\u0010\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u0012\u0010 \u001a\u00020\nX\u0086\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f"}, d2 = {"Lid/dana/social/model/mapper/FeedNotificationMapper;", "", "Ljava/util/Date;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Ljava/util/Date;)Z", "", "", "p1", "", "(ILjava/lang/Long;)Ljava/lang/String;", "", "Lid/dana/social/model/FeedModel;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/List;)Ljava/util/List;", "(I)Ljava/lang/String;", "(Ljava/util/Date;Ljava/util/Date;)Z", "", "Lid/dana/social/model/FeedViewHolderModel;", "p2", "", "(Ljava/util/List;ILjava/util/Date;Ljava/util/Date;)V", "Landroid/content/Context;", "MyBillsEntityDataFactory", "Landroid/content/Context;", "Lid/dana/social/model/mapper/FeedModelMapper;", "Lid/dana/social/model/mapper/FeedModelMapper;", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "<init>", "(Lid/dana/social/model/mapper/FeedModelMapper;Landroid/content/Context;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedNotificationMapper {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final FeedModelMapper BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public String PlaceComponentResult;

    @Inject
    public FeedNotificationMapper(FeedModelMapper feedModelMapper, Context context) {
        Intrinsics.checkNotNullParameter(feedModelMapper, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = feedModelMapper;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
        this.PlaceComponentResult = "";
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: id.dana.utils.DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(long):java.lang.String
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:74)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:49)
        Caused by: java.lang.IndexOutOfBoundsException: Index: 0
        	at java.base/java.util.Collections$EmptyList.get(Unknown Source)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:104)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:117)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:63)
        	... 1 more
        */
    public final void BuiltInFictitiousFunctionClassFactory(java.util.List<id.dana.social.model.FeedViewHolderModel> r10, int r11, java.util.Date r12, java.util.Date r13) {
        /*
            r9 = this;
            r0 = 0
            if (r11 < 0) goto L7
            r1 = 2
            if (r11 >= r1) goto L7
            r0 = 1
        L7:
            if (r0 == 0) goto L30
            java.lang.String r11 = r9.BuiltInFictitiousFunctionClassFactory(r11)
            java.lang.String r12 = r9.PlaceComponentResult
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r11)
            if (r12 != 0) goto L90
            r9.PlaceComponentResult = r11
            id.dana.social.model.FeedModel$Companion r12 = id.dana.social.model.FeedModel.INSTANCE
            id.dana.social.model.FeedModel r2 = id.dana.social.model.FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r11)
            id.dana.social.model.FeedViewHolderModel r11 = new id.dana.social.model.FeedViewHolderModel
            r1 = 16
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 60
            r8 = 0
            r0 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.add(r11)
            return
        L30:
            long r0 = r13.getTime()
            java.lang.String r11 = id.dana.utils.DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            boolean r0 = BuiltInFictitiousFunctionClassFactory(r13)
            if (r0 == 0) goto L56
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            r11 = 32
            r0.append(r11)
            java.lang.String r11 = id.dana.utils.DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(r13)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
        L56:
            java.lang.String r0 = r9.PlaceComponentResult
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r11)
            if (r0 == 0) goto L5f
            return
        L5f:
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            r9.PlaceComponentResult = r11
            boolean r12 = BuiltInFictitiousFunctionClassFactory(r12, r13)
            if (r12 == 0) goto L75
            android.content.Context r11 = r9.KClassImpl$Data$declaredNonStaticMembers$2
            r12 = 2131957390(0x7f13168e, float:1.9551363E38)
            java.lang.String r11 = r11.getString(r12)
        L75:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r0)
            id.dana.social.model.FeedModel$Companion r12 = id.dana.social.model.FeedModel.INSTANCE
            id.dana.social.model.FeedModel r2 = id.dana.social.model.FeedModel.Companion.KClassImpl$Data$declaredNonStaticMembers$2(r11)
            id.dana.social.model.FeedViewHolderModel r11 = new id.dana.social.model.FeedViewHolderModel
            r1 = 16
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 60
            r8 = 0
            r0 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.add(r11)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.social.model.mapper.FeedNotificationMapper.BuiltInFictitiousFunctionClassFactory(java.util.List, int, java.util.Date, java.util.Date):void");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Date p0, Date p1) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(p1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(p0);
        return calendar2.get(2) == calendar.get(2) && calendar2.get(1) == calendar.get(1);
    }

    public final String BuiltInFictitiousFunctionClassFactory(int p0, Long p1) {
        Date date = new Date(p1 != null ? p1.longValue() : 0L);
        String authRequestContext = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(p0, date, "dd MMMM", new Function2<String, Date, String>() { // from class: id.dana.social.model.mapper.FeedNotificationMapper$getFormattedFeedNotificationDate$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, Date date2) {
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(date2, "");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(DateTimeUtil.KClassImpl$Data$declaredNonStaticMembers$2(date2));
                return sb.toString();
            }
        });
        StringBuilder sb = new StringBuilder();
        sb.append(authRequestContext);
        sb.append(", ");
        sb.append(DateTimeUtil.BuiltInFictitiousFunctionClassFactory(date));
        return sb.toString();
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(Date p0) {
        return DateTimeUtil.lookAheadTest(p0) < Calendar.getInstance().get(1);
    }

    private final String BuiltInFictitiousFunctionClassFactory(int p0) {
        String string;
        if (p0 == 0) {
            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.feed_section_today);
            Intrinsics.checkNotNullExpressionValue(string, "");
        } else if (p0 != 1) {
            return "";
        } else {
            string = this.KClassImpl$Data$declaredNonStaticMembers$2.getString(R.string.feed_section_yesterday);
            Intrinsics.checkNotNullExpressionValue(string, "");
        }
        return string;
    }

    public static List<HashMap<String, String>> KClassImpl$Data$declaredNonStaticMembers$2(List<FeedModel> p0) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = p0.iterator();
        while (it.hasNext()) {
            HashMap<String, String> hashMap = ((FeedModel) it.next()).lookAheadTest;
            if (hashMap != null) {
                linkedHashMap.put(ExtendInfoUtilKt.getUserId(hashMap), hashMap);
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        ArrayList arrayList = new ArrayList(linkedHashMap2.size());
        Iterator it2 = linkedHashMap2.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList.add((HashMap) ((Map.Entry) it2.next()).getValue());
        }
        return arrayList;
    }
}
