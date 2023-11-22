package id.dana.data.social.model;

import android.database.Cursor;
import id.dana.data.social.common.CursorExtensionKt;
import id.dana.data.social.common.PhoneNumberUtilKt;
import id.dana.domain.social.ExtendInfoUtilKt;
import io.michaelrocks.libphonenumber.android.PhoneNumberUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BC\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJL\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001d\u001a\u0004\b\u001e\u0010\u0007R\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001f\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010 \u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0012\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b!\u0010\u0007R\u001a\u0010\u0010\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\"\u0010\u0007"}, d2 = {"Lid/dana/data/social/model/FeedsContactEntity;", "", "", "component1", "()I", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "", "component6", "()Z", "contactId", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "phoneNumber", "contactRawId", "lastUpdatedTime", "isEmpty", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/data/social/model/FeedsContactEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getContactId", "Ljava/lang/String;", "getContactRawId", "getDisplayName", "Z", "getLastUpdatedTime", "getPhoneNumber", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FeedsContactEntity {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int contactId;
    private final String contactRawId;
    private final String displayName;
    private final boolean isEmpty;
    private final String lastUpdatedTime;
    private final String phoneNumber;

    public FeedsContactEntity() {
        this(0, null, null, null, null, false, 63, null);
    }

    public static /* synthetic */ FeedsContactEntity copy$default(FeedsContactEntity feedsContactEntity, int i, String str, String str2, String str3, String str4, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = feedsContactEntity.contactId;
        }
        if ((i2 & 2) != 0) {
            str = feedsContactEntity.displayName;
        }
        String str5 = str;
        if ((i2 & 4) != 0) {
            str2 = feedsContactEntity.phoneNumber;
        }
        String str6 = str2;
        if ((i2 & 8) != 0) {
            str3 = feedsContactEntity.contactRawId;
        }
        String str7 = str3;
        if ((i2 & 16) != 0) {
            str4 = feedsContactEntity.lastUpdatedTime;
        }
        String str8 = str4;
        if ((i2 & 32) != 0) {
            z = feedsContactEntity.isEmpty;
        }
        return feedsContactEntity.copy(i, str5, str6, str7, str8, z);
    }

    /* renamed from: component1  reason: from getter */
    public final int getContactId() {
        return this.contactId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component4  reason: from getter */
    public final String getContactRawId() {
        return this.contactRawId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    /* renamed from: component6  reason: from getter */
    public final boolean getIsEmpty() {
        return this.isEmpty;
    }

    public final FeedsContactEntity copy(int contactId, String displayName, String phoneNumber, String contactRawId, String lastUpdatedTime, boolean isEmpty) {
        Intrinsics.checkNotNullParameter(displayName, "");
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        Intrinsics.checkNotNullParameter(contactRawId, "");
        Intrinsics.checkNotNullParameter(lastUpdatedTime, "");
        return new FeedsContactEntity(contactId, displayName, phoneNumber, contactRawId, lastUpdatedTime, isEmpty);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FeedsContactEntity) {
            FeedsContactEntity feedsContactEntity = (FeedsContactEntity) other;
            return this.contactId == feedsContactEntity.contactId && Intrinsics.areEqual(this.displayName, feedsContactEntity.displayName) && Intrinsics.areEqual(this.phoneNumber, feedsContactEntity.phoneNumber) && Intrinsics.areEqual(this.contactRawId, feedsContactEntity.contactRawId) && Intrinsics.areEqual(this.lastUpdatedTime, feedsContactEntity.lastUpdatedTime) && this.isEmpty == feedsContactEntity.isEmpty;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int i = this.contactId;
        int hashCode = this.displayName.hashCode();
        int hashCode2 = this.phoneNumber.hashCode();
        int hashCode3 = this.contactRawId.hashCode();
        int hashCode4 = this.lastUpdatedTime.hashCode();
        boolean z = this.isEmpty;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return (((((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FeedsContactEntity(contactId=");
        sb.append(this.contactId);
        sb.append(", displayName=");
        sb.append(this.displayName);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", contactRawId=");
        sb.append(this.contactRawId);
        sb.append(", lastUpdatedTime=");
        sb.append(this.lastUpdatedTime);
        sb.append(", isEmpty=");
        sb.append(this.isEmpty);
        sb.append(')');
        return sb.toString();
    }

    public FeedsContactEntity(int i, String str, String str2, String str3, String str4, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        this.contactId = i;
        this.displayName = str;
        this.phoneNumber = str2;
        this.contactRawId = str3;
        this.lastUpdatedTime = str4;
        this.isEmpty = z;
    }

    public /* synthetic */ FeedsContactEntity(int i, String str, String str2, String str3, String str4, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) == 0 ? str4 : "", (i2 & 32) != 0 ? false : z);
    }

    @JvmName(name = "getContactId")
    public final int getContactId() {
        return this.contactId;
    }

    @JvmName(name = "getDisplayName")
    public final String getDisplayName() {
        return this.displayName;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getContactRawId")
    public final String getContactRawId() {
        return this.contactRawId;
    }

    @JvmName(name = "getLastUpdatedTime")
    public final String getLastUpdatedTime() {
        return this.lastUpdatedTime;
    }

    @JvmName(name = "isEmpty")
    public final boolean isEmpty() {
        return this.isEmpty;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/social/model/FeedsContactEntity$Companion;", "", "Landroid/database/Cursor;", "cursor", "Lid/dana/data/social/model/FeedsContactEntity;", "fromCursorWithoutPhoto", "(Landroid/database/Cursor;)Lid/dana/data/social/model/FeedsContactEntity;", "", "isEmpty", "()V", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void isEmpty() {
            while (true) {
            }
        }

        private Companion() {
        }

        public final FeedsContactEntity fromCursorWithoutPhoto(Cursor cursor) {
            Intrinsics.checkNotNullParameter(cursor, "");
            int parseContactId = CursorExtensionKt.parseContactId(cursor);
            String parseContactDisplayId = CursorExtensionKt.parseContactDisplayId(cursor);
            Intrinsics.checkNotNullExpressionValue(parseContactDisplayId, "");
            String normalizeDigitsOnly = PhoneNumberUtil.normalizeDigitsOnly(CursorExtensionKt.parsePhoneNumber(cursor));
            Intrinsics.checkNotNullExpressionValue(normalizeDigitsOnly, "");
            String replaceIndoPhonePrefixWithRegionDash = PhoneNumberUtilKt.replaceIndoPhonePrefixWithRegionDash(normalizeDigitsOnly);
            String parseContactRawId = CursorExtensionKt.parseContactRawId(cursor);
            Intrinsics.checkNotNullExpressionValue(parseContactRawId, "");
            String parseLastUpdatedTime = CursorExtensionKt.parseLastUpdatedTime(cursor);
            Intrinsics.checkNotNullExpressionValue(parseLastUpdatedTime, "");
            return new FeedsContactEntity(parseContactId, parseContactDisplayId, replaceIndoPhonePrefixWithRegionDash, parseContactRawId, parseLastUpdatedTime, false);
        }
    }
}
