package id.dana.cashier.data.repository.source.network.result;

import com.google.gson.annotations.SerializedName;
import id.dana.data.model.cashier.PayMethodRiskResult;
import id.dana.data.payasset.source.network.result.AmountRangeResult;
import id.dana.data.paylater.repository.source.network.result.DanaCreditResult;
import id.dana.data.paylater.repository.source.network.result.LoanCreditChannelInfosResult;
import id.dana.data.paylater.repository.source.network.result.RepaymentPlanResult;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bh\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0003\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010D\u001a\u0004\u0018\u00010+\u0012\b\u0010E\u001a\u0004\u0018\u00010+\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010G\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010M\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010N\u001a\u0004\u0018\u00010\n\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010S\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010V\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010W\u001a\u0004\u0018\u00010\u001a\u0012\b\u0010X\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010Y\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010Z\u001a\u0004\u0018\u00010\u001f\u0012\u000e\u0010[\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010+\u0012\b\u0010d\u001a\u0004\u0018\u000103\u0012\u000e\u0010e\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\"\u0012\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\"\u0012\u0010\b\u0002\u0010g\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\"¢\u0006\u0006\b¡\u0001\u0010¢\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u0010\u0010\tJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b&\u0010\tJ\u0012\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b*\u0010\tJ\u0012\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u0004J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010\u0004J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u0004J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010\u0004J\u0012\u00102\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0004\b2\u0010-J\u0012\u00104\u001a\u0004\u0018\u000103HÆ\u0003¢\u0006\u0004\b4\u00105J\u0018\u00107\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b7\u0010%J\u0018\u00109\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b9\u0010%J\u0018\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b;\u0010%J\u0012\u0010<\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0004\b<\u0010-J\u0012\u0010=\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b=\u0010\u0004J\u0012\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b>\u0010\tJ\u0012\u0010?\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b?\u0010\u0004J\u0018\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"HÆ\u0003¢\u0006\u0004\b@\u0010%J\u0012\u0010A\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\bA\u0010\tJö\u0003\u0010h\u001a\u00020\u00002\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010W\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u001f2\u0010\b\u0002\u0010[\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010]\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010c\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010d\u001a\u0004\u0018\u0001032\u0010\b\u0002\u0010e\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\"2\u0010\b\u0002\u0010f\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\"2\u0010\b\u0002\u0010g\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\"HÆ\u0001¢\u0006\u0004\bh\u0010iJ\u001a\u0010k\u001a\u00020\u00072\b\u0010j\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bk\u0010lJ\u0010\u0010m\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bo\u0010\u0004R\"\u0010f\u001a\n\u0012\u0004\u0012\u000208\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010p\u001a\u0004\bq\u0010%R\u001c\u0010]\u001a\u0004\u0018\u00010'8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b]\u0010r\u001a\u0004\bs\u0010)R\u001c\u0010D\u001a\u0004\u0018\u00010+8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010t\u001a\u0004\bu\u0010-R\u001c\u0010B\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010v\u001a\u0004\bw\u0010\u0004R\u001c\u0010C\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010v\u001a\u0004\bx\u0010\u0004R\u001c\u0010F\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bF\u0010v\u001a\u0004\by\u0010\u0004R\u001c\u0010G\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\bG\u0010z\u001a\u0004\b{\u0010\tR\u001c\u0010H\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010v\u001a\u0004\b|\u0010\u0004R\"\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010p\u001a\u0004\b}\u0010%R\u001c\u0010E\u001a\u0004\u0018\u00010+8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010t\u001a\u0004\b~\u0010-R\u001c\u0010a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\ba\u0010v\u001a\u0004\b\u007f\u0010\u0004R\u001e\u0010d\u001a\u0004\u0018\u0001038\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bd\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u00105R\u001d\u0010J\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\r\n\u0004\bJ\u0010z\u001a\u0005\b\u0082\u0001\u0010\tR\u001d\u0010K\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bK\u0010v\u001a\u0005\b\u0083\u0001\u0010\u0004R\u001d\u0010L\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bL\u0010v\u001a\u0005\b\u0084\u0001\u0010\u0004R\u001d\u0010M\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\r\n\u0004\bM\u0010z\u001a\u0005\b\u0085\u0001\u0010\tR\u001e\u0010N\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bN\u0010\u0086\u0001\u001a\u0005\b\u0087\u0001\u0010\fR\u001d\u0010c\u001a\u0004\u0018\u00010+8\u0007X\u0087\u0004¢\u0006\r\n\u0004\bc\u0010t\u001a\u0005\b\u0088\u0001\u0010-R\u001d\u0010O\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bO\u0010v\u001a\u0005\b\u0089\u0001\u0010\u0004R\u001d\u0010P\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bP\u0010v\u001a\u0005\b\u008a\u0001\u0010\u0004R\u001d\u0010Q\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bQ\u0010v\u001a\u0005\b\u008b\u0001\u0010\u0004R\u001d\u0010R\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\r\n\u0004\bR\u0010z\u001a\u0005\b\u008c\u0001\u0010\tR\u001d\u0010^\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\r\n\u0004\b^\u0010z\u001a\u0005\b\u008d\u0001\u0010\tR#\u0010g\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\r\n\u0004\bg\u0010p\u001a\u0005\b\u008e\u0001\u0010%R\u001e\u0010S\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bS\u0010\u008f\u0001\u001a\u0005\b\u0090\u0001\u0010\u0013R\u001d\u0010T\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bT\u0010v\u001a\u0005\b\u0091\u0001\u0010\u0004R\u001d\u0010_\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b_\u0010v\u001a\u0005\b\u0092\u0001\u0010\u0004R\u001d\u0010U\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bU\u0010v\u001a\u0005\b\u0093\u0001\u0010\u0004R\u001e\u0010V\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bV\u0010\u0094\u0001\u001a\u0005\b\u0095\u0001\u0010\u0019R\u001d\u0010`\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b`\u0010v\u001a\u0005\b\u0096\u0001\u0010\u0004R\u001d\u0010\\\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\r\n\u0004\b\\\u0010z\u001a\u0005\b\u0097\u0001\u0010\tR\u001e\u0010W\u001a\u0004\u0018\u00010\u001a8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bW\u0010\u0098\u0001\u001a\u0005\b\u0099\u0001\u0010\u001cR#\u0010e\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\r\n\u0004\be\u0010p\u001a\u0005\b\u009a\u0001\u0010%R\u001d\u0010b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bb\u0010v\u001a\u0005\b\u009b\u0001\u0010\u0004R\u001d\u0010X\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bX\u0010v\u001a\u0005\b\u009c\u0001\u0010\u0004R\u001d\u0010Y\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bY\u0010v\u001a\u0005\b\u009d\u0001\u0010\u0004R\u001e\u0010Z\u001a\u0004\u0018\u00010\u001f8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bZ\u0010\u009e\u0001\u001a\u0005\b\u009f\u0001\u0010!R#\u0010[\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"8\u0007X\u0087\u0004¢\u0006\r\n\u0004\b[\u0010p\u001a\u0005\b \u0001\u0010%"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/PayChannelResult;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "component12", "()Ljava/lang/Boolean;", "Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "component13", "()Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "component14", "component15", "component16", "component17", "", "component18", "()Ljava/lang/Integer;", "component19", "component2", "component20", "Lid/dana/data/model/cashier/PayMethodRiskResult;", "component21", "()Lid/dana/data/model/cashier/PayMethodRiskResult;", "Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "component22", "()Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "component23", "component24", "Lid/dana/cashier/data/repository/source/network/result/ViewConfigInfoResult;", "component25", "()Lid/dana/cashier/data/repository/source/network/result/ViewConfigInfoResult;", "", "Lid/dana/cashier/data/repository/source/network/result/VoucherInfoResult;", "component26", "()Ljava/util/List;", "component27", "Lid/dana/data/payasset/source/network/result/AmountRangeResult;", "component28", "()Lid/dana/data/payasset/source/network/result/AmountRangeResult;", "component29", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component3", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "component30", "component31", "component32", "component33", "component34", "Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "component35", "()Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "Lid/dana/data/paylater/repository/source/network/result/RepaymentPlanResult;", "component36", "Lid/dana/cashier/data/repository/source/network/result/AddOnChannelSupportInfosResult;", "component37", "Lid/dana/data/paylater/repository/source/network/result/LoanCreditChannelInfosResult;", "component38", "component4", "component5", "component6", "component7", "component8", "component9", "bankCode", "bankName", "balanceAmount", "chargeAmount", "bankPhoneNo", "canUse", "cardBrand", "cardBrands", "directDebit", "disableCode", "disableReason", "enableStatus", "extendInfo", "index", "instId", "instName", "instSupportDirectDebit", "maxPeriod", "name", "payMethod", "payMethodRiskResult", "promo", "serviceInstId", "serviceInstName", "viewConfig", "voucherList", "pivotCard", "amountRange", "interBank", "payAccountNo", "payOption", "companyCode", "serviceBankCode", "foreignBalanceAmount", "danaCredit", "repaymentPlans", "addOnChannelSupportInfosResult", "loanCreditChannelInfos", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/model/cashier/PayMethodRiskResult;Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/ViewConfigInfoResult;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/data/payasset/source/network/result/AmountRangeResult;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lid/dana/cashier/data/repository/source/network/result/PayChannelResult;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/util/List;", "getAddOnChannelSupportInfosResult", "Lid/dana/data/payasset/source/network/result/AmountRangeResult;", "getAmountRange", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getBalanceAmount", "Ljava/lang/String;", "getBankCode", "getBankName", "getBankPhoneNo", "Ljava/lang/Boolean;", "getCanUse", "getCardBrand", "getCardBrands", "getChargeAmount", "getCompanyCode", "Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;", "getDanaCredit", "getDirectDebit", "getDisableCode", "getDisableReason", "getEnableStatus", "Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;", "getExtendInfo", "getForeignBalanceAmount", "getIndex", "getInstId", "getInstName", "getInstSupportDirectDebit", "getInterBank", "getLoanCreditChannelInfos", "Ljava/lang/Integer;", "getMaxPeriod", "getName", "getPayAccountNo", "getPayMethod", "Lid/dana/data/model/cashier/PayMethodRiskResult;", "getPayMethodRiskResult", "getPayOption", "getPivotCard", "Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;", "getPromo", "getRepaymentPlans", "getServiceBankCode", "getServiceInstId", "getServiceInstName", "Lid/dana/cashier/data/repository/source/network/result/ViewConfigInfoResult;", "getViewConfig", "getVoucherList", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lid/dana/cashier/data/repository/source/network/result/ExtendInfoResult;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lid/dana/data/model/cashier/PayMethodRiskResult;Lid/dana/cashier/data/repository/source/network/result/PromoInfoResult;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/data/repository/source/network/result/ViewConfigInfoResult;Ljava/util/List;Ljava/lang/Boolean;Lid/dana/data/payasset/source/network/result/AmountRangeResult;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/network/response/expresspurchase/MoneyViewEntity;Lid/dana/data/paylater/repository/source/network/result/DanaCreditResult;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PayChannelResult {
    @SerializedName("addOnChannelSupportInfos")
    private final List<AddOnChannelSupportInfosResult> addOnChannelSupportInfosResult;
    private final AmountRangeResult amountRange;
    private final MoneyViewEntity balanceAmount;
    @SerializedName("bankCode")
    private final String bankCode;
    private final String bankName;
    private final String bankPhoneNo;
    private final Boolean canUse;
    private final String cardBrand;
    private final List<String> cardBrands;
    private final MoneyViewEntity chargeAmount;
    private final String companyCode;
    private final DanaCreditResult danaCredit;
    private final Boolean directDebit;
    private final String disableCode;
    private final String disableReason;
    private final Boolean enableStatus;
    private final ExtendInfoResult extendInfo;
    private final MoneyViewEntity foreignBalanceAmount;
    private final String index;
    private final String instId;
    private final String instName;
    private final Boolean instSupportDirectDebit;
    private final Boolean interBank;
    @SerializedName("loanCreditChannelInfos")
    private final List<LoanCreditChannelInfosResult> loanCreditChannelInfos;
    private final Integer maxPeriod;
    private final String name;
    private final String payAccountNo;
    private final String payMethod;
    private final PayMethodRiskResult payMethodRiskResult;
    private final String payOption;
    private final Boolean pivotCard;
    private final PromoInfoResult promo;
    private final List<RepaymentPlanResult> repaymentPlans;
    private final String serviceBankCode;
    private final String serviceInstId;
    private final String serviceInstName;
    private final ViewConfigInfoResult viewConfig;
    private final List<VoucherInfoResult> voucherList;

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
    public final ExtendInfoResult getExtendInfo() {
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
    public final PayMethodRiskResult getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    /* renamed from: component22  reason: from getter */
    public final PromoInfoResult getPromo() {
        return this.promo;
    }

    /* renamed from: component23  reason: from getter */
    public final String getServiceInstId() {
        return this.serviceInstId;
    }

    /* renamed from: component24  reason: from getter */
    public final String getServiceInstName() {
        return this.serviceInstName;
    }

    /* renamed from: component25  reason: from getter */
    public final ViewConfigInfoResult getViewConfig() {
        return this.viewConfig;
    }

    public final List<VoucherInfoResult> component26() {
        return this.voucherList;
    }

    /* renamed from: component27  reason: from getter */
    public final Boolean getPivotCard() {
        return this.pivotCard;
    }

    /* renamed from: component28  reason: from getter */
    public final AmountRangeResult getAmountRange() {
        return this.amountRange;
    }

    /* renamed from: component29  reason: from getter */
    public final Boolean getInterBank() {
        return this.interBank;
    }

    /* renamed from: component3  reason: from getter */
    public final MoneyViewEntity getBalanceAmount() {
        return this.balanceAmount;
    }

    /* renamed from: component30  reason: from getter */
    public final String getPayAccountNo() {
        return this.payAccountNo;
    }

    /* renamed from: component31  reason: from getter */
    public final String getPayOption() {
        return this.payOption;
    }

    /* renamed from: component32  reason: from getter */
    public final String getCompanyCode() {
        return this.companyCode;
    }

    /* renamed from: component33  reason: from getter */
    public final String getServiceBankCode() {
        return this.serviceBankCode;
    }

    /* renamed from: component34  reason: from getter */
    public final MoneyViewEntity getForeignBalanceAmount() {
        return this.foreignBalanceAmount;
    }

    /* renamed from: component35  reason: from getter */
    public final DanaCreditResult getDanaCredit() {
        return this.danaCredit;
    }

    public final List<RepaymentPlanResult> component36() {
        return this.repaymentPlans;
    }

    public final List<AddOnChannelSupportInfosResult> component37() {
        return this.addOnChannelSupportInfosResult;
    }

    public final List<LoanCreditChannelInfosResult> component38() {
        return this.loanCreditChannelInfos;
    }

    /* renamed from: component4  reason: from getter */
    public final MoneyViewEntity getChargeAmount() {
        return this.chargeAmount;
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

    public final PayChannelResult copy(String bankCode, String bankName, MoneyViewEntity balanceAmount, MoneyViewEntity chargeAmount, String bankPhoneNo, Boolean canUse, String cardBrand, List<String> cardBrands, Boolean directDebit, String disableCode, String disableReason, Boolean enableStatus, ExtendInfoResult extendInfo, String index, String instId, String instName, Boolean instSupportDirectDebit, Integer maxPeriod, String name, String payMethod, PayMethodRiskResult payMethodRiskResult, PromoInfoResult promo, String serviceInstId, String serviceInstName, ViewConfigInfoResult viewConfig, List<VoucherInfoResult> voucherList, Boolean pivotCard, AmountRangeResult amountRange, Boolean interBank, String payAccountNo, String payOption, String companyCode, String serviceBankCode, MoneyViewEntity foreignBalanceAmount, DanaCreditResult danaCredit, List<RepaymentPlanResult> repaymentPlans, List<AddOnChannelSupportInfosResult> addOnChannelSupportInfosResult, List<LoanCreditChannelInfosResult> loanCreditChannelInfos) {
        return new PayChannelResult(bankCode, bankName, balanceAmount, chargeAmount, bankPhoneNo, canUse, cardBrand, cardBrands, directDebit, disableCode, disableReason, enableStatus, extendInfo, index, instId, instName, instSupportDirectDebit, maxPeriod, name, payMethod, payMethodRiskResult, promo, serviceInstId, serviceInstName, viewConfig, voucherList, pivotCard, amountRange, interBank, payAccountNo, payOption, companyCode, serviceBankCode, foreignBalanceAmount, danaCredit, repaymentPlans, addOnChannelSupportInfosResult, loanCreditChannelInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PayChannelResult) {
            PayChannelResult payChannelResult = (PayChannelResult) other;
            return Intrinsics.areEqual(this.bankCode, payChannelResult.bankCode) && Intrinsics.areEqual(this.bankName, payChannelResult.bankName) && Intrinsics.areEqual(this.balanceAmount, payChannelResult.balanceAmount) && Intrinsics.areEqual(this.chargeAmount, payChannelResult.chargeAmount) && Intrinsics.areEqual(this.bankPhoneNo, payChannelResult.bankPhoneNo) && Intrinsics.areEqual(this.canUse, payChannelResult.canUse) && Intrinsics.areEqual(this.cardBrand, payChannelResult.cardBrand) && Intrinsics.areEqual(this.cardBrands, payChannelResult.cardBrands) && Intrinsics.areEqual(this.directDebit, payChannelResult.directDebit) && Intrinsics.areEqual(this.disableCode, payChannelResult.disableCode) && Intrinsics.areEqual(this.disableReason, payChannelResult.disableReason) && Intrinsics.areEqual(this.enableStatus, payChannelResult.enableStatus) && Intrinsics.areEqual(this.extendInfo, payChannelResult.extendInfo) && Intrinsics.areEqual(this.index, payChannelResult.index) && Intrinsics.areEqual(this.instId, payChannelResult.instId) && Intrinsics.areEqual(this.instName, payChannelResult.instName) && Intrinsics.areEqual(this.instSupportDirectDebit, payChannelResult.instSupportDirectDebit) && Intrinsics.areEqual(this.maxPeriod, payChannelResult.maxPeriod) && Intrinsics.areEqual(this.name, payChannelResult.name) && Intrinsics.areEqual(this.payMethod, payChannelResult.payMethod) && Intrinsics.areEqual(this.payMethodRiskResult, payChannelResult.payMethodRiskResult) && Intrinsics.areEqual(this.promo, payChannelResult.promo) && Intrinsics.areEqual(this.serviceInstId, payChannelResult.serviceInstId) && Intrinsics.areEqual(this.serviceInstName, payChannelResult.serviceInstName) && Intrinsics.areEqual(this.viewConfig, payChannelResult.viewConfig) && Intrinsics.areEqual(this.voucherList, payChannelResult.voucherList) && Intrinsics.areEqual(this.pivotCard, payChannelResult.pivotCard) && Intrinsics.areEqual(this.amountRange, payChannelResult.amountRange) && Intrinsics.areEqual(this.interBank, payChannelResult.interBank) && Intrinsics.areEqual(this.payAccountNo, payChannelResult.payAccountNo) && Intrinsics.areEqual(this.payOption, payChannelResult.payOption) && Intrinsics.areEqual(this.companyCode, payChannelResult.companyCode) && Intrinsics.areEqual(this.serviceBankCode, payChannelResult.serviceBankCode) && Intrinsics.areEqual(this.foreignBalanceAmount, payChannelResult.foreignBalanceAmount) && Intrinsics.areEqual(this.danaCredit, payChannelResult.danaCredit) && Intrinsics.areEqual(this.repaymentPlans, payChannelResult.repaymentPlans) && Intrinsics.areEqual(this.addOnChannelSupportInfosResult, payChannelResult.addOnChannelSupportInfosResult) && Intrinsics.areEqual(this.loanCreditChannelInfos, payChannelResult.loanCreditChannelInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bankCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bankName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        MoneyViewEntity moneyViewEntity = this.balanceAmount;
        int hashCode3 = moneyViewEntity == null ? 0 : moneyViewEntity.hashCode();
        MoneyViewEntity moneyViewEntity2 = this.chargeAmount;
        int hashCode4 = moneyViewEntity2 == null ? 0 : moneyViewEntity2.hashCode();
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
        ExtendInfoResult extendInfoResult = this.extendInfo;
        int hashCode13 = extendInfoResult == null ? 0 : extendInfoResult.hashCode();
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
        PayMethodRiskResult payMethodRiskResult = this.payMethodRiskResult;
        int hashCode21 = payMethodRiskResult == null ? 0 : payMethodRiskResult.hashCode();
        PromoInfoResult promoInfoResult = this.promo;
        int hashCode22 = promoInfoResult == null ? 0 : promoInfoResult.hashCode();
        String str12 = this.serviceInstId;
        int hashCode23 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.serviceInstName;
        int hashCode24 = str13 == null ? 0 : str13.hashCode();
        ViewConfigInfoResult viewConfigInfoResult = this.viewConfig;
        int hashCode25 = viewConfigInfoResult == null ? 0 : viewConfigInfoResult.hashCode();
        List<VoucherInfoResult> list2 = this.voucherList;
        int hashCode26 = list2 == null ? 0 : list2.hashCode();
        Boolean bool5 = this.pivotCard;
        int hashCode27 = bool5 == null ? 0 : bool5.hashCode();
        AmountRangeResult amountRangeResult = this.amountRange;
        int hashCode28 = amountRangeResult == null ? 0 : amountRangeResult.hashCode();
        Boolean bool6 = this.interBank;
        int hashCode29 = bool6 == null ? 0 : bool6.hashCode();
        String str14 = this.payAccountNo;
        int hashCode30 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.payOption;
        int hashCode31 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.companyCode;
        int hashCode32 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.serviceBankCode;
        int hashCode33 = str17 == null ? 0 : str17.hashCode();
        MoneyViewEntity moneyViewEntity3 = this.foreignBalanceAmount;
        int hashCode34 = moneyViewEntity3 == null ? 0 : moneyViewEntity3.hashCode();
        DanaCreditResult danaCreditResult = this.danaCredit;
        int hashCode35 = danaCreditResult == null ? 0 : danaCreditResult.hashCode();
        List<RepaymentPlanResult> list3 = this.repaymentPlans;
        int hashCode36 = list3 == null ? 0 : list3.hashCode();
        List<AddOnChannelSupportInfosResult> list4 = this.addOnChannelSupportInfosResult;
        int hashCode37 = list4 == null ? 0 : list4.hashCode();
        List<LoanCreditChannelInfosResult> list5 = this.loanCreditChannelInfos;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + (list5 != null ? list5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PayChannelResult(bankCode=");
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
        sb.append(", promo=");
        sb.append(this.promo);
        sb.append(", serviceInstId=");
        sb.append(this.serviceInstId);
        sb.append(", serviceInstName=");
        sb.append(this.serviceInstName);
        sb.append(", viewConfig=");
        sb.append(this.viewConfig);
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
        sb.append(", foreignBalanceAmount=");
        sb.append(this.foreignBalanceAmount);
        sb.append(", danaCredit=");
        sb.append(this.danaCredit);
        sb.append(", repaymentPlans=");
        sb.append(this.repaymentPlans);
        sb.append(", addOnChannelSupportInfosResult=");
        sb.append(this.addOnChannelSupportInfosResult);
        sb.append(", loanCreditChannelInfos=");
        sb.append(this.loanCreditChannelInfos);
        sb.append(')');
        return sb.toString();
    }

    public PayChannelResult(String str, String str2, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, String str3, Boolean bool, String str4, List<String> list, Boolean bool2, String str5, String str6, Boolean bool3, ExtendInfoResult extendInfoResult, String str7, String str8, String str9, Boolean bool4, Integer num, String str10, String str11, PayMethodRiskResult payMethodRiskResult, PromoInfoResult promoInfoResult, String str12, String str13, ViewConfigInfoResult viewConfigInfoResult, List<VoucherInfoResult> list2, Boolean bool5, AmountRangeResult amountRangeResult, Boolean bool6, String str14, String str15, String str16, String str17, MoneyViewEntity moneyViewEntity3, DanaCreditResult danaCreditResult, List<RepaymentPlanResult> list3, List<AddOnChannelSupportInfosResult> list4, List<LoanCreditChannelInfosResult> list5) {
        this.bankCode = str;
        this.bankName = str2;
        this.balanceAmount = moneyViewEntity;
        this.chargeAmount = moneyViewEntity2;
        this.bankPhoneNo = str3;
        this.canUse = bool;
        this.cardBrand = str4;
        this.cardBrands = list;
        this.directDebit = bool2;
        this.disableCode = str5;
        this.disableReason = str6;
        this.enableStatus = bool3;
        this.extendInfo = extendInfoResult;
        this.index = str7;
        this.instId = str8;
        this.instName = str9;
        this.instSupportDirectDebit = bool4;
        this.maxPeriod = num;
        this.name = str10;
        this.payMethod = str11;
        this.payMethodRiskResult = payMethodRiskResult;
        this.promo = promoInfoResult;
        this.serviceInstId = str12;
        this.serviceInstName = str13;
        this.viewConfig = viewConfigInfoResult;
        this.voucherList = list2;
        this.pivotCard = bool5;
        this.amountRange = amountRangeResult;
        this.interBank = bool6;
        this.payAccountNo = str14;
        this.payOption = str15;
        this.companyCode = str16;
        this.serviceBankCode = str17;
        this.foreignBalanceAmount = moneyViewEntity3;
        this.danaCredit = danaCreditResult;
        this.repaymentPlans = list3;
        this.addOnChannelSupportInfosResult = list4;
        this.loanCreditChannelInfos = list5;
    }

    public /* synthetic */ PayChannelResult(String str, String str2, MoneyViewEntity moneyViewEntity, MoneyViewEntity moneyViewEntity2, String str3, Boolean bool, String str4, List list, Boolean bool2, String str5, String str6, Boolean bool3, ExtendInfoResult extendInfoResult, String str7, String str8, String str9, Boolean bool4, Integer num, String str10, String str11, PayMethodRiskResult payMethodRiskResult, PromoInfoResult promoInfoResult, String str12, String str13, ViewConfigInfoResult viewConfigInfoResult, List list2, Boolean bool5, AmountRangeResult amountRangeResult, Boolean bool6, String str14, String str15, String str16, String str17, MoneyViewEntity moneyViewEntity3, DanaCreditResult danaCreditResult, List list3, List list4, List list5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, moneyViewEntity, moneyViewEntity2, str3, bool, str4, list, bool2, str5, str6, bool3, extendInfoResult, str7, str8, str9, bool4, num, str10, str11, payMethodRiskResult, promoInfoResult, str12, str13, viewConfigInfoResult, list2, bool5, (i & 134217728) != 0 ? null : amountRangeResult, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? null : bool6, (i & 536870912) != 0 ? null : str14, (i & 1073741824) != 0 ? null : str15, (i & Integer.MIN_VALUE) != 0 ? null : str16, (i2 & 1) != 0 ? null : str17, (i2 & 2) != 0 ? null : moneyViewEntity3, danaCreditResult, list3, (i2 & 16) != 0 ? null : list4, (i2 & 32) != 0 ? null : list5);
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
    public final MoneyViewEntity getBalanceAmount() {
        return this.balanceAmount;
    }

    @JvmName(name = "getChargeAmount")
    public final MoneyViewEntity getChargeAmount() {
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
    public final ExtendInfoResult getExtendInfo() {
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
    public final PayMethodRiskResult getPayMethodRiskResult() {
        return this.payMethodRiskResult;
    }

    @JvmName(name = "getPromo")
    public final PromoInfoResult getPromo() {
        return this.promo;
    }

    @JvmName(name = "getServiceInstId")
    public final String getServiceInstId() {
        return this.serviceInstId;
    }

    @JvmName(name = "getServiceInstName")
    public final String getServiceInstName() {
        return this.serviceInstName;
    }

    @JvmName(name = "getViewConfig")
    public final ViewConfigInfoResult getViewConfig() {
        return this.viewConfig;
    }

    @JvmName(name = "getVoucherList")
    public final List<VoucherInfoResult> getVoucherList() {
        return this.voucherList;
    }

    @JvmName(name = "getPivotCard")
    public final Boolean getPivotCard() {
        return this.pivotCard;
    }

    @JvmName(name = "getAmountRange")
    public final AmountRangeResult getAmountRange() {
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

    @JvmName(name = "getForeignBalanceAmount")
    public final MoneyViewEntity getForeignBalanceAmount() {
        return this.foreignBalanceAmount;
    }

    @JvmName(name = "getDanaCredit")
    public final DanaCreditResult getDanaCredit() {
        return this.danaCredit;
    }

    @JvmName(name = "getRepaymentPlans")
    public final List<RepaymentPlanResult> getRepaymentPlans() {
        return this.repaymentPlans;
    }

    @JvmName(name = "getAddOnChannelSupportInfosResult")
    public final List<AddOnChannelSupportInfosResult> getAddOnChannelSupportInfosResult() {
        return this.addOnChannelSupportInfosResult;
    }

    @JvmName(name = "getLoanCreditChannelInfos")
    public final List<LoanCreditChannelInfosResult> getLoanCreditChannelInfos() {
        return this.loanCreditChannelInfos;
    }
}
