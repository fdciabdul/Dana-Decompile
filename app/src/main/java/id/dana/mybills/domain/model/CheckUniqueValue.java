package id.dana.mybills.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001eB+\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ4\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\t"}, d2 = {"Lid/dana/mybills/domain/model/CheckUniqueValue;", "", "", "component1", "()I", "component2", "", "Lid/dana/mybills/domain/model/CheckUniqueValue$SubscriptionItem;", "component3", "()Ljava/util/List;", "autodeductionCount", "reminderCount", "subscriptionItem", "copy", "(IILjava/util/List;)Lid/dana/mybills/domain/model/CheckUniqueValue;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "I", "getAutodeductionCount", "getReminderCount", "Ljava/util/List;", "getSubscriptionItem", "<init>", "(IILjava/util/List;)V", "SubscriptionItem"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CheckUniqueValue {
    private final int autodeductionCount;
    private final int reminderCount;
    private final List<SubscriptionItem> subscriptionItem;

    public CheckUniqueValue() {
        this(0, 0, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckUniqueValue copy$default(CheckUniqueValue checkUniqueValue, int i, int i2, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = checkUniqueValue.autodeductionCount;
        }
        if ((i3 & 2) != 0) {
            i2 = checkUniqueValue.reminderCount;
        }
        if ((i3 & 4) != 0) {
            list = checkUniqueValue.subscriptionItem;
        }
        return checkUniqueValue.copy(i, i2, list);
    }

    /* renamed from: component1  reason: from getter */
    public final int getAutodeductionCount() {
        return this.autodeductionCount;
    }

    /* renamed from: component2  reason: from getter */
    public final int getReminderCount() {
        return this.reminderCount;
    }

    public final List<SubscriptionItem> component3() {
        return this.subscriptionItem;
    }

    public final CheckUniqueValue copy(int autodeductionCount, int reminderCount, List<SubscriptionItem> subscriptionItem) {
        Intrinsics.checkNotNullParameter(subscriptionItem, "");
        return new CheckUniqueValue(autodeductionCount, reminderCount, subscriptionItem);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CheckUniqueValue) {
            CheckUniqueValue checkUniqueValue = (CheckUniqueValue) other;
            return this.autodeductionCount == checkUniqueValue.autodeductionCount && this.reminderCount == checkUniqueValue.reminderCount && Intrinsics.areEqual(this.subscriptionItem, checkUniqueValue.subscriptionItem);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.autodeductionCount * 31) + this.reminderCount) * 31) + this.subscriptionItem.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CheckUniqueValue(autodeductionCount=");
        sb.append(this.autodeductionCount);
        sb.append(", reminderCount=");
        sb.append(this.reminderCount);
        sb.append(", subscriptionItem=");
        sb.append(this.subscriptionItem);
        sb.append(')');
        return sb.toString();
    }

    public CheckUniqueValue(int i, int i2, List<SubscriptionItem> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.autodeductionCount = i;
        this.reminderCount = i2;
        this.subscriptionItem = list;
    }

    @JvmName(name = "getAutodeductionCount")
    public final int getAutodeductionCount() {
        return this.autodeductionCount;
    }

    @JvmName(name = "getReminderCount")
    public final int getReminderCount() {
        return this.reminderCount;
    }

    public /* synthetic */ CheckUniqueValue(int i, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getSubscriptionItem")
    public final List<SubscriptionItem> getSubscriptionItem() {
        return this.subscriptionItem;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\u0007\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004"}, d2 = {"Lid/dana/mybills/domain/model/CheckUniqueValue$SubscriptionItem;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "goodsType", "recurringType", "subscriptionId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/mybills/domain/model/CheckUniqueValue$SubscriptionItem;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getGoodsType", "getRecurringType", "getSubscriptionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class SubscriptionItem {
        private final String goodsType;
        private final String recurringType;
        private final String subscriptionId;

        public static /* synthetic */ SubscriptionItem copy$default(SubscriptionItem subscriptionItem, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = subscriptionItem.goodsType;
            }
            if ((i & 2) != 0) {
                str2 = subscriptionItem.recurringType;
            }
            if ((i & 4) != 0) {
                str3 = subscriptionItem.subscriptionId;
            }
            return subscriptionItem.copy(str, str2, str3);
        }

        /* renamed from: component1  reason: from getter */
        public final String getGoodsType() {
            return this.goodsType;
        }

        /* renamed from: component2  reason: from getter */
        public final String getRecurringType() {
            return this.recurringType;
        }

        /* renamed from: component3  reason: from getter */
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }

        public final SubscriptionItem copy(String goodsType, String recurringType, String subscriptionId) {
            Intrinsics.checkNotNullParameter(goodsType, "");
            Intrinsics.checkNotNullParameter(recurringType, "");
            Intrinsics.checkNotNullParameter(subscriptionId, "");
            return new SubscriptionItem(goodsType, recurringType, subscriptionId);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof SubscriptionItem) {
                SubscriptionItem subscriptionItem = (SubscriptionItem) other;
                return Intrinsics.areEqual(this.goodsType, subscriptionItem.goodsType) && Intrinsics.areEqual(this.recurringType, subscriptionItem.recurringType) && Intrinsics.areEqual(this.subscriptionId, subscriptionItem.subscriptionId);
            }
            return false;
        }

        public final int hashCode() {
            return (((this.goodsType.hashCode() * 31) + this.recurringType.hashCode()) * 31) + this.subscriptionId.hashCode();
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SubscriptionItem(goodsType=");
            sb.append(this.goodsType);
            sb.append(", recurringType=");
            sb.append(this.recurringType);
            sb.append(", subscriptionId=");
            sb.append(this.subscriptionId);
            sb.append(')');
            return sb.toString();
        }

        public SubscriptionItem(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str3, "");
            this.goodsType = str;
            this.recurringType = str2;
            this.subscriptionId = str3;
        }

        @JvmName(name = "getGoodsType")
        public final String getGoodsType() {
            return this.goodsType;
        }

        @JvmName(name = "getRecurringType")
        public final String getRecurringType() {
            return this.recurringType;
        }

        @JvmName(name = "getSubscriptionId")
        public final String getSubscriptionId() {
            return this.subscriptionId;
        }
    }
}
