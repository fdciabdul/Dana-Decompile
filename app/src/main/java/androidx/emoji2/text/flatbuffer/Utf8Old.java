package androidx.emoji2.text.flatbuffer;

import j$.util.function.Supplier;
import java.nio.ByteBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;

/* loaded from: classes6.dex */
public class Utf8Old extends Utf8 {
    private static final ThreadLocal<Cache> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Cache {
        CharSequence BuiltInFictitiousFunctionClassFactory = null;
        ByteBuffer PlaceComponentResult = null;
        final CharsetEncoder KClassImpl$Data$declaredNonStaticMembers$2 = StandardCharsets.UTF_8.newEncoder();
        final CharsetDecoder MyBillsEntityDataFactory = StandardCharsets.UTF_8.newDecoder();

        Cache() {
        }
    }

    static {
        final Supplier supplier = new Supplier() { // from class: androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticLambda0
            @Override // j$.util.function.Supplier
            public final Object get() {
                return Utf8Old.BuiltInFictitiousFunctionClassFactory();
            }
        };
        getAuthRequestContext = new ThreadLocal() { // from class: androidx.emoji2.text.flatbuffer.Utf8Old$$ExternalSyntheticThreadLocal1
            @Override // java.lang.ThreadLocal
            protected final /* synthetic */ Object initialValue() {
                return Supplier.this.get();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Cache BuiltInFictitiousFunctionClassFactory() {
        return new Cache();
    }
}
