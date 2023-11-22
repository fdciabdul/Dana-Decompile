package id.dana.domain.sendmoney.interactor;

import id.dana.domain.core.usecase.BaseUseCase;
import id.dana.domain.sendmoney.interactor.GetEWalletPrefixByBankName;
import id.dana.domain.sendmoney.model.DigitalMoney;
import id.dana.domain.sendmoney.repository.SendMoneyRepository;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001d\u001eB\u0011\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J+\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ\u001b\u0010\u0016\u001a\u00020\u0010*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lid/dana/domain/sendmoney/interactor/GetEWalletPrefixByBankName;", "Lid/dana/domain/core/usecase/BaseUseCase;", "Lid/dana/domain/sendmoney/model/DigitalMoney;", "Lid/dana/domain/sendmoney/interactor/GetEWalletPrefixByBankName$Params;", "params", "Lio/reactivex/Observable;", "buildUseCase", "(Lid/dana/domain/sendmoney/interactor/GetEWalletPrefixByBankName$Params;)Lio/reactivex/Observable;", "", "eWallets", "filterBankName", "(Ljava/util/List;Lid/dana/domain/sendmoney/interactor/GetEWalletPrefixByBankName$Params;)Ljava/util/List;", "Lkotlin/Function1;", "", "filterPrefix", "(Lid/dana/domain/sendmoney/interactor/GetEWalletPrefixByBankName$Params;)Lkotlin/jvm/functions/Function1;", "", "prefix", "", "getPrefixLength", "(Ljava/lang/String;)I", "mapEWallet", "substringPrefix", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "sendMoneyRepository", "Lid/dana/domain/sendmoney/repository/SendMoneyRepository;", "<init>", "(Lid/dana/domain/sendmoney/repository/SendMoneyRepository;)V", "Companion", "Params"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class GetEWalletPrefixByBankName extends BaseUseCase<DigitalMoney, Params> {
    private static final String MANUAL_INPUT = "Manual Input";
    private final SendMoneyRepository sendMoneyRepository;

    @Inject
    public GetEWalletPrefixByBankName(SendMoneyRepository sendMoneyRepository) {
        Intrinsics.checkNotNullParameter(sendMoneyRepository, "");
        this.sendMoneyRepository = sendMoneyRepository;
    }

    @Override // id.dana.domain.core.usecase.BaseUseCase
    public final Observable<DigitalMoney> buildUseCase(final Params params) {
        Intrinsics.checkNotNullParameter(params, "");
        Observable map = this.sendMoneyRepository.getEWalletsBankAccountPrefix().map(new Function() { // from class: id.dana.domain.sendmoney.interactor.GetEWalletPrefixByBankName$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                DigitalMoney m2492buildUseCase$lambda0;
                m2492buildUseCase$lambda0 = GetEWalletPrefixByBankName.m2492buildUseCase$lambda0(GetEWalletPrefixByBankName.this, params, (List) obj);
                return m2492buildUseCase$lambda0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* renamed from: buildUseCase$lambda-0  reason: not valid java name */
    public static final DigitalMoney m2492buildUseCase$lambda0(GetEWalletPrefixByBankName getEWalletPrefixByBankName, Params params, List list) {
        Intrinsics.checkNotNullParameter(getEWalletPrefixByBankName, "");
        Intrinsics.checkNotNullParameter(params, "");
        Intrinsics.checkNotNullParameter(list, "");
        List<DigitalMoney> filterBankName = getEWalletPrefixByBankName.filterBankName(list, params);
        Function1<DigitalMoney, Boolean> filterPrefix = getEWalletPrefixByBankName.filterPrefix(params);
        ArrayList arrayList = new ArrayList();
        for (?? r2 : filterBankName) {
            if (filterPrefix.invoke(r2).booleanValue()) {
                arrayList.add(r2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Function1<DigitalMoney, DigitalMoney> mapEWallet = getEWalletPrefixByBankName.mapEWallet(params);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(mapEWallet.invoke(it.next()));
        }
        return (DigitalMoney) CollectionsKt.firstOrNull((List) arrayList3);
    }

    private final Function1<DigitalMoney, DigitalMoney> mapEWallet(final Params params) {
        return new Function1<DigitalMoney, DigitalMoney>() { // from class: id.dana.domain.sendmoney.interactor.GetEWalletPrefixByBankName$mapEWallet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DigitalMoney invoke(DigitalMoney digitalMoney) {
                int prefixLength;
                Intrinsics.checkNotNullParameter(digitalMoney, "");
                String bankNumber = GetEWalletPrefixByBankName.Params.this.getBankNumber();
                prefixLength = this.getPrefixLength(digitalMoney.getEWalletPrefix());
                String substring = bankNumber.substring(prefixLength);
                Intrinsics.checkNotNullExpressionValue(substring, "");
                return new DigitalMoney(digitalMoney.getInstId(), digitalMoney.getEWalletPrefix(), digitalMoney.getBankName(), digitalMoney.getEWalletName(), digitalMoney.getIdentifier(), substring, false, 64, null);
            }
        };
    }

    private final Function1<DigitalMoney, Boolean> filterPrefix(final Params params) {
        return new Function1<DigitalMoney, Boolean>() { // from class: id.dana.domain.sendmoney.interactor.GetEWalletPrefixByBankName$filterPrefix$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(DigitalMoney digitalMoney) {
                String substringPrefix;
                boolean areEqual;
                String substringPrefix2;
                Intrinsics.checkNotNullParameter(digitalMoney, "");
                String prefix = GetEWalletPrefixByBankName.Params.this.getPrefix();
                if ((prefix == null || prefix.length() == 0) || Intrinsics.areEqual("Manual Input", GetEWalletPrefixByBankName.Params.this.getRecipientSource())) {
                    String eWalletPrefix = digitalMoney.getEWalletPrefix();
                    substringPrefix = this.substringPrefix(GetEWalletPrefixByBankName.Params.this.getBankNumber(), digitalMoney.getEWalletPrefix());
                    areEqual = Intrinsics.areEqual(eWalletPrefix, substringPrefix);
                } else {
                    String eWalletPrefix2 = digitalMoney.getEWalletPrefix();
                    substringPrefix2 = this.substringPrefix(GetEWalletPrefixByBankName.Params.this.getPrefix(), digitalMoney.getEWalletPrefix());
                    areEqual = Intrinsics.areEqual(eWalletPrefix2, substringPrefix2);
                }
                return Boolean.valueOf(areEqual);
            }
        };
    }

    private final List<DigitalMoney> filterBankName(List<DigitalMoney> eWallets, Params params) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : eWallets) {
            if (Intrinsics.areEqual(((DigitalMoney) obj).getBankName(), params.getBankName())) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getPrefixLength(String prefix) {
        return prefix.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String substringPrefix(String str, String str2) {
        String substring = str.substring(0, getPrefixLength(str2));
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J<\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/sendmoney/interactor/GetEWalletPrefixByBankName$Params;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "bankName", "bankNumber", "prefix", "recipientSource", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/sendmoney/interactor/GetEWalletPrefixByBankName$Params;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankName", "getBankNumber", "getPrefix", "getRecipientSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final /* data */ class Params {
        private final String bankName;
        private final String bankNumber;
        private final String prefix;
        private final String recipientSource;

        public static /* synthetic */ Params copy$default(Params params, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = params.bankName;
            }
            if ((i & 2) != 0) {
                str2 = params.bankNumber;
            }
            if ((i & 4) != 0) {
                str3 = params.prefix;
            }
            if ((i & 8) != 0) {
                str4 = params.recipientSource;
            }
            return params.copy(str, str2, str3, str4);
        }

        /* renamed from: component1  reason: from getter */
        public final String getBankName() {
            return this.bankName;
        }

        /* renamed from: component2  reason: from getter */
        public final String getBankNumber() {
            return this.bankNumber;
        }

        /* renamed from: component3  reason: from getter */
        public final String getPrefix() {
            return this.prefix;
        }

        /* renamed from: component4  reason: from getter */
        public final String getRecipientSource() {
            return this.recipientSource;
        }

        public final Params copy(String bankName, String bankNumber, String prefix, String recipientSource) {
            Intrinsics.checkNotNullParameter(bankName, "");
            Intrinsics.checkNotNullParameter(bankNumber, "");
            return new Params(bankName, bankNumber, prefix, recipientSource);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Params) {
                Params params = (Params) other;
                return Intrinsics.areEqual(this.bankName, params.bankName) && Intrinsics.areEqual(this.bankNumber, params.bankNumber) && Intrinsics.areEqual(this.prefix, params.prefix) && Intrinsics.areEqual(this.recipientSource, params.recipientSource);
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = this.bankName.hashCode();
            int hashCode2 = this.bankNumber.hashCode();
            String str = this.prefix;
            int hashCode3 = str == null ? 0 : str.hashCode();
            String str2 = this.recipientSource;
            return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str2 != null ? str2.hashCode() : 0);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Params(bankName=");
            sb.append(this.bankName);
            sb.append(", bankNumber=");
            sb.append(this.bankNumber);
            sb.append(", prefix=");
            sb.append(this.prefix);
            sb.append(", recipientSource=");
            sb.append(this.recipientSource);
            sb.append(')');
            return sb.toString();
        }

        public Params(String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            this.bankName = str;
            this.bankNumber = str2;
            this.prefix = str3;
            this.recipientSource = str4;
        }

        public /* synthetic */ Params(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, (i & 8) != 0 ? null : str4);
        }

        @JvmName(name = "getBankName")
        public final String getBankName() {
            return this.bankName;
        }

        @JvmName(name = "getBankNumber")
        public final String getBankNumber() {
            return this.bankNumber;
        }

        @JvmName(name = "getPrefix")
        public final String getPrefix() {
            return this.prefix;
        }

        @JvmName(name = "getRecipientSource")
        public final String getRecipientSource() {
            return this.recipientSource;
        }
    }
}
