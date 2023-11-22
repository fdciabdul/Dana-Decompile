package io.split.android.client;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class SplitFilter {
    private final Type mType;
    private final List<String> mValues;

    /* renamed from: io.split.android.client.SplitFilter$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$SplitFilter$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$io$split$android$client$SplitFilter$Type = iArr;
            try {
                iArr[Type.BY_NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$SplitFilter$Type[Type.BY_PREFIX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public enum Type {
        BY_NAME,
        BY_PREFIX;

        @Override // java.lang.Enum
        public final String toString() {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[ordinal()];
            return i != 1 ? i != 2 ? "Invalid type" : "by split prefix" : "by split name";
        }

        public final String queryStringField() {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[ordinal()];
            return i != 1 ? i != 2 ? "unknown" : "prefixes" : "names";
        }

        public final int maxValuesCount() {
            int i = AnonymousClass1.$SwitchMap$io$split$android$client$SplitFilter$Type[ordinal()];
            if (i != 1) {
                return i != 2 ? 0 : 50;
            }
            return 400;
        }
    }

    public static SplitFilter byName(List<String> list) {
        return new SplitFilter(Type.BY_NAME, list);
    }

    public static SplitFilter byPrefix(List<String> list) {
        return new SplitFilter(Type.BY_PREFIX, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SplitFilter(Type type, List<String> list) {
        if (list == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Values can't be null for ");
            sb.append(type.toString());
            sb.append(" filter");
            throw new IllegalArgumentException(sb.toString());
        }
        this.mType = type;
        this.mValues = new ArrayList(list);
    }

    public Type getType() {
        return this.mType;
    }

    public List<String> getValues() {
        return this.mValues;
    }

    public void updateValues(List<String> list) {
        this.mValues.clear();
        this.mValues.addAll(list);
    }
}
