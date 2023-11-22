package id.dana.pushverify.view.verificationlist.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRecyclerViewHolder;
import id.dana.core.ui.glide.GlideApp;
import id.dana.databinding.ViewVerificationActiveBinding;
import id.dana.pushverify.model.VerificationDetailModel;
import id.dana.pushverify.utlis.VerificationExpiryUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/pushverify/view/verificationlist/adapter/VerificationActiveViewHolder;", "Lid/dana/base/viewbinding/ViewBindingRecyclerViewHolder;", "Lid/dana/pushverify/model/VerificationDetailModel;", "Lid/dana/databinding/ViewVerificationActiveBinding;", "Landroid/view/ViewGroup;", "p0", "<init>", "(Landroid/view/ViewGroup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VerificationActiveViewHolder extends ViewBindingRecyclerViewHolder<VerificationDetailModel, ViewVerificationActiveBinding> {
    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(Object obj) {
        VerificationDetailModel verificationDetailModel = (VerificationDetailModel) obj;
        if (verificationDetailModel != null) {
            VerificationAdapterUtil verificationAdapterUtil = VerificationAdapterUtil.INSTANCE;
            getBinding().PlaceComponentResult.setText(getContext().getString(VerificationAdapterUtil.MyBillsEntityDataFactory(verificationDetailModel.lookAheadTest), verificationDetailModel.BuiltInFictitiousFunctionClassFactory));
            getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setText(verificationDetailModel.getAuthRequestContext);
            GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(verificationDetailModel.PlaceComponentResult).PlaceComponentResult((int) R.drawable.ic_push_verify_merchant).MyBillsEntityDataFactory((ImageView) getBinding().BuiltInFictitiousFunctionClassFactory);
            VerificationExpiryUtil verificationExpiryUtil = VerificationExpiryUtil.getAuthRequestContext;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            VerificationExpiryUtil.MyBillsEntityDataFactory(context, verificationDetailModel.MyBillsEntityDataFactory, new Function1<String, Unit>() { // from class: id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder$bindData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    Intrinsics.checkNotNullParameter(str, "");
                    VerificationActiveViewHolder.this.getBinding().getAuthRequestContext.setText(str);
                }
            }, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006e: INVOKE 
                  (r0v13 'context' android.content.Context)
                  (wrap: int : 0x0065: IGET (r7v1 'verificationDetailModel' id.dana.pushverify.model.VerificationDetailModel) A[WRAPPED] (LINE:3021) id.dana.pushverify.model.VerificationDetailModel.PlaceComponentResult int)
                  (wrap: kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> : 0x0069: CONSTRUCTOR 
                  (r6v0 'this' id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder A[DONT_INLINE, IMMUTABLE_TYPE, THIS])
                 A[MD:(id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder):void (m), WRAPPED] (LINE:1047) call: id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder$bindData$1$1.<init>(id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder):void type: CONSTRUCTOR)
                  (wrap: id.dana.pushverify.utlis.VerificationExpiryUtil$startCountDownTimer$2 : 0x0000: SGET  A[WRAPPED] (LINE:26) id.dana.pushverify.utlis.VerificationExpiryUtil$startCountDownTimer$2.INSTANCE id.dana.pushverify.utlis.VerificationExpiryUtil$startCountDownTimer$2)
                 type: STATIC call: id.dana.pushverify.utlis.VerificationExpiryUtil.MyBillsEntityDataFactory(android.content.Context, int, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0):void A[MD:(android.content.Context, int, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit>, kotlin.jvm.functions.Function0<kotlin.Unit>):void (m)] (LINE:22) in method: id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder.bindData(java.lang.Object):void, file: classes5.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:80)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:123)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: id.dana.pushverify.utlis.VerificationExpiryUtil$startCountDownTimer$2, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:307)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                	at jadx.core.codegen.InsnGen.staticField(InsnGen.java:224)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:491)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1105)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                	... 23 more
                */
            /*
                this = this;
                id.dana.pushverify.model.VerificationDetailModel r7 = (id.dana.pushverify.model.VerificationDetailModel) r7
                if (r7 == 0) goto L71
                id.dana.pushverify.view.verificationlist.adapter.VerificationAdapterUtil r0 = id.dana.pushverify.view.verificationlist.adapter.VerificationAdapterUtil.INSTANCE
                java.lang.String r0 = r7.lookAheadTest
                int r0 = id.dana.pushverify.view.verificationlist.adapter.VerificationAdapterUtil.MyBillsEntityDataFactory(r0)
                java.lang.Object r1 = r6.getBinding()
                id.dana.databinding.ViewVerificationActiveBinding r1 = (id.dana.databinding.ViewVerificationActiveBinding) r1
                androidx.appcompat.widget.AppCompatTextView r1 = r1.PlaceComponentResult
                android.content.Context r2 = r6.getContext()
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r4 = 0
                java.lang.String r5 = r7.BuiltInFictitiousFunctionClassFactory
                r3[r4] = r5
                java.lang.String r0 = r2.getString(r0, r3)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1.setText(r0)
                java.lang.Object r0 = r6.getBinding()
                id.dana.databinding.ViewVerificationActiveBinding r0 = (id.dana.databinding.ViewVerificationActiveBinding) r0
                androidx.appcompat.widget.AppCompatTextView r0 = r0.KClassImpl$Data$declaredNonStaticMembers$2
                java.lang.String r1 = r7.getAuthRequestContext
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                r0.setText(r1)
                android.content.Context r0 = r6.getContext()
                id.dana.core.ui.glide.GlideRequests r0 = id.dana.core.ui.glide.GlideApp.getAuthRequestContext(r0)
                java.lang.String r1 = r7.PlaceComponentResult
                id.dana.core.ui.glide.GlideRequest r0 = r0.PlaceComponentResult(r1)
                r1 = 2131233559(0x7f080b17, float:1.8083259E38)
                id.dana.core.ui.glide.GlideRequest r0 = r0.PlaceComponentResult(r1)
                java.lang.Object r1 = r6.getBinding()
                id.dana.databinding.ViewVerificationActiveBinding r1 = (id.dana.databinding.ViewVerificationActiveBinding) r1
                com.google.android.material.imageview.ShapeableImageView r1 = r1.BuiltInFictitiousFunctionClassFactory
                android.widget.ImageView r1 = (android.widget.ImageView) r1
                r0.MyBillsEntityDataFactory(r1)
                id.dana.pushverify.utlis.VerificationExpiryUtil r0 = id.dana.pushverify.utlis.VerificationExpiryUtil.getAuthRequestContext
                android.content.Context r0 = r6.getContext()
                java.lang.String r1 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                int r7 = r7.MyBillsEntityDataFactory
                id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder$bindData$1$1 r1 = new id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder$bindData$1$1
                r1.<init>()
                kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                id.dana.pushverify.utlis.VerificationExpiryUtil.getAuthRequestContext(r0, r7, r1)
            L71:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder.bindData(java.lang.Object):void");
        }

        @Override // id.dana.base.viewbinding.ViewBindingRecyclerViewHolder
        public final /* synthetic */ ViewVerificationActiveBinding initViewBinding(View view) {
            Intrinsics.checkNotNullParameter(view, "");
            ViewVerificationActiveBinding BuiltInFictitiousFunctionClassFactory = ViewVerificationActiveBinding.BuiltInFictitiousFunctionClassFactory(view);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            return BuiltInFictitiousFunctionClassFactory;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public VerificationActiveViewHolder(android.view.ViewGroup r3) {
            /*
                r2 = this;
                java.lang.String r0 = ""
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                android.content.Context r1 = r3.getContext()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
                r0 = 2131560244(0x7f0d0734, float:1.8745855E38)
                r2.<init>(r1, r0, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.pushverify.view.verificationlist.adapter.VerificationActiveViewHolder.<init>(android.view.ViewGroup):void");
        }
    }
