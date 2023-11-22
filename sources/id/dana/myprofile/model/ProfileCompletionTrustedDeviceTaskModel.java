package id.dana.myprofile.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\nX\u0006¢\u0006\u0006\n\u0004\b\r\u0010\u000e"}, d2 = {"Lid/dana/myprofile/model/ProfileCompletionTrustedDeviceTaskModel;", "Lid/dana/myprofile/model/ProfileCompletionTasksModel;", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getAuthRequestContext", "Ljava/lang/String;", "MyBillsEntityDataFactory", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProfileCompletionTrustedDeviceTaskModel extends ProfileCompletionTasksModel {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String MyBillsEntityDataFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ProfileCompletionTrustedDeviceTaskModel() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.model.ProfileCompletionTrustedDeviceTaskModel.<init>():void");
    }

    public final boolean equals(Object p0) {
        if (this == p0) {
            return true;
        }
        return (p0 instanceof ProfileCompletionTrustedDeviceTaskModel) && Intrinsics.areEqual(this.MyBillsEntityDataFactory, ((ProfileCompletionTrustedDeviceTaskModel) p0).MyBillsEntityDataFactory);
    }

    public final int hashCode() {
        return this.MyBillsEntityDataFactory.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProfileCompletionTrustedDeviceTaskModel(MyBillsEntityDataFactory=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ ProfileCompletionTrustedDeviceTaskModel(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileCompletionTrustedDeviceTaskModel(String str) {
        super(null, null, false, null, 15, null);
        Intrinsics.checkNotNullParameter(str, "");
        this.MyBillsEntityDataFactory = str;
    }
}
