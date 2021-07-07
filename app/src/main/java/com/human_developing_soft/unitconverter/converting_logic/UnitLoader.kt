package com.human_developing_soft.unitconverter.converting_logic

import com.human_developing_soft.unitconverter.units_storage.BaseUnit

interface UnitLoader {
    fun units(): List<BaseUnit>
}