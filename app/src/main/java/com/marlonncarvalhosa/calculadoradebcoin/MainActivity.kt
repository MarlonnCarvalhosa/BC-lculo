package com.marlonncarvalhosa.calculadoradebcoin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.marlonncarvalhosa.calculadoradebcoin.databinding.ActivityMainBinding
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    private val bauMarromValor: Float = 0.01425F
    private var bauMarromQuantidade: Int = 0
    private val bauRoxoValor: Float = 0.0325F
    private var bauRoxoQuantidade: Int = 0
    private val bauAmareloValor: Float = 0.1625F
    private var bauAmareloQuantidade: Int = 0
    private val bauAzulValor: Float = 0.325F
    private var bauAzulQuantidade: Int = 0
    private var valorTotal: Float = 0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(root) }

        onClick()

        calcularBauMarron()
        calcularBauRoxo()
        calcularBauAmarelo()
        calcularBauAzul()

        MobileAds.initialize(this) { }
    }

    private fun onClick() {
        binding?.btnCalcular?.setOnClickListener {
            valorTotal = calcularBauMarron() + calcularBauRoxo() + calcularBauAmarelo() + calcularBauAzul()
            binding?.textResultBcoin?.text = "$valorTotal BCoin"
            binding?.text?.visibility = View.VISIBLE
        }
    }

    private fun calcularBauMarron(): Float {
        binding?.addBauMarrom?.setOnClickListener {
            bauMarromQuantidade += 1
            binding?.textQuantidadeBauMarrom?.text = bauMarromQuantidade.toString()
        }
        binding?.removeBauMarrom?.setOnClickListener {
            bauMarromQuantidade -= 1
            binding?.textQuantidadeBauMarrom?.text = bauMarromQuantidade.toString()
        }
        return bauMarromQuantidade * bauMarromValor
    }

    private fun calcularBauRoxo(): Float {
        binding?.addBauRoxo?.setOnClickListener {
            bauRoxoQuantidade += 1
            binding?.textQuantidadeBauRoxo?.text = bauRoxoQuantidade.toString()
        }
        binding?.removeBauRoxo?.setOnClickListener {
            bauRoxoQuantidade -= 1
            binding?.textQuantidadeBauRoxo?.text = bauRoxoQuantidade.toString()
        }
        return bauRoxoQuantidade * bauRoxoValor
    }

    private fun calcularBauAmarelo(): Float {
        binding?.addBauAmarelo?.setOnClickListener {
            bauAmareloQuantidade += 1
            binding?.textQuantidadeBauAmarelo?.text = bauAmareloQuantidade.toString()
        }
        binding?.removeBauAmarelo?.setOnClickListener {
            bauAmareloQuantidade -= 1
            binding?.textQuantidadeBauAmarelo?.text = bauAmareloQuantidade.toString()
        }
        return bauAmareloQuantidade * bauAmareloValor
    }

    private fun calcularBauAzul(): Float {
        binding?.addBauAzul?.setOnClickListener {
            bauAzulQuantidade += 1
            binding?.textQuantidadeBauAzul?.text = bauAzulQuantidade.toString()
        }
        binding?.removeBauAzul?.setOnClickListener {
            bauAzulQuantidade -= 1
            binding?.textQuantidadeBauAzul?.text = bauAzulQuantidade.toString()
        }
        return bauAzulQuantidade * bauAzulValor
    }
}