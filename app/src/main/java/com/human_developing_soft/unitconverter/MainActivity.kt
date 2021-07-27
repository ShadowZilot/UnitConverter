package com.human_developing_soft.unitconverterimport android.os.Bundleimport android.view.Viewimport android.widget.AdapterViewimport android.widget.ArrayAdapterimport androidx.appcompat.app.AppCompatActivityimport androidx.lifecycle.ViewModelProviderimport com.human_developing_soft.unitconverter.databinding.ActivityMainBindingimport com.human_developing_soft.unitconverter.domain.*import com.human_developing_soft.unitconverter.units_storage.data_loading.ContextLoadingimport com.human_developing_soft.unitconverter.units_storage.data_loading.UnitDataJSON// TODO refactor this fileclass MainActivity : AppCompatActivity() {    private lateinit var mModel: UnitConvertingVM    private lateinit var mBinding: ActivityMainBinding    private lateinit var mCommunicator: FieldsCommunicator    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        mBinding = ActivityMainBinding.inflate(layoutInflater)        setContentView(mBinding.root)        mModel = ViewModelProvider(            this,            UnitConvertingVMFactory(                UnitDataJSON.Base(                    R.raw.volume_units,                    ContextLoading(baseContext)                ),                UnitIndexPair.Base(0, 0)            )        ).get(UnitConvertingVM::class.java)        mCommunicator = FieldsCommunicator.Base(            mBinding.unitInputFirst,            mBinding.unitInputSecond,            Subject.Base()        )        mCommunicator.addObserver(mModel)    }    override fun onResume() {        super.onResume()        mCommunicator.resumeObserving()        mBinding.unitFirstSelector.onItemSelectedListener =            object : AdapterView.OnItemSelectedListener {                override fun onItemSelected(                    parent: AdapterView<*>?,                    view: View?,                    position: Int,                    id: Long                ) {                    mModel.changeConvertingFormula(                        UnitIndexPair.Base(                            position,                            mBinding.unitSecondSelector.selectedItemPosition                        )                    )                }                override fun onNothingSelected(parent: AdapterView<*>?) {}            }        mBinding.unitFirstSelector.adapter = ArrayAdapter(            this,            android.R.layout.simple_spinner_item,            mModel.unitNames()        )        (mBinding.unitFirstSelector.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)        mBinding.unitSecondSelector.onItemSelectedListener =            object : AdapterView.OnItemSelectedListener {                override fun onItemSelected(                    parent: AdapterView<*>?,                    view: View?,                    position: Int,                    id: Long                ) {                    mModel.changeConvertingFormula(                        UnitIndexPair.Base(                            mBinding.unitFirstSelector.selectedItemPosition,                            position                        )                    )                }                override fun onNothingSelected(parent: AdapterView<*>?) {}            }        mBinding.unitSecondSelector.adapter = ArrayAdapter(            this,            android.R.layout.simple_spinner_item,            mModel.unitNames()        )        (mBinding.unitSecondSelector.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)    }    override fun onPause() {        super.onPause()        mCommunicator.pauseObserving()    }}