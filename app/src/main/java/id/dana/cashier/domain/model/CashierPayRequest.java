package id.dana.cashier.domain.model;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.danah5.bioutility.BioUtilityBridge;
import id.dana.data.encryptcardno.CardCredInfo;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0003\b\u009d\u0001\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0004\u0012\u0006\u00108\u001a\u00020\u0002\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010-\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f\u0012\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f\u0012\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010#\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010^\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0004J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0004J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0017J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0004J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0004J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b \u0010!J\u0018\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001fHÆ\u0003¢\u0006\u0004\b\"\u0010!J\u0012\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u0004J\u0012\u0010(\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b(\u0010)J\u0012\u0010*\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b*\u0010)J\u0012\u0010+\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b+\u0010)J\u0012\u0010,\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b,\u0010)J\u0012\u0010.\u001a\u0004\u0018\u00010-HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\u0004J\u0012\u00101\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b1\u0010\u0004J\u0012\u00102\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b2\u0010\u0004J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010\u0004J\u0012\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010\u0004J\u0012\u00105\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b5\u0010\u0004J\u0012\u00106\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b6\u0010\u0004J\u0012\u00107\u001a\u0004\u0018\u00010'HÆ\u0003¢\u0006\u0004\b7\u0010)J\u0092\u0004\u0010b\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\u00022\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010;\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010M\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010O\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010R\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010V\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\u0010\b\u0002\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010[\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010`\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010a\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\bb\u0010cJ\u001a\u0010e\u001a\u00020'2\b\u0010d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\be\u0010fJ\u0010\u0010g\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\bg\u0010hJ\r\u0010i\u001a\u00020'¢\u0006\u0004\bi\u0010jJ\u0010\u0010k\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bk\u0010\u0004R$\u0010G\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010l\u001a\u0004\bm\u0010\u0004\"\u0004\bn\u0010oR$\u0010B\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010l\u001a\u0004\bp\u0010\u0004\"\u0004\bq\u0010oR\u001c\u0010a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\ba\u0010l\u001a\u0004\br\u0010\u0004R$\u0010P\u001a\u0004\u0018\u00010\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010s\u001a\u0004\bt\u0010\u0017\"\u0004\bu\u0010vR$\u0010C\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010l\u001a\u0004\bw\u0010\u0004\"\u0004\bx\u0010oR$\u0010>\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010l\u001a\u0004\by\u0010\u0004\"\u0004\bz\u0010oR$\u0010=\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010l\u001a\u0004\b{\u0010\u0004\"\u0004\b|\u0010oR$\u0010A\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bA\u0010l\u001a\u0004\b}\u0010\u0004\"\u0004\b~\u0010oR%\u0010?\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0013\n\u0004\b?\u0010l\u001a\u0004\b\u007f\u0010\u0004\"\u0005\b\u0080\u0001\u0010oR&\u0010:\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b:\u0010l\u001a\u0005\b\u0081\u0001\u0010\u0004\"\u0005\b\u0082\u0001\u0010oR&\u0010K\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bK\u0010l\u001a\u0005\b\u0083\u0001\u0010\u0004\"\u0005\b\u0084\u0001\u0010oR&\u0010<\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b<\u0010l\u001a\u0005\b\u0085\u0001\u0010\u0004\"\u0005\b\u0086\u0001\u0010oR&\u0010M\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bM\u0010l\u001a\u0005\b\u0087\u0001\u0010\u0004\"\u0005\b\u0088\u0001\u0010oR.\u0010W\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bW\u0010\u0089\u0001\u001a\u0005\b\u008a\u0001\u0010!\"\u0006\b\u008b\u0001\u0010\u008c\u0001R&\u0010`\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b`\u0010l\u001a\u0005\b\u008d\u0001\u0010\u0004\"\u0005\b\u008e\u0001\u0010oR&\u0010H\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bH\u0010l\u001a\u0005\b\u008f\u0001\u0010\u0004\"\u0005\b\u0090\u0001\u0010oR&\u0010S\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bS\u0010l\u001a\u0005\b\u0091\u0001\u0010\u0004\"\u0005\b\u0092\u0001\u0010oR(\u0010;\u001a\u0004\u0018\u00010-8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b;\u0010\u0093\u0001\u001a\u0005\b\u0094\u0001\u0010/\"\u0006\b\u0095\u0001\u0010\u0096\u0001R&\u0010N\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bN\u0010l\u001a\u0005\b\u0097\u0001\u0010\u0004\"\u0005\b\u0098\u0001\u0010oR(\u0010]\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b]\u0010\u0099\u0001\u001a\u0005\b\u009a\u0001\u0010)\"\u0006\b\u009b\u0001\u0010\u009c\u0001R&\u0010Z\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bZ\u0010l\u001a\u0005\b\u009d\u0001\u0010\u0004\"\u0005\b\u009e\u0001\u0010oR&\u0010I\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bI\u0010l\u001a\u0005\b\u009f\u0001\u0010\u0004\"\u0005\b \u0001\u0010oR&\u0010R\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bR\u0010l\u001a\u0005\b¡\u0001\u0010\u0004\"\u0005\b¢\u0001\u0010oR&\u0010T\u001a\u0004\u0018\u00010\u00158\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bT\u0010s\u001a\u0005\b£\u0001\u0010\u0017\"\u0005\b¤\u0001\u0010vR&\u0010E\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bE\u0010l\u001a\u0005\b¥\u0001\u0010\u0004\"\u0005\b¦\u0001\u0010oR&\u0010F\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bF\u0010l\u001a\u0005\b§\u0001\u0010\u0004\"\u0005\b¨\u0001\u0010oR&\u0010L\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bL\u0010l\u001a\u0005\b©\u0001\u0010\u0004\"\u0005\bª\u0001\u0010oR$\u00108\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b8\u0010l\u001a\u0005\b«\u0001\u0010\u0004\"\u0005\b¬\u0001\u0010oR\u001e\u0010Y\u001a\u0004\u0018\u00010#8\u0007X\u0087\u0004¢\u0006\u000e\n\u0005\bY\u0010\u00ad\u0001\u001a\u0005\b®\u0001\u0010%R(\u0010\\\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b\\\u0010\u0099\u0001\u001a\u0005\b¯\u0001\u0010)\"\u0006\b°\u0001\u0010\u009c\u0001R(\u0010^\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b^\u0010\u0099\u0001\u001a\u0005\b±\u0001\u0010)\"\u0006\b²\u0001\u0010\u009c\u0001R&\u00109\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b9\u0010l\u001a\u0005\b³\u0001\u0010\u0004\"\u0005\b´\u0001\u0010oR&\u0010_\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\b_\u0010l\u001a\u0005\bµ\u0001\u0010\u0004\"\u0005\b¶\u0001\u0010oR(\u0010[\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b[\u0010\u0099\u0001\u001a\u0005\b·\u0001\u0010)\"\u0006\b¸\u0001\u0010\u009c\u0001R(\u0010@\u001a\u0004\u0018\u00010'8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\b@\u0010\u0099\u0001\u001a\u0005\b¹\u0001\u0010)\"\u0006\bº\u0001\u0010\u009c\u0001R&\u0010Q\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bQ\u0010l\u001a\u0005\b»\u0001\u0010\u0004\"\u0005\b¼\u0001\u0010oR.\u0010X\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0007@\u0007X\u0087\u000e¢\u0006\u0016\n\u0005\bX\u0010\u0089\u0001\u001a\u0005\b½\u0001\u0010!\"\u0006\b¾\u0001\u0010\u008c\u0001R&\u0010O\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bO\u0010l\u001a\u0005\b¿\u0001\u0010\u0004\"\u0005\bÀ\u0001\u0010oR&\u0010J\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bJ\u0010l\u001a\u0005\bÁ\u0001\u0010\u0004\"\u0005\bÂ\u0001\u0010oR&\u0010U\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bU\u0010l\u001a\u0005\bÃ\u0001\u0010\u0004\"\u0005\bÄ\u0001\u0010oR&\u0010V\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bV\u0010l\u001a\u0005\bÅ\u0001\u0010\u0004\"\u0005\bÆ\u0001\u0010oR&\u0010D\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0014\n\u0004\bD\u0010l\u001a\u0005\bÇ\u0001\u0010\u0004\"\u0005\bÈ\u0001\u0010o"}, d2 = {"Lid/dana/cashier/domain/model/CashierPayRequest;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "", "component25", "()Ljava/lang/Integer;", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "", "component32", "()Ljava/util/List;", "component33", "Lid/dana/cashier/domain/model/MixPayMethod;", "component34", "()Lid/dana/cashier/domain/model/MixPayMethod;", "component35", "", "component36", "()Ljava/lang/Boolean;", "component37", "component38", "component39", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "component4", "()Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "component40", "component41", "component42", "component5", "component6", "component7", "component8", "component9", "method", "payMethod", CashierKeyParams.CASHIER_ORDER_ID, "externalInfo", "channelIndex", CardCredInfo.CARD_EXPIRE_YEAR, CardCredInfo.CARD_EXPIRE_MONTH, CardCredInfo.CARD_NO, "saveCard", WalletConstant.CARD_INDEX_NO, "bindingId", "cardCredential", "xcoId", "limitMaximum", "maskedCardNo", "bankPhoneNo", "deviceId", "instCode", "validateData", "cashierRequestId", "merchantId", "clientIp", "fundType", "transType", "bukaCreditAmount", BioUtilityBridge.SECURITY_ID, "instId", "expressPayAgreementToken", CashierKeyParams.INSTALLMENT_PERIOD, CashierKeyParams.VERIFICATION_METHOD, "version", "couponIds", "selectedAddons", "mixPayMethod", "inUrl", "reloadRequest", "mixPaymentRequest", "hasBeenRegistered", "newCard", "payMethodFilter", "cvv2", "bizOrderId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lid/dana/cashier/domain/model/MixPayMethod;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/cashier/domain/model/CashierPayRequest;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "isEncryptCardEnabledForTopUpPay", "()Z", "toString", "Ljava/lang/String;", "getBankPhoneNo", "setBankPhoneNo", "(Ljava/lang/String;)V", "getBindingId", "setBindingId", "getBizOrderId", "Ljava/lang/Integer;", "getBukaCreditAmount", "setBukaCreditAmount", "(Ljava/lang/Integer;)V", "getCardCredential", "setCardCredential", "getCardExpireMonth", "setCardExpireMonth", "getCardExpireYear", "setCardExpireYear", "getCardIndexNo", "setCardIndexNo", "getCardNo", "setCardNo", "getCashierOrderId", "setCashierOrderId", "getCashierRequestId", "setCashierRequestId", "getChannelIndex", "setChannelIndex", "getClientIp", "setClientIp", "Ljava/util/List;", "getCouponIds", "setCouponIds", "(Ljava/util/List;)V", "getCvv2", "setCvv2", "getDeviceId", "setDeviceId", "getExpressPayAgreementToken", "setExpressPayAgreementToken", "Lid/dana/cashier/domain/model/CheckoutExternalInfo;", "getExternalInfo", "setExternalInfo", "(Lid/dana/cashier/domain/model/CheckoutExternalInfo;)V", "getFundType", "setFundType", "Ljava/lang/Boolean;", "getHasBeenRegistered", "setHasBeenRegistered", "(Ljava/lang/Boolean;)V", "getInUrl", "setInUrl", "getInstCode", "setInstCode", "getInstId", "setInstId", "getInstallmentPeriod", "setInstallmentPeriod", "getLimitMaximum", "setLimitMaximum", "getMaskedCardNo", "setMaskedCardNo", "getMerchantId", "setMerchantId", "getMethod", "setMethod", "Lid/dana/cashier/domain/model/MixPayMethod;", "getMixPayMethod", "getMixPaymentRequest", "setMixPaymentRequest", "getNewCard", "setNewCard", "getPayMethod", "setPayMethod", "getPayMethodFilter", "setPayMethodFilter", "getReloadRequest", "setReloadRequest", "getSaveCard", "setSaveCard", "getSecurityId", "setSecurityId", "getSelectedAddons", "setSelectedAddons", "getTransType", "setTransType", "getValidateData", "setValidateData", "getVerificationMethod", "setVerificationMethod", "getVersion", "setVersion", "getXcoId", "setXcoId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lid/dana/cashier/domain/model/CheckoutExternalInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lid/dana/cashier/domain/model/MixPayMethod;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CashierPayRequest {
    private String bankPhoneNo;
    private String bindingId;
    private final String bizOrderId;
    private Integer bukaCreditAmount;
    private String cardCredential;
    private String cardExpireMonth;
    private String cardExpireYear;
    private String cardIndexNo;
    private String cardNo;
    private String cashierOrderId;
    private String cashierRequestId;
    private String channelIndex;
    private String clientIp;
    private List<String> couponIds;
    private String cvv2;
    private String deviceId;
    private String expressPayAgreementToken;
    private CheckoutExternalInfo externalInfo;
    private String fundType;
    private Boolean hasBeenRegistered;
    private String inUrl;
    private String instCode;
    private String instId;
    private Integer installmentPeriod;
    private String limitMaximum;
    private String maskedCardNo;
    private String merchantId;
    private String method;
    private final MixPayMethod mixPayMethod;
    private Boolean mixPaymentRequest;
    private Boolean newCard;
    private String payMethod;
    private String payMethodFilter;
    private Boolean reloadRequest;
    private Boolean saveCard;
    private String securityId;
    private List<String> selectedAddons;
    private String transType;
    private String validateData;
    private String verificationMethod;
    private String version;
    private String xcoId;

    /* renamed from: component1  reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component10  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component11  reason: from getter */
    public final String getBindingId() {
        return this.bindingId;
    }

    /* renamed from: component12  reason: from getter */
    public final String getCardCredential() {
        return this.cardCredential;
    }

    /* renamed from: component13  reason: from getter */
    public final String getXcoId() {
        return this.xcoId;
    }

    /* renamed from: component14  reason: from getter */
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    /* renamed from: component15  reason: from getter */
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    /* renamed from: component16  reason: from getter */
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    /* renamed from: component17  reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component18  reason: from getter */
    public final String getInstCode() {
        return this.instCode;
    }

    /* renamed from: component19  reason: from getter */
    public final String getValidateData() {
        return this.validateData;
    }

    /* renamed from: component2  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component20  reason: from getter */
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    /* renamed from: component21  reason: from getter */
    public final String getMerchantId() {
        return this.merchantId;
    }

    /* renamed from: component22  reason: from getter */
    public final String getClientIp() {
        return this.clientIp;
    }

    /* renamed from: component23  reason: from getter */
    public final String getFundType() {
        return this.fundType;
    }

    /* renamed from: component24  reason: from getter */
    public final String getTransType() {
        return this.transType;
    }

    /* renamed from: component25  reason: from getter */
    public final Integer getBukaCreditAmount() {
        return this.bukaCreditAmount;
    }

    /* renamed from: component26  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    /* renamed from: component27  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component28  reason: from getter */
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    /* renamed from: component29  reason: from getter */
    public final Integer getInstallmentPeriod() {
        return this.installmentPeriod;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    /* renamed from: component30  reason: from getter */
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    /* renamed from: component31  reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<String> component32() {
        return this.couponIds;
    }

    public final List<String> component33() {
        return this.selectedAddons;
    }

    /* renamed from: component34  reason: from getter */
    public final MixPayMethod getMixPayMethod() {
        return this.mixPayMethod;
    }

    /* renamed from: component35  reason: from getter */
    public final String getInUrl() {
        return this.inUrl;
    }

    /* renamed from: component36  reason: from getter */
    public final Boolean getReloadRequest() {
        return this.reloadRequest;
    }

    /* renamed from: component37  reason: from getter */
    public final Boolean getMixPaymentRequest() {
        return this.mixPaymentRequest;
    }

    /* renamed from: component38  reason: from getter */
    public final Boolean getHasBeenRegistered() {
        return this.hasBeenRegistered;
    }

    /* renamed from: component39  reason: from getter */
    public final Boolean getNewCard() {
        return this.newCard;
    }

    /* renamed from: component4  reason: from getter */
    public final CheckoutExternalInfo getExternalInfo() {
        return this.externalInfo;
    }

    /* renamed from: component40  reason: from getter */
    public final String getPayMethodFilter() {
        return this.payMethodFilter;
    }

    /* renamed from: component41  reason: from getter */
    public final String getCvv2() {
        return this.cvv2;
    }

    /* renamed from: component42  reason: from getter */
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    /* renamed from: component6  reason: from getter */
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    /* renamed from: component7  reason: from getter */
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCardNo() {
        return this.cardNo;
    }

    /* renamed from: component9  reason: from getter */
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    public final CashierPayRequest copy(String method, String payMethod, String cashierOrderId, CheckoutExternalInfo externalInfo, String channelIndex, String cardExpireYear, String cardExpireMonth, String cardNo, Boolean saveCard, String cardIndexNo, String bindingId, String cardCredential, String xcoId, String limitMaximum, String maskedCardNo, String bankPhoneNo, String deviceId, String instCode, String validateData, String cashierRequestId, String merchantId, String clientIp, String fundType, String transType, Integer bukaCreditAmount, String securityId, String instId, String expressPayAgreementToken, Integer installmentPeriod, String verificationMethod, String version, List<String> couponIds, List<String> selectedAddons, MixPayMethod mixPayMethod, String inUrl, Boolean reloadRequest, Boolean mixPaymentRequest, Boolean hasBeenRegistered, Boolean newCard, String payMethodFilter, String cvv2, String bizOrderId) {
        Intrinsics.checkNotNullParameter(method, "");
        return new CashierPayRequest(method, payMethod, cashierOrderId, externalInfo, channelIndex, cardExpireYear, cardExpireMonth, cardNo, saveCard, cardIndexNo, bindingId, cardCredential, xcoId, limitMaximum, maskedCardNo, bankPhoneNo, deviceId, instCode, validateData, cashierRequestId, merchantId, clientIp, fundType, transType, bukaCreditAmount, securityId, instId, expressPayAgreementToken, installmentPeriod, verificationMethod, version, couponIds, selectedAddons, mixPayMethod, inUrl, reloadRequest, mixPaymentRequest, hasBeenRegistered, newCard, payMethodFilter, cvv2, bizOrderId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof CashierPayRequest) {
            CashierPayRequest cashierPayRequest = (CashierPayRequest) other;
            return Intrinsics.areEqual(this.method, cashierPayRequest.method) && Intrinsics.areEqual(this.payMethod, cashierPayRequest.payMethod) && Intrinsics.areEqual(this.cashierOrderId, cashierPayRequest.cashierOrderId) && Intrinsics.areEqual(this.externalInfo, cashierPayRequest.externalInfo) && Intrinsics.areEqual(this.channelIndex, cashierPayRequest.channelIndex) && Intrinsics.areEqual(this.cardExpireYear, cashierPayRequest.cardExpireYear) && Intrinsics.areEqual(this.cardExpireMonth, cashierPayRequest.cardExpireMonth) && Intrinsics.areEqual(this.cardNo, cashierPayRequest.cardNo) && Intrinsics.areEqual(this.saveCard, cashierPayRequest.saveCard) && Intrinsics.areEqual(this.cardIndexNo, cashierPayRequest.cardIndexNo) && Intrinsics.areEqual(this.bindingId, cashierPayRequest.bindingId) && Intrinsics.areEqual(this.cardCredential, cashierPayRequest.cardCredential) && Intrinsics.areEqual(this.xcoId, cashierPayRequest.xcoId) && Intrinsics.areEqual(this.limitMaximum, cashierPayRequest.limitMaximum) && Intrinsics.areEqual(this.maskedCardNo, cashierPayRequest.maskedCardNo) && Intrinsics.areEqual(this.bankPhoneNo, cashierPayRequest.bankPhoneNo) && Intrinsics.areEqual(this.deviceId, cashierPayRequest.deviceId) && Intrinsics.areEqual(this.instCode, cashierPayRequest.instCode) && Intrinsics.areEqual(this.validateData, cashierPayRequest.validateData) && Intrinsics.areEqual(this.cashierRequestId, cashierPayRequest.cashierRequestId) && Intrinsics.areEqual(this.merchantId, cashierPayRequest.merchantId) && Intrinsics.areEqual(this.clientIp, cashierPayRequest.clientIp) && Intrinsics.areEqual(this.fundType, cashierPayRequest.fundType) && Intrinsics.areEqual(this.transType, cashierPayRequest.transType) && Intrinsics.areEqual(this.bukaCreditAmount, cashierPayRequest.bukaCreditAmount) && Intrinsics.areEqual(this.securityId, cashierPayRequest.securityId) && Intrinsics.areEqual(this.instId, cashierPayRequest.instId) && Intrinsics.areEqual(this.expressPayAgreementToken, cashierPayRequest.expressPayAgreementToken) && Intrinsics.areEqual(this.installmentPeriod, cashierPayRequest.installmentPeriod) && Intrinsics.areEqual(this.verificationMethod, cashierPayRequest.verificationMethod) && Intrinsics.areEqual(this.version, cashierPayRequest.version) && Intrinsics.areEqual(this.couponIds, cashierPayRequest.couponIds) && Intrinsics.areEqual(this.selectedAddons, cashierPayRequest.selectedAddons) && Intrinsics.areEqual(this.mixPayMethod, cashierPayRequest.mixPayMethod) && Intrinsics.areEqual(this.inUrl, cashierPayRequest.inUrl) && Intrinsics.areEqual(this.reloadRequest, cashierPayRequest.reloadRequest) && Intrinsics.areEqual(this.mixPaymentRequest, cashierPayRequest.mixPaymentRequest) && Intrinsics.areEqual(this.hasBeenRegistered, cashierPayRequest.hasBeenRegistered) && Intrinsics.areEqual(this.newCard, cashierPayRequest.newCard) && Intrinsics.areEqual(this.payMethodFilter, cashierPayRequest.payMethodFilter) && Intrinsics.areEqual(this.cvv2, cashierPayRequest.cvv2) && Intrinsics.areEqual(this.bizOrderId, cashierPayRequest.bizOrderId);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.method.hashCode();
        String str = this.payMethod;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.cashierOrderId;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        CheckoutExternalInfo checkoutExternalInfo = this.externalInfo;
        int hashCode4 = checkoutExternalInfo == null ? 0 : checkoutExternalInfo.hashCode();
        String str3 = this.channelIndex;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.cardExpireYear;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.cardExpireMonth;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.cardNo;
        int hashCode8 = str6 == null ? 0 : str6.hashCode();
        Boolean bool = this.saveCard;
        int hashCode9 = bool == null ? 0 : bool.hashCode();
        String str7 = this.cardIndexNo;
        int hashCode10 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.bindingId;
        int hashCode11 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.cardCredential;
        int hashCode12 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.xcoId;
        int hashCode13 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.limitMaximum;
        int hashCode14 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.maskedCardNo;
        int hashCode15 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.bankPhoneNo;
        int hashCode16 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.deviceId;
        int hashCode17 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.instCode;
        int hashCode18 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.validateData;
        int hashCode19 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.cashierRequestId;
        int hashCode20 = str17 == null ? 0 : str17.hashCode();
        String str18 = this.merchantId;
        int hashCode21 = str18 == null ? 0 : str18.hashCode();
        String str19 = this.clientIp;
        int hashCode22 = str19 == null ? 0 : str19.hashCode();
        String str20 = this.fundType;
        int hashCode23 = str20 == null ? 0 : str20.hashCode();
        String str21 = this.transType;
        int hashCode24 = str21 == null ? 0 : str21.hashCode();
        Integer num = this.bukaCreditAmount;
        int hashCode25 = num == null ? 0 : num.hashCode();
        String str22 = this.securityId;
        int hashCode26 = str22 == null ? 0 : str22.hashCode();
        String str23 = this.instId;
        int hashCode27 = str23 == null ? 0 : str23.hashCode();
        String str24 = this.expressPayAgreementToken;
        int hashCode28 = str24 == null ? 0 : str24.hashCode();
        Integer num2 = this.installmentPeriod;
        int hashCode29 = num2 == null ? 0 : num2.hashCode();
        String str25 = this.verificationMethod;
        int hashCode30 = str25 == null ? 0 : str25.hashCode();
        String str26 = this.version;
        int hashCode31 = str26 == null ? 0 : str26.hashCode();
        List<String> list = this.couponIds;
        int hashCode32 = list == null ? 0 : list.hashCode();
        List<String> list2 = this.selectedAddons;
        int hashCode33 = list2 == null ? 0 : list2.hashCode();
        MixPayMethod mixPayMethod = this.mixPayMethod;
        int hashCode34 = mixPayMethod == null ? 0 : mixPayMethod.hashCode();
        String str27 = this.inUrl;
        int hashCode35 = str27 == null ? 0 : str27.hashCode();
        Boolean bool2 = this.reloadRequest;
        int hashCode36 = bool2 == null ? 0 : bool2.hashCode();
        Boolean bool3 = this.mixPaymentRequest;
        int hashCode37 = bool3 == null ? 0 : bool3.hashCode();
        Boolean bool4 = this.hasBeenRegistered;
        int hashCode38 = bool4 == null ? 0 : bool4.hashCode();
        Boolean bool5 = this.newCard;
        int hashCode39 = bool5 == null ? 0 : bool5.hashCode();
        String str28 = this.payMethodFilter;
        int hashCode40 = str28 == null ? 0 : str28.hashCode();
        String str29 = this.cvv2;
        int hashCode41 = str29 == null ? 0 : str29.hashCode();
        String str30 = this.bizOrderId;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + hashCode18) * 31) + hashCode19) * 31) + hashCode20) * 31) + hashCode21) * 31) + hashCode22) * 31) + hashCode23) * 31) + hashCode24) * 31) + hashCode25) * 31) + hashCode26) * 31) + hashCode27) * 31) + hashCode28) * 31) + hashCode29) * 31) + hashCode30) * 31) + hashCode31) * 31) + hashCode32) * 31) + hashCode33) * 31) + hashCode34) * 31) + hashCode35) * 31) + hashCode36) * 31) + hashCode37) * 31) + hashCode38) * 31) + hashCode39) * 31) + hashCode40) * 31) + hashCode41) * 31) + (str30 != null ? str30.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CashierPayRequest(method=");
        sb.append(this.method);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", cashierOrderId=");
        sb.append(this.cashierOrderId);
        sb.append(", externalInfo=");
        sb.append(this.externalInfo);
        sb.append(", channelIndex=");
        sb.append(this.channelIndex);
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
        sb.append(", validateData=");
        sb.append(this.validateData);
        sb.append(", cashierRequestId=");
        sb.append(this.cashierRequestId);
        sb.append(", merchantId=");
        sb.append(this.merchantId);
        sb.append(", clientIp=");
        sb.append(this.clientIp);
        sb.append(", fundType=");
        sb.append(this.fundType);
        sb.append(", transType=");
        sb.append(this.transType);
        sb.append(", bukaCreditAmount=");
        sb.append(this.bukaCreditAmount);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", expressPayAgreementToken=");
        sb.append(this.expressPayAgreementToken);
        sb.append(", installmentPeriod=");
        sb.append(this.installmentPeriod);
        sb.append(", verificationMethod=");
        sb.append(this.verificationMethod);
        sb.append(", version=");
        sb.append(this.version);
        sb.append(", couponIds=");
        sb.append(this.couponIds);
        sb.append(", selectedAddons=");
        sb.append(this.selectedAddons);
        sb.append(", mixPayMethod=");
        sb.append(this.mixPayMethod);
        sb.append(", inUrl=");
        sb.append(this.inUrl);
        sb.append(", reloadRequest=");
        sb.append(this.reloadRequest);
        sb.append(", mixPaymentRequest=");
        sb.append(this.mixPaymentRequest);
        sb.append(", hasBeenRegistered=");
        sb.append(this.hasBeenRegistered);
        sb.append(", newCard=");
        sb.append(this.newCard);
        sb.append(", payMethodFilter=");
        sb.append(this.payMethodFilter);
        sb.append(", cvv2=");
        sb.append(this.cvv2);
        sb.append(", bizOrderId=");
        sb.append(this.bizOrderId);
        sb.append(')');
        return sb.toString();
    }

    public CashierPayRequest(String str, String str2, String str3, CheckoutExternalInfo checkoutExternalInfo, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, Integer num, String str23, String str24, String str25, Integer num2, String str26, String str27, List<String> list, List<String> list2, MixPayMethod mixPayMethod, String str28, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str29, String str30, String str31) {
        Intrinsics.checkNotNullParameter(str, "");
        this.method = str;
        this.payMethod = str2;
        this.cashierOrderId = str3;
        this.externalInfo = checkoutExternalInfo;
        this.channelIndex = str4;
        this.cardExpireYear = str5;
        this.cardExpireMonth = str6;
        this.cardNo = str7;
        this.saveCard = bool;
        this.cardIndexNo = str8;
        this.bindingId = str9;
        this.cardCredential = str10;
        this.xcoId = str11;
        this.limitMaximum = str12;
        this.maskedCardNo = str13;
        this.bankPhoneNo = str14;
        this.deviceId = str15;
        this.instCode = str16;
        this.validateData = str17;
        this.cashierRequestId = str18;
        this.merchantId = str19;
        this.clientIp = str20;
        this.fundType = str21;
        this.transType = str22;
        this.bukaCreditAmount = num;
        this.securityId = str23;
        this.instId = str24;
        this.expressPayAgreementToken = str25;
        this.installmentPeriod = num2;
        this.verificationMethod = str26;
        this.version = str27;
        this.couponIds = list;
        this.selectedAddons = list2;
        this.mixPayMethod = mixPayMethod;
        this.inUrl = str28;
        this.reloadRequest = bool2;
        this.mixPaymentRequest = bool3;
        this.hasBeenRegistered = bool4;
        this.newCard = bool5;
        this.payMethodFilter = str29;
        this.cvv2 = str30;
        this.bizOrderId = str31;
    }

    @JvmName(name = "getMethod")
    public final String getMethod() {
        return this.method;
    }

    @JvmName(name = "setMethod")
    public final void setMethod(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.method = str;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "setPayMethod")
    public final void setPayMethod(String str) {
        this.payMethod = str;
    }

    @JvmName(name = "getCashierOrderId")
    public final String getCashierOrderId() {
        return this.cashierOrderId;
    }

    @JvmName(name = "setCashierOrderId")
    public final void setCashierOrderId(String str) {
        this.cashierOrderId = str;
    }

    @JvmName(name = "getExternalInfo")
    public final CheckoutExternalInfo getExternalInfo() {
        return this.externalInfo;
    }

    @JvmName(name = "setExternalInfo")
    public final void setExternalInfo(CheckoutExternalInfo checkoutExternalInfo) {
        this.externalInfo = checkoutExternalInfo;
    }

    @JvmName(name = "getChannelIndex")
    public final String getChannelIndex() {
        return this.channelIndex;
    }

    @JvmName(name = "setChannelIndex")
    public final void setChannelIndex(String str) {
        this.channelIndex = str;
    }

    @JvmName(name = "getCardExpireYear")
    public final String getCardExpireYear() {
        return this.cardExpireYear;
    }

    @JvmName(name = "setCardExpireYear")
    public final void setCardExpireYear(String str) {
        this.cardExpireYear = str;
    }

    @JvmName(name = "getCardExpireMonth")
    public final String getCardExpireMonth() {
        return this.cardExpireMonth;
    }

    @JvmName(name = "setCardExpireMonth")
    public final void setCardExpireMonth(String str) {
        this.cardExpireMonth = str;
    }

    @JvmName(name = "getCardNo")
    public final String getCardNo() {
        return this.cardNo;
    }

    @JvmName(name = "setCardNo")
    public final void setCardNo(String str) {
        this.cardNo = str;
    }

    @JvmName(name = "getSaveCard")
    public final Boolean getSaveCard() {
        return this.saveCard;
    }

    @JvmName(name = "setSaveCard")
    public final void setSaveCard(Boolean bool) {
        this.saveCard = bool;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "setCardIndexNo")
    public final void setCardIndexNo(String str) {
        this.cardIndexNo = str;
    }

    @JvmName(name = "getBindingId")
    public final String getBindingId() {
        return this.bindingId;
    }

    @JvmName(name = "setBindingId")
    public final void setBindingId(String str) {
        this.bindingId = str;
    }

    @JvmName(name = "getCardCredential")
    public final String getCardCredential() {
        return this.cardCredential;
    }

    @JvmName(name = "setCardCredential")
    public final void setCardCredential(String str) {
        this.cardCredential = str;
    }

    @JvmName(name = "getXcoId")
    public final String getXcoId() {
        return this.xcoId;
    }

    @JvmName(name = "setXcoId")
    public final void setXcoId(String str) {
        this.xcoId = str;
    }

    @JvmName(name = "getLimitMaximum")
    public final String getLimitMaximum() {
        return this.limitMaximum;
    }

    @JvmName(name = "setLimitMaximum")
    public final void setLimitMaximum(String str) {
        this.limitMaximum = str;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    @JvmName(name = "setMaskedCardNo")
    public final void setMaskedCardNo(String str) {
        this.maskedCardNo = str;
    }

    @JvmName(name = "getBankPhoneNo")
    public final String getBankPhoneNo() {
        return this.bankPhoneNo;
    }

    @JvmName(name = "setBankPhoneNo")
    public final void setBankPhoneNo(String str) {
        this.bankPhoneNo = str;
    }

    @JvmName(name = "getDeviceId")
    public final String getDeviceId() {
        return this.deviceId;
    }

    @JvmName(name = "setDeviceId")
    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    @JvmName(name = "getInstCode")
    public final String getInstCode() {
        return this.instCode;
    }

    @JvmName(name = "setInstCode")
    public final void setInstCode(String str) {
        this.instCode = str;
    }

    @JvmName(name = "getValidateData")
    public final String getValidateData() {
        return this.validateData;
    }

    @JvmName(name = "setValidateData")
    public final void setValidateData(String str) {
        this.validateData = str;
    }

    @JvmName(name = "getCashierRequestId")
    public final String getCashierRequestId() {
        return this.cashierRequestId;
    }

    @JvmName(name = "setCashierRequestId")
    public final void setCashierRequestId(String str) {
        this.cashierRequestId = str;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        return this.merchantId;
    }

    @JvmName(name = "setMerchantId")
    public final void setMerchantId(String str) {
        this.merchantId = str;
    }

    @JvmName(name = "getClientIp")
    public final String getClientIp() {
        return this.clientIp;
    }

    @JvmName(name = "setClientIp")
    public final void setClientIp(String str) {
        this.clientIp = str;
    }

    @JvmName(name = "getFundType")
    public final String getFundType() {
        return this.fundType;
    }

    @JvmName(name = "setFundType")
    public final void setFundType(String str) {
        this.fundType = str;
    }

    @JvmName(name = "getTransType")
    public final String getTransType() {
        return this.transType;
    }

    @JvmName(name = "setTransType")
    public final void setTransType(String str) {
        this.transType = str;
    }

    @JvmName(name = "getBukaCreditAmount")
    public final Integer getBukaCreditAmount() {
        return this.bukaCreditAmount;
    }

    @JvmName(name = "setBukaCreditAmount")
    public final void setBukaCreditAmount(Integer num) {
        this.bukaCreditAmount = num;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    @JvmName(name = "setSecurityId")
    public final void setSecurityId(String str) {
        this.securityId = str;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "setInstId")
    public final void setInstId(String str) {
        this.instId = str;
    }

    @JvmName(name = "getExpressPayAgreementToken")
    public final String getExpressPayAgreementToken() {
        return this.expressPayAgreementToken;
    }

    @JvmName(name = "setExpressPayAgreementToken")
    public final void setExpressPayAgreementToken(String str) {
        this.expressPayAgreementToken = str;
    }

    @JvmName(name = "getInstallmentPeriod")
    public final Integer getInstallmentPeriod() {
        return this.installmentPeriod;
    }

    @JvmName(name = "setInstallmentPeriod")
    public final void setInstallmentPeriod(Integer num) {
        this.installmentPeriod = num;
    }

    @JvmName(name = "getVerificationMethod")
    public final String getVerificationMethod() {
        return this.verificationMethod;
    }

    @JvmName(name = "setVerificationMethod")
    public final void setVerificationMethod(String str) {
        this.verificationMethod = str;
    }

    @JvmName(name = "getVersion")
    public final String getVersion() {
        return this.version;
    }

    @JvmName(name = "setVersion")
    public final void setVersion(String str) {
        this.version = str;
    }

    @JvmName(name = "getCouponIds")
    public final List<String> getCouponIds() {
        return this.couponIds;
    }

    @JvmName(name = "setCouponIds")
    public final void setCouponIds(List<String> list) {
        this.couponIds = list;
    }

    @JvmName(name = "getSelectedAddons")
    public final List<String> getSelectedAddons() {
        return this.selectedAddons;
    }

    @JvmName(name = "setSelectedAddons")
    public final void setSelectedAddons(List<String> list) {
        this.selectedAddons = list;
    }

    @JvmName(name = "getMixPayMethod")
    public final MixPayMethod getMixPayMethod() {
        return this.mixPayMethod;
    }

    @JvmName(name = "getInUrl")
    public final String getInUrl() {
        return this.inUrl;
    }

    @JvmName(name = "setInUrl")
    public final void setInUrl(String str) {
        this.inUrl = str;
    }

    @JvmName(name = "getReloadRequest")
    public final Boolean getReloadRequest() {
        return this.reloadRequest;
    }

    @JvmName(name = "setReloadRequest")
    public final void setReloadRequest(Boolean bool) {
        this.reloadRequest = bool;
    }

    @JvmName(name = "getMixPaymentRequest")
    public final Boolean getMixPaymentRequest() {
        return this.mixPaymentRequest;
    }

    @JvmName(name = "setMixPaymentRequest")
    public final void setMixPaymentRequest(Boolean bool) {
        this.mixPaymentRequest = bool;
    }

    public /* synthetic */ CashierPayRequest(String str, String str2, String str3, CheckoutExternalInfo checkoutExternalInfo, String str4, String str5, String str6, String str7, Boolean bool, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, Integer num, String str23, String str24, String str25, Integer num2, String str26, String str27, List list, List list2, MixPayMethod mixPayMethod, String str28, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str29, String str30, String str31, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, str3, (i & 8) != 0 ? null : checkoutExternalInfo, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & 256) != 0 ? null : bool, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : str11, (i & 8192) != 0 ? null : str12, (i & 16384) != 0 ? null : str13, (32768 & i) != 0 ? null : str14, (65536 & i) != 0 ? null : str15, (131072 & i) != 0 ? null : str16, (262144 & i) != 0 ? null : str17, (524288 & i) != 0 ? null : str18, (1048576 & i) != 0 ? null : str19, (2097152 & i) != 0 ? null : str20, (4194304 & i) != 0 ? null : str21, (8388608 & i) != 0 ? null : str22, (16777216 & i) != 0 ? null : num, (33554432 & i) != 0 ? null : str23, (67108864 & i) != 0 ? null : str24, (134217728 & i) != 0 ? null : str25, (268435456 & i) != 0 ? null : num2, (536870912 & i) != 0 ? null : str26, (1073741824 & i) != 0 ? null : str27, (i & Integer.MIN_VALUE) != 0 ? null : list, (i2 & 1) != 0 ? null : list2, (i2 & 2) != 0 ? null : mixPayMethod, (i2 & 4) != 0 ? null : str28, (i2 & 8) != 0 ? null : bool2, (i2 & 16) != 0 ? null : bool3, (i2 & 32) != 0 ? Boolean.FALSE : bool4, (i2 & 64) != 0 ? Boolean.FALSE : bool5, (i2 & 128) != 0 ? null : str29, (i2 & 256) != 0 ? null : str30, (i2 & 512) != 0 ? null : str31);
    }

    @JvmName(name = "getHasBeenRegistered")
    public final Boolean getHasBeenRegistered() {
        return this.hasBeenRegistered;
    }

    @JvmName(name = "setHasBeenRegistered")
    public final void setHasBeenRegistered(Boolean bool) {
        this.hasBeenRegistered = bool;
    }

    @JvmName(name = "getNewCard")
    public final Boolean getNewCard() {
        return this.newCard;
    }

    @JvmName(name = "setNewCard")
    public final void setNewCard(Boolean bool) {
        this.newCard = bool;
    }

    @JvmName(name = "getPayMethodFilter")
    public final String getPayMethodFilter() {
        return this.payMethodFilter;
    }

    @JvmName(name = "setPayMethodFilter")
    public final void setPayMethodFilter(String str) {
        this.payMethodFilter = str;
    }

    @JvmName(name = "getCvv2")
    public final String getCvv2() {
        return this.cvv2;
    }

    @JvmName(name = "setCvv2")
    public final void setCvv2(String str) {
        this.cvv2 = str;
    }

    @JvmName(name = "getBizOrderId")
    public final String getBizOrderId() {
        return this.bizOrderId;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0039 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isEncryptCardEnabledForTopUpPay() {
        /*
            r3 = this;
            java.lang.String r0 = r3.method
            java.lang.String r1 = "topupPay"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3a
            java.lang.String r0 = r3.cardExpireMonth
            if (r0 == 0) goto L1f
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 != r2) goto L1f
            r0 = 1
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 == 0) goto L3a
            java.lang.String r0 = r3.cardExpireYear
            if (r0 == 0) goto L35
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L30
            r0 = 1
            goto L31
        L30:
            r0 = 0
        L31:
            if (r0 != r2) goto L35
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            if (r0 != 0) goto L39
            goto L3a
        L39:
            r1 = 1
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.cashier.domain.model.CashierPayRequest.isEncryptCardEnabledForTopUpPay():boolean");
    }
}
