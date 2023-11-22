package id.dana.domain.mybills.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J@\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/domain/mybills/model/MyBillsServiceModel;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "name", "icon", "link", "userAction", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/mybills/model/MyBillsServiceModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getIcon", "getLink", "getName", "getUserAction", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MyBillsServiceModel {
    private final String icon;
    private final String link;
    private final String name;
    private final String userAction;

    public static /* synthetic */ MyBillsServiceModel copy$default(MyBillsServiceModel myBillsServiceModel, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = myBillsServiceModel.name;
        }
        if ((i & 2) != 0) {
            str2 = myBillsServiceModel.icon;
        }
        if ((i & 4) != 0) {
            str3 = myBillsServiceModel.link;
        }
        if ((i & 8) != 0) {
            str4 = myBillsServiceModel.userAction;
        }
        return myBillsServiceModel.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2  reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component3  reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component4  reason: from getter */
    public final String getUserAction() {
        return this.userAction;
    }

    public final MyBillsServiceModel copy(String name, String icon, String link, String userAction) {
        return new MyBillsServiceModel(name, icon, link, userAction);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MyBillsServiceModel) {
            MyBillsServiceModel myBillsServiceModel = (MyBillsServiceModel) other;
            return Intrinsics.areEqual(this.name, myBillsServiceModel.name) && Intrinsics.areEqual(this.icon, myBillsServiceModel.icon) && Intrinsics.areEqual(this.link, myBillsServiceModel.link) && Intrinsics.areEqual(this.userAction, myBillsServiceModel.userAction);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.name;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.icon;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.link;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.userAction;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyBillsServiceModel(name=");
        sb.append(this.name);
        sb.append(", icon=");
        sb.append(this.icon);
        sb.append(", link=");
        sb.append(this.link);
        sb.append(", userAction=");
        sb.append(this.userAction);
        sb.append(')');
        return sb.toString();
    }

    public MyBillsServiceModel(String str, String str2, String str3, String str4) {
        this.name = str;
        this.icon = str2;
        this.link = str3;
        this.userAction = str4;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getIcon")
    public final String getIcon() {
        return this.icon;
    }

    @JvmName(name = "getLink")
    public final String getLink() {
        return this.link;
    }

    @JvmName(name = "getUserAction")
    public final String getUserAction() {
        return this.userAction;
    }
}
