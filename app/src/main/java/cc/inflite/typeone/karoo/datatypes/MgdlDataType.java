package cc.inflite.typeone.karoo.datatypes;

import androidx.annotation.NonNull;

import cc.inflite.typeone.karoo.formatters.MgdlFormatter;
import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.SdkDataType;
import io.hammerhead.sdk.v0.datatype.formatter.SdkFormatter;
import io.hammerhead.sdk.v0.datatype.transformer.BuiltInTransformer;
import io.hammerhead.sdk.v0.datatype.transformer.SdkTransformer;
import io.hammerhead.sdk.v0.datatype.view.BuiltInView;
import io.hammerhead.sdk.v0.datatype.view.SdkView;

public class MgdlDataType extends SdkDataType {

    private static final String ID = "IFTO::text-mgdl";

    public MgdlDataType(@NonNull SdkContext context) {
        super(context);
    }

    @NonNull
    @Override
    public String getDescription() {
        return "Display mg/dL";
    }

    @NonNull
    @Override
    public String getDisplayName() {
        return "mg/dL";
    }

    @NonNull
    @Override
    public String getTypeId() {
        return ID;
    }

    @NonNull
    @Override
    public SdkFormatter newFormatter() {
        return new MgdlFormatter(getContext());
    }

    @NonNull
    @Override
    public SdkTransformer newTransformer() {
        return new BuiltInTransformer.Identity(getContext());
    }

    @NonNull
    @Override
    public SdkView newView() {
        return new BuiltInView.Numeric(getContext());
    }
}
