package com.android.uniassist.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.uniassist.R
import kotlinx.android.synthetic.main.file_upload.view.*
import kotlinx.android.synthetic.main.fragment_document.*

class DocumentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_document, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        doc2.docTitle.setText("Letter of Recommendation")
        doc3.docTitle.setText("High School/Diploma Transcripts")
        doc4.docTitle.setText("Personal Statement")
        doc5.docTitle.setText("CV")
        doc6.docTitle.setText("English Proficency Test")
        doc7.docTitle.setText("UG Degree Certificate")

    }

}