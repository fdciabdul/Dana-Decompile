package id.dana.riskChallenges.ui.util.statemanager;

import id.dana.riskChallenges.constant.RiskChallengeKey;
import id.dana.riskChallenges.ui.resetpin.model.VerificationMethodModel;
import id.dana.riskChallenges.ui.util.model.BasicRiskChallengesModel;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J1\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000b\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0004\b\u000b\u0010\rJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u0003\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0005\u0010\u0010R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0015\u001a\u00020\u0017X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016"}, d2 = {"Lid/dana/riskChallenges/ui/util/statemanager/QueueVerificationMethods;", "", "Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/riskChallenges/ui/util/model/BasicRiskChallengesModel;)V", "", "Lkotlin/Function0;", "p1", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "", "getAuthRequestContext", "()Ljava/lang/String;", "", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/util/List;", "Ljava/util/LinkedList;", "PlaceComponentResult", "Ljava/util/LinkedList;", "Lkotlin/text/Regex;", "Lkotlin/Lazy;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QueueVerificationMethods {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult = LazyKt.lazy(new Function0<Regex>() { // from class: id.dana.riskChallenges.ui.util.statemanager.QueueVerificationMethods$regex$2
        @Override // kotlin.jvm.functions.Function0
        public final Regex invoke() {
            return new Regex("[^A-Za-z0-9]");
        }
    });

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final LinkedList<String> KClassImpl$Data$declaredNonStaticMembers$2 = new LinkedList<>();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final LinkedList<String> getAuthRequestContext = new LinkedList<>();

    public final void BuiltInFictitiousFunctionClassFactory(BasicRiskChallengesModel p0) {
        List<VerificationMethodModel> authRequestContext;
        List sortedWith = (p0 == null || (authRequestContext = p0.getAuthRequestContext()) == null) ? null : CollectionsKt.sortedWith(authRequestContext, new Comparator() { // from class: id.dana.riskChallenges.ui.util.statemanager.QueueVerificationMethods$createQueue$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((VerificationMethodModel) t2).getPriority()), Integer.valueOf(((VerificationMethodModel) t).getPriority()));
            }
        });
        if (sortedWith != null) {
            Iterator it = sortedWith.iterator();
            while (it.hasNext()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.add(((VerificationMethodModel) it.next()).getVerificationMethodCode());
            }
        }
    }

    public final String getAuthRequestContext() {
        List<String> MyBillsEntityDataFactory;
        String str;
        String str2 = (String) CollectionsKt.firstOrNull((List) this.KClassImpl$Data$declaredNonStaticMembers$2);
        if (str2 != null && (MyBillsEntityDataFactory = MyBillsEntityDataFactory(str2)) != null && (str = (String) CollectionsKt.firstOrNull((List) MyBillsEntityDataFactory)) != null) {
            String replace = ((Regex) this.PlaceComponentResult.getValue()).replace(str, "");
            if (replace != null) {
                String upperCase = replace.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "");
                return upperCase;
            }
        }
        return null;
    }

    public final String BuiltInFictitiousFunctionClassFactory() {
        if (this.getAuthRequestContext.isEmpty()) {
            String pollFirst = this.KClassImpl$Data$declaredNonStaticMembers$2.pollFirst();
            List<String> MyBillsEntityDataFactory = pollFirst != null ? MyBillsEntityDataFactory(pollFirst) : null;
            if (MyBillsEntityDataFactory == null) {
                MyBillsEntityDataFactory = CollectionsKt.emptyList();
            }
            this.getAuthRequestContext.addAll(MyBillsEntityDataFactory);
        }
        String pollFirst2 = this.getAuthRequestContext.pollFirst();
        if (pollFirst2 != null) {
            String upperCase = ((Regex) this.PlaceComponentResult.getValue()).replace(pollFirst2, "").toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "");
            return upperCase;
        }
        return null;
    }

    private final List<String> MyBillsEntityDataFactory(String p0) {
        String str = p0;
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "+", false, 2, (Object) null)) {
            return StringsKt.split$default((CharSequence) str, new String[]{"+"}, false, 0, 6, (Object) null);
        }
        String replace = ((Regex) this.PlaceComponentResult.getValue()).replace(str, "");
        RiskChallengeKey.Companion companion = RiskChallengeKey.INSTANCE;
        for (String str2 : RiskChallengeKey.Companion.BuiltInFictitiousFunctionClassFactory()) {
            if (StringsKt.startsWith(replace, str2, true)) {
                String substring = replace.substring(str2.length());
                Intrinsics.checkNotNullExpressionValue(substring, "");
                if ((!StringsKt.isBlank(substring)) != false) {
                    return CollectionsKt.listOf((Object[]) new String[]{str2, substring});
                }
                return CollectionsKt.listOf(str2);
            }
        }
        return CollectionsKt.listOf(replace);
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Function0<Unit> p0, Function0<Unit> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if ((!this.getAuthRequestContext.isEmpty()) != false) {
            p0.invoke();
        } else {
            p1.invoke();
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0, Function0<Unit> p1, Function0<Unit> p2) {
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        if (p0) {
            if ((!this.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) == false) {
                p2.invoke();
                return;
            }
            this.getAuthRequestContext.clear();
            p1.invoke();
            return;
        }
        p2.invoke();
    }
}
