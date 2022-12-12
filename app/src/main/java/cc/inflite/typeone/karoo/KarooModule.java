package cc.inflite.typeone.karoo;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

import cc.inflite.typeone.BuildConfig;
import cc.inflite.typeone.karoo.datatypes.DataTimestampDataType;
import cc.inflite.typeone.karoo.datatypes.DirectionDataType;
import cc.inflite.typeone.karoo.datatypes.DirectionHistoryIconDataType;
import cc.inflite.typeone.karoo.datatypes.DirectionIconDataType;
import cc.inflite.typeone.karoo.datatypes.MgdlDataType;
import cc.inflite.typeone.karoo.datatypes.MmollDataType;
import io.hammerhead.sdk.v0.Module;
import io.hammerhead.sdk.v0.ModuleFactoryI;
import io.hammerhead.sdk.v0.SdkContext;
import io.hammerhead.sdk.v0.datatype.SdkDataType;

public class KarooModule extends Module {

    public static ModuleFactoryI factory = KarooModule::new;

    public KarooModule(@NonNull SdkContext sdkContext) {
        super(sdkContext);
    }

    @NonNull
    @Override
    public String getName() {
        return "INFLITE TypeOne";
    }

    @NonNull
    @Override
    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @NonNull
    @Override
    protected List<SdkDataType> provideDataTypes() {
        return Arrays.asList(
                new MgdlDataType(getContext()),
                new MmollDataType(getContext()),
                new DataTimestampDataType(getContext()),
                new DirectionDataType(getContext()),
                new DirectionIconDataType(getContext()),
                new DirectionHistoryIconDataType(getContext()));
    }
}