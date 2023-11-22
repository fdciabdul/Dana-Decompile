package id.dana.domain.model;

import android.os.Parcel;
import android.os.Parcelable;
import id.dana.domain.user.UserInfoResponseConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u000f\u0010\u001b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001b\u0010\nJ \u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u001f\u0010 R(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b8\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010!\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u0007R$\u0010$\u001a\u0004\u0018\u00010\u00008\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0005R\"\u0010\u000e\u001a\u00020\b8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010)\u001a\u0004\b*\u0010\n\"\u0004\b+\u0010,"}, d2 = {"Lid/dana/domain/model/VerificationTreeNode;", "Landroid/os/Parcelable;", "node", "", "addChild", "(Lid/dana/domain/model/VerificationTreeNode;)V", "", "(Ljava/util/List;)V", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", "value", "children", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/domain/model/VerificationTreeNode;", "", "describeContents", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Landroid/os/Parcel;", "parcel", "flags", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/List;", "getChildren", "setChildren", "parent", "Lid/dana/domain/model/VerificationTreeNode;", "getParent", "()Lid/dana/domain/model/VerificationTreeNode;", "setParent", "Ljava/lang/String;", "getValue", "setValue", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerificationTreeNode implements Parcelable {
    private List<VerificationTreeNode> children;
    private VerificationTreeNode parent;
    private String value;

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Parcelable.Creator<VerificationTreeNode> CREATOR = new Creator();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Creator implements Parcelable.Creator<VerificationTreeNode> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VerificationTreeNode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "");
            String readString = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(VerificationTreeNode.CREATOR.createFromParcel(parcel));
            }
            return new VerificationTreeNode(readString, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final VerificationTreeNode[] newArray(int i) {
            return new VerificationTreeNode[i];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerificationTreeNode copy$default(VerificationTreeNode verificationTreeNode, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verificationTreeNode.value;
        }
        if ((i & 2) != 0) {
            list = verificationTreeNode.children;
        }
        return verificationTreeNode.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final List<VerificationTreeNode> component2() {
        return this.children;
    }

    public final VerificationTreeNode copy(String value, List<VerificationTreeNode> children) {
        Intrinsics.checkNotNullParameter(value, "");
        Intrinsics.checkNotNullParameter(children, "");
        return new VerificationTreeNode(value, children);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerificationTreeNode) {
            VerificationTreeNode verificationTreeNode = (VerificationTreeNode) other;
            return Intrinsics.areEqual(this.value, verificationTreeNode.value) && Intrinsics.areEqual(this.children, verificationTreeNode.children);
        }
        return false;
    }

    public final int hashCode() {
        return (this.value.hashCode() * 31) + this.children.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "");
        parcel.writeString(this.value);
        List<VerificationTreeNode> list = this.children;
        parcel.writeInt(list.size());
        Iterator<VerificationTreeNode> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, flags);
        }
    }

    public VerificationTreeNode(String str, List<VerificationTreeNode> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.value = str;
        this.children = list;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }

    @JvmName(name = "setValue")
    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.value = str;
    }

    public /* synthetic */ VerificationTreeNode(String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    @JvmName(name = "getChildren")
    public final List<VerificationTreeNode> getChildren() {
        return this.children;
    }

    @JvmName(name = "setChildren")
    public final void setChildren(List<VerificationTreeNode> list) {
        Intrinsics.checkNotNullParameter(list, "");
        this.children = list;
    }

    @JvmName(name = "getParent")
    public final VerificationTreeNode getParent() {
        return this.parent;
    }

    @JvmName(name = "setParent")
    public final void setParent(VerificationTreeNode verificationTreeNode) {
        this.parent = verificationTreeNode;
    }

    public final void addChild(VerificationTreeNode node) {
        Intrinsics.checkNotNullParameter(node, "");
        this.children.add(node);
        node.parent = this;
    }

    public final void addChild(List<VerificationTreeNode> node) {
        Intrinsics.checkNotNullParameter(node, "");
        Iterator<T> it = node.iterator();
        while (it.hasNext()) {
            addChild((VerificationTreeNode) it.next());
        }
    }

    public final String toString() {
        String str = this.value;
        if ((!this.children.isEmpty()) == true) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" {");
            List<VerificationTreeNode> list = this.children;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((VerificationTreeNode) it.next()).toString());
            }
            sb.append(arrayList);
            sb.append(" }");
            return sb.toString();
        }
        return str;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/domain/model/VerificationTreeNode$Companion;", "", "Lid/dana/domain/model/VerificationTreeNode;", "tree", "", "", "list", "", "convertToList", "(Lid/dana/domain/model/VerificationTreeNode;Ljava/util/List;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void convertToList(VerificationTreeNode tree, List<String> list) {
            while (true) {
                Intrinsics.checkNotNullParameter(list, "");
                if (tree == null) {
                    return;
                }
                if (!Intrinsics.areEqual(tree.getValue(), UserInfoResponseConstant.LoginStatus.INITIAL)) {
                    list.add(tree.getValue());
                }
                convertToList((VerificationTreeNode) CollectionsKt.firstOrNull((List) tree.getChildren()), list);
                tree = (VerificationTreeNode) CollectionsKt.getOrNull(tree.getChildren(), 1);
            }
        }
    }
}
