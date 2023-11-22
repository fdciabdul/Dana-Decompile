package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.sendmoney.model.HolderName;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bh\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0003\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010N\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b\u0012\b\u0010T\u001a\u0004\u0018\u00010\u001e\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b\u0012\b\u0010W\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010X\u001a\u0004\u0018\u00010%\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u000100\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u000f\u0010\bJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\"\u0010\u001dJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0012\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b(\u0010\bJ\u0012\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010-\u001a\u0004\u0018\u00010,HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b/\u0010\bJ\u0012\u00101\u001a\u0004\u0018\u000100HÆ\u0003¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b3\u0010\u0014J\u0012\u00104\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b4\u0010\u0018J\u0012\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b5\u0010\bJ\u0012\u00106\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b6\u0010\u0004J\u0012\u00107\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b7\u0010\u0004J\u0012\u00108\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b8\u0010\u0018J\u0012\u00109\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b9\u0010\u0004J\u0012\u0010:\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b:\u0010\bJØ\u0003\u0010`\u001a\u00020\u00002\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b2\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010X\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010]\u001a\u0004\u0018\u0001002\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0004\b`\u0010aJ\u001a\u0010c\u001a\u00020\u00062\b\u0010b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bc\u0010dJ\u0010\u0010e\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bg\u0010\u0004R\u001c\u0010;\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b;\u0010h\u001a\u0004\bi\u0010\u0004R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010h\u001a\u0004\bj\u0010\u0004R\u001c\u0010=\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010h\u001a\u0004\bk\u0010\u0004R\u001c\u0010>\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010l\u001a\u0004\bm\u0010\bR\u001c\u0010?\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b?\u0010h\u001a\u0004\bn\u0010\u0004R\u001c\u0010@\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010h\u001a\u0004\bo\u0010\u0004R\u001c\u0010A\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010p\u001a\u0004\bq\u0010\u0018R\u001c\u0010B\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010h\u001a\u0004\br\u0010\u0004R\u001c\u0010X\u001a\u0004\u0018\u00010%8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bX\u0010s\u001a\u0004\bt\u0010'R\u001c\u0010Y\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\bY\u0010l\u001a\u0004\bu\u0010\bR\u001c\u0010C\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010l\u001a\u0004\bv\u0010\bR\u001c\u0010D\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010h\u001a\u0004\bw\u0010\u0004R\u001c\u0010E\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010l\u001a\u0004\bx\u0010\bR\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010h\u001a\u0004\by\u0010\u0004R\u001c\u0010G\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010l\u001a\u0004\bz\u0010\bR\u001c\u0010H\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010h\u001a\u0004\b{\u0010\u0004R\u001c\u0010I\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010h\u001a\u0004\b|\u0010\u0004R\u001c\u0010Z\u001a\u0004\u0018\u00010)8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bZ\u0010}\u001a\u0004\b~\u0010+R\u001d\u0010[\u001a\u0004\u0018\u00010,8\u0007X\u0087\u0004¢\u0006\r\n\u0004\b[\u0010\u007f\u001a\u0005\b\u0080\u0001\u0010.R\u001d\u0010J\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bJ\u0010h\u001a\u0005\b\u0081\u0001\u0010\u0004R\u001d\u0010K\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bK\u0010h\u001a\u0005\b\u0082\u0001\u0010\u0004R\u001d\u0010L\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\r\n\u0004\bL\u0010l\u001a\u0005\b\u0083\u0001\u0010\bR\u001d\u0010_\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\r\n\u0004\b_\u0010p\u001a\u0005\b\u0084\u0001\u0010\u0018R\u001e\u0010N\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bN\u0010\u0085\u0001\u001a\u0005\b\u0086\u0001\u0010\u0014R\u001d\u0010M\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bM\u0010h\u001a\u0005\b\u0087\u0001\u0010\u0004R\u001d\u0010O\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bO\u0010h\u001a\u0005\b\u0088\u0001\u0010\u0004R\u001d\u0010P\u001a\u0004\u0018\u00010\u00168\u0007X\u0087\u0004¢\u0006\r\n\u0004\bP\u0010p\u001a\u0005\b\u0089\u0001\u0010\u0018R\u001d\u0010Q\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bQ\u0010h\u001a\u0005\b\u008a\u0001\u0010\u0004R\u001d\u0010R\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bR\u0010h\u001a\u0005\b\u008b\u0001\u0010\u0004R$\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bS\u0010\u008c\u0001\u001a\u0005\b\u008d\u0001\u0010\u001dR\u001d\u0010\\\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\r\n\u0004\b\\\u0010l\u001a\u0005\b\u008e\u0001\u0010\bR\u001e\u0010T\u001a\u0004\u0018\u00010\u001e8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bT\u0010\u008f\u0001\u001a\u0005\b\u0090\u0001\u0010 R\u001e\u0010]\u001a\u0004\u0018\u0001008\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b]\u0010\u0091\u0001\u001a\u0005\b\u0092\u0001\u00102R\u001e\u0010^\u001a\u0004\u0018\u00010\u00128\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b^\u0010\u0085\u0001\u001a\u0005\b\u0093\u0001\u0010\u0014R\u001d\u0010U\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bU\u0010h\u001a\u0005\b\u0094\u0001\u0010\u0004R$\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001b8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bV\u0010\u008c\u0001\u001a\u0005\b\u0095\u0001\u0010\u001dR\u001d\u0010W\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bW\u0010h\u001a\u0005\b\u0096\u0001\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/AssetCardResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "", "component11", "()Ljava/lang/Boolean;", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "", "component20", "()Ljava/lang/Long;", "component21", "", "component22", "()Ljava/lang/Integer;", "component23", "component24", "", "component25", "()Ljava/util/List;", "Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "component26", "()Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "component27", "component28", "component29", "component3", "Lid/dana/cashier/data/repository/source/network/result/DailyLimitAmountConfResult;", "component30", "()Lid/dana/cashier/data/repository/source/network/result/DailyLimitAmountConfResult;", "component31", "Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "component32", "()Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "Lid/dana/data/sendmoney/model/HolderName;", "component33", "()Lid/dana/data/sendmoney/model/HolderName;", "component34", "Lid/dana/cashier/data/repository/source/network/result/RemainingCardLimitAmountResult;", "component35", "()Lid/dana/cashier/data/repository/source/network/result/RemainingCardLimitAmountResult;", "component36", "component37", "component4", "component5", "component6", "component7", "component8", "component9", "assetType", "bankPhoneNo", "bindingId", "canUse", "cardBin", WalletConstant.CARD_INDEX_NO, "cardNoLength", "cardScheme", "defaultOption", "deviceId", "directDebit", "disableReason", "enableStatus", "expiryMonth", "expiryYear", "instId", "instName", "instSupportDirectDebit", "limitMaximum", "lastPayTime", "maskedCardNo", "order", "payMethod", "payOption", "payVerifyElements", "promo", "type", "verifyElements", "xcoId", "dailyLimitAmountConf", "defaultCard", "extendInfo", "holderName", "payWithoutCvv", "remainingCardLimitAmount", "sequence", CashierKeyParams.INSTALLMENT_PERIOD, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/DailyLimitAmountConfResult;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;Lid/dana/data/sendmoney/model/HolderName;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/RemainingCardLimitAmountResult;Ljava/lang/Long;Ljava/lang/Integer;)Lid/dana/cashier/data/repository/source/network/result/AssetCardResult;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAssetType", "getBankPhoneNo", "getBindingId", "Ljava/lang/Boolean;", "getCanUse", "getCardBin", "getCardIndexNo", "Ljava/lang/Integer;", "getCardNoLength", "getCardScheme", "Lid/dana/cashier/data/repository/source/network/result/DailyLimitAmountConfResult;", "getDailyLimitAmountConf", "getDefaultCard", "getDefaultOption", "getDeviceId", "getDirectDebit", "getDisableReason", "getEnableStatus", "getExpiryMonth", "getExpiryYear", "Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "getExtendInfo", "Lid/dana/data/sendmoney/model/HolderName;", "getHolderName", "getInstId", "getInstName", "getInstSupportDirectDebit", "getInstallmentPeriod", "Ljava/lang/Long;", "getLastPayTime", "getLimitMaximum", "getMaskedCardNo", "getOrder", "getPayMethod", "getPayOption", "Ljava/util/List;", "getPayVerifyElements", "getPayWithoutCvv", "Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "getPromo", "Lid/dana/cashier/data/repository/source/network/result/RemainingCardLimitAmountResult;", "getRemainingCardLimitAmount", "getSequence", "getType", "getVerifyElements", "getXcoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/DailyLimitAmountConfResult;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;Lid/dana/data/sendmoney/model/HolderName;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/RemainingCardLimitAmountResult;Ljava/lang/Long;Ljava/lang/Integer;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AssetCardResult {
    @SerializedName("assetType")
    private final String assetType;
    private final String bankPhoneNo;
    private final String bindingId;
    private final Boolean canUse;
    private final String cardBin;
    private final String cardIndexNo;
    private final Integer cardNoLength;
    private final String cardScheme;
    private final DailyLimitAmountConfResult dailyLimitAmountConf;
    private final Boolean defaultCard;
    private final Boolean defaultOption;
    private final String deviceId;
    private final Boolean directDebit;
    private final String disableReason;
    private final Boolean enableStatus;
    private final String expiryMonth;
    private final String expiryYear;
    private final ExtendInfoResult extendInfo;
    private final HolderName holderName;
    private final String instId;
    private final String instName;
    private final Boolean instSupportDirectDebit;
    private final Integer installmentPeriod;
    private final Long lastPayTime;
    private final String limitMaximum;
    private final String maskedCardNo;
    private final Integer order;
    private final String payMethod;
    private final String payOption;
    private final List<String> payVerifyElements;
    private final Boolean payWithoutCvv;
    private final PromoInfoResult promo;
    private final RemainingCardLimitAmountResult remainingCardLimitAmount;
    private final Long sequence;
    private final String type;
    private final List<String> verifyElements;
    private final String xcoId;

    /* renamed from: component1  reason: from getter */
    public final String getAssetType() {
        return this.assetType;
    }

    /* renamed from: component10  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component11  reason: from getter */
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    /* renamed from: component12  reason: from getter */
    public final String getDisableReason() {
        return this.disableReason;
    }

    /* renamed from: component13  reason: from getter */
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    /* renamed from: component14  reason: from getter */
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    /* renamed from: component15  reason: from getter */
    public final String getExpiryYear() {
        return this.expiryYear;
    }

    /* renamed from: component16  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component17  reason: from getter */
    public final String getInstName() {
        return this.instName;
    }

    /* renamed from: component18  reason: from getter */
    public final Boolean getInstSupportDirectDebit() {
        return this.instSupportDirectDebit;
    }

    /* renamed from: component19  reason: from getter */
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component20  reason: from getter */
    public final Long getLastPayTime() {
        return this.lastPayTime;
    }

    /* renamed from: component21  reason: from getter */
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    /* renamed from: component22  reason: from getter */
    public final Integer getOrder() {
        return this.order;
    }

    /* renamed from: component23  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component24  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    public final List<String> component25() {
        return this.payVerifyElements;
    }

    /* renamed from: component26  reason: from getter */
    public final PromoInfoResult getPromo() {
        return this.promo;
    }

    /* renamed from: component27  reason: from getter */
    public final String getType() {
        return this.type;
    }

    public final List<String> component28() {
        return this.verifyElements;
    }

    /* renamed from: component29  reason: from getter */
    public final String getXcoId() {
        return this.xcoId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component30  reason: from getter */
    public final DailyLimitAmountConfResult getDailyLimitAmountConf() {
        return this.dailyLimitAmountConf;
    }

    /* renamed from: component31  reason: from getter */
    public final Boolean getDefaultCard() {
        return this.defaultCard;
    }

    /* renamed from: component32  reason: from getter */
    public final ExtendInfoResult getExtendInfo() {
        return this.extendInfo;
    }

    /* renamed from: component33  reason: from getter */
    public final HolderName getHolderName() {
        return this.holderName;
    }

    /* renamed from: component34  reason: from getter */
    public final Boolean getPayWithoutCvv() {
        return this.payWithoutCvv;
    }

    /* renamed from: component35  reason: from getter */
    public final RemainingCardLimitAmountResult getRemainingCardLimitAmount() {
        return this.remainingCardLimitAmount;
    }

    /* renamed from: component36  reason: from getter */
    public final Long getSequence() {
        return this.sequence;
    }

    /* renamed from: component37  reason: from getter */
    public final Integer getInstallmentPeriod() {
        return this.installmentPeriod;
    }

    /* renamed from: component4  reason: from getter */
    public final Boolean getCanUse() {
        return this.canUse;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCardBin() {
        return this.cardBin;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component7  reason: from getter */
    public final Integer getCardNoLength() {
        return this.cardNoLength;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCardScheme() {
        return this.cardScheme;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getDefaultOption() {
        return this.defaultOption;
    }

    public final AssetCardResult copy(String assetType, String bankPhoneNo, String bindingId, Boolean canUse, String cardBin, String cardIndexNo, Integer cardNoLength, String cardScheme, Boolean defaultOption, String deviceId, Boolean directDebit, String disableReason, Boolean enableStatus, String expiryMonth, String expiryYear, String instId, String instName, Boolean instSupportDirectDebit, String limitMaximum, Long lastPayTime, String maskedCardNo, Integer order, String payMethod, String payOption, List<String> payVerifyElements, PromoInfoResult promo, String type, List<String> verifyElements, String xcoId, DailyLimitAmountConfResult dailyLimitAmountConf, Boolean defaultCard, ExtendInfoResult extendInfo, HolderName holderName, Boolean payWithoutCvv, RemainingCardLimitAmountResult remainingCardLimitAmount, Long sequence, Integer installmentPeriod) {
        return new AssetCardResult(assetType, bankPhoneNo, bindingId, canUse, cardBin, cardIndexNo, cardNoLength, cardScheme, defaultOption, deviceId, directDebit, disableReason, enableStatus, expiryMonth, expiryYear, instId, instName, instSupportDirectDebit, limitMaximum, lastPayTime, maskedCardNo, order, payMethod, payOption, payVerifyElements, promo, type, verifyElements, xcoId, dailyLimitAmountConf, defaultCard, extendInfo, holderName, payWithoutCvv, remainingCardLimitAmount, sequence, installmentPeriod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof AssetCardResult) {
            AssetCardResult assetCardResult = (AssetCardResult) other;
            return Intrinsics.areEqual(this.assetType, assetCardResult.assetType) && Intrinsics.areEqual(this.bankPhoneNo, assetCardResult.bankPhoneNo) && Intrinsics.areEqual(this.bindingId, assetCardResult.bindingId) && Intrinsics.areEqual(this.canUse, assetCardResult.canUse) && Intrinsics.areEqual(this.cardBin, assetCardResult.cardBin) && Intrinsics.areEqual(this.cardIndexNo, assetCardResult.cardIndexNo) && Intrinsics.areEqual(this.cardNoLength, assetCardResult.cardNoLength) && Intrinsics.areEqual(this.cardScheme, assetCardResult.cardScheme) && Intrinsics.areEqual(this.defaultOption, assetCardResult.defaultOption) && Intrinsics.areEqual(this.deviceId, assetCardResult.deviceId) && Intrinsics.areEqual(this.directDebit, assetCardResult.directDebit) && Intrinsics.areEqual(this.disableReason, assetCardResult.disableReason) && Intrinsics.areEqual(this.enableStatus, assetCardResult.enableStatus) && Intrinsics.areEqual(this.expiryMonth, assetCardResult.expiryMonth) && Intrinsics.areEqual(this.expiryYear, assetCardResult.expiryYear) && Intrinsics.areEqual(this.instId, assetCardResult.instId) && Intrinsics.areEqual(this.instName, assetCardResult.instName) && Intrinsics.areEqual(this.instSupportDirectDebit, assetCardResult.instSupportDirectDebit) && Intrinsics.areEqual(this.limitMaximum, assetCardResult.limitMaximum) && Intrinsics.areEqual(this.lastPayTime, assetCardResult.lastPayTime) && Intrinsics.areEqual(this.maskedCardNo, assetCardResult.maskedCardNo) && Intrinsics.areEqual(this.order, assetCardResult.order) && Intrinsics.areEqual(this.payMethod, assetCardResult.payMethod) && Intrinsics.areEqual(this.payOption, assetCardResult.payOption) && Intrinsics.areEqual(this.payVerifyElements, assetCardResult.payVerifyElements) && Intrinsics.areEqual(this.promo, assetCardResult.promo) && Intrinsics.areEqual(this.type, assetCardResult.type) && Intrinsics.areEqual(this.verifyElements, assetCardResult.verifyElements) && Intrinsics.areEqual(this.xcoId, assetCardResult.xcoId) && Intrinsics.areEqual(this.dailyLimitAmountConf, assetCardResult.dailyLimitAmountConf) && Intrinsics.areEqual(this.defaultCard, assetCardResult.defaultCard) && Intrinsics.areEqual(this.extendInfo, assetCardResult.extendInfo) && Intrinsics.areEqual(this.holderName, assetCardResult.holderName) && Intrinsics.areEqual(this.payWithoutCvv, assetCardResult.payWithoutCvv) && Intrinsics.areEqual(this.remainingCardLimitAmount, assetCardResult.remainingCardLimitAmount) && Intrinsics.areEqual(this.sequence, assetCardResult.sequence) && Intrinsics.areEqual(this.installmentPeriod, assetCardResult.installmentPeriod);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.assetType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bankPhoneNo;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.bindingId;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        Boolean bool = this.canUse;
        int hashCode4 = bool == null ? 0 : bool.hashCode();
        String str4 = this.cardBin;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.cardIndexNo;
        int hashCode6 = str5 == null ? 0 : str5.hashCode();
        Integer num = this.cardNoLength;
        int hashCode7 = num == null ? 0 : num.hashCode();
        String str6 = this.cardScheme;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        Boolean bool2 = this.defaultOption;
        int hashCode9 = bool2 == null ? 0 : bool2.hashCode();
        String str7 = this.deviceId;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        Boolean bool3 = this.directDebit;
        int hashCode11 = bool3 == null ? 0 : bool3.hashCode();
        String str8 = this.disableReason;
        int hashCode12 = str8 == null ? 0 : str8.hashCode();
        Boolean bool4 = this.enableStatus;
        int hashCode13 = bool4 == null ? 0 : bool4.hashCode();
        String str9 = this.expiryMonth;
        int hashCode14 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.expiryYear;
        int hashCode15 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.instId;
        int hashCode16 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.instName;
        int hashCode17 = str12 == null ? 0 : str12.hashCode();
        Boolean bool5 = this.instSupportDirectDebit;
        int hashCode18 = bool5 == null ? 0 : bool5.hashCode();
        String str13 = this.limitMaximum;
        int hashCode19 = str13 == null ? 0 : str13.hashCode();
        Long l = this.lastPayTime;
        int hashCode20 = l == null ? 0 : l.hashCode();
        String str14 = this.maskedCardNo;
        int hashCode21 = str14 == null ? 0 : str14.hashCode();
        Integer num2 = this.order;
        int hashCode22 = num2 == null ? 0 : num2.hashCode();
        String str15 = this.payMethod;
        int hashCode23 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.payOption;
        int hashCode24 = str16 == null ? 0 : str16.hashCode();
        List<String> list = this.payVerifyElements;
        int hashCode25 = list == null ? 0 : list.hashCode();
        PromoInfoResult promoInfoResult = this.promo;
        int hashCode26 = promoInfoResult == null ? 0 : promoInfoResult.hashCode();
        String str17 = this.type;
        int hashCode27 = str17 == null ? 0 : str17.hashCode();
        List<String> list2 = this.verifyElements;
        int hashCode28 = list2 == null ? 0 : list2.hashCode();
        String str18 = this.xcoId;
        int hashCode29 = str18 == null ? 0 : str18.hashCode();
        DailyLimitAmountConfResult dailyLimitAmountConfResult = this.dailyLimitAmountConf;
        int hashCode30 = dailyLimitAmountConfResult == null ? 0 : dailyLimitAmountConfResult.hashCode();
        Boolean bool6 = this.defaultCard;
        int hashCode31 = bool6 == null ? 0 : bool6.hashCode();
        ExtendInfoResult extendInfoResult = this.extendInfo;
        int hashCode32 = extendInfoResult == null ? 0 : extendInfoResult.hashCode();
        HolderName holderName = this.holderName;
        int hashCode33 = holderName == null ? 0 : holderName.hashCode();
        Boolean bool7 = this.payWithoutCvv;
        int hashCode34 = bool7 == null ? 0 : bool7.hashCode();
        RemainingCardLimitAmountResult remainingCardLimitAmountResult = this.remainingCardLimitAmount;
        int hashCode35 = remainingCardLimitAmountResult == null ? 0 : remainingCardLimitAmountResult.hashCode();
        Long l2 = this.sequence;
        int hashCode36 = l2 == null ? 0 : l2.hashCode();
        Integer num3 = this.installmentPeriod;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + (num3 != null ? num3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AssetCardResult(assetType=");
        sb.append(this.assetType);
        sb.append(", bankPhoneNo=");
        sb.append(this.bankPhoneNo);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", canUse=");
        sb.append(this.canUse);
        sb.append(", cardBin=");
        sb.append(this.cardBin);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", cardNoLength=");
        sb.append(this.cardNoLength);
        sb.append(", cardScheme=");
        sb.append(this.cardScheme);
        sb.append(", defaultOption=");
        sb.append(this.defaultOption);
        sb.append(", deviceId=");
        sb.append(this.deviceId);
        sb.append(", directDebit=");
        sb.append(this.directDebit);
        sb.append(", disableReason=");
        sb.append(this.disableReason);
        sb.append(", enableStatus=");
        sb.append(this.enableStatus);
        sb.append(", expiryMonth=");
        sb.append(this.expiryMonth);
        sb.append(", expiryYear=");
        sb.append(this.expiryYear);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", instName=");
        sb.append(this.instName);
        sb.append(", instSupportDirectDebit=");
        sb.append(this.instSupportDirectDebit);
        sb.append(", limitMaximum=");
        sb.append(this.limitMaximum);
        sb.append(", lastPayTime=");
        sb.append(this.lastPayTime);
        sb.append(", maskedCardNo=");
        sb.append(this.maskedCardNo);
        sb.append(", order=");
        sb.append(this.order);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", payOption=");
        sb.append(this.payOption);
        sb.append(", payVerifyElements=");
        sb.append(this.payVerifyElements);
        sb.append(", promo=");
        sb.append(this.promo);
        sb.append(", type=");
        sb.append(this.type);
        sb.append(", verifyElements=");
        sb.append(this.verifyElements);
        sb.append(", xcoId=");
        sb.append(this.xcoId);
        sb.append(", dailyLimitAmountConf=");
        sb.append(this.dailyLimitAmountConf);
        sb.append(", defaultCard=");
        sb.append(this.defaultCard);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(", holderName=");
        sb.append(this.holderName);
        sb.append(", payWithoutCvv=");
        sb.append(this.payWithoutCvv);
        sb.append(", remainingCardLimitAmount=");
        sb.append(this.remainingCardLimitAmount);
        sb.append(", sequence=");
        sb.append(this.sequence);
        sb.append(", installmentPeriod=");
        sb.append(this.installmentPeriod);
        sb.append(')');
        return sb.toString();
    }

    public AssetCardResult(String str, String str2, String str3, Boolean bool, String str4, String str5, Integer num, String str6, Boolean bool2, String str7, Boolean bool3, String str8, Boolean bool4, String str9, String str10, String str11, String str12, Boolean bool5, String str13, Long l, String str14, Integer num2, String str15, String str16, List<String> list, PromoInfoResult promoInfoResult, String str17, List<String> list2, String str18, DailyLimitAmountConfResult dailyLimitAmountConfResult, Boolean bool6, ExtendInfoResult extendInfoResult, HolderName holderName, Boolean bool7, RemainingCardLimitAmountResult remainingCardLimitAmountResult, Long l2, Integer num3) {
        this.assetType = str;
        this.bankPhoneNo = str2;
        this.bindingId = str3;
        this.canUse = bool;
        this.cardBin = str4;
        this.cardIndexNo = str5;
        this.cardNoLength = num;
        this.cardScheme = str6;
        this.defaultOption = bool2;
        this.deviceId = str7;
        this.directDebit = bool3;
        this.disableReason = str8;
        this.enableStatus = bool4;
        this.expiryMonth = str9;
        this.expiryYear = str10;
        this.instId = str11;
        this.instName = str12;
        this.instSupportDirectDebit = bool5;
        this.limitMaximum = str13;
        this.lastPayTime = l;
        this.maskedCardNo = str14;
        this.order = num2;
        this.payMethod = str15;
        this.payOption = str16;
        this.payVerifyElements = list;
        this.promo = promoInfoResult;
        this.type = str17;
        this.verifyElements = list2;
        this.xcoId = str18;
        this.dailyLimitAmountConf = dailyLimitAmountConfResult;
        this.defaultCard = bool6;
        this.extendInfo = extendInfoResult;
        this.holderName = holderName;
        this.payWithoutCvv = bool7;
        this.remainingCardLimitAmount = remainingCardLimitAmountResult;
        this.sequence = l2;
        this.installmentPeriod = num3;
    }

    public /* synthetic */ AssetCardResult(String str, String str2, String str3, Boolean bool, String str4, String str5, Integer num, String str6, Boolean bool2, String str7, Boolean bool3, String str8, Boolean bool4, String str9, String str10, String str11, String str12, Boolean bool5, String str13, Long l, String str14, Integer num2, String str15, String str16, List list, PromoInfoResult promoInfoResult, String str17, List list2, String str18, DailyLimitAmountConfResult dailyLimitAmountConfResult, Boolean bool6, ExtendInfoResult extendInfoResult, HolderName holderName, Boolean bool7, RemainingCardLimitAmountResult remainingCardLimitAmountResult, Long l2, Integer num3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, bool, str4, str5, num, str6, bool2, str7, bool3, str8, bool4, str9, str10, str11, str12, bool5, str13, l, str14, num2, str15, str16, list, promoInfoResult, str17, list2, str18, dailyLimitAmountConfResult, (i & 1073741824) != 0 ? null : bool6, (i & Integer.MIN_VALUE) != 0 ? null : extendInfoResult, (i2 & 1) != 0 ? null : holderName, (i2 & 2) != 0 ? null : bool7, (i2 & 4) != 0 ? null : remainingCardLimitAmountResult, (i2 & 8) != 0 ? null : l2, (i2 & 16) != 0 ? null : num3);
    }

    @JvmName(name = "getAssetType")
    public final String getAssetType() {
        return this.assetType;
    }

    @JvmName(name = "getBankPhoneNo")
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "getCanUse")
    public final Boolean getCanUse() {
        return this.canUse;
    }

    @JvmName(name = "getCardBin")
    public final String getCardBin() {
        return this.cardBin;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getCardNoLength")
    public final Integer getCardNoLength() {
        return this.cardNoLength;
    }

    @JvmName(name = "getCardScheme")
    public final String getCardScheme() {
        return this.cardScheme;
    }

    @JvmName(name = "getDefaultOption")
    public final Boolean getDefaultOption() {
        return this.defaultOption;
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    @JvmName(name = "getDirectDebit")
    public final Boolean getDirectDebit() {
        return this.directDebit;
    }

    @JvmName(name = "getDisableReason")
    public final String getDisableReason() {
        return this.disableReason;
    }

    @JvmName(name = "getEnableStatus")
    public final Boolean getEnableStatus() {
        return this.enableStatus;
    }

    @JvmName(name = "getExpiryMonth")
    public final String getExpiryMonth() {
        return this.expiryMonth;
    }

    @JvmName(name = "getExpiryYear")
    public final String getExpiryYear() {
        return this.expiryYear;
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

    @JvmName(name = "getLimitMaximum")
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    @JvmName(name = "getLastPayTime")
    public final Long getLastPayTime() {
        return this.lastPayTime;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    @JvmName(name = "getOrder")
    public final Integer getOrder() {
        return this.order;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getPayOption")
    public final String getPayOption() {
        return this.payOption;
    }

    @JvmName(name = "getPayVerifyElements")
    public final List<String> getPayVerifyElements() {
        return this.payVerifyElements;
    }

    @JvmName(name = "getPromo")
    public final PromoInfoResult getPromo() {
        return this.promo;
    }

    @JvmName(name = "getType")
    public final String getType() {
        return this.type;
    }

    @JvmName(name = "getVerifyElements")
    public final List<String> getVerifyElements() {
        return this.verifyElements;
    }

    @JvmName(name = "getXcoId")
    public final String getXcoId() {
        return this.xcoId;
    }

    @JvmName(name = "getDailyLimitAmountConf")
    public final DailyLimitAmountConfResult getDailyLimitAmountConf() {
        return this.dailyLimitAmountConf;
    }

    @JvmName(name = "getDefaultCard")
    public final Boolean getDefaultCard() {
        return this.defaultCard;
    }

    @JvmName(name = "getExtendInfo")
    public final ExtendInfoResult getExtendInfo() {
        return this.extendInfo;
    }

    @JvmName(name = "getHolderName")
    public final HolderName getHolderName() {
        return this.holderName;
    }

    @JvmName(name = "getPayWithoutCvv")
    public final Boolean getPayWithoutCvv() {
        return this.payWithoutCvv;
    }

    @JvmName(name = "getRemainingCardLimitAmount")
    public final RemainingCardLimitAmountResult getRemainingCardLimitAmount() {
        return this.remainingCardLimitAmount;
    }

    @JvmName(name = "getSequence")
    public final Long getSequence() {
        return this.sequence;
    }

    @JvmName(name = "getInstallmentPeriod")
    public final Integer getInstallmentPeriod() {
        return this.installmentPeriod;
    }
}
