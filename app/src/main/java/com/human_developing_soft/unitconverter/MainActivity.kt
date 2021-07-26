package com.human_developing_soft.unitconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.human_developing_soft.unitconverter.databinding.ActivityMainBinding
import com.human_developing_soft.unitconverter.domain.FieldsCommunicator
import com.human_developing_soft.unitconverter.domain.Subject
import com.human_developing_soft.unitconverter.domain.UnitConvertingVM
import com.human_developing_soft.unitconverter.domain.UnitConvertingVMFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mModel: UnitConvertingVM
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mModel = ViewModelProvider(
            this,
            UnitConvertingVMFactory(
                FieldsCommunicator.Base(
                    mBinding.unitInputFirst,
                    mBinding.unitInputSecond,
                    Subject.Base()
                )
            )
        ).get(UnitConvertingVM::class.java)
    }
}