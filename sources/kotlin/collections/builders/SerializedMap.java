package kotlin.collections.builders;

import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\t\b\u0016¢\u0006\u0004\b\u0011\u0010\u0012B\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0011\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u000f\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "Ljava/io/ObjectInput;", "input", "", "readExternal", "(Ljava/io/ObjectInput;)V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", TinyAppLogUtil.TINY_APP_STANDARD_OUTPUT, "writeExternal", "(Ljava/io/ObjectOutput;)V", "", "map", "Ljava/util/Map;", "<init>", "()V", "(Ljava/util/Map;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SerializedMap implements Externalizable {
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    public SerializedMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "");
        this.map = map;
    }

    public SerializedMap() {
        this(MapsKt.emptyMap());
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) {
        Intrinsics.checkNotNullParameter(input, "");
        byte readByte = input.readByte();
        if (readByte != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unsupported flags value: ");
            sb.append((int) readByte);
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
        Map createMapBuilder = MapsKt.createMapBuilder(readInt);
        for (int i = 0; i < readInt; i++) {
            createMapBuilder.put(input.readObject(), input.readObject());
        }
        this.map = MapsKt.build(createMapBuilder);
    }

    private final Object readResolve() {
        return this.map;
    }
}
