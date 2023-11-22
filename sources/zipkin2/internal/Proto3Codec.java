package zipkin2.internal;

import java.util.Collection;
import java.util.List;
import zipkin2.Span;
import zipkin2.internal.Proto3ZipkinFields;

/* loaded from: classes6.dex */
public final class Proto3Codec {
    public final Proto3SpanWriter KClassImpl$Data$declaredNonStaticMembers$2 = new Proto3SpanWriter();

    public final byte[] getAuthRequestContext(Span span) {
        return Proto3SpanWriter.PlaceComponentResult2(span);
    }

    public final byte[] MyBillsEntityDataFactory(List<Span> list) {
        return Proto3SpanWriter.PlaceComponentResult(list);
    }

    public static boolean MyBillsEntityDataFactory(ReadBuffer readBuffer, Collection<Span> collection) {
        if (readBuffer.available() == 0) {
            return false;
        }
        try {
            Proto3ZipkinFields.SpanField spanField = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
            readBuffer.scheduleImpl();
            int scheduleImpl = readBuffer.scheduleImpl();
            Span MyBillsEntityDataFactory = scheduleImpl == 0 ? null : spanField.MyBillsEntityDataFactory(readBuffer, scheduleImpl);
            if (MyBillsEntityDataFactory == null) {
                return false;
            }
            collection.add(MyBillsEntityDataFactory);
            return true;
        } catch (RuntimeException e) {
            throw PlaceComponentResult("Span", e);
        }
    }

    @Nullable
    public static Span BuiltInFictitiousFunctionClassFactory(ReadBuffer readBuffer) {
        try {
            Proto3ZipkinFields.SpanField spanField = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
            readBuffer.scheduleImpl();
            int scheduleImpl = readBuffer.scheduleImpl();
            return scheduleImpl == 0 ? null : spanField.MyBillsEntityDataFactory(readBuffer, scheduleImpl);
        } catch (RuntimeException e) {
            throw PlaceComponentResult("Span", e);
        }
    }

    public static boolean PlaceComponentResult(ReadBuffer readBuffer, Collection<Span> collection) {
        int available = readBuffer.available();
        if (available == 0) {
            return false;
        }
        while (readBuffer.BuiltInFictitiousFunctionClassFactory() < available) {
            try {
                Proto3ZipkinFields.SpanField spanField = Proto3ZipkinFields.BuiltInFictitiousFunctionClassFactory;
                readBuffer.scheduleImpl();
                int scheduleImpl = readBuffer.scheduleImpl();
                Span MyBillsEntityDataFactory = scheduleImpl == 0 ? null : spanField.MyBillsEntityDataFactory(readBuffer, scheduleImpl);
                if (MyBillsEntityDataFactory == null) {
                    return false;
                }
                collection.add(MyBillsEntityDataFactory);
            } catch (RuntimeException e) {
                throw PlaceComponentResult("List<Span>", e);
            }
        }
        return true;
    }

    private static IllegalArgumentException PlaceComponentResult(String str, Exception exc) {
        String message = exc.getMessage() == null ? "Error" : exc.getMessage();
        if (message.indexOf("Malformed") != -1) {
            message = "Malformed";
        }
        throw new IllegalArgumentException(String.format("%s reading %s from proto3", message, str), exc);
    }
}
