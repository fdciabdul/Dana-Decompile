package fsimpl;

import com.alipay.mobile.rome.longlinkservice.LongLinkMsgConstants;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class eO {

    /* renamed from: a */
    static boolean f7958a = false;
    private final ArrayDeque b = new ArrayDeque();
    private final long c;
    private final boolean d;
    private final List e;

    public eO(long j, boolean z) {
        this.e = f7958a ? new ArrayList() : null;
        this.c = j;
        this.d = z;
    }

    private void c(Runnable runnable) {
        this.b.addFirst(runnable);
    }

    public void a(Runnable runnable) {
        C0350eu.a(LongLinkMsgConstants.MSG_PACKET_CHANNEL_PUSH, new Object[0]);
        c(runnable);
    }

    public eR b(Runnable runnable) {
        Throwable th;
        long j;
        long j2;
        String str;
        int i;
        int i2;
        if (C0350eu.f7977a) {
            C0350eu.b(SemanticAttributes.MessagingOperationValues.PROCESS, new Object[0]);
            C0350eu.a(this.b.isEmpty(), "The work stack should always be empty at the beginning of `process`", new Object[0]);
        }
        c(runnable);
        eQ eQVar = new eQ(this);
        fb.a(eQVar);
        eQVar.a();
        th = eQVar.b;
        j = eQVar.e;
        j2 = eQVar.d;
        eR eRVar = new eR(th, (j - j2) / 1000);
        if (f7958a) {
            List list = this.e;
            if (list != null) {
                list.add(Long.valueOf(eRVar.b));
                if (this.e.size() > 5) {
                    this.e.remove(0);
                }
                int size = this.e.size();
                long j3 = 0;
                Iterator it = this.e.iterator();
                while (it.hasNext()) {
                    j3 += ((Long) it.next()).longValue();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("; rollingAvg=");
                sb.append(j3 / size);
                sb.append(" μs (last ");
                sb.append(size);
                sb.append(" items)");
                str = sb.toString();
            } else {
                str = "";
            }
            PrintStream printStream = System.out;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Scan time: ");
            sb2.append(eRVar.b);
            sb2.append(" μs; t=");
            sb2.append(eRVar.f7960a);
            sb2.append("; uiThreadCalls=");
            i = eQVar.g;
            sb2.append(i);
            sb2.append("; runnablesProcessed=");
            i2 = eQVar.f;
            sb2.append(i2);
            sb2.append(str);
            printStream.println(sb2.toString());
        }
        this.b.clear();
        return eRVar;
    }
}
