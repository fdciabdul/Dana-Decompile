package androidx.credentials.webauthn;

import id.dana.cashier.view.InputCardNumberView;
import id.dana.data.constant.BranchLinkConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b)\u0010*J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0086D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u001f\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010\u0018\u001a\u0004\b \u0010\u001aR\u001a\u0010!\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR\u001a\u0010#\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b#\u0010\u0018\u001a\u0004\b$\u0010\u001aR\u001a\u0010%\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR\u001a\u0010'\u001a\u00020\u00028\u0007X\u0087D¢\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001a"}, d2 = {"Landroidx/credentials/webauthn/Cbor;", "", "", "type", "", "arg", "", "createArg", "(IJ)[B", "data", BranchLinkConstant.PathTarget.DECODE, "([B)Ljava/lang/Object;", "encode", "(Ljava/lang/Object;)[B", "offset", "Landroidx/credentials/webauthn/Cbor$Arg;", "getArg", "([BI)Landroidx/credentials/webauthn/Cbor$Arg;", "getType", "([BI)I", "Landroidx/credentials/webauthn/Cbor$Item;", "parseItem", "([BI)Landroidx/credentials/webauthn/Cbor$Item;", "TYPE_ARRAY", "I", "getTYPE_ARRAY", "()I", "TYPE_BYTE_STRING", "getTYPE_BYTE_STRING", "TYPE_FLOAT", "getTYPE_FLOAT", "TYPE_MAP", "getTYPE_MAP", "TYPE_NEGATIVE_INT", "getTYPE_NEGATIVE_INT", "TYPE_TAG", "getTYPE_TAG", "TYPE_TEXT_STRING", "getTYPE_TEXT_STRING", "TYPE_UNSIGNED_INT", "getTYPE_UNSIGNED_INT", "<init>", "()V", "Arg", "Item"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Cbor {
    private final int TYPE_UNSIGNED_INT;
    private final int TYPE_NEGATIVE_INT = 1;
    private final int TYPE_BYTE_STRING = 2;
    private final int TYPE_TEXT_STRING = 3;
    private final int TYPE_ARRAY = 4;
    private final int TYPE_MAP = 5;
    private final int TYPE_TAG = 6;
    private final int TYPE_FLOAT = 7;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0003R\u001a\u0010\b\u001a\u00020\u00048\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0006"}, d2 = {"Landroidx/credentials/webauthn/Cbor$Item;", "", "component1", "()Ljava/lang/Object;", "", "component2", "()I", "item", "len", "copy", "(Ljava/lang/Object;I)Landroidx/credentials/webauthn/Cbor$Item;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "Ljava/lang/Object;", "getItem", "I", "getLen", "<init>", "(Ljava/lang/Object;I)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class Item {
        private final Object item;
        private final int len;

        public static /* synthetic */ Item copy$default(Item item, Object obj, int i, int i2, Object obj2) {
            if ((i2 & 1) != 0) {
                obj = item.item;
            }
            if ((i2 & 2) != 0) {
                i = item.len;
            }
            return item.copy(obj, i);
        }

        /* renamed from: component1  reason: from getter */
        public final Object getItem() {
            return this.item;
        }

        /* renamed from: component2  reason: from getter */
        public final int getLen() {
            return this.len;
        }

        public final Item copy(Object item, int len) {
            Intrinsics.checkNotNullParameter(item, "");
            return new Item(item, len);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Item) {
                Item item = (Item) other;
                return Intrinsics.areEqual(this.item, item.item) && this.len == item.len;
            }
            return false;
        }

        public final int hashCode() {
            return (this.item.hashCode() * 31) + this.len;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Item(item=");
            sb.append(this.item);
            sb.append(", len=");
            sb.append(this.len);
            sb.append(')');
            return sb.toString();
        }

        public Item(Object obj, int i) {
            Intrinsics.checkNotNullParameter(obj, "");
            this.item = obj;
            this.len = i;
        }

        @JvmName(name = "getItem")
        public final Object getItem() {
            return this.item;
        }

        @JvmName(name = "getLen")
        public final int getLen() {
            return this.len;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001a\u0010\t\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007"}, d2 = {"Landroidx/credentials/webauthn/Cbor$Arg;", "", "", "component1", "()J", "", "component2", "()I", "arg", "len", "copy", "(JI)Landroidx/credentials/webauthn/Cbor$Arg;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", "J", "getArg", "I", "getLen", "<init>", "(JI)V"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* data */ class Arg {
        private final long arg;
        private final int len;

        public static /* synthetic */ Arg copy$default(Arg arg, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = arg.arg;
            }
            if ((i2 & 2) != 0) {
                i = arg.len;
            }
            return arg.copy(j, i);
        }

        /* renamed from: component1  reason: from getter */
        public final long getArg() {
            return this.arg;
        }

        /* renamed from: component2  reason: from getter */
        public final int getLen() {
            return this.len;
        }

        public final Arg copy(long arg, int len) {
            return new Arg(arg, len);
        }

        public final boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof Arg) {
                Arg arg = (Arg) other;
                return this.arg == arg.arg && this.len == arg.len;
            }
            return false;
        }

        public final int hashCode() {
            return (Cbor$Arg$$ExternalSyntheticBackport0.m(this.arg) * 31) + this.len;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Arg(arg=");
            sb.append(this.arg);
            sb.append(", len=");
            sb.append(this.len);
            sb.append(')');
            return sb.toString();
        }

        public Arg(long j, int i) {
            this.arg = j;
            this.len = i;
        }

        @JvmName(name = "getArg")
        public final long getArg() {
            return this.arg;
        }

        @JvmName(name = "getLen")
        public final int getLen() {
            return this.len;
        }
    }

    @JvmName(name = "getTYPE_UNSIGNED_INT")
    public final int getTYPE_UNSIGNED_INT() {
        return this.TYPE_UNSIGNED_INT;
    }

    @JvmName(name = "getTYPE_NEGATIVE_INT")
    public final int getTYPE_NEGATIVE_INT() {
        return this.TYPE_NEGATIVE_INT;
    }

    @JvmName(name = "getTYPE_BYTE_STRING")
    public final int getTYPE_BYTE_STRING() {
        return this.TYPE_BYTE_STRING;
    }

    @JvmName(name = "getTYPE_TEXT_STRING")
    public final int getTYPE_TEXT_STRING() {
        return this.TYPE_TEXT_STRING;
    }

    @JvmName(name = "getTYPE_ARRAY")
    public final int getTYPE_ARRAY() {
        return this.TYPE_ARRAY;
    }

    @JvmName(name = "getTYPE_MAP")
    public final int getTYPE_MAP() {
        return this.TYPE_MAP;
    }

    @JvmName(name = "getTYPE_TAG")
    public final int getTYPE_TAG() {
        return this.TYPE_TAG;
    }

    @JvmName(name = "getTYPE_FLOAT")
    public final int getTYPE_FLOAT() {
        return this.TYPE_FLOAT;
    }

    public final Object decode(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "");
        return parseItem(data, 0).getItem();
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.util.Map] */
    public final byte[] encode(Object data) {
        Intrinsics.checkNotNullParameter(data, "");
        if (data instanceof Number) {
            if (data instanceof Double) {
                throw new IllegalArgumentException("Don't support doubles yet");
            }
            long longValue = ((Number) data).longValue();
            if (longValue >= 0) {
                return createArg(this.TYPE_UNSIGNED_INT, longValue);
            }
            return createArg(this.TYPE_NEGATIVE_INT, (-1) - longValue);
        } else if (data instanceof byte[]) {
            return ArraysKt.plus(createArg(this.TYPE_BYTE_STRING, r7.length), (byte[]) data);
        } else if (data instanceof String) {
            return ArraysKt.plus(createArg(this.TYPE_TEXT_STRING, r7.length()), StringsKt.encodeToByteArray((String) data));
        } else if (data instanceof List) {
            byte[] createArg = createArg(this.TYPE_ARRAY, r7.size());
            for (Object obj : (List) data) {
                Intrinsics.checkNotNull(obj);
                createArg = ArraysKt.plus(createArg, encode(obj));
            }
            return createArg;
        } else if (data instanceof Map) {
            byte[] createArg2 = createArg(this.TYPE_MAP, r7.size());
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new LinkedHashMap();
            for (Map.Entry entry : ((Map) data).entrySet()) {
                Map map = (Map) objectRef.element;
                Object key = entry.getKey();
                Intrinsics.checkNotNull(key);
                byte[] encode = encode(key);
                Object value = entry.getValue();
                Intrinsics.checkNotNull(value);
                map.put(encode, encode(value));
            }
            ArrayList arrayList = new ArrayList(((Map) objectRef.element).keySet());
            CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.credentials.webauthn.Cbor$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj2, Object obj3) {
                    int encode$lambda$0;
                    encode$lambda$0 = Cbor.encode$lambda$0(Ref.ObjectRef.this, (byte[]) obj2, (byte[]) obj3);
                    return encode$lambda$0;
                }
            });
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArr = (byte[]) it.next();
                Intrinsics.checkNotNullExpressionValue(bArr, "");
                byte[] plus = ArraysKt.plus(createArg2, bArr);
                Object obj2 = ((Map) objectRef.element).get(bArr);
                Intrinsics.checkNotNull(obj2);
                createArg2 = ArraysKt.plus(plus, (byte[]) obj2);
            }
            return createArg2;
        } else {
            throw new IllegalArgumentException("Bad type");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int encode$lambda$0(Ref.ObjectRef objectRef, byte[] bArr, byte[] bArr2) {
        Intrinsics.checkNotNullParameter(objectRef, "");
        Object obj = ((Map) objectRef.element).get(bArr);
        Intrinsics.checkNotNull(obj);
        byte[] bArr3 = (byte[]) obj;
        Object obj2 = ((Map) objectRef.element).get(bArr2);
        Intrinsics.checkNotNull(obj2);
        byte[] bArr4 = (byte[]) obj2;
        if (bArr.length <= bArr2.length) {
            if (bArr.length >= bArr2.length) {
                if (bArr3.length <= bArr4.length) {
                    if (bArr3.length >= bArr4.length) {
                        return 0;
                    }
                }
            }
            return -1;
        }
        return 1;
    }

    private final int getType(byte[] data, int offset) {
        return (data[offset] & 255) >> 5;
    }

    private final Arg getArg(byte[] data, int offset) {
        long j = data[offset] & 31;
        if (j < 24) {
            return new Arg(j, 1);
        }
        if (j == 24) {
            return new Arg(data[offset + 1] & 255, 2);
        }
        if (j == 25) {
            return new Arg((data[offset + 2] & 255) | ((data[offset + 1] & 255) << 8), 3);
        } else if (j == 26) {
            return new Arg((data[offset + 4] & 255) | ((data[offset + 1] & 255) << 24) | ((data[offset + 2] & 255) << 16) | ((data[offset + 3] & 255) << 8), 5);
        } else {
            throw new IllegalArgumentException("Bad arg");
        }
    }

    private final Item parseItem(byte[] data, int offset) {
        int type = getType(data, offset);
        Arg arg = getArg(data, offset);
        StringBuilder sb = new StringBuilder();
        sb.append("Type ");
        sb.append(type);
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(arg.getArg());
        sb.append(InputCardNumberView.DIVIDER);
        sb.append(arg.getLen());
        System.out.println((Object) sb.toString());
        if (type == this.TYPE_UNSIGNED_INT) {
            return new Item(Long.valueOf(arg.getArg()), arg.getLen());
        }
        if (type == this.TYPE_NEGATIVE_INT) {
            return new Item(Long.valueOf((-1) - arg.getArg()), arg.getLen());
        }
        if (type == this.TYPE_BYTE_STRING) {
            return new Item(ArraysKt.sliceArray(data, RangesKt.until(arg.getLen() + offset, offset + arg.getLen() + ((int) arg.getArg()))), arg.getLen() + ((int) arg.getArg()));
        }
        if (type == this.TYPE_TEXT_STRING) {
            return new Item(new String(ArraysKt.sliceArray(data, RangesKt.until(arg.getLen() + offset, offset + arg.getLen() + ((int) arg.getArg()))), Charsets.UTF_8), arg.getLen() + ((int) arg.getArg()));
        }
        int i = 0;
        if (type == this.TYPE_ARRAY) {
            ArrayList arrayList = new ArrayList();
            int len = arg.getLen();
            int arg2 = (int) arg.getArg();
            while (i < arg2) {
                Item parseItem = parseItem(data, offset + len);
                arrayList.add(parseItem.getItem());
                len += parseItem.getLen();
                i++;
            }
            return new Item(CollectionsKt.toList(arrayList), len);
        } else if (type == this.TYPE_MAP) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int len2 = arg.getLen();
            int arg3 = (int) arg.getArg();
            while (i < arg3) {
                Item parseItem2 = parseItem(data, offset + len2);
                int len3 = len2 + parseItem2.getLen();
                Item parseItem3 = parseItem(data, offset + len3);
                len2 = len3 + parseItem3.getLen();
                linkedHashMap.put(parseItem2.getItem(), parseItem3.getItem());
                i++;
            }
            return new Item(MapsKt.toMap(linkedHashMap), len2);
        } else {
            throw new IllegalArgumentException("Bad type");
        }
    }

    private final byte[] createArg(int type, long arg) {
        int i = type << 5;
        int i2 = (int) arg;
        if (arg < 24) {
            return new byte[]{(byte) ((i | i2) & 255)};
        }
        if (arg <= 255) {
            return new byte[]{(byte) ((i | 24) & 255), (byte) (i2 & 255)};
        }
        if (arg <= 65535) {
            return new byte[]{(byte) ((i | 25) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
        }
        if (arg <= 4294967295L) {
            return new byte[]{(byte) ((i | 26) & 255), (byte) ((i2 >> 24) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 8) & 255), (byte) (i2 & 255)};
        }
        throw new IllegalArgumentException("bad Arg");
    }
}
