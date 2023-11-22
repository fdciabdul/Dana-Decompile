package id.dana.mybills.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.afollestad.materialdialogs.utils.MDUtil;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.iap.ac.android.common.container.provider.ui.ContainerUIProvider;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.core.ui.util.FlowViewUtil;
import id.dana.core.ui.util.KeyboardHelper;
import id.dana.mybills.R;
import id.dana.mybills.databinding.ViewCustomEditTextMyBillsBinding;
import id.dana.mybills.utils.PhoneNumberValidation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&B+\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010'\u001a\u00020#¢\u0006\u0004\b%\u0010(J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010JA\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00112*\u0010\u0016\u001a&\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0014\u0012\u000b\u0012\t\u0018\u00010\r¢\u0006\u0002\b\u0014\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\n"}, d2 = {"Lid/dana/mybills/ui/customview/PhoneNumberView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/mybills/databinding/ViewCustomEditTextMyBillsBinding;", "", "getPhoneNumber", "()Ljava/lang/CharSequence;", "inflateViewBinding", "()Lid/dana/mybills/databinding/ViewCustomEditTextMyBillsBinding;", "", "setDisabled", "()V", "", ContainerUIProvider.KEY_SHOW, "", "msg", "setErrorMessage", "(ZLjava/lang/String;)V", "Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "Lid/dana/mybills/ui/customview/OnPhoneNumberChanged;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlinx/coroutines/Job;", "setOnChangeListener", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "Lid/dana/mybills/utils/PhoneNumberValidation;", "phoneNumber", "setPhoneNumber", "(Lid/dana/mybills/utils/PhoneNumberValidation;)V", "setup", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class PhoneNumberView extends BaseViewBindingRichView<ViewCustomEditTextMyBillsBinding> {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhoneNumberView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhoneNumberView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public /* synthetic */ PhoneNumberView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumberView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewCustomEditTextMyBillsBinding inflateViewBinding() {
        ViewCustomEditTextMyBillsBinding authRequestContext = ViewCustomEditTextMyBillsBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void setPhoneNumber(PhoneNumberValidation phoneNumber) {
        Intrinsics.checkNotNullParameter(phoneNumber, "");
        getBinding().MyBillsEntityDataFactory.setText(phoneNumber.BuiltInFictitiousFunctionClassFactory);
    }

    public final Job setOnChangeListener(CoroutineScope lifecycleScope, final Function2<? super String, ? super String, Unit> r7) {
        Intrinsics.checkNotNullParameter(lifecycleScope, "");
        Intrinsics.checkNotNullParameter(r7, "");
        final ViewCustomEditTextMyBillsBinding binding = getBinding();
        MDUtil mDUtil = MDUtil.INSTANCE;
        EditText editText = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(editText, "");
        mDUtil.textChanged(editText, new Function1<CharSequence, Unit>() { // from class: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                invoke2(charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence charSequence) {
                Intrinsics.checkNotNullParameter(charSequence, "");
                if (charSequence.length() == 0) {
                    AppCompatImageView appCompatImageView = ViewCustomEditTextMyBillsBinding.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    appCompatImageView.setVisibility(8);
                    ImageView imageView = ViewCustomEditTextMyBillsBinding.this.PlaceComponentResult;
                    Intrinsics.checkNotNullExpressionValue(imageView, "");
                    imageView.setVisibility(8);
                    PhoneNumberView.setErrorMessage$default(this, false, null, 2, null);
                    r7.invoke("", "");
                }
            }
        });
        FlowViewUtil flowViewUtil = FlowViewUtil.INSTANCE;
        EditText editText2 = binding.MyBillsEntityDataFactory;
        Intrinsics.checkNotNullExpressionValue(editText2, "");
        final Flow filterNotNull = FlowKt.filterNotNull(FlowViewUtil.PlaceComponentResult(editText2));
        final Flow debounce = FlowKt.debounce(new Flow<CharSequence>() { // from class: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$filter$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super CharSequence> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$filter$1$2  reason: invalid class name */
            /* loaded from: classes9.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$filter$1$2", f = "PhoneNumberView.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$filter$1$2$1  reason: invalid class name */
                /* loaded from: classes9.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$PlaceComponentResult = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda2$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$filter$1$2$1 r0 = (id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda2$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$filter$1$2$1 r0 = new id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$filter$1$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L52
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        r2 = r6
                        java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                        int r2 = r2.length()
                        r4 = 4
                        if (r2 < r4) goto L46
                        r2 = 1
                        goto L47
                    L46:
                        r2 = 0
                    L47:
                        if (r2 == 0) goto L52
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L52
                        return r1
                    L52:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda2$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, 500L);
        return FlowKt.launchIn(FlowKt.onEach(new Flow<PhoneNumberValidation>() { // from class: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super PhoneNumberValidation> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes9.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $getAuthRequestContext;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$map$1$2", f = "PhoneNumberView.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes9.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$getAuthRequestContext = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda2$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$map$1$2$1 r0 = (id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda2$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$map$1$2$1 r0 = new id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda-2$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L4f
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$getAuthRequestContext
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        id.dana.mybills.utils.PhoneNumberUtils r2 = id.dana.mybills.utils.PhoneNumberUtils.INSTANCE
                        java.lang.String r5 = r5.toString()
                        id.dana.mybills.utils.PhoneNumberValidation r5 = id.dana.mybills.utils.PhoneNumberUtils.PlaceComponentResult(r5)
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.ui.customview.PhoneNumberView$setOnChangeListener$lambda2$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        }, new PhoneNumberView$setOnChangeListener$1$4(binding, this, r7, null)), lifecycleScope);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        ViewCustomEditTextMyBillsBinding binding = getBinding();
        binding.NetworkUserEntityData$$ExternalSyntheticLambda0.setText(binding.lookAheadTest.getContext().getString(R.string.my_bills_label_mobile_number));
        EditText editText = binding.MyBillsEntityDataFactory;
        editText.setHint(binding.lookAheadTest.getContext().getString(R.string.my_bills_phone_number_hint));
        editText.setInputType(2);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: id.dana.mybills.ui.customview.PhoneNumberView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PhoneNumberView.m2684$r8$lambda$gl9OvWaftCUpBGw4umSD68I1rw(PhoneNumberView.this, view, z);
            }
        });
        binding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.ui.customview.PhoneNumberView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneNumberView.m2683$r8$lambda$4k_5JblZzB9Ps3lwYSUVylEZB8(PhoneNumberView.this, view);
            }
        });
    }

    public static /* synthetic */ void setErrorMessage$default(PhoneNumberView phoneNumberView, boolean z, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        phoneNumberView.setErrorMessage(z, str);
    }

    public final void setErrorMessage(boolean r3, String msg) {
        TextView textView = getBinding().getErrorConfigVersion;
        Intrinsics.checkNotNullExpressionValue(textView, "");
        textView.setVisibility(r3 ? 0 : 8);
        getBinding().getErrorConfigVersion.setText(msg);
        if (r3) {
            getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_red_border_8dp);
        } else if (getBinding().MyBillsEntityDataFactory.hasFocus()) {
            getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_yellow_border_8dp);
        } else {
            getBinding().getAuthRequestContext.setBackgroundResource(R.drawable.bg_white_rounded_grey_border_8dp);
        }
    }

    public final void setDisabled() {
        getBinding().MyBillsEntityDataFactory.setEnabled(false);
    }

    public final CharSequence getPhoneNumber() {
        CharSequence text = getBinding().MyBillsEntityDataFactory.getText();
        if (text == null) {
            text = "";
        }
        return text;
    }

    /* renamed from: $r8$lambda$4-k_5JblZzB9Ps3lwYSUVylEZB8 */
    public static /* synthetic */ void m2683$r8$lambda$4k_5JblZzB9Ps3lwYSUVylEZB8(PhoneNumberView phoneNumberView, View view) {
        Intrinsics.checkNotNullParameter(phoneNumberView, "");
        phoneNumberView.getBinding().MyBillsEntityDataFactory.setText("");
    }

    /* renamed from: $r8$lambda$gl9OvWaftCUpBGw4u-mSD68I1rw */
    public static /* synthetic */ void m2684$r8$lambda$gl9OvWaftCUpBGw4umSD68I1rw(PhoneNumberView phoneNumberView, View view, boolean z) {
        int i;
        Intrinsics.checkNotNullParameter(phoneNumberView, "");
        if (!z) {
            KeyboardHelper.getAuthRequestContext(view);
        }
        ConstraintLayout constraintLayout = phoneNumberView.getBinding().getAuthRequestContext;
        if (z) {
            i = R.drawable.bg_white_rounded_yellow_border_8dp;
        } else {
            i = R.drawable.bg_white_rounded_grey_border_8dp;
        }
        constraintLayout.setBackgroundResource(i);
    }
}
