package com.human_developing_soft.unitconverter.units_storage.data_loading

import androidx.annotation.RawRes
import java.io.InputStream

interface ContextLoader {
    fun rawResources(@RawRes resourceID: Int) : InputStream
}