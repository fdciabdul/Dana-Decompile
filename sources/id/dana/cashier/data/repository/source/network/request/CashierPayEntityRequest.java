package id.dana.cashier.data.repository.source.network.request;

import com.google.gson.annotations.SerializedName;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b;\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0003\u0012\u0006\u00102\u001a\u00020\u0002\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0002\u0012\b\u00105\u001a\u0004\u0018\u00010\u0002\u0012\b\u00106\u001a\u0004\u0018\u00010\u0002\u0012\b\u00107\u001a\u0004\u0018\u00010\u0002\u0012\b\u00108\u001a\u0004\u0018\u00010\u0002\u0012\b\u00109\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010P\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c\u0012\b\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010)¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0004J\u0018\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0004J\u0012\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b \u0010\u0007J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0004J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0004J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0004J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u0004J\u0018\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b%\u0010\u001eJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0004J\u0012\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b'\u0010\u0007J\u0012\u0010(\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b(\u0010\u0019J\u0012\u0010*\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010\u0004J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\u0004J\u0012\u0010.\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\u0004J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010\u0004J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u0004J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010\u0004JÊ\u0003\u0010V\u001a\u00020\u00002\b\b\u0002\u00102\u001a\u00020\u00022\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c2\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010U\u001a\u0004\u0018\u00010)HÆ\u0001¢\u0006\u0004\bV\u0010WJ\u001a\u0010Z\u001a\u00020\u00052\b\u0010Y\u001a\u0004\u0018\u00010XHÖ\u0003¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b^\u0010\u0004R\u0019\u0010B\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\bB\u0010_\u001a\u0004\b`\u0010\u0004R\u001c\u0010=\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b=\u0010_\u001a\u0004\ba\u0010\u0004R\u001c\u0010R\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bR\u0010_\u001a\u0004\bb\u0010\u0004R$\u0010T\u001a\u0004\u0018\u00010\u00178\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bT\u0010c\u001a\u0004\bd\u0010\u0019\"\u0004\be\u0010fR\u001c\u0010>\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010_\u001a\u0004\bg\u0010\u0004R\u001c\u00109\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010_\u001a\u0004\bh\u0010\u0004R\u001c\u00108\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b8\u0010_\u001a\u0004\bi\u0010\u0004R\u001c\u0010<\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010_\u001a\u0004\bj\u0010\u0004R\u001c\u0010:\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b:\u0010_\u001a\u0004\bk\u0010\u0004R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010_\u001a\u0004\bl\u0010\u0004R$\u0010G\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u0010_\u001a\u0004\bm\u0010\u0004\"\u0004\bn\u0010oR\u001c\u00106\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010_\u001a\u0004\bp\u0010\u0004R\u001c\u0010O\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010_\u001a\u0004\bq\u0010\u0004R\"\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0007X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010r\u001a\u0004\bs\u0010\u001eR\u001c\u0010P\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bP\u0010_\u001a\u0004\bt\u0010\u0004R\u001c\u0010C\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bC\u0010_\u001a\u0004\bu\u0010\u0004R\u001c\u00103\u001a\u0004\u0018\u00010\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010v\u001a\u0004\bw\u0010\u0013R\u001c\u0010L\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bL\u0010_\u001a\u0004\bx\u0010\u0004R\u001c\u0010D\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bD\u0010_\u001a\u0004\by\u0010\u0004R$\u0010E\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010_\u001a\u0004\bz\u0010\u0004\"\u0004\b{\u0010oR\u001c\u0010H\u001a\u0004\u0018\u00010\u00178\u0007X\u0087\u0004¢\u0006\f\n\u0004\bH\u0010c\u001a\u0004\b|\u0010\u0019R\u001c\u0010@\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010_\u001a\u0004\b}\u0010\u0004R\u001c\u0010A\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\bA\u0010_\u001a\u0004\b~\u0010\u0004R\u001a\u00102\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b2\u0010_\u001a\u0004\b\u007f\u0010\u0004R\u001e\u0010U\u001a\u0004\u0018\u00010)8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bU\u0010\u0080\u0001\u001a\u0005\b\u0081\u0001\u0010+R(\u0010S\u001a\u0004\u0018\u00010\u00058\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bS\u0010\u0082\u0001\u001a\u0005\b\u0083\u0001\u0010\u0007\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001d\u00107\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b7\u0010_\u001a\u0005\b\u0086\u0001\u0010\u0004R\u001d\u0010N\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bN\u0010_\u001a\u0005\b\u0087\u0001\u0010\u0004R\u001e\u0010M\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bM\u0010\u0082\u0001\u001a\u0005\b\u0088\u0001\u0010\u0007R\u001e\u0010;\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\b;\u0010\u0082\u0001\u001a\u0005\b\u0089\u0001\u0010\u0007R-\u0010Q\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c8\u0007@\u0007X\u0087\u000e¢\u0006\u0015\n\u0004\bQ\u0010r\u001a\u0005\b\u008a\u0001\u0010\u001e\"\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001d\u00104\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b4\u0010_\u001a\u0005\b\u008d\u0001\u0010\u0004R\u001d\u0010F\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bF\u0010_\u001a\u0005\b\u008e\u0001\u0010\u0004R\u001d\u0010I\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bI\u0010_\u001a\u0005\b\u008f\u0001\u0010\u0004R\u001d\u0010J\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\bJ\u0010_\u001a\u0005\b\u0090\u0001\u0010\u0004R\u001d\u0010?\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\r\n\u0004\b?\u0010_\u001a\u0005\b\u0091\u0001\u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;", "Lid/dana/cashier/data/repository/source/network/request/BaseRpcRequestWithCity;", "", "component1", "()Ljava/lang/String;", "", "component10", "()Ljava/lang/Boolean;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "component2", "()Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "component20", "component21", "component22", "", "component23", "()Ljava/lang/Integer;", "component24", "component25", "", "component26", "()Ljava/util/List;", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "Lid/dana/cashier/data/repository/source/network/request/MixPayMethodRequest;", "component36", "()Lid/dana/cashier/data/repository/source/network/request/MixPayMethodRequest;", "component4", "component5", "component6", "component7", "component8", "component9", "method", "externalInfo", "transType", CashierKeyParams.CASHIER_ORDER_ID, "channelIndex", "payMethod", CardCredInfo.CARD_EXPIRE_YEAR, CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_NO, "saveCard", WalletConstant.CARD_INDEX_NO, "bindingId", "cardCredential", "xcoId", "limitMaximum", "maskedCardNo", "bankPhoneNo", "deviceId", "instCode", "instId", "validateData", "cashierRequestId", CashierKeyParams.INSTALLMENT_PERIOD, CashierKeyParams.VERIFICATION_METHOD, "version", "couponIds", "inUrl", "reloadRequest", "payMethodFilter", "cityName", "cvv2", "selectedAddons", "bizOrderId", "mixPaymentRequest", "bukaCreditAmount", "mixPayMethod", "copy", "(Ljava/lang/String;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lid/dana/cashier/data/repository/source/network/request/MixPayMethodRequest;)Lid/dana/cashier/data/repository/source/network/request/CashierPayEntityRequest;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBankPhoneNo", "getBindingId", "getBizOrderId", "Ljava/lang/Integer;", "getBukaCreditAmount", "setBukaCreditAmount", "(Ljava/lang/Integer;)V", "getCardCredential", "getCardExpireMonth", "getCardExpireYear", "getCardIndexNo", "getCardNo", "getCashierOrderId", "getCashierRequestId", "setCashierRequestId", "(Ljava/lang/String;)V", "getChannelIndex", "getCityName", "Ljava/util/List;", "getCouponIds", "getCvv2", "getDeviceId", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "getExternalInfo", "getInUrl", "getInstCode", "getInstId", "setInstId", "getInstallmentPeriod", "getLimitMaximum", "getMaskedCardNo", "getMethod", "Lid/dana/cashier/data/repository/source/network/request/MixPayMethodRequest;", "getMixPayMethod", "Ljava/lang/Boolean;", "getMixPaymentRequest", "setMixPaymentRequest", "(Ljava/lang/Boolean;)V", "getPayMethod", "getPayMethodFilter", "getReloadRequest", "getSaveCard", "getSelectedAddons", "setSelectedAddons", "(Ljava/util/List;)V", "getTransType", "getValidateData", "getVerificationMethod", "getVersion", "getXcoId", "<init>", "(Ljava/lang/String;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Lid/dana/cashier/data/repository/source/network/request/MixPayMethodRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierPayEntityRequest extends BaseRpcRequestWithCity {
    private final String bankPhoneNo;
    private final String bindingId;
    private final String bizOrderId;
    private Integer bukaCreditAmount;
    private final String cardCredential;
    private final String cardExpireMonth;
    private final String cardExpireYear;
    private final String cardIndexNo;
    private final String cardNo;
    private final String cashierOrderId;
    private String cashierRequestId;
    private final String channelIndex;
    private final String cityName;
    private final List<String> couponIds;
    private final String cvv2;
    private final String deviceId;
    @SerializedName("externalInfo")
    private final CheckoutExternalInfo externalInfo;
    private final String inUrl;
    private final String instCode;
    private String instId;
    private final Integer installmentPeriod;
    private final String limitMaximum;
    private final String maskedCardNo;
    private final String method;
    private final MixPayMethodRequest mixPayMethod;
    private Boolean mixPaymentRequest;
    private final String payMethod;
    private final String payMethodFilter;
    private final Boolean reloadRequest;
    private final Boolean saveCard;
    private List<String> selectedAddons;
    private final String transType;
    private final String validateData;
    private final String verificationMethod;
    private final String version;
    private final String xcoId;

    /* renamed from: component1  reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component10  reason: from getter */
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    /* renamed from: component11  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component12  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component13  reason: from getter */
    public final String getCardCredential() {
        return this.cardCredential;
    }

    /* renamed from: component14  reason: from getter */
    public final String getXcoId() {
        return this.xcoId;
    }

    /* renamed from: component15  reason: from getter */
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    /* renamed from: component16  reason: from getter */
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    /* renamed from: component17  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component18  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component19  reason: from getter */
    public final String getInstCode() {
        return this.instCode;
    }

    /* renamed from: component2  reason: from getter */
    public final CheckoutExternalInfo getExternalInfo() {
        return this.externalInfo;
    }

    /* renamed from: component20  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component21  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component22  reason: from getter */
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    /* renamed from: component23  reason: from getter */
    public final Integer getInstallmentPeriod() {
        return this.installmentPeriod;
    }

    /* renamed from: component24  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component25  reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<String> component26() {
        return this.couponIds;
    }

    /* renamed from: component27  reason: from getter */
    public final String getInUrl() {
        return this.inUrl;
    }

    /* renamed from: component28  reason: from getter */
    public final Boolean getReloadRequest() {
        return this.reloadRequest;
    }

    /* renamed from: component29  reason: from getter */
    public final String getPayMethodFilter() {
        return this.payMethodFilter;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTransType() {
        return this.transType;
    }

    /* renamed from: component30  reason: from getter */
    public final String getCityName() {
        return this.cityName;
    }

    /* renamed from: component31  reason: from getter */
    public final String getCvv2() {
        return this.cvv2;
    }

    public final List<String> component32() {
        return this.selectedAddons;
    }

    /* renamed from: component33  reason: from getter */
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    /* renamed from: component34  reason: from getter */
    public final Boolean getMixPaymentRequest() {
        return this.mixPaymentRequest;
    }

    /* renamed from: component35  reason: from getter */
    public final Integer getBukaCreditAmount() {
        return this.bukaCreditAmount;
    }

    /* renamed from: component36  reason: from getter */
    public final MixPayMethodRequest getMixPayMethod() {
        return this.mixPayMethod;
    }

    /* renamed from: component4  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    /* renamed from: component6  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    /* renamed from: component9  reason: from getter */
    public final String getCardNo() {
        return this.cardNo;
    }

    public final CashierPayEntityRequest copy(String method, CheckoutExternalInfo externalInfo, String transType, String cashierOrderId, String channelIndex, String payMethod, String cardExpireYear, String cardExpireMonth, String cardNo, Boolean saveCard, String cardIndexNo, String bindingId, String cardCredential, String xcoId, String limitMaximum, String maskedCardNo, String bankPhoneNo, String deviceId, String instCode, String instId, String validateData, String cashierRequestId, Integer installmentPeriod, String verificationMethod, String version, List<String> couponIds, String inUrl, Boolean reloadRequest, String payMethodFilter, String cityName, String cvv2, List<String> selectedAddons, String bizOrderId, Boolean mixPaymentRequest, Integer bukaCreditAmount, MixPayMethodRequest mixPayMethod) {
        Intrinsics.checkNotNullParameter(method, "");
        return new CashierPayEntityRequest(method, externalInfo, transType, cashierOrderId, channelIndex, payMethod, cardExpireYear, cardExpireMonth, cardNo, saveCard, cardIndexNo, bindingId, cardCredential, xcoId, limitMaximum, maskedCardNo, bankPhoneNo, deviceId, instCode, instId, validateData, cashierRequestId, installmentPeriod, verificationMethod, version, couponIds, inUrl, reloadRequest, payMethodFilter, cityName, cvv2, selectedAddons, bizOrderId, mixPaymentRequest, bukaCreditAmount, mixPayMethod);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierPayEntityRequest) {
            CashierPayEntityRequest cashierPayEntityRequest = (CashierPayEntityRequest) other;
            return Intrinsics.areEqual(this.method, cashierPayEntityRequest.method) && Intrinsics.areEqual(this.externalInfo, cashierPayEntityRequest.externalInfo) && Intrinsics.areEqual(this.transType, cashierPayEntityRequest.transType) && Intrinsics.areEqual(this.cashierOrderId, cashierPayEntityRequest.cashierOrderId) && Intrinsics.areEqual(this.channelIndex, cashierPayEntityRequest.channelIndex) && Intrinsics.areEqual(this.payMethod, cashierPayEntityRequest.payMethod) && Intrinsics.areEqual(this.cardExpireYear, cashierPayEntityRequest.cardExpireYear) && Intrinsics.areEqual(this.cardExpireMonth, cashierPayEntityRequest.cardExpireMonth) && Intrinsics.areEqual(this.cardNo, cashierPayEntityRequest.cardNo) && Intrinsics.areEqual(this.saveCard, cashierPayEntityRequest.saveCard) && Intrinsics.areEqual(this.cardIndexNo, cashierPayEntityRequest.cardIndexNo) && Intrinsics.areEqual(this.bindingId, cashierPayEntityRequest.bindingId) && Intrinsics.areEqual(this.cardCredential, cashierPayEntityRequest.cardCredential) && Intrinsics.areEqual(this.xcoId, cashierPayEntityRequest.xcoId) && Intrinsics.areEqual(this.limitMaximum, cashierPayEntityRequest.limitMaximum) && Intrinsics.areEqual(this.maskedCardNo, cashierPayEntityRequest.maskedCardNo) && Intrinsics.areEqual(this.bankPhoneNo, cashierPayEntityRequest.bankPhoneNo) && Intrinsics.areEqual(this.deviceId, cashierPayEntityRequest.deviceId) && Intrinsics.areEqual(this.instCode, cashierPayEntityRequest.instCode) && Intrinsics.areEqual(this.instId, cashierPayEntityRequest.instId) && Intrinsics.areEqual(this.validateData, cashierPayEntityRequest.validateData) && Intrinsics.areEqual(this.cashierRequestId, cashierPayEntityRequest.cashierRequestId) && Intrinsics.areEqual(this.installmentPeriod, cashierPayEntityRequest.installmentPeriod) && Intrinsics.areEqual(this.verificationMethod, cashierPayEntityRequest.verificationMethod) && Intrinsics.areEqual(this.version, cashierPayEntityRequest.version) && Intrinsics.areEqual(this.couponIds, cashierPayEntityRequest.couponIds) && Intrinsics.areEqual(this.inUrl, cashierPayEntityRequest.inUrl) && Intrinsics.areEqual(this.reloadRequest, cashierPayEntityRequest.reloadRequest) && Intrinsics.areEqual(this.payMethodFilter, cashierPayEntityRequest.payMethodFilter) && Intrinsics.areEqual(this.cityName, cashierPayEntityRequest.cityName) && Intrinsics.areEqual(this.cvv2, cashierPayEntityRequest.cvv2) && Intrinsics.areEqual(this.selectedAddons, cashierPayEntityRequest.selectedAddons) && Intrinsics.areEqual(this.bizOrderId, cashierPayEntityRequest.bizOrderId) && Intrinsics.areEqual(this.mixPaymentRequest, cashierPayEntityRequest.mixPaymentRequest) && Intrinsics.areEqual(this.bukaCreditAmount, cashierPayEntityRequest.bukaCreditAmount) && Intrinsics.areEqual(this.mixPayMethod, cashierPayEntityRequest.mixPayMethod);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.method.hashCode();
        CheckoutExternalInfo checkoutExternalInfo = this.externalInfo;
        int hashCode2 = checkoutExternalInfo == null ? 0 : checkoutExternalInfo.hashCode();
        String str = this.transType;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.channelIndex;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.payMethod;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.cardExpireYear;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.cardExpireMonth;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.cardNo;
        int hashCode9 = str7 == null ? 0 : str7.hashCode();
        Boolean bool = this.saveCard;
        int hashCode10 = bool == null ? 0 : bool.hashCode();
        String str8 = this.cardIndexNo;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.bindingId;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.cardCredential;
        int hashCode13 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.xcoId;
        int hashCode14 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.limitMaximum;
        int hashCode15 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.maskedCardNo;
        int hashCode16 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.bankPhoneNo;
        int hashCode17 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.deviceId;
        int hashCode18 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.instCode;
        int hashCode19 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.instId;
        int hashCode20 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.validateData;
        int hashCode21 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.cashierRequestId;
        int hashCode22 = str19 == null ? 0 : str19.hashCode();
        Integer num = this.installmentPeriod;
        int hashCode23 = num == null ? 0 : num.hashCode();
        String str20 = this.verificationMethod;
        int hashCode24 = str20 == null ? 0 : str20.hashCode();
        String str21 = this.version;
        int hashCode25 = str21 == null ? 0 : str21.hashCode();
        List<String> list = this.couponIds;
        int hashCode26 = list == null ? 0 : list.hashCode();
        String str22 = this.inUrl;
        int hashCode27 = str22 == null ? 0 : str22.hashCode();
        Boolean bool2 = this.reloadRequest;
        int hashCode28 = bool2 == null ? 0 : bool2.hashCode();
        String str23 = this.payMethodFilter;
        int hashCode29 = str23 == null ? 0 : str23.hashCode();
        String str24 = this.cityName;
        int hashCode30 = str24 == null ? 0 : str24.hashCode();
        String str25 = this.cvv2;
        int hashCode31 = str25 == null ? 0 : str25.hashCode();
        List<String> list2 = this.selectedAddons;
        int hashCode32 = list2 == null ? 0 : list2.hashCode();
        String str26 = this.bizOrderId;
        int hashCode33 = str26 == null ? 0 : str26.hashCode();
        Boolean bool3 = this.mixPaymentRequest;
        int hashCode34 = bool3 == null ? 0 : bool3.hashCode();
        Integer num2 = this.bukaCreditAmount;
        int hashCode35 = num2 == null ? 0 : num2.hashCode();
        MixPayMethodRequest mixPayMethodRequest = this.mixPayMethod;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + (mixPayMethodRequest != null ? mixPayMethodRequest.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierPayEntityRequest(method=");
        sb.append(this.method);
        sb.append(", externalInfo=");
        sb.append(this.externalInfo);
        sb.append(", transType=");
        sb.append(this.transType);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", channelIndex=");
        sb.append(this.channelIndex);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", cardExpireYear=");
        sb.append(this.cardExpireYear);
        sb.append(", cardExpireMonth=");
        sb.append(this.cardExpireMonth);
        sb.append(", cardNo=");
        sb.append(this.cardNo);
        sb.append(", saveCard=");
        sb.append(this.saveCard);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", bindingId=");
        sb.append(this.bindingId);
        sb.append(", cardCredential=");
        sb.append(this.cardCredential);
        sb.append(", xcoId=");
        sb.append(this.xcoId);
        sb.append(", limitMaximum=");
        sb.append(this.limitMaximum);
        sb.append(", maskedCardNo=");
        sb.append(this.maskedCardNo);
        sb.append(", bankPhoneNo=");
        sb.append(this.bankPhoneNo);
        sb.append(", deviceId=");
        sb.append(this.deviceId);
        sb.append(", instCode=");
        sb.append(this.instCode);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", cashierRequestId=");
        sb.append(this.cashierRequestId);
        sb.append(", installmentPeriod=");
        sb.append(this.installmentPeriod);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", couponIds=");
        sb.append(this.couponIds);
        sb.append(", inUrl=");
        sb.append(this.inUrl);
        sb.append(", reloadRequest=");
        sb.append(this.reloadRequest);
        sb.append(", payMethodFilter=");
        sb.append(this.payMethodFilter);
        sb.append(", cityName=");
        sb.append(this.cityName);
        sb.append(", cvv2=");
        sb.append(this.cvv2);
        sb.append(", selectedAddons=");
        sb.append(this.selectedAddons);
        sb.append(", bizOrderId=");
        sb.append(this.bizOrderId);
        sb.append(", mixPaymentRequest=");
        sb.append(this.mixPaymentRequest);
        sb.append(", bukaCreditAmount=");
        sb.append(this.bukaCreditAmount);
        sb.append(", mixPayMethod=");
        sb.append(this.mixPayMethod);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMethod")
    public final String getMethod() {
        return this.method;
    }

    @JvmName(name = "getExternalInfo")
    public final CheckoutExternalInfo getExternalInfo() {
        return this.externalInfo;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "getChannelIndex")
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getCardExpireYear")
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    @JvmName(name = "getCardExpireMonth")
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    @JvmName(name = "getCardNo")
    public final String getCardNo() {
        return this.cardNo;
    }

    @JvmName(name = "getSaveCard")
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "getCardCredential")
    public final String getCardCredential() {
        return this.cardCredential;
    }

    @JvmName(name = "getXcoId")
    public final String getXcoId() {
        return this.xcoId;
    }

    @JvmName(name = "getLimitMaximum")
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    @JvmName(name = "getBankPhoneNo")
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    @JvmName(name = "getInstCode")
    public final String getInstCode() {
        return this.instCode;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "setInstId")
    public final void setInstId(String str) {
        this.instId = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "getCashierRequestId")
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    @JvmName(name = "setCashierRequestId")
    public final void setCashierRequestId(String str) {
        this.cashierRequestId = str;
    }

    @JvmName(name = "getInstallmentPeriod")
    public final Integer getInstallmentPeriod() {
        return this.installmentPeriod;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "getVersion")
    public final String getVersion() {
        return this.version;
    }

    @JvmName(name = "getCouponIds")
    public final List<String> getCouponIds() {
        return this.couponIds;
    }

    @JvmName(name = "getInUrl")
    public final String getInUrl() {
        return this.inUrl;
    }

    public /* synthetic */ CashierPayEntityRequest(String str, CheckoutExternalInfo checkoutExternalInfo, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Boolean bool, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, Integer num, String str21, String str22, List list, String str23, Boolean bool2, String str24, String str25, String str26, List list2, String str27, Boolean bool3, Integer num2, MixPayMethodRequest mixPayMethodRequest, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : checkoutExternalInfo, (i & 4) != 0 ? null : str2, str3, str4, str5, str6, str7, str8, bool, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, (i & 2097152) != 0 ? null : str20, num, str21, str22, list, (i & 67108864) != 0 ? null : str23, (i & 134217728) != 0 ? Boolean.FALSE : bool2, (i & SQLiteDatabase.CREATE_IF_NECESSARY) != 0 ? "" : str24, str25, str26, (i & Integer.MIN_VALUE) != 0 ? null : list2, str27, (i2 & 2) != 0 ? Boolean.FALSE : bool3, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : mixPayMethodRequest);
    }

    @JvmName(name = "getReloadRequest")
    public final Boolean getReloadRequest() {
        return this.reloadRequest;
    }

    @JvmName(name = "getPayMethodFilter")
    public final String getPayMethodFilter() {
        return this.payMethodFilter;
    }

    @JvmName(name = "getCityName")
    public final String getCityName() {
        return this.cityName;
    }

    @JvmName(name = "getCvv2")
    public final String getCvv2() {
        return this.cvv2;
    }

    @JvmName(name = "getSelectedAddons")
    public final List<String> getSelectedAddons() {
        return this.selectedAddons;
    }

    @JvmName(name = "setSelectedAddons")
    public final void setSelectedAddons(List<String> list) {
        this.selectedAddons = list;
    }

    @JvmName(name = "getBizOrderId")
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    @JvmName(name = "getMixPaymentRequest")
    public final Boolean getMixPaymentRequest() {
        return this.mixPaymentRequest;
    }

    @JvmName(name = "setMixPaymentRequest")
    public final void setMixPaymentRequest(Boolean bool) {
        this.mixPaymentRequest = bool;
    }

    @JvmName(name = "getBukaCreditAmount")
    public final Integer getBukaCreditAmount() {
        return this.bukaCreditAmount;
    }

    @JvmName(name = "setBukaCreditAmount")
    public final void setBukaCreditAmount(Integer num) {
        this.bukaCreditAmount = num;
    }

    @JvmName(name = "getMixPayMethod")
    public final MixPayMethodRequest getMixPayMethod() {
        return this.mixPayMethod;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.util.Map, id.dana.cashier.data.repository.source.network.request.MobileEnvInfoWithCity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CashierPayEntityRequest(java.lang.String r5, id.dana.cashier.domain.model.CheckoutExternalInfo r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.Boolean r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.Integer r27, java.lang.String r28, java.lang.String r29, java.util.List<java.lang.String> r30, java.lang.String r31, java.lang.Boolean r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.util.List<java.lang.String> r36, java.lang.String r37, java.lang.Boolean r38, java.lang.Integer r39, id.dana.cashier.data.repository.source.network.request.MixPayMethodRequest r40) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            java.lang.String r2 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            r2 = 0
            r3 = 3
            r4.<init>(r2, r2, r3, r2)
            r0.method = r1
            r1 = r6
            r0.externalInfo = r1
            r1 = r7
            r0.transType = r1
            r1 = r8
            r0.cashierOrderId = r1
            r1 = r9
            r0.channelIndex = r1
            r1 = r10
            r0.payMethod = r1
            r1 = r11
            r0.cardExpireYear = r1
            r1 = r12
            r0.cardExpireMonth = r1
            r1 = r13
            r0.cardNo = r1
            r1 = r14
            r0.saveCard = r1
            r1 = r15
            r0.cardIndexNo = r1
            r1 = r16
            r0.bindingId = r1
            r1 = r17
            r0.cardCredential = r1
            r1 = r18
            r0.xcoId = r1
            r1 = r19
            r0.limitMaximum = r1
            r1 = r20
            r0.maskedCardNo = r1
            r1 = r21
            r0.bankPhoneNo = r1
            r1 = r22
            r0.deviceId = r1
            r1 = r23
            r0.instCode = r1
            r1 = r24
            r0.instId = r1
            r1 = r25
            r0.validateData = r1
            r1 = r26
            r0.cashierRequestId = r1
            r1 = r27
            r0.installmentPeriod = r1
            r1 = r28
            r0.verificationMethod = r1
            r1 = r29
            r0.version = r1
            r1 = r30
            r0.couponIds = r1
            r1 = r31
            r0.inUrl = r1
            r1 = r32
            r0.reloadRequest = r1
            r1 = r33
            r0.payMethodFilter = r1
            r1 = r34
            r0.cityName = r1
            r1 = r35
            r0.cvv2 = r1
            r1 = r36
            r0.selectedAddons = r1
            r1 = r37
            r0.bizOrderId = r1
            r1 = r38
            r0.mixPaymentRequest = r1
            r1 = r39
            r0.bukaCreditAmount = r1
            r1 = r40
            r0.mixPayMethod = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.data.repository.source.network.request.CashierPayEntityRequest.<init>(java.lang.String, id.dana.cashier.domain.model.CheckoutExternalInfo, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.Boolean, java.lang.Integer, id.dana.cashier.data.repository.source.network.request.MixPayMethodRequest):void");
    }
}
