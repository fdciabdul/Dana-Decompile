package id.dana.cardbinding.domain.interactor;

import android.text.TextUtils;
import id.dana.cardbinding.domain.CardBindingRepository;
import id.dana.cardbinding.domain.model.BankCardInfo;
import id.dana.domain.core.usecase.BaseFlowUseCase;
import id.dana.domain.util.DateTimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\t\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage;", "Lid/dana/domain/core/usecase/BaseFlowUseCase;", "Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage$Params;", "Lid/dana/cardbinding/domain/model/BankCardInfo;", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Z", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/cardbinding/domain/CardBindingRepository;", "MyBillsEntityDataFactory", "Lid/dana/cardbinding/domain/CardBindingRepository;", "<init>", "(Lid/dana/cardbinding/domain/CardBindingRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GetCardInfoFromImage extends BaseFlowUseCase<Params, BankCardInfo> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final CardBindingRepository PlaceComponentResult;

    @Override // id.dana.domain.core.usecase.BaseFlowUseCase
    public final /* synthetic */ Flow<BankCardInfo> buildUseCase(Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        return FlowKt.flow(new GetCardInfoFromImage$buildUseCase$1(this, null));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, kotlinx.coroutines.CoroutineDispatcher] */
    @javax.inject.Inject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GetCardInfoFromImage(id.dana.cardbinding.domain.CardBindingRepository r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            r2.PlaceComponentResult = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cardbinding.domain.interactor.GetCardInfoFromImage.<init>(id.dana.cardbinding.domain.CardBindingRepository):void");
    }

    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        int length = p0.length();
        return 15 <= length && length < 20;
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(String p0) {
        int i = 0;
        boolean z = false;
        for (int length = p0.length() - 1; length >= 0; length--) {
            int charAt = p0.charAt(length) - '0';
            if (charAt >= 0 && charAt <= 9) {
                if (z && (charAt = charAt * 2) > 9) {
                    charAt -= 9;
                }
                i += charAt;
                z = !z;
            }
        }
        return i % 10 == 0;
    }

    private static boolean PlaceComponentResult(String p0) {
        if (p0.length() > 0) {
            DateTimeUtils dateTimeUtils = DateTimeUtils.INSTANCE;
            DateTimeUtils dateTimeUtils2 = DateTimeUtils.INSTANCE;
            StringBuilder sb = new StringBuilder();
            sb.append("01/");
            sb.append(p0);
            String obj = sb.toString();
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "");
            return !dateTimeUtils.isPastToday(dateTimeUtils2.getDateTimeInMillis(obj, "dd/MM/yy", locale));
        }
        return false;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage$Params;", "", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Params {

        /* renamed from: Companion  reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public /* synthetic */ Params(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage$Params$Companion;", "", "Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage$Params;", "PlaceComponentResult", "()Lid/dana/cardbinding/domain/interactor/GetCardInfoFromImage$Params;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            @JvmStatic
            public static Params PlaceComponentResult() {
                return new Params(null);
            }
        }

        private Params() {
        }
    }

    public static final /* synthetic */ BankCardInfo getAuthRequestContext(List list) {
        Object obj;
        Object obj2;
        List list2 = list;
        Iterator it = list2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            String str = (String) obj2;
            if (TextUtils.isDigitsOnly(new Regex("[\\s-]+").replace(str, "")) && KClassImpl$Data$declaredNonStaticMembers$2(str)) {
                break;
            }
        }
        String str2 = (String) obj2;
        if (str2 == null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj3 : list2) {
                String str3 = (String) obj3;
                if (TextUtils.isDigitsOnly(str3) && str3.length() == 4) {
                    arrayList.add(obj3);
                }
            }
            str2 = "";
            for (String str4 : CollectionsKt.take(arrayList, 4)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str4);
                str2 = sb.toString();
            }
            if (!KClassImpl$Data$declaredNonStaticMembers$2(str2)) {
                str2 = null;
            }
        }
        if (str2 != null) {
            Iterator it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                if (new Regex("^\\d{2}/\\d{2}$").matches((String) next)) {
                    obj = next;
                    break;
                }
            }
            String str5 = (String) obj;
            return new BankCardInfo(str2, str5 == null ? "" : str5, BuiltInFictitiousFunctionClassFactory(str2), PlaceComponentResult(str5 != null ? str5 : ""));
        }
        return null;
    }
}
