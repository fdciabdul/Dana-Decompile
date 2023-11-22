package id.dana.core.ui.model;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\t\b\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\u000b\f"}, d2 = {"Lid/dana/core/ui/model/UiTextModel;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "asString", "(Landroid/content/Context;)Ljava/lang/String;", "<init>", "()V", "DynamicString", "StringResource", "Lid/dana/core/ui/model/UiTextModel$DynamicString;", "Lid/dana/core/ui/model/UiTextModel$StringResource;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UiTextModel {
    public /* synthetic */ UiTextModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/model/UiTextModel$DynamicString;", "Lid/dana/core/ui/model/UiTextModel;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DynamicString extends UiTextModel {
        private final String text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DynamicString(String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "");
            this.text = str;
        }

        @JvmName(name = "getText")
        public final String getText() {
            return this.text;
        }
    }

    private UiTextModel() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eR!\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u00028\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/core/ui/model/UiTextModel$StringResource;", "Lid/dana/core/ui/model/UiTextModel;", "", "", "args", "[Ljava/lang/Object;", "getArgs", "()[Ljava/lang/Object;", "", "text", "I", "getText", "()I", "<init>", "(I[Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class StringResource extends UiTextModel {
        private final Object[] args;
        private final int text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StringResource(int i, Object... objArr) {
            super(null);
            Intrinsics.checkNotNullParameter(objArr, "");
            this.text = i;
            this.args = objArr;
        }

        public /* synthetic */ StringResource(int i, Object[] objArr, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i2 & 2) != 0 ? new Object[0] : objArr);
        }

        @JvmName(name = "getArgs")
        public final Object[] getArgs() {
            return this.args;
        }

        @JvmName(name = "getText")
        public final int getText() {
            return this.text;
        }
    }

    public static /* synthetic */ String asString$default(UiTextModel uiTextModel, Context context, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                context = null;
            }
            return uiTextModel.asString(context);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: asString");
    }

    public final String asString(Context context) {
        String str;
        if (this instanceof DynamicString) {
            return ((DynamicString) this).getText();
        }
        if (this instanceof StringResource) {
            if (context != null) {
                StringResource stringResource = (StringResource) this;
                int text = stringResource.getText();
                Object[] args = stringResource.getArgs();
                str = context.getString(text, Arrays.copyOf(args, args.length));
            } else {
                str = null;
            }
            return str == null ? "" : str;
        }
        throw new NoWhenBranchMatchedException();
    }
}
