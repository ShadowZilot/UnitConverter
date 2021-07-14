package com.human_developing_soft.unitconverter.units_storage.data_loading

import android.content.Context
import androidx.annotation.RawRes
import java.io.InputStream

class ContextLoading(
    private val mContext: Context
) : ContextLoader {

    override fun rawResources(@RawRes resourceID: Int): InputStream {
        return mContext
            .resources
            .openRawResource(resourceID)
    }
}