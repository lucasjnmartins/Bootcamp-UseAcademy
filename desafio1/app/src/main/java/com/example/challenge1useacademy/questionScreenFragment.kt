package com.example.challenge1useacademy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.challenge1useacademy.databinding.FragmentQuestionScreenBinding


class questionScreenFragment : Fragment() {

    private lateinit var binding: FragmentQuestionScreenBinding
    private var buttonBack: ImageView? = null
    private var opSelected: String? = null
    private var flag: Boolean = true
    private var countQuestions: Int = 0
    private val questionManager: Question = Question()
    private var question: DataQuestion = questionManager.sortQuestion()
    val options = navOptions {
        anim {
            enter = R.anim.slide_in_right
            exit = R.anim.slide_out_left
            popEnter = R.anim.slide_in_left
            popExit = R.anim.slide_out_right
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickOption()
        buttonActions()
        buttonBack()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuestionScreenBinding.inflate(layoutInflater)
        buttonBack = activity?.findViewById<ImageView>(R.id.b_back)
        buttonBack?.isVisible = true
        buttonBack?.isClickable = true
        showQuestion()
        return binding.root
    }


    fun clickOption() {
        binding.apply {
            if (flag) {
                llOption1.setOnClickListener {
                    llOption1.setBackgroundResource(R.drawable.question_checked)
                    llOption2.setBackgroundResource(R.drawable.question_shape)
                    llOption3.setBackgroundResource(R.drawable.question_shape)
                    llOption4.setBackgroundResource(R.drawable.question_shape)
                    ckOp1.setButtonDrawable(R.drawable.ic_check_button_checked)
                    ckOp2.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp3.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp4.setButtonDrawable(R.drawable.ic_check_button)
                    opSelected = tvOp1.text.toString()
                    button.setBackgroundResource(R.drawable.rounded_button)
                }
                llOption2.setOnClickListener {
                    llOption1.setBackgroundResource(R.drawable.question_shape)
                    llOption2.setBackgroundResource(R.drawable.question_checked)
                    llOption3.setBackgroundResource(R.drawable.question_shape)
                    llOption4.setBackgroundResource(R.drawable.question_shape)
                    ckOp2.setButtonDrawable(R.drawable.ic_check_button_checked)
                    ckOp1.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp3.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp4.setButtonDrawable(R.drawable.ic_check_button)
                    opSelected = tvOp2.text.toString()
                    button.setBackgroundResource(R.drawable.rounded_button)
                }
                llOption3.setOnClickListener {
                    llOption1.setBackgroundResource(R.drawable.question_shape)
                    llOption2.setBackgroundResource(R.drawable.question_shape)
                    llOption3.setBackgroundResource(R.drawable.question_checked)
                    llOption4.setBackgroundResource(R.drawable.question_shape)
                    ckOp3.setButtonDrawable(R.drawable.ic_check_button_checked)
                    ckOp2.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp1.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp4.setButtonDrawable(R.drawable.ic_check_button)
                    opSelected = tvOp3.text.toString()
                    button.setBackgroundResource(R.drawable.rounded_button)
                }
                llOption4.setOnClickListener {
                    llOption1.setBackgroundResource(R.drawable.question_shape)
                    llOption2.setBackgroundResource(R.drawable.question_shape)
                    llOption3.setBackgroundResource(R.drawable.question_shape)
                    llOption4.setBackgroundResource(R.drawable.question_checked)
                    ckOp4.setButtonDrawable(R.drawable.ic_check_button_checked)
                    ckOp2.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp1.setButtonDrawable(R.drawable.ic_check_button)
                    ckOp3.setButtonDrawable(R.drawable.ic_check_button)
                    opSelected = tvOp4.text.toString()
                    button.setBackgroundResource(R.drawable.rounded_button)
                }
            } else {
                llOption1.isClickable = false
                llOption2.isClickable = false
                llOption3.isClickable = false
                llOption4.isClickable = false
            }
        }
    }

    fun buttonActions() {
        binding.apply {
            button.setOnClickListener {
                if (flag == true) {
                    if (opSelected != null) {
                        if (opSelected == question.answer) {
                            questionManager.questionRight()
                        } else {
                            questionManager.questionWrong()
                            findOptionLinear(opSelected.toString()).setBackgroundResource(R.drawable.question_wrong)
                            findOptionCheckBox(opSelected.toString()).setButtonDrawable(R.drawable.ic_check_button_wrong)
                        }
                        findOptionLinear(question.answer).setBackgroundResource(R.drawable.question_right)
                        findOptionCheckBox(question.answer).setButtonDrawable(R.drawable.ic_check_button_right)
                        buttonBack?.isClickable = false
                        button.setText("Próxima pergunta")
                        llOption1.isClickable = false
                        llOption2.isClickable = false
                        llOption3.isClickable = false
                        llOption4.isClickable = false
                        flag = false
                        countQuestions++
                    } else {
                        button.setBackgroundResource(R.drawable.rounded_button_gray)
                    }
                } else {
                    if (countQuestions == 10) {
                        countQuestions = 0
                        questionManager.removeAllQuestions()

                        val action = questionScreenFragmentDirections.actionQuestionScreenFragmentToFinalScreenFragment2(questionManager.getScore())
                        findNavController().navigate(action)
                    } else {
                        question = questionManager.sortQuestion()
                        showQuestion()
                        changeQuestion()
                    }
                }
            }
        }
    }

    fun showQuestion() {
        var start: Int = (0 until 4).random()

        binding.apply {
            tvQuestion.setText(question.question)

            for (i in 0 until 4) {
                if (start == 4) {
                    start = 0
                }
                when (i) {
                    0 -> tvOp1.setText(question.options[start])
                    1 -> tvOp2.setText(question.options[start])
                    2 -> tvOp3.setText(question.options[start])
                    3 -> tvOp4.setText(question.options[start])
                }
                start++
            }
        }
    }

    private fun findOptionLinear(option: String): LinearLayout {
        binding.apply {
            if (option == tvOp1.text) {
                return llOption1
            } else if (option == tvOp2.text) {
                return llOption2
            } else if (option == tvOp3.text) {
                return llOption3
            } else {
                return llOption4
            }
        }
    }

    private fun findOptionCheckBox(option: String): CheckBox {
        binding.apply {
            if (option == tvOp1.text) {
                return ckOp1
            } else if (option == tvOp2.text) {
                return ckOp2
            } else if (option == tvOp3.text) {
                return ckOp3
            } else {
                return ckOp4
            }
        }
    }

    fun changeQuestion() {
        flag = true
        binding.apply {
            llOption1.setBackgroundResource(R.drawable.question_shape)
            llOption2.setBackgroundResource(R.drawable.question_shape)
            llOption3.setBackgroundResource(R.drawable.question_shape)
            llOption4.setBackgroundResource(R.drawable.question_shape)
            ckOp1.setButtonDrawable(R.drawable.ic_check_button)
            ckOp2.setButtonDrawable(R.drawable.ic_check_button)
            ckOp3.setButtonDrawable(R.drawable.ic_check_button)
            ckOp4.setButtonDrawable(R.drawable.ic_check_button)
            button.setText("Responder")
            button.setBackgroundResource(R.drawable.rounded_button_gray)
            buttonBack?.isClickable = true
            opSelected = null
            llOption1.isClickable = true
            llOption2.isClickable = true
            llOption3.isClickable = true
            llOption4.isClickable = true
        }
    }

    fun buttonBack() {
        buttonBack?.setOnClickListener {
            if (countQuestions == 0) {
                questionManager.removeAllQuestions()
                findNavController().navigate(R.id.startScreenFragment)
            } else {
                countQuestions--
                question = questionManager.getLastQuestion()
                showQuestion()
                changeQuestion()
            }
        }
    }

}