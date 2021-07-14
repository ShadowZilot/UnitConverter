package com.human_developing_soft.unitconverter.units_storage.data_loading

import java.lang.StringBuilder
import java.util.*

interface UnitDataJSON {
    fun jsonString(): String

    class Base(
        private val mFileID: Int,
        private val mContextOpener: ContextLoader
    ): UnitDataJSON {
        override fun jsonString(): String {
            val scanner =  Scanner(
                mContextOpener.rawResources(mFileID)
            )
            val jsonStringBuilder = StringBuilder()

            while (scanner.hasNextLine()) {
                jsonStringBuilder.append(scanner.nextLine())
            }

            return jsonStringBuilder.toString()
        }
    }
}