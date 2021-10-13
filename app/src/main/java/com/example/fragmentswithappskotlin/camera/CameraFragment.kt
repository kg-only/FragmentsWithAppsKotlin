package com.example.fragmentswithappskotlin.camera

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.fragmentswithappskotlin.databinding.FragmentCameraBinding
import com.example.fragmentswithappskotlin.databinding.FragmentWeatherBinding

private const val REQUEST_CODE_CAMERA = 100
private const val REQUEST_CODE_CAPTURE = 1
lateinit var binding: FragmentCameraBinding

@SuppressLint("StaticFieldLeak")
private var cameraImageView: ImageView? = null

class CameraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCameraBinding.inflate(layoutInflater)

        binding.btnCamera.setOnClickListener {
            cameraPermission()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CODE_CAPTURE) {
                if (data != null && data.extras != null) {
                    val bitmap = data.extras!!.get("data")
                    cameraImageView!!.setImageBitmap(bitmap as Bitmap?)
                }
            }
        }
    }

    private fun cameraPermission() {
        val permission = Manifest.permission.CAMERA
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                permission
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            showCamera()
        } else {
            requestCameraPermission()
        }
    }

    private fun showCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, REQUEST_CODE_CAPTURE)
    }

    private fun requestCameraPermission() {
        val permissions = arrayOf(Manifest.permission.CAMERA)
        ActivityCompat.requestPermissions(requireActivity(), permissions, REQUEST_CODE_CAMERA)
    }
}


