package io.opentelemetry.instrumentation.api.db;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class AutoSqlSanitizer {
    private static final int FROM_TABLE_REF_MAX_IDENTIFIERS = 3;
    private static final int LIMIT = 32768;
    private static final int YYEOF = -1;
    private static final int YYINITIAL = 0;
    private static final String ZZ_ACTION_PACKED_0 = "\u0001\u0000\u0001\u0001\u0001\u0002\u0003\u0001\u0001\u0003\u0001\u0004\u0002\u0001\u0001\u0005\u0001\u0001\u0002\u0006\b\u0007\u0001\u0001\u0001\u0000\u0001\b\u0002\u0000\u0001\u0006\u0001\t\u0001\u0000\u0001\n\u0001\u0000\u0007\u0007\u0001\u0000\u0001\u000b\u0001\u0000\u0001\u0006\b\u0007\u0001\u0006\u0001\u0007\u0001\f\u0001\u0007\u0001\r\u0001\u000e\u0005\u0007\u0001\u000f\u0002\u0007\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013";
    private static final String ZZ_ATTRIBUTE_PACKED_0 = "\u0001\u0000\u0001\t\u0004\u0001\u0002\t\u0002\u0001\u0001\t\f\u0001\u0001\u0000\u0001\u0001\u0002\u0000\u0001\u0001\u0001\t\u0001\u0000\u0001\t\u0001\u0000\u0007\u0001\u0001\u0000\u0001\t\u0001\u0000\t\u0001\u0001\t\u0011\u0001";
    private static final int ZZ_BUFFERSIZE = 2048;
    private static final String ZZ_CMAP_BLOCKS_PACKED_0 = "\t\u0000\u0002\u0001\u0002\u0000\u0001\u0001\u0012\u0000\u0001\u0001\u0001\u0000\u0001\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\b\u0001\n\u0001\u000b\u0001\f\t\r\u0007\u0000\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0015\u0001\u0018\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u001c\u0001\u0015\u0001\u001d\u0001\u001e\u0001\u001f\u0001 \u0002\u0015\u0001!\u0002\u0015\u0004\u0000\u0001\u0015\u0001\"\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0015\u0001\u0016\u0001\u0017\u0001\u0015\u0001\u0018\u0001\u0019\u0001\u001a\u0001\u001b\u0001\u001c\u0001\u0015\u0001\u001d\u0001\u001e\u0001\u001f\u0001 \u0002\u0015\u0001!\u0002\u0015/\u0000\u0001\u0015\n\u0000\u0001\u0015\u0004\u0000\u0001\u0015\u0005\u0000\u0017\u0015\u0001\u0000\u001f\u0015\u0001\u00008\u0015\u0002\u0016M\u0015\u0001\u001eł\u0015\u0004\u0000\f\u0015\u000e\u0000\u0005\u0015\u0007\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0081\u0000\u0005\u0015\u0001\u0000\u0002\u0015\u0002\u0000\u0004\u0015\u0001\u0000\u0001\u0015\u0006\u0000\u0001\u0015\u0001\u0000\u0003\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0014\u0015\u0001\u0000S\u0015\u0001\u0000\u008b\u0015\b\u0000¦\u0015\u0001\u0000&\u0015\u0002\u0000\u0001\u0015\u0006\u0000)\u0015G\u0000\u001b\u0015\u0004\u0000\u0004\u0015-\u0000+\u0015#\u0000\u0002\u0015\u0001\u0000c\u0015\u0001\u0000\u0001\u0015\u000f\u0000\u0002\u0015\u0007\u0000\u0002\u0015\n\u0000\u0003\u0015\u0002\u0000\u0001\u0015\u0010\u0000\u0001\u0015\u0001\u0000\u001e\u0015\u001d\u0000Y\u0015\u000b\u0000\u0001\u0015\u0018\u0000!\u0015\t\u0000\u0002\u0015\u0004\u0000\u0001\u0015\u0005\u0000\u0016\u0015\u0004\u0000\u0001\u0015\t\u0000\u0001\u0015\u0003\u0000\u0001\u0015\u0017\u0000\u0019\u0015\u0007\u0000\u000b\u00155\u0000\u0015\u0015\u0001\u0000\b\u0015F\u00006\u0015\u0003\u0000\u0001\u0015\u0012\u0000\u0001\u0015\u0007\u0000\n\u0015\u000f\u0000\u0010\u0015\u0004\u0000\b\u0015\u0002\u0000\u0002\u0015\u0002\u0000\u0016\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0001\u0015\u0003\u0000\u0004\u0015\u0003\u0000\u0001\u0015\u0010\u0000\u0001\u0015\r\u0000\u0002\u0015\u0001\u0000\u0003\u0015\u000e\u0000\u0002\u0015\n\u0000\u0001\u0015\b\u0000\u0006\u0015\u0004\u0000\u0002\u0015\u0002\u0000\u0016\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0002\u0015\u001f\u0000\u0004\u0015\u0001\u0000\u0001\u0015\u0013\u0000\u0003\u0015\u0010\u0000\t\u0015\u0001\u0000\u0003\u0015\u0001\u0000\u0016\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0005\u0015\u0003\u0000\u0001\u0015\u0012\u0000\u0001\u0015\u000f\u0000\u0002\u0015\u0017\u0000\u0001\u0015\u000b\u0000\b\u0015\u0002\u0000\u0002\u0015\u0002\u0000\u0016\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0005\u0015\u0003\u0000\u0001\u0015\u001e\u0000\u0002\u0015\u0001\u0000\u0003\u0015\u000f\u0000\u0001\u0015\u0011\u0000\u0001\u0015\u0001\u0000\u0006\u0015\u0003\u0000\u0003\u0015\u0001\u0000\u0004\u0015\u0003\u0000\u0002\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0002\u0015\u0003\u0000\u0002\u0015\u0003\u0000\u0003\u0015\u0003\u0000\f\u0015\u0016\u0000\u0001\u00154\u0000\b\u0015\u0001\u0000\u0003\u0015\u0001\u0000\u0017\u0015\u0001\u0000\u0010\u0015\u0003\u0000\u0001\u0015\u001a\u0000\u0003\u0015\u0005\u0000\u0002\u0015\u001e\u0000\u0001\u0015\u0004\u0000\b\u0015\u0001\u0000\u0003\u0015\u0001\u0000\u0017\u0015\u0001\u0000\n\u0015\u0001\u0000\u0005\u0015\u0003\u0000\u0001\u0015 \u0000\u0001\u0015\u0001\u0000\u0002\u0015\u000f\u0000\u0002\u0015\u0012\u0000\b\u0015\u0001\u0000\u0003\u0015\u0001\u0000)\u0015\u0002\u0000\u0001\u0015\u0010\u0000\u0001\u0015\u0005\u0000\u0003\u0015\b\u0000\u0003\u0015\u0018\u0000\u0006\u0015\u0005\u0000\u0012\u0015\u0003\u0000\u0018\u0015\u0001\u0000\t\u0015\u0001\u0000\u0001\u0015\u0002\u0000\u0007\u0015:\u00000\u0015\u0001\u0000\u0002\u0015\f\u0000\u0007\u0015:\u0000\u0002\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0005\u0015\u0001\u0000\u0018\u0015\u0001\u0000\u0001\u0015\u0001\u0000\n\u0015\u0001\u0000\u0002\u0015\t\u0000\u0001\u0015\u0002\u0000\u0005\u0015\u0001\u0000\u0001\u0015\u0015\u0000\u0004\u0015 \u0000\u0001\u0015?\u0000\b\u0015\u0001\u0000$\u0015\u001b\u0000\u0005\u0015s\u0000+\u0015\u0014\u0000\u0001\u0015\u0010\u0000\u0006\u0015\u0004\u0000\u0004\u0015\u0003\u0000\u0001\u0015\u0003\u0000\u0002\u0015\u0007\u0000\u0003\u0015\u0004\u0000\r\u0015\f\u0000\u0001\u0015\u0011\u0000&\u0015\u0001\u0000\u0001\u0015\u0005\u0000\u0001\u0015\u0002\u0000+\u0015\u0001\u0000ō\u0015\u0001\u0000\u0004\u0015\u0002\u0000\u0007\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0004\u0015\u0002\u0000)\u0015\u0001\u0000\u0004\u0015\u0002\u0000!\u0015\u0001\u0000\u0004\u0015\u0002\u0000\u0007\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0004\u0015\u0002\u0000\u000f\u0015\u0001\u00009\u0015\u0001\u0000\u0004\u0015\u0002\u0000C\u0015%\u0000\u0010\u0015\u0010\u0000V\u0015\u0002\u0000\u0006\u0015\u0003\u0000Ŭ\u0015\u0002\u0000\u0011\u0015\u0001\u0000\u001a\u0015\u0005\u0000K\u0015\u0006\u0000\b\u0015\u0007\u0000\r\u0015\u0001\u0000\u0004\u0015\u000e\u0000\u0012\u0015\u000e\u0000\u0012\u0015\u000e\u0000\r\u0015\u0001\u0000\u0003\u0015\u000f\u00004\u0015#\u0000\u0001\u0015\u0004\u0000\u0001\u0015C\u0000Y\u0015\u0007\u0000\u0005\u0015\u0002\u0000\"\u0015\u0001\u0000\u0001\u0015\u0005\u0000F\u0015\n\u0000\u001f\u00151\u0000\u001e\u0015\u0002\u0000\u0005\u0015\u000b\u0000,\u0015\u0004\u0000\u001a\u00156\u0000\u0017\u0015\t\u00005\u0015R\u0000\u0001\u0015]\u0000/\u0015\u0011\u0000\u0007\u00157\u0000\u001e\u0015\r\u0000\u0002\u0015\n\u0000,\u0015\u001a\u0000$\u0015)\u0000\u0003\u0015\n\u0000$\u0015\u0002\u0000\t\u0015\u0007\u0000+\u0015\u0002\u0000\u0003\u0015)\u0000\u0004\u0015\u0001\u0000\u0006\u0015\u0001\u0000\u0002\u0015\u0003\u0000\u0001\u0015\u0005\u0000À\u0015@\u0000\u0016\u0015\u0002\u0000\u0006\u0015\u0002\u0000&\u0015\u0002\u0000\u0006\u0015\u0002\u0000\b\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u001f\u0015\u0002\u00005\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0001\u0015\u0003\u0000\u0003\u0015\u0001\u0000\u0007\u0015\u0003\u0000\u0004\u0015\u0002\u0000\u0006\u0015\u0004\u0000\r\u0015\u0005\u0000\u0003\u0015\u0001\u0000\u0007\u0015t\u0000\u0001\u0015\r\u0000\u0001\u0015\u0010\u0000\r\u0015e\u0000\u0001\u0015\u0004\u0000\u0001\u0015\u0002\u0000\n\u0015\u0001\u0000\u0001\u0015\u0003\u0000\u0005\u0015\u0006\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0004\u0015\u0001\u0000\u000b\u0015\u0002\u0000\u0004\u0015\u0005\u0000\u0005\u0015\u0004\u0000\u0001\u00154\u0000\u0002\u0015Ż\u0000/\u0015\u0001\u0000/\u0015\u0001\u0000\u0085\u0015\u0006\u0000\u0004\u0015\u0003\u0000\u0002\u0015\f\u0000&\u0015\u0001\u0000\u0001\u0015\u0005\u0000\u0001\u0015\u0002\u00008\u0015\u0007\u0000\u0001\u0015\u0010\u0000\u0017\u0015\t\u0000\u0007\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0007\u0015P\u0000\u0001\u0015Õ\u0000\u0002\u0015*\u0000\u0005\u0015\u0005\u0000\u0002\u0015\u0004\u0000V\u0015\u0006\u0000\u0003\u0015\u0001\u0000Z\u0015\u0001\u0000\u0004\u0015\u0005\u0000+\u0015\u0001\u0000^\u0015\u0011\u0000\u001b\u00155\u0000Æ\u0015J\u0000ð\u0015\u0010\u0000\u008d\u0015C\u0000.\u0015\u0002\u0000\r\u0015\u0003\u0000\u0010\u0015\n\u0000\u0002\u0015\u0014\u0000/\u0015\u0010\u0000\u001f\u0015\u0002\u0000F\u00151\u0000\t\u0015\u0002\u0000g\u0015\u0002\u00005\u0015\u0002\u0000\u0005\u00150\u0000\u000b\u0015\u0001\u0000\u0003\u0015\u0001\u0000\u0004\u0015\u0001\u0000\u0017\u0015\u001d\u00004\u0015\u000e\u00002\u0015>\u0000\u0006\u0015\u0003\u0000\u0001\u0015\u0001\u0000\u0002\u0015\u000b\u0000\u001c\u0015\n\u0000\u0017\u0015\u0019\u0000\u001d\u0015\u0007\u0000/\u0015\u001c\u0000\u0001\u0015\u0010\u0000\u0005\u0015\u0001\u0000\n\u0015\n\u0000\u0005\u0015\u0001\u0000)\u0015\u0017\u0000\u0003\u0015\u0001\u0000\b\u0015\u0014\u0000\u0017\u0015\u0003\u0000\u0001\u0015\u0003\u00002\u0015\u0001\u0000\u0001\u0015\u0003\u0000\u0002\u0015\u0002\u0000\u0005\u0015\u0002\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0018\u0000\u0003\u0015\u0002\u0000\u000b\u0015\u0007\u0000\u0003\u0015\f\u0000\u0006\u0015\u0002\u0000\u0006\u0015\u0002\u0000\u0006\u0015\t\u0000\u0007\u0015\u0001\u0000\u0007\u0015\u0001\u0000+\u0015\u0001\u0000\f\u0015\b\u0000s\u0015\u001d\u0000¤\u0015\f\u0000\u0017\u0015\u0004\u00001\u0015\u0004\u0000n\u0015\u0002\u0000j\u0015&\u0000\u0007\u0015\f\u0000\u0005\u0015\u0005\u0000\u0001\u0015\u0001\u0000\n\u0015\u0001\u0000\r\u0015\u0001\u0000\u0005\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0002\u0015\u0001\u0000l\u0015!\u0000k\u0015\u0012\u0000@\u0015\u0002\u00006\u0015(\u0000\f\u0015t\u0000\u0005\u0015\u0001\u0000\u0087\u0015$\u0000\u001a\u0015\u0006\u0000\u001a\u0015\u000b\u0000Y\u0015\u0003\u0000\u0006\u0015\u0002\u0000\u0006\u0015\u0002\u0000\u0006\u0015\u0002\u0000\u0003\u0015#\u0000\f\u0015\u0001\u0000\u001a\u0015\u0001\u0000\u0013\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u000f\u0015\u0002\u0000\u000e\u0015\"\u0000{\u0015\u0085\u0000\u001d\u0015\u0003\u00001\u0015/\u0000 \u0015\r\u0000\u0014\u0015\u0001\u0000\b\u0015\u0006\u0000&\u0015\n\u0000\u001e\u0015\u0002\u0000$\u0015\u0004\u0000\b\u00150\u0000\u009e\u0015\u0012\u0000$\u0015\u0004\u0000$\u0015\u0004\u0000(\u0015\b\u00004\u0015\u009c\u00007\u0015\t\u0000\u0016\u0015\n\u0000\b\u0015\u0098\u0000\u0006\u0015\u0002\u0000\u0001\u0015\u0001\u0000,\u0015\u0001\u0000\u0002\u0015\u0003\u0000\u0001\u0015\u0002\u0000\u0017\u0015\n\u0000\u0017\u0015\t\u0000\u001f\u0015A\u0000\u0013\u0015\u0001\u0000\u0002\u0015\n\u0000\u0016\u0015\n\u0000\u001a\u0015F\u00008\u0015\u0006\u0000\u0002\u0015@\u0000\u0001\u0015\u000f\u0000\u0004\u0015\u0001\u0000\u0003\u0015\u0001\u0000\u001d\u0015*\u0000\u001d\u0015\u0003\u0000\u001d\u0015#\u0000\b\u0015\u0001\u0000\u001c\u0015\u001b\u00006\u0015\n\u0000\u0016\u0015\n\u0000\u0013\u0015\r\u0000\u0012\u0015n\u0000I\u00157\u00003\u0015\r\u00003\u0015\r\u0000$\u0015Ü\u0000\u001d\u0015\n\u0000\u0001\u0015\b\u0000\u0016\u0015\u009a\u0000\u0017\u0015\f\u00005\u0015K\u0000-\u0015 \u0000\u0019\u0015\u001a\u0000$\u0015\u001d\u0000\u0001\u0015\u000b\u0000#\u0015\u0003\u0000\u0001\u0015\f\u00000\u0015\u000e\u0000\u0004\u0015\u0015\u0000\u0001\u0015\u0001\u0000\u0001\u0015#\u0000\u0012\u0015\u0001\u0000\u0019\u0015T\u0000\u0007\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0004\u0015\u0001\u0000\u000f\u0015\u0001\u0000\n\u0015\u0007\u0000/\u0015&\u0000\b\u0015\u0002\u0000\u0002\u0015\u0002\u0000\u0016\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0005\u0015\u0003\u0000\u0001\u0015\u0012\u0000\u0001\u0015\f\u0000\u0005\u0015\u009e\u00005\u0015\u0012\u0000\u0004\u0015\u0014\u0000\u0001\u0015 \u00000\u0015\u0014\u0000\u0002\u0015\u0001\u0000\u0001\u0015¸\u0000/\u0015)\u0000\u0004\u0015$\u00000\u0015\u0014\u0000\u0001\u0015;\u0000+\u0015\r\u0000\u0001\u0015G\u0000\u001b\u0015å\u0000,\u0015t\u0000@\u0015\u001f\u0000\u0001\u0015 \u0000\b\u0015\u0002\u0000'\u0015\u0010\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u001c\u0000\u0001\u0015\n\u0000(\u0015\u0007\u0000\u0001\u0015\u0015\u0000\u0001\u0015\u000b\u0000.\u0015\u0013\u0000\u0001\u0015\"\u00009\u0015\u0007\u0000\t\u0015\u0001\u0000%\u0015\u0011\u0000\u0001\u00151\u0000\u001e\u0015p\u0000\u0007\u0015\u0001\u0000\u0002\u0015\u0001\u0000&\u0015\u0015\u0000\u0001\u0015\u0019\u0000\u0006\u0015\u0001\u0000\u0002\u0015\u0001\u0000 \u0015\u000e\u0000\u0001\u0015Ň\u0000\u0013\u0015\r\u0000\u009a\u0015æ\u0000Ä\u0015¼\u0000/\u0015Ñ\u0000G\u0015¹\u00009\u0015\u0007\u0000\u001f\u0015q\u0000\u001e\u0015\u0012\u00000\u0015\u0010\u0000\u0004\u0015\u001f\u0000\u0015\u0015\u0005\u0000\u0013\u0015°\u0000@\u0015\u0080\u0000K\u0015\u0005\u0000\u0001\u0015B\u0000\r\u0015@\u0000\u0002\u0015\u0001\u0000\u0001\u0015\u001c\u0000ø\u0015\b\u0000ó\u0015\r\u0000\u001f\u00151\u0000\u0003\u0015\u0011\u0000\u0004\u0015\b\u0000ƌ\u0015\u0004\u0000k\u0015\u0005\u0000\r\u0015\u0003\u0000\t\u0015\u0007\u0000\n\u0015f\u0000U\u0015\u0001\u0000G\u0015\u0001\u0000\u0002\u0015\u0002\u0000\u0001\u0015\u0002\u0000\u0002\u0015\u0002\u0000\u0004\u0015\u0001\u0000\f\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0007\u0015\u0001\u0000A\u0015\u0001\u0000\u0004\u0015\u0002\u0000\b\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u001c\u0015\u0001\u0000\u0004\u0015\u0001\u0000\u0005\u0015\u0001\u0000\u0001\u0015\u0003\u0000\u0007\u0015\u0001\u0000Ŕ\u0015\u0002\u0000\u0019\u0015\u0001\u0000\u0019\u0015\u0001\u0000\u001f\u0015\u0001\u0000\u0019\u0015\u0001\u0000\u001f\u0015\u0001\u0000\u0019\u0015\u0001\u0000\u001f\u0015\u0001\u0000\u0019\u0015\u0001\u0000\u001f\u0015\u0001\u0000\u0019\u0015\u0001\u0000\b\u00154\u0000-\u0015\n\u0000\u0007\u0015\u0010\u0000\u0001\u0015ű\u0000,\u0015\u0014\u0000Å\u0015;\u0000D\u0015\u0007\u0000\u0001\u0015´\u0000\u0004\u0015\u0001\u0000\u001b\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0001\u0015\u0002\u0000\u0001\u0015\u0001\u0000\n\u0015\u0001\u0000\u0004\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0006\u0000\u0001\u0015\u0004\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0003\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0001\u0015\u0002\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0001\u0000\u0002\u0015\u0001\u0000\u0001\u0015\u0002\u0000\u0004\u0015\u0001\u0000\u0007\u0015\u0001\u0000\u0004\u0015\u0001\u0000\u0004\u0015\u0001\u0000\u0001\u0015\u0001\u0000\n\u0015\u0001\u0000\u0011\u0015\u0005\u0000\u0003\u0015\u0001\u0000\u0005\u0015\u0001\u0000\u0011\u0015D\u0000×\u0015)\u00005\u0015\u000b\u0000Þ\u0015\u0002\u0000Ƃ\u0015\u000e\u0000ı\u0015\u001f\u0000\u001e\u0015â\u0000";
    private static final String ZZ_CMAP_TOP_PACKED_0 = "\u0001\u0000\u0001Ā\u0001Ȁ\u0001̀\u0001Ѐ\u0001Ԁ\u0001\u0600\u0001܀\u0001ࠀ\u0001ऀ\u0001\u0a00\u0001\u0b00\u0001ఀ\u0001ഀ\u0001\u0e00\u0001ༀ\u0001က\u0001ᄀ\u0001ሀ\u0001ጀ\u0001᐀\u0001ᄀ\u0001ᔀ\u0001ᘀ\u0001ᜀ\u0001᠀\u0001ᤀ\u0001ᨀ\u0001ᬀ\u0001ᰀ\u0001ᄀ\u0001ᴀ\u0001Ḁ\u0001ἀ\n\u2000\u0001℀\u0001∀\u0001⌀\u0001\u2000\u0001␀\u0001─\u0002\u2000\u0019ᄀ\u0001☀Qᄀ\u0001✀\u0004ᄀ\u0001⠀\u0001ᄀ\u0001⤀\u0001⨀\u0001⬀\u0001Ⰰ\u0001ⴀ\u0001⸀+ᄀ\u0001⼀!\u2000\u0001ᄀ\u0001\u3000\u0001\u3100\u0001ᄀ\u0001㈀\u0001㌀\u0001㐀\u0001㔀\u0001\u2000\u0001㘀\u0001㜀\u0001㠀\u0001㤀\u0001ᄀ\u0001㨀\u0001㬀\u0001㰀\u0001㴀\u0001㸀\u0001㼀\u0001䀀\u0001\u2000\u0001䄀\u0001䈀\u0001䌀\u0001䐀\u0001䔀\u0001䘀\u0001䜀\u0001䠀\u0001䤀\u0001䨀\u0001䬀\u0001䰀\u0001\u2000\u0001䴀\u0001一\u0001伀\u0001\u2000\u0003ᄀ\u0001倀\u0001儀\u0001刀\n\u2000\u0004ᄀ\u0001匀\u000f\u2000\u0002ᄀ\u0001吀!\u2000\u0002ᄀ\u0001唀\u0001嘀\u0002\u2000\u0001圀\u0001堀\u0017ᄀ\u0001夀\u0002ᄀ\u0001娀%\u2000\u0001ᄀ\u0001嬀\u0001尀\t\u2000\u0001崀\u0017\u2000\u0001帀\u0001开\u0001怀\u0001愀\t\u2000\u0001戀\u0001挀\u0005\u2000\u0001搀\u0001攀\u0004\u2000\u0001昀\u0011\u2000¦ᄀ\u0001最\u0010ᄀ\u0001栀\u0001椀\u0015ᄀ\u0001樀\u001cᄀ\u0001欀\f\u2000\u0002ᄀ\u0001氀ฅ\u2000";
    private static final int ZZ_NO_MATCH = 1;
    private static final int ZZ_PUSHBACK_2BIG = 2;
    private static final String ZZ_ROWMAP_PACKED_0 = "\u0000\u0000\u0000#\u0000F\u0000i\u0000\u008c\u0000¯\u0000#\u0000#\u0000Ò\u0000õ\u0000#\u0000Ę\u0000Ļ\u0000Ş\u0000Ɓ\u0000Ƥ\u0000Ǉ\u0000Ǫ\u0000ȍ\u0000Ȱ\u0000ɓ\u0000ɶ\u0000ʙ\u0000i\u0000ʼ\u0000˟\u0000¯\u0000̂\u0000#\u0000õ\u0000#\u0000̥\u0000͈\u0000ͫ\u0000Ύ\u0000α\u0000ϔ\u0000Ϸ\u0000К\u0000ʙ\u0000#\u0000н\u0000̥\u0000Ѡ\u0000҃\u0000Ҧ\u0000Ӊ\u0000Ӭ\u0000ԏ\u0000Բ\u0000Օ\u0000#\u0000ո\u0000Ɓ\u0000֛\u0000Ɓ\u0000Ɓ\u0000־\u0000ס\u0000\u0604\u0000ا\u0000ي\u0000Ɓ\u0000٭\u0000ڐ\u0000Ɓ\u0000Ɓ\u0000Ɓ\u0000Ɓ";
    private static final String ZZ_TRANS_PACKED_0 = "\u0001\u0002\u0001\u0003\u0001\u0004\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\n\u0001\f\u0001\r\u0001\u000e\u0003\u000f\u0001\u0010\u0001\u000f\u0001\u0011\u0002\u000f\u0001\u0012\u0001\u0013\u0001\u000f\u0001\u0014\u0004\u000f\u0001\u0015\u0001\u000f\u0001\u0016\u0001\u000f\u0001\u0017$\u0000\u0001\u0003!\u0000\u0002\u0018\u0001\u0019 \u0018\u0003\u0000\u0001\u001a\u001f\u0000\u0004\u001b\u0001\u001c\u001e\u001b\u000b\u0000\u0001\u001d\u001f\u0000\u0001\u001e\u0001\u0000\u0001\u001e\u0001\u0000\u0002\u000e\u001c\u0000\u0001\u001f#\u0000\u0001\u000e\u0001\u0000\u0001\u000e\u0001\u0000\u0002\u000e\u0004\u0000\u0001\u000e\u000e\u0000\u0001 \t\u0000\u0001\u000e\u0001\u0000\u0001\u000e\u0001\u0000\u0002\u000e\u0004\u0000\u0001\u000e\u001a\u0000\u0001\u000f\u0001\u0000\u0016\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u0001!\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0011\u000f\u0001\"\u0004\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u000e\u000f\u0001#\u0007\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u000f\u000f\u0001$\u0006\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u0001%\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u0001&\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0010\u000f\u0001'\u0005\u000f\u0001\u0000\"(\u0001)\u0002\u0000\u0001\u0018 \u0000\u0003\u001a\u0001*\u001f\u001a\u0004\u0000\u0001\u001b*\u0000\b+\u0019\u0000\u0001\u000f\u0001\u0000\f\u000f\u0001,\t\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u000f\u000f\u0001-\u0006\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0012\u000f\u0001.\u0001/\u0002\u000f\u000b\u0000\u0001\u000f\u0001\u0000\n\u000f\u00010\u000b\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0011\u000f\u00011\u0004\u000f\u000b\u0000\u0001\u000f\u0001\u0000\f\u000f\u00012\t\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0005\u000f\u00013\u0010\u000f\u0004\u0000\u00014)\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u00015\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\r\u000f\u00016\b\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u00017\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u000f\u000f\u00018\u0006\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u000e\u000f\u00019\u0007\u000f\u000b\u0000\u0001\u000f\u0001\u0000\b\u000f\u0001:\r\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u0001;\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0002\u000f\u0001<\u0013\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0013\u000f\u0001=\u0002\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0011\u000f\u0001>\u0004\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u0001?\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0004\u000f\u0001@\u0011\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0013\u000f\u0001A\u0002\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u0001B\u000f\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0013\u000f\u0001C\u0002\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0013\u000f\u0001D\u0002\u000f\u000b\u0000\u0001\u000f\u0001\u0000\u0006\u000f\u0001E\u000f\u000f\u0001\u0000";
    private static final int ZZ_UNKNOWN_ERROR = 0;
    private SqlDialect dialect;
    private long yychar;
    private int yycolumn;
    private int yyline;
    private boolean zzAtEOF;
    private int zzCurrentPos;
    private boolean zzEOFDone;
    private int zzEndRead;
    private int zzMarkedPos;
    private Reader zzReader;
    private int zzStartRead;
    private int zzState;
    private static final int[] ZZ_LEXSTATE = {0, 0};
    private static final int[] ZZ_CMAP_TOP = zzUnpackcmap_top();
    private static final int[] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();
    private static final int[] ZZ_ACTION = zzUnpackAction();
    private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
    private static final int[] ZZ_TRANS = zzUnpackTrans();
    private static final String[] ZZ_ERROR_MSG = {"Unknown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
    private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
    private int zzLexicalState = 0;
    private char[] zzBuffer = new char[ZZ_BUFFERSIZE];
    private int zzFinalHighSurrogate = 0;
    private boolean zzAtBOL = true;
    private final StringBuilder builder = new StringBuilder();
    private int parenLevel = 0;
    private boolean insideComment = false;
    private Operation operation = NoOp.INSTANCE;
    private boolean extractionDone = false;

    private static int[] zzUnpackcmap_top() {
        int[] iArr = new int[4352];
        zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, 0, iArr);
        return iArr;
    }

    private static int zzUnpackcmap_top(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            char charAt2 = str.charAt(i4);
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i4 + 1;
            i = i2;
        }
        return i;
    }

    private static int[] zzUnpackcmap_blocks() {
        int[] iArr = new int[27904];
        zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, 0, iArr);
        return iArr;
    }

    private static int zzUnpackcmap_blocks(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            char charAt2 = str.charAt(i4);
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i4 + 1;
            i = i2;
        }
        return i;
    }

    private static int[] zzUnpackAction() {
        int[] iArr = new int[69];
        zzUnpackAction(ZZ_ACTION_PACKED_0, 0, iArr);
        return iArr;
    }

    private static int zzUnpackAction(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            char charAt2 = str.charAt(i4);
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i4 + 1;
            i = i2;
        }
        return i;
    }

    private static int[] zzUnpackRowMap() {
        int[] iArr = new int[69];
        zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, 0, iArr);
        return iArr;
    }

    private static int zzUnpackRowMap(String str, int i, int[] iArr) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            iArr[i] = (str.charAt(i2) << 16) | str.charAt(i3);
            i++;
            i2 = i3 + 1;
        }
        return i;
    }

    private static int[] zzUnpackTrans() {
        int[] iArr = new int[1715];
        zzUnpackTrans(ZZ_TRANS_PACKED_0, 0, iArr);
        return iArr;
    }

    private static int zzUnpackTrans(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            char charAt2 = str.charAt(i4);
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2 - 1;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i4 + 1;
            i = i2;
        }
        return i;
    }

    private static int[] zzUnpackAttribute() {
        int[] iArr = new int[69];
        zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, 0, iArr);
        return iArr;
    }

    private static int zzUnpackAttribute(String str, int i, int[] iArr) {
        int i2;
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            int charAt = str.charAt(i3);
            char charAt2 = str.charAt(i4);
            while (true) {
                i2 = i + 1;
                iArr[i] = charAt2;
                charAt--;
                if (charAt <= 0) {
                    break;
                }
                i = i2;
            }
            i3 = i4 + 1;
            i = i2;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SqlStatementInfo sanitize(String str, SqlDialect sqlDialect) {
        AutoSqlSanitizer autoSqlSanitizer = new AutoSqlSanitizer(new StringReader(str));
        autoSqlSanitizer.dialect = sqlDialect;
        while (!autoSqlSanitizer.yyatEOF() && autoSqlSanitizer.yylex() != -1) {
            try {
            } catch (IOException unused) {
                return SqlStatementInfo.create(null, null, null);
            }
        }
        return autoSqlSanitizer.getResult();
    }

    private void appendCurrentFragment() {
        StringBuilder sb = this.builder;
        char[] cArr = this.zzBuffer;
        int i = this.zzStartRead;
        sb.append(cArr, i, this.zzMarkedPos - i);
    }

    private boolean isOverLimit() {
        return this.builder.length() > LIMIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String readTableName() {
        String yytext = yytext();
        return yytext != null ? ((yytext.startsWith("\"") && yytext.endsWith("\"")) || (yytext.startsWith("`") && yytext.endsWith("`"))) ? yytext.substring(1, yytext.length() - 1) : yytext : yytext;
    }

    private void setOperation(Operation operation) {
        if (this.operation == NoOp.INSTANCE) {
            this.operation = operation;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static abstract class Operation {
        String mainTable;

        boolean handleComma() {
            return false;
        }

        boolean handleFrom() {
            return false;
        }

        boolean handleIdentifier() {
            return false;
        }

        boolean handleInto() {
            return false;
        }

        boolean handleJoin() {
            return false;
        }

        private Operation() {
            this.mainTable = null;
        }

        SqlStatementInfo getResult(String str) {
            return SqlStatementInfo.create(str, getClass().getSimpleName().toUpperCase(Locale.ROOT), this.mainTable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class NoOp extends Operation {
        static final Operation INSTANCE = new NoOp();

        private NoOp() {
            super();
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        SqlStatementInfo getResult(String str) {
            return SqlStatementInfo.create(str, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class Select extends Operation {
        private static final int FROM_TABLE_REF_MAX_IDENTIFIERS = 3;
        boolean expectingTableName;
        int identifiersAfterMainFromClause;
        boolean mainTableSetAlready;

        private Select() {
            super();
            this.expectingTableName = false;
            this.mainTableSetAlready = false;
            this.identifiersAfterMainFromClause = 0;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleFrom() {
            if (AutoSqlSanitizer.this.parenLevel == 0) {
                this.expectingTableName = true;
                return false;
            }
            this.mainTable = null;
            return true;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleJoin() {
            this.mainTable = null;
            return true;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleIdentifier() {
            int i = this.identifiersAfterMainFromClause;
            if (i > 0) {
                this.identifiersAfterMainFromClause = i + 1;
            }
            if (this.expectingTableName) {
                if (AutoSqlSanitizer.this.parenLevel != 0) {
                    this.mainTable = null;
                    return true;
                } else if (!this.mainTableSetAlready) {
                    this.mainTable = AutoSqlSanitizer.this.readTableName();
                    this.mainTableSetAlready = true;
                    this.expectingTableName = false;
                    this.identifiersAfterMainFromClause = 1;
                    return false;
                } else {
                    this.mainTable = null;
                    return true;
                }
            }
            return false;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleComma() {
            int i = this.identifiersAfterMainFromClause;
            if (i <= 0 || i > 3) {
                return false;
            }
            this.mainTable = null;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class Insert extends Operation {
        boolean expectingTableName;

        private Insert() {
            super();
            this.expectingTableName = false;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleInto() {
            this.expectingTableName = true;
            return false;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleIdentifier() {
            if (this.expectingTableName) {
                this.mainTable = AutoSqlSanitizer.this.readTableName();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class Delete extends Operation {
        boolean expectingTableName;

        private Delete() {
            super();
            this.expectingTableName = false;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleFrom() {
            this.expectingTableName = true;
            return false;
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleIdentifier() {
            if (this.expectingTableName) {
                this.mainTable = AutoSqlSanitizer.this.readTableName();
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class Update extends Operation {
        private Update() {
            super();
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleIdentifier() {
            this.mainTable = AutoSqlSanitizer.this.readTableName();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class Merge extends Operation {
        private Merge() {
            super();
        }

        @Override // io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.Operation
        boolean handleIdentifier() {
            this.mainTable = AutoSqlSanitizer.this.readTableName();
            return true;
        }
    }

    private SqlStatementInfo getResult() {
        if (this.builder.length() > LIMIT) {
            StringBuilder sb = this.builder;
            sb.delete(LIMIT, sb.length());
        }
        return this.operation.getResult(this.builder.toString());
    }

    AutoSqlSanitizer(Reader reader) {
        this.zzReader = reader;
    }

    private static int zzCMap(int i) {
        int i2 = i & 255;
        return i2 == i ? ZZ_CMAP_BLOCKS[i2] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[i >> 8] | i2];
    }

    private boolean zzRefill() throws IOException {
        int i = this.zzStartRead;
        if (i > 0) {
            int i2 = this.zzEndRead + this.zzFinalHighSurrogate;
            this.zzEndRead = i2;
            this.zzFinalHighSurrogate = 0;
            char[] cArr = this.zzBuffer;
            System.arraycopy(cArr, i, cArr, 0, i2 - i);
            int i3 = this.zzEndRead;
            int i4 = this.zzStartRead;
            this.zzEndRead = i3 - i4;
            this.zzCurrentPos -= i4;
            this.zzMarkedPos -= i4;
            this.zzStartRead = 0;
        }
        int i5 = this.zzCurrentPos;
        char[] cArr2 = this.zzBuffer;
        if (i5 >= cArr2.length - this.zzFinalHighSurrogate) {
            char[] cArr3 = new char[cArr2.length * 2];
            System.arraycopy(cArr2, 0, cArr3, 0, cArr2.length);
            this.zzBuffer = cArr3;
            this.zzEndRead += this.zzFinalHighSurrogate;
            this.zzFinalHighSurrogate = 0;
        }
        char[] cArr4 = this.zzBuffer;
        int length = cArr4.length;
        int i6 = this.zzEndRead;
        int i7 = length - i6;
        int read = this.zzReader.read(cArr4, i6, i7);
        if (read != 0) {
            if (read > 0) {
                int i8 = this.zzEndRead + read;
                this.zzEndRead = i8;
                if (Character.isHighSurrogate(this.zzBuffer[i8 - 1])) {
                    if (read == i7) {
                        this.zzEndRead--;
                        this.zzFinalHighSurrogate = 1;
                    } else {
                        int read2 = this.zzReader.read();
                        if (read2 == -1) {
                            return true;
                        }
                        char[] cArr5 = this.zzBuffer;
                        int i9 = this.zzEndRead;
                        this.zzEndRead = i9 + 1;
                        cArr5[i9] = (char) read2;
                    }
                }
                return false;
            }
            return true;
        }
        throw new IOException("Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
    }

    private final void yyclose() throws IOException {
        this.zzAtEOF = true;
        this.zzEndRead = this.zzStartRead;
        Reader reader = this.zzReader;
        if (reader != null) {
            reader.close();
        }
    }

    private final void yyreset(Reader reader) {
        this.zzReader = reader;
        this.zzEOFDone = false;
        yyResetPosition();
        this.zzLexicalState = 0;
        if (this.zzBuffer.length > ZZ_BUFFERSIZE) {
            this.zzBuffer = new char[ZZ_BUFFERSIZE];
        }
    }

    private final void yyResetPosition() {
        this.zzAtBOL = true;
        this.zzAtEOF = false;
        this.zzCurrentPos = 0;
        this.zzMarkedPos = 0;
        this.zzStartRead = 0;
        this.zzEndRead = 0;
        this.zzFinalHighSurrogate = 0;
        this.yyline = 0;
        this.yycolumn = 0;
        this.yychar = 0L;
    }

    private final boolean yyatEOF() {
        return this.zzAtEOF;
    }

    private final int yystate() {
        return this.zzLexicalState;
    }

    private final void yybegin(int i) {
        this.zzLexicalState = i;
    }

    private final String yytext() {
        char[] cArr = this.zzBuffer;
        int i = this.zzStartRead;
        return new String(cArr, i, this.zzMarkedPos - i);
    }

    private final char yycharat(int i) {
        return this.zzBuffer[this.zzStartRead + i];
    }

    private final int yylength() {
        return this.zzMarkedPos - this.zzStartRead;
    }

    private static void zzScanError(int i) {
        String str;
        try {
            str = ZZ_ERROR_MSG[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            str = ZZ_ERROR_MSG[0];
        }
        throw new Error(str);
    }

    private void yypushback(int i) {
        if (i > yylength()) {
            zzScanError(2);
        }
        this.zzMarkedPos -= i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
    
        r11 = -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int yylex() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.db.AutoSqlSanitizer.yylex():int");
    }
}
