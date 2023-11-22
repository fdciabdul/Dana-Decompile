package id.dana.cashier.domain.model;

import id.dana.cashier.domain.model.paylater.DanaCredit;
import id.dana.cashier.domain.model.paylater.LoanCreditChannelInfo;
import id.dana.cashier.domain.model.paylater.RepaymentPlan;
import id.dana.data.config.model.PayLaterMethodConfig;
import id.dana.domain.model.cashier.PayMethodRisk;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.domain.payasset.model.AmountRange;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bt\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0003\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010H\u001a\u0004\u0018\u00010%\u0012\b\u0010I\u001a\u0004\u0018\u00010%\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010R\u001a\u0004\u0018\u00010\n\u0012\b\u0010S\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010V\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010Y\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010Z\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010[\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010]\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010^\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f\u0012\u000e\u0010a\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001f\u0012\b\u0010b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010i\u001a\u0004\u0018\u000100\u0012\f\u0010j\u001a\b\u0012\u0004\u0012\u0002030\u001f\u0012\n\b\u0002\u0010k\u001a\u0004\u0018\u000105\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u000108\u0012\u000e\u0010m\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u001f\u0012\u0010\b\u0002\u0010n\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u001f\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010%¢\u0006\u0006\b±\u0001\u0010²\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\tJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001b\u0010\tJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b#\u0010!J\u0012\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b$\u0010\tJ\u0012\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b+\u0010\tJ\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u0004J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0004J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u0004J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010\u0004J\u0012\u00101\u001a\u0004\u0018\u000100HÆ\u0003¢\u0006\u0004\b1\u00102J\u0016\u00104\u001a\b\u0012\u0004\u0012\u0002030\u001fHÆ\u0003¢\u0006\u0004\b4\u0010!J\u0012\u00106\u001a\u0004\u0018\u000105HÆ\u0003¢\u0006\u0004\b6\u00107J\u0012\u00109\u001a\u0004\u0018\u000108HÆ\u0003¢\u0006\u0004\b9\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b;\u0010'J\u0018\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b=\u0010!J\u0018\u0010?\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b?\u0010!J\u0012\u0010@\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b@\u0010'J\u0012\u0010A\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bA\u0010\u0004J\u0012\u0010B\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bB\u0010\tJ\u0012\u0010C\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\bC\u0010\u0004J\u0018\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\bD\u0010!J\u0012\u0010E\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bE\u0010\tJª\u0004\u0010p\u001a\u00020\u00002\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\u0010\b\u0002\u0010a\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001f2\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010c\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010i\u001a\u0004\u0018\u0001002\u000e\b\u0002\u0010j\u001a\b\u0012\u0004\u0012\u0002030\u001f2\n\b\u0002\u0010k\u001a\u0004\u0018\u0001052\n\b\u0002\u0010l\u001a\u0004\u0018\u0001082\u0010\b\u0002\u0010m\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u001f2\u0010\b\u0002\u0010n\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u001f2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010%HÆ\u0001¢\u0006\u0004\bp\u0010qJ\u001a\u0010s\u001a\u00020\u00072\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bs\u0010tJ\u0010\u0010u\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\bu\u0010vJ\u0010\u0010w\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bw\u0010\u0004R\u001f\u0010m\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u001f8\u0007¢\u0006\f\n\u0004\bm\u0010x\u001a\u0004\by\u0010!R\u001c\u0010c\u001a\u0004\u0018\u00010(8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bc\u0010z\u001a\u0004\b{\u0010*R\u001c\u0010H\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010|\u001a\u0004\b}\u0010'R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010~\u001a\u0004\b\u007f\u0010\u0004R\u001d\u0010G\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bG\u0010~\u001a\u0005\b\u0080\u0001\u0010\u0004R\u001d\u0010J\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bJ\u0010~\u001a\u0005\b\u0081\u0001\u0010\u0004R\u001e\u0010K\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bK\u0010\u0082\u0001\u001a\u0005\b\u0083\u0001\u0010\tR\u001d\u0010L\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bL\u0010~\u001a\u0005\b\u0084\u0001\u0010\u0004R#\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\r\n\u0004\bM\u0010x\u001a\u0005\b\u0085\u0001\u0010!R\u001d\u0010I\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\r\n\u0004\bI\u0010|\u001a\u0005\b\u0086\u0001\u0010'R\u001d\u0010g\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bg\u0010~\u001a\u0005\b\u0087\u0001\u0010\u0004R\u001e\u0010i\u001a\u0004\u0018\u0001008\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bi\u0010\u0088\u0001\u001a\u0005\b\u0089\u0001\u00102R\u001e\u0010N\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bN\u0010\u0082\u0001\u001a\u0005\b\u008a\u0001\u0010\tR\u001d\u0010O\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bO\u0010~\u001a\u0005\b\u008b\u0001\u0010\u0004R\u001d\u0010P\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bP\u0010~\u001a\u0005\b\u008c\u0001\u0010\u0004R\u001e\u0010Q\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bQ\u0010\u0082\u0001\u001a\u0005\b\u008d\u0001\u0010\tR\u001e\u0010R\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bR\u0010\u008e\u0001\u001a\u0005\b\u008f\u0001\u0010\fR\u001d\u0010o\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\r\n\u0004\bo\u0010|\u001a\u0005\b\u0090\u0001\u0010'R\u001d\u0010S\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bS\u0010~\u001a\u0005\b\u0091\u0001\u0010\u0004R\u001d\u0010T\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bT\u0010~\u001a\u0005\b\u0092\u0001\u0010\u0004R\u001d\u0010U\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bU\u0010~\u001a\u0005\b\u0093\u0001\u0010\u0004R\u001e\u0010V\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bV\u0010\u0082\u0001\u001a\u0005\b\u0094\u0001\u0010\tR\u001e\u0010d\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bd\u0010\u0082\u0001\u001a\u0005\b\u0095\u0001\u0010\tR#\u0010n\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\r\n\u0004\bn\u0010x\u001a\u0005\b\u0096\u0001\u0010!R\u001e\u0010W\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bW\u0010\u0097\u0001\u001a\u0005\b\u0098\u0001\u0010\u0013R\u001d\u0010X\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bX\u0010~\u001a\u0005\b\u0099\u0001\u0010\u0004R\u001d\u0010e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\be\u0010~\u001a\u0005\b\u009a\u0001\u0010\u0004R(\u0010l\u001a\u0004\u0018\u0001088\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bl\u0010\u009b\u0001\u001a\u0005\b\u009c\u0001\u0010:\"\u0006\b\u009d\u0001\u0010\u009e\u0001R(\u0010k\u001a\u0004\u0018\u0001058\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bk\u0010\u009f\u0001\u001a\u0005\b \u0001\u00107\"\u0006\b¡\u0001\u0010¢\u0001R\u001d\u0010Y\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bY\u0010~\u001a\u0005\b£\u0001\u0010\u0004R\u001e\u0010Z\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bZ\u0010¤\u0001\u001a\u0005\b¥\u0001\u0010\u0019R\u001d\u0010f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bf\u0010~\u001a\u0005\b¦\u0001\u0010\u0004R\u001e\u0010b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bb\u0010\u0082\u0001\u001a\u0005\b§\u0001\u0010\tR\u001d\u0010[\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b[\u0010~\u001a\u0005\b¨\u0001\u0010\u0004R\u001e\u0010\\\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b\\\u0010\u0082\u0001\u001a\u0005\b©\u0001\u0010\tR!\u0010j\u001a\b\u0012\u0004\u0012\u0002030\u001f8\u0007X\u0087\u0004¢\u0006\r\n\u0004\bj\u0010x\u001a\u0005\bª\u0001\u0010!R\u001d\u0010h\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bh\u0010~\u001a\u0005\b«\u0001\u0010\u0004R\u001d\u0010]\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b]\u0010~\u001a\u0005\b¬\u0001\u0010\u0004R\u001d\u0010^\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b^\u0010~\u001a\u0005\b\u00ad\u0001\u0010\u0004R#\u0010`\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\r\n\u0004\b`\u0010x\u001a\u0005\b®\u0001\u0010!R\u001d\u0010_\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b_\u0010~\u001a\u0005\b¯\u0001\u0010\u0004R#\u0010a\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\r\n\u0004\ba\u0010x\u001a\u0005\b°\u0001\u0010!"}, d2 = {"Lid/dana/cashier/domain/model/CashierPayChannelInfo;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "component12", "()Ljava/lang/Boolean;", "Lid/dana/cashier/domain/model/ExtendCashierInfo;", "component13", "()Lid/dana/cashier/domain/model/ExtendCashierInfo;", "component14", "component15", "component16", "component17", "", "component18", "()Ljava/lang/Integer;", "component19", "component2", "component20", "Lid/dana/domain/model/cashier/PayMethodRisk;", "component21", "()Lid/dana/domain/model/cashier/PayMethodRisk;", "component22", "component23", "component24", "component25", "component26", "", "component27", "()Ljava/util/List;", "Lid/dana/cashier/domain/model/VoucherCashierInfo;", "component28", "component29", "Lid/dana/domain/nearbyme/model/MoneyView;", "component3", "()Lid/dana/domain/nearbyme/model/MoneyView;", "Lid/dana/domain/payasset/model/AmountRange;", "component30", "()Lid/dana/domain/payasset/model/AmountRange;", "component31", "component32", "component33", "component34", "component35", "Lid/dana/cashier/domain/model/paylater/DanaCredit;", "component36", "()Lid/dana/cashier/domain/model/paylater/DanaCredit;", "Lid/dana/cashier/domain/model/paylater/RepaymentPlan;", "component37", "Lid/dana/data/config/model/PayLaterMethodConfig;", "component38", "()Lid/dana/data/config/model/PayLaterMethodConfig;", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "component39", "()Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "component4", "Lid/dana/cashier/domain/model/CashierAddOnChannelSupportInfo;", "component40", "Lid/dana/cashier/domain/model/paylater/LoanCreditChannelInfo;", "component41", "component42", "component5", "component6", "component7", "component8", "component9", "bankCode", "bankName", "balanceAmount", "chargeAmount", "bankPhoneNo", "canUse", "cardBrand", "cardBrands", "directDebit", "disableCode", "disableReason", "enableStatus", "extendInfo", "index", "instId", "instName", "instSupportDirectDebit", "maxPeriod", "name", "payMethod", "payMethodRiskResult", "promoDescription", "promoStatus", "serviceInstId", "serviceInstName", "viewConfigShortDescription", "viewConfigIconList", "voucherList", "pivotCard", "amountRange", "interBank", "payAccountNo", "payOption", "companyCode", "serviceBankCode", "danaCredit", "repaymentPlans", "payLaterMethodConfig", "payLaterCicilMethodConfig", "addOnChannelSupportInfos", "loanCreditChannelInfos", "foreignBalanceAmount", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/domain/model/ExtendCashierInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/model/cashier/PayMethodRisk;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/domain/payasset/model/AmountRange;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/domain/model/paylater/DanaCredit;Ljava/util/List;Lid/dana/data/config/model/PayLaterMethodConfig;Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;Ljava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/cashier/domain/model/CashierPayChannelInfo;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/util/List;", "getAddOnChannelSupportInfos", "Lid/dana/domain/payasset/model/AmountRange;", "getAmountRange", "Lid/dana/domain/nearbyme/model/MoneyView;", "getBalanceAmount", "Ljava/lang/String;", "getBankCode", "getBankName", "getBankPhoneNo", "Ljava/lang/Boolean;", "getCanUse", "getCardBrand", "getCardBrands", "getChargeAmount", "getCompanyCode", "Lid/dana/cashier/domain/model/paylater/DanaCredit;", "getDanaCredit", "getDirectDebit", "getDisableCode", "getDisableReason", "getEnableStatus", "Lid/dana/cashier/domain/model/ExtendCashierInfo;", "getExtendInfo", "getForeignBalanceAmount", "getIndex", "getInstId", "getInstName", "getInstSupportDirectDebit", "getInterBank", "getLoanCreditChannelInfos", "Ljava/lang/Integer;", "getMaxPeriod", "getName", "getPayAccountNo", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "getPayLaterCicilMethodConfig", "setPayLaterCicilMethodConfig", "(Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;)V", "Lid/dana/data/config/model/PayLaterMethodConfig;", "getPayLaterMethodConfig", "setPayLaterMethodConfig", "(Lid/dana/data/config/model/PayLaterMethodConfig;)V", "getPayMethod", "Lid/dana/domain/model/cashier/PayMethodRisk;", "getPayMethodRiskResult", "getPayOption", "getPivotCard", "getPromoDescription", "getPromoStatus", "getRepaymentPlans", "getServiceBankCode", "getServiceInstId", "getServiceInstName", "getViewConfigIconList", "getViewConfigShortDescription", "getVoucherList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/nearbyme/model/MoneyView;Lid/dana/domain/nearbyme/model/MoneyView;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/domain/model/ExtendCashierInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lid/dana/domain/model/cashier/PayMethodRisk;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/domain/payasset/model/AmountRange;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/domain/model/paylater/DanaCredit;Ljava/util/List;Lid/dana/data/config/model/PayLaterMethodConfig;Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;Ljava/util/List;Ljava/util/List;Lid/dana/domain/nearbyme/model/MoneyView;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierPayChannelInfo {
    private final List<CashierAddOnChannelSupportInfo> addOnChannelSupportInfos;
    private final AmountRange amountRange;
    private final MoneyView balanceAmount;
    private final String bankCode;
    private final String bankName;
    private final String bankPhoneNo;
    private final Boolean canUse;
    private final String cardBrand;
    private final List<String> cardBrands;
    private final MoneyView chargeAmount;
    private final String companyCode;
    private final DanaCredit danaCredit;
    private final Boolean directDebit;
    private final String disableCode;
    private final String disableReason;
    private final Boolean enableStatus;
    private final ExtendCashierInfo extendInfo;
    private final MoneyView foreignBalanceAmount;
    private final String index;
    private final String instId;
    private final String instName;
    private final Boolean instSupportDirectDebit;
    private final Boolean interBank;
    private final List<LoanCreditChannelInfo> loanCreditChannelInfos;
    private final Integer maxPeriod;
    private final String name;
    private final String payAccountNo;
    private PaylaterCicilMethodConfig payLaterCicilMethodConfig;
    private PayLaterMethodConfig payLaterMethodConfig;
    private final String payMethod;
    private final PayMethodRisk payMethodRiskResult;
    private final String payOption;
    private final Boolean pivotCard;
    private final String promoDescription;
    private final Boolean promoStatus;
    private final List<RepaymentPlan> repaymentPlans;
    private final String serviceBankCode;
    private final String serviceInstId;
    private final String serviceInstName;
    private final List<String> viewConfigIconList;
    private final String viewConfigShortDescription;
    private final List<VoucherCashierInfo> voucherList;

    /* renamed from: component1  reason: from getter */
    public final String getBankCode() {
        return this.bankCode;
    }

    /* renamed from: component10  reason: from getter */
    public final String getDisableCode() {
        return this.disableCode;
    }

    /* renamed from: component11  reason: from getter */
    public final String getDisableReason() {
        return this.disableReason;
    }

    /* renamed from: component12  reason: from getter */
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    /* renamed from: component13  reason: from getter */
    public final ExtendCashierInfo getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component14  reason: from getter */
    public final String getIndex() {
        return this.index;
    }

    /* renamed from: component15  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component16  reason: from getter */
    public final String getInstName() {
        return this.instName;
    }

    /* renamed from: component17  reason: from getter */
    public final Boolean getInstSupportDirectDebit() {
        return this.instSupportDirectDebit;
    }

    /* renamed from: component18  reason: from getter */
    public final Integer getMaxPeriod() {
        return this.maxPeriod;
    }

    /* renamed from: component19  reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBankName() {
        return this.bankName;
    }

    /* renamed from: component20  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component21  reason: from getter */
    public final PayMethodRisk getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    /* renamed from: component22  reason: from getter */
    public final String getPromoDescription() {
        return this.promoDescription;
    }

    /* renamed from: component23  reason: from getter */
    public final Boolean getPromoStatus() {
        return this.promoStatus;
    }

    /* renamed from: component24  reason: from getter */
    public final String getServiceInstId() {
        return this.serviceInstId;
    }

    /* renamed from: component25  reason: from getter */
    public final String getServiceInstName() {
        return this.serviceInstName;
    }

    /* renamed from: component26  reason: from getter */
    public final String getViewConfigShortDescription() {
        return this.viewConfigShortDescription;
    }

    public final List<String> component27() {
        return this.viewConfigIconList;
    }

    public final List<VoucherCashierInfo> component28() {
        return this.voucherList;
    }

    /* renamed from: component29  reason: from getter */
    public final Boolean getPivotCard() {
        return this.pivotCard;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyView getBalanceAmount() {
        return this.balanceAmount;
    }

    /* renamed from: component30  reason: from getter */
    public final AmountRange getAmountRange() {
        return this.amountRange;
    }

    /* renamed from: component31  reason: from getter */
    public final Boolean getInterBank() {
        return this.interBank;
    }

    /* renamed from: component32  reason: from getter */
    public final String getPayAccountNo() {
        return this.payAccountNo;
    }

    /* renamed from: component33  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component34  reason: from getter */
    public final String getCompanyCode() {
        return this.companyCode;
    }

    /* renamed from: component35  reason: from getter */
    public final String getServiceBankCode() {
        return this.serviceBankCode;
    }

    /* renamed from: component36  reason: from getter */
    public final DanaCredit getDanaCredit() {
        return this.danaCredit;
    }

    public final List<RepaymentPlan> component37() {
        return this.repaymentPlans;
    }

    /* renamed from: component38  reason: from getter */
    public final PayLaterMethodConfig getPayLaterMethodConfig() {
        return this.payLaterMethodConfig;
    }

    /* renamed from: component39  reason: from getter */
    public final PaylaterCicilMethodConfig getPayLaterCicilMethodConfig() {
        return this.payLaterCicilMethodConfig;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyView getChargeAmount() {
        return this.chargeAmount;
    }

    public final List<CashierAddOnChannelSupportInfo> component40() {
        return this.addOnChannelSupportInfos;
    }

    public final List<LoanCreditChannelInfo> component41() {
        return this.loanCreditChannelInfos;
    }

    /* renamed from: component42  reason: from getter */
    public final MoneyView getForeignBalanceAmount() {
        return this.foreignBalanceAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component6  reason: from getter */
    public final Boolean getCanUse() {
        return this.canUse;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCardBrand() {
        return this.cardBrand;
    }

    public final List<String> component8() {
        return this.cardBrands;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    public final CashierPayChannelInfo copy(String bankCode, String bankName, MoneyView balanceAmount, MoneyView chargeAmount, String bankPhoneNo, Boolean canUse, String cardBrand, List<String> cardBrands, Boolean directDebit, String disableCode, String disableReason, Boolean enableStatus, ExtendCashierInfo extendInfo, String index, String instId, String instName, Boolean instSupportDirectDebit, Integer maxPeriod, String name, String payMethod, PayMethodRisk payMethodRiskResult, String promoDescription, Boolean promoStatus, String serviceInstId, String serviceInstName, String viewConfigShortDescription, List<String> viewConfigIconList, List<VoucherCashierInfo> voucherList, Boolean pivotCard, AmountRange amountRange, Boolean interBank, String payAccountNo, String payOption, String companyCode, String serviceBankCode, DanaCredit danaCredit, List<RepaymentPlan> repaymentPlans, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig payLaterCicilMethodConfig, List<CashierAddOnChannelSupportInfo> addOnChannelSupportInfos, List<LoanCreditChannelInfo> loanCreditChannelInfos, MoneyView foreignBalanceAmount) {
        Intrinsics.checkNotNullParameter(repaymentPlans, "");
        return new CashierPayChannelInfo(bankCode, bankName, balanceAmount, chargeAmount, bankPhoneNo, canUse, cardBrand, cardBrands, directDebit, disableCode, disableReason, enableStatus, extendInfo, index, instId, instName, instSupportDirectDebit, maxPeriod, name, payMethod, payMethodRiskResult, promoDescription, promoStatus, serviceInstId, serviceInstName, viewConfigShortDescription, viewConfigIconList, voucherList, pivotCard, amountRange, interBank, payAccountNo, payOption, companyCode, serviceBankCode, danaCredit, repaymentPlans, payLaterMethodConfig, payLaterCicilMethodConfig, addOnChannelSupportInfos, loanCreditChannelInfos, foreignBalanceAmount);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierPayChannelInfo) {
            CashierPayChannelInfo cashierPayChannelInfo = (CashierPayChannelInfo) other;
            return Intrinsics.areEqual(this.bankCode, cashierPayChannelInfo.bankCode) && Intrinsics.areEqual(this.bankName, cashierPayChannelInfo.bankName) && Intrinsics.areEqual(this.balanceAmount, cashierPayChannelInfo.balanceAmount) && Intrinsics.areEqual(this.chargeAmount, cashierPayChannelInfo.chargeAmount) && Intrinsics.areEqual(this.bankPhoneNo, cashierPayChannelInfo.bankPhoneNo) && Intrinsics.areEqual(this.canUse, cashierPayChannelInfo.canUse) && Intrinsics.areEqual(this.cardBrand, cashierPayChannelInfo.cardBrand) && Intrinsics.areEqual(this.cardBrands, cashierPayChannelInfo.cardBrands) && Intrinsics.areEqual(this.directDebit, cashierPayChannelInfo.directDebit) && Intrinsics.areEqual(this.disableCode, cashierPayChannelInfo.disableCode) && Intrinsics.areEqual(this.disableReason, cashierPayChannelInfo.disableReason) && Intrinsics.areEqual(this.enableStatus, cashierPayChannelInfo.enableStatus) && Intrinsics.areEqual(this.extendInfo, cashierPayChannelInfo.extendInfo) && Intrinsics.areEqual(this.index, cashierPayChannelInfo.index) && Intrinsics.areEqual(this.instId, cashierPayChannelInfo.instId) && Intrinsics.areEqual(this.instName, cashierPayChannelInfo.instName) && Intrinsics.areEqual(this.instSupportDirectDebit, cashierPayChannelInfo.instSupportDirectDebit) && Intrinsics.areEqual(this.maxPeriod, cashierPayChannelInfo.maxPeriod) && Intrinsics.areEqual(this.name, cashierPayChannelInfo.name) && Intrinsics.areEqual(this.payMethod, cashierPayChannelInfo.payMethod) && Intrinsics.areEqual(this.payMethodRiskResult, cashierPayChannelInfo.payMethodRiskResult) && Intrinsics.areEqual(this.promoDescription, cashierPayChannelInfo.promoDescription) && Intrinsics.areEqual(this.promoStatus, cashierPayChannelInfo.promoStatus) && Intrinsics.areEqual(this.serviceInstId, cashierPayChannelInfo.serviceInstId) && Intrinsics.areEqual(this.serviceInstName, cashierPayChannelInfo.serviceInstName) && Intrinsics.areEqual(this.viewConfigShortDescription, cashierPayChannelInfo.viewConfigShortDescription) && Intrinsics.areEqual(this.viewConfigIconList, cashierPayChannelInfo.viewConfigIconList) && Intrinsics.areEqual(this.voucherList, cashierPayChannelInfo.voucherList) && Intrinsics.areEqual(this.pivotCard, cashierPayChannelInfo.pivotCard) && Intrinsics.areEqual(this.amountRange, cashierPayChannelInfo.amountRange) && Intrinsics.areEqual(this.interBank, cashierPayChannelInfo.interBank) && Intrinsics.areEqual(this.payAccountNo, cashierPayChannelInfo.payAccountNo) && Intrinsics.areEqual(this.payOption, cashierPayChannelInfo.payOption) && Intrinsics.areEqual(this.companyCode, cashierPayChannelInfo.companyCode) && Intrinsics.areEqual(this.serviceBankCode, cashierPayChannelInfo.serviceBankCode) && Intrinsics.areEqual(this.danaCredit, cashierPayChannelInfo.danaCredit) && Intrinsics.areEqual(this.repaymentPlans, cashierPayChannelInfo.repaymentPlans) && Intrinsics.areEqual(this.payLaterMethodConfig, cashierPayChannelInfo.payLaterMethodConfig) && Intrinsics.areEqual(this.payLaterCicilMethodConfig, cashierPayChannelInfo.payLaterCicilMethodConfig) && Intrinsics.areEqual(this.addOnChannelSupportInfos, cashierPayChannelInfo.addOnChannelSupportInfos) && Intrinsics.areEqual(this.loanCreditChannelInfos, cashierPayChannelInfo.loanCreditChannelInfos) && Intrinsics.areEqual(this.foreignBalanceAmount, cashierPayChannelInfo.foreignBalanceAmount);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bankCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bankName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MoneyView moneyView = this.balanceAmount;
        int hashCode3 = moneyView == null ? 0 : moneyView.hashCode();
        MoneyView moneyView2 = this.chargeAmount;
        int hashCode4 = moneyView2 == null ? 0 : moneyView2.hashCode();
        String str3 = this.bankPhoneNo;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.canUse;
        int hashCode6 = bool == null ? 0 : bool.hashCode();
        String str4 = this.cardBrand;
        int hashCode7 = str4 == null ? 0 : str4.hashCode();
        List<String> list = this.cardBrands;
        int hashCode8 = list == null ? 0 : list.hashCode();
        Boolean bool2 = this.directDebit;
        int hashCode9 = bool2 == null ? 0 : bool2.hashCode();
        String str5 = this.disableCode;
        int hashCode10 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.disableReason;
        int hashCode11 = str6 == null ? 0 : str6.hashCode();
        Boolean bool3 = this.enableStatus;
        int hashCode12 = bool3 == null ? 0 : bool3.hashCode();
        ExtendCashierInfo extendCashierInfo = this.extendInfo;
        int hashCode13 = extendCashierInfo == null ? 0 : extendCashierInfo.hashCode();
        String str7 = this.index;
        int hashCode14 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.instId;
        int hashCode15 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.instName;
        int hashCode16 = str9 == null ? 0 : str9.hashCode();
        Boolean bool4 = this.instSupportDirectDebit;
        int hashCode17 = bool4 == null ? 0 : bool4.hashCode();
        Integer num = this.maxPeriod;
        int hashCode18 = num == null ? 0 : num.hashCode();
        String str10 = this.name;
        int hashCode19 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.payMethod;
        int hashCode20 = str11 == null ? 0 : str11.hashCode();
        PayMethodRisk payMethodRisk = this.payMethodRiskResult;
        int hashCode21 = payMethodRisk == null ? 0 : payMethodRisk.hashCode();
        String str12 = this.promoDescription;
        int hashCode22 = str12 == null ? 0 : str12.hashCode();
        Boolean bool5 = this.promoStatus;
        int hashCode23 = bool5 == null ? 0 : bool5.hashCode();
        String str13 = this.serviceInstId;
        int hashCode24 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.serviceInstName;
        int hashCode25 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.viewConfigShortDescription;
        int hashCode26 = str15 == null ? 0 : str15.hashCode();
        List<String> list2 = this.viewConfigIconList;
        int hashCode27 = list2 == null ? 0 : list2.hashCode();
        List<VoucherCashierInfo> list3 = this.voucherList;
        int hashCode28 = list3 == null ? 0 : list3.hashCode();
        Boolean bool6 = this.pivotCard;
        int hashCode29 = bool6 == null ? 0 : bool6.hashCode();
        AmountRange amountRange = this.amountRange;
        int hashCode30 = amountRange == null ? 0 : amountRange.hashCode();
        Boolean bool7 = this.interBank;
        int hashCode31 = bool7 == null ? 0 : bool7.hashCode();
        String str16 = this.payAccountNo;
        int hashCode32 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.payOption;
        int hashCode33 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.companyCode;
        int hashCode34 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.serviceBankCode;
        int hashCode35 = str19 == null ? 0 : str19.hashCode();
        DanaCredit danaCredit = this.danaCredit;
        int hashCode36 = danaCredit == null ? 0 : danaCredit.hashCode();
        int hashCode37 = this.repaymentPlans.hashCode();
        PayLaterMethodConfig payLaterMethodConfig = this.payLaterMethodConfig;
        int hashCode38 = payLaterMethodConfig == null ? 0 : payLaterMethodConfig.hashCode();
        PaylaterCicilMethodConfig paylaterCicilMethodConfig = this.payLaterCicilMethodConfig;
        int hashCode39 = paylaterCicilMethodConfig == null ? 0 : paylaterCicilMethodConfig.hashCode();
        List<CashierAddOnChannelSupportInfo> list4 = this.addOnChannelSupportInfos;
        int hashCode40 = list4 == null ? 0 : list4.hashCode();
        List<LoanCreditChannelInfo> list5 = this.loanCreditChannelInfos;
        int hashCode41 = list5 == null ? 0 : list5.hashCode();
        MoneyView moneyView3 = this.foreignBalanceAmount;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + hashCode38) * 31) + hashCode39) * 31) + hashCode40) * 31) + hashCode41) * 31) + (moneyView3 != null ? moneyView3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierPayChannelInfo(bankCode=");
        sb.append(this.bankCode);
        sb.append(", bankName=");
        sb.append(this.bankName);
        sb.append(", balanceAmount=");
        sb.append(this.balanceAmount);
        sb.append(", chargeAmount=");
        sb.append(this.chargeAmount);
        sb.append(", bankPhoneNo=");
        sb.append(this.bankPhoneNo);
        sb.append(", canUse=");
        sb.append(this.canUse);
        sb.append(", cardBrand=");
        sb.append(this.cardBrand);
        sb.append(", cardBrands=");
        sb.append(this.cardBrands);
        sb.append(", directDebit=");
        sb.append(this.directDebit);
        sb.append(", disableCode=");
        sb.append(this.disableCode);
        sb.append(", disableReason=");
        sb.append(this.disableReason);
        sb.append(", enableStatus=");
        sb.append(this.enableStatus);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", index=");
        sb.append(this.index);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", instName=");
        sb.append(this.instName);
        sb.append(", instSupportDirectDebit=");
        sb.append(this.instSupportDirectDebit);
        sb.append(", maxPeriod=");
        sb.append(this.maxPeriod);
        sb.append(", name=");
        sb.append(this.name);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", payMethodRiskResult=");
        sb.append(this.payMethodRiskResult);
        sb.append(", promoDescription=");
        sb.append(this.promoDescription);
        sb.append(", promoStatus=");
        sb.append(this.promoStatus);
        sb.append(", serviceInstId=");
        sb.append(this.serviceInstId);
        sb.append(", serviceInstName=");
        sb.append(this.serviceInstName);
        sb.append(", viewConfigShortDescription=");
        sb.append(this.viewConfigShortDescription);
        sb.append(", viewConfigIconList=");
        sb.append(this.viewConfigIconList);
        sb.append(", voucherList=");
        sb.append(this.voucherList);
        sb.append(", pivotCard=");
        sb.append(this.pivotCard);
        sb.append(", amountRange=");
        sb.append(this.amountRange);
        sb.append(", interBank=");
        sb.append(this.interBank);
        sb.append(", payAccountNo=");
        sb.append(this.payAccountNo);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", companyCode=");
        sb.append(this.companyCode);
        sb.append(", serviceBankCode=");
        sb.append(this.serviceBankCode);
        sb.append(", danaCredit=");
        sb.append(this.danaCredit);
        sb.append(", repaymentPlans=");
        sb.append(this.repaymentPlans);
        sb.append(", payLaterMethodConfig=");
        sb.append(this.payLaterMethodConfig);
        sb.append(", payLaterCicilMethodConfig=");
        sb.append(this.payLaterCicilMethodConfig);
        sb.append(", addOnChannelSupportInfos=");
        sb.append(this.addOnChannelSupportInfos);
        sb.append(", loanCreditChannelInfos=");
        sb.append(this.loanCreditChannelInfos);
        sb.append(", foreignBalanceAmount=");
        sb.append(this.foreignBalanceAmount);
        sb.append(')');
        return sb.toString();
    }

    public CashierPayChannelInfo(String str, String str2, MoneyView moneyView, MoneyView moneyView2, String str3, Boolean bool, String str4, List<String> list, Boolean bool2, String str5, String str6, Boolean bool3, ExtendCashierInfo extendCashierInfo, String str7, String str8, String str9, Boolean bool4, Integer num, String str10, String str11, PayMethodRisk payMethodRisk, String str12, Boolean bool5, String str13, String str14, String str15, List<String> list2, List<VoucherCashierInfo> list3, Boolean bool6, AmountRange amountRange, Boolean bool7, String str16, String str17, String str18, String str19, DanaCredit danaCredit, List<RepaymentPlan> list4, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig paylaterCicilMethodConfig, List<CashierAddOnChannelSupportInfo> list5, List<LoanCreditChannelInfo> list6, MoneyView moneyView3) {
        Intrinsics.checkNotNullParameter(list4, "");
        this.bankCode = str;
        this.bankName = str2;
        this.balanceAmount = moneyView;
        this.chargeAmount = moneyView2;
        this.bankPhoneNo = str3;
        this.canUse = bool;
        this.cardBrand = str4;
        this.cardBrands = list;
        this.directDebit = bool2;
        this.disableCode = str5;
        this.disableReason = str6;
        this.enableStatus = bool3;
        this.extendInfo = extendCashierInfo;
        this.index = str7;
        this.instId = str8;
        this.instName = str9;
        this.instSupportDirectDebit = bool4;
        this.maxPeriod = num;
        this.name = str10;
        this.payMethod = str11;
        this.payMethodRiskResult = payMethodRisk;
        this.promoDescription = str12;
        this.promoStatus = bool5;
        this.serviceInstId = str13;
        this.serviceInstName = str14;
        this.viewConfigShortDescription = str15;
        this.viewConfigIconList = list2;
        this.voucherList = list3;
        this.pivotCard = bool6;
        this.amountRange = amountRange;
        this.interBank = bool7;
        this.payAccountNo = str16;
        this.payOption = str17;
        this.companyCode = str18;
        this.serviceBankCode = str19;
        this.danaCredit = danaCredit;
        this.repaymentPlans = list4;
        this.payLaterMethodConfig = payLaterMethodConfig;
        this.payLaterCicilMethodConfig = paylaterCicilMethodConfig;
        this.addOnChannelSupportInfos = list5;
        this.loanCreditChannelInfos = list6;
        this.foreignBalanceAmount = moneyView3;
    }

    public /* synthetic */ CashierPayChannelInfo(String str, String str2, MoneyView moneyView, MoneyView moneyView2, String str3, Boolean bool, String str4, List list, Boolean bool2, String str5, String str6, Boolean bool3, ExtendCashierInfo extendCashierInfo, String str7, String str8, String str9, Boolean bool4, Integer num, String str10, String str11, PayMethodRisk payMethodRisk, String str12, Boolean bool5, String str13, String str14, String str15, List list2, List list3, Boolean bool6, AmountRange amountRange, Boolean bool7, String str16, String str17, String str18, String str19, DanaCredit danaCredit, List list4, PayLaterMethodConfig payLaterMethodConfig, PaylaterCicilMethodConfig paylaterCicilMethodConfig, List list5, List list6, MoneyView moneyView3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, moneyView, moneyView2, str3, bool, str4, list, bool2, str5, str6, bool3, extendCashierInfo, str7, str8, str9, bool4, num, str10, str11, payMethodRisk, str12, bool5, str13, str14, str15, (i & 67108864) != 0 ? null : list2, list3, bool6, (i & 536870912) != 0 ? null : amountRange, (i & 1073741824) != 0 ? null : bool7, (i & Integer.MIN_VALUE) != 0 ? null : str16, (i2 & 1) != 0 ? null : str17, (i2 & 2) != 0 ? null : str18, (i2 & 4) != 0 ? null : str19, danaCredit, list4, (i2 & 32) != 0 ? null : payLaterMethodConfig, (i2 & 64) != 0 ? null : paylaterCicilMethodConfig, list5, (i2 & 256) != 0 ? null : list6, (i2 & 512) != 0 ? null : moneyView3);
    }

    @JvmName(name = "getBankCode")
    public final String getBankCode() {
        return this.bankCode;
    }

    @JvmName(name = "getBankName")
    public final String getBankName() {
        return this.bankName;
    }

    @JvmName(name = "getBalanceAmount")
    public final MoneyView getBalanceAmount() {
        return this.balanceAmount;
    }

    @JvmName(name = "getChargeAmount")
    public final MoneyView getChargeAmount() {
        return this.chargeAmount;
    }

    @JvmName(name = "getBankPhoneNo")
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    @JvmName(name = "getCanUse")
    public final Boolean getCanUse() {
        return this.canUse;
    }

    @JvmName(name = "getCardBrand")
    public final String getCardBrand() {
        return this.cardBrand;
    }

    @JvmName(name = "getCardBrands")
    public final List<String> getCardBrands() {
        return this.cardBrands;
    }

    @JvmName(name = "getDirectDebit")
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    @JvmName(name = "getDisableCode")
    public final String getDisableCode() {
        return this.disableCode;
    }

    @JvmName(name = "getDisableReason")
    public final String getDisableReason() {
        return this.disableReason;
    }

    @JvmName(name = "getEnableStatus")
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    @JvmName(name = "getExtendInfo")
    public final ExtendCashierInfo getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getIndex")
    public final String getIndex() {
        return this.index;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getInstName")
    public final String getInstName() {
        return this.instName;
    }

    @JvmName(name = "getInstSupportDirectDebit")
    public final Boolean getInstSupportDirectDebit() {
        return this.instSupportDirectDebit;
    }

    @JvmName(name = "getMaxPeriod")
    public final Integer getMaxPeriod() {
        return this.maxPeriod;
    }

    @JvmName(name = "getName")
    public final String getName() {
        return this.name;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayMethodRiskResult")
    public final PayMethodRisk getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    @JvmName(name = "getPromoDescription")
    public final String getPromoDescription() {
        return this.promoDescription;
    }

    @JvmName(name = "getPromoStatus")
    public final Boolean getPromoStatus() {
        return this.promoStatus;
    }

    @JvmName(name = "getServiceInstId")
    public final String getServiceInstId() {
        return this.serviceInstId;
    }

    @JvmName(name = "getServiceInstName")
    public final String getServiceInstName() {
        return this.serviceInstName;
    }

    @JvmName(name = "getViewConfigShortDescription")
    public final String getViewConfigShortDescription() {
        return this.viewConfigShortDescription;
    }

    @JvmName(name = "getViewConfigIconList")
    public final List<String> getViewConfigIconList() {
        return this.viewConfigIconList;
    }

    @JvmName(name = "getVoucherList")
    public final List<VoucherCashierInfo> getVoucherList() {
        return this.voucherList;
    }

    @JvmName(name = "getPivotCard")
    public final Boolean getPivotCard() {
        return this.pivotCard;
    }

    @JvmName(name = "getAmountRange")
    public final AmountRange getAmountRange() {
        return this.amountRange;
    }

    @JvmName(name = "getInterBank")
    public final Boolean getInterBank() {
        return this.interBank;
    }

    @JvmName(name = "getPayAccountNo")
    public final String getPayAccountNo() {
        return this.payAccountNo;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getCompanyCode")
    public final String getCompanyCode() {
        return this.companyCode;
    }

    @JvmName(name = "getServiceBankCode")
    public final String getServiceBankCode() {
        return this.serviceBankCode;
    }

    @JvmName(name = "getDanaCredit")
    public final DanaCredit getDanaCredit() {
        return this.danaCredit;
    }

    @JvmName(name = "getRepaymentPlans")
    public final List<RepaymentPlan> getRepaymentPlans() {
        return this.repaymentPlans;
    }

    @JvmName(name = "getPayLaterMethodConfig")
    public final PayLaterMethodConfig getPayLaterMethodConfig() {
        return this.payLaterMethodConfig;
    }

    @JvmName(name = "setPayLaterMethodConfig")
    public final void setPayLaterMethodConfig(PayLaterMethodConfig payLaterMethodConfig) {
        this.payLaterMethodConfig = payLaterMethodConfig;
    }

    @JvmName(name = "getPayLaterCicilMethodConfig")
    public final PaylaterCicilMethodConfig getPayLaterCicilMethodConfig() {
        return this.payLaterCicilMethodConfig;
    }

    @JvmName(name = "setPayLaterCicilMethodConfig")
    public final void setPayLaterCicilMethodConfig(PaylaterCicilMethodConfig paylaterCicilMethodConfig) {
        this.payLaterCicilMethodConfig = paylaterCicilMethodConfig;
    }

    @JvmName(name = "getAddOnChannelSupportInfos")
    public final List<CashierAddOnChannelSupportInfo> getAddOnChannelSupportInfos() {
        return this.addOnChannelSupportInfos;
    }

    @JvmName(name = "getLoanCreditChannelInfos")
    public final List<LoanCreditChannelInfo> getLoanCreditChannelInfos() {
        return this.loanCreditChannelInfos;
    }

    @JvmName(name = "getForeignBalanceAmount")
    public final MoneyView getForeignBalanceAmount() {
        return this.foreignBalanceAmount;
    }
}
