package you.thiago.signaturepad.views

interface SignedListener {
    fun onStartSigning()
    fun onSigned()
    fun onClear()
}
