package zipkin2.reporter;

import java.util.ArrayList;
import java.util.Iterator;
import zipkin2.codec.Encoding;

/* loaded from: classes9.dex */
abstract class BufferNextMessage<S> implements SpanWithSizeConsumer<S> {
    final int BuiltInFictitiousFunctionClassFactory;
    int KClassImpl$Data$declaredNonStaticMembers$2;
    long PlaceComponentResult;
    boolean getAuthRequestContext;
    final ArrayList<S> scheduleImpl = new ArrayList<>();
    final ArrayList<Integer> MyBillsEntityDataFactory = new ArrayList<>();
    final long getErrorConfigVersion = 0;

    abstract void KClassImpl$Data$declaredNonStaticMembers$2();

    abstract int PlaceComponentResult(int i);

    /* renamed from: zipkin2.reporter.BufferNextMessage$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[Encoding.values().length];
            getAuthRequestContext = iArr;
            try {
                iArr[Encoding.JSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                getAuthRequestContext[Encoding.THRIFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                getAuthRequestContext[Encoding.PROTO3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <S> BufferNextMessage<S> MyBillsEntityDataFactory(Encoding encoding, int i) {
        int i2 = AnonymousClass1.getAuthRequestContext[encoding.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return new BufferNextProto3Message(i);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("encoding: ");
                sb.append(encoding);
                throw new UnsupportedOperationException(sb.toString());
            }
            return new BufferNextThriftMessage(i);
        }
        return new BufferNextJsonMessage(i);
    }

    BufferNextMessage(int i, long j) {
        this.BuiltInFictitiousFunctionClassFactory = i;
    }

    /* loaded from: classes9.dex */
    static final class BufferNextJsonMessage<S> extends BufferNextMessage<S> {
        boolean moveToNextValue;

        BufferNextJsonMessage(int i) {
            super(i, 0L);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
            this.moveToNextValue = false;
        }

        @Override // zipkin2.reporter.BufferNextMessage
        final int PlaceComponentResult(int i) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 + i + (this.moveToNextValue ? 1 : 0);
        }

        @Override // zipkin2.reporter.BufferNextMessage
        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            int size = this.MyBillsEntityDataFactory.size();
            this.moveToNextValue = size > 0;
            if (size < 2) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 = 2;
                if (this.moveToNextValue) {
                    this.KClassImpl$Data$declaredNonStaticMembers$2 += this.MyBillsEntityDataFactory.get(0).intValue();
                    return;
                }
                return;
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2 = (size + 2) - 1;
            for (int i = 0; i < size; i++) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 += this.MyBillsEntityDataFactory.get(i).intValue();
            }
        }

        @Override // zipkin2.reporter.BufferNextMessage
        final void getAuthRequestContext(S s, int i) {
            super.getAuthRequestContext(s, i);
            this.moveToNextValue = true;
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferNextThriftMessage<S> extends BufferNextMessage<S> {
        BufferNextThriftMessage(int i) {
            super(i, 0L);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 5;
        }

        @Override // zipkin2.reporter.BufferNextMessage
        final int PlaceComponentResult(int i) {
            return this.KClassImpl$Data$declaredNonStaticMembers$2 + i;
        }

        @Override // zipkin2.reporter.BufferNextMessage
        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 5;
            int size = this.MyBillsEntityDataFactory.size();
            for (int i = 0; i < size; i++) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 += this.MyBillsEntityDataFactory.get(i).intValue();
            }
        }
    }

    /* loaded from: classes9.dex */
    static final class BufferNextProto3Message<S> extends BufferNextMessage<S> {
        BufferNextProto3Message(int i) {
            super(i, 0L);
        }

        @Override // zipkin2.reporter.BufferNextMessage
        final int PlaceComponentResult(int i) {
            int i2 = this.KClassImpl$Data$declaredNonStaticMembers$2 + i;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
            return i2;
        }

        @Override // zipkin2.reporter.BufferNextMessage
        final void KClassImpl$Data$declaredNonStaticMembers$2() {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            int size = this.MyBillsEntityDataFactory.size();
            for (int i = 0; i < size; i++) {
                this.KClassImpl$Data$declaredNonStaticMembers$2 += this.MyBillsEntityDataFactory.get(i).intValue();
            }
        }
    }

    @Override // zipkin2.reporter.SpanWithSizeConsumer
    public final boolean PlaceComponentResult(S s, int i) {
        int PlaceComponentResult = PlaceComponentResult(i);
        int i2 = this.BuiltInFictitiousFunctionClassFactory;
        char c = PlaceComponentResult < i2 ? (char) 65535 : PlaceComponentResult == i2 ? (char) 0 : (char) 1;
        if (c > 0) {
            this.getAuthRequestContext = true;
            return false;
        }
        getAuthRequestContext(s, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = PlaceComponentResult;
        if (c == 0) {
            this.getAuthRequestContext = true;
        }
        return true;
    }

    void getAuthRequestContext(S s, int i) {
        this.scheduleImpl.add(s);
        this.MyBillsEntityDataFactory.add(Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long PlaceComponentResult() {
        if (this.scheduleImpl.isEmpty()) {
            this.PlaceComponentResult = System.nanoTime() + this.getErrorConfigVersion;
        }
        return Math.max(this.PlaceComponentResult - System.nanoTime(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext || PlaceComponentResult() <= 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void PlaceComponentResult(SpanWithSizeConsumer<S> spanWithSizeConsumer) {
        Iterator<S> it = this.scheduleImpl.iterator();
        Iterator<Integer> it2 = this.MyBillsEntityDataFactory.iterator();
        while (it.hasNext()) {
            if (spanWithSizeConsumer.PlaceComponentResult(it.next(), it2.next().intValue())) {
                this.getAuthRequestContext = false;
                it.remove();
                it2.remove();
            }
        }
        KClassImpl$Data$declaredNonStaticMembers$2();
        this.PlaceComponentResult = 0L;
    }
}
