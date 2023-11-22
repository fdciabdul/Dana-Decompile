package id.dana.expresspurchase.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0001\u001eBi\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0011\u0010\n\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0011\u0010\u0010\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0011\u0010\u0011\u001a\u00020\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0006¢\u0006\u0006\n\u0004\b\u0012\u0010\b"}, d2 = {"Lid/dana/expresspurchase/model/CTAModel;", "", "Lid/dana/expresspurchase/model/CTAModel$CtaStyle;", "PlaceComponentResult", "Lid/dana/expresspurchase/model/CTAModel$CtaStyle;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "MyBillsEntityDataFactory", "Lkotlin/Function0;", "", "Lkotlin/jvm/functions/Function0;", "moveToNextValue", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getErrorConfigVersion", "lookAheadTest", "scheduleImpl", "p0", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Lid/dana/expresspurchase/model/CTAModel$CtaStyle;)V", "CtaStyle"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CTAModel {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final String getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    public final Function0<Unit> PlaceComponentResult;
    public final String MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    public final String getErrorConfigVersion;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final CtaStyle KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public final String BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    public final String lookAheadTest;
    public final String moveToNextValue;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    public final String NetworkUserEntityData$$ExternalSyntheticLambda0;

    public CTAModel() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    private CTAModel(String str, String str2, String str3, String str4, String str5, String str6, Function0<Unit> function0, String str7, CtaStyle ctaStyle) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(str7, "");
        Intrinsics.checkNotNullParameter(ctaStyle, "");
        this.lookAheadTest = str;
        this.getErrorConfigVersion = str2;
        this.MyBillsEntityDataFactory = str3;
        this.moveToNextValue = str4;
        this.getAuthRequestContext = str5;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = str6;
        this.PlaceComponentResult = function0;
        this.BuiltInFictitiousFunctionClassFactory = str7;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ctaStyle;
    }

    public /* synthetic */ CTAModel(String str, String str2, String str3, String str4, String str5, String str6, Function0 function0, String str7, CtaStyle ctaStyle, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? new Function0<Unit>() { // from class: id.dana.expresspurchase.model.CTAModel.1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0, (i & 128) == 0 ? str7 : "", (i & 256) != 0 ? CtaStyle.DEFAULT : ctaStyle);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n"}, d2 = {"Lid/dana/expresspurchase/model/CTAModel$CtaStyle;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "DEFAULT", "TOP_DOWN"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public enum CtaStyle {
        DEFAULT(0),
        TOP_DOWN(1);

        private final int value;

        CtaStyle(int i) {
            this.value = i;
        }

        @JvmName(name = "getValue")
        public final int getValue() {
            return this.value;
        }
    }
}
