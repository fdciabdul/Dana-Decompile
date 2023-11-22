package id.dana.data.recentrecipient.model;

import id.dana.data.recentrecipient.source.persistence.entity.RecentRecipientEntity;
import id.dana.domain.recentbank.model.RecentBank;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0000*\b\u0012\u0004\u0012\u00020\u00070\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\"\u0014\u0010\f\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00038\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\r"}, d2 = {"", "Lid/dana/domain/recentbank/model/RecentBank;", "recentBanks", "", "sortingBy", "sortingRecentBanks", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "Lid/dana/data/recentrecipient/source/persistence/entity/RecentRecipientEntity;", "", "maxRecentRecipient", "filterAndSortRecentTransaction", "(Ljava/util/List;I)Ljava/util/List;", "ALPHABET", "Ljava/lang/String;", "RECENT"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RecentRecipientEntityExtKt {
    public static final String ALPHABET = "ALPHABET";
    public static final String RECENT = "RECENT";

    public static final List<RecentRecipientEntity> filterAndSortRecentTransaction(List<RecentRecipientEntity> list, int i) {
        Intrinsics.checkNotNullParameter(list, "");
        final Comparator comparator = new Comparator() { // from class: id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt$filterAndSortRecentTransaction$$inlined$compareByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(((RecentRecipientEntity) t2).getIsFavorite()), Boolean.valueOf(((RecentRecipientEntity) t).getIsFavorite()));
            }
        };
        final Comparator comparator2 = new Comparator() { // from class: id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt$filterAndSortRecentTransaction$$inlined$thenByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare == 0 ? ComparisonsKt.compareValues(Integer.valueOf(((RecentRecipientEntity) t2).getTransactionCount()), Integer.valueOf(((RecentRecipientEntity) t).getTransactionCount())) : compare;
            }
        };
        final Comparator nullsLast = ComparisonsKt.nullsLast(ComparisonsKt.naturalOrder());
        return CollectionsKt.take(CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt$filterAndSortRecentTransaction$$inlined$thenByDescending$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator2.compare(t, t2);
                return compare == 0 ? nullsLast.compare(Long.valueOf(((RecentRecipientEntity) t2).getLastUpdated()), Long.valueOf(((RecentRecipientEntity) t).getLastUpdated())) : compare;
            }
        }), i);
    }

    public static final List<RecentBank> sortingRecentBanks(List<? extends RecentBank> list, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        if (Intrinsics.areEqual(str, "ALPHABET")) {
            final Comparator comparator = new Comparator() { // from class: id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt$sortingRecentBanks$$inlined$compareBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    String alias = ((RecentBank) t).getAlias();
                    Intrinsics.checkNotNullExpressionValue(alias, "");
                    String lowerCase = alias.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                    String alias2 = ((RecentBank) t2).getAlias();
                    Intrinsics.checkNotNullExpressionValue(alias2, "");
                    String lowerCase2 = alias2.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
                    return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                }
            };
            return CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt$sortingRecentBanks$$inlined$thenBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int compare = comparator.compare(t, t2);
                    if (compare == 0) {
                        String recipientName = ((RecentBank) t).getRecipientName();
                        Intrinsics.checkNotNullExpressionValue(recipientName, "");
                        String lowerCase = recipientName.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                        String recipientName2 = ((RecentBank) t2).getRecipientName();
                        Intrinsics.checkNotNullExpressionValue(recipientName2, "");
                        String lowerCase2 = recipientName2.toLowerCase();
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
                        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
                    }
                    return compare;
                }
            });
        } else if (Intrinsics.areEqual(str, "RECENT")) {
            return CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt$sortingRecentBanks$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((RecentBank) t2).getLastUpdated()), Long.valueOf(((RecentBank) t).getLastUpdated()));
                }
            });
        } else {
            return CollectionsKt.sortedWith(list, new Comparator() { // from class: id.dana.data.recentrecipient.model.RecentRecipientEntityExtKt$sortingRecentBanks$$inlined$sortedByDescending$2
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((RecentBank) t2).getTransactionCount()), Integer.valueOf(((RecentBank) t).getTransactionCount()));
                }
            });
        }
    }
}
