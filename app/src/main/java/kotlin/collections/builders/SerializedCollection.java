package kotlin.collections.builders;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import id.dana.data.profilemenu.MyProfileMenuAction;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\t\b\u0016¢\u0006\u0004\b\u0014\u0010\u0015B\u001b\u0012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "Ljava/io/ObjectInput;", "input", "", "readExternal", "(Ljava/io/ObjectInput;)V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, "writeExternal", "(Ljava/io/ObjectOutput;)V", "", MyProfileMenuAction.COLLECTION, "Ljava/util/Collection;", "", "tag", "I", "<init>", "()V", "(Ljava/util/Collection;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SerializedCollection implements Externalizable {
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    public SerializedCollection(Collection<?> collection, int i) {
        Intrinsics.checkNotNullParameter(collection, "");
        this.collection = collection;
        this.tag = i;
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> it = this.collection.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) {
        List build;
        Intrinsics.checkNotNullParameter(input, "");
        byte readByte = input.readByte();
        int i = readByte & 1;
        if ((readByte & (-2)) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported flags value: ");
            sb.append((int) readByte);
            sb.append('.');
            throw new InvalidObjectException(sb.toString());
        }
        int readInt = input.readInt();
        if (readInt < 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Illegal size value: ");
            sb2.append(readInt);
            sb2.append('.');
            throw new InvalidObjectException(sb2.toString());
        }
        int i2 = 0;
        if (i == 0) {
            List createListBuilder = CollectionsKt.createListBuilder(readInt);
            while (i2 < readInt) {
                createListBuilder.add(input.readObject());
                i2++;
            }
            build = CollectionsKt.build(createListBuilder);
        } else if (i == 1) {
            Set createSetBuilder = SetsKt.createSetBuilder(readInt);
            while (i2 < readInt) {
                createSetBuilder.add(input.readObject());
                i2++;
            }
            build = SetsKt.build(createSetBuilder);
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unsupported collection type tag: ");
            sb3.append(i);
            sb3.append('.');
            throw new InvalidObjectException(sb3.toString());
        }
        this.collection = build;
    }

    private final Object readResolve() {
        return this.collection;
    }
}
